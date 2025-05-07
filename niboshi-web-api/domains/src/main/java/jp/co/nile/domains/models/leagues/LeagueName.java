package jp.co.nile.domains.models.leagues;

import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;

/**
 * リーグ名
 */
public class LeagueName implements NileModel {
  private String inner;

  public LeagueName(String leagueName) {
    if (Objects.isNull(leagueName)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (leagueName.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = leagueName;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
