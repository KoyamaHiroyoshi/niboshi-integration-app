package jp.co.nile.domains.models.players;

import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;

public class PlayerName implements NileModel {
  private String inner;

  public PlayerName(String playerName) {
    if (Objects.isNull(playerName)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (playerName.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = playerName;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
