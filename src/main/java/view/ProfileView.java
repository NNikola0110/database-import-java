package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProfileView extends GridPane {

    private Label label_name;
    private Label last_name_label;
    private Label user_name;
    private Button btn_pregled_karata_i_nekretnina;

    public ProfileView() {
        initElements();
        addElements();
        addAction();
    }
    public void initElements(){
        label_name=new Label();
        last_name_label=new Label();
        user_name=new Label();
        btn_pregled_karata_i_nekretnina=new Button("Pregledaj svoje kupovine");
    }

    public void addElements(){

    }
    private void addAction(){

    }



}
