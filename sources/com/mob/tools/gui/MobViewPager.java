package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class MobViewPager extends ViewGroup {
    private static final int DECELERATION = 10;
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private int flingVelocity;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private int pageWidth;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private boolean skipScreen;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, (AttributeSet) null);
    }

    private void adjustScroller() {
        View view;
        this.skipScreen = true;
        if (this.currentPage != null && getFocusedChild() == (view = this.currentPage)) {
            view.clearFocus();
        }
        int width = (this.currentScreen * getWidth()) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            this.scroller.startScroll(getScrollX(), 0, width, 0, 0);
        }
        invalidate();
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        int abs = (int) Math.abs(x11 - this.lastMotionX);
        if (((int) Math.abs(y11 - this.lastMotionY)) < abs && abs > this.touchSlop) {
            this.touchState = 1;
            this.lastMotionX = x11;
        }
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int right;
        if (this.adapter != null) {
            float x11 = motionEvent.getX();
            int i11 = (int) (this.lastMotionX - x11);
            this.lastMotionX = x11;
            if (i11 < 0) {
                if (getScrollX() > 0) {
                    scrollBy(Math.max(-getScrollX(), i11), 0);
                }
            } else if (i11 > 0 && getChildCount() != 0 && (right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth()) > 0) {
                scrollBy(Math.min(right, i11), 0);
            }
        }
    }

    private void init(Context context) {
        this.scroller = new Scroller(context, new Interpolator() {
            public float getInterpolation(float f11) {
                return (2.0f - f11) * f11;
            }
        });
        this.touchState = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i11) {
        if (this.adapter != null) {
            if (this.skipScreen && Math.abs(i11 - this.currentScreen) > 2) {
                removeAllViews();
                int i12 = this.currentScreen;
                if (i12 > 0) {
                    View view = this.adapter.getView(i12 - 1, this.previousPage, this);
                    this.previousPage = view;
                    addView(view);
                }
                View view2 = this.adapter.getView(this.currentScreen, this.currentPage, this);
                this.currentPage = view2;
                addView(view2);
                int i13 = this.currentScreen;
                if (i13 < this.screenCount - 1) {
                    View view3 = this.adapter.getView(i13 + 1, this.nextPage, this);
                    this.nextPage = view3;
                    addView(view3);
                }
            } else if (this.currentScreen > i11) {
                for (int i14 = 0; i14 < this.currentScreen - i11; i14++) {
                    int i15 = i11 + i14 + 1;
                    View view4 = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(0);
                    }
                    if (i15 < this.screenCount - 1) {
                        View view5 = this.adapter.getView(i15 + 1, view4, this);
                        this.nextPage = view5;
                        addView(view5);
                    } else {
                        this.nextPage = view4;
                    }
                }
            } else {
                for (int i16 = 0; i16 < i11 - this.currentScreen; i16++) {
                    int i17 = (i11 - i16) - 1;
                    View view6 = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i17 > 0) {
                        View view7 = this.adapter.getView(i17 - 1, view6, this);
                        this.previousPage = view7;
                        addView(view7, 0);
                    } else {
                        this.previousPage = view6;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i11);
        }
    }

    /* access modifiers changed from: private */
    public void scrollToScreenOnUIThread(int i11, boolean z11) {
        int i12;
        View view;
        this.skipScreen = z11;
        if (this.currentPage != null && getFocusedChild() == (view = this.currentPage)) {
            view.clearFocus();
        }
        int width = (i11 * getWidth()) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            int i13 = 0;
            if (!z11) {
                int abs = Math.abs(width) / 2;
                int i14 = this.flingVelocity;
                if (i14 != 0) {
                    int abs2 = Math.abs(i14);
                    i13 = (int) (((((double) abs2) - Math.sqrt((double) ((abs2 * abs2) - (Math.abs(width) * 20)))) * 1000.0d) / 10.0d);
                }
                if (i13 == 0 || i13 > abs) {
                    i12 = abs;
                    this.scroller.startScroll(getScrollX(), 0, width, 0, i12);
                }
            }
            i12 = i13;
            this.scroller.startScroll(getScrollX(), 0, width, 0, i12);
        }
        invalidate();
    }

    public void computeScroll() {
        if (this.adapter != null && this.screenCount > 0) {
            if (this.scroller.computeScrollOffset()) {
                scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
                postInvalidate();
            } else {
                int i11 = this.currentScreen;
                int currX = this.scroller.getCurrX();
                int width = getWidth();
                int i12 = currX / width;
                if (currX % width > width / 2) {
                    i12++;
                }
                int max = Math.max(0, Math.min(i12, this.screenCount - 1));
                this.currentScreen = max;
                if (i11 != max) {
                    onScreenChange(i11);
                }
            }
            if (this.adapter != null) {
                this.adapter.onScreenChanging(((float) getScrollX()) / ((float) getWidth()));
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.adapter != null && this.screenCount > 0) {
            long drawingTime = getDrawingTime();
            if (this.currentScreen > 0) {
                drawChild(canvas, this.previousPage, drawingTime);
            }
            drawChild(canvas, this.currentPage, drawingTime);
            if (this.currentScreen < this.screenCount - 1) {
                drawChild(canvas, this.nextPage, drawingTime);
            }
        }
    }

    public boolean dispatchUnhandledMove(View view, int i11) {
        int i12;
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i11);
        }
        if (i11 == 17) {
            int i13 = this.currentScreen;
            if (i13 > 0) {
                scrollToScreenOnUIThread(i13 - 1, false);
                return true;
            }
        } else if (i11 == 66 && (i12 = this.currentScreen) < this.screenCount - 1) {
            scrollToScreenOnUIThread(i12 + 1, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i11);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r0 != 3) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x000d
            int r3 = r4.touchState
            if (r3 == 0) goto L_0x000d
            return r2
        L_0x000d:
            android.view.VelocityTracker r3 = r4.velocityTracker
            if (r3 != 0) goto L_0x0017
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r4.velocityTracker = r3
        L_0x0017:
            android.view.VelocityTracker r3 = r4.velocityTracker
            r3.addMovement(r5)
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x002b
            if (r0 == r1) goto L_0x0027
            r5 = 3
            if (r0 == r5) goto L_0x002b
            goto L_0x004d
        L_0x0027:
            r4.handleInterceptMove(r5)
            goto L_0x004d
        L_0x002b:
            android.view.VelocityTracker r5 = r4.velocityTracker
            if (r5 == 0) goto L_0x0035
            r5.recycle()
            r5 = 0
            r4.velocityTracker = r5
        L_0x0035:
            r4.touchState = r3
            goto L_0x004d
        L_0x0038:
            float r0 = r5.getX()
            float r5 = r5.getY()
            r4.lastMotionX = r0
            r4.lastMotionY = r5
            android.widget.Scroller r5 = r4.scroller
            boolean r5 = r5.isFinished()
            r5 = r5 ^ r2
            r4.touchState = r5
        L_0x004d:
            int r5 = r4.touchState
            if (r5 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = r3
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.MobViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.adapter != null && this.screenCount > 0) {
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            int i17 = this.currentScreen;
            int i18 = i17 * i15;
            if (i17 > 0) {
                this.previousPage.layout(i18 - i15, 0, i18, i16);
            }
            int i19 = i18 + i15;
            this.currentPage.layout(i18, 0, i19, i16);
            if (this.currentScreen < this.screenCount - 1) {
                this.nextPage.layout(i19, 0, i15 + i19, i16);
            }
            if (this.pageWidth != getWidth()) {
                int i21 = this.pageWidth;
                this.pageWidth = getWidth();
                if (i21 != 0) {
                    adjustScroller();
                }
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.adapter != null && this.screenCount > 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                getChildAt(i13).measure(makeMeasureSpec, makeMeasureSpec2);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i11;
        int i12;
        if (this.adapter == null) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x11 = motionEvent.getX();
        if (action != 0) {
            if (action == 1) {
                if (this.touchState == 1) {
                    this.velocityTracker.computeCurrentVelocity(1000, (float) this.maximumVelocity);
                    int xVelocity = (int) this.velocityTracker.getXVelocity();
                    this.flingVelocity = xVelocity;
                    if (xVelocity > 500 && (i12 = this.currentScreen) > 0) {
                        scrollToScreenOnUIThread(i12 - 1, false);
                    } else if (xVelocity >= -500 || (i11 = this.currentScreen) >= this.screenCount - 1) {
                        int width = getWidth();
                        scrollToScreenOnUIThread((getScrollX() + (width / 2)) / width, false);
                    } else {
                        scrollToScreenOnUIThread(i11 + 1, false);
                    }
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
            } else if (action != 2) {
                if (action == 3) {
                    this.touchState = 0;
                }
            } else if (this.touchState == 1) {
                handleScrollMove(motionEvent);
            } else if (onInterceptTouchEvent(motionEvent) && this.touchState == 1) {
                handleScrollMove(motionEvent);
            }
        } else if (this.touchState != 0) {
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            this.lastMotionX = x11;
        }
        return true;
    }

    public void scrollLeft(boolean z11) {
        int i11 = this.currentScreen;
        if (i11 > 0) {
            scrollToScreen(i11 - 1, z11);
        }
    }

    public void scrollRight(boolean z11) {
        int i11 = this.currentScreen;
        if (i11 < this.screenCount - 1) {
            scrollToScreen(i11 + 1, z11);
        }
    }

    public void scrollToScreen(final int i11, final boolean z11) {
        post(new Runnable() {
            public void run() {
                MobViewPager.this.scrollToScreenOnUIThread(i11, z11);
            }
        });
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.setMobViewPager((MobViewPager) null);
        }
        this.adapter = viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        int count = viewPagerAdapter.getCount();
        this.screenCount = count;
        if (count <= 0) {
            this.currentScreen = 0;
            removeAllViews();
        } else if (count <= this.currentScreen) {
            scrollToScreenOnUIThread(count - 1, true);
        } else {
            removeAllViews();
            int i11 = this.currentScreen;
            if (i11 > 0) {
                View view = viewPagerAdapter.getView(i11 - 1, this.previousPage, this);
                this.previousPage = view;
                addView(view);
            }
            View view2 = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
            this.currentPage = view2;
            addView(view2);
            int i12 = this.currentScreen;
            if (i12 < this.screenCount - 1) {
                View view3 = viewPagerAdapter.getView(i12 + 1, this.nextPage, this);
                this.nextPage = view3;
                addView(view3);
            }
        }
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void scrollToScreen(int i11, boolean z11, boolean z12) {
        scrollToScreen(i11, z11);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
