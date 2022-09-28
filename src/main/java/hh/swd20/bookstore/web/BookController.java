package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String frontpage() {
		return "index"; // booklist.html
	}
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
	
	 @RequestMapping(value="/booklist")
		public String getBooks(Model model) {
		model.addAttribute("books",repository.findAll());
		
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
		public String deleteStudent (@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
		
	}
	
	@RequestMapping(value = "/add")
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
	
	@GetMapping("/edit")
	public String update( Model model, Book book) {
		
		
	
		return "edit";
	}

}