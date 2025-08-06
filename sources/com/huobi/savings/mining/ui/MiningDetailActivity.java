package com.huobi.savings.mining.ui;

import al.p;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.MiningDetailBean;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.savings.mining.presenter.MiningDetailPresenter;
import com.huobi.utils.a0;
import com.huobi.view.button.StatusButton;
import com.huochat.community.util.ToastTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import sn.f;
import xq.c;
import xq.d;
import xq.e;
import xq.g;
import xq.h;
import xq.i;
import xq.j;
import xq.l;
import xq.n;
import xq.o;
import xq.q;
import xq.r;
import xq.s;
import xq.t;
import xq.u;
import xq.v;

@Route(path = "/mining/detail")
public class MiningDetailActivity extends BaseActivity<MiningDetailPresenter, MiningDetailPresenter.e> implements MiningDetailPresenter.e {

    /* renamed from: b  reason: collision with root package name */
    public int f80697b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80698c = false;

    /* renamed from: d  reason: collision with root package name */
    public View f80699d;

    /* renamed from: e  reason: collision with root package name */
    public StatusButton f80700e;

    /* renamed from: f  reason: collision with root package name */
    public StatusButton f80701f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80702g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f80703h;

    /* renamed from: i  reason: collision with root package name */
    public CommonSwitchButton f80704i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f80705j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f80706k;

    /* renamed from: l  reason: collision with root package name */
    public View f80707l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f80708m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f80709n;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout f80710o;

    /* renamed from: p  reason: collision with root package name */
    public View f80711p;

    /* renamed from: q  reason: collision with root package name */
    public LinearLayout f80712q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f80713r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f80714s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f80715t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f80716u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f80717v;

    /* renamed from: w  reason: collision with root package name */
    public MiningDetailBean f80718w;

    /* renamed from: x  reason: collision with root package name */
    public String f80719x;

    /* renamed from: y  reason: collision with root package name */
    public long f80720y;

    public class b extends a {
        public b(String str, String str2, List<MiningDetailBean.TieredRate> list, String str3, String str4) {
            super(str, str2, list, str3, str4);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(View view) {
            String s11 = f.s();
            String str = String.format(Locale.US, a0.j() + "%sfinancial/earn/h5/", new Object[]{s11}) + "stepRate?currency=" + this.f80724d;
            k.n("H5-tieredRate Page h5Url = " + str);
            HBBaseWebActivity.showWebViewNoClear(MiningDetailActivity.this, str, "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public View a() {
            View inflate = LayoutInflater.from(MiningDetailActivity.this).inflate(R.layout.dialog_tiered_rate_remind, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_tiered_table);
            linearLayout.removeAllViews();
            for (int i11 = 0; i11 < this.f80723c.size(); i11++) {
                MiningDetailBean.TieredRate tieredRate = this.f80723c.get(i11);
                View inflate2 = LayoutInflater.from(MiningDetailActivity.this).inflate(R.layout.item_tiered_rate_info, (ViewGroup) null);
                TextView textView = (TextView) inflate2.findViewById(R.id.tv_tiered_range);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.tv_tiered_rate);
                if (i11 == this.f80723c.size() - 1) {
                    textView.setText(String.format(">%s %s:     ", new Object[]{tieredRate.amountStart, this.f80724d}));
                } else {
                    textView.setText(String.format("%s~%s %s:     ", new Object[]{tieredRate.amountStart, tieredRate.amountEnd, this.f80724d}));
                }
                textView2.setText(m.Q(tieredRate.rate, 2, 1));
                linearLayout.addView(inflate2);
            }
            ((TextView) inflate.findViewById(R.id.tv_tiered_link)).setOnClickListener(new v(this));
            return inflate;
        }

        public /* bridge */ /* synthetic */ void b(String str) {
            super.b(str);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ih(View view) {
        T1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        DialogUtils.X(this, "", getResources().getString(R.string.n_mining_fixed_transfer_continue_tips), "", getResources().getString(R.string.n_known), j.f61675a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        if (this.f80718w != null) {
            Ch(!this.f80704i.isChecked());
            ai("5174");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        if (this.f80718w != null) {
            AssetModuleConfig.a().w0(this, "financial/earn/h5?utm_source=app_orderdetails_redeem");
            ai("5180");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        if (this.f80718w != null) {
            if (this.f80698c) {
                String s11 = f.s();
                String str = String.format(Locale.US, a0.j() + "%sfinancial/prime-earn/h5/", new Object[]{s11}) + "redeem?orderId=" + this.f80718w.getOrderId() + "&projectId=" + this.f80718w.getProjectId();
                k.n("定期赎回地址 url = " + str);
                HBBaseWebActivity.showWebViewNoClear(this, str, "", "", false);
                ai("5194");
            } else {
                MiningRedeemDialogFragment miningRedeemDialogFragment = new MiningRedeemDialogFragment(this);
                miningRedeemDialogFragment.Hh(this.f80718w);
                miningRedeemDialogFragment.show(getSupportFragmentManager(), "MiningRedeemDialogFragment");
                ai("5194");
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Ph(View view, View view2) {
        view.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rh(a aVar, View view) {
        DialogUtils.a0(this, getString(R.string.n_asset_rate_explain), aVar.a(), getResources().getString(R.string.n_known), xq.m.f61678a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Sh(View view, View view2) {
        view.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Uh(a aVar, View view) {
        DialogUtils.X(this, "", aVar.f80727g, "", getResources().getString(R.string.n_known), i.f61674a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vh(View view) {
        ((MiningDetailPresenter) getPresenter()).U(this.f80718w.getOrderId());
        ai("APP_huobiearn_account_int.collection_click");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wh(View view) {
        Bh(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        Bh(2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        Bh(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        DialogUtils.X(this, "", getResources().getString(R.string.n_mining_transfer_tips, new Object[]{this.f80718w.getBalanceAutoTime()}), "", getResources().getString(R.string.n_known), h.f61673a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        DialogUtils.X(this, "", getResources().getString(R.string.n_mining_fixed_transfer_tips), "", getResources().getString(R.string.n_known), xq.k.f61676a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bh(int i11) {
        ((MiningDetailPresenter) getPresenter()).V(this.f80718w.getOrderId(), i11);
    }

    public final void Ch(boolean z11) {
        ((MiningDetailPresenter) getPresenter()).T(this.f80718w.getCurrency(), z11);
    }

    public final View Dh(a aVar) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_mining_info_item_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.label);
        TextView textView2 = (TextView) inflate.findViewById(R.id.value);
        View findViewById = inflate.findViewById(R.id.askIcon);
        textView.setText(aVar.f80721a);
        textView2.setText(TextUtils.isEmpty(aVar.f80722b) ? "--" : aVar.f80722b);
        if (aVar.a() != null) {
            findViewById.setVisibility(0);
            textView.setOnClickListener(new xq.a(findViewById));
            findViewById.setOnClickListener(new g(this, aVar));
        } else if (aVar.f80727g != null) {
            findViewById.setVisibility(0);
            textView.setOnClickListener(new l(findViewById));
            findViewById.setOnClickListener(new xq.f(this, aVar));
        } else {
            findViewById.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f80725e)) {
            TextView textView3 = (TextView) inflate.findViewById(R.id.tips);
            textView3.setVisibility(0);
            textView3.setText(aVar.f80725e);
        }
        if (!TextUtils.isEmpty(aVar.f80726f)) {
            TextView textView4 = (TextView) inflate.findViewById(R.id.orange_tips);
            textView4.setVisibility(0);
            textView4.setText(aVar.f80726f);
        }
        return inflate;
    }

    /* renamed from: Eh */
    public MiningDetailPresenter createPresenter() {
        return new MiningDetailPresenter();
    }

    public void Fg(boolean z11, String str) {
        if (z11) {
            String string = getResources().getString(R.string.n_mining_collect_interest_success);
            ToastTool.showIcon(string, "+" + p.i(str, this.f80697b) + " " + this.f80719x, R.drawable.ic_success, 1);
            ((MiningDetailPresenter) getPresenter()).a0();
        }
    }

    public String Fh() {
        MiningDetailBean miningDetailBean = this.f80718w;
        if (miningDetailBean == null) {
            return "";
        }
        if (miningDetailBean.getShelfType() == 0) {
            return "1005308";
        }
        return this.f80718w.getShelfType() == 1 ? "1005309" : "1005310";
    }

    /* renamed from: Gh */
    public MiningDetailPresenter.e getUI() {
        return this;
    }

    public void T1() {
        ((MiningDetailPresenter) getPresenter()).a0();
        this.f80710o.p();
    }

    public final void Zh(int i11) {
        if (i11 == 1) {
            Log.d("MiningDetailActivity", "updateFixedInfo: 到期自动转入余币宝");
            this.f80715t.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_selected, 0, 0, 0);
            this.f80716u.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80717v.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80715t.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80716u.setTextColor(getResources().getColor(R.color.color_909090));
            this.f80717v.setTextColor(getResources().getColor(R.color.color_909090));
        } else if (i11 == 2) {
            Log.d("MiningDetailActivity", "updateFixedInfo: 到期自动续投");
            this.f80715t.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80716u.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80717v.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_selected, 0, 0, 0);
            this.f80715t.setTextColor(getResources().getColor(R.color.color_909090));
            this.f80716u.setTextColor(getResources().getColor(R.color.color_909090));
            this.f80717v.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
        } else if (i11 == 0) {
            Log.d("MiningDetailActivity", "updateFixedInfo: 到期自动赎回");
            this.f80715t.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80716u.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_selected, 0, 0, 0);
            this.f80717v.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_circle_unselected, 0, 0, 0);
            this.f80715t.setTextColor(getResources().getColor(R.color.color_909090));
            this.f80716u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80717v.setTextColor(getResources().getColor(R.color.color_909090));
        }
    }

    public void addEvent() {
        this.f80699d.setOnClickListener(new t(this));
        this.f80711p.setOnClickListener(new e(this));
        this.f80708m.setOnClickListener(new r(this));
        this.f80709n.setOnClickListener(new n(this));
        this.f80704i.setOnClickListener(new u(this));
        this.f80701f.setOnClickListener(new o(this));
        this.f80700e.setOnClickListener(new xq.b(this));
        this.f80710o.setOnRetryClickListener(new s(this));
    }

    public void ai(String str) {
        String Fh = Fh();
        if (!TextUtils.isEmpty(Fh)) {
            is.a.j(str, (Map<String, Object>) null, Fh);
        }
    }

    public final void bi() {
        String Fh = Fh();
        if (!TextUtils.isEmpty(Fh)) {
            is.a.n("126", Fh, String.valueOf(SystemClock.elapsedRealtime() - this.f80720y), (Map<String, Object>) null);
        }
    }

    public final void ci(MiningDetailBean miningDetailBean) {
        Resources resources = getResources();
        ArrayList arrayList = new ArrayList();
        if (m.a(miningDetailBean.getPreMiningAmount()).compareTo(BigDecimal.ZERO) != 0) {
            arrayList.add(new a(resources.getString(R.string.n_mining_pre_amount), p.i(miningDetailBean.getPreMiningAmount(), this.f80697b) + " " + this.f80719x, getResources().getString(R.string.n_mining_pre_amount_tip)));
        }
        arrayList.add(new a(resources.getString(R.string.n_mining_type), resources.getString(R.string.n_mining_active), (List<MiningDetailBean.TieredRate>) null, miningDetailBean.getTag(this)));
        b bVar = new b(resources.getString(R.string.n_grid_apy), m.Q(miningDetailBean.getMiningYearRate(), 2, 1), miningDetailBean.getTieredRate(), miningDetailBean.getCurrency(), (String) null);
        int i11 = 0;
        if (miningDetailBean.getCouponStatus() == 1) {
            bVar.b(String.format(getResources().getString(R.string.n_balance_earn_extra_interest), new Object[]{m.Q(miningDetailBean.getCouponRate(), 2, 1)}));
        }
        arrayList.add(bVar);
        arrayList.add(new a(resources.getString(R.string.n_balance_earn_yesterday_income), p.i(miningDetailBean.getYesterdayIncome(), this.f80697b) + " " + this.f80719x, (List<MiningDetailBean.TieredRate>) null, (String) null));
        arrayList.add(new a(resources.getString(R.string.n_mining_total_profit), p.i(miningDetailBean.getTotalIncomeAmount(), this.f80697b) + " " + this.f80719x));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f80703h.addView(Dh((a) it2.next()));
        }
        this.f80706k.setText(resources.getString(R.string.n_mining_balance_auto_mining));
        this.f80700e.setVisibility(0);
        this.f80705j.setVisibility(miningDetailBean.isSupportYbb() ? 0 : 8);
        View findViewById = findViewById(R.id.view_line1);
        if (!miningDetailBean.isSupportYbb()) {
            i11 = 8;
        }
        findViewById.setVisibility(i11);
        this.f80704i.setChecked(miningDetailBean.isBalanceAutoStatusOpen());
    }

    public final void di(MiningDetailBean miningDetailBean) {
        Resources resources = getResources();
        ArrayList arrayList = new ArrayList();
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_mining_info_fixed_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tips);
        int i11 = 8;
        boolean z11 = false;
        if (StringUtils.p(miningDetailBean.getTag(this))) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(miningDetailBean.getTag(this));
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_day_num);
        String str = miningDetailBean.getTerm() + getResources().getString(R.string.n_mining_day_text);
        if (TextUtils.isEmpty(str)) {
            str = "--";
        }
        textView2.setText(str);
        arrayList.add(new a(resources.getString(R.string.n_mining_type), resources.getString(R.string.n_mining_fixed), (List<MiningDetailBean.TieredRate>) null, miningDetailBean.getFixedTag(this)));
        arrayList.add(new a(resources.getString(R.string.n_mining_duration), miningDetailBean.getTerm() + resources.getString(R.string.n_mining_day_text)));
        new a(resources.getString(R.string.n_grid_apy), m.Q(miningDetailBean.getMiningYearRate(), 2, RoundingMode.DOWN.ordinal()));
        AutoSizeTextView autoSizeTextView = (AutoSizeTextView) inflate.findViewById(R.id.astv_orange_tag);
        if (miningDetailBean.getCouponStatus() == 1) {
            autoSizeTextView.setVisibility(0);
            autoSizeTextView.setText(String.format(getResources().getString(R.string.n_balance_earn_extra_interest), new Object[]{m.Q(miningDetailBean.getCouponRate(), 2, 1)}));
        } else {
            autoSizeTextView.setVisibility(8);
        }
        ((TextView) inflate.findViewById(R.id.tv_benefit_value)).setText(m.Q(miningDetailBean.getMiningYearRate(), 2, RoundingMode.DOWN.ordinal()));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_today_collect_interest);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_collect_interest);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_interest_value_zero);
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_interest_value);
        String str2 = p.i(miningDetailBean.getInterestToGet(), this.f80697b) + " " + this.f80719x;
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_collect_interest);
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_collect_interest_yet);
        if (miningDetailBean.getBtnStatus() == 0) {
            textView6.setVisibility(8);
            textView7.setVisibility(8);
            textView5.setVisibility(8);
            textView5.setText("");
            textView4.setVisibility(0);
        } else if (miningDetailBean.getBtnStatus() == 1) {
            textView7.setVisibility(8);
            textView6.setVisibility(0);
            textView6.setOnClickListener(new d(this));
            textView5.setVisibility(0);
            textView5.setText(str2);
            textView4.setVisibility(8);
        } else if (miningDetailBean.getBtnStatus() == 2) {
            textView6.setVisibility(8);
            textView7.setVisibility(0);
            textView5.setVisibility(0);
            textView5.setText(str2);
            textView4.setVisibility(8);
        } else if (miningDetailBean.getBtnStatus() == 3) {
            textView3.setVisibility(8);
            textView5.setVisibility(8);
            textView5.setText("");
            linearLayout.setVisibility(8);
        }
        this.f80703h.addView(inflate);
        this.f80705j.setVisibility(8);
        this.f80712q.setVisibility(0);
        Zh(miningDetailBean.getFixedToActiveAutoStatus());
        this.f80715t.setOnClickListener(new q(this));
        this.f80717v.setOnClickListener(new c(this));
        this.f80716u.setOnClickListener(new xq.p(this));
        this.f80714s.setVisibility(miningDetailBean.isPeProject() ? 8 : 0);
        LinearLayout linearLayout2 = this.f80713r;
        if (miningDetailBean.isShowFix2Active()) {
            i11 = 0;
        }
        linearLayout2.setVisibility(i11);
        findViewById(R.id.view_line2).setVisibility(0);
        this.f80700e.setVisibility(0);
        this.f80700e.setMinTextSize(getResources().getDimension(R.dimen.global_text_size_14));
        this.f80700e.setButtonText(getResources().getString(R.string.n_asset_early_withdraw));
        this.f80698c = true;
        this.f80704i.setChecked(miningDetailBean.isFixedToActiveAutoStatusOpen());
        findViewById(R.id.time_line).setVisibility(0);
        ((TextView) findViewById(R.id.tv_start_time)).setText(DateTimeUtils.h(miningDetailBean.getMiningStartTime(), "yyyy-MM-dd"));
        ((TextView) findViewById(R.id.tv_work_time)).setText(DateTimeUtils.h(miningDetailBean.getEffectTime(), "yyyy-MM-dd"));
        ((TextView) findViewById(R.id.tv_end_time)).setText(DateTimeUtils.h(miningDetailBean.getMiningEndTime(), "yyyy-MM-dd"));
        ((TextView) findViewById(R.id.tv_refund_time)).setText(DateTimeUtils.h(miningDetailBean.getIncomeTime(), "yyyy-MM-dd"));
        if (miningDetailBean.isRedeem() && !miningDetailBean.isStEth() && (miningDetailBean.isRedeem() || !miningDetailBean.isStEth())) {
            z11 = true;
        }
        ViewUtil.m(this.f80700e, z11);
    }

    public final void ei(MiningDetailBean miningDetailBean) {
        TextView textView = this.f80702g;
        textView.setText(p.i(miningDetailBean.getMiningAmount(), this.f80697b) + " " + this.f80719x);
    }

    public int getContentView() {
        return R.layout.activity_mining_active_detail_layout;
    }

    public void ib(boolean z11, int i11) {
        if (z11) {
            Zh(i11);
        }
    }

    public void initView() {
        this.f80699d = findViewById(R.id.backBtn);
        this.f80700e = (StatusButton) findViewById(R.id.redeemBtn);
        this.f80701f = (StatusButton) findViewById(R.id.goMiningBtn);
        this.f80702g = (TextView) findViewById(R.id.amountText);
        this.f80703h = (LinearLayout) findViewById(R.id.contentLayout);
        this.f80704i = (CommonSwitchButton) findViewById(R.id.switchButton);
        this.f80705j = (RelativeLayout) findViewById(R.id.rlAutoMoneyMgr);
        this.f80706k = (TextView) findViewById(R.id.autoMiningLabel);
        this.f80707l = findViewById(R.id.askIcon);
        this.f80710o = (LoadingLayout) findViewById(R.id.loadingLayout);
        this.f80711p = findViewById(R.id.autoMiningTipsLayout);
        this.f80708m = (ImageView) findViewById(R.id.askYbbIcon);
        this.f80709n = (ImageView) findViewById(R.id.askContinueIcon);
        this.f80712q = (LinearLayout) findViewById(R.id.ll_redemption_way);
        this.f80713r = (LinearLayout) findViewById(R.id.ll_auto_ybb);
        this.f80714s = (LinearLayout) findViewById(R.id.ll_auto_continue);
        this.f80715t = (TextView) findViewById(R.id.tv_auto_ybb);
        this.f80716u = (TextView) findViewById(R.id.tv_auto_spot);
        this.f80717v = (TextView) findViewById(R.id.tv_auto_continue);
    }

    public void ne(MiningDetailBean miningDetailBean) {
        if (miningDetailBean != null) {
            this.f80703h.removeAllViews();
            this.f80718w = miningDetailBean;
            if (miningDetailBean.getCurrency() != null) {
                this.f80719x = d7.k.C().z(this.f80718w.getCurrency());
                this.f80697b = d7.k.C().p(this.f80718w.getCurrency());
            }
            ei(miningDetailBean);
            if (miningDetailBean.getShelfType() == 2 || miningDetailBean.getShelfType() == 4 || miningDetailBean.getShelfType() == 1 || miningDetailBean.getShelfType() == 6) {
                di(miningDetailBean);
            } else {
                ci(miningDetailBean);
            }
            this.f80710o.setVisibility(8);
            return;
        }
        this.f80710o.k();
    }

    public void onResume() {
        super.onResume();
        this.f80720y = SystemClock.elapsedRealtime();
    }

    public void onStop() {
        super.onStop();
        bi();
    }

    public void ue(boolean z11) {
        if (z11) {
            CommonSwitchButton commonSwitchButton = this.f80704i;
            commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f80721a;

        /* renamed from: b  reason: collision with root package name */
        public String f80722b;

        /* renamed from: c  reason: collision with root package name */
        public List<MiningDetailBean.TieredRate> f80723c;

        /* renamed from: d  reason: collision with root package name */
        public String f80724d;

        /* renamed from: e  reason: collision with root package name */
        public String f80725e;

        /* renamed from: f  reason: collision with root package name */
        public String f80726f;

        /* renamed from: g  reason: collision with root package name */
        public String f80727g;

        public a(String str, String str2) {
            this.f80721a = str;
            this.f80722b = str2;
        }

        public View a() {
            return null;
        }

        public void b(String str) {
            this.f80726f = str;
        }

        public a(String str, String str2, String str3) {
            this.f80721a = str;
            this.f80722b = str2;
            this.f80727g = str3;
        }

        public a(String str, String str2, List<MiningDetailBean.TieredRate> list, String str3) {
            this.f80721a = str;
            this.f80722b = str2;
            this.f80723c = list;
            this.f80725e = str3;
        }

        public a(String str, String str2, List<MiningDetailBean.TieredRate> list, String str3, String str4) {
            this.f80721a = str;
            this.f80722b = str2;
            this.f80723c = list;
            this.f80724d = str3;
            this.f80725e = str4;
        }
    }
}
