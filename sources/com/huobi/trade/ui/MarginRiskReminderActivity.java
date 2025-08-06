package com.huobi.trade.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.trade.helper.w;
import com.huobi.trade.presenter.MarginRiskReminderPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class MarginRiskReminderActivity extends BaseActivity<MarginRiskReminderPresenter, MarginRiskReminderPresenter.b> implements MarginRiskReminderPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public View f82285b;

    /* renamed from: c  reason: collision with root package name */
    public CommonCheckBox f82286c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82287d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f82288e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        CommonCheckBox commonCheckBox = this.f82286c;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.f82288e.setEnabled(this.f82286c.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f82286c.isChecked()) {
            ((MarginRiskReminderPresenter) getPresenter()).S();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        w.f82084a = true;
        Intent putExtra = new Intent(this, HuobiMainActivity.class).putExtra("navigator_action", "pro.huobi.pro");
        putExtra.addFlags(67108864);
        startActivity(putExtra);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f82288e.setOnClickListener(new h(this));
        this.f82285b.setOnClickListener(new i(this));
        this.f82287d.setOnClickListener(new g(this));
    }

    /* renamed from: fg */
    public MarginRiskReminderPresenter createPresenter() {
        return new MarginRiskReminderPresenter();
    }

    public int getContentView() {
        return R.layout.activity_margin_risk_reminder;
    }

    /* renamed from: gg */
    public MarginRiskReminderPresenter.b getUI() {
        return this;
    }

    public void initView() {
        this.f82288e = (TextView) this.viewFinder.b(R.id.margin_agree_tv);
        this.f82287d = (TextView) this.viewFinder.b(R.id.margin_agree_cancel);
        this.f82285b = this.viewFinder.b(R.id.margin_agree_checkbox_layout);
        this.f82286c = (CommonCheckBox) this.viewFinder.b(R.id.margin_agree_checkbox);
    }

    public void onBackPressed() {
    }
}
