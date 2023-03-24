/***
 * ............................................................
 *    Project Phase 1 , SOEN 6441
 *    ©(Faraaz, Himangshu, Shivesh)
 *    Written by:
 *                @author Himangshu Shekhar Baruah , Student ID 40229774
 *                @author Ahmad Faraaz Jafri, Student ID 40232742
 *                @author Shivesh Chaudhary, Student ID 40228107
 * ............................................................
 */
package Controller;

import View.AddPropertyMenuView;
import View.MainMenuView;
import com.example.demo6.Main;
import javafx.stage.Stage;

public class MainMenuController {
    private final MainMenuView view;

//    Main main = new Main();

    public MainMenuController(MainMenuView view) {
        this.view = view;
    }

    public void start(Stage primaryStage) throws Exception {
        System.out.println("-------- Welcome to Rental Management System --------");
        int selection = -1;

        view.start(primaryStage, result -> {
            if (result == 1) {
                System.out.println(result);
                AddPropertyMenuController addPropertyMenuController = new AddPropertyMenuController(new AddPropertyMenuView());
                addPropertyMenuController.start(primaryStage);
            } else if (result == 4) {
                System.out.println(Main.properties.get(0));
            }

        });
    }
}
