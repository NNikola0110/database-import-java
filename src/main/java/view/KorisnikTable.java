package view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

import model.Korisnik;


public class KorisnikTable extends TableView<Korisnik> {
    public KorisnikTable(List<Korisnik> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Korisnik, Integer> tcKorisnikId = new TableColumn<>("ID");
        TableColumn<Korisnik, String> tcImeKorisnika = new TableColumn<>("Ime korisnika");
        TableColumn<Korisnik, String> tcPrezime = new TableColumn<>("Prezime");
        TableColumn<Korisnik, String> tcUsername = new TableColumn<>("Username");
        TableColumn<Korisnik, String> tcPasword = new TableColumn<>("Password");

        tcKorisnikId.setCellValueFactory(new PropertyValueFactory<>("korisnikId"));
        tcImeKorisnika.setCellValueFactory(new PropertyValueFactory<>("imeKorisnika"));
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcPasword.setCellValueFactory(new PropertyValueFactory<>("password"));

        super.getColumns().add(tcKorisnikId);
        super.getColumns().add(tcImeKorisnika);
        super.getColumns().add(tcPrezime);
        super.getColumns().add(tcUsername);
        super.getColumns().add(tcPasword);
    }
}
