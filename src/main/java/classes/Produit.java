package classes;

import java.io.Serializable;

public class Produit implements Serializable {
    Long Id ;
    String nom ;
    String marque ;
    Float prix ;
    String description ;
    int nb_stock ;

    public Produit(Long id, String nom, String marque, float prix, String description, int nb_stock) {
        Id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nb_stock = nb_stock;
    }

    public Produit() {

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_stock() {
        return nb_stock;
    }

    public void setNb_stock(int nb_stock) {
        this.nb_stock = nb_stock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + Id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrEnStock=" + nb_stock +
                '}';
    }
}
