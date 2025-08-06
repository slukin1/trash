package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class QuickTradeAutoSizeEditText extends AppCompatEditText {

    /* renamed from: b  reason: collision with root package name */
    public float f80123b;

    /* renamed from: c  reason: collision with root package name */
    public String f80124c;

    public QuickTradeAutoSizeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void a(String str) {
        float measureText = getPaint().measureText(str);
        float textSize = getTextSize();
        if (measureText > ((float) getMaxWidth())) {
            setTextSize(0, textSize - 2.0f);
            a(str);
        }
    }

    public final void b(String str) {
        float measureText = getPaint().measureText(str);
        float textSize = getTextSize();
        if (textSize >= this.f80123b || measureText > ((float) getMaxWidth())) {
            a(str);
            return;
        }
        setTextSize(0, textSize + 2.0f);
        b(str);
    }

    public void setInputText(CharSequence charSequence) {
        if (this.f80123b == -1.0f) {
            this.f80123b = getTextSize();
        }
        if (charSequence != null) {
            if (getText() != null) {
                if (this.f80124c.length() < charSequence.length()) {
                    a(charSequence.toString());
                } else if (this.f80124c.length() > charSequence.length()) {
                    b(charSequence.toString());
                }
            }
            this.f80124c = charSequence.toString();
            setText(charSequence);
        }
    }

    public QuickTradeAutoSizeEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f80123b = -1.0f;
        this.f80124c = "";
    }
}
