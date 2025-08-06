package com.mob.mgs.impl;

import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static SharePrefrenceHelper f27641a;

    public static synchronized void a(boolean z11) {
        synchronized (i.class) {
            e();
            f27641a.putInt("device_switch_local_cache", Integer.valueOf(z11 ? 1 : 0));
        }
    }

    public static synchronized void b(boolean z11) {
        synchronized (i.class) {
            e();
            f27641a.putInt("device_switch_remote_cache", Integer.valueOf(z11 ? 1 : 0));
        }
    }

    public static synchronized String c() {
        String string;
        synchronized (i.class) {
            e();
            string = f27641a.getString("duid_remote_cache", "");
        }
        return string;
    }

    public static synchronized String d() {
        String string;
        synchronized (i.class) {
            e();
            string = f27641a.getString("guard_id_remote_cache", "");
        }
        return string;
    }

    private static void e() {
        if (f27641a == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            f27641a = sharePrefrenceHelper;
            sharePrefrenceHelper.open("gu", 0);
        }
    }

    public static synchronized Boolean a() {
        Boolean bool;
        synchronized (i.class) {
            e();
            int i11 = f27641a.getInt("device_switch_local_cache", -1);
            if (i11 == 1) {
                bool = Boolean.TRUE;
            } else {
                bool = i11 == 0 ? Boolean.FALSE : null;
            }
        }
        return bool;
    }

    public static synchronized Boolean b() {
        Boolean bool;
        synchronized (i.class) {
            e();
            int i11 = f27641a.getInt("device_switch_remote_cache", -1);
            if (i11 == 1) {
                bool = Boolean.TRUE;
            } else {
                bool = i11 == 0 ? Boolean.FALSE : null;
            }
        }
        return bool;
    }

    public static synchronized void a(String str) {
        synchronized (i.class) {
            e();
            f27641a.putString("duid_remote_cache", str);
        }
    }

    public static synchronized void b(String str) {
        synchronized (i.class) {
            e();
            f27641a.putString("guard_id_remote_cache", str);
        }
    }
}
