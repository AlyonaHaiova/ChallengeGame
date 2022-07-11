package com.example.gameapi.controller;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoint.CARD)
@RequiredArgsConstructor
public class CardController {
  private final CardService cardService;

  @PostMapping
  public ResponseEntity<IdDto> create(
      @Valid @RequestBody CardDto cardDto
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(cardService.create(cardDto));
  }

  @PutMapping("/{id}")
  public void update(
      @PathVariable("id") long id,
      @Valid @RequestBody CardDto cardDto
  ) {
    cardService.update(id, cardDto);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable("id") long id
  ) {
    cardService.delete(id);
  }
}
