package com.hunseong.webservice.config.auth;

import com.hunseong.webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Hunseong on 2022/04/24
 */
@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위한 disable
                .and()
                .authorizeRequests() // URL 별 권한 관리를 설정하는 옵션의 시작점 (선언되어야만 antMatchers 사용가능)
                .antMatchers("/", "/css/**", "/images/**", "/js/**",
                        "/h2-console/**").permitAll() // 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER Role만 권한
                .anyRequest().authenticated() // 설정값 이외 나머지 URL에 대해 인증된(로그인된) 사용자만 권한
                .and()
                .logout()
                .logoutSuccessUrl("/") // 로그아웃 성공시 "/"로 이동
                .and()
                .oauth2Login()
                .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 진입점
                .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체
                // 리소스 서버 (소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능에 대한 명시
    }
}
