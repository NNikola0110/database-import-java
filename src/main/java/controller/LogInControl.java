package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.OdabirPlaneteView;
import view.SignUpView;
import app.App;

public class LogInControl implements EventHandler<ActionEvent> {


    public LogInControl() {

    }

    @Override
    public void handle(ActionEvent event) {

        App.window.close();
        App.window = new Stage();
        App.window.setScene(new Scene(new OdabirPlaneteView(), 500, 300));
        App.window.show();
    }
}
