package com.huobi.account.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class BrushSecurityVerifyActivity extends EmptyMVPActivity implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f41133b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41134c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41135d;

    /* renamed from: e  reason: collision with root package name */
    public String f41136e;

    public final void Xf() {
        if (TextUtils.isEmpty(this.f41136e)) {
            this.f41135d.setText(String.format(getResources().getString(R.string.n_login_has_verified_status), new Object[]{"0", "1"}));
            this.f41135d.setEnabled(false);
            this.f41133b.setEnabled(true);
            this.f41134c.setImageResource(R.drawable.icon_bind_ga_arrow);
            return;
        }
        this.f41135d.setText(R.string.n_login_finish_verification);
        this.f41135d.setEnabled(true);
        this.f41133b.setEnabled(false);
        this.f41134c.setImageResource(R.drawable.icon_bind_ga_done);
    }

    public void afterInit() {
        super.afterInit();
        this.f41136e = getIntent().getStringExtra("TEMP_GA_VERIFY_PASS_TOKEN");
        Xf();
    }

    public int getContentView() {
        return R.layout.activity_brush_security_verify;
    }

    public void initView() {
        this.f41133b = this.viewFinder.b(R.id.bind_ga_layout);
        this.f41134c = (ImageView) this.viewFinder.b(R.id.iv_bind_ga_right);
        TextView textView = (TextView) this.viewFinder.b(R.id.btn_action);
        this.f41135d = textView;
        textView.setOnClickListener(this);
        this.f41133b.setOnClickListener(this);
        this.viewFinder.b(R.id.title_layout).setBackground((Drawable) null);
        setStatusBarColor(getResources().getColor(R.color.KAssetTopHeaderContentBackground));
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.bind_ga_layout) {
            Intent intent = new Intent(this, BrushGuideGAActivity.class);
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                intent.putExtras(getIntent().getExtras());
            }
            intent.putExtra("JUMP_LOGIN_GA_BIND_PAGE", false);
            startActivity(intent);
        } else if (id2 == R.id.btn_action) {
            Intent intent2 = new Intent();
            intent2.putExtra("TEMP_GA_VERIFY_PASS_TOKEN", this.f41136e);
            setResult(-1, intent2);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f41136e = intent.getStringExtra("TEMP_GA_VERIFY_PASS_TOKEN");
        Xf();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
