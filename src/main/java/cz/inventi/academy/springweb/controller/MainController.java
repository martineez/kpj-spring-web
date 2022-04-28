package cz.inventi.academy.springweb.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.inventi.academy.springweb.model.Book;

//TODO: Write annotation for controller
public class MainController {

    // TODO: Define bookService and messageSource parameter and inject it via spring annotation

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)
    public String list(Model model) {
        // TODO: Load all books
        // TODO: Add books to model
        return "list";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)
    public String formEdit(Model model) {
        // TODO: Add new book to model
        return "edit";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)
    public String formSave(//TODO: Use correct types (validate input book)) {
        // TODO: When there are no error, then save book and add text message ("info.book.saved") to model from resource bundle 
        return "edit";
    }

    // TODO: Add @RequestMapping with correct parameters (value, method)
    public String delete(//TODO: Use correct types (e.g. PathVariable)) {
        // TODO: Delete book by id
        // TODO: Load all books
        // TODO: Add books to model
        return "redirect:/list";
    }
}