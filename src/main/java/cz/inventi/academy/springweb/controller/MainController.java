package cz.inventi.academy.springweb.controller;

import cz.inventi.academy.springweb.model.Book;
import cz.inventi.academy.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(value = "/list", method = GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.loadBooks());
        return "list";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String formEdit(Model model) {
        model.addAttribute("book", new Book());
        return "edit";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String formSave(Model model, @Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            bookService.save(book);
            model.addAttribute("info", messageSource.getMessage("info.book.saved", null, getLocale()));
        }

        return "edit";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String delete(Model model, @PathVariable long id) {
        bookService.delete(id);
        model.addAttribute("books", bookService.loadBooks());
        return "redirect:/list";
    }
}