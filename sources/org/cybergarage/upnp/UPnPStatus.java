package org.cybergarage.upnp;

import org.cybergarage.http.HTTPStatus;

public class UPnPStatus {

    /* renamed from: a  reason: collision with root package name */
    public int f59872a;

    /* renamed from: b  reason: collision with root package name */
    public String f59873b;

    public UPnPStatus() {
        d(0);
        e("");
    }

    public static final String a(int i11) {
        if (i11 == 412) {
            return "Precondition Failed";
        }
        if (i11 == 501) {
            return "Action Failed";
        }
        switch (i11) {
            case 401:
                return "Invalid Action";
            case 402:
                return "Invalid Args";
            case 403:
                return "Out of Sync";
            case 404:
                return "Invalid Var";
            default:
                return HTTPStatus.a(i11);
        }
    }

    public int b() {
        return this.f59872a;
    }

    public String c() {
        return this.f59873b;
    }

    public void d(int i11) {
        this.f59872a = i11;
    }

    public void e(String str) {
        this.f59873b = str;
    }
}
