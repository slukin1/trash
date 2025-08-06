package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class AutoScrollView extends HorizontalScrollView {
    /* access modifiers changed from: private */
    public IndexCallBack indexCallBack;

    public interface IndexCallBack {
        void onIndexChange(int i11);
    }

    public AutoScrollView(Context context) {
        super(context);
    }

    public void fling(int i11) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            View childAt = getChildAt(0);
            if (childAt instanceof ViewGroup) {
                final int measuredWidth = childAt.getMeasuredWidth();
                final int measuredWidth2 = ((ViewGroup) childAt).getChildAt(0).getMeasuredWidth();
                int scrollX = getScrollX();
                int i11 = measuredWidth2 / 2;
                if (scrollX <= i11) {
                    post(new Runnable() {
                        public void run() {
                            AutoScrollView autoScrollView = AutoScrollView.this;
                            autoScrollView.smoothScrollTo(0, autoScrollView.getScrollY());
                            if (AutoScrollView.this.indexCallBack != null) {
                                AutoScrollView.this.indexCallBack.onIndexChange(0);
                            }
                        }
                    });
                } else if (scrollX <= i11 || scrollX >= i11 + measuredWidth2) {
                    post(new Runnable() {
                        public void run() {
                            AutoScrollView autoScrollView = AutoScrollView.this;
                            autoScrollView.smoothScrollTo(measuredWidth - measuredWidth2, autoScrollView.getScrollY());
                            if (AutoScrollView.this.indexCallBack != null) {
                                AutoScrollView.this.indexCallBack.onIndexChange(2);
                            }
                        }
                    });
                } else {
                    post(new Runnable() {
                        public void run() {
                            AutoScrollView autoScrollView = AutoScrollView.this;
                            autoScrollView.smoothScrollTo((measuredWidth / 2) - (autoScrollView.getMeasuredWidth() / 2), AutoScrollView.this.getScrollY());
                            if (AutoScrollView.this.indexCallBack != null) {
                                AutoScrollView.this.indexCallBack.onIndexChange(1);
                            }
                        }
                    });
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIndex(int i11) {
        View childAt = getChildAt(0);
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredWidth2 = ((ViewGroup) childAt).getChildAt(0).getMeasuredWidth();
        if (i11 == 1) {
            smoothScrollTo((measuredWidth / 2) - (getMeasuredWidth() / 2), getScrollY());
        } else if (i11 != 2) {
            scrollTo(0, getScrollY());
        } else {
            smoothScrollTo(measuredWidth - measuredWidth2, getScrollY());
        }
    }

    public void setIndexCallBack(IndexCallBack indexCallBack2) {
        this.indexCallBack = indexCallBack2;
    }

    public AutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
