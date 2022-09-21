package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book a = new Book("Testi", "testi","123", 2000, 15.00);
			Book b = new Book("Testi2", "test2i","234", 2000, 15.00);
			Book c = new Book("Testi3", "testi3","345", 2000, 15.00);
			Book d = new Book("Testi4", "testi4","456", 2000, 15.00);
			
			repository.save(a);
			repository.save(b);
			repository.save(c);
			repository.save(d);
			
			
			for (Book book :  repository.findAll()) {
				book.toString();
			}
		};
	}

}
