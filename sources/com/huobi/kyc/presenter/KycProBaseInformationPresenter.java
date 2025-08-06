package com.huobi.kyc.presenter;

import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.kyc.bean.CountryKyc;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import gs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import rx.Observable;
import tg.r;
import u6.g;

public class KycProBaseInformationPresenter extends ActivityPresenter<c> {

    public class a extends EasySubscriber<Pair<UserKycInfoNew, Map<String, CountryKyc>>> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Pair<UserKycInfoNew, Map<String, CountryKyc>> pair) {
            super.onNext(pair);
            ((c) KycProBaseInformationPresenter.this.getUI()).m6(pair);
            KycProBaseInformationPresenter.this.a0();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((c) KycProBaseInformationPresenter.this.getUI()).W0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((c) KycProBaseInformationPresenter.this.getUI()).W0();
        }

        public void onStart() {
            super.onStart();
            ((c) KycProBaseInformationPresenter.this.getUI()).Hf();
        }
    }

    public class b extends d<String> {
        public b(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(String str) {
            super.onNext(str);
            e.b().a("PM_AUTH", true, (Map<String, Object>) null);
            KycProBaseInformationPresenter.this.c0();
        }
    }

    public interface c extends g {
        void Hf();

        void W0();

        void m6(Pair<UserKycInfoNew, Map<String, CountryKyc>> pair);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable W(UserKycInfoNew userKycInfoNew, UserInfoData userInfoData) {
        if (userInfoData.d() != null && !userInfoData.d().isEmpty()) {
            userKycInfoNew.getUser_info().setAuth_country(new HashMap<Object, String>(userInfoData) {
                public final /* synthetic */ UserInfoData val$userInfo;

                {
                    this.val$userInfo = r2;
                    put("2", String.valueOf(r2.d().get(0)));
                }
            });
        }
        return Observable.just(userKycInfoNew);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable X(UserKycInfoNew userKycInfoNew) {
        if (userKycInfoNew.getUser_info() == null || (userKycInfoNew.getUser_info().getAuth_country() != null && !userKycInfoNew.getUser_info().getAuth_country().isEmpty())) {
            return Observable.just(userKycInfoNew);
        }
        return r.x().O(false).flatMap(new f(this, userKycInfoNew));
    }

    public static /* synthetic */ Pair Y(UserKycInfoNew userKycInfoNew, List list) {
        HashMap hashMap = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            CountryKyc countryKyc = (CountryKyc) it2.next();
            hashMap.put(String.valueOf(countryKyc.getId()), countryKyc);
        }
        return new Pair(userKycInfoNew, hashMap);
    }

    public void U(String str, String str2) {
        KycProxy.l().g(str, str2).compose(RxJavaHelper.t((g) getUI())).subscribe(new b((g) getUI()));
    }

    public void V() {
        o7.b.f(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
    }

    public void a0() {
        l.E().compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        c0();
        V();
        EventBus.d().p(this);
    }

    public void c0() {
        KycProxy.l().i(false).flatMap(new e(this)).flatMap(g.f74844b).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        rn.c.i().f(getActivity());
        getActivity().finish();
    }
}
