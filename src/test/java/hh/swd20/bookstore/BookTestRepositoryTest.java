package hh.swd20.bookstore;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;


import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookTestRepositoryTest {

	@Autowired
	private BookRepository brepository;

	@Test
	public void FindbyTitleTest() {
		List<Book> books = brepository.findByTitle("Testi");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("testi");

	}
	
	@Test
	public void createNewBook () {
		Book book = new Book("TestJUnit", "JUnit","234", 2000, 15.00, new Category("Fiction"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook () {
		long id =  4;
		
		brepository.deleteById(id);
		assertThat(brepository.findById(id)).isEmpty();
		
	}
	
	public void findById () {
		long id = 4;
		  
		assertThat(brepository.findById(id)).isNotNull();
	
	}

}
