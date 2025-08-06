package com.huobi.view.rv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {
    private boolean isMainPagesBiz;
    private Drawable mDividerDrawable;
    private int mDividerSize;

    public GridDividerItemDecoration(Drawable drawable, int i11) {
        this.mDividerDrawable = drawable;
        this.mDividerSize = i11;
    }

    private int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).k();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).D();
        }
        return -1;
    }

    private boolean isLastColum(RecyclerView recyclerView, int i11, int i12, int i13) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((i11 + 1) % i12 == 0) {
                return true;
            }
            return false;
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return false;
        } else {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if ((i11 + 1) % i12 == 0) {
                    return true;
                }
                return false;
            } else if (i11 >= i13 - (i13 % i12)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean isLastRaw(RecyclerView recyclerView, int i11, int i12, int i13) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int i14 = i13 % i12;
            int i15 = i13 / i12;
            if (i14 != 0) {
                i15++;
            }
            if (i15 == (i11 / i12) + 1) {
                return true;
            }
            return false;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if (i11 >= i13 - (i13 % i12)) {
                    return true;
                }
            } else if ((i11 + 1) % i12 == 0) {
                return true;
            }
        }
        return false;
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            this.mDividerDrawable.setBounds(childAt.getLeft() - layoutParams.leftMargin, bottom, childAt.getRight() + layoutParams.rightMargin + this.mDividerSize, this.mDividerSize + bottom);
            this.mDividerDrawable.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int top = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int right = childAt.getRight() + layoutParams.rightMargin;
            this.mDividerDrawable.setBounds(right, top, this.mDividerSize + right, bottom);
            this.mDividerDrawable.draw(canvas);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int spanCount = getSpanCount(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (isLastColum(recyclerView, viewLayoutPosition, spanCount, itemCount) && isLastRaw(recyclerView, viewLayoutPosition, spanCount, itemCount)) {
            rect.set(0, 0, 0, 0);
        } else if (isLastRaw(recyclerView, viewLayoutPosition, spanCount, itemCount)) {
            if (this.isMainPagesBiz) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(0, 0, this.mDividerSize, 0);
            }
        } else if (isLastColum(recyclerView, viewLayoutPosition, spanCount, itemCount)) {
            rect.set(0, 0, 0, this.mDividerSize);
        } else {
            int i11 = this.mDividerSize;
            rect.set(0, 0, i11, i11);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontal(canvas, recyclerView);
        drawVertical(canvas, recyclerView);
    }

    public void setMainPagesBiz(boolean z11) {
        this.isMainPagesBiz = z11;
    }

    public GridDividerItemDecoration(Context context, int i11, int i12) {
        this.mDividerDrawable = ContextCompat.getDrawable(context, i11);
        this.mDividerSize = i12;
    }
}
