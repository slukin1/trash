package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.huobi.index.bean.IndexInformationItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.wtree.helper.Utils;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import tg.r;

public class IndexMarketRemindHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public IndexInformationItem f74218b;

    public static int e() {
        return NightHelper.e().g() ? 2131231168 : 2131231167;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(MarketRemindFlashItem marketRemindFlashItem, View view) {
        g.i("app_news_rechome_nrkp", f());
        MarketModuleConfig.a().y(view.getContext(), marketRemindFlashItem.j(), false, TradeType.PRO, "3");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String d(String str) {
        String j11 = BaseModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon/" + str.toLowerCase() + ".png?t=" + System.currentTimeMillis();
    }

    public final HashMap<String, Object> f() {
        return new HashMap<String, Object>() {
            {
                String J = r.x().J();
                put("uid", (J == null || J.equals("")) ? "0" : J);
                put("type", 3);
                put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (!(IndexMarketRemindHandler.this.f74218b == null || IndexMarketRemindHandler.this.f74218b.j() == null)) {
                    put("contentid", Long.valueOf(IndexMarketRemindHandler.this.f74218b.j().g()));
                    put("title", IndexMarketRemindHandler.this.f74218b.j().l());
                }
                put("category", "homefeeds");
                put("recom_base_info", IndexMarketRemindHandler.this.f74218b.d());
            }
        };
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, IndexInformationItem indexInformationItem, ViewGroup viewGroup) {
        int i12;
        int i13;
        this.f74218b = indexInformationItem;
        i6.r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        MarketRemindFlashItem j11 = indexInformationItem.j();
        f6.c.a().l(context, d(j11.c()), (ImageView) e11.b(R.id.image_view_market_remind_coin), e());
        ((TextView) e11.b(R.id.text_view_market_remind_time)).setText(j11.k());
        ((TextView) e11.b(R.id.text_view_market_remind_title)).setText(j11.l());
        ((TextView) e11.b(R.id.text_view_market_remind_content)).setText(j11.d());
        ((TextView) e11.b(R.id.text_view_market_remind_coin)).setText(j11.c());
        TextView textView = (TextView) e11.b(R.id.text_view_market_remind_info);
        if (j11.f() == 2) {
            i12 = context.getResources().getColor(R.color.base_down_color);
            i13 = R.drawable.bg_newer_market_down;
        } else {
            i12 = context.getResources().getColor(R.color.base_up_color);
            i13 = R.drawable.bg_newer_market_up;
        }
        textView.setText(j11.i());
        textView.setTextColor(i12);
        textView.setBackgroundResource(i13);
        textView.setPadding(Utils.b(R.dimen.dimen_5), 0, Utils.b(R.dimen.dimen_5), 0);
        cVar.itemView.setTag(indexInformationItem);
        cVar.itemView.setOnClickListener(new m(this, j11));
    }

    public int getResId() {
        return R.layout.item_market_remind_index;
    }
}
