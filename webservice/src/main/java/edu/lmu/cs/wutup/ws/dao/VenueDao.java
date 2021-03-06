package edu.lmu.cs.wutup.ws.dao;

import java.util.List;
import java.util.Map;

import edu.lmu.cs.wutup.ws.model.Circle;
import edu.lmu.cs.wutup.ws.model.PaginationData;
import edu.lmu.cs.wutup.ws.model.Venue;

public interface VenueDao extends CommentDao {

    void createVenue(Venue loc);

    List<Venue> findVenues(String name, Integer eventId, Circle circle, PaginationData pagination);

    Venue findVenueById(int id);

    Venue findVenueByName(String name);

    void updateVenue(Venue loc);

    void deleteVenue(int venueId);

    int findNumberOfVenues();

    Map<String, String> findProperties(int venueId);

    void addProperty(int venueId, String propertyName, String value);

    void updateOrAddProperty(int venueId, String propertyName, String value);

    void deleteProperty(int venueId, String propertyName);
}
