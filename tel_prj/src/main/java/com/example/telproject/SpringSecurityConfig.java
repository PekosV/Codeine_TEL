package com.example.telproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder myPasswordEncoderValue=null;
    private final String USER_NAME_QUERY="select email,password from user  where email=?";
    private final String USER_ROLE_QUERY="select email,role "+"from user "+" where email = ?";
    @Autowired
    private DataSource dataSource;



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder myPasswordEncoder(){
        myPasswordEncoderValue = new BCryptPasswordEncoder();
        return myPasswordEncoderValue;
    }
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String psw = myPasswordEncoderValue.encode("yava");
//        auth.inMemoryAuthentication()
//                .passwordEncoder(myPasswordEncoder())
//                .withUser("nikos").password(psw).authorities("USER").roles("USER");
//    }




    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//				.withUser("mama").password("1234").roles("PARENT")
//			.and()
//				.withUser("paido").password("3210").roles("ORGANIZER")
//			.and()
//				.withUser("mpampas").password("42069").roles("PARENT");

        auth.jdbcAuthentication()
                .usersByUsernameQuery(this.USER_NAME_QUERY)
                .authoritiesByUsernameQuery(this.USER_ROLE_QUERY)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
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