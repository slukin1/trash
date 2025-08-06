package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.BuildConfig;
import com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager;
import com.sensorsdata.analytics.android.sdk.util.SASpUtils;

public class SAEncryptStorePlugin implements StorePlugin {
    private final String mFileName;
    private final SharedPreferences mStoreSp;

    public SAEncryptStorePlugin(Context context) {
        this(context, BuildConfig.LIBRARY_PACKAGE_NAME);
    }

    private String decryptValue(String str) {
        return AESSecretManager.getInstance().decryptAES(str);
    }

    private String encryptValue(String str) {
        return AESSecretManager.getInstance().encryptAES(str);
    }

    public Boolean getBool(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            return Boolean.valueOf(Boolean.parseBoolean(string));
        }
        return null;
    }

    public Float getFloat(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            return Float.valueOf(Float.parseFloat(string));
        }
        return null;
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            return Integer.valueOf(Integer.parseInt(string));
        }
        return null;
    }

    public Long getLong(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            return Long.valueOf(Long.parseLong(string));
        }
        return null;
    }

    public String getString(String str) {
        String string = this.mStoreSp.getString(encryptValue(str), (String) null);
        if (!TextUtils.isEmpty(string)) {
            return decryptValue(string);
        }
        return null;
    }

    public boolean isExists(String str) {
        return this.mStoreSp.contains(encryptValue(str));
    }

    public void remove(String str) {
        this.mStoreSp.edit().remove(encryptValue(str)).apply();
    }

    public void setBool(String str, boolean z11) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(String.valueOf(z11))).apply();
    }

    public void setFloat(String str, float f11) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(String.valueOf(f11))).apply();
    }

    public void setInteger(String str, int i11) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(String.valueOf(i11))).apply();
    }

    public void setLong(String str, long j11) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(String.valueOf(j11))).apply();
    }

    public void setString(String str, String str2) {
        this.mStoreSp.edit().putString(encryptValue(str), encryptValue(str2)).apply();
    }

    public String type() {
        return this.mFileName;
    }

    public void upgrade(StorePlugin storePlugin) {
    }

    public SAEncryptStorePlugin(Context context, String str) {
        this.mStoreSp = SASpUtils.getSharedPreferences(context, str, 0);
        this.mFileName = str;
    }
}
