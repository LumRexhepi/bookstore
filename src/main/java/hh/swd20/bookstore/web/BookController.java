package hh.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {

	@GetMapping("/")
	public String frontpage() {
		return "redirect:booklist"; // booklist.html
	}

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@GetMapping("/booklist")
	public String getBooks(Model model) {
		model.addAttribute("books", repository.findAll());

		return "booklist";
	}

	// RESTful service to get all books
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	// RESTful service to get books by id
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> findBooksRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	// REStful service to save new book 
	@PostMapping("/books")
	public @ResponseBody Book saveBookRest(@RequestBody Book book) {
		return repository.save(book);
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";

	}

	@GetMapping("/add")
	public String addStudent(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addBook";

	}

	@PostMapping("/save")
	public String Save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/edit/{id}")
	public String showEditBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}


    
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
}
