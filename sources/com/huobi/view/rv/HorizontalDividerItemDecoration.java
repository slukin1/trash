package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    private int mDividerSize;
    private int mFirstDividerSize;
    private boolean mIsShowFirstDivider;
    private boolean mIsShowLastDivider;

    public HorizontalDividerItemDecoration(Drawable drawable, int i11, boolean z11) {
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0 || !this.mIsShowFirstDivider) {
            rect.set(0, 0, this.mDividerSize, 0);
            return;
        }
        int i11 = this.mFirstDividerSize;
        if (i11 > 0) {
            rect.set(i11, 0, this.mDividerSize, 0);
            return;
        }
        int i12 = this.mDividerSize;
        rect.set(i12, 0, i12, 0);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int childAdapterPosition;
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            if (this.mIsShowLastDivider || !((childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) == -1 || childAdapterPosition == itemCount - 1)) {
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                if (i12 != 0 || (i11 = this.mFirstDividerSize) <= 0) {
                    i11 = this.mDividerSize;
                }
                this.mDividerDrawable.setBounds(right, paddingTop, i11 + right, height);
                this.mDividerDrawable.draw(canvas);
            }
        }
    }

    public HorizontalDividerItemDecoration(Drawable drawable, int i11, boolean z11, boolean z12) {
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
        this.mIsShowFirstDivider = z12;
    }

    public HorizontalDividerItemDecoration(Drawable drawable, int i11, int i12, boolean z11, boolean z12) {
        this.mDividerDrawable = drawable;
        this.mDividerSize = i12;
        this.mIsShowLastDivider = z11;
        this.mIsShowFirstDivider = z12;
        this.mFirstDividerSize = i11;
    }

    public HorizontalDividerItemDecoration(Context context, int i11, int i12, boolean z11) {
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mDividerSize = i12;
        this.mIsShowLastDivider = z11;
    }

    public HorizontalDividerItemDecoration(Drawable drawable, int i11) {
        this(drawable, i11, true);
    }

    public HorizontalDividerItemDecoration(Context context, int i11, int i12) {
        this(context, i11, i12, true);
    }
}
