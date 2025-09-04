package com.bookhub;

import com.bookhub.util.PropertyUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String message = PropertyUtil.getPropertyObject().getProperty("WELCOME.MESSAGE");
        System.out.println( message );
    }
}
