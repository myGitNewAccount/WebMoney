/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.manager;

import java.util.ResourceBundle;

/**
 *
 * @author Anton
 */
public class Message {

    private static Message instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "ua.com.iteducate.manager.messages";
    public static final String SERVLET_EXECPTION = "SERVLET_EXCEPTION";
    public static final String IO_EXCEPTION = "IO_EXCEPTION";
    public static final String LOGIN_ERROR = "LOGIN_ERROR";
    public static final String REG_ERROR = "REG_ERROR";
    public static final String T_ERROR = "T_ERROR";

    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
