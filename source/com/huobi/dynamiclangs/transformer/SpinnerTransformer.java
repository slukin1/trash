package com.huobi.dynamiclangs.transformer;

import android.view.View;
import android.widget.Spinner;

public class SpinnerTransformer extends BaseTransformer {
    public Class<? extends View> getViewType() {
        return Spinner.class;
    }
}
