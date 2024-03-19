package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class ComfigDB {
    //Variable que va a contener el estado de la conexión

    static Connection objConnection = null;

    //Metodo para establecer conexión entre java y la base de datos

    public static Connection openConnection() {
        try {
            //Class forname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "";

            //EStablecemos la conexion
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecte perfectamente !!!!");

        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no instalado");
        } catch (SQLException e) {
            System.out.println("Error >> No se pudo establecer una conexión con la  base de datos");
        }

        return objConnection;
    }


    public static void closeConnection(){
        try{
            if(objConnection != null) objConnection.close();

        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());

        }
    }
}
