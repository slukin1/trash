package com.hbg.lib.network.uc.retrofit.bean;

import com.google.gson.annotations.SerializedName;

public class MessageNoReadNum {
    @SerializedName("sum_sub_un_read")

    /* renamed from: a  reason: collision with root package name */
    public int f70786a;
    @SerializedName("sum_un_read")

    /* renamed from: b  reason: collision with root package name */
    public int f70787b;
    @SerializedName("letter_sub_type")

    /* renamed from: c  reason: collision with root package name */
    public int f70788c;
    @SerializedName("sum_un_read_except_code")

    /* renamed from: d  reason: collision with root package name */
    public int f70789d;

    public static class DetailsDTO {

        public static class ContentExtDTO {

            public static class DetailsLinksDTO {

                public static class HyperlinkDTO {
                }
            }

            public static class HyperlinkDTO {
            }
        }
    }

    public int a() {
        return this.f70788c;
    }

    public int b() {
        return this.f70786a;
    }

    public Integer c() {
        return Integer.valueOf(this.f70787b);
    }

    public int d() {
        return this.f70789d;
    }

    public void e(Integer num) {
        this.f70786a = num.intValue();
    }

    public void f(Integer num) {
        this.f70789d = num.intValue();
    }
}
