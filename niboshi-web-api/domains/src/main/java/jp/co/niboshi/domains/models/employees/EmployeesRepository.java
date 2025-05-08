package jp.co.niboshi.domains.models.employees;

import java.util.List;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;

public interface EmployeesRepository {
  public void createEmployees(List<CreateEmployeeParams> createEmployeesParams);

  public List<Employee> findAllEmployees() throws DomainModelException;

  public Employee findEmployeeById(EmployeeId employeeId) throws DomainModelException;

  public List<Employee> findEmployeesById(List<EmployeeId> employeeIds) throws DomainModelException;

  public void updateEmployee(UpdateEmployeeParams updateEmployeeParams);

  public void deleteEmployees(List<EmployeeId> deleteEmployeeIds);
}
