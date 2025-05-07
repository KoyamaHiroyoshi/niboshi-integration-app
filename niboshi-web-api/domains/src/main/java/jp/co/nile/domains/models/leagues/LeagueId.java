package jp.co.nile.domains.models.leagues;

import java.util.UUID;
import jp.co.nile.domains.models.shared.uuid.NileUuid;

/**
 * リーグID
 */
public class LeagueId extends NileUuid {
  public LeagueId() {
    super();
  }

  public LeagueId(UUID uuid) {
    super(uuid);
  }

  public LeagueId(String uuidString) {
    super(uuidString);
  }
}
