package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import java.util.Timer;
import java.util.TimerTask;

public class CouponCountDown extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public CouponCountDownView f79673b;

    /* renamed from: c  reason: collision with root package name */
    public CouponCountDownView f79674c;

    /* renamed from: d  reason: collision with root package name */
    public CouponCountDownView f79675d;

    /* renamed from: e  reason: collision with root package name */
    public CouponCountDownView f79676e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f79677f;

    /* renamed from: g  reason: collision with root package name */
    public long f79678g;

    /* renamed from: h  reason: collision with root package name */
    public long f79679h = 60000;

    /* renamed from: i  reason: collision with root package name */
    public long f79680i = 1000;

    /* renamed from: j  reason: collision with root package name */
    public b f79681j;

    public class a extends TimerTask {
        public a() {
        }

        public void run() {
            CouponCountDown.this.c();
        }
    }

    public interface b {
        void a();
    }

    public CouponCountDown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.coupon_count_down, this, true);
        this.f79673b = (CouponCountDownView) findViewById(R$id.prime_count_down_aim_view_hour);
        this.f79674c = (CouponCountDownView) findViewById(R$id.prime_count_down_aim_view_hour_1);
        this.f79675d = (CouponCountDownView) findViewById(R$id.prime_count_down_aim_view_min);
        this.f79676e = (CouponCountDownView) findViewById(R$id.prime_count_down_aim_view_min_1);
        this.f79673b.setValid(true);
        this.f79674c.setValid(true);
        this.f79675d.setValid(true);
        this.f79676e.setValid(true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.global_text_size_12);
        this.f79673b.setTextSize(dimensionPixelSize);
        this.f79674c.setTextSize(dimensionPixelSize);
        this.f79675d.setTextSize(dimensionPixelSize);
        this.f79676e.setTextSize(dimensionPixelSize);
        this.f79673b.setMax(9);
        this.f79674c.setMax(9);
        this.f79675d.setMax(9);
        this.f79676e.setMax(9);
        this.f79673b.j(0, false);
        this.f79674c.j(0, false);
        this.f79675d.j(0, false);
        this.f79676e.j(0, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(int i11, int i12, int i13, int i14) {
        b bVar;
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0 && (bVar = this.f79681j) != null) {
            bVar.a();
            Timer timer = this.f79677f;
            if (timer != null) {
                timer.cancel();
                this.f79677f = null;
            }
        }
        this.f79673b.j(i11, true);
        this.f79674c.j(i12, true);
        this.f79675d.j(i13, true);
        this.f79676e.j(i14, true);
    }

    public final void c() {
        long j11 = this.f79678g - 1000;
        this.f79678g = j11;
        long j12 = this.f79679h;
        long j13 = j11 / j12;
        long j14 = (j11 % j12) / this.f79680i;
        this.f79675d.post(new vp.b(this, (int) (j13 / 10), (int) (j13 % 10), (int) (j14 / 10), (int) (j14 % 10)));
    }

    public void e(long j11) {
        Timer timer = this.f79677f;
        if (timer != null) {
            timer.cancel();
            this.f79677f = null;
        }
        this.f79678g = j11;
        Timer timer2 = new Timer();
        this.f79677f = timer2;
        timer2.schedule(new a(), 1000, 1000);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Timer timer = this.f79677f;
        if (timer != null) {
            timer.cancel();
            this.f79677f = null;
        }
    }

    public void setCountDownTextColor(int i11) {
        this.f79673b.setTextColor(i11);
        this.f79674c.setTextColor(i11);
        this.f79675d.setTextColor(i11);
        this.f79676e.setTextColor(i11);
    }

    public void setOnCouponCountDownDone(b bVar) {
        this.f79681j = bVar;
    }

    public CouponCountDown(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
