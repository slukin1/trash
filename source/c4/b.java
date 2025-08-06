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
import f4.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class b<T extends View, Z> implements g<Z> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f63142g = R$id.glide_custom_view_target_tag;

    /* renamed from: b  reason: collision with root package name */
    public final a f63143b;

    /* renamed from: c  reason: collision with root package name */
    public final T f63144c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnAttachStateChangeListener f63145d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63146e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63147f;

    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        public static Integer f63148e;

        /* renamed from: a  reason: collision with root package name */
        public final View f63149a;

        /* renamed from: b  reason: collision with root package name */
        public final List<f> f63150b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public boolean f63151c;

        /* renamed from: d  reason: collision with root package name */
        public C0694a f63152d;

        /* renamed from: c4.b$a$a  reason: collision with other inner class name */
        public static final class C0694a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: b  reason: collision with root package name */
            public final WeakReference<a> f63153b;

            public C0694a(a aVar) {
                this.f63153b = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f63153b.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f63149a = view;
        }

        public static int c(Context context) {
            if (f63148e == null) {
                Display defaultDisplay = ((WindowManager) h.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f63148e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f63148e.intValue();
        }

        public void a() {
            if (!this.f63150b.isEmpty()) {
                int g11 = g();
                int f11 = f();
                if (i(g11, f11)) {
                    j(g11, f11);
                    b();
                }
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.f63149a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f63152d);
            }
            this.f63152d = null;
            this.f63150b.clear();
        }

        public void d(f fVar) {
            int g11 = g();
            int f11 = f();
            if (i(g11, f11)) {
                fVar.d(g11, f11);
                return;
            }
            if (!this.f63150b.contains(fVar)) {
                this.f63150b.add(fVar);
            }
            if (this.f63152d == null) {
                ViewTreeObserver viewTreeObserver = this.f63149a.getViewTreeObserver();
                C0694a aVar = new C0694a(this);
                this.f63152d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        public final int e(int i11, int i12, int i13) {
            int i14 = i12 - i13;
            if (i14 > 0) {
                return i14;
            }
            if (this.f63151c && this.f63149a.isLayoutRequested()) {
                return 0;
            }
            int i15 = i11 - i13;
            if (i15 > 0) {
                return i15;
            }
            if (this.f63149a.isLayoutRequested() || i12 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f63149a.getContext());
        }

        public final int f() {
            int paddingTop = this.f63149a.getPaddingTop() + this.f63149a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f63149a.getLayoutParams();
            return e(this.f63149a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.f63149a.getPaddingLeft() + this.f63149a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f63149a.getLayoutParams();
            return e(this.f63149a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i11) {
            return i11 > 0 || i11 == Integer.MIN_VALUE;
        }

        public final boolean i(int i11, int i12) {
            return h(i11) && h(i12);
        }

        public final void j(int i11, int i12) {
            Iterator it2 = new ArrayList(this.f63150b).iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).d(i11, i12);
            }
        }

        public void k(f fVar) {
            this.f63150b.remove(fVar);
        }
    }

    public b(T t11) {
        this.f63144c = (View) h.d(t11);
        this.f63143b = new a(t11);
    }

    public final Object a() {
        return this.f63144c.getTag(f63142g);
    }

    public final void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f63145d;
        if (onAttachStateChangeListener != null && !this.f63147f) {
            this.f63144c.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f63147f = true;
        }
    }

    public final void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f63145d;
        if (onAttachStateChangeListener != null && this.f63147f) {
            this.f63144c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f63147f = false;
        }
    }

    public abstract void d(Drawable drawable);

    public void e(Drawable drawable) {
    }

    public final void f(Object obj) {
        this.f63144c.setTag(f63142g, obj);
    }

    public final c getRequest() {
        Object a11 = a();
        if (a11 == null) {
            return null;
        }
        if (a11 instanceof c) {
            return (c) a11;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void getSize(f fVar) {
        this.f63143b.d(fVar);
    }

    public void onDestroy() {
    }

    public final void onLoadCleared(Drawable drawable) {
        this.f63143b.b();
        d(drawable);
        if (!this.f63146e) {
            c();
        }
    }

    public final void onLoadStarted(Drawable drawable) {
        b();
        e(drawable);
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(f fVar) {
        this.f63143b.k(fVar);
    }

    public final void setRequest(c cVar) {
        f(cVar);
    }

    public String toString() {
        return "Target for: " + this.f63144c;
    }
}
