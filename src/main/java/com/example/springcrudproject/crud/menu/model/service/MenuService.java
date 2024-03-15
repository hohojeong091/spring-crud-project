package com.example.springcrudproject.crud.menu.model.service;

import com.example.springcrudproject.crud.menu.model.dao.MenuMapper;
import com.example.springcrudproject.crud.menu.model.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper ;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<BookDTO> showAllBooks() {
        return menuMapper.showAllBooks();
    }

    public void registBook(BookDTO bookDTO) {
        menuMapper.registBook(bookDTO);
    }

    public void insertBook(BookDTO bookDTO) {
        menuMapper.insertBook(bookDTO);
    }
}
