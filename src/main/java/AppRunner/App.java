package AppRunner;

import controller.GameController;
import exception.MoreThanOneBotException;
import exception.SymbolsNotUniqueException;
import exception.dimensionislessthan3exception;
import exception.minimunmplayersrequiredshouldbe1lessthansizeofboardexception;
import models.*;
import winningstratagies.ColumnWinningStrategy;
import winningstratagies.DiagonalWinningStratregy;
import winningstratagies.RowWinningstrategy;
import winningstratagies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player('X', "Player1", 1, PlayerType.HUMAN));
        playerList.add(new Bot('0', "GPT", 2, PlayerType.BOT, BotDifficultylevel.EASY));
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningstrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStratregy());
        Game game = null;
        try {
            game = gameController.startGame(3, playerList, winningStrategies);
        } catch (dimensionislessthan3exception e) {
            throw new RuntimeException(e);
        } catch (SymbolsNotUniqueException e) {
            throw new RuntimeException(e);
        } catch (MoreThanOneBotException e) {
            throw new RuntimeException(e);
        } catch (minimunmplayersrequiredshouldbe1lessthansizeofboardexception e) {
            throw new RuntimeException(e);
        }
        game.printBoard();


    }
}
