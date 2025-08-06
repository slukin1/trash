package com.huobi.otc.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.persenter.OtcRiskWarningPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import sp.f2;
import sp.g2;
import sp.h2;
import sp.i2;

public class OtcRiskWarningActivity extends BaseActivity<OtcRiskWarningPresenter, OtcRiskWarningPresenter.b> implements OtcRiskWarningPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f79524b;

    /* renamed from: c  reason: collision with root package name */
    public Button f79525c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f79526d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79527e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pg(View view) {
        if (!NetworkStatus.c(this)) {
            HuobiToastUtil.k(this, R$string.string_network_disconnect);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ph();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qg(CompoundButton compoundButton, boolean z11) {
        this.f79525c.setEnabled(z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        HBBaseWebActivity.showWebView(this, ((OtcRiskWarningPresenter) getPresenter()).S(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void oh(Context context, boolean z11) {
        Intent intent = new Intent(context, OtcRiskWarningActivity.class);
        intent.putExtra("com.huobi.otc.ui.risk.treading", z11);
        context.startActivity(intent);
    }

    /* renamed from: Og */
    public OtcRiskWarningPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.f79524b.setNavigationOnClickListener(new f2(this));
        this.f79525c.setOnClickListener(new g2(this));
        this.f79526d.setOnCheckedChangeListener(new i2(this));
        this.f79527e.setOnClickListener(new h2(this));
    }

    public int getContentView() {
        return R$layout.activity_otc_risk_warning;
    }

    /* renamed from: gg */
    public OtcRiskWarningPresenter createPresenter() {
        return new OtcRiskWarningPresenter();
    }

    public void initView() {
        this.f79525c = (Button) findViewById(R$id.next_btn);
        this.f79524b = (Toolbar) findViewById(R$id.toolbar);
        this.f79526d = (CheckBox) findViewById(R$id.checkbox);
        this.f79527e = (TextView) findViewById(R$id.user_agreement_txt);
        this.f79526d.setChecked(false);
        this.f79525c.setEnabled(false);
    }

    public final void ph() {
        OtcAliCertificateActivity.gg(this, true, getIntent().getBooleanExtra("com.huobi.otc.ui.risk.treading", false));
    }
}
