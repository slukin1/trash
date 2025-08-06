package com.hbg.lib.widgets.adapter.bean;

import com.hbg.lib.widgets.adapter.viewhandler.CommonNetErrorItemHandler;

public class CommonNetErrorItem implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public a f71741b;

    public interface a {
        void a();
    }

    public boolean a(Object obj) {
        return obj instanceof CommonNetErrorItem;
    }

    public a c() {
        return this.f71741b;
    }

    public void d(a aVar) {
        this.f71741b = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommonNetErrorItem)) {
            return false;
        }
        CommonNetErrorItem commonNetErrorItem = (CommonNetErrorItem) obj;
        if (!commonNetErrorItem.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = commonNetErrorItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return CommonNetErrorItemHandler.class.getName();
    }

    public int hashCode() {
        a c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "CommonNetErrorItem(callback=" + c() + ")";
    }
}
