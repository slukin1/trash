package o1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final float[] f16225f;

    /* renamed from: g  reason: collision with root package name */
    public static final FloatBuffer f16226g;

    /* renamed from: a  reason: collision with root package name */
    public final float[] f16227a;

    /* renamed from: b  reason: collision with root package name */
    public final FloatBuffer f16228b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16229c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16230d;

    /* renamed from: e  reason: collision with root package name */
    public c f16231e;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f16225f = fArr;
        f16226g = b(fArr);
    }

    public a(c cVar, int i11, int i12) {
        float[] fArr = new float[8];
        this.f16227a = fArr;
        this.f16228b = b(fArr);
        this.f16231e = cVar;
        this.f16229c = i11;
        this.f16230d = i12;
    }

    public static FloatBuffer b(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public void a(int i11, float[] fArr, Rect rect) {
        f(rect);
        this.f16231e.e(c.f16239h, f16226g, 0, 4, 2, 8, fArr, this.f16228b, i11, 8);
    }

    public int c() {
        return this.f16231e.d();
    }

    public void d(int i11, Bitmap bitmap) {
        this.f16231e.g(i11, bitmap);
    }

    public void e(boolean z11) {
        c cVar = this.f16231e;
        if (cVar != null) {
            if (z11) {
                cVar.h();
            }
            this.f16231e = null;
        }
    }

    public void f(Rect rect) {
        float[] fArr = this.f16227a;
        int i11 = rect.left;
        int i12 = this.f16229c;
        fArr[0] = ((float) i11) / ((float) i12);
        int i13 = rect.bottom;
        int i14 = this.f16230d;
        fArr[1] = 1.0f - (((float) i13) / ((float) i14));
        int i15 = rect.right;
        fArr[2] = ((float) i15) / ((float) i12);
        fArr[3] = 1.0f - (((float) i13) / ((float) i14));
        fArr[4] = ((float) i11) / ((float) i12);
        int i16 = rect.top;
        fArr[5] = 1.0f - (((float) i16) / ((float) i14));
        fArr[6] = ((float) i15) / ((float) i12);
        fArr[7] = 1.0f - (((float) i16) / ((float) i14));
        this.f16228b.put(fArr);
        this.f16228b.position(0);
    }
}
