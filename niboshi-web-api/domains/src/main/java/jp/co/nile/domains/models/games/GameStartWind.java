package jp.co.nile.domains.models.games;

import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;

/**
 * ゲーム開始時の風
 */
public enum GameStartWind {
  /**
   * 東
   */
  EAST(1),
  /**
   * 南
   */
  SOUTH(2),
  /**
   * 西
   */
  WEST(3),
  /**
   * 北
   */
  NORTH(4),
  ;

  private final int sortNum;

  GameStartWind(int sortNum) {
    this.sortNum = sortNum;
  }

  /**
   * ENUM名から風を生成する
   *
   * @param name ENUM名
   * @return 風
   */
  public static GameStartWind from(String name) {
    for (GameStartWind wind : GameStartWind.values()) {
      if (wind.name().equals(name)) {
        return wind;
      }
    }
    throw new DomainModelException("GameStartWind",
        String.format(ErrorMessages.UNKNOWN_VALUE.getMessage(), "GameStartWind"));
  }

  public int getSortNum() {
    return sortNum;
  }
}
