package t2;

import java.io.BufferedReader;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public c f16542a;

    /* renamed from: b  reason: collision with root package name */
    public j<T> f16543b;

    public class a implements HostnameVerifier {
        public a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
        }
    }

    public b() {
    }

    public b(c cVar, j<T> jVar) {
        this.f16542a = cVar;
        this.f16543b = jVar;
    }

    public static StringBuilder b(BufferedReader bufferedReader) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb2;
            }
            sb2.append(readLine);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            t2.c r2 = r10.f16542a
            java.lang.String r2 = r2.e()
            boolean r3 = com.alibaba.sdk.android.httpdns.log.HttpDnsLog.f()
            if (r3 == 0) goto L_0x0024
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "request url "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.b(r3)
        L_0x0024:
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x00cb }
            r4.<init>(r2)     // Catch:{ all -> 0x00cb }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x00cb }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00cb }
            t2.c r5 = r10.f16542a     // Catch:{ all -> 0x00c7 }
            int r5 = r5.c()     // Catch:{ all -> 0x00c7 }
            r4.setReadTimeout(r5)     // Catch:{ all -> 0x00c7 }
            t2.c r5 = r10.f16542a     // Catch:{ all -> 0x00c7 }
            int r5 = r5.c()     // Catch:{ all -> 0x00c7 }
            r4.setConnectTimeout(r5)     // Catch:{ all -> 0x00c7 }
            boolean r5 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x0051
            r5 = r4
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ all -> 0x00c7 }
            t2.b$a r6 = new t2.b$a     // Catch:{ all -> 0x00c7 }
            r6.<init>()     // Catch:{ all -> 0x00c7 }
            r5.setHostnameVerifier(r6)     // Catch:{ all -> 0x00c7 }
        L_0x0051:
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x00c7 }
            r6 = 200(0xc8, float:2.8E-43)
            java.lang.String r7 = "UTF-8"
            if (r5 != r6) goto L_0x00a8
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00c7 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00a2 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a2 }
            r8.<init>(r5, r7)     // Catch:{ all -> 0x00a2 }
            r6.<init>(r8)     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = b(r6)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x009d }
            boolean r7 = com.alibaba.sdk.android.httpdns.log.HttpDnsLog.f()     // Catch:{ all -> 0x009d }
            if (r7 == 0) goto L_0x008b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
            r7.<init>()     // Catch:{ all -> 0x009d }
            java.lang.String r8 = "request success "
            r7.append(r8)     // Catch:{ all -> 0x009d }
            r7.append(r3)     // Catch:{ all -> 0x009d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x009d }
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.b(r7)     // Catch:{ all -> 0x009d }
        L_0x008b:
            t2.j<T> r7 = r10.f16543b     // Catch:{ all -> 0x009d }
            java.lang.Object r0 = r7.a(r3)     // Catch:{ all -> 0x009d }
            r4.disconnect()
            if (r5 == 0) goto L_0x0099
            r5.close()     // Catch:{ IOException -> 0x009c }
        L_0x0099:
            r6.close()     // Catch:{ IOException -> 0x009c }
        L_0x009c:
            return r0
        L_0x009d:
            r3 = move-exception
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x00cf
        L_0x00a2:
            r6 = move-exception
            r9 = r6
            r6 = r3
            r3 = r4
            r4 = r9
            goto L_0x00cf
        L_0x00a8:
            java.io.InputStream r5 = r4.getErrorStream()     // Catch:{ all -> 0x00c7 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00a2 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a2 }
            r8.<init>(r5, r7)     // Catch:{ all -> 0x00a2 }
            r6.<init>(r8)     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = b(r6)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x009d }
            int r7 = r4.getResponseCode()     // Catch:{ all -> 0x009d }
            com.alibaba.sdk.android.httpdns.i.b r3 = com.alibaba.sdk.android.httpdns.i.b.a(r7, r3)     // Catch:{ all -> 0x009d }
            throw r3     // Catch:{ all -> 0x009d }
        L_0x00c7:
            r5 = move-exception
            r6 = r3
            r3 = r4
            goto L_0x00cd
        L_0x00cb:
            r5 = move-exception
            r6 = r3
        L_0x00cd:
            r4 = r5
            r5 = r6
        L_0x00cf:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f1 }
            long r7 = r7 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r0.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = "request "
            r0.append(r1)     // Catch:{ all -> 0x00f1 }
            r0.append(r2)     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = " fail, cost "
            r0.append(r1)     // Catch:{ all -> 0x00f1 }
            r0.append(r7)     // Catch:{ all -> 0x00f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f1 }
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.j(r0, r4)     // Catch:{ all -> 0x00f1 }
            throw r4     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            if (r3 == 0) goto L_0x00f7
            r3.disconnect()
        L_0x00f7:
            if (r5 == 0) goto L_0x00fc
            r5.close()     // Catch:{ IOException -> 0x0101 }
        L_0x00fc:
            if (r6 == 0) goto L_0x0101
            r6.close()     // Catch:{ IOException -> 0x0101 }
        L_0x0101:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.b.a():java.lang.Object");
    }

    public c c() {
        return this.f16542a;
    }
}
