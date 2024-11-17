package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Korisnik {

    private final int korisnik_id;
    private String ime_korisnika;
    private String prezime;
    private String username;
    private String password;

    public Korisnik(int user_id, String first_name, String prezime, String username, String password) {
        this.korisnik_id = user_id;
        this.ime_korisnika = first_name;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

}
