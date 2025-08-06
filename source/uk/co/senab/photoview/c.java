package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.n;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.gestures.VersionedGestureDetector;
import uk.co.senab.photoview.log.LogManager;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

public class c implements b, View.OnTouchListener, c30.e, ViewTreeObserver.OnGlobalLayoutListener {
    public static final boolean F = Log.isLoggable("PhotoViewAttacher", 3);
    public static int G = 1;
    public d A;
    public int B;
    public float C;
    public boolean D;
    public ImageView.ScaleType E;

    /* renamed from: b  reason: collision with root package name */
    public Interpolator f60714b;

    /* renamed from: c  reason: collision with root package name */
    public int f60715c;

    /* renamed from: d  reason: collision with root package name */
    public float f60716d;

    /* renamed from: e  reason: collision with root package name */
    public float f60717e;

    /* renamed from: f  reason: collision with root package name */
    public float f60718f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60719g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60720h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<ImageView> f60721i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f60722j;

    /* renamed from: k  reason: collision with root package name */
    public c30.d f60723k;

    /* renamed from: l  reason: collision with root package name */
    public final Matrix f60724l;

    /* renamed from: m  reason: collision with root package name */
    public final Matrix f60725m;

    /* renamed from: n  reason: collision with root package name */
    public final Matrix f60726n;

    /* renamed from: o  reason: collision with root package name */
    public final RectF f60727o;

    /* renamed from: p  reason: collision with root package name */
    public final float[] f60728p;

    /* renamed from: q  reason: collision with root package name */
    public e f60729q;

    /* renamed from: r  reason: collision with root package name */
    public f f60730r;

    /* renamed from: s  reason: collision with root package name */
    public i f60731s;

    /* renamed from: t  reason: collision with root package name */
    public View.OnLongClickListener f60732t;

    /* renamed from: u  reason: collision with root package name */
    public g f60733u;

    /* renamed from: v  reason: collision with root package name */
    public h f60734v;

    /* renamed from: w  reason: collision with root package name */
    public int f60735w;

    /* renamed from: x  reason: collision with root package name */
    public int f60736x;

    /* renamed from: y  reason: collision with root package name */
    public int f60737y;

    /* renamed from: z  reason: collision with root package name */
    public int f60738z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (c.this.f60734v == null || c.this.z() > 1.0f || n.c(motionEvent) > c.G || n.c(motionEvent2) > c.G) {
                return false;
            }
            return c.this.f60734v.onFling(motionEvent, motionEvent2, f11, f12);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (c.this.f60732t != null) {
                c.this.f60732t.onLongClick(c.this.r());
            }
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f60740a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60740a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f60740a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f60740a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f60740a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f60740a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.photoview.c.b.<clinit>():void");
        }
    }

    /* renamed from: uk.co.senab.photoview.c$c  reason: collision with other inner class name */
    public class C0678c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final float f60741b;

        /* renamed from: c  reason: collision with root package name */
        public final float f60742c;

        /* renamed from: d  reason: collision with root package name */
        public final long f60743d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        public final float f60744e;

        /* renamed from: f  reason: collision with root package name */
        public final float f60745f;

        public C0678c(float f11, float f12, float f13, float f14) {
            this.f60741b = f13;
            this.f60742c = f14;
            this.f60744e = f11;
            this.f60745f = f12;
        }

        public final float a() {
            return c.this.f60714b.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f60743d)) * 1.0f) / ((float) c.this.f60715c)));
        }

        public void run() {
            ImageView r11 = c.this.r();
            if (r11 != null) {
                float a11 = a();
                float f11 = this.f60744e;
                c.this.onScale((f11 + ((this.f60745f - f11) * a11)) / c.this.z(), this.f60741b, this.f60742c);
                if (a11 < 1.0f) {
                    Compat.d(r11, this);
                }
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final ScrollerProxy f60747b;

        /* renamed from: c  reason: collision with root package name */
        public int f60748c;

        /* renamed from: d  reason: collision with root package name */
        public int f60749d;

        public d(Context context) {
            this.f60747b = ScrollerProxy.f(context);
        }

        public void a() {
            if (c.F) {
                LogManager.a().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.f60747b.c(true);
        }

        public void b(int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            int i17;
            int i18;
            RectF n11 = c.this.n();
            if (n11 != null) {
                int round = Math.round(-n11.left);
                float f11 = (float) i11;
                if (f11 < n11.width()) {
                    i15 = Math.round(n11.width() - f11);
                    i16 = 0;
                } else {
                    i16 = round;
                    i15 = i16;
                }
                int round2 = Math.round(-n11.top);
                float f12 = (float) i12;
                if (f12 < n11.height()) {
                    i17 = Math.round(n11.height() - f12);
                    i18 = 0;
                } else {
                    i18 = round2;
                    i17 = i18;
                }
                this.f60748c = round;
                this.f60749d = round2;
                if (c.F) {
                    LogManager.a().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i15 + " MaxY:" + i17);
                }
                if (round != i15 || round2 != i17) {
                    this.f60747b.b(round, round2, i13, i14, i16, i15, i18, i17, 0, 0);
                }
            }
        }

        public void run() {
            ImageView r11;
            if (!this.f60747b.g() && (r11 = c.this.r()) != null && this.f60747b.a()) {
                int d11 = this.f60747b.d();
                int e11 = this.f60747b.e();
                if (c.F) {
                    d30.a a11 = LogManager.a();
                    a11.d("PhotoViewAttacher", "fling run(). CurrentX:" + this.f60748c + " CurrentY:" + this.f60749d + " NewX:" + d11 + " NewY:" + e11);
                }
                c.this.f60726n.postTranslate((float) (this.f60748c - d11), (float) (this.f60749d - e11));
                c cVar = c.this;
                cVar.H(cVar.p());
                this.f60748c = d11;
                this.f60749d = e11;
                Compat.d(r11, this);
            }
        }
    }

    public interface e {
        void onMatrixChanged(RectF rectF);
    }

    public interface f {
        void onOutsidePhotoTap();

        void onPhotoTap(View view, float f11, float f12);
    }

    public interface g {
        void onScaleChange(float f11, float f12, float f13);
    }

    public interface h {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12);
    }

    public interface i {
        void onViewTap(View view, float f11, float f12);
    }

    public c(ImageView imageView) {
        this(imageView, true);
    }

    public static boolean D(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    public static boolean E(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.f60740a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    public static void I(ImageView imageView) {
        if (imageView != null && !(imageView instanceof b) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public static void l(float f11, float f12, float f13) {
        if (f11 >= f12) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f12 >= f13) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public ImageView.ScaleType A() {
        return this.E;
    }

    public final float B(Matrix matrix, int i11) {
        matrix.getValues(this.f60728p);
        return this.f60728p[i11];
    }

    public Bitmap C() {
        ImageView r11 = r();
        if (r11 == null) {
            return null;
        }
        return r11.getDrawingCache();
    }

    public final void F() {
        this.f60726n.reset();
        T(this.C);
        H(p());
        k();
    }

    public void G(boolean z11) {
        this.f60719g = z11;
    }

    public final void H(Matrix matrix) {
        RectF o11;
        ImageView r11 = r();
        if (r11 != null) {
            j();
            r11.setImageMatrix(matrix);
            if (this.f60729q != null && (o11 = o(matrix)) != null) {
                this.f60729q.onMatrixChanged(o11);
            }
        }
    }

    public void J(float f11) {
        l(this.f60716d, this.f60717e, f11);
        this.f60718f = f11;
    }

    public void K(float f11) {
        l(this.f60716d, f11, this.f60718f);
        this.f60717e = f11;
    }

    public void L(float f11) {
        l(f11, this.f60717e, this.f60718f);
        this.f60716d = f11;
    }

    public void M(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f60722j.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f60722j.setOnDoubleTapListener(new a(this));
        }
    }

    public void N(View.OnLongClickListener onLongClickListener) {
        this.f60732t = onLongClickListener;
    }

    public void O(e eVar) {
        this.f60729q = eVar;
    }

    public void P(f fVar) {
        this.f60730r = fVar;
    }

    public void Q(g gVar) {
        this.f60733u = gVar;
    }

    public void R(h hVar) {
        this.f60734v = hVar;
    }

    public void S(i iVar) {
        this.f60731s = iVar;
    }

    public void T(float f11) {
        this.f60726n.postRotate(f11 % 360.0f);
        i();
    }

    public void U(float f11) {
        this.f60726n.setRotate(f11 % 360.0f);
        i();
    }

    public void V(float f11) {
        X(f11, false);
    }

    public void W(float f11, float f12, float f13, boolean z11) {
        ImageView r11 = r();
        if (r11 == null) {
            return;
        }
        if (f11 < this.f60716d || f11 > this.f60718f) {
            LogManager.a().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z11) {
            r11.post(new C0678c(z(), f11, f12, f13));
        } else {
            this.f60726n.setScale(f11, f11, f12, f13);
            i();
        }
    }

    public void X(float f11, boolean z11) {
        ImageView r11 = r();
        if (r11 != null) {
            W(f11, (float) (r11.getRight() / 2), (float) (r11.getBottom() / 2), z11);
        }
    }

    public void Y(ImageView.ScaleType scaleType) {
        if (E(scaleType) && scaleType != this.E) {
            this.E = scaleType;
            b0();
        }
    }

    public void Z(int i11) {
        if (i11 < 0) {
            i11 = 200;
        }
        this.f60715c = i11;
    }

    public void a0(boolean z11) {
        this.D = z11;
        b0();
    }

    public void b0() {
        ImageView r11 = r();
        if (r11 == null) {
            return;
        }
        if (this.D) {
            I(r11);
            c0(r11.getDrawable());
            return;
        }
        F();
    }

    public final void c0(Drawable drawable) {
        ImageView r11 = r();
        if (r11 != null && drawable != null) {
            float t11 = (float) t(r11);
            float s11 = (float) s(r11);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f60724l.reset();
            float f11 = (float) intrinsicWidth;
            float f12 = t11 / f11;
            float f13 = (float) intrinsicHeight;
            float f14 = s11 / f13;
            ImageView.ScaleType scaleType = this.E;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.f60724l.postTranslate((t11 - f11) / 2.0f, (s11 - f13) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f12, f14);
                this.f60724l.postScale(max, max);
                this.f60724l.postTranslate((t11 - (f11 * max)) / 2.0f, (s11 - (f13 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f12, f14));
                this.f60724l.postScale(min, min);
                this.f60724l.postTranslate((t11 - (f11 * min)) / 2.0f, (s11 - (f13 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f11, f13);
                RectF rectF2 = new RectF(0.0f, 0.0f, t11, s11);
                if (((int) this.C) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f13, f11);
                }
                int i11 = b.f60740a[this.E.ordinal()];
                if (i11 == 2) {
                    this.f60724l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i11 == 3) {
                    this.f60724l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i11 == 4) {
                    this.f60724l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i11 == 5) {
                    this.f60724l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            F();
        }
    }

    public final void h() {
        d dVar = this.A;
        if (dVar != null) {
            dVar.a();
            this.A = null;
        }
    }

    public final void i() {
        if (k()) {
            H(p());
        }
    }

    public final void j() {
        ImageView r11 = r();
        if (r11 != null && !(r11 instanceof b) && !ImageView.ScaleType.MATRIX.equals(r11.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k() {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.r()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r12.p()
            android.graphics.RectF r2 = r12.o(r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            int r5 = r12.s(r0)
            float r5 = (float) r5
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 3
            r9 = 2
            r10 = 0
            if (r6 > 0) goto L_0x0044
            int[] r6 = uk.co.senab.photoview.c.b.f60740a
            android.widget.ImageView$ScaleType r11 = r12.E
            int r11 = r11.ordinal()
            r6 = r6[r11]
            if (r6 == r9) goto L_0x0041
            if (r6 == r8) goto L_0x003c
            float r5 = r5 - r3
            float r5 = r5 / r7
            float r3 = r2.top
            goto L_0x003f
        L_0x003c:
            float r5 = r5 - r3
            float r3 = r2.top
        L_0x003f:
            float r5 = r5 - r3
            goto L_0x0054
        L_0x0041:
            float r3 = r2.top
            goto L_0x004a
        L_0x0044:
            float r3 = r2.top
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x004c
        L_0x004a:
            float r5 = -r3
            goto L_0x0054
        L_0x004c:
            float r3 = r2.bottom
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0053
            goto L_0x003f
        L_0x0053:
            r5 = r10
        L_0x0054:
            int r0 = r12.t(r0)
            float r0 = (float) r0
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            r6 = 1
            if (r3 > 0) goto L_0x007d
            int[] r1 = uk.co.senab.photoview.c.b.f60740a
            android.widget.ImageView$ScaleType r3 = r12.E
            int r3 = r3.ordinal()
            r1 = r1[r3]
            if (r1 == r9) goto L_0x0076
            if (r1 == r8) goto L_0x0071
            float r0 = r0 - r4
            float r0 = r0 / r7
            float r1 = r2.left
            goto L_0x0074
        L_0x0071:
            float r0 = r0 - r4
            float r1 = r2.left
        L_0x0074:
            float r0 = r0 - r1
            goto L_0x0079
        L_0x0076:
            float r0 = r2.left
            float r0 = -r0
        L_0x0079:
            r10 = r0
            r12.B = r9
            goto L_0x0095
        L_0x007d:
            float r3 = r2.left
            int r4 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0087
            r12.B = r1
            float r10 = -r3
            goto L_0x0095
        L_0x0087:
            float r1 = r2.right
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0092
            float r10 = r0 - r1
            r12.B = r6
            goto L_0x0095
        L_0x0092:
            r0 = -1
            r12.B = r0
        L_0x0095:
            android.graphics.Matrix r0 = r12.f60726n
            r0.postTranslate(r10, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.photoview.c.k():boolean");
    }

    public void m() {
        WeakReference<ImageView> weakReference = this.f60721i;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                h();
            }
            GestureDetector gestureDetector = this.f60722j;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.f60729q = null;
            this.f60730r = null;
            this.f60731s = null;
            this.f60721i = null;
        }
    }

    public RectF n() {
        k();
        return o(p());
    }

    public final RectF o(Matrix matrix) {
        Drawable drawable;
        ImageView r11 = r();
        if (r11 == null || (drawable = r11.getDrawable()) == null) {
            return null;
        }
        this.f60727o.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f60727o);
        return this.f60727o;
    }

    public void onDrag(float f11, float f12) {
        if (!this.f60723k.c()) {
            if (F) {
                LogManager.a().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f11), Float.valueOf(f12)}));
            }
            ImageView r11 = r();
            this.f60726n.postTranslate(f11, f12);
            i();
            ViewParent parent = r11.getParent();
            if (this.f60719g && !this.f60723k.c() && !this.f60720h) {
                int i11 = this.B;
                if ((i11 == 2 || ((i11 == 0 && f11 >= 1.0f) || (i11 == 1 && f11 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public void onFling(float f11, float f12, float f13, float f14) {
        if (F) {
            d30.a a11 = LogManager.a();
            a11.d("PhotoViewAttacher", "onFling. sX: " + f11 + " sY: " + f12 + " Vx: " + f13 + " Vy: " + f14);
        }
        ImageView r11 = r();
        d dVar = new d(r11.getContext());
        this.A = dVar;
        dVar.b(t(r11), s(r11), (int) f13, (int) f14);
        r11.post(this.A);
    }

    public void onGlobalLayout() {
        ImageView r11 = r();
        if (r11 == null) {
            return;
        }
        if (this.D) {
            int top = r11.getTop();
            int right = r11.getRight();
            int bottom = r11.getBottom();
            int left = r11.getLeft();
            if (top != this.f60735w || bottom != this.f60737y || left != this.f60738z || right != this.f60736x) {
                c0(r11.getDrawable());
                this.f60735w = top;
                this.f60736x = right;
                this.f60737y = bottom;
                this.f60738z = left;
                return;
            }
            return;
        }
        c0(r11.getDrawable());
    }

    public void onScale(float f11, float f12, float f13) {
        if (F) {
            LogManager.a().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)}));
        }
        if (z() >= this.f60718f && f11 >= 1.0f) {
            return;
        }
        if (z() > this.f60716d || f11 > 1.0f) {
            g gVar = this.f60733u;
            if (gVar != null) {
                gVar.onScaleChange(f11, f12, f13);
            }
            this.f60726n.postScale(f11, f11, f12, f13);
            i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.D
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = D(r0)
            if (r0 == 0) goto L_0x00a1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L_0x0049
            if (r3 == r2) goto L_0x001f
            r0 = 3
            if (r3 == r0) goto L_0x001f
            goto L_0x005d
        L_0x001f:
            float r0 = r10.z()
            float r3 = r10.f60716d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            android.graphics.RectF r0 = r10.n()
            if (r0 == 0) goto L_0x005d
            uk.co.senab.photoview.c$c r9 = new uk.co.senab.photoview.c$c
            float r5 = r10.z()
            float r6 = r10.f60716d
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = r2
            goto L_0x005e
        L_0x0049:
            if (r0 == 0) goto L_0x004f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x005a
        L_0x004f:
            d30.a r11 = uk.co.senab.photoview.log.LogManager.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L_0x005a:
            r10.h()
        L_0x005d:
            r11 = r1
        L_0x005e:
            c30.d r0 = r10.f60723k
            if (r0 == 0) goto L_0x0095
            boolean r11 = r0.c()
            c30.d r0 = r10.f60723k
            boolean r0 = r0.a()
            c30.d r3 = r10.f60723k
            boolean r3 = r3.b(r12)
            if (r11 != 0) goto L_0x007e
            c30.d r11 = r10.f60723k
            boolean r11 = r11.c()
            if (r11 != 0) goto L_0x007e
            r11 = r2
            goto L_0x007f
        L_0x007e:
            r11 = r1
        L_0x007f:
            if (r0 != 0) goto L_0x008b
            c30.d r0 = r10.f60723k
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x008b
            r0 = r2
            goto L_0x008c
        L_0x008b:
            r0 = r1
        L_0x008c:
            if (r11 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0091
            r1 = r2
        L_0x0091:
            r10.f60720h = r1
            r1 = r3
            goto L_0x0096
        L_0x0095:
            r1 = r11
        L_0x0096:
            android.view.GestureDetector r11 = r10.f60722j
            if (r11 == 0) goto L_0x00a1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00a1
            r1 = r2
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.photoview.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final Matrix p() {
        this.f60725m.set(this.f60724l);
        this.f60725m.postConcat(this.f60726n);
        return this.f60725m;
    }

    public Matrix q() {
        return this.f60725m;
    }

    public ImageView r() {
        WeakReference<ImageView> weakReference = this.f60721i;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            m();
            LogManager.a().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public final int s(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int t(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float u() {
        return this.f60718f;
    }

    public float v() {
        return this.f60717e;
    }

    public float w() {
        return this.f60716d;
    }

    public f x() {
        return this.f60730r;
    }

    public i y() {
        return this.f60731s;
    }

    public float z() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) B(this.f60726n, 0), 2.0d)) + ((float) Math.pow((double) B(this.f60726n, 3), 2.0d))));
    }

    public c(ImageView imageView, boolean z11) {
        this.f60714b = new AccelerateDecelerateInterpolator();
        this.f60715c = 200;
        this.f60716d = 1.0f;
        this.f60717e = 1.75f;
        this.f60718f = 3.0f;
        this.f60719g = true;
        this.f60720h = false;
        this.f60724l = new Matrix();
        this.f60725m = new Matrix();
        this.f60726n = new Matrix();
        this.f60727o = new RectF();
        this.f60728p = new float[9];
        this.B = 2;
        this.E = ImageView.ScaleType.FIT_CENTER;
        this.f60721i = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        I(imageView);
        if (!imageView.isInEditMode()) {
            this.f60723k = VersionedGestureDetector.a(imageView.getContext(), this);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
            this.f60722j = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new a(this));
            this.C = 0.0f;
            a0(z11);
        }
    }
}
