package com.huobi.contract.ui;

import a7.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
import com.huobi.contract.entity.ContractOrderDetailInfo;
import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import dj.q1;
import dj.r1;
import ej.f;
import ej.g;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;

public class ContractTradeDetailActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ContractHistoryOrderInfo f43386b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<ContractOrderDetailInfo> f43387c;

    public static Intent Og(Context context, ContractHistoryOrderInfo contractHistoryOrderInfo) {
        Class cls;
        if (contractHistoryOrderInfo.isCanceled()) {
            cls = ContractTradeCancelDetailActivity.class;
        } else {
            cls = ContractTradeDetailActivity.class;
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra("EXTRA", contractHistoryOrderInfo);
        return intent;
    }

    public static /* synthetic */ ContractOrderDetailResult oh(Map map, ContractOrderDetailResult contractOrderDetailResult) {
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        if (m11 != null) {
            for (ContractCurrencyInfo next : m11) {
                if (next != null) {
                    map.put(next.getSymbol(), next);
                }
            }
        }
        return contractOrderDetailResult;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(Map map, ContractOrderDetailResult contractOrderDetailResult) {
        if (contractOrderDetailResult != null) {
            Zf(map, contractOrderDetailResult);
        }
    }

    public static void rh(Context context, ContractHistoryOrderInfo contractHistoryOrderInfo) {
        if (context != null && contractHistoryOrderInfo != null) {
            context.startActivity(Og(context, contractHistoryOrderInfo));
        }
    }

    public String Pg() {
        return getString(R$string.detail_order_title);
    }

    public final void Qg() {
        setToolBar((Toolbar) this.viewFinder.b(R$id.toolbar), Pg(), true);
        ((CollapsingToolbarLayout) this.viewFinder.b(R$id.collapsing_toolbar)).setShowDivider(false);
    }

    public void Zf(Map<String, ContractCurrencyInfo> map, ContractOrderDetailResult contractOrderDetailResult) {
        List<ContractOrderDetailInfo> trades = contractOrderDetailResult.getTrades();
        String orderPriceTypeString = contractOrderDetailResult.getOrderPriceTypeString(this);
        for (ContractOrderDetailInfo next : trades) {
            next.setSymbol(contractOrderDetailResult.getSymbol());
            next.setPrice(contractOrderDetailResult.getPrice());
            next.setContractCode(contractOrderDetailResult.getContractCode());
            next.setContractFace(map.get(next.getSymbol()).getContractFace());
            next.setOrderPriceTypeStr(orderPriceTypeString);
        }
        this.f43387c.setData(trades);
    }

    public void fg(ContractHistoryOrderInfo contractHistoryOrderInfo) {
        String str;
        int i11;
        TradeType tradeType = TradeType.CONTRACT;
        if (e.E(tradeType)) {
            str = contractHistoryOrderInfo.getSymbol();
        } else {
            str = getString(R$string.contract_market_vol_sheet);
        }
        TextView textView = (TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_volume);
        TextView textView2 = (TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_price);
        TextView textView3 = (TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_fee);
        Locale locale = Locale.US;
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_volume_title)).setText(String.format(locale, getString(R$string.contract_entrust_order_finish_volume), new Object[]{str}));
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_price_title)).setText(String.format(locale, getString(R$string.contract_current_order_trade_price), new Object[]{"usd".toUpperCase(locale)}));
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_fee_title)).setText(String.format(locale, getString(R$string.contract_entrust_order_fee), new Object[]{contractHistoryOrderInfo.getSymbol()}));
        boolean E = e.E(tradeType);
        String e11 = ContractOrderHelper.e(contractHistoryOrderInfo.getTradeVolume(), contractHistoryOrderInfo.getTradeAvgPrice(), contractHistoryOrderInfo.getContractFace());
        if (E) {
            i11 = f.o(contractHistoryOrderInfo.getSymbol());
        } else {
            i11 = f.c(contractHistoryOrderInfo.getSymbol());
        }
        textView.setText(m.m(e11, i11));
        textView2.setText(m.n(contractHistoryOrderInfo.getTradeAvgPrice(), f.r(contractHistoryOrderInfo.getSymbol()), "--"));
        textView3.setText(m.u(contractHistoryOrderInfo.getFee(), f.m(contractHistoryOrderInfo.getSymbol())));
    }

    public int getContentView() {
        return R$layout.contract_activity_trade_detail;
    }

    public final void gg(ContractHistoryOrderInfo contractHistoryOrderInfo) {
        String str;
        TextView textView = (TextView) this.viewFinder.b(R$id.contract_trade_detail_symbol_tv);
        TextView textView2 = (TextView) this.viewFinder.b(R$id.contract_trade_detail_code_tv);
        if (contractHistoryOrderInfo.isBuy()) {
            textView.setTextColor(BaseApplication.a(w.h()));
        } else {
            textView.setTextColor(BaseApplication.a(w.d()));
        }
        if (contractHistoryOrderInfo.isOpen()) {
            if (contractHistoryOrderInfo.isBuy()) {
                str = getString(R$string.contract_trade_open_more);
            } else {
                str = getString(R$string.contract_trade_open_low);
            }
        } else if (contractHistoryOrderInfo.isDelivery()) {
            str = getString(R$string.currency_detail_contract_status_force_delivry);
        } else if (contractHistoryOrderInfo.isExplose()) {
            if (contractHistoryOrderInfo.isBuy()) {
                str = getString(R$string.contract_trade_cutdown_low);
            } else {
                str = getString(R$string.contract_trade_cutdown_more);
            }
        } else if (contractHistoryOrderInfo.isBuy()) {
            str = getString(R$string.contract_trade_close_low);
        } else {
            str = getString(R$string.contract_trade_close_more);
        }
        textView.setText(str + "·" + contractHistoryOrderInfo.getLeverRate() + "X");
        textView2.setText(g.g(contractHistoryOrderInfo.getContractCode()));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
        this.f43386b = (ContractHistoryOrderInfo) getIntent().getSerializableExtra("EXTRA");
        Qg();
        this.f43387c = (EasyRecyclerView) findViewById(R$id.contract_trade_detail_recyclerView);
        sh(this.f43386b);
        qh(this.f43386b);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        finish();
    }

    public final void qh(ContractHistoryOrderInfo contractHistoryOrderInfo) {
        HashMap hashMap = new HashMap();
        ContractOrderHelper.c(contractHistoryOrderInfo.getSymbol(), contractHistoryOrderInfo.getOrderType(), contractHistoryOrderInfo.getOrderId().longValue(), contractHistoryOrderInfo.getCreateDate().longValue()).compose(RxJavaHelper.t(getUI())).map(new r1(hashMap)).subscribe(d.c(getUI(), new q1(this, hashMap)));
    }

    public final void sh(ContractHistoryOrderInfo contractHistoryOrderInfo) {
        if (contractHistoryOrderInfo == null) {
            i6.d.d("ContractTradeDetailActivity-->updateData-->null!!!!!!!!!!!!!!!!!!!!!!");
            return;
        }
        gg(contractHistoryOrderInfo);
        fg(contractHistoryOrderInfo);
    }
}
