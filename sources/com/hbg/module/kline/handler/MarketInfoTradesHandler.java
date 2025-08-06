package com.hbg.module.kline.handler;

import a7.e;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.MarketInfoTradesItem;
import i6.m;
import i6.r;
import java.text.SimpleDateFormat;
import java.util.Locale;
import s9.c;
import td.i;
import u9.b;

public class MarketInfoTradesHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f23525b;

    /* renamed from: b */
    public void handleView(b bVar, int i11, MarketInfoTradesItem marketInfoTradesItem, ViewGroup viewGroup) {
        String stringExtra = ((Activity) bVar.b().getContext()).getIntent().getStringExtra("contract_currency_symble");
        r c11 = bVar.c();
        Context context = bVar.b().getContext();
        TextView textView = (TextView) c11.b(R$id.trades_time_tv);
        TextView textView2 = (TextView) c11.b(R$id.trades_direction_tv);
        TextView textView3 = (TextView) c11.b(R$id.trades_price_tv);
        TextView textView4 = (TextView) c11.b(R$id.trades_amount_tv);
        MarketTradeDetailInfo tradeDetailInfo = marketInfoTradesItem.getTradeDetailInfo();
        if (this.f23525b == null) {
            this.f23525b = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        }
        textView.setText(this.f23525b.format(Long.valueOf(tradeDetailInfo.getTs())));
        if ("buy".equals(tradeDetailInfo.getDirection())) {
            textView2.setText(R$string.market_info_trade_buy_type);
            textView2.setTextColor(ContextCompat.getColor(context, w.h()));
        } else {
            textView2.setText(R$string.market_info_trade_sell_type);
            textView2.setTextColor(ContextCompat.getColor(context, w.d()));
        }
        if (tradeDetailInfo.getPrice() == null) {
            textView3.setText("--");
        } else if (marketInfoTradesItem.getTradeType() == TradeType.CONTRACT) {
            textView3.setText(m.m(tradeDetailInfo.getPrice(), i.a().b().z(marketInfoTradesItem.getTradeDetailInfo().getContractCode())));
        } else if (TradeType.isSwap(marketInfoTradesItem.getTradeType())) {
            textView3.setText(m.m(tradeDetailInfo.getPrice(), i.a().b().y(stringExtra)));
        } else if (TradeType.isOption(marketInfoTradesItem.getTradeType())) {
            textView3.setText(m.m(tradeDetailInfo.getPrice(), FuturePrecisionUtil.y(tradeDetailInfo.getContractCode(), "", tradeDetailInfo.getOptionCode())));
        } else if (TradeType.isLinearSwap(marketInfoTradesItem.getTradeType())) {
            textView3.setText(m.m(tradeDetailInfo.getPrice(), FuturePrecisionUtil.y(tradeDetailInfo.getContractCode(), tradeDetailInfo.getContractShortType(), "")));
        } else {
            textView3.setText(m.m(tradeDetailInfo.getPrice(), PrecisionUtil.e(tradeDetailInfo.getSymbol())));
        }
        if (tradeDetailInfo.getAmount() == null) {
            textView4.setText("--");
            return;
        }
        TradeType tradeType = marketInfoTradesItem.getTradeType();
        TradeType tradeType2 = TradeType.CONTRACT;
        if (tradeType == tradeType2) {
            if (e.E(tradeType2)) {
                textView4.setText(tradeDetailInfo.getAmount());
            } else {
                textView4.setText(m.m(tradeDetailInfo.getAmount(), i.a().b().D(tradeDetailInfo.getSymbol())));
            }
        } else if (TradeType.isSwap(marketInfoTradesItem.getTradeType())) {
            if (e.E(TradeType.SWAP)) {
                textView4.setText(tradeDetailInfo.getAmount());
            } else {
                textView4.setText(m.m(tradeDetailInfo.getAmount(), i.a().b().j(tradeDetailInfo.getSymbol())));
            }
        } else if (TradeType.isOption(marketInfoTradesItem.getTradeType())) {
            if (e.E(marketInfoTradesItem.getTradeType())) {
                textView4.setText(tradeDetailInfo.getAmount());
            } else {
                textView4.setText(m.m(tradeDetailInfo.getAmount(), FuturePrecisionUtil.B()));
            }
        } else if (!TradeType.isLinearSwap(marketInfoTradesItem.getTradeType())) {
            textView4.setText(m.m(tradeDetailInfo.getAmount(), PrecisionUtil.d(tradeDetailInfo.getSymbol())));
        } else if (e.F(marketInfoTradesItem.getTradeType())) {
            textView4.setText(tradeDetailInfo.getAmount());
        } else {
            textView4.setText(m.m(tradeDetailInfo.getAmount(), FuturePrecisionUtil.B()));
        }
    }

    public int getResId() {
        return R$layout.item_market_info_trades;
    }
}
