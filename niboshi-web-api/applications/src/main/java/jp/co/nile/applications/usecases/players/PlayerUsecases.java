package jp.co.nile.applications.usecases.players;

import java.util.List;
import jp.co.nile.domains.models.players.CreatePlayerParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.UpdatePlayerParams;

/**
 * プレイヤードメインユースケースサービス
 */
public interface PlayerUsecases {
  void createPlayers(List<CreatePlayerParams> createPlayersParams);

  /**
   * プレイヤー一覧を取得する
   *
   * @return プレイヤー一覧
   */
  List<Player> findAllPlayers();

  /**
   * プレイヤーIDに紐づくプレイヤーを取得する
   *
   * @param playerId
   * @return
   */
  Player findPlayer(PlayerId playerId);

  /**
   * 指定したプレイヤーを更新する
   *
   * @param updatePlayerParams
   */
  void updatePlayer(UpdatePlayerParams updatePlayerParams);

  /**
   * 指定したプレイヤーを削除する
   *
   * @param deletePlayerIds
   */
  void deletePlayers(List<PlayerId> deletePlayerIds);
}
