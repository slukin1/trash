package com.mob.tools.network;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import com.jumio.core.cdn.CDNDownload;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.MobProduct;
import com.mob.commons.aa;
import com.mob.commons.e;
import com.mob.commons.u;
import com.mob.commons.v;
import com.mob.mcl.b.a;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class NetCommunicator implements PublicMemberKeeper {
    public static final String KEY_DUID = C0891r.b("004Zcbcfchcb");
    public static final String KEY_DUID_PREVIOUS = "duidPrevious";
    public static final String KEY_IS_MODIFIED = "isModified";

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadPoolExecutor f27918a = new ThreadPoolExecutor(3, 20, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());

    /* renamed from: b  reason: collision with root package name */
    private BigInteger f27919b;

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f27920c;

    /* renamed from: d  reason: collision with root package name */
    private MobRSA f27921d;

    /* renamed from: e  reason: collision with root package name */
    private NetworkHelper f27922e;

    /* renamed from: f  reason: collision with root package name */
    private NetworkHelper.NetworkTimeOut f27923f;

    /* renamed from: g  reason: collision with root package name */
    private ThreadPoolExecutor f27924g;

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th2) {
        }

        public void onResultOk(T t11) {
        }
    }

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public NetCommunicator(int i11, String str, String str2) {
        this(i11, str, str2, (NetworkHelper.NetworkTimeOut) null);
    }

    public static String checkHttpRequestUrl(String str) {
        return v.b(str);
    }

    public static String dynamicModifyUrl(String str) {
        return v.a(str);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() throws Throwable {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(C0891r.b("003Idg%eCdb"), u.a());
        hashMap.put(C0891r.b("013?djehJeZcigjddcbYedhFch3hGdb"), aa.c());
        hashMap.put(C0891r.b("0047cecjchcb"), c.a(MobSDK.getContext()).d().ai());
        return hashMap;
    }

    public static synchronized String getDUID(MobProduct mobProduct) {
        String a11;
        synchronized (NetCommunicator.class) {
            a11 = e.a(mobProduct);
        }
        return a11;
    }

    public static synchronized HashMap<String, Object> getDUIDWithModifyInfo(MobProduct mobProduct) {
        HashMap<String, Object> b11;
        synchronized (NetCommunicator.class) {
            b11 = e.b(mobProduct);
        }
        return b11;
    }

    public void addTcpIntercept(String str) {
        try {
            a.a(str);
        } catch (Throwable unused) {
        }
    }

    public void removeTcpIntercept(String str) {
        try {
            a.b(str);
        } catch (Throwable unused) {
        }
    }

    public <T> void request(HashMap<String, Object> hashMap, String str, boolean z11, Callback<T> callback) {
        request(true, (HashMap<String, String>) null, hashMap, str, z11, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> hashMap, String str, boolean z11) throws Throwable {
        return requestSynchronized((HashMap<String, String>) null, hashMap, str, z11);
    }

    public String requestSynchronizedGet(String str, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) throws Throwable {
        try {
            a.a((String) null);
            String a11 = a.a(false, str, hashMap, hashMap2, this.f27923f);
            NLog instance = MobLog.getInstance();
            instance.d(">>> gt res:  " + a11, new Object[0]);
            return a11;
        } catch (Throwable unused) {
            return this.f27922e.httpGetNew(str, hashMap, hashMap2, this.f27923f);
        }
    }

    public <T> T requestWithoutEncode(boolean z11, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z12) throws Throwable {
        return a(z11, hashMap, a(hashMap2), str, true, false, z12);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.f27924g = threadPoolExecutor;
    }

    public NetCommunicator(int i11, String str, String str2, NetworkHelper.NetworkTimeOut networkTimeOut) {
        this.f27921d = new MobRSA(i11);
        this.f27919b = new BigInteger(str, 16);
        this.f27920c = new BigInteger(str2, 16);
        this.f27922e = new NetworkHelper();
        if (networkTimeOut != null) {
            this.f27923f = networkTimeOut;
        } else {
            NetworkHelper.NetworkTimeOut networkTimeOut2 = new NetworkHelper.NetworkTimeOut();
            this.f27923f = networkTimeOut2;
            networkTimeOut2.readTimout = CDNDownload.DEFAULT_TIMEOUT;
            networkTimeOut2.connectionTimeout = 5000;
        }
        this.f27924g = f27918a;
    }

    public <T> void request(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z11, Callback<T> callback) {
        request(true, hashMap, hashMap2, str, z11, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z11) throws Throwable {
        return requestSynchronized(true, hashMap, hashMap2, str, z11);
    }

    private String a(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return "{}";
        }
        String fromHashMap = HashonHelper.fromHashMap(hashMap);
        if (fromHashMap.length() == 0) {
            return "{}";
        }
        return fromHashMap;
    }

    public <T> void request(boolean z11, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z12, Callback<T> callback) {
        final boolean z13 = z11;
        final HashMap<String, String> hashMap3 = hashMap;
        final HashMap<String, Object> hashMap4 = hashMap2;
        final String str2 = str;
        final boolean z14 = z12;
        final Callback<T> callback2 = callback;
        this.f27924g.execute(new i() {
            public void a() {
                try {
                    final Object requestSynchronized = NetCommunicator.this.requestSynchronized(z13, (HashMap<String, String>) hashMap3, (HashMap<String, Object>) hashMap4, str2, z14);
                    if (callback2 != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                            public boolean handleMessage(Message message) {
                                callback2.onResultOk(requestSynchronized);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    if (callback2 != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() {
                            public boolean handleMessage(Message message) {
                                callback2.onResultError(th2);
                                return false;
                            }
                        });
                    }
                }
            }
        });
    }

    public <T> T requestSynchronized(String str, String str2, boolean z11) throws Throwable {
        return requestSynchronized((HashMap<String, String>) null, str, str2, z11);
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, String str, String str2, boolean z11) throws Throwable {
        return requestSynchronized(true, hashMap, str, str2, z11);
    }

    private <T> T a(boolean z11, HashMap<String, String> hashMap, String str, String str2, boolean z12, boolean z13, boolean z14) throws Throwable {
        boolean z15 = z11;
        HashMap<String, String> hashMap2 = hashMap;
        String str3 = str;
        String str4 = str2;
        boolean z16 = z14;
        byte[] c11 = v.c();
        byte[] a11 = a(c11, str3, z12);
        boolean z17 = true;
        T[] tArr = new String[1];
        HttpResponseCallback a12 = a(c11, (String[]) tArr, z16);
        if (z13) {
            String encodeToString = Base64.encodeToString(a11, 2);
            HashMap<String, String> a13 = a(z15, hashMap2, str3, encodeToString.getBytes("utf-8").length);
            StringPart stringPart = new StringPart();
            stringPart.append(encodeToString);
            MobLog.getInstance().d(">>>  request(" + str4 + "): " + str3 + "\nheader = " + a13.toString(), new Object[0]);
            try {
                a.a((String) null);
            } catch (Throwable unused) {
                z17 = false;
            }
            if (z17) {
                a.a(false, str2, a13, stringPart, -1, a12, this.f27923f);
            } else {
                this.f27922e.rawPost(str2, a13, (HTTPPart) stringPart, -1, a12, this.f27923f);
            }
        } else {
            HashMap<String, String> a14 = a(z15, hashMap2, str3, -1);
            MobLog.getInstance().d(">>>  request(" + str4 + "): " + str3 + "\nheader = " + a14.toString(), new Object[0]);
            try {
                a.a((String) null);
            } catch (Throwable unused2) {
                z17 = false;
            }
            if (z17) {
                a.a(false, str2, a14, a11, -1, a12, this.f27923f);
            } else {
                this.f27922e.httpPostWithBytes(str2, a11, a14, -1, a12, this.f27923f);
            }
        }
        if (tArr[0] == null) {
            return null;
        }
        MobLog.getInstance().d(">>> response(" + str4 + "): " + tArr[0], new Object[0]);
        if (z16) {
            return a((String) tArr[0]);
        }
        return tArr[0];
    }

    public <T> T requestSynchronized(boolean z11, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z12) throws Throwable {
        return a(z11, hashMap, a(hashMap2), str, z12, true, true);
    }

    public <T> T requestSynchronized(boolean z11, HashMap<String, String> hashMap, String str, String str2, boolean z12) throws Throwable {
        return a(z11, hashMap, str, str2, z12, true, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(byte[] r9, java.lang.String r10, boolean r11) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "utf-8"
            r1 = 2
            r2 = 1
            r3 = 0
            r4 = 0
            if (r11 == 0) goto L_0x0049
            r11 = 3
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003a }
            r5.<init>()     // Catch:{ all -> 0x003a }
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0037 }
            r6.<init>(r5)     // Catch:{ all -> 0x0037 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0035 }
            r7.<init>(r6)     // Catch:{ all -> 0x0035 }
            byte[] r10 = r10.getBytes(r0)     // Catch:{ all -> 0x0032 }
            r7.write(r10)     // Catch:{ all -> 0x0032 }
            r7.flush()     // Catch:{ all -> 0x0032 }
            java.io.Closeable[] r10 = new java.io.Closeable[r11]
            r10[r3] = r7
            r10[r2] = r6
            r10[r1] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            byte[] r10 = r5.toByteArray()
            goto L_0x004d
        L_0x0032:
            r9 = move-exception
            r4 = r7
            goto L_0x003d
        L_0x0035:
            r9 = move-exception
            goto L_0x003d
        L_0x0037:
            r9 = move-exception
            r6 = r4
            goto L_0x003d
        L_0x003a:
            r9 = move-exception
            r5 = r4
            r6 = r5
        L_0x003d:
            java.io.Closeable[] r10 = new java.io.Closeable[r11]
            r10[r3] = r4
            r10[r2] = r6
            r10[r1] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            throw r9
        L_0x0049:
            byte[] r10 = r10.getBytes(r0)
        L_0x004d:
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0089 }
            r11.<init>()     // Catch:{ all -> 0x0089 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ all -> 0x0087 }
            r0.<init>(r11)     // Catch:{ all -> 0x0087 }
            com.mob.tools.utils.MobRSA r4 = r8.f27921d     // Catch:{ all -> 0x0084 }
            java.math.BigInteger r5 = r8.f27919b     // Catch:{ all -> 0x0084 }
            java.math.BigInteger r6 = r8.f27920c     // Catch:{ all -> 0x0084 }
            byte[] r4 = r4.encode(r9, r5, r6)     // Catch:{ all -> 0x0084 }
            int r5 = r4.length     // Catch:{ all -> 0x0084 }
            r0.writeInt(r5)     // Catch:{ all -> 0x0084 }
            r0.write(r4)     // Catch:{ all -> 0x0084 }
            byte[] r9 = com.mob.tools.utils.Data.AES128Encode((byte[]) r9, (byte[]) r10)     // Catch:{ all -> 0x0084 }
            int r10 = r9.length     // Catch:{ all -> 0x0084 }
            r0.writeInt(r10)     // Catch:{ all -> 0x0084 }
            r0.write(r9)     // Catch:{ all -> 0x0084 }
            r0.flush()     // Catch:{ all -> 0x0084 }
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r3] = r0
            r9[r2] = r11
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            byte[] r9 = r11.toByteArray()
            return r9
        L_0x0084:
            r9 = move-exception
            r4 = r0
            goto L_0x008b
        L_0x0087:
            r9 = move-exception
            goto L_0x008b
        L_0x0089:
            r9 = move-exception
            r11 = r4
        L_0x008b:
            java.io.Closeable[] r10 = new java.io.Closeable[r1]
            r10[r3] = r4
            r10[r2] = r11
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetCommunicator.a(byte[], java.lang.String, boolean):byte[]");
    }

    private HashMap<String, String> a(boolean z11, HashMap<String, String> hashMap, String str, int i11) throws Throwable {
        HashMap<String, String> hashMap2;
        if (z11) {
            hashMap2 = i11 > 0 ? a(str, i11) : getCommonDefaultHeaders();
        } else {
            hashMap2 = null;
        }
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        return hashMap2;
    }

    private HashMap<String, String> a(String str, int i11) throws Throwable {
        HashMap<String, String> commonDefaultHeaders = getCommonDefaultHeaders();
        String b11 = C0891r.b("004Yehchdi:d");
        commonDefaultHeaders.put(b11, Data.MD5(str + MobSDK.getAppSecret()));
        commonDefaultHeaders.put(C0891r.b("014.dccj)dhedh)gjedLedIdiGhg"), String.valueOf(i11));
        return commonDefaultHeaders;
    }

    private HttpResponseCallback a(final byte[] bArr, final String[] strArr, final boolean z11) {
        return new HttpResponseCallback() {
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStream inputStream;
                ByteArrayOutputStream byteArrayOutputStream;
                int responseCode = httpConnection.getResponseCode();
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                if (responseCode == 200) {
                    try {
                        inputStream = httpConnection.getInputStream();
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        v.a(byteArrayOutputStream2, inputStream);
                        throw th;
                    }
                } else {
                    inputStream = httpConnection.getErrorStream();
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th3) {
                    th = th3;
                    v.a(byteArrayOutputStream2, inputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (responseCode == 200) {
                        if (z11) {
                            long a11 = NetCommunicator.this.a(httpConnection);
                            if (a11 == -1 || a11 != ((long) byteArray.length)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(C0891r.b("010ghhi5dk*hchBcfeh"), Integer.valueOf(responseCode));
                                hashMap.put(C0891r.b("006%ehKhchMcfeh"), -2);
                                hashMap.put(C0891r.b("005eOcicicjci"), "Illegal content length");
                                throw new NetworkError(HashonHelper.fromHashMap(hashMap));
                            }
                            strArr[0] = NetCommunicator.this.a(bArr, byteArray);
                        } else {
                            strArr[0] = new String(byteArray, "utf-8");
                        }
                        v.a(byteArrayOutputStream, inputStream);
                        return;
                    }
                    HashMap fromJson = HashonHelper.fromJson(new String(byteArray, "utf-8"));
                    fromJson.put(C0891r.b("010ghhi@dkChchJcfeh"), Integer.valueOf(responseCode));
                    throw new NetworkError(HashonHelper.fromHashMap(fromJson));
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    v.a(byteArrayOutputStream2, inputStream);
                    throw th;
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public long a(HttpConnection httpConnection) throws Throwable {
        List<String> a11 = a(httpConnection, C0891r.b("014Mdccj8dhedh'gjed8edZdiFhg"));
        if (a11 == null || a11.size() <= 0) {
            return -1;
        }
        return Long.parseLong(a11.get(0));
    }

    private List<String> a(HttpConnection httpConnection, String str) throws Throwable {
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || headerFields.isEmpty()) {
            return null;
        }
        for (String next : headerFields.keySet()) {
            if (next != null && next.equals(str)) {
                return headerFields.get(next);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String a(byte[] bArr, byte[] bArr2) throws Throwable {
        return new String(Data.AES128Decode(bArr, Base64.decode(bArr2, 2)), "utf-8");
    }

    private Object a(String str) throws Throwable {
        if (str != null) {
            HashMap fromJson = HashonHelper.fromJson(str.trim());
            if (!fromJson.isEmpty()) {
                Object obj = fromJson.get(C0891r.b("003]ci3e]eh"));
                return obj == null ? fromJson.get(C0891r.b("004Mcb8chc")) : obj;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(C0891r.b("0064eh hch8cfeh"), -1);
            hashMap.put(C0891r.b("005e;cicicjci"), "RS is empty");
            throw new NetworkError(HashonHelper.fromHashMap(hashMap));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(C0891r.b("006.ehVhch>cfeh"), -1);
        hashMap2.put(C0891r.b("005e1cicicjci"), "RS is empty");
        throw new NetworkError(HashonHelper.fromHashMap(hashMap2));
    }
}
