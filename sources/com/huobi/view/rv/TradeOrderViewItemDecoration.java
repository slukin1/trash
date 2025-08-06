package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class TradeOrderViewItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    private int mDividerSize;
    private int mSecondDividerSize;
    private Drawable mSecondDrawable;

    public TradeOrderViewItemDecoration(Context context, int i11, int i12, int i13, int i14) {
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mSecondDrawable = ContextCompat.getDrawable(context, i13);
        this.mDividerSize = i12;
        this.mSecondDividerSize = i14;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int i12;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (childAdapterPosition != -1 && childAdapterPosition != itemCount - 1 && (i12 = childAdapterPosition + 1) <= i11) {
            if (recyclerView.getAdapter().getItemViewType(childAdapterPosition) != recyclerView.getAdapter().getItemViewType(i12)) {
                rect.set(0, 0, 0, this.mSecondDividerSize);
            } else {
                rect.set(0, 0, 0, this.mDividerSize);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int i12;
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = recyclerView.getChildAt(i13);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (!(childAdapterPosition == -1 || childAdapterPosition == itemCount - 1 || (i12 = childAdapterPosition + 1) > i11)) {
                if (recyclerView.getAdapter().getItemViewType(childAdapterPosition) == recyclerView.getAdapter().getItemViewType(i12)) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.mDividerDrawable.setBounds(paddingLeft, bottom, width, this.mDividerSize + bottom);
                    this.mDividerDrawable.draw(canvas);
                } else {
                    int bottom2 = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.mSecondDrawable.setBounds(paddingLeft, bottom2, width, this.mSecondDividerSize + bottom2);
                    this.mSecondDrawable.draw(canvas);
                }
            }
        }
    }

    public TradeOrderViewItemDecoration(Context context, Drawable drawable, int i11, Drawable drawable2, int i12) {
        this.mDividerDrawable = drawable;
        this.mSecondDrawable = drawable2;
        this.mDividerSize = i11;
        this.mSecondDividerSize = i12;
    }
}
