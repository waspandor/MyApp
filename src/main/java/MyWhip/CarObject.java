package MyWhip;

import sun.rmi.runtime.NewThreadAction;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by pandorw on 17/03/2017.
 */
public class CarObject {

    String carDetailsResponse;
    JsonParser json = new JsonParser();
    NetworkUtils networkUtils = new NetworkUtils();

    public void carDetailsCheck(String registration) throws IOException, URISyntaxException {
        carDetailsResponse = networkUtils.get("http://www.regcheck.org.uk/api/reg.asmx/Check?RegistrationNumber="
                +registration + "&username=waspandor");

        carDetailsResponse = json.extractJsonFromXml(carDetailsResponse,"vehicleJson");
    }

    public String getCarMake() throws Throwable {
        return json.returnJson(carDetailsResponse,"CarMake.CurrentTextValue");
    }

    public String getCarDescription() throws Throwable {
        return json.returnJson(carDetailsResponse,"Description");

    }


}
