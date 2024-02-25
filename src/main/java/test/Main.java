package test;

import models.Restaurant;
import services.RestaurantService;
import utils.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String [] args){
    // Database d = Database.getInstance();
        RestaurantService rs = new RestaurantService();
        try {
           // rs.ajouter(new Restaurant("Bowly","Rue Ahmed Tlili, Ariana","healthy food"));
            //rs.ajouter(new Restaurant("Sabato","nabeul","sandwish"));
            rs.modifier(new Restaurant(4,"elbey","bardo","fastfood"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }





    }
}
