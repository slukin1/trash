package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.DecodeHintType;
import com.sumsub.sns.internal.core.analytics.d;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

final class DecodeHintManager {
    private static final Pattern COMMA = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final String TAG = "DecodeHintManager";

    private DecodeHintManager() {
    }

    public static Map<DecodeHintType, ?> parseDecodeHints(Uri uri) {
        String str;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return null;
        }
        Map<String, String> splitQuery = splitQuery(encodedQuery);
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (!(decodeHintType == DecodeHintType.CHARACTER_SET || decodeHintType == DecodeHintType.NEED_RESULT_POINT_CALLBACK || decodeHintType == DecodeHintType.POSSIBLE_FORMATS || (str = splitQuery.get(decodeHintType.name())) == null)) {
                if (decodeHintType.getValueType().equals(Object.class)) {
                    enumMap.put(decodeHintType, str);
                } else if (decodeHintType.getValueType().equals(Void.class)) {
                    enumMap.put(decodeHintType, Boolean.TRUE);
                } else if (decodeHintType.getValueType().equals(String.class)) {
                    enumMap.put(decodeHintType, str);
                } else if (decodeHintType.getValueType().equals(Boolean.class)) {
                    if (str.isEmpty()) {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    } else if ("0".equals(str) || d.f31895b.equalsIgnoreCase(str) || "no".equalsIgnoreCase(str)) {
                        enumMap.put(decodeHintType, Boolean.FALSE);
                    } else {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    }
                } else if (decodeHintType.getValueType().equals(int[].class)) {
                    if (!str.isEmpty() && str.charAt(str.length() - 1) == ',') {
                        str = str.substring(0, str.length() - 1);
                    }
                    String[] split = COMMA.split(str);
                    int[] iArr = new int[split.length];
                    int i11 = 0;
                    while (i11 < split.length) {
                        try {
                            iArr[i11] = m.k0(split[i11]);
                            i11++;
                        } catch (NumberFormatException unused) {
                            Log.w(TAG, "Skipping array of integers hint " + decodeHintType + " due to invalid numeric value: '" + split[i11] + '\'');
                            iArr = null;
                        }
                    }
                    if (iArr != null) {
                        enumMap.put(decodeHintType, iArr);
                    }
                } else {
                    Log.w(TAG, "Unsupported hint type '" + decodeHintType + "' of type " + decodeHintType.getValueType());
                }
            }
        }
        Log.i(TAG, "Hints from the URI: " + enumMap);
        return enumMap;
    }

    private static Map<String, String> splitQuery(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (true) {
            if (i11 >= str.length()) {
                break;
            } else if (str.charAt(i11) == '&') {
                i11++;
            } else {
                int indexOf = str.indexOf(38, i11);
                int indexOf2 = str.indexOf(61, i11);
                String str3 = "";
                if (indexOf < 0) {
                    if (indexOf2 < 0) {
                        str2 = Uri.decode(str.substring(i11).replace('+', ' '));
                    } else {
                        String decode = Uri.decode(str.substring(i11, indexOf2).replace('+', ' '));
                        str3 = Uri.decode(str.substring(indexOf2 + 1).replace('+', ' '));
                        str2 = decode;
                    }
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(str2, str3);
                    }
                } else {
                    if (indexOf2 < 0 || indexOf2 > indexOf) {
                        String decode2 = Uri.decode(str.substring(i11, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode2)) {
                            hashMap.put(decode2, str3);
                        }
                    } else {
                        String decode3 = Uri.decode(str.substring(i11, indexOf2).replace('+', ' '));
                        String decode4 = Uri.decode(str.substring(indexOf2 + 1, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode3)) {
                            hashMap.put(decode3, decode4);
                        }
                    }
                    i11 = indexOf + 1;
                }
            }
        }
        return hashMap;
    }

    public static Map<DecodeHintType, Object> parseDecodeHints(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (!(decodeHintType == DecodeHintType.CHARACTER_SET || decodeHintType == DecodeHintType.NEED_RESULT_POINT_CALLBACK || decodeHintType == DecodeHintType.POSSIBLE_FORMATS)) {
                String name = decodeHintType.name();
                if (extras.containsKey(name)) {
                    if (decodeHintType.getValueType().equals(Void.class)) {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    } else {
                        Object obj = extras.get(name);
                        if (decodeHintType.getValueType().isInstance(obj)) {
                            enumMap.put(decodeHintType, obj);
                        } else {
                            Log.w(TAG, "Ignoring hint " + decodeHintType + " because it is not assignable from " + obj);
                        }
                    }
                }
            }
        }
        Log.i(TAG, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
