package com.example.gameapi.controller;

import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoint.GAME)
@RequiredArgsConstructor
public class ActiveGameController {

  private final CardService cardService;

  @GetMapping("/{gameId}/cards/next")
  public RandomCardDto getNextPlayableCard(
      @PathVariable("gameId") long gameId
  ) {
    return cardService.getRandomPlayableCard(gameId);
  }

  @GetMapping("/{gameId}/cards/refresh")
  public RandomCardDto getRefreshedPlayableCard(
      @PathVariable("gameId") long gameId
  ) {
    return cardService.getRandomRefreshedPlayableCard(gameId);
  }

  @GetMapping("/{gameId}/cards/penalty")
  public RandomCardDto getPenaltyCard(
      @PathVariable("gameId") long gameId
  ) {
    return cardService.getRandomPenaltyCard(gameId);
  }

  @GetMapping("/{gameId}/cards")
  public List<FullCardDataDto> getAllCards(
      @PathVariable("gameId") long gameId
  ) {
    return cardService.getAllCards(gameId);
  }
}
