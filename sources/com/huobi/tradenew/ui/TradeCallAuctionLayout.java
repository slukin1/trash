package com.huobi.tradenew.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.trade.helper.i;
import com.huobi.trade.ui.TradeCallAuctionCountDownLayout;
import com.huobi.utils.v0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.d;
import i6.m;
import it.a;
import pro.huobi.R;

public class TradeCallAuctionLayout extends ConstraintLayout implements a {
    public boolean A;
    public TextView B;

    /* renamed from: b  reason: collision with root package name */
    public TradeCallAuctionCountDownLayout f83128b;

    /* renamed from: c  reason: collision with root package name */
    public TradeCallAuctionCountDownLayout f83129c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f83130d;

    /* renamed from: e  reason: collision with root package name */
    public View f83131e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83132f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83133g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f83134h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f83135i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f83136j;

    /* renamed from: k  reason: collision with root package name */
    public View f83137k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f83138l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f83139m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f83140n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f83141o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f83142p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f83143q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f83144r;

    /* renamed from: s  reason: collision with root package name */
    public a f83145s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f83146t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f83147u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f83148v;

    /* renamed from: w  reason: collision with root package name */
    public View f83149w;

    /* renamed from: x  reason: collision with root package name */
    public View f83150x;

    /* renamed from: y  reason: collision with root package name */
    public View f83151y;

    /* renamed from: z  reason: collision with root package name */
    public TradeCallAuctionCountDownLayout f83152z;

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        v0.e(getContext(), "104900011957169");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p(View view) {
        if (this.f83148v) {
            this.f83147u.setImageResource(R.drawable.auction_arrow_down);
            ViewUtil.m(this.f83130d, false);
            ViewUtil.m(this.f83149w, false);
            ViewUtil.m(this.f83134h, false);
            ViewUtil.m(this.f83131e, false);
            ViewUtil.m(this.f83137k, false);
            ViewUtil.m(this.f83150x, false);
            if (this.A) {
                ViewUtil.m(this.f83151y, false);
            } else {
                ViewUtil.m(this.f83151y, true);
            }
            if (this.A) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
                marginLayoutParams.rightMargin = PixelUtils.a(15.0f);
                this.B.setLayoutParams(marginLayoutParams);
            }
            ViewUtil.m(this.B, true);
        } else {
            this.f83147u.setImageResource(R.drawable.auction_arrow_up);
            ViewUtil.m(this.f83130d, true);
            ViewUtil.m(this.f83149w, true);
            ViewUtil.m(this.f83134h, true);
            ViewUtil.m(this.f83131e, true);
            ViewUtil.m(this.f83137k, true);
            ViewUtil.m(this.f83150x, true);
            ViewUtil.m(this.f83151y, false);
            ViewUtil.m(this.B, false);
        }
        this.f83148v = !this.f83148v;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(int i11, long j11, long[] jArr) {
    }

    public void c(int i11) {
        a aVar = this.f83145s;
        if (aVar != null) {
            aVar.c(i11);
        }
    }

    public final void j() {
        this.f83143q.setOnClickListener(new a1(this));
        this.f83147u.setOnClickListener(new b1(this));
    }

    public void k() {
        ImageView imageView;
        if (this.f83148v && (imageView = this.f83147u) != null) {
            imageView.performClick();
        }
    }

    public final void m(Context context) {
        ViewGroup.inflate(context, R.layout.layout_trade_spot_call_auction_new, this);
        this.f83128b = (TradeCallAuctionCountDownLayout) findViewById(R.id.first_count_down_view);
        this.f83129c = (TradeCallAuctionCountDownLayout) findViewById(R.id.second_count_down_view);
        this.f83130d = (ImageView) findViewById(R.id.number_first_tv);
        this.f83131e = findViewById(R.id.first_container);
        this.f83132f = (TextView) findViewById(R.id.call_auction_first_time_tv);
        this.f83133g = (TextView) findViewById(R.id.call_auction_first_order_tv);
        this.f83134h = (ImageView) findViewById(R.id.number_second_tv);
        this.f83135i = (TextView) findViewById(R.id.call_auction_first_time_count_down_tv);
        this.f83136j = (TextView) findViewById(R.id.call_auction_first_end_tv);
        this.f83137k = findViewById(R.id.second_container);
        this.f83138l = (TextView) findViewById(R.id.call_auction_second_time_tv);
        this.f83139m = (TextView) findViewById(R.id.call_auction_second_not_start_tv);
        this.f83140n = (TextView) findViewById(R.id.call_auction_second_time_count_down_tv);
        this.f83141o = (TextView) findViewById(R.id.open_price_value_tv);
        this.f83142p = (TextView) findViewById(R.id.match_number_value_tv);
        this.f83143q = (TextView) findViewById(R.id.call_auction_desc_tv);
        this.f83144r = (TextView) findViewById(R.id.call_auction_second_order_tv);
        this.f83151y = findViewById(R.id.step_title_layout);
        this.f83150x = findViewById(R.id.open_price_container);
        this.f83146t = (TextView) findViewById(R.id.step_number_tv);
        this.f83149w = findViewById(R.id.arrow_iv);
        this.f83147u = (ImageView) findViewById(R.id.auction_arrow_iv);
        this.f83152z = (TradeCallAuctionCountDownLayout) findViewById(R.id.step_count_down_view);
        this.B = (TextView) findViewById(R.id.tv_step_left);
        if (this.A) {
            ViewUtil.m(this.f83151y, false);
            ViewUtil.m(this.B, false);
        }
        j();
    }

    public void q(int i11, long j11) {
        if (i11 == 1) {
            this.f83128b.setValid(true);
        } else {
            this.f83129c.setValid(true);
        }
        this.f83152z.setValid(true);
        i.k().v(i11, j11);
    }

    public void r(CallAuction callAuction, String str) {
        if (callAuction == null) {
            this.f83141o.setText("--");
            this.f83142p.setText("--");
            return;
        }
        if (TextUtils.isEmpty(callAuction.getForecastPrice())) {
            this.f83141o.setText("--");
        } else {
            this.f83141o.setText(m.m(callAuction.getForecastPrice(), PrecisionUtil.e(str)));
        }
        if (TextUtils.isEmpty(callAuction.getMatchAmount())) {
            this.f83142p.setText("--");
        } else {
            this.f83142p.setText(m.m(callAuction.getMatchAmount(), PrecisionUtil.z(str)));
        }
    }

    public void s(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (J != null) {
            d.b("CallAuction isCallAuctionOne:" + J.isCallAuctionOne() + "====isCallAuctionTwo:" + J.isCallAuctionTwo());
            if (SymbolBean.ONLINE.equals(J.getState())) {
                StringBuilder sb2 = new StringBuilder(DateTimeUtils.h(J.getCa1OpenAt(), "HH:mm:ss"));
                sb2.append(" - ");
                sb2.append(DateTimeUtils.h(J.getCa1CloseAt(), "HH:mm:ss"));
                this.f83132f.setText(sb2);
                StringBuilder sb3 = new StringBuilder(DateTimeUtils.h(J.getCa2OpenAt(), "HH:mm:ss"));
                sb3.append(" - ");
                sb3.append(DateTimeUtils.h(J.getCa2CloseAt(), "HH:mm:ss"));
                this.f83138l.setText(sb3);
                if (J.isCallAuctionOne()) {
                    setVisibility(0);
                    this.f83128b.setCountDownCallback(this);
                    this.f83152z.setCountDownCallback(this);
                    if (this.A) {
                        this.B.setText(String.format("%s", new Object[]{getContext().getString(R.string.n_spot_order_auction_one)}));
                    } else {
                        this.B.setText(String.format("%s,", new Object[]{getContext().getString(R.string.n_spot_order_auction_one)}));
                    }
                    this.f83130d.setImageResource(R.drawable.call_auction_number_first);
                    this.f83131e.setBackgroundResource(R.drawable.shape_call_auction_first_bg);
                    this.f83135i.setVisibility(0);
                    this.f83128b.setVisibility(0);
                    this.f83136j.setVisibility(8);
                    this.f83137k.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.baseColorRemarksBackground));
                    this.f83139m.setVisibility(0);
                    this.f83140n.setVisibility(4);
                    this.f83129c.setVisibility(4);
                    this.f83134h.setImageResource(R.drawable.call_auction_number_second);
                    this.f83144r.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f83138l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f83132f.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText));
                    this.f83133g.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
                } else if (J.isCallAuctionTwo()) {
                    setVisibility(0);
                    this.f83129c.setCountDownCallback(this);
                    this.f83152z.setCountDownCallback(this);
                    if (this.A) {
                        this.B.setText(String.format("%s", new Object[]{getContext().getString(R.string.n_spot_order_auction_second)}));
                    } else {
                        this.B.setText(String.format("%s,", new Object[]{getContext().getString(R.string.n_spot_order_auction_second)}));
                    }
                    this.f83130d.setImageResource(R.drawable.call_auction_finish);
                    this.f83131e.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.baseColorRemarksBackground));
                    this.f83135i.setVisibility(4);
                    this.f83128b.setVisibility(4);
                    this.f83136j.setVisibility(0);
                    this.f83137k.setBackgroundResource(R.drawable.shape_call_auction_first_bg);
                    this.f83139m.setVisibility(8);
                    this.f83140n.setVisibility(0);
                    this.f83129c.setVisibility(0);
                    this.f83134h.setImageResource(R.drawable.call_auction_number_second_start);
                    this.f83144r.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
                    this.f83138l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorSecondaryText));
                    this.f83132f.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                    this.f83133g.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorThreeLevelText));
                } else {
                    setVisibility(8);
                    this.f83128b.setCountDownCallback((a) null);
                    this.f83129c.setCountDownCallback((a) null);
                    this.f83152z.setCountDownCallback((a) null);
                }
            } else {
                setVisibility(8);
                this.f83128b.setCountDownCallback((a) null);
                this.f83129c.setCountDownCallback((a) null);
                this.f83152z.setCountDownCallback((a) null);
            }
        } else {
            setVisibility(8);
            this.f83128b.setCountDownCallback((a) null);
            this.f83129c.setCountDownCallback((a) null);
            this.f83152z.setCountDownCallback((a) null);
        }
    }

    public void setCountDownCallback(a aVar) {
        this.f83145s = aVar;
    }

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public TradeCallAuctionLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f83148v = true;
        this.A = true;
        m(context);
    }
}
