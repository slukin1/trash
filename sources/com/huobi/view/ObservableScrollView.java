package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView {
    private OnScrollViewScrollChanged listener;

    public interface OnScrollViewScrollChanged {
        void onScrollViewChangedListener(int i11, int i12, int i13, int i14);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        OnScrollViewScrollChanged onScrollViewScrollChanged = this.listener;
        if (onScrollViewScrollChanged != null) {
            onScrollViewScrollChanged.onScrollViewChangedListener(i11, i12, i13, i14);
        }
    }

    public void setListener(OnScrollViewScrollChanged onScrollViewScrollChanged) {
        this.listener = onScrollViewScrollChanged;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
