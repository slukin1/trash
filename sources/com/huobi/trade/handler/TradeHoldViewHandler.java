package com.huobi.trade.handler;

import al.p;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bt.f2;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.trade.bean.TradeHoldBean;
import i6.r;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;
import zn.a;

public class TradeHoldViewHandler implements c {
    public static /* synthetic */ void d(TradeHoldBean tradeHoldBean, Void voidR) {
        BalanceDetailInfo currencyInfo = tradeHoldBean.getCurrencyInfo();
        if (currencyInfo != null && !TextUtils.isEmpty(currencyInfo.getCurrency())) {
            a d11 = a.d();
            d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=coindetail&navConfig=&currency=" + currencyInfo.getCurrency() + "&stable=" + currencyInfo.getCurrency().toUpperCase().equals("USDT"))).a().c();
            com.huobi.trade.helper.c.b().e(currencyInfo.getCurrency());
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TradeHoldBean tradeHoldBean, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.trade_hold_head_tv);
        TextView textView2 = (TextView) e11.b(R.id.trade_hold_name_tv);
        ImageView imageView = (ImageView) e11.b(R.id.trade_hold_symbol_iv);
        TextView textView3 = (TextView) e11.b(R.id.trade_hold_net_tv);
        TextView textView4 = (TextView) e11.b(R.id.trade_hold_available_tv);
        TextView textView5 = (TextView) e11.b(R.id.trade_hold_volume_tv);
        TextView textView6 = (TextView) e11.b(R.id.trade_hold_percent_tv);
        TextView textView7 = (TextView) e11.b(R.id.trade_hold_volume_label_tv);
        textView.setText(tradeHoldBean.getHead());
        textView.setVisibility(TextUtils.isEmpty(tradeHoldBean.getHead()) ? 8 : 0);
        f6.c.a().f(imageView, p.l(tradeHoldBean.getDisplayName()), p.m());
        textView7.setText(String.format(Locale.ENGLISH, context.getString(R.string.n_trade_total_accounted2), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        textView2.setText(tradeHoldBean.getDisplayName());
        textView3.setText(tradeHoldBean.getNetAsset());
        textView4.setText(tradeHoldBean.getAvailable());
        textView5.setText(tradeHoldBean.getEstimateTotal());
        textView6.setText(tradeHoldBean.getPercent());
        dw.a.a(cVar.itemView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new f2(tradeHoldBean));
    }

    public int getResId() {
        return R.layout.item_spot_asset;
    }
}
