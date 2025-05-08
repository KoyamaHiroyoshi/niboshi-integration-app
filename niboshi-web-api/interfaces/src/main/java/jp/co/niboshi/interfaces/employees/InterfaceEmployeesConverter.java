package jp.co.niboshi.interfaces.employees;

import java.util.List;

import org.openapitools.model.Employee;
import org.openapitools.model.Employees;
import org.springframework.stereotype.Component;

@Component
public class InterfaceEmployeesConverter {
  public Employee toInterfaceEmployee(
      jp.co.niboshi.domains.models.employees.Employee domainEmployee) {
    Employee interfaceEmployee = new Employee();
    interfaceEmployee.setId(domainEmployee.getId().toString());
    interfaceEmployee.setName(domainEmployee.getName().toString());

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
