package ty;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.a.e.h;
import java.io.File;
import py.a;
import uy.c;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40586a = (".UTSystemConfig" + File.separator + "Global");

    public static String a(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + File.separator + ".7934039a7252be16";
        h.g("", "UtdidAppRoot dir:" + str);
        c.c(str);
        return str;
    }

    public static void b(Context context, String str) {
        String str2;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), "7934039a7252be16");
        } catch (Exception unused) {
            str2 = null;
        }
        if (!str.equals(str2)) {
            try {
                Settings.System.putString(context.getContentResolver(), "7934039a7252be16", str);
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(String str) {
        try {
            h.i();
            c.a(d(), str);
        } catch (Throwable unused) {
        }
    }

    public static String d() {
        Context f11 = a.c().f();
        String str = a(f11) + File.separator + "4635b664f789000d";
        h.g("", str);
        return str;
    }

    public static String e(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "7934039a7252be16");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void f(String str) {
        try {
            String m11 = m();
            if (!TextUtils.isEmpty(m11)) {
                c.a(m11, str);
            }
        } catch (Exception unused) {
        }
    }

    public static String g() {
        Context f11 = a.c().f();
        return a(f11) + File.separator + "9983c160aa044115";
    }

    public static boolean h(Context context) {
        try {
            return !context.getFileStreamPath("3c9b584e65e6c983").exists();
        } catch (Exception unused) {
            return true;
        }
    }

    public static String i() {
        Context f11 = a.c().f();
        return a(f11) + File.separator + "a325712a39bd320a";
    }

    public static String j() {
        try {
            return c.b(d());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String k() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + f40586a;
        h.g("", "SdcardRoot dir:" + str);
        c.c(str);
        return str;
    }

    public static String l() {
        try {
            String m11 = m();
            if (!TextUtils.isEmpty(m11)) {
                return c.b(m11);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String m() {
        if (!ry.d.a(a.c().f())) {
            return null;
        }
        return k() + File.separator + "7934039a7252be16";
    }
}
