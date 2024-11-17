package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.utility.JDBCUtils;
import view.FirstView;

public class App extends Application {
    public static Stage window;


    @Override
    public void start(Stage primaryStage) throws Exception {
        JDBCUtils.connect();
        window = primaryStage;
        window.setScene(new Scene(new FirstView(), 500, 300));
        window.show();
    }
}
