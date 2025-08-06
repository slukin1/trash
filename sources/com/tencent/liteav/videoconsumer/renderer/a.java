package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.b.b;
import com.tencent.liteav.videobase.b.c;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.frame.i;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f22390a = ("PostProcessor_" + hashCode());

    /* renamed from: b  reason: collision with root package name */
    public final Size f22391b;

    /* renamed from: c  reason: collision with root package name */
    public final e f22392c;

    /* renamed from: d  reason: collision with root package name */
    public b f22393d;

    /* renamed from: e  reason: collision with root package name */
    public FloatBuffer f22394e;

    /* renamed from: f  reason: collision with root package name */
    public FloatBuffer f22395f;

    /* renamed from: g  reason: collision with root package name */
    public i f22396g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f22397h;

    /* renamed from: i  reason: collision with root package name */
    public List<PointF> f22398i;

    /* renamed from: j  reason: collision with root package name */
    public List<PointF> f22399j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22400k;

    public a(e eVar, int i11, int i12) {
        Size size = new Size();
        this.f22391b = size;
        this.f22400k = false;
        this.f22392c = eVar;
        size.set(i11, i12);
    }

    public final void a(List<PointF> list, List<PointF> list2) {
        if (list != null && list.size() == 4 && list2 != null && list2.size() == 4 && this.f22391b.isValid() && this.f22393d != null) {
            List<PointF> a11 = a(list);
            List<PointF> a12 = a(list2);
            b bVar = this.f22393d;
            if (a11.size() == 4 && a12.size() == 4) {
                bVar.a(c.a(bVar, a12, a11));
            }
        }
    }

    private List<PointF> a(List<PointF> list) {
        ArrayList arrayList = new ArrayList();
        for (PointF next : list) {
            float f11 = next.x;
            Size size = this.f22391b;
            PointF a11 = a(new PointF(f11 * ((float) size.width), next.y * ((float) size.height)), this.f22397h);
            float f12 = a11.x;
            Size size2 = this.f22391b;
            PointF pointF = new PointF(f12 / ((float) size2.width), a11.y / ((float) size2.height));
            pointF.y = 1.0f - pointF.y;
            arrayList.add(pointF);
        }
        return arrayList;
    }

    private static PointF a(PointF pointF, Matrix matrix) {
        if (matrix == null) {
            return pointF;
        }
        Matrix matrix2 = new Matrix();
        if (!matrix.invert(matrix2)) {
            return pointF;
        }
        float[] fArr = new float[2];
        matrix2.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        return new PointF(fArr[0], fArr[1]);
    }
}
