package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.ugc.videoprocessor.videoeffect.filter.TXCGPUSpiritOutFilter;

public class TXCGPUPhontomFilter extends TXCGPUSpiritOutFilter {
    private static final int DURATION_PHANTOM_LV1 = 240;
    private static final int DURATION_PHANTOM_LV10 = 1320;
    private static final int DURATION_PHANTOM_LV11 = 1440;
    private static final int DURATION_PHANTOM_LV12 = 1560;
    private static final int DURATION_PHANTOM_LV13 = 1680;
    private static final int DURATION_PHANTOM_LV14 = 1800;
    private static final int DURATION_PHANTOM_LV2 = 360;
    private static final int DURATION_PHANTOM_LV3 = 480;
    private static final int DURATION_PHANTOM_LV4 = 600;
    private static final int DURATION_PHANTOM_LV5 = 720;
    private static final int DURATION_PHANTOM_LV6 = 840;
    private static final int DURATION_PHANTOM_LV7 = 960;
    private static final int DURATION_PHANTOM_LV8 = 1080;
    private static final int DURATION_PHANTOM_LV9 = 1200;
    private static final int DURATION_PHANTOM_LVMIN = 120;
    private PhantomParam mPhantomParam;

    public static class PhantomParam extends TXCGPUSpiritOutFilter.SpiritOutEffectParam {
        public float[] offetRed = {0.0f, 0.0f};
        public float[] offsetBlue = {0.0f, 0.0f};
        public float[] offsetGreen = {0.0f, 0.1f};
    }

    public void setNextFrameTimestamp(long j11) {
        TXCZoomInOutFilter tXCZoomInOutFilter;
        super.setNextFrameTimestamp(j11);
        if (this.mPhantomParam == null) {
            PhantomParam phantomParam = new PhantomParam();
            this.mPhantomParam = phantomParam;
            phantomParam.fringeNumber = 1;
            phantomParam.alpahLevel = 0.3f;
        }
        PhantomParam phantomParam2 = this.mPhantomParam;
        phantomParam2.offetRed = new float[]{0.0f, 0.0f};
        phantomParam2.offsetGreen = new float[]{0.0f, 0.1f};
        long abs = Math.abs(j11 - this.mEffectStartTime);
        int i11 = (abs > 120 ? 1 : (abs == 120 ? 0 : -1));
        if (i11 < 0) {
            PhantomParam phantomParam3 = this.mPhantomParam;
            phantomParam3.zoomOutLevel = 0;
            phantomParam3.offetRed = new float[]{0.0f, 0.0f};
            phantomParam3.offsetGreen = new float[]{0.0f, 0.0f};
        } else if (i11 < 0) {
            this.mPhantomParam.zoomOutLevel = 1;
        } else if (abs < 240) {
            this.mPhantomParam.zoomOutLevel = 2;
        } else if (abs < 360) {
            this.mPhantomParam.zoomOutLevel = 3;
        } else if (abs < 480) {
            this.mPhantomParam.zoomOutLevel = 4;
        } else if (abs < 600) {
            this.mPhantomParam.zoomOutLevel = 5;
        } else if (abs < 720) {
            this.mPhantomParam.zoomOutLevel = 6;
        } else if (abs < 840) {
            this.mPhantomParam.zoomOutLevel = 7;
        } else if (abs < 960) {
            this.mPhantomParam.zoomOutLevel = 8;
        } else if (abs < 1080) {
            this.mPhantomParam.zoomOutLevel = 9;
        } else if (abs < 1200) {
            this.mPhantomParam.zoomOutLevel = 10;
        } else if (abs < 1320) {
            this.mPhantomParam.zoomOutLevel = 11;
        } else if (abs < 1440) {
            this.mPhantomParam.zoomOutLevel = 12;
        } else if (abs < 1560) {
            this.mPhantomParam.zoomOutLevel = 13;
        } else if (abs < 1680) {
            this.mPhantomParam.zoomOutLevel = 14;
        } else if (abs < 1800) {
            this.mPhantomParam.zoomOutLevel = 15;
        } else {
            this.mEffectStartTime = -1;
        }
        PhantomParam phantomParam4 = this.mPhantomParam;
        if (phantomParam4 != null && (tXCZoomInOutFilter = this.mZoomInOutFilter) != null) {
            tXCZoomInOutFilter.setColorOffset(phantomParam4.offetRed, phantomParam4.offsetGreen, phantomParam4.offsetBlue);
        }
    }
}
