package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

final class d extends f {
    public d(Context context) {
        super(context);
    }

    public final boolean a() {
        return true;
    }

    public final String b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f40459e).getString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), (String) null);
        }
        return string;
    }

    public final void b(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f40459e).edit();
            edit.putString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }
}
