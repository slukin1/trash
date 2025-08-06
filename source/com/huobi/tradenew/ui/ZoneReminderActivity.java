package com.huobi.tradenew.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.tradenew.presenter.ZoneReminderPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class ZoneReminderActivity extends BaseActivity<ZoneReminderPresenter, ZoneReminderPresenter.a> implements ZoneReminderPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f83353b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83354c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83355d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f83356e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83357f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83358g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f83359h;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        ((ZoneReminderPresenter) getPresenter()).S();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f83359h) {
            this.f83356e.setImageResource(R.drawable.trade_risk_remider_uncheck);
            this.f83359h = false;
        } else {
            this.f83356e.setImageResource(R.drawable.trade_risk_remider_checked);
            this.f83359h = true;
        }
        this.f83357f.setEnabled(this.f83359h);
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
                this.f83358g.setText(R.string.trade_risk_dialog_new_title);
                this.f83353b.setText(R.string.trade_risk_dialog_new_assets_details);
                this.f83354c.setText(R.string.trade_risk_dialog_new_trading_pairs_details);
                this.f83355d.setText(R.string.trade_risk_dialog_new_risk_reminder_details);
                return;
            case 1:
                this.f83358g.setText(R.string.trade_risk_dialog_professional_title);
                this.f83353b.setText(R.string.trade_risk_dialog_professional_assets_details);
                this.f83354c.setText(R.string.trade_risk_dialog_professional_trading_pairs_details);
                this.f83355d.setText(R.string.trade_risk_dialog_professional_risk_reminder_details);
                return;
            case 2:
                this.f83358g.setText(R.string.trade_risk_dialog_fork_title);
                this.f83353b.setText(R.string.trade_risk_dialog_fork_assets_details);
                this.f83354c.setText(R.string.trade_risk_dialog_fork_trading_pairs_details);
                this.f83355d.setText(R.string.trade_risk_dialog_fork_risk_reminder_details);
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
        this.f83356e.setOnClickListener(new b5(this));
        this.f83357f.setOnClickListener(new c5(this));
    }

    /* renamed from: fg */
    public ZoneReminderPresenter.a getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_zone_reminder;
    }

    public void initView() {
        this.f83353b = (TextView) this.viewFinder.b(R.id.zone_assets_details_tv);
        this.f83354c = (TextView) this.viewFinder.b(R.id.trading_pairs_details_tv);
        this.f83355d = (TextView) this.viewFinder.b(R.id.risk_reminder_details_tv);
        this.f83356e = (ImageView) this.viewFinder.b(R.id.trade_risk_remider_check_iv);
        this.f83357f = (TextView) this.viewFinder.b(R.id.zone_agree_tv);
        this.f83358g = (TextView) this.viewFinder.b(R.id.zone_title_tv);
    }

    public void onBackPressed() {
    }
}
