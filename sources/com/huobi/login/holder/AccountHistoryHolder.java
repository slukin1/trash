package com.huobi.login.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huobi.login.bean.AccountHistoryBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import mn.a;
import mn.b;
import pro.huobi.R;
import s9.c;

public class AccountHistoryHolder implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f75439b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f75440c;

    @SensorsDataInstrumented
    public static /* synthetic */ void e(AccountHistoryBean accountHistoryBean, View view) {
        accountHistoryBean.getListener().b(accountHistoryBean);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(AccountHistoryBean accountHistoryBean, View view) {
        accountHistoryBean.getListener().a(accountHistoryBean);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, AccountHistoryBean accountHistoryBean, ViewGroup viewGroup) {
        this.f75439b = cVar.e().e(R.id.accountName);
        this.f75440c = cVar.e().c(R.id.deleteIcon);
        this.f75439b.setText(accountHistoryBean.getAccount());
        this.f75440c.setOnClickListener(new a(accountHistoryBean));
        cVar.itemView.setOnClickListener(new b(accountHistoryBean));
    }

    public int getResId() {
        return R.layout.account_history_item_layout;
    }
}
