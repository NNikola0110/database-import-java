package model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Setter
@Getter
public class Kupovina {
    private int kupovinaId;
    private int korisnikId;
    private int objekatId;
    private LocalDate datumKupovine;

    public Kupovina(int kupovinaId, int korisnikId, int objekatId, LocalDate datumKupovine) {
        this.kupovinaId = kupovinaId;
        this.korisnikId = korisnikId;
        this.objekatId = objekatId;
        this.datumKupovine = datumKupovine;
    }
}

