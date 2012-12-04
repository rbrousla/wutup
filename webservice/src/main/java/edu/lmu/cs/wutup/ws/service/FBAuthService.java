package edu.lmu.cs.wutup.ws.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.joda.time.DateTime;

import com.restfb.types.User;

public interface FBAuthService {
    public String getAccessToken(String code, String redirectUri) throws IOException;
    
    public Response fetchFBCode(String redirectUri) throws ParseException, ClientProtocolException,
    UnsupportedEncodingException, IOException, URISyntaxException;
    
    public String getUserNameFromFB(com.restfb.types.User u);

    public String getUserIdFromFB(com.restfb.types.User u);

    public User getFBUser(String accessToken);

    public String getUserEvents(String accessToken) throws ParseException, ClientProtocolException, IOException;

    public edu.lmu.cs.wutup.ws.model.User findOrCreateFBUser(String accessToken, String fbId);

    public edu.lmu.cs.wutup.ws.model.User syncUser(String accessToken);

    public String postUserEvent(String accessToken, String name, DateTime start, DateTime end,
            String description, String location, String FBLocationId, String privacyType);
    
}
