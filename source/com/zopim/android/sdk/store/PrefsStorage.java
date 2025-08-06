package com.zopim.android.sdk.store;

import android.content.Context;
import android.content.SharedPreferences;

abstract class PrefsStorage implements BaseStorage {
    private static final String DEFAULT_PREFS_NAME = "zopim_chat";
    public boolean mDisabled;
    public final SharedPreferences mStoragePreferences;

    private PrefsStorage() {
        throw new UnsupportedOperationException("Use of unsupported constructor");
    }

    public void delete() {
        this.mStoragePreferences.edit().clear().apply();
    }

    public void disable() {
        delete();
        this.mDisabled = true;
    }

    public PrefsStorage(Context context) {
        this(context, (String) null);
    }

    public PrefsStorage(Context context, String str) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (str == null) {
                this.mStoragePreferences = applicationContext.getSharedPreferences(DEFAULT_PREFS_NAME, 0);
            } else {
                this.mStoragePreferences = applicationContext.getSharedPreferences(str, 0);
            }
        } else {
            throw new IllegalArgumentException("Context must not be null");
        }
    }
}
