package com.huobi.view.showcaseview;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface ShowcaseDrawer {
    void drawShowcase(Bitmap bitmap, float f11, float f12, float f13);

    void drawToCanvas(Canvas canvas, Bitmap bitmap);

    void erase(Bitmap bitmap);

    float getBlockedRadius();

    int getShowcaseHeight();

    int getShowcaseWidth();

    void setBackgroundColour(int i11);

    void setShowcaseColour(int i11);
}
