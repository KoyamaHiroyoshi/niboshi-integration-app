package jp.co.niboshi.domains.models.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class CreateEmployeeParamsTest {
  @Test
  void testGetEmployeeName() {
    EmployeeName employeeName = new EmployeeName("テスト名");

    CreateEmployeeParams createEmployeeParams = new CreateEmployeeParams(employeeName);
    assertEquals(employeeName.toString(), createEmployeeParams.getEmployeeName().toString());
  }
}
