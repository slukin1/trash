package com.huobi.contract.viewhandler;

import a7.e;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.contract.entity.ContractOrderDetailInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import ej.f;
import i6.m;
import i6.r;
import java.text.SimpleDateFormat;
import java.util.Locale;
import s9.c;

public class ContractOrderRspInfoHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f43582b = new SimpleDateFormat("HH:mm MM/dd", Locale.US);

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ContractOrderDetailInfo contractOrderDetailInfo, ViewGroup viewGroup) {
        String str;
        int i12;
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.contract_order_detail_item_amount);
        TextView textView2 = (TextView) e11.b(R$id.contract_order_detail_item_type);
        TextView textView3 = (TextView) e11.b(R$id.contract_order_detail_item_fee);
        ((TextView) e11.b(R$id.contract_order_detail_item_time)).setText(this.f43582b.format(Long.valueOf(contractOrderDetailInfo.getCreatedAt())));
        ((TextView) e11.b(R$id.contract_order_detail_item_order_type)).setText(contractOrderDetailInfo.getOrderPriceTypeStr());
        ((TextView) e11.b(R$id.contract_order_detail_item_price)).setText(m.n(contractOrderDetailInfo.getTradePrice(), f.r(contractOrderDetailInfo.getSymbol()), "--") + " " + "usd".toUpperCase(Locale.US));
        TradeType tradeType = TradeType.CONTRACT;
        boolean E = e.E(tradeType);
        if (e.E(tradeType)) {
            str = contractOrderDetailInfo.getSymbol();
        } else {
            str = BaseApplication.c(R$string.contract_market_vol_sheet);
        }
        StringBuilder sb2 = new StringBuilder();
        String e12 = ContractOrderHelper.e(contractOrderDetailInfo.getTradeVolume(), contractOrderDetailInfo.getTradePrice(), contractOrderDetailInfo.getContractFace());
        if (E) {
            i12 = f.o(contractOrderDetailInfo.getSymbol());
        } else {
            i12 = f.c(contractOrderDetailInfo.getSymbol());
        }
        sb2.append(m.m(e12, i12));
        sb2.append(" ");
        sb2.append(str);
        textView.setText(sb2.toString());
        textView2.setText(StringUtils.e(contractOrderDetailInfo.getRole()));
        textView3.setText(m.u(contractOrderDetailInfo.getFee(), f.m(contractOrderDetailInfo.getSymbol())) + " " + contractOrderDetailInfo.getSymbol());
    }

    public int getResId() {
        return R$layout.contract_order_detail_item;
    }
}
