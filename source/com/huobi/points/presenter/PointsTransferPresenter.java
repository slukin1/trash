package com.huobi.points.presenter;

import al.m0;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AccountBalanceInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.points.activity.PointsTransferPolicyActivity;
import com.huobi.points.activity.TransferOrderListActivity;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.utils.PointsDataSource;
import com.huobi.utils.k0;
import com.jumio.sdk.reject.JumioRejectReason;
import dt.h2;
import i6.m;
import iq.a0;
import iq.b0;
import iq.q;
import iq.s;
import iq.t;
import iq.u;
import iq.v;
import iq.w;
import iq.x;
import iq.y;
import iq.z;
import java.math.BigDecimal;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q6.d;
import rx.Observable;
import tg.r;
import tq.p;
import u6.g;

public class PointsTransferPresenter extends ActivityPresenter<b> {

    public class a extends d<Pair<UserSecurityInfoData, SecurityStrategySet>> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
            super.onNext(pair);
            ((b) PointsTransferPresenter.this.getUI()).C(pair);
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

        void Ob(String str);

        String cf();

        String getUid();

        String i6();

        String x4();
    }

    public static /* synthetic */ BalanceQueryData c0(BalanceQueryData balanceQueryData) {
        return balanceQueryData == null ? new BalanceQueryData() : balanceQueryData;
    }

    public static /* synthetic */ String d0(BalanceQueryData balanceQueryData, AccountBalanceInfo accountBalanceInfo) {
        if (balanceQueryData.getList() == null) {
            return "0";
        }
        BigDecimal subtract = m.a(m.m(balanceQueryData.getBalance("hbpoint", "trade"), PrecisionUtil.c((String) null))).subtract(m.a(accountBalanceInfo.getAccountBalance()));
        if (subtract.compareTo(BigDecimal.ZERO) <= 0) {
            subtract = BigDecimal.ZERO;
        }
        return subtract.toPlainString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(String str) {
        i6.d.b("PointsTransferPresenter-->requestPointsData-->" + str);
        ((b) getUI()).Ob(str);
    }

    public static /* synthetic */ void g0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void h0(Throwable th2) {
    }

    public static /* synthetic */ void i0(APIStatusErrorException aPIStatusErrorException) {
        String str;
        i6.d.b("PointsTransferPresenter-->requestPointsTransfer-->ok-->errorCode:" + aPIStatusErrorException.getErrCode() + " errorMsg:" + aPIStatusErrorException.getErrMsg());
        String errCode = aPIStatusErrorException.getErrCode();
        switch (errCode.hashCode()) {
            case 49587:
                str = JumioRejectReason.NO_DOC;
                break;
            case 51509:
                str = "401";
                break;
            case 51511:
                str = "403";
                break;
            case 51512:
                str = "404";
                break;
            default:
                return;
        }
        errCode.equals(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(Long l11) {
        i6.d.b("PointsTransferPresenter-->requestPointsTransfer-->ok-->" + l11);
        HuobiToastUtil.r(getString(R.string.points_transfer_success_tips));
        TransferOrderListActivity.vh(getActivity(), PointsAction.TYPE_TRANSFER_OUT, 1);
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(TradeRiskReminder tradeRiskReminder) {
        if (tradeRiskReminder == null || !"1".equals(tradeRiskReminder.getState())) {
            PointsTransferPolicyActivity.qh(getActivity(), 100);
        } else {
            t0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(CodeVerifyData codeVerifyData) {
        u0(codeVerifyData.getToken());
        i6.d.j("StrategyDisable", "success");
    }

    public static /* synthetic */ void p0(Throwable th2) {
        i6.d.j("StrategyDisable", th2.toString());
        th2.printStackTrace();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 != -1) {
            getActivity().finish();
        } else {
            t0();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onResume() {
        super.onResume();
        if (!r.x().F0()) {
            return;
        }
        if (PointsTransferPolicyActivity.oh()) {
            t0();
        } else {
            v0();
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        SoftInputUtils.f(getActivity());
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }

    public Observable<UserSecurityInfoData> q0() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Observable<SecurityStrategySet> r0() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t((g) getUI()));
    }

    /* renamed from: s0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    public void t0() {
        Observable.zip(h2.t1().v3(TradeType.POINT, false).map(iq.r.f55829b), v7.b.a().getAccountBalance("").b(), s.f55831b).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new v(this), w.f55835b, z.f55838b));
    }

    public final void u0(String str) {
        PointsDataSource.i(((b) getUI()).cf(), ((b) getUI()).getUid(), ((b) getUI()).x4(), ((b) getUI()).i6(), str).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new u(this), x.f55836b, a0.f55794b));
    }

    public final void v0() {
        UserCenterRemoteDataSource.A().requestLicenseState("PRO_POINT_TRANSFER", true).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new t(this)));
    }

    public void w0() {
        Observable.zip(q0(), r0(), m0.f3581b).subscribe(new a((g) getUI()));
    }

    public void x0(String str, String str2, String str3) {
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
        UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.d((g) getUI(), new q(this), y.f55837b, b0.f55796b));
    }
}
