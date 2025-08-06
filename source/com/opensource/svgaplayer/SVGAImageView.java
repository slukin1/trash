package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.huochat.community.network.domain.DomainTool;
import com.opensource.svgaplayer.SVGAParser;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0003n1oB'\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010k\u001a\u000209¢\u0006\u0004\bl\u0010mJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0006\u0010 \u001a\u00020\u0006J\u001a\u0010!\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010&\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010)\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010'J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\u0012\u0010/\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010-H\u0017J\b\u00100\u001a\u00020\u0006H\u0014R\u0014\u00103\u001a\u00020\b8\u0002XD¢\u0006\u0006\n\u0004\b1\u00102R$\u00107\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00148\u0006@BX\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010@\u001a\u0002098\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010G\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bA\u00106\u0012\u0004\bE\u0010F\u001a\u0004\bB\u00108\"\u0004\bC\u0010DR\"\u0010K\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u00106\u001a\u0004\bI\u00108\"\u0004\bJ\u0010DR\"\u0010S\u001a\u00020L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010Z\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010]R\u0016\u0010_\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00106R\u0016\u0010`\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00106R\u0014\u0010c\u001a\u00020a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010bR\u0014\u0010f\u001a\u00020d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010eR\u0016\u0010g\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010;R\u0016\u0010h\u001a\u0002098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010;¨\u0006p"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "Lcom/opensource/svgaplayer/d;", "getSVGADrawable", "Landroid/util/AttributeSet;", "attrs", "", "k", "", "source", "n", "Ljava/lang/ref/WeakReference;", "ref", "Lcom/opensource/svgaplayer/SVGAParser$c;", "i", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "s", "Lzx/c;", "range", "", "reverse", "o", "q", "", "j", "Landroid/animation/ValueAnimator;", "animator", "m", "Landroid/animation/Animator;", "animation", "l", "r", "t", "h", "u", "clear", "v", "setVideoItem", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicItem", "p", "Lcom/opensource/svgaplayer/c;", "clickListener", "setOnAnimKeyClickListener", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "onDetachedFromWindow", "b", "Ljava/lang/String;", "TAG", "<set-?>", "c", "Z", "isAnimating", "()Z", "", "d", "I", "getLoops", "()I", "setLoops", "(I)V", "loops", "e", "getClearsAfterStop", "setClearsAfterStop", "(Z)V", "clearsAfterStop$annotations", "()V", "clearsAfterStop", "f", "getClearsAfterDetached", "setClearsAfterDetached", "clearsAfterDetached", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "g", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "fillMode", "Lcom/opensource/svgaplayer/b;", "Lcom/opensource/svgaplayer/b;", "getCallback", "()Lcom/opensource/svgaplayer/b;", "setCallback", "(Lcom/opensource/svgaplayer/b;)V", "callback", "Landroid/animation/ValueAnimator;", "mAnimator", "Lcom/opensource/svgaplayer/c;", "mItemClickAreaListener", "mAntiAlias", "mAutoPlay", "Lcom/opensource/svgaplayer/SVGAImageView$a;", "Lcom/opensource/svgaplayer/SVGAImageView$a;", "mAnimatorListener", "Lcom/opensource/svgaplayer/SVGAImageView$b;", "Lcom/opensource/svgaplayer/SVGAImageView$b;", "mAnimatorUpdateListener", "mStartFrame", "mEndFrame", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "FillMode", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class SVGAImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public final String f28480b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28481c;

    /* renamed from: d  reason: collision with root package name */
    public int f28482d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28483e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28484f;

    /* renamed from: g  reason: collision with root package name */
    public FillMode f28485g;

    /* renamed from: h  reason: collision with root package name */
    public b f28486h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f28487i;

    /* renamed from: j  reason: collision with root package name */
    public c f28488j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f28489k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f28490l;

    /* renamed from: m  reason: collision with root package name */
    public final a f28491m;

    /* renamed from: n  reason: collision with root package name */
    public final b f28492n;

    /* renamed from: o  reason: collision with root package name */
    public int f28493o;

    /* renamed from: p  reason: collision with root package name */
    public int f28494p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "", "(Ljava/lang/String;I)V", "Backward", "Forward", "Clear", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum FillMode {
        Backward,
        Forward,
        Clear
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$a;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "Ljava/lang/ref/WeakReference;", "Lcom/opensource/svgaplayer/SVGAImageView;", "b", "Ljava/lang/ref/WeakReference;", "weakReference", "view", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<SVGAImageView> f28495b;

        public a(SVGAImageView sVGAImageView) {
            this.f28495b = new WeakReference<>(sVGAImageView);
        }

        public void onAnimationCancel(Animator animator) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28495b.get();
            if (sVGAImageView != null) {
                sVGAImageView.f28481c = false;
            }
        }

        public void onAnimationEnd(Animator animator) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28495b.get();
            if (sVGAImageView != null) {
                sVGAImageView.l(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            b callback;
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28495b.get();
            if (sVGAImageView != null && (callback = sVGAImageView.getCallback()) != null) {
                callback.b();
            }
        }

        public void onAnimationStart(Animator animator) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28495b.get();
            if (sVGAImageView != null) {
                sVGAImageView.f28481c = true;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$b;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "Ljava/lang/ref/WeakReference;", "Lcom/opensource/svgaplayer/SVGAImageView;", "b", "Ljava/lang/ref/WeakReference;", "weakReference", "view", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<SVGAImageView> f28496b;

        public b(SVGAImageView sVGAImageView) {
            this.f28496b = new WeakReference<>(sVGAImageView);
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28496b.get();
            if (sVGAImageView != null) {
                sVGAImageView.m(valueAnimator);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/opensource/svgaplayer/SVGAImageView$c", "Lcom/opensource/svgaplayer/SVGAParser$c;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "", "a", "onError", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class c implements SVGAParser.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f28497a;

        public c(WeakReference weakReference) {
            this.f28497a = weakReference;
        }

        public void a(SVGAVideoEntity sVGAVideoEntity) {
            SVGAImageView sVGAImageView = (SVGAImageView) this.f28497a.get();
            if (sVGAImageView != null) {
                sVGAImageView.s(sVGAVideoEntity);
            }
        }

        public void onError() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SVGAImageView f28498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f28499c;

        public d(SVGAImageView sVGAImageView, SVGAVideoEntity sVGAVideoEntity) {
            this.f28498b = sVGAImageView;
            this.f28499c = sVGAVideoEntity;
        }

        public final void run() {
            this.f28499c.x(this.f28498b.f28489k);
            this.f28498b.setVideoItem(this.f28499c);
            d c11 = this.f28498b.getSVGADrawable();
            if (c11 != null) {
                c11.g(this.f28498b.getScaleType());
            }
            if (this.f28498b.f28490l) {
                this.f28498b.r();
            }
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SVGAImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* access modifiers changed from: private */
    public final d getSVGADrawable() {
        Drawable drawable = getDrawable();
        if (!(drawable instanceof d)) {
            drawable = null;
        }
        return (d) drawable;
    }

    public final b getCallback() {
        return this.f28486h;
    }

    public final boolean getClearsAfterDetached() {
        return this.f28484f;
    }

    public final boolean getClearsAfterStop() {
        return this.f28483e;
    }

    public final FillMode getFillMode() {
        return this.f28485g;
    }

    public final int getLoops() {
        return this.f28482d;
    }

    public final void h() {
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(true);
        }
        d sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.a();
        }
        setImageDrawable((Drawable) null);
    }

    public final SVGAParser.c i(WeakReference<SVGAImageView> weakReference) {
        return new c(weakReference);
    }

    public final double j() {
        double d11 = 1.0d;
        try {
            Class<?> cls = Class.forName("android.animation.ValueAnimator");
            Method declaredMethod = cls.getDeclaredMethod("getDurationScale", new Class[0]);
            if (declaredMethod == null) {
                return 1.0d;
            }
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            if (invoke != null) {
                double floatValue = (double) ((Float) invoke).floatValue();
                if (floatValue != 0.0d) {
                    return floatValue;
                }
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod("setDurationScale", new Class[]{Float.TYPE});
                    if (declaredMethod2 == null) {
                        return floatValue;
                    }
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls, new Object[]{Float.valueOf(1.0f)});
                    ay.b.f26389a.e(this.f28480b, "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                    return 1.0d;
                } catch (Exception e11) {
                    e = e11;
                    d11 = floatValue;
                    e.printStackTrace();
                    return d11;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return d11;
        }
    }

    public final void k(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.SVGAImageView, 0, 0);
        this.f28482d = obtainStyledAttributes.getInt(R$styleable.SVGAImageView_loopCount, 0);
        this.f28483e = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterStop, false);
        this.f28484f = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_clearsAfterDetached, false);
        this.f28489k = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_antiAlias, true);
        this.f28490l = obtainStyledAttributes.getBoolean(R$styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R$styleable.SVGAImageView_fillMode);
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        this.f28485g = FillMode.Backward;
                        break;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        this.f28485g = FillMode.Forward;
                        break;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        this.f28485g = FillMode.Clear;
                        break;
                    }
                    break;
            }
        }
        String string2 = obtainStyledAttributes.getString(R$styleable.SVGAImageView_source);
        if (string2 != null) {
            n(string2);
        }
        obtainStyledAttributes.recycle();
    }

    public final void l(Animator animator) {
        this.f28481c = false;
        u();
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            int i11 = e.f28589a[this.f28485g.ordinal()];
            if (i11 == 1) {
                sVGADrawable.f(this.f28493o);
            } else if (i11 == 2) {
                sVGADrawable.f(this.f28494p);
            } else if (i11 == 3) {
                sVGADrawable.e(true);
            }
        }
        b bVar = this.f28486h;
        if (bVar != null) {
            bVar.onFinished();
        }
    }

    public final void m(ValueAnimator valueAnimator) {
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            Object animatedValue = valueAnimator != null ? valueAnimator.getAnimatedValue() : null;
            if (animatedValue != null) {
                sVGADrawable.f(((Integer) animatedValue).intValue());
                double b11 = ((double) (sVGADrawable.b() + 1)) / ((double) sVGADrawable.d().n());
                b bVar = this.f28486h;
                if (bVar != null) {
                    bVar.a(sVGADrawable.b(), b11);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final void n(String str) {
        WeakReference weakReference = new WeakReference(this);
        SVGAParser sVGAParser = new SVGAParser(getContext());
        if (StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX_HTTP, false, 2, (Object) null) || StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX, false, 2, (Object) null)) {
            SVGAParser.s(sVGAParser, new URL(str), i(weakReference), (SVGAParser.d) null, 4, (Object) null);
            return;
        }
        SVGAParser.n(sVGAParser, str, i(weakReference), (SVGAParser.d) null, 4, (Object) null);
    }

    public final void o(zx.c cVar, boolean z11) {
        ay.b.f26389a.e(this.f28480b, "================ start animation ================");
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            q();
            this.f28493o = Math.max(0, 0);
            SVGAVideoEntity d11 = sVGADrawable.d();
            int min = Math.min(d11.n() - 1, (Integer.MAX_VALUE + 0) - 1);
            this.f28494p = min;
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f28493o, min});
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration((long) (((double) (((this.f28494p - this.f28493o) + 1) * (1000 / d11.m()))) / j()));
            int i11 = this.f28482d;
            ofInt.setRepeatCount(i11 <= 0 ? 99999 : i11 - 1);
            ofInt.addUpdateListener(this.f28492n);
            ofInt.addListener(this.f28491m);
            if (z11) {
                ofInt.reverse();
            } else {
                ofInt.start();
            }
            this.f28487i = ofInt;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v(this.f28484f);
        if (this.f28484f) {
            h();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return super.onTouchEvent(motionEvent);
        }
        for (Map.Entry next : sVGADrawable.c().j().entrySet()) {
            String str = (String) next.getKey();
            int[] iArr = (int[]) next.getValue();
            if (motionEvent.getX() >= ((float) iArr[0]) && motionEvent.getX() <= ((float) iArr[2]) && motionEvent.getY() >= ((float) iArr[1]) && motionEvent.getY() <= ((float) iArr[3]) && (cVar = this.f28488j) != null) {
                cVar.onClick(str);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(SVGAVideoEntity sVGAVideoEntity, SVGADynamicEntity sVGADynamicEntity) {
        if (sVGAVideoEntity == null) {
            setImageDrawable((Drawable) null);
            return;
        }
        if (sVGADynamicEntity == null) {
            sVGADynamicEntity = new SVGADynamicEntity();
        }
        d dVar = new d(sVGAVideoEntity, sVGADynamicEntity);
        dVar.e(true);
        setImageDrawable(dVar);
    }

    public final void q() {
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.e(false);
            sVGADrawable.g(getScaleType());
        }
    }

    public final void r() {
        t((zx.c) null, false);
    }

    public final void s(SVGAVideoEntity sVGAVideoEntity) {
        post(new d(this, sVGAVideoEntity));
    }

    public final void setCallback(b bVar) {
        this.f28486h = bVar;
    }

    public final void setClearsAfterDetached(boolean z11) {
        this.f28484f = z11;
    }

    public final void setClearsAfterStop(boolean z11) {
        this.f28483e = z11;
    }

    public final void setFillMode(FillMode fillMode) {
        this.f28485g = fillMode;
    }

    public final void setLoops(int i11) {
        this.f28482d = i11;
    }

    public final void setOnAnimKeyClickListener(c cVar) {
        this.f28488j = cVar;
    }

    public final void setVideoItem(SVGAVideoEntity sVGAVideoEntity) {
        p(sVGAVideoEntity, new SVGADynamicEntity());
    }

    public final void t(zx.c cVar, boolean z11) {
        v(false);
        o(cVar, z11);
    }

    public final void u() {
        v(this.f28483e);
    }

    public final void v(boolean z11) {
        ValueAnimator valueAnimator = this.f28487i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f28487i;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.f28487i;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        d sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.h();
        }
        d sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.e(z11);
        }
    }

    public SVGAImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f28480b = "SVGAImageView";
        this.f28485g = FillMode.Forward;
        this.f28489k = true;
        this.f28490l = true;
        this.f28491m = new a(this);
        this.f28492n = new b(this);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
        if (attributeSet != null) {
            k(attributeSet);
        }
    }
}
