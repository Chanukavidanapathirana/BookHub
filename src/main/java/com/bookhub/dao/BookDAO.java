package com.bookhub.dao;

import com.bookhub.model.Book;

import java.sql.SQLException;

public interface BookDAO {

    void saveBook(Book book) throws SQLException;
    Book[] getAllBooks() throws SQLException;
    Book getBookById(int bookId) throws SQLException;
    Book updateBook(Book book) throws SQLException;
    void deleteBookById(int bookId) throws SQLException;

}
