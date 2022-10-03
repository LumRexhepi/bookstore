package hh.swd20.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
@CrossOrigin
@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository crepository;

	@GetMapping("/categorylist")
	public String getCategories(Model model) {
		model.addAttribute("categories", crepository.findAll());

		return "categorylist";
	}
	
	@GetMapping ("/addcategory")
	public String addCategory (Model model) {
		model.addAttribute("category", new Category());
		
		return "addCategory";
	}
	
	@PostMapping ("/savecategory")
	public String SaveCategory(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}
	


}
