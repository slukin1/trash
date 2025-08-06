package com.huobi.account.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.BusinessType;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.api.StepRateService;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.entity.UserRateInfoAvailableCollection;
import com.huobi.utils.k0;
import dt.h2;
import java.util.Map;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import rx.Observable;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;
import ug.u1;
import ug.v1;
import ug.w1;
import ug.x1;
import ug.y1;

public class StepRateSettingPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public UserStepRateInfo f41093a;

    /* renamed from: b  reason: collision with root package name */
    public String f41094b;

    /* renamed from: c  reason: collision with root package name */
    public String f41095c;

    public class a extends EasySubscriber<UserRateInfoAvailableCollection> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(UserRateInfoAvailableCollection userRateInfoAvailableCollection) {
            super.onNext(userRateInfoAvailableCollection);
            UserStepRateInfo unused = StepRateSettingPresenter.this.f41093a = userRateInfoAvailableCollection.getStepUserRateInfo();
            String unused2 = StepRateSettingPresenter.this.f41094b = userRateInfoAvailableCollection.getAvailable();
            ((b) StepRateSettingPresenter.this.getUI()).r7(userRateInfoAvailableCollection);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface b extends h6.a, g {
        void ed(boolean z11);

        void qb(boolean z11);

        void r7(UserRateInfoAvailableCollection userRateInfoAvailableCollection);
    }

    public static /* synthetic */ UserVO a0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Boolean b0(UserVO userVO) {
        return Boolean.valueOf(userVO == null || userVO.isIsMerchant());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(UserRateInfoAvailableCollection userRateInfoAvailableCollection) {
        this.f41093a = userRateInfoAvailableCollection.getStepUserRateInfo();
        this.f41094b = userRateInfoAvailableCollection.getAvailable();
        ((b) getUI()).r7(userRateInfoAvailableCollection);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(boolean z11, boolean z12, Boolean bool) {
        if (bool.booleanValue()) {
            if (z11) {
                ((b) getUI()).qb(z12);
            } else {
                ((b) getUI()).ed(z12);
            }
            Z().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
        }
    }

    public String X() {
        return this.f41095c;
    }

    public UserStepRateInfo Y() {
        return this.f41093a;
    }

    public final Observable<UserRateInfoAvailableCollection> Z() {
        return Observable.zip(v7.b.a().L(BusinessType.PRO).b(), v7.b.a().L(BusinessType.MARGIN).b(), v7.b.a().L(BusinessType.OTC).b(), h2.t1().y3(TradeType.PRO, false).subscribeOn(Schedulers.io()), l.q(false).onErrorReturn(x1.f60661b).map(w1.f60658b), h2.t1().v3(TradeType.POINT, false).defaultIfEmpty(new BalanceQueryData()), new y1(this));
    }

    /* renamed from: f0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        UserRateInfoAvailableCollection userRateInfoAvailableCollection = new UserRateInfoAvailableCollection();
        userRateInfoAvailableCollection.buildCardDataList(baseCoreActivity);
        ((b) getUI()).r7(userRateInfoAvailableCollection);
        Z().compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new u1(this)));
    }

    public final UserRateInfoAvailableCollection g0(UserStepRateInfo userStepRateInfo, UserStepRateInfo userStepRateInfo2, UserStepRateInfo userStepRateInfo3, Map<String, String> map, boolean z11, BalanceQueryData balanceQueryData) {
        UserRateInfoAvailableCollection userRateInfoAvailableCollection = new UserRateInfoAvailableCollection();
        userRateInfoAvailableCollection.setStepUserRateInfo(userStepRateInfo);
        userRateInfoAvailableCollection.setMarginInterestRateInfo(userStepRateInfo2);
        userRateInfoAvailableCollection.setOtcRateInfo(userStepRateInfo3);
        userRateInfoAvailableCollection.setUserMerchant(z11);
        userRateInfoAvailableCollection.buildCardDataList(getActivity());
        if (map != null) {
            userRateInfoAvailableCollection.setAvailable(map.get("ht"));
        }
        this.f41095c = balanceQueryData.getBalance("hbpoint", "trade");
        return userRateInfoAvailableCollection;
    }

    public void h0(int i11, boolean z11, boolean z12) {
        MapParamsBuilder c11 = MapParamsBuilder.c();
        c11.a("switch-type", Integer.valueOf(i11));
        if (i11 == 2 && z11) {
            c11.a("deduction-currency", "ht");
        }
        ((StepRateService) p.W(StepRateService.class)).updateStepRateSwitch(c11.b()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new v1(this, z12, z11)));
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && getActivity() != null) {
            getActivity().startActivity(k0.h(getActivity()));
        }
    }
}
