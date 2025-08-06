package com.tencent.liteav.base.http;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.google.common.net.HttpHeaders;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.HttpDnsUtil;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLException;
import okhttp3.internal.http.StatusLine;

@JNINamespace("liteav")
public class HttpClientAndroid {
    private static final int ERROR_CODE_INVALID_REQUEST = 0;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final int READ_STREAM_SIZE = 8192;
    private static final int REDIRECT_REQUEST_MAX = 3;
    private static final String TAG = "HttpClientAndroid";
    private static final Object mLock = new Object();
    private HttpURLConnection mConnection;
    /* access modifiers changed from: private */
    public b mHttpConfig;
    private final Handler mHttpHandler;
    private volatile c mInternalState = c.NONE;
    private String mLastRequestURL;
    private final Object mLocker = new Object();
    private long mNativeHttpClientAndroidJni;
    private boolean mPausedRepeatDownloading = false;
    public byte[] mReadDataBytes = new byte[8192];
    private g mRepeatDownloadingStatusCode = g.kUnknownError;
    private final ConcurrentHashMap<Long, d> mRunningRequestMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public long mStartReadTime = 0;
    /* access modifiers changed from: private */
    public long mTotalReadBytes = 0;

    public static class a extends Authenticator {

        /* renamed from: a  reason: collision with root package name */
        public String f21421a;

        /* renamed from: b  reason: collision with root package name */
        public String f21422b;

        public a(String str, String str2) {
            this.f21421a = str;
            this.f21422b = str2;
        }

        public final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f21421a, this.f21422b.toCharArray());
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f21423a;

        /* renamed from: b  reason: collision with root package name */
        public int f21424b;

        /* renamed from: c  reason: collision with root package name */
        public int f21425c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21426d;

        /* renamed from: e  reason: collision with root package name */
        public int f21427e;

        /* renamed from: f  reason: collision with root package name */
        public int f21428f;

        /* renamed from: g  reason: collision with root package name */
        public String f21429g;

        /* renamed from: h  reason: collision with root package name */
        public String f21430h;

        /* renamed from: i  reason: collision with root package name */
        public String f21431i;

        public b(int i11, int i12, int i13, boolean z11, int i14, int i15, String str, String str2, String str3) {
            this.f21423a = i11;
            this.f21424b = i12;
            this.f21425c = i13;
            this.f21426d = z11;
            this.f21427e = i14;
            this.f21428f = i15;
            this.f21429g = str;
            this.f21430h = str2;
            this.f21431i = str3;
        }
    }

    public enum c {
        NONE,
        RUNNING_REPEAT,
        RUNNING_ONCE
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f21436a;

        /* renamed from: b  reason: collision with root package name */
        public String f21437b;

        /* renamed from: c  reason: collision with root package name */
        public String f21438c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f21439d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f21440e;

        /* renamed from: f  reason: collision with root package name */
        public int f21441f = 0;

        /* renamed from: g  reason: collision with root package name */
        public String f21442g = "";

        public d(String str, String str2, byte[] bArr, Map<String, String> map) {
            this.f21437b = str;
            this.f21438c = str2;
            this.f21439d = bArr;
            this.f21440e = map;
        }

        public final boolean a() {
            if (TextUtils.isEmpty(this.f21437b)) {
                return false;
            }
            if (this.f21437b.startsWith("http://") || this.f21437b.startsWith("https://")) {
                return true;
            }
            return false;
        }

        public final boolean b() {
            byte[] bArr = this.f21439d;
            return bArr != null && bArr.length > 0;
        }

        public final boolean c() {
            return HttpClientAndroid.METHOD_POST.equals(d()) || HttpClientAndroid.METHOD_PUT.equals(d());
        }

        public final String d() {
            if (TextUtils.isEmpty(this.f21438c)) {
                return "";
            }
            if (HttpClientAndroid.METHOD_POST.equalsIgnoreCase(this.f21438c)) {
                return HttpClientAndroid.METHOD_POST;
            }
            if (HttpClientAndroid.METHOD_GET.equalsIgnoreCase(this.f21438c)) {
                return HttpClientAndroid.METHOD_GET;
            }
            if (HttpClientAndroid.METHOD_PUT.equalsIgnoreCase(this.f21438c)) {
                return HttpClientAndroid.METHOD_PUT;
            }
            return "";
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Request{requestId=");
            sb2.append(this.f21436a);
            sb2.append(", url='");
            sb2.append(this.f21437b);
            sb2.append('\'');
            sb2.append(", method='");
            sb2.append(this.f21438c);
            sb2.append('\'');
            sb2.append(", body.size=");
            sb2.append(b() ? this.f21439d.length : 0);
            sb2.append(", headers=");
            sb2.append(this.f21440e);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public g f21443a = g.kUnknownError;

        /* renamed from: b  reason: collision with root package name */
        public String f21444b = "";

        /* renamed from: c  reason: collision with root package name */
        public ByteBuffer f21445c;

        /* renamed from: d  reason: collision with root package name */
        public int f21446d = 0;

        /* renamed from: e  reason: collision with root package name */
        public String f21447e = "";

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f21448f = null;

        /* renamed from: g  reason: collision with root package name */
        public int f21449g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f21450h = 0;

        /* renamed from: i  reason: collision with root package name */
        public String f21451i = "";
    }

    public enum f {
        CONNECTED(0),
        DISCONNECTED(1),
        FINISHED(2);
        
        public int nativeValue;

        private f(int i11) {
            this.nativeValue = i11;
        }
    }

    public enum g {
        kHTTP200OK(200),
        kHTTP204NoContent(204),
        kHTTP206PartialContent(206),
        kHTTP301MovedPermanently(301),
        kHTTP302Found(302),
        kHTTP303SeeOther(303),
        kHTTP304NotModified(304),
        kHTTP307TemporaryRedirect(307),
        kHTTP308PermanentRedirect(StatusLine.HTTP_PERM_REDIRECT),
        kHTTP403Forbidden(403),
        kHTTP404NotFound(404),
        kHTTP405MethodNotAllowed(405),
        kHTTP503ServiceUnavailable(503),
        kSystemFileOpenFailed(1001),
        kSystemFileWriteFailed(1002),
        kSystemUnknownHost(1003),
        kSystemConnectHostFailed(1004),
        kSystemCreateSocketFailed(1005),
        kSystemNetworkDisabled(1006),
        kSystemConnectTimeout(1007),
        kSystemConnectRefused(1008),
        kSystemProtocolError(1009),
        kSystemSSLError(1010),
        kUnknownError(MTCommonConstants.RemoteWhat.ON_SERVICE_CONNECTED);
        
        public final int nativeValue;

        private g(int i11) {
            this.nativeValue = i11;
        }
    }

    public HttpClientAndroid(int i11, int i12, int i13, boolean z11, int i14, int i15, String str, String str2, String str3, long j11) {
        this.mHttpConfig = new b(i11, i12, i13, z11, i14, i15, str, str2, str3);
        this.mNativeHttpClientAndroidJni = j11;
        HandlerThread handlerThread = new HandlerThread("HttpClient_" + hashCode());
        handlerThread.start();
        LiteavLog.i(TAG, "Create http client(" + hashCode() + "). [ThreadName:" + handlerThread.getName() + "][ThreadId:" + handlerThread.getId() + "]");
        this.mHttpHandler = new Handler(handlerThread.getLooper());
    }

    private boolean checkNativeValid() {
        boolean z11;
        synchronized (this.mLocker) {
            z11 = this.mNativeHttpClientAndroidJni != -1;
        }
        return z11;
    }

    private boolean checkRequestValid(long j11) {
        return this.mRunningRequestMap.containsKey(Long.valueOf(j11));
    }

    private void closeConnectionSafely(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                closeIO(httpURLConnection.getInputStream());
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            } catch (Throwable th2) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e14) {
                    e14.printStackTrace();
                }
                throw th2;
            }
        }
    }

    private void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    private HttpURLConnection createConnection(d dVar) throws Exception {
        Proxy proxy;
        HttpURLConnection httpURLConnection;
        String replace = dVar.f21437b.replace(" ", "%20");
        URL url = new URL(replace);
        if (!TextUtils.isEmpty(this.mHttpConfig.f21429g) && this.mHttpConfig.f21428f > 0) {
            Proxy.Type type = Proxy.Type.SOCKS;
            b bVar = this.mHttpConfig;
            proxy = new Proxy(type, new InetSocketAddress(bVar.f21429g, bVar.f21428f));
            b bVar2 = this.mHttpConfig;
            Authenticator.setDefault(new a(bVar2.f21430h, bVar2.f21431i));
        } else if ("127.0.0.1".equals(url.getHost()) || "localhost".equals(url.getHost())) {
            proxy = Proxy.NO_PROXY;
        } else {
            proxy = null;
        }
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            if (HttpDnsUtil.verifyCustomHttpDNS(url.getHost())) {
                try {
                    httpURLConnection = HttpDnsUtil.createConnectionUseCustomHttpDNS(replace, url.getHost());
                } catch (Exception e11) {
                    LiteavLog.w(TAG, "(" + hashCode() + ")createConnectionUseCustomHttpDNS failed. error: " + Log.getStackTraceString(e11));
                }
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(this.mHttpConfig.f21423a);
        httpURLConnection.setReadTimeout(this.mHttpConfig.f21424b);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
        httpURLConnection.setRequestMethod(dVar.d());
        if (dVar.c()) {
            httpURLConnection.setDoOutput(true);
        }
        if (this.mHttpConfig.f21426d) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
        } else {
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
        }
        Map<String, String> map = dVar.f21440e;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : dVar.f21440e.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r26 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        closeConnectionSafely(r1.mConnection);
        r1.mConnection = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026 A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038 A[Catch:{ all -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[SYNTHETIC, Splitter:B:19:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doCallbackAndResetState(com.tencent.liteav.base.http.HttpClientAndroid.f r22, long r23, com.tencent.liteav.base.http.HttpClientAndroid.e r25, boolean r26) {
        /*
            r21 = this;
            r1 = r21
            r0 = r25
            java.lang.Object r2 = r1.mLocker
            monitor-enter(r2)
            boolean r3 = r21.checkNativeValid()     // Catch:{ all -> 0x0079 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x001b
            r10 = r23
            boolean r3 = r1.checkRequestValid(r10)     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x001d
            if (r0 == 0) goto L_0x001d
            r3 = r4
            goto L_0x001e
        L_0x001b:
            r10 = r23
        L_0x001d:
            r3 = r5
        L_0x001e:
            com.tencent.liteav.base.http.HttpClientAndroid$c r6 = com.tencent.liteav.base.http.HttpClientAndroid.c.RUNNING_REPEAT     // Catch:{ all -> 0x0079 }
            com.tencent.liteav.base.http.HttpClientAndroid$c r7 = r1.mInternalState     // Catch:{ all -> 0x0079 }
            if (r6 != r7) goto L_0x0026
            r8 = r4
            goto L_0x0027
        L_0x0026:
            r8 = r5
        L_0x0027:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r1.mRunningRequestMap     // Catch:{ all -> 0x0079 }
            java.lang.Long r5 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x0079 }
            r4.remove(r5)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r1.mRunningRequestMap     // Catch:{ all -> 0x0079 }
            int r4 = r4.size()     // Catch:{ all -> 0x0079 }
            if (r4 != 0) goto L_0x003c
            com.tencent.liteav.base.http.HttpClientAndroid$c r4 = com.tencent.liteav.base.http.HttpClientAndroid.c.NONE     // Catch:{ all -> 0x0079 }
            r1.mInternalState = r4     // Catch:{ all -> 0x0079 }
        L_0x003c:
            if (r3 == 0) goto L_0x0067
            long r6 = r1.mNativeHttpClientAndroidJni     // Catch:{ all -> 0x0075 }
            r3 = r22
            int r9 = r3.nativeValue     // Catch:{ all -> 0x0075 }
            com.tencent.liteav.base.http.HttpClientAndroid$g r3 = r0.f21443a     // Catch:{ all -> 0x0075 }
            int r12 = r3.nativeValue     // Catch:{ all -> 0x0075 }
            java.lang.String r13 = r0.f21444b     // Catch:{ all -> 0x0075 }
            int r14 = r0.f21449g     // Catch:{ all -> 0x0075 }
            java.nio.ByteBuffer r15 = r0.f21445c     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = r0.f21447e     // Catch:{ all -> 0x0075 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r0.f21448f     // Catch:{ all -> 0x0075 }
            int r5 = r0.f21446d     // Catch:{ all -> 0x0075 }
            int r1 = r0.f21450h     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.f21451i     // Catch:{ all -> 0x0075 }
            r10 = r23
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r1
            r20 = r0
            nativeOnCallback(r6, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0075 }
        L_0x0067:
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            r1 = r21
            if (r26 == 0) goto L_0x0074
            java.net.HttpURLConnection r0 = r1.mConnection
            r1.closeConnectionSafely(r0)
            r0 = 0
            r1.mConnection = r0
        L_0x0074:
            return
        L_0x0075:
            r0 = move-exception
            r1 = r21
            goto L_0x007a
        L_0x0079:
            r0 = move-exception
        L_0x007a:
            monitor-exit(r2)     // Catch:{ all -> 0x0079 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.doCallbackAndResetState(com.tencent.liteav.base.http.HttpClientAndroid$f, long, com.tencent.liteav.base.http.HttpClientAndroid$e, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean doOnCallback(com.tencent.liteav.base.http.HttpClientAndroid.f r21, long r22, com.tencent.liteav.base.http.HttpClientAndroid.e r24) {
        /*
            r20 = this;
            r1 = r20
            r0 = r24
            java.lang.Object r2 = r1.mLocker
            monitor-enter(r2)
            boolean r3 = r20.checkNativeValid()     // Catch:{ all -> 0x004c }
            r4 = 0
            if (r3 == 0) goto L_0x004a
            r9 = r22
            boolean r3 = r1.checkRequestValid(r9)     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x004a
            com.tencent.liteav.base.http.HttpClientAndroid$c r3 = com.tencent.liteav.base.http.HttpClientAndroid.c.RUNNING_REPEAT     // Catch:{ all -> 0x004c }
            com.tencent.liteav.base.http.HttpClientAndroid$c r5 = r1.mInternalState     // Catch:{ all -> 0x004c }
            if (r3 != r5) goto L_0x001f
            r4 = 1
        L_0x001f:
            r7 = r4
            long r5 = r1.mNativeHttpClientAndroidJni     // Catch:{ all -> 0x004c }
            r3 = r21
            int r8 = r3.nativeValue     // Catch:{ all -> 0x004c }
            com.tencent.liteav.base.http.HttpClientAndroid$g r3 = r0.f21443a     // Catch:{ all -> 0x004c }
            int r11 = r3.nativeValue     // Catch:{ all -> 0x004c }
            java.lang.String r12 = r0.f21444b     // Catch:{ all -> 0x004c }
            int r13 = r0.f21449g     // Catch:{ all -> 0x004c }
            java.nio.ByteBuffer r14 = r0.f21445c     // Catch:{ all -> 0x004c }
            java.lang.String r15 = r0.f21447e     // Catch:{ all -> 0x004c }
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.f21448f     // Catch:{ all -> 0x004c }
            int r4 = r0.f21446d     // Catch:{ all -> 0x004c }
            int r1 = r0.f21450h     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r0.f21451i     // Catch:{ all -> 0x004c }
            r9 = r22
            r16 = r3
            r17 = r4
            r18 = r1
            r19 = r0
            boolean r0 = nativeOnCallback(r5, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x004c }
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            return r0
        L_0x004a:
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            return r4
        L_0x004c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.doOnCallback(com.tencent.liteav.base.http.HttpClientAndroid$f, long, com.tencent.liteav.base.http.HttpClientAndroid$e):boolean");
    }

    private void doReadData(long j11, e eVar) {
        boolean z11;
        long j12;
        boolean z12;
        if (!checkRequestValid(j11)) {
            closeConnectionSafely(this.mConnection);
            LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Invalid request id. id:" + j11);
            return;
        }
        try {
            InputStream inputStream = this.mConnection.getInputStream();
            synchronized (this.mLocker) {
                z11 = this.mInternalState == c.RUNNING_ONCE;
            }
            long j13 = 0;
            if (z11) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                do {
                    try {
                        int read = inputStream.read(this.mReadDataBytes);
                        if (read > 0) {
                            byteArrayOutputStream.write(this.mReadDataBytes, 0, read);
                        }
                        if (read <= 0 || !checkRequestValid(j11)) {
                            z12 = false;
                            continue;
                        } else {
                            z12 = true;
                            continue;
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                        eVar.f21443a = getStatusCode(e11);
                        eVar.f21444b = e11.toString();
                        doCallbackAndResetState(f.DISCONNECTED, j11, eVar, true);
                        return;
                    }
                } while (z12);
                int size = byteArrayOutputStream.size();
                if (size > 0) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size);
                    eVar.f21445c = allocateDirect;
                    allocateDirect.put(byteArrayOutputStream.toByteArray(), 0, size);
                    eVar.f21446d = size;
                }
                j12 = 0;
            } else {
                try {
                    int read2 = inputStream.read(this.mReadDataBytes);
                    this.mTotalReadBytes += (long) read2;
                    j12 = SystemClock.elapsedRealtime();
                    if (read2 > 0) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(read2);
                        eVar.f21445c = allocateDirect2;
                        allocateDirect2.put(this.mReadDataBytes, 0, read2);
                        eVar.f21446d = read2;
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                    LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                    eVar.f21443a = getStatusCode(e12);
                    eVar.f21444b = e12.toString();
                    doCallbackAndResetState(f.DISCONNECTED, j11, eVar, true);
                    return;
                }
            }
            if (eVar.f21446d == 0 && !z11) {
                LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Rsp size is 0.");
                doCallbackAndResetState(f.FINISHED, j11, eVar, this.mHttpConfig.f21426d ^ true);
            } else if (z11) {
                doCallbackAndResetState(f.FINISHED, j11, eVar, !this.mHttpConfig.f21426d);
            } else {
                boolean doOnCallback = doOnCallback(f.CONNECTED, j11, eVar);
                this.mPausedRepeatDownloading = doOnCallback;
                this.mRepeatDownloadingStatusCode = eVar.f21443a;
                if (!doOnCallback) {
                    int i11 = this.mHttpConfig.f21427e;
                    if (i11 > 0) {
                        long j14 = this.mStartReadTime;
                        long j15 = j12 - j14 == 0 ? 1 : j12 - j14;
                        long j16 = this.mTotalReadBytes;
                        if (j16 / j15 > ((long) (i11 / 1000))) {
                            j13 = ((j16 * 1000) / ((long) i11)) - j15;
                        }
                    }
                    this.mHttpHandler.postDelayed(f.a(this, eVar, j11), j13);
                }
            }
        } catch (Exception e13) {
            e13.printStackTrace();
            LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Fail to get InputStream.");
            eVar.f21443a = getStatusCode(e13);
            eVar.f21444b = e13.toString();
            doCallbackAndResetState(f.DISCONNECTED, j11, eVar, true);
        }
    }

    /* access modifiers changed from: private */
    public void doRequest(d dVar) {
        e eVar = null;
        int i11 = 0;
        while (i11 < 4) {
            eVar = internalRequest(dVar);
            if (eVar != null) {
                g gVar = eVar.f21443a;
                if (gVar != g.kHTTP301MovedPermanently && gVar != g.kHTTP302Found) {
                    break;
                }
                String headerField = this.mConnection.getHeaderField(HttpHeaders.LOCATION);
                dVar.f21437b = headerField;
                dVar.f21441f++;
                dVar.f21442g = headerField;
                i11++;
            } else {
                return;
            }
        }
        this.mTotalReadBytes = 0;
        this.mStartReadTime = SystemClock.elapsedRealtime();
        doReadData(dVar.f21436a, eVar);
    }

    public static HashMap getJavaHashMap(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return new HashMap();
        }
        if (strArr.length != strArr2.length) {
            LiteavLog.w(TAG, "Invalid parameter, keys and values do not match.");
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            hashMap.put(strArr[i11], strArr2[i11]);
        }
        return hashMap;
    }

    public static String[] getMapKeys(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        Set<String> keySet = map.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public static String[] getMapValue(Map<String, String> map, String[] strArr) {
        if (map == null || map.isEmpty() || strArr == null || strArr.length == 0) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr2[i11] = map.get(strArr[i11]);
        }
        return strArr2;
    }

    private Map<String, String> getResponseHeaders(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                hashMap.put(next.getKey(), ((List) next.getValue()).get(0));
            }
        }
        return hashMap;
    }

    private g getStatusCode(int i11) {
        g gVar = g.kUnknownError;
        if (i11 == 200) {
            return g.kHTTP200OK;
        }
        if (i11 == 204) {
            return g.kHTTP204NoContent;
        }
        if (i11 == 206) {
            return g.kHTTP206PartialContent;
        }
        if (i11 == 301) {
            return g.kHTTP301MovedPermanently;
        }
        if (i11 == 302) {
            return g.kHTTP302Found;
        }
        if (i11 == 303) {
            return g.kHTTP303SeeOther;
        }
        if (i11 == 304) {
            return g.kHTTP304NotModified;
        }
        if (i11 == 307) {
            return g.kHTTP307TemporaryRedirect;
        }
        if (i11 == 308) {
            return g.kHTTP308PermanentRedirect;
        }
        if (i11 == 403) {
            return g.kHTTP403Forbidden;
        }
        if (i11 == 404) {
            return g.kHTTP404NotFound;
        }
        if (i11 == 405) {
            return g.kHTTP405MethodNotAllowed;
        }
        if (i11 == 503) {
            return g.kHTTP503ServiceUnavailable;
        }
        Log.w(TAG, "(" + hashCode() + ")Failed to convert status code：" + i11, new Object[0]);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.liteav.base.http.HttpClientAndroid.e internalRequest(com.tencent.liteav.base.http.HttpClientAndroid.d r9) {
        /*
            r8 = this;
            boolean r0 = r9.a()
            r1 = 0
            if (r0 != 0) goto L_0x002e
            java.lang.String r0 = "HttpClientAndroid"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "("
            r2.<init>(r3)
            int r3 = r8.hashCode()
            r2.append(r3)
            java.lang.String r3 = ")Send request failed. Invalid request url("
            r2.append(r3)
            java.lang.String r9 = r9.f21437b
            r2.append(r9)
            java.lang.String r9 = ")."
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.e(r0, r9)
            return r1
        L_0x002e:
            long r2 = r9.f21436a
            boolean r0 = r8.checkRequestValid(r2)
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "HttpClientAndroid"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "("
            r2.<init>(r3)
            int r3 = r8.hashCode()
            r2.append(r3)
            java.lang.String r3 = ")Do send failed. ignore request when cancelled. request:"
            r2.append(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.w(r0, r9)
            return r1
        L_0x0056:
            com.tencent.liteav.base.http.HttpClientAndroid$e r6 = new com.tencent.liteav.base.http.HttpClientAndroid$e
            r6.<init>()
            int r0 = r9.f21441f
            r6.f21450h = r0
            java.lang.String r0 = r9.f21442g
            r6.f21451i = r0
            java.lang.Object r0 = r8.mLocker
            monitor-enter(r0)
            com.tencent.liteav.base.http.HttpClientAndroid$c r2 = r8.mInternalState     // Catch:{ all -> 0x01bc }
            com.tencent.liteav.base.http.HttpClientAndroid$c r3 = com.tencent.liteav.base.http.HttpClientAndroid.c.RUNNING_ONCE     // Catch:{ all -> 0x01bc }
            if (r2 != r3) goto L_0x006e
            r2 = 1
            goto L_0x006f
        L_0x006e:
            r2 = 0
        L_0x006f:
            monitor-exit(r0)     // Catch:{ all -> 0x01bc }
            if (r2 == 0) goto L_0x0087
            java.net.HttpURLConnection r0 = r8.mConnection
            if (r0 == 0) goto L_0x0087
            java.lang.String r0 = r9.f21437b
            java.lang.String r2 = r8.mLastRequestURL
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0087
            java.net.HttpURLConnection r0 = r8.mConnection
            r8.closeConnectionSafely(r0)
            r8.mConnection = r1
        L_0x0087:
            java.lang.String r0 = r9.f21437b
            r8.mLastRequestURL = r0
            java.net.HttpURLConnection r0 = r8.createConnection(r9)     // Catch:{ Exception -> 0x017f }
            r8.mConnection = r0     // Catch:{ Exception -> 0x017f }
            boolean r0 = r9.c()
            if (r0 == 0) goto L_0x00db
            boolean r0 = r9.b()
            if (r0 == 0) goto L_0x00db
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
            byte[] r2 = r9.f21439d     // Catch:{ Exception -> 0x00af }
            r0.write(r2)     // Catch:{ Exception -> 0x00af }
            r0.flush()     // Catch:{ Exception -> 0x00af }
        L_0x00ab:
            r8.closeIO(r0)
            goto L_0x00db
        L_0x00af:
            r2 = move-exception
            goto L_0x00b5
        L_0x00b1:
            r9 = move-exception
            goto L_0x00d7
        L_0x00b3:
            r2 = move-exception
            r0 = r1
        L_0x00b5:
            r2.printStackTrace()     // Catch:{ all -> 0x00d5 }
            java.lang.String r2 = "HttpClientAndroid"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "("
            r3.<init>(r4)     // Catch:{ all -> 0x00d5 }
            int r4 = r8.hashCode()     // Catch:{ all -> 0x00d5 }
            r3.append(r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = ")Do send body failed."
            r3.append(r4)     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d5 }
            com.tencent.liteav.base.util.LiteavLog.w(r2, r3)     // Catch:{ all -> 0x00d5 }
            goto L_0x00ab
        L_0x00d5:
            r9 = move-exception
            r1 = r0
        L_0x00d7:
            r8.closeIO(r1)
            throw r9
        L_0x00db:
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x0142 }
            int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x0142 }
            com.tencent.liteav.base.http.HttpClientAndroid$g r0 = r8.getStatusCode((int) r0)     // Catch:{ Exception -> 0x0142 }
            r6.f21443a = r0     // Catch:{ Exception -> 0x0142 }
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x0142 }
            java.lang.String r0 = r0.getResponseMessage()     // Catch:{ Exception -> 0x0142 }
            r6.f21444b = r0     // Catch:{ Exception -> 0x0142 }
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x0142 }
            java.net.URL r0 = r0.getURL()     // Catch:{ Exception -> 0x0142 }
            java.lang.String r0 = r0.getHost()     // Catch:{ Exception -> 0x0142 }
            java.lang.String r0 = r8.parseHostAddress(r0)     // Catch:{ Exception -> 0x0142 }
            r6.f21447e = r0     // Catch:{ Exception -> 0x0142 }
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x0142 }
            java.net.URL r0 = r0.getURL()     // Catch:{ Exception -> 0x0142 }
            int r0 = r0.getPort()     // Catch:{ Exception -> 0x0142 }
            r6.f21449g = r0     // Catch:{ Exception -> 0x0142 }
            java.net.HttpURLConnection r0 = r8.mConnection     // Catch:{ Exception -> 0x0142 }
            java.util.Map r0 = r0.getHeaderFields()     // Catch:{ Exception -> 0x0142 }
            java.util.Map r0 = r8.getResponseHeaders(r0)     // Catch:{ Exception -> 0x0142 }
            r6.f21448f = r0     // Catch:{ Exception -> 0x0142 }
            long r2 = r9.f21436a
            boolean r9 = r8.checkRequestValid(r2)
            if (r9 != 0) goto L_0x0141
            java.net.HttpURLConnection r9 = r8.mConnection
            r8.closeConnectionSafely(r9)
            java.lang.String r9 = "HttpClientAndroid"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "("
            r0.<init>(r2)
            int r2 = r8.hashCode()
            r0.append(r2)
            java.lang.String r2 = ")Do send failed. Invalid request, abort request."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.tencent.liteav.base.util.LiteavLog.w(r9, r0)
            return r1
        L_0x0141:
            return r6
        L_0x0142:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r2 = "HttpClientAndroid"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            int r4 = r8.hashCode()
            r3.append(r4)
            java.lang.String r4 = ")Do send failed. Catch error. ex= "
            r3.append(r4)
            java.lang.String r4 = com.tencent.liteav.base.Log.getStackTraceString(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.e(r2, r3)
            com.tencent.liteav.base.http.HttpClientAndroid$g r2 = r8.getStatusCode((java.lang.Exception) r0)
            r6.f21443a = r2
            java.lang.String r0 = r0.toString()
            r6.f21444b = r0
            com.tencent.liteav.base.http.HttpClientAndroid$f r3 = com.tencent.liteav.base.http.HttpClientAndroid.f.DISCONNECTED
            long r4 = r9.f21436a
            r7 = 1
            r2 = r8
            r2.doCallbackAndResetState(r3, r4, r6, r7)
            return r1
        L_0x017f:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r2 = "HttpClientAndroid"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            int r4 = r8.hashCode()
            r3.append(r4)
            java.lang.String r4 = ")Do send failed. Fail to create http connection. ex= "
            r3.append(r4)
            java.lang.String r4 = com.tencent.liteav.base.Log.getStackTraceString(r0)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.e(r2, r3)
            com.tencent.liteav.base.http.HttpClientAndroid$g r2 = r8.getStatusCode((java.lang.Exception) r0)
            r6.f21443a = r2
            java.lang.String r0 = r0.toString()
            r6.f21444b = r0
            com.tencent.liteav.base.http.HttpClientAndroid$f r3 = com.tencent.liteav.base.http.HttpClientAndroid.f.DISCONNECTED
            long r4 = r9.f21436a
            r7 = 1
            r2 = r8
            r2.doCallbackAndResetState(r3, r4, r6, r7)
            return r1
        L_0x01bc:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01bc }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.internalRequest(com.tencent.liteav.base.http.HttpClientAndroid$d):com.tencent.liteav.base.http.HttpClientAndroid$e");
    }

    public static /* synthetic */ void lambda$cancelAll$1(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
    }

    public static /* synthetic */ void lambda$destroy$4(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            httpClientAndroid.mHttpHandler.getLooper().quitSafely();
        } else {
            httpClientAndroid.mHttpHandler.getLooper().quit();
        }
    }

    public static /* synthetic */ void lambda$doReadData$5(HttpClientAndroid httpClientAndroid, e eVar, long j11) {
        e eVar2 = new e();
        eVar2.f21443a = eVar.f21443a;
        httpClientAndroid.doReadData(j11, eVar2);
    }

    public static /* synthetic */ void lambda$resumeRepeatDownload$2(HttpClientAndroid httpClientAndroid, Long l11) {
        e eVar = new e();
        eVar.f21443a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(l11.longValue(), eVar);
    }

    public static /* synthetic */ void lambda$resumeRepeatDownload$3(HttpClientAndroid httpClientAndroid, long j11) {
        e eVar = new e();
        eVar.f21443a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(j11, eVar);
    }

    private static native boolean nativeOnCallback(long j11, boolean z11, int i11, long j12, int i12, String str, int i13, ByteBuffer byteBuffer, String str2, Map map, int i14, int i15, String str3);

    private String parseHostAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception unused) {
            LiteavLog.w(TAG, "(" + hashCode() + ")Parse host error. host:" + str);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel(long r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLocker
            monitor-enter(r0)
            boolean r1 = r3.checkNativeValid()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0027
            java.lang.String r4 = "HttpClientAndroid"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            java.lang.String r1 = "("
            r5.<init>(r1)     // Catch:{ all -> 0x006a }
            int r1 = r3.hashCode()     // Catch:{ all -> 0x006a }
            r5.append(r1)     // Catch:{ all -> 0x006a }
            java.lang.String r1 = ")Cancel request failed. Invalid native handle."
            r5.append(r1)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006a }
            com.tencent.liteav.base.util.LiteavLog.e(r4, r5)     // Catch:{ all -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x0027:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r1 = r3.mRunningRequestMap     // Catch:{ all -> 0x006a }
            int r1 = r1.size()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x0031:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r1 = r3.mRunningRequestMap     // Catch:{ all -> 0x006a }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x006a }
            java.lang.Object r4 = r1.remove(r4)     // Catch:{ all -> 0x006a }
            com.tencent.liteav.base.http.HttpClientAndroid$d r4 = (com.tencent.liteav.base.http.HttpClientAndroid.d) r4     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "HttpClientAndroid"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            java.lang.String r2 = "("
            r1.<init>(r2)     // Catch:{ all -> 0x006a }
            int r2 = r3.hashCode()     // Catch:{ all -> 0x006a }
            r1.append(r2)     // Catch:{ all -> 0x006a }
            java.lang.String r2 = ")Cancel request. request:"
            r1.append(r2)     // Catch:{ all -> 0x006a }
            r1.append(r4)     // Catch:{ all -> 0x006a }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x006a }
            com.tencent.liteav.base.util.LiteavLog.i(r5, r4)     // Catch:{ all -> 0x006a }
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r3.mRunningRequestMap     // Catch:{ all -> 0x006a }
            int r4 = r4.size()     // Catch:{ all -> 0x006a }
            if (r4 != 0) goto L_0x0068
            com.tencent.liteav.base.http.HttpClientAndroid$c r4 = com.tencent.liteav.base.http.HttpClientAndroid.c.NONE     // Catch:{ all -> 0x006a }
            r3.mInternalState = r4     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.cancel(long):void");
    }

    public void cancelAll() {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel all request failed. Invalid native handle.");
                return;
            }
            c cVar = this.mInternalState;
            c cVar2 = c.NONE;
            if (cVar != cVar2) {
                this.mInternalState = cVar2;
                LiteavLog.i(TAG, "(" + hashCode() + ")Cancel all. size:" + this.mRunningRequestMap.size());
                this.mRunningRequestMap.clear();
                this.mHttpHandler.post(b.a(this));
            }
        }
    }

    public void destroy() {
        synchronized (this.mLocker) {
            this.mRunningRequestMap.clear();
            this.mNativeHttpClientAndroidJni = -1;
            this.mHttpHandler.post(e.a(this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resumeRepeatDownload(long r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLocker
            monitor-enter(r0)
            boolean r1 = r3.checkNativeValid()     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0027
            java.lang.String r4 = "HttpClientAndroid"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "("
            r5.<init>(r1)     // Catch:{ all -> 0x0088 }
            int r1 = r3.hashCode()     // Catch:{ all -> 0x0088 }
            r5.append(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = ")Cancel request failed. Invalid native handle."
            r5.append(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0088 }
            com.tencent.liteav.base.util.LiteavLog.e(r4, r5)     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0027:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r1 = r3.mRunningRequestMap     // Catch:{ all -> 0x0088 }
            int r1 = r1.size()     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0031:
            com.tencent.liteav.base.http.HttpClientAndroid$c r1 = r3.mInternalState     // Catch:{ all -> 0x0088 }
            com.tencent.liteav.base.http.HttpClientAndroid$c r2 = com.tencent.liteav.base.http.HttpClientAndroid.c.RUNNING_REPEAT     // Catch:{ all -> 0x0088 }
            if (r1 != r2) goto L_0x0086
            boolean r1 = r3.mPausedRepeatDownloading     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x003c
            goto L_0x0086
        L_0x003c:
            r1 = 0
            r3.mPausedRepeatDownloading = r1     // Catch:{ all -> 0x0088 }
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0065
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r4 = r3.mRunningRequestMap     // Catch:{ all -> 0x0088 }
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0088 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0088 }
        L_0x004f:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x0084
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0088 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0088 }
            android.os.Handler r1 = r3.mHttpHandler     // Catch:{ all -> 0x0088 }
            java.lang.Runnable r5 = com.tencent.liteav.base.http.c.a(r3, r5)     // Catch:{ all -> 0x0088 }
            r1.post(r5)     // Catch:{ all -> 0x0088 }
            goto L_0x004f
        L_0x0065:
            boolean r1 = r3.checkRequestValid(r4)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0084
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.liteav.base.http.HttpClientAndroid$d> r1 = r3.mRunningRequestMap     // Catch:{ all -> 0x0088 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0088 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0088 }
            com.tencent.liteav.base.http.HttpClientAndroid$d r1 = (com.tencent.liteav.base.http.HttpClientAndroid.d) r1     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x007b
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x007b:
            android.os.Handler r1 = r3.mHttpHandler     // Catch:{ all -> 0x0088 }
            java.lang.Runnable r4 = com.tencent.liteav.base.http.d.a(r3, r4)     // Catch:{ all -> 0x0088 }
            r1.post(r4)     // Catch:{ all -> 0x0088 }
        L_0x0084:
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            return
        L_0x0088:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.resumeRepeatDownload(long):void");
    }

    public long send(long j11, String str, String str2, byte[] bArr, Map<String, String> map, boolean z11) {
        if (!checkNativeValid()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid native handle.");
            return 0;
        }
        d dVar = new d(str, str2, bArr, map);
        if (!dVar.a()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid request url(" + dVar.f21437b + ").");
            return 0;
        }
        boolean z12 = true;
        if (!(!TextUtils.isEmpty(dVar.d()))) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Request method(" + dVar.f21438c + ") is not supported.");
            return 0;
        }
        synchronized (this.mLocker) {
            if (this.mInternalState == c.NONE) {
                this.mInternalState = z11 ? c.RUNNING_REPEAT : c.RUNNING_ONCE;
            } else if (this.mInternalState != c.RUNNING_ONCE) {
                z12 = false;
            }
            if (z12) {
                dVar.f21436a = j11;
                this.mRunningRequestMap.put(Long.valueOf(j11), dVar);
                this.mHttpHandler.post(a.a(this, dVar));
                long j12 = dVar.f21436a;
                return j12;
            }
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid state:" + this.mInternalState);
            return 0;
        }
    }

    public void updateConfig(int i11, int i12, int i13, boolean z11, int i14, int i15, String str, String str2, String str3, long j11) {
        final int i16 = i11;
        final int i17 = i12;
        final int i18 = i13;
        final boolean z12 = z11;
        final int i19 = i14;
        final int i21 = i15;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        this.mHttpHandler.post(new Runnable() {
            public final void run() {
                b unused = HttpClientAndroid.this.mHttpConfig = new b(i16, i17, i18, z12, i19, i21, str4, str5, str6);
                if (i19 > 0) {
                    long unused2 = HttpClientAndroid.this.mTotalReadBytes = 0;
                    long unused3 = HttpClientAndroid.this.mStartReadTime = SystemClock.elapsedRealtime();
                }
            }
        });
    }

    private g getStatusCode(Exception exc) {
        g gVar = g.kUnknownError;
        if (exc instanceof FileNotFoundException) {
            return g.kSystemFileOpenFailed;
        }
        if (exc instanceof EOFException) {
            return g.kSystemFileWriteFailed;
        }
        if (exc instanceof UnknownHostException) {
            return g.kSystemUnknownHost;
        }
        if (exc instanceof NoRouteToHostException) {
            return g.kSystemConnectHostFailed;
        }
        if ((exc instanceof SocketException) || (exc instanceof MalformedURLException)) {
            return g.kSystemCreateSocketFailed;
        }
        if (exc instanceof SocketTimeoutException) {
            return g.kSystemConnectTimeout;
        }
        if (exc instanceof ConnectException) {
            return g.kSystemConnectRefused;
        }
        if (exc instanceof ProtocolException) {
            return g.kSystemProtocolError;
        }
        if (exc instanceof SSLException) {
            return g.kSystemSSLError;
        }
        Log.w(TAG, "(" + hashCode() + ")Failed to convert status code, exception：", exc.toString());
        return gVar;
    }
}
