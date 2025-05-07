package jp.co.nile.interfaces.players;

import java.util.List;
import java.util.stream.Collectors;
import org.openapitools.model.Player;
import org.openapitools.model.Players;
import org.springframework.stereotype.Component;

@Component
public class InterfacePlayersConverter {
  public Player toInterfacePlayer(jp.co.nile.domains.models.players.Player domainPlayer) {
    Player interfacePlayer = new Player();
    interfacePlayer.setId(domainPlayer.getId().toString());
    interfacePlayer.setName(domainPlayer.getName().toString());

    return interfacePlayer;
  }

  public Players toInterfaceFindAllPlayersResponse(
      List<jp.co.nile.domains.models.players.Player> domainPlayers) {
    Players interfaceFindAllPlayersResponse = new Players();
    interfaceFindAllPlayersResponse.setPlayers(
        domainPlayers.stream().map(this::toInterfacePlayer).collect(Collectors.toList()));

    return interfaceFindAllPlayersResponse;
  }
}
