package kaplun.musicbot.music;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class YouTubeData {
    private static YouTube youtube;
    private static final long NUMBER_OF_VIDEOS_RETURNED = 5;

public  String search(String query){
    Properties properties = new Properties();
        try {
        InputStream in = YouTube.Search.class.getResourceAsStream("/" );
        properties.load(in);

    } catch (IOException e) {
        System.err.println("There was an error reading "  + ": " + e.getCause()
                + " : " + e.getMessage());
        System.exit(1);
    }

        try {
        // This object is used to make YouTube Data API requests. The last
        // argument is required, but since we don't need anything
        // initialized when the HttpRequest is initialized, we override
        // the interface and provide a no-op function.
        youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
            }
        }).setApplicationName("youtube-cmdline-search-sample").build();

        // Prompt the user to enter a query term.
        String queryTerm = getInputQuery(query);

        // Define the API request for retrieving search results.
        YouTube.Search.List search = youtube.search().list("id,snippet");

        // Set your developer key from the {{ Google Cloud Console }} for
        // non-authenticated requests. See:
        // {{ https://cloud.google.com/console }}
        String apiKey = "Token";
        search.setKey(apiKey);
        search.setQ(queryTerm);

        // Restrict the search results to only include videos. See:
        // https://developers.google.com/youtube/v3/docs/search/list#type
        search.setType("video");

        // To increase efficiency, only retrieve the fields that the
        // application uses.
        search.setFields("items(id/videoId)");
        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

        // Call the API and print results.
        SearchListResponse searchResponse = search.execute();
        List<SearchResult> searchResultList = searchResponse.getItems();

         return String.valueOf(searchResultList.get(0));
    } catch (GoogleJsonResponseException e) {
        System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                + e.getDetails().getMessage());
    } catch (IOException e) {
        System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
    } catch (Throwable t) {
        t.printStackTrace();
    }
    return query ;
}

    /*
     * Prompt the user to enter a query term and return the user-specified term.
     */
    private static String getInputQuery(String inputQuery) throws IOException {
        if (inputQuery.length() < 1) {
            // Use the string "YouTube Developers Live" as a default.
            inputQuery = "YouTube Developers Live";
        }
        return inputQuery;
    }




}
