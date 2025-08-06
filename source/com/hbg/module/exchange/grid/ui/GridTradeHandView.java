package com.hbg.module.exchange.grid.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cd.r;
import cd.s;
import cd.t;
import cd.u;
import cd.v;
import cd.w;
import cd.x;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.widgets.CommonCornerTabLayout;
import com.hbg.module.exchange.R$dimen;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.grid.ui.GridTradeInputView;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GridTradeHandView extends FrameLayout {
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;

    /* renamed from: b  reason: collision with root package name */
    public GridTradeActivity f19525b;

    /* renamed from: c  reason: collision with root package name */
    public CommonCornerTabLayout f19526c;

    /* renamed from: d  reason: collision with root package name */
    public CommonCornerTabLayout f19527d;

    /* renamed from: e  reason: collision with root package name */
    public j f19528e;

    /* renamed from: f  reason: collision with root package name */
    public GridTradeInputView f19529f;

    /* renamed from: g  reason: collision with root package name */
    public GridTradeInputView f19530g;

    /* renamed from: h  reason: collision with root package name */
    public GridTradeInputView f19531h;

    /* renamed from: i  reason: collision with root package name */
    public GridTradeInputView f19532i;

    /* renamed from: j  reason: collision with root package name */
    public GridTradeInputView f19533j;

    /* renamed from: k  reason: collision with root package name */
    public GridTradeInputView f19534k;

    /* renamed from: l  reason: collision with root package name */
    public GridTradeInputView f19535l;

    /* renamed from: m  reason: collision with root package name */
    public View f19536m;

    /* renamed from: n  reason: collision with root package name */
    public BubbleSeekBar f19537n;

    /* renamed from: o  reason: collision with root package name */
    public BubbleSeekBar f19538o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f19539p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f19540q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f19541r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f19542s;

    /* renamed from: t  reason: collision with root package name */
    public View f19543t;

    /* renamed from: u  reason: collision with root package name */
    public int f19544u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f19545v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f19546w;

    /* renamed from: x  reason: collision with root package name */
    public String f19547x;

    /* renamed from: y  reason: collision with root package name */
    public String f19548y;

    /* renamed from: z  reason: collision with root package name */
    public String f19549z;

    public class a implements GridTradeInputView.b {
        public a() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.g(z11, str);
            }
        }

        public void onTextChanged(String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.s(str);
            }
        }
    }

    public class b implements GridTradeInputView.b {
        public b() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.c(z11, str);
            }
        }

        public void onTextChanged(String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.l(str);
            }
        }
    }

    public class c implements GridTradeInputView.b {
        public c() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.f(z11, str);
            }
        }

        public void onTextChanged(String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.o(str);
            }
        }
    }

    public class d implements GridTradeInputView.b {
        public d() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.e(z11, str);
            }
        }

        public void onTextChanged(String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.p(str);
            }
        }
    }

    public class e implements GridTradeInputView.b {
        public e() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.j(z11, str);
            }
        }

        public void onTextChanged(String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.m(str);
            }
        }
    }

    public class f implements BubbleSeekBar.OnProgressChangedListener {
        public f() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                if (GridTradeHandView.this.f19528e != null) {
                    GridTradeHandView.this.f19528e.a();
                }
                if (m.a(GridTradeHandView.this.f19549z).doubleValue() > 0.0d) {
                    String str = "";
                    if (GridTradeHandView.this.f19549z != null) {
                        if (!(m.a(GridTradeHandView.this.f19549z).compareTo(BigDecimal.ZERO) == 0 || i11 == 0)) {
                            str = m.q(m.a(GridTradeHandView.this.f19549z).multiply(m.a(String.valueOf(i11))).divide(m.a("100"), 8, 1), GridTradeHandView.this.B);
                        }
                        GridTradeHandView.this.f19530g.setInputText(str);
                        return;
                    }
                    GridTradeHandView.this.f19530g.setInputText(str);
                }
            }
        }
    }

    public class g implements BubbleSeekBar.OnProgressChangedListener {
        public g() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                if (GridTradeHandView.this.f19528e != null) {
                    GridTradeHandView.this.f19528e.a();
                }
                if (m.a(GridTradeHandView.this.A).doubleValue() > 0.0d) {
                    String str = "";
                    if (GridTradeHandView.this.A != null) {
                        if (!(m.a(GridTradeHandView.this.A).compareTo(BigDecimal.ZERO) == 0 || i11 == 0)) {
                            str = m.q(m.a(GridTradeHandView.this.A).multiply(m.a(String.valueOf(i11))).divide(m.a("100"), 8, 1), GridTradeHandView.this.C);
                        }
                        GridTradeHandView.this.f19531h.setInputText(str);
                        return;
                    }
                    GridTradeHandView.this.f19531h.setInputText(str);
                }
            }
        }
    }

    public class h implements GridTradeInputView.b {
        public h() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.d(z11, str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTextChanged(java.lang.String r5) {
            /*
                r4 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L_0x0032
                java.math.BigDecimal r0 = i6.m.a(r5)
                com.hbg.module.exchange.grid.ui.GridTradeHandView r1 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                java.lang.String r1 = r1.f19549z
                java.math.BigDecimal r1 = i6.m.a(r1)
                java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
                int r2 = r1.compareTo(r2)
                if (r2 <= 0) goto L_0x0032
                r2 = 8
                r3 = 1
                java.math.BigDecimal r0 = r0.divide(r1, r2, r3)
                java.lang.String r1 = "100"
                java.math.BigDecimal r1 = i6.m.a(r1)
                java.math.BigDecimal r0 = r0.multiply(r1)
                float r0 = r0.floatValue()
                goto L_0x0033
            L_0x0032:
                r0 = 0
            L_0x0033:
                com.hbg.module.exchange.grid.ui.GridTradeHandView r1 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.huobi.view.bubbleseekbar.BubbleSeekBar r1 = r1.f19537n
                r1.setProgress(r0)
                com.hbg.module.exchange.grid.ui.GridTradeHandView r0 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.hbg.module.exchange.grid.ui.GridTradeHandView$j r0 = r0.f19528e
                if (r0 == 0) goto L_0x004d
                com.hbg.module.exchange.grid.ui.GridTradeHandView r0 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.hbg.module.exchange.grid.ui.GridTradeHandView$j r0 = r0.f19528e
                r0.b(r5)
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.exchange.grid.ui.GridTradeHandView.h.onTextChanged(java.lang.String):void");
        }
    }

    public class i implements GridTradeInputView.b {
        public i() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeHandView.this.f19528e != null) {
                GridTradeHandView.this.f19528e.q(z11, str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTextChanged(java.lang.String r5) {
            /*
                r4 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L_0x0032
                java.math.BigDecimal r0 = i6.m.a(r5)
                com.hbg.module.exchange.grid.ui.GridTradeHandView r1 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                java.lang.String r1 = r1.A
                java.math.BigDecimal r1 = i6.m.a(r1)
                java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
                int r2 = r1.compareTo(r2)
                if (r2 <= 0) goto L_0x0032
                r2 = 8
                r3 = 1
                java.math.BigDecimal r0 = r0.divide(r1, r2, r3)
                java.lang.String r1 = "100"
                java.math.BigDecimal r1 = i6.m.a(r1)
                java.math.BigDecimal r0 = r0.multiply(r1)
                float r0 = r0.floatValue()
                goto L_0x0033
            L_0x0032:
                r0 = 0
            L_0x0033:
                com.hbg.module.exchange.grid.ui.GridTradeHandView r1 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.huobi.view.bubbleseekbar.BubbleSeekBar r1 = r1.f19538o
                r1.setProgress(r0)
                com.hbg.module.exchange.grid.ui.GridTradeHandView r0 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.hbg.module.exchange.grid.ui.GridTradeHandView$j r0 = r0.f19528e
                if (r0 == 0) goto L_0x004d
                com.hbg.module.exchange.grid.ui.GridTradeHandView r0 = com.hbg.module.exchange.grid.ui.GridTradeHandView.this
                com.hbg.module.exchange.grid.ui.GridTradeHandView$j r0 = r0.f19528e
                r0.n(r5)
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.exchange.grid.ui.GridTradeHandView.i.onTextChanged(java.lang.String):void");
        }
    }

    public interface j {
        void a();

        void b(String str);

        void c(boolean z11, String str);

        void d(boolean z11, String str);

        void e(boolean z11, String str);

        void f(boolean z11, String str);

        void g(boolean z11, String str);

        void h(boolean z11);

        void i(View view);

        void j(boolean z11, String str);

        void k(int i11);

        void l(String str);

        void m(String str);

        void n(String str);

        void o(String str);

        void p(String str);

        void q(boolean z11, String str);

        void r(View view);

        void s(String str);

        void t();
    }

    public GridTradeHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(View view) {
        j jVar = this.f19528e;
        if (jVar != null) {
            jVar.r(findViewById(R$id.id_grid_trade_hand_input_rate_title_i));
        }
        vc.b.a().d("5837", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void B(View view) {
        j jVar = this.f19528e;
        if (jVar != null) {
            jVar.i(findViewById(R$id.id_grid_trade_hand_throw_in_title_i));
        }
        vc.b.a().d("5843", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(ValueAnimator valueAnimator) {
        this.E = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f19536m.getLayoutParams();
        layoutParams.height = this.E;
        this.f19536m.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(int i11) {
        if (i11 != 1) {
            this.f19544u = 0;
        } else {
            this.f19544u = 1;
        }
        j jVar = this.f19528e;
        if (jVar != null) {
            jVar.k(this.f19544u);
        }
        this.f19527d.setSelectIndex(i11);
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.f19544u == 1 ? "等比" : "等差");
        vc.b.a().d("5842", hashMap, "1005373");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(int i11) {
        if (i11 != 1) {
            this.f19545v = true;
        } else {
            this.f19545v = false;
        }
        if (this.f19545v) {
            ViewUtil.m(this.f19531h, false);
            ViewUtil.m(this.f19538o, false);
            ViewUtil.m(findViewById(R$id.id_grid_trade_hand_input_money_base_available_title), false);
            ViewUtil.m(this.f19540q, false);
        } else {
            ViewUtil.m(this.f19531h, true);
            ViewUtil.m(this.f19538o, true);
            ViewUtil.m(findViewById(R$id.id_grid_trade_hand_input_money_base_available_title), true);
            ViewUtil.m(this.f19540q, true);
        }
        j jVar = this.f19528e;
        if (jVar != null) {
            jVar.h(this.f19545v);
        }
        this.f19526c.setSelectIndex(i11);
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.f19545v ? "单币" : "双币");
        vc.b.a().d("5841", hashMap, "1005373");
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        setHighLevelOpen(!this.f19546w);
        vc.b.a().d("5844", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        j jVar = this.f19528e;
        if (jVar != null) {
            jVar.t();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void D() {
        this.f19532i.k();
        this.f19533j.k();
        this.f19529f.k();
        this.f19530g.k();
        this.f19531h.k();
        this.f19534k.k();
        this.f19535l.k();
    }

    public void E() {
        this.f19532i.setInputText("");
        this.f19533j.setInputText("");
        this.f19529f.setInputText("");
        this.f19530g.setInputText("");
        this.f19531h.setInputText("");
        this.f19534k.setInputText("");
        this.f19535l.setInputText("");
        this.f19537n.setProgress(0.0f);
        this.f19538o.setProgress(0.0f);
    }

    public void F(String str, String str2) {
        this.f19549z = str;
        this.A = str2;
        TextView textView = this.f19539p;
        textView.setText(str + " " + k.C().z(this.f19548y));
        TextView textView2 = this.f19540q;
        textView2.setText(str2 + " " + k.C().z(this.f19547x));
    }

    public void G(String str) {
        if (!TextUtils.isEmpty(str)) {
            int A2 = PrecisionUtil.A(str);
            this.f19533j.setFloatPrecision(A2);
            this.f19532i.setFloatPrecision(A2);
            this.f19529f.setFloatPrecision(0);
            this.f19529f.setIntPrecision(2);
            this.B = PrecisionUtil.z(str);
            this.C = PrecisionUtil.z(str);
            this.f19530g.setFloatPrecision(this.B);
            this.f19531h.setFloatPrecision(this.B);
            this.f19534k.setFloatPrecision(A2);
            this.f19535l.setFloatPrecision(A2);
        }
    }

    public void H() {
        CommonCornerTabLayout commonCornerTabLayout = this.f19526c;
        String z11 = k.C().z(this.f19548y);
        commonCornerTabLayout.g(z11, k.C().z(this.f19548y) + "+" + k.C().z(this.f19547x));
        this.f19526c.setSelectIndex(this.f19545v ^ true ? 1 : 0);
    }

    public int getGridNum() {
        try {
            return Integer.parseInt(this.f19529f.getText());
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public String getGridRate() {
        return this.f19541r.getText().toString();
    }

    public String getInvestBaseAmount() {
        if (this.f19545v) {
            return null;
        }
        return this.f19531h.getText();
    }

    public String getInvestQuoteAmount() {
        return this.f19530g.getText();
    }

    public String getMaxPrice() {
        return this.f19533j.getText();
    }

    public String getMinPrice() {
        return this.f19532i.getText();
    }

    public String getStopLossPrice() {
        return this.f19535l.getText();
    }

    public String getStopProfitPrice() {
        return this.f19534k.getText();
    }

    public final void q() {
        this.f19527d.setCallback(new w(this));
    }

    public final void r() {
        this.f19526c.setCallback(new x(this));
    }

    public boolean s() {
        return this.f19544u == 0;
    }

    public void setActivity(GridTradeActivity gridTradeActivity) {
        this.f19525b = gridTradeActivity;
        this.f19529f.setActivity(gridTradeActivity);
        this.f19530g.setActivity(this.f19525b);
        this.f19531h.setActivity(this.f19525b);
        this.f19532i.setActivity(this.f19525b);
        this.f19533j.setActivity(this.f19525b);
        this.f19534k.setActivity(this.f19525b);
        this.f19535l.setActivity(this.f19525b);
    }

    public void setBaseCurrency(String str) {
        this.f19547x = StringUtils.i(str);
        this.f19531h.setUnit(k.C().z(this.f19547x));
        if (TextUtils.isEmpty(this.A)) {
            TextView textView = this.f19540q;
            textView.setText("-- " + k.C().z(this.f19547x));
        }
    }

    public void setCallback(j jVar) {
        this.f19528e = jVar;
    }

    public void setDengCha(boolean z11) {
        boolean z12 = !z11;
        this.f19544u = z12 ? 1 : 0;
        this.f19527d.setSelectIndex(z12);
    }

    public void setHighLevelOpen(boolean z11) {
        ValueAnimator valueAnimator;
        this.f19546w = z11;
        if (z11) {
            this.f19542s.animate().rotation(180.0f);
            valueAnimator = ValueAnimator.ofInt(new int[]{this.E, this.D});
        } else {
            this.f19542s.animate().rotation(0.0f);
            valueAnimator = ValueAnimator.ofInt(new int[]{this.E, 0});
        }
        valueAnimator.addUpdateListener(new r(this));
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(150);
        valueAnimator.start();
    }

    public void setInputGridNum(String str) {
        this.f19529f.setInputText(str);
    }

    public void setInputMaxPrice(String str) {
        this.f19533j.setInputText(str);
    }

    public void setInputMinPrice(String str) {
        this.f19532i.setInputText(str);
    }

    public void setIsSingle(boolean z11) {
        this.f19545v = z11;
        if (z11) {
            ViewUtil.m(this.f19531h, false);
            ViewUtil.m(this.f19538o, false);
            ViewUtil.m(findViewById(R$id.id_grid_trade_hand_input_money_base_available_title), false);
            ViewUtil.m(this.f19540q, false);
        } else {
            ViewUtil.m(this.f19531h, true);
            ViewUtil.m(this.f19538o, true);
            ViewUtil.m(findViewById(R$id.id_grid_trade_hand_input_money_base_available_title), true);
            ViewUtil.m(this.f19540q, true);
        }
        this.f19526c.setSelectIndex(z11 ^ true ? 1 : 0);
    }

    public void setMinCapitalBase(String str) {
        this.f19531h.setInputHint(str);
    }

    public void setMinCapitalQuote(String str) {
        this.f19530g.setInputHint(str);
    }

    public void setPerGridRate(String str) {
        this.f19541r.setText(str);
    }

    public void setQuoteCurrency(String str) {
        this.f19548y = StringUtils.i(str);
        String z11 = k.C().z(this.f19548y);
        this.f19530g.setUnit(z11);
        this.f19532i.setUnit(z11);
        this.f19533j.setUnit(z11);
        this.f19534k.setUnit(z11);
        this.f19535l.setUnit(z11);
        if (TextUtils.isEmpty(this.f19549z)) {
            TextView textView = this.f19539p;
            textView.setText("-- " + k.C().z(this.f19548y));
        }
    }

    public boolean t() {
        return this.f19546w;
    }

    public int u() {
        return this.f19544u;
    }

    public boolean v() {
        return this.f19545v;
    }

    public GridTradeHandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f19545v = true;
        FrameLayout.inflate(context, R$layout.grid_trade_hand_view, this);
        this.f19526c = (CommonCornerTabLayout) findViewById(R$id.id_grid_trade_hand_throw_in_tab);
        this.f19527d = (CommonCornerTabLayout) findViewById(R$id.id_grid_trade_hand_mode_title_tab);
        this.f19529f = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_input_amount);
        this.f19530g = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_input_money_quote);
        this.f19531h = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_input_money_base);
        this.f19537n = (BubbleSeekBar) findViewById(R$id.id_grid_trade_han_seekBar_quote);
        this.f19538o = (BubbleSeekBar) findViewById(R$id.id_grid_trade_han_seekBar_base);
        this.f19540q = (TextView) findViewById(R$id.id_grid_trade_hand_input_money_base_available_tv);
        this.f19539p = (TextView) findViewById(R$id.id_grid_trade_hand_input_money_quote_available_tv);
        this.f19542s = (ImageView) findViewById(R$id.id_grid_trade_hand_high_level_arrow);
        this.f19543t = findViewById(R$id.id_grid_trade_hand_high_level_arrow_parent);
        this.f19532i = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_input_min);
        this.f19533j = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_input_max);
        this.f19534k = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_zhiying_price_tv);
        this.f19535l = (GridTradeInputView) findViewById(R$id.id_grid_trade_hand_zhisun_price_tv);
        this.f19541r = (TextView) findViewById(R$id.id_grid_trade_hand_input_rate_tv);
        this.f19536m = findViewById(R$id.id_grid_trade_hand_mode_parent);
        this.D = getResources().getDimensionPixelOffset(R$dimen.dimen_122);
        r();
        q();
        this.f19541r.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        BubbleSeekBar bubbleSeekBar = this.f19537n;
        int i12 = R$drawable.contract_slider;
        bubbleSeekBar.setThumbBitmap(i12);
        this.f19538o.setThumbBitmap(i12);
        this.f19543t.setOnClickListener(new u(this));
        this.f19529f.setInputType(2);
        this.f19532i.setCallback(new a());
        this.f19533j.setCallback(new b());
        this.f19529f.setCallback(new c());
        this.f19534k.setCallback(new d());
        this.f19535l.setCallback(new e());
        this.f19537n.setOnProgressChangedListener(new f());
        this.f19538o.setOnProgressChangedListener(new g());
        this.f19530g.setCallback(new h());
        this.f19531h.setCallback(new i());
        findViewById(R$id.id_grid_trade_hand_high_level_title).setOnClickListener(new v(this));
        s sVar = new s(this);
        findViewById(R$id.id_grid_trade_hand_input_rate_title).setOnClickListener(sVar);
        findViewById(R$id.id_grid_trade_hand_input_rate_title_i).setOnClickListener(sVar);
        t tVar = new t(this);
        findViewById(R$id.id_grid_trade_hand_throw_in_title).setOnClickListener(tVar);
        findViewById(R$id.id_grid_trade_hand_throw_in_title_i).setOnClickListener(tVar);
    }
}
