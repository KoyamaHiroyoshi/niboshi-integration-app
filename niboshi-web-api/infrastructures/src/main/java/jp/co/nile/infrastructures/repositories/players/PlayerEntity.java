package jp.co.nile.infrastructures.repositories.players;

import java.util.UUID;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.infrastructures.repositories.NileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerEntity implements NileEntity<Player> {
  private UUID id;
  private String name;
}
