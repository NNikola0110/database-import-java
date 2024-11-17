package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Kupovina;
import model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class PregledView extends VBox {

    private TableView<Kupovina> purchasesTable;
    private Button backButton;

    public PregledView() {

        setPrefSize(800, 400);

        initElements();
        addElements();
        addAction();
    }

    private void initElements() {
        backButton = new Button("Back");
        purchasesTable = new TableView<>();
    }

    private void addElements() {
        getChildren().addAll(purchasesTable, backButton);
    }

    private void addAction() {
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FirstView loginForm = new FirstView();
                loginForm.setVisible(true);
                getScene().getWindow().hide();
            }
        });
    }

    private void populatePurchasesTable() {
        List<Kupovina> purchases = JDBCUtils.getPurchasesByUserId(getLoggedInUserId());
        ObservableList<Kupovina> data = FXCollections.observableArrayList(purchases);

        TableColumn<Kupovina, Integer> purchaseIdColumn = new TableColumn<>("Purchase ID");
        purchaseIdColumn.setCellValueFactory(new PropertyValueFactory<>("kupovinaId"));

        TableColumn<Kupovina, Integer> userIdColumn = new TableColumn<>("User ID");
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("korisnikId"));

        TableColumn<Kupovina, Integer> objectIdColumn = new TableColumn<>("Object ID");
        objectIdColumn.setCellValueFactory(new PropertyValueFactory<>("objekatId"));

        TableColumn<Kupovina, LocalDate> purchaseDateColumn = new TableColumn<>("Purchase Date");
        purchaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("datumKupovine"));

        purchasesTable.setItems(data);
        purchasesTable.getColumns().addAll(purchaseIdColumn, userIdColumn, objectIdColumn, purchaseDateColumn);
    }

    private int getLoggedInUserId() {
        // Implement this method to return the currently logged-in user ID
        // This is a placeholder value
        return 1;
    }
}
