package jp.co.niboshi.infrastructures.repositories.employees;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import jp.co.niboshi.domains.models.employees.CreateEmployeeParams;
import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeesRepository;
import jp.co.niboshi.domains.models.employees.UpdateEmployeeParams;
import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.shared.uuid.NiboshiUuid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class EmployeesRepositoryImpl implements EmployeesRepository {
  private final EmployeesMapper employeesMapper;
  private final InfraEmployeesConverter employeesConverter;

  @Override
  public void createEmployees(List<CreateEmployeeParams> createEmployeesParams) {
    List<EmployeeEntity> newEmployees = createEmployeesParams.stream()
        .map(createEmployeeParams -> new EmployeeEntity(new EmployeeId().getUuid(),
            createEmployeeParams.getEmployeeName().toString()))
        .collect(Collectors.toList());
    employeesMapper.createEmployees(newEmployees);
  }

  @Override
  public List<Employee> findAllEmployees() throws DomainModelException {
    return employeesMapper.selectAllEmployees().stream().map(
        employeesConverter::toEmployee)
        .collect(Collectors.toList());
  }

  @Override
  public Employee findEmployeeById(EmployeeId employeeId) throws DomainModelException {
    return employeesConverter.toEmployee(employeesMapper.selectEmployeeById(employeeId.getUuid()));
  }

  @Override
  public void updateEmployee(UpdateEmployeeParams updateEmployeeParams) {
    employeesMapper.updateEmployee(updateEmployeeParams.getId().getUuid(),
        updateEmployeeParams.getName().toString());
  }

  @Override
  public void deleteEmployees(List<EmployeeId> deleteEmployeeIds) {
    employeesMapper.deleteEmployees(
        deleteEmployeeIds.stream().map(NiboshiUuid::getUuid).collect(Collectors.toList()));
  }

  @Override
  public List<Employee> findEmployeesById(List<EmployeeId> employeeIds)
      throws DomainModelException {
    return employeesMapper
        .selectEmployeesById(employeeIds
            .stream()
            .map(EmployeeId::getUuid)
            .toList())
        .stream()
        .map(employeesConverter::toEmployee)
        .toList();
  }
}
