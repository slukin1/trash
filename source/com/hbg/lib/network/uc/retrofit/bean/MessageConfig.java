package com.hbg.lib.network.uc.retrofit.bean;

import com.google.gson.annotations.SerializedName;

public class MessageConfig {
    @SerializedName("id")

    /* renamed from: a  reason: collision with root package name */
    public String f70781a;
    @SerializedName("label_name")

    /* renamed from: b  reason: collision with root package name */
    public String f70782b;
    @SerializedName("sub_state")

    /* renamed from: c  reason: collision with root package name */
    public String f70783c;

    public boolean a(Object obj) {
        return obj instanceof MessageConfig;
    }

    public String b() {
        return this.f70781a;
    }

    public String c() {
        return this.f70782b;
    }

    public String d() {
        return this.f70783c;
    }

    public void e(String str) {
        this.f70783c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageConfig)) {
            return false;
        }
        MessageConfig messageConfig = (MessageConfig) obj;
        if (!messageConfig.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = messageConfig.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = messageConfig.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = messageConfig.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int i12 = hashCode2 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "MessageConfig(id=" + b() + ", name=" + c() + ", status=" + d() + ")";
    }
}
