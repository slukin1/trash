package com.huobi.view.showcaseview.targets;

import android.graphics.Point;

public interface Target {
    public static final Target NONE = new Target() {
        public Point getPoint() {
            return new Point(1000000, 1000000);
        }
    };

    Point getPoint();
}
