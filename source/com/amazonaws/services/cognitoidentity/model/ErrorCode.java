package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
    AccessDenied("AccessDenied"),
    InternalServerError(GmsRpc.ERROR_INTERNAL_SERVER_ERROR_ALT);
    
    private static final Map<String, ErrorCode> enumMap = null;
    private String value;

    /* access modifiers changed from: public */
    static {
        ErrorCode errorCode;
        ErrorCode errorCode2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AccessDenied", errorCode);
        hashMap.put(GmsRpc.ERROR_INTERNAL_SERVER_ERROR_ALT, errorCode2);
    }

    private ErrorCode(String str) {
        this.value = str;
    }

    public static ErrorCode fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ErrorCode> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
