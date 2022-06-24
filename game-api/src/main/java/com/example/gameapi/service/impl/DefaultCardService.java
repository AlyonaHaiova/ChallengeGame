package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.repository.CardRoleRepository;
import com.example.gameapi.repository.CardTypeRepository;
import com.example.gameapi.service.CardService;
import com.example.gameapi.utils.CollectionUtils;
import com.example.gameapi.validator.CardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DefaultCardService implements CardService {
  private final CardMapper cardMapper;
  private final CardRepository cardRepository;
  private final CardTypeRepository cardTypeRepository;
  private final CardRoleRepository cardRoleRepository;
  private final CardValidator cardValidator;

  @Transactional
  @Override
  public IdDto create(CardDto cardDto) {
    cardValidator.ensureIfValid(cardDto);
    CardEntity entity = cardMapper.toEntity(cardDto);
    cardRepository.save(entity);
    cardRepository.saveCardRoles(entity.getId(), cardDto.getRoleIds());
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
      cardRepository.saveCardRoles(id, roleIdsToInsert);
    }
    if (roleIdsToDelete.size() > 0) {
      cardRoleRepository.deleteCardRoles(id, roleIdsToDelete);
    }
  }

  @Override
  public void delete(Long id) {
    cardRepository.deleteById(id);
  }

  private List<Long> getChangedIdsList(Set<Long> ids, Set<Long> newIds) {
    return new ArrayList<>(CollectionUtils.getDifference(newIds, ids));
  }
}
