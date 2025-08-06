package com.huobi.login.ui;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.GesturePwdLayout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.presenter.SecurityVerificationPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.i;
import java.util.HashMap;
import java.util.List;
import pn.j;
import pro.huobi.R;

public class SecurityVerificationActivity extends BaseActivity<SecurityVerificationPresenter, SecurityVerificationPresenter.c> implements SecurityVerificationPresenter.c, View.OnClickListener, GesturePwdLayout.a {

    /* renamed from: b  reason: collision with root package name */
    public GesturePwdLayout f75582b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75583c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75584d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f75585e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75586f;

    /* access modifiers changed from: private */
    public /* synthetic */ void gg() {
        GesturePwdLayout gesturePwdLayout = this.f75582b;
        if (gesturePwdLayout != null) {
            gesturePwdLayout.l();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f75586f) {
            finish();
        } else {
            onBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ga(String str) {
        this.f75582b.setError(true);
        HuobiToastUtil.m(str);
    }

    public void N8(boolean z11) {
    }

    public boolean Wa() {
        return this.f75586f;
    }

    /* renamed from: Zf */
    public SecurityVerificationPresenter createPresenter() {
        return new SecurityVerificationPresenter();
    }

    public void a6() {
        i.b().d(new j(this));
    }

    public void addEvent() {
        this.f75582b.setCallback(this);
        this.f75583c.setOnClickListener(this);
        this.f75585e.setOnClickListener(new pn.i(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    /* renamed from: fg */
    public SecurityVerificationPresenter.c getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_security_ver;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void initExtra() {
        this.f75586f = getIntent().getBooleanExtra("verifyOnly", false);
    }

    public void initView() {
        this.f75584d = (TextView) findViewById(R.id.gesture_top_name);
        this.f75583c = (TextView) findViewById(R.id.change_account_text);
        this.f75582b = (GesturePwdLayout) findViewById(R.id.ninepoint_setview);
        this.f75585e = (TextView) this.viewFinder.b(R.id.login_cancel_text);
        g.i("unlock_gesture", (HashMap) null);
        this.f75583c.setVisibility(this.f75586f ? 8 : 0);
    }

    public void ja(String str) {
        this.f75584d.setText(String.valueOf(str));
    }

    public void onBackPressed() {
        if (this.f75586f) {
            super.onBackPressed();
        } else {
            ((SecurityVerificationPresenter) getPresenter()).b0();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.change_account_text) {
            ((SecurityVerificationPresenter) getPresenter()).j0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void y7(List<Integer> list) {
        if (list.size() < 6) {
            ((SecurityVerificationPresenter) getPresenter()).l0();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer intValue : list) {
            sb2.append(String.valueOf(intValue.intValue() + 518));
        }
        ((SecurityVerificationPresenter) getPresenter()).c0(sb2.toString());
    }
}
