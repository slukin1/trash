package com.huobi.finance.presenter;

import ad.i;
import android.content.Intent;
import android.text.TextUtils;
import bj.o0;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.pro.core.bean.CurrencyRef;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.finance.ui.dc;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.l;
import pro.huobi.R;
import q6.d;
import rx.Observable;
import rx.Subscription;
import tg.r;
import u6.g;
import vk.y;
import wk.b1;
import wk.w0;

public class UsdtExchangePresenter extends NeedLoginActivityPresenter<dc> implements y.a {

    /* renamed from: b  reason: collision with root package name */
    public List<y> f45763b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<y> f45764c;

    /* renamed from: d  reason: collision with root package name */
    public UsdtExchangeConfig f45765d;

    /* renamed from: e  reason: collision with root package name */
    public Comparator<BaseAssetInfo> f45766e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45767f = true;

    /* renamed from: g  reason: collision with root package name */
    public Subscription f45768g;

    /* renamed from: h  reason: collision with root package name */
    public Subscription f45769h;

    public class a extends EasySubscriber<List<y>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45770b;

        public a(boolean z11) {
            this.f45770b = z11;
        }

        public void onAfter() {
            super.onAfter();
            ((dc) UsdtExchangePresenter.this.getUI()).finishRefresh();
            if (this.f45770b) {
                ((dc) UsdtExchangePresenter.this.getUI()).dismissProgressDialog();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((dc) UsdtExchangePresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((dc) UsdtExchangePresenter.this.getUI()).m0();
        }

        public void onNext(List<y> list) {
            super.onNext(list);
            UsdtExchangePresenter.this.k0();
            List unused = UsdtExchangePresenter.this.f45764c = list;
            if (!UsdtExchangePresenter.this.f45767f || UsdtExchangePresenter.this.f45765d == null || !com.hbg.lib.core.util.b.c().d()) {
                if (UsdtExchangePresenter.this.f45765d != null) {
                    ((dc) UsdtExchangePresenter.this.getUI()).lf(UsdtExchangePresenter.this.f45765d);
                }
                ((dc) UsdtExchangePresenter.this.getUI()).setData(list);
                return;
            }
            ((dc) UsdtExchangePresenter.this.getUI()).eh(UsdtExchangePresenter.this.f45765d, list);
            boolean unused2 = UsdtExchangePresenter.this.f45767f = false;
        }
    }

    public class b extends EasySubscriber<UserVO> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(UserVO userVO) {
            super.onNext(userVO);
            boolean z11 = true;
            if (l.r() == null || l.r().getRealBind() != 1) {
                z11 = false;
            }
            nb.c.h(UsdtExchangePresenter.this.getActivity(), z11, false);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public UsdtExchangeConfig f45773a;

        /* renamed from: b  reason: collision with root package name */
        public List<CurrencyRef> f45774b;

        /* renamed from: c  reason: collision with root package name */
        public BalanceDataTotal f45775c;

        public c(UsdtExchangeConfig usdtExchangeConfig, List<CurrencyRef> list, BalanceDataTotal balanceDataTotal) {
            this.f45773a = usdtExchangeConfig;
            this.f45774b = list;
            this.f45775c = balanceDataTotal;
        }

        public boolean a(Object obj) {
            return obj instanceof c;
        }

        public BalanceDataTotal b() {
            return this.f45775c;
        }

        public List<CurrencyRef> c() {
            return this.f45774b;
        }

        public UsdtExchangeConfig d() {
            return this.f45773a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a(this)) {
                return false;
            }
            UsdtExchangeConfig d11 = d();
            UsdtExchangeConfig d12 = cVar.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            List<CurrencyRef> c11 = c();
            List<CurrencyRef> c12 = cVar.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            BalanceDataTotal b11 = b();
            BalanceDataTotal b12 = cVar.b();
            return b11 != null ? b11.equals(b12) : b12 == null;
        }

        public int hashCode() {
            UsdtExchangeConfig d11 = d();
            int i11 = 43;
            int hashCode = d11 == null ? 43 : d11.hashCode();
            List<CurrencyRef> c11 = c();
            int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
            BalanceDataTotal b11 = b();
            int i12 = hashCode2 * 59;
            if (b11 != null) {
                i11 = b11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "UsdtExchangePresenter.SrcBundle(usdtExchangeConfig=" + d() + ", currencyRefs=" + c() + ", balanceDataTotal=" + b() + ")";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(HBDialogFragment hBDialogFragment, boolean z11, APIStatusErrorException aPIStatusErrorException) {
        s0(hBDialogFragment, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(HBDialogFragment hBDialogFragment, boolean z11, Throwable th2) {
        s0(hBDialogFragment, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(HBDialogFragment hBDialogFragment, Long l11) {
        boolean z11 = l11.longValue() >= 3;
        Subscription subscription = this.f45769h;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f45769h = v7.b.a().getUsdtExchangeSubmitStatus().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new qb(this, hBDialogFragment, z11), new pb(this, hBDialogFragment, z11), new rb(this, hBDialogFragment, z11)));
        if (z11) {
            this.f45768g.unsubscribe();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(HBDialogFragment hBDialogFragment) {
        H0();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        getActivity().finish();
        UnifyWithdrawActivity.Di(getActivity(), "usdt", TradeType.PRO);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(HbgIntCodeResponse hbgIntCodeResponse) {
        if (hbgIntCodeResponse.isSuccess()) {
            K0();
        } else {
            L0(hbgIntCodeResponse);
        }
    }

    public static /* synthetic */ int u0(BaseAssetInfo baseAssetInfo, BaseAssetInfo baseAssetInfo2) {
        Integer num;
        int i11 = 0;
        try {
            k C = k.C();
            String currency = baseAssetInfo2.getCurrency();
            TradeType tradeType = TradeType.PRO;
            num = Integer.valueOf(C.I(currency, tradeType));
            try {
                i11 = Integer.valueOf(k.C().I(baseAssetInfo.getCurrency(), tradeType));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable v0(c cVar) {
        this.f45765d = cVar.f45773a;
        return Observable.from(cVar.f45775c.getDetailInfos()).filter(new w0(cVar.f45774b));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer w0(BaseAssetInfo baseAssetInfo, BaseAssetInfo baseAssetInfo2) {
        return Integer.valueOf(n0().compare(baseAssetInfo, baseAssetInfo2));
    }

    public static /* synthetic */ Boolean x0(y yVar) {
        return Boolean.valueOf(m.a(m.u0(yVar.e(), 12, 8)).compareTo(BigDecimal.ZERO) > 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0(List list, HbgIntCodeResponse hbgIntCodeResponse) {
        if (hbgIntCodeResponse.isSuccess()) {
            m0(list);
        } else {
            L0(hbgIntCodeResponse);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0(HBDialogFragment hBDialogFragment, boolean z11, Boolean bool) {
        if (!bool.booleanValue()) {
            this.f45768g.unsubscribe();
            hBDialogFragment.dismiss();
            M0();
            return;
        }
        s0(hBDialogFragment, z11);
    }

    public void F0(boolean z11) {
        if (z11) {
            ((dc) getUI()).showProgressDialog();
        }
        Observable<R> first = AssetDataCacheManager.k0().S().compose(RxJavaHelper.s()).first();
        Observable.zip(Observable.zip(v7.b.a().getUsdtExchangeConfig().b().compose(HbgRetrofit.e()), x8.a.a().getCurrenciesReference().b(), first, kb.f45962b).flatMap(new tb(this)).toSortedList(new jb(this)), LegalCurrencyConfigUtil.S(TradeType.PRO, false).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)), new b1(this)).flatMap(i.f3526b).filter(ib.f45929b).toList().compose(RxJavaHelper.t((g) getUI())).subscribe(new a(z11));
    }

    /* renamed from: G0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, dc dcVar) {
        super.onUIReady(baseCoreActivity, dcVar);
        F0(true);
    }

    public final void H0() {
        if (r.x().U()) {
            l.q(true).compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
            return;
        }
        getActivity().startActivity(new Intent(getActivity(), KycProBaseInformationActivity.class));
    }

    public final void I0(List<String> list) {
        v7.b.a().O(list).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new d((g) getUI(), new sb(this, list)));
    }

    public void J0(boolean z11) {
        for (y i11 : this.f45764c) {
            i11.i(z11);
            ((dc) getUI()).setData(this.f45764c);
        }
        if (!z11) {
            this.f45763b.clear();
        } else if (this.f45764c != null) {
            this.f45763b.clear();
            this.f45763b.addAll(this.f45764c);
        }
        ((dc) getUI()).D3(this.f45763b.size());
        ((dc) getUI()).S(j0());
        ((dc) getUI()).y3(this.f45763b.size() > 0);
    }

    public final void K0() {
        HBDialogFragment e02 = DialogUtils.e0(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.n_usdt_exchange_wait));
        Subscription subscription = this.f45768g;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f45768g = Observable.interval(3, 3, TimeUnit.SECONDS).take(4).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new ob(this, e02)));
    }

    public final void L0(HbgIntCodeResponse<String> hbgIntCodeResponse) {
        if (hbgIntCodeResponse.getCode() != 40210) {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), hbgIntCodeResponse.getMessage(), (String) null, getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
        } else if (r.x().X()) {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.ht_exchange_error_msg_2), (String) null, getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
        } else if (r.x().U()) {
            DialogUtils.b0(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.n_usdt_exchange_verifty), (String) null, getString(R.string.n_cancel), getString(R.string.withdraw_action_3), o0.f12469a, new hb(this));
        } else {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.ht_exchange_error_msg_1), (String) null, getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
        }
    }

    public final void M0() {
        DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.n_usdt_exchange_success), (String) null, getString(R.string.n_discharge_optimize_get_coin), new lb(this));
    }

    public void N0() {
        I0(r0());
    }

    public void i(y yVar, boolean z11) {
        i6.d.b(yVar.c().getCurrency() + " becomes checked " + z11);
        boolean z12 = true;
        if (z11) {
            if (!this.f45763b.contains(yVar)) {
                this.f45763b.add(yVar);
            }
            if (this.f45764c != null && this.f45763b.size() == this.f45764c.size()) {
                ((dc) getUI()).C3(true);
            }
        } else {
            this.f45763b.remove(yVar);
            ((dc) getUI()).C3(false);
        }
        ((dc) getUI()).D3(this.f45763b.size());
        ((dc) getUI()).S(j0());
        dc dcVar = (dc) getUI();
        if (this.f45763b.size() <= 0) {
            z12 = false;
        }
        dcVar.y3(z12);
    }

    public String j0() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (y e11 : this.f45763b) {
            bigDecimal = bigDecimal.add(m.a(e11.e()));
        }
        return bigDecimal.toPlainString();
    }

    public final void k0() {
        this.f45763b.clear();
        ((dc) getUI()).D3(this.f45763b.size());
        ((dc) getUI()).S(j0());
        ((dc) getUI()).C3(false);
        ((dc) getUI()).y3(false);
    }

    public void l0() {
    }

    public final void m0(List<String> list) {
        v7.b.a().m(list).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new d((g) getUI(), new nb(this)));
    }

    public final Comparator<BaseAssetInfo> n0() {
        if (this.f45766e == null) {
            this.f45766e = mb.f46006b;
        }
        return this.f45766e;
    }

    public UsdtExchangeConfig p0() {
        return this.f45765d;
    }

    public List<y> q0() {
        return this.f45763b;
    }

    public final List<String> r0() {
        ArrayList arrayList = new ArrayList();
        for (y next : this.f45763b) {
            if (!(next == null || next.c() == null)) {
                String currency = next.c().getCurrency();
                if (!TextUtils.isEmpty(currency)) {
                    arrayList.add(StringUtils.g(currency));
                }
            }
        }
        return arrayList;
    }

    public final void s0(HBDialogFragment hBDialogFragment, boolean z11) {
        if (z11) {
            hBDialogFragment.dismiss();
            HuobiToastUtil.k(getActivity(), R.string.ht_exchange_in_progress);
            getActivity().finish();
        }
    }
}
