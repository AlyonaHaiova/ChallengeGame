package com.example.gameapi.controller;

import com.example.gameapi.dto.CardTypeDto;
import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.GameCardTypeDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Endpoint.CARD_TYPE)
@RequiredArgsConstructor
public class CardTypeController {
  private final CardTypeService cardTypeService;

  @GetMapping("/{gameId}")
  public List<GameCardTypeDto> getCardTypes(
      @PathVariable("gameId") long gameId
  ) {
    return cardTypeService.getCardTypes(gameId);
  }
  @PostMapping
  public ResponseEntity<IdDto> create(
      @Valid @RequestBody CreateCardTypeDto createCardTypeDto
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(cardTypeService.create(createCardTypeDto));
  }
}
