package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;

public class FeedRequestItems {
    @SerializedName("id")

    /* renamed from: a  reason: collision with root package name */
    public Long f73147a;
    @SerializedName("itemType")

    /* renamed from: b  reason: collision with root package name */
    public Integer f73148b;

    public boolean a(Object obj) {
        return obj instanceof FeedRequestItems;
    }

    public Long b() {
        return this.f73147a;
    }

    public Integer c() {
        return this.f73148b;
    }

    public void d(Long l11) {
        this.f73147a = l11;
    }

    public void e(Integer num) {
        this.f73148b = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedRequestItems)) {
            return false;
        }
        FeedRequestItems feedRequestItems = (FeedRequestItems) obj;
        if (!feedRequestItems.a(this)) {
            return false;
        }
        Long b11 = b();
        Long b12 = feedRequestItems.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        Integer c11 = c();
        Integer c12 = feedRequestItems.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int hashCode() {
        Long b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        Integer c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "FeedRequestItems(id=" + b() + ", itemType=" + c() + ")";
    }
}
