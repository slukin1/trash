package c30;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import uk.co.senab.photoview.Compat;

@TargetApi(5)
public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public int f60245h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f60246i = 0;

    public b(Context context) {
        super(context);
    }

    public boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i11 = 0;
        if (action == 0) {
            this.f60245h = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.f60245h = -1;
        } else if (action == 6) {
            int a11 = Compat.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a11) == this.f60245h) {
                int i12 = a11 == 0 ? 1 : 0;
                this.f60245h = motionEvent.getPointerId(i12);
                this.f60239b = motionEvent.getX(i12);
                this.f60240c = motionEvent.getY(i12);
            }
        }
        int i13 = this.f60245h;
        if (i13 != -1) {
            i11 = i13;
        }
        this.f60246i = motionEvent.findPointerIndex(i11);
        try {
            return super.b(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f60246i);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f60246i);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }
}
