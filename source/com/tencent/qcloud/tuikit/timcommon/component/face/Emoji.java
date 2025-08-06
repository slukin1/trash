package com.tencent.qcloud.tuikit.timcommon.component.face;

import android.graphics.Bitmap;

public class Emoji extends ChatFace {
    private Bitmap icon;

    public Bitmap getIcon() {
        return this.icon;
    }

    public void setIcon(Bitmap bitmap) {
        this.icon = bitmap;
    }
}
