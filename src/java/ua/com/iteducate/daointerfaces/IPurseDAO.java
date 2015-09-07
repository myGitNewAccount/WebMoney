/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.daointerfaces;

import ua.com.iteducate.entities.*;

/**
 *
 * @author Anton
 */
public interface IPurseDAO {
    public int insertPurse(double money);
    public boolean deletePurse(int id);
    public boolean updatePurse(int id, double money);
    public Purse selectPurse(int id);
}
