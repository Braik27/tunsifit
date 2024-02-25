package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Restaurantinfo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adressetextfield;

    @FXML
    private TextField nomtextfield;

    @FXML
    private TextField typetextfield;

    public void setAdressetextfield(String adressetextfield) {
        this.adressetextfield.setText(adressetextfield);
    }

    public void setNomtextfield(String nomtextfield) {
        this.nomtextfield.setText(nomtextfield);
    }

    public void setTypetextfield(String typetextfield) {
        this.typetextfield.setText(typetextfield);
    }

    @FXML
    void initialize() {

    }

}

