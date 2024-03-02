package test;

import models.Reservation;
import models.Restaurant;
import models.Table;
import services.ReservationService;
import services.RestaurantService;
import services.TableService;
import utils.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String [] args){
   //  Database d = Database.getInstance();
       /* RestaurantService rs = new RestaurantService();
        try {
           // rs.ajouter(new Restaurant("Bowly","Rue Ahmed Tlili, Ariana","healthy food"));
            rs.ajouter(new Restaurant("Sabato","nabeul","sandwish"));
          // rs.modifier(new Restaurant(4,"elbey","bardo","fastfood"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
       /* ReservationService rs = new ReservationService();
        try {
             rs.ajouter(new Reservation("ahmed","2020-5-20",6,"comfirmée"));
            //rs.ajouter(new Reservation("Ali","2021-6-12",10,"annuler"));
            //rs.modifier(new Reservation(2,"elbey","2023-10-25",12,"confirmée"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
        TableService rs = new TableService();
        try {
            //rs.ajouter(new Table("table 27",8,"12","15","sawssen",95939391,"saw@gmail.com","table vue sur mer"));
            //rs.ajouter(new Reservation("Ali","2021-6-12",10,"annuler"));
            rs.modifier(new Table(1,"table 100",5,"12","14","htab",95939391,"saw@gmail.com","aaa"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }





    }
}
