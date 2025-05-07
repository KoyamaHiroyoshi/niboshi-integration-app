package jp.co.nile.domains.models.leagues;

import java.util.Date;
import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;

/**
 * リーグ終了日
 */
public class LeagueEndAt implements NileModel {
  private Date inner;

  public LeagueEndAt(Date endAt) {
    if (Objects.isNull(endAt)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    }

    this.inner = endAt;
  }

  public Date toDate() {
    return this.inner;
  }
}
