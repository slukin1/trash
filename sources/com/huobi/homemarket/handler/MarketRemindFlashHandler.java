package com.huobi.homemarket.handler;

import ad.b;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.MarketAutoRemindItem;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Locale;
import oa.a;
import ql.n;
import s9.c;

public class MarketRemindFlashHandler implements c, View.OnClickListener {
    public static String c(String str) {
        String j11 = BaseModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon/" + str.toLowerCase() + ".png?t=" + System.currentTimeMillis();
    }

    public static int d() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(View view) {
        BaseModuleConfig.a().w("MT_ST_disclaimer", (HashMap) null);
        DialogUtils.X((FragmentActivity) a.g().b(), BaseApplication.b().getResources().getString(R$string.n_market_remind_protocol), BaseApplication.b().getResources().getString(R$string.n_remind_market_protocol_desc), (String) null, BaseApplication.b().getString(R$string.otc_one_key_to_buy_know), b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, MarketRemindFlashItem marketRemindFlashItem, ViewGroup viewGroup) {
        MarketAutoRemindItem marketAutoRemindItem = (MarketAutoRemindItem) cVar.itemView.findViewById(R$id.market_auto_remind_item);
        boolean z11 = true;
        boolean z12 = !marketRemindFlashItem.n();
        String e11 = marketRemindFlashItem.e();
        if (i11 != 0) {
            z11 = false;
        }
        marketAutoRemindItem.b(z12, e11, z11, n.f60045b);
        marketAutoRemindItem.c(c(marketRemindFlashItem.c()), d());
        marketAutoRemindItem.setShowTime(marketRemindFlashItem.k());
        marketAutoRemindItem.setTitle(marketRemindFlashItem.l());
        marketAutoRemindItem.setContent(marketRemindFlashItem.d());
        marketAutoRemindItem.setCoin(marketRemindFlashItem.c());
        marketAutoRemindItem.d(marketRemindFlashItem.f(), marketRemindFlashItem.i());
        marketAutoRemindItem.setOnClickListener(this);
        marketAutoRemindItem.setTag(marketRemindFlashItem);
    }

    public int getResId() {
        return R$layout.item_market_remind;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        MarketRemindFlashItem marketRemindFlashItem = (MarketRemindFlashItem) view.getTag();
        String j11 = marketRemindFlashItem.j();
        if (j11.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) || j11.contains("_")) {
            j11 = j11.toUpperCase(Locale.ROOT);
        }
        MarketModuleConfig.a().y(view.getContext(), marketRemindFlashItem.j(), false, TradeType.getTradeTypeBySymbol(j11), "3");
        HashMap hashMap = new HashMap();
        hashMap.put("id", Long.valueOf(marketRemindFlashItem.g()));
        BaseModuleConfig.a().w("MT_ST_Content_of_the_hot_spots", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
