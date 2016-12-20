package mosque;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pandorw on 01/09/2016.
 */
public class Barbers {

    static  String locationValue;
    Rest restCall = new Rest();
    ArrayList<String> mosques = new ArrayList<String>();







    public  void findLocalBarbers(String postCode) throws Throwable{

        restCall.getCall("http://api.postcodes.io/postcodes/"+postCode);

        if (restCall.getResponse().contains("Postcode not found"))
            System.out.println(restCall.returnJson(restCall.getResponse(),"error"));

        else {
            locationValue = restCall.returnJson(restCall.getResponse(), "result.latitude")
                    + ","
                    + restCall.returnJson(restCall.getResponse(), "result.longitude");

    //        System.out.println("Location Value");
      //      System.out.println(locationValue);

            String test = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                    + locationValue
                    + "&rankby=distance&type=mosque&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";

  //          System.out.println(test);
            restCall.getCall(test);

//            System.out.println("");
  //          System.out.println("Json Response");

            //System.out.println(restCall.getResponse());
            //System.out.println(restCall.returnJson(restCall.getResponse(), "results[*].name"));

            String listOfMosques = restCall.returnJson(restCall.getResponse(), "results[*].name");

            String str = (listOfMosques.replace("\"", "").replace("[","").replace("}",""));

            //String[] mosques = listOfMosques.split();

            List<String> items = Arrays.asList(str.split("\\s*,\\s*"));



            for (String temp : items) {
                System.out.println(temp);
            }




        }

    }


    public  void returnMoreInfo(String keyword) throws Throwable{

        String replaceText = keyword;
        String newKeyword = replaceText.replace(' ', '+');

       // System.out.println(newKeyword);

        String test1 =  "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                + locationValue
                + "&keyword="+newKeyword+"&type=mosque&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";
      //  System.out.println(test1);
        restCall.getCall(test1);

    //    System.out.println(restCall.getResponse());

        System.out.println("Name: "+restCall.returnJson(restCall.getResponse(), ".name"));
        System.out.println("Open Now: "+restCall.returnJson(restCall.getResponse(), ".opening_hours.open_now"));
        System.out.println("Rating: "+ restCall.returnJson(restCall.getResponse(), ".rating"));
       // System.out.println("Id: "+restCall.returnJson(restCall.getResponse(), ".place_id"));
        System.out.println("Address "+restCall.returnJson(restCall.getResponse(), ".vicinity"));


        String placeId = restCall.returnJson(restCall.getResponse(), ".place_id");
        placeId = placeId.substring(placeId.indexOf("[")+2,placeId.indexOf("]")-1);
    //    System.out.println(placeId);

        String reference = restCall.returnJson(restCall.getResponse(), ".reference");
        reference = reference.substring(reference.indexOf("[")+2,reference.indexOf("]")-2);
     //   System.out.println(reference);

        String moreInfo = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&key=AIzaSyCcrqYTwcNLIEkBwTaYDg6Jt6g7Q0jbDRQ";

        restCall.getCall(moreInfo);
    //    System.out.println(restCall.getResponse());
    }

}
