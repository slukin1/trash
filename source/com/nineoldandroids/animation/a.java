package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import fx.c;
import java.util.ArrayList;

public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f28276g;

    /* renamed from: h  reason: collision with root package name */
    public int f28277h;

    /* renamed from: i  reason: collision with root package name */
    public int f28278i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28279j = true;

    public a(Keyframe.a... aVarArr) {
        super(aVarArr);
    }

    public Object b(float f11) {
        return Integer.valueOf(f(f11));
    }

    /* renamed from: e */
    public a clone() {
        ArrayList<Keyframe> arrayList = this.f28284e;
        int size = arrayList.size();
        Keyframe.a[] aVarArr = new Keyframe.a[size];
        for (int i11 = 0; i11 < size; i11++) {
            aVarArr[i11] = (Keyframe.a) arrayList.get(i11).clone();
        }
        return new a(aVarArr);
    }

    public int f(float f11) {
        int i11 = this.f28280a;
        if (i11 == 2) {
            if (this.f28279j) {
                this.f28279j = false;
                this.f28276g = ((Keyframe.a) this.f28284e.get(0)).l();
                int l11 = ((Keyframe.a) this.f28284e.get(1)).l();
                this.f28277h = l11;
                this.f28278i = l11 - this.f28276g;
            }
            Interpolator interpolator = this.f28283d;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f11);
            }
            c cVar = this.f28285f;
            if (cVar == null) {
                return this.f28276g + ((int) (f11 * ((float) this.f28278i)));
            }
            return ((Number) cVar.evaluate(f11, Integer.valueOf(this.f28276g), Integer.valueOf(this.f28277h))).intValue();
        } else if (f11 <= 0.0f) {
            Keyframe.a aVar = (Keyframe.a) this.f28284e.get(0);
            Keyframe.a aVar2 = (Keyframe.a) this.f28284e.get(1);
            int l12 = aVar.l();
            int l13 = aVar2.l();
            float c11 = aVar.c();
            float c12 = aVar2.c();
            Interpolator d11 = aVar2.d();
            if (d11 != null) {
                f11 = d11.getInterpolation(f11);
            }
            float f12 = (f11 - c11) / (c12 - c11);
            c cVar2 = this.f28285f;
            return cVar2 == null ? l12 + ((int) (f12 * ((float) (l13 - l12)))) : ((Number) cVar2.evaluate(f12, Integer.valueOf(l12), Integer.valueOf(l13))).intValue();
        } else if (f11 >= 1.0f) {
            Keyframe.a aVar3 = (Keyframe.a) this.f28284e.get(i11 - 2);
            Keyframe.a aVar4 = (Keyframe.a) this.f28284e.get(this.f28280a - 1);
            int l14 = aVar3.l();
            int l15 = aVar4.l();
            float c13 = aVar3.c();
            float c14 = aVar4.c();
            Interpolator d12 = aVar4.d();
            if (d12 != null) {
                f11 = d12.getInterpolation(f11);
            }
            float f13 = (f11 - c13) / (c14 - c13);
            c cVar3 = this.f28285f;
            return cVar3 == null ? l14 + ((int) (f13 * ((float) (l15 - l14)))) : ((Number) cVar3.evaluate(f13, Integer.valueOf(l14), Integer.valueOf(l15))).intValue();
        } else {
            Keyframe.a aVar5 = (Keyframe.a) this.f28284e.get(0);
            int i12 = 1;
            while (true) {
                int i13 = this.f28280a;
                if (i12 >= i13) {
                    return ((Number) this.f28284e.get(i13 - 1).e()).intValue();
                }
                Keyframe.a aVar6 = (Keyframe.a) this.f28284e.get(i12);
                if (f11 < aVar6.c()) {
                    Interpolator d13 = aVar6.d();
                    if (d13 != null) {
                        f11 = d13.getInterpolation(f11);
                    }
                    float c15 = (f11 - aVar5.c()) / (aVar6.c() - aVar5.c());
                    int l16 = aVar5.l();
                    int l17 = aVar6.l();
                    c cVar4 = this.f28285f;
                    return cVar4 == null ? l16 + ((int) (c15 * ((float) (l17 - l16)))) : ((Number) cVar4.evaluate(c15, Integer.valueOf(l16), Integer.valueOf(l17))).intValue();
                }
                i12++;
                aVar5 = aVar6;
            }
        }
    }
}
