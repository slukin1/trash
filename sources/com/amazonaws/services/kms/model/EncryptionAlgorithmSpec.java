package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum EncryptionAlgorithmSpec {
    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT"),
    RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256"),
    SM2PKE("SM2PKE");
    
    private static final Map<String, EncryptionAlgorithmSpec> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        EncryptionAlgorithmSpec encryptionAlgorithmSpec;
        EncryptionAlgorithmSpec encryptionAlgorithmSpec2;
        EncryptionAlgorithmSpec encryptionAlgorithmSpec3;
        EncryptionAlgorithmSpec encryptionAlgorithmSpec4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SYMMETRIC_DEFAULT", encryptionAlgorithmSpec);
        hashMap.put("RSAES_OAEP_SHA_1", encryptionAlgorithmSpec2);
        hashMap.put("RSAES_OAEP_SHA_256", encryptionAlgorithmSpec3);
        hashMap.put("SM2PKE", encryptionAlgorithmSpec4);
    }

    private EncryptionAlgorithmSpec(String str) {
        this.value = str;
    }

    public static EncryptionAlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EncryptionAlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
