package model;

import database.CRUD;
import database.ComfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {
    @Override
    public Object insert(Object object) {
        //1.Abrimos la conexion
        Connection objConnection = ComfigDB.openConnection();

        //2.Castear el objeto
        Coder objCoder = (Coder) object;
        try{
            //Escribimos el sql
            String sql = "INSERT INTO coder (name,age,clan) VALUE(?,?,?)";

            //Preparar el Statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //Asignar los signos de interrogacion

            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());

            //Ejecutamos el query
            objPrepare.execute();

            //Obtener el resultado
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }
            //Cerramos el prepareStatement
            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Coder insertion was  successful");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding coder"+ e.getMessage());

        }
        //Cerramos la conexion
        ComfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public boolean update(Object object) {


        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List<Object> finAll() {
        //1.Abrir la conexion
        Connection objConnection = ComfigDB.openConnection();
        //2.Inicializar la lista donde se guardaran los registros que devuelve la base de datos
        List<Object> listCoders = new ArrayList<>();

        try{
            //3. Escribir la sentencia SQL
            String sql = "SELECT * FROM coder ORDER BY coder.id ASC;";

            //4.Utilizar PrepareStatemet
            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);
            //5.Ejecutar el prepareStatement
            ResultSet  objResult = (ResultSet) objPrepareStatement.executeQuery();
            //6.Obtener resultados
            while(objResult.next()){
               Coder objCoder = new Coder();
               objCoder.setId(objResult.getInt("id"));
               objCoder.setName(objResult.getString("name"));
               objCoder.setAge(objResult.getInt("age"));
               objCoder.setClan(objResult.getString("clan"));

               //Finalmente agregamos el coder a la lista

                listCoders.add(objCoder);
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data adquisition error");
        }
        //7.Cerramos la conexion
        ComfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public Object findById(int id) {
        Connection objConnection = ComfigDB.openConnection();
        Coder objCoder = new Coder();



        try {
            String sql = "SELECT * FROM coder WHERE id = "+ id +";";

            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();


                boolean resultadoId = objResult.next();

                if(!resultadoId) {
                    JOptionPane.showMessageDialog(null,"Id no encontrado");
                    return null;
                }else {

                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));


            }




        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data adquisition error");
            System.out.println(e.getMessage());


        }
        ComfigDB.closeConnection();

        return objCoder;

    }

    public List<Object> findName(String name) {
        Connection objConnection = ComfigDB.openConnection();

        List<Object> listCoders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE name LIKE '%" + name + "%';";

            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();
            System.out.println(objResult.next());

            while (objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                listCoders.add(objCoder);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data adquisition error");


        }
        ComfigDB.closeConnection();

        return listCoders;
    }
}





