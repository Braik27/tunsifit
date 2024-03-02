package models;


public class Reservation {
    int idR ;
    String NomClient ;
    String  DateResev;
    int NBper;
    String StatRes ;

    public Reservation(int idR, String nomClient, String dateResev, int NBper, String statRes) {
        this.idR = idR;
        this.NomClient = nomClient;
        this.DateResev = dateResev;
        this.NBper = NBper;
        this.StatRes = statRes;
    }

    public Reservation(String nomClient, String dateResev, int NBper, String statRes) {
        this.NomClient = nomClient;
        this.DateResev = dateResev;
        this.NBper = NBper;
        this.StatRes = statRes;
    }

    public Reservation() {

    }

    public int getIdR() {
        return idR;
    }

    public void setidR(int idR) {
        this.idR = idR;
    }

    public String getNomClient() {
        return NomClient;
    }

    public void setNomClient(String nomClient) {
        NomClient = nomClient;
    }

    public String getDateResev() {
        return DateResev;
    }

    public void setDateResev(String dateResev) {
        DateResev = dateResev;
    }

    public int getNBper() {
        return NBper;
    }

    public void setNBper(int NBper) {
        this.NBper = NBper;
    }

    public String getStatRes() {
        return StatRes;
    }

    public void setStatRes(String statRes) {
        StatRes = statRes;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Reservation{" +
                "idR=" + idR +
                ", NomClient='" + NomClient + '\'' +
                ", DateResev='" + DateResev + '\'' +
                ", NBper=" + NBper +
                ", StatRes='" + StatRes + '\'' +
                '}';
    }
}
