package mosque;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rest {

    static String USER_AGENT = "Mozilla/5.0";
    public static Map<String, String> param = new HashMap<String, String>();
    static String postcodeBaseUrl = "https://api.ideal-postcodes.co.uk/v1/postcodes/";
    static String postcodeApiKey = "ak_ir1vwhr4XXl0E3InWHZf4pSsyUYRC";
    static String postcode = "ID11QD";

    static int responseCode;
    static String response;
    static String responseBody;
    Object savedJsonDocument = null;


    public static void main (String arge[]) throws ClientProtocolException, IOException, URISyntaxException{

        addParam("api_key", postcodeApiKey);
        getCall(postcodeBaseUrl+postcode);

    }


    public static void getCall(String endpoint) throws ClientProtocolException, IOException, URISyntaxException {

        generateMap(param);
        String url = endpoint;

//		URIBuilder builder = new URIBuilder();
//		builder.setPath(url);

        URIBuilder builder = new URIBuilder(endpoint);


        for (Entry<String, String> entry : param.entrySet()) {
            builder.setParameter(entry.getKey(), entry.getValue());
        }

        System.out.println(builder.toString());

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(builder.build());

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
//		System.out.println("");
//		System.out.println(result.toString());
        setResponse(result.toString());

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

    public static String getResponse() {
        return response;
    }


    public static void setResponse(String response) {
        Rest.response = response;
    }




    public String returnJson(String response, String jsonValue ) throws Throwable {

        Object document = savedJsonDocument;
        document = Configuration.defaultConfiguration().jsonProvider().parse(response);

        String test = JsonPath.read(document, jsonValue).toString();
        //System.out.println("Print json value -> " + test);
        return test;

    }

    public void return_follwing_json(String arg1) throws Throwable {

        System.out.println("current json "+ Rest.getResponse());

        Object document = Configuration.defaultConfiguration().jsonProvider().parse(Rest.getResponse());
        String theSavedJson = JsonPath.read(document, arg1).toString();
        System.out.println("The following Json String has been saved statically ");
        System.out.println(theSavedJson);

        theSavedJson = (theSavedJson.substring(1, theSavedJson.length()-1));
        savedJsonDocument = Configuration.defaultConfiguration().jsonProvider().parse(theSavedJson);
    }



}
