package back.security.model;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import back.security.config.WebSecurityConfig;
import back.security.repository.UserRepository;
import back.upload.Aws3Upload;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username", length = 255, unique = true)
    @NotNull
    @Size(min = 0, max = 255)
    private String username;

    @Column(name = "password", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String password;

    @Column(name = "name", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String name;

    @Column(name = "lastname", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String lastname;
    
    @Column(name = "picture", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String picture;
    
    @Column(name = "isactive", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String isActive;
    
    
    @Column(name = "description", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String description;
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "role", length = 255)
    @NotNull
    @Size(min = 0, max = 255)
    private String role;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    
    
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) throws IOException {
		
		if( !picture.equals("https://openclipart.org/download/247324/abstract-user-flat-1.svg") )
		{
			Aws3Upload uploader = new Aws3Upload();
			System.out.println("GUARDANDOOOO IMAGEEEEENNN");		
			
			
			this.picture = uploader.uploadImageS3( picture );
			
			System.out.println("MOSTRANDO LA URL DE S3");
			System.out.println(this.picture);
			
		}
		else
		{
			this.picture = picture;
		}
		

	}





	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) 
    {
		UserRepository userBD = (UserRepository) WebSecurityConfig.contextProvider().getApplicationContext().getBean("userRepository");
		String oldPass = "";
		boolean goHash = true;
		List<User> users = userBD.findAll();
		System.out.println("Esta pass me llego: "+password);
		
		
		for( int i = 0 ; i < users.size() ; i ++ )
		{
			if( users.get(i).getPassword().equals(password) )
			{
				System.out.println("Esta pass encontramos de otro usuario: "+users.get(i).getPassword());
				System.out.println("ES LA MISMA PASSS POR LO QUE NO SE DEBE HASHEAR");
				goHash = false;
				oldPass = users.get(i).getPassword();
				break;
			}
		}
    	
    	if( goHash )
    	{
    		System.out.println("ES OTRA PASS ASI QUE HAY QUE HASHEARLA");
        	BCryptPasswordEncoder hasher = new BCryptPasswordEncoder();
            this.password = hasher.encode(password);    		
    	}
    	else
    	{
    		this.password = oldPass;
    	}

    }




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}