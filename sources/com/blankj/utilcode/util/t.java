package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SuppressLint({"ApplySharedPref"})
public final class t {

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, t> f63543b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f63544a;

    public t(String str, int i11) {
        this.f63544a = Utils.a().getSharedPreferences(str, i11);
    }

    public static t a(String str) {
        return b(str, 0);
    }

    public static t b(String str, int i11) {
        if (f(str)) {
            str = "spUtils";
        }
        Map<String, t> map = f63543b;
        t tVar = map.get(str);
        if (tVar == null) {
            synchronized (t.class) {
                tVar = map.get(str);
                if (tVar == null) {
                    tVar = new t(str, i11);
                    map.put(str, tVar);
                }
            }
        }
        return tVar;
    }

    public static boolean f(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public String c(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return d(str, "");
    }

    public String d(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f63544a.getString(str, str2);
    }

    public Set<String> e(String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f63544a.getStringSet(str, set);
    }

    public void g(String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h(str, set, false);
    }

    public void h(String str, Set<String> set, boolean z11) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z11) {
            this.f63544a.edit().putStringSet(str, set).commit();
        } else {
            this.f63544a.edit().putStringSet(str, set).apply();
        }
    }

    public void i(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j(str, false);
    }

    public void j(String str, boolean z11) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z11) {
            this.f63544a.edit().remove(str).commit();
        } else {
            this.f63544a.edit().remove(str).apply();
        }
    }
}
