package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.MobLink;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13725a = MobLink.getSdkVersion();

    /* renamed from: b  reason: collision with root package name */
    private static SharePrefrenceHelper f13726b;

    public static synchronized boolean a() {
        boolean z11;
        synchronized (f.class) {
            c();
            z11 = f13726b.getBoolean("appInstall");
        }
        return z11;
    }

    public static synchronized String b() {
        synchronized (f.class) {
            c();
            if (f13726b.getBoolean("debuggable")) {
                return "";
            }
            String string = f13726b.getString("config_data");
            return string;
        }
    }

    private static void c() {
        if (f13726b == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            f13726b = sharePrefrenceHelper;
            sharePrefrenceHelper.open(MobLink.getSdkTag(), f13725a);
        }
    }

    public static synchronized void a(boolean z11) {
        synchronized (f.class) {
            c();
            f13726b.putBoolean("appInstall", Boolean.valueOf(z11));
        }
    }

    public static synchronized void a(String str) {
        synchronized (f.class) {
            c();
            f13726b.putString("config_data", str);
            f13726b.putBoolean("debuggable", Boolean.FALSE);
        }
    }
}
