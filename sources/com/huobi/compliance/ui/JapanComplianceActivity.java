package com.huobi.compliance.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.huobi.compliance.ComplianceUtil;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import vi.a;
import vi.b;
import vi.c;

public class JapanComplianceActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public String f43037b = "https://www.huobi.co.jp/?source=10000400";

    /* renamed from: c  reason: collision with root package name */
    public StatusButton f43038c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f43039d;

    /* renamed from: e  reason: collision with root package name */
    public View f43040e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43041f;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fg(View view) {
        boolean z11 = !this.f43041f;
        this.f43041f = z11;
        if (z11) {
            this.f43039d.setImageResource(R.drawable.common_check_selected);
            this.f43038c.setEnabled(true);
        } else {
            this.f43039d.setImageResource(R.drawable.common_check_unselected);
            this.f43038c.setEnabled(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f43041f) {
            ComplianceUtil.h();
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f43037b)));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f43038c.setOnClickListener(new a(this));
        this.f43040e.setOnClickListener(new c(this));
        this.viewFinder.b(R.id.status_button_jump_japan).setOnClickListener(new b(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_japan_compliance;
    }

    public void initView() {
        this.f43038c = (StatusButton) findViewById(R.id.tv_confirm);
        this.f43039d = (ImageView) findViewById(R.id.iv_check);
        this.f43040e = findViewById(R.id.ll_check);
    }

    public void onBackPressed() {
    }

    public void onStart() {
        super.onStart();
    }
}
