package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import org.xmlpull.v1.XmlPullParser;
import v1.i;
import v1.l;
import v1.u;

public class ChangeTransform extends Transition {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f11759e = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: f  reason: collision with root package name */
    public static final Property<e, float[]> f11760f = new a(float[].class, "nonTranslations");

    /* renamed from: g  reason: collision with root package name */
    public static final Property<e, PointF> f11761g = new b(PointF.class, "translations");

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f11762h = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    public boolean f11763b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11764c = true;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f11765d = new Matrix();

    public static class a extends Property<e, float[]> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public float[] get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, float[] fArr) {
            eVar.d(fArr);
        }
    }

    public static class b extends Property<e, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(e eVar) {
            return null;
        }

        /* renamed from: b */
        public void set(e eVar, PointF pointF) {
            eVar.c(pointF);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f11766b;

        /* renamed from: c  reason: collision with root package name */
        public Matrix f11767c = new Matrix();

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f11768d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Matrix f11769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f11770f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11771g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f11772h;

        public c(boolean z11, Matrix matrix, View view, f fVar, e eVar) {
            this.f11768d = z11;
            this.f11769e = matrix;
            this.f11770f = view;
            this.f11771g = fVar;
            this.f11772h = eVar;
        }

        public final void a(Matrix matrix) {
            this.f11767c.set(matrix);
            this.f11770f.setTag(R$id.transition_transform, this.f11767c);
            this.f11771g.a(this.f11770f);
        }

        public void onAnimationCancel(Animator animator) {
            this.f11766b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f11766b) {
                if (!this.f11768d || !ChangeTransform.this.f11763b) {
                    this.f11770f.setTag(R$id.transition_transform, (Object) null);
                    this.f11770f.setTag(R$id.parent_matrix, (Object) null);
                } else {
                    a(this.f11769e);
                }
            }
            u.f(this.f11770f, (Matrix) null);
            this.f11771g.a(this.f11770f);
        }

        public void onAnimationPause(Animator animator) {
            a(this.f11772h.a());
        }

        public void onAnimationResume(Animator animator) {
            ChangeTransform.e(this.f11770f);
        }
    }

    public static class d extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public View f11774b;

        /* renamed from: c  reason: collision with root package name */
        public v1.c f11775c;

        public d(View view, v1.c cVar) {
            this.f11774b = view;
            this.f11775c = cVar;
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            b.b(this.f11774b);
            this.f11774b.setTag(R$id.transition_transform, (Object) null);
            this.f11774b.setTag(R$id.parent_matrix, (Object) null);
        }

        public void onTransitionPause(Transition transition) {
            this.f11775c.setVisibility(4);
        }

        public void onTransitionResume(Transition transition) {
            this.f11775c.setVisibility(0);
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f11776a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        public final View f11777b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f11778c;

        /* renamed from: d  reason: collision with root package name */
        public float f11779d;

        /* renamed from: e  reason: collision with root package name */
        public float f11780e;

        public e(View view, float[] fArr) {
            this.f11777b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f11778c = fArr2;
            this.f11779d = fArr2[2];
            this.f11780e = fArr2[5];
            b();
        }

        public Matrix a() {
            return this.f11776a;
        }

        public final void b() {
            float[] fArr = this.f11778c;
            fArr[2] = this.f11779d;
            fArr[5] = this.f11780e;
            this.f11776a.setValues(fArr);
            u.f(this.f11777b, this.f11776a);
        }

        public void c(PointF pointF) {
            this.f11779d = pointF.x;
            this.f11780e = pointF.y;
            b();
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f11778c, 0, fArr.length);
            b();
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final float f11781a;

        /* renamed from: b  reason: collision with root package name */
        public final float f11782b;

        /* renamed from: c  reason: collision with root package name */
        public final float f11783c;

        /* renamed from: d  reason: collision with root package name */
        public final float f11784d;

        /* renamed from: e  reason: collision with root package name */
        public final float f11785e;

        /* renamed from: f  reason: collision with root package name */
        public final float f11786f;

        /* renamed from: g  reason: collision with root package name */
        public final float f11787g;

        /* renamed from: h  reason: collision with root package name */
        public final float f11788h;

        public f(View view) {
            this.f11781a = view.getTranslationX();
            this.f11782b = view.getTranslationY();
            this.f11783c = h0.S(view);
            this.f11784d = view.getScaleX();
            this.f11785e = view.getScaleY();
            this.f11786f = view.getRotationX();
            this.f11787g = view.getRotationY();
            this.f11788h = view.getRotation();
        }

        public void a(View view) {
            ChangeTransform.g(view, this.f11781a, this.f11782b, this.f11783c, this.f11784d, this.f11785e, this.f11786f, this.f11787g, this.f11788h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.f11781a == this.f11781a && fVar.f11782b == this.f11782b && fVar.f11783c == this.f11783c && fVar.f11784d == this.f11784d && fVar.f11785e == this.f11785e && fVar.f11786f == this.f11786f && fVar.f11787g == this.f11787g && fVar.f11788h == this.f11788h) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            float f11 = this.f11781a;
            int i11 = 0;
            int floatToIntBits = (f11 != 0.0f ? Float.floatToIntBits(f11) : 0) * 31;
            float f12 = this.f11782b;
            int floatToIntBits2 = (floatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
            float f13 = this.f11783c;
            int floatToIntBits3 = (floatToIntBits2 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
            float f14 = this.f11784d;
            int floatToIntBits4 = (floatToIntBits3 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
            float f15 = this.f11785e;
            int floatToIntBits5 = (floatToIntBits4 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0)) * 31;
            float f16 = this.f11786f;
            int floatToIntBits6 = (floatToIntBits5 + (f16 != 0.0f ? Float.floatToIntBits(f16) : 0)) * 31;
            float f17 = this.f11787g;
            int floatToIntBits7 = (floatToIntBits6 + (f17 != 0.0f ? Float.floatToIntBits(f17) : 0)) * 31;
            float f18 = this.f11788h;
            if (f18 != 0.0f) {
                i11 = Float.floatToIntBits(f18);
            }
            return floatToIntBits7 + i11;
        }
    }

    public ChangeTransform() {
    }

    public static void e(View view) {
        g(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void g(View view, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        view.setTranslationX(f11);
        view.setTranslationY(f12);
        h0.V0(view, f13);
        view.setScaleX(f14);
        view.setScaleY(f15);
        view.setRotationX(f16);
        view.setRotationY(f17);
        view.setRotation(f18);
    }

    public final void b(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.f11866b;
        Matrix matrix = new Matrix((Matrix) transitionValues2.f11865a.get("android:changeTransform:parentMatrix"));
        u.k(viewGroup, matrix);
        v1.c a11 = b.a(view, viewGroup, matrix);
        if (a11 != null) {
            a11.a((ViewGroup) transitionValues.f11865a.get("android:changeTransform:parent"), transitionValues.f11866b);
            Transition transition = this;
            while (true) {
                Transition transition2 = transition.mParent;
                if (transition2 == null) {
                    break;
                }
                transition = transition2;
            }
            transition.addListener(new d(view, a11));
            if (f11762h) {
                View view2 = transitionValues.f11866b;
                if (view2 != transitionValues2.f11866b) {
                    u.h(view2, 0.0f);
                }
                u.h(view, 1.0f);
            }
        }
    }

    public final ObjectAnimator c(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z11) {
        Matrix matrix = (Matrix) transitionValues.f11865a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f11865a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = v1.f.f16648a;
        }
        if (matrix2 == null) {
            matrix2 = v1.f.f16648a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        View view = transitionValues2.f11866b;
        e(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(f11760f, new v1.b(new float[9]), new float[][]{fArr, fArr2}), i.a(f11761g, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5]))});
        c cVar = new c(z11, matrix3, view, (f) transitionValues2.f11865a.get("android:changeTransform:transforms"), eVar);
        ofPropertyValuesHolder.addListener(cVar);
        a.a(ofPropertyValuesHolder, cVar);
        return ofPropertyValuesHolder;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!f11762h) {
            ((ViewGroup) transitionValues.f11866b.getParent()).startViewTransition(transitionValues.f11866b);
        }
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.f11866b;
        if (view.getVisibility() != 8) {
            transitionValues.f11865a.put("android:changeTransform:parent", view.getParent());
            transitionValues.f11865a.put("android:changeTransform:transforms", new f(view));
            Matrix matrix = view.getMatrix();
            transitionValues.f11865a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.f11764c) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                u.j(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.f11865a.put("android:changeTransform:parentMatrix", matrix2);
                transitionValues.f11865a.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
                transitionValues.f11865a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.f11865a.containsKey("android:changeTransform:parent") || !transitionValues2.f11865a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.f11865a.get("android:changeTransform:parent");
        boolean z11 = this.f11764c && !d(viewGroup2, (ViewGroup) transitionValues2.f11865a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) transitionValues.f11865a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            transitionValues.f11865a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.f11865a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            transitionValues.f11865a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z11) {
            f(transitionValues, transitionValues2);
        }
        ObjectAnimator c11 = c(transitionValues, transitionValues2, z11);
        if (z11 && c11 != null && this.f11763b) {
            b(viewGroup, transitionValues, transitionValues2);
        } else if (!f11762h) {
            viewGroup2.endViewTransition(transitionValues.f11866b);
        }
        return c11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r5 == r4.f11866b) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r4 == r5) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.isValidTarget(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            boolean r0 = r3.isValidTarget(r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            androidx.transition.TransitionValues r4 = r3.getMatchedTransitionValues(r4, r1)
            if (r4 == 0) goto L_0x001f
            android.view.View r4 = r4.f11866b
            if (r5 != r4) goto L_0x001d
            goto L_0x001e
        L_0x001a:
            if (r4 != r5) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            r2 = r1
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.d(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    public final void f(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.f11865a.get("android:changeTransform:parentMatrix");
        transitionValues2.f11866b.setTag(R$id.parent_matrix, matrix);
        Matrix matrix2 = this.f11765d;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.f11865a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.f11865a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.f11865a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    public String[] getTransitionProperties() {
        return f11759e;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16668g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f11763b = s0.i.a(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f11764c = s0.i.a(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
