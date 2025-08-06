package c4;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R$id;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.target.BaseTarget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class h<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f63157g;

    /* renamed from: h  reason: collision with root package name */
    public static int f63158h = R$id.glide_custom_view_target_tag;

    /* renamed from: b  reason: collision with root package name */
    public final T f63159b;

    /* renamed from: c  reason: collision with root package name */
    public final a f63160c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnAttachStateChangeListener f63161d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63162e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63163f;

    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        public static Integer f63164e;

        /* renamed from: a  reason: collision with root package name */
        public final View f63165a;

        /* renamed from: b  reason: collision with root package name */
        public final List<f> f63166b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f63167c;

        /* renamed from: d  reason: collision with root package name */
        public C0695a f63168d;

        /* renamed from: c4.h$a$a  reason: collision with other inner class name */
        public static final class C0695a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: b  reason: collision with root package name */
            public final WeakReference<a> f63169b;

            public C0695a(a aVar) {
                this.f63169b = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f63169b.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f63165a = view;
        }

        public static int c(Context context) {
            if (f63164e == null) {
                Display defaultDisplay = ((WindowManager) f4.h.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f63164e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f63164e.intValue();
        }

        public void a() {
            if (!this.f63166b.isEmpty()) {
                int g11 = g();
                int f11 = f();
                if (i(g11, f11)) {
                    j(g11, f11);
                    b();
                }
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f63165a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f63168d);
            }
            this.f63168d = null;
            this.f63166b.clear();
        }

        public void d(f fVar) {
            int g11 = g();
            int f11 = f();
            if (i(g11, f11)) {
                fVar.d(g11, f11);
                return;
            }
            if (!this.f63166b.contains(fVar)) {
                this.f63166b.add(fVar);
            }
            if (this.f63168d == null) {
                ViewTreeObserver viewTreeObserver = this.f63165a.getViewTreeObserver();
                C0695a aVar = new C0695a(this);
                this.f63168d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public final int e(int i11, int i12, int i13) {
            int i14 = i12 - i13;
            if (i14 > 0) {
                return i14;
            }
            if (this.f63167c && this.f63165a.isLayoutRequested()) {
                return 0;
            }
            int i15 = i11 - i13;
            if (i15 > 0) {
                return i15;
            }
            if (this.f63165a.isLayoutRequested() || i12 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f63165a.getContext());
        }

        public final int f() {
            int paddingTop = this.f63165a.getPaddingTop() + this.f63165a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f63165a.getLayoutParams();
            return e(this.f63165a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f63165a.getPaddingLeft() + this.f63165a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f63165a.getLayoutParams();
            return e(this.f63165a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i11) {
            return i11 > 0 || i11 == Integer.MIN_VALUE;
        }

        public final boolean i(int i11, int i12) {
            return h(i11) && h(i12);
        }

        public final void j(int i11, int i12) {
            Iterator it2 = new ArrayList(this.f63166b).iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).d(i11, i12);
            }
        }

        public void k(f fVar) {
            this.f63166b.remove(fVar);
        }
    }

    public h(T t11) {
        this.f63159b = (View) f4.h.d(t11);
        this.f63160c = new a(t11);
    }

    public final Object a() {
        return this.f63159b.getTag(f63158h);
    }

    public T b() {
        return this.f63159b;
    }

    public final void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f63161d;
        if (onAttachStateChangeListener != null && !this.f63163f) {
            this.f63159b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f63163f = true;
        }
    }

    public final void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f63161d;
        if (onAttachStateChangeListener != null && this.f63163f) {
            this.f63159b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f63163f = false;
        }
    }

    public final void e(Object obj) {
        f63157g = true;
        this.f63159b.setTag(f63158h, obj);
    }

    public c getRequest() {
        Object a11 = a();
        if (a11 == null) {
            return null;
        }
        if (a11 instanceof c) {
            return (c) a11;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(f fVar) {
        this.f63160c.d(fVar);
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f63160c.b();
        if (!this.f63162e) {
            d();
        }
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        c();
    }

    public void removeCallback(f fVar) {
        this.f63160c.k(fVar);
    }

    public void setRequest(c cVar) {
        e(cVar);
    }

    public String toString() {
        return "Target for: " + this.f63159b;
    }
}
