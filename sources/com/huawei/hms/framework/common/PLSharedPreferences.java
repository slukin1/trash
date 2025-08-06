package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PLSharedPreferences {
    private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    private static final String TAG = "PLSharedPreferences";

    /* renamed from: sp  reason: collision with root package name */
    private final SharedPreferences f37968sp;

    public PLSharedPreferences(Context context, String str) {
        this.f37968sp = getSharedPreferences(context, str);
    }

    private SharedPreferences getSharedPreferences(Context context, String str) {
        if (context == null) {
            Logger.e(TAG, "context is null, must call init method to set context");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
            if (!sharedPreferences.getBoolean(str, false)) {
                if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
            }
            context = createDeviceProtectedStorageContext;
        }
        return context.getSharedPreferences(str, 0);
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public Map<String, ?> getAll() {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences == null) {
            return null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sp size ");
        sb2.append(all == null ? 0 : all.size());
        Logger.i(TAG, sb2.toString());
        return all;
    }

    public Map<String, String> getHashMap(String str) {
        HashMap hashMap = new HashMap();
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences == null) {
            return hashMap;
        }
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, ""));
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i12 = 0; i12 < names.length(); i12++) {
                        String string = names.getString(i12);
                        hashMap.put(string, jSONObject.getString(string));
                    }
                }
            }
        } catch (JSONException e11) {
            Logger.w(TAG, "getHashMap parse Json to map error: %s", StringUtils.anonymizeMessage(e11.getMessage()));
        }
        return hashMap;
    }

    public long getLong(String str, long j11) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences == null) {
            return j11;
        }
        return sharedPreferences.getLong(str, j11);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public void putHashMap(String str, Map<String, String> map) {
        if (this.f37968sp != null && map != null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (JSONException e11) {
                    Logger.w(TAG, "putHashMap one object error: %s", StringUtils.anonymizeMessage(e11.getMessage()));
                }
            }
            jSONArray.put(jSONObject);
            this.f37968sp.edit().putString(str, jSONArray.toString()).apply();
        }
    }

    public void putLong(String str, long j11) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j11).apply();
        }
    }

    public void putString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public void remove(String str) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public void removeKeyValue(String str) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f37968sp;
        if (sharedPreferences == null) {
            return str2;
        }
        return sharedPreferences.getString(str, str2);
    }
}
