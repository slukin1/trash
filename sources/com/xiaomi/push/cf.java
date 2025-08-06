package com.xiaomi.push;

import java.net.InetSocketAddress;

public final class cf {

    /* renamed from: a  reason: collision with root package name */
    private int f51492a;

    /* renamed from: a  reason: collision with other field name */
    private String f2598a;

    public cf(String str, int i11) {
        this.f2598a = str;
        this.f51492a = i11;
    }

    public int a() {
        return this.f51492a;
    }

    public String toString() {
        if (this.f51492a <= 0) {
            return this.f2598a;
        }
        return this.f2598a + ":" + this.f51492a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2481a() {
        return this.f2598a;
    }

    public static cf a(String str, int i11) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i11 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new cf(str, i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m2480a(String str, int i11) {
        cf a11 = a(str, i11);
        return new InetSocketAddress(a11.a(), a11.a());
    }
}
