package com.huobi.c2c.lend.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.widgets.CommonEditText;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.huobi.view.TradeRangeBarView;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.d;
import java.math.BigDecimal;
import java.util.List;
import pro.huobi.R;
import qi.f;
import qi.g;
import qi.h;
import qi.i;
import qi.j;
import qi.l;
import qi.m;
import qi.n;
import qi.o;
import qi.p;

public class C2CLendTradeLayout extends FrameLayout {
    public boolean A;

    /* renamed from: b  reason: collision with root package name */
    public HuobiKeyboardHelper f42941b;

    /* renamed from: c  reason: collision with root package name */
    public CommonEditText.b f42942c;

    /* renamed from: d  reason: collision with root package name */
    public CommonEditText.b f42943d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42944e;

    /* renamed from: f  reason: collision with root package name */
    public CommonEditText f42945f;

    /* renamed from: g  reason: collision with root package name */
    public View f42946g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42947h;

    /* renamed from: i  reason: collision with root package name */
    public CommonEditText f42948i;

    /* renamed from: j  reason: collision with root package name */
    public View f42949j;

    /* renamed from: k  reason: collision with root package name */
    public TradeRangeBarView f42950k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f42951l;

    /* renamed from: m  reason: collision with root package name */
    public View f42952m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f42953n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f42954o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f42955p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f42956q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f42957r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f42958s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f42959t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f42960u;

    /* renamed from: v  reason: collision with root package name */
    public View f42961v;

    /* renamed from: w  reason: collision with root package name */
    public CommonSwitchButton f42962w;

    /* renamed from: x  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f42963x;

    /* renamed from: y  reason: collision with root package name */
    public c f42964y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f42965z;

    public class a implements CommonEditText.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonEditText.b f42966a;

        public a(CommonEditText.b bVar) {
            this.f42966a = bVar;
        }

        public boolean b() {
            CommonEditText.b bVar = this.f42966a;
            if (!(bVar != null ? bVar.b() : false)) {
                C2CLendTradeLayout.this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5_focused);
                C2CLendTradeLayout.this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
            }
            return false;
        }

        public void c(String str, Editable editable) {
            CommonEditText.b bVar = this.f42966a;
            if (bVar != null) {
                bVar.c(str, editable);
            }
        }
    }

    public class b implements CommonEditText.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonEditText.b f42968a;

        public b(CommonEditText.b bVar) {
            this.f42968a = bVar;
        }

        public boolean b() {
            CommonEditText.b bVar = this.f42968a;
            if (!(bVar != null ? bVar.b() : false)) {
                C2CLendTradeLayout.this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
                C2CLendTradeLayout.this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5_focused);
            }
            return false;
        }

        public void c(String str, Editable editable) {
            CommonEditText.b bVar = this.f42968a;
            if (bVar != null) {
                bVar.c(str, editable);
            }
        }
    }

    public interface c {
        void a();

        void d(boolean z11);

        void e();

        void g(boolean z11);

        void h(View view);
    }

    public C2CLendTradeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View view, boolean z11) {
        if (z11) {
            this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5_focused);
            this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
            return;
        }
        this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean B(View view, MotionEvent motionEvent) {
        CommonEditText.b bVar = this.f42942c;
        if (bVar == null) {
            return false;
        }
        bVar.b();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean C(View view, MotionEvent motionEvent) {
        CommonEditText.b bVar = this.f42943d;
        if (bVar == null) {
            return false;
        }
        bVar.b();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(CharSequence charSequence) {
        if (this.f42957r.getPaint().measureText(charSequence.toString()) > ((float) this.f42946g.getWidth())) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f42957r.getLayoutParams();
            layoutParams.f7940g = -1;
            this.f42957r.setLayoutParams(layoutParams);
        } else {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f42957r.getLayoutParams();
            layoutParams2.f7940g = R.id.id_c2c_lend_trade_rate_layout;
            this.f42957r.setLayoutParams(layoutParams2);
        }
        this.f42957r.setText(charSequence);
        this.f42957r.setVisibility(0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        c cVar = this.f42964y;
        if (cVar != null) {
            cVar.e();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        c cVar = this.f42964y;
        if (cVar != null) {
            cVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        c cVar = this.f42964y;
        if (cVar != null) {
            cVar.h(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void w(View view) {
        setBestBtnSelected(!this.f42965z);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void x(View view) {
        setBestBtnSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        this.f42945f.clearFocus();
        setAutoOrder(!this.A);
        this.f42941b.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(View view, boolean z11) {
        if (z11) {
            this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5_focused);
            this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
            return;
        }
        this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
    }

    public void E() {
        this.f42948i.setText("");
    }

    public void F(String str, String str2) {
        String z11 = k.C().z(str2);
        this.f42955p.setText(str + " " + z11);
        this.f42955p.setTextColor(getResources().getColor(w.h()));
    }

    public void G(String str, boolean z11) {
        this.f42945f.setText(str);
        if (z11) {
            CommonAnimateUtil.a(this.f42945f);
        }
    }

    public void H(boolean z11, boolean z12) {
        Drawable drawable;
        if (z11) {
            drawable = z12 ? ContextCompat.getDrawable(getContext(), R.drawable.trade_arrow_up) : ContextCompat.getDrawable(getContext(), R.drawable.trade_arrow_down);
        } else {
            drawable = null;
        }
        this.f42944e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public String getAmountText() {
        return this.f42948i.getText().toString();
    }

    public HuobiKeyboardHelper getHuobiKeyboardHelper() {
        return this.f42941b;
    }

    public String getRateText() {
        return this.f42945f.getText().toString();
    }

    public final void n() {
        this.f42953n.setOnClickListener(new j(this));
        this.f42952m.setOnClickListener(new h(this));
        this.f42944e.setOnClickListener(new i(this));
        this.f42959t.setOnClickListener(new qi.k(this));
        this.f42960u.setOnClickListener(new f(this));
        this.f42961v.setOnClickListener(new l(this));
    }

    public void o() {
        this.f42945f.clearFocus();
        this.f42948i.clearFocus();
        this.f42946g.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
        this.f42949j.setBackgroundResource(R.drawable.shape_rect_stroke_bg_corner_5);
    }

    public final void p(Context context) {
        q(context);
        n();
        this.f42950k.setThumbBitmap(R.drawable.contract_slider);
        this.f42945f.setOnFocusChangeListener(new m(this));
        this.f42948i.setOnFocusChangeListener(new n(this));
        this.f42941b = new HuobiKeyboardHelper().attach((Activity) context).registerInput(this.f42948i, new o(this)).registerInput(this.f42945f, new p(this));
    }

    public final void q(Context context) {
        FrameLayout.inflate(context, R.layout.c2c_lend_trade_layout, this);
        this.f42944e = (TextView) findViewById(R.id.id_c2c_lend_trade_layout_period_tv);
        this.f42945f = (CommonEditText) findViewById(R.id.id_c2c_lend_trade_layout_rate_et);
        this.f42947h = (TextView) findViewById(R.id.id_c2c_lend_trade_layout_range_tv);
        this.f42948i = (CommonEditText) findViewById(R.id.id_c2c_lend_trade_layout_amount_et);
        this.f42950k = (TradeRangeBarView) findViewById(R.id.id_c2c_lend_trade_layout_seekBar);
        this.f42953n = (TextView) findViewById(R.id.c2c_lend_trade_btn);
        this.f42951l = (TextView) findViewById(R.id.c2c_lend_trade_available_tv);
        this.f42952m = findViewById(R.id.c2c_lend_trade_available_tips);
        this.f42954o = (TextView) findViewById(R.id.c2c_lend_trade_input_unit_tv);
        this.f42955p = (TextView) findViewById(R.id.c2c_lend_trade_profit_tv);
        this.f42963x = (EasyRecyclerView) findViewById(R.id.c2c_lend_trade_recyclerView);
        this.f42956q = (TextView) findViewById(R.id.c2c_lend_trade_min_amount_tv);
        this.f42958s = (TextView) findViewById(R.id.c2c_lend_trade_max_amount_tv);
        this.f42957r = (TextView) findViewById(R.id.c2c_lend_trade_year_rate_tv);
        this.f42946g = findViewById(R.id.id_c2c_lend_trade_rate_layout);
        this.f42949j = findViewById(R.id.id_c2c_lend_trade_amount_layout);
        this.f42959t = (TextView) findViewById(R.id.id_c2c_lend_trade_bast_tv);
        this.f42960u = (TextView) findViewById(R.id.c2c_lend_trade_best_cover_tv);
        this.f42961v = findViewById(R.id.c2c_lend_trade_switch_layout);
        this.f42962w = (CommonSwitchButton) findViewById(R.id.c2c_lend_trade_switch_botton);
    }

    public boolean r() {
        return this.A;
    }

    public boolean s() {
        return this.f42965z;
    }

    public void setAmountEtCallback(CommonEditText.b bVar) {
        b bVar2 = new b(bVar);
        this.f42942c = bVar2;
        this.f42948i.setCallback(bVar2);
    }

    public void setAmountEtHintText(String str) {
        this.f42948i.setHint(str);
    }

    public void setAmountEtText(String str) {
        BigDecimal a11 = i6.m.a(str);
        String amountText = getAmountText();
        BigDecimal a12 = i6.m.a(amountText);
        boolean z11 = a11.compareTo(a12) != 0;
        d.b("C2CLendTradeLayout-->setAmountEtText--> \ntext:" + str + " \namountText:" + amountText + " \ntextDecimal:" + a11.toPlainString() + " \namountDecimal:" + a12.toPlainString() + " \nisSame:" + z11);
        if (z11) {
            this.f42948i.setText(str);
        }
    }

    public void setAmountFloatPrecision(int i11) {
        this.f42948i.setFloatPrecision(i11);
    }

    public void setAmountIntPrecision(int i11) {
        this.f42948i.setIntPrecision(i11);
    }

    public void setAutoOrder(boolean z11) {
        this.A = z11;
        this.f42962w.b(z11, true);
        c cVar = this.f42964y;
        if (cVar != null) {
            cVar.d(z11);
        }
    }

    public void setAvailable(String str) {
        this.f42951l.setText(str);
    }

    public void setBestBtnSelected(boolean z11) {
        this.f42965z = z11;
        this.f42959t.setSelected(z11);
        ViewUtil.m(this.f42960u, z11);
        G("", false);
        if (z11) {
            this.f42945f.clearFocus();
            this.f42941b.hideKeyboard();
        }
        c cVar = this.f42964y;
        if (cVar != null) {
            cVar.g(z11);
        }
    }

    public void setCallback(c cVar) {
        this.f42964y = cVar;
    }

    public void setCurrency(String str) {
        this.f42954o.setText(k.C().z(str));
    }

    public void setLendBtnText(String str) {
        this.f42953n.setText(str);
    }

    public void setMaxAmount(String str) {
        this.f42958s.setText(str);
    }

    public void setOnProgressChangedListener(BubbleSeekBar.OnProgressChangedListener onProgressChangedListener) {
        this.f42950k.setOnProgressChangedListener(onProgressChangedListener);
    }

    public void setPeriod(String str) {
        this.f42944e.setText(str);
    }

    public void setProgress(float f11) {
        d.b("C2CLendTradeLayout-->setProgress-->" + f11);
        this.f42950k.setProgress((int) f11);
    }

    public void setRange(String str) {
        this.f42947h.setText(str);
    }

    public void setRateEtCallback(CommonEditText.b bVar) {
        a aVar = new a(bVar);
        this.f42943d = aVar;
        this.f42945f.setCallback(aVar);
    }

    public void setRateFloatPrecision(int i11) {
        this.f42945f.setFloatPrecision(i11);
    }

    public void setRateIntPrecision(int i11) {
        this.f42945f.setIntPrecision(i11);
    }

    public void setRateList(List<s9.a> list) {
        this.f42963x.setData(list);
    }

    public void setYearRate(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f42957r.setVisibility(8);
        } else {
            this.f42957r.post(new g(this, charSequence));
        }
    }

    public C2CLendTradeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        p(context);
    }
}
