package com.huobi.tradenew.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.R$styleable;
import com.huobi.trade.helper.l;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gj.d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;

public class TradeHeadView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f83156b;

    /* renamed from: c  reason: collision with root package name */
    public View f83157c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83158d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f83159e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f83160f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f83161g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f83162h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f83163i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f83164j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f83165k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f83166l;

    /* renamed from: m  reason: collision with root package name */
    public View f83167m;

    /* renamed from: n  reason: collision with root package name */
    public View f83168n;

    /* renamed from: o  reason: collision with root package name */
    public String f83169o;

    /* renamed from: p  reason: collision with root package name */
    public TradeType f83170p;

    /* renamed from: q  reason: collision with root package name */
    public a f83171q;

    /* renamed from: r  reason: collision with root package name */
    public int f83172r;

    /* renamed from: s  reason: collision with root package name */
    public int[] f83173s;

    /* renamed from: t  reason: collision with root package name */
    public int f83174t;

    /* renamed from: u  reason: collision with root package name */
    public int f83175u;

    /* renamed from: v  reason: collision with root package name */
    public View f83176v;

    /* renamed from: w  reason: collision with root package name */
    public View.OnClickListener f83177w;

    /* renamed from: x  reason: collision with root package name */
    public TextPaint f83178x;

    public interface a {
        void D(View view);

        void Q(View view);

        void R(View view);

        void a0(View view);

        void e(View view);

        void g0(View view, String str);

        void s(View view);
    }

    public TradeHeadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.s(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.Q(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.s(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(Void voidR) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.D(this.f83159e);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.a0(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.R(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        is.a.j("4307", (Map<String, Object>) null, "1000048");
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.e(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        a aVar = this.f83171q;
        if (aVar != null) {
            aVar.g0(view, this.f83169o);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        View.OnClickListener onClickListener = this.f83177w;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int[] getRightPopIvLocation() {
        int[] iArr = new int[2];
        this.f83159e.getLocationOnScreen(iArr);
        return iArr;
    }

    public int getRightPopIvMarginRight() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f83159e.getLayoutParams();
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public int getRightPopIvWidth() {
        return this.f83159e.getWidth();
    }

    public int[] getSymbolChangeIvLocation() {
        int[] iArr = new int[2];
        this.f83162h.getLocationOnScreen(iArr);
        return iArr;
    }

    public int getSymbolChangeIvWidth() {
        return this.f83162h.getWidth();
    }

    public ImageView getTradeKlineIv() {
        return this.f83160f;
    }

    public View getTradeRightPopIv() {
        return this.f83159e;
    }

    public final void j() {
        this.f83156b.setOnClickListener(new o1(this));
        this.f83160f.setOnClickListener(new u1(this));
        this.f83157c.setOnClickListener(new q1(this));
        dw.a.a(this.f83159e).throttleFirst(1, TimeUnit.SECONDS).subscribe(new v1(this));
        this.f83161g.setOnClickListener(new t1(this));
        this.f83162h.setOnClickListener(new s1(this));
        this.f83166l.setOnClickListener(new r1(this));
        p1 p1Var = new p1(this);
        this.f83176v.setOnClickListener(new n1(this));
        this.f83163i.setOnClickListener(p1Var);
        this.f83164j.setOnClickListener(p1Var);
    }

    public final int k(int i11) {
        int measureText;
        int measureText2;
        this.f83178x.set(this.f83158d.getPaint());
        int measureText3 = ((int) this.f83178x.measureText(this.f83158d.getText().toString())) - i11;
        if (i11 < 0) {
            do {
                float textSize = this.f83178x.getTextSize();
                int i12 = this.f83174t;
                if (textSize >= ((float) i12)) {
                    return i12;
                }
                TextPaint textPaint = this.f83178x;
                textPaint.setTextSize(textPaint.getTextSize() + 1.0f);
                measureText2 = (int) this.f83178x.measureText(this.f83158d.getText().toString());
                if (measureText2 == measureText3) {
                    return (int) this.f83178x.getTextSize();
                }
            } while (measureText2 <= measureText3);
            return ((int) this.f83178x.getTextSize()) - 1;
        }
        do {
            float textSize2 = this.f83178x.getTextSize();
            int i13 = this.f83175u;
            if (textSize2 <= ((float) i13)) {
                return i13;
            }
            TextPaint textPaint2 = this.f83178x;
            textPaint2.setTextSize(textPaint2.getTextSize() - 1.0f);
            measureText = (int) this.f83178x.measureText(this.f83158d.getText().toString());
            if (measureText == measureText3) {
                return (int) this.f83178x.getTextSize();
            }
        } while (measureText >= measureText3);
        return ((int) this.f83178x.getTextSize()) - 1;
    }

    public final void l(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_trade_head_new, this, true);
        this.f83156b = (ImageView) findViewById(R.id.trade_drawer_iv);
        this.f83158d = (TextView) findViewById(R.id.trade_head_symbol_tv);
        this.f83157c = findViewById(R.id.trade_drawer_iv_wapper);
        this.f83160f = (ImageView) findViewById(R.id.trade_kline_iv);
        this.f83159e = (ImageView) findViewById(R.id.trade_right_pop_iv);
        this.f83161g = (ImageView) findViewById(R.id.trade_description_iv);
        this.f83162h = (ImageView) findViewById(R.id.trade_symbol_change_iv);
        this.f83165k = (TextView) findViewById(R.id.trade_price_change_tv);
        this.f83176v = findViewById(R.id.ll_reminder);
        this.f83168n = findViewById(R.id.divider_view);
        this.f83166l = (TextView) findViewById(R.id.margin_lever_tv);
        this.f83163i = (ImageView) findViewById(R.id.grid_entrance_iv);
        this.f83164j = (ImageView) findViewById(R.id.grid_entrance_new_iv);
        this.f83167m = findViewById(R.id.ll_right);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TradeHeadView);
        if (obtainStyledAttributes != null) {
            int integer = obtainStyledAttributes.getInteger(0, 2);
            if (integer == 0) {
                this.f83161g.setVisibility(0);
            } else if (integer == 1) {
                this.f83161g.setVisibility(4);
            } else if (integer != 2) {
                this.f83161g.setVisibility(8);
            } else {
                this.f83161g.setVisibility(8);
            }
            int integer2 = obtainStyledAttributes.getInteger(5, 0);
            if (integer2 == 0) {
                this.f83162h.setVisibility(0);
            } else if (integer2 == 1) {
                this.f83162h.setVisibility(4);
            } else if (integer2 != 2) {
                this.f83162h.setVisibility(8);
            } else {
                this.f83162h.setVisibility(8);
            }
            int integer3 = obtainStyledAttributes.getInteger(4, 2);
            if (integer3 == 0) {
                this.f83176v.setVisibility(0);
            } else if (integer3 != 1) {
                this.f83176v.setVisibility(8);
            } else {
                this.f83176v.setVisibility(4);
            }
            int integer4 = obtainStyledAttributes.getInteger(1, 2);
            if (integer4 == 0) {
                this.f83168n.setVisibility(0);
            } else if (integer4 == 1) {
                this.f83168n.setVisibility(4);
            } else if (integer4 != 2) {
                this.f83168n.setVisibility(8);
            } else {
                this.f83168n.setVisibility(8);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, PixelUtils.a(20.0f));
            this.f83174t = dimensionPixelSize;
            this.f83175u = dimensionPixelSize - PixelUtils.a(8.0f);
            this.f83158d.setTextSize(0, (float) PixelUtils.h((float) this.f83174t));
            obtainStyledAttributes.recycle();
        }
        this.f83172r = PixelUtils.g();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f83165k.getLocationOnScreen(this.f83173s);
        int width = ((this.f83173s[0] + this.f83165k.getWidth()) + this.f83167m.getWidth()) - this.f83172r;
        if (width != 0) {
            if (width >= 0 || this.f83165k.getTextSize() != ((float) this.f83174t)) {
                int k11 = k(width);
                int i15 = this.f83175u;
                if (k11 < i15 || k11 >= (i15 = this.f83174t)) {
                    k11 = i15;
                }
                float f11 = (float) k11;
                if (this.f83158d.getTextSize() != f11) {
                    this.f83158d.setTextSize(0, f11);
                }
            }
        }
    }

    public void setBaseCurrencyText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f83166l.setVisibility(8);
            return;
        }
        this.f83166l.setText(str);
        this.f83166l.setVisibility(0);
    }

    public void setGridEntranceVisible(boolean z11) {
    }

    public void setKlineVisibility(int i11) {
        this.f83160f.setVisibility(i11);
    }

    public void setMarginLeverText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f83166l.setVisibility(8);
        } else if (d.n().G()) {
            this.f83166l.setText(str);
            this.f83166l.setVisibility(0);
        } else {
            this.f83166l.setVisibility(8);
        }
    }

    public void setOnHeadClickListener(a aVar) {
        this.f83171q = aVar;
    }

    public void setOnStClickListener(View.OnClickListener onClickListener) {
        this.f83177w = onClickListener;
    }

    public void setReminderBg(int i11) {
    }

    public void setReminderTvVisible(boolean z11) {
        ViewUtil.m(this.f83176v, z11);
    }

    public void setRightPopVisibility(int i11) {
        this.f83159e.setVisibility(i11);
    }

    public void setSymbol(String str) {
        this.f83169o = str;
    }

    public void setTradePriceChangeTvVisible(boolean z11) {
        ViewUtil.m(this.f83165k, z11);
    }

    public void setTradeType(TradeType tradeType) {
        this.f83170p = tradeType;
    }

    public void v() {
        l.b().e();
    }

    public void w(String str) {
        this.f83158d.setText(str);
    }

    public TradeHeadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f83173s = new int[2];
        this.f83178x = new TextPaint();
        l(attributeSet);
        j();
    }
}
