package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.h0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import v1.t;

public class ViewOverlayApi14 implements t {

    /* renamed from: a  reason: collision with root package name */
    public OverlayViewGroup f11868a;

    public static class OverlayViewGroup extends ViewGroup {

        /* renamed from: g  reason: collision with root package name */
        public static Method f11869g;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f11870b;

        /* renamed from: c  reason: collision with root package name */
        public View f11871c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Drawable> f11872d = null;

        /* renamed from: e  reason: collision with root package name */
        public ViewOverlayApi14 f11873e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11874f;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                f11869g = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{cls2, cls2, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f11870b = viewGroup;
            this.f11871c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f11873e = viewOverlayApi14;
        }

        public void a(Drawable drawable) {
            c();
            if (this.f11872d == null) {
                this.f11872d = new ArrayList<>();
            }
            if (!this.f11872d.contains(drawable)) {
                this.f11872d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f11870b || viewGroup.getParent() == null || !h0.Z(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f11870b.getLocationOnScreen(iArr2);
                    h0.g0(view, iArr[0] - iArr2[0]);
                    h0.h0(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void c() {
            if (this.f11874f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f11872d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f11874f = true;
                    this.f11870b.removeView(this);
                }
            }
        }

        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f11870b.getLocationOnScreen(iArr);
            this.f11871c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f11871c.getWidth(), this.f11871c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f11872d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f11872d.get(i11).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public final void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f11870b.getLocationOnScreen(iArr2);
            this.f11871c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f11872d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            d();
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f11870b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f11870b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                e(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.f11872d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f11872d
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ViewOverlayApi14.OverlayViewGroup.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f11868a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    public static ViewOverlayApi14 a(View view) {
        ViewGroup b11 = b(view);
        if (b11 == null) {
            return null;
        }
        int childCount = b11.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = b11.getChildAt(i11);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).f11873e;
            }
        }
        return new e(b11.getContext(), b11, view);
    }

    public static ViewGroup b(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    public void add(Drawable drawable) {
        this.f11868a.a(drawable);
    }

    public void remove(Drawable drawable) {
        this.f11868a.f(drawable);
    }
}
