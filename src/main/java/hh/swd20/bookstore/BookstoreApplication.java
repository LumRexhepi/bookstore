package hh.swd20.bookstore;


import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	
}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of Books");
			Category c_a = new Category("Fiction");
			Category c_b = new Category("Drama");
			Category c_c = new Category("Science");
			crepository.save(c_a);
			crepository.save(c_b);
			crepository.save(c_c);
			
			
			
			Book a = new Book("Testi", "testi","123", 2000, 15.00, c_a);
			Book b = new Book("Testi2", "test2i","234", 2000, 15.00, c_b);
			Book c = new Book("Testi3", "testi3","345", 2000, 15.00, c_c);
			Book d = new Book("Testi4", "testi4","456", 2000, 15.00, c_c);
			
			repository.save(a);
			repository.save(b);
			repository.save(c);
			repository.save(d);
			

			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			
			
			log.info("Fetch all the categories");
			for (Category category: crepository.findAll()) {
				log.info(category.toString());
			}
			
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			
		};
	}

}
