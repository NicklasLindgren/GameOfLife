/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 * View class responsible for adding Java Swing components and drawing the game/simulation
 */
package views;
import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

    private GridLayout buttonGrid = new GridLayout(1,2);
    private GridLayout boardGrid;
    private  int boardSize;
    public JButton[] cells;
    public JButton nextGenButton = new JButton("Next Gen");

    public View(int dimension) {
        this.boardSize = dimension;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane();
    }

    public void addComponentsToPane() {
        final JFrame mainPanel = new JFrame();
        final JPanel buttonPanel = new JPanel();
        final JPanel gridPanel = new JPanel();
        boardGrid = new GridLayout(this.boardSize, this.boardSize);
        gridPanel.setLayout(boardGrid);
        cells = new JButton[(boardSize*boardSize)];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new JButton();
            cells[i].setBackground(Color.white);
            cells[i].setName("CellModel");
            gridPanel.add(cells[i]);
        }
        nextGenButton.setName("Next");
        buttonPanel.setLayout(buttonGrid);
        buttonPanel.add(nextGenButton);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);
        mainPanel.add(gridPanel,BorderLayout.CENTER);
        mainPanel.pack();
        mainPanel.setSize(900,900);
        mainPanel.setResizable(false);
        mainPanel.setVisible(true);
    }

    public void redrawButtons(boolean[] map) {
        for ( int j=0; j<map.length; j++) {
            if(map[j])
                cells[j].setBackground(Color.black);
            else
                cells[j].setBackground(Color.white);
        }
    }
}