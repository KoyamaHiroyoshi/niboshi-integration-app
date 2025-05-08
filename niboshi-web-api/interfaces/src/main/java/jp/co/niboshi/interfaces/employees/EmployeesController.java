package jp.co.niboshi.interfaces.employees;

import java.util.ArrayList;
import java.util.Arrays;

import org.openapitools.api.EmployeesApi;
import org.openapitools.model.CreateEmployeesRequest;
import org.openapitools.model.Employee;
import org.openapitools.model.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jp.co.niboshi.applications.usecases.employees.EmployeeUsecases;
import jp.co.niboshi.domains.models.employees.CreateEmployeeParams;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeeName;
import jp.co.niboshi.domains.models.employees.UpdateEmployeeParams;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeesController implements EmployeesApi {
  private final EmployeeUsecases employeesUseCases;
  private final InterfaceEmployeesConverter employeesConverter;

  @Override
  public ResponseEntity<Void> createEmployees(@Valid CreateEmployeesRequest createEmployeeRequest) {
    employeesUseCases.createEmployees(createEmployeeRequest.getEmployees().stream()
        .map(req -> new EmployeeName(req.getName())).toList().stream()
        .map(CreateEmployeeParams::new).toList());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteEmployee(String employeeId) {
    employeesUseCases.deleteEmployees(new ArrayList<>(Arrays.asList(new EmployeeId(employeeId))));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Employees> findAllEmployees() {
    return new ResponseEntity<>(
        employeesConverter
            .toInterfaceFindAllEmployeesResponse(employeesUseCases.findAllEmployees()),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Employee> findEmployee(String employeeId) {
    return new ResponseEntity<>(
        employeesConverter
            .toInterfaceEmployee(employeesUseCases.findEmployee(new EmployeeId(employeeId))),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateEmployee(String employeeId,
      org.openapitools.model.@Valid CreateEmployeeParams body) {
    employeesUseCases.updateEmployee(UpdateEmployeeParams.builder().id(new EmployeeId(employeeId))
        .name(new EmployeeName(body.getName())).build());

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
