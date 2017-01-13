package mosque;

/**
 * Created by pandorw on 13/01/2017.
 */
public class Prayer {

    private String name;
    private String time;
    private String date;
    private String jamatTime;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJamatTime() {
        return jamatTime;
    }

    public void setJamatTime(String jamatTime) {
        this.jamatTime = jamatTime;
    }
}
