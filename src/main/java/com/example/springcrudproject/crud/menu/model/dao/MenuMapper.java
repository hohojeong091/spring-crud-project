package com.example.springcrudproject.crud.menu.model.dao;

import com.example.springcrudproject.crud.menu.model.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<BookDTO> showAllBooks();

    void registBook(BookDTO bookDTO);

    void insertBook(BookDTO bookDTO);
}
