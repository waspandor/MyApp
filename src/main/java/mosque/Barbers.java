package mosque;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pandorw on 01/09/2016.
 */
public class Barbers {

    String locationValue;
    Rest rest = new Rest();
    PostCode postcode = new PostCode();

    public void findLocalMosques(String userPostcode) throws Throwable {

        locationValue = postcode.getLocationFromPostcode(userPostcode);

        String returnLocalMosques = GoogleApi.googleApiBaseUrl + "place/nearbysearch/json?location="
                + locationValue + "&rankby=distance&type=mosque&key=" + GoogleApi.apiKey;

        rest.getCall(returnLocalMosques);

        String listOfMosques = rest.returnJson(rest.getResponse(), "results[*].name");
        String str = (listOfMosques.replace("\"", "").replace("[", "").replace("]", ""));
        List<String> listAllMosques = Arrays.asList(str.split("\\s*,\\s*"));

        for (String singleMosque : listAllMosques) {
            System.out.println(singleMosque);
        }
    }

    public void returnMoreInfo(String keyword) throws Throwable {

        String replaceText = keyword;
        String newKeyword = replaceText.replace(' ', '+');

        // System.out.println(newKeyword);

        String test1 = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                + locationValue
                + "&keyword=" + newKeyword + "&type=mosque&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";

        rest.getCall(test1);

        System.out.println("Name: " + rest.returnJson(rest.getResponse(), ".name"));
        System.out.println("Open Now: " + rest.returnJson(rest.getResponse(), ".opening_hours.open_now"));
        System.out.println("Rating: " + rest.returnJson(rest.getResponse(), ".rating"));
        System.out.println("Id: " + rest.returnJson(rest.getResponse(), ".place_id"));
        System.out.println("Address " + rest.returnJson(rest.getResponse(), ".vicinity"));


        String placeId = rest.returnJson(rest.getResponse(), ".place_id");
        placeId = placeId.substring(placeId.indexOf("[") + 2, placeId.indexOf("]") - 1);
        //    System.out.println(placeId);

        String reference = rest.returnJson(rest.getResponse(), ".reference");
        reference = reference.substring(reference.indexOf("[") + 2, reference.indexOf("]") - 2);
        System.out.println(reference);

        String moreInfo = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";

        rest.getCall(moreInfo);
        System.out.println(rest.getResponse());
    }

}
