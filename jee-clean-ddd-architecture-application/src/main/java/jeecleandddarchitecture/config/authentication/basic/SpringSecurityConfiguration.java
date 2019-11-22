/**
 *
 */
package jeecleandddarchitecture.config.authentication.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Contains Spring Configuration to enable Basic Authentication.
 * 
 * @author scarrasco
 *
 */
@Configuration
@EnableWebSecurity
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest()
		        .authenticated().and()
		        // .formLogin().and()
		        .httpBasic();
	}
}
