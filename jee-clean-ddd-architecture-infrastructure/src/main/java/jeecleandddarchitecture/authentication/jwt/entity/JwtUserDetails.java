/**
 *
 */
package jeecleandddarchitecture.authentication.jwt.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jeecleandddarchitecture.authentication.entity.AuthorityDto;

/**
 * Implementation of UserDetails interface providing user details.
 *
 * @author scarrasco
 *
 */
public class JwtUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 5155720064139820502L;
	
	private final Long id;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public JwtUserDetails(final Long id, final String username, final String password,
	        final Set<AuthorityDto> authoritySet) {
		this.id = id;
		this.username = username;
		this.password = password;

		final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (final AuthorityDto dto : authoritySet) {
			authorities.add(new SimpleGrantedAuthority(dto.getAuthority()));
		}
		this.authorities = authorities;
	}
	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
