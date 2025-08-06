package com.jumio.core.face;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.res.ResourcesCompat;
import com.huobi.view.roundimg.RoundedDrawable;
import com.jumio.core.MobileContext;
import com.jumio.core.R;
import d10.p;
import java.util.Map;
import javax.security.auth.Destroyable;
import jumio.core.i1;
import kotlin.jvm.internal.Lambda;

public final class FaceHelpAnimation implements MotionLayout.k, Destroyable {

    /* renamed from: a  reason: collision with root package name */
    public MobileContext f39215a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, Integer> f39216b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39217c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39218d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39219e;

    /* renamed from: f  reason: collision with root package name */
    public MotionLayout f39220f;

    /* renamed from: g  reason: collision with root package name */
    public int f39221g = 1;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f39222h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f39223i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f39224j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f39225k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f39226l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f39227m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f39228n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f39229o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f39230p;

    /* renamed from: q  reason: collision with root package name */
    public ImageView f39231q;

    public static final class a extends Lambda implements p<TypedArray, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39232a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((TypedArray) obj).getColor(((Number) obj2).intValue(), -1));
        }
    }

    public FaceHelpAnimation(MobileContext mobileContext) {
        this.f39215a = mobileContext;
        this.f39216b = a(mobileContext);
    }

    public static Map a(MobileContext mobileContext) {
        return mobileContext.getCustomizations(R.style.Jumio_Face_Animation_Customization, R.attr.jumio_face_animation_customization, new int[]{R.attr.jumio_face_animation_foreground}, a.f39232a);
    }

    public final void applyCustomizations(Context context) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Integer num = this.f39216b.get(Integer.valueOf(R.attr.jumio_face_animation_foreground));
        int intValue = num != null ? num.intValue() : RoundedDrawable.DEFAULT_BORDER_COLOR;
        MotionLayout motionLayout = this.f39220f;
        boolean z11 = false;
        if (motionLayout != null) {
            motionLayout.setBackgroundColor(0);
        }
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = new TypedValue();
        int i11 = R.style.Jumio_Face_Animation_Customization;
        if (theme != null && theme.resolveAttribute(R.attr.jumio_face_animation_customization, typedValue, true)) {
            z11 = true;
        }
        if (z11) {
            i11 = typedValue.data;
        }
        Drawable f11 = ResourcesCompat.f(context.getResources(), R.drawable.jumio_ic_face_oval_mask, new ContextThemeWrapper(context, i11).getTheme());
        ImageView imageView = this.f39223i;
        if (imageView != null) {
            imageView.setImageDrawable(f11);
        }
        ImageView imageView2 = this.f39226l;
        if (!(imageView2 == null || (drawable6 = imageView2.getDrawable()) == null)) {
            u0.a.n(drawable6, intValue);
        }
        ImageView imageView3 = this.f39228n;
        Drawable drawable7 = null;
        if (imageView3 != null) {
            ImageView imageView4 = this.f39226l;
            imageView3.setImageDrawable(imageView4 != null ? imageView4.getDrawable() : null);
        }
        ImageView imageView5 = this.f39229o;
        if (imageView5 != null) {
            ImageView imageView6 = this.f39226l;
            imageView5.setImageDrawable(imageView6 != null ? imageView6.getDrawable() : null);
        }
        ImageView imageView7 = this.f39227m;
        if (imageView7 != null) {
            ImageView imageView8 = this.f39226l;
            if (imageView8 != null) {
                drawable7 = imageView8.getDrawable();
            }
            imageView7.setImageDrawable(drawable7);
        }
        ImageView imageView9 = this.f39222h;
        if (!(imageView9 == null || (drawable5 = imageView9.getDrawable()) == null)) {
            u0.a.n(drawable5, intValue);
        }
        ImageView imageView10 = this.f39224j;
        if (!(imageView10 == null || (drawable4 = imageView10.getDrawable()) == null)) {
            u0.a.n(drawable4, intValue);
        }
        ImageView imageView11 = this.f39225k;
        if (!(imageView11 == null || (drawable3 = imageView11.getDrawable()) == null)) {
            u0.a.n(drawable3, intValue);
        }
        ImageView imageView12 = this.f39230p;
        if (!(imageView12 == null || (drawable2 = imageView12.getDrawable()) == null)) {
            u0.a.n(drawable2, intValue);
        }
        ImageView imageView13 = this.f39231q;
        if (imageView13 != null && (drawable = imageView13.getDrawable()) != null) {
            u0.a.n(drawable, intValue);
        }
    }

    public final synchronized void configure(MotionLayout motionLayout, boolean z11) {
        if (this.f39218d) {
            stop();
        }
        this.f39220f = motionLayout;
        this.f39222h = (ImageView) motionLayout.findViewById(R.id.iv_face);
        this.f39223i = (ImageView) motionLayout.findViewById(R.id.iv_face_oval_mask);
        this.f39228n = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_bl);
        this.f39229o = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_br);
        this.f39226l = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tl);
        this.f39227m = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tr);
        this.f39224j = (ImageView) motionLayout.findViewById(R.id.iv_checkmark);
        this.f39225k = (ImageView) motionLayout.findViewById(R.id.iv_checkmark_circle);
        this.f39230p = (ImageView) motionLayout.findViewById(R.id.iv_progress_lane);
        this.f39231q = (ImageView) motionLayout.findViewById(R.id.iv_progress_bar);
        this.f39217c = z11;
        this.f39219e = true;
    }

    public void destroy() {
        stop();
        this.f39220f = null;
        this.f39222h = null;
        this.f39223i = null;
        this.f39224j = null;
        this.f39225k = null;
        this.f39226l = null;
        this.f39227m = null;
        this.f39228n = null;
        this.f39229o = null;
        this.f39230p = null;
        this.f39231q = null;
    }

    public final MobileContext getContext() {
        return this.f39215a;
    }

    public boolean isDestroyed() {
        return !this.f39218d;
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        if (this.f39218d) {
            if (this.f39217c) {
                int a11 = i1.a(this.f39221g);
                if (a11 == 0) {
                    this.f39221g = 2;
                    MotionLayout motionLayout2 = this.f39220f;
                    if (motionLayout2 != null) {
                        motionLayout2.o0(R.id.start, R.id.appear);
                    }
                } else if (a11 == 1) {
                    this.f39221g = 3;
                    MotionLayout motionLayout3 = this.f39220f;
                    if (motionLayout3 != null) {
                        motionLayout3.o0(R.id.appear, R.id.align);
                    }
                } else if (a11 == 2) {
                    this.f39221g = 4;
                    MotionLayout motionLayout4 = this.f39220f;
                    if (motionLayout4 != null) {
                        motionLayout4.o0(R.id.align, R.id.focus);
                    }
                } else if (a11 == 3) {
                    this.f39221g = 5;
                    MotionLayout motionLayout5 = this.f39220f;
                    if (motionLayout5 != null) {
                        motionLayout5.o0(R.id.focus, R.id.flash);
                    }
                } else if (a11 == 4) {
                    this.f39221g = 6;
                    MotionLayout motionLayout6 = this.f39220f;
                    if (motionLayout6 != null) {
                        motionLayout6.o0(R.id.flash, R.id.success);
                    }
                } else if (a11 == 5) {
                    this.f39221g = 1;
                    MotionLayout motionLayout7 = this.f39220f;
                    if (motionLayout7 != null) {
                        motionLayout7.o0(R.id.success, R.id.start);
                    }
                }
            } else {
                int a12 = i1.a(this.f39221g);
                if (a12 == 0) {
                    this.f39221g = 2;
                    MotionLayout motionLayout8 = this.f39220f;
                    if (motionLayout8 != null) {
                        motionLayout8.o0(R.id.start, R.id.appear);
                    }
                } else if (a12 == 1) {
                    this.f39221g = 3;
                    MotionLayout motionLayout9 = this.f39220f;
                    if (motionLayout9 != null) {
                        motionLayout9.o0(R.id.appear, R.id.align);
                    }
                } else if (a12 == 2) {
                    this.f39221g = 4;
                    MotionLayout motionLayout10 = this.f39220f;
                    if (motionLayout10 != null) {
                        motionLayout10.o0(R.id.align, R.id.focus);
                    }
                } else if (a12 == 3) {
                    this.f39221g = 6;
                    MotionLayout motionLayout11 = this.f39220f;
                    if (motionLayout11 != null) {
                        motionLayout11.o0(R.id.focus, R.id.success);
                    }
                } else if (a12 == 5) {
                    this.f39221g = 1;
                    MotionLayout motionLayout12 = this.f39220f;
                    if (motionLayout12 != null) {
                        motionLayout12.o0(R.id.success, R.id.start);
                    }
                }
            }
            MotionLayout motionLayout13 = this.f39220f;
            if (motionLayout13 != null) {
                motionLayout13.s0();
            }
        }
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
    }

    public final synchronized void pause() {
        if (this.f39219e && this.f39218d) {
            for (View view : CollectionsKt__CollectionsJVMKt.e(this.f39220f)) {
                if (view != null) {
                    if (view.getAlpha() == 1.0f) {
                        view.setAlpha(0.5f);
                    }
                }
            }
        }
    }

    public final void setContext(MobileContext mobileContext) {
        this.f39215a = mobileContext;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void start() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f39219e     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            boolean r0 = r1.f39218d     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0011
            r0 = 1
            r1.f39218d = r0     // Catch:{ all -> 0x0013 }
            r1.a()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.face.FaceHelpAnimation.start():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void stop() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f39219e     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            boolean r0 = r3.f39218d     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            r0 = 1
            r3.f39221g = r0     // Catch:{ all -> 0x0027 }
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f39220f     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x001b
            int r1 = com.jumio.core.R.id.start     // Catch:{ all -> 0x0027 }
            androidx.constraintlayout.widget.ConstraintSet r2 = r0.c0(r1)     // Catch:{ all -> 0x0027 }
            r0.A0(r1, r2)     // Catch:{ all -> 0x0027 }
        L_0x001b:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f39220f     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0022
            r0.u0()     // Catch:{ all -> 0x0027 }
        L_0x0022:
            r0 = 0
            r3.f39218d = r0     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r3)
            return
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.face.FaceHelpAnimation.stop():void");
    }

    public final synchronized void a() {
        if (this.f39221g == 1) {
            MotionLayout motionLayout = this.f39220f;
            if (motionLayout != null) {
                motionLayout.setTransitionListener(this);
            }
            MotionLayout motionLayout2 = this.f39220f;
            if (motionLayout2 != null) {
                motionLayout2.o0(R.id.start, R.id.appear);
            }
            this.f39221g = 2;
            this.f39218d = true;
            new Handler(Looper.getMainLooper()).postDelayed(new jw.a(this), 50);
        }
    }

    public static final void a(FaceHelpAnimation faceHelpAnimation) {
        MotionLayout motionLayout = faceHelpAnimation.f39220f;
        if (motionLayout != null) {
            motionLayout.s0();
        }
    }
}
