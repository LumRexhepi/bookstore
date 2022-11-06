package hh.swd20.bookstore.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//restful service to get all Categories
	@GetMapping("/categories")
	public @ResponseBody List<Category> getCategoriesRest() {
		return (List<Category>) crepository.findAll();
	}
	
	//RESTful service to get category byt id
	@GetMapping ("/categories/{id}")
	public @ResponseBody Optional<Category> findcategoryRest(@PathVariable("id") Long cId){
		return crepository.findById(cId);
			
	}
	
	//RESTful service to save new category
	@PostMapping("/categories")
	public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
		return crepository.save(category);
	}
	
	
	
	
	
	
}
