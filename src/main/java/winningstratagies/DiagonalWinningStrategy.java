package winningstratagies;

import models.Board;
import models.Move;
import winningstratagies.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    private Map<Character, Integer> mainDiagonalCounts = new HashMap<>();
    private Map<Character, Integer> antiDiagonalCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        int dimension = board.getDimension();

        // Check main diagonal
        if (row == col) {
            mainDiagonalCounts.put(symbol, mainDiagonalCounts.getOrDefault(symbol, 0) + 1);
            if (mainDiagonalCounts.get(symbol) == dimension) {
                return true;
            }
        }

        // Check anti-diagonal
        if (row + col == dimension - 1) {
            antiDiagonalCounts.put(symbol, antiDiagonalCounts.getOrDefault(symbol, 0) + 1);
            if (antiDiagonalCounts.get(symbol) == dimension) {
                return true;
            }
        }

        return false;
    }
}
