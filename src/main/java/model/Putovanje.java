package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Putovanje {
    private final int putovanje_id;
    private final int kupovina_id;
    private LocalDate datum_polaska;
    private String sifra;

    public Putovanje(int putovanje_id, int kupovina_id, LocalDate datum_polaska, String sifra) {
        this.putovanje_id = putovanje_id;
        this.kupovina_id = kupovina_id;
        this.datum_polaska = datum_polaska;
        this.sifra = sifra;
    }
}
