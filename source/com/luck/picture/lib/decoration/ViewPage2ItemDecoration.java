package com.luck.picture.lib.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPage2ItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;
    private final int spanCount;

    public ViewPage2ItemDecoration(int i11, int i12) {
        this.spanCount = i11;
        this.spacing = i12;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i11 = this.spanCount;
        int i12 = childAdapterPosition % i11;
        int i13 = this.spacing;
        rect.left = i13 - ((i12 * i13) / i11);
        rect.right = ((i12 + 1) * i13) / i11;
    }
}
