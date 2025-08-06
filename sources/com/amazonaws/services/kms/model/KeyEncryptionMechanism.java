package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyEncryptionMechanism {
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256");
    
    private static final Map<String, KeyEncryptionMechanism> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        KeyEncryptionMechanism keyEncryptionMechanism;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSAES_OAEP_SHA_256", keyEncryptionMechanism);
    }

    private KeyEncryptionMechanism(String str) {
        this.value = str;
    }

    public static KeyEncryptionMechanism fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyEncryptionMechanism> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
