package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;

public class ViewTarget implements Target {
    private final View mView;

    public ViewTarget(View view) {
        this.mView = view;
    }

    public Point getPoint() {
        int[] iArr = new int[2];
        this.mView.getLocationInWindow(iArr);
        return new Point(iArr[0] + (this.mView.getWidth() / 2), iArr[1] + (this.mView.getHeight() / 2));
    }

    public ViewTarget(int i11, Activity activity) {
        this.mView = activity.findViewById(i11);
    }
}
