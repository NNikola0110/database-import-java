package view;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DodajPutnikaView extends VBox {

    private Label lblIme;
    private Label lblPreziem;
    private TextField tfIme;
    private TextField tfPreziem;

    private HBox hb1;
    private HBox hb2;

    private Button dodajPutnika;
    private Button kupiKartu;


    public DodajPutnikaView() {
        initElements();
        addElements();
        addAction();
    }


    private void initElements(){
        lblIme=new Label("Ime");
        lblPreziem=new Label("Prezime");
        tfIme=new TextField();
        tfIme.setPromptText("Unesi ime");
        tfPreziem=new TextField();
        tfPreziem.setPromptText("Unesi prezime");

        hb1=new HBox();
        hb2=new HBox();

        dodajPutnika=new Button("Dodaj putnika");
        kupiKartu=new Button("Zavrsi kupovinu");
    }

    private void addElements(){
        hb1.getChildren().addAll(lblIme,tfIme);
        hb1.setAlignment(Pos.CENTER);
        hb1.setSpacing(40);

        hb2.getChildren().addAll(lblPreziem,tfPreziem);
        hb2.setAlignment(Pos.CENTER);
        hb2.setSpacing(30);

        this.getChildren().addAll(hb1,hb2,dodajPutnika,kupiKartu);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }

    private void addAction(){
        dodajPutnika.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                App.window.close();
                App.window = new Stage();
                App.window.setScene(new Scene(new DodajPutnikaView(), 500, 300));
                App.window.show();
            }
        });


    //   kupiKartu.setOnAction(new EventHandler<ActionEvent>() {

    //       @Override
    //       public void handle(ActionEvent event) {
    //           App.window.close();
    //           App.window = new Stage();
    //           App.window.setScene(new Scene(new OdabirDatumaView(), 500, 300));
    //           App.window.show();
    //       }
    //   });
    }
}
