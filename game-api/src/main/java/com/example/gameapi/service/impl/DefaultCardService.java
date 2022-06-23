package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.repository.RoleRepository;
import com.example.gameapi.service.CardService;
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
  private final RoleRepository roleRepository;
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

  @Override
  public void update(Long id, CardDto cardDto) {
    Set<Long> roleIds = roleRepository.getRolesIdsByCardId(id);
    Set<Long> newRoleIds = new HashSet<>(cardDto.getRoleIds());
    List<Long> roleIdsToInsert = getRoleIdsToInsert(roleIds, newRoleIds);
    List<Long> roleIdsToDelete = getRoleIdsToDelete(roleIds, newRoleIds);
    Long gameId = cardRepository.getGameIdByCardId(id);
    cardValidator.ensureIfValid(gameId, cardDto);
    CardEntity entity = cardMapper.toEntity(cardDto);
    cardRepository.update(id, entity);
    if (roleIdsToInsert.size() > 0) {
      cardRepository.saveCardRoles(id, roleIdsToInsert);
    }
    if (roleIdsToDelete.size() > 0) {
      cardRepository.deleteCardRoles(id, roleIdsToDelete);
    }
  }

  private List<Long> getRoleIdsToInsert(Set<Long> roleIds, Set<Long> newRoleIds) {
    Set<Long> ids = new HashSet<>(newRoleIds);
    ids.removeAll(roleIds);
    return new ArrayList<>(ids);
  }

  private List<Long> getRoleIdsToDelete(Set<Long> roleIds, Set<Long> newRoleIds) {
    Set<Long> ids = new HashSet<>(roleIds);
    ids.removeAll(newRoleIds);
    return new ArrayList<>(ids);
  }
}
