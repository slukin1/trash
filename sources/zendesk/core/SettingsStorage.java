package zendesk.core;

import com.google.gson.JsonElement;
import java.util.Map;
import java.util.concurrent.TimeUnit;

interface SettingsStorage {
    boolean areSettingsUpToDate(long j11, TimeUnit timeUnit);

    void clear();

    Map<String, JsonElement> getRawSettings();

    <E> E getSettings(String str, Class<E> cls);

    boolean hasStoredSettings();

    void storeRawSettings(Map<String, JsonElement> map);
}
