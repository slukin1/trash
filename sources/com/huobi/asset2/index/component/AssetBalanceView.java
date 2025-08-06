package com.huobi.asset2.index.component;

import al.p;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.NumberAnimView;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.otc.R$styleable;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.m;
import xh.b;
import xh.c;

public class AssetBalanceView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public NumberAnimView f42611b;

    /* renamed from: c  reason: collision with root package name */
    public NumberAnimView f42612c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42613d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42614e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42615f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42616g;

    /* renamed from: h  reason: collision with root package name */
    public int f42617h;

    /* renamed from: i  reason: collision with root package name */
    public int f42618i;

    /* renamed from: j  reason: collision with root package name */
    public int f42619j;

    public AssetBalanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static String f(String str) {
        int indexOf = str.indexOf(46);
        if (indexOf <= 0) {
            return str;
        }
        int length = str.length();
        return "0." + str.substring(indexOf + 1, length);
    }

    public static String g(String str) {
        int indexOf = str.indexOf(46);
        if (indexOf <= 0) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String i(String str) {
        if (this.f42615f) {
            str = d(str);
        }
        if (!this.f42616g || !m.a0(str)) {
            return str;
        }
        String x11 = LegalCurrencyConfigUtil.x();
        StringBuilder sb2 = new StringBuilder();
        if (!p.u()) {
            x11 = "";
        }
        sb2.append(x11);
        sb2.append(str);
        return sb2.toString();
    }

    public final void c() {
        this.f42611b.setCallback(new b(this));
        this.f42612c.setCallback(c.f61602a);
    }

    public final String d(String str) {
        int length;
        int i11;
        if (!m.a0(str) || (length = str.length()) <= 3) {
            return str;
        }
        if (length % 3 == 0) {
            i11 = (length / 3) - 1;
        } else {
            i11 = length / 3;
        }
        int i12 = i11 + length;
        char[] cArr = new char[i12];
        int i13 = length - 1;
        int i14 = 0;
        for (int i15 = i12 - 1; i15 >= 0; i15--) {
            if (i14 == 3) {
                cArr[i15] = ',';
                i14 = 0;
            } else {
                cArr[i15] = str.charAt(i13);
                i13--;
                i14++;
            }
        }
        return String.copyValueOf(cArr);
    }

    public final int e(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void h() {
        this.f42611b = (NumberAnimView) findViewById(R$id.integer_text);
        this.f42612c = (NumberAnimView) findViewById(R$id.decimal_text);
        setTextColor(getContext().getResources().getColor(this.f42619j));
        this.f42611b.setTextSize(this.f42617h);
        if (this.f42614e) {
            this.f42612c.setTextSize(this.f42618i);
        } else {
            this.f42612c.setTextSize(this.f42617h);
        }
    }

    public void k(NumberAnimView numberAnimView, String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            numberAnimView.setText("--");
        } else if (z11) {
            numberAnimView.setNumber(m.a(str));
            numberAnimView.f();
        } else {
            numberAnimView.setText(str);
        }
    }

    public void setAnimation(boolean z11) {
        this.f42613d = z11;
    }

    public void setDecimalTextSize(int i11) {
        this.f42618i = i11;
        if (this.f42614e) {
            this.f42612c.setTextSize(i11);
        } else {
            this.f42612c.setTextSize(this.f42617h);
        }
    }

    public void setDiffNumber(boolean z11) {
        this.f42614e = z11;
    }

    public void setFiat(boolean z11) {
        this.f42616g = z11;
    }

    public void setIntegerTextSize(int i11) {
        this.f42617h = i11;
        this.f42611b.setTextSize(i11);
    }

    public void setSubText(boolean z11) {
        this.f42615f = z11;
    }

    public void setText(String str) {
        ViewUtil.m(this.f42612c, false);
        this.f42611b.setText(str);
    }

    public void setTextColor(int i11) {
        this.f42611b.setTextColor(i11);
        this.f42612c.setTextColor(i11);
    }

    public void setTextNumber(String str) {
        ViewUtil.m(this.f42612c, this.f42614e);
        if (!this.f42614e) {
            k(this.f42611b, str, this.f42613d);
        } else if (!m.a0(str)) {
            k(this.f42611b, "0", this.f42613d);
        } else if (str.indexOf(46) == -1) {
            k(this.f42611b, str, this.f42613d);
        } else {
            k(this.f42611b, g(str), this.f42613d);
            k(this.f42612c, f(str), this.f42613d);
        }
    }

    public AssetBalanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.asset_blance_text_view, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AssetBalanceText, i11, 0);
        this.f42613d = obtainStyledAttributes.getBoolean(com.hbg.module.asset.R$styleable.AssetBalanceText_is_animation, false);
        this.f42615f = obtainStyledAttributes.getBoolean(com.hbg.module.asset.R$styleable.AssetBalanceText_is_sub_text, false);
        this.f42614e = obtainStyledAttributes.getBoolean(com.hbg.module.asset.R$styleable.AssetBalanceText_is_diff_number, false);
        this.f42616g = obtainStyledAttributes.getBoolean(com.hbg.module.asset.R$styleable.AssetBalanceText_is_start_fiat, false);
        this.f42619j = obtainStyledAttributes.getResourceId(com.hbg.module.asset.R$styleable.AssetBalanceText_asset_balance_text_color, R$color.baseColorPrimaryText);
        this.f42617h = obtainStyledAttributes.getDimensionPixelOffset(com.hbg.module.asset.R$styleable.AssetBalanceText_integer_text_size, e(20.0f));
        this.f42618i = obtainStyledAttributes.getDimensionPixelOffset(com.hbg.module.asset.R$styleable.AssetBalanceText_decimal_text_size, e(16.0f));
        obtainStyledAttributes.recycle();
        h();
        c();
    }
}
