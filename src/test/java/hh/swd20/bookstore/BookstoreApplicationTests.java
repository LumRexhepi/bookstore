package hh.swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.web.BookController;
import hh.swd20.bookstore.web.CategoryController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bcontroller;
	private CategoryController ccontroller;

	@Test
	void bContextLoads() {
		assertThat(bcontroller).isNotNull();
	}

//	@Test -
//	void cContextLoads () {
//		assertThat(ccontroller).isNull();
//	}
	
}
