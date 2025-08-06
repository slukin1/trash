package com.huobi.trade.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bt.q2;
import com.huobi.trade.bean.TradingBotSelectMarketInfo;
import com.huobi.utils.a0;
import com.luck.picture.lib.config.PictureMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kc.a;
import pro.huobi.R;
import s9.c;

public class TradingBotSelectMarketItemHandler implements c {
    public static String c(String str) {
        return a0.j() + "/-/x/hb/p/api/contents/currency/icon_png/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(TradingBotSelectMarketInfo tradingBotSelectMarketInfo, View view) {
        if (tradingBotSelectMarketInfo.getSelectSymbolCallback() != null) {
            tradingBotSelectMarketInfo.getSelectSymbolCallback().Zf(tradingBotSelectMarketInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, TradingBotSelectMarketInfo tradingBotSelectMarketInfo, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.id_tag_tv);
        ImageView imageView = (ImageView) cVar.e().b(R.id.iv_selected);
        ImageView imageView2 = (ImageView) cVar.e().b(R.id.iv_currency);
        ((TextView) cVar.e().b(R.id.id_symbol_tv)).setText(tradingBotSelectMarketInfo.getDisplayName());
        cVar.itemView.setOnClickListener(new q2(tradingBotSelectMarketInfo));
        if (tradingBotSelectMarketInfo.isAllMarket()) {
            imageView2.setImageResource(R.drawable.edge_engine_trading_bot_all_market);
        } else if (TextUtils.isEmpty(tradingBotSelectMarketInfo.getCurrency())) {
            imageView2.setImageResource(a.f19139a.f());
        } else {
            f6.c.a().f(imageView2, c(tradingBotSelectMarketInfo.getCurrency()), a.f19139a.f());
        }
        int i12 = 0;
        textView.setVisibility(tradingBotSelectMarketInfo.isContract() ? 0 : 4);
        if (!tradingBotSelectMarketInfo.isCurrentSelected()) {
            i12 = 4;
        }
        imageView.setVisibility(i12);
    }

    public int getResId() {
        return R.layout.item_tradingbot_select_market_layout;
    }
}
