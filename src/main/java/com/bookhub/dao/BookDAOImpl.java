package com.bookhub.dao;

import com.bookhub.constant.DbConstent;
import com.bookhub.model.Book;
import com.bookhub.util.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {

    @Override
    public void saveBook(Book book) throws SQLException {
        Connection connection = DBConnectionManager.connection();
        String query = DbConstent.SAVE_BOOK_SQL;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getIsbn());
        preparedStatement.setDouble(4, book.getPrice());
        preparedStatement.setInt(5, book.getQuantity());
        int count = preparedStatement.executeUpdate();
        System.out.println(count + "row/s affected");
        preparedStatement.close();
        connection.close();
    }

    @Override
    public Book[] getAllBooks() throws SQLException {

        Connection connection = DBConnectionManager.connection();
        String query = DbConstent.GET_ALL_BOOKS_SQL;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            int  id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String isbn = resultSet.getString("isbn");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            Book book = new Book( id, title, author, isbn, price, quantity);
            books.add(book);
        }
        preparedStatement.close();
        connection.close();
        return books.toArray(new Book[0]);
    }

    @Override
    public Book getBookById(int bookId) throws SQLException {

        Connection connection = DBConnectionManager.connection();
        String query = DbConstent.GET_BOOK_BY_ID_SQL;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        connection.close();
        return DBConnectionManager.createBookObject(resultSet);
    }

    @Override
    public Book updateBook(Book book) throws SQLException {

        Connection connection = DBConnectionManager.connection();
        String query = DbConstent.UPDATE_BOOK_SQL;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getIsbn());
        preparedStatement.setDouble(4, book.getPrice());
        preparedStatement.setInt(5, book.getQuantity());
        preparedStatement.setInt(6, book.getId());
        int count = preparedStatement.executeUpdate();
        System.out.println(count + "row/s affected");
        preparedStatement.close();
        connection.close();
        return book;
    }

    @Override
    public void deleteBookById(int bookId) throws SQLException {

        Connection connection = DBConnectionManager.connection();
        String query = DbConstent.DELETE_BOOK_SQL;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);
        int count = preparedStatement.executeUpdate();
        System.out.println(count + "row/s affected");
        preparedStatement.close();
        connection.close();
    }
}
