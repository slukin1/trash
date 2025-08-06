package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.audio.AacUtil;

public class SlideSelectTouchListener implements RecyclerView.k {
    private boolean isActive;
    private int mAutoScrollDistance = ((int) (Resources.getSystem().getDisplayMetrics().density * 56.0f));
    private int mBottomBoundFrom;
    private int mBottomBoundTo;
    private int mEnd;
    private int mHeaderViewCount;
    private boolean mInBottomSpot;
    private boolean mInTopSpot;
    private int mLastEnd;
    private int mLastStart;
    private float mLastX;
    private float mLastY;
    private int mMaxScrollDistance = 16;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private boolean mScrollAboveTopRegion = true;
    private boolean mScrollBelowTopRegion = true;
    /* access modifiers changed from: private */
    public int mScrollDistance;
    /* access modifiers changed from: private */
    public final Runnable mScrollRunnable = new Runnable() {
        public void run() {
            if (SlideSelectTouchListener.this.mScroller != null && SlideSelectTouchListener.this.mScroller.computeScrollOffset()) {
                SlideSelectTouchListener slideSelectTouchListener = SlideSelectTouchListener.this;
                slideSelectTouchListener.scrollBy(slideSelectTouchListener.mScrollDistance);
                h0.p0(SlideSelectTouchListener.this.mRecyclerView, SlideSelectTouchListener.this.mScrollRunnable);
            }
        }
    };
    /* access modifiers changed from: private */
    public OverScroller mScroller;
    private OnSlideSelectListener mSelectListener;
    private int mStart;
    private int mTopBoundFrom;
    private int mTopBoundTo;
    private int mTouchRegionBottomOffset = 0;
    private int mTouchRegionTopOffset = 0;

    public interface OnAdvancedSlideSelectListener extends OnSlideSelectListener {
        void onSelectionFinished(int i11);

        void onSelectionStarted(int i11);
    }

    public interface OnSlideSelectListener {
        void onSelectChange(int i11, int i12, boolean z11);
    }

    public SlideSelectTouchListener() {
        reset();
    }

    private void changeSelectedRange(RecyclerView recyclerView, MotionEvent motionEvent) {
        changeSelectedRange(recyclerView, motionEvent.getX(), motionEvent.getY());
    }

    private void initScroller(Context context) {
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(context, new LinearInterpolator());
        }
    }

    private void notifySelectRangeChange() {
        int i11;
        int i12;
        if (this.mSelectListener != null && (i11 = this.mStart) != -1 && (i12 = this.mEnd) != -1) {
            int min = Math.min(i11, i12);
            int max = Math.max(this.mStart, this.mEnd);
            if (min >= 0) {
                int i13 = this.mLastStart;
                if (i13 != -1 && this.mLastEnd != -1) {
                    if (min > i13) {
                        this.mSelectListener.onSelectChange(i13, min - 1, false);
                    } else if (min < i13) {
                        this.mSelectListener.onSelectChange(min, i13 - 1, true);
                    }
                    int i14 = this.mLastEnd;
                    if (max > i14) {
                        this.mSelectListener.onSelectChange(i14 + 1, max, true);
                    } else if (max < i14) {
                        this.mSelectListener.onSelectChange(max + 1, i14, false);
                    }
                } else if (max - min == 1) {
                    this.mSelectListener.onSelectChange(min, min, true);
                } else {
                    this.mSelectListener.onSelectChange(min, max, true);
                }
                this.mLastStart = min;
                this.mLastEnd = max;
            }
        }
    }

    private void processAutoScroll(MotionEvent motionEvent) {
        int y11 = (int) motionEvent.getY();
        int i11 = this.mTopBoundFrom;
        if (y11 >= i11 && y11 <= this.mTopBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            int i12 = this.mTopBoundTo;
            int i13 = this.mTopBoundFrom;
            this.mScrollDistance = (int) (((float) this.mMaxScrollDistance) * (((((float) i12) - ((float) i13)) - (((float) y11) - ((float) i13))) / (((float) i12) - ((float) i13))) * -1.0f);
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
            }
        } else if (this.mScrollAboveTopRegion && y11 < i11) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance * -1;
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
            }
        } else if (y11 >= this.mBottomBoundFrom && y11 <= this.mBottomBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            float f11 = (float) y11;
            int i14 = this.mBottomBoundFrom;
            this.mScrollDistance = (int) (((float) this.mMaxScrollDistance) * ((f11 - ((float) i14)) / (((float) this.mBottomBoundTo) - ((float) i14))));
            if (!this.mInBottomSpot) {
                this.mInBottomSpot = true;
                startAutoScroll();
            }
        } else if (!this.mScrollBelowTopRegion || y11 <= this.mBottomBoundTo) {
            this.mInBottomSpot = false;
            this.mInTopSpot = false;
            this.mLastX = Float.MIN_VALUE;
            this.mLastY = Float.MIN_VALUE;
            stopAutoScroll();
        } else {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance;
            if (!this.mInTopSpot) {
                this.mInTopSpot = true;
                startAutoScroll();
            }
        }
    }

    private void reset() {
        setActive(false);
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionFinished(this.mEnd);
        }
        this.mStart = -1;
        this.mEnd = -1;
        this.mLastStart = -1;
        this.mLastEnd = -1;
        this.mInTopSpot = false;
        this.mInBottomSpot = false;
        this.mLastX = Float.MIN_VALUE;
        this.mLastY = Float.MIN_VALUE;
        stopAutoScroll();
    }

    /* access modifiers changed from: private */
    public void scrollBy(int i11) {
        int i12;
        if (i11 > 0) {
            i12 = Math.min(i11, this.mMaxScrollDistance);
        } else {
            i12 = Math.max(i11, -this.mMaxScrollDistance);
        }
        this.mRecyclerView.scrollBy(0, i12);
        float f11 = this.mLastX;
        if (f11 != Float.MIN_VALUE) {
            float f12 = this.mLastY;
            if (f12 != Float.MIN_VALUE) {
                changeSelectedRange(this.mRecyclerView, f11, f12);
            }
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.isActive || recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 5) {
            reset();
        }
        this.mRecyclerView = recyclerView;
        int height = recyclerView.getHeight();
        int i11 = this.mTouchRegionTopOffset;
        this.mTopBoundFrom = i11;
        int i12 = this.mAutoScrollDistance;
        this.mTopBoundTo = i11 + i12;
        int i13 = this.mTouchRegionBottomOffset;
        this.mBottomBoundFrom = (height + i13) - i12;
        this.mBottomBoundTo = height + i13;
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.isActive) {
            reset();
            return;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                if (!this.mInTopSpot && !this.mInBottomSpot) {
                    changeSelectedRange(recyclerView, motionEvent);
                }
                processAutoScroll(motionEvent);
                return;
            } else if (!(action == 3 || action == 6)) {
                return;
            }
        }
        reset();
    }

    public void setActive(boolean z11) {
        this.isActive = z11;
    }

    public SlideSelectTouchListener setRecyclerViewHeaderCount(int i11) {
        this.mHeaderViewCount = i11;
        return this;
    }

    public void startAutoScroll() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            initScroller(recyclerView.getContext());
            if (this.mScroller.isFinished()) {
                this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
                OverScroller overScroller = this.mScroller;
                overScroller.startScroll(0, overScroller.getCurrY(), 0, 5000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
                h0.p0(this.mRecyclerView, this.mScrollRunnable);
            }
        }
    }

    public void startSlideSelection(int i11) {
        setActive(true);
        this.mStart = i11;
        this.mEnd = i11;
        this.mLastStart = i11;
        this.mLastEnd = i11;
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionStarted(i11);
        }
    }

    public void stopAutoScroll() {
        try {
            OverScroller overScroller = this.mScroller;
            if (overScroller != null && !overScroller.isFinished()) {
                this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
                this.mScroller.abortAnimation();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public SlideSelectTouchListener withBottomOffset(int i11) {
        this.mTouchRegionBottomOffset = i11;
        return this;
    }

    public SlideSelectTouchListener withMaxScrollDistance(int i11) {
        this.mMaxScrollDistance = i11;
        return this;
    }

    public SlideSelectTouchListener withScrollAboveTopRegion(boolean z11) {
        this.mScrollAboveTopRegion = z11;
        return this;
    }

    public SlideSelectTouchListener withScrollBelowTopRegion(boolean z11) {
        this.mScrollBelowTopRegion = z11;
        return this;
    }

    public SlideSelectTouchListener withSelectListener(OnSlideSelectListener onSlideSelectListener) {
        this.mSelectListener = onSlideSelectListener;
        return this;
    }

    public SlideSelectTouchListener withTopOffset(int i11) {
        this.mTouchRegionTopOffset = i11;
        return this;
    }

    public SlideSelectTouchListener withTouchRegion(int i11) {
        this.mAutoScrollDistance = i11;
        return this;
    }

    private void changeSelectedRange(RecyclerView recyclerView, float f11, float f12) {
        int childAdapterPosition;
        View findChildViewUnder = recyclerView.findChildViewUnder(f11, f12);
        if (findChildViewUnder != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(findChildViewUnder) - this.mHeaderViewCount) != -1 && this.mEnd != childAdapterPosition) {
            this.mEnd = childAdapterPosition;
            notifySelectRangeChange();
        }
    }
}
