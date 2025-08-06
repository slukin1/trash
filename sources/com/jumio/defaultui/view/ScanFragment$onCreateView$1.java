package com.jumio.defaultui.view;

import android.view.View;
import android.view.ViewTreeObserver;

public final class ScanFragment$onCreateView$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ ScanFragment this$0;

    public ScanFragment$onCreateView$1(View view, ScanFragment scanFragment) {
        this.$view = view;
        this.this$0 = scanFragment;
    }

    public void onGlobalLayout() {
        if (this.$view.getHeight() > 0 && this.$view.getWidth() > 0) {
            this.this$0.height = this.$view.getHeight();
            this.this$0.width = this.$view.getWidth();
            this.$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.this$0.updateScanTitleLayout();
        }
    }
}
