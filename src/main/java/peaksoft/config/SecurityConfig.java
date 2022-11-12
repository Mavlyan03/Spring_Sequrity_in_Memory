package peaksoft.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(builder.username("Akzhol").password("akzhol").roles("Student"))
                .withUser(builder.username("Datka").password("datka").roles("Manager"))
                .withUser(builder.username("Arlen").password("arlen").roles("Hr","Manager"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/all").hasAnyRole("Student","Manager","Hr")
                .antMatchers("/hr_info").hasRole("Hr")
                .antMatchers("/manager_info").hasRole("Manager").and().formLogin().permitAll();
    }

}
