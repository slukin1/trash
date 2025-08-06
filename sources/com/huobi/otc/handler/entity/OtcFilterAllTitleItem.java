package com.huobi.otc.handler.entity;

import com.huobi.otc.handler.OtcFilterAllTitleHandler;
import s9.a;

public class OtcFilterAllTitleItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f78784b;

    public boolean a(Object obj) {
        return obj instanceof OtcFilterAllTitleItem;
    }

    public String c() {
        return this.f78784b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFilterAllTitleItem)) {
            return false;
        }
        OtcFilterAllTitleItem otcFilterAllTitleItem = (OtcFilterAllTitleItem) obj;
        if (!otcFilterAllTitleItem.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = otcFilterAllTitleItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return OtcFilterAllTitleHandler.class.getName();
    }

    public int hashCode() {
        String c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "OtcFilterAllTitleItem(text=" + c() + ")";
    }
}
