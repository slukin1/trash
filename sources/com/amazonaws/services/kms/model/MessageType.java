package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {
    RAW("RAW"),
    DIGEST("DIGEST");
    
    private static final Map<String, MessageType> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        MessageType messageType;
        MessageType messageType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RAW", messageType);
        hashMap.put("DIGEST", messageType2);
    }

    private MessageType(String str) {
        this.value = str;
    }

    public static MessageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, MessageType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
