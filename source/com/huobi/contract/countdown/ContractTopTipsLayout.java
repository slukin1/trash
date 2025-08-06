package com.huobi.contract.countdown;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.contract.entity.FuturesActivityInfo;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import pro.huobi.R;
import yi.e;
import yi.f;
import yi.g;

public class ContractTopTipsLayout extends FrameLayout implements it.a {

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, Set<String>> f43043j = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public TextView f43044b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f43045c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f43046d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f43047e;

    /* renamed from: f  reason: collision with root package name */
    public ContractCountDownLayout f43048f;

    /* renamed from: g  reason: collision with root package name */
    public FuturesActivityInfo f43049g;

    /* renamed from: h  reason: collision with root package name */
    public String f43050h;

    /* renamed from: i  reason: collision with root package name */
    public a f43051i;

    public interface a {
        void a(boolean z11);

        void b();
    }

    public ContractTopTipsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        Set set = f43043j.get(this.f43050h);
        if (set == null) {
            set = new HashSet();
        }
        set.add(String.valueOf(this.f43049g.getStatus()));
        f43043j.put(this.f43050h, set);
        e();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(int i11, long j11, long[] jArr) {
        d.b("ContractTopTipsLayout-->onLoop--> type = " + i11 + " timeArray = " + jArr);
    }

    public void c(int i11) {
        if (i11 == 1) {
            this.f43049g.setStatus(2);
            FuturesActivityInfo futuresActivityInfo = this.f43049g;
            futuresActivityInfo.setCurrentTime(futuresActivityInfo.getStartTime() + 1);
        } else {
            this.f43049g.setStatus(3);
            FuturesActivityInfo futuresActivityInfo2 = this.f43049g;
            futuresActivityInfo2.setCurrentTime(futuresActivityInfo2.getEndTime() + 1);
        }
        j(this.f43049g, this.f43050h);
        a aVar = this.f43051i;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void e() {
        ViewUtil.m(this, false);
        a aVar = this.f43051i;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public boolean f() {
        boolean z11;
        String str = this.f43050h;
        if (str != null) {
            Set set = f43043j.get(str);
            z11 = set != null ? set.contains(String.valueOf(this.f43049g.getStatus())) : false;
        } else {
            z11 = true;
        }
        FuturesActivityInfo futuresActivityInfo = this.f43049g;
        if (futuresActivityInfo == null || futuresActivityInfo.getStatus() == 3 || z11) {
            return true;
        }
        return false;
    }

    public void i() {
        if (this.f43049g != null) {
            ContractWebActivity.Sh((Activity) getContext(), this.f43049g.getUrl());
        }
    }

    public void j(FuturesActivityInfo futuresActivityInfo, String str) {
        this.f43049g = futuresActivityInfo;
        this.f43050h = str;
        if (f()) {
            ViewUtil.m(this, false);
            this.f43048f.setCountDownCallback((it.a) null);
            a aVar = this.f43051i;
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        this.f43048f.setValid(true);
        long l11 = l();
        ViewUtil.m(this, true);
        this.f43048f.setCountDownCallback(this);
        e.k().u(this.f43049g.getStatus(), l11);
        a aVar2 = this.f43051i;
        if (aVar2 != null) {
            aVar2.a(true);
        }
    }

    public void k(boolean z11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f43046d.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f43047e.getLayoutParams();
        if (z11) {
            layoutParams.f7942h = R.id.id_contract_count_down_view;
            layoutParams.f7948k = R.id.id_contract_count_down_view;
            layoutParams2.f7942h = R.id.id_contract_count_down_view;
            layoutParams2.f7948k = R.id.id_contract_count_down_view;
            this.f43046d.setLayoutParams(layoutParams);
            this.f43047e.setLayoutParams(layoutParams2);
            return;
        }
        layoutParams.f7942h = 0;
        layoutParams.f7948k = 0;
        layoutParams2.f7942h = 0;
        layoutParams2.f7948k = 0;
        this.f43046d.setLayoutParams(layoutParams);
        this.f43047e.setLayoutParams(layoutParams2);
    }

    public long l() {
        long j11;
        long j12;
        if (this.f43049g.getStatus() != 1) {
            ViewUtil.m(this.f43044b, false);
            ViewUtil.m(this.f43045c, true);
            this.f43045c.setText(String.format(Locale.US, getResources().getString(R.string.n_future_trade_contest_tips_title2), new Object[]{this.f43049g.getActivityId(), this.f43049g.getTitle()}));
            ViewUtil.m(this.f43048f, false);
            k(false);
            j12 = this.f43049g.getEndTime();
            j11 = this.f43049g.getCurrentTime();
        } else {
            ViewUtil.m(this.f43044b, true);
            ViewUtil.m(this.f43045c, false);
            this.f43044b.setText(String.format(Locale.US, getResources().getString(R.string.n_future_trade_contest_tips_title), new Object[]{this.f43049g.getActivityId(), this.f43049g.getTitle()}));
            ViewUtil.m(this.f43048f, true);
            k(true);
            j12 = this.f43049g.getStartTime();
            j11 = this.f43049g.getCurrentTime();
        }
        return j12 - j11;
    }

    public void setCallback(a aVar) {
        this.f43051i = aVar;
    }

    public ContractTopTipsLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R.layout.layout_contract_count_down, this);
        this.f43044b = (TextView) findViewById(R.id.id_contract_count_down_title_pre);
        this.f43045c = (TextView) findViewById(R.id.id_contract_count_down_title_in);
        this.f43048f = (ContractCountDownLayout) findViewById(R.id.id_contract_count_down_view);
        TextView textView = (TextView) findViewById(R.id.id_prime_detail_btn);
        this.f43046d = textView;
        textView.setOnClickListener(new f(this));
        ImageView imageView = (ImageView) findViewById(R.id.id_contract_count_down_close);
        this.f43047e = imageView;
        imageView.setOnClickListener(new g(this));
    }
}
