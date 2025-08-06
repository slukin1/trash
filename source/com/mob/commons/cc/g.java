package com.mob.commons.cc;

import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SharePrefrenceHelper f27134a;

    public g(String str, int i11) {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.f27134a = sharePrefrenceHelper;
        sharePrefrenceHelper.open(str, i11);
    }

    public void a(String str, long j11) {
        this.f27134a.putLong(str, Long.valueOf(j11));
    }

    public long b(String str, long j11) {
        return this.f27134a.getLong(str, j11);
    }

    public void a(String str, int i11) {
        this.f27134a.putInt(str, Integer.valueOf(i11));
    }

    public int b(String str, int i11) {
        return this.f27134a.getInt(str, i11);
    }

    public void a(String str, boolean z11) {
        this.f27134a.putBoolean(str, Boolean.valueOf(z11));
    }

    public boolean b(String str, boolean z11) {
        return this.f27134a.getBoolean(str, z11);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.f27134a.remove(str);
        } else {
            this.f27134a.putString(str, str2);
        }
    }

    public String b(String str, String str2) {
        return this.f27134a.getString(str, str2);
    }

    public void a(String str, Object obj) {
        this.f27134a.put(str, obj);
    }

    public Object a(String str) {
        return this.f27134a.get(str);
    }
}
