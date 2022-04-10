package com.alwaysbeginners.dwitbook.domain.account;

import com.alwaysbeginners.dwitbook.domain.review.Review;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByEmailEquals(String email);

}
