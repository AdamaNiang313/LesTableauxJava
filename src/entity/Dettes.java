package entity;

import java.util.Objects;

public class Dettes {
    private int id;
    private float montantDette;
    private float montantPaye;
    private float montantRestant;
    private static int nombreDettes;
    

    public Dettes() {
        id = ++nombreDettes;
    }

    public Dettes(int id, float montantDette, float montantPaye, float montantRestant) {
        this.id = id;
        this.montantDette = montantDette;
        this.montantPaye = montantPaye;
        this.montantRestant = montantRestant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontantDette() {
        return montantDette;
    }

    public void setMontantDette(float montantDette) {
        this.montantDette = montantDette;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public float getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(float montantRestant) {
        this.montantRestant = montantRestant;
    }

    @Override
    public String toString() {
        return "Dettes{" +
                "id=" + id +
                ", montantDette=" + montantDette +
                ", montantPaye=" + montantPaye +
                ", montantRestant=" + montantRestant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dettes dettes = (Dettes) o;
        return id == dettes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
