package com.youth.banner.util;

import android.content.res.Resources;
import android.graphics.Outline;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

public class BannerUtils {
    public static int dp2px(float f11) {
        return (int) TypedValue.applyDimension(1, f11, Resources.getSystem().getDisplayMetrics());
    }

    public static int getRealPosition(boolean z11, int i11, int i12) {
        if (!z11) {
            return i11;
        }
        if (i11 == 0) {
            return i12 - 1;
        }
        if (i11 == i12 + 1) {
            return 0;
        }
        return i11 - 1;
    }

    public static View getView(ViewGroup viewGroup, int i11) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (!(layoutParams.height == -1 && layoutParams.width == -1)) {
            layoutParams.height = -1;
            layoutParams.width = -1;
            inflate.setLayoutParams(layoutParams);
        }
        return inflate;
    }

    public static void setBannerRound(View view, final float f11) {
        view.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f11);
            }
        });
        view.setClipToOutline(true);
    }
}
