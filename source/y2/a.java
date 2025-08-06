package y2;

import android.util.Log;
import com.alibaba.sdk.android.logger.LogLevel;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class a {

    /* renamed from: h  reason: collision with root package name */
    public static final LogLevel f16867h = LogLevel.WARN;

    /* renamed from: i  reason: collision with root package name */
    public static final c f16868i = new d((C0114a) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f16869a = true;

    /* renamed from: b  reason: collision with root package name */
    public LogLevel f16870b = f16867h;

    /* renamed from: c  reason: collision with root package name */
    public c f16871c = f16868i;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f16872d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public c f16873e = new c(this, (C0114a) null);

    /* renamed from: f  reason: collision with root package name */
    public String f16874f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16875g;

    /* renamed from: y2.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0114a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f16876a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.alibaba.sdk.android.logger.LogLevel[] r0 = com.alibaba.sdk.android.logger.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16876a = r0
                com.alibaba.sdk.android.logger.LogLevel r1 = com.alibaba.sdk.android.logger.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16876a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.logger.LogLevel r1 = com.alibaba.sdk.android.logger.LogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16876a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.logger.LogLevel r1 = com.alibaba.sdk.android.logger.LogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16876a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.sdk.android.logger.LogLevel r1 = com.alibaba.sdk.android.logger.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: y2.a.C0114a.<clinit>():void");
        }
    }

    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public c f16877a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16878b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDateFormat f16879c;

        public b(c cVar, boolean z11) {
            this.f16877a = cVar;
            this.f16878b = z11;
            if (z11) {
                this.f16879c = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS");
            }
        }

        public /* synthetic */ b(c cVar, boolean z11, C0114a aVar) {
            this(cVar, z11);
        }

        public void a(LogLevel logLevel, String str, String str2) {
            if (this.f16878b) {
                str2 = "[" + this.f16879c.format(new Date()) + "]" + str2 + b();
            }
            this.f16877a.a(logLevel, str, str2);
        }

        public final String b() {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i11 = 1;
            while (i11 < stackTrace.length) {
                if (stackTrace[i11].getClassName().startsWith("com.alibaba.sdk.android.logger")) {
                    i11++;
                } else {
                    return "(" + stackTrace[i11].getFileName() + ":" + stackTrace[i11].getLineNumber() + ")";
                }
            }
            return "";
        }
    }

    public class c implements c {
        public c() {
        }

        public /* synthetic */ c(a aVar, C0114a aVar2) {
            this();
        }

        public void a(LogLevel logLevel, String str, String str2) {
            if (a.this.c(logLevel) && a.this.f16871c != null) {
                try {
                    a.this.f16871c.a(logLevel, str, str2);
                } catch (Throwable unused) {
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a.this.f16872d);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                try {
                    ((c) it2.next()).a(logLevel, str, str2);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static class d implements c {
        public d() {
        }

        public /* synthetic */ d(C0114a aVar) {
            this();
        }

        public void a(LogLevel logLevel, String str, String str2) {
            int i11 = C0114a.f16876a[logLevel.ordinal()];
            if (i11 == 1) {
                Log.d(str, str2);
            } else if (i11 == 2) {
                Log.i(str, str2);
            } else if (i11 == 3) {
                Log.w(str, str2);
            } else if (i11 == 4) {
                Log.e(str, str2);
            }
        }
    }

    public static class e implements b {

        /* renamed from: a  reason: collision with root package name */
        public final String f16881a;

        /* renamed from: b  reason: collision with root package name */
        public c f16882b;

        public e(String str, c cVar) {
            this.f16881a = str;
            this.f16882b = cVar;
        }

        public void d(String str) {
            this.f16882b.a(LogLevel.DEBUG, this.f16881a, str);
        }
    }

    public a(String str, boolean z11) {
        this.f16874f = str;
        if (str == null) {
            this.f16874f = "default";
        }
        this.f16875g = z11;
        if (z11) {
            this.f16870b = LogLevel.DEBUG;
        }
    }

    public final String a(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else if (obj instanceof Class) {
            str = ((Class) obj).getSimpleName();
        } else if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + obj.hashCode();
        }
        return this.f16874f + "_" + str;
    }

    public final boolean c(LogLevel logLevel) {
        return this.f16869a && logLevel.ordinal() >= this.f16870b.ordinal();
    }

    public b f(Object obj) {
        return new e(a(obj), new b(this.f16873e, this.f16875g, (C0114a) null));
    }
}
