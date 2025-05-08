package jp.co.niboshi.domains.models.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class EmployeeNameTest {
  @Test
  void 成功_生成() {
    EmployeeName employeeName = new EmployeeName("employeeName");
    assertEquals("employeeName", employeeName.toString());
  }

  @Test
  void 失敗_nullからの生成() {
    DomainModelException domainModelException =
        assertThrows(DomainModelException.class, () -> new EmployeeName(null));

    assertEquals("EmployeeName", domainModelException.getField());
    assertEquals("EmployeeNameはNULL非許容です。", domainModelException.getReason());
  }

  @Test
  void 失敗_空文字からの生成() {
    DomainModelException domainModelException =
        assertThrows(DomainModelException.class, () -> new EmployeeName(""));

    assertEquals("EmployeeName", domainModelException.getField());
    assertEquals("EmployeeNameは空文字非許容です。", domainModelException.getReason());
  }

  @Test
  void 成功_文字列化() {
    assertEquals("テスト従業員名", new EmployeeName("テスト従業員名").toString());
  }
}
