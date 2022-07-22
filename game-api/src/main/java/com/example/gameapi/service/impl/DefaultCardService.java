package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.entity.projection.CardProjection;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.repository.CardRoleRepository;
import com.example.gameapi.repository.CardTypeRepository;
import com.example.gameapi.service.CardService;
import com.example.gameapi.service.MoveService;
import com.example.gameapi.utils.CollectionUtils;
import com.example.gameapi.validator.CardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultCardService implements CardService {
  private static final Random RANDOM = new Random();

  private final CardMapper cardMapper;
  private final CardRepository cardRepository;
  private final CardTypeRepository cardTypeRepository;
  private final CardRoleRepository cardRoleRepository;
  private final MoveService moveService;
  private final CardValidator cardValidator;

  @Transactional
  @Override
  public IdDto create(CardDto cardDto) {
    cardValidator.ensureIfValid(cardDto);
    CardEntity entity = cardMapper.toEntity(cardDto);
    cardRepository.save(entity);
    cardRoleRepository.saveCardRoles(entity.getId(), cardDto.getRoleIds());
    return new IdDto(entity.getId());
  }

  @Transactional
  @Override
  public void update(Long id, CardDto cardDto) {
    Long gameId = cardTypeRepository.getGameIdByCardId(id);
    cardValidator.ensureIfValid(gameId, cardDto);
    Set<Long> roleIds = cardRoleRepository.getRolesIdsByCardId(id);
    Set<Long> newRoleIds = new HashSet<>(cardDto.getRoleIds());
    List<Long> roleIdsToInsert = getChangedIdsList(roleIds, newRoleIds);
    List<Long> roleIdsToDelete = getChangedIdsList(newRoleIds, roleIds);
    CardEntity entity = cardMapper.toEntity(cardDto);
    cardRepository.update(id, entity);
    if (roleIdsToInsert.size() > 0) {
      cardRoleRepository.saveCardRoles(id, roleIdsToInsert);
    }
    if (roleIdsToDelete.size() > 0) {
      cardRoleRepository.deleteCardRoles(id, roleIdsToDelete);
    }
  }

  @Override
  public void delete(Long id) {
    cardRepository.deleteById(id);
  }

  @Override
  public List<FullCardDataDto> getAllCards(Long gameId) {
    return cardRepository.getAllCardsByGameId(gameId).stream()
        .map(cardMapper::toCardDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public RandomCardDto getRandomPlayableCard(Long gameId) {
    Long nextRoleId = moveService.getNextRoleId(gameId);
    CardProjection cardProjection = cardRepository.getRandomCard(gameId, true, nextRoleId);
    moveService.updateLastRoleId(gameId, nextRoleId);
    return mapCardProjectionToRandomCardDto(cardProjection);
  }

  @Override
  @Transactional
  public RandomCardDto getRandomRefreshedPlayableCard(Long gameId) {
    return getRandomCardCardForLastRole(gameId, true);
  }

  @Override
  @Transactional
  public RandomCardDto getRandomPenaltyCard(Long gameId) {
    return getRandomCardCardForLastRole(gameId, false);
  }

  @Transactional
  protected RandomCardDto getRandomCardCardForLastRole(Long gameId, boolean isPlayable) {
    Long lastRoleId = moveService.getLastRoleId(gameId);
    CardProjection cardProjection = cardRepository.getRandomCard(gameId, isPlayable, lastRoleId);
    return mapCardProjectionToRandomCardDto(cardProjection);
  }

  private RandomCardDto mapCardProjectionToRandomCardDto(CardProjection cardProjection) {
    if (cardProjection == null) {
      return null;
    }
    RandomCardDto card = cardMapper.toRandomCardDto(cardProjection);
    card.setAmount(generateAmount(cardProjection.getRangeBegin(), cardProjection.getRangeEnd()));
    return card;
  }

  private int generateAmount(int rangeBegin, int rangeEnd) {
    return RANDOM.nextInt(rangeEnd - rangeBegin + 1) + rangeBegin;
  }

  private List<Long> getChangedIdsList(Set<Long> ids, Set<Long> newIds) {
    return new ArrayList<>(CollectionUtils.getDifference(newIds, ids));
  }
}
