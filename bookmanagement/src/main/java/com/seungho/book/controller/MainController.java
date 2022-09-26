package com.seungho.book.controller;

import com.seungho.book.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final List<String> list;

    public MainController(){
        list = new ArrayList<>();
    }

    @GetMapping("/select")
    public String select(){
        return "select_function.html";
    }

    @GetMapping("/register")
    public String register(){
        return "registerbook.html";
    }

    @PostMapping("/re")
    public String  re(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("publisher") String publisher, @RequestParam("date") String date) throws IOException {
        BookDto bookDto = new BookDto();
        bookDto.setName(name);
        bookDto.setAuthor(author);
        bookDto.setPublisher(publisher);
        bookDto.setDate(date);

        list.add(String.valueOf(bookDto));

        String obj = list.toString();

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\xray21\\Downloads\\list\\test.txt"));
        bw.write(obj+"\n");
        bw.newLine();
        bw.flush();
        bw.close();
        return "redirect:/select";
    }
    @GetMapping("/showLists")
    public String showList(Model model) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xray21\\Downloads\\list\\test.txt"));
        String a = br.readLine();
        model.addAttribute("data",a);
        return "BookLists.html";
    }
}
