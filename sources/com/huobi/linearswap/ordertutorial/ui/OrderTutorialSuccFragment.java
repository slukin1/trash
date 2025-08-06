package com.huobi.linearswap.ordertutorial.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import zm.u;
import zm.v;

public class OrderTutorialSuccFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public View f75041l;

    /* renamed from: m  reason: collision with root package name */
    public View f75042m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OrderTutorialSuccFragment.this.f75041l.setEnabled(true);
            OrderTutorialSuccFragment.this.f75042m.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jh(Void voidR) {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(Void voidR) {
        ((OrderTutorialActivity) getActivity()).zh();
    }

    public final an.a Ih() {
        return ((OrderTutorialActivity) getActivity()).ph();
    }

    public void initViews() {
        super.initViews();
        this.f75041l = this.f67460i.b(R.id.tv_check_order);
        this.f75042m = this.f67460i.b(R.id.tv_again);
        Observable<Void> a11 = dw.a.a(this.f75041l);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new u(this));
        dw.a.a(this.f75042m).throttleFirst(1, timeUnit).subscribe(new v(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_order_tutorial_succ, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            an.a Ih = Ih();
            FutureContractInfo H = Ih.H();
            String symbol = H.getSymbol();
            Ih.q(H);
            ConfigPreferences.k("user_config", "config_linear_swap_margin_type_" + symbol, 1);
            this.f75041l.setEnabled(false);
            this.f75042m.setEnabled(false);
            this.f75041l.postDelayed(new a(), 1000);
        }
    }
}
