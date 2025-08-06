package com.huobi.riskcontrol.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import bj.o0;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.api.RiskService;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import com.huobi.riskcontrol.presenter.RiskControlPresenter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import q6.d;
import rx.Observable;
import tq.p;
import wq.b;
import wq.c;

public class RiskControlActivity extends BaseActivity<RiskControlPresenter, RiskControlPresenter.c> implements RiskControlPresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80672b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80673c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80674d;

    /* renamed from: e  reason: collision with root package name */
    public Button f80675e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f80676f;

    /* renamed from: g  reason: collision with root package name */
    public SecurityVerifyParam f80677g;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80678a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.riskcontrol.bean.SecurityVerifyParam$VerifyType[] r0 = com.huobi.riskcontrol.bean.SecurityVerifyParam.VerifyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f80678a = r0
                com.huobi.riskcontrol.bean.SecurityVerifyParam$VerifyType r1 = com.huobi.riskcontrol.bean.SecurityVerifyParam.VerifyType.FACE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f80678a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.riskcontrol.bean.SecurityVerifyParam$VerifyType r1 = com.huobi.riskcontrol.bean.SecurityVerifyParam.VerifyType.MOBILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f80678a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.riskcontrol.bean.SecurityVerifyParam$VerifyType r1 = com.huobi.riskcontrol.bean.SecurityVerifyParam.VerifyType.EMAIL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.riskcontrol.ui.RiskControlActivity.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qg(Void voidR) {
        rh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(Void voidR) {
        int i11 = a.f80678a[this.f80677g.getVerifyType().ordinal()];
        if (i11 == 1) {
            ((RiskControlPresenter) getPresenter()).S(this.f80677g.getTsvToken());
        } else if (i11 == 2 || i11 == 3) {
            ((RiskControlPresenter) getPresenter()).W(Boolean.FALSE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(HBDialogFragment hBDialogFragment) {
        finish();
    }

    public static void sh(Context context, SecurityVerifyParam securityVerifyParam) {
        Intent intent = new Intent(context, RiskControlActivity.class);
        intent.putExtra("mSecurityVerifyParam", securityVerifyParam);
        context.startActivity(intent);
    }

    public void E4() {
        RiskControlResultActivity.gg(this, Og(true), Boolean.TRUE, this.f80677g.isResetPassword());
        finish();
    }

    public final String Og(boolean z11) {
        SecurityVerifyParam.Scene scene = this.f80677g.getScene();
        SecurityVerifyParam.RiskOperate riskOperate = this.f80677g.getRiskOperate();
        if (this.f80677g.isResetPassword()) {
            return getString(z11 ? R.string.n_risk_reset_password_success_subtitle : R.string.n_risk_reset_password_fail_subtitle);
        }
        SecurityVerifyParam.Scene scene2 = SecurityVerifyParam.Scene.RISK_EMAIL;
        if (scene == scene2 && riskOperate == SecurityVerifyParam.RiskOperate.DISABLE) {
            return getString(z11 ? R.string.n_risk_close_email_success_subtitle : R.string.n_risk_close_email_fail_subtitle);
        }
        SecurityVerifyParam.Scene scene3 = SecurityVerifyParam.Scene.RISK_PHONE;
        if (scene == scene3 && riskOperate == SecurityVerifyParam.RiskOperate.DISABLE) {
            return getString(z11 ? R.string.n_risk_close_phone_success_subtitle : R.string.n_risk_close_phone_fail_subtitle);
        }
        SecurityVerifyParam.Scene scene4 = SecurityVerifyParam.Scene.GA;
        if (scene == scene4 && riskOperate == SecurityVerifyParam.RiskOperate.DISABLE) {
            return getString(z11 ? R.string.n_risk_close_ga_success_subtitle : R.string.n_risk_close_ga_fail_subtitle);
        } else if (scene == scene3 && riskOperate == SecurityVerifyParam.RiskOperate.BIND) {
            return getString(z11 ? R.string.n_risk_bind_phone_success_subtitle : R.string.n_risk_bind_phone_fail_subtitle);
        } else if (scene == scene2 && riskOperate == SecurityVerifyParam.RiskOperate.BIND) {
            return getString(z11 ? R.string.n_risk_bind_email_success_subtitle : R.string.n_risk_bind_email_fail_subtitle);
        } else if (scene != scene4 || riskOperate != SecurityVerifyParam.RiskOperate.GENERATE) {
            return "";
        } else {
            return getString(z11 ? R.string.n_risk_bind_ga_success_subtitle : R.string.n_risk_bind_ga_fail_subtitle);
        }
    }

    /* renamed from: Pg */
    public RiskControlPresenter.c getUI() {
        return this;
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f80674d);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b(this));
        dw.a.a(this.f80675e).throttleFirst(300, timeUnit).subscribe(new c(this));
    }

    public void cc() {
        RiskControlResultActivity.gg(this, Og(false), Boolean.FALSE, this.f80677g.isResetPassword());
        finish();
    }

    public void doFinish() {
        DialogUtils.b0(this, "", getString(R.string.n_risk_back_hint), "", getString(R.string.cancel), getString(R.string.global_string_confirm), o0.f12469a, new wq.a(this)).show(getSupportFragmentManager(), "");
    }

    public int getContentView() {
        return R.layout.activitiy_risk_control_layout;
    }

    /* renamed from: gg */
    public RiskControlPresenter createPresenter() {
        return new RiskControlPresenter();
    }

    public void initView() {
        SecurityVerifyParam securityVerifyParam = (SecurityVerifyParam) getIntent().getSerializableExtra("mSecurityVerifyParam");
        this.f80677g = securityVerifyParam;
        if (securityVerifyParam == null) {
            finish();
        }
        setToolBar((Toolbar) findViewById(R.id.toolbar), "", true);
        this.f80672b = (TextView) this.viewFinder.b(R.id.risk_desc_tv);
        this.f80676f = (ImageView) this.viewFinder.b(R.id.risk_image_iv);
        this.f80673c = (TextView) this.viewFinder.b(R.id.risk_content_tv);
        this.f80674d = (TextView) this.viewFinder.b(R.id.risk_retry_tv);
        this.f80675e = (Button) this.viewFinder.b(R.id.confirm_btn);
        this.f80672b.setText(this.f80677g.getHint());
        SecurityVerifyParam.VerifyType verifyType = this.f80677g.getVerifyType();
        if (verifyType != null) {
            int i11 = a.f80678a[verifyType.ordinal()];
            if (i11 == 1) {
                this.f80673c.setText(R.string.n_risk_face_hint);
                this.f80676f.setImageResource(R.drawable.withdraw_risk_face);
            } else if (i11 == 2) {
                this.f80673c.setText(R.string.n_risk_sms_hint);
                this.f80674d.setVisibility(0);
                this.f80674d.setText(R.string.sms_check_retry);
                this.f80675e.setText(R.string.withdraw_finish_check);
                this.f80676f.setImageResource(R.drawable.withdraw_risk_sms);
            } else if (i11 == 3) {
                this.f80673c.setText(R.string.n_risk_email_hint);
                this.f80674d.setVisibility(0);
                this.f80674d.setText(R.string.mail_check_retry);
                this.f80675e.setText(R.string.withdraw_finish_check);
                this.f80676f.setImageResource(R.drawable.withdraw_risk_mail);
            }
        }
    }

    public SecurityVerifyParam kc() {
        return this.f80677g;
    }

    public final void rh() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("tsvToken", this.f80677g.getTsvToken());
        ((RiskService) p.Y(RiskService.class)).resendTsvMessage(hashMap).compose(p.Z()).compose(RxJavaHelper.t(getUI())).subscribe(d.c(getUI(), wq.d.f61500b));
    }
}
