package com.tencent.a.a.a.a;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

public final class e extends f {
    public e(Context context) {
        super(context);
    }

    public final boolean a() {
        return h.a(this.f40459e, "android.permission.WRITE_SETTINGS");
    }

    public final String b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = Settings.System.getString(this.f40459e.getContentResolver(), h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }

    public final void b(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            Settings.System.putString(this.f40459e.getContentResolver(), h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }
}
