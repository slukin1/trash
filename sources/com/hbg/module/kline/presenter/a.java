package com.hbg.module.kline.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.CommunitySwitchBean;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.enums.CommentSwitchEnum;
import com.hbg.module.kline.enums.CommunitySwitchEnum;
import com.hbg.module.kline.enums.SymbolTypeEnum;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import d7.a1;
import de.b;
import de.c;
import de.h1;
import de.j0;
import de.q;
import de.t;
import de.t0;
import de.u;
import de.v;
import i6.d;
import java.util.List;
import u6.g;

public class a extends BaseFragmentPresenter<AbstractKlinePresenter.b> implements q.e, t0.a {

    /* renamed from: c  reason: collision with root package name */
    public u f23706c;

    /* renamed from: d  reason: collision with root package name */
    public String f23707d;

    /* renamed from: e  reason: collision with root package name */
    public String f23708e;

    /* renamed from: f  reason: collision with root package name */
    public String f23709f;

    /* renamed from: g  reason: collision with root package name */
    public ContractCurrencyInfo f23710g;

    /* renamed from: h  reason: collision with root package name */
    public SwapCurrencyInfo f23711h;

    /* renamed from: i  reason: collision with root package name */
    public IndexCurrencyInfo f23712i;

    /* renamed from: j  reason: collision with root package name */
    public FutureContractInfo f23713j;

    /* renamed from: com.hbg.module.kline.presenter.a$a  reason: collision with other inner class name */
    public class C0214a extends EasySubscriber<CommunitySwitchBean> {
        public C0214a() {
        }

        /* renamed from: a */
        public void onNext(CommunitySwitchBean communitySwitchBean) {
            if (communitySwitchBean != null) {
                communitySwitchBean.setCommunityState(0);
                ((AbstractKlinePresenter.b) a.this.getUI()).d6(CommunitySwitchEnum.getType(communitySwitchBean.getCommunityState()), CommentSwitchEnum.getType(communitySwitchBean.getCommentState()), SymbolTypeEnum.getType(communitySwitchBean.getSymbolState()));
                return;
            }
            ((AbstractKlinePresenter.b) a.this.getUI()).d6(CommunitySwitchEnum.HIDE, CommentSwitchEnum.HIDE, SymbolTypeEnum.SYMBOl);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public a(String str, String str2) {
        this.f23707d = str;
        this.f23708e = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f23708e = TradeType.PRO.toString();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(IndexDetail indexDetail) {
        ((AbstractKlinePresenter.b) getUI()).eb(indexDetail);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(HBDialogFragment hBDialogFragment) {
        getActivity().finish();
    }

    public void G(String str, String str2, KlineInfo klineInfo) {
        ((AbstractKlinePresenter.b) getUI()).k8(str, str2, klineInfo);
    }

    public void G3(KlineInfo klineInfo) {
        ((AbstractKlinePresenter.b) getUI()).G3(klineInfo);
    }

    public void K(List<?> list, int i11) {
        ((AbstractKlinePresenter.b) getUI()).K(list, i11);
    }

    public void M(KlineInfo klineInfo) {
        ((AbstractKlinePresenter.b) getUI()).M(klineInfo);
    }

    public void P(String str) {
        ((AbstractKlinePresenter.b) getUI()).P(str);
    }

    public ContractCurrencyInfo d0() {
        return this.f23710g;
    }

    public void e0(double d11) {
        ((AbstractKlinePresenter.b) getUI()).e0(d11);
    }

    public String f0() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23708e)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23710g;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isSwap(this.f23708e)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23711h;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isOption(this.f23708e)) {
            FutureContractInfo futureContractInfo2 = this.f23713j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getContractFace();
            }
            return null;
        } else if (!TradeType.isLinearSwap(this.f23708e) || (futureContractInfo = this.f23713j) == null) {
            return null;
        } else {
            return futureContractInfo.getContractFace();
        }
    }

    public String g0() {
        IndexCurrencyInfo indexCurrencyInfo;
        if (TradeType.isContract(this.f23708e)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23710g;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getContractShortType();
            }
            return null;
        } else if (TradeType.isSwap(this.f23708e)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23711h;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getContractShortType();
            }
            return null;
        } else if (TradeType.isOption(this.f23708e)) {
            FutureContractInfo futureContractInfo = this.f23713j;
            if (futureContractInfo != null) {
                return futureContractInfo.getContractShortType();
            }
            return null;
        } else if (TradeType.isLinearSwap(this.f23708e)) {
            FutureContractInfo futureContractInfo2 = this.f23713j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getContractShortType();
            }
            return null;
        } else if (TradeType.isContractIndex(this.f23708e)) {
            IndexCurrencyInfo indexCurrencyInfo2 = this.f23712i;
            if (indexCurrencyInfo2 != null) {
                return indexCurrencyInfo2.getContractShortType();
            }
            return null;
        } else if (!TradeType.isLinearSwapIndex(this.f23708e) || (indexCurrencyInfo = this.f23712i) == null) {
            return null;
        } else {
            return indexCurrencyInfo.getContractShortType();
        }
    }

    public String h0() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23708e)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23710g;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getSymbol();
            }
            return null;
        } else if (TradeType.isSwap(this.f23708e)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23711h;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getSymbol();
            }
            return null;
        } else if (TradeType.isOption(this.f23708e)) {
            FutureContractInfo futureContractInfo2 = this.f23713j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getSymbol();
            }
            return null;
        } else if (!TradeType.isLinearSwap(this.f23708e) || (futureContractInfo = this.f23713j) == null) {
            return null;
        } else {
            return futureContractInfo.getSymbol();
        }
    }

    public u i0(Intent intent) {
        if (TradeType.HADAX.toString().equalsIgnoreCase(this.f23708e)) {
            return new b(this.f23707d, this.f23709f, this);
        }
        if (TradeType.isIndex(this.f23708e)) {
            return new c(this.f23707d, (g) getUI(), new ce.a(this));
        }
        if (TradeType.isContract(this.f23708e)) {
            return new q(this.f23707d, this.f23709f, intent.getStringExtra("contractCode"), this, (g) getUI());
        } else if (TradeType.isSwap(this.f23708e)) {
            return new h1(this.f23707d, this.f23709f, intent.getStringExtra("contractCode"), this, (g) getUI());
        } else if (TradeType.isContractIndex(this.f23708e)) {
            return new de.a(this.f23712i.getContractCode(), this.f23709f, this);
        } else {
            if (TradeType.isOption(this.f23708e)) {
                FutureContractInfo futureContractInfo = this.f23713j;
                if (futureContractInfo == null) {
                    return null;
                }
                return new t0(futureContractInfo, this.f23709f, intent.getStringExtra("contractCode"), intent.getStringExtra("optionCode"), this, (g) getUI());
            } else if (TradeType.isLinearSwap(this.f23708e)) {
                FutureContractInfo futureContractInfo2 = this.f23713j;
                if (futureContractInfo2 != null) {
                    return new j0(this.f23707d, this.f23709f, futureContractInfo2.getContractCode(), this, (g) getUI());
                }
                return new j0(this.f23707d, this.f23709f, "", this, (g) getUI());
            } else if (TradeType.isLinearSwapIndex(this.f23708e)) {
                return new v(this.f23712i.getContractCode(), this.f23709f, this);
            } else {
                return new t(this.f23707d, this.f23709f, ((AbstractKlinePresenter.b) getUI()).ae(), this);
            }
        }
    }

    public void j(OptionMarketIndexInfo optionMarketIndexInfo) {
        ((AbstractKlinePresenter.b) getUI()).v9(optionMarketIndexInfo);
    }

    public FutureContractInfo j0() {
        return this.f23713j;
    }

    public SwapCurrencyInfo k0() {
        return this.f23711h;
    }

    public String l0() {
        return this.f23707d;
    }

    public void m0(String str) {
        boolean isIndex = TradeType.isIndex(this.f23708e);
        boolean z11 = false;
        boolean z12 = TradeType.isContractIndex(this.f23708e) || TradeType.isLinearSwapIndex(this.f23708e);
        boolean z13 = TradeType.isContract(this.f23708e) || TradeType.isSwap(this.f23708e) || TradeType.isOption(this.f23708e) || TradeType.isLinearSwap(this.f23708e);
        boolean p02 = a1.v().p0(this.f23707d);
        if (!isIndex && !z12 && !z13 && !p02) {
            z11 = true;
        }
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        if (z11 && isChineseLanguage) {
            v7.b.a().communitySwitchConfig(str).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new C0214a());
        }
    }

    public final void n0(Intent intent) {
        if (TradeType.isContract(this.f23708e)) {
            this.f23710g = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isSwap(this.f23708e)) {
            this.f23711h = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isContractIndex(this.f23708e)) {
            this.f23712i = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isOption(this.f23708e)) {
            this.f23713j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isLinearSwap(this.f23708e)) {
            this.f23713j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isLinearSwapIndex(this.f23708e)) {
            this.f23712i = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        }
    }

    public void onPause() {
        super.onPause();
        this.f23706c.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f23706c.onResume();
    }

    public void p3(String str) {
        ((AbstractKlinePresenter.b) getUI()).p3(str);
    }

    public void r0(boolean z11) {
        this.f23706c.b(z11);
    }

    public void s0(boolean z11) {
        u uVar = this.f23706c;
        if (uVar instanceof j0) {
            ((j0) uVar).Q(z11);
        } else if (uVar instanceof h1) {
            ((h1) uVar).Q(z11);
        } else if (uVar instanceof q) {
            ((q) uVar).Q(z11);
        }
    }

    public void s3(String str, String str2, KlineInfo klineInfo) {
        ((AbstractKlinePresenter.b) getUI()).s3(str, str2, klineInfo);
    }

    public void t0(boolean z11, boolean z12) {
        u uVar = this.f23706c;
        if (uVar instanceof j0) {
            ((j0) uVar).S(z11, z12);
        } else if (uVar instanceof h1) {
            ((h1) uVar).S(z11, z12);
        } else if (uVar instanceof q) {
            ((q) uVar).S(z11, z12);
        }
    }

    public void u(KlineInfo klineInfo) {
        ((AbstractKlinePresenter.b) getUI()).u(klineInfo);
    }

    /* renamed from: u0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, AbstractKlinePresenter.b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        n0(intent);
        a1 v11 = a1.v();
        String str = this.f23707d;
        TradeType tradeType = TradeType.PRO;
        String str2 = v11.E(str, tradeType) + "usdt";
        if (a1.v().H(tradeType).contains(str2)) {
            this.f23709f = str2;
        }
        d.b("AbstractKlinePresenter-->onUIReady--> mTradeType:" + this.f23708e + " mQuoteSymbol:" + this.f23709f);
        this.f23706c = i0(intent);
        m0(this.f23707d);
    }

    public void v0(Period period) {
        this.f23706c.a(period);
    }

    public void z() {
        DialogUtils.X(getActivity(), getString(R$string.n_option_delivery_tip), getString(R$string.n_option_has_delivery), "", getString(R$string.lite_trade_i_know), new ce.b(this));
    }
}
