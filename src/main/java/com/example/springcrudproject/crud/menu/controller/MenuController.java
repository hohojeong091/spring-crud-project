package com.example.springcrudproject.crud.menu.controller;

import com.example.springcrudproject.crud.menu.model.dto.BookDTO;
import com.example.springcrudproject.crud.menu.model.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String showAllBooks(Model model) {

        List<BookDTO> bookList = menuService.showAllBooks();
        model.addAttribute("bookList", bookList);

        return "menu/list" ;
    }

    @GetMapping("/regist")
    public String registBook() {
       //BookDTO bookDTO = menuService.registBook(bookDTO);
        return "menu/regist";
    }

    @PostMapping("/regist")
    public String insertBook(BookDTO bookDTO) {
        menuService.insertBook(bookDTO);
    return "redirect:/menu/list";
    }
}
