package services;

import models.Restaurant;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantService implements IService<Restaurant> {
    private Connection connection;
    private PreparedStatement pst;
    public RestaurantService (){

        connection = Database.getInstance().getConnection();

    }

    @Override
    public void ajouter(Restaurant restaurant) throws SQLException {
        /*String sql = "insert into restaurant (nom, adresse,type_de_cuisine) " +
                "values('" + restaurant.getNom() + "','" + restaurant.getAdresse() + "'"
                +  "," + restaurant.getType_de_cuisine() + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);*/

        String req = "INSERT INTO restaurant (nom,adresse,type) values(?,?,?)";
        try {
        pst = connection.prepareStatement(req);
        pst.setString(1, restaurant.getNom());
        pst.setString(2, restaurant.getAdresse());
        pst.setString(3, restaurant.getType());
        pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void modifier(Restaurant restaurant) throws SQLException {
        String sql = "update restaurant set nom = ?, adresse = ?, type = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, restaurant.getNom());
        preparedStatement.setString(2, restaurant.getAdresse());
        preparedStatement.setString(3,restaurant.getType());
        preparedStatement.setInt(4,restaurant.getId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM `restaurant` WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Restaurant> recuperer() throws SQLException {
        String sql = "select * from restaurant";
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(sql);
        List<Restaurant> list = new ArrayList<>();
        while (rs.next()){
            Restaurant r = new Restaurant();
            r.setId(rs.getInt("id"));
            r.setAdresse(rs.getString("adresse"));
            r.setNom(rs.getString("nom"));
            r.setType(rs.getString("type"));
            list.add(r);

        }
        return list;
    }
}
