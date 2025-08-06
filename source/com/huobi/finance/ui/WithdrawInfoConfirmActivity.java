package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.InnerShareParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.IntegrationRiskDescriptionInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.withdraw.ui.WithdrawReqFinishActivity;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.huobi.finance.model.WithdrawRequestParams;
import com.huobi.finance.presenter.WithdrawInfoConfirmPresenter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel;
import g6.b;
import gs.e;
import i6.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;

public class WithdrawInfoConfirmActivity extends BaseActivity<WithdrawInfoConfirmPresenter, WithdrawInfoConfirmPresenter.d> implements WithdrawInfoConfirmPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public TextView f47007b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47008c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f47009d;

    /* renamed from: e  reason: collision with root package name */
    public String f47010e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47011f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47012g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47013h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47014i;

    /* renamed from: j  reason: collision with root package name */
    public CommonCheckBox f47015j;

    /* renamed from: k  reason: collision with root package name */
    public View f47016k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f47017l;

    /* renamed from: m  reason: collision with root package name */
    public View f47018m;

    /* renamed from: n  reason: collision with root package name */
    public IntegrationRiskDescriptionInfo f47019n;

    /* renamed from: o  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f47020o = new SecurityStrategyBottomMenuFragment();

    /* renamed from: p  reason: collision with root package name */
    public String f47021p;

    /* renamed from: q  reason: collision with root package name */
    public String f47022q;

    /* renamed from: r  reason: collision with root package name */
    public String f47023r;

    /* renamed from: s  reason: collision with root package name */
    public String f47024s;

    /* renamed from: t  reason: collision with root package name */
    public String f47025t;

    /* renamed from: u  reason: collision with root package name */
    public ChainInfo f47026u;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((WithdrawInfoConfirmPresenter) getPresenter()).y0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        IntegrationRiskDescriptionInfo integrationRiskDescriptionInfo = this.f47019n;
        if (integrationRiskDescriptionInfo != null) {
            String str = null;
            if (integrationRiskDescriptionInfo.getType() == 1) {
                str = BaseModuleConfig.a().Q(this.f47019n.getPath());
            } else if (this.f47019n.getType() == 2) {
                str = this.f47019n.getPath();
            }
            if (!TextUtils.isEmpty(str)) {
                HBBaseWebActivity.showWebView(this, str, "", "", false);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        CommonCheckBox commonCheckBox = this.f47015j;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        this.f47016k.setEnabled(this.f47015j.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void yh(Activity activity, int i11, String str, String str2, String str3, String str4, WithdrawTypeItem.WithdrawType withdrawType, ChainInfo chainInfo, String str5, String str6, String str7) {
        if (activity != null) {
            Intent intent = new Intent(activity, WithdrawInfoConfirmActivity.class);
            intent.putExtra("EXTRA_CURRENCY", str);
            intent.putExtra("EXTRA_AMOUNT", str2);
            intent.putExtra("EXTRA_ADDRESS", str3);
            intent.putExtra("EXTRA_RISK_LEVEL", str4);
            intent.putExtra(SNSVideoSelfieViewModel.E, withdrawType.toString());
            intent.putExtra("EXTRA_CHAIN_INFO", chainInfo);
            intent.putExtra("EXTRA_FEE", str5);
            intent.putExtra("EXTRA_ADDRESS_TAG", str6);
            intent.putExtra("EXTRA_RECEIVE_AMOUNT", str7);
            activity.startActivityForResult(intent, i11);
        }
    }

    public void T(long j11) {
        startActivity(UnifyRiskActivity.Ch(this, j11, 0));
    }

    public void Wc(IntegrationRiskDescriptionInfo integrationRiskDescriptionInfo) {
        String str;
        d.b("WithdrawInfoConfirmActivity-->updateData-->" + integrationRiskDescriptionInfo);
        this.f47019n = integrationRiskDescriptionInfo;
        if (integrationRiskDescriptionInfo != null) {
            if (!TextUtils.isEmpty(integrationRiskDescriptionInfo.getContent())) {
                String[] split = this.f47019n.getContent().split("\n");
                StringBuilder sb2 = new StringBuilder();
                int i11 = 0;
                while (i11 < split.length) {
                    int i12 = i11 + 1;
                    sb2.append(i12);
                    sb2.append("、");
                    sb2.append(split[i11]);
                    if (i11 < split.length - 1) {
                        sb2.append("\n\n");
                    }
                    i11 = i12;
                }
                str = sb2.toString();
            } else {
                str = "";
            }
            this.f47014i.setText(str);
            ViewUtil.m(this.f47017l, !TextUtils.isEmpty(this.f47019n.getBannerUrl()));
            if (!TextUtils.isEmpty(this.f47019n.getBannerUrl())) {
                b.c().h(this.f47017l, this.f47019n.getBannerUrl());
            }
        }
    }

    public void X(String str, boolean z11) {
        if (z11) {
            Intent intent = new Intent(this, WithdrawQuickReviewActivity.class);
            intent.putExtra("WITHDRAW_ADDRESS_ID", str);
            startActivity(intent);
            setResult(-1);
            finish();
        } else {
            HuobiToastUtil.s(R.string.withdraw_success);
            String str2 = this.f47021p;
            String str3 = this.f47022q;
            String str4 = this.f47023r;
            String str5 = this.f47025t;
            ChainInfo chainInfo = this.f47026u;
            WithdrawReqFinishActivity.Og(this, str2, str3, str4, str5, chainInfo == null ? "" : chainInfo.getDisplayName(), this.f47010e);
            setResult(-1);
            finish();
        }
        e.b().a("PM_WITHDRAW", true, (Map<String, Object>) null);
    }

    public Map<String, Object> Zc() {
        HashMap hashMap = new HashMap();
        hashMap.put("addr-tag", ((WithdrawInfoConfirmPresenter) getPresenter()).Z());
        hashMap.put(InnerShareParams.ADDRESS, this.f47023r);
        hashMap.put("amount", this.f47022q);
        hashMap.put("chain", ((WithdrawInfoConfirmPresenter) getPresenter()).b0().getChain());
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, this.f47021p);
        hashMap.put("fee", ((WithdrawInfoConfirmPresenter) getPresenter()).c0());
        hashMap.put("prefer-fast", ((WithdrawInfoConfirmPresenter) getPresenter()).k0());
        return hashMap;
    }

    public void addEvent() {
        this.viewFinder.b(R.id.id_back_btn).setOnClickListener(new kc(this));
        this.f47015j.setOnClickListener(new lc(this));
        this.f47016k.setOnClickListener(new ic(this));
        this.f47017l.setOnClickListener(new jc(this));
    }

    public void afterInit() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f47021p = intent.getStringExtra("EXTRA_CURRENCY");
            this.f47022q = intent.getStringExtra("EXTRA_AMOUNT");
            this.f47023r = intent.getStringExtra("EXTRA_ADDRESS");
            this.f47024s = intent.getStringExtra("EXTRA_RISK_LEVEL");
            this.f47025t = intent.getStringExtra("EXTRA_RECEIVE_AMOUNT");
            this.f47026u = (ChainInfo) intent.getSerializableExtra("EXTRA_CHAIN_INFO");
            String stringExtra = intent.getStringExtra("EXTRA_ADDRESS_TAG");
            this.f47010e = stringExtra;
            boolean z11 = !TextUtils.isEmpty(stringExtra);
            ViewUtil.m(this.f47008c, z11);
            ViewUtil.m(this.f47009d, z11);
            this.f47009d.setText(this.f47010e);
        }
        this.f47011f.setText(StringUtils.i(this.f47021p));
        this.f47012g.setText(this.f47025t);
        this.f47013h.setText(this.f47023r);
        ChainInfo chainInfo = this.f47026u;
        if (chainInfo != null && !TextUtils.isEmpty(chainInfo.getDisplayName())) {
            ViewUtil.m(this.f47007b, true);
            this.f47007b.setText(this.f47026u.getDisplayName());
        }
        ViewUtil.m(this.f47018m, "RISK_EXIST".equalsIgnoreCase(this.f47024s));
    }

    public int getContentView() {
        return R.layout.activity_withdraw_info_confirm;
    }

    public void initView() {
        this.f47011f = (TextView) this.viewFinder.b(R.id.id_withdraw_info_confirm_symbol_tv);
        this.f47012g = (TextView) this.viewFinder.b(R.id.id_withdraw_info_confirm_amount_tv);
        this.f47013h = (TextView) this.viewFinder.b(R.id.id_withdraw_info_confirm_address_tv);
        this.f47015j = (CommonCheckBox) this.viewFinder.b(R.id.id_withdraw_info_confirm_checkbox);
        this.f47016k = this.viewFinder.b(R.id.dialog_confirm_btn);
        this.f47017l = (ImageView) this.viewFinder.b(R.id.id_withdraw_info_confirm_iv);
        this.f47014i = (TextView) this.viewFinder.b(R.id.id_withdraw_info_confirm_risk_tv);
        this.f47018m = this.viewFinder.b(R.id.id_withdraw_info_confirm_risk_logo);
        this.f47007b = (TextView) this.viewFinder.b(R.id.tv_chain_tag);
        this.f47008c = (TextView) this.viewFinder.b(R.id.tv_tag_label);
        this.f47009d = (TextView) this.viewFinder.b(R.id.tv_tag_value);
    }

    public void rc(final String str, final Pair<UserSecurityInfoData, SecurityStrategySet> pair) {
        this.f47020o.Ci(new SecurityStrategyControllerAdapter() {

            /* renamed from: com.huobi.finance.ui.WithdrawInfoConfirmActivity$1$Params */
            public class Params implements Serializable {
                private String amount;
                private String chain;
                private String currency;
                @SerializedName("withdraw_id")
                private String withdrawId;

                public Params() {
                }

                public String getAmount() {
                    return this.amount;
                }

                public String getChain() {
                    return this.chain;
                }

                public String getCurrency() {
                    return this.currency;
                }

                public String getWithdrawId() {
                    return this.withdrawId;
                }

                public void setAmount(String str) {
                    this.amount = str;
                }

                public void setChain(String str) {
                    this.chain = str;
                }

                public void setCurrency(String str) {
                    this.currency = str;
                }

                public void setWithdrawId(String str) {
                    this.withdrawId = str;
                }
            }

            public boolean C() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_phone();
            }

            public final String Z() {
                return ((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).g0() == WithdrawTypeItem.WithdrawType.HUO_PAY ? "VERIFY_SETTING_POLICY_WITHDRAW" : "VERIFY_SETTING_POLICY_WITHDRAW_AUTH_CODE";
            }

            public void i(String str, String str2, String str3, String str4) {
                super.i(str, str2, str3, str4);
                String c02 = ((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).c0();
                String Z = ((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).Z();
                WithdrawRequestParams withdrawRequestParams = new WithdrawRequestParams();
                withdrawRequestParams.r(str);
                withdrawRequestParams.u((SecurityStrategySet) pair.second);
                withdrawRequestParams.w(Z());
                withdrawRequestParams.o(str);
                withdrawRequestParams.t(str2);
                withdrawRequestParams.q(str3);
                withdrawRequestParams.s(str4);
                withdrawRequestParams.n(((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).f0());
                withdrawRequestParams.m(WithdrawInfoConfirmActivity.this.f47023r);
                withdrawRequestParams.v(Z);
                withdrawRequestParams.p(c02);
                ((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).A0(withdrawRequestParams);
            }

            public String n() {
                return ((UserSecurityInfoData) pair.first).getEmail();
            }

            public String o() {
                return ((UserSecurityInfoData) pair.first).getPhone();
            }

            public Map<String, Object> p() {
                MapParamsBuilder a11 = MapParamsBuilder.c().a("use_type", Z());
                Params params = new Params();
                if (WithdrawInfoConfirmActivity.this.getPresenter() != null) {
                    params.setCurrency(WithdrawInfoConfirmActivity.this.f47021p);
                }
                if (WithdrawInfoConfirmActivity.this.f47022q != null) {
                    params.setAmount(WithdrawInfoConfirmActivity.this.f47022q.trim());
                }
                if (((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).b0() != null) {
                    params.setChain(((WithdrawInfoConfirmPresenter) WithdrawInfoConfirmActivity.this.getPresenter()).b0().getChain());
                }
                params.setWithdrawId(str);
                a11.a("params", params);
                return a11.b();
            }

            public Map<String, Object> s() {
                Map<String, Object> p11 = p();
                p11.put("voice", Boolean.FALSE);
                return p11;
            }

            public boolean x() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_email();
            }

            public boolean y() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerify_ga();
            }

            public boolean z() {
                return ((SecurityStrategySet) pair.second).getSetting().isVerifyPassword();
            }
        });
        this.f47020o.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    /* renamed from: vh */
    public WithdrawInfoConfirmPresenter createPresenter() {
        return new WithdrawInfoConfirmPresenter();
    }

    /* renamed from: wh */
    public WithdrawInfoConfirmPresenter.d getUI() {
        return this;
    }

    public void y(boolean z11) {
        SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f47020o;
        if (securityStrategyBottomMenuFragment != null) {
            securityStrategyBottomMenuFragment.Bi(z11);
        }
    }
}
