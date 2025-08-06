package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import t0.g;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final i0.b<String, Typeface> f8435a = new i0.b<>(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f8436b = y0.d.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8437c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleArrayMap<String, ArrayList<Consumer<e>>> f8438d = new SimpleArrayMap<>();

    public class a implements Callable<e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8439b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f8440c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ y0.c f8441d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8442e;

        public a(String str, Context context, y0.c cVar, int i11) {
            this.f8439b = str;
            this.f8440c = context;
            this.f8441d = cVar;
            this.f8442e = i11;
        }

        /* renamed from: a */
        public e call() {
            return c.c(this.f8439b, this.f8440c, this.f8441d, this.f8442e);
        }
    }

    public class b implements Consumer<e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8443b;

        public b(a aVar) {
            this.f8443b = aVar;
        }

        /* renamed from: a */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f8443b.b(eVar);
        }
    }

    /* renamed from: androidx.core.provider.c$c  reason: collision with other inner class name */
    public class C0025c implements Callable<e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8444b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f8445c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ y0.c f8446d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8447e;

        public C0025c(String str, Context context, y0.c cVar, int i11) {
            this.f8444b = str;
            this.f8445c = context;
            this.f8446d = cVar;
            this.f8447e = i11;
        }

        /* renamed from: a */
        public e call() {
            try {
                return c.c(this.f8444b, this.f8445c, this.f8446d, this.f8447e);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    public class d implements Consumer<e> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8448b;

        public d(String str) {
            this.f8448b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((androidx.core.util.Consumer) r2.get(r0)).accept(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(androidx.core.provider.c.e r5) {
            /*
                r4 = this;
                java.lang.Object r0 = androidx.core.provider.c.f8437c
                monitor-enter(r0)
                androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.c$e>>> r1 = androidx.core.provider.c.f8438d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f8448b     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f8448b     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                androidx.core.util.Consumer r1 = (androidx.core.util.Consumer) r1
                r1.accept(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.c.d.accept(androidx.core.provider.c$e):void");
        }
    }

    public static String a(y0.c cVar, int i11) {
        return cVar.d() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(FontsContractCompat.a aVar) {
        int i11 = 1;
        if (aVar.c() == 0) {
            FontsContractCompat.b[] b11 = aVar.b();
            if (!(b11 == null || b11.length == 0)) {
                int length = b11.length;
                i11 = 0;
                int i12 = 0;
                while (i12 < length) {
                    int b12 = b11[i12].b();
                    if (b12 == 0) {
                        i12++;
                    } else if (b12 < 0) {
                        return -3;
                    } else {
                        return b12;
                    }
                }
            }
            return i11;
        } else if (aVar.c() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    public static e c(String str, Context context, y0.c cVar, int i11) {
        i0.b<String, Typeface> bVar = f8435a;
        Typeface typeface = bVar.get(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            FontsContractCompat.a e11 = b.e(context, cVar, (CancellationSignal) null);
            int b11 = b(e11);
            if (b11 != 0) {
                return new e(b11);
            }
            Typeface b12 = g.b(context, (CancellationSignal) null, e11.b(), i11);
            if (b12 == null) {
                return new e(-3);
            }
            bVar.put(str, b12);
            return new e(b12);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r9 = new androidx.core.provider.c.C0025c(r0, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r8 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r8 = f8436b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        y0.d.b(r8, r9, new androidx.core.provider.c.d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface d(android.content.Context r5, y0.c r6, int r7, java.util.concurrent.Executor r8, androidx.core.provider.a r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            i0.b<java.lang.String, android.graphics.Typeface> r1 = f8435a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.c$e r5 = new androidx.core.provider.c$e
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.c$b r1 = new androidx.core.provider.c$b
            r1.<init>(r9)
            java.lang.Object r9 = f8437c
            monitor-enter(r9)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.c$e>>> r2 = f8438d     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x004d }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x004d }
            r4 = 0
            if (r3 == 0) goto L_0x002f
            r3.add(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            return r4
        L_0x002f:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            r3.add(r1)     // Catch:{ all -> 0x004d }
            r2.put(r0, r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            androidx.core.provider.c$c r9 = new androidx.core.provider.c$c
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0044
            java.util.concurrent.ExecutorService r8 = f8436b
        L_0x0044:
            androidx.core.provider.c$d r5 = new androidx.core.provider.c$d
            r5.<init>(r0)
            y0.d.b(r8, r9, r5)
            return r4
        L_0x004d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.c.d(android.content.Context, y0.c, int, java.util.concurrent.Executor, androidx.core.provider.a):android.graphics.Typeface");
    }

    public static Typeface e(Context context, y0.c cVar, a aVar, int i11, int i12) {
        String a11 = a(cVar, i11);
        Typeface typeface = f8435a.get(a11);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        } else if (i12 == -1) {
            e c11 = c(a11, context, cVar, i11);
            aVar.b(c11);
            return c11.f8449a;
        } else {
            try {
                e eVar = (e) y0.d.c(f8436b, new a(a11, context, cVar, i11), i12);
                aVar.b(eVar);
                return eVar.f8449a;
            } catch (InterruptedException unused) {
                aVar.b(new e(-3));
                return null;
            }
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f8449a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8450b;

        public e(int i11) {
            this.f8449a = null;
            this.f8450b = i11;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f8450b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public e(Typeface typeface) {
            this.f8449a = typeface;
            this.f8450b = 0;
        }
    }
}
