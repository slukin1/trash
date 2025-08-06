package com.sumsub.sns.internal.log.logger;

import android.util.Log;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.log.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.r;

public final class a implements Logger, b {

    /* renamed from: e  reason: collision with root package name */
    public static final C0404a f34900e = new C0404a((r) null);
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f34901f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);

    /* renamed from: a  reason: collision with root package name */
    public final String f34902a;

    /* renamed from: b  reason: collision with root package name */
    public final Logger f34903b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f34904c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public List<? extends LoggerType> f34905d = CollectionsKt__CollectionsJVMKt.e(LoggerType.KIBANA);

    /* renamed from: com.sumsub.sns.internal.log.logger.a$a  reason: collision with other inner class name */
    public static final class C0404a {
        public /* synthetic */ C0404a(r rVar) {
            this();
        }

        public final String a(int i11, String str, String str2, Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.f34901f.format(new Date()).toString());
            sb2.append(' ');
            sb2.append(b.a().get(Integer.valueOf(i11)));
            sb2.append('/');
            sb2.append(str);
            sb2.append(':');
            sb2.append(' ');
            sb2.append(str2);
            if (th2 != null) {
                sb2.append(10);
                sb2.append(Log.getStackTraceString(th2));
            }
            return sb2.toString();
        }

        public C0404a() {
        }
    }

    public a(String str, Logger logger) {
        this.f34902a = str;
        this.f34903b = logger;
    }

    public String a() {
        return this.f34902a;
    }

    public synchronized List<LoggerType> b() {
        return this.f34905d;
    }

    public synchronized void clear() {
        this.f34904c.clear();
    }

    public void d(String str, String str2, Throwable th2) {
        this.f34903b.d(str, str2, th2);
        a(3, str, str2, th2);
    }

    public void e(String str, String str2, Throwable th2) {
        this.f34903b.e(str, str2, th2);
        a(6, str, str2, th2);
    }

    public synchronized void flush() {
        if (!this.f34904c.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (String append : this.f34904c) {
                sb2.append(append);
                sb2.append(10);
            }
            this.f34904c.clear();
            String sb3 = sb2.toString();
            for (Logger c11 : com.sumsub.sns.internal.log.a.f34862a.b((List<? extends LoggerType>) b())) {
                com.sumsub.log.logger.a.c(c11, a(), sb3, (Throwable) null, 4, (Object) null);
            }
        }
    }

    public void i(String str, String str2, Throwable th2) {
        this.f34903b.i(str, str2, th2);
        a(4, str, str2, th2);
    }

    public void v(String str, String str2, Throwable th2) {
        this.f34903b.v(str, str2, th2);
        a(2, str, str2, th2);
    }

    public void w(String str, String str2, Throwable th2) {
        this.f34903b.w(str, str2, th2);
        a(5, str, str2, th2);
    }

    public synchronized void a(List<? extends LoggerType> list) {
        this.f34905d = list;
    }

    public final synchronized void a(int i11, String str, String str2, Throwable th2) {
        this.f34904c.add(f34900e.a(i11, str, str2, th2));
    }
}
