package model;

import entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionHelper {
    Connection connection;

    public void insert(Phone phone) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement statement =connection.prepareStatement("Insert Into phone1(Name,Brand,Price,Description) VALUES (?,?,?,?)");
            statement.setString(1,phone.getName());
            statement.setString(2,phone.getBrand());
            statement.setInt(3,phone.getPrice());
            statement.setString(4,phone.getDescription());
            statement.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Phone> returnList(){
      String  sql = "SELECT* FROM phone1";
      List<Phone> listPhone = new ArrayList<Phone>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet rS = statement.executeQuery();
            while (rS.next()){
                Phone phone = new Phone();
                phone.setName(rS.getString(2));
                phone.setBrand(rS.getString(3));
                phone.setPrice(rS.getInt(4));
                phone.setDescription(rS.getString(5));
                listPhone.add(phone);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listPhone;
    }
}
