package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class AutoSizeTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public float f71019b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71020c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f71021d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f71022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f71023c;

        public a(int i11, String str) {
            this.f71022b = i11;
            this.f71023c = str;
        }

        public void run() {
            String str;
            if (AutoSizeTextView.this.f71020c && this.f71022b > 0 && (str = this.f71023c) != null && str.length() != 0) {
                int paddingLeft = (this.f71022b - AutoSizeTextView.this.getPaddingLeft()) - AutoSizeTextView.this.getPaddingRight();
                AutoSizeTextView autoSizeTextView = AutoSizeTextView.this;
                autoSizeTextView.f71021d.set(autoSizeTextView.getPaint());
                float textSize = AutoSizeTextView.this.getTextSize();
                AutoSizeTextView.this.f71021d.setTextSize(textSize);
                float f11 = (float) paddingLeft;
                if (AutoSizeTextView.this.f71021d.measureText(this.f71023c) < f11) {
                    AutoSizeTextView.this.setTextSize(0, textSize);
                    return;
                }
                float f12 = AutoSizeTextView.this.f71019b;
                while (textSize - f12 > 0.5f) {
                    float f13 = (textSize + f12) / 2.0f;
                    AutoSizeTextView.this.f71021d.setTextSize(f13);
                    if (AutoSizeTextView.this.f71021d.measureText(this.f71023c) > f11) {
                        textSize = f13;
                    } else {
                        f12 = f13;
                    }
                }
                AutoSizeTextView.this.setTextSize(0, f12);
            }
        }
    }

    public AutoSizeTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void d(String str, int i11) {
        if (this.f71020c && i11 > 0 && str != null && str.length() != 0) {
            post(new a(i11, str));
        }
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
        this.f71019b = f11;
    }

    public void setSwitchOn(boolean z11) {
        this.f71020c = z11;
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71021d = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AutoSizeTextView, i11, 0);
        this.f71019b = obtainStyledAttributes.getDimension(R$styleable.AutoSizeTextView_auto_size_tv_min_text_size, getResources().getDimension(R$dimen.global_text_size_6));
        this.f71020c = obtainStyledAttributes.getBoolean(R$styleable.AutoSizeTextView_auto_size_switch_on, true);
        obtainStyledAttributes.recycle();
    }
}
