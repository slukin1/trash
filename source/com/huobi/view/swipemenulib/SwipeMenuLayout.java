package com.huobi.view.swipemenulib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.hbg.lib.widgets.R$styleable;

public class SwipeMenuLayout extends ViewGroup {
    private static final String TAG = "zxt/SwipeMenuLayout";
    private static boolean isTouching;
    private static SwipeMenuLayout mViewCache;
    private Log LogUtils;
    private boolean iosInterceptFlag;
    /* access modifiers changed from: private */
    public boolean isExpand;
    private boolean isIos;
    private boolean isLeftSwipe;
    private boolean isSwipeEnable;
    private boolean isUnMoved;
    private boolean isUserSwiped;
    private ValueAnimator mCloseAnim;
    private View mContentView;
    private ValueAnimator mExpandAnim;
    private PointF mFirstP;
    private int mHeight;
    private PointF mLastP;
    private int mLimit;
    private int mMaxVelocity;
    private int mPointerId;
    private int mRightMenuWidths;
    private int mScaleTouchSlop;
    private VelocityTracker mVelocityTracker;

    public SwipeMenuLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void cancelAnim() {
        ValueAnimator valueAnimator = this.mCloseAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mCloseAnim.cancel();
        }
        ValueAnimator valueAnimator2 = this.mExpandAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mExpandAnim.cancel();
        }
    }

    private void forceUniformHeight(int i11, int i12) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i13 = 0; i13 < i11; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i14 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i12, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i14;
                }
            }
        }
    }

    public static SwipeMenuLayout getViewCache() {
        return mViewCache;
    }

    private void init(Context context, AttributeSet attributeSet, int i11) {
        this.mScaleTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaxVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.isSwipeEnable = true;
        this.isIos = true;
        this.isLeftSwipe = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SwipeMenuLayout, i11, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i12 = 0; i12 < indexCount; i12++) {
            int index = obtainStyledAttributes.getIndex(i12);
            if (index == R$styleable.SwipeMenuLayout_swipeEnable) {
                this.isSwipeEnable = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R$styleable.SwipeMenuLayout_ios) {
                this.isIos = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R$styleable.SwipeMenuLayout_leftSwipe) {
                this.isLeftSwipe = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r1 != 3) goto L_0x0140;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isSwipeEnable
            if (r0 == 0) goto L_0x0140
            r5.acquireVelocityTracker(r6)
            android.view.VelocityTracker r0 = r5.mVelocityTracker
            int r1 = r6.getAction()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x00ff
            if (r1 == r2) goto L_0x0096
            r4 = 2
            if (r1 == r4) goto L_0x001b
            r4 = 3
            if (r1 == r4) goto L_0x0096
            goto L_0x0140
        L_0x001b:
            boolean r0 = r5.iosInterceptFlag
            if (r0 == 0) goto L_0x0021
            goto L_0x0140
        L_0x0021:
            android.graphics.PointF r0 = r5.mLastP
            float r0 = r0.x
            float r1 = r6.getRawX()
            float r0 = r0 - r1
            float r1 = java.lang.Math.abs(r0)
            r4 = 1092616192(0x41200000, float:10.0)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0040
            int r1 = r5.getScrollX()
            int r1 = java.lang.Math.abs(r1)
            r4 = 10
            if (r1 <= r4) goto L_0x0047
        L_0x0040:
            android.view.ViewParent r1 = r5.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
        L_0x0047:
            float r1 = java.lang.Math.abs(r0)
            int r2 = r5.mScaleTouchSlop
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0054
            r5.isUnMoved = r3
        L_0x0054:
            int r0 = (int) r0
            r5.scrollBy(r0, r3)
            boolean r0 = r5.isLeftSwipe
            if (r0 == 0) goto L_0x0071
            int r0 = r5.getScrollX()
            if (r0 >= 0) goto L_0x0065
            r5.scrollTo(r3, r3)
        L_0x0065:
            int r0 = r5.getScrollX()
            int r1 = r5.mRightMenuWidths
            if (r0 <= r1) goto L_0x0087
            r5.scrollTo(r1, r3)
            goto L_0x0087
        L_0x0071:
            int r0 = r5.getScrollX()
            int r1 = r5.mRightMenuWidths
            int r2 = -r1
            if (r0 >= r2) goto L_0x007e
            int r0 = -r1
            r5.scrollTo(r0, r3)
        L_0x007e:
            int r0 = r5.getScrollX()
            if (r0 <= 0) goto L_0x0087
            r5.scrollTo(r3, r3)
        L_0x0087:
            android.graphics.PointF r0 = r5.mLastP
            float r1 = r6.getRawX()
            float r2 = r6.getRawY()
            r0.set(r1, r2)
            goto L_0x0140
        L_0x0096:
            float r1 = r6.getRawX()
            android.graphics.PointF r4 = r5.mFirstP
            float r4 = r4.x
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            int r4 = r5.mScaleTouchSlop
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ac
            r5.isUserSwiped = r2
        L_0x00ac:
            boolean r1 = r5.iosInterceptFlag
            if (r1 != 0) goto L_0x00f9
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r5.mMaxVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            int r1 = r5.mPointerId
            float r0 = r0.getXVelocity(r1)
            float r1 = java.lang.Math.abs(r0)
            r2 = 1148846080(0x447a0000, float:1000.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e6
            r1 = -998637568(0xffffffffc47a0000, float:-1000.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00da
            boolean r0 = r5.isLeftSwipe
            if (r0 == 0) goto L_0x00d6
            r5.smoothExpand()
            goto L_0x00f9
        L_0x00d6:
            r5.smoothClose()
            goto L_0x00f9
        L_0x00da:
            boolean r0 = r5.isLeftSwipe
            if (r0 == 0) goto L_0x00e2
            r5.smoothClose()
            goto L_0x00f9
        L_0x00e2:
            r5.smoothExpand()
            goto L_0x00f9
        L_0x00e6:
            int r0 = r5.getScrollX()
            int r0 = java.lang.Math.abs(r0)
            int r1 = r5.mLimit
            if (r0 <= r1) goto L_0x00f6
            r5.smoothExpand()
            goto L_0x00f9
        L_0x00f6:
            r5.smoothClose()
        L_0x00f9:
            r5.releaseVelocityTracker()
            isTouching = r3
            goto L_0x0140
        L_0x00ff:
            r5.isUserSwiped = r3
            r5.isUnMoved = r2
            r5.iosInterceptFlag = r3
            boolean r0 = isTouching
            if (r0 == 0) goto L_0x010a
            return r3
        L_0x010a:
            isTouching = r2
            android.graphics.PointF r0 = r5.mLastP
            float r1 = r6.getRawX()
            float r4 = r6.getRawY()
            r0.set(r1, r4)
            android.graphics.PointF r0 = r5.mFirstP
            float r1 = r6.getRawX()
            float r4 = r6.getRawY()
            r0.set(r1, r4)
            com.huobi.view.swipemenulib.SwipeMenuLayout r0 = mViewCache
            if (r0 == 0) goto L_0x013a
            if (r0 == r5) goto L_0x0133
            r0.smoothClose()
            boolean r0 = r5.isIos
            r5.iosInterceptFlag = r0
        L_0x0133:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
        L_0x013a:
            int r0 = r6.getPointerId(r3)
            r5.mPointerId = r0
        L_0x0140:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.swipemenulib.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean isIos() {
        return this.isIos;
    }

    public boolean isLeftSwipe() {
        return this.isLeftSwipe;
    }

    public boolean isSwipeEnable() {
        return this.isSwipeEnable;
    }

    public void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = mViewCache;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.smoothClose();
            mViewCache = null;
        }
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isSwipeEnable) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (this.isLeftSwipe) {
                    if (getScrollX() > this.mScaleTouchSlop && motionEvent.getX() < ((float) (getWidth() - getScrollX()))) {
                        if (this.isUnMoved) {
                            smoothClose();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.mScaleTouchSlop && motionEvent.getX() > ((float) (-getScrollX()))) {
                    if (this.isUnMoved) {
                        smoothClose();
                    }
                    return true;
                }
                if (this.isUserSwiped) {
                    return true;
                }
            } else if (action == 2 && Math.abs(motionEvent.getRawX() - this.mFirstP.x) > ((float) this.mScaleTouchSlop)) {
                return true;
            }
            if (this.iosInterceptFlag) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                if (i15 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.isLeftSwipe) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setClickable(true);
        this.mRightMenuWidths = 0;
        this.mHeight = 0;
        int childCount = getChildCount();
        boolean z11 = View.MeasureSpec.getMode(i12) != 1073741824;
        int i13 = 0;
        boolean z12 = false;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i11, i12);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.mHeight = Math.max(this.mHeight, childAt.getMeasuredHeight());
                if (z11 && marginLayoutParams.height == -1) {
                    z12 = true;
                }
                if (i14 > 0) {
                    this.mRightMenuWidths += childAt.getMeasuredWidth();
                } else {
                    this.mContentView = childAt;
                    i13 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i13, this.mHeight + getPaddingTop() + getPaddingBottom());
        this.mLimit = (this.mRightMenuWidths * 4) / 10;
        if (z12) {
            forceUniformHeight(childCount, i11);
        }
    }

    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.mScaleTouchSlop) {
            return false;
        }
        return super.performLongClick();
    }

    public void quickClose() {
        if (this == mViewCache) {
            cancelAnim();
            mViewCache.scrollTo(0, 0);
            mViewCache = null;
        }
    }

    public SwipeMenuLayout setIos(boolean z11) {
        this.isIos = z11;
        return this;
    }

    public SwipeMenuLayout setLeftSwipe(boolean z11) {
        this.isLeftSwipe = z11;
        return this;
    }

    public void setSwipeEnable(boolean z11) {
        this.isSwipeEnable = z11;
    }

    public void smoothClose() {
        mViewCache = null;
        View view = this.mContentView;
        if (view != null) {
            view.setLongClickable(true);
        }
        cancelAnim();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.mCloseAnim = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.mCloseAnim.setInterpolator(new AccelerateInterpolator());
        this.mCloseAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SwipeMenuLayout.this.isExpand = false;
            }
        });
        this.mCloseAnim.setDuration(300).start();
    }

    public void smoothExpand() {
        mViewCache = this;
        View view = this.mContentView;
        if (view != null) {
            view.setLongClickable(false);
        }
        cancelAnim();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.isLeftSwipe ? this.mRightMenuWidths : -this.mRightMenuWidths;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.mExpandAnim = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.mExpandAnim.setInterpolator(new OvershootInterpolator());
        this.mExpandAnim.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SwipeMenuLayout.this.isExpand = true;
            }
        });
        this.mExpandAnim.setDuration(300).start();
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mLastP = new PointF();
        this.isUnMoved = true;
        this.mFirstP = new PointF();
        init(context, attributeSet, i11);
    }
}
