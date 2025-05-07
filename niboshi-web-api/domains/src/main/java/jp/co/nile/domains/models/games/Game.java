package jp.co.nile.domains.models.games;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.shared.NileModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Game implements NileModel {
  @NonNull
  private final GameId id;
  @NonNull
  private final LeagueId leagueId;
  @NonNull
  private final Rule rule;
  @NonNull
  private final Uma uma;
  @NonNull
  private final List<PlayerResult> playerResults;
  @NonNull
  private final Date evenDate;

  public Map<PlayerId, Float> getCalculatedPlayerScore() {
    Map<PlayerId, Float> playerScoreMap = new LinkedHashMap<>();

    playerResults
        .stream()
        // 4位→1位の順でソートして4位から計算
        .sorted(Comparator.comparing(PlayerResult::getResult).reversed())
        .forEach(playerResult -> {
          Float score = BigDecimal
              .valueOf(playerResult.getScore() / 1000d).setScale(1, RoundingMode.FLOOR)
              // 30000点返し
              .floatValue() - 30;

          // ウマ計算してマップに追加する
          switch (playerResult.getResult()) {
            case 4:
              playerScoreMap
                  .put(playerResult.getPlayer().getId(), score - uma.getFirstPlaceRate());
              break;
            case 3:
              playerScoreMap
                  .put(playerResult.getPlayer().getId(), score - uma.getSecondPlaceRate());
              break;
            case 2:
              playerScoreMap
                  .put(playerResult.getPlayer().getId(), score + uma.getSecondPlaceRate());
              break;
            default:
              // 1位はオカ(20)も追加
              playerScoreMap
                  .put(playerResult.getPlayer().getId(), score + uma.getFirstPlaceRate() + 20);
              break;
          }
        });
    return playerScoreMap;
  }
}
