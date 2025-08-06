package com.huobi.otc.persenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import u6.g;

public class OtcSeaViewPresenter extends ActivityPresenter<a> {

    public interface a extends g {
        void la();
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        ((a) getUI()).la();
    }
}
