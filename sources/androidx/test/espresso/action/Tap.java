package androidx.test.espresso.action;

import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.MotionEvents;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.InvocationTargetException;

public enum Tap {
    SINGLE {
        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2) {
            return sendTap(uiController, fArr, fArr2, 0, 0);
        }

        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2, int i11, int i12) {
            Tapper$Status access$100 = Tap.sendSingleTap(uiController, fArr, fArr2, i11, i12);
            if (Tapper$Status.SUCCESS == access$100) {
                uiController.c((long) (((float) ViewConfiguration.getTapTimeout()) * 1.5f));
            }
            return access$100;
        }
    },
    LONG {
        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2) {
            return sendTap(uiController, fArr, fArr2, 0, 0);
        }

        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2, int i11, int i12) {
            Preconditions.i(uiController);
            Preconditions.i(fArr);
            Preconditions.i(fArr2);
            MotionEvent motionEvent = MotionEvents.i(uiController, fArr, fArr2, i11, i12).f11100a;
            try {
                uiController.c((long) (((float) ViewConfiguration.getLongPressTimeout()) * 1.5f));
                if (!MotionEvents.j(uiController, motionEvent)) {
                    MotionEvents.h(uiController, motionEvent);
                    return Tapper$Status.FAILURE;
                }
                motionEvent.recycle();
                return Tapper$Status.SUCCESS;
            } finally {
                motionEvent.recycle();
            }
        }
    },
    DOUBLE {
        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2) {
            return sendTap(uiController, fArr, fArr2, 0, 0);
        }

        public Tapper$Status sendTap(UiController uiController, float[] fArr, float[] fArr2, int i11, int i12) {
            Preconditions.i(uiController);
            Preconditions.i(fArr);
            Preconditions.i(fArr2);
            Tapper$Status access$100 = Tap.sendSingleTap(uiController, fArr, fArr2, i11, i12);
            Tapper$Status tapper$Status = Tapper$Status.FAILURE;
            if (access$100 == tapper$Status) {
                return tapper$Status;
            }
            if (Tap.DOUBLE_TAP_MIN_TIMEOUT > 0) {
                uiController.c((long) Tap.DOUBLE_TAP_MIN_TIMEOUT);
            }
            Tapper$Status access$1002 = Tap.sendSingleTap(uiController, fArr, fArr2, i11, i12);
            if (access$1002 == tapper$Status) {
                return tapper$Status;
            }
            Tapper$Status tapper$Status2 = Tapper$Status.WARNING;
            return (access$1002 == tapper$Status2 || access$100 == tapper$Status2) ? tapper$Status2 : Tapper$Status.SUCCESS;
        }
    };
    
    /* access modifiers changed from: private */
    public static final int DOUBLE_TAP_MIN_TIMEOUT = 0;
    private static final String TAG = null;

    /* access modifiers changed from: public */
    static {
        int i11;
        TAG = Tap.class.getSimpleName();
        if (Build.VERSION.SDK_INT > 18) {
            try {
                i11 = ((Integer) ViewConfiguration.class.getDeclaredMethod("getDoubleTapMinTime", new Class[0]).invoke((Object) null, new Object[0])).intValue();
            } catch (NoSuchMethodException e11) {
                Log.w(TAG, "Expected to find getDoubleTapMinTime", e11);
            } catch (InvocationTargetException e12) {
                Log.w(TAG, "Unable to query double tap min time!", e12);
            } catch (IllegalAccessException e13) {
                Log.w(TAG, "Unable to query double tap min time!", e13);
            }
        }
        DOUBLE_TAP_MIN_TIMEOUT = i11;
    }

    /* access modifiers changed from: private */
    public static Tapper$Status sendSingleTap(UiController uiController, float[] fArr, float[] fArr2, int i11, int i12) {
        Preconditions.i(uiController);
        Preconditions.i(fArr);
        Preconditions.i(fArr2);
        MotionEvents.DownResultHolder i13 = MotionEvents.i(uiController, fArr, fArr2, i11, i12);
        try {
            if (!MotionEvents.j(uiController, i13.f11100a)) {
                Log.d(TAG, "Injection of up event as part of the click failed. Send cancel event.");
                MotionEvents.h(uiController, i13.f11100a);
                return Tapper$Status.FAILURE;
            }
            i13.f11100a.recycle();
            return i13.f11101b ? Tapper$Status.WARNING : Tapper$Status.SUCCESS;
        } finally {
            i13.f11100a.recycle();
        }
    }
}
