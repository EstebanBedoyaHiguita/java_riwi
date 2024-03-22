package model;

import database.CRUD;
import database.ConfiDB;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD {
    @Override
    public Object insert(Object object) {

        //Abrir la conexion
        Connection objConnection = ConfiDB.openConnection();

        //Castear el objeto
        Autor objAutor = (Autor) object;

        try{
            //Comando sql
            String sql = "INSERT INTO autor (name,nacionalidad) VALUE(?,?)";
            //Preparar el Statement
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //Asignar valores
            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());

            //Ejecutar el query
            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objAutor.setId(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null,"Autor agregado correctamente");



        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar autor"+ e.getMessage());
        }
        ConfiDB.closeConnection();

        return objAutor;
    }

    @Override
    public boolean update(Object object) {

        Connection objConnection = ConfiDB.openConnection();

        Autor objAutor = (Autor) object;
        boolean isEdit = false;

        try{
            String sql = "UPDATE autor SET name = ?,nacionalidad = ? where id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());
            objPrepare.setInt(3,objAutor.getId());

            int totalAffect = objPrepare.executeUpdate();

            if(totalAffect > 0){
                isEdit = true;
                JOptionPane.showMessageDialog(null,"Editado exitosamente");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        ConfiDB.closeConnection();

        return isEdit;
    }

    @Override
    public boolean delete(Object object) {
        Connection objConnection = ConfiDB.openConnection();

        Autor objAutor = (Autor) object;

        boolean isDelete = false;

        try{
            String sql = "DELETE FROM autor WHERE id = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setInt(1,objAutor.getId());
            int totalAffect = objPrepare.executeUpdate();

            if (totalAffect > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null,"Autor eliminado correctamente");
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return false;
    }


    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfiDB.openConnection();

        List<Object> listAutores = new ArrayList<>();

        try{
            String sql = "SELECT * FROM autor ORDER BY autor.id ASC;";
            PreparedStatement objPrepareStatement = objConnection.prepareStatement(sql);

            ResultSet objResult = (ResultSet) objPrepareStatement.executeQuery();

            while (objResult.next()){
                Autor objAutor = new Autor();
                objAutor.setId(objResult.getInt("id"));
                objAutor.setNombre(objResult.getString("name"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));

                listAutores.add(objAutor);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la carga");

        }
        ConfiDB.closeConnection();
        return listAutores;

    }

    @Override
    public Object findById(int id) {
       Connection objConnection = ConfiDB.openConnection();
       Autor objAutor = new Autor();

       try{
           String sql = "SELECT * FROM autor WHERE id = "+ id +";";

           PreparedStatement objPreparestment = objConnection.prepareStatement(sql);
           ResultSet objResult = (ResultSet) objPreparestment.executeQuery();

           boolean resultadoId = objResult.next();

           if(!resultadoId){
               JOptionPane.showMessageDialog(null,"Id no encontrado");
               return null;
           }else{
               objAutor.setId(objResult.getInt("id"));
               objAutor.setNombre(objResult.getString("name"));
               objAutor.setNacionalidad(objResult.getString("nacionalidad"));

           }

       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data Error");
           System.out.println(e.getMessage());
       }
       ConfiDB.closeConnection();
        return objAutor;
    }

    public  List<Object> findName (String name){
        Connection objConnection = ConfiDB.openConnection();

        List<Object> listAutores = new ArrayList<>();

        try{
            String sql = "SELECT * FROM autor WHERE name LIKE '%" + name + "%';";
            PreparedStatement objPrepar = objConnection.prepareStatement(sql);
            ResultSet objResult = (ResultSet) objPrepar.executeQuery();

            while (objResult.next()){

                Autor objAutor = new Autor();

                objAutor.setId(objResult.getInt("id"));
                objAutor.setNombre(objResult.getString("name"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));

                listAutores.add(objAutor);
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al optener");

        }
        ConfiDB.closeConnection();
        return listAutores;

    }
}


