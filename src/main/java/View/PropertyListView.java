package View;

import Controller.MainMenuController;
import Model.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class PropertyListView {
    private ObservableList<Property> properties;

    public PropertyListView(List<Property> properties) {
        this.properties = FXCollections.observableArrayList(properties);
    }

    public void start(Stage primaryStage, List<Property> properties1) {
        this.properties = FXCollections.observableArrayList(properties1);
        ListView<Property> listView = new ListView<>(properties);

        // Add numbering to the properties in the list
        listView.setCellFactory(param -> new ListViewCell());

        Button button = new Button("Go Back to Main Menu");
        button.setOnAction(event -> {
            MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
            try {
                mainMenuController.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        HBox hbox = new HBox(button);
        hbox.setPadding(new Insets(10, 0, 0, 0));

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f2f2f2"), CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.getChildren().addAll(new Text(""), listView, hbox);

        Text title = new Text("Property List");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.web("#0076a3"));

        BorderPane root = new BorderPane();
        root.setCenter(vbox);
        root.setTop(title);
        root.setPadding(new Insets(10, 30, 10, 30));

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Define a ListViewCell class to display properties with numbering
    private class ListViewCell extends javafx.scene.control.ListCell<Property> {
        @Override
        protected void updateItem(Property item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
            } else {
                int index = getIndex() + 1;
                Label label = new Label(index + ". " + item.toString());
                setGraphic(label);
            }
        }
    }
}
