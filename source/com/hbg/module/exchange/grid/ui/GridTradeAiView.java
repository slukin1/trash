package com.hbg.module.exchange.grid.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cd.p;
import cd.q;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.grid.bean.GridAiQuote;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.grid.ui.GridTradeInputView;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

public class GridTradeAiView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public GridTradeActivity f19509b;

    /* renamed from: c  reason: collision with root package name */
    public BubbleSeekBar f19510c;

    /* renamed from: d  reason: collision with root package name */
    public GridTradeInputView f19511d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19512e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19513f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19514g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19515h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19516i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19517j;

    /* renamed from: k  reason: collision with root package name */
    public String f19518k;

    /* renamed from: l  reason: collision with root package name */
    public GridAiQuote f19519l;

    /* renamed from: m  reason: collision with root package name */
    public c f19520m;

    /* renamed from: n  reason: collision with root package name */
    public String f19521n;

    /* renamed from: o  reason: collision with root package name */
    public int f19522o;

    public class a implements BubbleSeekBar.OnProgressChangedListener {
        public a() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                if (GridTradeAiView.this.f19520m != null) {
                    GridTradeAiView.this.f19520m.a();
                }
                if (m.a(GridTradeAiView.this.f19521n).doubleValue() > 0.0d) {
                    String str = "";
                    if (GridTradeAiView.this.f19521n != null) {
                        if (!(m.a(GridTradeAiView.this.f19521n).compareTo(BigDecimal.ZERO) == 0 || i11 == 0)) {
                            str = m.q(m.a(GridTradeAiView.this.f19521n).multiply(m.a(String.valueOf(i11))).divide(m.a("100"), 8, 1), GridTradeAiView.this.f19522o);
                        }
                        GridTradeAiView.this.f19511d.setInputText(str);
                        return;
                    }
                    GridTradeAiView.this.f19511d.setInputText(str);
                }
            }
        }
    }

    public class b implements GridTradeInputView.b {
        public b() {
        }

        public void a(boolean z11, String str) {
            if (GridTradeAiView.this.f19520m != null) {
                GridTradeAiView.this.f19520m.i(z11, str);
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
                com.hbg.module.exchange.grid.ui.GridTradeAiView r1 = com.hbg.module.exchange.grid.ui.GridTradeAiView.this
                java.lang.String r1 = r1.f19521n
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
                com.hbg.module.exchange.grid.ui.GridTradeAiView r1 = com.hbg.module.exchange.grid.ui.GridTradeAiView.this
                com.huobi.view.bubbleseekbar.BubbleSeekBar r1 = r1.f19510c
                r1.setProgress(r0)
                com.hbg.module.exchange.grid.ui.GridTradeAiView r0 = com.hbg.module.exchange.grid.ui.GridTradeAiView.this
                com.hbg.module.exchange.grid.ui.GridTradeAiView$c r0 = r0.f19520m
                if (r0 == 0) goto L_0x004d
                com.hbg.module.exchange.grid.ui.GridTradeAiView r0 = com.hbg.module.exchange.grid.ui.GridTradeAiView.this
                com.hbg.module.exchange.grid.ui.GridTradeAiView$c r0 = r0.f19520m
                r0.n(r5)
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.exchange.grid.ui.GridTradeAiView.b.onTextChanged(java.lang.String):void");
        }
    }

    public interface c {
        void a();

        void b(View view);

        void e(View view);

        void i(boolean z11, String str);

        void n(String str);
    }

    public GridTradeAiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        c cVar = this.f19520m;
        if (cVar != null) {
            cVar.e(findViewById(R$id.id_grid_trade_ai_title_i));
        }
        vc.b.a().d("5836", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        c cVar = this.f19520m;
        if (cVar != null) {
            cVar.b(findViewById(R$id.id_grid_trade_ai_content_money_title_i));
        }
        vc.b.a().d("5837", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getGridNum() {
        GridAiQuote gridAiQuote = this.f19519l;
        if (gridAiQuote != null) {
            return gridAiQuote.getGridNum();
        }
        return 0;
    }

    public String getGridRate() {
        return this.f19517j.getText().toString();
    }

    public String getInvestQuoteAmount() {
        return this.f19511d.getText();
    }

    public String getMaxPrice() {
        GridAiQuote gridAiQuote = this.f19519l;
        if (gridAiQuote != null) {
            return gridAiQuote.getMaxPrice();
        }
        return null;
    }

    public String getMinPrice() {
        GridAiQuote gridAiQuote = this.f19519l;
        if (gridAiQuote != null) {
            return gridAiQuote.getMinPrice();
        }
        return null;
    }

    public int getRunType() {
        GridAiQuote gridAiQuote = this.f19519l;
        if (gridAiQuote != null) {
            return gridAiQuote.getRunType();
        }
        return 0;
    }

    public final String j(String str) {
        return m.Q(str, 2, 1);
    }

    public void k() {
        this.f19511d.k();
    }

    public void l() {
        this.f19511d.setInputText("");
        this.f19510c.setProgress(0.0f);
    }

    public void m(GridAiQuote gridAiQuote) {
        this.f19519l = gridAiQuote;
        if (TextUtils.isEmpty(gridAiQuote.getYieldRate())) {
            this.f19514g.setText("--");
        } else {
            this.f19514g.setText(j(gridAiQuote.getYieldRate()));
        }
        if (TextUtils.isEmpty(gridAiQuote.getSymbol())) {
            this.f19515h.setText("--");
        } else {
            int e11 = PrecisionUtil.e(gridAiQuote.getSymbol());
            String m11 = m.m(gridAiQuote.getMinPrice(), e11);
            String m12 = m.m(gridAiQuote.getMaxPrice(), e11);
            TextView textView = this.f19515h;
            textView.setText(m11 + " - " + m12);
        }
        if (gridAiQuote.getGridNum() <= 0) {
            this.f19516i.setText("--");
        } else {
            this.f19516i.setText(String.valueOf(gridAiQuote.getGridNum()));
        }
        if (!TextUtils.isEmpty(gridAiQuote.getPerMinProfitRate()) && !TextUtils.isEmpty(gridAiQuote.getPerMaxProfitRate())) {
            TextView textView2 = this.f19517j;
            textView2.setText(j(gridAiQuote.getPerMinProfitRate()) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j(gridAiQuote.getPerMaxProfitRate()));
        } else if (!TextUtils.isEmpty(gridAiQuote.getPerMinProfitRate())) {
            this.f19517j.setText(j(gridAiQuote.getPerMinProfitRate()));
        } else if (!TextUtils.isEmpty(gridAiQuote.getPerMaxProfitRate())) {
            this.f19517j.setText(j(gridAiQuote.getPerMaxProfitRate()));
        } else {
            this.f19517j.setText("--");
        }
    }

    public void n(String str) {
        if (!TextUtils.isEmpty(str)) {
            int z11 = PrecisionUtil.z(str);
            this.f19522o = z11;
            this.f19511d.setFloatPrecision(z11);
        }
    }

    public void setActivity(GridTradeActivity gridTradeActivity) {
        this.f19509b = gridTradeActivity;
        this.f19511d.setActivity(gridTradeActivity);
    }

    public void setAvailable(String str) {
        this.f19521n = str;
        TextView textView = this.f19513f;
        textView.setText(str + " " + k.C().z(this.f19518k));
    }

    public void setCallback(c cVar) {
        this.f19520m = cVar;
    }

    public void setMinCapitalQuote(String str) {
        this.f19511d.setInputHint(str);
    }

    public void setQuoteCurrency(String str) {
        this.f19518k = StringUtils.i(str);
        this.f19511d.setUnit(k.C().z(this.f19518k));
        TextView textView = this.f19512e;
        textView.setText(getResources().getString(R$string.n_grid_trade_price_range) + "(" + k.C().z(this.f19518k) + ")");
        if (TextUtils.isEmpty(this.f19521n)) {
            setAvailable("--");
        }
    }

    public GridTradeAiView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R$layout.grid_trade_ai_view, this);
        this.f19510c = (BubbleSeekBar) findViewById(R$id.id_grid_trade_ai_seekBar);
        this.f19511d = (GridTradeInputView) findViewById(R$id.id_grid_trade_ai_input_view);
        this.f19512e = (TextView) findViewById(R$id.id_grid_trade_ai_content_range_title_tv);
        this.f19513f = (TextView) findViewById(R$id.id_grid_trade_ai_available_tv);
        this.f19514g = (TextView) findViewById(R$id.id_grid_trade_ai_year_percent_tv);
        this.f19515h = (TextView) findViewById(R$id.id_grid_trade_ai_content_range_tv);
        this.f19516i = (TextView) findViewById(R$id.id_grid_trade_ai_content_size_tv);
        this.f19517j = (TextView) findViewById(R$id.id_grid_trade_ai_content_money_tv);
        TextView textView = (TextView) findViewById(R$id.id_grid_trade_ai_title_tv);
        textView.setText(String.format(Locale.US, getResources().getString(R$string.n_grid_trade_year_rate), new Object[]{BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP}));
        this.f19517j.setTextColor(getResources().getColor(w.h()));
        this.f19510c.setThumbBitmap(R$drawable.contract_slider);
        p pVar = new p(this);
        textView.setOnClickListener(pVar);
        findViewById(R$id.id_grid_trade_ai_title_i).setOnClickListener(pVar);
        q qVar = new q(this);
        findViewById(R$id.id_grid_trade_ai_content_money_title_tv).setOnClickListener(qVar);
        findViewById(R$id.id_grid_trade_ai_content_money_title_i).setOnClickListener(qVar);
        this.f19510c.setOnProgressChangedListener(new a());
        this.f19511d.setCallback(new b());
    }
}
