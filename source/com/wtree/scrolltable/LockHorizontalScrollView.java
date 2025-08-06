package com.wtree.scrolltable;

import android.content.Context;
import android.util.AttributeSet;

public class LockHorizontalScrollView extends SyncHorizontalScrollView {

    /* renamed from: c  reason: collision with root package name */
    public boolean f51241c;

    /* renamed from: d  reason: collision with root package name */
    public int f51242d;

    /* renamed from: e  reason: collision with root package name */
    public int f51243e;

    public LockHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2 != 3) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            int r2 = r7.getAction()
            r3 = 0
            if (r2 == 0) goto L_0x0036
            r4 = 1
            if (r2 == r4) goto L_0x0033
            r5 = 2
            if (r2 == r5) goto L_0x001b
            r0 = 3
            if (r2 == r0) goto L_0x0033
            goto L_0x003c
        L_0x001b:
            int r2 = r6.f51242d
            int r0 = r0 - r2
            int r2 = r6.f51243e
            int r1 = r1 - r2
            int r0 = java.lang.Math.abs(r0)
            int r1 = java.lang.Math.abs(r1)
            if (r0 >= r1) goto L_0x002e
            r6.f51241c = r4
            return r3
        L_0x002e:
            boolean r0 = r6.f51241c
            if (r0 == 0) goto L_0x003c
            return r3
        L_0x0033:
            r6.f51241c = r3
            goto L_0x003c
        L_0x0036:
            r6.f51242d = r0
            r6.f51243e = r1
            r6.f51241c = r3
        L_0x003c:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wtree.scrolltable.LockHorizontalScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
