package com.hbg.lite.index.bean;

import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import java.util.List;

public class LiteIndexBannerTopNoticeModel {

    /* renamed from: a  reason: collision with root package name */
    public boolean f77071a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiteHomeActivityEntity> f77072b;

    /* renamed from: c  reason: collision with root package name */
    public ZendeskTopNotice f77073c;

    public boolean a(Object obj) {
        return obj instanceof LiteIndexBannerTopNoticeModel;
    }

    public List<LiteHomeActivityEntity> b() {
        return this.f77072b;
    }

    public ZendeskTopNotice c() {
        return this.f77073c;
    }

    public boolean d() {
        return this.f77071a;
    }

    public void e(boolean z11) {
        this.f77071a = z11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteIndexBannerTopNoticeModel)) {
            return false;
        }
        LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel = (LiteIndexBannerTopNoticeModel) obj;
        if (!liteIndexBannerTopNoticeModel.a(this) || d() != liteIndexBannerTopNoticeModel.d()) {
            return false;
        }
        List<LiteHomeActivityEntity> b11 = b();
        List<LiteHomeActivityEntity> b12 = liteIndexBannerTopNoticeModel.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        ZendeskTopNotice c11 = c();
        ZendeskTopNotice c12 = liteIndexBannerTopNoticeModel.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(List<LiteHomeActivityEntity> list) {
        this.f77072b = list;
    }

    public void g(ZendeskTopNotice zendeskTopNotice) {
        this.f77073c = zendeskTopNotice;
    }

    public int hashCode() {
        int i11 = d() ? 79 : 97;
        List<LiteHomeActivityEntity> b11 = b();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (b11 == null ? 43 : b11.hashCode());
        ZendeskTopNotice c11 = c();
        int i13 = hashCode * 59;
        if (c11 != null) {
            i12 = c11.hashCode();
        }
        return i13 + i12;
    }

    public String toString() {
        return "LiteIndexBannerTopNoticeModel(canPlay=" + d() + ", list=" + b() + ", topNotice=" + c() + ")";
    }
}
