package com.alibaba.verificationsdk.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.alibaba.verificationsdk.utils.Log;

public class BallImageView extends ImageView {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public float currentX = 40.0f;
    public float currentY = 50.0f;
    public float radius = 0.0f;

    public BallImageView(Context context) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        Log.i("TEST", "displayMetrics.widthPixels: " + mScreenWidth + " displayMetrics.heightPixels: " + mScreenHeight);
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        mScreenHeight = rect.height();
        Log.i("TEST", "getWindowVisibleDisplayFrame.width: " + rect.width() + " getWindowVisibleDisplayFrame.height: " + rect.height());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        if (r0 != 3) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean autoMouse(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r6.getHeight()
            float r0 = (float) r0
            r6.radius = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "x: "
            r0.append(r1)
            float r1 = r7.getX()
            r0.append(r1)
            java.lang.String r1 = " y: "
            r0.append(r1)
            float r1 = r7.getY()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TEST"
            com.alibaba.verificationsdk.utils.Log.i(r1, r0)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == r1) goto L_0x007e
            r2 = 2
            if (r0 == r2) goto L_0x003b
            r7 = 3
            if (r0 == r7) goto L_0x007e
            goto L_0x0090
        L_0x003b:
            float r0 = r7.getX()
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007d
            float r0 = r7.getX()
            int r4 = mScreenWidth
            int r5 = r6.getWidth()
            int r4 = r4 - r5
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0055
            goto L_0x007d
        L_0x0055:
            float r0 = r7.getY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007d
            float r0 = r7.getY()
            int r3 = mScreenHeight
            int r4 = r6.getHeight()
            int r4 = r4 * r2
            int r3 = r3 - r4
            float r2 = (float) r3
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x006f
            goto L_0x007d
        L_0x006f:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r7 = r7.getY()
            int r7 = (int) r7
            r6.setLocation(r0, r7)
            goto L_0x0091
        L_0x007d:
            return r1
        L_0x007e:
            float r7 = r6.radius
            r6.currentX = r7
            int r0 = mScreenHeight
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 * r7
            float r0 = r0 - r1
            r6.currentY = r0
            int r7 = (int) r7
            int r0 = (int) r0
            r6.setLocation(r7, r0)
        L_0x0090:
            r1 = 0
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.widgets.BallImageView.autoMouse(android.view.MotionEvent):boolean");
    }

    public void setLocation(int i11, int i12) {
        setFrame(i11, i12 - (getHeight() / 2), getWidth() + i11, i12 + (getHeight() / 2));
    }
}
