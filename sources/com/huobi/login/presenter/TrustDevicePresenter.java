package com.huobi.login.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.api.RiskService;
import i6.m;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import nn.u1;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import tq.p;
import u6.g;

public class TrustDevicePresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public final CompositeSubscription f75511a = new CompositeSubscription();

    /* renamed from: b  reason: collision with root package name */
    public String f75512b;

    public class a extends EasySubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (l11.longValue() <= 0) {
                ((c) TrustDevicePresenter.this.getUI()).H(true, TrustDevicePresenter.this.getString(R.string.verify_code_resend));
                if (!isUnsubscribed()) {
                    unsubscribe();
                    return;
                }
                return;
            }
            int k02 = m.k0(l11 + "");
            ((c) TrustDevicePresenter.this.getUI()).H(false, String.format(TrustDevicePresenter.this.getString(R.string.security_resend_after), new Object[]{Integer.valueOf(k02)}));
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            TrustDevicePresenter.this.W();
        }
    }

    public interface c extends g {
        void H(boolean z11, String str);
    }

    /* renamed from: T */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        this.f75512b = getActivity().getIntent().getStringExtra("DEVICE_TSV_TOKEN");
        W();
    }

    public void U() {
        V().subscribe(new b());
    }

    public final Observable<Object> V() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("tsvToken", this.f75512b);
        return ((RiskService) p.Y(RiskService.class)).resendTsvMessage(hashMap).compose(p.Z()).compose(RxJavaHelper.t((g) getUI()));
    }

    public final void W() {
        a aVar = new a();
        ((c) getUI()).H(false, "");
        this.f75511a.add(Observable.interval(0, 1, TimeUnit.SECONDS).map(u1.f58666b).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(aVar));
    }

    public void onDestroy() {
        super.onDestroy();
        this.f75511a.clear();
    }
}
