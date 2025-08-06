package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.mob.MobSDK;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f13299a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f13300b;

    public static boolean a() {
        String appkey = MobSDK.getAppkey();
        if (f13299a || TextUtils.isEmpty(appkey)) {
            return false;
        }
        if (TextUtils.isEmpty(f13300b)) {
            SSDKLog.b().a("CheckAppKeyAsynchronously verify the appkey", new Object[0]);
            k.a(new k.a() {
                public void a() throws Throwable {
                    b.a().b();
                }
            });
            return true;
        }
        SSDKLog.b().a("CheckAppKeyDetermine whether successAppKey is equal to mobsdk.getappkey", new Object[0]);
        return appkey.equals(f13300b);
    }
}
