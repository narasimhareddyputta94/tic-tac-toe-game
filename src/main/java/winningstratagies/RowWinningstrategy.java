package winningstratagies;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningstrategy implements WinningStrategy{

    Map<Integer, Map<Character,Integer>> map = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();

        if(map.containsKey(row)) {
            Map<Character, Integer> rowMap = map.get(row);
            if (rowMap.containsKey(symbol)) {
                rowMap.put(symbol, rowMap.get(symbol) + 1);
            } else {
                rowMap.put(symbol, 1);
            }
        }
        else{
            Map<Character, Integer> rowMap = new HashMap<>();
            rowMap.put(symbol, 1);
            map.put(row, rowMap);
        }


        // check if the row is full

        if(map.get(row).get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    }
}
