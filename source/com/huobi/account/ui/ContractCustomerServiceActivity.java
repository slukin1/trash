package com.huobi.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.utils.d1;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import u6.g;

public class ContractCustomerServiceActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41150b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41151c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractCustomerServiceActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(view.getContext(), d1.t(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static Intent Xf(Context context) {
        return new Intent(context, ContractCustomerServiceActivity.class);
    }

    public void addEvent() {
        this.f41150b.setOnClickListener(new a());
        this.f41151c.setOnClickListener(new b());
    }

    public int getContentView() {
        return R.layout.activity_contract_customer_service;
    }

    public g getUI() {
        return this;
    }

    public void initView() {
        this.f41150b = (ImageView) this.viewFinder.b(R.id.iv_back);
        this.f41151c = (TextView) this.viewFinder.b(R.id.tv_submit);
    }
}
