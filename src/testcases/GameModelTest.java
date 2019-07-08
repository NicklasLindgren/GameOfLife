package testcases;

import models.GameModel;

import static org.junit.Assert.*;

public class GameModelTest {

    private int dimension = 10;
    private int negativeDimension = -10;
    private GameModel gameModel = new GameModel(dimension);
    private GameModel gameModel2 = new GameModel(negativeDimension);

    @org.junit.Before
    public void init(){

    }

    @org.junit.Test
    public void testDimension() {
        assertEquals("Checking size of GameModel", (dimension*dimension), gameModel.getBoardMap().length);
    }

    @org.junit.Test
    public void testNegativeDimension() {
        assertEquals("Checking size of GameModel with negative dimension", (negativeDimension*negativeDimension), gameModel2.getBoardMap().length);
    }

}