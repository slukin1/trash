package com.zendesk.logger;

import android.os.Build;
import android.util.Log;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mz.f;

public class Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f52771a = TimeZone.getTimeZone(UtcDates.UTC);

    /* renamed from: b  reason: collision with root package name */
    public static final List<c> f52772b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static c f52773c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f52774d = false;

    public enum Priority {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        /* access modifiers changed from: private */
        public final int priority;

        private Priority(int i11) {
            this.priority = i11;
        }
    }

    public static class a implements c {
        public void a(Priority priority, String str, String str2, Throwable th2) {
            Priority priority2;
            String a11 = kz.a.a(str);
            if (b(str) && (priority2 = Priority.ERROR) == priority) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(Logger.f52771a);
                Log.println(priority2.priority, a11, "Time in UTC: " + simpleDateFormat.format(new Date()));
            }
            if (th2 != null) {
                str2 = str2 + f.f58291b + Log.getStackTraceString(th2);
            }
            for (String println : kz.a.c(str2, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY)) {
                Log.println(priority == null ? Priority.INFO.priority : priority.priority, a11, println);
            }
        }

        public final boolean b(String str) {
            return f.c(str) && (str.endsWith("Provider") || str.endsWith("Service"));
        }
    }

    public static class b implements c {
        public void a(Priority priority, String str, String str2, Throwable th2) {
            char c11;
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append("[");
            sb2.append(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).format(new Date()));
            sb2.append("]");
            sb2.append(" ");
            if (priority == null) {
                c11 = kz.a.b(Priority.INFO.priority);
            } else {
                c11 = kz.a.b(priority.priority);
            }
            sb2.append(c11);
            sb2.append("/");
            if (!f.c(str)) {
                str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
            }
            sb2.append(str);
            sb2.append(l.f34627b);
            sb2.append(str2);
            System.out.println(sb2.toString());
            if (th2 != null) {
                th2.printStackTrace(System.out);
            }
        }
    }

    public interface c {
        void a(Priority priority, String str, String str2, Throwable th2);
    }

    static {
        b bVar;
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                f52773c = new a();
            }
            if (f52773c == null) {
                bVar = new b();
                f52773c = bVar;
            }
        } catch (ClassNotFoundException unused) {
            if (f52773c == null) {
                bVar = new b();
            }
        } catch (Throwable th2) {
            if (f52773c == null) {
                f52773c = new b();
            }
            throw th2;
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        i(Priority.DEBUG, str, str2, (Throwable) null, objArr);
    }

    public static void c(String str, String str2, Throwable th2, Object... objArr) {
        i(Priority.ERROR, str, str2, th2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        i(Priority.ERROR, str, str2, (Throwable) null, objArr);
    }

    public static void e(String str, lz.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        if (aVar != null) {
            sb2.append("Network Error: ");
            sb2.append(aVar.b());
            sb2.append(", Status Code: ");
            sb2.append(aVar.getStatus());
            if (f.c(aVar.getReason())) {
                sb2.append(", Reason: ");
                sb2.append(aVar.getReason());
            }
        }
        String sb3 = sb2.toString();
        Priority priority = Priority.ERROR;
        if (!f.c(sb3)) {
            sb3 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.W;
        }
        i(priority, str, sb3, (Throwable) null, new Object[0]);
    }

    public static void f(String str, String str2, Throwable th2, Object... objArr) {
        i(Priority.INFO, str, str2, th2, objArr);
    }

    public static void g(String str, String str2, Object... objArr) {
        i(Priority.INFO, str, str2, (Throwable) null, objArr);
    }

    public static boolean h() {
        return f52774d;
    }

    public static void i(Priority priority, String str, String str2, Throwable th2, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str2 = String.format(Locale.US, str2, objArr);
        }
        if (f52774d) {
            f52773c.a(priority, str, str2, th2);
            for (c a11 : f52772b) {
                a11.a(priority, str, str2, th2);
            }
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        i(Priority.VERBOSE, str, str2, (Throwable) null, objArr);
    }

    public static void k(String str, String str2, Throwable th2, Object... objArr) {
        i(Priority.WARN, str, str2, th2, objArr);
    }

    public static void l(String str, String str2, Object... objArr) {
        i(Priority.WARN, str, str2, (Throwable) null, objArr);
    }
}
