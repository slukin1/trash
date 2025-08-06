package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.LogUtil;

public class SafeBundle {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f38543a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f38543a.containsKey(str);
        } catch (Throwable unused) {
            LogUtil.e("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f38543a.get(str);
        } catch (Exception e11) {
            LogUtil.e("SafeBundle", "get exception: " + e11.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f38543a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f38543a.getString(str);
        } catch (Throwable th2) {
            LogUtil.e("SafeBundle", "getString exception: " + th2.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f38543a.isEmpty();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f38543a.size();
        } catch (Exception unused) {
            LogUtil.e("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f38543a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f38543a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i11) {
        try {
            return this.f38543a.getInt(str, i11);
        } catch (Throwable th2) {
            LogUtil.e("SafeBundle", "getInt exception: " + th2.getMessage(), true);
            return i11;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f38543a.getString(str, str2);
        } catch (Exception e11) {
            LogUtil.e("SafeBundle", "getString exception: " + e11.getMessage(), true);
            return str2;
        }
    }
}
