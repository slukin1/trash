package androidx.core.view;

import android.view.MotionEvent;

public final class n {
    @Deprecated
    public static int a(MotionEvent motionEvent, int i11) {
        return motionEvent.findPointerIndex(i11);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    @Deprecated
    public static int d(MotionEvent motionEvent, int i11) {
        return motionEvent.getPointerId(i11);
    }

    @Deprecated
    public static float e(MotionEvent motionEvent, int i11) {
        return motionEvent.getX(i11);
    }

    @Deprecated
    public static float f(MotionEvent motionEvent, int i11) {
        return motionEvent.getY(i11);
    }

    public static boolean g(MotionEvent motionEvent, int i11) {
        return (motionEvent.getSource() & i11) == i11;
    }
}
