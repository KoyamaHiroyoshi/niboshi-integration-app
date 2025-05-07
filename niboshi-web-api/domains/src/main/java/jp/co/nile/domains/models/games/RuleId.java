package jp.co.nile.domains.models.games;

import java.util.UUID;
import jp.co.nile.domains.models.shared.uuid.NileUuid;

/**
 * ゲームルールID
 */
public class RuleId extends NileUuid {
  public RuleId() {
    super();
  }

  public RuleId(UUID uuid) {
    super(uuid);
  }

  public RuleId(String uuidString) {
    super(uuidString);
  }
}
