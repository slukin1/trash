package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;

public class AutoSizeMinMaxTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public float f70996b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f70997c;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f70998b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f70999c;

        public a(int i11, String str) {
            this.f70998b = i11;
            this.f70999c = str;
        }

        public void run() {
            String str;
            if (this.f70998b > 0 && (str = this.f70999c) != null && str.length() != 0) {
                int paddingLeft = AutoSizeMinMaxTextView.this.getPaddingLeft() + AutoSizeMinMaxTextView.this.getPaddingRight();
                int max = Math.max(AutoSizeMinMaxTextView.this.getMaxWidth() - paddingLeft, AutoSizeMinMaxTextView.this.getWidth() - paddingLeft);
                AutoSizeMinMaxTextView autoSizeMinMaxTextView = AutoSizeMinMaxTextView.this;
                autoSizeMinMaxTextView.f70997c.set(autoSizeMinMaxTextView.getPaint());
                float textSize = AutoSizeMinMaxTextView.this.getTextSize();
                AutoSizeMinMaxTextView.this.f70997c.setTextSize(textSize);
                float f11 = (float) max;
                if (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) < f11) {
                    AutoSizeMinMaxTextView.this.setTextSize(0, textSize);
                    float f12 = (float) paddingLeft;
                    if (AutoSizeMinMaxTextView.this.getWidth() != ((int) (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) + f12))) {
                        ViewGroup.LayoutParams layoutParams = AutoSizeMinMaxTextView.this.getLayoutParams();
                        layoutParams.width = Math.max(AutoSizeMinMaxTextView.this.getMinWidth(), (int) (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) + f12));
                        AutoSizeMinMaxTextView.this.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                float f13 = AutoSizeMinMaxTextView.this.f70996b;
                while (true) {
                    if (textSize - f13 <= 0.5f) {
                        break;
                    }
                    textSize = (textSize + f13) / 2.0f;
                    AutoSizeMinMaxTextView.this.f70997c.setTextSize(textSize);
                    if (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) <= f11) {
                        f13 = textSize;
                        break;
                    }
                }
                AutoSizeMinMaxTextView.this.setTextSize(0, f13);
                if (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) > f11) {
                    int i11 = max + paddingLeft;
                    if (AutoSizeMinMaxTextView.this.getWidth() != i11) {
                        ViewGroup.LayoutParams layoutParams2 = AutoSizeMinMaxTextView.this.getLayoutParams();
                        layoutParams2.width = i11;
                        AutoSizeMinMaxTextView.this.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                float f14 = (float) paddingLeft;
                if (((float) AutoSizeMinMaxTextView.this.getWidth()) != AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) + f14) {
                    ViewGroup.LayoutParams layoutParams3 = AutoSizeMinMaxTextView.this.getLayoutParams();
                    layoutParams3.width = (int) (AutoSizeMinMaxTextView.this.f70997c.measureText(this.f70999c) + f14);
                    AutoSizeMinMaxTextView.this.setLayoutParams(layoutParams3);
                }
            }
        }
    }

    public AutoSizeMinMaxTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void d(String str, int i11) {
        post(new a(i11, str));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (i11 != i13) {
            d(getText().toString(), i11);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        d(charSequence.toString(), getWidth());
    }

    public void setMinTextSize(float f11) {
        this.f70996b = f11;
    }

    public AutoSizeMinMaxTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f70997c = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoSizeTextView, i11, 0);
        this.f70996b = obtainStyledAttributes.getDimension(R$styleable.AutoSizeTextView_auto_size_tv_min_text_size, getResources().getDimension(R$dimen.global_text_size_6));
        obtainStyledAttributes.recycle();
    }
}
