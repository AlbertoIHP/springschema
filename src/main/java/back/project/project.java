package back.project;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import back.upload.Aws3Upload;


@Entity
public class project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    

    @Size(min = 0, max = 255)
    private String picture;
    
    
    private String user_id;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) throws IOException 
	{
		if( !picture.equals("https://cdn.lynda.com/course/506926/506926-636238695730179167-16x9.jpg") )
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private String description;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
