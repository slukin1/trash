package com.huobi.c2c.lend.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.CommonProgressBar;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.util.o;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import java.util.Locale;
import oi.a;
import pro.huobi.R;
import ri.b;
import s9.c;

public class C2CLendOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(a aVar, C2CLoanOrderBean c2CLoanOrderBean, View view) {
        if (aVar.d() != null) {
            aVar.d().n(c2CLoanOrderBean);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(a aVar, C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton, View view) {
        if (aVar.d() != null) {
            aVar.d().f(c2CLoanOrderBean, commonSwitchButton);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        a aVar2 = aVar;
        Resources resources = cVar.itemView.getResources();
        C2CLoanOrderBean c11 = aVar.c();
        r e11 = cVar.e();
        ViewUtil.m(e11.b(R.id.id_c2c_lend_order_item_divider), i11 != 0);
        View b11 = e11.b(R.id.id_c2c_lend_order_item_cancel);
        CommonProgressBar commonProgressBar = (CommonProgressBar) e11.b(R.id.id_c2c_lend_order_item_progress_view);
        TextView textView = (TextView) e11.b(R.id.id_c2c_lend_order_item_income);
        View b12 = e11.b(R.id.id_c2c_lend_order_item_switch_botton_layout);
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_title)).setText(k.C().z(c11.getCurrency()));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_time)).setText(DateTimeUtils.C(c11.getCreatedAt()));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_total_amount)).setText(m.m(c11.getAmount(), o.a()));
        long term = c11.getTerm() / Period.DAY_MILLS;
        String string = resources.getString(R.string.n_c2c_lend_days);
        Locale locale = Locale.US;
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) e11.b(R.id.id_c2c_lend_order_item_switch_botton);
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_period)).setText(String.format(locale, string, new Object[]{String.valueOf(term)}));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_lended)).setText(m.m(c11.getFilledAmount(), o.a()));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_rate)).setText(m.Q(c11.getInterestRate(), o.e(), 1));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_unlend)).setText(m.m(c11.getUnfilledAmount(), o.a()));
        textView.setText(m.m(c11.getExpectIncome(), o.d(c11.getCurrency())));
        textView.setTextColor(resources.getColor(w.h()));
        commonProgressBar.setMax(c11.getAmount());
        commonProgressBar.j(c11.getFilledAmount(), false);
        b11.setOnClickListener(new b(aVar2, c11));
        CommonSwitchButton commonSwitchButton2 = commonSwitchButton;
        commonSwitchButton2.b(c11.isRenewOpen(), false);
        b12.setOnClickListener(new ri.c(aVar2, c11, commonSwitchButton2));
    }

    public int getResId() {
        return R.layout.c2c_lend_order_item_layout;
    }
}
