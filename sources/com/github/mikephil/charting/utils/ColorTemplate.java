package com.github.mikephil.charting.utils;

import android.graphics.Color;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.oned.Code39Reader;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;

public class ColorTemplate {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f65535a = {Color.rgb(207, 248, 246), Color.rgb(Code39Reader.ASTERISK_ENCODING, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION), Color.rgb(42, 109, 130)};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f65536b = {Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 120), Color.rgb(106, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 134), Color.rgb(53, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 209)};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f65537c = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f65538d = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f65539e = {Color.rgb(192, 255, 140), Color.rgb(255, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f65540f = {b("#2ecc71"), b("#f1c40f"), b("#e74c3c"), b("#3498db")};

    public static int a(int i11, int i12) {
        return (i11 & FlexItem.MAX_SIZE) | ((i12 & 255) << 24);
    }

    public static int b(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }
}
