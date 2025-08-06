package i6;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.dianping.logan.Logan;
import com.dianping.logan.SendLogRunnable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f68175a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f68176b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f68177c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f68178d = true;

    public static String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm:ss:SSS", Locale.US);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(simpleDateFormat.format(new Date()));
        stringBuffer.append(":");
        stringBuffer.append(f68175a);
        stringBuffer.append(":");
        stringBuffer.append(f68176b);
        stringBuffer.append(":");
        stringBuffer.append(f68177c);
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String b(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm:ss:SSS", Locale.US);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(simpleDateFormat.format(new Date()));
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("]");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static void c(String str) {
        try {
            d.b(str);
            if (q()) {
                m(Thread.currentThread().getStackTrace());
                Logan.e(a(str), 3);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void d(String str, String str2) {
        try {
            d.c(str, str2);
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2), 3);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void e(String str) {
        try {
            d.d(str);
            if (q()) {
                m(Thread.currentThread().getStackTrace());
                Logan.e(a(str), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void f(String str, String str2) {
        try {
            d.e(str, str2);
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void g(String str, String str2, Throwable th2) {
        try {
            d.e(str, str2 + 10 + Log.getStackTraceString(th2));
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2) + 10 + Log.getStackTraceString(th2), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void h(String str, String str2, Throwable th2, boolean z11) {
        try {
            d.e(str, str2 + 10 + Log.getStackTraceString(th2));
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2) + 10 + Log.getStackTraceString(th2), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void i(String str, String str2, boolean z11) {
        try {
            d.e(str, str2);
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void j(String str, Throwable th2) {
        try {
            d.d(str + 10 + Log.getStackTraceString(th2));
            if (q()) {
                m(Thread.currentThread().getStackTrace());
                Logan.e(a(str) + 10 + Log.getStackTraceString(th2), 6);
            }
        } catch (Exception e11) {
            d.f("LoganLogHelper.e 报错", e11);
        }
    }

    public static void k(Throwable th2) {
        try {
            d.d(th2.getMessage());
            if (q()) {
                m(Thread.currentThread().getStackTrace());
                Logan.e(a(String.format("Exception: %s. Caused by %s. Detail message: %s", new Object[]{th2.toString(), th2.getCause(), th2.getMessage()})), 6);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static String l(Context context) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir == null) {
                return context.getFilesDir().getAbsolutePath() + File.separator + "logan";
            }
            return externalFilesDir.getAbsolutePath() + File.separator + "logan";
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "logan";
    }

    public static void m(StackTraceElement[] stackTraceElementArr) {
        f68175a = stackTraceElementArr[3].getFileName();
        f68176b = stackTraceElementArr[3].getMethodName();
        f68177c = stackTraceElementArr[3].getLineNumber();
    }

    public static void n(String str) {
        try {
            d.i(str);
            if (q()) {
                m(Thread.currentThread().getStackTrace());
                Logan.e(a(str), 4);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void o(String str, String str2) {
        p(str, str2, false);
    }

    public static void p(String str, String str2, boolean z11) {
        try {
            d.j(str, str2);
            if (!q()) {
                return;
            }
            if (str2 != null) {
                try {
                    Logan.e(b(str, str2), 4);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public static boolean q() {
        return f68178d;
    }

    public static void r(SendLogRunnable sendLogRunnable) {
        if (q()) {
            Logan.c(new String[]{new SimpleDateFormat("yyyy-MM-dd").format(new Date())}, sendLogRunnable);
        }
    }

    public static void s(String str, String str2) {
        try {
            d.o(str, str2);
            if (!q()) {
                return;
            }
            if (str2 != null) {
                Logan.e(b(str, str2), 5);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
