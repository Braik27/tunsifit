package models;

public class Table {
   int idT;
   String nomTable;
   int nbdeper;
   String heureDebut;
   String heureFin;
   String nom;
   int mobile;
   String adresseEmail;
   String message;

    public Table(int idT, String nomTable, int nbdeper, String heureDebut, String heureFin, String nom, int mobile, String adresseEmail, String message) {
        this.idT = idT;
        this.nomTable = nomTable;
        this.nbdeper = nbdeper;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nom = nom;
        this.mobile = mobile;
        this.adresseEmail = adresseEmail;
        this.message = message;
    }

    public Table(String nomTable, int nbdeper, String heureDebut, String heureFin, String nom, int mobile, String adresseEmail, String message) {
        this.nomTable = nomTable;
        this.nbdeper = nbdeper;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nom = nom;
        this.mobile = mobile;
        this.adresseEmail = adresseEmail;
        this.message = message;
    }

    public Table() {

    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getNomTable() {
        return nomTable;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }

    public int getNbdeper() {
        return nbdeper;
    }

    public void setNbdeper(int nbdeper) {
        this.nbdeper = nbdeper;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Table{" +
                "idT=" + idT +
                ", nomTable='" + nomTable + '\'' +
                ", nbdeper=" + nbdeper +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", nom='" + nom + '\'' +
                ", mobile=" + mobile +
                ", adresseEmail='" + adresseEmail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
