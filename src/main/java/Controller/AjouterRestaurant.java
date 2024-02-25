package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Restaurant;
import services.RestaurantService;

public class AjouterRestaurant {

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

    @FXML
    void AjouterRestaurant(ActionEvent event)
            throws IOException
    {
        Restaurant restaurant=new Restaurant(nomtextfield.getText(),adressetextfield.getText(),typetextfield.getText());
        RestaurantService restaurantService=new RestaurantService();

        try {
            restaurantService.ajouter(restaurant);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("le restaurant ajoutée");
            alert.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Restaurantinfo.fxml"));
            try {
                Parent root = loader.load();
                Restaurantinfo restaurantinfo = loader.getController();
                restaurantinfo.setNomtextfield(nomtextfield.getText());
                restaurantinfo.setAdressetextfield(adressetextfield.getText());
                restaurantinfo.setTypetextfield(typetextfield.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    @FXML
    void initialize() {


    }

}
