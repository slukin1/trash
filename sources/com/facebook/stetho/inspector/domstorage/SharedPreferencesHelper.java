package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;

public class SharedPreferencesHelper {
    private static final String PREFS_SUFFIX = ".xml";

    private SharedPreferencesHelper() {
    }

    public static Set<Map.Entry<String, ?>> getSharedPreferenceEntriesSorted(SharedPreferences sharedPreferences) {
        TreeSet treeSet = new TreeSet(new Comparator<Map.Entry<String, ?>>() {
            public int compare(Map.Entry<String, ?> entry, Map.Entry<String, ?> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        treeSet.addAll(sharedPreferences.getAll().entrySet());
        return treeSet;
    }

    public static List<String> getSharedPreferenceTags(Context context) {
        ArrayList arrayList = new ArrayList();
        File file = new File(context.getApplicationInfo().dataDir + "/shared_prefs");
        if (file.exists()) {
            for (File name : file.listFiles()) {
                String name2 = name.getName();
                if (name2.endsWith(PREFS_SUFFIX)) {
                    arrayList.add(name2.substring(0, name2.length() - 4));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Boolean parseBoolean(String str) throws IllegalArgumentException {
        if ("1".equals(str) || "true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("0".equals(str) || d.f31895b.equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Expected boolean, got " + str);
    }

    public static Object valueFromString(String str, Object obj) throws IllegalArgumentException {
        if (obj instanceof Integer) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (obj instanceof Boolean) {
            return parseBoolean(str);
        }
        if (obj instanceof String) {
            return str;
        }
        if (obj instanceof Set) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                HashSet hashSet = new HashSet(length);
                for (int i11 = 0; i11 < length; i11++) {
                    hashSet.add(jSONArray.getString(i11));
                }
                return hashSet;
            } catch (JSONException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
    }

    public static String valueToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Set)) {
            return obj.toString();
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : (Set) obj) {
            jSONArray.put(put);
        }
        return jSONArray.toString();
    }
}
