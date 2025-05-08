package jp.co.niboshi.domains.models.shared.uuid;

import java.util.UUID;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.shared.NiboshiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NiboshiUuid implements NiboshiModel {
  private UUID uuid;

  protected NiboshiUuid() {
    this.uuid = UUID.randomUUID();
  }

  protected NiboshiUuid(String uuidString) throws DomainModelException {
    try {
      this.uuid = UUID.fromString(uuidString);
    } catch (IllegalArgumentException e) {
      throw new DomainModelException("niboshiUuid", "", e);
    }
  }

  @Override
  public String toString() {
    return this.uuid.toString();
  }
}
