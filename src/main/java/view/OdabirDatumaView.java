package view;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Planeta;
import model.utility.JDBCUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class OdabirDatumaView extends VBox {

    private TextField departureDateField;
    private TextField codeField;
    private Button confirmButton;
    private String selectedObject;

    private Button dodajPutnika;

    public OdabirDatumaView(String selectedObject) {
        this.selectedObject = selectedObject;
        setPrefSize(400, 200);
        setPadding(new Insets(10));

        Label departureDateLabel = new Label("Departure Date (YYYY-MM-DD):");
        departureDateField = new TextField();
        Label codeLabel = new Label("Code:");
        codeField = new TextField();
        confirmButton = new Button("Confirm");
        dodajPutnika= new Button("Dodaj putnika");

        getChildren().addAll(departureDateLabel, departureDateField, codeLabel, codeField, confirmButton,dodajPutnika);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String departureDate = departureDateField.getText();
                String code = codeField.getText();

                Date departure = Date.valueOf(departureDate);

                JDBCUtils.registerTrip(getKupovinaId(selectedObject), departure, code);

                PregledView reviewForm = new PregledView();
                Stage stage = new Stage();
                stage.setScene(new Scene(reviewForm));
                stage.show();
                getScene().getWindow().hide();
            }
        });
        dodajPutnika.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                App.window.close();
                App.window = new Stage();
                App.window.setScene(new Scene(new DodajPutnikaView(), 500, 300));
                App.window.show();
            }
        });
    }

    private int getKupovinaId(String objectAddress) {
        /*List<Objekat> objects = JDBCUtils.getObjectsByPlanetId();
        for (Objekat objekat : objects) {
            if (objekat.getAdresa().equals(objectAddress)) {
                return objekat.getObjekatId();
            }
        }*/
        return -1;
    }

    private int getPlanetaId(String planetName) {
        List<Planeta> planets = JDBCUtils.getHabitablePlanets();
        for (Planeta planet : planets) {
            if (planet.getImePlanete().equals(planetName)) {
                return planet.getPlanetaId();
            }
        }
        return -1;
    }
}
