package com.huobi.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.module.otc.R$styleable;
import java.util.Locale;
import pro.huobi.R;

public class LanguageView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public Locale f42071b;

    /* renamed from: c  reason: collision with root package name */
    public ImageButton f42072c;

    /* renamed from: d  reason: collision with root package name */
    public BaseLang f42073d;

    /* renamed from: e  reason: collision with root package name */
    public String f42074e;

    public LanguageView(Context context) {
        super(context);
        c();
    }

    public void a() {
        this.f42072c.setVisibility(4);
    }

    public final void b(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LanguageView, i11, 0);
        this.f42074e = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.app_language_view_item, this);
        this.f42072c = (ImageButton) findViewById(R.id.f16913ib);
        ((TextView) findViewById(R.id.f16920tv)).setText(this.f42074e);
    }

    public void d() {
        this.f42072c.setVisibility(0);
    }

    public BaseLang getLang() {
        return this.f42073d;
    }

    public Locale getLocale() {
        return this.f42071b;
    }

    public boolean isSelected() {
        return this.f42072c.getVisibility() == 0;
    }

    public void setLang(BaseLang baseLang) {
        this.f42073d = baseLang;
    }

    public void setLocale(Locale locale) {
        this.f42071b = locale;
    }

    public void setText(String str) {
        this.f42074e = str;
        ((TextView) findViewById(R.id.f16920tv)).setText(this.f42074e);
    }

    public LanguageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context, attributeSet, i11);
        c();
    }
}
