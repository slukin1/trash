package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.view.DatePickerDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import oa.l;
import y9.a;

public class TradeOrderMoreFilterView extends FrameLayout {
    public a.C0825a A;

    /* renamed from: b  reason: collision with root package name */
    public View f71699b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71700c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71701d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71702e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f71703f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f71704g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f71705h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f71706i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f71707j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f71708k;

    /* renamed from: l  reason: collision with root package name */
    public View f71709l;

    /* renamed from: m  reason: collision with root package name */
    public View f71710m;

    /* renamed from: n  reason: collision with root package name */
    public EasyRecyclerView<y9.a> f71711n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f71712o;

    /* renamed from: p  reason: collision with root package name */
    public int f71713p;

    /* renamed from: q  reason: collision with root package name */
    public int f71714q;

    /* renamed from: r  reason: collision with root package name */
    public final List<y9.a> f71715r;

    /* renamed from: s  reason: collision with root package name */
    public int f71716s;

    /* renamed from: t  reason: collision with root package name */
    public int f71717t;

    /* renamed from: u  reason: collision with root package name */
    public AnimatorSet f71718u;

    /* renamed from: v  reason: collision with root package name */
    public AnimatorSet f71719v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f71720w;

    /* renamed from: x  reason: collision with root package name */
    public long f71721x;

    /* renamed from: y  reason: collision with root package name */
    public long f71722y;

    /* renamed from: z  reason: collision with root package name */
    public e f71723z;

    public class a implements DatePickerDialog.ResultListener {
        public a() {
        }

        public void onCancel() {
            TradeOrderMoreFilterView tradeOrderMoreFilterView = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView.z(tradeOrderMoreFilterView.f71700c, false);
            TradeOrderMoreFilterView tradeOrderMoreFilterView2 = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView2.z(tradeOrderMoreFilterView2.f71701d, false);
            TradeOrderMoreFilterView tradeOrderMoreFilterView3 = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView3.W(tradeOrderMoreFilterView3.f71700c, true);
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            TradeOrderMoreFilterView.this.T(datePickerDialog, j11);
            TradeOrderMoreFilterView tradeOrderMoreFilterView = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView.W(tradeOrderMoreFilterView.f71700c, true);
        }
    }

    public class b implements DatePickerDialog.ResultListener {
        public b() {
        }

        public void onCancel() {
            TradeOrderMoreFilterView tradeOrderMoreFilterView = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView.z(tradeOrderMoreFilterView.f71700c, false);
            TradeOrderMoreFilterView tradeOrderMoreFilterView2 = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView2.z(tradeOrderMoreFilterView2.f71701d, false);
            TradeOrderMoreFilterView tradeOrderMoreFilterView3 = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView3.W(tradeOrderMoreFilterView3.f71701d, true);
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            TradeOrderMoreFilterView.this.S(datePickerDialog, j11);
            TradeOrderMoreFilterView tradeOrderMoreFilterView = TradeOrderMoreFilterView.this;
            tradeOrderMoreFilterView.W(tradeOrderMoreFilterView.f71701d, true);
        }
    }

    public class c implements a.C0825a {
        public c() {
        }

        public void a(y9.a aVar) {
            int unused = TradeOrderMoreFilterView.this.f71716s = aVar.e();
            TradeOrderMoreFilterView.this.f71711n.c();
        }

        public boolean b(y9.a aVar) {
            return TradeOrderMoreFilterView.this.f71716s == aVar.e();
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        public void onAnimationEnd(Animator animator) {
            TradeOrderMoreFilterView.this.setVisibility(8);
            if (TradeOrderMoreFilterView.this.f71723z != null) {
                TradeOrderMoreFilterView.this.f71723z.onHide();
            }
        }
    }

    public interface e {
        void a(int i11, long j11, long j12, int i12, int i13);

        void onHide();

        void onShow();
    }

    public TradeOrderMoreFilterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static String A(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void G(View view) {
        B();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H(View view) {
        B();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void I(View view) {
        U();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void J(View view) {
        e eVar = this.f71723z;
        if (eVar != null) {
            eVar.a(this.f71713p, this.f71721x, this.f71722y, this.f71716s, this.f71714q);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void K(View view) {
        z(this.f71700c, true);
        z(this.f71701d, false);
        W(this.f71700c, false);
        new DatePickerDialog.Builder().setInitDate(this.f71721x).setTitle(R$string.n_order_filter_start_time).setResultListener(new a()).show(getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void L(View view) {
        z(this.f71700c, false);
        z(this.f71701d, true);
        W(this.f71701d, false);
        new DatePickerDialog.Builder().setInitDate(this.f71722y).setTitle(R$string.n_order_filter_end_time).setResultListener(new b()).show(getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void M(View view) {
        setDateType(1);
        z(this.f71700c, false);
        z(this.f71701d, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void N(View view) {
        setDateType(4);
        z(this.f71700c, false);
        z(this.f71701d, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void O(View view) {
        setDateType(3);
        z(this.f71700c, false);
        z(this.f71701d, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void P(View view) {
        setDirection(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Q(View view) {
        setDirection(2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void R(View view) {
        setDirection(3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void B() {
        this.f71720w = false;
        AnimatorSet animatorSet = this.f71719v;
        if (animatorSet == null || !animatorSet.isRunning()) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f71719v = animatorSet2;
            animatorSet2.setDuration(270);
            this.f71719v.setInterpolator(new DecelerateInterpolator());
            this.f71719v.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f71699b, FrameLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f71717t)}), ObjectAnimator.ofFloat(this.f71710m, FrameLayout.ALPHA, new float[]{0.2f, 0.0f})});
            this.f71719v.addListener(new d());
            this.f71719v.start();
        }
    }

    public final void C() {
        this.f71717t = getResources().getDimensionPixelOffset(R$dimen.dimen_388);
        D();
        this.f71711n.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.f71711n.addItemDecoration(new l(getContext()));
        w();
        setClickable(true);
        U();
    }

    public final void D() {
        this.f71699b = findViewById(R$id.id_trade_order_more_filter_content_parent);
        this.f71710m = findViewById(R$id.id_trade_order_more_filter_shape);
        this.f71700c = (TextView) findViewById(R$id.id_trade_order_more_filter_et1);
        this.f71701d = (TextView) findViewById(R$id.id_trade_order_more_filter_et2);
        this.f71702e = (TextView) findViewById(R$id.id_trade_order_more_filter_time1);
        this.f71704g = (TextView) findViewById(R$id.id_trade_order_more_filter_time2);
        this.f71703f = (TextView) findViewById(R$id.id_trade_order_more_filter_time3);
        this.f71705h = (TextView) findViewById(R$id.id_trade_order_more_filter_direction1);
        this.f71706i = (TextView) findViewById(R$id.id_trade_order_more_filter_direction2);
        this.f71707j = (TextView) findViewById(R$id.id_trade_order_more_filter_direction3);
        this.f71708k = (TextView) findViewById(R$id.id_trade_order_more_filter_bottom_reset);
        this.f71709l = findViewById(R$id.id_trade_order_more_filter_bottom_ok);
        this.f71711n = (EasyRecyclerView) findViewById(R$id.id_trade_order_more_filter_status_layout);
        this.f71712o = (TextView) findViewById(R$id.id_trade_order_more_filter_status_title);
    }

    public final boolean E(long j11, long j12) {
        return j11 < j12 && !A(j11).equals(A(j12));
    }

    public boolean F() {
        return this.f71720w;
    }

    public final void S(DatePickerDialog datePickerDialog, long j11) {
        x();
        long currentTimeMillis = System.currentTimeMillis();
        if (E(currentTimeMillis, j11)) {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_error_tip);
        } else if (E(j11, this.f71721x)) {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_early_tip);
        } else if (E(j11, currentTimeMillis - 10281600000L)) {
            HuobiToastUtil.j(R$string.n_order_filter_four_months_ahead_tip2);
        } else {
            datePickerDialog.dismiss();
            this.f71722y = j11;
            this.f71701d.setText(A(j11));
        }
    }

    public final void T(DatePickerDialog datePickerDialog, long j11) {
        x();
        long currentTimeMillis = System.currentTimeMillis();
        if (E(currentTimeMillis, j11)) {
            HuobiToastUtil.j(R$string.n_order_filter_start_time_error_tip);
        } else if (E(this.f71722y, j11)) {
            HuobiToastUtil.j(R$string.n_order_filter_end_time_early_tip);
        } else if (E(j11, currentTimeMillis - 10281600000L)) {
            HuobiToastUtil.j(R$string.n_order_filter_four_months_ahead_tip2);
        } else {
            datePickerDialog.dismiss();
            this.f71721x = j11;
            this.f71700c.setText(A(j11));
        }
    }

    public void U() {
        setDateType(3);
        z(this.f71700c, false);
        z(this.f71701d, false);
        setDirection(1);
        if (!this.f71715r.isEmpty()) {
            this.f71716s = this.f71715r.get(0).e();
        }
        this.f71711n.c();
    }

    public void V(int i11, List<y9.a> list) {
        this.f71716s = i11;
        this.f71715r.clear();
        this.f71715r.addAll(list);
        for (int i12 = 0; i12 < list.size(); i12++) {
            list.get(i12).h(this.A);
        }
        this.f71711n.setData(this.f71715r);
    }

    public final void W(TextView textView, boolean z11) {
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.trade_arrow_down, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R$drawable.trade_arrow_up, 0);
        }
    }

    public void X() {
        this.f71720w = true;
        AnimatorSet animatorSet = this.f71718u;
        if (animatorSet == null || !animatorSet.isRunning()) {
            setVisibility(0);
            e eVar = this.f71723z;
            if (eVar != null) {
                eVar.onShow();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f71718u = animatorSet2;
            animatorSet2.setDuration(270);
            this.f71718u.setInterpolator(new DecelerateInterpolator());
            this.f71718u.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f71699b, FrameLayout.TRANSLATION_Y, new float[]{(float) (-this.f71717t), 0.0f}), ObjectAnimator.ofFloat(this.f71710m, FrameLayout.ALPHA, new float[]{0.0f, 0.2f})});
            this.f71718u.start();
        }
    }

    public final void Y() {
        this.f71700c.setText(A(this.f71721x));
        this.f71701d.setText(A(this.f71722y));
    }

    public void setCallback(e eVar) {
        this.f71723z = eVar;
    }

    public void setDateType(int i11) {
        this.f71713p = i11;
        int i12 = 0;
        y(this.f71702e, i11 == 1);
        y(this.f71703f, i11 == 4);
        y(this.f71704g, i11 == 3);
        if (i11 != 0) {
            Calendar instance = Calendar.getInstance();
            this.f71722y = instance.getTimeInMillis();
            if (i11 == 1) {
                i12 = -6;
            } else if (i11 == 4) {
                i12 = -119;
            } else if (i11 == 3) {
                i12 = -29;
            }
            instance.add(5, i12);
            this.f71721x = instance.getTimeInMillis();
            Y();
        }
    }

    public void setDirection(int i11) {
        this.f71714q = i11;
        boolean z11 = false;
        y(this.f71705h, i11 == 1);
        y(this.f71706i, i11 == 2);
        TextView textView = this.f71707j;
        if (i11 == 3) {
            z11 = true;
        }
        y(textView, z11);
    }

    public void setEndTime(long j11) {
        this.f71722y = j11;
        this.f71701d.setText(A(j11));
    }

    public void setStartTime(long j11) {
        this.f71721x = j11;
        this.f71700c.setText(A(j11));
    }

    public void setStatusVisible(boolean z11) {
        ViewUtil.m(this.f71711n, z11);
        ViewUtil.m(this.f71712o, z11);
    }

    public void setTimeVisible(boolean z11) {
        ViewUtil.m(findViewById(R$id.id_id_trade_order_more_filter_time_title), z11);
        ViewUtil.m(findViewById(R$id.id_id_trade_order_more_filter_time_content1), z11);
        ViewUtil.m(findViewById(R$id.id_id_trade_order_more_filter_time_content2), z11);
    }

    public final void w() {
        setOnClickListener(new e2(this));
        this.f71710m.setOnClickListener(new y1(this));
        this.f71700c.setOnClickListener(new f2(this));
        this.f71701d.setOnClickListener(new w1(this));
        this.f71702e.setOnClickListener(new z1(this));
        this.f71703f.setOnClickListener(new b2(this));
        this.f71704g.setOnClickListener(new x1(this));
        this.f71705h.setOnClickListener(new v1(this));
        this.f71706i.setOnClickListener(new a2(this));
        this.f71707j.setOnClickListener(new d2(this));
        this.f71708k.setOnClickListener(new c2(this));
        this.f71709l.setOnClickListener(new g2(this));
    }

    public final void x() {
        setDateType(0);
        z(this.f71700c, false);
        z(this.f71701d, false);
    }

    public final void y(TextView textView, boolean z11) {
        int i11;
        textView.setSelected(z11);
        if (z11) {
            i11 = getResources().getColor(R$color.baseColorMajorTheme100);
        } else {
            i11 = getResources().getColor(R$color.baseColorSecondaryTextNew);
        }
        textView.setTextColor(i11);
    }

    public final void z(TextView textView, boolean z11) {
        int i11;
        textView.setSelected(z11);
        if (z11) {
            i11 = getResources().getColor(R$color.baseColorMajorTheme100);
        } else {
            i11 = getResources().getColor(R$color.baseColorPrimaryText);
        }
        textView.setTextColor(i11);
    }

    public TradeOrderMoreFilterView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71713p = 3;
        this.f71714q = 1;
        this.f71715r = new ArrayList();
        this.A = new c();
        FrameLayout.inflate(context, R$layout.layout_trade_order_more_filter, this);
        C();
    }
}
