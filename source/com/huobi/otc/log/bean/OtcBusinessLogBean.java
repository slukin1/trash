package com.huobi.otc.log.bean;

import java.util.List;

public class OtcBusinessLogBean {

    /* renamed from: a  reason: collision with root package name */
    public String f78955a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f78956b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f78957c;

    public boolean a(Object obj) {
        return obj instanceof OtcBusinessLogBean;
    }

    public String b() {
        return this.f78955a;
    }

    public List<String> c() {
        return this.f78957c;
    }

    public boolean d() {
        return this.f78956b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcBusinessLogBean)) {
            return false;
        }
        OtcBusinessLogBean otcBusinessLogBean = (OtcBusinessLogBean) obj;
        if (!otcBusinessLogBean.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = otcBusinessLogBean.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        if (d() != otcBusinessLogBean.d()) {
            return false;
        }
        List<String> c11 = c();
        List<String> c12 = otcBusinessLogBean.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = (((b11 == null ? 43 : b11.hashCode()) + 59) * 59) + (d() ? 79 : 97);
        List<String> c11 = c();
        int i12 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OtcBusinessLogBean(key=" + b() + ", isAll=" + d() + ", valueKeys=" + c() + ")";
    }
}
