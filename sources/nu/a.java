package nu;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile HashMap<String, a> f23022d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f23023a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f23024b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23025c = false;

    public a(Context context, String str) {
        context = !(context instanceof Application) ? context.getApplicationContext() : context;
        if ("default".equals(str)) {
            this.f23023a = PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            this.f23023a = context.getSharedPreferences(str, 0);
        }
        this.f23024b = this.f23023a.edit();
    }

    public static a b(Context context, String str) {
        if (f23022d.get(str) == null) {
            synchronized (a.class) {
                if (f23022d.get(str) == null) {
                    f23022d.put(str, new a(context, str));
                }
            }
        }
        f23022d.get(str).f23025c = false;
        return f23022d.get(str);
    }

    public void a(String str) {
        this.f23024b.remove(str);
        g();
    }

    public int c(String str, int i11) {
        return this.f23023a.getInt(str, i11);
    }

    public String d(String str, String str2) {
        return this.f23023a.getString(str, str2);
    }

    public a e(String str, int i11) {
        this.f23024b.putInt(str, i11);
        g();
        return this;
    }

    public a f(String str, String str2) {
        this.f23024b.putString(str, str2);
        g();
        return this;
    }

    public final void g() {
        if (this.f23025c) {
            this.f23024b.apply();
        } else {
            this.f23024b.commit();
        }
    }
}
