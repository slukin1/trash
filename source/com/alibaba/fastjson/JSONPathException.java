package com.alibaba.fastjson;

public class JSONPathException extends JSONException {
    public JSONPathException(String str) {
        super(str);
    }

    public JSONPathException(String str, Throwable th2) {
        super(str, th2);
    }
}
