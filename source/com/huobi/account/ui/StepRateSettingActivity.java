package com.huobi.account.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import bj.o0;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.UserRateInfoAvailableCollection;
import com.huobi.account.presenter.StepRateSettingPresenter;
import com.huobi.account.ui.StepRateItemCardView;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;

@Deprecated
public class StepRateSettingActivity extends BaseActivity<StepRateSettingPresenter, StepRateSettingPresenter.b> implements StepRateSettingPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f41565b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41566c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41567d;

    /* renamed from: e  reason: collision with root package name */
    public SwitchCompat f41568e;

    /* renamed from: f  reason: collision with root package name */
    public SwitchCompat f41569f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f41570g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f41571h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f41572i;

    /* renamed from: j  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f41573j = new a();

    /* renamed from: k  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f41574k = new b();

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(boolean z11, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            ((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).h0(2, z11, true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(boolean z11, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            ((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).h0(2, z11, true);
        }

        @SensorsDataInstrumented
        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (z11) {
                new DialogUtils.b.d(StepRateSettingActivity.this).c1(StepRateSettingActivity.this.getString(R.string.step_rate_swith_ht_on_title)).C0(StepRateSettingActivity.this.getString(R.string.n_step_rate_ht_switch_on_hint)).R0("").T0(true).P0(StepRateSettingActivity.this.getString(R.string.string_confirm)).s0(StepRateSettingActivity.this.getString(R.string.string_cancel)).Q0(new r5(this, z11)).N0(o0.f12469a).k0().show(StepRateSettingActivity.this.getSupportFragmentManager(), "");
            } else {
                StepRateSettingActivity stepRateSettingActivity = StepRateSettingActivity.this;
                DialogUtils.b0(stepRateSettingActivity, stepRateSettingActivity.getString(R.string.step_rate_swith_ht_off_title), StepRateSettingActivity.this.getString(R.string.step_rate_ht_switch_off_hint), "", StepRateSettingActivity.this.getString(R.string.string_cancel), StepRateSettingActivity.this.getString(R.string.string_confirm), s5.f41812a, new q5(this, z11));
            }
            StepRateSettingActivity.this.qb(!z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(boolean z11, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            ((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).h0(1, z11, false);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(boolean z11, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            ((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).h0(2, z11, false);
        }

        @SensorsDataInstrumented
        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (!z11) {
                StepRateSettingActivity stepRateSettingActivity = StepRateSettingActivity.this;
                String string = stepRateSettingActivity.getString(R.string.step_rate_swith_point_off_title);
                DialogUtils.b0(stepRateSettingActivity, string, StepRateSettingActivity.this.getString(R.string.step_rate_ht_switch_off_hint), "", StepRateSettingActivity.this.getString(R.string.string_cancel), StepRateSettingActivity.this.getString(R.string.string_confirm), w5.f41845a, new t5(this, z11));
            } else if (((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).Y() == null || m.a(((StepRateSettingPresenter) StepRateSettingActivity.this.getPresenter()).X()).compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R.string.step_rate_point_no_enough_switch_on_hint);
            } else {
                StepRateSettingActivity stepRateSettingActivity2 = StepRateSettingActivity.this;
                DialogUtils.b0(stepRateSettingActivity2, stepRateSettingActivity2.getString(R.string.step_rate_swith_point_on_title), StepRateSettingActivity.this.getString(R.string.step_rate_point_switch_on_hint), "", StepRateSettingActivity.this.getString(R.string.string_cancel), StepRateSettingActivity.this.getString(R.string.string_confirm), v5.f41836a, new u5(this, z11));
            }
            StepRateSettingActivity.this.ed(!z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(Void voidR) {
        DialogUtils.X(this, getString(R.string.my_points_description), getString(R.string.step_rate_title_help), (String) null, getString(R.string.allow_access_dialog_positive_btn), o0.f12469a);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void th(View view) {
        String u11 = a1.v().u("ht", false);
        if (!TextUtils.isEmpty(u11)) {
            k0.O(this, u11, true);
            finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        dw.a.a(this.viewFinder.b(R.id.iv_title_help)).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new p5(this));
        this.f41568e.setOnCheckedChangeListener(this.f41573j);
        this.f41569f.setOnCheckedChangeListener(this.f41574k);
        this.f41567d.setOnClickListener(new o5(this));
    }

    public void ed(boolean z11) {
        this.f41569f.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41569f.setChecked(z11);
        this.f41569f.setOnCheckedChangeListener(this.f41574k);
    }

    public int getContentView() {
        return R.layout.activity_step_rate_setting;
    }

    public void initView() {
        setStatusBarColor(getResources().getColor(R.color.balance_exchange));
        this.f41567d = (TextView) this.viewFinder.b(R.id.get_available_tv);
        this.f41566c = (TextView) this.viewFinder.b(R.id.available_not_enough_tv);
        this.f41565b = (RelativeLayout) this.viewFinder.b(R.id.available_not_enough_rl);
        this.f41568e = (SwitchCompat) this.viewFinder.b(R.id.deduction_currency_switch);
        this.f41569f = (SwitchCompat) this.viewFinder.b(R.id.deduction_point_switch);
        this.f41570g = (RelativeLayout) this.viewFinder.b(R.id.deduction_currency_switch_rl);
        this.f41571h = (RelativeLayout) this.viewFinder.b(R.id.deduction_point_switch_rl);
        this.f41572i = (LinearLayout) this.viewFinder.b(R.id.ll_rate_card_list);
        setToolBar((Toolbar) this.viewFinder.b(R.id.step_rate_setting_toolbar), getString(R.string.step_rate_setting_title), true);
    }

    /* renamed from: oh */
    public StepRateSettingPresenter createPresenter() {
        return new StepRateSettingPresenter();
    }

    /* renamed from: ph */
    public StepRateSettingPresenter.b getUI() {
        return this;
    }

    public void qb(boolean z11) {
        this.f41568e.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41568e.setChecked(z11);
        this.f41568e.setOnCheckedChangeListener(this.f41573j);
    }

    public final boolean qh(UserStepRateInfo userStepRateInfo) {
        if (!"ht".equalsIgnoreCase(userStepRateInfo.getCurrency()) || 1 != userStepRateInfo.getDeductionSwitch()) {
            return false;
        }
        return true;
    }

    public void r7(UserRateInfoAvailableCollection userRateInfoAvailableCollection) {
        vh(userRateInfoAvailableCollection);
        UserStepRateInfo stepUserRateInfo = userRateInfoAvailableCollection.getStepUserRateInfo();
        if (stepUserRateInfo != null) {
            uh(stepUserRateInfo);
            xh(userRateInfoAvailableCollection);
            zh(0);
        }
    }

    public final boolean rh(UserStepRateInfo userStepRateInfo) {
        return userStepRateInfo.getPointSwitch() == 1;
    }

    public final void uh(UserStepRateInfo userStepRateInfo) {
        this.f41568e.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41568e.setChecked(qh(userStepRateInfo));
        this.f41568e.setOnCheckedChangeListener(this.f41573j);
        this.f41569f.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41569f.setChecked(rh(userStepRateInfo));
        this.f41569f.setOnCheckedChangeListener(this.f41574k);
    }

    public final void vh(UserRateInfoAvailableCollection userRateInfoAvailableCollection) {
        this.f41572i.removeAllViews();
        for (StepRateItemCardView.Data b11 : userRateInfoAvailableCollection.getCardDataList()) {
            StepRateItemCardView stepRateItemCardView = new StepRateItemCardView(this);
            stepRateItemCardView.b(b11);
            this.f41572i.addView(stepRateItemCardView);
        }
    }

    public final void wh(String str) {
        if (m.a(str).compareTo(BigDecimal.ONE) <= 0) {
            this.f41567d.setVisibility(0);
            this.f41565b.setVisibility(0);
            this.f41566c.setText(R.string.step_rate_available_not_enough_new);
            return;
        }
        this.f41565b.setVisibility(8);
    }

    public final void xh(UserRateInfoAvailableCollection userRateInfoAvailableCollection) {
        UserStepRateInfo stepUserRateInfo = userRateInfoAvailableCollection.getStepUserRateInfo();
        if (qh(stepUserRateInfo)) {
            wh(userRateInfoAvailableCollection.getAvailable());
        } else if (rh(stepUserRateInfo)) {
            yh(stepUserRateInfo);
        } else {
            this.f41565b.setVisibility(8);
        }
    }

    public final void yh(UserStepRateInfo userStepRateInfo) {
        if (m.a(((StepRateSettingPresenter) getPresenter()).X()).compareTo(BigDecimal.ONE) <= 0) {
            this.f41565b.setVisibility(0);
            this.f41566c.setText(R.string.step_rate_point_not_enough_new);
            this.f41567d.setVisibility(8);
            return;
        }
        this.f41565b.setVisibility(8);
    }

    public final void zh(int i11) {
        this.f41570g.setVisibility(i11);
        this.f41571h.setVisibility(i11);
    }
}
