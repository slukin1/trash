package com.hbg.lite.record.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ra.c;
import u6.g;

public class AllCurrencyRecordPresenter extends ActivityPresenter<a> {

    public interface a extends g {
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(p6.a aVar) {
        if (getUI() != null && ((a) getUI()).isAlive()) {
            c.b().e(getActivity(), (Intent) null, new Intent(db.a.b().a()));
            getActivity().finish();
        }
    }
}
