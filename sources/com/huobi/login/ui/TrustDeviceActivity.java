package com.huobi.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.TrustDevicePresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class TrustDeviceActivity extends BaseActivity<TrustDevicePresenter, TrustDevicePresenter.c> implements TrustDevicePresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f75611b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75612c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75613d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75614e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f75615f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HuobiToastUtil.j(R.string.trust_device_action_finish_hint);
            TrustDeviceActivity.this.onBackPressed();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((TrustDevicePresenter) TrustDeviceActivity.this.getPresenter()).U();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static void fg(Activity activity, boolean z11, String str) {
        Intent intent = new Intent(activity, TrustDeviceActivity.class);
        intent.putExtra("DEVICE_EMAIL_TYPE", z11);
        intent.putExtra("DEVICE_TSV_TOKEN", str);
        activity.startActivity(intent);
    }

    public void H(boolean z11, String str) {
        if (z11) {
            this.f75615f.setEnabled(true);
            this.f75615f.setText(str);
            this.f75615f.setBackground(getResources().getDrawable(R.drawable.shape_trust_retry_bg));
            this.f75615f.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
            return;
        }
        this.f75615f.setEnabled(false);
        this.f75615f.setText(str);
        this.f75615f.setBackground(getResources().getDrawable(R.drawable.shape_trust_count_down_bg));
        this.f75615f.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
    }

    /* renamed from: Yf */
    public TrustDevicePresenter createPresenter() {
        return new TrustDevicePresenter();
    }

    /* renamed from: Zf */
    public TrustDevicePresenter.c getUI() {
        return this;
    }

    public void addEvent() {
        this.f75614e.setOnClickListener(new a());
        this.f75615f.setOnClickListener(new b());
    }

    public int getContentView() {
        return R.layout.activity_trust_device;
    }

    public void initView() {
        CharSequence charSequence;
        String str;
        this.f75611b = getIntent().getBooleanExtra("DEVICE_EMAIL_TYPE", true);
        setToolBar((Toolbar) findViewById(R.id.toolbar), "", true);
        this.f75612c = (TextView) findViewById(R.id.tv_device_hint);
        this.f75613d = (TextView) findViewById(R.id.tv_device_type);
        TextView textView = this.f75612c;
        if (this.f75611b) {
            charSequence = getText(R.string.trust_device_email_hint);
        } else {
            charSequence = getText(R.string.trust_device_sms_hint);
        }
        textView.setText(charSequence);
        TextView textView2 = this.f75613d;
        if (this.f75611b) {
            str = getString(R.string.trust_device_content_email);
        } else {
            str = getString(R.string.trust_device_content_sms);
        }
        textView2.setText(str);
        this.f75614e = (TextView) findViewById(R.id.tv_finish);
        this.f75615f = (TextView) findViewById(R.id.tv_retry);
    }
}
