package models;

import java.util.*;


public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();

        for (int i = 0; i < dimension; i++) {
           board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }

        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                cell.display();
            }
            System.out.println();

        }
    }


    public Cell[] getEmptyCells() {
        List<Cell> emptyCells = new ArrayList<>();
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    emptyCells.add(cell);
                }
            }
        }
        return emptyCells.toArray(new Cell[0]);
    }

    public void setCell(Cell cell, int player) {
        board.get(cell.getRow()).get(cell.getCol()).setCellState(player == 1 ? CellState.FILLED : CellState.EMPTY);
    }

    public boolean checkWin(int i) {
        for (int j = 0; j < dimension; j++) {
            if (board.get(j).get(0).getCellState() == CellState.FILLED && board.get(j).get(1).getCellState() == CellState.FILLED && board.get(j).get(2).getCellState() == CellState.FILLED) {
                return true;
            }
            if (board.get(0).get(j).getCellState() == CellState.FILLED && board.get(1).get(j).getCellState() == CellState.FILLED && board.get(2).get(j).getCellState() == CellState.FILLED) {
                return true;
            }
        }
        if (board.get(0).get(0).getCellState() == CellState.FILLED && board.get(1).get(1).getCellState() == CellState.FILLED && board.get(2).get(2).getCellState() == CellState.FILLED) {
            return true;
        }
        if (board.get(0).get(2).getCellState() == CellState.FILLED && board.get(1).get(1).getCellState() == CellState.FILLED && board.get(2).get(0).getCellState() == CellState.FILLED) {
            return true;
        }
        return false;
    }
}
