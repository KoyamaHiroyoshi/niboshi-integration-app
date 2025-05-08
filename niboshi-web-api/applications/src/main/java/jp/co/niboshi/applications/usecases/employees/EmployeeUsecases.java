package jp.co.niboshi.applications.usecases.employees;

import java.util.List;

import jp.co.niboshi.domains.models.employees.CreateEmployeeParams;
import jp.co.niboshi.domains.models.employees.Employee;
import jp.co.niboshi.domains.models.employees.EmployeeId;
import jp.co.niboshi.domains.models.employees.UpdateEmployeeParams;

/**
 * 従業員ドメインユースケースサービス
 */
public interface EmployeeUsecases {
  void createEmployees(List<CreateEmployeeParams> createEmployeesParams);

  /**
   * 従業員一覧を取得する
   *
   * @return 従業員一覧
   */
  List<Employee> findAllEmployees();

  /**
   * 従業員IDに紐づく従業員を取得する
   *
   * @param employeeId
   * @return
   */
  Employee findEmployee(EmployeeId employeeId);

  /**
   * 指定した従業員を更新する
   *
   * @param updateEmployeeParams
   */
  void updateEmployee(UpdateEmployeeParams updateEmployeeParams);

  /**
   * 指定した従業員を削除する
   *
   * @param deleteEmployeeIds
   */
  void deleteEmployees(List<EmployeeId> deleteEmployeeIds);
}
