package app.rosettacloud.ProjectAlpha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.rosettacloud.ProjectAlpha.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
