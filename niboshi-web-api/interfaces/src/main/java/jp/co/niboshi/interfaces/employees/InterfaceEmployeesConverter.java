package jp.co.niboshi.interfaces.employees;

import java.util.List;

import org.openapitools.model.Employee;
import org.openapitools.model.Employees;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InterfaceEmployeesConverter {
  public Employee toInterfaceEmployee(
      jp.co.niboshi.domains.models.employees.Employee domainEmployee) {
    log.info("Id:　" + domainEmployee.getId().toString());
    log.info("Name:　" + domainEmployee.getName().toString());
    log.info("MailAddress:　" + domainEmployee.getMailAddress().toString());
    log.info("Password:　" + domainEmployee.getPassword().toString());
    Employee interfaceEmployee = new Employee();
    interfaceEmployee.setId(domainEmployee.getId().toString());
    interfaceEmployee.setName(domainEmployee.getName().toString());
    interfaceEmployee.setMailAddress(domainEmployee.getMailAddress().toString());
    interfaceEmployee.setPassword(domainEmployee.getPassword().toString());

    return interfaceEmployee;
  }

  public Employees toInterfaceFindAllEmployeesResponse(
      List<jp.co.niboshi.domains.models.employees.Employee> domainEmployees) {
    Employees interfaceFindAllPlayersResponse = new Employees();
    interfaceFindAllPlayersResponse.setEmployees(
        domainEmployees.stream().map(this::toInterfaceEmployee).toList());

    return interfaceFindAllPlayersResponse;
  }
}
