package com.tencent.imsdk.common;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpClient {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HTTP_ACTION_REQUEST = 0;
    public static final int HTTP_ACTION_RESPONSE = 1;
    private static final long KEEP_ALIVE = 5;
    private static final int MAX_POOL_SIZE;
    private static final int PROXY_TYPE_HTTP = 1;
    private static final int PROXY_TYPE_SOCKS5 = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "HttpClient";
    /* access modifiers changed from: private */
    public static boolean mNeedRollbackHttps2Http = false;
    /* access modifiers changed from: private */
    public static String mRollbackHttps2Http = "";
    private static final Executor mThreadPoolExecutor;

    public static class BasicAuthenticator extends Authenticator {
        private String password = "";
        private String userName = "";

        public BasicAuthenticator(String str, String str2) {
            this.userName = str;
            this.password = str2;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.userName, this.password.toCharArray());
        }
    }

    public interface HttpRequestListener {
        void onCompleted(int i11, Map<String, String> map, byte[] bArr);

        void onProgress(int i11, int i12, int i13);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i11 = availableProcessors + 1;
        CORE_POOL_SIZE = i11;
        int i12 = (availableProcessors * 2) + 1;
        MAX_POOL_SIZE = i12;
        mThreadPoolExecutor = new ThreadPoolExecutor(i11, i12, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    private static void httpRequest(String str, String str2, Boolean bool, Map<String, String> map, byte[] bArr, String str3, String str4, HttpRequestListener httpRequestListener, int i11, String str5, int i12, String str6, String str7, int i13, int i14, String str8) {
        final String str9 = str;
        final String str10 = str2;
        final Boolean bool2 = bool;
        final Map<String, String> map2 = map;
        final byte[] bArr2 = bArr;
        final String str11 = str3;
        final String str12 = str4;
        final HttpRequestListener httpRequestListener2 = httpRequestListener;
        final int i15 = i11;
        final String str13 = str5;
        final int i16 = i12;
        final String str14 = str6;
        final String str15 = str7;
        final int i17 = i13;
        final int i18 = i14;
        final String str16 = str8;
        AnonymousClass1 r17 = r0;
        AnonymousClass1 r02 = new Runnable() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: java.util.HashMap} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v62, resolved type: byte[]} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:100:0x01cd A[Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }] */
            /* JADX WARNING: Removed duplicated region for block: B:101:0x01cf A[Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x01d2 A[Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }] */
            /* JADX WARNING: Removed duplicated region for block: B:124:0x0223  */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x0226 A[SYNTHETIC, Splitter:B:126:0x0226] */
            /* JADX WARNING: Removed duplicated region for block: B:132:0x0235  */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x0292 A[SYNTHETIC, Splitter:B:162:0x0292] */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x029c  */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x02a3  */
            /* JADX WARNING: Removed duplicated region for block: B:179:0x02ca A[SYNTHETIC, Splitter:B:179:0x02ca] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x02d4  */
            /* JADX WARNING: Removed duplicated region for block: B:187:0x02db  */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x02e2 A[SYNTHETIC, Splitter:B:190:0x02e2] */
            /* JADX WARNING: Removed duplicated region for block: B:195:0x02ec  */
            /* JADX WARNING: Removed duplicated region for block: B:198:0x02f3  */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x0182 A[EDGE_INSN: B:202:0x0182->B:79:0x0182 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:213:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x0163 A[Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x016b A[Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x0186 A[Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x01a4 A[Catch:{ UnknownHostException -> 0x0253, Exception -> 0x024e, all -> 0x0248 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x01ba A[Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x01c2 A[Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:159:0x026c=Splitter:B:159:0x026c, B:175:0x02ac=Splitter:B:175:0x02ac} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r14 = this;
                    java.lang.String r0 = "http request failed."
                    java.lang.String r1 = r1
                    java.lang.String r2 = "https"
                    boolean r3 = r1.startsWith(r2)
                    if (r3 == 0) goto L_0x0034
                    java.lang.String r3 = com.tencent.imsdk.common.HttpClient.mRollbackHttps2Http
                    java.lang.String r4 = r2
                    boolean r3 = r3.equals(r4)
                    if (r3 != 0) goto L_0x0026
                    java.lang.String r3 = r2
                    java.lang.String unused = com.tencent.imsdk.common.HttpClient.mRollbackHttps2Http = r3
                    java.lang.String r3 = r2
                    boolean r3 = com.tencent.imsdk.common.HttpClient.needRollbackHttps2Http(r3)
                    boolean unused = com.tencent.imsdk.common.HttpClient.mNeedRollbackHttps2Http = r3
                L_0x0026:
                    boolean r3 = com.tencent.imsdk.common.HttpClient.mNeedRollbackHttps2Http
                    if (r3 == 0) goto L_0x0034
                    java.lang.String r1 = r1
                    java.lang.String r3 = "http"
                    java.lang.String r1 = r1.replaceFirst(r2, r3)
                L_0x0034:
                    r2 = 200(0xc8, float:2.8E-43)
                    r3 = 0
                    int r4 = r3     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r5 = 1
                    if (r5 != r4) goto L_0x0080
                    java.lang.String r4 = r4     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    if (r4 != 0) goto L_0x0080
                    int r4 = r5     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    if (r4 == 0) goto L_0x0080
                    java.net.Proxy r4 = new java.net.Proxy     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.Proxy$Type r6 = java.net.Proxy.Type.HTTP     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.InetSocketAddress r7 = new java.net.InetSocketAddress     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.lang.String r8 = r4     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    int r9 = r5     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r7.<init>(r8, r9)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r4.<init>(r6, r7)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.URL r6 = new java.net.URL     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r6.<init>(r1)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.URLConnection r1 = r6.openConnection(r4)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.lang.String r4 = r6     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r4 != 0) goto L_0x00d4
                    java.lang.String r4 = r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r4 != 0) goto L_0x00d4
                    com.tencent.imsdk.common.HttpClient$BasicAuthenticator r4 = new com.tencent.imsdk.common.HttpClient$BasicAuthenticator     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r6 = r6     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r7 = r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r4.<init>(r6, r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.net.Authenticator.setDefault(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x00d4
                L_0x0080:
                    r4 = 2
                    int r6 = r3     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    if (r4 != r6) goto L_0x00c9
                    java.lang.String r4 = r4     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    if (r4 != 0) goto L_0x00c9
                    int r4 = r5     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    if (r4 == 0) goto L_0x00c9
                    java.net.Proxy r4 = new java.net.Proxy     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.Proxy$Type r6 = java.net.Proxy.Type.SOCKS     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.InetSocketAddress r7 = new java.net.InetSocketAddress     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.lang.String r8 = r4     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    int r9 = r5     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r7.<init>(r8, r9)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r4.<init>(r6, r7)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.URL r6 = new java.net.URL     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r6.<init>(r1)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.URLConnection r1 = r6.openConnection(r4)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.lang.String r4 = r6     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r4 != 0) goto L_0x00d4
                    java.lang.String r4 = r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    boolean r4 = r4.isEmpty()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r4 != 0) goto L_0x00d4
                    com.tencent.imsdk.common.HttpClient$BasicAuthenticator r4 = new com.tencent.imsdk.common.HttpClient$BasicAuthenticator     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r6 = r6     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r7 = r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r4.<init>(r6, r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.net.Authenticator.setDefault(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x00d4
                L_0x00c9:
                    java.net.URL r4 = new java.net.URL     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    r4.<init>(r1)     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.URLConnection r1 = r4.openConnection()     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ UnknownHostException -> 0x02a7, Exception -> 0x0267, all -> 0x0261 }
                L_0x00d4:
                    java.lang.String r4 = r8     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setRequestMethod(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    int r4 = r9     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setConnectTimeout(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    int r4 = r10     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setReadTimeout(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r4 = 0
                    r1.setUseCaches(r4)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setDoInput(r5)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.util.Map r6 = r11     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r6 == 0) goto L_0x0112
                    java.util.Set r6 = r6.entrySet()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.util.Iterator r6 = r6.iterator()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                L_0x00f6:
                    boolean r7 = r6.hasNext()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r7 == 0) goto L_0x0112
                    java.lang.Object r7 = r6.next()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.Object r8 = r7.getKey()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.Object r7 = r7.getValue()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r7 = (java.lang.String) r7     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setRequestProperty(r8, r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x00f6
                L_0x0112:
                    java.lang.Boolean r6 = r12     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    boolean r6 = r6.booleanValue()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r6 == 0) goto L_0x0131
                    boolean r6 = r1 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r6 == 0) goto L_0x0131
                    r6 = r1
                    javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    com.tencent.imsdk.common.HttpClient$1$1 r7 = new com.tencent.imsdk.common.HttpClient$1$1     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r7.<init>(r6)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r6.setSSLSocketFactory(r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    com.tencent.imsdk.common.HttpClient$1$2 r7 = new com.tencent.imsdk.common.HttpClient$1$2     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r7.<init>(r6)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r6.setHostnameVerifier(r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                L_0x0131:
                    byte[] r6 = r13     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r6 == 0) goto L_0x013a
                    int r6 = r6.length     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r6 <= 0) goto L_0x013a
                    r6 = r5
                    goto L_0x013b
                L_0x013a:
                    r6 = r4
                L_0x013b:
                    java.lang.String r7 = r14     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r7 == 0) goto L_0x0147
                    int r7 = r7.length()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r7 == 0) goto L_0x0147
                    r7 = r5
                    goto L_0x0148
                L_0x0147:
                    r7 = r4
                L_0x0148:
                    if (r6 != 0) goto L_0x014f
                    if (r7 == 0) goto L_0x014d
                    goto L_0x014f
                L_0x014d:
                    r6 = r4
                    goto L_0x0150
                L_0x014f:
                    r6 = r5
                L_0x0150:
                    java.lang.String r8 = r8     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r9 = "GET"
                    boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r9 = 4096(0x1000, float:5.74E-42)
                    if (r8 != 0) goto L_0x0196
                    if (r6 == 0) goto L_0x0196
                    r1.setDoOutput(r5)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r7 == 0) goto L_0x016b
                    java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.lang.String r7 = r14     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r6.<init>(r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x0172
                L_0x016b:
                    java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    byte[] r7 = r13     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r6.<init>(r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                L_0x0172:
                    int r7 = r6.available()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r1.setFixedLengthStreamingMode(r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    byte[] r8 = new byte[r9]     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r10 = r4
                L_0x017c:
                    int r11 = r6.read(r8)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r11 >= 0) goto L_0x0186
                    r6.close()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x0196
                L_0x0186:
                    int r10 = r10 + r11
                    java.io.OutputStream r12 = r1.getOutputStream()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    r12.write(r8, r4, r11)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r11 = r15     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    if (r11 == 0) goto L_0x017c
                    r11.onProgress(r4, r10, r7)     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    goto L_0x017c
                L_0x0196:
                    int r6 = r1.getResponseCode()     // Catch:{ UnknownHostException -> 0x025e, Exception -> 0x025b, all -> 0x0258 }
                    java.util.Map r7 = r1.getHeaderFields()     // Catch:{ UnknownHostException -> 0x0253, Exception -> 0x024e, all -> 0x0248 }
                    int r7 = r7.size()     // Catch:{ UnknownHostException -> 0x0253, Exception -> 0x024e, all -> 0x0248 }
                    if (r7 <= 0) goto L_0x01ba
                    java.util.HashMap r8 = new java.util.HashMap     // Catch:{ UnknownHostException -> 0x0253, Exception -> 0x024e, all -> 0x0248 }
                    r8.<init>()     // Catch:{ UnknownHostException -> 0x0253, Exception -> 0x024e, all -> 0x0248 }
                    r10 = r4
                L_0x01aa:
                    if (r10 >= r7) goto L_0x01bb
                    java.lang.String r11 = r1.getHeaderFieldKey(r10)     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    java.lang.String r12 = r1.getHeaderField(r10)     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    r8.put(r11, r12)     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    int r10 = r10 + 1
                    goto L_0x01aa
                L_0x01ba:
                    r8 = r3
                L_0x01bb:
                    int r7 = r1.getContentLength()     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    r10 = -1
                    if (r7 != r10) goto L_0x01c3
                    r7 = r4
                L_0x01c3:
                    java.lang.String r10 = r16     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    if (r10 == 0) goto L_0x01cf
                    int r10 = r10.length()     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    if (r10 == 0) goto L_0x01cf
                    r10 = r5
                    goto L_0x01d0
                L_0x01cf:
                    r10 = r4
                L_0x01d0:
                    if (r6 != r2) goto L_0x0223
                    java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    java.io.InputStream r11 = r1.getInputStream()     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    r2.<init>(r11)     // Catch:{ UnknownHostException -> 0x0242, Exception -> 0x023d, all -> 0x023a }
                    if (r10 == 0) goto L_0x01e5
                    java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    java.lang.String r12 = r16     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    goto L_0x01ea
                L_0x01e5:
                    java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    r11.<init>()     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                L_0x01ea:
                    byte[] r9 = new byte[r9]     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    r12 = r4
                L_0x01ed:
                    int r13 = r2.read(r9)     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    if (r13 >= 0) goto L_0x0205
                    if (r10 == 0) goto L_0x01f8
                    byte[] r3 = new byte[r4]     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    goto L_0x01ff
                L_0x01f8:
                    r4 = r11
                    java.io.ByteArrayOutputStream r4 = (java.io.ByteArrayOutputStream) r4     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    byte[] r3 = r4.toByteArray()     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                L_0x01ff:
                    r11.close()     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    r0 = r3
                    r3 = r2
                    goto L_0x0224
                L_0x0205:
                    int r12 = r12 + r13
                    r11.write(r9, r4, r13)     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r13 = r15     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    if (r13 == 0) goto L_0x01ed
                    r13.onProgress(r5, r12, r7)     // Catch:{ UnknownHostException -> 0x021c, Exception -> 0x0215, all -> 0x0211 }
                    goto L_0x01ed
                L_0x0211:
                    r0 = move-exception
                    r4 = r3
                    r3 = r2
                    goto L_0x024b
                L_0x0215:
                    r4 = move-exception
                    r5 = r4
                    r4 = r3
                    r3 = r2
                    r2 = r6
                    goto L_0x026c
                L_0x021c:
                    r4 = move-exception
                    r5 = r4
                    r4 = r3
                    r3 = r2
                    r2 = r6
                    goto L_0x02ac
                L_0x0223:
                    r0 = r3
                L_0x0224:
                    if (r3 == 0) goto L_0x022e
                    r3.close()     // Catch:{ IOException -> 0x022a }
                    goto L_0x022e
                L_0x022a:
                    r2 = move-exception
                    r2.printStackTrace()
                L_0x022e:
                    r1.disconnect()
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r1 = r15
                    if (r1 == 0) goto L_0x02de
                    r1.onCompleted(r6, r8, r0)
                    goto L_0x02de
                L_0x023a:
                    r0 = move-exception
                    r4 = r3
                    goto L_0x024b
                L_0x023d:
                    r4 = move-exception
                    r5 = r4
                    r2 = r6
                    r4 = r3
                    goto L_0x026c
                L_0x0242:
                    r4 = move-exception
                    r5 = r4
                    r2 = r6
                    r4 = r3
                    goto L_0x02ac
                L_0x0248:
                    r0 = move-exception
                    r4 = r3
                    r8 = r4
                L_0x024b:
                    r2 = r6
                    goto L_0x02e0
                L_0x024e:
                    r4 = move-exception
                    r8 = r3
                    r5 = r4
                    r2 = r6
                    goto L_0x026b
                L_0x0253:
                    r4 = move-exception
                    r8 = r3
                    r5 = r4
                    r2 = r6
                    goto L_0x02ab
                L_0x0258:
                    r0 = move-exception
                    r4 = r3
                    goto L_0x0264
                L_0x025b:
                    r4 = move-exception
                    r8 = r3
                    goto L_0x026a
                L_0x025e:
                    r4 = move-exception
                    r8 = r3
                    goto L_0x02aa
                L_0x0261:
                    r0 = move-exception
                    r1 = r3
                    r4 = r1
                L_0x0264:
                    r8 = r4
                    goto L_0x02e0
                L_0x0267:
                    r4 = move-exception
                    r1 = r3
                    r8 = r1
                L_0x026a:
                    r5 = r4
                L_0x026b:
                    r4 = r8
                L_0x026c:
                    java.lang.String r6 = com.tencent.imsdk.common.HttpClient.TAG     // Catch:{ all -> 0x02df }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
                    r7.<init>()     // Catch:{ all -> 0x02df }
                    r7.append(r0)     // Catch:{ all -> 0x02df }
                    java.lang.String r0 = r5.getLocalizedMessage()     // Catch:{ all -> 0x02df }
                    r7.append(r0)     // Catch:{ all -> 0x02df }
                    java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x02df }
                    com.tencent.imsdk.common.IMLog.e(r6, r0)     // Catch:{ all -> 0x02df }
                    r2 = 6010(0x177a, float:8.422E-42)
                    java.lang.String r0 = android.util.Log.getStackTraceString(r5)     // Catch:{ all -> 0x02df }
                    byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x02df }
                    if (r3 == 0) goto L_0x029a
                    r3.close()     // Catch:{ IOException -> 0x0296 }
                    goto L_0x029a
                L_0x0296:
                    r3 = move-exception
                    r3.printStackTrace()
                L_0x029a:
                    if (r1 == 0) goto L_0x029f
                    r1.disconnect()
                L_0x029f:
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r1 = r15
                    if (r1 == 0) goto L_0x02de
                    r1.onCompleted(r2, r8, r0)
                    goto L_0x02de
                L_0x02a7:
                    r4 = move-exception
                    r1 = r3
                    r8 = r1
                L_0x02aa:
                    r5 = r4
                L_0x02ab:
                    r4 = r8
                L_0x02ac:
                    java.lang.String r6 = com.tencent.imsdk.common.HttpClient.TAG     // Catch:{ all -> 0x02df }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02df }
                    r7.<init>()     // Catch:{ all -> 0x02df }
                    r7.append(r0)     // Catch:{ all -> 0x02df }
                    java.lang.String r0 = r5.getLocalizedMessage()     // Catch:{ all -> 0x02df }
                    r7.append(r0)     // Catch:{ all -> 0x02df }
                    java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x02df }
                    com.tencent.imsdk.common.IMLog.e(r6, r0)     // Catch:{ all -> 0x02df }
                    r0 = 404(0x194, float:5.66E-43)
                    if (r3 == 0) goto L_0x02d2
                    r3.close()     // Catch:{ IOException -> 0x02ce }
                    goto L_0x02d2
                L_0x02ce:
                    r2 = move-exception
                    r2.printStackTrace()
                L_0x02d2:
                    if (r1 == 0) goto L_0x02d7
                    r1.disconnect()
                L_0x02d7:
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r1 = r15
                    if (r1 == 0) goto L_0x02de
                    r1.onCompleted(r0, r8, r4)
                L_0x02de:
                    return
                L_0x02df:
                    r0 = move-exception
                L_0x02e0:
                    if (r3 == 0) goto L_0x02ea
                    r3.close()     // Catch:{ IOException -> 0x02e6 }
                    goto L_0x02ea
                L_0x02e6:
                    r3 = move-exception
                    r3.printStackTrace()
                L_0x02ea:
                    if (r1 == 0) goto L_0x02ef
                    r1.disconnect()
                L_0x02ef:
                    com.tencent.imsdk.common.HttpClient$HttpRequestListener r1 = r15
                    if (r1 == 0) goto L_0x02f6
                    r1.onCompleted(r2, r8, r4)
                L_0x02f6:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.common.HttpClient.AnonymousClass1.run():void");
            }
        };
        mThreadPoolExecutor.execute(r17);
    }

    /* access modifiers changed from: private */
    public static native void nativeProgressCallback(int i11, int i12, int i13, long j11);

    /* access modifiers changed from: private */
    public static native void nativeResponseCallback(int i11, String[] strArr, String[] strArr2, byte[] bArr, long j11);

    /* access modifiers changed from: private */
    public static boolean needRollbackHttps2Http(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String str2 = "";
            if (SystemUtil.isBrandOppo()) {
                str2 = MTPushConstants.Manufacturer.OPPO;
            } else if (SystemUtil.isBrandVivo()) {
                str2 = "vivo";
            } else if (SystemUtil.isBrandHuawei()) {
                str2 = MTPushConstants.Manufacturer.HUAWEI;
            } else if (SystemUtil.isBrandXiaoMi()) {
                str2 = "xiaomi";
            } else if (SystemUtil.isBrandMeizu()) {
                str2 = MTPushConstants.Manufacturer.MEIZU;
            }
            int i11 = 0;
            while (i11 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String string = jSONObject.getString("brand");
                int i12 = jSONObject.getInt("below_version");
                if (!str2.equals(string)) {
                    i11++;
                } else if (SystemUtil.getSDKVersion() <= i12) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private static void httpRequest(String str, String str2, boolean z11, String[] strArr, String[] strArr2, byte[] bArr, String str3, String str4, long j11, long j12, int i11, String str5, int i12, String str6, String str7, int i13, int i14, String str8) {
        HashMap hashMap;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        if (strArr3 == null || strArr4 == null || strArr3.length != strArr4.length) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i15 = 0; i15 < strArr3.length; i15++) {
                hashMap.put(strArr3[i15], strArr4[i15]);
            }
        }
        HashMap hashMap2 = hashMap;
        final long j13 = j11;
        final long j14 = j12;
        httpRequest(str, str2, Boolean.valueOf(z11), hashMap2, bArr, str3, str4, new HttpRequestListener() {
            public void onCompleted(int i11, Map<String, String> map, byte[] bArr) {
                String[] strArr;
                String[] strArr2;
                if (j14 != 0) {
                    if (map != null) {
                        String[] strArr3 = new String[map.size()];
                        String[] strArr4 = new String[map.size()];
                        int i12 = 0;
                        for (Map.Entry next : map.entrySet()) {
                            strArr3[i12] = (String) next.getKey();
                            strArr4[i12] = (String) next.getValue();
                            i12++;
                        }
                        strArr2 = strArr3;
                        strArr = strArr4;
                    } else {
                        strArr2 = null;
                        strArr = null;
                    }
                    HttpClient.nativeResponseCallback(i11, strArr2, strArr, bArr, j14);
                }
            }

            public void onProgress(int i11, int i12, int i13) {
                long j11 = j13;
                if (j11 != 0) {
                    HttpClient.nativeProgressCallback(i11, i12, i13, j11);
                }
            }
        }, i11, str5, i12, str6, str7, i13, i14, str8);
    }
}
