package model;

import database.CRUD;
import database.ComfigDB;
import entity.Coder;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
            Connection objConnection = ComfigDB.openConnection();

            Coder objCoder = (Coder) object;

            boolean isEdit = false;

            try{
                String sql = "UPDATE coder SET name = ?, age = ?,clan = ? where id = ?;";

                PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

                objPrepare.setString(1,objCoder.getName());
                objPrepare.setInt(2,objCoder.getAge());
                objPrepare.setString(3,objCoder.getClan());
                objPrepare.setInt(4,objCoder.getId());

                int totalAffectedRows = objPrepare.executeUpdate();


                if (totalAffectedRows > 0){
                    isEdit = true;
                    JOptionPane.showMessageDialog(null,"The edit was succesfull");

                }

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());

            }
            ComfigDB.closeConnection();


        return isEdit;
    }

    @Override
    public boolean delete(Object object) {
        //1. Convertir el objeto a la entidad que necesito
        Coder objCoder = (Coder) object;
        //2.Variable boolean para medir el estado de la eliminacion
        boolean isDelete = false;
        //3. Abrir la conexion

        Connection objConnection = ComfigDB.openConnection();

        try{
            //4.Escribir la sentencia sql
            String sql = "DELETE FROM coder WHERE id = ?";
            //5. Preparamos el estatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //6. Asignamos el valor al ?
            objPrepare.setInt(1,objCoder.getId());
            //7. ExecuteUpdate devuelve la cantidad de filas afectadas por la sentencia sql
            int totalAffectedRows = objPrepare.executeUpdate();

            if(totalAffectedRows > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"The delete was succesfull");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }
        //8.Cerramos la conexion
        ComfigDB.closeConnection();


        return isDelete;
    }

    @Override
    public List<Object> findAll() {
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





