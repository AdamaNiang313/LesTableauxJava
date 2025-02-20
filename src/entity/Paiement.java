package entity;

public class Paiement {
    private String date;
    private float montant;

    public Paiement() {
    }

    public Paiement(String date, float montant) {
        this.date = date;
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "date='" + date + '\'' +
                ", montant=" + montant +
                '}';
    }



}
