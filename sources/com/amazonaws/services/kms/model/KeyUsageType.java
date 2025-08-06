package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyUsageType {
    SIGN_VERIFY("SIGN_VERIFY"),
    ENCRYPT_DECRYPT("ENCRYPT_DECRYPT"),
    GENERATE_VERIFY_MAC("GENERATE_VERIFY_MAC"),
    KEY_AGREEMENT("KEY_AGREEMENT");
    
    private static final Map<String, KeyUsageType> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        KeyUsageType keyUsageType;
        KeyUsageType keyUsageType2;
        KeyUsageType keyUsageType3;
        KeyUsageType keyUsageType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIGN_VERIFY", keyUsageType);
        hashMap.put("ENCRYPT_DECRYPT", keyUsageType2);
        hashMap.put("GENERATE_VERIFY_MAC", keyUsageType3);
        hashMap.put("KEY_AGREEMENT", keyUsageType4);
    }

    private KeyUsageType(String str) {
        this.value = str;
    }

    public static KeyUsageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyUsageType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
