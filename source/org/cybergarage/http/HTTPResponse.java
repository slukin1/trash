package org.cybergarage.http;

import com.jumio.commons.log.LogUtils;

public class HTTPResponse extends HTTPPacket {

    /* renamed from: f  reason: collision with root package name */
    public int f59815f = 0;

    public HTTPResponse() {
        j0("1.1");
        a0("text/html; charset=\"utf-8\"");
        i0(HTTPServer.d());
        T("");
    }

    public String k0() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m0());
        stringBuffer.append(r());
        return stringBuffer.toString();
    }

    public int l0() {
        int i11 = this.f59815f;
        if (i11 != 0) {
            return i11;
        }
        return new HTTPStatus(n()).b();
    }

    public String m0() {
        return "HTTP/" + y() + " " + l0() + " " + HTTPStatus.a(this.f59815f) + LogUtils.NEW_LINE;
    }

    public boolean n0() {
        return HTTPStatus.c(l0());
    }

    public void o0() {
        System.out.println(toString());
    }

    public void p0(int i11) {
        this.f59815f = i11;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m0());
        stringBuffer.append(r());
        stringBuffer.append(LogUtils.NEW_LINE);
        stringBuffer.append(l());
        return stringBuffer.toString();
    }

    public HTTPResponse(HTTPResponse hTTPResponse) {
        M(hTTPResponse);
    }
}
