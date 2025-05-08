package jp.co.niboshi.infrastructures.repositories.employees;

import java.util.UUID;

import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.infrastructures.repositories.NiboshiEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmployeeEntity implements NiboshiEntity<Employee> {
  private UUID id;
  private String name;
}
