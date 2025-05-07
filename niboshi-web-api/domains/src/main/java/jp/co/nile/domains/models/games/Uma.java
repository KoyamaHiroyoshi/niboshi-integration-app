package jp.co.nile.domains.models.games;

import jp.co.nile.domains.models.shared.NileModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * ゲームルール
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Uma implements NileModel {
  /**
   * ウマID
   */
  @NonNull
  private UmaId id;
  /**
   * ウマ名
   */
  @NonNull
  private String name;
  /**
   * 2位, 3位間のレート
   */
  @NonNull
  private Integer secondPlaceRate;
  /**
   * 1位, 4位間のレート
   */
  @NonNull
  private Integer firstPlaceRate;
}
