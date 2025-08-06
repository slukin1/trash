package iz;

import android.content.Context;
import android.content.SharedPreferences;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f52896a;

    public d(Context context) {
        this.f52896a = context.getSharedPreferences("belvedere_prefs", 0);
    }

    public void a(String str) {
        this.f52896a.edit().putBoolean(str, true).apply();
    }

    public boolean b(String str) {
        return this.f52896a.contains(str);
    }
}
