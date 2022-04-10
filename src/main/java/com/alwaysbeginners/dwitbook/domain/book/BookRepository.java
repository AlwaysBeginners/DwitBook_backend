package com.alwaysbeginners.dwitbook.domain.book;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByISBNEquals(String ISBN);

    List<Book> findTop10ByTitleContainsOrderByPublishedDateAsc(String title);

    List<Book> findTop10ByAuthor_NameEqualsOrderByPublishedDateDesc(String authorName);

//    TODO : 테스트 코드 작성
//    List<Book> findTop10ByCategory_NameEqualsOrderByPublishedDateDesc(String categoryName);

}
