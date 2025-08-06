package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;

public class ValueAnimator extends Animator {
    public static final ThreadLocal<ArrayList<ValueAnimator>> A = new e();
    public static final Interpolator B = new AccelerateDecelerateInterpolator();
    public static final fx.c C = new IntEvaluator();
    public static final fx.c D = new FloatEvaluator();
    public static long E = 10;

    /* renamed from: v  reason: collision with root package name */
    public static ThreadLocal<f> f28252v = new ThreadLocal<>();

    /* renamed from: w  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f28253w = new a();

    /* renamed from: x  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f28254x = new b();

    /* renamed from: y  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f28255y = new c();

    /* renamed from: z  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f28256z = new d();

    /* renamed from: c  reason: collision with root package name */
    public long f28257c;

    /* renamed from: d  reason: collision with root package name */
    public long f28258d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28259e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f28260f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f28261g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28262h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f28263i;

    /* renamed from: j  reason: collision with root package name */
    public int f28264j = 0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f28265k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f28266l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f28267m = false;

    /* renamed from: n  reason: collision with root package name */
    public long f28268n = 300;

    /* renamed from: o  reason: collision with root package name */
    public long f28269o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f28270p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f28271q = 1;

    /* renamed from: r  reason: collision with root package name */
    public Interpolator f28272r = B;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<g> f28273s = null;

    /* renamed from: t  reason: collision with root package name */
    public fx.b[] f28274t;

    /* renamed from: u  reason: collision with root package name */
    public HashMap<String, fx.b> f28275u;

    public static class a extends ThreadLocal<ArrayList<ValueAnimator>> {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class b extends ThreadLocal<ArrayList<ValueAnimator>> {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class c extends ThreadLocal<ArrayList<ValueAnimator>> {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class d extends ThreadLocal<ArrayList<ValueAnimator>> {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class e extends ThreadLocal<ArrayList<ValueAnimator>> {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class f extends Handler {
        public f() {
        }

        public void handleMessage(Message message) {
            boolean z11;
            ArrayList arrayList = (ArrayList) ValueAnimator.f28253w.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.f28255y.get();
            int i11 = message.what;
            if (i11 == 0) {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.f28254x.get();
                z11 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i12);
                        if (valueAnimator.f28269o == 0) {
                            valueAnimator.G();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            } else if (i11 == 1) {
                z11 = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.A.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.f28256z.get();
            int size2 = arrayList2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i13);
                if (valueAnimator2.t(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i14 = 0; i14 < size3; i14++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i14);
                    valueAnimator3.G();
                    boolean unused = valueAnimator3.f28265k = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i15 = 0;
            while (i15 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i15);
                if (valueAnimator4.r(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i15++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i16 = 0; i16 < arrayList6.size(); i16++) {
                    ((ValueAnimator) arrayList6.get(i16)).u();
                }
                arrayList6.clear();
            }
            if (!z11) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.E - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public interface g {
        void a(ValueAnimator valueAnimator);
    }

    public static ValueAnimator y(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.B(iArr);
        return valueAnimator;
    }

    public ValueAnimator A(long j11) {
        if (j11 >= 0) {
            this.f28268n = j11;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j11);
    }

    public void B(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            fx.b[] bVarArr = this.f28274t;
            if (bVarArr == null || bVarArr.length == 0) {
                D(fx.b.j("", iArr));
            } else {
                bVarArr[0].l(iArr);
            }
            this.f28267m = false;
        }
    }

    public void C(Interpolator interpolator) {
        if (interpolator != null) {
            this.f28272r = interpolator;
        } else {
            this.f28272r = new LinearInterpolator();
        }
    }

    public void D(fx.b... bVarArr) {
        this.f28274t = bVarArr;
        this.f28275u = new HashMap<>(r0);
        for (fx.b bVar : bVarArr) {
            this.f28275u.put(bVar.g(), bVar);
        }
        this.f28267m = false;
    }

    public void E() {
        F(false);
    }

    public final void F(boolean z11) {
        if (Looper.myLooper() != null) {
            this.f28259e = z11;
            this.f28260f = 0;
            this.f28264j = 0;
            this.f28266l = true;
            this.f28262h = false;
            f28254x.get().add(this);
            if (this.f28269o == 0) {
                z(w());
                this.f28264j = 0;
                this.f28265k = true;
                ArrayList<Animator.a> arrayList = this.f28226b;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((Animator.a) arrayList2.get(i11)).onAnimationStart(this);
                    }
                }
            }
            f fVar = f28252v.get();
            if (fVar == null) {
                fVar = new f((a) null);
                f28252v.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public final void G() {
        ArrayList<Animator.a> arrayList;
        x();
        f28253w.get().add(this);
        if (this.f28269o > 0 && (arrayList = this.f28226b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animator.a) arrayList2.get(i11)).onAnimationStart(this);
            }
        }
    }

    public void p(g gVar) {
        if (this.f28273s == null) {
            this.f28273s = new ArrayList<>();
        }
        this.f28273s.add(gVar);
    }

    public void q(float f11) {
        float interpolation = this.f28272r.getInterpolation(f11);
        this.f28261g = interpolation;
        for (fx.b b11 : this.f28274t) {
            b11.b(interpolation);
        }
        ArrayList<g> arrayList = this.f28273s;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f28273s.get(i11).a(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r(long r11) {
        /*
            r10 = this;
            int r0 = r10.f28264j
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001a
            r10.f28264j = r3
            long r4 = r10.f28258d
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r10.f28257c = r11
            goto L_0x001a
        L_0x0012:
            long r4 = r11 - r4
            r10.f28257c = r4
            r4 = -1
            r10.f28258d = r4
        L_0x001a:
            int r0 = r10.f28264j
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L_0x0023
            if (r0 == r4) goto L_0x0023
            goto L_0x0081
        L_0x0023:
            long r6 = r10.f28268n
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= 0) goto L_0x0032
            long r8 = r10.f28257c
            long r11 = r11 - r8
            float r11 = (float) r11
            float r12 = (float) r6
            float r11 = r11 / r12
            goto L_0x0033
        L_0x0032:
            r11 = r1
        L_0x0033:
            int r12 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r12 < 0) goto L_0x0076
            int r12 = r10.f28260f
            int r0 = r10.f28270p
            if (r12 < r0) goto L_0x0046
            r12 = -1
            if (r0 != r12) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            float r11 = java.lang.Math.min(r11, r1)
            goto L_0x0077
        L_0x0046:
            java.util.ArrayList<com.nineoldandroids.animation.Animator$a> r12 = r10.f28226b
            if (r12 == 0) goto L_0x005f
            int r12 = r12.size()
            r0 = r5
        L_0x004f:
            if (r0 >= r12) goto L_0x005f
            java.util.ArrayList<com.nineoldandroids.animation.Animator$a> r2 = r10.f28226b
            java.lang.Object r2 = r2.get(r0)
            com.nineoldandroids.animation.Animator$a r2 = (com.nineoldandroids.animation.Animator.a) r2
            r2.onAnimationRepeat(r10)
            int r0 = r0 + 1
            goto L_0x004f
        L_0x005f:
            int r12 = r10.f28271q
            if (r12 != r4) goto L_0x0068
            boolean r12 = r10.f28259e
            r12 = r12 ^ r3
            r10.f28259e = r12
        L_0x0068:
            int r12 = r10.f28260f
            int r0 = (int) r11
            int r12 = r12 + r0
            r10.f28260f = r12
            float r11 = r11 % r1
            long r2 = r10.f28257c
            long r6 = r10.f28268n
            long r2 = r2 + r6
            r10.f28257c = r2
        L_0x0076:
            r3 = r5
        L_0x0077:
            boolean r12 = r10.f28259e
            if (r12 == 0) goto L_0x007d
            float r11 = r1 - r11
        L_0x007d:
            r10.q(r11)
            r5 = r3
        L_0x0081:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.ValueAnimator.r(long):boolean");
    }

    /* renamed from: s */
    public ValueAnimator clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        ArrayList<g> arrayList = this.f28273s;
        if (arrayList != null) {
            valueAnimator.f28273s = new ArrayList<>();
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                valueAnimator.f28273s.add(arrayList.get(i11));
            }
        }
        valueAnimator.f28258d = -1;
        valueAnimator.f28259e = false;
        valueAnimator.f28260f = 0;
        valueAnimator.f28267m = false;
        valueAnimator.f28264j = 0;
        valueAnimator.f28262h = false;
        fx.b[] bVarArr = this.f28274t;
        if (bVarArr != null) {
            int length = bVarArr.length;
            valueAnimator.f28274t = new fx.b[length];
            valueAnimator.f28275u = new HashMap<>(length);
            for (int i12 = 0; i12 < length; i12++) {
                fx.b c11 = bVarArr[i12].clone();
                valueAnimator.f28274t[i12] = c11;
                valueAnimator.f28275u.put(c11.g(), c11);
            }
        }
        return valueAnimator;
    }

    public final boolean t(long j11) {
        if (!this.f28262h) {
            this.f28262h = true;
            this.f28263i = j11;
            return false;
        }
        long j12 = j11 - this.f28263i;
        long j13 = this.f28269o;
        if (j12 <= j13) {
            return false;
        }
        this.f28257c = j11 - (j12 - j13);
        this.f28264j = 1;
        return true;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f28274t != null) {
            for (int i11 = 0; i11 < this.f28274t.length; i11++) {
                str = str + "\n    " + this.f28274t[i11].toString();
            }
        }
        return str;
    }

    public final void u() {
        ArrayList<Animator.a> arrayList;
        f28253w.get().remove(this);
        f28254x.get().remove(this);
        f28255y.get().remove(this);
        this.f28264j = 0;
        if (this.f28265k && (arrayList = this.f28226b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animator.a) arrayList2.get(i11)).onAnimationEnd(this);
            }
        }
        this.f28265k = false;
        this.f28266l = false;
    }

    public Object v() {
        fx.b[] bVarArr = this.f28274t;
        if (bVarArr == null || bVarArr.length <= 0) {
            return null;
        }
        return bVarArr[0].d();
    }

    public long w() {
        if (!this.f28267m || this.f28264j == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f28257c;
    }

    public void x() {
        if (!this.f28267m) {
            for (fx.b h11 : this.f28274t) {
                h11.h();
            }
            this.f28267m = true;
        }
    }

    public void z(long j11) {
        x();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f28264j != 1) {
            this.f28258d = j11;
            this.f28264j = 2;
        }
        this.f28257c = currentAnimationTimeMillis - j11;
        r(currentAnimationTimeMillis);
    }
}
