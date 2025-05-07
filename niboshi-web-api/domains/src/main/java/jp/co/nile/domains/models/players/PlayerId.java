package jp.co.nile.domains.models.players;

import java.util.UUID;
import jp.co.nile.domains.models.shared.uuid.NileUuid;

public class PlayerId extends NileUuid {
  public PlayerId() {
    super();
  }

  public PlayerId(UUID uuid) {
    super(uuid);
  }

  public PlayerId(String uuidString) {
    super(uuidString);
  }
}
