package com.arathin.HospitalMS.securityConf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final UserDetailsService userDetailsService;

    public SpringSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/home", "/register").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/patient/**", "/billings/**", "/invoices/**").hasRole("PATIENT")
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll())

                .userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
/*
    @Autowired
    private PatientService patientService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/register").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/patient/**").hasRole("PATIENT")
                    .antMatchers("/patient/**", "/billings/**", "/invoices/**").hasRole("PATIENT")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(email -> {
                    Patient patient = patientService.findByEmail(email);
                    if (patient != null) {
                        return new org.springframework.security.core.userdetails.User(
                                patient.getEmail(),
                                patient.getPassword(),
                                Collections.singleton(new SimpleGrantedAuthority("ROLE_PATIENT"))
                        );
                    }
                    throw new UsernameNotFoundException("User not found.");
                })
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/

