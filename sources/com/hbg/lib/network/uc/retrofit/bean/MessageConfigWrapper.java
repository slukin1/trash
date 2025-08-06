package com.hbg.lib.network.uc.retrofit.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MessageConfigWrapper {
    @SerializedName("message_type")

    /* renamed from: a  reason: collision with root package name */
    public String f70784a;
    @SerializedName("subscribe")

    /* renamed from: b  reason: collision with root package name */
    public List<MessageConfig> f70785b;

    public boolean a(Object obj) {
        return obj instanceof MessageConfigWrapper;
    }

    public List<MessageConfig> b() {
        return this.f70785b;
    }

    public String c() {
        return this.f70784a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageConfigWrapper)) {
            return false;
        }
        MessageConfigWrapper messageConfigWrapper = (MessageConfigWrapper) obj;
        if (!messageConfigWrapper.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = messageConfigWrapper.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        List<MessageConfig> b11 = b();
        List<MessageConfig> b12 = messageConfigWrapper.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        List<MessageConfig> b11 = b();
        int i12 = (hashCode + 59) * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "MessageConfigWrapper(type=" + c() + ", dataList=" + b() + ")";
    }
}
