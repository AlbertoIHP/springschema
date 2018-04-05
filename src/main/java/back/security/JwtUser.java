package back.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1215456216545L;
	
	private final Long id;
    private final String username;
    private final String name;
    private final String lastname;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final String picture;
    private final String isActive;
    private final String role;
    private final String description;

    public JwtUser(
          Long id,
          String username,
          String firstname,
          String lastname,
          String password, 
          Collection<? extends GrantedAuthority> authorities,
          boolean enabled,
          Date lastPasswordResetDate,
          String picture,
          String isActive,
          String role,
          String description
    ) {
        this.id = id;
        this.username = username;
        this.name = firstname;
        this.lastname = lastname;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.picture = picture;
        this.isActive = isActive;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.role = role;
        this.description = description;
    }

    
    
    
   



	public String getDescription() {
		return description;
	}




	public String getRole() {
		return role;
	}




	public String getPicture() {
		return picture;
	}








	
    public String getIsActive() {
		return isActive;
	}




	public Long getId() {
        return id;
    }

   

 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }








	public String getName() 
	{
		return name;
	}




	public String getLastname() 
	{
        return lastname;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return authorities;
    }

    @Override
    public boolean isEnabled() 
    {
        return enabled;
    }

 
    public Date getLastPasswordResetDate() 
    {
        return lastPasswordResetDate;
    }




	public String getUsername() 
	{
		return username;
	}





}
