package edu.lmu.cs.wutup.ws.resource;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.DateTime;
import org.junit.Test;

public class VenueResourceIT {
    
    /*
     * (1, 'Pantages Theater', '6233 Hollywood Bl, Los Angeles, CA', 34.1019444, -118.3261111);
     * (2, 'Hollywood Bowl', '2301 North Highland Ave, Hollywood, CA', 34.1127863, -118.3392439);
     * (3, 'Tochka', '8915 Sunset Bl, West Hollywood, CA', 34.090608, -118.386178);
     * (4, 'Griffith Observatory', '2800 East Observatory Rd, Los Angeles, CA 90027', 0, 0);
     * (5, 'The Roxy', '9009 West Sunset Bl, West Hollywood, CA 90069', 34.123408, -118.302409);
     * (6, 'The Viper Room', '8852 West Sunset Bl, West Hollywood, CA 90069', 34.090512, -118.384657);
     * (8, 'Carousel Restaurant', '304 N Brand Bl, Glendale, CA 91203', 34.149885, -118.255108);
     */
    
    @Test
    public void testGetVenueFindsEndpoint() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            contentType("application/json").
            body(containsString("\"id\":2")).
            body(containsString("\"name\":\"Hollywood Bowl\"")).
            body(containsString("\"address\":\"2301 North Highland Ave, Hollywood, CA\"")).
            body(containsString("\"latitude\":34.1127863")).
            body(containsString("\"longitude\":-118.3392439")).
        when().
            get("/wutup/venues/2");
    }
    
    @Test
    public void testGetVenueByNameFindsEndpoint() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            contentType("application/json").
            body(containsString("\"id\":1")).
            body(containsString("\"name\":\"Pantages Theater\"")).
            body(containsString("\"address\":\"6233 Hollywood Bl, Los Angeles, CA\"")).
            body(containsString("\"latitude\":34.1019444")).
            body(containsString("\"longitude\":-118.3261111")).
        when().
            get("wutup/venues?name=Pan");
    }
    
    @Test
    public void testGetVenueByEventIdFindsEndpoint() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            contentType("application/json").
            body(containsString("\"id\":4")).
            body(containsString("\"name\":\"Griffith Observatory\"")).
            body(containsString("\"address\":\"2800 East Observatory Rd, Los Angeles, CA 90027\"")).
            body(containsString("\"latitude\":0")).
            body(containsString("\"longitude\":0")).
        when().
            get("/wutup/venues?event=8");
    }
    
    @Test
    public void getVenueByPartialCircleSearchResponds400() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(400).
        when().
            get("/wutup/venues?center=-100.0,20.0");
        
        given().
            header("Accept", "application/json").
        expect().
            statusCode(400).
        when().
            get("/wutup/venues?radius=20");
    }
    
    @Test
    public void patchToExistingVenueCanBeRetrieved() {
        given().
            contentType("application/json").
            body("{\"name\":\"The Echo\"}").
        expect().
            statusCode(204).
        when().
            patch("/wutup/venues/3");
        
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            body(containsString("\"name\":\"The Echo\"")).
            body(containsString("\"id\":3")).
            body(containsString("\"address\":\"8915 Sunset Bl, West Hollywood, CA\"")).
            body(containsString("\"latitude\":34.090608")).
            body(containsString("\"longitude\":-118.386178")).
        when().
            get("/wutup/venues/3");
    }
    
    @Test
    public void patchToVenueWithMismatchedIdsResponds409Conflict() {
        given().
            contentType("application/json").
            body("{\"id\":27,\"name\":\"The Echo\"}").
        expect().
            statusCode(409).
        when().
            patch("/wutup/venues/3");
    }
    
    @Test
    public void testFindVenuesbyIncompleteCircleSearchResponds400() {
        given().
            contentType("application/json").
        expect().
            statusCode(400).
        when().
            get("/wutup/venues?radius=3.14");
        
        given().
            contentType("application/json").
        expect().
            statusCode(400).
        when().
            get("/wutup/venues?center=-24.5,100.02");
        
        given().
            contentType("application/json").
        expect().
            statusCode(400).
        when().
            get("/wutup/venues?center=-22.0001&radius=50.0");
            
    }
    
    @Test
    public void testFindVenuesByCircleSearch() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            body(containsString("\"id\":1")).
            body(containsString("\"name\":\"Pantages Theater\"")).
            body(containsString("\"address\":\"6233 Hollywood Bl, Los Angeles, CA\"")).
            body(containsString("\"latitude\":34.1019444")).
            body(containsString("\"longitude\":-118.3261111")).
        when().
            get("/wutup/venues/?center=34.1019444,-118.3261111&radius=0.01");
    }
    
    // **************************** COMMENT TESTING ****************************
    
    @Test
    public void testfindVenueCommentCanBeRead() {
        DateTime postDateOne = new DateTime(2012, 3, 30, 12, 34, 56);
        DateTime postDateTwo = new DateTime(2012, 12, 25, 7, 0, 0);
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            body(containsString("\"id\":1")).
            body(containsString("\"author\":{\"id\":1,\"email\":\"40mpg@gmail.com\",\"nickname\":\"hybrid\",\"firstname\":\"Honda\",\"lastname\":\"Prius\"}")).
            body(containsString("\"body\":\"This venue sux.\"")).
            body(containsString("\"postdate\":" + postDateOne.getMillis())).
            body(containsString("\"id\":2")).
            body(containsString("\"author\":{\"id\":2,\"email\":\"naked@winterfell.com\",\"nickname\":\"headless\",\"firstname\":\"Ned\",\"lastname\":\"Stark\"}")).
            body(containsString("\"body\":\"My life is a sham\"")).
            body(containsString("\"postdate\":" + postDateTwo.getMillis())).
        when().
            get("wutup/venues/10/comments");
    }
    
    @Test
    public void testFindVenueCommentsOnVenueWithNoComments() {
        given().
            header("Accept", "application/json").
        expect().
            statusCode(200).
            body(equalTo("[]")).
        when().
            get("wutup/venues/6/comments");
    }
}
