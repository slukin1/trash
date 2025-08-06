package v1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

public class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    public final Property<T, PointF> f16649a;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f16650b;

    /* renamed from: c  reason: collision with root package name */
    public final float f16651c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f16652d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    public final PointF f16653e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    public float f16654f;

    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f16649a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f16650b = pathMeasure;
        this.f16651c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(T t11) {
        return Float.valueOf(this.f16654f);
    }

    /* renamed from: b */
    public void set(T t11, Float f11) {
        this.f16654f = f11.floatValue();
        this.f16650b.getPosTan(this.f16651c * f11.floatValue(), this.f16652d, (float[]) null);
        PointF pointF = this.f16653e;
        float[] fArr = this.f16652d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f16649a.set(t11, pointF);
    }
}
