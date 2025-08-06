package com.hbg.module.content.custom.like.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.util.SparseArray;
import java.util.Random;
import jc.a;

public class CurveEvaluatorRecord {

    /* renamed from: a  reason: collision with root package name */
    public final Random f18149a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public int f18150b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<TypeEvaluator<PointF>> f18151c = new SparseArray<>();

    public final TypeEvaluator<PointF> a(PointF pointF, PointF pointF2) {
        return new a(pointF, pointF2);
    }

    public void b() {
        SparseArray<TypeEvaluator<PointF>> sparseArray = this.f18151c;
        if (sparseArray != null) {
            sparseArray.clear();
            this.f18151c = null;
        }
    }

    public TypeEvaluator<PointF> c(PointF pointF, PointF pointF2) {
        int i11 = this.f18150b + 1;
        this.f18150b = i11;
        if (i11 > 100) {
            return this.f18151c.get(Math.abs(this.f18149a.nextInt() % 100) + 1);
        }
        TypeEvaluator<PointF> a11 = a(pointF, pointF2);
        this.f18151c.put(this.f18150b, a11);
        return a11;
    }
}
