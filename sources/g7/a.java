package g7;

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<View>> f70077a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f70078b = new Object();

    public static void a(View view) {
        if (view != null) {
            synchronized (f70078b) {
                f70077a.add(new WeakReference(view));
            }
        }
    }

    public static View b() {
        if (f70077a.isEmpty()) {
            return null;
        }
        List<WeakReference<View>> list = f70077a;
        WeakReference weakReference = list.get(list.size() - 1);
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public static void c(View view) {
        synchronized (f70078b) {
            Iterator<WeakReference<View>> it2 = f70077a.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                if (!(next == null || next.get() == null || next.get() != view)) {
                    it2.remove();
                }
            }
        }
    }

    public static boolean d(MotionEvent motionEvent) {
        View b11 = b();
        if (b11 == null) {
            return false;
        }
        int[] iArr = new int[2];
        b11.getLocationOnScreen(iArr);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(obtain.getX() - ((float) iArr[0]), obtain.getY() - ((float) iArr[1]));
        return b11.dispatchTouchEvent(obtain);
    }
}
