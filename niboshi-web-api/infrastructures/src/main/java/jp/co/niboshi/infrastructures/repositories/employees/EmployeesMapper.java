package jp.co.niboshi.infrastructures.repositories.employees;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeesMapper {
  void createEmployees(List<EmployeeEntity> newEmployees);

  List<EmployeeEntity> selectAllEmployees();

  EmployeeEntity selectEmployeeById(UUID employeeId);

  List<EmployeeEntity> selectEmployeesById(List<UUID> employeeIds);

  void updateEmployee(UUID employeeId, String employeeName);

  void deleteEmployees(List<UUID> employeeIds);
}
