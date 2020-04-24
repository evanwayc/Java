package omdb;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Driver {

    //透過OMDB-API 取得資料的JSON
    public String getSearchResult(String title) {
        String responseBody = null;
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpGet httpget
                    = new HttpGet("http://www.omdbapi.com/?i=tt3896198&apikey=47f7ab1b&s=" + title);
            System.out.println("Executing request " + httpget.getMethod() + " " + httpget.getUri());
            // Create a custom response handler
            final HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final ClassicHttpResponse response) throws IOException {
                    final int status = response.getCode();
                    if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                        final HttpEntity entity = response.getEntity();
                        try {
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } catch (final ParseException ex) {
                            throw new ClientProtocolException(ex);
                        }
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            responseBody = httpclient.execute(httpget, responseHandler);
            //印出結果來驗證一下
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    //透過JSONObject的外掛，解析JSON
    public ArrayList<Movie> parseMovie(String responseBody) {
        ArrayList<Movie> result = new ArrayList<>();
        //parse JSON
        JSONObject jsons = new JSONObject(responseBody);
        //System.out.println("> " + jsons.getString("Title"));    //get title
        boolean hasResponse = jsons.getBoolean("Response");    //get title
        if (hasResponse) {
            // 組成 ArrayList<String> 來回傳
            //how to get Ratings (array)
            JSONArray movies = jsons.getJSONArray("Search");
            //System.out.println(">> " + ratings);
            for (Object obj : movies) {
                JSONObject aMovie = new JSONObject(obj.toString());
                System.out.println(" > " + aMovie.getString("Title") + "("
                        + aMovie.getString("Year") + ")");

                Movie newMovie = new Movie();
                newMovie.setTitle(aMovie.getString("Title"));
                newMovie.setYear(aMovie.getString("Year"));
                newMovie.setImdbID(aMovie.getString("imdbID"));
                newMovie.setType(aMovie.getString("Type"));
                newMovie.setImageUrl(aMovie.getString("Poster"));

                result.add(newMovie);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Driver driver = new Driver();
//        String result = driver.getSearchResult("superman");
//        ArrayList<Movie> movieList = driver.parseMovie(result);

    }
}
