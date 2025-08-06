package com.huobi.view.rv;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class WrapVerticalDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    private int mDividerSize;

    public WrapVerticalDividerItemDecoration(Drawable drawable, int i11) {
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            int i11 = this.mDividerSize;
            rect.set(0, i11, 0, i11);
            return;
        }
        rect.set(0, 0, 0, this.mDividerSize);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (childAdapterPosition == 0) {
                    int top = childAt.getTop() + layoutParams.topMargin;
                    this.mDividerDrawable.setBounds(paddingLeft, top - this.mDividerSize, width, top);
                    this.mDividerDrawable.draw(canvas);
                }
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                this.mDividerDrawable.setBounds(paddingLeft, bottom, width, this.mDividerSize + bottom);
                this.mDividerDrawable.draw(canvas);
            }
        }
    }
}
