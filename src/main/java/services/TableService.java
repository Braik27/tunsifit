package services;

import models.Table;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TableService implements IService<Table> {
    private Connection connection;
    private PreparedStatement pst;
    public TableService (){

        connection = Database.getInstance().getConnection();

    }

    @Override
    public void ajouter(Table  table) throws SQLException {
       /* String sql = "insert into reservation (NomClient, DateResev,NBper,StatRes) " +
                "values('" + reservation.getNomClient() + "','" + reservation.getDateResev() + ""
                +  "," + reservation.getNBper() + ","+reservation.getStatRes()+ ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);*/

        String req = "INSERT INTO `table` (nomTable,nbdeper,heureDebut,heureFin,Nom,mobile,adresseEmail,message) values(?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);
            pst.setString(1, table.getNomTable());
            pst.setInt(2, table.getNbdeper());
            pst.setString(3, table.getHeureDebut());
            pst.setString(4, table.getHeureFin());
            pst.setString(5, table.getNom());
            pst.setInt(6, table.getMobile());
            pst.setString(7, table.getAdresseEmail());
            pst.setString(8, table.getMessage());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(services.ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void modifier(Table table) throws SQLException {
        String sql = "update `table`  set nomTable = ?, nbdeper = ?,heureDebut = ?,heureFin=? ,nom=?,mobile=?,adresseEmail=?,message=?  where idT = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, table.getNomTable());
        preparedStatement.setInt(2, table.getNbdeper());
        preparedStatement.setString(3,table.getHeureDebut());
        preparedStatement.setString(4,table.getHeureFin());
        preparedStatement.setString(5,table.getNom());
        preparedStatement.setInt(6,table.getMobile());
        preparedStatement.setString(7,table.getAdresseEmail());
        preparedStatement.setString(8,table.getMessage());
        preparedStatement.setInt(9, table.getIdT());
        preparedStatement.executeUpdate();

    }



    @Override
    public void supprimer(int idT) throws SQLException {
        String req = "DELETE FROM `table` WHERE idT=?";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1,idT);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Table> recuperer() throws SQLException {
        String sql = "select * from `table` ";
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(sql);
        List<Table> list = new ArrayList<>();
        while (rs.next()){
            Table r = new Table();
            r.setIdT(rs.getInt("idT"));
            r.setNomTable(rs.getString("nomTable"));
            r.setNbdeper(rs.getInt("nbdeper"));
            r.setHeureDebut(rs.getString("heureDebut"));
            r.setHeureFin(rs.getString("heureFin"));
            r.setNom(rs.getString("nom"));
            r.setMobile(rs.getInt("mobile"));
            r.setAdresseEmail(rs.getString("adresseEmail"));
            r.setMessage(rs.getString("message"));
            list.add(r);

        }
        return list;
    }
}



