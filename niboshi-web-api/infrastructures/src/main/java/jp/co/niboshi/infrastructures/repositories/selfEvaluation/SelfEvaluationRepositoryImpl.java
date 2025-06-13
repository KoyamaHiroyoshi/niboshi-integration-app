package jp.co.niboshi.infrastructures.repositories.selfEvaluation;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.selfEvaluation.CreateSelfEvaluationParams;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationId;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationRepository;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationUserId;
import jp.co.niboshi.domains.models.selfEvaluation.UpdateSelfEvaluationParams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Repository
@Slf4j
public class SelfEvaluationRepositoryImpl implements SelfEvaluationRepository {
  private final SelfEvaluationMapper selfEvaluationMapper;
  private final InfraSelfEvaluationsConverter selfEvaluationsConverter;

  @Override
  public void createSelfEvaluations(List<CreateSelfEvaluationParams> createEmployeesParams) {
    // List<EmployeeEntity> newEmployees = createEmployeesParams.stream()
    // .map(createEmployeeParams -> new EmployeeEntity(new EmployeeId().getUuid(),
    // createEmployeeParams.getEmployeeName().toString()))
    // .toList();
    // employeesMapper.createSelfEvaluations(newEmployees);
  }

  @Override
  public List<SelfEvaluation> findAllSelfEvaluations() throws DomainModelException {
    return selfEvaluationMapper.selectAllSelfEvaluations().stream().map(
        selfEvaluationsConverter::toSelfEvaluation)
        .toList();
  }

  @Override
  public SelfEvaluation findSelfEvaluationById(SelfEvaluationUserId selfEvaluationUserId)
      throws DomainModelException {
    log.info("findSelfEvaluationById開始");
    SelfEvaluationEntity entity;
    try {
      entity = selfEvaluationMapper.selectSelfEvaluationById(selfEvaluationUserId.toString());
      if (entity == null) {
        throw new Exception("該当するデータが見つかりません: " + selfEvaluationUserId);
      }

    } catch (Exception e) {
      log.error("catch箇所:　" + "SelfEvaluationRepositoryImpl.findSelfEvaluationById");
      log.error("エラー内容：" + e.toString());
      return null;
    }
    return selfEvaluationsConverter.toSelfEvaluation(entity);
  }

  @Override
  public void updateSelfEvaluation(UpdateSelfEvaluationParams updateSelfEvaluationParams) {
    // employeesMapper.updateSelfEvaluation(updateEmployeeParams.getId().getUuid(),
    // updateEmployeeParams.getName().toString());
  }

  @Override
  public void deleteSelfEvaluations(List<SelfEvaluationUserId> deleteSelfEvaluationUserId) {
    // employeesMapper.deleteSelfEvaluations(
    // deleteEmployeeIds.stream().map(NiboshiUuid::getUuid).toList());
  }

  @Override
  public List<SelfEvaluation> findSelfEvaluationsById(
      List<SelfEvaluationUserId> selfEvaluationUserIds)
      throws DomainModelException {
    return selfEvaluationMapper
        .selectSelfEvaluationsById(selfEvaluationUserIds
            .stream()
            .map(SelfEvaluationUserId::toString)
            .toList())
        .stream()
        .map(selfEvaluationsConverter::toSelfEvaluation)
        .toList();
  }


}
