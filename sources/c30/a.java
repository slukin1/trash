package c30;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import uk.co.senab.photoview.log.LogManager;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public e f60238a;

    /* renamed from: b  reason: collision with root package name */
    public float f60239b;

    /* renamed from: c  reason: collision with root package name */
    public float f60240c;

    /* renamed from: d  reason: collision with root package name */
    public final float f60241d;

    /* renamed from: e  reason: collision with root package name */
    public final float f60242e;

    /* renamed from: f  reason: collision with root package name */
    public VelocityTracker f60243f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60244g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f60242e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f60241d = (float) viewConfiguration.getScaledTouchSlop();
    }

    public boolean a() {
        return this.f60244g;
    }

    public boolean b(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        boolean z11 = false;
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f60243f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                LogManager.a().i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.f60239b = e(motionEvent);
            this.f60240c = f(motionEvent);
            this.f60244g = false;
        } else if (action == 1) {
            if (this.f60244g && this.f60243f != null) {
                this.f60239b = e(motionEvent);
                this.f60240c = f(motionEvent);
                this.f60243f.addMovement(motionEvent);
                this.f60243f.computeCurrentVelocity(1000);
                float xVelocity = this.f60243f.getXVelocity();
                float yVelocity = this.f60243f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f60242e) {
                    this.f60238a.onFling(this.f60239b, this.f60240c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f60243f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f60243f = null;
            }
        } else if (action == 2) {
            float e11 = e(motionEvent);
            float f11 = f(motionEvent);
            float f12 = e11 - this.f60239b;
            float f13 = f11 - this.f60240c;
            if (!this.f60244g) {
                if (Math.sqrt((double) ((f12 * f12) + (f13 * f13))) >= ((double) this.f60241d)) {
                    z11 = true;
                }
                this.f60244g = z11;
            }
            if (this.f60244g) {
                this.f60238a.onDrag(f12, f13);
                this.f60239b = e11;
                this.f60240c = f11;
                VelocityTracker velocityTracker3 = this.f60243f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f60243f) != null) {
            velocityTracker.recycle();
            this.f60243f = null;
        }
        return true;
    }

    public boolean c() {
        return false;
    }

    public void d(e eVar) {
        this.f60238a = eVar;
    }

    public float e(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float f(MotionEvent motionEvent) {
        return motionEvent.getY();
    }
}
