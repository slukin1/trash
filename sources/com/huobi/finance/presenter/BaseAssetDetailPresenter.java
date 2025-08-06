package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.login.bean.JumpTarget;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.utils.k0;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public abstract class BaseAssetDetailPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter f45501a;

    /* renamed from: b  reason: collision with root package name */
    public String f45502b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45503c;

    public interface a extends SmartRefreshPageSplitter.d {
        void pb(BaseAssetInfo baseAssetInfo);

        void wd(BaseAssetInfo baseAssetInfo, YbbUserAssetInfoData ybbUserAssetInfoData, List<String> list);
    }

    public BaseAssetInfo Q() {
        return null;
    }

    public abstract void R();

    public boolean S() {
        return false;
    }

    public abstract void T(boolean z11);

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        EventBus.d().p(this);
        this.f45503c = true;
        super.onUIReady(baseCoreActivity, aVar);
        R();
    }

    public void V(String str) {
        this.f45502b = str;
        W();
    }

    public void W() {
        SmartRefreshPageSplitter smartRefreshPageSplitter = this.f45501a;
        if (smartRefreshPageSplitter != null) {
            smartRefreshPageSplitter.F();
        }
    }

    public void onDestroy() {
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        W();
        if (!this.f45503c) {
            T(false);
        }
    }

    public void onStop() {
        super.onStop();
        this.f45503c = false;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), new JumpTarget((Intent) null, k0.h(getActivity())));
        getActivity().finish();
    }
}
