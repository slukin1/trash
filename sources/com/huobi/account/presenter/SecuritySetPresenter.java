package com.huobi.account.presenter;

import android.util.ArrayMap;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.login.usercenter.data.source.bean.SecuritySetData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserContacts;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.bean.UserSecurityLoginListData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import java.util.List;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import rn.c;
import rx.Observable;
import tq.p;
import u6.g;
import ug.s1;
import ug.t1;

public class SecuritySetPresenter extends ActivityPresenter<a> {

    public interface a extends g {
        void Y(SecuritySetData securitySetData);
    }

    public static /* synthetic */ SecuritySetData X(UserVO userVO, SecurityStrategySet securityStrategySet, UserSecurityInfoData userSecurityInfoData, List list) {
        SecuritySetData securitySetData = new SecuritySetData();
        securitySetData.h(userVO);
        securitySetData.e(securityStrategySet);
        securitySetData.f(userSecurityInfoData);
        if (list != null && list.size() > 0) {
            securitySetData.g((UserSecurityLoginListData) list.get(0));
        }
        return securitySetData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(SecuritySetData securitySetData) {
        ((a) getUI()).Y(securitySetData);
    }

    public Observable<List<UserContacts>> S(int i11) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("record_type", Integer.valueOf(i11));
        return UserCenterRemoteDataSource.A().getContacts(arrayMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<SecurityStrategySet> T() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<UserSecurityInfoData> U() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<List<UserSecurityLoginListData>> V() {
        return o9.a.a().c(0, 1).b().compose(RxJavaHelper.t((g) getUI()));
    }

    public void W() {
        Observable.zip(l.q(false).compose(RxJavaHelper.t((g) getUI())).onErrorResumeNext(Observable.just(null)), T(), U(), V(), t1.f60647b).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new s1(this)));
    }

    /* renamed from: Z */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        c.i().f(getActivity());
        getActivity().finish();
    }
}
