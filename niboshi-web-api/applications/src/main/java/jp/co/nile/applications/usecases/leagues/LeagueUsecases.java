package jp.co.nile.applications.usecases.leagues;

import java.util.List;
import java.util.Optional;
import jp.co.nile.domains.models.games.CreateGameParams;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.domains.models.leagues.CreateLeagueParams;
import jp.co.nile.domains.models.leagues.League;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.UpdateLeagueParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;

/**
 * リーグドメインユースケースサービス
 */
public interface LeagueUsecases {
  /**
   * リーグを登録する
   *
   * @param createLeaguesParams
   */
  void createLeagues(List<CreateLeagueParams> createLeaguesParams);

  /**
   * リーグ一覧を取得する
   *
   * @return リーグ一覧
   */
  List<League> findAllLeagues();

  /**
   * リーグIDに紐づくリーグを取得する
   *
   * @param leagueId
   * @return
   */
  Optional<League> findLeague(LeagueId leagueId);

  /**
   * 指定したリーグを更新する
   *
   * @param updateLeagueParams
   */
  void updateLeague(UpdateLeagueParams updateLeagueParams);

  /**
   * 指定したリーグを削除する
   *
   * @param deleteLeagueId
   */
  void deleteLeague(LeagueId deleteLeagueId);

  /**
   * リーグにプレイヤーを追加する
   *
   * @param leagueId リーグID
   * @param playerIds プレイヤーIDリスト
   */
  void addPlayersToLeague(LeagueId leagueId, List<PlayerId> playerIds);

  /**
   * リーグに所属しているプレイヤー一覧を取得加する
   *
   * @param leagueId リーグID
   */
  List<Player> findLeaguePlayers(LeagueId leagueId);

  /**
   * リーグにゲームを登録する
   *
   * @param CreateGameParams
   */
  void createGame(CreateGameParams createGameParams);

  /**
   * リーグ内ゲーム一覧を取得する
   *
   * @param leagueId
   * @return
   */
  List<Game> getLeagueGames(LeagueId leagueId);
}
