package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum DataKeyPairSpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SM2("SM2");
    
    private static final Map<String, DataKeyPairSpec> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        DataKeyPairSpec dataKeyPairSpec;
        DataKeyPairSpec dataKeyPairSpec2;
        DataKeyPairSpec dataKeyPairSpec3;
        DataKeyPairSpec dataKeyPairSpec4;
        DataKeyPairSpec dataKeyPairSpec5;
        DataKeyPairSpec dataKeyPairSpec6;
        DataKeyPairSpec dataKeyPairSpec7;
        DataKeyPairSpec dataKeyPairSpec8;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", dataKeyPairSpec);
        hashMap.put("RSA_3072", dataKeyPairSpec2);
        hashMap.put("RSA_4096", dataKeyPairSpec3);
        hashMap.put("ECC_NIST_P256", dataKeyPairSpec4);
        hashMap.put("ECC_NIST_P384", dataKeyPairSpec5);
        hashMap.put("ECC_NIST_P521", dataKeyPairSpec6);
        hashMap.put("ECC_SECG_P256K1", dataKeyPairSpec7);
        hashMap.put("SM2", dataKeyPairSpec8);
    }

    private DataKeyPairSpec(String str) {
        this.value = str;
    }

    public static DataKeyPairSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DataKeyPairSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
