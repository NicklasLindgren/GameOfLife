/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 * Class for representing a single cell, with methods for changing and getting the state of the cell.
 */
package models;

public class CellModel {

    private boolean isAlive;

    public CellModel(){
        this.isAlive = false;
    }

    public void setCell(boolean state){
        this.isAlive = state;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void toggleCell() {
        if(this.isAlive)
            this.isAlive = false;
        else
            this.isAlive = true;
    }
}
