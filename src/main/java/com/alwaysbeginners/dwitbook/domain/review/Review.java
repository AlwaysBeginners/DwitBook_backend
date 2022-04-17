package com.alwaysbeginners.dwitbook.domain.review;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.account.Account;
import com.alwaysbeginners.dwitbook.domain.book.Book;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "rating", nullable = false)
    private Float rating;

    @Column(name = "favorite_sentence")
    private String favoriteSentence;

    @Column(name = "comment")
    private String comment;

    @Builder
    public Review(Book book, Account account, Float rating, String favoriteSentence,
        String comment) {
        this.book = book;
        this.account = account;
        this.rating = rating;
        this.favoriteSentence=favoriteSentence;
        this.comment=comment;
    }

}
