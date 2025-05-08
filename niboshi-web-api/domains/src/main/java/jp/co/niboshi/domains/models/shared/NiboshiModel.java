package jp.co.niboshi.domains.models.shared;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;

/**
 * Niboshiで扱うモデルはこの interface を実装すること
 */
public interface NiboshiModel {
  /**
   * モデル名を取得する
   *
   * @return モデル名
   */
  default String getModelName() {
    return this.getClass().getSimpleName();
  }

  /**
   * ドメインモデル作成失敗エラーを返却する
   *
   * @param message
   * @throws DomainModelException
   */
  default void throwDomainModelException(String message) throws DomainModelException {
    throw new DomainModelException(this.getModelName(), message);
  }
}
