package sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;



public class PostCall {

	
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		PostCall http = new PostCall();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}


	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://image.maps.cit.api.here.com/mia/1.6/mapview";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("app_id", "ziKwjnsbyEbJf9RHXZzU"));
		urlParameters.add(new BasicNameValuePair("app_code", "QGSQs3Y3w_D3HhJBR9MrPg"));
//		urlParameters.add(new BasicNameValuePair("waypoint0", "geo!52.530,13.326"));
//		urlParameters.add(new BasicNameValuePair("waypoint1", "geo!52.513,13.407"));
//		urlParameters.add(new BasicNameValuePair("mode", "fastest;bicycle"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		System.out.println(urlParameters.toString());

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("");
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		System.out.println("");

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}
	


	
	
	
}
