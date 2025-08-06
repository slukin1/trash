package com.huobi.homemarket.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$font;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.index.bean.RealTimePrice;
import com.huobi.trade.helper.f0;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.util.HashMap;
import s9.c;

public class IndexViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, RealTimePrice realTimePrice, ViewGroup viewGroup) {
        c(cVar, realTimePrice, i11);
    }

    public final void c(v9.c cVar, RealTimePrice realTimePrice, int i11) {
        String str;
        String str2;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R$id.item_data, realTimePrice);
        cVar.itemView.setTag(R$id.item_data1, Integer.valueOf(i11));
        TextView e12 = e11.e(R$id.item_chart_basecurrency);
        TextView e13 = e11.e(R$id.item_chart_quotecurrency);
        TextView e14 = e11.e(R$id.item_chart_price);
        TextView e15 = e11.e(R$id.item_chart_percent);
        TextView e16 = e11.e(R$id.item_chart_etp_tag);
        String o11 = realTimePrice.o();
        if (o11 == null) {
            o11 = "";
        }
        Double valueOf = Double.valueOf(realTimePrice.j());
        realTimePrice.s();
        if (valueOf.doubleValue() >= 0.0d) {
            str = m.m(String.valueOf(valueOf), PrecisionUtil.x(o11));
        } else {
            str = "--";
        }
        e12.setText(realTimePrice.h());
        e13.setText("/" + a1.v().F(realTimePrice.o()));
        e14.setText(str);
        try {
            double doubleValue = Double.valueOf(realTimePrice.i()).doubleValue();
            if (realTimePrice.i() == null) {
                e15.setText("--");
                str2 = "--";
            } else {
                str2 = m.Q(String.valueOf(doubleValue), PrecisionUtil.v((String) null), 1);
                if (Double.compare(doubleValue, 0.0d) > 0) {
                    str2 = "+" + str2;
                }
                e15.setText(str2);
            }
            e15.setBackground(new BgColorDrawable(context.getResources().getColor(w.k(str2)), AbsMarketViewHandler.f72703g));
        } catch (Exception unused) {
            e15.setBackground(new BgColorDrawable(context.getResources().getColor(w.e()), AbsMarketViewHandler.f72703g));
            e15.setText("--");
        }
        SymbolBean n11 = realTimePrice.n();
        if (n11 == null || !n11.isEtpTag()) {
            ViewUtil.m(e16, false);
        } else {
            String d11 = f0.d(context, n11.getDirection(), n11.getEtpLeverageRatio());
            if (!TextUtils.isEmpty(d11)) {
                ViewUtil.m(e16, true);
                e16.setText(d11);
                e16.setTextColor(f0.g(context, n11.isEtpTag(), n11.getDirection()));
                e16.setBackgroundResource(f0.e(n11.isEtpTag(), n11.getDirection()));
            } else {
                ViewUtil.m(e16, false);
            }
        }
        int i12 = R$font.roboto_medium;
        e14.setTypeface(ResourcesCompat.h(context, i12));
        e15.setTypeface(ResourcesCompat.h(context, i12));
    }

    public int getResId() {
        return R$layout.view_index_framelayout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        RealTimePrice realTimePrice = (RealTimePrice) view.getTag(R$id.item_data);
        String o11 = realTimePrice.o();
        if (a1.v().S(o11)) {
            MarketModuleConfig.a().X(view.getContext(), o11, true);
        } else {
            MarketModuleConfig.a().j0(view.getContext(), o11, MarketModuleConfig.a().w(), false, TradeType.PRO);
        }
        try {
            MarketModuleConfig.a().j("4478", o11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", realTimePrice.o());
        hashMap.put("list_type", Integer.valueOf(realTimePrice.m()));
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R$id.item_data1).toString()) + 1));
        hashMap.put("select_type", realTimePrice.c());
        hashMap.put("iconurl", realTimePrice.e());
        BaseModuleConfig.a().w("toplist_token_click", hashMap);
        MarketModuleConfig.a().K("涨幅榜");
        MarketModuleConfig.a().t("top_gainers_click", o11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
