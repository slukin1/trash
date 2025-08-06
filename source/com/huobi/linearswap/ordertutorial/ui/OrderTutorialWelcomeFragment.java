package com.huobi.linearswap.ordertutorial.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import dw.a;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import zm.w;
import zm.x;

public class OrderTutorialWelcomeFragment extends EmptyMVPFragment {
    /* access modifiers changed from: private */
    public /* synthetic */ void Gh(Void voidR) {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(Void voidR) {
        ((OrderTutorialActivity) getActivity()).S4(1);
    }

    public void initViews() {
        super.initViews();
        Observable<Void> a11 = a.a(this.f67460i.b(R.id.tv_close));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new x(this));
        a.a(this.f67460i.b(R.id.tv_start)).throttleFirst(1, timeUnit).subscribe(new w(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_order_tutorial_welcome, viewGroup, false);
    }
}
