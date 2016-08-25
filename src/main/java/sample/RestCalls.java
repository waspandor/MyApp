package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;



@SuppressWarnings("unused")
public class RestCalls {

	public static Map<String, String> param = new HashMap<String, String>();
	static StringBuilder sb = new StringBuilder();

	static String USER_AGENT = "Mozilla/5.0";

	static int responseCode;
	static String response;
	static String responseBody;
	Object savedJsonDocument = null;

	public void addString(String value) {

		sb.append("/");
		sb.append(value);
	}

	public static StringBuilder returnString() {

		return sb;

	}

	public void addParam(String name, String value) {

		param.put(name, value);
	}

	public void generateMap(Map<String, String> paramMap) {
		param.putAll(paramMap);

	}

	public void printMap() {
		System.out.println("PRINTING MAP: ");
		for (Entry<String, String> entry : param.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println("");

	}

	public void sendGet(String url) throws Exception {

		// String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		setResponse(response.toString());

	}

	
//	public String returnJson(){
//		
//		String json = getResponse();
//		Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);
//
//		String author0 = JsonPath.read(document, "response");
//		
//		return author0;
//		
//	}
	
	
	
	public String returnJson(String response, String jsonValue ) throws Throwable {
		
		Object document = savedJsonDocument;
		document = Configuration.defaultConfiguration().jsonProvider().parse(response);
	
		String test = JsonPath.read(document, jsonValue).toString();
		//System.out.println("Print json value -> " + test);
		return test;
		
	}
	
	
	

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response.toString();
	}






	public void return_follwing_json(String arg1) throws Throwable {

		System.out.println("current json "+ Postcode.getResponse());

		Object document = Configuration.defaultConfiguration().jsonProvider().parse(Postcode.getResponse());
		String theSavedJson = JsonPath.read(document, arg1).toString();
		System.out.println("The following Json String has been saved statically ");
		System.out.println(theSavedJson);

		theSavedJson = (theSavedJson.substring(1, theSavedJson.length()-1));
		savedJsonDocument = Configuration.defaultConfiguration().jsonProvider().parse(theSavedJson);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
