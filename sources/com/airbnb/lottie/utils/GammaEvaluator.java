package com.airbnb.lottie.utils;

public class GammaEvaluator {
    private static float EOCF_sRGB(float f11) {
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((double) ((f11 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f11) {
        return f11 <= 0.0031308f ? f11 * 12.92f : (float) ((Math.pow((double) f11, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f11, int i11, int i12) {
        if (i11 == i12) {
            return i11;
        }
        float f12 = ((float) ((i11 >> 24) & 255)) / 255.0f;
        float EOCF_sRGB = EOCF_sRGB(((float) ((i11 >> 16) & 255)) / 255.0f);
        float EOCF_sRGB2 = EOCF_sRGB(((float) ((i11 >> 8) & 255)) / 255.0f);
        float EOCF_sRGB3 = EOCF_sRGB(((float) (i11 & 255)) / 255.0f);
        float EOCF_sRGB4 = EOCF_sRGB(((float) ((i12 >> 16) & 255)) / 255.0f);
        float EOCF_sRGB5 = EOCF_sRGB(((float) ((i12 >> 8) & 255)) / 255.0f);
        float EOCF_sRGB6 = EOCF_sRGB3 + (f11 * (EOCF_sRGB(((float) (i12 & 255)) / 255.0f) - EOCF_sRGB3));
        return (Math.round(OECF_sRGB(EOCF_sRGB + ((EOCF_sRGB4 - EOCF_sRGB) * f11)) * 255.0f) << 16) | (Math.round((f12 + (((((float) ((i12 >> 24) & 255)) / 255.0f) - f12) * f11)) * 255.0f) << 24) | (Math.round(OECF_sRGB(EOCF_sRGB2 + ((EOCF_sRGB5 - EOCF_sRGB2) * f11)) * 255.0f) << 8) | Math.round(OECF_sRGB(EOCF_sRGB6) * 255.0f);
    }
}
