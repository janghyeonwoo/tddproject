package com.pooney.book.config.auth;

import com.pooney.book.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//시큐리티 설정을 활성화
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final CustomOAuth2UserService customOauth2UserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    //h2-console을 사용하기 위한 해당 옵션들을 disable한다.
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                //.authorizeRequests() url별 권한 관리를 설정하는 옵션의 시작점
                    .authorizeRequests()
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                //로그아웃 시 '/' 로 이동
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOauth2UserService);

    }
}
