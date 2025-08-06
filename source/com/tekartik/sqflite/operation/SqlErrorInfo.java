package com.tekartik.sqflite.operation;

import java.util.HashMap;
import java.util.Map;
import xy.b;
import yy.d;

public class SqlErrorInfo {
    public static Map<String, Object> a(d dVar) {
        b b11 = dVar.b();
        if (b11 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", b11.e());
        hashMap.put("arguments", b11.d());
        return hashMap;
    }
}
