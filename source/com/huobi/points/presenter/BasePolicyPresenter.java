package com.huobi.points.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.HashMap;
import q6.d;
import tq.p;
import u6.g;

public class BasePolicyPresenter extends ActivityPresenter<a> {

    public interface a extends g {
        void q5();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(Object obj) {
        ((a) getUI()).q5();
    }

    public void S(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new iq.a(this)));
    }
}
