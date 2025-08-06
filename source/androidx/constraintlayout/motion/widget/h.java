package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class h {

    /* renamed from: w  reason: collision with root package name */
    public static String f7761w = "ViewTransition";

    /* renamed from: a  reason: collision with root package name */
    public int f7762a;

    /* renamed from: b  reason: collision with root package name */
    public int f7763b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7764c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f7765d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7766e;

    /* renamed from: f  reason: collision with root package name */
    public KeyFrames f7767f;

    /* renamed from: g  reason: collision with root package name */
    public ConstraintSet.Constraint f7768g;

    /* renamed from: h  reason: collision with root package name */
    public int f7769h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f7770i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f7771j;

    /* renamed from: k  reason: collision with root package name */
    public String f7772k;

    /* renamed from: l  reason: collision with root package name */
    public int f7773l = 0;

    /* renamed from: m  reason: collision with root package name */
    public String f7774m = null;

    /* renamed from: n  reason: collision with root package name */
    public int f7775n = -1;

    /* renamed from: o  reason: collision with root package name */
    public Context f7776o;

    /* renamed from: p  reason: collision with root package name */
    public int f7777p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f7778q = -1;

    /* renamed from: r  reason: collision with root package name */
    public int f7779r = -1;

    /* renamed from: s  reason: collision with root package name */
    public int f7780s = -1;

    /* renamed from: t  reason: collision with root package name */
    public int f7781t = -1;

    /* renamed from: u  reason: collision with root package name */
    public int f7782u = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f7783v = -1;

    public class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Easing f7784a;

        public a(Easing easing) {
            this.f7784a = easing;
        }

        public float getInterpolation(float f11) {
            return (float) this.f7784a.a((double) f11);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f7786a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7787b;

        /* renamed from: c  reason: collision with root package name */
        public long f7788c;

        /* renamed from: d  reason: collision with root package name */
        public d f7789d;

        /* renamed from: e  reason: collision with root package name */
        public int f7790e;

        /* renamed from: f  reason: collision with root package name */
        public int f7791f;

        /* renamed from: g  reason: collision with root package name */
        public KeyCache f7792g = new KeyCache();

        /* renamed from: h  reason: collision with root package name */
        public i f7793h;

        /* renamed from: i  reason: collision with root package name */
        public Interpolator f7794i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f7795j = false;

        /* renamed from: k  reason: collision with root package name */
        public float f7796k;

        /* renamed from: l  reason: collision with root package name */
        public float f7797l;

        /* renamed from: m  reason: collision with root package name */
        public long f7798m;

        /* renamed from: n  reason: collision with root package name */
        public Rect f7799n = new Rect();

        /* renamed from: o  reason: collision with root package name */
        public boolean f7800o = false;

        public b(i iVar, d dVar, int i11, int i12, int i13, Interpolator interpolator, int i14, int i15) {
            this.f7793h = iVar;
            this.f7789d = dVar;
            this.f7790e = i11;
            this.f7791f = i12;
            long nanoTime = System.nanoTime();
            this.f7788c = nanoTime;
            this.f7798m = nanoTime;
            this.f7793h.b(this);
            this.f7794i = interpolator;
            this.f7786a = i14;
            this.f7787b = i15;
            if (i13 == 3) {
                this.f7800o = true;
            }
            this.f7797l = i11 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i11);
            a();
        }

        public void a() {
            if (this.f7795j) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            long nanoTime = System.nanoTime();
            this.f7798m = nanoTime;
            float f11 = this.f7796k + (((float) (((double) (nanoTime - this.f7798m)) * 1.0E-6d)) * this.f7797l);
            this.f7796k = f11;
            if (f11 >= 1.0f) {
                this.f7796k = 1.0f;
            }
            Interpolator interpolator = this.f7794i;
            float interpolation = interpolator == null ? this.f7796k : interpolator.getInterpolation(this.f7796k);
            d dVar = this.f7789d;
            boolean x11 = dVar.x(dVar.f7661b, interpolation, nanoTime, this.f7792g);
            if (this.f7796k >= 1.0f) {
                if (this.f7786a != -1) {
                    this.f7789d.v().setTag(this.f7786a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7787b != -1) {
                    this.f7789d.v().setTag(this.f7787b, (Object) null);
                }
                if (!this.f7800o) {
                    this.f7793h.g(this);
                }
            }
            if (this.f7796k < 1.0f || x11) {
                this.f7793h.e();
            }
        }

        public void c() {
            long nanoTime = System.nanoTime();
            this.f7798m = nanoTime;
            float f11 = this.f7796k - (((float) (((double) (nanoTime - this.f7798m)) * 1.0E-6d)) * this.f7797l);
            this.f7796k = f11;
            if (f11 < 0.0f) {
                this.f7796k = 0.0f;
            }
            Interpolator interpolator = this.f7794i;
            float interpolation = interpolator == null ? this.f7796k : interpolator.getInterpolation(this.f7796k);
            d dVar = this.f7789d;
            boolean x11 = dVar.x(dVar.f7661b, interpolation, nanoTime, this.f7792g);
            if (this.f7796k <= 0.0f) {
                if (this.f7786a != -1) {
                    this.f7789d.v().setTag(this.f7786a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7787b != -1) {
                    this.f7789d.v().setTag(this.f7787b, (Object) null);
                }
                this.f7793h.g(this);
            }
            if (this.f7796k > 0.0f || x11) {
                this.f7793h.e();
            }
        }

        public void d(int i11, float f11, float f12) {
            if (i11 != 1) {
                if (i11 == 2) {
                    this.f7789d.v().getHitRect(this.f7799n);
                    if (!this.f7799n.contains((int) f11, (int) f12) && !this.f7795j) {
                        e(true);
                    }
                }
            } else if (!this.f7795j) {
                e(true);
            }
        }

        public void e(boolean z11) {
            int i11;
            this.f7795j = z11;
            if (z11 && (i11 = this.f7791f) != -1) {
                this.f7797l = i11 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i11);
            }
            this.f7793h.e();
            this.f7798m = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.f7763b = r0
            r1 = 0
            r9.f7764c = r1
            r9.f7765d = r1
            r9.f7769h = r0
            r9.f7770i = r0
            r9.f7773l = r1
            r2 = 0
            r9.f7774m = r2
            r9.f7775n = r0
            r9.f7777p = r0
            r9.f7778q = r0
            r9.f7779r = r0
            r9.f7780s = r0
            r9.f7781t = r0
            r9.f7782u = r0
            r9.f7783v = r0
            r9.f7776o = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x002a:
            r3 = 1
            if (r2 == r3) goto L_0x00eb
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0042
            if (r2 == r5) goto L_0x0037
            goto L_0x00dc
        L_0x0037:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r2 == 0) goto L_0x00dc
            return
        L_0x0042:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x0075;
                case -1239391468: goto L_0x006b;
                case 61998586: goto L_0x0063;
                case 366511058: goto L_0x0059;
                case 1791837707: goto L_0x004f;
                default: goto L_0x004e;
            }     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x004e:
            goto L_0x007f
        L_0x004f:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r5
            goto L_0x0080
        L_0x0059:
            java.lang.String r4 = "CustomMethod"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r8
            goto L_0x0080
        L_0x0063:
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r1
            goto L_0x0080
        L_0x006b:
            java.lang.String r4 = "KeyFrameSet"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r3
            goto L_0x0080
        L_0x0075:
            java.lang.String r4 = "ConstraintOverride"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            if (r4 == 0) goto L_0x007f
            r4 = r6
            goto L_0x0080
        L_0x007f:
            r4 = r0
        L_0x0080:
            if (r4 == 0) goto L_0x00d9
            if (r4 == r3) goto L_0x00d1
            if (r4 == r6) goto L_0x00ca
            if (r4 == r5) goto L_0x00c2
            if (r4 == r8) goto L_0x00c2
            java.lang.String r3 = f7761w     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r5 = androidx.constraintlayout.motion.widget.Debug.a()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r5 = " unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            android.util.Log.e(r3, r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r2 = f7761w     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r4 = ".xml:"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            int r4 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            android.util.Log.e(r2, r3)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00c2:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.f7768g     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.f8002g     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            androidx.constraintlayout.widget.ConstraintAttribute.i(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00ca:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.m(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r9.f7768g = r2     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00d1:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            r9.f7767f = r2     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x00dc
        L_0x00d9:
            r9.l(r10, r11)     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
        L_0x00dc:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00e7, IOException -> 0x00e2 }
            goto L_0x002a
        L_0x00e2:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00eb
        L_0x00e7:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.h.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View[] viewArr) {
        if (this.f7777p != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.f7777p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f7778q != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.f7778q, (Object) null);
            }
        }
    }

    public void b(i iVar, MotionLayout motionLayout, View view) {
        d dVar = new d(view);
        dVar.A(view);
        this.f7767f.a(dVar);
        dVar.H(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.f7769h, System.nanoTime());
        i iVar2 = iVar;
        d dVar2 = dVar;
        new b(iVar2, dVar2, this.f7769h, this.f7770i, this.f7763b, f(motionLayout.getContext()), this.f7777p, this.f7778q);
    }

    public void c(i iVar, MotionLayout motionLayout, int i11, ConstraintSet constraintSet, View... viewArr) {
        if (!this.f7764c) {
            int i12 = this.f7766e;
            if (i12 == 2) {
                b(iVar, motionLayout, viewArr[0]);
                return;
            }
            if (i12 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i13 : constraintSetIds) {
                    if (i13 != i11) {
                        ConstraintSet c02 = motionLayout.c0(i13);
                        for (View id2 : viewArr) {
                            ConstraintSet.Constraint w11 = c02.w(id2.getId());
                            ConstraintSet.Constraint constraint = this.f7768g;
                            if (constraint != null) {
                                constraint.d(w11);
                                w11.f8002g.putAll(this.f7768g.f8002g);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.q(constraintSet);
            for (View id3 : viewArr) {
                ConstraintSet.Constraint w12 = constraintSet2.w(id3.getId());
                ConstraintSet.Constraint constraint2 = this.f7768g;
                if (constraint2 != null) {
                    constraint2.d(w12);
                    w12.f8002g.putAll(this.f7768g.f8002g);
                }
            }
            motionLayout.A0(i11, constraintSet2);
            int i14 = R$id.view_transition;
            motionLayout.A0(i14, constraintSet);
            motionLayout.setState(i14, -1, -1);
            e.b bVar = new e.b(-1, motionLayout.f7520b, i14, i11);
            for (View n11 : viewArr) {
                n(bVar, n11);
            }
            motionLayout.setTransition(bVar);
            motionLayout.t0(new g(this, viewArr));
        }
    }

    public boolean d(View view) {
        int i11 = this.f7779r;
        boolean z11 = i11 == -1 || view.getTag(i11) != null;
        int i12 = this.f7780s;
        boolean z12 = i12 == -1 || view.getTag(i12) == null;
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    public int e() {
        return this.f7762a;
    }

    public Interpolator f(Context context) {
        int i11 = this.f7773l;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f7775n);
        }
        if (i11 == -1) {
            return new a(Easing.c(this.f7774m));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 == 5) {
            return new OvershootInterpolator();
        }
        if (i11 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f7781t;
    }

    public int h() {
        return this.f7782u;
    }

    public int i() {
        return this.f7763b;
    }

    public boolean k(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f7771j == -1 && this.f7772k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f7771j) {
            return true;
        }
        if (this.f7772k != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).f7931b0) != null && str.matches(this.f7772k)) {
            return true;
        }
        return false;
    }

    public final void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f7762a = obtainStyledAttributes.getResourceId(index, this.f7762a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.K0) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f7771j);
                    this.f7771j = resourceId;
                    if (resourceId == -1) {
                        this.f7772k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f7772k = obtainStyledAttributes.getString(index);
                } else {
                    this.f7771j = obtainStyledAttributes.getResourceId(index, this.f7771j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f7763b = obtainStyledAttributes.getInt(index, this.f7763b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f7764c = obtainStyledAttributes.getBoolean(index, this.f7764c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f7765d = obtainStyledAttributes.getInt(index, this.f7765d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f7769h = obtainStyledAttributes.getInt(index, this.f7769h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f7770i = obtainStyledAttributes.getInt(index, this.f7770i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.f7766e = obtainStyledAttributes.getInt(index, this.f7766e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i12 = obtainStyledAttributes.peekValue(index).type;
                if (i12 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f7775n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f7773l = -2;
                    }
                } else if (i12 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7774m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f7773l = -1;
                    } else {
                        this.f7775n = obtainStyledAttributes.getResourceId(index, -1);
                        this.f7773l = -2;
                    }
                } else {
                    this.f7773l = obtainStyledAttributes.getInteger(index, this.f7773l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f7777p = obtainStyledAttributes.getResourceId(index, this.f7777p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f7778q = obtainStyledAttributes.getResourceId(index, this.f7778q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.f7779r = obtainStyledAttributes.getResourceId(index, this.f7779r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f7780s = obtainStyledAttributes.getResourceId(index, this.f7780s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f7782u = obtainStyledAttributes.getResourceId(index, this.f7782u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f7781t = obtainStyledAttributes.getInteger(index, this.f7781t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public boolean m(int i11) {
        int i12 = this.f7763b;
        return i12 == 1 ? i11 == 0 : i12 == 2 ? i11 == 1 : i12 == 3 && i11 == 0;
    }

    public final void n(e.b bVar, View view) {
        int i11 = this.f7769h;
        if (i11 != -1) {
            bVar.E(i11);
        }
        bVar.I(this.f7765d);
        bVar.G(this.f7773l, this.f7774m, this.f7775n);
        int id2 = view.getId();
        KeyFrames keyFrames = this.f7767f;
        if (keyFrames != null) {
            ArrayList<Key> d11 = keyFrames.d(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator<Key> it2 = d11.iterator();
            while (it2.hasNext()) {
                keyFrames2.c(it2.next().clone().i(id2));
            }
            bVar.t(keyFrames2);
        }
    }

    public String toString() {
        return "ViewTransition(" + Debug.c(this.f7776o, this.f7762a) + ")";
    }
}
