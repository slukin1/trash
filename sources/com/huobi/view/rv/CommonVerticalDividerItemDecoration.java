package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CommonVerticalDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    private int mDividerSize;
    private Drawable mFirstDividerDrawable;
    private int mFirstDividerSize;
    private boolean mIsShowFirstDivider;

    public CommonVerticalDividerItemDecoration(Drawable drawable, Drawable drawable2, int i11, int i12) {
        this.mDividerDrawable = drawable2;
        this.mFirstDividerDrawable = drawable;
        this.mDividerSize = i12;
        this.mFirstDividerSize = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (!this.mIsShowFirstDivider) {
            rect.set(0, 0, 0, this.mDividerSize);
        } else if (childAdapterPosition == 0) {
            rect.set(0, this.mFirstDividerSize, 0, 0);
        } else {
            rect.set(0, this.mDividerSize, 0, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1) {
                if (!this.mIsShowFirstDivider) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.mDividerDrawable.setBounds(paddingLeft, bottom, width, this.mDividerSize + bottom);
                    this.mDividerDrawable.draw(canvas);
                } else if (childAdapterPosition == 0) {
                    int top = childAt.getTop() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).topMargin;
                    this.mFirstDividerDrawable.setBounds(paddingLeft, top - this.mFirstDividerSize, width, top);
                    this.mFirstDividerDrawable.draw(canvas);
                } else {
                    int top2 = childAt.getTop() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).topMargin;
                    this.mDividerDrawable.setBounds(paddingLeft, top2 - this.mDividerSize, width, top2);
                    this.mDividerDrawable.draw(canvas);
                }
            }
        }
    }

    public CommonVerticalDividerItemDecoration(Drawable drawable, Drawable drawable2, int i11, int i12, boolean z11) {
        this.mDividerDrawable = drawable2;
        this.mFirstDividerDrawable = drawable;
        this.mDividerSize = i12;
        this.mFirstDividerSize = i11;
        this.mIsShowFirstDivider = z11;
    }

    public CommonVerticalDividerItemDecoration(Context context, int i11, int i12, boolean z11) {
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mDividerSize = i12;
    }

    public CommonVerticalDividerItemDecoration(Context context, int i11, int i12) {
        this(context, i11, i12, true);
    }
}
