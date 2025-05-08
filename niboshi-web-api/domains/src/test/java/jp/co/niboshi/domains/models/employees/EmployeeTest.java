package jp.co.niboshi.domains.models.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class EmployeeTest {
  private EmployeeId employeeId;
  private EmployeeName employeeName;
  private Employee employee;

  @BeforeEach
  void setUp() {
    employeeId = new EmployeeId("f07e8324-0e14-4e4e-bbf3-0a901d2cfb78");
    employeeName = new EmployeeName("テスト名");
    employee = Employee.builder().id(employeeId).name(employeeName).build();
  }

  @Test
  void testGetEmployeeId() {
    assertEquals(employeeId.getUuid(), employee.getId().getUuid());
  }

  @Test
  void testGetEmployeeName() {
    assertEquals(employeeName.toString(), employee.getName().toString());
  }
}
