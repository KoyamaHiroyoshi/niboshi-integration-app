package jp.co.nile.applications.usecases.leagues.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.nile.applications.usecases.leagues.LeagueUsecases;
import jp.co.nile.domains.models.exceptions.UserInputErrorException;
import jp.co.nile.domains.models.games.CreateGameParams;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.leagues.CreateLeagueParams;
import jp.co.nile.domains.models.leagues.League;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.LeaguesRepository;
import jp.co.nile.domains.models.leagues.UpdateLeagueParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
class LeagueUsecasesImpl implements LeagueUsecases {
  private final LeaguesRepository leaguesRepository;

  @Override
  public void createLeagues(List<CreateLeagueParams> createLeaguesParams) {
    leaguesRepository.createLeagues(createLeaguesParams);
  }

  @Override
  public List<League> findAllLeagues() {
    return leaguesRepository.findAllLeagues();
  }

  @Override
  public Optional<League> findLeague(LeagueId leagueId) {
    return leaguesRepository.findLeague(leagueId);
  }

  @Override
  public void updateLeague(UpdateLeagueParams updateLeagueParams) {
    leaguesRepository.updateLeague(updateLeagueParams);
  }

  @Override
  public void deleteLeague(LeagueId deleteLeagueId) {
    List<GameId> leagueGames = leaguesRepository
        .getLeagueGames(deleteLeagueId)
        .stream()
        .map(Game::getId)
        .toList();

    // leagues_games削除
    leaguesRepository.deleteLeaguesGames(deleteLeagueId);
    // leagues_players削除
    leaguesRepository.deleteLeaguesPlayers(deleteLeagueId);
    // player_results削除
    leaguesRepository.deletePlayerResults(leagueGames);
    // games削除
    leaguesRepository.deleteGames(leagueGames);
    // leagues削除
    leaguesRepository.deleteLeague(deleteLeagueId);
  }

  @Override
  public void addPlayersToLeague(LeagueId leagueId, List<PlayerId> playerIds) {
    try {
      leaguesRepository.addPlayersToLeague(leagueId, playerIds);
    } catch (DataIntegrityViolationException e) {
      throw new UserInputErrorException("存在するリークID、プレイヤーIDを指定してください。", e);
    }
  }

  @Override
  public void createGame(CreateGameParams createGameParams) {
    GameId gameId = leaguesRepository.createGame(createGameParams.getRuleId(),
        createGameParams.getUmaId(), createGameParams.getEventDate());

    leaguesRepository.createPlayerResults(gameId, createGameParams.getPlayerResults());

    leaguesRepository.createLeagueGame(createGameParams.getLeagueId(), gameId,
        createGameParams.getEventDate());
  }

  @Override
  public List<Game> getLeagueGames(LeagueId leagueId) {
    return leaguesRepository.getLeagueGames(leagueId);
  }

  @Override
  public List<Player> findLeaguePlayers(LeagueId leagueId) {
    return leaguesRepository.findLeaguePlayers(leagueId);
  }
}
