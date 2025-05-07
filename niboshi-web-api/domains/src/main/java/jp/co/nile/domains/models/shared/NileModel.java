package jp.co.nile.domains.models.shared;

import jp.co.nile.domains.models.exceptions.DomainModelException;

/**
 * Nileで扱うモデルはこの interface を実装すること
 */
public interface NileModel {
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
