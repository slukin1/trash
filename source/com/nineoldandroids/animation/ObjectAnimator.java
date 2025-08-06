package com.nineoldandroids.animation;

import android.view.View;
import fx.a;
import fx.b;
import gx.c;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator {
    public static final Map<String, c> I;
    public Object F;
    public String G;
    public c H;

    static {
        HashMap hashMap = new HashMap();
        I = hashMap;
        hashMap.put("alpha", a.f28980a);
        hashMap.put("pivotX", a.f28981b);
        hashMap.put("pivotY", a.f28982c);
        hashMap.put("translationX", a.f28983d);
        hashMap.put("translationY", a.f28984e);
        hashMap.put("rotation", a.f28985f);
        hashMap.put("rotationX", a.f28986g);
        hashMap.put("rotationY", a.f28987h);
        hashMap.put("scaleX", a.f28988i);
        hashMap.put("scaleY", a.f28989j);
        hashMap.put("scrollX", a.f28990k);
        hashMap.put("scrollY", a.f28991l);
        hashMap.put("x", a.f28992m);
        hashMap.put("y", a.f28993n);
    }

    public void B(int... iArr) {
        b[] bVarArr = this.f28274t;
        if (bVarArr == null || bVarArr.length == 0) {
            c cVar = this.H;
            if (cVar != null) {
                D(b.i(cVar, iArr));
                return;
            }
            D(b.j(this.G, iArr));
            return;
        }
        super.B(iArr);
    }

    public void E() {
        super.E();
    }

    /* renamed from: H */
    public ObjectAnimator s() {
        return (ObjectAnimator) super.clone();
    }

    /* renamed from: I */
    public ObjectAnimator A(long j11) {
        super.A(j11);
        return this;
    }

    public void J(c cVar) {
        b[] bVarArr = this.f28274t;
        if (bVarArr != null) {
            b bVar = bVarArr[0];
            String g11 = bVar.g();
            bVar.m(cVar);
            this.f28275u.remove(g11);
            this.f28275u.put(this.G, bVar);
        }
        if (this.H != null) {
            this.G = cVar.b();
        }
        this.H = cVar;
        this.f28267m = false;
    }

    public void q(float f11) {
        super.q(f11);
        for (b k11 : this.f28274t) {
            k11.k(this.F);
        }
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.F;
        if (this.f28274t != null) {
            for (int i11 = 0; i11 < this.f28274t.length; i11++) {
                str = str + "\n    " + this.f28274t[i11].toString();
            }
        }
        return str;
    }

    public void x() {
        if (!this.f28267m) {
            if (this.H == null && hx.a.f29054r && (this.F instanceof View)) {
                Map<String, c> map = I;
                if (map.containsKey(this.G)) {
                    J(map.get(this.G));
                }
            }
            for (b p11 : this.f28274t) {
                p11.p(this.F);
            }
            super.x();
        }
    }
}
