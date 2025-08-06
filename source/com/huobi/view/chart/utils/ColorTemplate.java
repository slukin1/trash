package com.huobi.view.chart.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.oned.Code39Reader;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import java.util.ArrayList;
import java.util.List;

public class ColorTemplate {
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 120), Color.rgb(106, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 134), Color.rgb(53, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 209)};
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, 248, 246), Color.rgb(Code39Reader.ASTERISK_ENCODING, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION), Color.rgb(42, 109, 130)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, 140), Color.rgb(255, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    public static int colorWithAlpha(int i11, int i12) {
        return (i11 & FlexItem.MAX_SIZE) | ((i12 & 255) << 24);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(color)));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static int rgb(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }
}
