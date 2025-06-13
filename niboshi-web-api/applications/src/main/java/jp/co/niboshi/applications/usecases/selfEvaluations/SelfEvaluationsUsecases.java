package jp.co.niboshi.applications.usecases.selfEvaluations;

import java.util.List;

import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation;
import jp.co.niboshi.domains.models.selfEvaluation.CreateSelfEvaluationParams;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationUserId;
import jp.co.niboshi.domains.models.selfEvaluation.UpdateSelfEvaluationParams;

/**
 * 自己評価ドメインユースケースサービス
 */
public interface SelfEvaluationsUsecases {
  void createSelfEvaluations(List<CreateSelfEvaluationParams> createSelfEvaluationsParams);

  /**
   * 自己評価一覧を取得する
   *
   * @return 自己評価一覧
   */
  List<SelfEvaluation> findAllSelfEvaluations();

  /**
   * 自己評価IDに紐づく自己評価を取得する
   *
   * @param employeeId
   * @return
   */
  SelfEvaluation findSelfEvaluation(SelfEvaluationUserId selfEvaluationUserId);

  /**
   * 指定した自己評価を更新する
   *
   * @param updateEmployeeParams
   */
  void updateSelfEvaluation(UpdateSelfEvaluationParams updateSelfEvaluationParams);

  /**
   * 指定した自己評価を削除する
   *
   * @param deleteEmployeeIds
   */
  void deleteSelfEvaluations(List<SelfEvaluationUserId> deleteSelfEvaluationUserIds);

}
