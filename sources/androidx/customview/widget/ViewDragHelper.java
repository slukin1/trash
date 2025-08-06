package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.h0;
import com.youth.banner.config.BannerConfig;
import java.util.Arrays;

public class ViewDragHelper {

    /* renamed from: x  reason: collision with root package name */
    public static final Interpolator f8824x = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f8825a;

    /* renamed from: b  reason: collision with root package name */
    public int f8826b;

    /* renamed from: c  reason: collision with root package name */
    public int f8827c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float[] f8828d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f8829e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f8830f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f8831g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f8832h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f8833i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f8834j;

    /* renamed from: k  reason: collision with root package name */
    public int f8835k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f8836l;

    /* renamed from: m  reason: collision with root package name */
    public float f8837m;

    /* renamed from: n  reason: collision with root package name */
    public float f8838n;

    /* renamed from: o  reason: collision with root package name */
    public int f8839o;

    /* renamed from: p  reason: collision with root package name */
    public final int f8840p;

    /* renamed from: q  reason: collision with root package name */
    public int f8841q;

    /* renamed from: r  reason: collision with root package name */
    public OverScroller f8842r;

    /* renamed from: s  reason: collision with root package name */
    public final Callback f8843s;

    /* renamed from: t  reason: collision with root package name */
    public View f8844t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f8845u;

    /* renamed from: v  reason: collision with root package name */
    public final ViewGroup f8846v;

    /* renamed from: w  reason: collision with root package name */
    public final Runnable f8847w = new b();

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return 0;
        }

        public int getOrderedChildIndex(int i11) {
            return i11;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i11, int i12) {
        }

        public boolean onEdgeLock(int i11) {
            return false;
        }

        public void onEdgeTouched(int i11, int i12) {
        }

        public void onViewCaptured(View view, int i11) {
        }

        public void onViewDragStateChanged(int i11) {
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
        }

        public void onViewReleased(View view, float f11, float f12) {
        }

        public abstract boolean tryCaptureView(View view, int i11);
    }

    public class a implements Interpolator {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ViewDragHelper.this.M(0);
        }
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f8846v = viewGroup;
            this.f8843s = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i11 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f8840p = i11;
            this.f8839o = i11;
            this.f8826b = viewConfiguration.getScaledTouchSlop();
            this.f8837m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f8838n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f8842r = new OverScroller(context, f8824x);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public static ViewDragHelper o(ViewGroup viewGroup, float f11, Callback callback) {
        ViewDragHelper p11 = p(viewGroup, callback);
        p11.f8826b = (int) (((float) p11.f8826b) * (1.0f / f11));
        return p11;
    }

    public static ViewDragHelper p(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public float A() {
        return this.f8838n;
    }

    public int B() {
        return this.f8826b;
    }

    public int C() {
        return this.f8825a;
    }

    public boolean D(int i11, int i12) {
        return G(this.f8844t, i11, i12);
    }

    public boolean E(int i11) {
        return ((1 << i11) & this.f8835k) != 0;
    }

    public final boolean F(int i11) {
        if (E(i11)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i11 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean G(View view, int i11, int i12) {
        if (view != null && i11 >= view.getLeft() && i11 < view.getRight() && i12 >= view.getTop() && i12 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public void H(MotionEvent motionEvent) {
        int i11;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f8836l == null) {
            this.f8836l = VelocityTracker.obtain();
        }
        this.f8836l.addMovement(motionEvent);
        int i12 = 0;
        if (actionMasked == 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View u11 = u((int) x11, (int) y11);
            K(x11, y11, pointerId);
            T(u11, pointerId);
            int i13 = this.f8832h[pointerId];
            int i14 = this.f8841q;
            if ((i13 & i14) != 0) {
                this.f8843s.onEdgeTouched(i13 & i14, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f8825a == 1) {
                I();
            }
            b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f8825a == 1) {
                    q(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x12 = motionEvent.getX(actionIndex);
                float y12 = motionEvent.getY(actionIndex);
                K(x12, y12, pointerId2);
                if (this.f8825a == 0) {
                    T(u((int) x12, (int) y12), pointerId2);
                    int i15 = this.f8832h[pointerId2];
                    int i16 = this.f8841q;
                    if ((i15 & i16) != 0) {
                        this.f8843s.onEdgeTouched(i15 & i16, pointerId2);
                    }
                } else if (D((int) x12, (int) y12)) {
                    T(this.f8844t, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f8825a == 1 && pointerId3 == this.f8827c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i12 >= pointerCount) {
                            i11 = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i12);
                        if (pointerId4 != this.f8827c) {
                            View u12 = u((int) motionEvent.getX(i12), (int) motionEvent.getY(i12));
                            View view = this.f8844t;
                            if (u12 == view && T(view, pointerId4)) {
                                i11 = this.f8827c;
                                break;
                            }
                        }
                        i12++;
                    }
                    if (i11 == -1) {
                        I();
                    }
                }
                k(pointerId3);
            }
        } else if (this.f8825a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i12 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i12);
                if (F(pointerId5)) {
                    float x13 = motionEvent.getX(i12);
                    float y13 = motionEvent.getY(i12);
                    float f11 = x13 - this.f8828d[pointerId5];
                    float f12 = y13 - this.f8829e[pointerId5];
                    J(f11, f12, pointerId5);
                    if (this.f8825a != 1) {
                        View u13 = u((int) x13, (int) y13);
                        if (g(u13, f11, f12) && T(u13, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i12++;
            }
            L(motionEvent);
        } else if (F(this.f8827c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f8827c);
            float x14 = motionEvent.getX(findPointerIndex);
            float y14 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f8830f;
            int i17 = this.f8827c;
            int i18 = (int) (x14 - fArr[i17]);
            int i19 = (int) (y14 - this.f8831g[i17]);
            s(this.f8844t.getLeft() + i18, this.f8844t.getTop() + i19, i18, i19);
            L(motionEvent);
        }
    }

    public final void I() {
        this.f8836l.computeCurrentVelocity(1000, this.f8837m);
        q(h(this.f8836l.getXVelocity(this.f8827c), this.f8838n, this.f8837m), h(this.f8836l.getYVelocity(this.f8827c), this.f8838n, this.f8837m));
    }

    public final void J(float f11, float f12, int i11) {
        boolean d11 = d(f11, f12, i11, 1);
        if (d(f12, f11, i11, 4)) {
            d11 |= true;
        }
        if (d(f11, f12, i11, 2)) {
            d11 |= true;
        }
        if (d(f12, f11, i11, 8)) {
            d11 |= true;
        }
        if (d11) {
            int[] iArr = this.f8833i;
            iArr[i11] = iArr[i11] | d11;
            this.f8843s.onEdgeDragStarted(d11 ? 1 : 0, i11);
        }
    }

    public final void K(float f11, float f12, int i11) {
        t(i11);
        float[] fArr = this.f8828d;
        this.f8830f[i11] = f11;
        fArr[i11] = f11;
        float[] fArr2 = this.f8829e;
        this.f8831g[i11] = f12;
        fArr2[i11] = f12;
        this.f8832h[i11] = z((int) f11, (int) f12);
        this.f8835k |= 1 << i11;
    }

    public final void L(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i11 = 0; i11 < pointerCount; i11++) {
            int pointerId = motionEvent.getPointerId(i11);
            if (F(pointerId)) {
                float x11 = motionEvent.getX(i11);
                float y11 = motionEvent.getY(i11);
                this.f8830f[pointerId] = x11;
                this.f8831g[pointerId] = y11;
            }
        }
    }

    public void M(int i11) {
        this.f8846v.removeCallbacks(this.f8847w);
        if (this.f8825a != i11) {
            this.f8825a = i11;
            this.f8843s.onViewDragStateChanged(i11);
            if (this.f8825a == 0) {
                this.f8844t = null;
            }
        }
    }

    public void N(int i11) {
        this.f8839o = i11;
    }

    public void O(int i11) {
        this.f8841q = i11;
    }

    public void P(float f11) {
        this.f8838n = f11;
    }

    public boolean Q(int i11, int i12) {
        if (this.f8845u) {
            return v(i11, i12, (int) this.f8836l.getXVelocity(this.f8827c), (int) this.f8836l.getYVelocity(this.f8827c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean R(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f8836l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f8836l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f8836l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.k(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.K(r7, r1, r2)
            int r3 = r0.f8825a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f8832h
            r1 = r1[r2]
            int r3 = r0.f8841q
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f8843s
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.u(r3, r1)
            android.view.View r3 = r0.f8844t
            if (r1 != r3) goto L_0x0031
            r0.T(r1, r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f8828d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f8829e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.F(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f8828d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f8829e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.u(r7, r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.g(r7, r9, r10)
            if (r8 == 0) goto L_0x00b0
            r8 = r6
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f8843s
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.widget.ViewDragHelper$Callback r5 = r0.f8843s
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.customview.widget.ViewDragHelper$Callback r14 = r0.f8843s
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.customview.widget.ViewDragHelper$Callback r15 = r0.f8843s
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.J(r9, r10, r4)
            int r5 = r0.f8825a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.T(r7, r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.L(r17)
            goto L_0x0031
        L_0x00ff:
            r16.b()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.K(r2, r3, r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.u(r2, r3)
            android.view.View r3 = r0.f8844t
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f8825a
            if (r3 != r4) goto L_0x0125
            r0.T(r2, r1)
        L_0x0125:
            int[] r2 = r0.f8832h
            r2 = r2[r1]
            int r3 = r0.f8841q
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.widget.ViewDragHelper$Callback r4 = r0.f8843s
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0135:
            int r1 = r0.f8825a
            if (r1 != r6) goto L_0x013a
            r5 = r6
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.R(android.view.MotionEvent):boolean");
    }

    public boolean S(View view, int i11, int i12) {
        this.f8844t = view;
        this.f8827c = -1;
        boolean v11 = v(i11, i12, 0, 0);
        if (!v11 && this.f8825a == 0 && this.f8844t != null) {
            this.f8844t = null;
        }
        return v11;
    }

    public boolean T(View view, int i11) {
        if (view == this.f8844t && this.f8827c == i11) {
            return true;
        }
        if (view == null || !this.f8843s.tryCaptureView(view, i11)) {
            return false;
        }
        this.f8827c = i11;
        c(view, i11);
        return true;
    }

    public void a() {
        b();
        if (this.f8825a == 2) {
            int currX = this.f8842r.getCurrX();
            int currY = this.f8842r.getCurrY();
            this.f8842r.abortAnimation();
            int currX2 = this.f8842r.getCurrX();
            int currY2 = this.f8842r.getCurrY();
            this.f8843s.onViewPositionChanged(this.f8844t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        M(0);
    }

    public void b() {
        this.f8827c = -1;
        j();
        VelocityTracker velocityTracker = this.f8836l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8836l = null;
        }
    }

    public void c(View view, int i11) {
        if (view.getParent() == this.f8846v) {
            this.f8844t = view;
            this.f8827c = i11;
            this.f8843s.onViewCaptured(view, i11);
            M(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f8846v + ")");
    }

    public final boolean d(float f11, float f12, int i11, int i12) {
        float abs = Math.abs(f11);
        float abs2 = Math.abs(f12);
        if ((this.f8832h[i11] & i12) != i12 || (this.f8841q & i12) == 0 || (this.f8834j[i11] & i12) == i12 || (this.f8833i[i11] & i12) == i12) {
            return false;
        }
        int i13 = this.f8826b;
        if (abs <= ((float) i13) && abs2 <= ((float) i13)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f8843s.onEdgeLock(i12)) {
            int[] iArr = this.f8834j;
            iArr[i11] = iArr[i11] | i12;
            return false;
        } else if ((this.f8833i[i11] & i12) != 0 || abs <= ((float) this.f8826b)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean e(int i11) {
        int length = this.f8828d.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (f(i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i11, int i12) {
        if (!E(i12)) {
            return false;
        }
        boolean z11 = (i11 & 1) == 1;
        boolean z12 = (i11 & 2) == 2;
        float f11 = this.f8830f[i12] - this.f8828d[i12];
        float f12 = this.f8831g[i12] - this.f8829e[i12];
        if (z11 && z12) {
            int i13 = this.f8826b;
            if ((f11 * f11) + (f12 * f12) > ((float) (i13 * i13))) {
                return true;
            }
            return false;
        } else if (z11) {
            if (Math.abs(f11) > ((float) this.f8826b)) {
                return true;
            }
            return false;
        } else if (!z12 || Math.abs(f12) <= ((float) this.f8826b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean g(View view, float f11, float f12) {
        if (view == null) {
            return false;
        }
        boolean z11 = this.f8843s.getViewHorizontalDragRange(view) > 0;
        boolean z12 = this.f8843s.getViewVerticalDragRange(view) > 0;
        if (z11 && z12) {
            int i11 = this.f8826b;
            if ((f11 * f11) + (f12 * f12) > ((float) (i11 * i11))) {
                return true;
            }
            return false;
        } else if (z11) {
            if (Math.abs(f11) > ((float) this.f8826b)) {
                return true;
            }
            return false;
        } else if (!z12 || Math.abs(f12) <= ((float) this.f8826b)) {
            return false;
        } else {
            return true;
        }
    }

    public final float h(float f11, float f12, float f13) {
        float abs = Math.abs(f11);
        if (abs < f12) {
            return 0.0f;
        }
        if (abs > f13) {
            return f11 > 0.0f ? f13 : -f13;
        }
        return f11;
    }

    public final int i(int i11, int i12, int i13) {
        int abs = Math.abs(i11);
        if (abs < i12) {
            return 0;
        }
        if (abs > i13) {
            return i11 > 0 ? i13 : -i13;
        }
        return i11;
    }

    public final void j() {
        float[] fArr = this.f8828d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f8829e, 0.0f);
            Arrays.fill(this.f8830f, 0.0f);
            Arrays.fill(this.f8831g, 0.0f);
            Arrays.fill(this.f8832h, 0);
            Arrays.fill(this.f8833i, 0);
            Arrays.fill(this.f8834j, 0);
            this.f8835k = 0;
        }
    }

    public final void k(int i11) {
        if (this.f8828d != null && E(i11)) {
            this.f8828d[i11] = 0.0f;
            this.f8829e[i11] = 0.0f;
            this.f8830f[i11] = 0.0f;
            this.f8831g[i11] = 0.0f;
            this.f8832h[i11] = 0;
            this.f8833i[i11] = 0;
            this.f8834j[i11] = 0;
            this.f8835k = (~(1 << i11)) & this.f8835k;
        }
    }

    public final int l(int i11, int i12, int i13) {
        int i14;
        if (i11 == 0) {
            return 0;
        }
        int width = this.f8846v.getWidth();
        float f11 = (float) (width / 2);
        float r11 = f11 + (r(Math.min(1.0f, ((float) Math.abs(i11)) / ((float) width))) * f11);
        int abs = Math.abs(i12);
        if (abs > 0) {
            i14 = Math.round(Math.abs(r11 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i14 = (int) (((((float) Math.abs(i11)) / ((float) i13)) + 1.0f) * 256.0f);
        }
        return Math.min(i14, BannerConfig.SCROLL_TIME);
    }

    public final int m(View view, int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float f13;
        float f14;
        int i15 = i(i13, (int) this.f8838n, (int) this.f8837m);
        int i16 = i(i14, (int) this.f8838n, (int) this.f8837m);
        int abs = Math.abs(i11);
        int abs2 = Math.abs(i12);
        int abs3 = Math.abs(i15);
        int abs4 = Math.abs(i16);
        int i17 = abs3 + abs4;
        int i18 = abs + abs2;
        if (i15 != 0) {
            f12 = (float) abs3;
            f11 = (float) i17;
        } else {
            f12 = (float) abs;
            f11 = (float) i18;
        }
        float f15 = f12 / f11;
        if (i16 != 0) {
            f14 = (float) abs4;
            f13 = (float) i17;
        } else {
            f14 = (float) abs2;
            f13 = (float) i18;
        }
        float f16 = f14 / f13;
        return (int) ((((float) l(i11, i15, this.f8843s.getViewHorizontalDragRange(view))) * f15) + (((float) l(i12, i16, this.f8843s.getViewVerticalDragRange(view))) * f16));
    }

    public boolean n(boolean z11) {
        if (this.f8825a == 2) {
            boolean computeScrollOffset = this.f8842r.computeScrollOffset();
            int currX = this.f8842r.getCurrX();
            int currY = this.f8842r.getCurrY();
            int left = currX - this.f8844t.getLeft();
            int top = currY - this.f8844t.getTop();
            if (left != 0) {
                h0.g0(this.f8844t, left);
            }
            if (top != 0) {
                h0.h0(this.f8844t, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f8843s.onViewPositionChanged(this.f8844t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f8842r.getFinalX() && currY == this.f8842r.getFinalY()) {
                this.f8842r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z11) {
                    this.f8846v.post(this.f8847w);
                } else {
                    M(0);
                }
            }
        }
        if (this.f8825a == 2) {
            return true;
        }
        return false;
    }

    public final void q(float f11, float f12) {
        this.f8845u = true;
        this.f8843s.onViewReleased(this.f8844t, f11, f12);
        this.f8845u = false;
        if (this.f8825a == 1) {
            M(0);
        }
    }

    public final float r(float f11) {
        return (float) Math.sin((double) ((f11 - 0.5f) * 0.47123894f));
    }

    public final void s(int i11, int i12, int i13, int i14) {
        int left = this.f8844t.getLeft();
        int top = this.f8844t.getTop();
        if (i13 != 0) {
            i11 = this.f8843s.clampViewPositionHorizontal(this.f8844t, i11, i13);
            h0.g0(this.f8844t, i11 - left);
        }
        int i15 = i11;
        if (i14 != 0) {
            i12 = this.f8843s.clampViewPositionVertical(this.f8844t, i12, i14);
            h0.h0(this.f8844t, i12 - top);
        }
        int i16 = i12;
        if (i13 != 0 || i14 != 0) {
            this.f8843s.onViewPositionChanged(this.f8844t, i15, i16, i15 - left, i16 - top);
        }
    }

    public final void t(int i11) {
        float[] fArr = this.f8828d;
        if (fArr == null || fArr.length <= i11) {
            int i12 = i11 + 1;
            float[] fArr2 = new float[i12];
            float[] fArr3 = new float[i12];
            float[] fArr4 = new float[i12];
            float[] fArr5 = new float[i12];
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int[] iArr3 = new int[i12];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f8829e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f8830f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f8831g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f8832h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f8833i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f8834j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f8828d = fArr2;
            this.f8829e = fArr3;
            this.f8830f = fArr4;
            this.f8831g = fArr5;
            this.f8832h = iArr;
            this.f8833i = iArr2;
            this.f8834j = iArr3;
        }
    }

    public View u(int i11, int i12) {
        for (int childCount = this.f8846v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f8846v.getChildAt(this.f8843s.getOrderedChildIndex(childCount));
            if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && i12 >= childAt.getTop() && i12 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean v(int i11, int i12, int i13, int i14) {
        int left = this.f8844t.getLeft();
        int top = this.f8844t.getTop();
        int i15 = i11 - left;
        int i16 = i12 - top;
        if (i15 == 0 && i16 == 0) {
            this.f8842r.abortAnimation();
            M(0);
            return false;
        }
        this.f8842r.startScroll(left, top, i15, i16, m(this.f8844t, i15, i16, i13, i14));
        M(2);
        return true;
    }

    public View w() {
        return this.f8844t;
    }

    public int x() {
        return this.f8840p;
    }

    public int y() {
        return this.f8839o;
    }

    public final int z(int i11, int i12) {
        int i13 = i11 < this.f8846v.getLeft() + this.f8839o ? 1 : 0;
        if (i12 < this.f8846v.getTop() + this.f8839o) {
            i13 |= 4;
        }
        if (i11 > this.f8846v.getRight() - this.f8839o) {
            i13 |= 2;
        }
        return i12 > this.f8846v.getBottom() - this.f8839o ? i13 | 8 : i13;
    }
}
