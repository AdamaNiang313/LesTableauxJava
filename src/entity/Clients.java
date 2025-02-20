package entity;

import java.util.Objects;

public class Clients {
    private int id;
    private String nom;
    private String phone;
    private String adresse;

    //Un attribut navigeable est un attribut que est issu d'une relation
    //OneToMany c'est à dire un objet de type client est associé à plusieurs objets de type dette
    private Dettes[] dettes;
    private int nombreDettes;

    

    public Dettes[] getDettes() {
        return dettes;
    
    }

    public void setNombreDettes(int nombreDettes) {
        this.nombreDettes = nombreDettes;
    }

    public void addDette(Dettes dette){
        dettes[nombreDettes++] = dette;
    }

    public int getNombreDettes() {
        return nombreDettes;
    }

    public Clients() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(phone);
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Clients(int id, String nom, String phone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.phone = phone;
        this.adresse = adresse;
        this.dettes = new Dettes[10];
    }

    public Clients(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", phone='" + phone + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(phone, clients.phone);
    }


}
