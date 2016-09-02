package unsorted;

public class Weather {

	public static String weatherBaseUrl = "http://api.wunderground.com/api/f6d8723cac1a7d96/forecast/q/";
	
		



	public String weatherUrl() {

		String url = Weather.weatherBaseUrl+ RestCalls.returnString()+".json";
		return url;
	}
}