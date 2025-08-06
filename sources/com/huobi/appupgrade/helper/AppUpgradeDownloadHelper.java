package com.huobi.appupgrade.helper;

import i6.d;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class AppUpgradeDownloadHelper {

    /* renamed from: c  reason: collision with root package name */
    public static String f42191c;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f42192a;

    /* renamed from: b  reason: collision with root package name */
    public eh.b f42193b;

    public interface a {
        void a(long j11, long j12, boolean z11);
    }

    public static class b extends ResponseBody {

        /* renamed from: b  reason: collision with root package name */
        public final ResponseBody f42194b;

        /* renamed from: c  reason: collision with root package name */
        public final a f42195c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSource f42196d;

        public class a extends ForwardingSource {

            /* renamed from: b  reason: collision with root package name */
            public long f42197b = 0;

            public a(Source source) {
                super(source);
            }

            public long read(Buffer buffer, long j11) throws IOException {
                long read = super.read(buffer, j11);
                int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                this.f42197b += i11 != 0 ? read : 0;
                b.this.f42195c.a(this.f42197b, b.this.f42194b.contentLength(), i11 == 0);
                return read;
            }
        }

        public b(ResponseBody responseBody, a aVar) {
            this.f42194b = responseBody;
            this.f42195c = aVar;
        }

        public long contentLength() {
            return this.f42194b.contentLength();
        }

        public MediaType contentType() {
            return this.f42194b.contentType();
        }

        public final Source e(Source source) {
            return new a(source);
        }

        public BufferedSource source() {
            if (this.f42196d == null) {
                this.f42196d = Okio.buffer(e(this.f42194b.source()));
            }
            return this.f42196d;
        }
    }

    public class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f42199a = new StringBuilder();

        /* renamed from: b  reason: collision with root package name */
        public long f42200b;

        /* renamed from: c  reason: collision with root package name */
        public long f42201c;

        /* renamed from: d  reason: collision with root package name */
        public long f42202d;

        public c() {
        }

        public void a(long j11, long j12, boolean z11) {
            long j13;
            long currentTimeMillis = System.currentTimeMillis();
            long j14 = this.f42201c;
            long j15 = currentTimeMillis - j14;
            if (j15 > 300) {
                if (j14 != 0) {
                    d.c("UpdateApkDownLoadSpeed", "size=" + (j11 - this.f42200b) + " timeInterval=" + j15);
                    j13 = (long) ((((double) (j11 - this.f42200b)) / 1024.0d) / (((double) j15) / 1000.0d));
                } else {
                    j13 = 0;
                }
                this.f42200b = j11;
                this.f42201c = currentTimeMillis;
                AppUpgradeDownloadHelper.f42191c = j13 + "kb/s";
            }
            String b11 = b(j11 + 0, j12 + 0);
            if (currentTimeMillis - this.f42202d > 1000 || !b11.equals(this.f42199a.toString())) {
                if (this.f42199a.length() > 0) {
                    StringBuilder sb2 = this.f42199a;
                    sb2.delete(0, sb2.length());
                }
                this.f42199a.append(b11);
                if (j11 <= j12 && j11 != 0 && AppUpgradeDownloadHelper.this.f42193b != null) {
                    AppUpgradeDownloadHelper.this.f42193b.a(this.f42199a.toString());
                    this.f42202d = System.currentTimeMillis();
                }
            }
        }

        public final String b(long j11, long j12) {
            return ((int) ((j11 * 100) / j12)) + "";
        }
    }

    public AppUpgradeDownloadHelper() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f42192a = builder.connectTimeout(1800, timeUnit).callTimeout(1800, timeUnit).readTimeout(1800, timeUnit).writeTimeout(1800, timeUnit).build().newBuilder().addNetworkInterceptor(new eh.a(this)).build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Response d(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new b(proceed.body(), new c())).build();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: okhttp3.Call} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00cb, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cc, code lost:
        r8 = r2;
        r2 = r10;
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d0, code lost:
        r10 = th;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e1, code lost:
        r2.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e6, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d0 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v4 okhttp3.Call) = (r2v0 okhttp3.Call), (r2v0 okhttp3.Call), (r2v10 okhttp3.Call) binds: [B:1:0x0006, B:3:0x003f, B:13:0x00a2] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(java.lang.String r10, java.lang.String r11, java.lang.String r12, long r13) {
        /*
            r9 = this;
            java.lang.String r0 = "  下载任务失败"
            java.lang.String r1 = "UPGRADE"
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            r4.<init>(r11)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            r5.<init>()     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Request$Builder r10 = r5.url((java.lang.String) r10)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            java.lang.String r5 = "RANGE"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            r6.<init>()     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            java.lang.String r7 = "bytes="
            r6.append(r7)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            r6.append(r13)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            java.lang.String r13 = "-"
            r6.append(r13)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            java.lang.String r13 = r6.toString()     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Request$Builder r10 = r10.header(r5, r13)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Request r10 = r10.build()     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            java.lang.String r13 = "  mOkHttpClient.newCall"
            i6.k.f(r1, r13)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.OkHttpClient r13 = r9.f42192a     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Call r10 = r13.newCall(r10)     // Catch:{ Exception -> 0x00d2, all -> 0x00d0 }
            okhttp3.Response r2 = r10.execute()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            boolean r13 = r2.isSuccessful()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            if (r13 == 0) goto L_0x00ba
            java.lang.String r13 = "   response.isSuccessful()   "
            i6.k.f(r1, r13)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            okio.Sink r13 = okio.Okio.appendingSink(r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            okio.BufferedSink r13 = okio.Okio.buffer((okio.Sink) r13)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            okhttp3.ResponseBody r14 = r2.body()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            okio.BufferedSource r14 = r14.source()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            okhttp3.ResponseBody r4 = r2.body()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            long r4 = r4.contentLength()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r13.write(r14, r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r13.close()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.lang.String r13 = "   FileUtil.checkMd5 "
            i6.k.f(r1, r13)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r13.<init>(r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            boolean r12 = com.hbg.lib.common.utils.FileUtil.b(r12, r13)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            if (r12 == 0) goto L_0x00ac
            java.lang.String r12 = "md5通过!"
            i6.k.f(r1, r12)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            int r12 = r11.length()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            int r12 = r12 + -5
            java.lang.String r12 = r11.substring(r3, r12)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r13.<init>(r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            r13.renameTo(r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.lang.String r11 = "  changeFileMode"
            i6.k.f(r1, r11)     // Catch:{ IOException -> 0x00a1 }
            com.hbg.lib.common.utils.FileUtil.a(r12)     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00aa
        L_0x00a1:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.lang.String r11 = "  changeFileMode IOException"
            i6.k.f(r1, r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
        L_0x00aa:
            r3 = 1
            goto L_0x00bf
        L_0x00ac:
            java.lang.String r12 = "doUpgradeApp error md5 mismatch !"
            i6.k.f(r1, r12)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            com.hbg.lib.common.utils.FileUtil.h(r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            java.lang.String r11 = "doUpgradeApp error md5 mismatch deleteFile!"
            i6.k.f(r1, r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
            goto L_0x00bf
        L_0x00ba:
            java.lang.String r11 = "  mOkHttpClient.newCall fail"
            i6.k.f(r1, r11)     // Catch:{ Exception -> 0x00cb, all -> 0x00d0 }
        L_0x00bf:
            if (r3 != 0) goto L_0x00c7
            i6.k.f(r1, r0)
            r10.cancel()
        L_0x00c7:
            r2.close()
            goto L_0x00e9
        L_0x00cb:
            r11 = move-exception
            r8 = r2
            r2 = r10
            r10 = r8
            goto L_0x00d4
        L_0x00d0:
            r10 = move-exception
            goto L_0x00ed
        L_0x00d2:
            r11 = move-exception
            r10 = r2
        L_0x00d4:
            r11.printStackTrace()     // Catch:{ all -> 0x00ea }
            java.lang.String r12 = "doUpgradeApp error downloading has exception "
            i6.k.g(r1, r12, r11)     // Catch:{ all -> 0x00ea }
            i6.k.f(r1, r0)
            if (r2 == 0) goto L_0x00e4
            r2.cancel()
        L_0x00e4:
            if (r10 == 0) goto L_0x00e9
            r10.close()
        L_0x00e9:
            return r3
        L_0x00ea:
            r11 = move-exception
            r2 = r10
            r10 = r11
        L_0x00ed:
            if (r2 == 0) goto L_0x00f2
            r2.close()
        L_0x00f2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.appupgrade.helper.AppUpgradeDownloadHelper.c(java.lang.String, java.lang.String, java.lang.String, long):boolean");
    }

    public void e(eh.b bVar) {
        this.f42193b = bVar;
    }
}
