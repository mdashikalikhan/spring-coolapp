package com.app.springcoolapp.configs;

import com.app.springcoolapp.res.CustomAuthenticationSuccessHandler;
import com.app.springcoolapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DemoSecurityConfig {
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails ashik = User.builder().username("ashik")
                .password("{noop}test123")
                .roles("EMPLOYEE").build();
        UserDetails rahim = User.builder().username("rahim")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER").build();

        UserDetails karim = User.builder().username("karim")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        return new InMemoryUserDetailsManager(ashik, rahim, karim);
    }*/

    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /*@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailManager = new JdbcUserDetailsManager(dataSource);

        userDetailManager.setUsersByUsernameQuery("select * from members where user_id=?");

        userDetailManager.setAuthoritiesByUsernameQuery("select * from roles where user_id=?");
        System.out.println(userDetailManager);
        return userDetailManager;
    }*/

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){

        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(encoder());
        return auth;
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    //Before Web requests
    /*public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/static/**", "/welcome", "/about").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")


                        );
        //httpSecurity.formLogin()

        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                           AuthenticationSuccessHandler authenticationSuccessHandler) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers("/css/**","/sendtopc1", "/register/**").permitAll()
                                .requestMatchers("/leaders").hasRole("MANAGER")
                                .anyRequest().authenticated()
                        )
                .formLogin(form->form
                        .loginPage("/login")

                        .loginProcessingUrl("/authenticationProcess")
                        .successHandler(authenticationSuccessHandler)
                        .permitAll()
                        )
                .logout(logout->logout.permitAll())

                .exceptionHandling(configurer-> configurer.accessDeniedPage("/access-denied")
                )

                ;

        return httpSecurity.build();

    }
}
