package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class PullToRequestView extends RelativeLayout {
    private static final int FAULT_TOLERANCE_RANGE = 10;
    private static final long MIN_REF_TIME = 1000;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    public PullToRequestView(Context context) {
        super(context);
        init();
    }

    private boolean canPullDown() {
        return !this.pullingDownLock && this.adapter.isPullDownReady() && this.state == 0;
    }

    private boolean canPullUp() {
        return !this.pullingUpLock && this.adapter.isPullUpReady() && this.state == 0;
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    private void init() {
        this.stopAct = new Runnable() {
            public void run() {
                PullToRequestView.this.reversePulling();
            }
        };
    }

    private void performRequestNext() {
        this.pullTime = System.currentTimeMillis();
        this.state = -1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRequestNext();
        }
    }

    /* access modifiers changed from: private */
    public void reversePulling() {
        this.top = 0;
        scrollTo(0, 0);
        this.state = 0;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onReversed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r0 != 3) goto L_0x0187;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            if (r0 == 0) goto L_0x0181
            r1 = -1
            r2 = 1
            r3 = 100
            r4 = 0
            if (r0 == r2) goto L_0x0118
            r5 = 2
            if (r0 == r5) goto L_0x0015
            r5 = 3
            if (r0 == r5) goto L_0x0118
            goto L_0x0187
        L_0x0015:
            float r0 = r8.getY()
            int r5 = r7.state
            r6 = 1073741824(0x40000000, float:2.0)
            if (r5 == r1) goto L_0x00fa
            if (r5 == r2) goto L_0x00df
            int r1 = r7.top
            if (r1 <= 0) goto L_0x004e
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            if (r1 >= 0) goto L_0x0033
            r7.top = r4
        L_0x0033:
            int r1 = r7.top
            int r1 = -r1
            r7.scrollTo(r4, r1)
            com.mob.tools.gui.PullToRequestAdatper r1 = r7.adapter
            if (r1 == 0) goto L_0x0048
            int r2 = r7.headerHeight
            if (r2 == 0) goto L_0x0048
            int r4 = r7.top
            int r4 = r4 * r3
            int r4 = r4 / r2
            r1.onPullDown(r4)
        L_0x0048:
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0114
        L_0x004e:
            if (r1 >= 0) goto L_0x007a
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            if (r1 <= 0) goto L_0x005e
            r7.top = r4
        L_0x005e:
            int r1 = r7.top
            int r1 = -r1
            r7.scrollTo(r4, r1)
            com.mob.tools.gui.PullToRequestAdatper r1 = r7.adapter
            if (r1 == 0) goto L_0x0074
            int r2 = r7.footerHeight
            if (r2 == 0) goto L_0x0074
            int r4 = r7.top
            int r4 = -r4
            int r4 = r4 * r3
            int r4 = r4 / r2
            r1.onPullUp(r4)
        L_0x0074:
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0114
        L_0x007a:
            float r1 = r7.downY
            float r2 = r0 - r1
            r5 = 1092616192(0x41200000, float:10.0)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00af
            boolean r1 = r7.canPullDown()
            if (r1 == 0) goto L_0x0114
            int r1 = r7.top
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            int r1 = -r1
            r7.scrollTo(r4, r1)
            com.mob.tools.gui.PullToRequestAdatper r1 = r7.adapter
            if (r1 == 0) goto L_0x00aa
            int r2 = r7.headerHeight
            if (r2 == 0) goto L_0x00aa
            int r4 = r7.top
            int r4 = -r4
            int r4 = r4 * r3
            int r4 = r4 / r2
            r1.onPullUp(r4)
        L_0x00aa:
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0114
        L_0x00af:
            float r1 = r1 - r0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0114
            boolean r1 = r7.canPullUp()
            if (r1 == 0) goto L_0x0114
            int r1 = r7.top
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            int r1 = -r1
            r7.scrollTo(r4, r1)
            com.mob.tools.gui.PullToRequestAdatper r1 = r7.adapter
            if (r1 == 0) goto L_0x00da
            int r2 = r7.footerHeight
            if (r2 == 0) goto L_0x00da
            int r4 = r7.top
            int r4 = -r4
            int r4 = r4 * r3
            int r4 = r4 / r2
            r1.onPullUp(r4)
        L_0x00da:
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0114
        L_0x00df:
            int r1 = r7.top
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            if (r1 >= 0) goto L_0x00ef
            r7.top = r4
        L_0x00ef:
            int r1 = r7.top
            int r1 = -r1
            r7.scrollTo(r4, r1)
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0114
        L_0x00fa:
            int r1 = r7.top
            float r1 = (float) r1
            float r2 = r7.downY
            float r2 = r0 - r2
            float r2 = r2 / r6
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.top = r1
            if (r1 <= 0) goto L_0x010a
            r7.top = r4
        L_0x010a:
            int r1 = r7.top
            int r1 = -r1
            r7.scrollTo(r4, r1)
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
        L_0x0114:
            r7.downY = r0
            goto L_0x0187
        L_0x0118:
            int r0 = r7.state
            if (r0 == r1) goto L_0x0177
            if (r0 == 0) goto L_0x012a
            if (r0 == r2) goto L_0x0121
            goto L_0x0187
        L_0x0121:
            int r0 = r7.headerHeight
            r7.top = r0
            int r0 = -r0
            r7.scrollTo(r4, r0)
            goto L_0x0187
        L_0x012a:
            int r0 = r7.top
            int r1 = r7.headerHeight
            if (r0 <= r1) goto L_0x0145
            r7.top = r1
            int r0 = -r1
            r7.scrollTo(r4, r0)
            com.mob.tools.gui.PullToRequestAdatper r0 = r7.adapter
            if (r0 == 0) goto L_0x013d
            r0.onPullDown(r3)
        L_0x013d:
            r7.performFresh()
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0187
        L_0x0145:
            int r1 = r7.footerHeight
            int r2 = -r1
            if (r0 >= r2) goto L_0x0160
            int r0 = -r1
            r7.top = r0
            int r0 = -r0
            r7.scrollTo(r4, r0)
            com.mob.tools.gui.PullToRequestAdatper r0 = r7.adapter
            if (r0 == 0) goto L_0x0158
            r0.onPullUp(r3)
        L_0x0158:
            r7.performRequestNext()
            android.view.MotionEvent r8 = r7.getCancelEvent(r8)
            goto L_0x0187
        L_0x0160:
            if (r0 == 0) goto L_0x0187
            r7.scrollTo(r4, r4)
            com.mob.tools.gui.PullToRequestAdatper r0 = r7.adapter
            if (r0 == 0) goto L_0x0174
            int r1 = r7.top
            if (r1 <= 0) goto L_0x0171
            r0.onPullDown(r4)
            goto L_0x0174
        L_0x0171:
            r0.onPullUp(r4)
        L_0x0174:
            r7.top = r4
            goto L_0x0187
        L_0x0177:
            int r0 = r7.footerHeight
            int r0 = -r0
            r7.top = r0
            int r0 = -r0
            r7.scrollTo(r4, r0)
            goto L_0x0187
        L_0x0181:
            float r0 = r8.getY()
            r7.downY = r0
        L_0x0187:
            boolean r8 = super.dispatchTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.PullToRequestView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void performFresh() {
        this.pullTime = System.currentTimeMillis();
        this.state = 1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRefresh();
        }
    }

    public void performPullingDown(boolean z11) {
        int i11 = this.headerHeight;
        this.top = i11;
        scrollTo(0, -i11);
        if (z11) {
            performFresh();
        }
    }

    public void performPullingUp(boolean z11) {
        int i11 = -this.footerHeight;
        this.top = i11;
        scrollTo(0, -i11);
        if (z11) {
            performRequestNext();
        }
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        this.adapter = pullToRequestAdatper;
        removeAllViews();
        this.bodyView = (View) pullToRequestAdatper.getBodyView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.bodyView, layoutParams);
        View headerView2 = pullToRequestAdatper.getHeaderView();
        this.headerView = headerView2;
        headerView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.headerView.measure(0, 0);
        this.headerHeight = this.headerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = -this.headerHeight;
        addView(this.headerView, layoutParams2);
        View footerView2 = pullToRequestAdatper.getFooterView();
        this.footerView = footerView2;
        footerView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.footerView.measure(0, 0);
        this.footerHeight = this.footerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams3.addRule(9);
        layoutParams3.addRule(11);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = -this.headerHeight;
        addView(this.footerView, layoutParams3);
    }

    public void stopPulling() {
        long currentTimeMillis = System.currentTimeMillis() - this.pullTime;
        if (currentTimeMillis < 1000) {
            postDelayed(this.stopAct, 1000 - currentTimeMillis);
        } else {
            post(this.stopAct);
        }
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
