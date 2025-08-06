package com.huobi.tradenew.ui;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import qt.v;
import qt.w;

public class SpotMarginConfigActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f83069b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83070c;

    /* renamed from: d  reason: collision with root package name */
    public SwitchCompat f83071d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f83072e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83073f;

    /* renamed from: g  reason: collision with root package name */
    public SwitchCompat f83074g;

    @SensorsDataInstrumented
    public static /* synthetic */ void Zf(CompoundButton compoundButton, boolean z11) {
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", !z11);
        w.h(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void fg(CompoundButton compoundButton, boolean z11) {
        ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", !z11);
        w.h(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public void afterInit() {
        super.afterInit();
        this.f83070c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f83073f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f83071d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f83074g.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f83070c.setText(getString(R.string.n_exchange_spot_order_confirmation));
        this.f83073f.setText(getString(R.string.n_spot_margin_loan_order_confirmation));
        this.f83071d.setChecked(v.h());
        this.f83074g.setChecked(v.i());
        this.f83071d.setOnCheckedChangeListener(c.f83374b);
        this.f83074g.setOnCheckedChangeListener(b.f83367b);
    }

    public int getContentView() {
        return R.layout.activity_spot_margin_config;
    }

    public void initView() {
        super.initView();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.include_spot_margin);
        this.f83069b = viewGroup;
        this.f83070c = (TextView) viewGroup.findViewById(R.id.id_setting_list_item_title);
        this.f83071d = (SwitchCompat) this.f83069b.findViewById(R.id.quickly_withdraw_cb);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.include_spot_margin_loan);
        this.f83072e = viewGroup2;
        this.f83073f = (TextView) viewGroup2.findViewById(R.id.id_setting_list_item_title);
        this.f83074g = (SwitchCompat) this.f83072e.findViewById(R.id.quickly_withdraw_cb);
    }
}
