package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Restaurant;
import services.RestaurantService;

import java.sql.SQLException;

public class ModifierRestaurant {
    @FXML
    private TextField adressetextfield;

    @FXML
    private TextField nomtextfield;

    @FXML
    private TextField typetextfield;
    @FXML
    private Label label;
    AfficherRestaurant aff;
    RestaurantService rs= new RestaurantService();
    @FXML
    private void modifier(MouseEvent event) throws SQLException {
        Restaurant cs = new Restaurant(Integer.valueOf(label.getText()),nomtextfield.getText(), adressetextfield.getText(),typetextfield.getText());
        System.out.println(cs);

        rs.modifier(cs);

    }
    void setMainController(AfficherRestaurant aThis) {
        aff=aThis;
    }

    void setData(String id,String nom,String adresse,String type ){
        this.label.setText(id);
        this.nomtextfield.setText(nom);
        this.adressetextfield.setText(adresse);
        this.typetextfield.setText(type);

    }

}
