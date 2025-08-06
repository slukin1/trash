package androidx.test.espresso.action;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

public final class MotionEvents {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11099a = "MotionEvents";

    public static class DownResultHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MotionEvent f11100a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11101b;

        public DownResultHolder(MotionEvent motionEvent, boolean z11) {
            this.f11100a = motionEvent;
            this.f11101b = z11;
        }
    }

    public static MotionEvent a(long j11, float[] fArr, float[] fArr2) {
        return MotionEvent.obtain(j11, SystemClock.uptimeMillis(), 0, fArr[0], fArr[1], 0.0f, 1.0f, 0, fArr2[0], fArr2[1], 0, 0);
    }

    public static MotionEvent b(long j11, float[] fArr, float[] fArr2, int i11, int i12) {
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerProperties[] c11 = c(i11);
        pointerCoordsArr[0].clear();
        pointerCoordsArr[0].x = fArr[0];
        pointerCoordsArr[0].y = fArr[1];
        pointerCoordsArr[0].pressure = 0.0f;
        pointerCoordsArr[0].size = 1.0f;
        return MotionEvent.obtain(j11, SystemClock.uptimeMillis(), 0, 1, c11, pointerCoordsArr, 0, i12, fArr2[0], fArr2[1], 0, 0, i11, 0);
    }

    public static MotionEvent.PointerProperties[] c(int i11) {
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        pointerPropertiesArr[0].clear();
        pointerPropertiesArr[0].id = 0;
        if (i11 == 4098) {
            pointerPropertiesArr[0].toolType = 1;
        } else if (i11 == 8194) {
            pointerPropertiesArr[0].toolType = 3;
        } else if (i11 != 16386) {
            pointerPropertiesArr[0].toolType = 0;
        } else {
            pointerPropertiesArr[0].toolType = 2;
        }
        return pointerPropertiesArr;
    }

    public static MotionEvent d(float[] fArr, float[] fArr2) {
        return e(fArr, fArr2, 0, 1);
    }

    public static MotionEvent e(float[] fArr, float[] fArr2, int i11, int i12) {
        Preconditions.i(fArr);
        Preconditions.i(fArr2);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Build.VERSION.SDK_INT < 14) {
            return a(uptimeMillis, fArr, fArr2);
        }
        return b(uptimeMillis, fArr, fArr2, i11, i12);
    }

    public static MotionEvent f(long j11, long j12, float[] fArr) {
        return MotionEvent.obtain(j11, j12, 2, fArr[0], fArr[1], 0);
    }

    public static MotionEvent g(MotionEvent motionEvent, float[] fArr) {
        Preconditions.i(motionEvent);
        Preconditions.i(fArr);
        if (Build.VERSION.SDK_INT < 14) {
            return l(motionEvent, fArr);
        }
        return m(motionEvent, fArr);
    }

    public static void h(UiController uiController, MotionEvent motionEvent) {
        Preconditions.i(uiController);
        Preconditions.i(motionEvent);
        MotionEvent motionEvent2 = null;
        try {
            MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 3, motionEvent.getX(), motionEvent.getY(), 0);
            if (!uiController.a(obtain)) {
                Log.e(f11099a, String.format("Injection of cancel event failed (corresponding down event: %s)", new Object[]{motionEvent.toString()}));
                if (obtain != null) {
                    obtain.recycle();
                }
            } else if (obtain != null) {
                obtain.recycle();
            }
        } catch (InjectEventSecurityException e11) {
            throw new PerformException.Builder().e(String.format("inject cancel event (corresponding down event: %s)", new Object[]{motionEvent.toString()})).g("unknown").f(e11).d();
        } catch (Throwable th2) {
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            throw th2;
        }
    }

    public static DownResultHolder i(UiController uiController, float[] fArr, float[] fArr2, int i11, int i12) {
        UiController uiController2 = uiController;
        Preconditions.i(uiController);
        Preconditions.i(fArr);
        Preconditions.i(fArr2);
        int i13 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 < 3) {
                try {
                    MotionEvent e11 = e(fArr, fArr2, i11, i12);
                    long downTime = e11.getDownTime();
                    long tapTimeout = ((long) (ViewConfiguration.getTapTimeout() / 2)) + downTime;
                    boolean a11 = uiController.a(e11);
                    while (true) {
                        long uptimeMillis = tapTimeout - SystemClock.uptimeMillis();
                        if (uptimeMillis <= 10) {
                            break;
                        }
                        uiController.c(uptimeMillis / 4);
                    }
                    if (SystemClock.uptimeMillis() > downTime + ((long) ViewConfiguration.getLongPressTimeout())) {
                        Log.e(f11099a, "Overslept and turned a tap into a long press");
                    } else {
                        z11 = false;
                    }
                    if (a11) {
                        return new DownResultHolder(e11, z11);
                    }
                    e11.recycle();
                    i13++;
                } catch (InjectEventSecurityException e12) {
                    throw new PerformException.Builder().e("Send down motion event").g("unknown").f(e12).d();
                }
            } else {
                throw new PerformException.Builder().e(String.format("click (after %s attempts)", new Object[]{3})).g("unknown").d();
            }
        }
    }

    public static boolean j(UiController uiController, MotionEvent motionEvent) {
        return k(uiController, motionEvent, new float[]{motionEvent.getX(), motionEvent.getY()});
    }

    public static boolean k(UiController uiController, MotionEvent motionEvent, float[] fArr) {
        Preconditions.i(uiController);
        Preconditions.i(motionEvent);
        Preconditions.i(fArr);
        MotionEvent motionEvent2 = null;
        try {
            MotionEvent g11 = g(motionEvent, fArr);
            if (!uiController.a(g11)) {
                Log.e(f11099a, String.format("Injection of up event failed (corresponding down event: %s)", new Object[]{motionEvent.toString()}));
                if (g11 != null) {
                    g11.recycle();
                }
                return false;
            }
            if (g11 != null) {
                g11.recycle();
            }
            return true;
        } catch (InjectEventSecurityException e11) {
            throw new PerformException.Builder().e(String.format("inject up event (corresponding down event: %s)", new Object[]{motionEvent.toString()})).g("unknown").f(e11).d();
        } catch (Throwable th2) {
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            throw th2;
        }
    }

    public static MotionEvent l(MotionEvent motionEvent, float[] fArr) {
        return MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 1, fArr[0], fArr[1], 0);
    }

    public static MotionEvent m(MotionEvent motionEvent, float[] fArr) {
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerProperties[] c11 = c(motionEvent.getSource());
        pointerCoordsArr[0].clear();
        pointerCoordsArr[0].x = fArr[0];
        pointerCoordsArr[0].y = fArr[1];
        pointerCoordsArr[0].pressure = 0.0f;
        pointerCoordsArr[0].size = 1.0f;
        return MotionEvent.obtain(motionEvent.getDownTime(), SystemClock.uptimeMillis(), 1, 1, c11, pointerCoordsArr, 0, motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), 0, 0, motionEvent.getSource(), 0);
    }
}
