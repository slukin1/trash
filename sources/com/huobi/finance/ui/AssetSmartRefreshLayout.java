package com.huobi.finance.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class AssetSmartRefreshLayout extends SmartRefreshLayout {
    public boolean T0;

    public AssetSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void O(float f11) {
        if (!this.T0) {
            super.O(f11);
        }
    }

    public void setRefreshHidden(boolean z11) {
        this.T0 = z11;
    }

    public AssetSmartRefreshLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
