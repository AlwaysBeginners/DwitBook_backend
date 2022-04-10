package com.alwaysbeginners.dwitbook.domain.book;

import static org.assertj.core.api.Assertions.assertThat;

import com.alwaysbeginners.dwitbook.domain.author.Author;
import com.alwaysbeginners.dwitbook.domain.author.AuthorRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("작가이름으로 책 찾기")
    public void 작가이름으로_책_찾기_테스트() throws Exception {
        // given
        Author author1 = Author.builder().name("author 1").build();
        Author author2 = Author.builder().name("author 2").build();

        authorRepository.saveAll(Arrays.asList(author1, author2));

        String today = "2022-04-08";
        String yesterday = "2022-04-07";
        String weeksAgo = "2022-04-01";

        LocalDate todayLocalDate = LocalDate.parse(today, DateTimeFormatter.ISO_DATE);
        LocalDate yesterdayLocalDate = LocalDate.parse(yesterday, DateTimeFormatter.ISO_DATE);
        LocalDate weeksAgoLocalDate = LocalDate.parse(weeksAgo, DateTimeFormatter.ISO_DATE);

        Book book = Book.builder().ISBN("1234").title("title 1").publishedDate(todayLocalDate)
            .author(author1).build();
        Book book2 = Book.builder().ISBN("1235").title("title 2").publishedDate(yesterdayLocalDate)
            .author(author1).build();
        Book book3 = Book.builder().ISBN("1240").title("title 3").publishedDate(weeksAgoLocalDate)
            .author(author1).build();

        Book booksByAuthor2 = Book.builder().ISBN("1250").title("title 3")
            .publishedDate(todayLocalDate).author(author2).build();

        List<Book> booksByAuthor1 = Arrays.asList(book, book2, book3);

        List<Book> savedBooksByAuthor1 = bookRepository.saveAll(booksByAuthor1);
        bookRepository.save(booksByAuthor2);

        // when

        List<Book> booksByAuthorName = bookRepository.findTop10ByAuthor_NameEqualsOrderByPublishedDateDesc(
            author1.getName());

        // then
        assertThat(savedBooksByAuthor1).isEqualTo(booksByAuthorName);

        assertThat(booksByAuthorName.get(0).getAuthor()).isEqualTo(author1);

        assertThat(booksByAuthorName).isSortedAccordingTo(
            (o1, o2) -> o1.getPublishedDate().isBefore(o2.getPublishedDate()) ? 1 : -1);

        for (Book b : booksByAuthorName) {
            System.out.println("published Date = " + b.getPublishedDate());

        }

    }


}