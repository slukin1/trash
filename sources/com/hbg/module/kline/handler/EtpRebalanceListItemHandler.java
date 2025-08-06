package com.hbg.module.kline.handler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.hbg.core.bean.BasketInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalanceResult;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import i6.m;
import i6.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import s9.c;
import ud.b;

public class EtpRebalanceListItemHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public final SimpleDateFormat f23524b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        Resources resources = cVar.itemView.getResources();
        r e11 = cVar.e();
        View b11 = e11.b(R$id.id_market_info_etp_rebalance_divider);
        TextView textView = (TextView) e11.b(R$id.id_market_info_etp_rebalance_time);
        TextView textView2 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_title);
        TextView textView3 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_basket_amount1);
        TextView textView4 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_basket_amount2);
        TextView textView5 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_basket2_amount1);
        TextView textView6 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_basket2_amount2);
        TextView textView7 = (TextView) e11.b(R$id.id_market_info_etp_rebalance_change_amount);
        ViewUtil.m(b11, i11 > 0);
        EtpRebalanceResult c11 = bVar.c();
        textView.setText(this.f23524b.format(new Date(c11.getRebalanceTime())));
        if (c11.getPositionType() == 1) {
            textView2.setText(resources.getString(R$string.n_kline_etp_adjust_regularly));
        } else {
            textView2.setText(resources.getString(R$string.n_kline_etp_adjust_randomly));
        }
        List<BasketInfo> basketBefore = c11.getBasketBefore();
        if (!basketBefore.isEmpty()) {
            BasketInfo basketInfo = basketBefore.get(0);
            textView3.setText(m.m(basketInfo.getAmount(), 8) + " " + StringUtils.i(basketInfo.getCurrency()));
            BasketInfo basketInfo2 = basketBefore.get(1);
            textView4.setText(m.m(basketInfo2.getAmount(), 8) + " " + StringUtils.i(basketInfo2.getCurrency()));
        }
        List<BasketInfo> basketAfter = c11.getBasketAfter();
        if (!basketAfter.isEmpty()) {
            BasketInfo basketInfo3 = basketAfter.get(0);
            textView5.setText(m.m(basketInfo3.getAmount(), 8) + " " + StringUtils.i(basketInfo3.getCurrency()));
            BasketInfo basketInfo4 = basketAfter.get(1);
            textView6.setText(m.m(basketInfo4.getAmount(), 8) + " " + StringUtils.i(basketInfo4.getCurrency()));
        }
        textView7.setText(m.m(c11.getLeverageBefore(), 4) + "/" + m.m(c11.getLeverageAfter(), 4));
    }

    public int getResId() {
        return R$layout.layout_market_info_etp_rebalance_list_item;
    }
}
