package com.huobi.appupgrade.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.entity.UpdateResponse;
import eh.h;
import u6.g;

public class AppUpgradePresenter extends ActivityPresenter<a> {

    public interface a extends g {
    }

    public void Q(UpdateResponse updateResponse) {
        h.q().n();
    }

    public void R() {
        h.q().l();
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
