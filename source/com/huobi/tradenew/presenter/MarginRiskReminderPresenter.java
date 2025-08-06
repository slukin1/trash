package com.huobi.tradenew.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.ThreadMode;

public class MarginRiskReminderPresenter extends ActivityPresenter<Object> {
    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        getActivity().finish();
    }
}
