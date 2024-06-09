package models;

import java.util.Scanner;

public class Player {

    private char symbol;
    private String name;
    private int id;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(char symbol, String name, int id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Cell makeMove(Board board) {
    System.out.println(this.name + " make your move enter row and column");
    int row = scanner.nextInt();
    int col = scanner.nextInt();

    while(validateMove(row,col,board)){
        System.out.println("Invalid move, try again");
        row = scanner.nextInt();
        col = scanner.nextInt();
    }

    board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
    board.getBoard().get(row).get(col).setPlayer(this);
    return board.getBoard().get(row).get(col);


}

    private boolean validateMove(int row, int col, Board board) {
        if(row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension()){
            return false;
        }
        if(!CellState.EMPTY.equals(board.getBoard().get(row).get(col).getCellState())){
            return false;
        }
        return true;
    }
    }


