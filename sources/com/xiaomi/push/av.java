package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.common.net.HttpHeaders;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class av {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<a<aw>> f51403a = new AtomicReference<>(a());

    /* renamed from: a  reason: collision with other field name */
    public static final Pattern f2542a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f51404b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f51405c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static class a<T> extends FutureTask<T> {

        /* renamed from: a  reason: collision with root package name */
        private long f51406a;

        public a(Callable<T> callable) {
            super(callable);
        }

        public boolean a() {
            return j.a(s.a()) || (isDone() && Math.abs(SystemClock.elapsedRealtime() - this.f51406a) > Period.MIN30_MILLS);
        }

        public void run() {
            this.f51406a = SystemClock.elapsedRealtime();
            super.run();
        }
    }

    public static final class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f51407a;

        public b(InputStream inputStream) {
            super(inputStream);
        }

        public int read(byte[] bArr, int i11, int i12) {
            int read;
            if (!this.f51407a && (read = super.read(bArr, i11, i12)) != -1) {
                return read;
            }
            this.f51407a = true;
            return -1;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f51408a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f2543a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.f51408a), this.f2543a.toString()});
        }
    }

    public static InputStream a(Context context, URL url, boolean z11, String str, String str2) {
        return a(context, url, z11, str, str2, (Map<String, String>) null, (c) null);
    }

    public static void b() {
        f51403a.set(a());
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.xiaomi.push.aw] */
    public static boolean c(Context context) {
        ? a11 = a();
        return a11 != 0 && a11.a();
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.xiaomi.push.aw] */
    public static boolean d(Context context) {
        ? a11 = a();
        if (a11 != 0 && 1 == a11.a()) {
            return true;
        }
        return false;
    }

    public static boolean e(Context context) {
        aw a11 = a(context);
        if (a11 != null && a11.a() == 0 && 20 == a11.b()) {
            return true;
        }
        return false;
    }

    public static boolean f(Context context) {
        aw a11 = a(context);
        if (a11 != null && a11.a() == 0 && 13 == a11.b()) {
            return true;
        }
        return false;
    }

    public static boolean g(Context context) {
        aw a11 = a(context);
        if (a11 == null || a11.a() != 0) {
            return false;
        }
        String b11 = a11.b();
        if (!"TD-SCDMA".equalsIgnoreCase(b11) && !"CDMA2000".equalsIgnoreCase(b11) && !"WCDMA".equalsIgnoreCase(b11)) {
            switch (a11.b()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean h(Context context) {
        aw a11 = a(context);
        if (a11 == null || a11.a() != 0) {
            return false;
        }
        int b11 = a11.b();
        if (b11 == 1 || b11 == 2 || b11 == 4 || b11 == 7 || b11 == 11) {
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2406a() {
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r4) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r1 = 0
            if (r0 == 0) goto L_0x0027
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x0022
            android.net.Network r2 = r0.getActiveNetwork()     // Catch:{ Exception -> 0x0027 }
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r2)     // Catch:{ Exception -> 0x0027 }
            if (r0 == 0) goto L_0x0027
            r2 = 16
            boolean r0 = r0.hasCapability(r2)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0028
        L_0x0022:
            boolean r0 = a((android.content.Context) r4)
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            boolean r4 = c(r4)
            if (r4 == 0) goto L_0x0031
            r1 = 1
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.av.b(android.content.Context):boolean");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Object m2402a(Context context) {
        if (context == null) {
            context = s.a();
        }
        AnonymousClass1 r02 = null;
        if (context == null || j.a(context) || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkRequest build = new NetworkRequest.Builder().build();
            AnonymousClass1 r22 = new ConnectivityManager.NetworkCallback() {
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    av.b();
                }

                public void onLost(Network network) {
                    super.onLost(network);
                    av.b();
                }
            };
            try {
                connectivityManager.registerNetworkCallback(build, r22);
                return r22;
            } catch (Throwable th2) {
                th = th2;
                r02 = r22;
                com.xiaomi.channel.commonutils.logger.b.a("exception occurred in adding network callback :" + th);
                return r02;
            }
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.channel.commonutils.logger.b.a("exception occurred in adding network callback :" + th);
            return r02;
        }
    }

    public static void a(Context context, Object obj) {
        if (Build.VERSION.SDK_INT < 21) {
            com.xiaomi.channel.commonutils.logger.b.b("less than LOLLIPOP(21) not support channel ");
        } else if (context != null && obj != null) {
            try {
                if (obj instanceof ConnectivityManager.NetworkCallback) {
                    ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) obj);
                }
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.a("exception occurred in removing network callback :" + th2);
            }
        }
    }

    private static a<aw> a() {
        return new a<>(new Callable<aw>() {
            /* renamed from: a */
            public aw call() {
                NetworkInfo activeNetworkInfo;
                Context a11 = s.a();
                if (a11 == null) {
                    return null;
                }
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) a11.getSystemService("connectivity");
                    if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return null;
                    }
                    return new aw(activeNetworkInfo);
                } catch (Exception unused) {
                    return null;
                }
            }
        });
    }

    /* renamed from: a  reason: collision with other method in class */
    public static aw m2400a() {
        AtomicReference<a<aw>> atomicReference = f51403a;
        a<aw> aVar = atomicReference.get();
        if (aVar != null) {
            try {
                if (aVar.a()) {
                    aVar = a();
                    atomicReference.set(aVar);
                }
                if (!aVar.isDone()) {
                    aVar.run();
                }
                return (aw) aVar.get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static InputStream a(Context context, URL url, boolean z11, String str, String str2, Map<String, String> map, c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url != null) {
            URL url2 = !z11 ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection a11 = a(context, url2);
                a11.setConnectTimeout(10000);
                a11.setReadTimeout(DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS);
                if (!TextUtils.isEmpty(str)) {
                    a11.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    a11.setRequestProperty(HttpHeaders.COOKIE, str2);
                }
                if (map != null) {
                    for (String next : map.keySet()) {
                        a11.setRequestProperty(next, map.get(next));
                    }
                }
                if (cVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals(Constants.SCHEME))) {
                    cVar.f51408a = a11.getResponseCode();
                    if (cVar.f2543a == null) {
                        cVar.f2543a = new HashMap();
                    }
                    int i11 = 0;
                    while (true) {
                        String headerFieldKey = a11.getHeaderFieldKey(i11);
                        String headerField = a11.getHeaderField(i11);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey)) {
                            if (!TextUtils.isEmpty(headerField)) {
                                cVar.f2543a.put(headerFieldKey, headerField);
                            }
                        }
                        i11++;
                    }
                }
                return new b(a11.getInputStream());
            } catch (IOException e11) {
                throw new IOException("IOException:" + e11.getClass().getSimpleName());
            } catch (Throwable th2) {
                throw new IOException(th2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, (String) null, "UTF-8", (String) null);
    }

    public static String a(Context context, URL url, boolean z11, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z11, str, str3);
            try {
                StringBuilder sb2 = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb2.append(cArr, 0, read);
                    } else {
                        x.a((Closeable) inputStream);
                        return sb2.toString();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                x.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            x.a((Closeable) inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", new Object[]{str, bb.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{str}))});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.io.File r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "--"
            java.lang.String r1 = "\r\n"
            boolean r2 = r9.exists()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = r9.getName()
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r4.<init>(r7)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.net.URLConnection r7 = r4.openConnection()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r4 = 15000(0x3a98, float:2.102E-41)
            r7.setReadTimeout(r4)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r4 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r4 = 1
            r7.setDoInput(r4)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r7.setDoOutput(r4)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r4 = 0
            r7.setUseCaches(r4)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r5 = "POST"
            r7.setRequestMethod(r5)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r5 = "Connection"
            java.lang.String r6 = "Keep-Alive"
            r7.setRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "multipart/form-data;boundary=*****"
            r7.setRequestProperty(r5, r6)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            if (r8 == 0) goto L_0x0069
            java.util.Set r8 = r8.entrySet()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
        L_0x004d:
            boolean r5 = r8.hasNext()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            if (r5 == 0) goto L_0x0069
            java.lang.Object r5 = r8.next()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r7.setRequestProperty(r6, r5)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            goto L_0x004d
        L_0x0069:
            int r8 = r2.length()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            int r8 = r8 + 77
            long r5 = r9.length()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            int r2 = (int) r5     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            int r8 = r8 + r2
            int r2 = r10.length()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            int r8 = r8 + r2
            r7.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r8.<init>(r2)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r2 = "--*****\r\n"
            r8.writeBytes(r2)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r2.<init>()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r5 = "Content-Disposition: form-data; name=\""
            r2.append(r5)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r2.append(r10)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r10 = "\";filename=\""
            r2.append(r10)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r10 = r9.getName()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r2.append(r10)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r10 = "\""
            r2.append(r10)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r2.append(r1)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.lang.String r10 = r2.toString()     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r8.writeBytes(r10)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r8.writeBytes(r1)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r10.<init>(r9)     // Catch:{ IOException -> 0x0126, all -> 0x011a }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
        L_0x00bf:
            int r2 = r10.read(r9)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r5 = -1
            if (r2 == r5) goto L_0x00cd
            r8.write(r9, r4, r2)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.flush()     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            goto L_0x00bf
        L_0x00cd:
            r8.writeBytes(r1)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.writeBytes(r0)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.lang.String r9 = "*****"
            r8.writeBytes(r9)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.writeBytes(r0)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.writeBytes(r1)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.flush()     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r8.<init>()     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            com.xiaomi.push.av$b r1 = new com.xiaomi.push.av$b     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0116, all -> 0x0112 }
        L_0x00f9:
            java.lang.String r7 = r9.readLine()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            if (r7 == 0) goto L_0x0103
            r8.append(r7)     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            goto L_0x00f9
        L_0x0103:
            java.lang.String r7 = r8.toString()     // Catch:{ IOException -> 0x0110, all -> 0x010e }
            com.xiaomi.push.x.a((java.io.Closeable) r10)
            com.xiaomi.push.x.a((java.io.Closeable) r9)
            return r7
        L_0x010e:
            r7 = move-exception
            goto L_0x0114
        L_0x0110:
            r7 = move-exception
            goto L_0x0118
        L_0x0112:
            r7 = move-exception
            r9 = r3
        L_0x0114:
            r3 = r10
            goto L_0x011c
        L_0x0116:
            r7 = move-exception
            r9 = r3
        L_0x0118:
            r3 = r10
            goto L_0x0128
        L_0x011a:
            r7 = move-exception
            r9 = r3
        L_0x011c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0147 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0147 }
            r8.<init>(r7)     // Catch:{ all -> 0x0147 }
            throw r8     // Catch:{ all -> 0x0147 }
        L_0x0126:
            r7 = move-exception
            r9 = r3
        L_0x0128:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0147 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0147 }
            r10.<init>()     // Catch:{ all -> 0x0147 }
            java.lang.String r0 = "IOException:"
            r10.append(r0)     // Catch:{ all -> 0x0147 }
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0147 }
            java.lang.String r7 = r7.getSimpleName()     // Catch:{ all -> 0x0147 }
            r10.append(r7)     // Catch:{ all -> 0x0147 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x0147 }
            r8.<init>(r7)     // Catch:{ all -> 0x0147 }
            throw r8     // Catch:{ all -> 0x0147 }
        L_0x0147:
            r7 = move-exception
            com.xiaomi.push.x.a((java.io.Closeable) r3)
            com.xiaomi.push.x.a((java.io.Closeable) r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.av.a(java.lang.String, java.util.Map, java.io.File, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.xiaomi.push.aw] */
    public static int a(Context context) {
        ? a11 = a();
        if (a11 == 0) {
            return -1;
        }
        return a11.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m2404a(Context context, URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2407a(Context context) {
        return a(context) >= 0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.xiaomi.push.aw] */
    /* renamed from: a  reason: collision with other method in class */
    public static aw m2401a(Context context) {
        return a();
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.xiaomi.push.aw] */
    /* renamed from: a  reason: collision with other method in class */
    public static String m2403a(Context context) {
        if (d(context)) {
            return "wifi";
        }
        ? a11 = a();
        if (a11 == 0) {
            return "";
        }
        return (a11.a() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + a11.b()).toLowerCase();
    }

    public static at a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        r8 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00be */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:24:0x0082] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.at a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10) {
        /*
            com.xiaomi.push.at r0 = new com.xiaomi.push.at
            r0.<init>()
            r1 = 0
            java.net.URL r2 = a((java.lang.String) r7)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.net.HttpURLConnection r6 = a((android.content.Context) r6, (java.net.URL) r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2 = 15000(0x3a98, float:2.102E-41)
            r6.setReadTimeout(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r8 != 0) goto L_0x001c
            java.lang.String r8 = "GET"
        L_0x001c:
            r6.setRequestMethod(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r8 = 0
            if (r9 == 0) goto L_0x004e
            java.lang.String r2 = "gzip"
            java.lang.String r3 = "Content-Encoding"
            java.lang.Object r3 = r9.get(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.util.Set r3 = r9.keySet()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x0038:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.Object r5 = r9.get(r4)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r6.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            goto L_0x0038
        L_0x004e:
            r2 = r8
        L_0x004f:
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r3 = 1
            if (r9 != 0) goto L_0x0082
            r6.setDoOutput(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            byte[] r9 = r10.getBytes()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r2 == 0) goto L_0x0069
            java.util.zip.GZIPOutputStream r10 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.OutputStream r2 = r6.getOutputStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r10.<init>(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            goto L_0x006d
        L_0x0069:
            java.io.OutputStream r10 = r6.getOutputStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x006d:
            int r2 = r9.length     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.write(r9, r8, r2)     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.flush()     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.close()     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            goto L_0x0082
        L_0x0078:
            r6 = move-exception
            r8 = r1
            r1 = r10
            goto L_0x010c
        L_0x007d:
            r6 = move-exception
            r8 = r1
            r1 = r10
            goto L_0x0118
        L_0x0082:
            int r9 = r6.getResponseCode()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r0.f51402a = r9     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.<init>()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r10 = "Http POST Response Code: "
            r9.append(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            int r10 = r0.f51402a     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.append(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r9)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x009e:
            java.lang.String r9 = r6.getHeaderFieldKey(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r10 = r6.getHeaderField(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r9 != 0) goto L_0x0101
            if (r10 != 0) goto L_0x0101
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            com.xiaomi.push.av$b r10 = new com.xiaomi.push.av$b     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r10.<init>(r2)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r9.<init>(r10)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            goto L_0x00d1
        L_0x00be:
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            com.xiaomi.push.av$b r10 = new com.xiaomi.push.av$b     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.InputStream r6 = r6.getErrorStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r10.<init>(r6)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x00d1:
            java.lang.String r6 = r8.readLine()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r9.<init>()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.String r10 = "line.separator"
            java.lang.String r10 = java.lang.System.getProperty(r10)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
        L_0x00e0:
            if (r6 == 0) goto L_0x00ed
            r9.append(r6)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r9.append(r10)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.String r6 = r8.readLine()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            goto L_0x00e0
        L_0x00ed:
            java.lang.String r6 = r9.toString()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r0.f2540a = r6     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r8.close()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            return r0
        L_0x00fd:
            r6 = move-exception
            goto L_0x010c
        L_0x00ff:
            r6 = move-exception
            goto L_0x0118
        L_0x0101:
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f2541a     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2.put(r9, r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            int r8 = r8 + 1
            int r8 = r8 + r3
            goto L_0x009e
        L_0x010a:
            r6 = move-exception
            r8 = r1
        L_0x010c:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x013f }
            r7.<init>(r6)     // Catch:{ all -> 0x013f }
            throw r7     // Catch:{ all -> 0x013f }
        L_0x0116:
            r6 = move-exception
            r8 = r1
        L_0x0118:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013f }
            r10.<init>()     // Catch:{ all -> 0x013f }
            java.lang.String r0 = "err while request "
            r10.append(r0)     // Catch:{ all -> 0x013f }
            r10.append(r7)     // Catch:{ all -> 0x013f }
            java.lang.String r7 = ":"
            r10.append(r7)     // Catch:{ all -> 0x013f }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x013f }
            r10.append(r6)     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x013f }
            r9.<init>(r6)     // Catch:{ all -> 0x013f }
            throw r9     // Catch:{ all -> 0x013f }
        L_0x013f:
            r6 = move-exception
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.av.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.push.at");
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                } catch (UnsupportedEncodingException e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("Failed to convert from params map to string: " + e11);
                    com.xiaomi.channel.commonutils.logger.b.a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private static URL m2405a(String str) {
        return new URL(str);
    }
}
