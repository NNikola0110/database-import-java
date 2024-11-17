package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Objekat {

    private int objekatId;
    private int planetaId;
    private String adresa;
    private int kapacitet;
    private float cena;

    public Objekat(int objekatId, int planetaId, String adresa, int kapacitet, float cena) {
        this.objekatId = objekatId;
        this.planetaId = planetaId;
        this.adresa = adresa;
        this.kapacitet = kapacitet;
        this.cena = cena;
    }

}
