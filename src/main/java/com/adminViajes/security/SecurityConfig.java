package com.adminViajes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.adminViajes.config.CustomAccessDeniedHandler;
import com.adminViajes.security.Service.UserDetailServiceImp;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

        @Autowired
        UserDetailServiceImp userDetailServiceImp;

        @Bean
        AccessDeniedHandler accessDeniedHandler() {
                return new CustomAccessDeniedHandler();
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return NoOpPasswordEncoder.getInstance();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/login", "/registrar", "/vistas/Usuario/api/users",
                                                                "css/estiloLogin.css",
                                                                "css/estiloRegistro.css", "Imagenes/**", "/api/users",
                                                                "/vistas/registro")
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(formLogin -> formLogin
                                                .loginProcessingUrl("/signin")
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/api", true)
                                                .usernameParameter("correo")
                                                .passwordParameter("contrasena")
                                                .permitAll())
                                .exceptionHandling(exceptionHandling -> exceptionHandling
                                                .accessDeniedHandler(accessDeniedHandler()))
                                .logout(logout -> logout
                                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                                .logoutSuccessUrl("/index?logout")
                                                .deleteCookies("JSESSIONID")
                                                .permitAll())
                                .rememberMe(rememberMe -> rememberMe
                                                .tokenValiditySeconds(3600000)
                                                .key("secret")
                                /* .rememberMeParameter("checkRememberMe") */);
                return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
                AuthenticationManagerBuilder authenticationManagerBuilder = http
                                .getSharedObject(AuthenticationManagerBuilder.class);
                authenticationManagerBuilder
                                .userDetailsService(userDetailServiceImp);
                return authenticationManagerBuilder.build();
        }

        @SuppressWarnings("unused")
        private AuthenticationManagerBuilder authenticationManagerBuilder() throws Exception {
                return new AuthenticationManagerBuilder(null);
        }

}
