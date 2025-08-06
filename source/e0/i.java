package e0;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.b;

public class i extends MeteringPointFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final PointF f15636c = new PointF(2.0f, 2.0f);

    /* renamed from: a  reason: collision with root package name */
    public final b f15637a;

    /* renamed from: b  reason: collision with root package name */
    public Matrix f15638b;

    public i(b bVar) {
        this.f15637a = bVar;
    }

    public void a(Size size, int i11) {
        Threads.checkMainThread();
        synchronized (this) {
            if (size.getWidth() != 0) {
                if (size.getHeight() != 0) {
                    this.f15638b = this.f15637a.c(size, i11);
                    return;
                }
            }
            this.f15638b = null;
        }
    }

    public PointF convertPoint(float f11, float f12) {
        float[] fArr = {f11, f12};
        synchronized (this) {
            Matrix matrix = this.f15638b;
            if (matrix == null) {
                PointF pointF = f15636c;
                return pointF;
            }
            matrix.mapPoints(fArr);
            return new PointF(fArr[0], fArr[1]);
        }
    }
}
