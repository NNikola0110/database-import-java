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
import model.Objekat;
import model.Planeta;
import model.utility.JDBCUtils;

import java.util.List;

public class OdabirObjektaView extends VBox {

    private ComboBox<String> objectComboBox;
    private Button purchaseButton;
    private String selectedPlanet;

    public OdabirObjektaView(String selectedPlanet) {
        this.selectedPlanet = selectedPlanet;
        setSpacing(10);
        setPadding(new Insets(10));

        Label objectLabel = new Label("Select Object:");
        objectComboBox = new ComboBox<>();
        purchaseButton = new Button("Purchase");

        getChildren().addAll(objectLabel, objectComboBox, purchaseButton);

        initComboBox();
        addAction();
    }

    private void initComboBox() {
        List<Objekat> objects = JDBCUtils.getObjectsByPlanetId(getPlanetIdByName(selectedPlanet));
        ObservableList<String> objectNames = FXCollections.observableArrayList();
        for (Objekat object : objects) {
            objectNames.add(object.getAdresa());
        }
        objectComboBox.setItems(objectNames);
    }

    private void addAction() {
        purchaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedObject = objectComboBox.getValue();
                OdabirDatumaView dateForm = new OdabirDatumaView(selectedObject);
                Stage stage = new Stage();
                stage.setScene(new Scene(dateForm));
                stage.show();
                getScene().getWindow().hide();
                getScene().getWindow().hide();
            }
        });
    }

    private int getPlanetIdByName(String planetName) {
        List<Planeta> planets = JDBCUtils.getHabitablePlanets();
        for (Planeta planet : planets) {
            if (planet.getImePlanete().equals(planetName)) {
                return planet.getPlanetaId();
            }
        }
        return -1;
    }
}
