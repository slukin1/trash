package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import java.util.HashMap;
import java.util.Map;

public class SPUtils {
    public static final String DEFAULT_DATABASE = "tuikit";
    private static final Map<String, SPUtils> SP_UTILS_MAP = new HashMap();
    private final SharedPreferences mSharedPreferences;

    private SPUtils(String str, int i11) {
        this.mSharedPreferences = getApplicationContext().getSharedPreferences(str, i11);
    }

    private Context getApplicationContext() {
        return ServiceInitializer.getAppContext();
    }

    public static SPUtils getInstance() {
        return getInstance(DEFAULT_DATABASE, 0);
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        clear(false);
    }

    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public long getLong(String str) {
        return getLong(str, -1);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public void put(String str, String str2) {
        put(str, str2, false);
    }

    public void remove(String str) {
        remove(str, false);
    }

    public static SPUtils getInstance(int i11) {
        return getInstance(DEFAULT_DATABASE, i11);
    }

    public void clear(boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().clear().commit();
        } else {
            this.mSharedPreferences.edit().clear().apply();
        }
    }

    public boolean getBoolean(String str, boolean z11) {
        return this.mSharedPreferences.getBoolean(str, z11);
    }

    public float getFloat(String str, float f11) {
        return this.mSharedPreferences.getFloat(str, f11);
    }

    public int getInt(String str, int i11) {
        return this.mSharedPreferences.getInt(str, i11);
    }

    public long getLong(String str, long j11) {
        return this.mSharedPreferences.getLong(str, j11);
    }

    public String getString(String str, String str2) {
        return this.mSharedPreferences.getString(str, str2);
    }

    public void put(String str, String str2, boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().putString(str, str2).commit();
        } else {
            this.mSharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public void remove(String str, boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().remove(str).commit();
        } else {
            this.mSharedPreferences.edit().remove(str).apply();
        }
    }

    public static SPUtils getInstance(String str) {
        return getInstance(str, 0);
    }

    public static SPUtils getInstance(String str, int i11) {
        if (isSpace(str)) {
            str = DEFAULT_DATABASE;
        }
        Map<String, SPUtils> map = SP_UTILS_MAP;
        SPUtils sPUtils = map.get(str);
        if (sPUtils == null) {
            synchronized (SPUtils.class) {
                sPUtils = map.get(str);
                if (sPUtils == null) {
                    sPUtils = new SPUtils(str, i11);
                    map.put(str, sPUtils);
                }
            }
        }
        return sPUtils;
    }

    public void put(String str, boolean z11) {
        put(str, z11, false);
    }

    public void put(String str, boolean z11, boolean z12) {
        if (z12) {
            this.mSharedPreferences.edit().putBoolean(str, z11).commit();
        } else {
            this.mSharedPreferences.edit().putBoolean(str, z11).apply();
        }
    }

    public void put(String str, int i11) {
        put(str, i11, false);
    }

    public void put(String str, int i11, boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().putInt(str, i11).commit();
        } else {
            this.mSharedPreferences.edit().putInt(str, i11).apply();
        }
    }

    public void put(String str, float f11) {
        put(str, f11, false);
    }

    public void put(String str, float f11, boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().putFloat(str, f11).commit();
        } else {
            this.mSharedPreferences.edit().putFloat(str, f11).apply();
        }
    }

    public void put(String str, long j11) {
        put(str, j11, false);
    }

    public void put(String str, long j11, boolean z11) {
        if (z11) {
            this.mSharedPreferences.edit().putLong(str, j11).commit();
        } else {
            this.mSharedPreferences.edit().putLong(str, j11).apply();
        }
    }
}
