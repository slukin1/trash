package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import fx.c;
import java.util.ArrayList;
import java.util.Arrays;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f28280a;

    /* renamed from: b  reason: collision with root package name */
    public Keyframe f28281b = this.f28284e.get(0);

    /* renamed from: c  reason: collision with root package name */
    public Keyframe f28282c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f28283d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Keyframe> f28284e;

    /* renamed from: f  reason: collision with root package name */
    public c f28285f;

    public b(Keyframe... keyframeArr) {
        this.f28280a = keyframeArr.length;
        ArrayList<Keyframe> arrayList = new ArrayList<>();
        this.f28284e = arrayList;
        arrayList.addAll(Arrays.asList(keyframeArr));
        Keyframe keyframe = this.f28284e.get(this.f28280a - 1);
        this.f28282c = keyframe;
        this.f28283d = keyframe.d();
    }

    public static b c(int... iArr) {
        int length = iArr.length;
        Keyframe.a[] aVarArr = new Keyframe.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (Keyframe.a) Keyframe.g(0.0f);
            aVarArr[1] = (Keyframe.a) Keyframe.h(1.0f, iArr[0]);
        } else {
            aVarArr[0] = (Keyframe.a) Keyframe.h(0.0f, iArr[0]);
            for (int i11 = 1; i11 < length; i11++) {
                aVarArr[i11] = (Keyframe.a) Keyframe.h(((float) i11) / ((float) (length - 1)), iArr[i11]);
            }
        }
        return new a(aVarArr);
    }

    public b a() {
        throw null;
    }

    public Object b(float f11) {
        throw null;
    }

    public void d(c cVar) {
        this.f28285f = cVar;
    }

    public String toString() {
        String str = " ";
        for (int i11 = 0; i11 < this.f28280a; i11++) {
            str = str + this.f28284e.get(i11).e() + "  ";
        }
        return str;
    }
}
