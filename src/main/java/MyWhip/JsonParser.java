package MyWhip;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * Created by pandorw on 17/03/2017.
 */
public class JsonParser {

    Object savedJsonDocument = null;

    public String returnJson(String json, String requiredValue ) throws Throwable {

        Object document = savedJsonDocument;
        document = Configuration.defaultConfiguration().jsonProvider().parse(json);
        return JsonPath.read(document, requiredValue).toString();

    }

    public String extractJsonFromXml(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];

    }


}
