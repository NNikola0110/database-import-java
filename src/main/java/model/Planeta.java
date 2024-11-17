package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Planeta {
    private int planetaId;
    private String imePlanete;
    private float udaljenostOdZvezde;
    private float minTemperatura;
    private float maxTemperatura;
    private float procenatKiseonika;
    private float procenatGasa;
    private float maxGrav;
    private float brzinaOrbitiranja;
    private int smrtnost;
    private boolean nastanjivost;

    public Planeta(int planetaId, String imePlanete, float udaljenostOdZvezde, float minTemperatura, float maxTemperatura, float procenatKiseonika, float procenatGasa, float maxGrav, float brzinaOrbitiranja, int smrtnost, boolean nastanjivost) {
        this.planetaId = planetaId;
        this.imePlanete = imePlanete;
        this.udaljenostOdZvezde = udaljenostOdZvezde;
        this.minTemperatura = minTemperatura;
        this.maxTemperatura = maxTemperatura;
        this.procenatKiseonika = procenatKiseonika;
        this.procenatGasa = procenatGasa;
        this.maxGrav = maxGrav;
        this.brzinaOrbitiranja = brzinaOrbitiranja;
        this.smrtnost = smrtnost;
        this.nastanjivost = nastanjivost;
    }

}

