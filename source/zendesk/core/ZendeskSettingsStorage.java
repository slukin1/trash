package zendesk.core;

import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import mz.f;

class ZendeskSettingsStorage implements SettingsStorage {
    private static final String LAST_UPDATE = "last_settings_update";
    private static final String RAWSETTTINGS_KEYSET = "rawsettings_keyset";
    private final BaseStorage settingsStorage;

    public ZendeskSettingsStorage(BaseStorage baseStorage) {
        this.settingsStorage = baseStorage;
    }

    public boolean areSettingsUpToDate(long j11, TimeUnit timeUnit) {
        Long l11;
        synchronized (this.settingsStorage) {
            l11 = (Long) this.settingsStorage.get(LAST_UPDATE, Long.class);
        }
        if (l11 == null || l11.longValue() == -1) {
            return false;
        }
        if (System.currentTimeMillis() - l11.longValue() < TimeUnit.MILLISECONDS.convert(j11, timeUnit)) {
            return true;
        }
        return false;
    }

    public void clear() {
        synchronized (this.settingsStorage) {
            this.settingsStorage.clear();
        }
    }

    public Map<String, JsonElement> getRawSettings() {
        HashMap hashMap;
        synchronized (this.settingsStorage) {
            hashMap = new HashMap();
            Set<String> set = (Set) this.settingsStorage.get(RAWSETTTINGS_KEYSET, Set.class);
            if (set != null) {
                for (String str : set) {
                    if (str != null) {
                        hashMap.put(str, (JsonElement) this.settingsStorage.get(str, JsonElement.class));
                    }
                }
            }
        }
        return hashMap;
    }

    public <E> E getSettings(String str, Class<E> cls) {
        E e11;
        synchronized (this.settingsStorage) {
            e11 = this.settingsStorage.get(str, cls);
        }
        return e11;
    }

    public boolean hasStoredSettings() {
        boolean c11;
        synchronized (this.settingsStorage) {
            c11 = f.c(this.settingsStorage.get(LAST_UPDATE));
        }
        return c11;
    }

    public void storeRawSettings(Map<String, JsonElement> map) {
        synchronized (this.settingsStorage) {
            this.settingsStorage.put(LAST_UPDATE, (Object) Long.valueOf(System.currentTimeMillis()));
            for (Map.Entry next : map.entrySet()) {
                this.settingsStorage.put((String) next.getKey(), next.getValue());
            }
            this.settingsStorage.put(RAWSETTTINGS_KEYSET, (Object) map.keySet());
        }
    }
}
