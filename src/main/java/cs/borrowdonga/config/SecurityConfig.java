package cs.borrowdonga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
//                .antMatchers("/**").permitAll() // 모두 허용
//                .antMatchers("/api/members/join/**").hasRole(USER) // 인증 통과 후 USER role 을 가지는 사용자만 허용
//                .antMatchers("/api/members/delete").hasRole(ADMIN) // 인증 통과 후 ADMIN role 을 가지는 사용자만 허용

        // RESTful 개발을 위해 Cross Site Request Forgery 를 disable 한다.
        http.csrf().disable();
    }
}
