package jp.co.nile.infrastructures.repositories.leagues;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.players.PlayerId;

@Mapper
public interface LeaguesMapper {
    void createLeagues(List<LeagueEntity> newLeagues);

    List<LeagueEntity> selectAllLeagues();

    LeagueEntity selectLeague(LeagueId leagueId);

    void updateLeague(LeagueEntity leagueEntity);

    void addPlayersToLeague(LeagueId leagueId, List<PlayerId> playerIds);

    List<LeagueGameJoinEntity> selectLeaguePlayers(LeagueId leagueId);

    void createGame(GameEntity gameEntity);

    void createPlayerResults(List<PlayerResultEntity> playerResultEntities);

    void createLeagueGame(LeagueId leagueId, GameId gameId, Date eventDate);

    List<LeagueGameJoinEntity> selectLeagueGames(LeagueId leagueId, GameId gameId);

    void deleteLeagues(List<LeagueId> leagueIds);

    void deleteLeaguesGames(LeagueId leagueId);

    void deleteLeaguesPlayers(LeagueId leagueId);

    void deletePlayerResults(List<GameId> gameIds);

    void deleteGames(List<GameId> gameIds);
}
