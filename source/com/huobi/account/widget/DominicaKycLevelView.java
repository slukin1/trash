package com.huobi.account.widget;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.huobi.utils.a0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import wg.v;
import wg.w;
import zn.a;

public class DominicaKycLevelView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public DominicaKycPageInfo.VerifyStatusInfo f41950b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41951c;

    /* renamed from: d  reason: collision with root package name */
    public View f41952d;

    /* renamed from: e  reason: collision with root package name */
    public View f41953e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f41954f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41955g;

    /* renamed from: h  reason: collision with root package name */
    public View f41956h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41957i;

    /* renamed from: j  reason: collision with root package name */
    public View f41958j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f41959k;

    /* renamed from: l  reason: collision with root package name */
    public int f41960l;

    public DominicaKycLevelView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(View view) {
        i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c() {
        this.f41952d.setOnClickListener(new v(this));
        this.f41958j.setOnClickListener(new w(this));
    }

    public final void d() {
        this.f41951c = (TextView) findViewById(R.id.dominica_kyc_item_verify_rights_title);
        this.f41952d = findViewById(R.id.dominica_kyc_item_not_verify_status_layout);
        this.f41953e = findViewById(R.id.dominica_kyc_item_verify_status_layout);
        this.f41954f = (ImageView) findViewById(R.id.dominica_kyc_item_verify_icon);
        this.f41955g = (TextView) findViewById(R.id.dominica_kyc_item_verify_content);
        this.f41956h = findViewById(R.id.dominica_kyc_item_verify_error_layout);
        this.f41958j = findViewById(R.id.dominica_kyc_item_restart_verify_layout);
        this.f41959k = (LinearLayout) findViewById(R.id.dominica_kyc_item_level_list_layout);
        this.f41957i = (TextView) findViewById(R.id.dominica_kyc_item_verify_error_cause);
    }

    public final boolean e(int i11) {
        int i12 = this.f41960l;
        return i12 < 0 || i11 == i12 + 1;
    }

    public final void h(int i11) {
        if (e(i11)) {
            this.f41952d.setVisibility(0);
        } else {
            this.f41952d.setVisibility(8);
        }
        this.f41953e.setVisibility(8);
        this.f41956h.setVisibility(8);
    }

    public final void i() {
        DominicaKycPageInfo.VerifyStatusInfo verifyStatusInfo = this.f41950b;
        if (verifyStatusInfo != null && !TextUtils.isEmpty(verifyStatusInfo.getAuthUrl())) {
            String authUrl = this.f41950b.getAuthUrl();
            if (!authUrl.startsWith("http") && !authUrl.startsWith("holigeit")) {
                authUrl = a0.j() + authUrl;
            }
            a.d().v(Uri.parse(authUrl));
            a.d().c();
        }
    }

    public final void j(int i11) {
        this.f41952d.setVisibility(8);
        this.f41956h.setVisibility(8);
        this.f41953e.setVisibility(0);
        if (1 == i11) {
            this.f41954f.setImageResource(R.drawable.ic_dominica_kyc_verify_in_tips);
            this.f41955g.setText(R.string.n_kyc_authentication_verifying);
            this.f41955g.setTextColor(getResources().getColor(R.color.KBaseRiskTextColorLow));
        } else if (2 == i11) {
            this.f41954f.setImageResource(R.drawable.ic_check_selected_kyc);
            this.f41955g.setText(R.string.n_kyc_auth_passed);
            this.f41955g.setTextColor(getResources().getColor(R.color.KBaseRiskTextColorLow));
        } else if (3 == i11) {
            this.f41956h.setVisibility(0);
            this.f41954f.setImageResource(R.drawable.ic_dominica_kyc_verify_error_tips);
            this.f41955g.setText(R.string.n_kyc_authentication_fail);
            this.f41955g.setTextColor(getResources().getColor(R.color.baseCoinDangerousTip));
        }
    }

    public void setData(DominicaKycPageInfo.VerifyStatusInfo verifyStatusInfo) {
        this.f41950b = verifyStatusInfo;
        this.f41951c.setText(verifyStatusInfo.getEquityDesc());
        this.f41957i.setText(verifyStatusInfo.getReason());
        if (verifyStatusInfo.getAuthState() == 0) {
            h(verifyStatusInfo.getAuthStepValue());
        } else {
            j(verifyStatusInfo.getAuthState());
        }
        for (DominicaKycPageInfo.VerifyStatusInfo.TextConfigInfo next : verifyStatusInfo.getTextConfig()) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_dominica_kyc_level_content_layout, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.kyc_level_content_key)).setText(next.getTitle());
            ((TextView) inflate.findViewById(R.id.kyc_level_content_value)).setText(next.getValue());
            this.f41959k.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void setMaxLevel(int i11) {
        this.f41960l = i11;
    }

    public DominicaKycLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DominicaKycLevelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R.layout.item_dominica_kyc_level_layout, this);
        d();
        c();
    }
}
