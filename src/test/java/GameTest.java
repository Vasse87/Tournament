import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Саша", 30);
    Player player2 = new Player(2, "Ваня", 40);
    Player player3 = new Player(3, "Слава", 50);
    Player player4 = new Player(4, "Коля", 60);
    Player player5 = new Player(5, "Миша", 70);
    Player player6 = new Player(6, "Юра", 30);

    @Test
    public void shouldRegisterPlayers() {
        Assertions.assertEquals(0, game.registeredPlayers.size());
        game.register(player1);
        Assertions.assertEquals(1, game.registeredPlayers.size());
        game.register(player2);
        game.register(player3);
        Assertions.assertEquals(3, game.registeredPlayers.size());

        Assertions.assertThrows(RuntimeException.class, () -> { // третий игрок уже зарегистрирован
            game.register(player3);
        });
    }


    @Test
    public void shouldNotPlayBecausePlayersAreNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> { // первый игрок не зарегистрирован
            game.round("Юра", "Ваня");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> { // второй игрок не зарегистрирован
            game.round("Ваня", "Юра");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> { // оба игрока не зарегистрированы
            game.round("Ваня", "Миша");
        });
    }

    @Test
    public void s() {
        game.register(player1);
        game.register(player2);
        game.register(player6);

        int expected = 1;
        int actual = game.round("Ваня", "Саша");
        Assertions.assertEquals(expected, actual);

        int expected2 = 2;
        int actual2 = game.round("Саша", "Ваня");
        Assertions.assertEquals(expected2, actual2);

        int expected3 = 0;
        int actual3 = game.round("Юра", "Саша");
        Assertions.assertEquals(expected3, actual3);

    }
}

