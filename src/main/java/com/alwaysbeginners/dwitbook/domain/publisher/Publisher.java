package com.alwaysbeginners.dwitbook.domain.publisher;


import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.author.Author;
import com.alwaysbeginners.dwitbook.domain.book.Book;
import com.alwaysbeginners.dwitbook.domain.book.BookThumbnail;
import com.alwaysbeginners.dwitbook.domain.category.Category;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publisher")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Publisher extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name")
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @Builder
    public Publisher(Long id, String name) {
        this.name = name;
    }
}

