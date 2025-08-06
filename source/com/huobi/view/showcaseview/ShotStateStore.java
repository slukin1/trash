package com.huobi.view.showcaseview;

import android.content.Context;
import android.content.SharedPreferences;

class ShotStateStore {
    private static final int INVALID_SHOT_ID = -1;
    private static final String PREFS_SHOWCASE_INTERNAL = "showcase_internal";
    private final Context context;
    public long shotId = -1;

    public ShotStateStore(Context context2) {
        this.context = context2;
    }

    public boolean hasShot() {
        if (!isSingleShot()) {
            return false;
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREFS_SHOWCASE_INTERNAL, 0);
        if (sharedPreferences.getBoolean("hasShot" + this.shotId, false)) {
            return true;
        }
        return false;
    }

    public boolean isSingleShot() {
        return this.shotId != -1;
    }

    public void setSingleShot(long j11) {
        this.shotId = j11;
    }

    public void storeShot() {
        if (isSingleShot()) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences(PREFS_SHOWCASE_INTERNAL, 0).edit();
            edit.putBoolean("hasShot" + this.shotId, true).apply();
        }
    }
}
