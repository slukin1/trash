package com.hbg.lite.main.presenter;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import eb.b;
import i6.i;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ra.c;
import u6.g;
import wa.d;

public class LiteMainPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f77176a = b.f54313b;

    public interface a extends g {
        void E6(String str, Bundle bundle);

        void kd();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V() {
        ((a) getUI()).kd();
    }

    public final void S() {
        c.c().E();
        i.b().g(this.f77176a, 1000);
    }

    public void T(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Y(new Bundle());
        } else if (db.a.b().a().equals(intent.getAction())) {
            Y(intent.getExtras());
        } else if (db.a.b().c().equals(intent.getAction())) {
            Z(intent.getExtras());
        }
    }

    /* renamed from: W */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        X();
        c.b().q(baseCoreActivity);
        S();
    }

    public final void X() {
        d.d(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
    }

    public void Y(Bundle bundle) {
        ((a) getUI()).E6("INDEX", bundle);
    }

    public void Z(Bundle bundle) {
        ((a) getUI()).E6("WALLET", bundle);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onAuthStatus(ob.a aVar) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new eb.a(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onNightModeChanged(NightHelper.NightEvent nightEvent) {
        getActivity().recreate();
    }

    public void onResume() {
        super.onResume();
        c.c().y(getActivity(), (g) getUI());
    }
}
