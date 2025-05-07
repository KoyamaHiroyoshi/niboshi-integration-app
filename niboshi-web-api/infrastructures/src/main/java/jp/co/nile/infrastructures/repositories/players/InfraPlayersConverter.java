package jp.co.nile.infrastructures.repositories.players;

import org.springframework.stereotype.Component;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;

@Component
public class InfraPlayersConverter {
  public Player toPlayer(PlayerEntity playerEntity) {
    return Player.builder()
        .id(new PlayerId(playerEntity.getId()))
        .name(new PlayerName(playerEntity.getName()))
        .build();
  }
}
