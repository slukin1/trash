package com.huobi.otc.persenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusResponse;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.bean.UserSecuritySetData;
import com.huochat.community.base.CommunityConstants;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.List;
import jp.l;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import qp.h;
import rx.Observable;
import u6.g;

public class OtcFAQPresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public String f79047a;

    /* renamed from: b  reason: collision with root package name */
    public String f79048b;

    /* renamed from: c  reason: collision with root package name */
    public UserSecuritySetData f79049c;

    public class a extends d<List<OtcFAQBean>> {
        public a(g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (OtcFAQPresenter.this.getUI() != null) {
                ((c) OtcFAQPresenter.this.getUI()).n4(th2.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcFAQPresenter.this.getUI() != null) {
                ((c) OtcFAQPresenter.this.getUI()).n4(aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(List<OtcFAQBean> list) {
            super.onNext(list);
            if (OtcFAQPresenter.this.getUI() == null) {
                return;
            }
            if (list == null || list.isEmpty()) {
                ((c) OtcFAQPresenter.this.getUI()).n4((String) null);
            } else {
                ((c) OtcFAQPresenter.this.getUI()).rf(list);
            }
        }
    }

    public class b extends EasySubscriber<OTCStatusResponse<Object>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79051b;

        public b(String str) {
            this.f79051b = str;
        }

        /* renamed from: a */
        public void onNext(OTCStatusResponse<Object> oTCStatusResponse) {
            super.onNext(oTCStatusResponse);
            if (OtcFAQPresenter.this.getUI() != null) {
                ((c) OtcFAQPresenter.this.getUI()).D7(this.f79051b, oTCStatusResponse.isSuccess(), (String) null);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (OtcFAQPresenter.this.getUI() != null) {
                ((c) OtcFAQPresenter.this.getUI()).D7(this.f79051b, false, th2.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcFAQPresenter.this.getUI() != null) {
                ((c) OtcFAQPresenter.this.getUI()).D7(this.f79051b, false, aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public interface c extends g {
        void D7(String str, boolean z11, String str2);

        OtcFAQPresenter f2();

        void n4(String str);

        void rf(List<OtcFAQBean> list);

        void w6(UserSecuritySetData userSecuritySetData);
    }

    public static /* synthetic */ UserSecuritySetData Y(UserVO userVO, SecurityStrategySet securityStrategySet, UserSecurityInfoData userSecurityInfoData) {
        UserSecuritySetData userSecuritySetData = new UserSecuritySetData();
        userSecuritySetData.setUserVO(userVO);
        userSecuritySetData.setSecurityStrategySet(securityStrategySet);
        userSecuritySetData.setUserSecurityInfoData(userSecurityInfoData);
        return userSecuritySetData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(UserSecuritySetData userSecuritySetData) {
        this.f79049c = userSecuritySetData;
        ((c) getUI()).w6(userSecuritySetData);
    }

    public void S(String str, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", str);
        hashMap.put(CommunityConstants.REQUEST_KEY_LINE, Integer.valueOf(i11));
        s8.a.a().faqLike(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new b(str));
    }

    public Observable<SecurityStrategySet> T() {
        return ((UserCenterService) UcRetrofit.request(UserCenterService.class)).requestSecurityStrategy().compose(UcRetrofit.h()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<UserSecurityInfoData> U() {
        Class cls = UserCenterService.class;
        UcRetrofit.request(cls);
        return ((UserCenterService) UcRetrofit.request(cls)).requestUserSecurityInfo().compose(UcRetrofit.h()).compose(RxJavaHelper.t((g) getUI()));
    }

    public void V() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.LINE, "otc");
        hashMap.put(PlaceFields.PAGE, this.f79047a);
        if (!TextUtils.isEmpty(this.f79048b)) {
            hashMap.put("orderId", this.f79048b);
        }
        s8.a.a().getFAQConfig(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    public void W() {
        Observable.zip(l.q(false).compose(RxJavaHelper.t((g) getUI())), T(), U(), h.f60079b).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new qp.g(this)));
    }

    public UserSecuritySetData X() {
        return this.f79049c;
    }

    /* renamed from: a0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        V();
    }

    public void b0(String str) {
        this.f79048b = str;
    }

    public void c0(String str) {
        this.f79047a = str;
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((c) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }
}
