package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class GetCall {

	static String USER_AGENT = "Mozilla/5.0";
	public static Map<String, String> param = new HashMap<String, String>();
	
	
	
	public static void main (String arge[]) throws ClientProtocolException, IOException, URISyntaxException{
		
		
		addParam("app_id", "ziKwjnsbyEbJf9RHXZzU");
		addParam("app_code", "QGSQs3Y3w_D3HhJBR9MrPg");
		
		addParam("waypoint0", "51.4899488390558");
		addParam("waypoint1", "-0.208644362766368");
		//addParam("departure", "now");
		getCall("https://route.cit.api.here.com/routing/7.2/calculateroute.json");
		
	}
	
	
	
	
	

	public static void getCall(String endpoint) throws ClientProtocolException, IOException, URISyntaxException {

		generateMap(param);
		String url = endpoint;

		URIBuilder builder = new URIBuilder();
		builder.setPath(url);

		for (Entry<String, String> entry : param.entrySet()) {
			builder.setParameter(entry.getKey(), entry.getValue());
		}

		System.out.println(builder.toString());

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(builder.build());

		// add header
		get.setHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(get);
		System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println("");
		System.out.println(result.toString());
		param.clear();

	}
	
	

	public static void addParam(String name, String value) {

		param.put(name, value);
	}

	public static void generateMap(Map<String, String> paramMap) {
		param.putAll(paramMap);

	}

	public static void printMap() {
		System.out.println("PRINTING MAP: ");
		for (Entry<String, String> entry : param.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("");

	}

}
