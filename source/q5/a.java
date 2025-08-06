package q5;

import android.graphics.Color;
import com.hbg.lib.common.utils.PixelUtils;

public final class a {

    /* renamed from: j  reason: collision with root package name */
    public static a f68297j;

    /* renamed from: a  reason: collision with root package name */
    public String f68298a;

    /* renamed from: b  reason: collision with root package name */
    public String f68299b;

    /* renamed from: c  reason: collision with root package name */
    public int f68300c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f68301d = 3;

    /* renamed from: e  reason: collision with root package name */
    public float f68302e = ((float) PixelUtils.a(1.0f));

    /* renamed from: f  reason: collision with root package name */
    public int f68303f = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f68304g = Color.parseColor("#FE760D");

    /* renamed from: h  reason: collision with root package name */
    public int f68305h = 1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68306i = false;

    public static a g() {
        if (f68297j == null) {
            f68297j = new a();
        }
        return f68297j;
    }

    public int a() {
        return this.f68304g;
    }

    public int b() {
        return this.f68305h;
    }

    public float c() {
        return this.f68302e;
    }

    public int d() {
        return this.f68303f;
    }

    public int e() {
        return this.f68301d;
    }

    public int f() {
        return this.f68300c;
    }

    public String h() {
        return this.f68299b;
    }

    public String i() {
        return this.f68298a;
    }

    public void j(int i11) {
        this.f68304g = i11;
    }

    public void k(int i11) {
        this.f68305h = i11;
    }

    public void l(float f11) {
        this.f68302e = f11;
    }

    public void m(int i11) {
        this.f68303f = i11;
    }

    public void n(int i11) {
        this.f68301d = i11;
    }

    public void o(int i11) {
        this.f68300c = i11;
    }

    public void p(String str) {
        this.f68299b = str;
    }

    public void q(String str) {
        this.f68298a = str;
    }

    public void r(int i11, float f11, int i12, int i13, int i14) {
        if (!this.f68306i) {
            this.f68306i = true;
            this.f68301d = i11;
            this.f68302e = f11;
            this.f68303f = i12;
            this.f68304g = i13;
            this.f68305h = i14;
        }
    }
}
