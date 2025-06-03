package jp.co.niboshi.domains.models.employees;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class EmployeeMailAddress implements NiboshiModel {
  private String inner;

  public EmployeeMailAddress(String employeeMailAddress) {
    if (Objects.isNull(employeeMailAddress)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (employeeMailAddress.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = employeeMailAddress;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}

