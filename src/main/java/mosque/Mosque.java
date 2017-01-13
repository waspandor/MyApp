package mosque;

/**
 * Created by pandorw on 13/01/2017.
 */
public class Mosque {

    String name;
    String address;

    Prayer[] prayer = new Prayer[5];

    public Mosque(String name) {
        this.name = name;

        for (int i = 0; i < prayer.length; i++) {
            prayer[i] = new Prayer();
        }

        prayer[0].setTime("00:00 AM");
        prayer[1].setTime("00:00 AM");
        prayer[2].setTime("00:00 AM");
        prayer[3].setTime("00:00 AM");
        prayer[4].setTime("00:00 AM");

    }

    public String nextPrayer() {
        return "";
    }

    public void test() {

        System.out.println(prayer[0].getTime());
    }

    public String getFajr() {
        return prayer[0].getTime();
    }

    public String getZuhr() {
        return prayer[1].getTime();
    }

    public String getAsr() {
        return prayer[2].getTime();
    }

    public String getMaghrib() {
        return prayer[3].getTime();
    }

    public String getEsha() {
        return prayer[4].getTime();

    }

    public void returnAll() {

        for (int i = 0; i < prayer.length; i++) {

            System.out.println( prayer[i].getTime());
        }
    }
}
