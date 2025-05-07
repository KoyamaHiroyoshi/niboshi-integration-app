package jp.co.nile.interfaces.leagues;

import java.util.Map;
import org.openapitools.model.Game;
import org.openapitools.model.League;
import org.openapitools.model.Player;
import org.openapitools.model.PlayerResult;
import org.openapitools.model.Rule;
import org.openapitools.model.Uma;
import org.springframework.stereotype.Component;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.shared.NileDateUtils;

@Component
public class InterfaceLeaguesConverter {
  public Game toInterfaceGame(jp.co.nile.domains.models.games.Game domainGame) {
    final Map<PlayerId, Float> playerScores = domainGame.getCalculatedPlayerScore();

    return new Game()
        .id(domainGame.getId().getUuid())
        .rule(
            new Rule()
                .name(domainGame.getRule()
                    .getName()))
        .uma(new Uma()
            .name(domainGame.getUma().getName())
            .firstPlaceRate(domainGame.getUma()
                .getFirstPlaceRate())
            .secondPlaceRate(domainGame.getUma()
                .getSecondPlaceRate()))
        .playerResults(domainGame
            .getPlayerResults()
            .stream()
            .map(domainPlayerResult -> new PlayerResult()
                .player(
                    new Player()
                        .id(domainPlayerResult
                            .getPlayer()
                            .getId()
                            .toString())
                        .name(domainPlayerResult
                            .getPlayer()
                            .getName()
                            .toString()))
                .score(playerScores.get(
                    domainPlayerResult
                        .getPlayer()
                        .getId()))
                .result(domainPlayerResult
                    .getResult()))
            .toList())
        .eventDate(NileDateUtils.toLocalDate(domainGame.getEvenDate()));
  }

  public League toInterfaceLeague(
      jp.co.nile.domains.models.leagues.League domainLeague) {
    return new League()
        .id(domainLeague.getId().toString())
        .name(domainLeague.getName().toString())
        .startAt(NileDateUtils.toLocalDate(domainLeague.getStartAt().toDate()))
        .endAt(domainLeague.getEndAt().isPresent()
            ? NileDateUtils.toLocalDate(domainLeague.getEndAt().get().toDate())
            : null);
  }
}
