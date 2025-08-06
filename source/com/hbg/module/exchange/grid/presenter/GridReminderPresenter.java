package com.hbg.module.exchange.grid.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import i6.i;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import u6.g;
import vc.b;

public class GridReminderPresenter extends ActivityPresenter<a> {

    public interface a extends g {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(Object obj) {
        i.b().g(new bd.a(this), 50);
    }

    public void S() {
        b.a().g().compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new bd.b(this)));
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        b.a().c(getActivity());
        getActivity().finish();
    }
}
