package com.tencent.thumbplayer.tcmedia.g.f;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f49325e = new b(1920, 1920);

    /* renamed from: a  reason: collision with root package name */
    public boolean f49326a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f49327b;

    /* renamed from: c  reason: collision with root package name */
    public int f49328c;

    /* renamed from: d  reason: collision with root package name */
    public a f49329d = a.First;

    public enum a {
        First,
        SAME
    }

    public b(int i11, int i12) {
        this.f49327b = i11;
        this.f49328c = i12;
    }

    public final String toString() {
        return "[initWidth:" + this.f49327b + ", initHeight:" + this.f49328c + ", reConfigByRealFormat:" + this.f49326a + ']';
    }
}
