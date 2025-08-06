package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.bean.ExamInfo;
import com.huobi.finance.presenter.UnifyRiskPresenter;
import com.huobi.utils.SpannableUtils;
import com.huobi.utils.v0;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;
import rx.functions.Action1;

public class UnifyRiskActivity extends BaseActivity<UnifyRiskPresenter, UnifyRiskPresenter.f> implements UnifyRiskPresenter.f, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f46844b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f46845c;

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f46846d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46847e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46848f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f46849g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46850h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46851i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46852j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46853k;

    /* renamed from: l  reason: collision with root package name */
    public StatusButton f46854l;

    /* renamed from: m  reason: collision with root package name */
    public StatusButton f46855m;

    /* renamed from: n  reason: collision with root package name */
    public int f46856n = 1;

    /* renamed from: o  reason: collision with root package name */
    public int f46857o;

    /* renamed from: p  reason: collision with root package name */
    public int f46858p;

    public class a implements View.OnClickListener {

        /* renamed from: com.huobi.finance.ui.UnifyRiskActivity$a$a  reason: collision with other inner class name */
        public class C0574a implements Action1<Object> {
            public C0574a() {
            }

            public void call(Object obj) {
                HuobiToastUtil.s(R.string.send_success);
            }
        }

        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((UnifyRiskPresenter) UnifyRiskActivity.this.getPresenter()).p0().subscribe(q6.d.c(UnifyRiskActivity.this.getUI(), new C0574a()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((UnifyRiskPresenter) UnifyRiskActivity.this.getPresenter()).f0();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements Action1<StringStatusResponse<Object>> {
        public c() {
        }

        /* renamed from: a */
        public void call(StringStatusResponse<Object> stringStatusResponse) {
        }
    }

    public class d implements Action1<Object> {
        public d() {
        }

        public void call(Object obj) {
            HuobiToastUtil.s(R.string.send_success);
        }
    }

    public class e implements DialogUtils.b.f {
        public e() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
        }
    }

    public class f implements DialogUtils.b.f {
        public f() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
            UnifyRiskActivity.this.finish();
        }
    }

    public class g implements Action1<RiskActionData> {

        public class a implements Comparator<RiskActionData.ActionsBean> {
            public a() {
            }

            /* renamed from: a */
            public int compare(RiskActionData.ActionsBean actionsBean, RiskActionData.ActionsBean actionsBean2) {
                return actionsBean2.getActionstate() - actionsBean.getActionstate();
            }
        }

        public g() {
        }

        /* renamed from: a */
        public void call(RiskActionData riskActionData) {
            if (!CollectionsUtils.b(riskActionData.getActions())) {
                Collections.sort(riskActionData.getActions(), new a());
            }
            int actionstate = riskActionData.getActions().get(UnifyRiskActivity.this.f46857o).getActionstate();
            if (actionstate == 0) {
                HuobiToastUtil.j(R.string.don_not_finish_verify);
            } else if (actionstate == 1) {
                UnifyRiskActivity.this.rh(((UnifyRiskPresenter) UnifyRiskActivity.this.getPresenter()).g0().get(UnifyRiskActivity.ph(UnifyRiskActivity.this)).intValue());
            } else if (actionstate == 2) {
                HuobiToastUtil.j(UnifyRiskActivity.this.uh());
                UnifyRiskActivity.this.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(HBDialogFragment hBDialogFragment) {
        finish();
        hBDialogFragment.sh();
    }

    public static Intent Ch(Context context, long j11, int i11) {
        Intent intent = new Intent(context, UnifyRiskActivity.class);
        intent.putExtra("ORDER_ID", j11);
        intent.putExtra("ORDER_TYPE", i11);
        return intent;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ int ph(UnifyRiskActivity unifyRiskActivity) {
        int i11 = unifyRiskActivity.f46857o + 1;
        unifyRiskActivity.f46857o = i11;
        return i11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(String str, View view) {
        HBBaseWebActivity.showWebView(this, str, "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(ExamInfo examInfo, View view) {
        ((UnifyRiskPresenter) getPresenter()).p0().subscribe(q6.d.c(getUI(), new d()));
        ((UnifyRiskPresenter) getPresenter()).i0(examInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(HBDialogFragment hBDialogFragment) {
        v0.e(this, "900000384186");
    }

    public void Dh(ViewGroup viewGroup, int i11) {
        int childCount = viewGroup.getChildCount();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = viewGroup.getChildAt(i12);
            if (childAt instanceof LinearLayout) {
                boolean z11 = true;
                ((TextView) childAt.findViewById(R.id.tv_pic)).setSelected(i12 <= i11);
                ((TextView) childAt.findViewById(R.id.tv_txt)).setSelected(i12 <= i11);
                childAt.findViewById(R.id.line1).setSelected(i12 <= i11);
                View findViewById = childAt.findViewById(R.id.line2);
                if (i12 > i11) {
                    z11 = false;
                }
                findViewById.setSelected(z11);
                if (i11 == i12) {
                    findViewById.setSelected(false);
                }
            }
            i12++;
        }
    }

    public void Eh(View view, int i11) {
        ((TextView) view.findViewById(R.id.tv_pic)).setText(String.valueOf(i11 + 1));
        TextView textView = (TextView) view.findViewById(R.id.tv_txt);
        int intValue = ((UnifyRiskPresenter) getPresenter()).g0().get(i11).intValue();
        if (intValue == -1) {
            textView.setText(R.string.wait_check);
        } else if (intValue == 0) {
            textView.setText(R.string.market_edit_collection_finish_text);
        } else if (intValue == 1) {
            textView.setText(R.string.title_email);
        } else if (intValue == 2) {
            textView.setText(R.string.title_sms);
        } else if (intValue == 3) {
            textView.setText(R.string.face_check_title);
        } else if (intValue == 4) {
            textView.setText(R.string.n_quiz_verify);
        }
    }

    public void F0() {
        this.f46844b.g();
    }

    public final void Fh() {
        new DialogUtils.b.d(this).i1(5).c1(getString(R.string.n_withdraw_face_anti_fraud_title)).C0(getString(R.string.n_withdraw_face_anti_fraud_content)).R0(getString(R.string.n_withdraw_face_anti_fraud_subcontent)).T0(true).S0(Integer.valueOf(ContextCompat.getColor(this, R.color.baseColorMajorTheme100))).U0(new p8(this)).P0(getString(R.string.n_withdraw_face_anti_fraud_confirm)).Q0(r8.f47310a).s0(getString(R.string.n_withdraw_face_anti_fraud_cancel)).N0(new q8(this)).n0(false).j0().show(getSupportFragmentManager(), "");
    }

    public void addEvent() {
        this.f46846d.setNavigationOnClickListener(new m8(this));
        this.f46851i.setOnClickListener(new a());
        this.f46844b.setOnRetryClickListener(new b());
        this.f46854l.setOnClickListener(this);
    }

    public void b7(boolean z11, String str) {
        ((UnifyRiskPresenter) getPresenter()).d0(true).subscribe(q6.d.c(getUI(), new g()));
    }

    public int getContentView() {
        return R.layout.activity_finance_risk;
    }

    public void initView() {
        this.f46846d = (Toolbar) findViewById(R.id.toolbar);
        this.f46844b = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f46845c = (ViewGroup) findViewById(R.id.vg_step);
        this.f46847e = (TextView) findViewById(R.id.tv_title);
        this.f46848f = (TextView) findViewById(R.id.tv_desc);
        this.f46849g = (ImageView) findViewById(R.id.iv_pic);
        this.f46850h = (TextView) findViewById(R.id.tv_tip);
        this.f46851i = (TextView) findViewById(R.id.tv_retry);
        this.f46852j = (TextView) findViewById(R.id.tv_notice);
        TextView textView = (TextView) findViewById(R.id.tv_mid_desc);
        this.f46853k = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f46854l = (StatusButton) findViewById(R.id.btn_confirm);
        this.f46855m = (StatusButton) findViewById(R.id.btn_go);
    }

    public void l6(RiskActionData riskActionData) {
        boolean z11;
        List<RiskActionData.ActionsBean> actions = riskActionData.getActions();
        if (actions != null) {
            Iterator<RiskActionData.ActionsBean> it2 = actions.iterator();
            while (true) {
                z11 = true;
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().getActionstate() == 1) {
                    this.f46857o++;
                }
            }
            List<Integer> g02 = ((UnifyRiskPresenter) getPresenter()).g0();
            if (((UnifyRiskPresenter) getPresenter()).g0().size() <= 2) {
                z11 = false;
            }
            if (z11) {
                this.f46845c.setVisibility(0);
                wh(this.f46845c, g02.size());
            } else {
                this.f46845c.setVisibility(8);
            }
            rh(g02.get(this.f46857o).intValue());
        }
    }

    public void m0() {
        this.f46844b.k();
    }

    public void onBackPressed() {
        if (this.f46858p == 0) {
            super.onBackPressed();
            return;
        }
        DialogUtils.c0(this, getString(R.string.unify_risk_confirm_dialog_title), (String) null, getString(R.string.login_dialog_cancel), getString(R.string.login_dialog_confirm), new e(), new f());
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int i11 = this.f46856n;
        if (i11 == 1) {
            ((UnifyRiskPresenter) getPresenter()).r0();
        } else if (i11 == 2) {
            ((UnifyRiskPresenter) getPresenter()).d0(false).subscribe(q6.d.c(getUI(), new g()));
        } else if (i11 == 3) {
            finish();
        }
        if (this.f46857o == ((UnifyRiskPresenter) getPresenter()).g0().size() - 2) {
            ((UnifyRiskPresenter) getPresenter()).s0().subscribe(EasySubscriber.create(new c()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void rd(ExamInfo examInfo) {
        SpannableStringBuilder spannableStringBuilder;
        String url = examInfo.getUrl();
        String string = getResources().getString(R.string.n_quiz_verify_desc_2, new Object[]{url});
        o8 o8Var = new o8(this, url);
        SpannableStringBuilder a11 = SpannableUtils.a(this, string, url, o8Var);
        if (!TextUtils.isEmpty(examInfo.getMessage())) {
            a11.append("\n" + examInfo.getMessage());
        }
        if (examInfo.showRetryBtn()) {
            String string2 = getResources().getString(R.string.n_resend);
            if (examInfo.getCountDown() > 0) {
                spannableStringBuilder = SpannableUtils.c(this, string2 + "(" + examInfo.getCountDown() + "s)");
            } else {
                spannableStringBuilder = SpannableUtils.b(this, string2, new n8(this, examInfo));
            }
            a11.append(spannableStringBuilder);
        }
        this.f46853k.setText(a11);
        this.f46855m.setOnClickListener(o8Var);
    }

    public void rh(int i11) {
        if (((UnifyRiskPresenter) getPresenter()).g0().size() > 2) {
            Dh(this.f46845c, this.f46857o);
        }
        this.f46858p = i11;
        th(i11);
        this.f46854l.setButtonBackground(1);
        this.f46855m.setVisibility(8);
        this.f46853k.setVisibility(8);
        if (i11 == 0) {
            this.f46856n = 3;
            this.f46854l.setButtonText((int) R.string.market_edit_collection_finish_text);
        } else if (i11 == 3) {
            this.f46856n = 1;
            this.f46854l.setButtonText(getResources().getString(R.string.withdraw_start_check));
            Fh();
        } else if (i11 == 4) {
            this.f46856n = 2;
            this.f46855m.setVisibility(0);
            this.f46853k.setVisibility(0);
            this.f46854l.setButtonBackground(0);
            this.f46854l.setButtonText(getResources().getString(R.string.withdraw_finish_check));
            ((UnifyRiskPresenter) getPresenter()).b0();
        } else {
            this.f46856n = 2;
            this.f46854l.setButtonText(getResources().getString(R.string.withdraw_finish_check));
        }
    }

    /* renamed from: sh */
    public UnifyRiskPresenter createPresenter() {
        return new UnifyRiskPresenter();
    }

    public void showLoading() {
        this.f46844b.p();
    }

    public void th(int i11) {
        this.f46852j.setText(R.string.withdraw_risk_notice);
        if (i11 == -1) {
            this.f46847e.setText(R.string.wait_check);
            this.f46848f.setText(R.string.face_check_desc);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_wait);
            this.f46850h.setText(R.string.wait_check_tip);
            this.f46851i.setVisibility(8);
        } else if (i11 == 0) {
            this.f46847e.setText(R.string.verify_finish);
            this.f46848f.setText(R.string.unify_withdraw_verify_finish_desc);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_pass);
            this.f46850h.setText(R.string.unify_withdraw_verify_finish_tip);
            this.f46851i.setVisibility(8);
        } else if (i11 == 1) {
            this.f46847e.setText(R.string.title_email);
            this.f46848f.setText(R.string.mail_check_desc);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_mail);
            this.f46850h.setText(getResources().getString(R.string.mail_check_tip, new Object[]{"30"}));
            this.f46851i.setText(R.string.mail_check_retry);
            this.f46851i.setVisibility(0);
        } else if (i11 == 2) {
            this.f46847e.setText(R.string.title_sms);
            this.f46848f.setText(R.string.sms_check_desc);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_sms);
            this.f46850h.setText(getResources().getString(R.string.sms_check_tip, new Object[]{"30"}));
            this.f46851i.setText(R.string.sms_check_retry);
            this.f46851i.setVisibility(0);
        } else if (i11 == 3) {
            this.f46847e.setText(R.string.face_check_title);
            this.f46848f.setText(R.string.face_check_desc);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_face);
            this.f46850h.setText(getResources().getString(R.string.face_check_tip, new Object[]{"30"}));
            this.f46851i.setVisibility(8);
        } else if (i11 == 4) {
            this.f46847e.setText(R.string.n_quiz_verify);
            this.f46848f.setText("");
            this.f46849g.setImageResource(R.drawable.icon_questionnaire_on);
            String string = getResources().getString(R.string.n_quiz_verify_tips_time);
            this.f46850h.setText(getResources().getString(R.string.n_quiz_verify_tips, new Object[]{string}));
            this.f46851i.setVisibility(8);
        }
    }

    public int uh() {
        return R.string.check_failed_please_retry;
    }

    /* renamed from: vh */
    public UnifyRiskPresenter.f getUI() {
        return this;
    }

    public void wh(ViewGroup viewGroup, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.unify_risk_step, viewGroup, false);
            Eh(inflate, i12);
            viewGroup.addView(inflate);
            if (i12 == 0) {
                inflate.findViewById(R.id.line1).setVisibility(4);
            } else if (i12 == i11 - 1) {
                inflate.findViewById(R.id.line2).setVisibility(4);
            }
        }
    }
}
