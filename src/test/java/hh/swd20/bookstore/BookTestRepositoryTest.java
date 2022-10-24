package hh.swd20.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.web.BookController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookTestRepositoryTest {

	@Autowired
	private BookRepository brepository;
	private BookController bcontroller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(brepository).isNotNull();
	}

	public void contextLoads2() throws Exception {
		assertThat(bcontroller).isNotNull();
	}

	@Test
	public void FindbyTitleTest() {
		List<Book> books = brepository.findByTitle("Testi");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("testi");

	}

}
