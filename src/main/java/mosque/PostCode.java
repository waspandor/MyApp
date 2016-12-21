package mosque;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by pandorw on 21/12/2016.
 */
public class PostCode {

    String postcodeBaseUrl = "http://api.postcodes.io/postcodes/";
    String locationValue;


    Rest rest = new Rest();


    public String getLocationFromPostcode(String postCode) throws Throwable {

        rest.getCall(postcodeBaseUrl + postCode);

        if (rest.getResponse().contains("Postcode not found"))
            System.out.println(rest.returnJson(rest.getResponse(), "error"));

        else {
            locationValue = rest.returnJson(rest.getResponse(), "result.latitude")
                    + "," + rest.returnJson(rest.getResponse(), "result.longitude");

        }
        return locationValue;
    }

}
