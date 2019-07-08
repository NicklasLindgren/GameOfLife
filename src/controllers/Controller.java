/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 * Controller Class responsible for the communication between the view and the models.
 */

package controllers;
import models.GameModel;
import views.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controller implements ActionListener {

    View view;
    GameModel model;

    public Controller(GameModel model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {
        for (int i = 0; i < view.cells.length; i++)
            view.cells[i].addActionListener(this);
        view.nextGenButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getName());
        switch(((JButton) e.getSource()).getName()) {
            case "Next":
                model.simulateNextGen();
                this.view.redrawButtons(this.model.getBoardMap());
                break;
            default:
                int y = (((JButton) e.getSource()).getX())/((JButton) e.getSource()).getWidth();
                int x = (((JButton) e.getSource()).getY())/((JButton) e.getSource()).getHeight();
                this.model.cellClicked(x,y);
                this.view.redrawButtons(this.model.getBoardMap());
        }
    }
}