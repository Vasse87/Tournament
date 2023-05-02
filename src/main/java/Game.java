import java.util.ArrayList;

public class Game {
    ArrayList<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        if (registeredPlayers.contains(player)) {
            RuntimeException e = new RuntimeException(
                    "Игрок " + player + "уже зарегистрирован"
            );
            throw e;
        } else {
            registeredPlayers.add(player);
        }
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
