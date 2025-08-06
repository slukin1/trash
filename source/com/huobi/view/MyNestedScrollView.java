package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import i6.d;

public class MyNestedScrollView extends NestedScrollView {
    private float lastX;
    private float lastY;
    private boolean mIsStartScroll = false;
    private OnScrollChangedListener mOnScrollChangedListener;
    private ScrollStateListener mScrollListener;
    private int mState = 0;
    private int mTouchType = 0;
    private boolean scrollable = true;
    private float xDistance;
    private float yDistance;

    public interface OnScrollChangedListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14);
    }

    public interface ScrollStateListener {
        void onStartNestedScroll();

        void onStateChanged(int i11);

        void onStopNestedScroll();
    }

    public MyNestedScrollView(Context context) {
        super(context);
        init(context);
    }

    private void dispatchScrollState(int i11) {
        ScrollStateListener scrollStateListener = this.mScrollListener;
        if (scrollStateListener != null && this.mState != i11) {
            scrollStateListener.onStateChanged(i11);
            d.b("----Unsmooth----");
            this.mState = i11;
        }
    }

    private void init(Context context) {
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.scrollable) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
            computeScroll();
        } else if (action == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.xDistance += Math.abs(x11 - this.lastX);
            float abs = this.yDistance + Math.abs(y11 - this.lastY);
            this.yDistance = abs;
            this.lastX = x11;
            this.lastY = y11;
            if (this.xDistance > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        OnScrollChangedListener onScrollChangedListener = this.mOnScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChange(this, i11, i12, i13, i14);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        dispatchScrollState(1);
        return super.onStartNestedScroll(view, view2, i11);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.scrollable && super.onTouchEvent(motionEvent);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.mOnScrollChangedListener = onScrollChangedListener;
    }

    public void setScrollStateListener(ScrollStateListener scrollStateListener) {
        this.mScrollListener = scrollStateListener;
    }

    public void setScrollingEnabled(boolean z11) {
        this.scrollable = z11;
    }

    public boolean startNestedScroll(int i11, int i12) {
        this.mTouchType = i12;
        ScrollStateListener scrollStateListener = this.mScrollListener;
        if (scrollStateListener != null && !this.mIsStartScroll) {
            this.mIsStartScroll = true;
            scrollStateListener.onStartNestedScroll();
        }
        return super.startNestedScroll(i11, i12);
    }

    public void stopNestedScroll(int i11) {
        super.stopNestedScroll(i11);
        dispatchScrollState(0);
        ScrollStateListener scrollStateListener = this.mScrollListener;
        if (scrollStateListener != null && this.mTouchType == i11 && this.mIsStartScroll) {
            this.mIsStartScroll = false;
            scrollStateListener.onStopNestedScroll();
        }
    }

    public boolean startNestedScroll(int i11) {
        boolean startNestedScroll = super.startNestedScroll(i11);
        dispatchScrollState(1);
        return startNestedScroll;
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
