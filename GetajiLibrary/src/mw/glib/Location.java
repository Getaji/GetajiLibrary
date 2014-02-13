package mw.glib;

/**
 * 地域を表すクラスです.<br />
 * 地域名はすべて小文字で記されなければなりません.
 */
public class Location {

    /** en_US(英語:United States)のLocationです. */
    public static final Location EN_US = new Location("en_us");

    /** ja_JP(日本語:Japan)のLocationです. */
    public static final Location JA_JP = new Location("ja_jp");

    private final String locateName;

    /**
     * Locationインスタンスを新たに生成します.
     * @param locateName 地域名はすべて小文字に変換して格納されます
     */
    public Location(String locateName) {
        if (locateName == null || locateName.isEmpty()) {
            throw new LocalizeException("Location is null or empty");
        } else {
            this.locateName = locateName.toLowerCase();
        }
    }

    public String getLocateName() {
        return this.locateName;
    }
}
