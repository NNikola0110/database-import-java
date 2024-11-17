package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SignUpView;
import app.App;

public class SignUpAction implements EventHandler<ActionEvent> {


    public SignUpAction() {

    }

    @Override
    public void handle(ActionEvent event) {

        App.window.close();
        App.window = new Stage();
        App.window.setScene(new Scene(new SignUpView(), 500, 300));
        App.window.show();
    }
}
