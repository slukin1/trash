package com.huobi.share.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c.a;
import com.hbg.lib.core.util.w;
import com.hbg.lib.widgets.CommonProgressBar;
import com.hbg.lib.widgets.R$styleable;
import pro.huobi.R;

public class RiseDownProgressBar extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f81032b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f81033c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81034d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81035e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81036f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81037g;

    /* renamed from: h  reason: collision with root package name */
    public CommonProgressBar f81038h;

    /* renamed from: i  reason: collision with root package name */
    public double f81039i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f81040j;

    public RiseDownProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        Drawable drawable;
        if (attributeSet != null) {
            this.f81040j = getContext().obtainStyledAttributes(attributeSet, R$styleable.CommonProgressBar, 0, 0).getDrawable(9);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_rise_down_progressbar, this, true);
        this.f81032b = (ImageView) findViewById(R.id.indicator_rise_iv);
        this.f81033c = (ImageView) findViewById(R.id.indicator_down_iv);
        this.f81034d = (TextView) findViewById(R.id.indicator_rise_tv);
        this.f81035e = (TextView) findViewById(R.id.indicator_down_tv);
        this.f81036f = (TextView) findViewById(R.id.indicator_rise_number_tv);
        this.f81037g = (TextView) findViewById(R.id.indicator_down_number_tv);
        this.f81038h = (CommonProgressBar) findViewById(R.id.indicator_progressBar);
        if (w.l()) {
            ImageView imageView = this.f81032b;
            if (imageView != null) {
                imageView.setImageDrawable(a.b(getContext(), R.drawable.share_rise_red));
            }
            ImageView imageView2 = this.f81033c;
            if (imageView2 != null) {
                imageView2.setImageDrawable(a.b(getContext(), R.drawable.share_down_green));
            }
            TextView textView = this.f81034d;
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.color_down));
            }
            TextView textView2 = this.f81036f;
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.getColor(getContext(), R.color.color_down));
            }
            TextView textView3 = this.f81035e;
            if (textView3 != null) {
                textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.color_rise));
            }
            TextView textView4 = this.f81037g;
            if (textView4 != null) {
                textView4.setTextColor(ContextCompat.getColor(getContext(), R.color.color_rise));
            }
            CommonProgressBar commonProgressBar = this.f81038h;
            if (commonProgressBar != null) {
                commonProgressBar.setProgressBgColor(ContextCompat.getColor(getContext(), R.color.color_rise));
                this.f81038h.setProgressColor(ContextCompat.getColor(getContext(), R.color.color_down));
            }
        } else {
            ImageView imageView3 = this.f81032b;
            if (imageView3 != null) {
                imageView3.setImageDrawable(a.b(getContext(), R.drawable.share_rise_green));
            }
            ImageView imageView4 = this.f81033c;
            if (imageView4 != null) {
                imageView4.setImageDrawable(a.b(getContext(), R.drawable.share_down_red));
            }
            TextView textView5 = this.f81034d;
            if (textView5 != null) {
                textView5.setTextColor(ContextCompat.getColor(getContext(), R.color.color_rise));
            }
            TextView textView6 = this.f81036f;
            if (textView6 != null) {
                textView6.setTextColor(ContextCompat.getColor(getContext(), R.color.color_rise));
            }
            TextView textView7 = this.f81035e;
            if (textView7 != null) {
                textView7.setTextColor(ContextCompat.getColor(getContext(), R.color.color_down));
            }
            TextView textView8 = this.f81037g;
            if (textView8 != null) {
                textView8.setTextColor(ContextCompat.getColor(getContext(), R.color.color_down));
            }
            CommonProgressBar commonProgressBar2 = this.f81038h;
            if (commonProgressBar2 != null) {
                commonProgressBar2.setProgressBgColor(ContextCompat.getColor(getContext(), R.color.color_down));
                this.f81038h.setProgressColor(ContextCompat.getColor(getContext(), R.color.color_rise));
            }
        }
        b(0, 0);
        CommonProgressBar commonProgressBar3 = this.f81038h;
        if (commonProgressBar3 != null && (drawable = this.f81040j) != null) {
            commonProgressBar3.setThumbImage(drawable);
        }
    }

    public void b(int i11, int i12) {
        if (i11 > 0 || i12 > 0) {
            this.f81039i = ((double) i11) / ((double) (i11 + i12));
            TextView textView = this.f81036f;
            if (textView != null) {
                textView.setText(String.valueOf(i11));
            }
            TextView textView2 = this.f81037g;
            if (textView2 != null) {
                textView2.setText(String.valueOf(i12));
            }
            this.f81039i *= 100.0d;
        } else {
            this.f81036f.setText("0");
            this.f81037g.setText("0");
            this.f81039i = 50.0d;
        }
        CommonProgressBar commonProgressBar = this.f81038h;
        if (commonProgressBar != null) {
            commonProgressBar.i(this.f81039i, true);
        }
    }

    public RiseDownProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(attributeSet);
    }
}
