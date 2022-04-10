package com.alwaysbeginners.dwitbook.domain.account;

import com.alwaysbeginners.dwitbook.domain.BaseEntity;
import com.alwaysbeginners.dwitbook.domain.review.Review;
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
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickName;

    @Column(name = "short_description")
    private String shortDescription;

    // one to many to review

    @OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private final List<Review> reviews = new ArrayList<>();

    @Builder
    public Account(String email, String password, String nickName) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

}
