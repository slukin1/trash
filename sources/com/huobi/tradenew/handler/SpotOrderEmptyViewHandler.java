package com.huobi.tradenew.handler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.finance.ui.AssetSpotCurrencyDetailActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.utils.SymbolUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import pt.k;
import rt.j;
import s9.c;

public class SpotOrderEmptyViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(j jVar, Context context, View view) {
        String str;
        if (jVar.c()) {
            str = SymbolUtil.b(jVar.a());
        } else {
            str = SymbolUtil.a(jVar.a());
        }
        AssetSpotCurrencyDetailActivity.bj((Activity) context, str, (TradeType) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(j jVar, Context context, View view) {
        String str;
        if (jVar.c()) {
            str = SymbolUtil.b(jVar.a());
        } else {
            str = SymbolUtil.a(jVar.a());
        }
        UnifyTransferActivity.Vh((Activity) context, str, "1", true, (String) null, false, 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, j jVar, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        View b11 = e11.b(R.id.llyt_trade_order_empty_deposit);
        View b12 = e11.b(R.id.llyt_trade_order_empty_transfer);
        ((ImageView) e11.b(R.id.iv_trade_order_empty_deposit)).setImageResource(R.drawable.icon_trade_buy_deposit);
        ((TextView) e11.b(R.id.tv_trade_order_empty_deposit)).setTextColor(ContextCompat.getColor(context, R.color.color_12B298));
        ((ImageView) e11.b(R.id.iv_trade_order_empty_transfer)).setImageResource(R.drawable.icon_trade_buy_transfer);
        ((TextView) e11.b(R.id.tv_trade_order_empty_transfer)).setTextColor(ContextCompat.getColor(context, R.color.color_12B298));
        b11.setOnClickListener(new k(jVar, context));
        b12.setOnClickListener(new pt.j(jVar, context));
    }

    public int getResId() {
        return R.layout.item_trade_order_empty_deposit;
    }
}
