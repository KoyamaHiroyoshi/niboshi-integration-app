package jp.co.nile.domains.models.games;

import java.util.List;
import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * ゲーム結果
 */
@ToString
@Getter
@EqualsAndHashCode
public class GameResults implements NileModel {
  private final List<PlayerResult> results;

  public GameResults(List<PlayerResult> results) {
    if (Objects.isNull(results)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (results.size() != 4) {
      this.throwDomainModelException(
          String.format(ErrorMessages.LIST_SIZE.getMessage(), this.getModelName(), 4, 4));
    }
    this.results = results;
  }
}
