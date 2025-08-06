package com.huobi.points.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.points.entity.Points;
import com.huobi.points.utils.PointsDataSource;
import iq.g0;
import iq.h0;
import iq.i0;
import iq.j0;
import iq.k0;
import iq.l0;
import iq.m0;
import iq.n0;
import iq.o0;
import iq.p0;
import iq.q0;
import iq.r0;
import java.util.HashMap;
import q6.d;
import rx.Observable;
import tq.p;
import u6.g;

public class TransferToMePresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public long f80499a;

    public class a extends d<Pair<UserSecurityInfoData, SecurityStrategySet>> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
            super.onNext(pair);
            ((b) TransferToMePresenter.this.getUI()).C(pair);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public interface b extends g {
        void C(Pair<UserSecurityInfoData, SecurityStrategySet> pair);

        void z3(Points points);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(Long l11) {
        d0();
    }

    public static /* synthetic */ void g0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void h0(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Long l11) {
        d0();
    }

    public static /* synthetic */ void j0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void k0(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(Points points) {
        ((b) getUI()).z3(points);
    }

    public static /* synthetic */ void m0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void n0(Throwable th2) {
    }

    public static /* synthetic */ void q0(Throwable th2) {
        i6.d.j("StrategyDisable", th2.toString());
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(CodeVerifyData codeVerifyData) {
        c0(codeVerifyData.getToken());
        i6.d.j("StrategyDisable", "success");
    }

    public void c0(String str) {
        PointsDataSource.a(this.f80499a, str).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new l0(this), n0.f55821b, i0.f55810b));
    }

    public final void d0() {
        getActivity().finish();
    }

    public void onResume() {
        super.onResume();
        w0();
    }

    public Observable<UserSecurityInfoData> s0() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<SecurityStrategySet> t0() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    /* renamed from: u0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f80499a = intent.getLongExtra("extra", 0);
        }
    }

    public void v0() {
        PointsDataSource.h(this.f80499a).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new k0(this), p0.f55826b, q0.f55828b));
    }

    public void w0() {
        PointsDataSource.f(this.f80499a).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new j0(this), m0.f55819b, h0.f55808b));
    }

    public void x0() {
        Observable.zip(s0(), t0(), al.m0.f3581b).subscribe(new a((g) getUI()));
    }

    public void y0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        hashMap.put("use_type", "VERIFY_SETTING_POLICY");
        UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new g0(this), o0.f55823b, r0.f55830b));
    }
}
