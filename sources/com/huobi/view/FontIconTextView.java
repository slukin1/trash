package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huobi.utils.c0;

public class FontIconTextView extends AppCompatTextView {
    public FontIconTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setTypeface(c0.a().b(getContext()));
    }

    public FontIconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FontIconTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
