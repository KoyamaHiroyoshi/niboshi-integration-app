package jp.co.niboshi.infrastructures.repositories.employees;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeesMapper {
  void createEmployees(List<EmployeeEntity> newEmployees);

  List<EmployeeEntity> selectAllEmployees();

  EmployeeEntity selectEmployeeById(String employeeId);

  List<EmployeeEntity> selectEmployeesById(List<String> employeeIds);

  void updateEmployee(String employeeId, String employeeName);

  void deleteEmployees(List<String> employeeIds);
}
