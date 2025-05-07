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
public class Rule implements NileModel {
  @NonNull
  private RuleId id;
  @NonNull
  private String name;
}
