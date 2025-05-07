package jp.co.nile.domains.models.games;

import java.util.UUID;
import jp.co.nile.domains.models.shared.uuid.NileUuid;

/**
 * ゲームID
 */
public class GameId extends NileUuid {
  public GameId() {
    super();
  }

  public GameId(UUID uuid) {
    super(uuid);
  }

  public GameId(String uuidString) {
    super(uuidString);
  }
}
