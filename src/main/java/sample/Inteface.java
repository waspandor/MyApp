package sample;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import sample.RestCalls;

public class Inteface {

	static RestCalls rest;
	static Weather weather = new Weather();
	static Postcode postcode;

	public static void main(String[] args) throws Throwable {

		rest = new RestCalls();
		postcode = new Postcode();

//		rest.addString("UK");
//		rest.addString("London");
//		
//	
//
//		System.out.println(weather.weatherUrl());
//
//		rest.sendGet(weather.weatherUrl());
//		System.out.println("");
//		System.out.println(rest.getResponse());
//		
//		System.out.println(rest.returnJson("forecast.txt_forecast.forecastday[2].fcttext_metric"));
//		System.out.println(rest.returnJson("forecast.txt_forecast.forecastday[2].title"));

//		System.out.println(rest.returnJson(rest.getResponse(), "forecastday[0].date.day"));

//		Postcode.addParam("api_key", Postcode.postcodeApiKey);
//		Postcode.getCall(Postcode.postcodeBaseUrl+Postcode.postcode);
//		
//		System.out.println(rest.returnJson(Postcode.getResponse(),"result[0].longitude"));
//		System.out.println(rest.returnJson(Postcode.getResponse(),"result[0].latitude"));
//		
//		
//		
//		String longitude = rest.returnJson(Postcode.getResponse(),"result[0].longitude");
//		String latitude = rest.returnJson(Postcode.getResponse(),"result[0].latitude");
//		
//		GetCall.addParam("app_id", "ziKwjnsbyEbJf9RHXZzU");
//		GetCall.addParam("app_code", "QGSQs3Y3w_D3HhJBR9MrPg");
//		
//		GetCall.addParam("waypoint0", latitude);
//		GetCall.addParam("waypoint1", longitude);
//		
//		GetCall.getCall("https://route.cit.api.here.com/routing/7.2/calculateroute.json");

		
//		Postcode.getCall("http://api.postcodes.io/postcodes/n12qp");
//		System.out.println(rest.returnJson(Postcode.getResponse(),"result.longitude"));
//		System.out.println(rest.returnJson(Postcode.getResponse(),"result.latitude"));

		findLocalBarbers("n12qp");



		String s;
		Scanner in = new Scanner(System.in);

		System.out.println("Please type in a selection");
		s = in.nextLine();

		returnMoreInfo(s);

//		Postcode.getCall("http://api.postcodes.io/postcodes/test");
//		System.out.println(Postcode.getResponse());
//		System.out.println(rest.returnJson(Postcode.getResponse(),"error"));



	}

	static  String locationValue;

	public static void findLocalBarbers(String postCode) throws Throwable{

		Postcode.getCall("http://api.postcodes.io/postcodes/"+postCode);

		if (Postcode.getResponse().contains("Postcode not found"))
			System.out.println(rest.returnJson(Postcode.getResponse(),"error"));

		else {

			locationValue = rest.returnJson(Postcode.getResponse(), "result.latitude")
					+ ","
					+ rest.returnJson(Postcode.getResponse(), "result.longitude");

			System.out.println("Location Value");
			System.out.println(locationValue);

			String test = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
					+ locationValue
					+ "&radius=500&type=hair_care&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";

			System.out.println(test);
			Postcode.getCall(test);

			System.out.println("");
			System.out.println("Json Response");
			System.out.println(rest.returnJson(Postcode.getResponse(), "results[*].name"));



		}

	}

	public static void returnMoreInfo(String keyword) throws Throwable{



		String replaceText = keyword;
		String newKeyword = replaceText.replace(' ', '+');

		System.out.println(newKeyword);

		String test1 =  "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
				+ locationValue
				+ "&radius=500&keyword="+newKeyword+"&type=hair_care&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";
		System.out.println(test1);
		Postcode.getCall(test1);

		System.out.println(Postcode.getResponse());

		System.out.println("Name: "+rest.returnJson(Postcode.getResponse(), ".name"));
		System.out.println("Open Now: "+rest.returnJson(Postcode.getResponse(), ".opening_hours.open_now"));
		System.out.println("Rating: "+ rest.returnJson(Postcode.getResponse(), ".rating"));
		System.out.println("Id: "+rest.returnJson(Postcode.getResponse(), ".place_id"));
		System.out.println("Address "+rest.returnJson(Postcode.getResponse(), ".vicinity"));





	}


}
