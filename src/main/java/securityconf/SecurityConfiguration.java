package securityconf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Autowired

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		auth.inMemoryAuthentication()
		.withUser("mostafa")
		.password("userpass")
		.roles("USER")
		.and()
		.withUser("rishabh")
		.password("userpass")
		.roles("USER")
		.and()
		.withUser("sabrish")
		.password("userpass")
		.roles("USER")
		.and()
		.withUser("mostafa")
		.password("adminpass")
		.roles("ADMIN")
		.and()
		.withUser("sabrish")
		.password("adminpass")
		.roles("ADMIN")
		.and()
		.withUser("rishabh")
		.password("adminpass")
		.roles("ADMIN")
		.and();
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf()
			.disable()	;
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
		.antMatchers("/kitchenindex").hasRole("ADMIN")
		.antMatchers("/{kitchenName}/addmenuitem").permitAll()
		.antMatchers("/{kitchenName}/placeorder").permitAll()
		.antMatchers("/kitchenindex").authenticated()
		.and()
		.formLogin().loginPage("/kitchenlogin");
		
		http.authorizeRequests()
		.antMatchers("/userindex").hasRole("USER")
		.antMatchers("/{kitchenName}/addmenuitem").permitAll()
		.antMatchers("/userplaceorder").permitAll()
		.antMatchers("/userorderconfirmation").permitAll()
		.antMatchers("/userindex").authenticated()
		.and()
		.formLogin().loginPage("/userlogin");
		
		
	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	//@Bean
	//public PasswordEncoder getPasswordEncoder() {
	//	return NoOpPasswordEncoder.getInstance();
	//}
}
