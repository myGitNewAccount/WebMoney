/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.dao;

import ua.com.iteducate.database.ConnectionPool;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import ua.com.iteducate.daofactory.DAOFactory;
import ua.com.iteducate.daointerfaces.*;
import ua.com.iteducate.entities.*;
/**
 *
 * @author Anton
 */
public class PuserDAO implements IPuserDAO {
    public int insertUser(String name, String surname, String patronymic, String password){
        try {
            String query, index;
            int purseId = DAOFactory.getPurseDAO().insertPurse(10.0);
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query = "insert into puser(puser_name,puser_surname,puser_patronymic,puser_purse_id,puser_password) values(?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,surname);
            ps.setString(3,patronymic);
            ps.setString(4,String.valueOf(purseId));
            ps.setString(5,password);
            ps.executeUpdate();
            
            query = "select * from puser where puser_purse_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(purseId));
            ResultSet rs  = ps.executeQuery();
            rs.next();
            index = rs.getString(1);
            stmt.close();
            conn.close();
            return Integer.valueOf(index);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public boolean deleteUser(int id){
        try{
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query = "delete from puser where puser_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(id));
            ps.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateUser(int id, String...namefields){
        try{
            String query;
            String field[]={"puser_name", "puser_surname", "puser_patronymic"};
            int iterator = 0;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            if(namefields.length > 0 && namefields.length < 4){
                for(String buff: namefields){
                    query = "update users set ?=? where puser_id=?";
                    ps = conn.prepareStatement(query);
                    ps.setString(1,String.valueOf(field[iterator]));
                    iterator++;
                    ps.setString(2,String.valueOf(buff));
                    ps.setString(3,String.valueOf(id));
                    ps.executeUpdate();
                }
            }
            else{
                throw new SQLException();
            }
            stmt.close();
            conn.close();
            return true;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Puser selectUser(int id){
        try{
            Puser newPuser = new Puser();
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query="select * from puser where puser_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(id));
            ResultSet rs  = ps.executeQuery();
            rs.next();
            newPuser.setPuserId(Integer.valueOf(rs.getString(1)));
            newPuser.setPuserName(String.valueOf(rs.getString(2)));
            newPuser.setPuserSurname(String.valueOf(rs.getString(3)));
            newPuser.setPuserPatronymic(String.valueOf(rs.getString(4)));
            newPuser.setPurse(DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(rs.getString(5))));
            stmt.close();
            conn.close();
            return newPuser;
    } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
    }
    
    public Puser selectUser(String name, String password){
        try{
            Puser newPuser = new Puser();
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query="select * from puser where puser_name=? and puser_password=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs  = ps.executeQuery();
            rs.next();
            newPuser.setPuserId(Integer.valueOf(rs.getString(1)));
            newPuser.setPuserName(String.valueOf(rs.getString(2)));
            newPuser.setPuserSurname(String.valueOf(rs.getString(3)));
            newPuser.setPuserPatronymic(String.valueOf(rs.getString(4)));
            newPuser.setPurse(DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(rs.getString(5))));
            stmt.close();
            conn.close();
            return newPuser;
    } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
    }
}
