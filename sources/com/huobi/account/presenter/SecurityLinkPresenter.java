package com.huobi.account.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.login.usercenter.data.source.bean.GaGenerateData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.subscriptions.CompositeSubscription;
import tq.p;
import u6.g;

public class SecurityLinkPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public int f41036a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f41037b;

    /* renamed from: c  reason: collision with root package name */
    public String f41038c;

    /* renamed from: d  reason: collision with root package name */
    public final CompositeSubscription f41039d = new CompositeSubscription();

    public class a extends q6.d<GaGenerateData> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(GaGenerateData gaGenerateData) {
            super.onNext(gaGenerateData);
            ((d) SecurityLinkPresenter.this.getUI()).w(gaGenerateData);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!uq.a.a(SecurityLinkPresenter.this.getActivity(), aPIStatusErrorException, SecurityVerifyParam.Scene.GA, SecurityVerifyParam.RiskOperate.GENERATE) && aPIStatusErrorException != null && "11211".equals(aPIStatusErrorException.getErrCode())) {
                SecurityLinkPresenter.this.getActivity().finish();
            }
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41041b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f41042c;

        public b(String str, String str2) {
            this.f41041b = str;
            this.f41042c = str2;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            if (TextUtils.equals(aPIStatusErrorException.getErrCode(), "10051")) {
                ((d) SecurityLinkPresenter.this.getUI()).r8();
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((d) SecurityLinkPresenter.this.getUI()).Kg(this.f41041b, this.f41042c);
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41044b;

        public c(String str) {
            this.f41044b = str;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            if (TextUtils.equals(aPIStatusErrorException.getErrCode(), "10061")) {
                ((d) SecurityLinkPresenter.this.getUI()).F5();
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((d) SecurityLinkPresenter.this.getUI()).w7(this.f41044b);
        }
    }

    public interface d extends g {
        void F5();

        void Kg(String str, String str2);

        void r8();

        void w(GaGenerateData gaGenerateData);

        void w7(String str);
    }

    public void S() {
        o7.b.f(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
    }

    public void T() {
        if (this.f41036a == 3) {
            U();
        }
    }

    public final void U() {
        UserCenterRemoteDataSource.A().r0().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        EventBus.d().p(this);
        T();
        S();
    }

    public void W(String str) {
        this.f41039d.add(UserCenterRemoteDataSource.A().w(MapParamsBuilder.c().a("use_type", "BIND_EMAIL").a("email", str).b()).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new c(str)));
    }

    public void X(String str, String str2) {
        this.f41039d.add(UserCenterRemoteDataSource.A().I(MapParamsBuilder.c().a("use_type", "BIND_PHONE").a("country_code", str).a(PlaceFields.PHONE, str2).a("voice", Boolean.FALSE).b()).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new b(str, str2)));
    }

    public void Y(String str, String str2) {
        this.f41037b = str;
        this.f41038c = str2;
    }

    public void Z(int i11) {
        this.f41036a = i11;
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
