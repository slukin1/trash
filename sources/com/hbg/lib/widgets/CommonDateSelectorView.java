package com.hbg.lib.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.bean.CommonDateSelectorItemBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.view.DatePickerDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CommonDateSelectorView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public long f71083b;

    /* renamed from: c  reason: collision with root package name */
    public CommonDateSelectorItemBean.a f71084c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71085d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71086e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f71087f;

    /* renamed from: g  reason: collision with root package name */
    public EasyRecyclerView<CommonDateSelectorItemBean> f71088g;

    /* renamed from: h  reason: collision with root package name */
    public final List<CommonDateSelectorItemBean> f71089h;

    /* renamed from: i  reason: collision with root package name */
    public int f71090i;

    /* renamed from: j  reason: collision with root package name */
    public int f71091j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f71092k;

    /* renamed from: l  reason: collision with root package name */
    public long f71093l;

    /* renamed from: m  reason: collision with root package name */
    public long f71094m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f71095n;

    public class a implements CommonDateSelectorItemBean.a {
        public a() {
        }

        public void a(CommonDateSelectorItemBean commonDateSelectorItemBean) {
            int unused = CommonDateSelectorView.this.f71090i = commonDateSelectorItemBean.c();
            CommonDateSelectorView.this.f71088g.c();
            CommonDateSelectorView.this.C(commonDateSelectorItemBean.a());
        }

        public boolean b(CommonDateSelectorItemBean commonDateSelectorItemBean) {
            return CommonDateSelectorView.this.f71090i == commonDateSelectorItemBean.c();
        }
    }

    public class b implements DatePickerDialog.ResultListener {
        public b() {
        }

        public void onCancel() {
            CommonDateSelectorView commonDateSelectorView = CommonDateSelectorView.this;
            commonDateSelectorView.p(commonDateSelectorView.f71086e, false);
            CommonDateSelectorView commonDateSelectorView2 = CommonDateSelectorView.this;
            commonDateSelectorView2.p(commonDateSelectorView2.f71087f, false);
            CommonDateSelectorView commonDateSelectorView3 = CommonDateSelectorView.this;
            commonDateSelectorView3.A(commonDateSelectorView3.f71086e, true);
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            CommonDateSelectorView.this.x(datePickerDialog, j11);
            CommonDateSelectorView commonDateSelectorView = CommonDateSelectorView.this;
            commonDateSelectorView.A(commonDateSelectorView.f71086e, true);
        }
    }

    public class c implements DatePickerDialog.ResultListener {
        public c() {
        }

        public void onCancel() {
            CommonDateSelectorView commonDateSelectorView = CommonDateSelectorView.this;
            commonDateSelectorView.p(commonDateSelectorView.f71086e, false);
            CommonDateSelectorView commonDateSelectorView2 = CommonDateSelectorView.this;
            commonDateSelectorView2.p(commonDateSelectorView2.f71087f, false);
            CommonDateSelectorView commonDateSelectorView3 = CommonDateSelectorView.this;
            commonDateSelectorView3.A(commonDateSelectorView3.f71087f, true);
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            CommonDateSelectorView.this.w(datePickerDialog, j11);
            CommonDateSelectorView commonDateSelectorView = CommonDateSelectorView.this;
            commonDateSelectorView.A(commonDateSelectorView.f71087f, true);
        }
    }

    public CommonDateSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static String q(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        p(this.f71086e, true);
        p(this.f71087f, false);
        A(this.f71086e, false);
        long j11 = this.f71093l;
        if (j11 == 0) {
            j11 = Calendar.getInstance().getTimeInMillis() - Period.DAY_MILLS;
        }
        new DatePickerDialog.Builder().setInitDate(j11).setMinDate(this.f71083b).setTitle(R$string.n_order_filter_start_time).setResultListener(new b()).show(getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        p(this.f71086e, false);
        p(this.f71087f, true);
        A(this.f71087f, false);
        long j11 = this.f71094m;
        if (j11 == 0) {
            j11 = Calendar.getInstance().getTimeInMillis() - Period.DAY_MILLS;
        }
        new DatePickerDialog.Builder().setInitDate(j11).setMinDate(this.f71083b).setTitle(R$string.n_order_filter_end_time).setResultListener(new c()).show(getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void A(TextView textView, boolean z11) {
    }

    public final void B() {
        this.f71086e.setText(q(this.f71093l));
        this.f71087f.setText(q(this.f71094m));
    }

    public final void C(int i11) {
        setDateDay(i11);
        o();
        p(this.f71086e, false);
        p(this.f71087f, false);
    }

    public boolean getDateEnable() {
        return this.f71095n.getVisibility() == 8;
    }

    public long getEndDate() {
        return this.f71094m;
    }

    public long getStartDate() {
        return this.f71093l;
    }

    public final void m() {
        this.f71086e.setOnClickListener(new m(this));
        this.f71087f.setOnClickListener(new n(this));
    }

    public final void n() {
        p(this.f71086e, false);
        p(this.f71087f, false);
    }

    public final void o() {
        if ((this.f71094m - this.f71093l) / Period.DAY_MILLS >= 365) {
            this.f71095n.setVisibility(0);
        } else {
            this.f71095n.setVisibility(8);
        }
        View.OnClickListener onClickListener = this.f71092k;
        if (onClickListener != null) {
            onClickListener.onClick((View) null);
        }
    }

    public final void p(TextView textView, boolean z11) {
    }

    public final void r() {
        s();
        m();
        setClickable(true);
        y();
    }

    @SuppressLint({"SetTextI18n"})
    public final void s() {
        this.f71088g = (EasyRecyclerView) findViewById(R$id.common_date_selector_tab_recycler);
        this.f71085d = (TextView) findViewById(R$id.id_id_trade_order_more_filter_time_title);
        this.f71086e = (TextView) findViewById(R$id.id_trade_order_more_filter_et1);
        this.f71087f = (TextView) findViewById(R$id.id_trade_order_more_filter_et2);
        this.f71095n = (TextView) findViewById(R$id.tv_tips);
        this.f71088g.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f71088g.addItemDecoration(new oa.b(getContext()));
    }

    public void setCurrentSelectorTabId(int i11) {
        this.f71090i = i11;
        this.f71088g.c();
    }

    public void setDateDay(int i11) {
        Calendar instance = Calendar.getInstance();
        int i12 = this.f71091j;
        if (i12 != 0) {
            instance.add(5, i12);
        }
        this.f71094m = instance.getTimeInMillis();
        instance.add(5, (-i11) + 1);
        this.f71093l = instance.getTimeInMillis();
        B();
    }

    public void setEndTime(long j11) {
        this.f71094m = j11;
        this.f71087f.setText(q(j11));
    }

    public void setEndTimeOffsetDay(int i11) {
        this.f71091j = i11;
    }

    public void setMaxDayTimeInMillis(long j11) {
        this.f71083b = j11;
    }

    public void setOnStatusChangeListener(View.OnClickListener onClickListener) {
        this.f71092k = onClickListener;
    }

    public void setStartTime(long j11) {
        this.f71093l = j11;
        this.f71086e.setText(q(j11));
    }

    public void setTabItemData(List<CommonDateSelectorItemBean> list) {
        z(list, -1);
    }

    public void setTitle(String str) {
        this.f71085d.setText(str);
    }

    public final boolean t(long j11, long j12) {
        return j11 < j12 && !q(j11).equals(q(j12));
    }

    public final void w(DatePickerDialog datePickerDialog, long j11) {
        n();
        if (t(System.currentTimeMillis(), j11)) {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_error_tip);
        } else if (t(j11, this.f71093l)) {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_early_tip);
        } else {
            long j12 = this.f71083b;
            if (j12 == 0 || !t(j11, j12)) {
                datePickerDialog.dismiss();
                this.f71094m = j11;
                this.f71087f.setText(q(j11));
                o();
                return;
            }
            HuobiToastUtil.j(R$string.n_asset_before_earliest_time_tip);
        }
    }

    public final void x(DatePickerDialog datePickerDialog, long j11) {
        n();
        if (t(System.currentTimeMillis(), j11)) {
            HuobiToastUtil.j(R$string.n_order_filter_start_time_error_tip);
        } else if (!t(this.f71094m, j11) || this.f71094m <= 0) {
            long j12 = this.f71083b;
            if (j12 == 0 || !t(j11, j12)) {
                datePickerDialog.dismiss();
                this.f71093l = j11;
                this.f71086e.setText(q(j11));
                o();
                return;
            }
            HuobiToastUtil.j(R$string.n_asset_before_earliest_time_tip);
        } else {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_early_tip);
        }
    }

    public void y() {
        p(this.f71086e, false);
        p(this.f71087f, false);
        if (!this.f71089h.isEmpty()) {
            this.f71090i = this.f71089h.get(0).c();
        }
        this.f71088g.c();
    }

    public void z(List<CommonDateSelectorItemBean> list, int i11) {
        this.f71090i = i11;
        if (list != null && !list.isEmpty()) {
            this.f71089h.clear();
            this.f71089h.addAll(list);
            for (int i12 = 0; i12 < this.f71089h.size(); i12++) {
                CommonDateSelectorItemBean commonDateSelectorItemBean = this.f71089h.get(i12);
                commonDateSelectorItemBean.g(this.f71084c);
                if (i11 == commonDateSelectorItemBean.c()) {
                    C(commonDateSelectorItemBean.a());
                }
            }
            this.f71088g.setData(this.f71089h);
        }
    }

    public CommonDateSelectorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71083b = 0;
        this.f71084c = new a();
        this.f71089h = new ArrayList();
        this.f71091j = 0;
        FrameLayout.inflate(context, R$layout.layout_common_date_selector_view, this);
        r();
    }
}
