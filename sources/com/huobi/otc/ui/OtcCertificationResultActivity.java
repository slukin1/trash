package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UserOtcCoupon;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.lite.kyc.ui.LiteAliDetectionActivity;
import com.huobi.lite.kyc.ui.LiteVerifiedActivity;
import com.huobi.otc.persenter.OtcCertificationResultPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import jp.l;
import oa.a;
import org.greenrobot.eventbus.EventBus;
import sp.g0;
import sp.h0;

public class OtcCertificationResultActivity extends BaseActivity<OtcCertificationResultPresenter, OtcCertificationResultPresenter.b> implements OtcCertificationResultPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f79366b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79367c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79368d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79369e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f79370f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79371g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79372h;

    /* renamed from: i  reason: collision with root package name */
    public Toolbar f79373i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f79374j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f79375k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f79376l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f79377m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f79378n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f79379o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f79380p = false;

    /* renamed from: q  reason: collision with root package name */
    public int f79381q;

    public static void Og(Activity activity, boolean z11, int i11, String str, boolean z12) {
        Intent intent = new Intent(activity, OtcCertificationResultActivity.class);
        intent.putExtra("huobi.otc.extra.code", i11);
        intent.putExtra("com.huobi.otc.risk", z11);
        intent.putExtra("com.huobi.otc.treading", z12);
        intent.putExtra("com.huobi.otc.islite", true);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("huobi.otc.extra.message", str);
        }
        activity.startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gg(View view) {
        OtcModuleConfig.b().l(this, "Started chat with mandatory pre-chat form");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f79377m) {
            finish();
        } else if (this.f79381q == 1048578) {
            Qg();
        } else {
            Pg(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Pg(boolean z11) {
        if (this.f79380p) {
            if (z11) {
                setResult(17);
            } else {
                setResult(18);
            }
        } else if (z11) {
            OtcAliCertificateActivity.gg(this, this.f79378n, this.f79379o);
        }
        finish();
    }

    public final void Qg() {
        Class<LiteAliDetectionActivity> cls = LiteAliDetectionActivity.class;
        Class<LiteVerifiedActivity> cls2 = LiteVerifiedActivity.class;
        if (a.g().f(cls2) != null) {
            a.g().f(cls2).finish();
        }
        if (a.g().f(cls) != null) {
            a.g().f(cls).finish();
        }
        finish();
    }

    /* renamed from: Zf */
    public OtcCertificationResultPresenter createPresenter() {
        return new OtcCertificationResultPresenter();
    }

    public void addEvent() {
        this.f79370f.setOnClickListener(new h0(this));
        this.f79372h.setOnClickListener(new g0(this));
    }

    public void doFinish() {
        int i11 = this.f79381q;
        if (i11 == 1048576) {
            finish();
        } else if (i11 == 1048578) {
            Qg();
        } else {
            Pg(false);
        }
    }

    /* renamed from: fg */
    public OtcCertificationResultPresenter.b getUI() {
        return this;
    }

    public int getContentView() {
        return R$layout.activity_otc_certification_result;
    }

    public void initView() {
        this.f79373i = (Toolbar) findViewById(R$id.toolbar);
        this.f79366b = (ImageView) findViewById(R$id.otc_result_image);
        this.f79367c = (TextView) findViewById(R$id.otc_result_title_txt);
        this.f79368d = (TextView) findViewById(R$id.otc_result_message_txt);
        this.f79369e = (TextView) findViewById(R$id.otc_result_retry_btn);
        this.f79372h = (TextView) findViewById(R$id.otc_result_contract_us_txt);
        this.f79370f = (LinearLayout) findViewById(R$id.otc_result_retry_layout);
        this.f79371g = (ImageView) findViewById(R$id.otc_coupon_iv);
        this.f79374j = (LinearLayout) findViewById(R$id.otc_coupon_ll);
        this.f79375k = (TextView) findViewById(R$id.otc_coupon_volume_tv);
        this.f79376l = (TextView) findViewById(R$id.otc_coupon_due_day_tv);
        this.f79378n = getIntent().getBooleanExtra("com.huobi.otc.risk", false);
        this.f79379o = getIntent().getBooleanExtra("com.huobi.otc.treading", false);
        this.f79380p = getIntent().getBooleanExtra("com.huobi.otc.islite", false);
        l3();
        setToolBar(this.f79373i, "", true);
    }

    public void l3() {
        int i11;
        int intExtra = getIntent().getIntExtra("huobi.otc.extra.code", 0);
        this.f79381q = intExtra;
        if (intExtra == 1048576) {
            this.f79366b.setImageResource(R$drawable.me_certification_success);
            this.f79372h.setVisibility(8);
            this.f79370f.setVisibility(0);
            this.f79369e.setVisibility(0);
            this.f79367c.setText(R$string.n_otc_authentication_success);
            this.f79367c.setTextColor(ContextCompat.getColor(this, R$color.otc_face_result_success));
            this.f79377m = true;
            if (!OtcModuleConfig.a().e0() || getPresenter() == null || ((OtcCertificationResultPresenter) getPresenter()).T() == null) {
                this.f79368d.setVisibility(0);
                this.f79368d.setText(R$string.n_otc_kyc2_success);
            } else {
                this.f79374j.setVisibility(0);
                UserOtcCoupon T = ((OtcCertificationResultPresenter) getPresenter()).T();
                if (((OtcCertificationResultPresenter) getPresenter()).R(T.getEndTime(), T.getSysTime()) == 0) {
                    this.f79376l.setText(R$string.n_otc_coupon_due_today_exceed);
                } else {
                    this.f79376l.setText(String.format(Locale.ENGLISH, getString(R$string.n_otc_coupon_due_in_few_days_exceed), new Object[]{String.valueOf(((OtcCertificationResultPresenter) getPresenter()).R(T.getEndTime(), T.getSysTime()))}));
                }
                TextView textView = this.f79375k;
                textView.setText(T.getQuoteSign() + T.getAmount());
                this.f79371g.setVisibility(0);
                this.f79368d.setVisibility(8);
            }
            TextView textView2 = this.f79369e;
            if (this.f79379o) {
                i11 = R$string.n_otc_promptly_buy;
            } else {
                i11 = R$string.otc_verification_complete;
            }
            textView2.setText(i11);
            if (this.f79380p) {
                l.h();
                EventBus.d().k(new ob.a(this.f79381q));
            }
            oh();
        } else if (intExtra == 1048577) {
            this.f79372h.setVisibility(8);
            this.f79369e.setVisibility(0);
            this.f79370f.setVisibility(0);
            this.f79368d.setVisibility(0);
            this.f79366b.setImageResource(R$drawable.me_certification_failed);
            this.f79367c.setText(R$string.verification_failed);
            this.f79369e.setText(R$string.otc_retry);
            this.f79367c.setTextColor(ContextCompat.getColor(this, R$color.otc_face_result_error));
            this.f79368d.setText(getIntent().getStringExtra("huobi.otc.extra.message"));
        }
        if (this.f79381q != 1048578) {
            return;
        }
        if (this.f79380p) {
            this.f79372h.setVisibility(8);
            this.f79369e.setVisibility(0);
            this.f79370f.setVisibility(0);
            this.f79369e.setText(getString(R$string.head_return));
            this.f79368d.setVisibility(0);
            this.f79367c.setText(R$string.verification_failed);
            this.f79366b.setImageResource(R$drawable.me_certification_failed);
            this.f79367c.setTextColor(ContextCompat.getColor(this, R$color.otc_face_result_error));
            this.f79368d.setText(getIntent().getStringExtra("huobi.otc.extra.message"));
            return;
        }
        this.f79372h.setVisibility(0);
        this.f79369e.setVisibility(8);
        this.f79370f.setVisibility(8);
        this.f79368d.setVisibility(0);
        this.f79367c.setText(R$string.verification_failed);
        this.f79366b.setImageResource(R$drawable.me_certification_failed);
        this.f79367c.setTextColor(ContextCompat.getColor(this, R$color.otc_face_result_error));
        this.f79368d.setText(getIntent().getStringExtra("huobi.otc.extra.message"));
    }

    public final void oh() {
        Class<LiteAliDetectionActivity> cls = LiteAliDetectionActivity.class;
        Class<LiteVerifiedActivity> cls2 = LiteVerifiedActivity.class;
        if (this.f79380p) {
            if (a.g().f(cls2) != null) {
                a.g().f(cls2).finish();
            }
            if (a.g().f(cls) != null) {
                a.g().f(cls).finish();
            }
        }
    }

    public void onBackPressed() {
        doFinish();
    }
}
