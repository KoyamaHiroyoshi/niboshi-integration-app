package jp.co.niboshi.domains.models.employees;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Employee implements NiboshiModel {
  @NonNull
  private EmployeeId id;
  @NonNull
  private EmployeeName name;
}
