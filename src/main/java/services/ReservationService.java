package services;

import models.Reservation;
import models.Restaurant;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class ReservationService implements IService<Reservation> {
        private Connection connection;
        private PreparedStatement pst;
        public ReservationService (){

            connection = Database.getInstance().getConnection();

        }

        @Override
        public void ajouter(Reservation  reservation) throws SQLException {
       /* String sql = "insert into reservation (NomClient, DateResev,NBper,StatRes) " +
                "values('" + reservation.getNomClient() + "','" + reservation.getDateResev() + ""
                +  "," + reservation.getNBper() + ","+reservation.getStatRes()+ ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);*/

            String req = "INSERT INTO reservation (NomClient,DateResev,NBper,StatRes) values(?,?,?,?)";
            try {
                pst = connection.prepareStatement(req);
                pst.setString(1, reservation.getNomClient());
                pst.setString(2, reservation.getDateResev());
                pst.setInt(3, reservation.getNBper());
                pst.setString(4, reservation.getStatRes());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(services.ReservationService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        @Override
        public void modifier(Reservation reservation) throws SQLException {
            String sql = "update reservation set NomClient = ?, DateResev = ?,NBper = ?,StatRes=?  where idR = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reservation.getNomClient());
            preparedStatement.setString(2, reservation.getDateResev());
            preparedStatement.setInt(3,reservation.getNBper());
            preparedStatement.setString(4,reservation.getStatRes());
            preparedStatement.setInt(5,reservation.getIdR());
            preparedStatement.executeUpdate();

        }

        @Override
        public void supprimer(int idR) throws SQLException {
            String req = "DELETE FROM `reservation` WHERE idR=?";
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,idR);
            preparedStatement.executeUpdate();

        }

        @Override
        public List<Reservation> recuperer() throws SQLException {
            String sql = "select * from reservation";
            Statement statement = connection.createStatement();

            ResultSet rs1 = statement.executeQuery(sql);
            List<Reservation> list = new ArrayList<>();
            while (rs1.next()){
                Reservation r = new Reservation();
                r.setidR(rs1.getInt("idR"));
                r.setNomClient(rs1.getString("NomClient"));
                r.setDateResev(rs1.getString("DateReserv"));
                r.setNBper(rs1.getInt("NBper"));
                r.setStatRes(rs1.getString("StatRes"));
                list.add(r);

            }
            return list;
        }
    }


