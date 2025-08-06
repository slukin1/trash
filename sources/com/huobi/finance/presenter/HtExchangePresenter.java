package com.huobi.finance.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfig;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfigData;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.ui.c6;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.l;
import pro.huobi.R;
import rx.functions.Action1;
import u6.g;
import vk.r;

public class HtExchangePresenter extends NeedLoginActivityPresenter<c6> implements r.a {

    /* renamed from: b  reason: collision with root package name */
    public List<r> f45565b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<r> f45566c;

    /* renamed from: d  reason: collision with root package name */
    public HtExchangeConfig f45567d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45568e = true;

    public class a extends EasySubscriber<HtExchangeConfig> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(HtExchangeConfig htExchangeConfig) {
            HtExchangeConfig unused = HtExchangePresenter.this.f45567d = htExchangeConfig;
        }
    }

    public class b extends EasySubscriber<List<r>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45570b;

        public b(boolean z11) {
            this.f45570b = z11;
        }

        public void onAfter() {
            super.onAfter();
            ((c6) HtExchangePresenter.this.getUI()).finishRefresh();
            if (this.f45570b) {
                ((c6) HtExchangePresenter.this.getUI()).dismissProgressDialog();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((c6) HtExchangePresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((c6) HtExchangePresenter.this.getUI()).m0();
        }

        public void onNext(List<r> list) {
            super.onNext(list);
            HtExchangePresenter.this.f0();
            List unused = HtExchangePresenter.this.f45566c = list;
            if (!HtExchangePresenter.this.f45568e || HtExchangePresenter.this.f45567d == null) {
                if (HtExchangePresenter.this.f45567d != null) {
                    ((c6) HtExchangePresenter.this.getUI()).O3(HtExchangePresenter.this.f45567d);
                }
                ((c6) HtExchangePresenter.this.getUI()).setData(list);
                return;
            }
            ((c6) HtExchangePresenter.this.getUI()).N9(HtExchangePresenter.this.f45567d, list);
            boolean unused2 = HtExchangePresenter.this.f45568e = false;
        }
    }

    public class c implements Action1<HbgIntCodeResponse<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f45572b;

        public c(List list) {
            this.f45572b = list;
        }

        /* renamed from: a */
        public void call(HbgIntCodeResponse<String> hbgIntCodeResponse) {
            if (hbgIntCodeResponse.isSuccess()) {
                HtExchangePresenter.this.g0(this.f45572b);
            } else {
                HtExchangePresenter.this.u0(hbgIntCodeResponse);
            }
        }
    }

    public class d extends EasySubscriber<UserVO> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(UserVO userVO) {
            super.onNext(userVO);
            boolean z11 = true;
            if (l.r() == null || l.r().getRealBind() != 1) {
                z11 = false;
            }
            nb.c.h(HtExchangePresenter.this.getActivity(), z11, false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(HbgIntCodeResponse hbgIntCodeResponse) {
        if (hbgIntCodeResponse.isSuccess()) {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.ht_exchange_in_progress), (String) null, getString(R.string.allow_access_dialog_positive_btn), new e4(this));
        } else {
            u0(hbgIntCodeResponse);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ArrayList m0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            HtExchangeConfigData htExchangeConfigData = (HtExchangeConfigData) it2.next();
            r rVar = new r(new BaseAssetInfo());
            rVar.j(htExchangeConfigData.getExchangeHtAmount());
            rVar.c().setCurrency(htExchangeConfigData.getCurrency());
            rVar.c().setDisplayName(htExchangeConfigData.getDisplayName());
            rVar.c().setAvaialAble(htExchangeConfigData.getAvailableNum());
            rVar.c().setHoldingsNum(htExchangeConfigData.getPositionNum());
            rVar.h(this);
            arrayList.add(rVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(HBDialogFragment hBDialogFragment) {
        r0();
        hBDialogFragment.dismiss();
    }

    public String d0() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (r e11 : this.f45565b) {
            bigDecimal = bigDecimal.add(m.a(e11.e()));
        }
        return bigDecimal.toPlainString();
    }

    public final void f0() {
        this.f45565b.clear();
        ((c6) getUI()).D3(this.f45565b.size());
        ((c6) getUI()).S(d0());
        ((c6) getUI()).C3(false);
        ((c6) getUI()).y3(false);
    }

    public final void g0(List<String> list) {
        v7.b.a().s(list).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new q6.d((g) getUI(), new f4(this)));
    }

    public HtExchangeConfig h0() {
        return this.f45567d;
    }

    public List<r> i0() {
        return this.f45565b;
    }

    public final List<String> j0() {
        ArrayList arrayList = new ArrayList();
        for (r next : this.f45565b) {
            if (!(next == null || next.c() == null)) {
                String currency = next.c().getCurrency();
                if (!TextUtils.isEmpty(currency)) {
                    arrayList.add(StringUtils.g(currency));
                }
            }
        }
        return arrayList;
    }

    public void p0(boolean z11) {
        if (z11) {
            ((c6) getUI()).showProgressDialog();
        }
        v7.b.a().getHtExchangeConfig().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
        v7.b.a().getHtExchangeConfigDataList().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) getUI())).map(new g4(this)).subscribe(new b(z11));
    }

    /* renamed from: q0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c6 c6Var) {
        super.onUIReady(baseCoreActivity, c6Var);
        p0(true);
    }

    public final void r0() {
        if (tg.r.x().U()) {
            l.q(true).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
            return;
        }
        getActivity().startActivity(new Intent(getActivity(), KycProBaseInformationActivity.class));
    }

    public final void s0(List<String> list) {
        v7.b.a().y(list).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new q6.d((g) getUI(), new c(list)));
    }

    public void t0(boolean z11) {
        for (r i11 : this.f45566c) {
            i11.i(z11);
            ((c6) getUI()).setData(this.f45566c);
        }
        if (!z11) {
            this.f45565b.clear();
        } else if (this.f45566c != null) {
            this.f45565b.clear();
            this.f45565b.addAll(this.f45566c);
        }
        ((c6) getUI()).D3(this.f45565b.size());
        ((c6) getUI()).S(d0());
        ((c6) getUI()).y3(this.f45565b.size() > 0);
    }

    public final void u0(HbgIntCodeResponse<String> hbgIntCodeResponse) {
        if (hbgIntCodeResponse.getCode() != 40210) {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), hbgIntCodeResponse.getMessage(), (String) null, getString(R.string.allow_access_dialog_positive_btn), ad.b.f3517a);
        } else if (tg.r.x().X()) {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.ht_exchange_error_msg_2), (String) null, getString(R.string.allow_access_dialog_positive_btn), ad.b.f3517a);
        } else if (tg.r.x().U()) {
            DialogUtils.b0(getActivity(), getString(R.string.allow_access_dialog_title), hbgIntCodeResponse.getMessage(), (String) null, getString(R.string.do_not_auth), getString(R.string.withdraw_action_3), ad.b.f3517a, new d4(this));
        } else {
            DialogUtils.X(getActivity(), getString(R.string.allow_access_dialog_title), getString(R.string.ht_exchange_error_msg_1), (String) null, getString(R.string.allow_access_dialog_positive_btn), ad.b.f3517a);
        }
    }

    public void v(r rVar, boolean z11) {
        i6.d.b(rVar.c().getCurrency() + " becomes checked " + z11);
        boolean z12 = true;
        if (z11) {
            if (!this.f45565b.contains(rVar)) {
                this.f45565b.add(rVar);
            }
            if (this.f45566c != null && this.f45565b.size() == this.f45566c.size()) {
                ((c6) getUI()).C3(true);
            }
        } else {
            this.f45565b.remove(rVar);
            ((c6) getUI()).C3(false);
        }
        ((c6) getUI()).D3(this.f45565b.size());
        ((c6) getUI()).S(d0());
        c6 c6Var = (c6) getUI();
        if (this.f45565b.size() <= 0) {
            z12 = false;
        }
        c6Var.y3(z12);
    }

    public void v0() {
        s0(j0());
    }
}
