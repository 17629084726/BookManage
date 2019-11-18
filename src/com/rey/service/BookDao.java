package com.rey.service;
import com.rey.bean.Book;
import com.rey.bean.State;
import java.util.List;


public interface BookDao {
    public List<Book> getBooklist(Book book);
   public List<Book> selectBookByWhere(Book book) throws Exception;
    public Book getBookByid(Integer id);
   public boolean updateBook(Book book) throws Exception;
   public boolean deleteByid(Integer id) throws Exception;
   public boolean Register(Book book) throws Exception;
    public boolean lend(State state)throws Exception;
    public boolean lendUpdate(Integer id)throws Exception;
}
