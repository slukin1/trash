package com.huobi.account.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.StatusType;
import com.huobi.account.presenter.DominicaKycPagePresenter;
import com.huobi.account.widget.DominicaKycLevelView;
import com.huobi.coupon.bean.Coupon;
import com.huobi.utils.a0;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.roundview.RoundTextView;
import com.huobi.view.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import sn.f;

@Route(path = "/account/dominicaKyc")
public class DominicaKycPageActivity extends BaseActivity<DominicaKycPagePresenter, DominicaKycPagePresenter.a> implements DominicaKycPagePresenter.a {

    /* renamed from: w  reason: collision with root package name */
    public static final String f41154w = "DominicaKycPageActivity";

    /* renamed from: b  reason: collision with root package name */
    public ExpandableTextView f41155b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f41156c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f41157d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41158e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41159f;

    /* renamed from: g  reason: collision with root package name */
    public View f41160g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f41161h;

    /* renamed from: i  reason: collision with root package name */
    public BottomMenuFragment f41162i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41163j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f41164k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f41165l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f41166m;

    /* renamed from: n  reason: collision with root package name */
    public ConstraintLayout f41167n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f41168o;

    /* renamed from: p  reason: collision with root package name */
    public ConstraintLayout f41169p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41170q;

    /* renamed from: r  reason: collision with root package name */
    public ConstraintLayout f41171r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f41172s;

    /* renamed from: t  reason: collision with root package name */
    public String f41173t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f41174u = false;

    /* renamed from: v  reason: collision with root package name */
    public ConstraintLayout f41175v;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qg(View view) {
        hg(2);
        ((DominicaKycPagePresenter) getPresenter()).a0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.f41174u) {
            th(true);
            this.f41162i.show(getFragmentManager(), "DominicaKycPageActivityMenuDialog");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (!TextUtils.isEmpty(this.f41173t)) {
            HBBaseWebActivity.showWebView(this, a0.j() + this.f41173t, "", "", false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void oh(DominicaKycPageInfo dominicaKycPageInfo, Void voidR) {
        if (!TextUtils.isEmpty(dominicaKycPageInfo.getMintUrl())) {
            String str = a0.j() + dominicaKycPageInfo.getMintUrl();
            Log.d(f41154w, "bind mint jump url = " + str);
            if (!SystemUtils.c()) {
                str = str.replace("www.global-test", "fed-dmbt.global-test");
            }
            BaseModuleConfig.a().k0(str);
        }
    }

    public void Ld(DominicaKycPageInfo dominicaKycPageInfo) {
        if (dominicaKycPageInfo.getBaseInfo() != null) {
            this.f41174u = dominicaKycPageInfo.getBaseInfo().getAuthCountry() != dominicaKycPageInfo.getBaseInfo().getDigitalAuthCountry();
        } else {
            this.f41174u = false;
        }
        this.f41173t = dominicaKycPageInfo.getCardApplyUrl();
        boolean z11 = !TextUtils.isEmpty(dominicaKycPageInfo.getCardApplyUrl());
        ViewUtil.m(this.f41158e, z11);
        ViewUtil.m(this.f41161h, this.f41174u);
        if (z11) {
            this.f41158e.setText(dominicaKycPageInfo.getCardApplyText());
        }
        this.f41159f.setText(dominicaKycPageInfo.getTitle());
        this.f41155b.J(getString(R.string.n_kyc_dmc_intro_q_1) + "\n" + getString(R.string.n_kyc_dmc_intro_a_1) + "\n" + getString(R.string.n_kyc_dmc_intro_q_2) + "\n" + getString(R.string.n_kyc_dmc_intro_a_2_1) + "\n" + getString(R.string.n_kyc_dmc_intro_a_2_2) + "\n" + getString(R.string.n_kyc_dmc_intro_a_2_3) + "\n" + getString(R.string.n_kyc_dmc_intro_a_2_4), StatusType.STATUS_EXPAND);
        rh(this.f41163j, dominicaKycPageInfo.getBaseInfo().getCardNumber());
        if (TextUtils.isEmpty(dominicaKycPageInfo.getBaseInfo().getFirstName()) || TextUtils.isEmpty(dominicaKycPageInfo.getBaseInfo().getLastName())) {
            rh(this.f41164k, (String) null);
        } else {
            rh(this.f41164k, dominicaKycPageInfo.getBaseInfo().getFirstName() + dominicaKycPageInfo.getBaseInfo().getLastName());
        }
        rh(this.f41165l, dominicaKycPageInfo.getBaseInfo().getBirthDay());
        rh(this.f41166m, dominicaKycPageInfo.getBaseInfo().getSexDesc());
        rh(this.f41172s, dominicaKycPageInfo.getMaxLevelDesc());
        String realNationalityName = dominicaKycPageInfo.getBaseInfo().getRealNationalityName();
        if (TextUtils.isEmpty(realNationalityName)) {
            this.f41167n.setVisibility(8);
        } else {
            this.f41167n.setVisibility(0);
            rh(this.f41168o, realNationalityName);
        }
        String realCardNumber = dominicaKycPageInfo.getBaseInfo().getRealCardNumber();
        if (TextUtils.isEmpty(realCardNumber)) {
            this.f41169p.setVisibility(8);
        } else {
            this.f41169p.setVisibility(0);
            rh(this.f41170q, realCardNumber);
        }
        if (this.f41169p.getVisibility() == 8 && this.f41167n.getVisibility() == 8) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f41171r.getLayoutParams();
            layoutParams.setMarginStart(0);
            this.f41171r.setLayoutParams(layoutParams);
        } else {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f41171r.getLayoutParams();
            layoutParams2.setMarginStart(PixelUtils.a(20.0f));
            this.f41171r.setLayoutParams(layoutParams2);
        }
        ph(dominicaKycPageInfo.getStepStates(), dominicaKycPageInfo.getMaxLevel());
        qh(dominicaKycPageInfo);
    }

    /* renamed from: Og */
    public DominicaKycPagePresenter createPresenter() {
        return new DominicaKycPagePresenter();
    }

    /* renamed from: Pg */
    public DominicaKycPagePresenter.a getUI() {
        return this;
    }

    public void Wd(List<MenuItem> list) {
        this.f41162i.setMenuItems(list);
    }

    public void addEvent() {
        this.f41160g.setOnClickListener(new n(this));
        this.f41157d.setOnRetryClickListener(new l(this));
        this.f41158e.setOnClickListener(new m(this));
        findViewById(R.id.kyc_dmc_back).setOnClickListener(new k(this));
    }

    public int getContentView() {
        return R.layout.activity_dominica_kyc_page;
    }

    public void hg(int i11) {
        if (1 == i11) {
            this.f41157d.k();
        } else if (2 == i11) {
            this.f41157d.p();
        } else {
            this.f41157d.g();
        }
    }

    public void initView() {
        this.f41161h = (ImageView) findViewById(R.id.kyc_dmc_title_icon);
        this.f41155b = (ExpandableTextView) findViewById(R.id.dominica_page_expand_text);
        this.f41156c = (LinearLayout) findViewById(R.id.dominica_page_rights_list_layout);
        this.f41163j = (TextView) findViewById(R.id.dmnk_national_code_value);
        this.f41164k = (TextView) findViewById(R.id.dominica_card_name_value);
        this.f41165l = (TextView) findViewById(R.id.dominica_card_dob_value);
        this.f41166m = (TextView) findViewById(R.id.dominica_card_sex_value);
        this.f41172s = (TextView) findViewById(R.id.dominica_card_grade_value);
        this.f41160g = findViewById(R.id.kyc_dmc_title_layout);
        this.f41157d = (LoadingLayout) findViewById(R.id.dominica_page_loading_layout);
        this.f41158e = (TextView) findViewById(R.id.kyc_dmc_card_apply);
        this.f41159f = (TextView) findViewById(R.id.dominica_page_expand_title_text);
        this.f41167n = (ConstraintLayout) findViewById(R.id.cl_card_nation);
        this.f41168o = (TextView) findViewById(R.id.tv_card_nation_value);
        this.f41169p = (ConstraintLayout) findViewById(R.id.cl_card_number);
        this.f41170q = (TextView) findViewById(R.id.tv_card_number_value);
        this.f41171r = (ConstraintLayout) findViewById(R.id.cl_card_grade);
        hg(2);
        this.f41162i = new BottomMenuFragment();
        this.f41175v = (ConstraintLayout) findViewById(R.id.mintLayout);
    }

    public void mh(int i11) {
        this.f41162i.dismiss();
        th(false);
        if (i11 == 1) {
            startActivity(f.q(this, Coupon.SPOT, "1"));
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        ((DominicaKycPagePresenter) getPresenter()).a0();
    }

    public void ph(List<DominicaKycPageInfo.VerifyStatusInfo> list, int i11) {
        if (!CollectionsUtils.b(list)) {
            this.f41156c.removeAllViews();
            for (DominicaKycPageInfo.VerifyStatusInfo data : list) {
                DominicaKycLevelView dominicaKycLevelView = new DominicaKycLevelView(this);
                dominicaKycLevelView.setMaxLevel(i11);
                dominicaKycLevelView.setData(data);
                this.f41156c.addView(dominicaKycLevelView);
            }
        }
    }

    public final void qh(DominicaKycPageInfo dominicaKycPageInfo) {
        if (!dominicaKycPageInfo.isShowMint()) {
            this.f41175v.setVisibility(8);
            return;
        }
        this.f41175v.setVisibility(0);
        RoundTextView roundTextView = (RoundTextView) findViewById(R.id.bindMintState);
        ((AppCompatTextView) findViewById(R.id.mintText)).setText(dominicaKycPageInfo.getMintText());
        if (dominicaKycPageInfo.getBindMintState() != null) {
            RoundViewDelegate delegate = roundTextView.getDelegate();
            int intValue = dominicaKycPageInfo.getBindMintState().intValue();
            if (intValue == 0) {
                roundTextView.setText(getResources().getString(R.string.n_mint_go_bind));
                roundTextView.setTextColor(getColor(R.color.baseColorMajorTheme100));
                delegate.setStrokeColor(getColor(R.color.baseColorMajorTheme100));
                roundTextView.setCompoundDrawablePadding(0);
                roundTextView.setPadding(PixelUtils.a(8.0f), PixelUtils.a(3.0f), PixelUtils.a(8.0f), PixelUtils.a(3.0f));
            } else if (intValue == 1) {
                roundTextView.setText(getResources().getString(R.string.n_mint_bound));
                roundTextView.setTextColor(getColor(R.color.kyc_auth_success));
                delegate.setStrokeColor(getColor(R.color.baseColorContentBackground));
                roundTextView.setCompoundDrawablePadding(PixelUtils.a(4.0f));
                roundTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.f(getResources(), R.drawable.ic_mint_bind_arrow, (Resources.Theme) null), (Drawable) null);
                roundTextView.setPadding(0, PixelUtils.a(3.0f), 0, PixelUtils.a(3.0f));
            } else if (intValue == 2) {
                roundTextView.setText(getResources().getString(R.string.n_mint_expired));
                roundTextView.setTextColor(getColor(R.color.kyc_auth_fail));
                delegate.setStrokeColor(getColor(R.color.baseColorContentBackground));
                roundTextView.setCompoundDrawablePadding(PixelUtils.a(4.0f));
                roundTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.f(getResources(), R.drawable.ic_mint_bind_arrow, (Resources.Theme) null), (Drawable) null);
                roundTextView.setPadding(0, PixelUtils.a(3.0f), 0, PixelUtils.a(3.0f));
            }
            a.a(roundTextView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new o(dominicaKycPageInfo));
        }
    }

    public final void rh(TextView textView, String str) {
        sh(textView, str, "--");
    }

    public final void sh(TextView textView, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else if (!TextUtils.isEmpty(str2)) {
            textView.setText(str2);
        }
    }

    public final void th(boolean z11) {
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
