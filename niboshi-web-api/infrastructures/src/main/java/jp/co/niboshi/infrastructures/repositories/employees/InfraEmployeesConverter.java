package jp.co.niboshi.infrastructures.repositories.employees;

import org.springframework.stereotype.Component;

import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeeMailAddress;
import jp.co.niboshi.domains.models.employees.EmployeeName;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InfraEmployeesConverter {
  public Employee toEmployee(EmployeeEntity employeeEntity) {
    try {
      return Employee.builder()
          .id(new EmployeeId(employeeEntity.getId()))
          .name(new EmployeeName(employeeEntity.getName()))
          .mail_address(new EmployeeMailAddress(employeeEntity.getMail_address()))
          .build();
    } catch (Exception e) {
      log.error("エラー内容：　" + e.toString());
    }
    return null;
  }
}
