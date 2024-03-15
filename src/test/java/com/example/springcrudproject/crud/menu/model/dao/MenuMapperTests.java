package com.example.springcrudproject.crud.menu.model.dao;

import com.example.springcrudproject.SpringCrudProjectApplication;
import com.example.springcrudproject.crud.menu.model.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes={SpringCrudProjectApplication.class})
public class MenuMapperTests {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void 매퍼_의존성주입_테스트 () {
        assertNotNull(menuMapper);
    }

    @Test
    public void 전체_책조회_테스트() {
        List<BookDTO> bookDTO = menuMapper.showAllBooks();
        assertNotNull(bookDTO);
    }

    @Test
    @Transactional
    public void testInsertBook() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(55);
        bookDTO.setBookName("rlaQKdrn");
        bookDTO.setAutourName("flyyyyyy");
        bookDTO.setPubName("abcde");
        bookDTO.setCatNum(200);
        bookDTO.setAbility("Y");
        assertDoesNotThrow(()-> menuMapper.insertBook(bookDTO));

    }





}


