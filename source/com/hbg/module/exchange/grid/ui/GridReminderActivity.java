package com.hbg.module.exchange.grid.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cd.b;
import cd.c;
import cd.d;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.grid.presenter.GridReminderPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

@Route(path = "/trade/gridReminder")
public class GridReminderActivity extends BaseActivity<GridReminderPresenter, GridReminderPresenter.a> implements GridReminderPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19478b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19479c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19480d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19481e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        ((GridReminderPresenter) getPresenter()).S();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f19481e) {
            this.f19478b.setImageResource(R$drawable.marquee_unselected);
            this.f19481e = false;
        } else {
            this.f19478b.setImageResource(R$drawable.marquee_selected);
            this.f19481e = true;
        }
        this.f19479c.setEnabled(this.f19481e);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f19478b.setOnClickListener(new b(this));
        this.f19479c.setOnClickListener(new c(this));
        this.f19480d.setOnClickListener(new d(this));
    }

    /* renamed from: fg */
    public GridReminderPresenter createPresenter() {
        return new GridReminderPresenter();
    }

    public int getContentView() {
        return R$layout.activity_grid_reminder;
    }

    /* renamed from: gg */
    public GridReminderPresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f19478b = (ImageView) this.viewFinder.b(R$id.trade_risk_remider_check_iv);
        TextView textView = (TextView) this.viewFinder.b(R$id.dialog_confirm_btn);
        this.f19479c = textView;
        textView.setEnabled(false);
        this.f19480d = (TextView) this.viewFinder.b(R$id.dialog_cancel_btn);
    }
}
