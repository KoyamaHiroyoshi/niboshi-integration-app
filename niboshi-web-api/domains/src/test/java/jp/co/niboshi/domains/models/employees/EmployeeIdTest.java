package jp.co.niboshi.domains.models.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class EmployeeIdTest {
  private String employeeIdStr;
  private EmployeeId employeeId;

  @BeforeEach
  void setUp() {
    employeeIdStr = "f07e8324-0e14-4e4e-bbf3-0a901d2cfb78";
    employeeId = new EmployeeId(employeeIdStr);
  }

  @Test
  void testGetUuid() {
    assertEquals(employeeIdStr, employeeId.getUuid().toString());
  }

  @Test
  void testCreateFromUuid() {
    UUID uuid = UUID.randomUUID();
    assertEquals(uuid, new EmployeeId(uuid).getUuid());
  }
}
