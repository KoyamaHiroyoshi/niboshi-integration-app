package jp.co.niboshi.applications.usecases.employees.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.niboshi.applications.usecases.employees.EmployeeUsecases;
import jp.co.niboshi.domains.models.employees.CreateEmployeeParams;
import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeesRepository;
import jp.co.niboshi.domains.models.employees.UpdateEmployeeParams;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class EmployeesUseCasesImpl implements EmployeeUsecases {
  private final EmployeesRepository employeesRepository;

  @Override
  public void createEmployees(List<CreateEmployeeParams> createEmployeesParams) {
    employeesRepository.createEmployees(createEmployeesParams);
  }

  @Override
  public List<Employee> findAllEmployees() {
    return employeesRepository.findAllEmployees();
  }

  @Override
  public Employee findEmployee(EmployeeId employeeId) {
    return employeesRepository.findEmployeeById(employeeId);
  }

  @Override
  public void updateEmployee(UpdateEmployeeParams updateEmployeeParams) {
    employeesRepository.updateEmployee(updateEmployeeParams);
  }

  @Override
  public void deleteEmployees(List<EmployeeId> deleteEmployeeIds) {
    employeesRepository.deleteEmployees(deleteEmployeeIds);
  }
}
