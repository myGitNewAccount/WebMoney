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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anton
 */
public class CommandLogin implements ICommand {

    private static final String NAME = "username";
    private static final String PASSWORD = "password";

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASSWORD);

        if (DAOFactory.getPuserDAO().selectUser(name, password) != null) {
            HttpSession se = request.getSession(true);
            se.setMaxInactiveInterval(60*60);
            se.setAttribute("user", DAOFactory.getPuserDAO().selectUser(name, password));
            se.setAttribute("purse", DAOFactory.getPuserDAO().selectUser(name, password).getPurse());
            page = Config.getInstance().getProperty(Config.MAIN);
        } else {
            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
}
