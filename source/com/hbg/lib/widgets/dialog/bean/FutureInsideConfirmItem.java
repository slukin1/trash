package com.hbg.lib.widgets.dialog.bean;

import com.hbg.lib.widgets.dialog.viewhander.FutureInsideConfirmItemHandler;
import s9.a;

public class FutureInsideConfirmItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f71934b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f71935c;

    /* renamed from: d  reason: collision with root package name */
    public String f71936d;

    public boolean a(Object obj) {
        return obj instanceof FutureInsideConfirmItem;
    }

    public String c() {
        return this.f71934b;
    }

    public CharSequence d() {
        return this.f71935c;
    }

    public String e() {
        return this.f71936d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureInsideConfirmItem)) {
            return false;
        }
        FutureInsideConfirmItem futureInsideConfirmItem = (FutureInsideConfirmItem) obj;
        if (!futureInsideConfirmItem.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = futureInsideConfirmItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        CharSequence d11 = d();
        CharSequence d12 = futureInsideConfirmItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = futureInsideConfirmItem.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public void f(String str) {
        this.f71934b = str;
    }

    public void g(CharSequence charSequence) {
        this.f71935c = charSequence;
    }

    public String getViewHandlerName() {
        return FutureInsideConfirmItemHandler.class.getName();
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        CharSequence d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int i12 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "FutureInsideConfirmItem(key=" + c() + ", value=" + d() + ", valueExtra=" + e() + ")";
    }
}
