package com.huobi.trade.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.trade.presenter.ZoneReminderPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class ZoneReminderActivity extends BaseActivity<ZoneReminderPresenter, ZoneReminderPresenter.a> implements ZoneReminderPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f82567b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82568c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82569d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f82570e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82571f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82572g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f82573h;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        ((ZoneReminderPresenter) getPresenter()).S();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f82573h) {
            this.f82570e.setImageResource(R.drawable.trade_risk_remider_uncheck);
            this.f82573h = false;
        } else {
            this.f82570e.setImageResource(R.drawable.trade_risk_remider_checked);
            this.f82573h = true;
        }
        this.f82571f.setEnabled(this.f82573h);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Z(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2105272565:
                if (str.equals("NEW_ZONE")) {
                    c11 = 0;
                    break;
                }
                break;
            case -196039138:
                if (str.equals("PRO_ZONE")) {
                    c11 = 1;
                    break;
                }
                break;
            case 273840393:
                if (str.equals("FORK_ZONE")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f82572g.setText(R.string.trade_risk_dialog_new_title);
                this.f82567b.setText(R.string.trade_risk_dialog_new_assets_details);
                this.f82568c.setText(R.string.trade_risk_dialog_new_trading_pairs_details);
                this.f82569d.setText(R.string.trade_risk_dialog_new_risk_reminder_details);
                return;
            case 1:
                this.f82572g.setText(R.string.trade_risk_dialog_professional_title);
                this.f82567b.setText(R.string.trade_risk_dialog_professional_assets_details);
                this.f82568c.setText(R.string.trade_risk_dialog_professional_trading_pairs_details);
                this.f82569d.setText(R.string.trade_risk_dialog_professional_risk_reminder_details);
                return;
            case 2:
                this.f82572g.setText(R.string.trade_risk_dialog_fork_title);
                this.f82567b.setText(R.string.trade_risk_dialog_fork_assets_details);
                this.f82568c.setText(R.string.trade_risk_dialog_fork_trading_pairs_details);
                this.f82569d.setText(R.string.trade_risk_dialog_fork_risk_reminder_details);
                return;
            default:
                return;
        }
    }

    /* renamed from: Zf */
    public ZoneReminderPresenter createPresenter() {
        return new ZoneReminderPresenter();
    }

    public void addEvent() {
        this.f82570e.setOnClickListener(new a5(this));
        this.f82571f.setOnClickListener(new b5(this));
    }

    /* renamed from: fg */
    public ZoneReminderPresenter.a getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_zone_reminder;
    }

    public void initView() {
        this.f82567b = (TextView) this.viewFinder.b(R.id.zone_assets_details_tv);
        this.f82568c = (TextView) this.viewFinder.b(R.id.trading_pairs_details_tv);
        this.f82569d = (TextView) this.viewFinder.b(R.id.risk_reminder_details_tv);
        this.f82570e = (ImageView) this.viewFinder.b(R.id.trade_risk_remider_check_iv);
        this.f82571f = (TextView) this.viewFinder.b(R.id.zone_agree_tv);
        this.f82572g = (TextView) this.viewFinder.b(R.id.zone_title_tv);
    }

    public void onBackPressed() {
    }
}
