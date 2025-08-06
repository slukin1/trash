package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerLayoutManager extends LinearLayoutManager {
    private static final String TAG = "ViewPagerLayoutManager";
    private RecyclerView.j mChildAttachStateChangeListener = new RecyclerView.j() {
        public void onChildViewAttachedToWindow(View view) {
            if (ViewPagerLayoutManager.this.mOnViewPagerListener != null && ViewPagerLayoutManager.this.getChildCount() == 1) {
                ViewPagerLayoutManager.this.mOnViewPagerListener.onInitComplete();
            }
        }

        public void onChildViewDetachedFromWindow(View view) {
            if (ViewPagerLayoutManager.this.mDrift >= 0) {
                if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                    ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(true, ViewPagerLayoutManager.this.getPosition(view));
                }
            } else if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(false, ViewPagerLayoutManager.this.getPosition(view));
            }
        }
    };
    /* access modifiers changed from: private */
    public int mDrift;
    private boolean mIsLeftScroll = false;
    /* access modifiers changed from: private */
    public OnViewPagerListener mOnViewPagerListener;
    private PagerSnapHelper mPagerSnapHelper;
    private RecyclerView mRecyclerView;

    public ViewPagerLayoutManager(Context context, int i11) {
        super(context, i11, false);
        init();
    }

    private void init() {
        this.mPagerSnapHelper = new PagerSnapHelper();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mPagerSnapHelper.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnChildAttachStateChangeListener(this.mChildAttachStateChangeListener);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    public void onScrollStateChanged(int i11) {
        if (i11 == 0) {
            int position = getPosition(this.mPagerSnapHelper.findSnapView(this));
            if (this.mOnViewPagerListener != null) {
                boolean z11 = true;
                if (getChildCount() == 1) {
                    OnViewPagerListener onViewPagerListener = this.mOnViewPagerListener;
                    if (position != getItemCount() - 1) {
                        z11 = false;
                    }
                    onViewPagerListener.onPageSelected(position, z11, this.mIsLeftScroll);
                }
            }
        }
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (i11 <= 0) {
            this.mIsLeftScroll = true;
        } else {
            this.mIsLeftScroll = false;
        }
        this.mDrift = i11;
        return super.scrollHorizontallyBy(i11, recycler, state);
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = i11;
        return super.scrollVerticallyBy(i11, recycler, state);
    }

    public void setOnViewPagerListener(OnViewPagerListener onViewPagerListener) {
        this.mOnViewPagerListener = onViewPagerListener;
    }
}
