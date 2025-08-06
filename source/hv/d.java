package hv;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.HashMap;

public class d {

    /* renamed from: d  reason: collision with root package name */
    public static volatile HashMap<String, d> f22804d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f22805a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f22806b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22807c = false;

    public d(Context context, String str) {
        context = !(context instanceof Application) ? context.getApplicationContext() : context;
        if ("default".equals(str)) {
            this.f22805a = PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            this.f22805a = context.getSharedPreferences(str, 0);
        }
        this.f22806b = this.f22805a.edit();
    }

    public static d a(Context context, String str) {
        if (f22804d.get(str) == null) {
            synchronized (d.class) {
                if (f22804d.get(str) == null) {
                    f22804d.put(str, new d(context, str));
                }
            }
        }
        f22804d.get(str).f22807c = false;
        return f22804d.get(str);
    }

    public String b(String str, String str2) {
        return this.f22805a.getString(str, str2);
    }

    public d c(String str, String str2) {
        this.f22806b.putString(str, str2);
        d();
        return this;
    }

    public final void d() {
        if (this.f22807c) {
            this.f22806b.apply();
        } else {
            this.f22806b.commit();
        }
    }
}
