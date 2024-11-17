package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Planeta;
import model.utility.JDBCUtils;

import java.util.List;

public class OdabirPlaneteView extends VBox {

    private ComboBox<String> planetComboBox;
    private Button selectButton;
    private Label planetLabel;

    public OdabirPlaneteView() {
        initElements();
        addElements();
        addAction();
    }

    private void initElements() {
        setSpacing(10);
        setPadding(new Insets(10));

        planetLabel = new Label("Select Planet:");
        planetComboBox = new ComboBox<>();
        selectButton = new Button("Select");

        initComboBox();
    }

    private void addElements() {
        getChildren().addAll(planetLabel, planetComboBox, selectButton);
    }

    private void addAction() {
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedPlanet = planetComboBox.getValue();
                OdabirObjektaView objectForm = new OdabirObjektaView(selectedPlanet);
                Stage stage = new Stage();
                stage.setScene(new Scene(objectForm));
                stage.show();
                getScene().getWindow().hide();
                getScene().getWindow().hide();
            }
        });
    }

    private void initComboBox() {
        List<Planeta> planets = JDBCUtils.getHabitablePlanets();
        ObservableList<String> planetNames = FXCollections.observableArrayList();
        for (Planeta planet : planets) {
            planetNames.add(planet.getImePlanete());
        }
        planetComboBox.setItems(planetNames);
    }
}
