package com.example.backendApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableWebSecurity
@RestController("/login")
public class securityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
            .csrf(customizer -> customizer.disable())
            .authorizeHttpRequests(request -> request.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//            UserDetails user1 = User
//                    .withDefaultPasswordEncoder()
//                    .username("admin")
//                    .password("admindev")
//                    .roles("ADMIN")
//                    .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("dev")
//                .password("dev")
//                .roles("DEV")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());;
        provider.setUserDetailsService(userDetailsService);
                return provider;

    }


    @Bean
    public AuthenticationManager authenticationManager(AutheticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
