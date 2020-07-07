package fr.pontos3.rise.riserest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}") String jwkSetUri;

  /**
   * This section defines the user accounts which can be used for
   * authentication as well as the roles each user has.
   */
  /*
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
      .withUser("greg").password("{noop}turnquist").roles("USER").and()
      .withUser("ollie").password("{noop}gierke").roles("USER", "ADMIN");
  }
  */

  /**
   * This section defines the security policy for the app.
   * - BASIC authentication is supported (enough for this REST-based demo)
   * - /employees is secured using URL security shown below
   * - CSRF headers are disabled since we are only testing the REST interface,
   *   not a web one.
   *
   * NOTE: GET is not shown which defaults to permitted.
   */
/*  
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    //remove auth session cookie
    // http.sessionManagement()
    //     .sessionCreationPolicy(SessionCreationPolicy.NEVER);

    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
      .httpBasic().and()
      //.csrf().disable()
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/countries").hasRole("USER")
      //.antMatchers(HttpMethod.GET, "/countries").hasAuthority("SCOPE_riserest")
      //.antMatchers(HttpMethod.GET, "/countries").hasAuthority("SCOPE_countries:read")
      .antMatchers(HttpMethod.POST, "/countries").hasAuthority("SCOPE_countries:write")
      .anyRequest().authenticated().and()
      .oauth2ResourceServer()
      .jwt();
      
    //   .antMatchers(HttpMethod.POST , "/employees").hasRole("ADMIN")
    //   .antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
    //   .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").and()


  }
  */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .csrf().disable()
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/countries").hasRole("USER")
        //.antMatchers(HttpMethod.GET, "/countries").hasAuthority("SCOPE_riserest")
        //.antMatchers(HttpMethod.GET, "/countries").hasAuthority("SCOPE_countries:read")
      .antMatchers(HttpMethod.POST, "/countries").hasAuthority("SCOPE_countries:write")
      .anyRequest().authenticated().and()
      .oauth2ResourceServer().bearerTokenResolver(bearerTokenResolver)
      .jwt();
     
    //   .antMatchers(HttpMethod.POST , "/employees").hasRole("ADMIN")
    //   .antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
    //   .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").and()

  }

  /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .authorizeRequests()
          .anyRequest().authenticated()
          .and()
          .oauth2Login();
    } */

}