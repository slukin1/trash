package com.amazonaws.services.kms.model;

import com.tencent.android.tpush.stat.ServiceStat;
import java.util.HashMap;
import java.util.Map;

public enum GrantOperation {
    Decrypt("Decrypt"),
    Encrypt("Encrypt"),
    GenerateDataKey("GenerateDataKey"),
    GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),
    ReEncryptFrom("ReEncryptFrom"),
    ReEncryptTo("ReEncryptTo"),
    Sign("Sign"),
    Verify(ServiceStat.VERIFY_EVENT_ID),
    GetPublicKey("GetPublicKey"),
    CreateGrant("CreateGrant"),
    RetireGrant("RetireGrant"),
    DescribeKey("DescribeKey"),
    GenerateDataKeyPair("GenerateDataKeyPair"),
    GenerateDataKeyPairWithoutPlaintext("GenerateDataKeyPairWithoutPlaintext"),
    GenerateMac("GenerateMac"),
    VerifyMac("VerifyMac"),
    DeriveSharedSecret("DeriveSharedSecret");
    
    private static final Map<String, GrantOperation> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        GrantOperation grantOperation;
        GrantOperation grantOperation2;
        GrantOperation grantOperation3;
        GrantOperation grantOperation4;
        GrantOperation grantOperation5;
        GrantOperation grantOperation6;
        GrantOperation grantOperation7;
        GrantOperation grantOperation8;
        GrantOperation grantOperation9;
        Object obj;
        GrantOperation grantOperation10;
        GrantOperation grantOperation11;
        GrantOperation grantOperation12;
        GrantOperation grantOperation13;
        GrantOperation grantOperation14;
        GrantOperation grantOperation15;
        GrantOperation grantOperation16;
        GrantOperation grantOperation17;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Decrypt", grantOperation);
        hashMap.put("Encrypt", grantOperation2);
        hashMap.put("GenerateDataKey", grantOperation3);
        hashMap.put("GenerateDataKeyWithoutPlaintext", grantOperation4);
        hashMap.put("ReEncryptFrom", grantOperation5);
        hashMap.put("ReEncryptTo", grantOperation6);
        hashMap.put("Sign", grantOperation7);
        hashMap.put(obj, grantOperation8);
        hashMap.put("GetPublicKey", grantOperation9);
        hashMap.put("CreateGrant", grantOperation10);
        hashMap.put("RetireGrant", grantOperation11);
        hashMap.put("DescribeKey", grantOperation12);
        hashMap.put("GenerateDataKeyPair", grantOperation13);
        hashMap.put("GenerateDataKeyPairWithoutPlaintext", grantOperation14);
        hashMap.put("GenerateMac", grantOperation15);
        hashMap.put("VerifyMac", grantOperation17);
        hashMap.put("DeriveSharedSecret", grantOperation16);
    }

    private GrantOperation(String str) {
        this.value = str;
    }

    public static GrantOperation fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, GrantOperation> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
