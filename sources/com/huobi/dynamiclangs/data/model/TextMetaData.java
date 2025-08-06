package com.huobi.dynamiclangs.data.model;

import java.util.Arrays;

public class TextMetaData {

    /* renamed from: a  reason: collision with root package name */
    public String f43859a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43860b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43861c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f43862d = "";

    /* renamed from: e  reason: collision with root package name */
    public Object[] f43863e = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f43864f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f43865g = false;

    /* renamed from: h  reason: collision with root package name */
    public String f43866h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f43867i = -1;

    /* renamed from: j  reason: collision with root package name */
    public String f43868j = "";

    /* renamed from: k  reason: collision with root package name */
    public int f43869k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Object[] f43870l = new Object[0];

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextMetaData textMetaData = (TextMetaData) obj;
        if (!this.f43859a.equals(textMetaData.f43859a) || !this.f43860b.equals(textMetaData.f43860b) || !this.f43861c.equals(textMetaData.f43861c) || !this.f43862d.equals(textMetaData.f43862d) || !Arrays.equals(this.f43863e, textMetaData.f43863e) || !this.f43864f.equals(textMetaData.f43864f) || !this.f43866h.equals(textMetaData.f43866h) || this.f43867i != textMetaData.f43867i || !this.f43868j.equals(textMetaData.f43868j) || this.f43869k != textMetaData.f43869k || !Arrays.equals(this.f43870l, textMetaData.f43870l)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f43859a.hashCode() * 31) + this.f43860b.hashCode()) * 31) + this.f43861c.hashCode()) * 31) + this.f43862d.hashCode()) * 31) + Arrays.hashCode(this.f43863e)) * 31) + this.f43864f.hashCode()) * 31) + this.f43866h.hashCode()) * 31) + this.f43867i) * 31) + this.f43868j.hashCode()) * 31) + this.f43869k) * 31) + Arrays.hashCode(this.f43870l);
    }
}
