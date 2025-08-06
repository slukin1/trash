package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VerticalDividerItemDecoration extends RecyclerView.ItemDecoration {
    private List<Integer> ignoreDividerAtIndexList;
    private boolean ignorePadding;
    private Drawable mDividerDrawable;
    private int mDividerSize;
    private boolean mIsShowFirstDivider;
    private boolean mIsShowLastDivider;
    private int mUserLeftPadding;
    private int mUserRightPadding;

    public VerticalDividerItemDecoration(Drawable drawable, int i11, boolean z11, int i12, int i13) {
        this.ignorePadding = false;
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
        this.mUserLeftPadding = i12;
        this.mUserRightPadding = i13;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0 || !this.mIsShowFirstDivider) {
            rect.set(0, 0, 0, this.mDividerSize);
            return;
        }
        int i11 = this.mDividerSize;
        rect.set(0, i11, 0, i11);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        List<Integer> list;
        if (recyclerView.getAdapter() != null) {
            int paddingLeft = this.ignorePadding ? 0 : recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - (this.ignorePadding ? 0 : recyclerView.getPaddingRight());
            int i11 = this.mUserLeftPadding;
            if (i11 != 0) {
                paddingLeft = i11;
            }
            if (this.mUserRightPadding != 0) {
                width = recyclerView.getWidth() - this.mUserRightPadding;
            }
            int childCount = recyclerView.getChildCount();
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = recyclerView.getChildAt(i12);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if ((this.mIsShowLastDivider || !(childAdapterPosition == -1 || childAdapterPosition == itemCount - 1)) && ((list = this.ignoreDividerAtIndexList) == null || list.isEmpty() || !this.ignoreDividerAtIndexList.contains(Integer.valueOf(childAdapterPosition)))) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.mDividerDrawable.setBounds(paddingLeft, bottom, width, this.mDividerSize + bottom);
                    this.mDividerDrawable.draw(canvas);
                }
            }
        }
    }

    public void setIgnoreDividerAtIndexList(List<Integer> list) {
        this.ignoreDividerAtIndexList = list;
    }

    public VerticalDividerItemDecoration(Drawable drawable, int i11, boolean z11) {
        this.ignorePadding = false;
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
    }

    public VerticalDividerItemDecoration(Drawable drawable, int i11, boolean z11, boolean z12) {
        this.ignorePadding = false;
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
        this.mIsShowFirstDivider = z12;
    }

    public VerticalDividerItemDecoration(Context context, int i11, int i12, boolean z11) {
        this.ignorePadding = false;
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mDividerSize = i12;
        this.mIsShowLastDivider = z11;
    }

    public VerticalDividerItemDecoration(Drawable drawable, int i11, boolean z11, boolean z12, boolean z13) {
        this.ignorePadding = false;
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
        this.mIsShowLastDivider = z11;
        this.mIsShowFirstDivider = z12;
        this.ignorePadding = z13;
    }

    public VerticalDividerItemDecoration(Drawable drawable, int i11) {
        this(drawable, i11, true);
    }

    public VerticalDividerItemDecoration(Context context, int i11, int i12) {
        this(context, i11, i12, true);
    }
}
