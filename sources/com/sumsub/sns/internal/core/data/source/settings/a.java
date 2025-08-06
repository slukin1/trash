package com.sumsub.sns.internal.core.data.source.settings;

import android.content.SharedPreferences;
import com.sumsub.sns.internal.core.common.n0;
import java.util.UUID;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f33503a;

    public a(SharedPreferences sharedPreferences) {
        this.f33503a = sharedPreferences;
    }

    public String a() {
        String string = this.f33503a.getString(n0.i.f32195c, "");
        return string == null ? "" : string;
    }

    public String b() {
        String string = this.f33503a.getString(n0.i.f32196d, "");
        return string == null ? "" : string;
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.f33503a.edit();
        if (str == null) {
            edit.remove(n0.i.f32195c);
        }
        if (str != null) {
            edit.putString(n0.i.f32195c, str);
        }
        edit.commit();
    }

    public void d(String str) {
        SharedPreferences.Editor edit = this.f33503a.edit();
        edit.putString(n0.i.f32197e, str);
        edit.commit();
    }

    public /* synthetic */ void e() {
        c.a(this);
    }

    public String f() {
        String string = this.f33503a.getString("device_id", (String) null);
        if (string == null || string.length() == 0) {
            string = UUID.randomUUID().toString();
        }
        SharedPreferences.Editor edit = this.f33503a.edit();
        edit.putString("device_id", string);
        edit.commit();
        return string;
    }

    public UUID g() {
        try {
            return UUID.fromString(this.f33503a.getString(n0.i.f32198f, ""));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String h() {
        return this.f33503a.getString(n0.i.f32199g, "");
    }

    public boolean i() {
        return this.f33503a.getBoolean(n0.i.f32200h, false);
    }

    public void a(String str) {
        SharedPreferences.Editor edit = this.f33503a.edit();
        if (str == null) {
            edit.remove(n0.i.f32196d);
        }
        if (str != null) {
            edit.putString(n0.i.f32196d, str);
        }
        edit.commit();
    }

    public void b(String str) {
        SharedPreferences.Editor edit = this.f33503a.edit();
        edit.putString(n0.i.f32199g, str);
        edit.commit();
    }

    public void d() {
        SharedPreferences.Editor edit = this.f33503a.edit();
        edit.putBoolean(n0.i.f32200h, true);
        edit.commit();
    }

    public String c() {
        String string = this.f33503a.getString(n0.i.f32197e, "");
        return string == null ? "" : string;
    }

    public void a(UUID uuid) {
        SharedPreferences.Editor edit = this.f33503a.edit();
        edit.putString(n0.i.f32198f, uuid.toString());
        edit.commit();
    }
}
