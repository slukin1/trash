package com.huobi.trade.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.i;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import rx.Observable;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;
import u6.g;

public class MarginRiskReminderPresenter extends ActivityPresenter<b> {

    public class a implements Func2<Object, Object, Object> {
        public a() {
        }

        public Object call(Object obj, Object obj2) {
            return obj;
        }
    }

    public interface b extends g {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(Object obj) {
        i.b().g(new et.a(this), 50);
    }

    public void S() {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "MARGIN");
            hashMap.put("version", 1);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", "SUPER_MARGIN");
            hashMap2.put("version", 1);
            Observable.zip(UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap2).compose(p.c0()).subscribeOn(Schedulers.io()), new a()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new et.b(this)));
            return;
        }
        getActivity().finish();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        getActivity().finish();
    }
}
