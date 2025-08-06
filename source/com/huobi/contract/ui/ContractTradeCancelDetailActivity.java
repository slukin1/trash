package com.huobi.contract.ui;

import a7.e;
import android.os.Bundle;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
import com.huobi.contract.entity.ContractOrderDetailResult;
import com.huobi.contract.helper.ContractOrderHelper;
import ej.f;
import i6.m;
import java.util.Locale;
import java.util.Map;

public class ContractTradeCancelDetailActivity extends ContractTradeDetailActivity {
    public String Pg() {
        return getString(R$string.contract_order_canceled);
    }

    public void Zf(Map<String, ContractCurrencyInfo> map, ContractOrderDetailResult contractOrderDetailResult) {
        ((TextView) this.viewFinder.b(R$id.tv_cancel_time)).setText(DateTimeUtils.C(contractOrderDetailResult.getCancelDate()));
        ((TextView) this.viewFinder.b(R$id.tv_order_type)).setText(contractOrderDetailResult.getOrderPriceTypeString(this));
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
        TextView textView2 = (TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_fee);
        Locale locale = Locale.US;
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_price_title)).setText(String.format(locale, getString(R$string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_volume_title)).setText(String.format(locale, getString(R$string.contract_entrust_order_volume), new Object[]{str}));
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_fee_title)).setText(String.format(locale, getString(R$string.contract_entrust_order_get_money), new Object[]{contractHistoryOrderInfo.getSymbol()}));
        boolean E = e.E(tradeType);
        ((TextView) this.viewFinder.b(R$id.item_contract_order_tv_trade_price)).setText(m.n(contractHistoryOrderInfo.getPrice(), f.r(contractHistoryOrderInfo.getSymbol()), "--"));
        String e11 = ContractOrderHelper.e(contractHistoryOrderInfo.getVolume(), contractHistoryOrderInfo.getPrice(), contractHistoryOrderInfo.getContractFace());
        if (E) {
            i11 = f.o(contractHistoryOrderInfo.getSymbol());
        } else {
            i11 = f.t(contractHistoryOrderInfo.getSymbol());
        }
        textView.setText(m.m(e11, i11));
        textView2.setText(m.u(contractHistoryOrderInfo.getProfit(), f.o(contractHistoryOrderInfo.getSymbol())));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.viewFinder.b(R$id.cancel_layout).setVisibility(0);
    }
}
