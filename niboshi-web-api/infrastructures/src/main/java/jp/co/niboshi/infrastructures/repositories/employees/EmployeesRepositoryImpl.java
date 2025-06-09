package jp.co.niboshi.infrastructures.repositories.employees;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.niboshi.domains.models.employees.CreateEmployeeParams;
import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.EmployeeMailAddress;
import jp.co.niboshi.domains.models.employees.EmployeePassword;
import jp.co.niboshi.domains.models.employees.EmployeesRepository;
import jp.co.niboshi.domains.models.employees.UpdateEmployeeParams;
import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Repository
@Slf4j
public class EmployeesRepositoryImpl implements EmployeesRepository {
  private final EmployeesMapper employeesMapper;
  private final InfraEmployeesConverter employeesConverter;

  @Override
  public void createEmployees(List<CreateEmployeeParams> createEmployeesParams) {
    // List<EmployeeEntity> newEmployees = createEmployeesParams.stream()
    // .map(createEmployeeParams -> new EmployeeEntity(new EmployeeId().getUuid(),
    // createEmployeeParams.getEmployeeName().toString()))
    // .toList();
    // employeesMapper.createEmployees(newEmployees);
  }

  @Override
  public List<Employee> findAllEmployees() throws DomainModelException {
    return employeesMapper.selectAllEmployees().stream().map(
        employeesConverter::toEmployee)
        .toList();
  }

  @Override
  public Employee findEmployeeById(EmployeeId employeeId) throws DomainModelException {
    log.info("findEmployeeById開始");
    EmployeeEntity entity;
    try {
      entity = employeesMapper.selectEmployeeById(employeeId.toString());
      if (entity == null) {
        throw new Exception("該当する従業員が見つかりません: " + employeeId);
      }

    } catch (Exception e) {
      log.error("catch箇所:　" + "EmployeesRepositoryImpl.findEmployeeById");
      log.error("エラー内容：" + e.toString());
      return null;
    }
    return employeesConverter.toEmployee(entity);
  }

  @Override
  public void updateEmployee(UpdateEmployeeParams updateEmployeeParams) {
    // employeesMapper.updateEmployee(updateEmployeeParams.getId().getUuid(),
    // updateEmployeeParams.getName().toString());
  }

  @Override
  public void deleteEmployees(List<EmployeeId> deleteEmployeeIds) {
    // employeesMapper.deleteEmployees(
    // deleteEmployeeIds.stream().map(NiboshiUuid::getUuid).toList());
  }

  @Override
  public List<Employee> findEmployeesById(List<EmployeeId> employeeIds)
      throws DomainModelException {
    return employeesMapper
        .selectEmployeesById(employeeIds
            .stream()
            .map(EmployeeId::toString)
            .toList())
        .stream()
        .map(employeesConverter::toEmployee)
        .toList();
  }

  @Override
  public Employee findEmployeeByMailAddressAndPassword(EmployeeMailAddress mailAddress,
      EmployeePassword password) throws DomainModelException {
    log.info("findEmployeeByMailAddressAndPassword開始 / メールアドレス：" + mailAddress + " / パスワード：" + password);
    EmployeeEntity entity;
    try {
      entity = employeesMapper.selectEmployeeByMailAddressAndPassword(mailAddress.toString(),
          password.toString());
      if (entity == null) {
        throw new Exception("該当する従業員が見つかりません: メールアドレス：　" + mailAddress + "パスワード：　" + password);
      }

    } catch (Exception e) {
      log.error("catch箇所:　" + "EmployeesRepositoryImpl.findEmployeeByMailAddressAndPassword");
      log.error("エラー内容：" + e.toString());
      return null;
    }
    return employeesConverter.toEmployee(entity);
  }


}
