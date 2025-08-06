package com.huobi.asset.feature.summary;

import al.p;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.otc.utils.EaseOutElastic;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.List;
import qh.c;
import qh.d;
import qh.e;
import rh.q;

public class AssetSummaryAccountItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String f42340b;

    /* renamed from: c  reason: collision with root package name */
    public String f42341c;

    /* renamed from: d  reason: collision with root package name */
    public String f42342d;

    /* renamed from: e  reason: collision with root package name */
    public View f42343e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f42344f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42345g;

    /* renamed from: h  reason: collision with root package name */
    public View f42346h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f42347i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42348j;

    /* renamed from: k  reason: collision with root package name */
    public View f42349k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f42350l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f42351m;

    /* renamed from: n  reason: collision with root package name */
    public View f42352n;

    /* renamed from: o  reason: collision with root package name */
    public View f42353o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f42354p;

    /* renamed from: q  reason: collision with root package name */
    public int f42355q;

    /* renamed from: r  reason: collision with root package name */
    public BalanceProfitLossData.AccountBalance f42356r;

    /* renamed from: s  reason: collision with root package name */
    public AnimatorSet f42357s;

    /* renamed from: t  reason: collision with root package name */
    public AnimatorSet f42358t;

    /* renamed from: u  reason: collision with root package name */
    public b f42359u;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            AssetSummaryAccountItemView.this.f42353o.setVisibility(8);
            AssetSummaryAccountItemView.this.f42352n.setVisibility(0);
            AssetSummaryAccountItemView.this.f42354p.setVisibility(8);
        }
    }

    public interface b {
        void I9(View view, BalanceProfitLossData.AccountBalance accountBalance);

        void ze(View view, BalanceProfitLossData.AccountBalance accountBalance, BalanceProfitLossData.AccountBalance accountBalance2);
    }

    public AssetSummaryAccountItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(BalanceProfitLossData.AccountBalance accountBalance, View view) {
        b bVar = this.f42359u;
        if (bVar != null) {
            bVar.ze(view, this.f42356r, accountBalance);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        u();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        BalanceProfitLossData.AccountBalance accountBalance = this.f42356r;
        if (accountBalance == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetSummaryAccountType assetSummaryAccountType = AssetSummaryAccountType.get(accountBalance.getDistributionType());
        if (assetSummaryAccountType != AssetSummaryAccountType.CONTRACT && assetSummaryAccountType != AssetSummaryAccountType.MARGIN) {
            b bVar = this.f42359u;
            if (bVar != null) {
                bVar.I9(view, this.f42356r);
            }
        } else if (q.u(this.f42356r.getDistributionType())) {
            u();
        } else {
            l();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(ValueAnimator valueAnimator) {
        this.f42354p.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f42354p.requestLayout();
        this.f42354p.invalidate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(ValueAnimator valueAnimator) {
        this.f42354p.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f42354p.requestLayout();
        this.f42354p.invalidate();
    }

    public final void i(List<BalanceProfitLossData.AccountBalance> list) {
        this.f42354p.removeAllViews();
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f42354p.addView(k(list.get(i11)));
        }
    }

    public void j(BalanceProfitLossData.AccountBalance accountBalance) {
        if (accountBalance != null) {
            this.f42356r = accountBalance;
            if (accountBalance.getDistributionIconRes() != -1) {
                this.f42344f.setImageResource(accountBalance.getDistributionIconRes());
            }
            if (!StringUtils.r(accountBalance.getDistributionName())) {
                this.f42345g.setText(accountBalance.getDistributionName());
            }
            if (!accountBalance.isOpened()) {
                this.f42346h.setVisibility(0);
                this.f42349k.setVisibility(8);
                this.f42347i.setVisibility(0);
                this.f42348j.setText(R$string.n_balance_total_none_open_title);
            } else if (al.a.j(accountBalance)) {
                this.f42346h.setVisibility(0);
                this.f42349k.setVisibility(8);
                this.f42347i.setVisibility(8);
                this.f42348j.setText(R$string.contract_trade_safeguard);
            } else {
                this.f42346h.setVisibility(8);
                this.f42349k.setVisibility(0);
                String u02 = m.u0(accountBalance.getAccountBalance(), 12, 8);
                this.f42341c = u02;
                this.f42342d = LegalCurrencyConfigUtil.D(u02, "btcusdt", TradeType.PRO);
                this.f42342d = LegalCurrencyConfigUtil.J(getContext(), this.f42342d);
                v();
            }
            List<BalanceProfitLossData.AccountBalance> accountBalances = accountBalance.getAccountBalances();
            if (!CollectionsUtils.b(accountBalances)) {
                this.f42355q = getResources().getDimensionPixelSize(R$dimen.dimen_60) * accountBalances.size();
                n();
                o();
                i(accountBalances);
                if (q.u(accountBalance.getDistributionType())) {
                    this.f42354p.setVisibility(0);
                    this.f42352n.setVisibility(8);
                    this.f42353o.setVisibility(0);
                    return;
                }
                this.f42354p.setVisibility(8);
                this.f42352n.setVisibility(0);
                this.f42353o.setVisibility(8);
                return;
            }
            this.f42354p.setVisibility(8);
            this.f42352n.setVisibility(8);
            this.f42353o.setVisibility(8);
        }
    }

    public final AssetSummarySubAccountItemView k(BalanceProfitLossData.AccountBalance accountBalance) {
        AssetSummarySubAccountItemView assetSummarySubAccountItemView = new AssetSummarySubAccountItemView(getContext());
        assetSummarySubAccountItemView.b(accountBalance);
        assetSummarySubAccountItemView.setOnClickListener(new e(this, accountBalance));
        return assetSummarySubAccountItemView;
    }

    public final void l() {
        if (!this.f42357s.isStarted() && !this.f42357s.isRunning()) {
            this.f42354p.getLayoutParams().height = 0;
            this.f42354p.setVisibility(0);
            this.f42352n.setVisibility(8);
            this.f42353o.setVisibility(0);
            q.L(this.f42356r.getDistributionType(), true);
            this.f42357s.start();
        }
    }

    public final void m() {
        LayoutInflater.from(getContext()).inflate(R$layout.item_asset_summary_account, this);
        this.f42340b = getContext().getResources().getString(R$string.balance_hide_star);
        this.f42343e = findViewById(R$id.item_account_header);
        this.f42344f = (ImageView) findViewById(R$id.iv_asset_account_icon);
        this.f42345g = (TextView) findViewById(R$id.tv_account_name);
        this.f42346h = findViewById(R$id.state_panel);
        this.f42347i = (ImageView) findViewById(R$id.iv_state_icon);
        this.f42348j = (TextView) findViewById(R$id.tv_state);
        this.f42349k = findViewById(R$id.asset_amount_panel);
        this.f42350l = (TextView) findViewById(R$id.account_tv_amount);
        this.f42351m = (TextView) findViewById(R$id.account_tv_amount_cny);
        this.f42354p = (LinearLayout) findViewById(R$id.sub_accounts_container);
        this.f42352n = findViewById(R$id.expand_arrow_down_panel);
        this.f42353o = findViewById(R$id.expand_arrow_up_panel);
        this.f42352n.setVisibility(8);
        this.f42353o.setVisibility(8);
        this.f42353o.setOnClickListener(new c(this));
        this.f42343e.setOnClickListener(new d(this));
    }

    public final void n() {
        this.f42357s = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42354p, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f42355q});
        ofFloat.setDuration(300);
        ofInt.addUpdateListener(new qh.a(this));
        this.f42357s.playTogether(new Animator[]{ofFloat, ofInt});
        this.f42357s.setInterpolator(new EaseOutElastic());
        this.f42357s.setDuration(300);
    }

    public final void o() {
        this.f42358t = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42354p, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(300);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f42355q, 0});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new qh.b(this));
        ofInt.addListener(new a());
        this.f42358t.playTogether(new Animator[]{ofFloat, ofInt});
        this.f42358t.setInterpolator(new EaseOutElastic());
        this.f42358t.setDuration(300);
    }

    public void setOnItemClickListener(b bVar) {
        this.f42359u = bVar;
    }

    public final void u() {
        if (!this.f42358t.isStarted() && !this.f42358t.isRunning()) {
            q.L(this.f42356r.getDistributionType(), false);
            this.f42358t.start();
        }
    }

    public void v() {
        if (p.u()) {
            TextView textView = this.f42350l;
            textView.setText(p.j(this.f42341c, "btc") + " BTC");
            this.f42351m.setText(this.f42342d);
        } else {
            this.f42350l.setText(this.f42340b);
            this.f42351m.setText(this.f42340b);
        }
        LinearLayout linearLayout = this.f42354p;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i11 = 0; i11 < this.f42354p.getChildCount(); i11++) {
                View childAt = this.f42354p.getChildAt(i11);
                if (childAt instanceof AssetSummarySubAccountItemView) {
                    ((AssetSummarySubAccountItemView) childAt).f();
                }
            }
        }
    }

    public AssetSummaryAccountItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetSummaryAccountItemView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetSummaryAccountItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        m();
    }
}
