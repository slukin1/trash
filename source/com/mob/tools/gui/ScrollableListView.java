package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ListView;
import com.mob.tools.gui.Scrollable;

public class ScrollableListView extends ListView implements Scrollable {
    private Scrollable.OnScrollListener osListener;
    /* access modifiers changed from: private */
    public boolean pullEnable;

    public ScrollableListView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setCacheColorHint(0);
        setSelector(new ColorDrawable());
        setDividerHeight(0);
        this.pullEnable = true;
        this.osListener = new Scrollable.OnScrollListener() {
            public void onScrollChanged(Scrollable scrollable, int i11, int i12, int i13, int i14) {
                boolean unused = ScrollableListView.this.pullEnable = i12 <= 0 && i14 <= 0;
            }
        };
    }

    public int computeVerticalScrollOffset() {
        int computeVerticalScrollOffset = super.computeVerticalScrollOffset();
        Scrollable.OnScrollListener onScrollListener = this.osListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollChanged(this, 0, computeVerticalScrollOffset, 0, 0);
        }
        return computeVerticalScrollOffset;
    }

    public boolean isReadyToPull() {
        return this.pullEnable;
    }

    public ScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScrollableListView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
