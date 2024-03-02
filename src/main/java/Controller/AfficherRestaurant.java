package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Restaurant;
import services.RestaurantService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AfficherRestaurant {

    @FXML
    private TableView<Restaurant> tab_restaurant;
    @FXML
    private TableColumn<Restaurant, Integer> id;


    @FXML
    private TableColumn<Restaurant, String> nom;

    @FXML
    private TableColumn<Restaurant, String> adresse;
    @FXML
    private TableColumn<Restaurant, String> type;

    private final ObservableList<Restaurant> listRestaurant = FXCollections.observableArrayList();




    RestaurantService cs = new RestaurantService();




    public void affichee() {
        try {

            listRestaurant.addAll(cs.recuperer());
        } catch (SQLException ex) {
            ex.getMessage();        }

        id.setCellValueFactory(new PropertyValueFactory<Restaurant, Integer>("id"));

        nom.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("nom"));
       adresse.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("adresse"));
        type.setCellValueFactory(new PropertyValueFactory<Restaurant, String>("type"));
        tab_restaurant.setItems(listRestaurant);

    }


    @FXML
    void initialize() {
        affichee();

    }
    int valeurID() {
        Restaurant ev = tab_restaurant.getSelectionModel().getSelectedItem();

        return ev.getId();
    }
    @FXML
    void supprimer(MouseEvent event) throws SQLException {
        final ObservableList<Restaurant> listResto = FXCollections.observableArrayList();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Vous voulez supprimer resto"+nom+"?");

        ButtonType deleteGame = new ButtonType("Supprimer Resto)");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(deleteGame, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == deleteGame){
            cs.supprimer(valeurID());
            listResto.addAll(cs.recuperer());

            tab_restaurant.setItems(listResto);
        }}
    @FXML
    void modifier(MouseEvent event) {
        Restaurant rs = tab_restaurant.getSelectionModel().getSelectedItem();

        try{

            FXMLLoader loaderr = new FXMLLoader();
            loaderr.setLocation(getClass().getResource("/ModifierRestaurant.fxml"));

            AnchorPane rootLayout = (AnchorPane) loaderr.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            ModifierRestaurant restoController = loaderr.getController();
            restoController.setMainController(this);
            restoController.setData(String.valueOf(rs.getId()),rs.getNom(),rs.getAdresse(),rs.getType());
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }














}