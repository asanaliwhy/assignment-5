package Assignment_3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDataAccessObject {
    private Connection connection;

    
    public AirplaneDataAccessObject() {
        try {
            String url = key.getUrl();
            String user = key.getUser();
            String password = key.getPass();
            connection =  DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

   
    public void addAirplane(String name, String model, int age, String status) {
        try {
            String query = "INSERT INTO airplanes (name, model, age, status) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public List<Airplane> getAirplanes(){
        // creating list for all airplanes
        List<Airplane> airplanes = new ArrayList<>();

        try{
            String query = "SELECT * FROM airplanes";

            // by statement, I can get values of fields such us "id", "name" and etc
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int age = resultSet.getInt("age");
                String status = resultSet.getString("status");
                airplanes.add(new Airplane(id, name, model, age, status));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

     
        return airplanes;
    }

    
    public void updateAirplane(int id, String name, String model, int age, String status){
        try {
            String query = "UPDATE airplanes SET name=?, model=?, age=?, status=? WHERE id=?";

            // Same thing as in ADDING Airplanes, but for updating
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Delete airplane
    public void deleteAirplane(int id){
        try{
            String query = "DELETE FROM airplanes WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

  
    public void closeConnection(){
        try {
            // (clearing table) truncate almost the same us DELETE FROM table_name but faster
            String query = "truncate airplanes";
            String queryID = "ALTER SEQUENCE airplanes_id_seq RESTART WITH 1;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryID);

            preparedStatement1.executeUpdate();
            preparedStatement.executeUpdate();

            if (connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("CONNECTION WITH DATABASE CLOSED.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
