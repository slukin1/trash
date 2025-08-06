package com.hbg.module.kline.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.kline.bean.KlineBuySellItem;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import u6.f;

public class MarketInfoDepthPresenter extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public List<KlineBuySellItem> f23627c;

    /* renamed from: d  reason: collision with root package name */
    public List<KlineBuySellItem> f23628d;

    /* renamed from: e  reason: collision with root package name */
    public String f23629e;

    /* renamed from: f  reason: collision with root package name */
    public String f23630f;

    /* renamed from: g  reason: collision with root package name */
    public TradeType f23631g;

    /* renamed from: h  reason: collision with root package name */
    public ContractCurrencyInfo f23632h;

    /* renamed from: i  reason: collision with root package name */
    public SwapCurrencyInfo f23633i;

    /* renamed from: j  reason: collision with root package name */
    public FutureContractInfo f23634j;

    public interface a extends f {
        void kg();
    }

    public String b0() {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            return intent.getStringExtra("contractCode");
        }
        ContractCurrencyInfo contractCurrencyInfo = this.f23632h;
        if (contractCurrencyInfo != null) {
            return contractCurrencyInfo.getContractCode();
        }
        SwapCurrencyInfo swapCurrencyInfo = this.f23633i;
        if (swapCurrencyInfo != null) {
            return swapCurrencyInfo.getContractCode();
        }
        FutureContractInfo futureContractInfo = this.f23634j;
        return futureContractInfo != null ? futureContractInfo.getContractCode() : "";
    }

    public ContractCurrencyInfo c0() {
        return this.f23632h;
    }

    public String d0() {
        return this.f23630f;
    }

    public String f0() {
        int i11;
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23631g)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23632h;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getSymbol();
            }
        } else if (TradeType.isSwap(this.f23631g)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23633i;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getSymbol();
            }
        } else if (TradeType.isOption(this.f23631g)) {
            FutureContractInfo futureContractInfo2 = this.f23634j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getSymbol();
            }
        } else if (TradeType.isLinearSwap(this.f23631g) && (futureContractInfo = this.f23634j) != null) {
            return futureContractInfo.getSymbol();
        }
        if (TextUtils.isEmpty(this.f23629e) || !this.f23629e.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return null;
        }
        String[] split = this.f23629e.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null) {
            i11 = 0;
        } else {
            i11 = split.length;
        }
        if (i11 >= 1) {
            return split[0];
        }
        return null;
    }

    public FutureContractInfo g0() {
        return this.f23634j;
    }

    public SwapCurrencyInfo h0() {
        return this.f23633i;
    }

    public String i0() {
        return this.f23629e;
    }

    public TradeType j0() {
        return this.f23631g;
    }

    public void k0() {
    }

    /* renamed from: l0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        this.f23627c = new ArrayList();
        this.f23628d = new ArrayList();
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("market_trade_type");
            if (TextUtils.isEmpty(stringExtra)) {
                this.f23631g = TradeType.PRO;
            } else {
                this.f23631g = TradeType.valueOf(stringExtra);
            }
            if (TradeType.isContract(this.f23631g)) {
                this.f23632h = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isSwap(this.f23631g)) {
                this.f23633i = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isOption(this.f23631g)) {
                this.f23634j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isLinearSwap(this.f23631g)) {
                this.f23634j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            }
            this.f23629e = intent.getStringExtra("symbolId");
            this.f23630f = intent.getStringExtra("contract_currency_symble");
        }
        ((a) getUI()).f6().g();
        ((a) getUI()).kg();
    }
}
