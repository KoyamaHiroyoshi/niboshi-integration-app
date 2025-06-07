package jp.co.niboshi.domains.models.employees;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class EmployeePassword implements NiboshiModel {
  private String inner;

  public EmployeePassword(String employeePassword) {
    if (Objects.isNull(employeePassword)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (employeePassword.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = employeePassword;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}

