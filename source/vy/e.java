package vy;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import java.util.Random;
import ry.d;

public class e {
    public static String a(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        if (!c.a() && context != null) {
            try {
                if (d.c(context) && (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        if (f.c(str)) {
            str = d();
        }
        if (f.c(str)) {
            str = b(context);
        }
        return f.c(str) ? c() : str;
    }

    public static String b(Context context) {
        String str = "";
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            try {
                return (TextUtils.isEmpty(string) || string.equalsIgnoreCase("a5f5faddde9e9f02") || string.equalsIgnoreCase("8e17f7422b35fbea") || string.equalsIgnoreCase("ece1e988e8bf71f2") || string.equalsIgnoreCase("9e3ecdf2be3b9a69") || string.equalsIgnoreCase("0000000000000000")) ? str : string;
            } catch (Throwable unused) {
                str = string;
                return str;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static String c() {
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a11 = d.a((int) (System.currentTimeMillis() / 1000));
        byte[] a12 = d.a((int) System.nanoTime());
        byte[] a13 = d.a(nextInt);
        byte[] a14 = d.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a11, 0, bArr, 0, 4);
        System.arraycopy(a12, 0, bArr, 4, 4);
        System.arraycopy(a13, 0, bArr, 8, 4);
        System.arraycopy(a14, 0, bArr, 12, 4);
        return b.f(bArr, 2);
    }

    public static String d() {
        String a11 = g.a("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(a11)) {
            a11 = g.a("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(a11) ? e() : a11;
    }

    public static String e() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }
}
