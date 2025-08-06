package com.hbg.module.content.custom;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.module.content.R$color;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import com.hbg.module.libkt.base.ext.c;
import we.b;
import xe.d;

public class FloatView extends FrameLayout implements LifecycleOwner {

    /* renamed from: b  reason: collision with root package name */
    public Context f17992b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f17993c;

    /* renamed from: d  reason: collision with root package name */
    public WindowManager.LayoutParams f17994d;

    /* renamed from: e  reason: collision with root package name */
    public int f17995e;

    /* renamed from: f  reason: collision with root package name */
    public int f17996f;

    /* renamed from: g  reason: collision with root package name */
    public int f17997g;

    /* renamed from: h  reason: collision with root package name */
    public int f17998h;

    /* renamed from: i  reason: collision with root package name */
    public int f17999i;

    /* renamed from: j  reason: collision with root package name */
    public int f18000j;

    /* renamed from: k  reason: collision with root package name */
    public int f18001k;

    /* renamed from: l  reason: collision with root package name */
    public int f18002l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f18003m = false;

    /* renamed from: n  reason: collision with root package name */
    public Handler f18004n;

    /* renamed from: o  reason: collision with root package name */
    public LifecycleRegistry f18005o = new LifecycleRegistry(this);

    public FloatView(Context context) {
        super(context);
        this.f17992b = context;
        this.f18004n = new Handler(context.getMainLooper());
        b.l("floatEvent", d.class).observe(this, new a(this));
        this.f18001k = c.c();
        this.f18002l = c.b();
        int i11 = this.f18001k;
        int i12 = i11 / 2;
        int e11 = (i11 - i12) - e(context, 15.0f);
        this.f17999i = e11;
        this.f17997g = e11;
        int e12 = (this.f18002l - ((i12 * 9) / 16)) - e(context, 50.0f);
        this.f18000j = e12;
        this.f17998h = e12;
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f18003m = true;
        HbgLiveHelper.f18227a.A();
        m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        while (!this.f18003m) {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.f17992b)) {
                this.f18004n.post(new c(this));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(d dVar) {
        if (dVar.a() == 0) {
            HbgLiveHelper.f18227a.A();
        }
        m();
    }

    public boolean d() {
        if (this.f17993c != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (getParent() == null) {
                        this.f17993c.addView(this, this.f17994d);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (isAttachedToWindow()) {
                return false;
            } else {
                this.f17993c.addView(this, this.f17994d);
                return true;
            }
        }
        return false;
    }

    public int e(Context context, float f11) {
        return (int) TypedValue.applyDimension(1, f11, context.getResources().getDisplayMetrics());
    }

    public double f(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return (double) (identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0);
    }

    public WindowManager g(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public Lifecycle getLifecycle() {
        return this.f18005o;
    }

    public final void h() {
        setBackgroundResource(R$color.text_black);
        int e11 = e(getContext(), 2.0f);
        setPadding(e11, e11, e11, e11);
        i();
        new Thread(new b(this)).start();
    }

    public final void i() {
        this.f17993c = g(getContext().getApplicationContext());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f17994d = layoutParams;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.format = -3;
        layoutParams.flags = 8;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        int i11 = this.f18001k / 2;
        layoutParams.width = i11;
        layoutParams.height = (i11 * 9) / 16;
        layoutParams.x = this.f17997g;
        layoutParams.y = this.f17998h;
    }

    public boolean m() {
        HbgLiveHelper.f18227a.H(false);
        this.f18003m = true;
        if (this.f17993c != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (getParent() != null) {
                        this.f17993c.removeViewImmediate(this);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (!isAttachedToWindow()) {
                return false;
            } else {
                this.f17993c.removeViewImmediate(this);
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f17995e = (int) motionEvent.getRawX();
            this.f17996f = (int) motionEvent.getRawY();
            this.f17997g = (int) motionEvent.getX();
            this.f17998h = (int) (((double) motionEvent.getY()) + f(getContext()));
            return false;
        } else if (action != 2) {
            return false;
        } else {
            float abs = Math.abs(motionEvent.getRawX() - ((float) this.f17995e));
            float abs2 = Math.abs(motionEvent.getRawY() - ((float) this.f17996f));
            if (abs > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop()) || abs2 > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            this.f17994d.x = Math.max(e(this.f17992b, 10.0f), Math.min(((int) motionEvent.getRawX()) - this.f17997g, this.f17999i));
            this.f17994d.y = Math.min(((int) motionEvent.getRawY()) - this.f17998h, this.f18000j);
            this.f17993c.updateViewLayout(this, this.f17994d);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (i11 == 0) {
            this.f18005o.i(Lifecycle.Event.ON_START);
            this.f18005o.i(Lifecycle.Event.ON_RESUME);
        } else if (i11 == 8 || i11 == 4) {
            this.f18005o.i(Lifecycle.Event.ON_PAUSE);
            this.f18005o.i(Lifecycle.Event.ON_STOP);
        }
    }
}
