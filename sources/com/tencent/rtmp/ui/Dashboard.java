package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Dashboard extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f48655a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f48656b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f48657c;

    /* renamed from: d  reason: collision with root package name */
    private final SimpleDateFormat f48658d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollView f48659e;

    /* renamed from: f  reason: collision with root package name */
    private int f48660f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48661g;

    public Dashboard(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(int i11, int i12, int i13, int i14) {
        TextView textView = this.f48656b;
        if (textView != null) {
            textView.setPadding(i11, i12, i13, 0);
        }
        ScrollView scrollView = this.f48659e;
        if (scrollView != null) {
            scrollView.setPadding(i11, 0, i13, i14);
        }
    }

    public void setEventTextSize(float f11) {
        TextView textView = this.f48657c;
        if (textView != null) {
            textView.setTextSize(f11);
        }
    }

    public void setMessageMaxLength(int i11) {
        this.f48660f = i11;
    }

    public void setShowLevel(int i11) {
        if (i11 == 0) {
            TextView textView = this.f48656b;
            if (textView != null) {
                textView.setVisibility(4);
            }
            ScrollView scrollView = this.f48659e;
            if (scrollView != null) {
                scrollView.setVisibility(4);
            }
            setVisibility(4);
        } else if (i11 != 1) {
            a();
            this.f48656b.setVisibility(0);
            this.f48659e.setVisibility(0);
            setVisibility(0);
        } else {
            a();
            this.f48656b.setVisibility(0);
            this.f48659e.setVisibility(4);
            setVisibility(0);
        }
    }

    public void setStatusText(CharSequence charSequence) {
        TextView textView = this.f48656b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setStatusTextSize(float f11) {
        TextView textView = this.f48656b;
        if (textView != null) {
            textView.setTextSize(f11);
        }
    }

    public Dashboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48655a = new StringBuilder();
        this.f48658d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        this.f48660f = 3000;
        this.f48661g = false;
        setOrientation(1);
        setVisibility(8);
    }

    private void a() {
        if (this.f48656b == null) {
            this.f48656b = new TextView(getContext());
            this.f48657c = new TextView(getContext());
            this.f48659e = new ScrollView(getContext());
            this.f48656b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f48656b.setTextColor(-49023);
            this.f48656b.setTypeface(Typeface.MONOSPACE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f48659e.setPadding(0, 10, 0, 0);
            this.f48659e.setLayoutParams(layoutParams);
            this.f48659e.setVerticalScrollBarEnabled(true);
            this.f48659e.setScrollbarFadingEnabled(true);
            this.f48657c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f48657c.setTextColor(-49023);
            this.f48659e.addView(this.f48657c);
            addView(this.f48656b);
            addView(this.f48659e);
            if (this.f48655a.length() <= 0) {
                this.f48655a.append("liteav sdk version:\n");
            }
            this.f48657c.setText(this.f48655a.toString());
        }
    }
}
