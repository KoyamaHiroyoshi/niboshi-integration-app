package jp.co.nile.domains.models.leagues;

import java.util.Date;
import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;

/**
 * リーグ開始日
 */
public class LeagueStartAt implements NileModel {
  private Date inner;

  public LeagueStartAt(Date startAt) {
    if (Objects.isNull(startAt)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    }

    this.inner = startAt;
  }

  public Date toDate() {
    return this.inner;
  }
}
