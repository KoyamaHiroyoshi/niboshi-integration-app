package jp.co.nile.domains.models.players;

import java.util.Objects;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;
import lombok.Getter;

@Getter
public class CreatePlayerParams implements NileModel {
  private final PlayerName playerName;

  public CreatePlayerParams(PlayerName playerName) {
    if (Objects.isNull(playerName)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    }
    this.playerName = playerName;
  }
}
