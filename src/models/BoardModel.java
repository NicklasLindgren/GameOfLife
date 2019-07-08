/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 * Model class representing the cell-grid.
 * Containing a 2D array of Cells.
 */
package models;

public class BoardModel {

    private CellModel[][] board;
    private int dimension;

    public BoardModel(int i){
        this.dimension = i;
        this.board = new CellModel[i][i];
        for ( int j=0; j<i; j++) {
            for ( int k=0; k<i; k++) {
                board[j][k]=new CellModel();
            }
        }
    }

    public boolean[] getBoardMap() {
        boolean [] map = new boolean [this.board.length*this.board.length];
        int counter = 0;
        for ( int j=0; j<this.board.length; j++) {
            for ( int k=0; k<this.board.length; k++) {
                map[counter] = this.board[j][k].isAlive();
                counter++;
            }
        }
        return map;
    }

    public CellModel[][] clone() {
        CellModel[][] clone = new CellModel[this.dimension][this.dimension];
        for ( int j=0; j<this.dimension; j++) {
            for ( int k=0; k<this.dimension; k++) {
                clone[j][k] = new CellModel();
                clone[j][k].setCell(this.board[j][k].isAlive());
            }
        }
        return clone;
    }

    public void setCell(int x, int y){
        try {
            this.board[x][y].toggleCell();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean isAlive(int x, int y){
        try {
            return this.board[x][y].isAlive();
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String toString(){
        System.out.println(' ');
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if(this.board[i][j].isAlive()){
                    System.out.print(" 0 ");
                }
                else{
                    System.out.print(" x ");
                }
            }
            System.out.println(' ');
        }
        return null;
    }

    public int getDimension() {
        return dimension;
    }
}
