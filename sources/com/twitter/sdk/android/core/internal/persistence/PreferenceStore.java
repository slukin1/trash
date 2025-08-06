package com.twitter.sdk.android.core.internal.persistence;

import android.content.SharedPreferences;

public interface PreferenceStore {
    SharedPreferences.Editor edit();

    SharedPreferences get();

    boolean save(SharedPreferences.Editor editor);
}
