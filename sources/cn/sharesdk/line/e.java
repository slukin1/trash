package cn.sharesdk.line;

import android.content.Context;
import android.content.SharedPreferences;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f13634a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f13635b;

    public e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f13634a = sharedPreferences;
        this.f13635b = sharedPreferences.edit();
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.f13635b.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            this.f13635b.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            this.f13635b.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            this.f13635b.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            this.f13635b.putLong(str, ((Long) obj).longValue());
        } else {
            this.f13635b.putString(str, obj.toString());
        }
        this.f13635b.commit();
    }

    public Object b(String str, Object obj) {
        if (obj instanceof String) {
            return this.f13634a.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f13634a.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f13634a.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f13634a.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f13634a.getLong(str, ((Long) obj).longValue()));
        }
        return this.f13634a.getString(str, (String) null);
    }
}
