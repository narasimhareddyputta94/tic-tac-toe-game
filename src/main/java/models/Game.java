package models;

import exception.MoreThanOneBotException;
import stratagies.WinningStrategy;

import java.util.List;

public class Game {
   private List<Player> players;
   private Board board;
   private List<Move> moves;
   private Player winner;
   private GameState gameState;
   private int nextPlayerIndex;
   private List<WinningStrategy> winningStrategies;
   private int dimension;


    private Game(int dimension,List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        public Game build() throws MoreThanOneBotException {
            /*
                1. Validating the number of bots allowed in the game
                2. Validating the number of players allowed in the game
                3. Validating the dimension of the board
                4. Validating the winning strategies

             */

            ValidateBotCount();
            ValidateUniqueSymbolForPlayers();
            ValidateDimension();

            return new Game(dimension,players,winningStrategies);

        }

        private void ValidateBotCount() throws MoreThanOneBotException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if (botCount > 1) {
                throw new MoreThanOneBotException();
            }
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
}
