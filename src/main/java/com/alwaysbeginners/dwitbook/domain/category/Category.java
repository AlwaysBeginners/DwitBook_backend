package com.alwaysbeginners.dwitbook.domain.category;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.book.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    private final List<Book> books = new ArrayList<>();

    @Builder
    public Category(String name) {
        this.name = name;
    }

}
