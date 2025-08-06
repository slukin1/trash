package com.huochat.community.widget.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class Api21ItemDivider extends Divider {
    private final Drawer mDrawer;
    private final int mHeight;
    private final int mWidth;

    public Api21ItemDivider(int i11) {
        this(i11, 4, 4);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i11 = this.mWidth;
        int i12 = this.mHeight;
        rect.set(i11, i12, i11, i12);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        canvas.save();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = layoutManager.getChildAt(i11);
            this.mDrawer.drawLeft(childAt, canvas);
            this.mDrawer.drawTop(childAt, canvas);
            this.mDrawer.drawRight(childAt, canvas);
            this.mDrawer.drawBottom(childAt, canvas);
        }
        canvas.restore();
    }

    public Api21ItemDivider(int i11, int i12, int i13) {
        int round = Math.round(((float) i12) / 2.0f);
        this.mWidth = round;
        int round2 = Math.round(((float) i13) / 2.0f);
        this.mHeight = round2;
        this.mDrawer = new ColorDrawer(i11, round, round2);
    }
}
