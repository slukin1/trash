package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;

public class RecyclerPreloadView extends RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final int LIMIT = 150;
    private static final String TAG = RecyclerPreloadView.class.getSimpleName();
    private boolean isEnabledLoadMore = false;
    private boolean isInTheBottom = false;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private OnRecyclerViewScrollListener onRecyclerViewScrollListener;
    private OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener;
    private int reachBottomRow = 1;

    public RecyclerPreloadView(Context context) {
        super(context);
    }

    private void setLayoutManagerPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.mFirstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
            this.mLastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.mFirstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
            this.mLastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
        }
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    public void onScrollStateChanged(int i11) {
        OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener2;
        super.onScrollStateChanged(i11);
        if (i11 == 0 || i11 == 1) {
            setLayoutManagerPosition(getLayoutManager());
        }
        OnRecyclerViewScrollListener onRecyclerViewScrollListener2 = this.onRecyclerViewScrollListener;
        if (onRecyclerViewScrollListener2 != null) {
            onRecyclerViewScrollListener2.onScrollStateChanged(i11);
        }
        if (i11 == 0 && (onRecyclerViewScrollStateListener2 = this.onRecyclerViewScrollStateListener) != null) {
            onRecyclerViewScrollStateListener2.onScrollSlow();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(int r6, int r7) {
        /*
            r5 = this;
            super.onScrolled(r6, r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.getLayoutManager()
            if (r0 == 0) goto L_0x007b
            r5.setLayoutManagerPosition(r0)
            com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener r1 = r5.onRecyclerViewPreloadListener
            if (r1 == 0) goto L_0x005c
            boolean r1 = r5.isEnabledLoadMore
            if (r1 == 0) goto L_0x005c
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r5.getAdapter()
            if (r1 == 0) goto L_0x0054
            boolean r2 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003b
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r1 = r1.getItemCount()
            int r2 = r0.k()
            int r1 = r1 / r2
            int r2 = r0.findLastVisibleItemPosition()
            int r0 = r0.k()
            int r2 = r2 / r0
            int r0 = r5.reachBottomRow
            int r1 = r1 - r0
            if (r2 < r1) goto L_0x003b
            r0 = r3
            goto L_0x003c
        L_0x003b:
            r0 = r4
        L_0x003c:
            if (r0 != 0) goto L_0x0041
            r5.isInTheBottom = r4
            goto L_0x005c
        L_0x0041:
            boolean r0 = r5.isInTheBottom
            if (r0 != 0) goto L_0x004f
            com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener r0 = r5.onRecyclerViewPreloadListener
            r0.onRecyclerViewPreloadMore()
            if (r7 <= 0) goto L_0x005c
            r5.isInTheBottom = r3
            goto L_0x005c
        L_0x004f:
            if (r7 != 0) goto L_0x005c
            r5.isInTheBottom = r4
            goto L_0x005c
        L_0x0054:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "Adapter is null,Please check it!"
            r6.<init>(r7)
            throw r6
        L_0x005c:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener r0 = r5.onRecyclerViewScrollListener
            if (r0 == 0) goto L_0x0063
            r0.onScrolled(r6, r7)
        L_0x0063:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            if (r6 == 0) goto L_0x007a
            int r6 = java.lang.Math.abs(r7)
            r7 = 150(0x96, float:2.1E-43)
            if (r6 >= r7) goto L_0x0075
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            r6.onScrollSlow()
            goto L_0x007a
        L_0x0075:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            r6.onScrollFast()
        L_0x007a:
            return
        L_0x007b:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "LayoutManager is null,Please check it!"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.RecyclerPreloadView.onScrolled(int, int):void");
    }

    public void setEnabledLoadMore(boolean z11) {
        this.isEnabledLoadMore = z11;
    }

    public void setLastVisiblePosition(int i11) {
        this.mLastVisiblePosition = i11;
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }

    public void setOnRecyclerViewScrollListener(OnRecyclerViewScrollListener onRecyclerViewScrollListener2) {
        this.onRecyclerViewScrollListener = onRecyclerViewScrollListener2;
    }

    public void setOnRecyclerViewScrollStateListener(OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener2) {
        this.onRecyclerViewScrollStateListener = onRecyclerViewScrollStateListener2;
    }

    public void setReachBottomRow(int i11) {
        if (i11 < 1) {
            i11 = 1;
        }
        this.reachBottomRow = i11;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
