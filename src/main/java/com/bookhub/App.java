package com.bookhub;

import com.bookhub.util.DBConnectionManager;
import com.bookhub.util.PropertyUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String message = PropertyUtil.getPropertyObject().getProperty("WELCOME.MESSAGE");
        System.out.println( message );
        try (Connection conn = DBConnectionManager.connection()) {
            System.out.println("✅ Connected: " + (conn != null));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
