package winningstratagies;

import models.Board;
import models.Move;
import winningstratagies.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    // This map will keep track of the count of each player's symbols in each column
    private Map<Integer, Map<Character, Integer>> columnCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        // Initialize column map if not present
        columnCounts.putIfAbsent(col, new HashMap<>());
        Map<Character, Integer> colMap = columnCounts.get(col);

        // Update the count for the symbol in the column
        colMap.put(symbol, colMap.getOrDefault(symbol, 0) + 1);

        // Check if the column has all cells filled with the same symbol
        if (colMap.get(symbol) == board.getDimension()) {
            return true;
        }

        return false;
    }
}
