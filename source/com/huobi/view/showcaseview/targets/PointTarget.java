package com.huobi.view.showcaseview.targets;

import android.graphics.Point;

public class PointTarget implements Target {
    private final Point mPoint;

    public PointTarget(Point point) {
        this.mPoint = point;
    }

    public Point getPoint() {
        return this.mPoint;
    }

    public PointTarget(int i11, int i12) {
        this.mPoint = new Point(i11, i12);
    }
}
