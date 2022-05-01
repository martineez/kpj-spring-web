package cz.inventi.academy.springweb.controller;

import java.util.Locale;

import javax.validation.Valid;

import cz.inventi.academy.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.inventi.academy.springweb.model.Book;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO: Write annotation for controller
@Controller
public class MainController {

    // TODO: Define bookService and messageSource parameter and inject it via spring annotation

    @Autowired
    BookService bookService;
    @Autowired
    MessageSource messageSource;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(Model model) {
        // TODO: Load all books
        // TODO: Add books to model
        model.addAttribute("books", bookService.loadBooks());
        return "list";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)

    @RequestMapping(value="/edit", method= RequestMethod.GET)
    public String formEdit(Model model) {
        // TODO: Add new book to model
        model.addAttribute("book", new Book());
        return "edit";
    }


    // TODO: Add @RequestMapping with correct parameters (value, method)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String formSave(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, ModelMap model) {
        // TODO: When there are no error, then save book and add text message ("info.book.saved") to model from resource bundle
        if(bindingResult.hasErrors()) {
            return "edit";
        }
        bookService.save(book);
        model.addAttribute("bookAdded", messageSource.getMessage("info.book.saved", null, Locale.getDefault()));
        return "edit";
    }
//
    // TODO: Add @RequestMapping with correct parameters (value, method)
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, ModelMap model) {
        // TODO: Delete book by id
        // TODO: Load all books
        // TODO: Add books to model
        bookService.delete(id);
        model.addAttribute("books", bookService.loadBooks());
        return "redirect:/list";
    }
}