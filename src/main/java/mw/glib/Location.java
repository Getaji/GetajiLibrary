package mw.glib;

/**
 * <p>地域を表すクラスです。
 * 地域名はすべて小文字で記されなければなりません。
 * 空文字は許可されていません。
 *
 * <p>このクラスはMW Localize Frameworkに属します。
 *
 * @since build001
 * @author Getaji
 */
public class Location {

    /** en_US(英語:United States)のLocationです。 */
    public static final Location EN_US = new Location("en_us");

    /** ja_JP(日本語:Japan)のLocationです。 */
    public static final Location JA_JP = new Location("ja_jp");

    private final String locateName;

    /**
     * Locationインスタンスを新たに生成します。
     *
     * @param locateName 地域名はすべて小文字に変換して格納されます
     */
    public Location(String locateName) {
        Checker.requireNonEmpty(locateName);

        this.locateName = locateName.toLowerCase();
    }

    /**
     * 登録した地域名を返します。
     * @return 地域名
     */
    public String getLocateName() {
        return this.locateName;
    }
}
