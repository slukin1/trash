package com.huobi.trade.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import at.a;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.huobi.c2c.lend.C2CLendTradeController;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import u6.g;
import zs.b;
import zs.c;

public class HbTradeFragment extends EmptyMVPFragment implements b {

    /* renamed from: l  reason: collision with root package name */
    public CoordinatorLayout f81968l;

    /* renamed from: m  reason: collision with root package name */
    public AppBarLayout f81969m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f81970n;

    /* renamed from: o  reason: collision with root package name */
    public c f81971o;

    public void Ah() {
    }

    /* renamed from: Dh */
    public g zh() {
        return this;
    }

    public final c Eh() {
        return new C2CLendTradeController(this, this);
    }

    public void afterInit() {
        c Eh = Eh();
        this.f81971o = Eh;
        Eh.c(this.f81970n);
        this.f81971o.b(this.f81969m);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void initViews() {
        this.f81968l = (CoordinatorLayout) this.f67460i.b(R.id.trade_base_root_view);
        this.f81969m = (AppBarLayout) this.f67460i.b(R.id.fragment_hb_trade_appbar_layout);
        this.f81970n = (FrameLayout) this.f67460i.b(R.id.fragment_hb_trade_container);
    }

    public boolean isAlive() {
        return isCanBeSeen();
    }

    public CoordinatorLayout o8() {
        return this.f81968l;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(a aVar) {
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f81971o;
        if (cVar != null) {
            cVar.onDestroy();
        }
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_trade_base, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        c cVar = this.f81971o;
        if (cVar != null) {
            cVar.a(z11);
        }
    }

    public void z8(boolean z11, boolean z12) {
        AppBarLayout appBarLayout = this.f81969m;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(z11, z12);
        }
    }
}
