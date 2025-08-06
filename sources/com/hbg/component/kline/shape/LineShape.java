package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.PathEffect;
import com.hbg.component.kline.utils.PaintUtils;
import java.util.Arrays;

public class LineShape extends BaseShape {

    /* renamed from: g  reason: collision with root package name */
    public float[] f67393g;

    /* renamed from: h  reason: collision with root package name */
    public float f67394h;

    /* renamed from: i  reason: collision with root package name */
    public int f67395i;

    /* renamed from: j  reason: collision with root package name */
    public PathEffect f67396j;

    public boolean a(Object obj) {
        return obj instanceof LineShape;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LineShape)) {
            return false;
        }
        LineShape lineShape = (LineShape) obj;
        if (!lineShape.a(this) || !super.equals(obj) || !Arrays.equals(m(), lineShape.m()) || Float.compare(p(), lineShape.p()) != 0 || o() != lineShape.o()) {
            return false;
        }
        PathEffect n11 = n();
        PathEffect n12 = lineShape.n();
        return n11 != null ? n11.equals(n12) : n12 == null;
    }

    public int hashCode() {
        int hashCode = (((((super.hashCode() * 59) + Arrays.hashCode(m())) * 59) + Float.floatToIntBits(p())) * 59) + o();
        PathEffect n11 = n();
        return (hashCode * 59) + (n11 == null ? 43 : n11.hashCode());
    }

    public void l(Canvas canvas) {
        float[] fArr = this.f67393g;
        if (fArr != null && fArr.length % 2 == 0) {
            PaintUtils.e(this.f67335a, this.f67395i, this.f67394h, this.f67396j);
            canvas.drawLines(this.f67393g, this.f67335a);
        }
    }

    public float[] m() {
        return this.f67393g;
    }

    public PathEffect n() {
        return this.f67396j;
    }

    public int o() {
        return this.f67395i;
    }

    public float p() {
        return this.f67394h;
    }

    public void q(float[] fArr) {
        this.f67393g = fArr;
    }

    public void r(PathEffect pathEffect) {
        this.f67396j = pathEffect;
    }

    public void s(int i11) {
        this.f67395i = i11;
    }

    public void t(float f11) {
        this.f67394h = f11;
    }

    public String toString() {
        return "LineShape(lines=" + Arrays.toString(m()) + ", strokeWidth=" + p() + ", strokeColor=" + o() + ", pathEffect=" + n() + ")";
    }
}
