package com.huochat.community.widget.divider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

class ColorDrawer extends Drawer {
    public ColorDrawer(int i11, int i12, int i13) {
        super(new ColorDrawable(opaqueColor(i11)), i12, i13);
    }

    public static int opaqueColor(int i11) {
        if (Color.alpha(i11) == 0) {
            return i11;
        }
        return Color.argb(255, Color.red(i11), Color.green(i11), Color.blue(i11));
    }
}
