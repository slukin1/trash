package com.huobi.newtrade.presenter;

import com.hbg.lib.common.ui.BaseCoreActivity;
import org.greenrobot.eventbus.EventBus;
import ro.b;

public class NewTradeSpotPresenter extends NewTradeBasePresenter<b> {
    /* renamed from: f0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }
}
