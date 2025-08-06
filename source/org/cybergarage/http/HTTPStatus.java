package org.cybergarage.http;

public class HTTPStatus {

    /* renamed from: a  reason: collision with root package name */
    public String f59822a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f59823b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f59824c = "";

    public HTTPStatus() {
        g("");
        f(0);
        e("");
    }

    public static final String a(int i11) {
        return i11 != 100 ? i11 != 200 ? i11 != 206 ? i11 != 400 ? i11 != 404 ? i11 != 412 ? i11 != 416 ? i11 != 500 ? "" : "Internal Server Error" : "Invalid Range" : "Precondition Failed" : "Not Found" : "Bad Request" : "Partial Content" : "OK" : "Continue";
    }

    public static final boolean c(int i11) {
        return 200 <= i11 && i11 < 300;
    }

    public int b() {
        return this.f59823b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:11|12|13|14|15|16|(4:20|(2:22|27)(1:28)|23|17)|26|19|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[Catch:{ Exception -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = " "
            if (r4 != 0) goto L_0x0016
            java.lang.String r4 = "1.1"
            r3.g(r4)
            r4 = 500(0x1f4, float:7.0E-43)
            r3.f(r4)
            java.lang.String r4 = a(r4)
            r3.e(r4)
            return
        L_0x0016:
            java.util.StringTokenizer r1 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x0077 }
            r1.<init>(r4, r0)     // Catch:{ Exception -> 0x0077 }
            boolean r4 = r1.hasMoreTokens()     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r4 = r1.nextToken()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0077 }
            r3.g(r4)     // Catch:{ Exception -> 0x0077 }
            boolean r4 = r1.hasMoreTokens()     // Catch:{ Exception -> 0x0077 }
            if (r4 != 0) goto L_0x0034
            return
        L_0x0034:
            java.lang.String r4 = r1.nextToken()     // Catch:{ Exception -> 0x0077 }
            r2 = 0
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            r3.f(r2)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = ""
        L_0x0042:
            boolean r2 = r1.hasMoreTokens()     // Catch:{ Exception -> 0x0077 }
            if (r2 != 0) goto L_0x0050
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0077 }
            r3.e(r4)     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0050:
            int r2 = r4.length()     // Catch:{ Exception -> 0x0077 }
            if (r2 < 0) goto L_0x0062
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0077 }
            r2.append(r0)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0077 }
        L_0x0062:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0077 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r1.nextToken()     // Catch:{ Exception -> 0x0077 }
            r2.append(r4)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0042
        L_0x0077:
            r4 = move-exception
            org.cybergarage.util.Debug.d(r4)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cybergarage.http.HTTPStatus.d(java.lang.String):void");
    }

    public void e(String str) {
        this.f59824c = str;
    }

    public void f(int i11) {
        this.f59823b = i11;
    }

    public void g(String str) {
        this.f59822a = str;
    }

    public HTTPStatus(String str) {
        d(str);
    }
}
