package mw.glib;

import java.util.HashMap;
import java.util.Map;

/**
 * 言語に応じて対応したテキストを返すローカライザーです.<br />
 * デフォルトでen_usとja_jpが付属し, これらは標準で登録されています.
 *
 * <h2>書式規則</h2>
 * UnLocalizedText(未翻訳テキスト)はすべて小文字の英字で記述します.
 */
public class LocalizeManager {

    private final Map<String, Location> locationMap = new HashMap<>();

    private final Map<Location, Map<String, String>> localizedMap = new HashMap<>();

    private Location currentLocation = Location.EN_US;

    public LocalizeManager() {
        addLocation(Location.EN_US.getLocateName(), Location.EN_US);
        addLocation(Location.JA_JP.getLocateName(), Location.JA_JP);
    }

    public Location getLocation(String name) {
        return locationMap.get(name);
    }

    public void addLocation(String name, Location location) throws LocalizeException {
        if (name == null || location == null || name.equals(location.getLocateName())) {
            throw new LocalizeException("Parameter error");
        } else if (locationMap.containsValue(location)) {
            throw new LocalizeException("Contains this location : " + location.getLocateName());
        } else {
            locationMap.put(name, location);
            localizedMap.put(location, new HashMap<String, String>());
        }
    }

    public boolean isRegisteredLocation(String name) {
        return locationMap.containsKey(name);
    }

    public boolean isRegisteredLocation(Location location) {
        return locationMap.containsValue(location);
    }

    public void addLocalizedText(Location location, String unLocalizedText, String localizeText)
            throws LocalizeException {
        if (location == null || unLocalizedText == null || localizeText == null ||
                unLocalizedText.isEmpty() || localizeText.isEmpty()) {
            throw new LocalizeException("Parameter error");
        } else if (!this.isRegisteredLocation(location)) {
            throw new LocalizeException("This location is not registered : " + location.getLocateName());
        } else {
            localizedMap.get(location).put(unLocalizedText, localizeText);
        }
    }

    public String getLocalizedText(Location location, String unLocalizedText) {

        return localizedMap.get(location).get(unLocalizedText);
    }

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
