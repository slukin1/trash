package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final a f8589a;

    public interface a {
        boolean b(MotionEvent motionEvent);
    }

    public static class b implements a {

        /* renamed from: v  reason: collision with root package name */
        public static final int f8590v = ViewConfiguration.getTapTimeout();

        /* renamed from: w  reason: collision with root package name */
        public static final int f8591w = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        public int f8592a;

        /* renamed from: b  reason: collision with root package name */
        public int f8593b;

        /* renamed from: c  reason: collision with root package name */
        public int f8594c;

        /* renamed from: d  reason: collision with root package name */
        public int f8595d;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f8596e;

        /* renamed from: f  reason: collision with root package name */
        public final GestureDetector.OnGestureListener f8597f;

        /* renamed from: g  reason: collision with root package name */
        public GestureDetector.OnDoubleTapListener f8598g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8599h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8600i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f8601j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f8602k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f8603l;

        /* renamed from: m  reason: collision with root package name */
        public MotionEvent f8604m;

        /* renamed from: n  reason: collision with root package name */
        public MotionEvent f8605n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f8606o;

        /* renamed from: p  reason: collision with root package name */
        public float f8607p;

        /* renamed from: q  reason: collision with root package name */
        public float f8608q;

        /* renamed from: r  reason: collision with root package name */
        public float f8609r;

        /* renamed from: s  reason: collision with root package name */
        public float f8610s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f8611t;

        /* renamed from: u  reason: collision with root package name */
        public VelocityTracker f8612u;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f8596e = new a(handler);
            } else {
                this.f8596e = new a();
            }
            this.f8597f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        public final void a() {
            this.f8596e.removeMessages(1);
            this.f8596e.removeMessages(2);
            this.f8596e.removeMessages(3);
            this.f8612u.recycle();
            this.f8612u = null;
            this.f8606o = false;
            this.f8599h = false;
            this.f8602k = false;
            this.f8603l = false;
            this.f8600i = false;
            if (this.f8601j) {
                this.f8601j = false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0204  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(android.view.MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.f8612u
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.f8612u = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.f8612u
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = r2
                goto L_0x001d
            L_0x001c:
                r4 = r3
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = r3
                r9 = r7
                r10 = r9
            L_0x002d:
                if (r8 >= r6) goto L_0x003f
                if (r5 != r8) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r11 = r13.getX(r8)
                float r9 = r9 + r11
                float r11 = r13.getY(r8)
                float r10 = r10 + r11
            L_0x003c:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003f:
                if (r4 == 0) goto L_0x0044
                int r4 = r6 + -1
                goto L_0x0045
            L_0x0044:
                r4 = r6
            L_0x0045:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01bb
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x012d
                if (r0 == r4) goto L_0x00b8
                if (r0 == r5) goto L_0x00b3
                r2 = 5
                if (r0 == r2) goto L_0x00a6
                if (r0 == r1) goto L_0x005b
                goto L_0x024c
            L_0x005b:
                r12.f8607p = r9
                r12.f8609r = r9
                r12.f8608q = r10
                r12.f8610s = r10
                android.view.VelocityTracker r0 = r12.f8612u
                int r1 = r12.f8595d
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.f8612u
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.f8612u
                float r1 = r4.getYVelocity(r1)
                r4 = r3
            L_0x0080:
                if (r4 >= r6) goto L_0x024c
                if (r4 != r0) goto L_0x0085
                goto L_0x00a3
            L_0x0085:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.f8612u
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.f8612u
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a3
                android.view.VelocityTracker r13 = r12.f8612u
                r13.clear()
                goto L_0x024c
            L_0x00a3:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a6:
                r12.f8607p = r9
                r12.f8609r = r9
                r12.f8608q = r10
                r12.f8610s = r10
                r12.c()
                goto L_0x024c
            L_0x00b3:
                r12.a()
                goto L_0x024c
            L_0x00b8:
                boolean r0 = r12.f8601j
                if (r0 == 0) goto L_0x00be
                goto L_0x024c
            L_0x00be:
                float r0 = r12.f8607p
                float r0 = r0 - r9
                float r1 = r12.f8608q
                float r1 = r1 - r10
                boolean r6 = r12.f8606o
                if (r6 == 0) goto L_0x00d1
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f8598g
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x024c
            L_0x00d1:
                boolean r6 = r12.f8602k
                if (r6 == 0) goto L_0x010d
                float r6 = r12.f8609r
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.f8610s
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r12.f8592a
                if (r6 <= r7) goto L_0x0104
                android.view.GestureDetector$OnGestureListener r7 = r12.f8597f
                android.view.MotionEvent r8 = r12.f8604m
                boolean r13 = r7.onScroll(r8, r13, r0, r1)
                r12.f8607p = r9
                r12.f8608q = r10
                r12.f8602k = r3
                android.os.Handler r0 = r12.f8596e
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.f8596e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f8596e
                r0.removeMessages(r4)
                goto L_0x0105
            L_0x0104:
                r13 = r3
            L_0x0105:
                int r0 = r12.f8592a
                if (r6 <= r0) goto L_0x01b8
                r12.f8603l = r3
                goto L_0x01b8
            L_0x010d:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x011f
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x024c
            L_0x011f:
                android.view.GestureDetector$OnGestureListener r2 = r12.f8597f
                android.view.MotionEvent r3 = r12.f8604m
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.f8607p = r9
                r12.f8608q = r10
                goto L_0x024c
            L_0x012d:
                r12.f8599h = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.f8606o
                if (r1 == 0) goto L_0x013f
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f8598g
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x0197
            L_0x013f:
                boolean r1 = r12.f8601j
                if (r1 == 0) goto L_0x014b
                android.os.Handler r13 = r12.f8596e
                r13.removeMessages(r5)
                r12.f8601j = r3
                goto L_0x018d
            L_0x014b:
                boolean r1 = r12.f8602k
                if (r1 == 0) goto L_0x0162
                android.view.GestureDetector$OnGestureListener r1 = r12.f8597f
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.f8600i
                if (r5 == 0) goto L_0x0160
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.f8598g
                if (r5 == 0) goto L_0x0160
                r5.onSingleTapConfirmed(r13)
            L_0x0160:
                r13 = r1
                goto L_0x0197
            L_0x0162:
                android.view.VelocityTracker r1 = r12.f8612u
                int r5 = r13.getPointerId(r3)
                int r6 = r12.f8595d
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.f8594c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x018f
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.f8594c
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x018d
                goto L_0x018f
            L_0x018d:
                r13 = r3
                goto L_0x0197
            L_0x018f:
                android.view.GestureDetector$OnGestureListener r5 = r12.f8597f
                android.view.MotionEvent r7 = r12.f8604m
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x0197:
                android.view.MotionEvent r1 = r12.f8605n
                if (r1 == 0) goto L_0x019e
                r1.recycle()
            L_0x019e:
                r12.f8605n = r0
                android.view.VelocityTracker r0 = r12.f8612u
                if (r0 == 0) goto L_0x01aa
                r0.recycle()
                r0 = 0
                r12.f8612u = r0
            L_0x01aa:
                r12.f8606o = r3
                r12.f8600i = r3
                android.os.Handler r0 = r12.f8596e
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.f8596e
                r0.removeMessages(r4)
            L_0x01b8:
                r3 = r13
                goto L_0x024c
            L_0x01bb:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f8598g
                if (r0 == 0) goto L_0x01f7
                android.os.Handler r0 = r12.f8596e
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01cc
                android.os.Handler r1 = r12.f8596e
                r1.removeMessages(r5)
            L_0x01cc:
                android.view.MotionEvent r1 = r12.f8604m
                if (r1 == 0) goto L_0x01ef
                android.view.MotionEvent r6 = r12.f8605n
                if (r6 == 0) goto L_0x01ef
                if (r0 == 0) goto L_0x01ef
                boolean r0 = r12.f(r1, r6, r13)
                if (r0 == 0) goto L_0x01ef
                r12.f8606o = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f8598g
                android.view.MotionEvent r1 = r12.f8604m
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f8598g
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01f8
            L_0x01ef:
                android.os.Handler r0 = r12.f8596e
                int r1 = f8591w
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01f7:
                r0 = r3
            L_0x01f8:
                r12.f8607p = r9
                r12.f8609r = r9
                r12.f8608q = r10
                r12.f8610s = r10
                android.view.MotionEvent r1 = r12.f8604m
                if (r1 == 0) goto L_0x0207
                r1.recycle()
            L_0x0207:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.f8604m = r1
                r12.f8602k = r2
                r12.f8603l = r2
                r12.f8599h = r2
                r12.f8601j = r3
                r12.f8600i = r3
                boolean r1 = r12.f8611t
                if (r1 == 0) goto L_0x0235
                android.os.Handler r1 = r12.f8596e
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.f8596e
                android.view.MotionEvent r3 = r12.f8604m
                long r5 = r3.getDownTime()
                int r3 = f8590v
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = android.view.ViewConfiguration.getLongPressTimeout()
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0235:
                android.os.Handler r1 = r12.f8596e
                android.view.MotionEvent r3 = r12.f8604m
                long r3 = r3.getDownTime()
                int r5 = f8590v
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.f8597f
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x024c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.e.b.b(android.view.MotionEvent):boolean");
        }

        public final void c() {
            this.f8596e.removeMessages(1);
            this.f8596e.removeMessages(2);
            this.f8596e.removeMessages(3);
            this.f8606o = false;
            this.f8602k = false;
            this.f8603l = false;
            this.f8600i = false;
            if (this.f8601j) {
                this.f8601j = false;
            }
        }

        public void d() {
            this.f8596e.removeMessages(3);
            this.f8600i = false;
            this.f8601j = true;
            this.f8597f.onLongPress(this.f8604m);
        }

        public final void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f8597f != null) {
                this.f8611t = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f8594c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f8595d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f8592a = scaledTouchSlop * scaledTouchSlop;
                this.f8593b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        public final boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f8603l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f8591w)) {
                return false;
            }
            int x11 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y11 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x11 * x11) + (y11 * y11) < this.f8593b) {
                return true;
            }
            return false;
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f8598g = onDoubleTapListener;
        }

        public class a extends Handler {
            public a() {
            }

            public void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 1) {
                    b bVar = b.this;
                    bVar.f8597f.onShowPress(bVar.f8604m);
                } else if (i11 == 2) {
                    b.this.d();
                } else if (i11 == 3) {
                    b bVar2 = b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f8598g;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f8599h) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f8604m);
                    } else {
                        bVar2.f8600i = true;
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }

            public a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public final GestureDetector f8614a;

        public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f8614a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean b(MotionEvent motionEvent) {
            return this.f8614a.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f8589a.b(motionEvent);
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f8589a = new c(context, onGestureListener, handler);
        } else {
            this.f8589a = new b(context, onGestureListener, handler);
        }
    }
}
