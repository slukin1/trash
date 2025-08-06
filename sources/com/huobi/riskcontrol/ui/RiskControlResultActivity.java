package com.huobi.riskcontrol.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import u6.g;
import wq.e;

public class RiskControlResultActivity extends BaseActivity<ActivityPresenter<g>, g> {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80679b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80680c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80681d;

    /* renamed from: e  reason: collision with root package name */
    public Button f80682e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f80683f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f80684g;

    /* renamed from: h  reason: collision with root package name */
    public Boolean f80685h;

    /* renamed from: i  reason: collision with root package name */
    public String f80686i;

    public class a extends ActivityPresenter {
        public a() {
        }

        public void onUIReady(BaseCoreActivity baseCoreActivity, Object obj) {
        }
    }

    public static void gg(Context context, String str, Boolean bool, boolean z11) {
        Intent intent = new Intent(context, RiskControlResultActivity.class);
        intent.putExtra("isSuccess", bool);
        intent.putExtra("content", str);
        intent.putExtra("isResetPassword", z11);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        Yf();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Yf() {
        if (this.f80685h.booleanValue()) {
            Zf();
        } else {
            fg();
        }
    }

    public final void Zf() {
        Intent intent = new Intent(this, UserLoginActivityV2.class);
        intent.addFlags(67108864);
        Intent h11 = k0.h(this);
        intent.putExtra("target", new JumpTarget(h11, h11));
        startActivity(intent);
    }

    public void addEvent() {
        this.f80682e.setOnClickListener(new e(this));
    }

    public ActivityPresenter createPresenter() {
        return new a();
    }

    public final void fg() {
        startActivity(new Intent(this, SecuritySetActivity.class));
    }

    public int getContentView() {
        return R.layout.activitiy_risk_control_result_layout;
    }

    public g getUI() {
        return null;
    }

    public void initView() {
        this.f80684g = Boolean.valueOf(getIntent().getBooleanExtra("isSuccess", false));
        this.f80685h = Boolean.valueOf(getIntent().getBooleanExtra("isResetPassword", false));
        this.f80686i = getIntent().getStringExtra("content");
        setToolBar((Toolbar) findViewById(R.id.toolbar), "", true);
        this.f80679b = (TextView) this.viewFinder.b(R.id.risk_title_tv);
        this.f80680c = (TextView) this.viewFinder.b(R.id.risk_desc_tv);
        this.f80683f = (ImageView) this.viewFinder.b(R.id.risk_image_iv);
        this.f80681d = (TextView) this.viewFinder.b(R.id.risk_content_tv);
        this.f80682e = (Button) this.viewFinder.b(R.id.confirm_btn);
        this.f80679b.setText(this.f80684g.booleanValue() ? R.string.verify_finish : R.string.n_risk_fail_title);
        this.f80681d.setText(this.f80686i);
        this.f80683f.setImageResource(this.f80684g.booleanValue() ? R.drawable.withdraw_risk_pass : R.drawable.withdraw_risk_fail);
    }
}
