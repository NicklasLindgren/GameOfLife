/**
 * Author: Nicklas Lindgren
 * Date: 2019-07-08
 */
import controllers.Controller;
import models.GameModel;
import views.View;

public class Main {
    public static void main(String[] args) {
        int boardSize = 45;
        GameModel model = new GameModel(boardSize);
        View view = new View(boardSize);
        Controller controller = new Controller(model, view);
    }
}