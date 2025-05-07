package jp.co.nile.domains.models.games;

import java.util.UUID;
import jp.co.nile.domains.models.shared.uuid.NileUuid;

/**
 * ウマID
 */
public class UmaId extends NileUuid {
  public UmaId() {
    super();
  }

  public UmaId(UUID uuid) {
    super(uuid);
  }

  public UmaId(String uuidString) {
    super(uuidString);
  }
}
