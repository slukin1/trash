package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import java.util.Map;
import v1.l;
import v1.q;
import v1.u;

public class ChangeBounds extends Transition {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f11714e = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: f  reason: collision with root package name */
    public static final Property<Drawable, PointF> f11715f = new b(PointF.class, "boundsOrigin");

    /* renamed from: g  reason: collision with root package name */
    public static final Property<k, PointF> f11716g = new c(PointF.class, "topLeft");

    /* renamed from: h  reason: collision with root package name */
    public static final Property<k, PointF> f11717h = new d(PointF.class, "bottomRight");

    /* renamed from: i  reason: collision with root package name */
    public static final Property<View, PointF> f11718i = new e(PointF.class, "bottomRight");

    /* renamed from: j  reason: collision with root package name */
    public static final Property<View, PointF> f11719j = new f(PointF.class, "topLeft");

    /* renamed from: k  reason: collision with root package name */
    public static final Property<View, PointF> f11720k = new g(PointF.class, "position");

    /* renamed from: l  reason: collision with root package name */
    public static v1.j f11721l = new v1.j();

    /* renamed from: b  reason: collision with root package name */
    public int[] f11722b = new int[2];

    /* renamed from: c  reason: collision with root package name */
    public boolean f11723c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11724d = false;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11725b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f11726c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f11727d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f11728e;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f11) {
            this.f11725b = viewGroup;
            this.f11726c = bitmapDrawable;
            this.f11727d = view;
            this.f11728e = f11;
        }

        public void onAnimationEnd(Animator animator) {
            u.b(this.f11725b).remove(this.f11726c);
            u.h(this.f11727d, this.f11728e);
        }
    }

    public static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f11730a = new Rect();

        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f11730a);
            Rect rect = this.f11730a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f11730a);
            this.f11730a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f11730a);
        }
    }

    public static class c extends Property<k, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            u.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            u.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            u.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f11731b;
        private k mViewBounds;

        public h(k kVar) {
            this.f11731b = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f11733b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f11734c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Rect f11735d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f11737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f11738g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f11739h;

        public i(View view, Rect rect, int i11, int i12, int i13, int i14) {
            this.f11734c = view;
            this.f11735d = rect;
            this.f11736e = i11;
            this.f11737f = i12;
            this.f11738g = i13;
            this.f11739h = i14;
        }

        public void onAnimationCancel(Animator animator) {
            this.f11733b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f11733b) {
                h0.E0(this.f11734c, this.f11735d);
                u.g(this.f11734c, this.f11736e, this.f11737f, this.f11738g, this.f11739h);
            }
        }
    }

    public class j extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f11741b = false;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11742c;

        public j(ViewGroup viewGroup) {
            this.f11742c = viewGroup;
        }

        public void onTransitionCancel(Transition transition) {
            q.d(this.f11742c, false);
            this.f11741b = true;
        }

        public void onTransitionEnd(Transition transition) {
            if (!this.f11741b) {
                q.d(this.f11742c, false);
            }
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            q.d(this.f11742c, false);
        }

        public void onTransitionResume(Transition transition) {
            q.d(this.f11742c, true);
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public int f11744a;

        /* renamed from: b  reason: collision with root package name */
        public int f11745b;

        /* renamed from: c  reason: collision with root package name */
        public int f11746c;

        /* renamed from: d  reason: collision with root package name */
        public int f11747d;

        /* renamed from: e  reason: collision with root package name */
        public View f11748e;

        /* renamed from: f  reason: collision with root package name */
        public int f11749f;

        /* renamed from: g  reason: collision with root package name */
        public int f11750g;

        public k(View view) {
            this.f11748e = view;
        }

        public void a(PointF pointF) {
            this.f11746c = Math.round(pointF.x);
            this.f11747d = Math.round(pointF.y);
            int i11 = this.f11750g + 1;
            this.f11750g = i11;
            if (this.f11749f == i11) {
                b();
            }
        }

        public final void b() {
            u.g(this.f11748e, this.f11744a, this.f11745b, this.f11746c, this.f11747d);
            this.f11749f = 0;
            this.f11750g = 0;
        }

        public void c(PointF pointF) {
            this.f11744a = Math.round(pointF.x);
            this.f11745b = Math.round(pointF.y);
            int i11 = this.f11749f + 1;
            this.f11749f = i11;
            if (i11 == this.f11750g) {
                b();
            }
        }
    }

    public ChangeBounds() {
    }

    public final boolean b(View view, View view2) {
        if (!this.f11724d) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f11866b) {
            return true;
        }
        return false;
    }

    public void c(boolean z11) {
        this.f11723c = z11;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.f11866b;
        if (h0.a0(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f11865a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f11865a.put("android:changeBounds:parent", transitionValues.f11866b.getParent());
            if (this.f11724d) {
                transitionValues.f11866b.getLocationInWindow(this.f11722b);
                transitionValues.f11865a.put("android:changeBounds:windowX", Integer.valueOf(this.f11722b[0]));
                transitionValues.f11865a.put("android:changeBounds:windowY", Integer.valueOf(this.f11722b[1]));
            }
            if (this.f11723c) {
                transitionValues.f11865a.put("android:changeBounds:clip", h0.x(view));
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i11;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i12;
        Rect rect;
        ObjectAnimator objectAnimator2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.f11865a;
        Map<String, Object> map2 = transitionValues4.f11865a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues4.f11866b;
        if (b(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues3.f11865a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) transitionValues4.f11865a.get("android:changeBounds:bounds");
            int i13 = rect2.left;
            int i14 = rect3.left;
            int i15 = rect2.top;
            int i16 = rect3.top;
            int i17 = rect2.right;
            int i18 = rect3.right;
            int i19 = rect2.bottom;
            int i21 = rect3.bottom;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            int i24 = i18 - i14;
            int i25 = i21 - i16;
            View view3 = view2;
            Rect rect4 = (Rect) transitionValues3.f11865a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) transitionValues4.f11865a.get("android:changeBounds:clip");
            if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
                i11 = 0;
            } else {
                i11 = (i13 == i14 && i15 == i16) ? 0 : 1;
                if (!(i17 == i18 && i19 == i21)) {
                    i11++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i11++;
            }
            if (i11 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.f11723c) {
                view = view3;
                u.g(view, i13, i15, i17, i19);
                if (i11 == 2) {
                    if (i22 == i24 && i23 == i25) {
                        animator = v1.g.a(view, f11720k, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a11 = v1.g.a(kVar, f11716g, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                        ObjectAnimator a12 = v1.g.a(kVar, f11717h, getPathMotion().getPath((float) i17, (float) i19, (float) i18, (float) i21));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a11, a12});
                        animatorSet.addListener(new h(kVar));
                        animator = animatorSet;
                    }
                } else if (i13 == i14 && i15 == i16) {
                    animator = v1.g.a(view, f11718i, getPathMotion().getPath((float) i17, (float) i19, (float) i18, (float) i21));
                } else {
                    animator = v1.g.a(view, f11719j, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                }
            } else {
                view = view3;
                u.g(view, i13, i15, Math.max(i22, i24) + i13, Math.max(i23, i25) + i15);
                if (i13 == i14 && i15 == i16) {
                    objectAnimator = null;
                } else {
                    objectAnimator = v1.g.a(view, f11720k, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                }
                if (rect7 == null) {
                    i12 = 0;
                    rect = new Rect(0, 0, i22, i23);
                } else {
                    i12 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i12, i12, i24, i25) : rect6;
                if (!rect.equals(rect8)) {
                    h0.E0(view, rect);
                    v1.j jVar = f11721l;
                    Object[] objArr = new Object[2];
                    objArr[i12] = rect;
                    objArr[1] = rect8;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    ofObject.addListener(new i(view, rect6, i14, i16, i18, i21));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = c.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                q.d(viewGroup4, true);
                addListener(new j(viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues3.f11865a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues3.f11865a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues4.f11865a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues4.f11865a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f11722b);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c11 = u.c(view2);
        u.h(view2, 0.0f);
        u.b(viewGroup).add(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.f11722b;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{v1.i.a(f11715f, pathMotion.getPath((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c11));
        return ofPropertyValuesHolder;
    }

    public String[] getTransitionProperties() {
        return f11714e;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16665d);
        boolean a11 = s0.i.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        c(a11);
    }
}
