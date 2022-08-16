package Db_Handlers;
import java.sql.*;

public class Db_handler {
    Connection connection;

    public Db_handler(){
        try{
            String path = "jdbc:sqlite:src//Db_Handlers//banque_sang.db";

            this.connection=DriverManager.getConnection(path);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet execute_select(String query){
        ResultSet rs=null;
        try{
            Statement statement=this.connection.createStatement();
            rs=statement.executeQuery(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public void execute_update(String query){
        ResultSet rs=null;
        try{
            Statement statement=this.connection.createStatement();
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConn() throws SQLException {
        this.connection.close();
    }

}