package jp.co.niboshi.infrastructures.repositories.employees;

import org.springframework.stereotype.Component;

import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeeMailAddress;
import jp.co.niboshi.domains.models.employees.EmployeeName;
import jp.co.niboshi.domains.models.employees.EmployeePassword;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InfraEmployeesConverter {
  public Employee toEmployee(EmployeeEntity employeeEntity) {
    try {
      return Employee.builder()
          .id(new EmployeeId(employeeEntity.getId()))
          .name(new EmployeeName(employeeEntity.getName()))
          .mailAddress(new EmployeeMailAddress(employeeEntity.getMailAddress()))
          .password(new EmployeePassword(employeeEntity.getPassword()))
          .build();
    } catch (Exception e) {
      log.error("catch箇所:　" + "InfraEmployeesConverter.Employee");
      log.error("エラー内容：　" + e.toString());
    }
    return null;
  }
}
