package jp.co.niboshi.domains.models.employees;

import java.util.UUID;

import jp.co.niboshi.domains.models.shared.uuid.NiboshiUuid;

public class EmployeeId extends NiboshiUuid {
  public EmployeeId() {
    super();
  }

  public EmployeeId(UUID uuid) {
    super(uuid);
  }

  public EmployeeId(String uuidString) {
    super(uuidString);
  }
}
