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

public class OMDB_Test {

    public static void main(final String[] args) throws Exception {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpGet httpget = new HttpGet("http://www.omdbapi.com/?i=tt3896198&apikey=47f7ab1b&t=star");

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
            final String responseBody = httpclient.execute(httpget, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");

            JSONObject jsons = new JSONObject(responseBody);
            System.out.println(">>>>  " + jsons.getString("Title")); //得到名稱

            JSONArray ratings = jsons.getJSONArray("Ratings");
            System.out.println(ratings);

            System.out.println(ratings.length());

            ArrayList ValueAy = new ArrayList();

            for (Object o : ratings) {
                System.out.println(o.toString());
                JSONObject v = new JSONObject(o.toString());
                System.out.println(v.getString("Value"));
                ValueAy.add(v.getString("Value"));
            }

            for (Object o : ValueAy) {
                System.out.println(o.toString());
            }

        }
    }
}
