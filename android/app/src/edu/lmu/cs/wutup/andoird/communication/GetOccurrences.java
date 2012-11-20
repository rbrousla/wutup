package edu.lmu.cs.wutup.andoird.communication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import edu.lmu.cs.wutup.android.model.Occurrence;

public class GetOccurrences extends AsyncTask<Void, Integer, ArrayList<Occurrence>>{
    
    private HttpClient client = new DefaultHttpClient();
    
    private ArrayList<Occurrence> occurrences = new ArrayList<Occurrence>();

    @Override
    protected ArrayList<Occurrence> doInBackground(Void... params) {
        
        retrieveOccurences();
        
        return occurrences;
        
    }
    
    private void retrieveOccurences() {
        
        try {
            
            URI addressOfOccurrences = new URI("http://wutup.cs.lmu.edu:8080/wutup/occurrences");            
            HttpGet requestForOccurences = new HttpGet(addressOfOccurrences);
            HttpResponse responceToRequestForOccurences = client.execute(requestForOccurences);
            
            InputStream occurenceStream = responceToRequestForOccurences.getEntity().getContent();;
            BufferedInputStream occurenceBuffer = new BufferedInputStream(occurenceStream);       
                        
            try {
                
                ObjectMapper occurenceObjectMapper = new ObjectMapper();
                ObjectReader occurenceObjectReader = occurenceObjectMapper.reader(Occurrence.class);
                
                MappingIterator<Occurrence> occurenceIterator = occurenceObjectReader.readValues(occurenceBuffer);
                fillOccurrences(occurenceIterator);
                
            } finally {
                occurenceStream.close();
                occurenceBuffer.close();
            }
            
        } catch (URISyntaxException uriSyntaxException) {
            Log.wtf("URI", "Malformed URI for occurrences!", uriSyntaxException);            
            
        } catch (IOException ioException){
            Log.e("GET", "Failed to retrieve occurrences form web service!", ioException);     
        }
 
    }
    
    private void fillOccurrences(MappingIterator<Occurrence> occurenceIterator) {
        
        occurrences.clear();
        Log.i("occurence", "Cleared occurences.");
        
        while (occurenceIterator.hasNext()) {
            
            Occurrence occurrence = (Occurrence) occurenceIterator.next();
            
            occurrences.add(occurrence);
            Log.i("occurence", "Added occurence " + occurrence.getId() + ".");
            
        }
        
    }

}