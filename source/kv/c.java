package kv;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Locale;

public class c {
    public static double a(long j11, long j12) {
        if (j12 <= 0 || j11 <= 0) {
            return 0.0d;
        }
        return ((double) Math.round((((double) (j11 / j12)) / 1.024d) * 100.0d)) / 100.0d;
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th2) {
            e.g("ContextUtil", th2.getMessage(), th2);
            return null;
        }
    }

    public static String c(Context context) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return d(context);
        }
        if (i11 < 23 || i11 >= 24) {
            return i11 >= 24 ? f() : "02:00:00:00:00:00";
        }
        return e();
    }

    public static String d(Context context) {
        WifiManager wifiManager;
        WifiInfo wifiInfo;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return "02:00:00:00:00:00";
        }
        try {
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        String macAddress = wifiInfo.getMacAddress();
        return !TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(Locale.ENGLISH) : macAddress;
    }

    public static String e() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String f() {
        try {
            NetworkInterface byName = NetworkInterface.getByName(j("wifi.interface", "wlan0"));
            if (byName == null) {
                return "02:00:00:00:00:00";
            }
            byte[] hardwareAddress = byName.getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            int length = hardwareAddress.length;
            for (int i11 = 0; i11 < length; i11++) {
                sb2.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i11])}));
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String g(double d11) {
        return (d11 >= 20.0d || d11 <= 0.0d) ? (d11 < 20.0d || d11 >= 750.0d) ? (d11 < 750.0d || d11 >= 12500.0d) ? d11 >= 12500.0d ? "WIFI" : GrsBaseInfo.CountryCodeSource.UNKNOWN : "4G" : "3G" : "2G";
    }

    public static String h() {
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                if (ContextCompat.checkSelfPermission(ContextUtil.g(), "android.permission.READ_PHONE_STATE") == 0) {
                    return Build.getSerial();
                }
                return "";
            } else if (i11 >= 26) {
                return Build.SERIAL;
            } else {
                String i12 = i("ro.serialno");
                if (StringUtils.b(i12)) {
                    return i("ro.boot.serialno");
                }
                return i12;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            e.f("ContextUtil", "读取设备序列号异常：" + e11.toString());
            return "";
        }
    }

    public static final String i(String str) {
        return j(str, (String) null);
    }

    public static final String j(String str, String str2) {
        try {
            return Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str}).toString();
        } catch (ClassNotFoundException e11) {
            e.p("ContextUtil", e11.getMessage(), e11);
            return str2;
        } catch (SecurityException e12) {
            e.p("ContextUtil", e12.getMessage(), e12);
            return str2;
        } catch (Throwable th2) {
            e.p("ContextUtil", th2.getMessage(), th2);
            return str2;
        }
    }
}
