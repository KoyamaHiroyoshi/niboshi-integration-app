package jp.co.niboshi.infrastructures.repositories.selfEvaluation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelfEvaluationMapper {
  void createSelfEvaluations(List<SelfEvaluationEntity> newSelfEvaluation);

  List<SelfEvaluationEntity> selectAllSelfEvaluations();

  SelfEvaluationEntity selectSelfEvaluationById(String selfEvaluationId);

  List<SelfEvaluationEntity> selectSelfEvaluationsById(List<String> selfEvaluationIds);

  void updateSelfEvaluation(String selfEvaluationId, String employeeName);

  void deleteSelfEvaluations(List<String> selfEvaluationId);
}
