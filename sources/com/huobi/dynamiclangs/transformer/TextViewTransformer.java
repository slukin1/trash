package com.huobi.dynamiclangs.transformer;

import android.view.View;
import android.widget.TextView;

public class TextViewTransformer extends BaseTransformer {
    public Class<? extends View> getViewType() {
        return TextView.class;
    }
}
