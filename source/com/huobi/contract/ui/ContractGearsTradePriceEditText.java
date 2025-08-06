package com.huobi.contract.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$font;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$styleable;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.contract.ContractModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import dj.m;
import dj.n;
import dj.o;

public class ContractGearsTradePriceEditText extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f43237b;

    /* renamed from: c  reason: collision with root package name */
    public int f43238c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f43239d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f43240e;

    /* renamed from: f  reason: collision with root package name */
    public AppCompatTextView f43241f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f43242g;

    /* renamed from: h  reason: collision with root package name */
    public TradeType f43243h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43244i;

    /* renamed from: j  reason: collision with root package name */
    public View f43245j;

    /* renamed from: k  reason: collision with root package name */
    public View f43246k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f43247l;

    /* renamed from: m  reason: collision with root package name */
    public k4 f43248m;

    /* renamed from: n  reason: collision with root package name */
    public c f43249n;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (ContractGearsTradePriceEditText.this.f43248m != null) {
                ContractGearsTradePriceEditText.this.f43248m.onFocusChange(view, z11);
            }
            if (z11) {
                if (ContractGearsTradePriceEditText.this.f43237b == 2) {
                    ContractGearsTradePriceEditText.this.f43239d.setText("");
                }
                ContractGearsTradePriceEditText.this.setPriceInputType(1);
            }
            ContractGearsTradePriceEditText.this.g();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            ContractGearsTradePriceEditText.this.g();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public interface c {
        void a();

        void b();
    }

    public ContractGearsTradePriceEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(View view) {
        this.f43239d.setText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        c cVar = this.f43249n;
        if (cVar != null) {
            cVar.b();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        c cVar = this.f43249n;
        if (cVar != null) {
            cVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void g() {
        if (!this.f43247l || !this.f43239d.hasFocus() || this.f43239d.length() <= 0) {
            this.f43246k.setVisibility(8);
        } else {
            this.f43246k.setVisibility(0);
        }
    }

    public CharSequence getCurrentPriceTypeText() {
        return this.f43241f.getText();
    }

    public EditText getEditText() {
        return this.f43239d;
    }

    public int getLastTradePriceType() {
        return this.f43238c;
    }

    public int getTradePriceType() {
        return this.f43237b;
    }

    public final void h(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_contract_gears_trade_price_editext, this, true);
        this.f43239d = (EditText) findViewById(R$id.input_price_et);
        this.f43240e = (LinearLayout) findViewById(R$id.gears_change_container);
        i();
        this.f43242g = (ImageView) findViewById(R$id.gears_arrow_iv);
        this.f43244i = (TextView) findViewById(R$id.label_price_tv);
        this.f43246k = findViewById(R$id.inputClearBtn);
        this.f43245j = findViewById(R$id.inputPriceLayout);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ContractGearsTradePriceEditText);
        if (obtainStyledAttributes != null) {
            this.f43239d.setHint(obtainStyledAttributes.getString(R$styleable.ContractGearsTradePriceEditText_contract_gears_price_eidttext_hint));
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ContractGearsTradePriceEditText_contract_gears_price_editext_paddingleft, PixelUtils.a(10.0f));
            EditText editText = this.f43239d;
            editText.setPadding(dimensionPixelSize, editText.getTop(), this.f43239d.getRight(), this.f43239d.getBottom());
            obtainStyledAttributes.recycle();
        }
        j();
    }

    @SuppressLint({"RestrictedApi"})
    public final void i() {
        this.f43241f = new AppCompatTextView(getContext());
        this.f43241f.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f43241f.setAutoSizeTextTypeUniformWithConfiguration(6, 14, 1, 1);
        this.f43241f.setTextSize(14, 1.0f);
        this.f43241f.setMaxLines(1);
        this.f43241f.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f43241f.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
        this.f43240e.removeAllViews();
        this.f43240e.addView(this.f43241f);
    }

    public final void j() {
        this.f43239d.setOnFocusChangeListener(new a());
        this.f43239d.addTextChangedListener(new b());
        this.f43246k.setOnClickListener(new n(this));
        this.f43242g.setOnClickListener(new o(this));
        this.f43240e.setOnClickListener(new m(this));
    }

    public boolean k() {
        int i11 = this.f43237b;
        return 2 == i11 || 3 == i11 || 4 == i11 || 5 == i11 || 8 == i11;
    }

    public void o(boolean z11) {
        this.f43239d.setVisibility(0);
        this.f43245j.setVisibility(0);
        this.f43240e.setVisibility(8);
        this.f43242g.setVisibility(8);
        if (z11) {
            this.f43239d.setEnabled(false);
            this.f43245j.setEnabled(false);
            return;
        }
        this.f43239d.setEnabled(true);
        this.f43245j.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (BaseModuleConfig.a().a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        ContractModuleConfig.a().h(this.f43243h, getContext());
        return true;
    }

    public void p(int i11) {
        this.f43242g.setImageResource(i11);
    }

    public void setCallback(c cVar) {
        this.f43249n = cVar;
    }

    public void setClearEnable(boolean z11) {
        this.f43247l = z11;
    }

    public void setCurrentPriceTypeText(String str) {
        i();
        this.f43241f.setText(str);
    }

    public void setHintText(String str) {
        this.f43239d.setHint(str);
    }

    public void setIconImgVisible(boolean z11) {
        ViewUtil.m(this.f43242g, z11);
    }

    public void setLabel(String str) {
        this.f43244i.setText(str);
    }

    public void setLabelViewEnd(int i11) {
        ((ViewGroup.MarginLayoutParams) this.f43244i.getLayoutParams()).setMarginEnd(i11);
        this.f43244i.requestLayout();
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f43248m = k4Var;
    }

    public void setPriceInputType(int i11) {
        this.f43238c = this.f43237b;
        this.f43237b = i11;
        switch (i11) {
            case 1:
                this.f43239d.setEnabled(true);
                this.f43245j.setEnabled(true);
                this.f43239d.setVisibility(0);
                this.f43245j.setVisibility(0);
                this.f43240e.setVisibility(8);
                this.f43242g.setVisibility(8);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                this.f43239d.setEnabled(false);
                this.f43245j.setEnabled(false);
                this.f43239d.setVisibility(8);
                this.f43245j.setVisibility(8);
                this.f43240e.setVisibility(0);
                if (this.f43243h == TradeType.OPTION) {
                    this.f43242g.setVisibility(8);
                    return;
                } else {
                    this.f43242g.setVisibility(0);
                    return;
                }
            case 6:
                this.f43239d.setVisibility(8);
                this.f43245j.setVisibility(8);
                this.f43240e.setVisibility(0);
                this.f43242g.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public void setTradeType(TradeType tradeType) {
        this.f43243h = tradeType;
    }

    public ContractGearsTradePriceEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43237b = 1;
        this.f43238c = 1;
        this.f43243h = TradeType.CONTRACT;
        h(attributeSet);
    }

    public void setHintText(int i11) {
        this.f43239d.setHint(i11);
    }
}
