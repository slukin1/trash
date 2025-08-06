package com.huochat.community.widget.divider;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

class Drawer {
    private final Drawable mDivider;
    private final int mHeight;
    private final int mWidth;

    public Drawer(Drawable drawable, int i11, int i12) {
        this.mDivider = drawable;
        this.mWidth = i11;
        this.mHeight = i12;
    }

    public void drawBottom(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        int bottom = view.getBottom();
        this.mDivider.setBounds(left, bottom, view.getRight() + this.mWidth, this.mHeight + bottom);
        this.mDivider.draw(canvas);
    }

    public void drawLeft(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        int bottom = view.getBottom() + this.mHeight;
        this.mDivider.setBounds(left, view.getTop() - this.mHeight, this.mWidth + left, bottom);
        this.mDivider.draw(canvas);
    }

    public void drawRight(View view, Canvas canvas) {
        int right = view.getRight();
        int bottom = view.getBottom() + this.mHeight;
        this.mDivider.setBounds(right, view.getTop() - this.mHeight, this.mWidth + right, bottom);
        this.mDivider.draw(canvas);
    }

    public void drawTop(View view, Canvas canvas) {
        int left = view.getLeft() - this.mWidth;
        int top = view.getTop() - this.mHeight;
        this.mDivider.setBounds(left, top, view.getRight() + this.mWidth, this.mHeight + top);
        this.mDivider.draw(canvas);
    }
}
