package jp.co.niboshi.domains.models.employees;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;
import lombok.Getter;

@Getter
public class CreateEmployeeParams implements NiboshiModel {
  private final EmployeeName employeeName;

  public CreateEmployeeParams(EmployeeName employeeName) {
    if (Objects.isNull(employeeName)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    }
    this.employeeName = employeeName;
  }
}
