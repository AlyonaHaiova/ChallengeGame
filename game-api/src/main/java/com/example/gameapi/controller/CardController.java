package com.example.gameapi.controller;

import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.CARD)
@RequiredArgsConstructor
public class CardController {
  private final CardService cardService;

  @PostMapping
  public ResponseEntity<IdDto> create(
      @RequestBody CreateCardDto createCardDto
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(cardService.create(createCardDto));
  }
}