package com.huobi.dynamiclangs.transformer;

import android.view.View;
import android.widget.Toolbar;

public class ToolbarTransformer extends BaseTransformer {
    public Class<? extends View> getViewType() {
        return Toolbar.class;
    }
}
