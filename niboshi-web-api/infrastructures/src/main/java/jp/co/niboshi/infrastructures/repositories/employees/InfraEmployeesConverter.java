package jp.co.niboshi.infrastructures.repositories.employees;

import org.springframework.stereotype.Component;

import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeeName;

@Component
public class InfraEmployeesConverter {
  public Employee toEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
        .id(new EmployeeId(employeeEntity.getId()))
        .name(new EmployeeName(employeeEntity.getName()))
        .build();
  }
}
