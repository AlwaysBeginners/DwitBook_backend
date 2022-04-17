package com.alwaysbeginners.dwitbook.dto.account;

import com.alwaysbeginners.dwitbook.domain.account.Account;
import java.util.Collections;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AccountDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUpReq {

        private String email;

        private String password;

        private String nickname;


        @Builder
        public SignUpReq(String email, String password, String nickname) {
            this.email = email;
            this.password = password;
            this.nickname = nickname;
        }

        public Account toEntity() {
            return Account.builder()
                .email(this.email)
                .password(encodePassword(this.password))
                .nickName(this.nickname)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResetPasswordReq {

        private String password;

        @Builder
        public ResetPasswordReq(String password) {
            this.password = password;
        }
    }

    @Getter
    public static class Response {

        private final String email;

        private final String password;

        private final String nickname;

        public Response(Account account) {
            this.email = account.getEmail();
            this.password = account.getPassword();
            this.nickname = account.getNickName();
        }
    }

    private static String encodePassword(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
