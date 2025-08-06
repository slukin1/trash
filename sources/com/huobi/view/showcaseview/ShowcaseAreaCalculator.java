package com.huobi.view.showcaseview;

import android.graphics.Rect;
import android.util.Log;

class ShowcaseAreaCalculator {
    private final Rect mShowcaseRect = new Rect();

    public boolean calculateShowcaseRect(float f11, float f12, ShowcaseDrawer showcaseDrawer) {
        int i11 = (int) f11;
        int i12 = (int) f12;
        int showcaseWidth = showcaseDrawer.getShowcaseWidth();
        int showcaseHeight = showcaseDrawer.getShowcaseHeight();
        Rect rect = this.mShowcaseRect;
        int i13 = showcaseWidth / 2;
        int i14 = i11 - i13;
        if (rect.left == i14 && rect.top == i12 - (showcaseHeight / 2)) {
            return false;
        }
        Log.d("ShowcaseView", "Recalculated");
        Rect rect2 = this.mShowcaseRect;
        rect2.left = i14;
        int i15 = showcaseHeight / 2;
        rect2.top = i12 - i15;
        rect2.right = i11 + i13;
        rect2.bottom = i12 + i15;
        return true;
    }

    public Rect getShowcaseRect() {
        return this.mShowcaseRect;
    }
}
