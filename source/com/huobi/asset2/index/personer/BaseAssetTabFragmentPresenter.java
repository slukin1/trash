package com.huobi.asset2.index.personer;

import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import u6.g;

public class BaseAssetTabFragmentPresenter extends BaseFragmentPresenter<a> {

    public interface a extends h6.a, g {
        void Wg();
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        aVar.Wg();
    }
}
