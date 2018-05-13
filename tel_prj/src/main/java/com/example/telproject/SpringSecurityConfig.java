package com.example.telproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder myPasswordEncoderValue=null;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder myPasswordEncoder(){
        myPasswordEncoderValue = new BCryptPasswordEncoder();
        return myPasswordEncoderValue;
    }
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String psw = myPasswordEncoderValue.encode("yava");
        auth.inMemoryAuthentication()
                .passwordEncoder(myPasswordEncoder())
                .withUser("nikos").password(psw).authorities("USER").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/").hasRole("USER")
                    .antMatchers("/index").hasRole("USER")
                    .antMatchers("/greeting").hasRole("USER")
                    .antMatchers("/home").hasRole("USER")
                    .antMatchers("/signup").permitAll()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/login?logout").permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/403");

    }
}