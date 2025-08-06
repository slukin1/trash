package com.huobi.dynamiclangs.transformer;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class SupportToolbarTransformer extends BaseTransformer {
    public Class<? extends View> getViewType() {
        return Toolbar.class;
    }
}
