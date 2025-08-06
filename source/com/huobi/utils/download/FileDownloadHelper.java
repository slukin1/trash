package com.huobi.utils.download;

import i6.m;
import java.io.File;
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

public class FileDownloadHelper {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f83729a = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build().newBuilder().addNetworkInterceptor(new du.c(this)).build();

    /* renamed from: b  reason: collision with root package name */
    public du.b f83730b;

    /* renamed from: c  reason: collision with root package name */
    public du.a f83731c;

    public interface a {
        void a(long j11, long j12, boolean z11);
    }

    public static class b extends ResponseBody {

        /* renamed from: b  reason: collision with root package name */
        public final ResponseBody f83732b;

        /* renamed from: c  reason: collision with root package name */
        public final a f83733c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSource f83734d;

        public class a extends ForwardingSource {

            /* renamed from: b  reason: collision with root package name */
            public long f83735b = 0;

            public a(Source source) {
                super(source);
            }

            public long read(Buffer buffer, long j11) throws IOException {
                long read = super.read(buffer, j11);
                int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                this.f83735b += i11 != 0 ? read : 0;
                b.this.f83733c.a(this.f83735b, b.this.f83732b.contentLength(), i11 == 0);
                return read;
            }
        }

        public b(ResponseBody responseBody, a aVar) {
            this.f83732b = responseBody;
            this.f83733c = aVar;
        }

        public long contentLength() {
            return this.f83732b.contentLength();
        }

        public MediaType contentType() {
            return this.f83732b.contentType();
        }

        public final Source e(Source source) {
            return new a(source);
        }

        public BufferedSource source() {
            if (this.f83734d == null) {
                this.f83734d = Okio.buffer(e(this.f83732b.source()));
            }
            return this.f83734d;
        }
    }

    public class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f83737a = new StringBuilder();

        public c() {
        }

        public void a(long j11, long j12, boolean z11) {
            String b11 = b(j11 + 0, j12 + 0);
            if (!b11.equals(this.f83737a.toString())) {
                if (this.f83737a.length() > 0) {
                    StringBuilder sb2 = this.f83737a;
                    sb2.delete(0, sb2.length());
                }
                this.f83737a.append(b11);
                if (m.k0(b11) % 1 == 0 && j11 <= j12 && j11 != 0 && FileDownloadHelper.this.f83730b != null) {
                    FileDownloadHelper.this.f83730b.a(this.f83737a.toString());
                }
            }
        }

        public final String b(long j11, long j12) {
            return ((int) ((j11 * 100) / j12)) + "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Response f(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new b(proceed.body(), new c())).build();
    }

    public final boolean c(File file) {
        du.a aVar = this.f83731c;
        if (aVar == null) {
            return true;
        }
        return aVar.a(file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        r7 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (r3 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0086, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008c, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[SYNTHETIC, Splitter:B:33:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082 A[SYNTHETIC, Splitter:B:43:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.Request$Builder r3 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            r3.<init>()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.Request$Builder r7 = r3.url((java.lang.String) r7)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.Request r7 = r7.build()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.OkHttpClient r3 = r6.f83729a     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.Call r7 = r3.newCall(r7)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            okhttp3.Response r3 = r7.execute()     // Catch:{ Exception -> 0x0060, all -> 0x0063 }
            boolean r4 = r3.isSuccessful()     // Catch:{ Exception -> 0x005e }
            if (r4 == 0) goto L_0x004b
            okio.Sink r2 = okio.Okio.appendingSink(r2)     // Catch:{ Exception -> 0x005e }
            okio.BufferedSink r1 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ Exception -> 0x005e }
            okhttp3.ResponseBody r2 = r3.body()     // Catch:{ Exception -> 0x005e }
            okio.BufferedSource r2 = r2.source()     // Catch:{ Exception -> 0x005e }
            okhttp3.ResponseBody r4 = r3.body()     // Catch:{ Exception -> 0x005e }
            long r4 = r4.contentLength()     // Catch:{ Exception -> 0x005e }
            r1.write(r2, r4)     // Catch:{ Exception -> 0x005e }
            r1.close()     // Catch:{ Exception -> 0x005e }
            com.hbg.lib.common.utils.FileUtil.a(r8)     // Catch:{ IOException -> 0x0047 }
            r0 = 1
            goto L_0x004b
        L_0x0047:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ Exception -> 0x005e }
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0055:
            if (r0 != 0) goto L_0x005a
            r7.cancel()
        L_0x005a:
            r3.close()
            goto L_0x007e
        L_0x005e:
            r8 = move-exception
            goto L_0x0069
        L_0x0060:
            r8 = move-exception
            r3 = r1
            goto L_0x0069
        L_0x0063:
            r7 = move-exception
            r3 = r1
            goto L_0x0080
        L_0x0066:
            r8 = move-exception
            r7 = r1
            r3 = r7
        L_0x0069:
            r8.printStackTrace()     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0076:
            if (r7 == 0) goto L_0x007b
            r7.cancel()
        L_0x007b:
            if (r3 == 0) goto L_0x007e
            goto L_0x005a
        L_0x007e:
            return r0
        L_0x007f:
            r7 = move-exception
        L_0x0080:
            if (r1 == 0) goto L_0x008a
            r1.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008a:
            if (r3 == 0) goto L_0x008f
            r3.close()
        L_0x008f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.download.FileDownloadHelper.d(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: okhttp3.Call} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(java.lang.String r9, java.lang.String r10, long r11) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = ".part"
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r0 = 0
            r1 = 0
            r2 = 1
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r4.<init>()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Request$Builder r9 = r4.url((java.lang.String) r9)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r4 = "RANGE"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r5.<init>()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r6 = "bytes="
            r5.append(r6)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r5.append(r11)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r11 = "-"
            r5.append(r11)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r11 = r5.toString()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Request$Builder r9 = r9.header(r4, r11)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Request r9 = r9.build()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.OkHttpClient r11 = r8.f83729a     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Call r9 = r11.newCall(r9)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            okhttp3.Response r0 = r9.execute()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            boolean r11 = r0.isSuccessful()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            if (r11 == 0) goto L_0x00b0
            okio.Sink r11 = okio.Okio.appendingSink(r3)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            okhttp3.ResponseBody r12 = r0.body()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            okio.BufferedSource r12 = r12.source()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            okhttp3.ResponseBody r4 = r0.body()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            long r4 = r4.contentLength()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r11.write(r12, r4)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r11.close()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            boolean r11 = r8.c(r3)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            if (r11 == 0) goto L_0x0091
            int r11 = r10.length()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            int r11 = r11 + -5
            java.lang.String r11 = r10.substring(r1, r11)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r3.renameTo(r12)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            com.hbg.lib.common.utils.FileUtil.a(r11)     // Catch:{ IOException -> 0x008c }
            goto L_0x0095
        L_0x008c:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            goto L_0x0094
        L_0x0091:
            com.hbg.lib.common.utils.FileUtil.h(r10)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
        L_0x0094:
            r2 = r1
        L_0x0095:
            int r11 = r10.length()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            int r11 = r11 + -5
            java.lang.String r10 = r10.substring(r1, r11)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            r3.renameTo(r11)     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
            com.hbg.lib.common.utils.FileUtil.a(r10)     // Catch:{ IOException -> 0x00ac }
            r1 = r2
            goto L_0x00b0
        L_0x00ac:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ Exception -> 0x00be, all -> 0x00b9 }
        L_0x00b0:
            if (r1 != 0) goto L_0x00b5
            r9.cancel()
        L_0x00b5:
            r0.close()
            goto L_0x00d5
        L_0x00b9:
            r10 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x00d7
        L_0x00be:
            r10 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x00c8
        L_0x00c3:
            r10 = move-exception
            r9 = r0
            goto L_0x00d7
        L_0x00c6:
            r10 = move-exception
            r9 = r0
        L_0x00c8:
            r10.printStackTrace()     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00d0
            r0.cancel()
        L_0x00d0:
            if (r9 == 0) goto L_0x00d5
            r9.close()
        L_0x00d5:
            return r1
        L_0x00d6:
            r10 = move-exception
        L_0x00d7:
            if (r2 != 0) goto L_0x00de
            if (r0 == 0) goto L_0x00de
            r0.cancel()
        L_0x00de:
            if (r9 == 0) goto L_0x00e3
            r9.close()
        L_0x00e3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.download.FileDownloadHelper.e(java.lang.String, java.lang.String, long):boolean");
    }
}
