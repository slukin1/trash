package com.huobi.finance.viewhandler;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.d3;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.huobi.finance.ui.UsdtExchangeHistoryDetailActivity;
import com.huobi.finance.utils.UiFillUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.x;

public class UsdtExchangeHistoryViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(UsdtExchangeHistoryBean usdtExchangeHistoryBean, View view) {
        Intent intent = new Intent(view.getContext(), UsdtExchangeHistoryDetailActivity.class);
        intent.putExtra("history_id", usdtExchangeHistoryBean);
        view.getContext().startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, x xVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_fee_label);
        UsdtExchangeHistoryBean c11 = xVar.c();
        textView.setText(String.format(textView.getResources().getString(R.string.order_fee), new Object[]{"USDT"}));
        ((TextView) e11.b(R.id.tv_title_amount)).setText(String.format("+%s USDT", new Object[]{UiFillUtil.d(c11.getUsdtVolume())}));
        ((TextView) e11.b(R.id.tv_time)).setText(DateTimeUtils.f(c11.getTime()));
        ((TextView) e11.b(R.id.tv_fee)).setText(UiFillUtil.d(c11.getUsdtFee()));
        cVar.itemView.setOnClickListener(new d3(c11));
    }

    public int getResId() {
        return R.layout.item_usdt_exchange_history;
    }
}
