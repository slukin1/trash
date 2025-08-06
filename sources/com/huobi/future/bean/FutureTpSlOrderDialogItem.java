package com.huobi.future.bean;

import com.hbg.lib.data.future.bean.FutureTpSlOrder;
import com.huobi.future.viewhandler.FutureTpSlOrderItemViewHandler;
import s9.a;

public class FutureTpSlOrderDialogItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public FutureTpSlOrder f72451b;

    /* renamed from: c  reason: collision with root package name */
    public String f72452c;

    /* renamed from: d  reason: collision with root package name */
    public String f72453d;

    /* renamed from: e  reason: collision with root package name */
    public String f72454e;

    public boolean a(Object obj) {
        return obj instanceof FutureTpSlOrderDialogItem;
    }

    public String c() {
        return this.f72452c;
    }

    public String d() {
        return this.f72453d;
    }

    public FutureTpSlOrder e() {
        return this.f72451b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureTpSlOrderDialogItem)) {
            return false;
        }
        FutureTpSlOrderDialogItem futureTpSlOrderDialogItem = (FutureTpSlOrderDialogItem) obj;
        if (!futureTpSlOrderDialogItem.a(this)) {
            return false;
        }
        FutureTpSlOrder e11 = e();
        FutureTpSlOrder e12 = futureTpSlOrderDialogItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = futureTpSlOrderDialogItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = futureTpSlOrderDialogItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = futureTpSlOrderDialogItem.f();
        return f11 != null ? f11.equals(f12) : f12 == null;
    }

    public String f() {
        return this.f72454e;
    }

    public void g(String str) {
        this.f72452c = str;
    }

    public String getViewHandlerName() {
        return FutureTpSlOrderItemViewHandler.class.getName();
    }

    public void h(String str) {
        this.f72453d = str;
    }

    public int hashCode() {
        FutureTpSlOrder e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int i12 = hashCode3 * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return i12 + i11;
    }

    public void i(FutureTpSlOrder futureTpSlOrder) {
        this.f72451b = futureTpSlOrder;
    }

    public void j(String str) {
        this.f72454e = str;
    }

    public String toString() {
        return "FutureTpSlOrderDialogItem(futureTpSlOrder=" + e() + ", contractFace=" + c() + ", contractShortType=" + d() + ", priceUnit=" + f() + ")";
    }
}
