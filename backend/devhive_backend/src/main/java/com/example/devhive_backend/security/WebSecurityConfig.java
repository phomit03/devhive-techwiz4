package com.example.devhive_backend.security;

import com.example.devhive_backend.security.jwt.AuthEntryPointJwt;
import com.example.devhive_backend.security.jwt.AuthTokenFilter;
import com.example.devhive_backend.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }


  @Bean
  public AuthenticationManager authenticationManager(
          UserDetailsService userDetailsService,
          PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);

    return new ProviderManager(authenticationProvider);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().ignoringAntMatchers("/**");
    http.httpBasic().authenticationEntryPoint(unauthorizedHandler);
    http.authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            //new
            .antMatchers("/api/new/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/new/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/new/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/new/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/new/{id}").hasAnyRole("ADMIN")
            // tim 3 bai bao
            .mvcMatchers(HttpMethod.GET,"/api/new/getLatest").hasAnyRole("ADMIN","USER")
            //category
            .antMatchers("/api/category/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/category/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/category/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/category/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/category/{id}").hasAnyRole("ADMIN")
            //feedback
            .antMatchers("/api/feedback/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/feedback/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/feedback/create").hasAnyRole("ADMIN","USER")
            //match
            .antMatchers("/api/match/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/match/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/match/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/match/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/match/{id}").hasAnyRole("ADMIN")
            //search tran dau
            .mvcMatchers(HttpMethod.GET,"/api/latest-finished-match").hasAnyRole("ADMIN","USER")

            //order
            .antMatchers("/api/order/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/order/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/order/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/order/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/order/{id}").hasAnyRole("ADMIN")
            //order-product
            .antMatchers("/api/order/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/order/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/order/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/order/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/order/{id}").hasAnyRole("ADMIN")
            //player
            .antMatchers("/api/player/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/player/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/player/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/player/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/player/{id}").hasAnyRole("ADMIN")
            //product
            .antMatchers("/api/product/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/product/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/product/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/product/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/product/{id}").hasAnyRole("ADMIN")
            //test
            .antMatchers("/api/product/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/product/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/product/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/product/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/product/{id}").hasAnyRole("ADMIN")
            //team
            .antMatchers("/api/team/getAll").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.GET,"/api/team/{id}").hasAnyRole("ADMIN","USER")
            .antMatchers("/api/team/create").hasAnyRole("ADMIN","USER")
            .mvcMatchers(HttpMethod.POST,"/api/team/{id}").hasAnyRole("ADMIN")
            .mvcMatchers(HttpMethod.DELETE,"/api/team/{id}").hasAnyRole("ADMIN")
            //test
            .antMatchers("/api/test/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and().csrf().disable();
    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.cors();

    return http.build();
  }
}
