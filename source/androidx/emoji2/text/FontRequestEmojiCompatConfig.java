package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.h;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import k1.b;
import k1.f;
import k1.g;
import y0.c;

public class FontRequestEmojiCompatConfig extends EmojiCompat.c {

    /* renamed from: j  reason: collision with root package name */
    public static final FontProviderHelper f9407j = new FontProviderHelper();

    public static class FontProviderHelper {
        public Typeface a(Context context, FontsContractCompat.b bVar) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, (CancellationSignal) null, new FontsContractCompat.b[]{bVar});
        }

        public FontsContractCompat.a b(Context context, c cVar) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.b(context, (CancellationSignal) null, cVar);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public static class a implements EmojiCompat.f {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9408a;

        /* renamed from: b  reason: collision with root package name */
        public final c f9409b;

        /* renamed from: c  reason: collision with root package name */
        public final FontProviderHelper f9410c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f9411d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public Handler f9412e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f9413f;

        /* renamed from: g  reason: collision with root package name */
        public ThreadPoolExecutor f9414g;

        /* renamed from: h  reason: collision with root package name */
        public RetryPolicy f9415h;

        /* renamed from: i  reason: collision with root package name */
        public EmojiCompat.MetadataRepoLoaderCallback f9416i;

        /* renamed from: j  reason: collision with root package name */
        public ContentObserver f9417j;

        /* renamed from: k  reason: collision with root package name */
        public Runnable f9418k;

        /* renamed from: androidx.emoji2.text.FontRequestEmojiCompatConfig$a$a  reason: collision with other inner class name */
        public class C0039a extends ContentObserver {
            public C0039a(Handler handler) {
                super(handler);
            }

            public void onChange(boolean z11, Uri uri) {
                a.this.d();
            }
        }

        public a(Context context, c cVar, FontProviderHelper fontProviderHelper) {
            h.h(context, "Context cannot be null");
            h.h(cVar, "FontRequest cannot be null");
            this.f9408a = context.getApplicationContext();
            this.f9409b = cVar;
            this.f9410c = fontProviderHelper;
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            h.h(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f9411d) {
                this.f9416i = metadataRepoLoaderCallback;
            }
            d();
        }

        public final void b() {
            synchronized (this.f9411d) {
                this.f9416i = null;
                ContentObserver contentObserver = this.f9417j;
                if (contentObserver != null) {
                    this.f9410c.d(this.f9408a, contentObserver);
                    this.f9417j = null;
                }
                Handler handler = this.f9412e;
                if (handler != null) {
                    handler.removeCallbacks(this.f9418k);
                }
                this.f9412e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f9414g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f9413f = null;
                this.f9414g = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r1 != 2) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r2 = r7.f9411d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r3 = r7.f9415h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
            if (r3 == null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
            r3 = r3.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            if (r3 < 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
            f(r0.d(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
            if (r1 != 0) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            androidx.core.os.n.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
            r1 = r7.f9410c.a(r7.f9408a, r0);
            r0 = t0.k.f(r7.f9408a, (android.os.CancellationSignal) null, r0.d());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004e, code lost:
            if (r0 == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
            if (r1 == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
            r0 = androidx.emoji2.text.c.b(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            androidx.core.os.n.b();
            r1 = r7.f9411d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r2 = r7.f9416i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
            if (r2 == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0060, code lost:
            r2.b(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0072, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            androidx.core.os.n.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0077, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0093, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + ")");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0094, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0097, code lost:
            monitor-enter(r7.f9411d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r2 = r7.f9416i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x009a, code lost:
            if (r2 != null) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009c, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a0, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            r0 = e();
            r1 = r0.b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r7 = this;
                java.lang.Object r0 = r7.f9411d
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r7.f9416i     // Catch:{ all -> 0x00a7 }
                if (r1 != 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                androidx.core.provider.FontsContractCompat$b r0 = r7.e()     // Catch:{ all -> 0x0094 }
                int r1 = r0.b()     // Catch:{ all -> 0x0094 }
                r2 = 2
                if (r1 != r2) goto L_0x0034
                java.lang.Object r2 = r7.f9411d     // Catch:{ all -> 0x0094 }
                monitor-enter(r2)     // Catch:{ all -> 0x0094 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r7.f9415h     // Catch:{ all -> 0x0031 }
                if (r3 == 0) goto L_0x002f
                long r3 = r3.a()     // Catch:{ all -> 0x0031 }
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 < 0) goto L_0x002f
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0031 }
                r7.f(r0, r3)     // Catch:{ all -> 0x0031 }
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                return
            L_0x002f:
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                goto L_0x0034
            L_0x0031:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0031 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0034:
                if (r1 != 0) goto L_0x0078
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.n.a(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r7.f9410c     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f9408a     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.a(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r7.f9408a     // Catch:{ all -> 0x0073 }
                r3 = 0
                android.net.Uri r0 = r0.d()     // Catch:{ all -> 0x0073 }
                java.nio.ByteBuffer r0 = t0.k.f(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x006b
                if (r1 == 0) goto L_0x006b
                androidx.emoji2.text.c r0 = androidx.emoji2.text.c.b(r1, r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.n.b()     // Catch:{ all -> 0x0094 }
                java.lang.Object r1 = r7.f9411d     // Catch:{ all -> 0x0094 }
                monitor-enter(r1)     // Catch:{ all -> 0x0094 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.f9416i     // Catch:{ all -> 0x0068 }
                if (r2 == 0) goto L_0x0063
                r2.b(r0)     // Catch:{ all -> 0x0068 }
            L_0x0063:
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                r7.b()     // Catch:{ all -> 0x0094 }
                goto L_0x00a3
            L_0x0068:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0068 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x006b:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r0 = move-exception
                androidx.core.os.n.b()     // Catch:{ all -> 0x0094 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0078:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0094 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
                r2.<init>()     // Catch:{ all -> 0x0094 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0094 }
                r2.append(r1)     // Catch:{ all -> 0x0094 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0094 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0094 }
                r0.<init>(r1)     // Catch:{ all -> 0x0094 }
                throw r0     // Catch:{ all -> 0x0094 }
            L_0x0094:
                r0 = move-exception
                java.lang.Object r1 = r7.f9411d
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r7.f9416i     // Catch:{ all -> 0x00a4 }
                if (r2 == 0) goto L_0x009f
                r2.a(r0)     // Catch:{ all -> 0x00a4 }
            L_0x009f:
                monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
                r7.b()
            L_0x00a3:
                return
            L_0x00a4:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a4 }
                throw r0
            L_0x00a7:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a7 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.a.c():void");
        }

        public void d() {
            synchronized (this.f9411d) {
                if (this.f9416i != null) {
                    if (this.f9413f == null) {
                        ThreadPoolExecutor b11 = b.b("emojiCompat");
                        this.f9414g = b11;
                        this.f9413f = b11;
                    }
                    this.f9413f.execute(new f(this));
                }
            }
        }

        public final FontsContractCompat.b e() {
            try {
                FontsContractCompat.a b11 = this.f9410c.b(this.f9408a, this.f9409b);
                if (b11.c() == 0) {
                    FontsContractCompat.b[] b12 = b11.b();
                    if (b12 != null && b12.length != 0) {
                        return b12[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b11.c() + ")");
            } catch (PackageManager.NameNotFoundException e11) {
                throw new RuntimeException("provider not found", e11);
            }
        }

        public final void f(Uri uri, long j11) {
            synchronized (this.f9411d) {
                Handler handler = this.f9412e;
                if (handler == null) {
                    handler = b.d();
                    this.f9412e = handler;
                }
                if (this.f9417j == null) {
                    C0039a aVar = new C0039a(handler);
                    this.f9417j = aVar;
                    this.f9410c.c(this.f9408a, uri, aVar);
                }
                if (this.f9418k == null) {
                    this.f9418k = new g(this);
                }
                handler.postDelayed(this.f9418k, j11);
            }
        }

        public void g(Executor executor) {
            synchronized (this.f9411d) {
                this.f9413f = executor;
            }
        }
    }

    public FontRequestEmojiCompatConfig(Context context, c cVar) {
        super(new a(context, cVar, f9407j));
    }

    public FontRequestEmojiCompatConfig c(Executor executor) {
        ((a) a()).g(executor);
        return this;
    }
}
