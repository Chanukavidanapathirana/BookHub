package com.bookhub.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static Properties getPropertyObject(){
        try(InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream("bookhub.properties")){
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, Unable to load BookHub.properties");
            }
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
