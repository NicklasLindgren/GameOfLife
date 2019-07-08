package testcases;

import models.CellModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellModelTest {
    private CellModel cell = new CellModel();

    @Test
    public void setCell() {
        cell.setCell(true);
        assertEquals("Checking changed value of cell", true, cell.isAlive());
    }

    @Test
    public void isAlive() {
        assertEquals("Checking isAlive Method", false, cell.isAlive());
        cell.setCell(true);
        assertEquals("Checking isAlive Method", true, cell.isAlive());
    }

    @Test
    public void toggleCell() {
        cell.setCell(true);
        cell.toggleCell();
        assertEquals("Checking ToggleCell Method", false, cell.isAlive());

    }
}