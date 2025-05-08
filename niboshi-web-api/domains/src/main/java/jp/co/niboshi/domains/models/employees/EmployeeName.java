package jp.co.niboshi.domains.models.employees;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class EmployeeName implements NiboshiModel {
  private String inner;

  public EmployeeName(String employeeName) {
    if (Objects.isNull(employeeName)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (employeeName.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = employeeName;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
