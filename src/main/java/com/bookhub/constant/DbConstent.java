package com.bookhub.constant;

public class DbConstent {

    public static final String SAVE_BOOK_SQL = "INSERT INTO books(title,author,isbn,price,quantity) VALUES(?,?,?,?,?)";
    public static final String GET_ALL_BOOKS_SQL = "SELECT * FROM books";
    public static final String GET_BOOK_BY_ID_SQL = "SELECT * FROM books WHERE id = ?";
    public static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, author = ?, isbn = ?, price = ?, quantity = ? WHERE id = ?";
    public static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id = ?";
    public static final String GET_BOOK_BY_ISBN_SQL = "SELECT id FROM books WHERE isbn = ?";
}
