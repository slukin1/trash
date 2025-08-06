package com.huobi.feature.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.view.DatePickerDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Calendar;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pk.c;
import pk.d;
import pro.huobi.R;

public class ContractCalmPeriodActivity extends EmptyMVPActivity implements View.OnClickListener {
    public ContractCalmPeriodHelper A;

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f44649b;

    /* renamed from: c  reason: collision with root package name */
    public View f44650c;

    /* renamed from: d  reason: collision with root package name */
    public View f44651d;

    /* renamed from: e  reason: collision with root package name */
    public View f44652e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f44653f;

    /* renamed from: g  reason: collision with root package name */
    public View f44654g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f44655h;

    /* renamed from: i  reason: collision with root package name */
    public View f44656i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f44657j;

    /* renamed from: k  reason: collision with root package name */
    public View f44658k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f44659l;

    /* renamed from: m  reason: collision with root package name */
    public View f44660m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f44661n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f44662o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f44663p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f44664q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f44665r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f44666s;

    /* renamed from: t  reason: collision with root package name */
    public int f44667t = 0;

    /* renamed from: u  reason: collision with root package name */
    public final int f44668u = 1;

    /* renamed from: v  reason: collision with root package name */
    public final int f44669v = 2;

    /* renamed from: w  reason: collision with root package name */
    public final int f44670w = 4;

    /* renamed from: x  reason: collision with root package name */
    public final int f44671x = 8;

    /* renamed from: y  reason: collision with root package name */
    public long f44672y;

    /* renamed from: z  reason: collision with root package name */
    public long f44673z;

    public class a implements DatePickerDialog.ResultListener {
        public a() {
        }

        public void onCancel() {
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            ContractCalmPeriodActivity.this.qh(datePickerDialog, j11);
        }
    }

    public class b extends EasySubscriber<Void> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Void voidR) {
            super.onNext(voidR);
            ContractCalmPeriodHelper.f45059g = SystemClock.elapsedRealtime();
            ContractCalmPeriodActivity.this.finish();
        }

        public void onAfter() {
            super.onAfter();
            ContractCalmPeriodActivity.this.dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            ContractCalmPeriodActivity.this.showProgressDialog((String) null);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qg(View view) {
        this.f44649b.p();
        this.A.i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        new DatePickerDialog.Builder().setInitDate(this.f44673z).setTitle(R.string.n_asset_apply_end_time).setResultListener(new a()).show(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ph(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        rh();
    }

    public void Og(int i11, ImageView imageView) {
        boolean z11 = true;
        if (this.f44667t != i11) {
            this.f44653f.setImageResource(R.drawable.contract_calm_period_unselect);
            this.f44655h.setImageResource(R.drawable.contract_calm_period_unselect);
            this.f44657j.setImageResource(R.drawable.contract_calm_period_unselect);
            this.f44659l.setImageResource(R.drawable.contract_calm_period_unselect);
            imageView.setImageResource(R.drawable.contract_calm_period_select);
            this.f44667t = i11;
            sh(true);
        } else {
            imageView.setImageResource(R.drawable.contract_calm_period_unselect);
            this.f44667t = 0;
        }
        if (this.f44667t == 8) {
            this.f44660m.setVisibility(0);
        } else {
            this.f44660m.setVisibility(8);
        }
        TextView textView = this.f44663p;
        if (this.f44667t == 0) {
            z11 = false;
        }
        textView.setEnabled(z11);
    }

    public final void Pg() {
        sh(false);
        new DialogUtils.b.d(this).c1(getString(R.string.n_contract_calm_period_confirm_title)).C0(String.format(Locale.US, getResources().getString(R.string.n_contract_calm_period_confirm_content), new Object[]{this.f44661n.getText(), this.f44662o.getText()})).P0(getString(R.string.n_confirm)).s0(getString(R.string.n_cancel)).S0(Integer.valueOf(getResources().getColor(R.color.kColorPrimaryText))).q0(true).N0(d.f53067a).Q0(new c(this)).j0().show(getSupportFragmentManager(), "");
    }

    public void addEvent() {
        this.f44652e.setOnClickListener(this);
        this.f44654g.setOnClickListener(this);
        this.f44656i.setOnClickListener(this);
        this.f44658k.setOnClickListener(this);
        this.f44663p.setOnClickListener(this);
        this.f44662o.setOnClickListener(new pk.b(this));
        this.f44649b.setOnRetryClickListener(new pk.a(this));
        ContractCalmPeriodInfo contractCalmPeriodInfo = ContractCalmPeriodHelper.f45058f;
        if (contractCalmPeriodInfo != null) {
            onContractCalmPeriodInfoChange(contractCalmPeriodInfo);
        } else {
            this.f44649b.p();
        }
    }

    public int getContentView() {
        return R.layout.activity_contract_calm_period;
    }

    public void initView() {
        this.f44649b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f44650c = this.viewFinder.b(R.id.calm_period_opened_parent);
        this.f44651d = this.viewFinder.b(R.id.calm_period_to_open_parent);
        this.f44652e = this.viewFinder.b(R.id.rl_period_one_day);
        this.f44653f = (ImageView) this.viewFinder.b(R.id.iv_period_one_day);
        this.f44654g = this.viewFinder.b(R.id.rl_period_seven_day);
        this.f44655h = (ImageView) this.viewFinder.b(R.id.iv_period_seven_day);
        this.f44656i = this.viewFinder.b(R.id.rl_period_thirty_day);
        this.f44657j = (ImageView) this.viewFinder.b(R.id.iv_period_thirty_day);
        this.f44658k = this.viewFinder.b(R.id.rl_period_diy);
        this.f44659l = (ImageView) this.viewFinder.b(R.id.iv_period_diy);
        this.f44660m = this.viewFinder.b(R.id.ll_period_diy_expand);
        this.f44661n = (TextView) this.viewFinder.b(R.id.tv_period_diy_start);
        this.f44662o = (TextView) this.viewFinder.b(R.id.tv_period_diy_end);
        this.f44663p = (TextView) this.viewFinder.b(R.id.tv_open);
        this.f44664q = (TextView) this.viewFinder.b(R.id.calm_period_opened_starttime);
        this.f44665r = (TextView) this.viewFinder.b(R.id.calm_period_opened_endtime);
        this.f44666s = (TextView) this.viewFinder.b(R.id.calm_period_opened_tips);
        EventBus.d().p(this);
    }

    @SuppressLint({"StringFormatMatches"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view == this.f44652e) {
            Og(1, this.f44653f);
        } else if (view == this.f44654g) {
            Og(2, this.f44655h);
        } else if (view == this.f44656i) {
            Og(4, this.f44657j);
        } else if (view == this.f44658k) {
            Og(8, this.f44659l);
        } else if (view == this.f44663p) {
            Pg();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCalmPeriodInfoChange(ContractCalmPeriodInfo contractCalmPeriodInfo) {
        if (contractCalmPeriodInfo == null || contractCalmPeriodInfo.status == -1) {
            this.f44649b.k();
            return;
        }
        if (contractCalmPeriodInfo.isOff()) {
            this.f44650c.setVisibility(0);
            this.f44651d.setVisibility(8);
            this.f44666s.setText(String.format(Locale.US, getResources().getString(R.string.n_contract_calm_period_already_open), new Object[]{DateTimeUtils.k(contractCalmPeriodInfo.getCoolingOffEndTime())}));
            this.f44664q.setText(DateTimeUtils.k(contractCalmPeriodInfo.getCoolingOffBeginTime()));
            this.f44665r.setText(DateTimeUtils.k(contractCalmPeriodInfo.getCoolingOffEndTime()));
        } else {
            this.f44650c.setVisibility(8);
            this.f44651d.setVisibility(0);
        }
        this.f44649b.g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A = new ContractCalmPeriodHelper();
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onPause() {
        super.onPause();
        this.A.j();
    }

    public void onResume() {
        super.onResume();
        this.A.i();
    }

    public final void qh(DatePickerDialog datePickerDialog, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j11);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        if (instance.getTimeInMillis() <= currentTimeMillis) {
            HuobiToastUtil.j(R.string.n_order_filter_end_time_error_tip);
            return;
        }
        datePickerDialog.dismiss();
        long timeInMillis = instance.getTimeInMillis();
        this.f44673z = timeInMillis;
        this.f44662o.setText(DateTimeUtils.k(timeInMillis));
    }

    public final void rh() {
        q7.a.a().M(this.f44672y, this.f44673z).b().compose(RxJavaHelper.t(getUI())).subscribe(new b());
    }

    public final void sh(boolean z11) {
        int i11 = this.f44667t;
        if (i11 == 1) {
            th(0);
        } else if (i11 == 2) {
            th(6);
        } else if (i11 == 4) {
            th(29);
        }
        if (z11 && this.f44667t == 8) {
            th(0);
        }
    }

    public final void th(int i11) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        this.f44672y = timeInMillis;
        this.f44661n.setText(DateTimeUtils.k(timeInMillis));
        instance.add(5, i11);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        long timeInMillis2 = instance.getTimeInMillis();
        this.f44673z = timeInMillis2;
        this.f44662o.setText(DateTimeUtils.k(timeInMillis2));
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
