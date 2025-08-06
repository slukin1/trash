package com.huobi.index.ui;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.huobi.index.presenter.ScanLoginSuccessPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class ScanLoginSuccessActivity extends BaseActivity<ScanLoginSuccessPresenter, ScanLoginSuccessPresenter.b> implements ScanLoginSuccessPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f73854b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73855c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73856d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73857e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f73858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f73859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f73860h;

    /* renamed from: i  reason: collision with root package name */
    public CountDownTimer f73861i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f73862j = true;

    public class a extends CountDownTimer {
        public a(long j11, long j12) {
            super(j11, j12);
        }

        public void onFinish() {
            ScanLoginSuccessActivity.this.f73858f.setBackgroundResource(R.drawable.common_blue_5_radius_selector);
            ScanLoginSuccessActivity.this.f73858f.setText(R.string.n_scan_login_confirm);
            boolean unused = ScanLoginSuccessActivity.this.f73862j = true;
        }

        public void onTick(long j11) {
            if (j11 >= 1000) {
                String string = j.c().getString(R.string.n_scan_login_confirm);
                TextView fg2 = ScanLoginSuccessActivity.this.f73858f;
                fg2.setText(string + "（" + (j11 / 1000) + "s）");
                return;
            }
            ScanLoginSuccessActivity.this.f73858f.setBackgroundResource(R.drawable.common_blue_5_radius_selector);
            ScanLoginSuccessActivity.this.f73858f.setText(R.string.n_scan_login_confirm);
            boolean unused = ScanLoginSuccessActivity.this.f73862j = true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f73862j) {
            ((ScanLoginSuccessPresenter) getPresenter()).T();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void oh(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void ph(Context context, TokenBindInfo tokenBindInfo) {
        Intent intent = new Intent(context, ScanLoginSuccessActivity.class);
        intent.putExtra("scan_login_result", tokenBindInfo);
        context.startActivity(intent);
    }

    public final void Og() {
        CountDownTimer countDownTimer = this.f73861i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f73861i = null;
        }
    }

    /* renamed from: Pg */
    public ScanLoginSuccessPresenter createPresenter() {
        return new ScanLoginSuccessPresenter();
    }

    /* renamed from: Qg */
    public ScanLoginSuccessPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.f73858f.setOnClickListener(new x1(this));
        this.f73859g.setOnClickListener(new w1(this));
        this.f73854b.setOnClickListener(new v1(this));
    }

    public int getContentView() {
        return R.layout.activity_scan_login_success;
    }

    public void initView() {
        TokenBindInfo tokenBindInfo = (TokenBindInfo) getIntent().getSerializableExtra("scan_login_result");
        this.f73855c = (TextView) this.viewFinder.b(R.id.scan_ip_value_tv);
        this.f73856d = (TextView) this.viewFinder.b(R.id.scan_ip_address_value_tv);
        this.f73857e = (TextView) this.viewFinder.b(R.id.scan_ip_device_value_tv);
        this.f73858f = (TextView) this.viewFinder.b(R.id.scan_confirm_tv);
        this.f73859g = (TextView) this.viewFinder.b(R.id.scan_cancel_tv);
        this.f73860h = (TextView) this.viewFinder.b(R.id.scan_web_device_safe_tv);
        this.f73854b = (ImageView) this.viewFinder.b(R.id.close_iv);
        if (tokenBindInfo != null) {
            if (TextUtils.isEmpty(tokenBindInfo.getIp()) || TextUtils.isEmpty(tokenBindInfo.getIp().replaceAll(" ", ""))) {
                this.f73855c.setText("--");
            } else {
                this.f73855c.setText(tokenBindInfo.getIp());
            }
            if (TextUtils.isEmpty(tokenBindInfo.getAddress()) || TextUtils.isEmpty(tokenBindInfo.getAddress().replaceAll(" ", ""))) {
                this.f73856d.setText("--");
            } else {
                this.f73856d.setText(tokenBindInfo.getAddress());
            }
            if (TextUtils.isEmpty(tokenBindInfo.getEqInfo()) || TextUtils.isEmpty(tokenBindInfo.getEqInfo().replaceAll(" ", ""))) {
                this.f73857e.setText("--");
            } else {
                this.f73857e.setText(tokenBindInfo.getEqInfo());
            }
            if (!tokenBindInfo.isWebKnowDevice()) {
                this.f73860h.setVisibility(0);
                this.f73858f.setBackgroundResource(R.drawable.common_gray_1_radius_selector);
                this.f73862j = false;
                Og();
                qh();
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Og();
    }

    public final void qh() {
        a aVar = new a(5900, 1000);
        this.f73861i = aVar;
        aVar.start();
    }
}
