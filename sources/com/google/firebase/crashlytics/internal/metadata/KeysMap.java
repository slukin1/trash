package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private final int maxEntries;
    private final int maxEntryLength;

    public KeysMap(int i11, int i12) {
        this.maxEntries = i11;
        this.maxEntryLength = i12;
    }

    private String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeString(str, this.maxEntryLength);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String sanitizeString(String str, int i11) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i11 ? trim.substring(0, i11) : trim;
    }

    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.keys));
    }

    public synchronized boolean setKey(String str, String str2) {
        String sanitizeKey = sanitizeKey(str);
        if (this.keys.size() >= this.maxEntries) {
            if (!this.keys.containsKey(sanitizeKey)) {
                Logger logger = Logger.getLogger();
                logger.w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.maxEntries);
                return false;
            }
        }
        String sanitizeString = sanitizeString(str2, this.maxEntryLength);
        if (CommonUtils.nullSafeEquals(this.keys.get(sanitizeKey), sanitizeString)) {
            return false;
        }
        Map<String, String> map = this.keys;
        if (str2 == null) {
            sanitizeString = "";
        }
        map.put(sanitizeKey, sanitizeString);
        return true;
    }

    public synchronized void setKeys(Map<String, String> map) {
        int i11 = 0;
        for (Map.Entry next : map.entrySet()) {
            String sanitizeKey = sanitizeKey((String) next.getKey());
            if (this.keys.size() >= this.maxEntries) {
                if (!this.keys.containsKey(sanitizeKey)) {
                    i11++;
                }
            }
            String str = (String) next.getValue();
            this.keys.put(sanitizeKey, str == null ? "" : sanitizeString(str, this.maxEntryLength));
        }
        if (i11 > 0) {
            Logger logger = Logger.getLogger();
            logger.w("Ignored " + i11 + " entries when adding custom keys. Maximum allowable: " + this.maxEntries);
        }
    }
}
