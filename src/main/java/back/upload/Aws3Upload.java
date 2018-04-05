package back.upload;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.BasicAWSCredentials;

public class Aws3Upload {
	private static String bucketName     = "growthax-assets-qa";
	private  String keyName;
	private File imagen;
	URL s = null;
	
	
	public Aws3Upload()
	{
		
	}
	
	
	public String uploadImageS3( String file ) throws IOException
	{
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("put here your credentials", "put here your credentials");
		AmazonS3 s3client = new AmazonS3Client(awsCreds);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		
		
		//Transform the base64 code into an buffered image
		String base64Image = file.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
		
		
		//Get the extension of the file
		String extension = file.split(";")[0].split("/")[1];
		String fileName = String.valueOf( timestamp.getTime() );
		
		//Put the buffered image into an file
		File out = new File("temp"+fileName+"."+extension);
		ImageIO.write(img, extension, out);
		
		
		
		
	        try 
	        {
	        	
	            System.out.println("Uploading a new object to S3 from a file\n");
	            
	            System.out.println( s3client.putObject(new PutObjectRequest(bucketName+"/uploads", "temp"+fileName+"."+extension, out).withCannedAcl(CannedAccessControlList.PublicRead)) );	            
	            
	            s3client.putObject( bucketName,  "Document/hello.txt", out);
	            
	            String url_bucket = ((AmazonS3Client) s3client).getResourceUrl(bucketName, "uploads/"+out);	            
	           
	            System.out.println(":::::::url_bucket "+ url_bucket);    
	            
	            
	            return url_bucket;
	            
	         } 
	        catch (AmazonServiceException ase) 
	        {
	            System.out.println("Caught an AmazonServiceException, which " +
	            		"means your request made it " +
	                    "to Amazon S3, but was rejected with an error response" +
	                    " for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	            return null;
	        } 
	        catch (AmazonClientException ace) 
	        {
	            System.out.println("Caught an AmazonClientException, which " +
	            		"means the client encountered " +
	                    "an internal error while trying to " +
	                    "communicate with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	            return null;
	        }
	}

	
	
	
	private String getUserImageKey(int c_id, String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getKeyName() {
		return keyName;
	}


	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}


	public File getImagen() {
		return imagen;
	}


	public void setImagen(File imagen) {
		this.imagen = imagen;
	}
	
}