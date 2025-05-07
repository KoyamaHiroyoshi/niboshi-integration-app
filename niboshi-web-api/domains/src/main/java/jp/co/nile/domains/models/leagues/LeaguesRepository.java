package jp.co.nile.domains.models.leagues;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import jp.co.nile.domains.models.games.CreatePlayerResultParams;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.games.RuleId;
import jp.co.nile.domains.models.games.UmaId;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;

public interface LeaguesRepository {
  public void createLeagues(List<CreateLeagueParams> createLeagueParams);

  public Optional<League> findLeague(LeagueId leagueId);

  public List<League> findAllLeagues();

  public void updateLeague(UpdateLeagueParams updateLeagueParams);

  public void deleteLeague(LeagueId leagueId);

  public void addPlayersToLeague(LeagueId leagueId, List<PlayerId> playerIds);

  public List<Player> findLeaguePlayers(LeagueId leagueId);

  public GameId createGame(RuleId ruleId, UmaId umaId, Date eventDate);

  public void createPlayerResults(GameId gameId, List<CreatePlayerResultParams> playerResults);

  public void createLeagueGame(LeagueId leagueId, GameId gameId, Date eventDate);

  public List<Game> getLeagueGames(LeagueId leagueId);

  public void deleteLeaguesGames(LeagueId leagueId);

  public void deleteLeaguesPlayers(LeagueId leagueId);

  public void deletePlayerResults(List<GameId> gameIds);

  public void deleteGames(List<GameId> gameIds);
}
