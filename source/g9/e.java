package g9;

import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.tencent.qcloud.tuicore.TUIConstants;
import f9.a;
import h9.b;
import h9.c;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONObject;

public class e extends WebSocketListener {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f70873g = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<SoftReference<c>>> f70874a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Set<SoftReference<c>>> f70875b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f70876c;

    /* renamed from: d  reason: collision with root package name */
    public a f70877d;

    /* renamed from: e  reason: collision with root package name */
    public String f70878e;

    /* renamed from: f  reason: collision with root package name */
    public String f70879f;

    public e(String str, b bVar) {
        this.f70878e = str;
        this.f70876c = bVar;
        this.f70877d = new a(this.f70878e, (a.C0777a) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(SoftReference softReference, ISocketSend iSocketSend, Object obj) {
        c cVar = (c) softReference.get();
        if (cVar != null) {
            cVar.a(iSocketSend, this.f70878e, this.f70879f, obj);
        }
    }

    public static /* synthetic */ void h(SoftReference softReference, Throwable th2) {
        if (softReference.get() != null) {
            ((c) softReference.get()).onFailed(th2);
        }
    }

    public final void c(ISocketSend iSocketSend, String str, String str2, Map<String, Set<SoftReference<c>>> map, a aVar) {
        RetrofitLogger.a(this.f70878e + "-->handleCallback--> key = " + str2 + " text = " + str);
        Set<SoftReference> set = map.get(str2);
        if (set != null) {
            for (SoftReference softReference : set) {
                if (softReference.get() != null) {
                    Object b11 = ((c) softReference.get()).b(str);
                    if (!(softReference.get() == null || aVar == null)) {
                        aVar.post(new c(this, softReference, iSocketSend, b11));
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.lang.String r3, h9.c r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Object r0 = f70873g
            monitor-enter(r0)
            if (r6 == 0) goto L_0x000f
            java.util.Map<java.lang.String, java.util.Set<java.lang.ref.SoftReference<h9.c>>> r6 = r2.f70874a     // Catch:{ all -> 0x006c }
            goto L_0x0011
        L_0x000f:
            java.util.Map<java.lang.String, java.util.Set<java.lang.ref.SoftReference<h9.c>>> r6 = r2.f70875b     // Catch:{ all -> 0x006c }
        L_0x0011:
            boolean r1 = r6.containsKey(r3)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0023
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            java.util.Set r1 = java.util.Collections.newSetFromMap(r1)     // Catch:{ all -> 0x006c }
            r6.put(r3, r1)     // Catch:{ all -> 0x006c }
        L_0x0023:
            java.lang.Object r3 = r6.get(r3)     // Catch:{ all -> 0x006c }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x006c }
            java.util.Iterator r6 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x002d:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006c }
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x002d
            r6.remove()     // Catch:{ all -> 0x006c }
            goto L_0x002d
        L_0x0043:
            java.util.Iterator r6 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x0047:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006c }
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006c }
            if (r1 != r4) goto L_0x0047
            if (r5 == 0) goto L_0x005d
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x005d:
            r6.remove()     // Catch:{ all -> 0x006c }
        L_0x0060:
            if (r5 == 0) goto L_0x006a
            java.lang.ref.SoftReference r5 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x006c }
            r5.<init>(r4)     // Catch:{ all -> 0x006c }
            r3.add(r5)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.e.d(java.lang.String, h9.c, boolean, boolean):void");
    }

    public final void e(String str) {
        String str2;
        RetrofitLogger.a(this.f70878e + "-->handleMessage-->" + str);
        if (str != null) {
            synchronized (f70873g) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    ISocketSend iSocketSend = null;
                    if (jSONObject.has("rep")) {
                        String string = jSONObject.getString("rep");
                        b bVar = this.f70876c;
                        if (bVar != null) {
                            iSocketSend = bVar.f(string);
                        }
                        ISocketSend iSocketSend2 = iSocketSend;
                        b bVar2 = this.f70876c;
                        if (bVar2 != null) {
                            bVar2.b(string);
                        }
                        RetrofitLogger.g(this.f70878e + " Socket-->handleMessage req:" + string);
                        c(iSocketSend2, str, string, this.f70875b, this.f70877d);
                        Set set = this.f70875b.get(string);
                        if (set != null) {
                            set.clear();
                            this.f70875b.remove(string);
                        }
                    } else if (jSONObject.has("ch")) {
                        String string2 = jSONObject.getString("ch");
                        b bVar3 = this.f70876c;
                        if (bVar3 != null) {
                            iSocketSend = bVar3.d(string2);
                        }
                        c(iSocketSend, str, string2, this.f70874a, this.f70877d);
                        b bVar4 = this.f70876c;
                        if (bVar4 != null) {
                            bVar4.c(string2);
                        }
                    } else if (jSONObject.has("op")) {
                        String string3 = jSONObject.getString("op");
                        if ("auth".equalsIgnoreCase(string3)) {
                            str2 = "contract.authentication";
                        } else if (TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_ENABLE_NOTIFICATION.equalsIgnoreCase(string3)) {
                            str2 = jSONObject.optString("topic");
                        } else {
                            str2 = "sub".equalsIgnoreCase(string3) ? jSONObject.optString("topic") : "";
                        }
                        b bVar5 = this.f70876c;
                        if (bVar5 != null) {
                            iSocketSend = bVar5.d(str2);
                        }
                        c(iSocketSend, str, str2, this.f70874a, this.f70877d);
                        b bVar6 = this.f70876c;
                        if (bVar6 != null) {
                            bVar6.a(str2);
                            this.f70876c.c(str2);
                        }
                    } else if (jSONObject.has("subbed")) {
                        String string4 = jSONObject.getString("subbed");
                        RetrofitLogger.g(this.f70878e + " Socket-->handleMessage subbed:" + string4);
                        b bVar7 = this.f70876c;
                        if (bVar7 != null) {
                            bVar7.a(string4);
                            this.f70876c.g(string4);
                        }
                    }
                    b bVar8 = this.f70876c;
                    if (bVar8 != null) {
                        bVar8.e();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    RetrofitLogger.g(this.f70878e + " Socket-->handleMessage error:" + th2);
                }
            }
        }
    }

    public boolean f(String str) {
        boolean z11;
        synchronized (f70873g) {
            Set set = this.f70874a.get(str);
            z11 = set != null && !set.isEmpty();
        }
        return z11;
    }

    public void i(String str) {
        this.f70879f = str;
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        Map<String, Set<SoftReference<c>>> map = this.f70874a;
        if (map != null) {
            for (Set<SoftReference<c>> it2 : map.values()) {
                for (SoftReference softReference : it2) {
                    if (softReference.get() != null) {
                        f9.b.a().b(new d(softReference, th2));
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0092 A[SYNTHETIC, Splitter:B:49:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c A[SYNTHETIC, Splitter:B:54:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a6 A[SYNTHETIC, Splitter:B:59:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b0 A[SYNTHETIC, Splitter:B:64:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00db A[SYNTHETIC, Splitter:B:74:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e5 A[SYNTHETIC, Splitter:B:79:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ef A[SYNTHETIC, Splitter:B:84:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f9 A[SYNTHETIC, Splitter:B:89:0x00f9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x0079=Splitter:B:46:0x0079, B:71:0x00bf=Splitter:B:71:0x00bf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(okhttp3.WebSocket r8, okio.ByteString r9) {
        /*
            r7 = this;
            java.lang.String r0 = "-->"
            super.onMessage((okhttp3.WebSocket) r8, (okio.ByteString) r9)
            r8 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ OutOfMemoryError -> 0x00b9, all -> 0x0073 }
            byte[] r9 = r9.toByteArray()     // Catch:{ OutOfMemoryError -> 0x00b9, all -> 0x0073 }
            r1.<init>(r9)     // Catch:{ OutOfMemoryError -> 0x00b9, all -> 0x0073 }
            java.util.zip.GZIPInputStream r9 = new java.util.zip.GZIPInputStream     // Catch:{ OutOfMemoryError -> 0x0070, all -> 0x006d }
            r9.<init>(r1)     // Catch:{ OutOfMemoryError -> 0x0070, all -> 0x006d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ OutOfMemoryError -> 0x0068, all -> 0x0063 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r9, r3)     // Catch:{ OutOfMemoryError -> 0x0068, all -> 0x0063 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ OutOfMemoryError -> 0x005d, all -> 0x0058 }
            r3.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x005d, all -> 0x0058 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
            r8.<init>()     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
        L_0x0025:
            java.lang.String r4 = r3.readLine()     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
            if (r4 == 0) goto L_0x002f
            r8.append(r4)     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
            goto L_0x0025
        L_0x002f:
            java.lang.String r8 = r8.toString()     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
            r7.e(r8)     // Catch:{ OutOfMemoryError -> 0x0055, all -> 0x0053 }
            r3.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r8 = move-exception
            r8.printStackTrace()
        L_0x003e:
            r2.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0046:
            r9.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004e:
            r1.close()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00fc
        L_0x0053:
            r8 = move-exception
            goto L_0x0079
        L_0x0055:
            r8 = move-exception
            goto L_0x00bf
        L_0x0058:
            r3 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x0079
        L_0x005d:
            r3 = move-exception
            r6 = r3
            r3 = r8
            r8 = r6
            goto L_0x00bf
        L_0x0063:
            r2 = move-exception
            r3 = r8
            r8 = r2
            r2 = r3
            goto L_0x0079
        L_0x0068:
            r2 = move-exception
            r3 = r8
            r8 = r2
            r2 = r3
            goto L_0x00bf
        L_0x006d:
            r9 = move-exception
            r2 = r8
            goto L_0x0076
        L_0x0070:
            r9 = move-exception
            r2 = r8
            goto L_0x00bc
        L_0x0073:
            r9 = move-exception
            r1 = r8
            r2 = r1
        L_0x0076:
            r3 = r2
            r8 = r9
            r9 = r3
        L_0x0079:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r4.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = r7.f70878e     // Catch:{ all -> 0x00fd }
            r4.append(r5)     // Catch:{ all -> 0x00fd }
            r4.append(r0)     // Catch:{ all -> 0x00fd }
            r4.append(r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00fd }
            com.hbg.lib.network.retrofit.util.RetrofitLogger.b(r8)     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x009a
            r3.close()     // Catch:{ Exception -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r8 = move-exception
            r8.printStackTrace()
        L_0x009a:
            if (r2 == 0) goto L_0x00a4
            r2.close()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a4:
            if (r9 == 0) goto L_0x00ae
            r9.close()     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ae:
            if (r1 == 0) goto L_0x00fc
            r1.close()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00fc
        L_0x00b4:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00fc
        L_0x00b9:
            r9 = move-exception
            r1 = r8
            r2 = r1
        L_0x00bc:
            r3 = r2
            r8 = r9
            r9 = r3
        L_0x00bf:
            java.lang.System.gc()     // Catch:{ all -> 0x00fd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r4.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = r7.f70878e     // Catch:{ all -> 0x00fd }
            r4.append(r5)     // Catch:{ all -> 0x00fd }
            r4.append(r0)     // Catch:{ all -> 0x00fd }
            r4.append(r8)     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00fd }
            com.hbg.lib.network.retrofit.util.RetrofitLogger.b(r8)     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x00e3
            r3.close()     // Catch:{ Exception -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00e3:
            if (r2 == 0) goto L_0x00ed
            r2.close()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ed:
            if (r9 == 0) goto L_0x00f7
            r9.close()     // Catch:{ Exception -> 0x00f3 }
            goto L_0x00f7
        L_0x00f3:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00f7:
            if (r1 == 0) goto L_0x00fc
            r1.close()     // Catch:{ Exception -> 0x00b4 }
        L_0x00fc:
            return
        L_0x00fd:
            r8 = move-exception
            if (r3 == 0) goto L_0x0108
            r3.close()     // Catch:{ Exception -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0108:
            if (r2 == 0) goto L_0x0112
            r2.close()     // Catch:{ Exception -> 0x010e }
            goto L_0x0112
        L_0x010e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0112:
            if (r9 == 0) goto L_0x011c
            r9.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r9 = move-exception
            r9.printStackTrace()
        L_0x011c:
            if (r1 == 0) goto L_0x0126
            r1.close()     // Catch:{ Exception -> 0x0122 }
            goto L_0x0126
        L_0x0122:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0126:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.e.onMessage(okhttp3.WebSocket, okio.ByteString):void");
    }

    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        e(str);
    }
}
