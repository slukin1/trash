package com.huobi.trade.helper;

import com.hbg.lib.common.utils.SP;
import com.huobi.view.AnimTradeMenuView;
import i6.d;
import i6.i;
import java.lang.ref.SoftReference;

public class l implements AnimTradeMenuView.Callback {

    /* renamed from: a  reason: collision with root package name */
    public boolean f82057a = SP.l("sp_key_trade_drawer_btn_anim", false);

    /* renamed from: b  reason: collision with root package name */
    public SoftReference<AnimTradeMenuView> f82058b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f82059c = new k(this);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f82060a = new l();
    }

    public static l b() {
        return a.f82060a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        SoftReference<AnimTradeMenuView> softReference = this.f82058b;
        if (!(softReference == null || softReference.get() == null)) {
            AnimTradeMenuView animTradeMenuView = this.f82058b.get();
            animTradeMenuView.setCallback(this);
            animTradeMenuView.startAnim();
        }
        this.f82057a = true;
    }

    public void d(boolean z11) {
        d.b("TradeDrawerBtnAnimHelper-->setAnimated-->" + z11);
        this.f82057a = z11;
        SP.y("sp_key_trade_drawer_btn_anim", z11);
    }

    public void e() {
        d.b("TradeDrawerBtnAnimHelper-->stopAnim-->");
        i.b().h(this.f82059c);
        SoftReference<AnimTradeMenuView> softReference = this.f82058b;
        if (!(softReference == null || softReference.get() == null)) {
            this.f82058b.get().stopAnim();
            this.f82058b.clear();
        }
        this.f82058b = null;
    }

    public void onAnimFinish() {
        d.b("TradeDrawerBtnAnimHelper-->onAnimFinish-->");
        d(true);
    }
}
