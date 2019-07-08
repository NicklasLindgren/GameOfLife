package testcases;

import models.BoardModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardModelTest {

    private int dimension = 10;
    private BoardModel boardModel = new BoardModel(dimension);

    @Test
    public void getBoardMap() {
        assertEquals("Checking Dimension of Board", (dimension), boardModel.getDimension());
    }

    @Test
    public void clone1() {
        assertEquals("Checking Dimension of cloned board", (dimension), boardModel.clone().length);
        assertEquals("Checking Initial value of cell", false, boardModel.clone()[0][0].isAlive());
    }

    @Test
    public void setCell() {
        boardModel.setCell(0,0);
        assertEquals("Checking changed value of cloned object", true, boardModel.clone()[0][0].isAlive());
    }

    @Test
    public void isAlive() {
        boardModel.setCell(0,0);
        assertEquals("Checking changed value", true, boardModel.isAlive(0,0));
    }

    @Test
    public void getDimension() {
        assertEquals("Checking Dimension", 10, boardModel.getDimension());
    }
}