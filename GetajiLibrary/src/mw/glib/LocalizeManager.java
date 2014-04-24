package mw.glib;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>言語に応じて対応したテキストを返すローカライザーです。
 * <tt>en_us</tt>と<tt>ja_jp</tt>が初期化時に登録されます。
 *
 * <p>このクラスはローカライズ処理の一元化を目的に実装されました。
 *
 * <p><tt>UnLocalizedText</tt>(未翻訳テキスト)はすべて小文字の英字で記述します。
 * 分類ごとにドットかアンダーバーで区切るのが望ましいです。<br />
 * 例:<tt>job.swordman</tt> / <tt>apple_gold</tt>
 *
 * <p>未翻訳テキスト・翻訳テキストどちらも空文字が許可されています。
 *
 * <p>逐一地域を指定せずにローカライズできるように、<tt>CurrentLocation</tt>(現在の地域)を保持しています。
 * デフォルトで{@link Location#EN_US}がセットされています。
 * {@link LocalizeManager#getCurrentLocation()}で取得、
 * {@link LocalizeManager#setCurrentLocation(Location)}でセットできます。
 * 利用する場合は{@link LocalizeManager#getLocalizedTextWithCurrentLocation(String)}を用います。
 * このメソッドは<tt>CurrentLocation</tt>を使用してローカライズされたテキストを取得します。
 *
 * <p>このクラスはMW Localize Frameworkに属します。
 *
 * @since build001
 * @author Getaji
 */
public class LocalizeManager {

    /**
     * 地域名と地域をペアで所持するマップ。
     * 値の上書きは許可されている。
     */
    private final Map<String, Location> locationMap = new HashMap<>();

    /**
     * 地域とローカライズテキストのマップをペアで所持するマップ。
     */
    private final Map<Location, Map<String, String>> localizedMap = new HashMap<>();

    /**
     * 現在の地域。 デフォルトは{@link Location#EN_US}。
     */
    private Location currentLocation = Location.EN_US;

    /**
     * ローカライズマネージャーを初期化します。
     * {@link Location#EN_US}と{@link Location#JA_JP}がセットされます.
     */
    public LocalizeManager() {
        addLocation(Location.EN_US);
        addLocation(Location.JA_JP);
    }

    /**
     * 地域名から格納されている地域を返します。
     *
     * @param name 地域名
     * @return 地域
     */
    public Location getLocation(String name) {
        Objects.requireNonNull(name);

        return locationMap.get(name);
    }

    /**
     * 地域を追加します。
     *
     * @param location 地域
     * @throws LocalizeException Locationがすでに入っていた場合にスロー
     */
    public void addLocation(Location location) throws LocalizeException {
        Objects.requireNonNull(location);

        if (locationMap.containsValue(location)) {
            throw new LocalizeException("Contains this location : " + location.getLocateName());
        } else {
            locationMap.put(location.getLocateName(), location);
            localizedMap.put(location, new HashMap<String, String>());
        }
    }

    /**
     * 指定した地域名の地域がすでに登録されているか返します。
     *
     * @param name 地域名
     * @return 登録されているか
     */
    public boolean isRegisteredLocation(String name) {
        Objects.requireNonNull(name);

        return locationMap.containsKey(name);
    }

    /**
     * 指定した地域インスタンスがすでに登録されているか返します。
     *
     * @param location 地域
     * @return 登録されているか
     */
    public boolean isRegisteredLocation(Location location) {
        Objects.requireNonNull(location);

        return locationMap.containsValue(location);
    }

    /**
     * 地域を指定してローカライズされたテキストを追加します。
     *
     * @param location 地域
     * @param unLocalizedText 未ローカライズ文字列
     * @param localizeText ローカライズ済文字列
     * @throws LocalizeException locationが登録されていなかった場合にスロー
     */
    public void addLocalizedText(Location location, String unLocalizedText, String localizeText)
            throws LocalizeException {
        Checker.requireAndNonNull(location, unLocalizedText, localizeText);

        if (!this.isRegisteredLocation(location)) {
            throw new LocalizeException("This location is not registered : " + location.getLocateName());
        } else {
            localizedMap.get(location).put(unLocalizedText, localizeText);
        }
    }

    /**
     * ローカライズされたテキストを返します。
     *
     * @param location 地域
     * @param unLocalizedText 未ローカライズテキスト
     * @return ローカライズされたテキスト
     */
    public String getLocalizedText(Location location, String unLocalizedText) {
        Checker.requireAndNonNull(location, unLocalizedText);

        return localizedMap.get(location).get(unLocalizedText);
    }

    /**
     * <tt>CurrentLocation</tt>(現在の地域)を返します。
     *
     * @return 現在の地域
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * <tt>CurrentLocation</tt>(現在の地域)をセットします。
     * 登録されている地域のみセットできます。
     *
     * @param location <tt>CurrentLocation</tt>(現在の地域)
     * @throws LocalizeException 地域が登録されていない場合にスロー
     */
    public void setCurrentLocation(Location location) throws LocalizeException {
        Checker.requireNonNull(location);

        if (!isRegisteredLocation(location)) {
            throw new LocalizeException("This location is not registered : " + location.getLocateName());
        } else {
            this.currentLocation = location;
        }
    }

    /**
     * <p><tt>CurrentLocation</tt>(現在の地域)をもとにローカライズされたテキストを返します。
     *
     * <p>このメソッドは冗長なメソッド名のため非推奨となりました。
     * 同機能の{@link LocalizeManager#getLocalizedText(String)}を利用してください。
     *
     * @param unLocalizedText 未翻訳テキスト
     * @return ローカライズ（翻訳）テキスト
     */
    @Deprecated
    public String getLocalizedTextWithCurrentLocation(String unLocalizedText) {
        Checker.requireNonNull(unLocalizedText);

        return localizedMap.get(currentLocation).get(unLocalizedText);
    }

    /**
     * <tt>CurrentLocation</tt>(現在の地域)をもとにローカライズされたテキストを返します。
     *
     * @param unLocalizedText 未翻訳テキスト
     * @return ローカライズ（翻訳）テキスト
     */
    public String getLocalizedText(String unLocalizedText) {
        Checker.requireNonNull(unLocalizedText);

        return localizedMap.get(currentLocation).get(unLocalizedText);
    }
}
