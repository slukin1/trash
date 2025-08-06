package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class BandCardAddressItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    private int mDividerSize;
    private int mSecondDividerSize;
    private Drawable mSecondDrawable;

    public BandCardAddressItemDecoration(Context context, int i11, int i12, int i13, int i14) {
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mSecondDrawable = ContextCompat.getDrawable(context, i13);
        this.mDividerSize = i12;
        this.mSecondDividerSize = i14;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            if (childAdapterPosition == 0) {
                rect.set(0, this.mDividerSize, 0, 0);
            } else if (childAdapterPosition == 1) {
                rect.set(0, this.mSecondDividerSize, 0, this.mDividerSize);
            } else {
                rect.set(0, 0, 0, this.mSecondDividerSize);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (!(childAdapterPosition == -1 || childAdapterPosition == itemCount - 1)) {
                if (childAdapterPosition != 1) {
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
}
