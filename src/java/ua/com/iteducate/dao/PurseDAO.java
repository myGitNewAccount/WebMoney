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
import ua.com.iteducate.daointerfaces.*;
import ua.com.iteducate.entities.*;

/**
 *
 * @author Anton
 */
public class PurseDAO implements IPurseDAO {
    public int insertPurse(double money){
        try {
            String query, index;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query = "insert into purse(purse_money_uan) values(?)";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(money));
            ps.executeUpdate();
            query = "select * from purse where purse_money_uan=? and purse_status=1";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(money));
            ResultSet rs  = ps.executeQuery();
            rs.next();
            index = rs.getString(1);
            query = "update purse set purse_status=0 where purse_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,index);
            ps.executeUpdate();
            stmt.close();
            conn.close();
            return Integer.valueOf(index);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public boolean deletePurse(int id){
        try{
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query = "delete from purse where purse_id=?";
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
    public boolean updatePurse(int id, double money){
        try{
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query = "update purse set purse_money_uan=? where purse_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(money));
            ps.setString(2,String.valueOf(id));
            ps.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Purse selectPurse(int id){
        try{
            Purse newPurse = new Purse();
            String query;
            Connection conn = ConnectionPool.createConnection();
            Statement stmt = conn.createStatement();
            PreparedStatement ps;
            query="select * from purse where purse_id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,String.valueOf(id));
            ResultSet rs  = ps.executeQuery();
            rs.next();
            newPurse.setPurseId(Integer.valueOf(rs.getString(1)));
            newPurse.setPurseMoneyUan(Double.valueOf(rs.getString(2)));
            newPurse.setPurseStatus(Boolean.valueOf(rs.getString(3)));
            stmt.close();
            conn.close();
            return newPurse;
    } catch (NamingException | SQLException ex) {
            Logger.getLogger(PurseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
    }
}
