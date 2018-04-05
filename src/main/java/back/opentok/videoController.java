package back.opentok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/video")
public class videoController 
{
	VideoOpenTok video = new VideoOpenTok();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String findAll() 
    {
    	String sessionId = video.getSessionId();
    	System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	System.out.println( sessionId );
        return "{\"session\": \""+sessionId+"\"}";
    }
    
	@RequestMapping(value = "/{sessionid}", method = RequestMethod.GET, produces = "application/json" )
    public String findOne(@PathVariable String sessionid) 
	{
        String tokenId = video.getTokenSession(sessionid);
        System.out.println("TOKENNNNNNNNNNNNNNNNNNNNNNN ");
        System.out.println(tokenId);
        
        return "{\"tokenId\": \""+tokenId+"\"}";
    }
    

	
}