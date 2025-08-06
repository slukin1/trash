package c30;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class c extends b {

    /* renamed from: j  reason: collision with root package name */
    public final ScaleGestureDetector f60247j;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.f60238a.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public c(Context context) {
        super(context);
        this.f60247j = new ScaleGestureDetector(context, new a());
    }

    public boolean b(MotionEvent motionEvent) {
        try {
            this.f60247j.onTouchEvent(motionEvent);
            return super.b(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean c() {
        return this.f60247j.isInProgress();
    }
}
