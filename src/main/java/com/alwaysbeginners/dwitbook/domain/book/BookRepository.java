package com.alwaysbeginners.dwitbook.domain.book;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByISBNEquals(String ISBN);

    List<Book> findTop10ByTitleContainsOrderByPublishedDateAsc(String title);

}
