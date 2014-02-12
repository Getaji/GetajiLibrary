package mw.glib;

/**
 * Created with IntelliJ IDEA.
 * User: user9
 * Date: 14/02/12
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public class Location {

    /** en_US(英語:United States)のLocationです. */
    public static final Location EN_US = new Location("en_us");

    /** ja_JP(日本語:Japan)のLocationです. */
    public static final Location JA_JP = new Location("ja_jp");

    private final String locateName;

    public Location(String locateName) {
        this.locateName = locateName;
    }

    public String getLocateName() {
        return this.locateName;
    }
}
