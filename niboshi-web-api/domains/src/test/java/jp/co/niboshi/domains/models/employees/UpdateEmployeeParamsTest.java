package jp.co.niboshi.domains.models.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class UpdateEmployeeParamsTest {
  private EmployeeId employeeId;
  private EmployeeName employeeName;
  private UpdateEmployeeParams updateEmployeeParams;

  @BeforeEach
  void setUp() {
    this.employeeId = new EmployeeId();
    this.employeeName = new EmployeeName("テスト名");
    updateEmployeeParams = UpdateEmployeeParams.builder().id(employeeId).name(employeeName).build();
  }

  @Test
  void testGetId() {
    assertEquals(employeeId.getUuid(), updateEmployeeParams.getId().getUuid());
  }

  @Test
  void testGetName() {
    assertEquals(employeeName.toString(), updateEmployeeParams.getName().toString());
  }
}
