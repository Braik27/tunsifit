package models;

public class Restaurant {
    int id ;
    String nom ;
    String adresse;
     String type ;

    public Restaurant(int id, String nom, String adresse, String type) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
    }

    public Restaurant() {

    }
    public Restaurant(String nom, String adresse, String type) {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
