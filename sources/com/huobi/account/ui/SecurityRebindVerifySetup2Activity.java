package com.huobi.account.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.account.presenter.SecurityRebindVerifySetup2Presenter;
import com.huobi.login.usercenter.data.source.bean.SecuritySetData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategy;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import pro.huobi.R;
import sn.f;

public class SecurityRebindVerifySetup2Activity extends BaseActivity<SecurityRebindVerifySetup2Presenter, SecurityRebindVerifySetup2Presenter.f> implements SecurityRebindVerifySetup2Presenter.f {
    public LoadingLayout A;
    public boolean B;
    public boolean C;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f41360b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f41361c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f41362d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f41363e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f41364f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f41365g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41366h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41367i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41368j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f41369k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f41370l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f41371m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f41372n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f41373o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f41374p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41375q;

    /* renamed from: r  reason: collision with root package name */
    public View f41376r;

    /* renamed from: s  reason: collision with root package name */
    public View f41377s;

    /* renamed from: t  reason: collision with root package name */
    public View f41378t;

    /* renamed from: u  reason: collision with root package name */
    public View f41379u;

    /* renamed from: v  reason: collision with root package name */
    public View f41380v;

    /* renamed from: w  reason: collision with root package name */
    public View f41381w;

    /* renamed from: x  reason: collision with root package name */
    public SecuritySetData f41382x;

    /* renamed from: y  reason: collision with root package name */
    public UserSecurityInfoData f41383y;

    /* renamed from: z  reason: collision with root package name */
    public SecurityStrategy f41384z;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SecurityRebindVerifySetup2Activity.this.vh();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SecurityRebindVerifySetup2Activity.this.vh();
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            SecurityRebindVerifySetup2Activity.this.vh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(View view, boolean z11) {
        this.f41361c.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(View view, boolean z11) {
        this.f41362d.setSelected(z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        this.C = true;
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", yh());
        ((SecurityRebindVerifySetup2Presenter) getPresenter()).y0(hashMap);
        vh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        if (this.f41380v.getVisibility() == 0) {
            startActivity(k0.h(this));
        } else {
            doFinish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        ((SecurityRebindVerifySetup2Presenter) getPresenter()).x0(this.f41364f.getText().toString(), this.f41365g.getText().toString(), this.f41363e.getText().toString());
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                if (((SecurityRebindVerifySetup2Presenter) SecurityRebindVerifySetup2Activity.this.getPresenter()).f0() == 1) {
                    put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
                } else if (((SecurityRebindVerifySetup2Presenter) SecurityRebindVerifySetup2Activity.this.getPresenter()).f0() == 2) {
                    put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN);
                } else {
                    put("button_name", "19");
                }
            }
        });
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        startActivity(k0.h(this));
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                if (((SecurityRebindVerifySetup2Presenter) SecurityRebindVerifySetup2Activity.this.getPresenter()).f0() == 1) {
                    put("button_name", "15");
                } else if (((SecurityRebindVerifySetup2Presenter) SecurityRebindVerifySetup2Activity.this.getPresenter()).f0() == 2) {
                    put("button_name", "18");
                } else {
                    put("button_name", "22");
                }
            }
        });
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        startActivity(f.e0(this, (String) null));
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                put("button_name", "23");
            }
        });
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ClipData primaryClip = ((ClipboardManager) this.f41366h.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null || itemAt.getText() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String charSequence = itemAt.getText().toString();
        if (charSequence != null && TextUtils.isDigitsOnly(charSequence)) {
            this.f41363e.setText(charSequence);
            EditText editText = this.f41363e;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.B = true;
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", yh());
        hashMap.put("voice", Boolean.FALSE);
        ((SecurityRebindVerifySetup2Presenter) getPresenter()).z0(hashMap);
        vh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(View view, boolean z11) {
        this.f41360b.setSelected(z11);
    }

    public void V1() {
        if (((SecurityRebindVerifySetup2Presenter) getPresenter()).f0() == 1) {
            this.f41374p.setText(R.string.n_security_success_phone);
        } else if (((SecurityRebindVerifySetup2Presenter) getPresenter()).f0() == 2) {
            this.f41374p.setText(R.string.n_security_success_mail);
        } else {
            this.f41374p.setText(R.string.n_security_success_ga);
        }
        this.f41380v.setVisibility(0);
    }

    public void Y(SecuritySetData securitySetData) {
        if (securitySetData == null || securitySetData.b() == null || securitySetData.a() == null || securitySetData.a().getSetting() == null) {
            this.A.k();
            return;
        }
        this.f41382x = securitySetData;
        this.f41383y = securitySetData.b();
        this.f41384z = securitySetData.a().getSetting();
        this.f41371m.setText(String.format("%s%s", new Object[]{getString(R.string.n_security_input_phone), this.f41383y.getPhone()}));
        this.f41372n.setText(String.format("%s%s", new Object[]{getString(R.string.n_security_input_mail), this.f41383y.getEmail()}));
        ViewUtil.m(this.f41376r, this.f41384z.isVerify_ga());
        ViewUtil.m(this.f41377s, this.f41384z.isVerify_email());
        ViewUtil.m(this.f41378t, this.f41384z.isVerify_phone());
        this.A.g();
    }

    public void addEvent() {
        this.f41363e.setOnFocusChangeListener(new w2(this));
        this.f41364f.setOnFocusChangeListener(new x2(this));
        this.f41365g.setOnFocusChangeListener(new v2(this));
        this.f41363e.addTextChangedListener(new a());
        this.f41364f.addTextChangedListener(new b());
        this.f41365g.addTextChangedListener(new c());
        this.f41366h.setOnClickListener(new r2(this));
        this.f41367i.setOnClickListener(new o2(this));
        this.f41369k.setOnClickListener(new s2(this));
        this.f41379u.setOnClickListener(new t2(this));
        this.f41373o.setOnClickListener(new u2(this));
        this.f41375q.setOnClickListener(new q2(this));
        this.f41381w.setOnClickListener(new p2(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public void e2(boolean z11, String str) {
        if (z11) {
            this.f41369k.setVisibility(0);
            this.f41370l.setVisibility(8);
            return;
        }
        this.f41369k.setVisibility(8);
        this.f41370l.setVisibility(0);
        this.f41370l.setText(str);
    }

    public int getContentView() {
        return R.layout.activity_security_rebind_verify_setup2;
    }

    public void h3(boolean z11, String str) {
        if (z11) {
            this.f41367i.setVisibility(0);
            this.f41368j.setVisibility(8);
            return;
        }
        this.f41367i.setVisibility(8);
        this.f41368j.setVisibility(0);
        this.f41368j.setText(str);
    }

    public void initView() {
        this.f41363e = (EditText) this.viewFinder.b(R.id.gaEdit);
        this.f41360b = (LinearLayout) this.viewFinder.b(R.id.gaEditFrame);
        this.f41364f = (EditText) this.viewFinder.b(R.id.emailEdit);
        this.f41361c = (LinearLayout) this.viewFinder.b(R.id.emailEditFrame);
        this.f41365g = (EditText) this.viewFinder.b(R.id.phoneEdit);
        this.f41362d = (LinearLayout) this.viewFinder.b(R.id.phoneEditFrame);
        this.f41366h = (TextView) this.viewFinder.b(R.id.gaPaste);
        this.f41367i = (TextView) this.viewFinder.b(R.id.phoneSend);
        this.f41368j = (TextView) this.viewFinder.b(R.id.phoneCountDown);
        this.f41369k = (TextView) this.viewFinder.b(R.id.emailSend);
        this.f41370l = (TextView) this.viewFinder.b(R.id.emailCountDown);
        this.f41371m = (TextView) this.viewFinder.b(R.id.phoneTitle);
        this.f41372n = (TextView) this.viewFinder.b(R.id.emailTitle);
        this.f41376r = this.viewFinder.b(R.id.gaLayout);
        this.f41377s = this.viewFinder.b(R.id.emailLayout);
        this.f41378t = this.viewFinder.b(R.id.phoneLayout);
        this.f41379u = this.viewFinder.b(R.id.closeBtn);
        this.f41373o = (TextView) this.viewFinder.b(R.id.submit);
        this.f41374p = (TextView) this.viewFinder.b(R.id.successTxt);
        this.f41375q = (TextView) this.viewFinder.b(R.id.confirm);
        this.f41380v = this.viewFinder.b(R.id.successContent);
        this.A = (LoadingLayout) this.viewFinder.b(R.id.loadingLayout);
        this.f41381w = this.viewFinder.b(R.id.notAvailable);
        this.A.p();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void vh() {
        boolean z11 = false;
        if ((!this.f41384z.isVerify_ga() || this.f41363e.getText().length() == 6) && ((!this.f41384z.isVerify_phone() || (this.B && this.f41365g.getText().length() == 6)) && (!this.f41384z.isVerify_email() || (this.C && this.f41364f.getText().length() == 6)))) {
            z11 = true;
        }
        this.f41373o.setEnabled(z11);
    }

    /* renamed from: wh */
    public SecurityRebindVerifySetup2Presenter createPresenter() {
        return new SecurityRebindVerifySetup2Presenter();
    }

    /* renamed from: xh */
    public SecurityRebindVerifySetup2Presenter.f getUI() {
        return this;
    }

    public final String yh() {
        if (((SecurityRebindVerifySetup2Presenter) getPresenter()).f0() == 1) {
            return "VERIFY_SETTING_POLICY_REBIND_PHONE";
        }
        return ((SecurityRebindVerifySetup2Presenter) getPresenter()).f0() == 2 ? "VERIFY_SETTING_POLICY_REBIND_EMAIL" : "VERIFY_SETTING_POLICY_REBIND_GA";
    }
}
