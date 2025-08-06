package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import h.e;

public abstract class t implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final float f4679b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4680c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4681d;

    /* renamed from: e  reason: collision with root package name */
    public final View f4682e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f4683f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f4684g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4685h;

    /* renamed from: i  reason: collision with root package name */
    public int f4686i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f4687j = new int[2];

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ViewParent parent = t.this.f4682e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            t.this.e();
        }
    }

    public t(View view) {
        this.f4682e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f4679b = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f4680c = tapTimeout;
        this.f4681d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f11, float f12, float f13) {
        float f14 = -f13;
        return f11 >= f14 && f12 >= f14 && f11 < ((float) (view.getRight() - view.getLeft())) + f13 && f12 < ((float) (view.getBottom() - view.getTop())) + f13;
    }

    public final void a() {
        Runnable runnable = this.f4684g;
        if (runnable != null) {
            this.f4682e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f4683f;
        if (runnable2 != null) {
            this.f4682e.removeCallbacks(runnable2);
        }
    }

    public abstract e b();

    public abstract boolean c();

    public boolean d() {
        e b11 = b();
        if (b11 == null || !b11.isShowing()) {
            return true;
        }
        b11.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f4682e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f4685h = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f4682e;
        e b11 = b();
        if (b11 == null || !b11.isShowing() || (dropDownListView = (DropDownListView) b11.h()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(dropDownListView, obtainNoHistory);
        boolean e11 = dropDownListView.e(obtainNoHistory, this.f4686i);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z11 = (actionMasked == 1 || actionMasked == 3) ? false : true;
        if (!e11 || !z11) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f4682e
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f4686i
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f4679b
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f4686i = r6
            java.lang.Runnable r6 = r5.f4683f
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.t$a r6 = new androidx.appcompat.widget.t$a
            r6.<init>()
            r5.f4683f = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f4683f
            int r1 = r5.f4680c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f4684g
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.t$b r6 = new androidx.appcompat.widget.t$b
            r6.<init>()
            r5.f4684g = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f4684g
            int r1 = r5.f4681d
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f4687j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f4687j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        boolean z12 = this.f4685h;
        if (z12) {
            z11 = f(motionEvent) || !d();
        } else {
            z11 = g(motionEvent) && c();
            if (z11) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f4682e.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f4685h = z11;
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f4685h = false;
        this.f4686i = -1;
        Runnable runnable = this.f4683f;
        if (runnable != null) {
            this.f4682e.removeCallbacks(runnable);
        }
    }
}
