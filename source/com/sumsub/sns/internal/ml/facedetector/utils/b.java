package com.sumsub.sns.internal.ml.facedetector.utils;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Size;
import com.sumsub.sns.internal.ml.facedetector.models.a;
import com.sumsub.sns.internal.ml.facedetector.models.c;
import com.sumsub.sns.internal.ml.facedetector.models.f;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final int b(c cVar, c cVar2) {
        return Float.compare(cVar2.c(), cVar.c());
    }

    public final List<c> a(Size size, f fVar, float[][][] fArr, float[][][] fArr2, List<a> list) {
        float[][][] fArr3 = fArr;
        float[][][] fArr4 = fArr2;
        boolean z11 = true;
        if (fArr4.length == 1 && fArr4[0].length == fVar.f() && fArr4[0][0].length == fVar.h()) {
            if (fArr3.length == 1 && fArr3[0].length == fVar.f() && fArr3[0][0].length == fVar.g()) {
                if (fVar.d() == 0 || fVar.d() < -1) {
                    z11 = false;
                }
                if (z11) {
                    ArrayList arrayList = new ArrayList(fVar.f());
                    int f11 = fVar.f();
                    for (int i11 = 0; i11 < f11; i11++) {
                        float f12 = Float.MIN_VALUE;
                        float f13 = fArr3[0][i11][0];
                        if (fVar.k() > 0.0d) {
                            if (((double) f13) < (-fVar.k())) {
                                f13 = -((float) fVar.k());
                            }
                            if (((double) f13) > fVar.k()) {
                                f13 = (float) fVar.k();
                            }
                            float exp = 1.0f / (((float) Math.exp(-((double) f13))) + 1.0f);
                            if (exp > Float.MIN_VALUE) {
                                f12 = exp;
                            }
                        }
                        arrayList.add(Float.valueOf(f12));
                    }
                    List<c> a11 = a(a(fVar, fArr4, (List<Float>) arrayList, list), fVar.b());
                    if (fVar.d() != -1) {
                        a11 = a(a11, fVar.d());
                    }
                    Size size2 = size;
                    return a(a11, size);
                }
                throw new IllegalArgumentException("MaxNumberOfFaces must be greater than 0 or -1".toString());
            }
            throw new IllegalArgumentException("RawScores dimensions is not correct".toString());
        }
        throw new IllegalArgumentException("RawBoxes dimensions is not correct".toString());
    }

    public final List<c> a(f fVar, float[][][] fArr, List<Float> list, List<a> list2) {
        ArrayList arrayList = new ArrayList();
        int f11 = fVar.f();
        for (int i11 = 0; i11 < f11; i11++) {
            if (((double) list.get(i11).floatValue()) >= fVar.e()) {
                arrayList.add(a(a(fArr[0], i11, list2, fVar), list.get(i11).floatValue()));
            }
        }
        return arrayList;
    }

    public final float[] a(float[][] fArr, int i11, List<a> list, f fVar) {
        float[] fArr2 = new float[fVar.h()];
        float[] fArr3 = fArr[i11];
        float f11 = fArr3[0];
        float f12 = fArr3[1];
        float f13 = fArr3[2];
        float f14 = fArr3[3];
        float m11 = ((f11 / fVar.m()) * list.get(i11).b()) + list.get(i11).c();
        float n11 = ((f12 / fVar.n()) * list.get(i11).a()) + list.get(i11).d();
        float a11 = (f14 / fVar.a()) * list.get(i11).a();
        float f15 = (float) 2;
        float f16 = a11 / f15;
        float l11 = ((f13 / fVar.l()) * list.get(i11).b()) / f15;
        fArr2[0] = n11 - f16;
        fArr2[1] = m11 - l11;
        fArr2[2] = n11 + f16;
        fArr2[3] = m11 + l11;
        if (fVar.i() > 0) {
            int i12 = fVar.i();
            for (int i13 = 0; i13 < i12; i13++) {
                int c11 = fVar.c() + (fVar.j() * i13);
                float[] fArr4 = fArr[i11];
                float f17 = fArr4[c11];
                float f18 = fArr4[c11 + 1];
                fArr2[(fVar.j() * i13) + 4] = ((f17 / fVar.m()) * list.get(i11).b()) + list.get(i11).c();
                fArr2[(fVar.j() * i13) + 4 + 1] = ((f18 / fVar.n()) * list.get(i11).a()) + list.get(i11).d();
            }
        }
        return fArr2;
    }

    public final c a(float[] fArr, float f11) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 4; i11 < fArr.length - 1; i11 += 2) {
            arrayList.add(new PointF(fArr[i11], fArr[i11 + 1]));
        }
        return new c(f11, new RectF(fArr[1], fArr[0], fArr[3], fArr[2]), arrayList);
    }

    public final List<c> a(List<c> list, float f11) {
        List<c> list2 = list;
        if (list.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<c> arrayList3 = new ArrayList<>();
        CollectionsKt__MutableCollectionsJVMKt.z(list2, d.f35131b);
        while (true) {
            if (!(!list.isEmpty())) {
                break;
            }
            int size = list.size();
            arrayList3.clear();
            arrayList2.clear();
            int i11 = 0;
            c cVar = list2.get(0);
            for (c next : list) {
                if (a(next.a(), cVar.a()) > f11) {
                    arrayList3.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            if (!arrayList3.isEmpty()) {
                float f12 = 0.0f;
                RectF rectF = new RectF();
                ArrayList arrayList4 = new ArrayList(cVar.b().size());
                int size2 = cVar.b().size();
                for (int i12 = 0; i12 < size2; i12++) {
                    arrayList4.add(new PointF());
                }
                for (c cVar2 : arrayList3) {
                    f12 += cVar2.c();
                    rectF.top += cVar2.a().top * cVar2.c();
                    rectF.bottom += cVar2.a().bottom * cVar2.c();
                    rectF.left += cVar2.a().left * cVar2.c();
                    rectF.right += cVar2.a().right * cVar2.c();
                    int size3 = arrayList4.size();
                    int i13 = i11;
                    while (i13 < size3) {
                        ((PointF) arrayList4.get(i13)).x += cVar2.b().get(i13).x * cVar2.c();
                        ((PointF) arrayList4.get(i13)).y += cVar2.b().get(i13).y * cVar2.c();
                        i13++;
                        i11 = 0;
                    }
                }
                rectF.top /= f12;
                rectF.bottom /= f12;
                rectF.left /= f12;
                rectF.right /= f12;
                int size4 = arrayList4.size();
                for (int i14 = 0; i14 < size4; i14++) {
                    ((PointF) arrayList4.get(i14)).x /= f12;
                    ((PointF) arrayList4.get(i14)).y /= f12;
                }
                cVar = new c(f12 / ((float) arrayList3.size()), rectF, arrayList4);
            }
            arrayList.add(cVar);
            if (size == arrayList2.size()) {
                break;
            }
            list.clear();
            list2.addAll(arrayList2);
        }
        return arrayList;
    }

    public final float a(RectF rectF, RectF rectF2) {
        float max = Math.max(rectF.left, rectF2.left);
        float max2 = Math.max(0.0f, Math.min(rectF.bottom, rectF2.bottom) - Math.max(rectF.top, rectF2.top)) * Math.max(0.0f, Math.min(rectF.right, rectF2.right) - max);
        return max2 / ((a(rectF) + a(rectF2)) - max2);
    }

    public final float a(RectF rectF) {
        return (rectF.right - rectF.left) * (rectF.bottom - rectF.top);
    }

    public final List<c> a(List<c> list, int i11) {
        if (list.size() == 0) {
            return list;
        }
        CollectionsKt__MutableCollectionsJVMKt.z(list, c.f35130b);
        return list.subList(0, Math.min(i11, list.size()));
    }

    public static final int a(c cVar, c cVar2) {
        return Float.compare(cVar2.c(), cVar.c());
    }

    public final List<c> a(List<c> list, Size size) {
        float f11;
        float f12;
        if (size.getWidth() == size.getHeight()) {
            return list;
        }
        float f13 = 0.0f;
        float f14 = 1.0f;
        if (size.getWidth() < size.getHeight()) {
            f12 = (1.0f - (((float) size.getWidth()) / ((float) size.getHeight()))) / 2.0f;
            f14 = ((float) size.getHeight()) / ((float) size.getWidth());
            f11 = 1.0f;
        } else {
            f11 = ((float) size.getWidth()) / ((float) size.getHeight());
            f13 = (1.0f - (((float) size.getHeight()) / ((float) size.getWidth()))) / 2.0f;
            f12 = 0.0f;
        }
        for (c next : list) {
            next.a().left -= f12;
            next.a().left *= f14;
            next.a().right -= f12;
            next.a().right *= f14;
            next.a().top -= f13;
            next.a().top *= f11;
            next.a().bottom -= f13;
            next.a().bottom *= f11;
            int size2 = next.b().size();
            for (int i11 = 0; i11 < size2; i11++) {
                next.b().get(i11).x -= f12;
                next.b().get(i11).x *= f14;
                next.b().get(i11).y -= f13;
                next.b().get(i11).y *= f11;
            }
        }
        return list;
    }
}
