package com.alibaba.fastjson.serializer;

import h2.j;

public class PascalNameFilter implements j {
    public String a(Object obj, String str, Object obj2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }
}
