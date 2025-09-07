package com.bookhub.util;

import com.bookhub.model.Book;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.Connection;

public class DBConnectionManager {

public static Connection connection() throws SQLException {

    String url = Objects.requireNonNull(PropertyUtil.getPropertyObject()).getProperty("DB.URL");
    String user = Objects.requireNonNull(PropertyUtil.getPropertyObject()).getProperty("DB.USER");
    String password = Objects.requireNonNull(PropertyUtil.getPropertyObject()).getProperty("DB.PASSWORD");
    return DriverManager.getConnection(url,user,password);
}

/*
*Create a book object by using resultset;
 */
public static Book createBookObject(ResultSet resultSet) throws SQLException {
    String title = resultSet.getString("title");
    String author = resultSet.getString("author");
    String isbn = resultSet.getString("isbn");
    double price = resultSet.getDouble("price");
    int quantity = resultSet.getInt("quantity");
    int id = resultSet.getInt("id");
    return new Book(id, title, author, isbn, price, quantity);
}

}
