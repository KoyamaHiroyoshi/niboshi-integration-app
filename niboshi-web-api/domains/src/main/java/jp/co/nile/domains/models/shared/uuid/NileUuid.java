package jp.co.nile.domains.models.shared.uuid;

import java.util.UUID;
import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.shared.NileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NileUuid implements NileModel {
  private UUID uuid;

  protected NileUuid() {
    this.uuid = UUID.randomUUID();
  }

  protected NileUuid(String uuidString) throws DomainModelException {
    try {
      this.uuid = UUID.fromString(uuidString);
    } catch (IllegalArgumentException e) {
      throw new DomainModelException("nileUuid", "", e);
    }
  }

  @Override
  public String toString() {
    return this.uuid.toString();
  }
}
