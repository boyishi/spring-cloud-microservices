/*
 * package com.demo.boyishi.productservice;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws
 * Exception { http .authorizeHttpRequests((authorize) -> authorize
 * .anyRequest().authenticated() ) .httpBasic(Customizer.withDefaults())
 * .formLogin(Customizer.withDefaults());
 * 
 * return http.build(); }
 * 
 * @Bean UserDetailsService userDetailsService() { UserDetails userDetails =
 * User.builder() .username("user")
 * .password(passwordEncoder().encode("password")) .roles("USER") .build();
 * 
 * return new InMemoryUserDetailsManager(userDetails); }
 * 
 * 
 * @Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder();
 * }
 * 
 * }
 */