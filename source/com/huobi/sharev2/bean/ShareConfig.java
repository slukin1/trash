package com.huobi.sharev2.bean;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ShareConfig {
    @SerializedName("channelList")

    /* renamed from: a  reason: collision with root package name */
    public List<String> f81041a;
    @SerializedName("floatingText")

    /* renamed from: b  reason: collision with root package name */
    public String f81042b;
    @SerializedName("qrCodeUrl")

    /* renamed from: c  reason: collision with root package name */
    public String f81043c;
    @SerializedName("shareTitle")

    /* renamed from: d  reason: collision with root package name */
    public String f81044d;
    @SerializedName("showFloating")

    /* renamed from: e  reason: collision with root package name */
    public Integer f81045e;
    @SerializedName("tailImgUrl")

    /* renamed from: f  reason: collision with root package name */
    public String f81046f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f81047g;

    public boolean a(Object obj) {
        return obj instanceof ShareConfig;
    }

    public List<String> b() {
        return this.f81041a;
    }

    public String c() {
        return this.f81042b;
    }

    public String d() {
        return this.f81043c;
    }

    public String e() {
        return this.f81044d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareConfig)) {
            return false;
        }
        ShareConfig shareConfig = (ShareConfig) obj;
        if (!shareConfig.a(this)) {
            return false;
        }
        List<String> b11 = b();
        List<String> b12 = shareConfig.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = shareConfig.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = shareConfig.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = shareConfig.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        Integer f11 = f();
        Integer f12 = shareConfig.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = shareConfig.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        Bitmap g11 = g();
        Bitmap g12 = shareConfig.g();
        return g11 != null ? g11.equals(g12) : g12 == null;
    }

    public Integer f() {
        return this.f81045e;
    }

    public Bitmap g() {
        return this.f81047g;
    }

    public String h() {
        return this.f81046f;
    }

    public int hashCode() {
        List<String> b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int hashCode4 = (hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode());
        Integer f11 = f();
        int hashCode5 = (hashCode4 * 59) + (f11 == null ? 43 : f11.hashCode());
        String h11 = h();
        int hashCode6 = (hashCode5 * 59) + (h11 == null ? 43 : h11.hashCode());
        Bitmap g11 = g();
        int i12 = hashCode6 * 59;
        if (g11 != null) {
            i11 = g11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "ShareConfig{channelList=" + this.f81041a + ", floatingText='" + this.f81042b + '\'' + ", qrCodeUrl='" + this.f81043c + '\'' + ", shareTitle='" + this.f81044d + '\'' + ", showFloating=" + this.f81045e + ", tailImgUrl='" + this.f81046f + '\'' + '}';
    }
}
