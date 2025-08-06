package com.huobi.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.account.presenter.VerificationStartPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class VerificationStartActivity extends BaseActivity<VerificationStartPresenter, VerificationStartPresenter.b> implements VerificationStartPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public TextView f41631b;

    public static void fg(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, VerificationStartActivity.class);
        intent.putExtra("tsvToken", str);
        intent.putExtra("tsvMsg", str2);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((VerificationStartPresenter) getPresenter()).W();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Yf */
    public VerificationStartPresenter createPresenter() {
        return new VerificationStartPresenter();
    }

    /* renamed from: Zf */
    public VerificationStartPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
        this.viewFinder.b(R.id.btn_action).setOnClickListener(new n6(this));
    }

    public void c6(String str) {
        this.f41631b.setText(str);
    }

    public int getContentView() {
        return R.layout.activity_verification_start;
    }

    public void initView() {
        this.f41631b = (TextView) this.viewFinder.b(R.id.tv_hint);
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), "", true);
    }
}
