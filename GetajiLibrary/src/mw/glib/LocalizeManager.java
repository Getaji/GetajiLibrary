package mw.glib;

import java.util.HashMap;
import java.util.Map;

/**
 * 言語に応じて対応したテキストを返すローカライザーです.<br />
 * デフォルトでen_usとja_jpが付属し, これらは標準で登録されています.
 *
 * <h2>書式規則</h2>
 * UnLocalizedText(未翻訳テキスト)はすべて小文字の英字で記述します.<br />
 * 分類ごとにドットかアンダーバーで区切るのが望ましいです.<br />
 * 例:job.swordman / apple_gold
 *
 * <h2>CurrentLocation</h2>
 * 逐一地域を指定せずにローカライズできるように, CurrentLocation(現在の地域)を保持しています.<br />
 * デフォルトで{@link Location#EN_US}がセットされています.<br />
 * {@link mw.glib.LocalizeManager#getCurrentLocation()}で取得,
 * {@link LocalizeManager#setCurrentLocation(Location)}でセットできます.<br />
 * 利用する場合は{@link LocalizeManager#getLocalizedTextWithCurrentLocation(String)}を用います.<br />
 * このメソッドはCurrentLocationを使用してローカライズされたテキストを取得します.
 */
public class LocalizeManager {

    /**
     * 地域名と地域をペアで所持するマップ.<br />
     * 値の上書きは許可されている.
     */
    private final Map<String, Location> locationMap = new HashMap<>();

    /**
     * 地域とローカライズテキストのマップをペアで所持するマップ.
     */
    private final Map<Location, Map<String, String>> localizedMap = new HashMap<>();

    /**
     * 現在の地域. デフォルトは{@link Location#EN_US}.
     */
    private Location currentLocation = Location.EN_US;

    /**
     * ローカライズマネージャーを初期化する.<br />
     * {@link Location#EN_US}と{@link Location#JA_JP}がセットされる.
     */
    public LocalizeManager() {
        addLocation(Location.EN_US);
        addLocation(Location.JA_JP);
    }

    /**
     * 地域名から, 格納されている地域を取得する.
     * @param name 地域名
     * @return 地域
     */
    public Location getLocation(String name) {
        return locationMap.get(name);
    }

    /**
     * 地域を追加する.
     * @param location 地域
     * @throws IllegalArgumentException Locationがnullの場合にスロー
     * @throws LocalizeException Locationがすでに入っていた場合スロー
     */
    public void addLocation(Location location) throws IllegalArgumentException, LocalizeException {
        if (location == null) {
            throw new IllegalArgumentException("Location is null");
        } else if (locationMap.containsValue(location)) {
            throw new LocalizeException("Contains this location : " + location.getLocateName());
        } else {
            locationMap.put(location.getLocateName(), location);
            localizedMap.put(location, new HashMap<String, String>());
        }
    }

    /**
     * 指定した地域名の地域がすでに登録されているか調べる.
     * @param name 地域名
     * @return 登録されているか
     */
    public boolean isRegisteredLocation(String name) {
        return locationMap.containsKey(name);
    }

    /**
     * 指定した地域インスタンスがすでに登録されているか調べる.
     * @param location 地域
     * @return 登録されているか
     */
    public boolean isRegisteredLocation(Location location) {
        return locationMap.containsValue(location);
    }

    /**
     * 地域を指定してローカライズされたテキストを追加する.
     * @param location 地域
     * @param unLocalizedText 未ローカライズ文字列
     * @param localizeText ローカライズ済文字列
     * @throws IllegalArgumentException
     * @throws LocalizeException
     */
    public void addLocalizedText(Location location, String unLocalizedText, String localizeText)
            throws IllegalArgumentException, LocalizeException {
        if (checkNull(location, unLocalizedText, localizeText) ||
                checkEmpty(unLocalizedText, localizeText)) {
            throw new IllegalArgumentException("Parameter is null or empty");
        } else if (!this.isRegisteredLocation(location)) {
            throw new LocalizeException("This location is not registered : " + location.getLocateName());
        } else {
            localizedMap.get(location).put(unLocalizedText, localizeText);
        }
    }

    private boolean checkNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEmpty(String... strings) {
        for (String string : strings) {
            if (string.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * ローカライズされたテキストを返します.
     * @param location 地域
     * @param unLocalizedText 未ローカライズテキスト
     * @return ローカライズされたテキスト
     * @throws NullPointerException 地域が存在しない
     */
    public String getLocalizedText(Location location, String unLocalizedText)
            throws NullPointerException {
        return localizedMap.get(location).get(unLocalizedText);
    }

    /**
     * 現在の地域を返します.
     * @return 現在の地域
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) throws LocalizeException{
        if (!isRegisteredLocation(location)) {
            throw new LocalizeException("This location is not registered : " + location.getLocateName());
        } else if (location == null) {
            throw new LocalizeException("Parameter error");
        } else {
            this.currentLocation = location;
        }
    }

    public String getLocalizedTextWithCurrentLocation(String unLocalizedText)
            throws NullPointerException, LocalizeException {
        if (unLocalizedText == null) {
            throw new NullPointerException("Null this parameter");
        } else if (unLocalizedText.isEmpty()) {
            throw new LocalizeException("Empty this parameter");
        } else {
            return localizedMap.get(currentLocation).get(unLocalizedText);
        }
    }
}
