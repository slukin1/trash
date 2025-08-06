package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.text.style.SubscriptSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.regex.Matcher;

public class SubscriptTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public SpannableStringBuilder f71612b;

    /* renamed from: c  reason: collision with root package name */
    public SubscriptSpan f71613c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeSizeSpan f71614d;

    /* renamed from: e  reason: collision with root package name */
    public Paint.FontMetrics f71615e;

    public SubscriptTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void init() {
        if (this.f71612b == null) {
            this.f71612b = new SpannableStringBuilder();
            this.f71613c = new SubscriptSpan() {
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.getFontMetrics(SubscriptTextView.this.f71615e);
                    textPaint.baselineShift = (int) (((float) textPaint.baselineShift) + SubscriptTextView.this.f71615e.bottom);
                }

                public void updateMeasureState(TextPaint textPaint) {
                    textPaint.getFontMetrics(SubscriptTextView.this.f71615e);
                    textPaint.baselineShift = (int) (((float) textPaint.baselineShift) + SubscriptTextView.this.f71615e.bottom);
                }
            };
            this.f71614d = new RelativeSizeSpan(0.8f);
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null || charSequence.length() == 0 || !SubscriptHelper.b()) {
            super.setText(charSequence, bufferType);
            return;
        }
        init();
        Matcher matcher = SubscriptHelper.f71611a.matcher(charSequence);
        if (matcher.find()) {
            this.f71612b.clear();
            String group = matcher.group();
            int start = matcher.start();
            int a11 = SubscriptHelper.a(group);
            this.f71612b.append(charSequence);
            int i11 = start + 2;
            this.f71612b.delete(i11, (i11 + a11) - 1);
            this.f71612b.insert(i11, String.valueOf(a11));
            this.f71612b.setSpan(this.f71614d, i11, String.valueOf(a11).length() + i11, 33);
            this.f71612b.setSpan(this.f71613c, i11, String.valueOf(a11).length() + i11, 33);
            super.setText(this.f71612b, bufferType);
            return;
        }
        super.setText(charSequence, bufferType);
    }

    public SubscriptTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscriptTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71615e = new Paint.FontMetrics();
    }
}
