package mf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.SP;
import com.hbg.module.market.widget.view.MarketWidgetView;
import hf.b;
import i6.n;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public Context f29141a;

    /* renamed from: b  reason: collision with root package name */
    public MarketWidgetView f29142b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f29143c;

    /* renamed from: d  reason: collision with root package name */
    public WindowManager.LayoutParams f29144d;

    /* renamed from: e  reason: collision with root package name */
    public int f29145e;

    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public float f29146b;

        /* renamed from: c  reason: collision with root package name */
        public float f29147c;

        /* renamed from: d  reason: collision with root package name */
        public float f29148d;

        /* renamed from: e  reason: collision with root package name */
        public float f29149e;

        /* renamed from: f  reason: collision with root package name */
        public float f29150f;

        /* renamed from: g  reason: collision with root package name */
        public float f29151g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f29152h;

        public a() {
        }

        public final int a() {
            return n.g(q.this.f29141a) > n.f(q.this.f29141a) ? 0 : 1;
        }

        public final void b() {
            if (Math.abs(this.f29148d - this.f29150f) > 10.0f || Math.abs(this.f29149e - this.f29151g) > 10.0f) {
                q.this.f29144d.x = (int) (this.f29148d - this.f29146b);
                q.this.f29144d.y = (int) (this.f29149e - this.f29147c);
                this.f29152h = true;
                q.this.f29143c.updateViewLayout(q.this.f29142b, q.this.f29144d);
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f29148d = motionEvent.getRawX();
            if (1 == a()) {
                this.f29149e = motionEvent.getRawY() - ((float) n.h(q.this.f29141a));
            } else {
                this.f29149e = motionEvent.getRawY();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f29150f = this.f29148d;
                this.f29151g = this.f29149e;
                this.f29146b = motionEvent.getX();
                this.f29147c = motionEvent.getY();
                this.f29152h = false;
            } else if (action == 1) {
                b();
                SP.q("SP_KEY_MARKET_WIDGET_WINDOW_X", q.this.f29144d.x);
                SP.q("SP_KEY_MARKET_WIDGET_WINDOW_Y", q.this.f29144d.y);
                this.f29147c = 0.0f;
                this.f29146b = 0.0f;
                if (!this.f29152h) {
                    this.f29152h = false;
                }
                if (Math.abs(this.f29148d - this.f29150f) <= ((float) q.this.f29145e) && Math.abs(this.f29149e - this.f29151g) <= ((float) q.this.f29145e)) {
                    q.this.f29142b.m(motionEvent.getX(), motionEvent.getY());
                }
            } else if (action == 2) {
                b();
            }
            return true;
        }
    }

    public q(Context context) {
        this.f29141a = context;
        this.f29145e = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void f() {
        MarketWidgetView marketWidgetView;
        MarketWidgetView marketWidgetView2 = this.f29142b;
        if (marketWidgetView2 != null) {
            marketWidgetView2.l();
        }
        WindowManager windowManager = this.f29143c;
        if (windowManager != null && (marketWidgetView = this.f29142b) != null) {
            try {
                windowManager.removeView(marketWidgetView);
                this.f29142b = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void g() {
        if (this.f29142b == null) {
            MarketWidgetView marketWidgetView = new MarketWidgetView(this.f29141a);
            this.f29142b = marketWidgetView;
            marketWidgetView.setOnTouchListener(new a());
        }
    }

    public final void h() {
        i();
        g();
        if (this.f29143c == null) {
            this.f29143c = (WindowManager) this.f29141a.getSystemService("window");
        }
    }

    public final void i() {
        if (this.f29144d == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f29144d = layoutParams;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.flags |= 8;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            layoutParams.x = SP.e("SP_KEY_MARKET_WIDGET_WINDOW_X", 0);
            this.f29144d.y = SP.e("SP_KEY_MARKET_WIDGET_WINDOW_Y", 0);
            WindowManager.LayoutParams layoutParams2 = this.f29144d;
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.format = 1;
        }
    }

    public boolean j() {
        MarketWidgetView marketWidgetView = this.f29142b;
        return (marketWidgetView == null || marketWidgetView.getParent() == null) ? false : true;
    }

    public void k(float f11) {
        MarketWidgetView marketWidgetView = this.f29142b;
        if (marketWidgetView != null) {
            marketWidgetView.setBgAlpha(f11);
        }
    }

    public void l() {
        if (b.u()) {
            h();
            this.f29142b.k();
            try {
                this.f29143c.addView(this.f29142b, this.f29144d);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
