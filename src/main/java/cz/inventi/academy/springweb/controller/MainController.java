package cz.inventi.academy.springweb.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import cz.inventi.academy.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.inventi.academy.springweb.model.Book;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Book> books = bookService.loadBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String formEdit(Model model, @ModelAttribute("book") Book book) {
        model.addAttribute("book", book);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String formSave(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result, Locale locale) {
        if (result.hasErrors()) {
            model.addAttribute("errormsg", result);
        } else {
            bookService.save(book);
            model.addAttribute("infomsg", messageSource.getMessage("info.book.saved", null, locale));
        }
        return "edit";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") long id) {
        bookService.delete(id);
        List<Book> books = bookService.loadBooks();
        model.addAllAttributes(books);
        return "redirect:/list";
    }
}