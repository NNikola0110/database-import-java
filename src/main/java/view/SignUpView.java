package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpView extends VBox {

    private Image image;
    private String imageurl= "grayColore.png";
    private BackgroundImage backgroundImage;
    private BackgroundSize backgroundSize;
    private Button btnRegister;
    private Label namelbl;
    private Label surnamelbl;
    private Label usernamelbl;
    private Label passwordlbl;
    private TextField tfname;
    private TextField tfsurname;
    private TextField tfusername;
    private TextField tfpassword;

    private Label signUpText;

    private HBox hb1;
    private HBox hb2;
    private HBox hb3;
    private HBox hb4;

    
    public SignUpView() {
        initElements();
        addElements();
        addAction();
    }
    private void initElements() {

        signUpText=new Label("Sign up");
        signUpText.setStyle("-fx-font-size: 40px; -fx-font-weight: bold;-fx-text-fill: white;");

        btnRegister=new Button("Register");

        namelbl=new Label("First name");
        surnamelbl=new Label("Last name");
        usernamelbl=new Label("Username");
        passwordlbl=new Label("Password");

        namelbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-text-fill: white;");
        surnamelbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-text-fill: white;");
        usernamelbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-text-fill: white;");
        passwordlbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-text-fill: white;");

        tfname=new TextField();
        tfname.setPromptText("First name");
        tfsurname=new TextField();
        tfsurname.setPromptText("Last name");
        tfusername=new TextField();
        tfusername.setPromptText("Username");
        tfpassword=new TextField();
        tfpassword.setPromptText("Password");


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

        hb1=new HBox();
        hb2=new HBox();
        hb3=new HBox();
        hb4=new HBox();
    }

    private void addElements() {
        setBackground(new Background(backgroundImage));
        hb1.getChildren().addAll(namelbl,tfname);
        hb2.getChildren().addAll(surnamelbl,tfsurname);
        hb3.getChildren().addAll(usernamelbl,tfusername);
        hb4.getChildren().addAll(passwordlbl,tfpassword);

        hb1.setSpacing(55);
        hb2.setSpacing(32);
        hb3.setSpacing(23);
        hb4.setSpacing(27);

        hb1.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);
        hb3.setAlignment(Pos.CENTER);
        hb4.setAlignment(Pos.CENTER);

        btnRegister.setAlignment(Pos.CENTER);

        getChildren().addAll(signUpText,hb1,hb2,hb3,hb4,btnRegister);
        setSpacing(20);
        setAlignment(Pos.CENTER);
        
    }
    private void addAction() {
    }


}
