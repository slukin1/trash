package com.hbg.module.kline.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
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
import d7.a1;
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

public class AbstractKlinePresenter extends ActivityPresenter<b> implements q.e, t0.a {

    /* renamed from: b  reason: collision with root package name */
    public u f23605b;

    /* renamed from: c  reason: collision with root package name */
    public String f23606c;

    /* renamed from: d  reason: collision with root package name */
    public String f23607d;

    /* renamed from: e  reason: collision with root package name */
    public String f23608e;

    /* renamed from: f  reason: collision with root package name */
    public ContractCurrencyInfo f23609f;

    /* renamed from: g  reason: collision with root package name */
    public SwapCurrencyInfo f23610g;

    /* renamed from: h  reason: collision with root package name */
    public IndexCurrencyInfo f23611h;

    /* renamed from: i  reason: collision with root package name */
    public FutureContractInfo f23612i;

    public class a extends EasySubscriber<CommunitySwitchBean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(CommunitySwitchBean communitySwitchBean) {
            if (communitySwitchBean != null) {
                communitySwitchBean.setCommunityState(0);
                ((b) AbstractKlinePresenter.this.getUI()).d6(CommunitySwitchEnum.getType(communitySwitchBean.getCommunityState()), CommentSwitchEnum.getType(communitySwitchBean.getCommentState()), SymbolTypeEnum.getType(communitySwitchBean.getSymbolState()));
                return;
            }
            ((b) AbstractKlinePresenter.this.getUI()).d6(CommunitySwitchEnum.HIDE, CommentSwitchEnum.HIDE, SymbolTypeEnum.SYMBOl);
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public interface b extends g {
        void G3(KlineInfo klineInfo);

        void K(List<?> list, int i11);

        void M(KlineInfo klineInfo);

        void P(String str);

        boolean ae();

        void d6(CommunitySwitchEnum communitySwitchEnum, CommentSwitchEnum commentSwitchEnum, SymbolTypeEnum symbolTypeEnum);

        void e0(double d11);

        void eb(IndexDetail indexDetail);

        Activity getActivity();

        void k8(String str, String str2, KlineInfo klineInfo);

        void p3(String str);

        void s3(String str, String str2, KlineInfo klineInfo);

        void u(KlineInfo klineInfo);

        void v9(OptionMarketIndexInfo optionMarketIndexInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(IndexDetail indexDetail) {
        ((b) getUI()).eb(indexDetail);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(HBDialogFragment hBDialogFragment) {
        getActivity().finish();
    }

    public void G(String str, String str2, KlineInfo klineInfo) {
        ((b) getUI()).k8(str, str2, klineInfo);
    }

    public void G3(KlineInfo klineInfo) {
        ((b) getUI()).G3(klineInfo);
    }

    public void K(List<?> list, int i11) {
        ((b) getUI()).K(list, i11);
    }

    public void M(KlineInfo klineInfo) {
        ((b) getUI()).M(klineInfo);
    }

    public void P(String str) {
        ((b) getUI()).P(str);
    }

    public String S() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23607d)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23609f;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isSwap(this.f23607d)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23610g;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isOption(this.f23607d)) {
            FutureContractInfo futureContractInfo2 = this.f23612i;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getContractFace();
            }
            return null;
        } else if (!TradeType.isLinearSwap(this.f23607d) || (futureContractInfo = this.f23612i) == null) {
            return null;
        } else {
            return futureContractInfo.getContractFace();
        }
    }

    public String T() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23607d)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23609f;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getSymbol();
            }
            return null;
        } else if (TradeType.isSwap(this.f23607d)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23610g;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getSymbol();
            }
            return null;
        } else if (TradeType.isOption(this.f23607d)) {
            FutureContractInfo futureContractInfo2 = this.f23612i;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getSymbol();
            }
            return null;
        } else if (!TradeType.isLinearSwap(this.f23607d) || (futureContractInfo = this.f23612i) == null) {
            return null;
        } else {
            return futureContractInfo.getSymbol();
        }
    }

    public u U(Intent intent) {
        if (TradeType.isIndex(this.f23607d)) {
            return new c(this.f23606c, (g) getUI(), new ce.c(this));
        }
        if (TradeType.isContract(this.f23607d)) {
            return new q(this.f23606c, this.f23608e, intent.getStringExtra("contractCode"), this, (g) getUI());
        } else if (TradeType.isSwap(this.f23607d)) {
            return new h1(this.f23606c, this.f23608e, intent.getStringExtra("contractCode"), this, (g) getUI());
        } else if (TradeType.isContractIndex(this.f23607d)) {
            return new de.a(this.f23611h.getContractCode(), this.f23608e, this);
        } else {
            if (TradeType.isOption(this.f23607d)) {
                FutureContractInfo futureContractInfo = this.f23612i;
                if (futureContractInfo == null) {
                    return null;
                }
                return new t0(futureContractInfo, this.f23608e, intent.getStringExtra("contractCode"), intent.getStringExtra("optionCode"), this, (g) getUI());
            } else if (TradeType.isLinearSwap(this.f23607d)) {
                FutureContractInfo futureContractInfo2 = this.f23612i;
                if (futureContractInfo2 == null) {
                    return null;
                }
                return new j0(this.f23606c, this.f23608e, futureContractInfo2.getContractCode(), this, (g) getUI());
            } else if (TradeType.isLinearSwapIndex(this.f23607d)) {
                return new v(this.f23611h.getContractCode(), this.f23608e, this);
            } else {
                return new t(this.f23606c, this.f23608e, ((b) getUI()).ae(), this);
            }
        }
    }

    public FutureContractInfo V() {
        return this.f23612i;
    }

    public void W(String str) {
        boolean isIndex = TradeType.isIndex(this.f23607d);
        boolean z11 = false;
        boolean z12 = TradeType.isContractIndex(this.f23607d) || TradeType.isLinearSwapIndex(this.f23607d);
        boolean z13 = TradeType.isContract(this.f23607d) || TradeType.isSwap(this.f23607d) || TradeType.isOption(this.f23607d) || TradeType.isLinearSwap(this.f23607d);
        boolean p02 = a1.v().p0(this.f23606c);
        if (!isIndex && !z12 && !z13 && !p02) {
            z11 = true;
        }
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        if (z11 && isChineseLanguage) {
            v7.b.a().communitySwitchConfig(str).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
        }
    }

    public final void X(Intent intent) {
        if (TradeType.isContract(this.f23607d)) {
            this.f23609f = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isSwap(this.f23607d)) {
            this.f23610g = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isContractIndex(this.f23607d)) {
            this.f23611h = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isOption(this.f23607d)) {
            this.f23612i = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isLinearSwap(this.f23607d)) {
            this.f23612i = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
        } else if (TradeType.isLinearSwapIndex(this.f23607d)) {
            this.f23611h = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        }
    }

    public void a0(boolean z11) {
        this.f23605b.b(z11);
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        this.f23606c = intent.getStringExtra("symbolId");
        String stringExtra = intent.getStringExtra("market_trade_type");
        this.f23607d = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.f23607d = TradeType.PRO.toString();
        }
        X(intent);
        a1 v11 = a1.v();
        String str = this.f23606c;
        TradeType tradeType = TradeType.PRO;
        String str2 = v11.E(str, tradeType) + "usdt";
        if (a1.v().H(tradeType).contains(str2)) {
            this.f23608e = str2;
        }
        d.b("AbstractKlinePresenter-->onUIReady--> mTradeType:" + this.f23607d + " mQuoteSymbol:" + this.f23608e);
        this.f23605b = U(intent);
        W(this.f23606c);
    }

    public void c0(Period period) {
        this.f23605b.a(period);
    }

    public void e0(double d11) {
        ((b) getUI()).e0(d11);
    }

    public void j(OptionMarketIndexInfo optionMarketIndexInfo) {
        ((b) getUI()).v9(optionMarketIndexInfo);
    }

    public void onPause() {
        super.onPause();
        this.f23605b.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f23605b.onResume();
    }

    public void p3(String str) {
        ((b) getUI()).p3(str);
    }

    public void s3(String str, String str2, KlineInfo klineInfo) {
        ((b) getUI()).s3(str, str2, klineInfo);
    }

    public void u(KlineInfo klineInfo) {
        ((b) getUI()).u(klineInfo);
    }

    public void z() {
        DialogUtils.X(getActivity(), getString(R$string.n_option_delivery_tip), getString(R$string.n_option_has_delivery), "", getString(R$string.lite_trade_i_know), new ce.d(this));
    }
}
