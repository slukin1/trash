package com.huobi.otc.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.widgets.floating.FloatingLayout;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.floating.OtcReminderModelImp;
import com.huobi.otc.floating.OtcReminderPresenterImp;
import ga.a;
import gp.c;
import gp.d;
import gp.g;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import vp.h0;

public final class OtcOrderReminder {

    /* renamed from: g  reason: collision with root package name */
    public static volatile OtcOrderReminder f80030g;

    /* renamed from: a  reason: collision with root package name */
    public final a f80031a;

    /* renamed from: b  reason: collision with root package name */
    public final d f80032b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80033c;

    /* renamed from: d  reason: collision with root package name */
    public final c f80034d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f80035e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public boolean f80036f;

    public OtcOrderReminder() {
        FloatingLayout floatingLayout = new FloatingLayout();
        this.f80031a = floatingLayout;
        g gVar = new g(floatingLayout);
        this.f80032b = gVar;
        OtcReminderModelImp otcReminderModelImp = new OtcReminderModelImp();
        OtcReminderPresenterImp otcReminderPresenterImp = new OtcReminderPresenterImp(gVar, otcReminderModelImp);
        this.f80034d = otcReminderPresenterImp;
        otcReminderModelImp.g(otcReminderPresenterImp);
    }

    public static OtcOrderReminder e() {
        if (f80030g == null) {
            synchronized (OtcOrderReminder.class) {
                if (f80030g == null) {
                    f80030g = new OtcOrderReminder();
                }
            }
        }
        return f80030g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        i6.d.b("unfold");
        if (h()) {
            this.f80032b.b();
        }
    }

    public void b(g.C0864g gVar) {
        this.f80032b.i(gVar);
    }

    public void c(BaseCoreActivity baseCoreActivity) {
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        if (this.f80031a.e() == null) {
            this.f80031a.d(this.f80032b.h(baseCoreActivity));
        }
        if (this.f80036f) {
            this.f80036f = false;
            this.f80031a.d(this.f80032b.d(baseCoreActivity));
        }
        i6.d.b("activity attach " + baseCoreActivity.toString());
        boolean g11 = g(baseCoreActivity);
        this.f80031a.c(baseCoreActivity);
        if (g11) {
            d dVar = this.f80032b;
            dVar.e(dVar.g());
        }
        this.f80034d.start();
    }

    public void d(BaseCoreActivity baseCoreActivity) {
        i6.d.b("activity detach " + baseCoreActivity.toString());
        this.f80035e.removeCallbacksAndMessages((Object) null);
        this.f80031a.b(baseCoreActivity);
    }

    public ReminderData f() {
        return this.f80032b.g();
    }

    public final boolean g(BaseCoreActivity baseCoreActivity) {
        boolean z11 = this.f80031a.a() == null;
        boolean z12 = this.f80031a.a() != null && OtcModuleConfig.a().S(baseCoreActivity);
        boolean z13 = (this.f80031a.a() == null || this.f80031a.a().getContext() == baseCoreActivity) ? false : true;
        if (z11 || z12 || z13) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        View e11 = this.f80031a.e();
        int[] iArr = new int[2];
        e11.findViewById(R$id.id_remind_right_icon).getLocationOnScreen(iArr);
        if (iArr[0] > ViewUtil.f(e11.getContext())) {
            return true;
        }
        return false;
    }

    public void j() {
        onNightModeChanged((NightHelper.NightEvent) null);
    }

    public void k(View view, boolean z11) {
        if (this.f80031a.a() != null && view != null && view.getContext() == this.f80031a.a().getContext() && z11 != this.f80033c) {
            i6.d.b("scrolling=" + z11);
            this.f80035e.removeCallbacksAndMessages((Object) null);
            if (z11) {
                i6.d.b("try fold");
                if (!h()) {
                    i6.d.b("fold");
                    this.f80032b.c();
                }
            } else {
                i6.d.b("postDelay unfold");
                this.f80035e.postDelayed(new h0(this), 1000);
            }
            this.f80033c = z11;
        }
    }

    public void l(ReminderData reminderData) {
        if (reminderData == null) {
            this.f80032b.dismiss();
        } else {
            this.f80034d.a(reminderData);
        }
    }

    public void m(g.C0864g gVar) {
        this.f80032b.f(gVar);
    }

    public void n() {
        this.f80034d.start();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNightModeChanged(NightHelper.NightEvent nightEvent) {
        i6.d.b("reset onNightModeChanged");
        this.f80031a.reset();
        this.f80036f = true;
    }
}
