package model.base;

import model.Korisnik;
import model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnik> korisnici = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromKorisnik());
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Collection<Korisnik> korisnici) {
        this.korisnici.clear();
        this.korisnici.addAll(korisnici);
    }
}
