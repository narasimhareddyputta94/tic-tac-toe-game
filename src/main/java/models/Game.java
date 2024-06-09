package models;

import exception.MoreThanOneBotException;
import exception.SymbolsNotUniqueException;
import exception.dimensionislessthan3exception;
import exception.minimunmplayersrequiredshouldbe1lessthansizeofboardexception;
import winningstratagies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;// Initialize the moves list
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove() {
        Player player = players.get(nextPlayerIndex);
        Cell cell = player.makeMove(board);

        Move move = new Move(cell, player);
        moves.add(move);

        if(checkWinner(move, board)){
            gameState = GameState.WIN;
            winner = player;
            return ;
        }

        /*
        checking for draw
         */
        if(moves.size()==board.getDimension()*board.getDimension()){
            gameState = GameState.DRAW;
            return ;
        }

        // update teh next player accordingly
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % players.size();

    }


    private boolean checkWinner(Move move, Board board) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board , move)) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        public Game build() throws MoreThanOneBotException, SymbolsNotUniqueException, dimensionislessthan3exception, minimunmplayersrequiredshouldbe1lessthansizeofboardexception {
            /*
                1. Validating the number of bots allowed in the game
                2. Validating the number of players allowed in the game
                3. Validating the dimension of the board
                4. Validating the winning strategies

             */

            ValidateBotCount();
            ValidateUniqueSymbolForPlayers();
            ValidateDimensionandPlayerCount();

            return new Game(dimension,players,winningStrategies);

        }

        private void ValidateDimensionandPlayerCount() throws dimensionislessthan3exception, minimunmplayersrequiredshouldbe1lessthansizeofboardexception {
            if (dimension < 3) {
                throw new dimensionislessthan3exception();
            }
            if (players.size() != (dimension-1) ) {
                throw new minimunmplayersrequiredshouldbe1lessthansizeofboardexception();
            }
        }

        private void ValidateUniqueSymbolForPlayers() throws SymbolsNotUniqueException {
            Set<Character> symbols = new HashSet<>();
            for (Player player : players) {
                if (symbols.contains(player.getSymbol())) {
                    throw new SymbolsNotUniqueException();
                }
                symbols.add(player.getSymbol());
            }

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