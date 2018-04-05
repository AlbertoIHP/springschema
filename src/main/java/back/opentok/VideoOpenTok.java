package back.opentok;

import com.opentok.ArchiveMode;
import com.opentok.MediaMode;
import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.SessionProperties;
import com.opentok.exception.OpenTokException;


public class VideoOpenTok {

	// inside a class or method...
	int apiKey = 00000000; // YOUR API KEY
	String apiSecret = "put here your api secret";
	OpenTok opentok;
	
	public VideoOpenTok()
	{
		
	}
	
	public int getApiKey()
	{
		return apiKey;
	}
	
	public String getSessionId()
	{
		OpenTok opentok = new OpenTok(apiKey, apiSecret);
		
		// A session that uses the OpenTok Media Router (which is required for archiving):
		Session session;
		try 
		{
			session = opentok.createSession(new SessionProperties.Builder()
					  .mediaMode(MediaMode.ROUTED)
					  .archiveMode(ArchiveMode.ALWAYS)
					  .build());
			
			// Store this sessionId in the database for later use:
			String sessionId = session.getSessionId();	
			
			return sessionId;
		} 
		catch (OpenTokException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		
	}
	
	
	public String getTokenSession(String sessionId)
	{
		Session session;
		try 
		{
			OpenTok opentok = new OpenTok(apiKey, apiSecret);
			// Generate a token from just a sessionId (fetched from a database)
			String token = opentok.generateToken(sessionId);
			// Generate a token by calling the method on the Session (returned from createSession)
			return token;
		} 
		catch (OpenTokException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}	
}
