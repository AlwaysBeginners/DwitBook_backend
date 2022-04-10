package com.alwaysbeginners.dwitbook.domain.book;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.author.Author;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_author")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookAuthor extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "book_author_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

}
