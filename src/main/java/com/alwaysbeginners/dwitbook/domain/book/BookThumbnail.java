package com.alwaysbeginners.dwitbook.domain.book;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
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
@Table(name = "book_thumbnail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookThumbnail extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "thumbnail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Builder
    public BookThumbnail(Book book, String imgUrl) {
        this.book = book;
        this.imgUrl = imgUrl;
    }

}
