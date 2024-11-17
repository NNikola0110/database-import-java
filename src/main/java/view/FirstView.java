package view;

import controller.LogInControl;
import controller.SignUpAction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import model.utility.JDBCUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;


@Setter
@Getter
public class FirstView extends VBox {

    private Image image;
    private Image image2;
    private ImageView imageView2;
    private String imageurl= "spce.jpg";
    private String image2url= "rocket.gif";
    private BackgroundImage backgroundImage;
    private BackgroundSize backgroundSize;

    private VBox vBox;
    private HBox hBox1;
    private HBox hBox2;
    private HBox hBox3;

    private Label usernameLabel;
    private Label passwordLabel;
    private TextField tfUsername;
    private PasswordField passwordField;
    private Button logIn;
    private Hyperlink signUpLink;

    public FirstView() {
        initElements();
        addElements();
        addAction();


    }

    private void initElements(){
        image=new Image(imageurl,true);

         backgroundSize = new BackgroundSize(
                 1.0,
                 1.0,
                 true,
                 true,
                 false,
                 true
        );
        backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                backgroundSize
        );


        image2=new Image(image2url);
        imageView2=new ImageView(image2);
        imageView2.setFitWidth(50);
        imageView2.setPreserveRatio(true);

        vBox=new VBox();
        hBox1=new HBox();
        hBox2=new HBox();
        hBox3=new HBox();
        usernameLabel =new Label("Username");
        usernameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: grey;");

        passwordLabel=new Label("Password");
        passwordLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-text-fill: grey;");

        tfUsername =new TextField();
        tfUsername.setPromptText("Username");
        passwordField= new PasswordField();
        passwordField.setPromptText("Password");
        logIn = new Button("Log in");
        signUpLink =new Hyperlink("Sign up");


    }

    private void addElements(){
        setBackground(new Background(backgroundImage));
        hBox1.getChildren().addAll(usernameLabel, tfUsername);
        hBox1.setSpacing(48);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(passwordLabel,passwordField);
        hBox2.setSpacing(20);
        hBox2.setAlignment(Pos.CENTER);
        signUpLink.setTextAlignment(TextAlignment.CENTER);
        getChildren().addAll(imageView2,hBox1,hBox2,hBox3, logIn, signUpLink);
        setSpacing(10);
        setAlignment(Pos.CENTER);


    }

    private void addAction(){
        signUpLink.setOnAction(new SignUpAction());
        logIn.setOnAction(new LogInControl());
    }

}
