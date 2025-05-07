package jp.co.nile.domains.models.games;

import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.shared.NileModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * プレイヤーゲーム結果
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerResult implements NileModel {
  /**
   * プレイヤー
   */
  @NonNull
  private GameId gameId;
  /**
   * プレイヤー
   */
  @NonNull
  private Player player;
  /**
   * スコア
   */
  @NonNull
  private Integer score;
  /**
   * 順位
   */
  @NonNull
  private Integer result;
}
