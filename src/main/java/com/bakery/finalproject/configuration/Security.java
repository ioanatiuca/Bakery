package com.bakery.finalproject.configuration;

import com.bakery.finalproject.service.UserDetailsSecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    private final UserDetailsSecurityService userDetailsSecurityService;

    public Security(UserDetailsSecurityService userDetailsSecurityService) {
        this.userDetailsSecurityService = userDetailsSecurityService;
    }


    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}parola1234")
                .roles("ADMIN")
                ;
        auth.authenticationProvider(authenticationProvider());

    }
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
//                .antMatchers("/client").permitAll()
//                .antMatchers("/order").hasAuthority("USER")
                .antMatchers("/api/bakery/product/**").hasRole("ADMIN")
                .anyRequest().permitAll()
//                .authenticated()
                .and().csrf().disable().cors().disable();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth= new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsSecurityService);
        auth.setPasswordEncoder(bCryptPasswordEncoder());
        return auth;
    }
}
