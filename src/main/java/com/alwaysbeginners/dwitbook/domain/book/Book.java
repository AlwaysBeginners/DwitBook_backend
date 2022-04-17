package com.alwaysbeginners.dwitbook.domain.book;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.author.Author;
import com.alwaysbeginners.dwitbook.domain.category.Category;
import com.alwaysbeginners.dwitbook.domain.publisher.Publisher;
import com.alwaysbeginners.dwitbook.domain.review.Review;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    @Column(name = "isbn", nullable = false)
    private String ISBN;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    // TODO : 카테고리 정보 포함시켜야 함.

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private final List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private final List<BookThumbnail> thumbnailImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Book(String ISBN, String title, String description, LocalDate publishedDate,
        Author author, Category category, Publisher publisher) {
        this.ISBN = ISBN;
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
    }

    public void addThumbnailImage(BookThumbnail thumbnail) {
        this.thumbnailImages.add(thumbnail);
    }
}
