package com.huochat.community.widget.divider;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int i11, int i12, boolean z11) {
        this.spanCount = i11;
        this.spacing = i12;
        this.includeEdge = z11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i11 = this.spanCount;
        int i12 = childAdapterPosition % i11;
        if (this.includeEdge) {
            int i13 = this.spacing;
            rect.left = i13 - ((i12 * i13) / i11);
            rect.right = ((i12 + 1) * i13) / i11;
            if (childAdapterPosition < i11) {
                rect.top = i13;
            }
            rect.bottom = i13;
            return;
        }
        int i14 = this.spacing;
        rect.left = (i12 * i14) / i11;
        rect.right = i14 - (((i12 + 1) * i14) / i11);
        if (childAdapterPosition >= i11) {
            rect.top = i14;
        }
    }
}
