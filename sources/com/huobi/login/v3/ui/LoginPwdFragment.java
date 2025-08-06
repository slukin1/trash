package com.huobi.login.v3.ui;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import vn.b;
import vn.c;
import vn.d;

public class LoginPwdFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f76065b;

    /* renamed from: c  reason: collision with root package name */
    public StatusButton f76066c;

    /* renamed from: d  reason: collision with root package name */
    public ClearEditText f76067d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f76068e;

    public interface a {
        void a();

        boolean b();

        boolean c();

        void d(r rVar);

        void e();

        void login(String str);
    }

    public LoginPwdFragment(a aVar) {
        this.f76065b = aVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f76065b.login(this.f76067d.getText().toString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        this.f76065b.a();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f76065b.e();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f76066c.setOnClickListener(new d(this));
        this.f76068e.setOnClickListener(new c(this));
        rVar.b(R.id.tv_forgot_psw).setOnClickListener(new b(this));
        rVar.b(R.id.iv_close).setOnClickListener(new vn.a(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.activity_login_pwd;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        this.f76066c = (StatusButton) rVar.b(R.id.login_btn);
        this.f76067d = (ClearEditText) rVar.b(R.id.cet_pwd);
        TextView textView = (TextView) rVar.b(R.id.tv_switch_auth);
        this.f76068e = textView;
        textView.setVisibility((this.f76065b.c() || !this.f76065b.b()) ? 0 : 8);
        this.f76065b.d(rVar);
        this.f76066c.setButtonText((int) R.string.n_grid_user_guide_next);
    }

    public boolean isTransparent() {
        return false;
    }
}
