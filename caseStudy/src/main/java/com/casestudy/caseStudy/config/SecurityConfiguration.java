package com.casestudy.caseStudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/home","/doctors","addDoctor","editDoctor/*", "deleteDoctor/*",
        				"/employees","addEmployee","editEmployee/*", "deleteEmployee/*",
        				"/departments","addDepartment","editDepartment/*", "deleteDepartment/*",
        				"/patients","addPatient","editPatient/*", "deletePatient/*",
        				"/settings","deleteAppointment","editAppointment", "/payments","/accounts").hasAuthority("ADMIN")
                .antMatchers("/welcome","/profile","/editProfile",
                		"/appointments","addAppointment").hasAnyAuthority("ADMIN", "USER", "DOCTOR","PATIENT")
                .antMatchers("/", "/login","/logout").permitAll()
                .and()
		        .formLogin().loginPage("/login")
		        .loginProcessingUrl("/welcome");
        http.csrf().disable();
    }
    
    
    

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
