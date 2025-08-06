package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class OtcCancelReasonTextView extends AutoSizeTextView {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f71566b;

        public a(float f11) {
            this.f71566b = f11;
        }

        public void run() {
            ViewGroup.LayoutParams layoutParams = OtcCancelReasonTextView.this.getLayoutParams();
            OtcCancelReasonTextView otcCancelReasonTextView = OtcCancelReasonTextView.this;
            layoutParams.width = (int) (this.f71566b + ((float) otcCancelReasonTextView.getPaddingLeft()) + ((float) otcCancelReasonTextView.getPaddingRight()));
            otcCancelReasonTextView.setLayoutParams(layoutParams);
        }
    }

    public OtcCancelReasonTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void d(String str, int i11) {
        if (i11 > 0 && str != null && str.length() != 0) {
            int paddingLeft = (i11 - getPaddingLeft()) - getPaddingRight();
            this.f71021d.set(getPaint());
            float textSize = getTextSize();
            if (textSize > this.f71019b) {
                this.f71021d.setTextSize(textSize);
                float f11 = (float) paddingLeft;
                if (this.f71021d.measureText(str) <= f11) {
                    setTextSize(0, textSize);
                    return;
                }
                this.f71021d.setTextSize(this.f71019b);
                setMaxLines(2);
                float measureText = this.f71021d.measureText(str);
                setTextSize(0, this.f71019b);
                if (measureText < f11) {
                    post(new a(measureText));
                }
            }
        }
    }

    public OtcCancelReasonTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
