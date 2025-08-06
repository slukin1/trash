package com.huobi.uiKit.window.floatkeeper.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.e;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000 D2\u00020\u0001:\u0002E!B)\b\u0007\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u000203¢\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u001c\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\bH\u0014J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0002R$\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010(R\u0016\u0010+\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010*R\u0016\u0010,\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010*R\u0016\u0010-\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010*R\u0016\u0010.\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010*R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010(R\u001c\u00102\u001a\b\u0018\u000100R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u00109\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00105R\u0016\u0010:\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010*R\u0016\u0010<\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010*¨\u0006F"}, d2 = {"Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "isLeft", "isLandscape", "", "j", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "ev", "onInterceptTouchEvent", "Landroid/view/View;", "child", "addView", "autoMoveToEdge", "setAutoMoveToEdge", "onAttachedToWindow", "e", "n", "c", "m", "d", "g", "", "deltaX", "deltaY", "i", "h", "f", "b", "Landroid/view/View;", "getChildView", "()Landroid/view/View;", "setChildView", "(Landroid/view/View;)V", "childView", "Z", "dragEnable", "F", "mOriginalRawX", "mOriginalRawY", "mOriginalX", "mOriginalY", "isNearestLeft", "Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView$b;", "Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView$b;", "mMoveAnimator", "", "k", "I", "mRootWidth", "l", "mRootHeight", "mStatusBarHeight", "mPortraitY", "o", "touchDownX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "p", "a", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public class FloatingContainerView extends FrameLayout {

    /* renamed from: p  reason: collision with root package name */
    public static final a f83650p = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public View f83651b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f83652c;

    /* renamed from: d  reason: collision with root package name */
    public float f83653d;

    /* renamed from: e  reason: collision with root package name */
    public float f83654e;

    /* renamed from: f  reason: collision with root package name */
    public float f83655f;

    /* renamed from: g  reason: collision with root package name */
    public float f83656g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f83657h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f83658i;

    /* renamed from: j  reason: collision with root package name */
    public b f83659j;

    /* renamed from: k  reason: collision with root package name */
    public int f83660k;

    /* renamed from: l  reason: collision with root package name */
    public int f83661l;

    /* renamed from: m  reason: collision with root package name */
    public int f83662m;

    /* renamed from: n  reason: collision with root package name */
    public float f83663n;

    /* renamed from: o  reason: collision with root package name */
    public float f83664o;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView$a;", "", "", "MARGIN_EDGE", "I", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView$b;", "Ljava/lang/Runnable;", "", "x", "y", "", "a", "run", "b", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "c", "F", "destinationX", "d", "destinationY", "", "e", "J", "startingTime", "<init>", "(Lcom/huobi/uiKit/window/floatkeeper/core/FloatingContainerView;)V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
    public final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f83665b = new Handler(Looper.getMainLooper());

        /* renamed from: c  reason: collision with root package name */
        public float f83666c;

        /* renamed from: d  reason: collision with root package name */
        public float f83667d;

        /* renamed from: e  reason: collision with root package name */
        public long f83668e;

        public b() {
        }

        public final void a(float f11, float f12) {
            this.f83666c = f11;
            this.f83667d = f12;
            this.f83668e = System.currentTimeMillis();
            this.f83665b.post(this);
        }

        public final void b() {
            this.f83665b.removeCallbacks(this);
        }

        public void run() {
            if (FloatingContainerView.this.getRootView() != null && FloatingContainerView.this.getRootView().getParent() != null) {
                float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f83668e)) / 400.0f);
                FloatingContainerView.this.i((this.f83666c - FloatingContainerView.this.getX()) * min, (this.f83667d - FloatingContainerView.this.getY()) * min);
                if (min < 1.0f) {
                    this.f83665b.post(this);
                }
            }
        }
    }

    public FloatingContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatingContainerView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void k(FloatingContainerView floatingContainerView, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = floatingContainerView.g();
            }
            if ((i11 & 2) != 0) {
                z12 = false;
            }
            floatingContainerView.j(z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToEdge");
    }

    public static final void l(FloatingContainerView floatingContainerView, boolean z11) {
        floatingContainerView.m();
        floatingContainerView.j(floatingContainerView.f83658i, z11);
    }

    public void addView(View view) {
        removeAllViews();
        this.f83651b = view;
        super.addView(view);
    }

    public final void c(MotionEvent motionEvent) {
        this.f83655f = getX();
        this.f83656g = getY();
        this.f83653d = motionEvent.getRawX();
        this.f83654e = motionEvent.getRawY();
    }

    public final void d() {
        this.f83663n = 0.0f;
    }

    public final void e() {
        this.f83659j = new b();
        this.f83662m = e.b();
        setClickable(true);
    }

    public final void f(MotionEvent motionEvent) {
        c(motionEvent);
        m();
        b bVar = this.f83659j;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final boolean g() {
        boolean z11 = getX() < ((float) (this.f83660k / 2));
        this.f83658i = z11;
        return z11;
    }

    public final View getChildView() {
        return this.f83651b;
    }

    public final void h(boolean z11) {
        if (z11) {
            this.f83663n = getY();
        }
    }

    public final void i(float f11, float f12) {
        setX(getX() + f11);
        setY(getY() + f12);
    }

    public final void j(boolean z11, boolean z12) {
        float f11 = z11 ? 0.0f : ((float) this.f83660k) - 0.0f;
        float y11 = getY();
        if (!z12) {
            float f12 = this.f83663n;
            if (!(f12 == 0.0f)) {
                d();
                y11 = f12;
            }
        }
        b bVar = this.f83659j;
        if (bVar != null) {
            bVar.a(f11, RangesKt___RangesKt.f(RangesKt___RangesKt.c((float) this.f83662m, y11), (float) (this.f83661l - getHeight())));
        }
    }

    public final void m() {
        if (getParent() instanceof ViewGroup) {
            ViewParent parent = getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            this.f83660k = viewGroup.getWidth() - getWidth();
            this.f83661l = viewGroup.getHeight();
        }
    }

    public final void n(MotionEvent motionEvent) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        float rawX = (this.f83655f + motionEvent.getRawX()) - this.f83653d;
        if (layoutParams2.width == -2) {
            if (rawX < 0.0f) {
                rawX = 0.0f;
            }
            int i11 = this.f83660k;
            if (rawX > ((float) i11)) {
                rawX = (float) (i11 + 0);
            }
            setX(rawX);
        }
        float rawY = (this.f83656g + motionEvent.getRawY()) - this.f83654e;
        if (layoutParams2.height == -2) {
            int i12 = this.f83662m;
            if (rawY < ((float) i12)) {
                rawY = (float) i12;
            }
            if (rawY > ((float) (this.f83661l - getHeight()))) {
                rawY = (float) (this.f83661l - getHeight());
            }
            setY(rawY);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            boolean z11 = configuration.orientation == 2;
            h(z11);
            ViewParent parent = getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).post(new cu.a(this, z11));
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f83652c) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f83664o = motionEvent.getX();
            f(motionEvent);
            return false;
        } else if (actionMasked == 1 || actionMasked != 2 || Math.abs(this.f83664o - motionEvent.getX()) < ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            c(motionEvent);
            m();
            b bVar = this.f83659j;
            if (bVar != null) {
                bVar.b();
            }
        } else if (action == 1) {
            d();
            if (this.f83657h) {
                k(this, false, false, 3, (Object) null);
            }
        } else if (action == 2) {
            n(motionEvent);
        }
        return true;
    }

    public final void setAutoMoveToEdge(boolean z11) {
        this.f83657h = z11;
    }

    public final void setChildView(View view) {
        this.f83651b = view;
    }

    public FloatingContainerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f83657h = true;
        this.f83658i = true;
        e();
    }
}
