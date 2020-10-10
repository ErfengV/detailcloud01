package com.yc.springcloud812.service;


import com.yc.springcloud812.bean.Book;

import java.util.List;

public interface BookService {

    Book getBook(Integer id);

    List<Book> findAll();
}
