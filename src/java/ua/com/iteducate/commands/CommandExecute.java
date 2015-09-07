/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.commands;

import ua.com.iteducate.daofactory.DAOFactory;
import ua.com.iteducate.manager.Config;
import ua.com.iteducate.manager.Message;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.NumberFormatException;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Anton
 */
public class CommandExecute implements ICommand {

    private static final String BANKACCOUNT = "bankaccount";
    private static final String BANKACCOUNTMONEY = "bankaccmoney";
    private static final String PURSEID = "purseid";
    private static final String PURSEMONEY = "pursemoney";
    private static final String YBANKACC = "ybankacc";
    private static final String YBANKACCMONEY = "ybankaccmoney";
    private static final String MYPURSEID = "mypurseid";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        int firstComm;
        double secondComm;
        String page = null;
        String bankaccount = request.getParameter(BANKACCOUNT);
        String bankaccmoney = request.getParameter(BANKACCOUNTMONEY);
        String purseid = request.getParameter(PURSEID);
        String pursemoney = request.getParameter(PURSEMONEY);
        String ybankacc = request.getParameter(YBANKACC);
        String ybankaccmoney = request.getParameter(YBANKACCMONEY);
        String mypurseid = request.getParameter(MYPURSEID);
        
        try{
        if(bankaccount.length() > 0  && bankaccmoney.length() > 0){
            firstComm = Integer.valueOf(bankaccount);
            secondComm = Double.valueOf(bankaccmoney);
            if(secondComm <= DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)).getPurseMoneyUan()){
            DAOFactory.getPurseDAO().updatePurse(Integer.valueOf(mypurseid), DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)).getPurseMoneyUan()-Double.valueOf(bankaccmoney));
            }
        }
        if(purseid.length() > 0 && pursemoney.length() > 0){
            firstComm = Integer.valueOf(purseid);
            secondComm = Double.valueOf(pursemoney);
            if(DAOFactory.getPurseDAO().selectPurse(firstComm) != null && secondComm <= DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)).getPurseMoneyUan()){
            DAOFactory.getPurseDAO().updatePurse(Integer.valueOf(mypurseid), DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)).getPurseMoneyUan()-Double.valueOf(pursemoney));
            DAOFactory.getPurseDAO().updatePurse(firstComm, DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(firstComm)).getPurseMoneyUan()+Double.valueOf(pursemoney));
            }
        }
        if(ybankacc.length() > 0 && ybankaccmoney.length() > 0){
            firstComm = Integer.valueOf(ybankacc);
            secondComm = Double.valueOf(ybankaccmoney);
            DAOFactory.getPurseDAO().updatePurse(Integer.valueOf(mypurseid), DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)).getPurseMoneyUan()+Double.valueOf(secondComm));
        }
            HttpSession se = request.getSession(true);
            se.setAttribute("purse", DAOFactory.getPurseDAO().selectPurse(Integer.valueOf(mypurseid)));
            page = Config.getInstance().getProperty(Config.MAIN);
            return page;
        }catch(NumberFormatException e){
            request.setAttribute("error", Message.getInstance().getProperty(Message.T_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
            return page;
        }
    }
}
