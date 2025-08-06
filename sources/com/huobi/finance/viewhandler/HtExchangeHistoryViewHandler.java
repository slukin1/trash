package com.huobi.finance.viewhandler;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.r2;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
import com.huobi.finance.ui.HtExchangeHistoryDetailActivity;
import com.huobi.finance.utils.UiFillUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.q;

public class HtExchangeHistoryViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(HtExchangeHistoryBean htExchangeHistoryBean, View view) {
        Intent intent = new Intent(view.getContext(), HtExchangeHistoryDetailActivity.class);
        intent.putExtra("history_id", htExchangeHistoryBean);
        view.getContext().startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, q qVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_fee_label);
        HtExchangeHistoryBean c11 = qVar.c();
        textView.setText(String.format(textView.getResources().getString(R.string.order_fee), new Object[]{qVar.c().getCurrency()}));
        ((TextView) e11.b(R.id.tv_title_amount)).setText(String.format("+%s %s", new Object[]{UiFillUtil.c(c11.getHtVolume()), qVar.c().getCurrency()}));
        ((TextView) e11.b(R.id.tv_time)).setText(DateTimeUtils.f(c11.getTime()));
        ((TextView) e11.b(R.id.tv_fee)).setText(UiFillUtil.c(c11.getHtFee()));
        cVar.itemView.setOnClickListener(new r2(c11));
    }

    public int getResId() {
        return R.layout.item_ht_exchange_history;
    }
}
