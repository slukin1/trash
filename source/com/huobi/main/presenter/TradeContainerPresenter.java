package com.huobi.main.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.contract.entity.ContractChangeEvent;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.feature.bean.FutureChangeEvent;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.swap.bean.SwapChangeEvent;
import com.huobi.utils.k0;
import d7.a1;
import dt.i2;
import java.util.List;
import lk.a;
import org.greenrobot.eventbus.EventBus;
import u6.g;

public class TradeContainerPresenter extends ActivityPresenter<g> {

    /* renamed from: c  reason: collision with root package name */
    public static String f77776c = "pro.huobi.pro";

    /* renamed from: a  reason: collision with root package name */
    public TradeType f77777a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f77778b = null;

    public void Q(ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
        if (k0.g() == TradeType.SWAP) {
            BaseCoreActivity activity = getActivity();
            boolean z11 = activity != null && (activity instanceof HuobiMainActivity);
            Intent d11 = k0.d(activity, z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            d11.putExtra("contract_currency_info", contractCurrencyInfo);
            if (contractCurrencyInfo != null) {
                ContractUserInfoProvider.i().x(contractCurrencyInfo);
            }
            activity.startActivity(d11);
            activity.overridePendingTransition(0, 0);
            return;
        }
        Bundle bundle = null;
        if (getActivity().getIntent() != null) {
            bundle = getActivity().getIntent().getExtras();
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("contract_currency_info", contractCurrencyInfo);
        ContractChangeEvent contractChangeEvent = new ContractChangeEvent();
        contractChangeEvent.setInfo(contractCurrencyInfo);
        EventBus.d().k(contractChangeEvent);
    }

    public final void R() {
        String d11 = i2.a().d(this.f77777a);
        if (TextUtils.isEmpty(d11)) {
            List<SymbolBean> Z = a1.v().Z(this.f77777a);
            d11 = (Z == null || Z.isEmpty()) ? "" : Z.get(0).getSymbol();
        }
        i2.a().h(this.f77777a, d11);
    }

    public void S(FutureContractInfo futureContractInfo, TradeType tradeType) {
        Bundle extras = getActivity().getIntent() != null ? getActivity().getIntent().getExtras() : null;
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putSerializable("linear_swap_currency_info", futureContractInfo);
        FutureChangeEvent futureChangeEvent = new FutureChangeEvent();
        futureChangeEvent.setInfo(futureContractInfo);
        EventBus.d().k(futureChangeEvent);
    }

    public void T(String str, TradeType tradeType) {
        k0.H(tradeType);
        f77776c = k0.w();
        this.f77777a = tradeType;
        String d11 = i2.a().d(tradeType);
        i2.a().h(tradeType, str);
        R();
        boolean p02 = a1.v().p0(str);
        if (p02 != a1.v().p0(d11)) {
            EventBus.d().k(new a(p02));
            return;
        }
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(d11);
        symbolChangeEvent.j(tradeType);
        EventBus.d().k(symbolChangeEvent);
    }

    public void U(SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
        if (k0.g() == TradeType.CONTRACT) {
            BaseCoreActivity activity = getActivity();
            boolean z11 = activity != null && (activity instanceof HuobiMainActivity);
            Intent v11 = k0.v(activity, z11);
            if (!z11) {
                v11.addFlags(67108864);
                if (swapCurrencyInfo != null) {
                    ContractUserInfoProvider.i().y(swapCurrencyInfo);
                }
            } else {
                v11.putExtra("swap_currency_info", swapCurrencyInfo);
            }
            activity.startActivity(v11);
            activity.overridePendingTransition(0, 0);
            return;
        }
        Bundle bundle = null;
        if (getActivity().getIntent() != null) {
            bundle = getActivity().getIntent().getExtras();
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable("swap_currency_info", swapCurrencyInfo);
        SwapChangeEvent swapChangeEvent = new SwapChangeEvent();
        swapChangeEvent.setInfo(swapCurrencyInfo);
        EventBus.d().k(swapChangeEvent);
    }
}
