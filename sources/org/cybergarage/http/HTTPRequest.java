package org.cybergarage.http;

import com.jumio.commons.log.LogUtils;
import e20.e;
import java.net.Socket;

public class HTTPRequest extends HTTPPacket {

    /* renamed from: f  reason: collision with root package name */
    public String f59809f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f59810g = null;

    /* renamed from: h  reason: collision with root package name */
    public String f59811h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f59812i = -1;

    /* renamed from: j  reason: collision with root package name */
    public e f59813j = null;

    /* renamed from: k  reason: collision with root package name */
    public Socket f59814k = null;

    public HTTPRequest() {
        j0("1.0");
    }

    public boolean A0() {
        return w0("SUBSCRIBE");
    }

    public boolean B0() {
        return w0("UNSUBSCRIBE");
    }

    public HTTPResponse C0(String str, int i11) {
        return D0(str, i11, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c6 A[SYNTHETIC, Splitter:B:55:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00de A[SYNTHETIC, Splitter:B:70:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f3 A[SYNTHETIC, Splitter:B:86:0x00f3] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:67:0x00d6=Splitter:B:67:0x00d6, B:52:0x00be=Splitter:B:52:0x00be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.cybergarage.http.HTTPResponse D0(java.lang.String r11, int r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = "\r\n"
            org.cybergarage.http.HTTPResponse r1 = new org.cybergarage.http.HTTPResponse
            r1.<init>()
            r10.f0(r11)
            if (r13 == 0) goto L_0x000f
            java.lang.String r2 = "Keep-Alive"
            goto L_0x0011
        L_0x000f:
            java.lang.String r2 = "close"
        L_0x0011:
            r10.S(r2)
            boolean r2 = r10.u0()
            r3 = 500(0x1f4, float:7.0E-43)
            r4 = 0
            java.net.Socket r5 = r10.f59814k     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            if (r5 != 0) goto L_0x0031
            java.net.Socket r5 = new java.net.Socket     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            r5.<init>()     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            r10.f59814k = r5     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            r6.<init>(r11, r12)     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            r11 = 80000(0x13880, float:1.12104E-40)
            r5.connect(r6, r11)     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
        L_0x0031:
            java.net.Socket r11 = r10.f59814k     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            java.io.OutputStream r11 = r11.getOutputStream()     // Catch:{ SocketException -> 0x00d3, IOException -> 0x00bb, all -> 0x00b7 }
            java.io.PrintStream r12 = new java.io.PrintStream     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.<init>(r11)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            java.lang.String r5 = r10.m0()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.print(r5)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.print(r0)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            boolean r5 = r10.H()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            java.lang.String r6 = r10.l()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r7 = 0
            if (r6 == 0) goto L_0x0055
            int r7 = r6.length()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
        L_0x0055:
            if (r7 <= 0) goto L_0x006c
            if (r5 == 0) goto L_0x0064
            long r7 = (long) r7     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            java.lang.String r7 = java.lang.Long.toHexString(r7)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.print(r7)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.print(r0)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
        L_0x0064:
            r12.print(r6)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            if (r5 == 0) goto L_0x006c
            r12.print(r0)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
        L_0x006c:
            if (r5 == 0) goto L_0x0076
            java.lang.String r5 = "0"
            r12.print(r5)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r12.print(r0)     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
        L_0x0076:
            r12.flush()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            java.net.Socket r12 = r10.f59814k     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            java.io.InputStream r12 = r12.getInputStream()     // Catch:{ SocketException -> 0x00b1, IOException -> 0x00ab, all -> 0x00a5 }
            r1.P(r12, r2)     // Catch:{ SocketException -> 0x009f, IOException -> 0x0099, all -> 0x0092 }
            if (r13 != 0) goto L_0x00ef
            r12.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            if (r12 == 0) goto L_0x008c
            r11.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            if (r11 == 0) goto L_0x00ed
            java.net.Socket r11 = r10.f59814k     // Catch:{ Exception -> 0x00ed }
            goto L_0x00ea
        L_0x0092:
            r0 = move-exception
            r9 = r12
            r12 = r11
            r11 = r0
            r0 = r9
            goto L_0x00f1
        L_0x0099:
            r0 = move-exception
            r9 = r12
            r12 = r11
            r11 = r0
            r0 = r9
            goto L_0x00be
        L_0x009f:
            r0 = move-exception
            r9 = r12
            r12 = r11
            r11 = r0
            r0 = r9
            goto L_0x00d6
        L_0x00a5:
            r12 = move-exception
            r0 = r4
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00f1
        L_0x00ab:
            r12 = move-exception
            r0 = r4
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00be
        L_0x00b1:
            r12 = move-exception
            r0 = r4
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00d6
        L_0x00b7:
            r11 = move-exception
            r12 = r4
            r0 = r12
            goto L_0x00f1
        L_0x00bb:
            r11 = move-exception
            r12 = r4
            r0 = r12
        L_0x00be:
            r1.p0(r3)     // Catch:{ all -> 0x00f0 }
            org.cybergarage.util.Debug.d(r11)     // Catch:{ all -> 0x00f0 }
            if (r13 != 0) goto L_0x00ef
            r0.close()     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            if (r0 == 0) goto L_0x00ce
            r12.close()     // Catch:{ Exception -> 0x00ce }
        L_0x00ce:
            if (r12 == 0) goto L_0x00ed
            java.net.Socket r11 = r10.f59814k     // Catch:{ Exception -> 0x00ed }
            goto L_0x00ea
        L_0x00d3:
            r11 = move-exception
            r12 = r4
            r0 = r12
        L_0x00d6:
            r1.p0(r3)     // Catch:{ all -> 0x00f0 }
            org.cybergarage.util.Debug.d(r11)     // Catch:{ all -> 0x00f0 }
            if (r13 != 0) goto L_0x00ef
            r0.close()     // Catch:{ Exception -> 0x00e1 }
        L_0x00e1:
            if (r0 == 0) goto L_0x00e6
            r12.close()     // Catch:{ Exception -> 0x00e6 }
        L_0x00e6:
            if (r12 == 0) goto L_0x00ed
            java.net.Socket r11 = r10.f59814k     // Catch:{ Exception -> 0x00ed }
        L_0x00ea:
            r11.close()     // Catch:{ Exception -> 0x00ed }
        L_0x00ed:
            r10.f59814k = r4
        L_0x00ef:
            return r1
        L_0x00f0:
            r11 = move-exception
        L_0x00f1:
            if (r13 != 0) goto L_0x0104
            r0.close()     // Catch:{ Exception -> 0x00f6 }
        L_0x00f6:
            if (r0 == 0) goto L_0x00fb
            r12.close()     // Catch:{ Exception -> 0x00fb }
        L_0x00fb:
            if (r12 == 0) goto L_0x0102
            java.net.Socket r12 = r10.f59814k     // Catch:{ Exception -> 0x0102 }
            r12.close()     // Catch:{ Exception -> 0x0102 }
        L_0x0102:
            r10.f59814k = r4
        L_0x0104:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cybergarage.http.HTTPRequest.D0(java.lang.String, int, boolean):org.cybergarage.http.HTTPResponse");
    }

    public boolean E0(HTTPResponse hTTPResponse) {
        long j11;
        e r02 = r0();
        long h11 = hTTPResponse.h();
        long j12 = 0;
        if (C()) {
            long j13 = j();
            long k11 = k();
            if (k11 <= 0) {
                k11 = h11 - 1;
            }
            long j14 = k11;
            if (j13 > h11 || j14 > h11) {
                return J0(416);
            }
            j12 = j13;
            hTTPResponse.Z(j12, j14, h11);
            hTTPResponse.p0(206);
            j11 = (j14 - j13) + 1;
        } else {
            j11 = h11;
        }
        return r02.g(hTTPResponse, j12, j11, u0());
    }

    public void F0() {
        System.out.println(toString());
    }

    public boolean G0() {
        return super.K(r0());
    }

    public boolean H0() {
        return J0(400);
    }

    public boolean I0() {
        return J0(200);
    }

    public boolean J0(int i11) {
        HTTPResponse hTTPResponse = new HTTPResponse();
        hTTPResponse.p0(i11);
        hTTPResponse.Y(0);
        return E0(hTTPResponse);
    }

    public void K0(HTTPRequest hTTPRequest) {
        M(hTTPRequest);
        O0(hTTPRequest.r0());
    }

    public void L0(String str) {
        this.f59809f = str;
    }

    public void M0(String str) {
        this.f59811h = str;
    }

    public void N0(int i11) {
        this.f59812i = i11;
    }

    public void O0(e eVar) {
        this.f59813j = eVar;
    }

    public void P0(String str) {
        Q0(str, false);
    }

    public void Q0(String str, boolean z11) {
        this.f59810g = str;
        if (z11) {
            this.f59810g = HTTP.g(str);
        }
    }

    public String k0() {
        return String.valueOf(o0()) + " " + s0() + " " + l0() + LogUtils.NEW_LINE;
    }

    public String l0() {
        if (D()) {
            return o(2);
        }
        return "HTTP/" + super.y();
    }

    public String m0() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(k0());
        stringBuffer.append(r());
        return stringBuffer.toString();
    }

    public String n0() {
        return r0().c();
    }

    public String o0() {
        String str = this.f59809f;
        if (str != null) {
            return str;
        }
        return o(0);
    }

    public String p0() {
        return this.f59811h;
    }

    public int q0() {
        return this.f59812i;
    }

    public e r0() {
        return this.f59813j;
    }

    public String s0() {
        String str = this.f59810g;
        if (str != null) {
            return str;
        }
        return o(1);
    }

    public boolean t0() {
        return w0("GET");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m0());
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append(l());
        return stringBuffer.toString();
    }

    public boolean u0() {
        return w0("HEAD");
    }

    public boolean v0() {
        if (I()) {
            return false;
        }
        if (J()) {
            return true;
        }
        if (l0().indexOf("1.0") > 0) {
            return false;
        }
        return true;
    }

    public boolean w0(String str) {
        String o02 = o0();
        if (o02 == null) {
            return false;
        }
        return o02.equalsIgnoreCase(str);
    }

    public boolean x0() {
        return w0("NOTIFY");
    }

    public boolean y0() {
        return w0("POST");
    }

    public boolean z0() {
        return E("SOAPACTION");
    }
}
