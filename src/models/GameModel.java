/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 * GameModel class responsible for handling the game logic and simulating the upcoming generation.
 */

package models;

public class GameModel {
    private BoardModel board;

    public GameModel(int dimension){
        this.board = new BoardModel(Math.abs(dimension));
    }

    public void cellClicked(int x, int y){
        this.board.setCell(x,y);
    }

    public boolean[] getBoardMap() {
        return this.board.getBoardMap();
    }

    // Main method that counts the nr of alive neighbours and finally performs the correct action (Create or Remove) cell from the grid.
    public void simulateNextGen(){
        int [][] nrOfNeighbours = new int [this.board.getDimension()][this.board.getDimension()];
        for (int i = 0; i < this.board.getDimension(); i++) {
            for (int j = 0; j < this.board.getDimension(); j++) {
                int livingNeighbours = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if ((i + k) >= 0 && j + l >= 0 && (i + k) < this.board.getDimension() && j + l < this.board.getDimension()) {
                            if(this.board.isAlive((i + k),(j+l))){
                                livingNeighbours++;
                            }
                        }
                    }
                }
                if(this.board.isAlive((i), (j))){
                    livingNeighbours--;
                }
                nrOfNeighbours[i][j] = livingNeighbours;
            }
        }
        for (int i = 0; i < this.board.getDimension(); i++) {
            for (int j = 0; j < this.board.getDimension(); j++) {
                if(this.board.isAlive((i), (j))){
                    if(this.board.isAlive((i), (j)) && nrOfNeighbours[i][j] < 2){
                        this.board.setCell(i,j);
                    }
                    if(this.board.isAlive((i), (j)) && nrOfNeighbours[i][j] > 3 ){
                        this.board.setCell(i,j);
                    }
                }
                if(!this.board.isAlive((i), (j)) && nrOfNeighbours[i][j] == 3){
                    this.board.setCell(i,j);
                }
            }
        }
    }
}