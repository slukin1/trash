package com.huobi.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.presenter.SecurityLinkStatusPresenter;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.kyc.util.KycProxy;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import sn.f;
import tg.d;

public class SecurityLinkStatusActivity extends BaseActivity<SecurityLinkStatusPresenter, SecurityLinkStatusPresenter.b> implements SecurityLinkStatusPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public String f41271b;

    /* renamed from: c  reason: collision with root package name */
    public String f41272c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41273d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41274e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41275f;

    /* renamed from: g  reason: collision with root package name */
    public int f41276g;

    /* renamed from: h  reason: collision with root package name */
    public SwitchCompat f41277h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41278i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41279j;

    /* renamed from: k  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f41280k;

    /* renamed from: l  reason: collision with root package name */
    public Security2FADialogHelper f41281l;

    /* renamed from: m  reason: collision with root package name */
    public int f41282m;

    /* renamed from: n  reason: collision with root package name */
    public SecurityLinkStatusPresenter f41283n;

    /* renamed from: o  reason: collision with root package name */
    public HbTitleBar f41284o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f41285p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41286q;

    /* renamed from: r  reason: collision with root package name */
    public View f41287r;

    public class a extends Security2FADialogHelper.Callback {
        public a() {
        }

        public void onApiError(String str) {
            SecurityLinkStatusActivity.this.f41281l.v();
        }

        public void onFailed(String str) {
            SecurityLinkStatusActivity.this.f41281l.v();
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            SecurityLinkStatusActivity.this.f41281l.v();
            if (SecurityLinkStatusActivity.this.f41278i) {
                SecurityLinkStatusActivity.this.f41283n.v0(authResult.getEmailCode(), authResult.getSmsCode(), authResult.getGaCode(), authResult.passkey);
            } else {
                SecurityLinkStatusActivity.this.f41283n.w0(authResult.getEmailCode(), authResult.getSmsCode(), authResult.getGaCode(), authResult.passkey);
            }
        }
    }

    public class b extends SecurityStrategyController {
        public b() {
        }

        public boolean C() {
            return SecurityLinkStatusActivity.this.f41283n.i0();
        }

        public void i(String str, String str2, String str3, String str4) {
            SecurityLinkStatusActivity.this.f41283n.w0(str, str2, str3, (Security2FADialogHelper.PasskeyAuth) null);
        }

        public String n() {
            return SecurityLinkStatusActivity.this.f41283n.X();
        }

        public String o() {
            return SecurityLinkStatusActivity.this.f41283n.Y();
        }

        public Map<String, Object> p() {
            return SecurityLinkStatusActivity.this.f41283n.a0();
        }

        public Map<String, Object> s() {
            return SecurityLinkStatusActivity.this.f41283n.d0();
        }

        public boolean x() {
            return SecurityLinkStatusActivity.this.f41283n.g0();
        }

        public boolean y() {
            return SecurityLinkStatusActivity.this.f41283n.h0();
        }

        public boolean z() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        String str;
        g.i("APP_set_security_button_click", new HashMap<String, Object>() {
            {
                if (SecurityLinkStatusActivity.this.f41282m == 1) {
                    put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
                } else if (SecurityLinkStatusActivity.this.f41282m == 2) {
                    put("button_name", "8");
                } else if (SecurityLinkStatusActivity.this.f41282m == 3) {
                    put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
                }
            }
        });
        if (KycProxy.l().r()) {
            startActivity(f.e0(this, (String) null));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int i11 = this.f41282m;
        if (i11 == 1) {
            str = String.format("%s\n\n%s", new Object[]{getResources().getString(R.string.n_security_alert_phone), getResources().getString(R.string.n_security_alert_phone_d)});
        } else if (i11 == 2) {
            str = String.format("%s\n\n%s", new Object[]{getResources().getString(R.string.n_security_alert_mail), getResources().getString(R.string.n_security_alert_mail_d)});
        } else if (i11 == 3) {
            str = String.format("%s\n\n%s", new Object[]{getResources().getString(R.string.n_security_alert_ga), getResources().getString(R.string.n_security_alert_ga_d)});
        } else {
            str = "";
        }
        DialogUtils.b0(this, getResources().getString(R.string.n_security_alert_tips), str, "", getResources().getString(R.string.n_security_alert_cancel), getResources().getString(R.string.n_security_alert_continue), f1.f41679a, new c1(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        if (this.f41282m == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_GA", Boolean.valueOf(!this.f41278i));
            g.i("app_GA_settings_GA_switch_click", hashMap);
        }
        boolean z11 = this.f41278i;
        if (z11) {
            zh();
            this.f41277h.setChecked(this.f41278i);
            g.i("APP_set_security_button_click", new HashMap<String, Object>() {
                {
                    if (SecurityLinkStatusActivity.this.f41282m == 1) {
                        put("button_name", "4");
                    } else if (SecurityLinkStatusActivity.this.f41282m == 2) {
                        put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP);
                    } else if (SecurityLinkStatusActivity.this.f41282m == 3) {
                        put("button_name", CouponReturn.TYPE_EXPERIENCE);
                    }
                }
            });
        } else {
            this.f41277h.setChecked(z11);
            ((SecurityLinkStatusPresenter) getPresenter()).q0(this.f41278i);
            g.i("APP_set_security_button_click", new HashMap<String, Object>() {
                {
                    if (SecurityLinkStatusActivity.this.f41282m == 1) {
                        put("button_name", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
                    } else if (SecurityLinkStatusActivity.this.f41282m == 2) {
                        put("button_name", "9");
                    } else if (SecurityLinkStatusActivity.this.f41282m == 3) {
                        put("button_name", "12");
                    }
                }
            });
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Intent intent = new Intent(this, SecurityRebindVerifySetup1Activity.class);
        intent.putExtra("LINK_TYPE_KEY", this.f41282m);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.f41277h.setChecked(this.f41278i);
        ((SecurityLinkStatusPresenter) getPresenter()).q0(this.f41278i);
    }

    public final void Ah() {
        ViewUtil.m(this.f41287r, this.f41278i);
    }

    public void Ee() {
        if (this.f41280k.isVisible()) {
            this.f41280k.dismiss();
        }
        d.g().i();
        this.f41278i = true;
        this.f41277h.setChecked(true);
        Ah();
    }

    public void Jf() {
        if (this.f41279j) {
            this.f41277h.setChecked(this.f41278i);
            ((SecurityLinkStatusPresenter) getPresenter()).q0(this.f41278i);
        }
        if (!this.f41278i) {
            ((SecurityLinkStatusPresenter) getPresenter()).Z().subscribe();
        }
    }

    public void K7() {
    }

    public void P0() {
        if (this.f41278i) {
            this.f41281l.R(new a());
            return;
        }
        this.f41280k.Ci(new b());
        this.f41280k.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public void P1() {
        if (this.f41280k.isVisible()) {
            this.f41280k.dismiss();
        }
        d.g().i();
        this.f41278i = false;
        this.f41277h.setChecked(false);
        Ah();
        tg.f.j(4);
    }

    public void addEvent() {
        this.f41287r.setOnClickListener(new b1(this));
    }

    public boolean canFullScreen() {
        return true;
    }

    public void doFinish() {
        super.doFinish();
        g.i("app_GA_settings_back_click", (HashMap) null);
    }

    public int getContentView() {
        return R.layout.activity_security_status;
    }

    public void initView() {
        this.f41282m = getIntent().getIntExtra("LINK_TYPE_KEY", -1);
        this.f41271b = getIntent().getStringExtra("BIND_PHONE_KEY");
        this.f41272c = getIntent().getStringExtra("BIND_EMAIL_KEY");
        int intExtra = getIntent().getIntExtra("VERIFY_STATUS_KEY", -1);
        this.f41276g = intExtra;
        this.f41278i = intExtra == 3;
        this.f41279j = getIntent().getBooleanExtra("link_ga_open_dialog_type", false);
        this.f41284o = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f41273d = (TextView) this.viewFinder.b(R.id.tv_first_item_title);
        this.f41274e = (TextView) this.viewFinder.b(R.id.tv_first_item_status);
        this.f41275f = (TextView) this.viewFinder.b(R.id.tv_second_item_title);
        this.f41277h = (SwitchCompat) this.viewFinder.b(R.id.cb_second_item_status);
        this.f41285p = (ImageView) this.viewFinder.b(R.id.topImg);
        this.f41286q = (TextView) this.viewFinder.b(R.id.topTxt);
        this.f41287r = this.viewFinder.b(R.id.layout_second_item);
        this.f41277h.setChecked(this.f41278i);
        this.f41277h.setOnClickListener(new a1(this));
        int i11 = this.f41282m;
        if (i11 == 2) {
            this.f41284o.setTitle(getString(R.string.title_email));
            sh();
        } else if (i11 == 3) {
            this.f41284o.setTitle(getString(R.string.n_new_user_login_verify_ga));
            th();
        } else if (i11 == 1) {
            this.f41284o.setTitle(getString(R.string.title_mobile_verification));
            uh();
        }
        Ah();
        g.i("app_GA_settings_view", (HashMap) null);
    }

    public void m3() {
    }

    /* renamed from: qh */
    public SecurityLinkStatusPresenter createPresenter() {
        SecurityLinkStatusPresenter securityLinkStatusPresenter = new SecurityLinkStatusPresenter();
        this.f41283n = securityLinkStatusPresenter;
        securityLinkStatusPresenter.u0(this.f41282m);
        this.f41283n.t0(this.f41271b, this.f41272c);
        this.f41280k = new SecurityStrategyBottomMenuFragment();
        Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, this.f41283n.f0());
        this.f41281l = security2FADialogHelper;
        security2FADialogHelper.N(false);
        this.f41281l.M(true);
        this.f41281l.O(this.f41283n.f0());
        return this.f41283n;
    }

    /* renamed from: rh */
    public SecurityLinkStatusPresenter.b getUI() {
        return this;
    }

    public final void sh() {
        this.f41273d.setText(R.string.security_email_title);
        this.f41274e.setText(this.f41272c);
        this.f41275f.setText(R.string.n_security_reset_mail);
        this.f41285p.setImageResource(R.drawable.security_status_title_email_img);
        this.f41286q.setText(R.string.n_security_tips_mail);
    }

    public final void th() {
        this.f41273d.setText(R.string.security_google_title);
        this.f41275f.setText(R.string.n_security_reset_ga);
        this.f41285p.setImageResource(R.drawable.security_status_title_ga_img);
        this.f41286q.setText(R.string.n_security_tips_ga);
    }

    public final void uh() {
        this.f41273d.setText(R.string.security_phone_title);
        this.f41274e.setText(this.f41271b);
        this.f41275f.setText(R.string.n_security_reset_phone);
        this.f41285p.setImageResource(R.drawable.security_status_title_phone_img);
        this.f41286q.setText(R.string.n_security_tips_phone);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void zh() {
        DialogUtils.c0(this, getResources().getString(R.string.security_change_tips), "", getResources().getString(R.string.market_coll_edit_cancle_text), getResources().getString(R.string.market_coll_edit_ok_text), e1.f41671a, new d1(this));
    }
}
