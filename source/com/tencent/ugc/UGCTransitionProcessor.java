package com.tencent.ugc;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.List;

public class UGCTransitionProcessor {
    private final String TAG = "UGCTransitionProcessor";
    private final UGCCombineFrameFilter mCombineFrameFilter;
    private final int mOutputPixelHeight;
    private final int mOutputPixelWidth;

    public static class TXCCombineFrame {
        public PixelFrame drawInputFrame;
        public TXVideoEditConstants.TXAbsoluteRect drawRect;
        public TransformParams transformParams;
    }

    public static class TransformParams {
        public float alpha = 1.0f;
        public boolean isBackgroundTransparent = false;
        public int rotate = 0;
        public float scale = 1.0f;
    }

    public UGCTransitionProcessor(int i11, int i12, GLTexturePool gLTexturePool) {
        LiteavLog.i("UGCTransitionProcessor", "UGCTransitionProcessor pixelWidth = " + i11 + " pixelHeight = " + i12);
        this.mOutputPixelWidth = i11;
        this.mOutputPixelHeight = i12;
        this.mCombineFrameFilter = new UGCCombineFrameFilter(gLTexturePool);
    }

    private void Retain(List<PixelFrame> list) {
        for (PixelFrame next : list) {
            if (next != null) {
                next.retain();
            }
        }
    }

    private GLTexture combineFramesWithTransitionType(List<TXCCombineFrame> list, long j11, int i11) {
        switch (i11) {
            case 1:
                return processTwoPicLeftRightCombine(list, j11);
            case 2:
                return processTwoPicUpDownCombine(list, j11);
            case 3:
                return processTwoPicRotation(list, j11);
            case 4:
            case 5:
                return processTwoPicZoom(list, j11, i11);
            case 6:
                return processTwoPicFaceInOut(list, j11);
            default:
                return null;
        }
    }

    private static float getAlpha(int i11, long j11) {
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i11);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i11);
        long j12 = stayDurationMs + motionDurationMs;
        long j13 = j11 - ((j11 / j12) * j12);
        if (i11 == 4 || i11 == 5) {
            float f11 = (float) stayDurationMs;
            float f12 = (float) motionDurationMs;
            float f13 = f11 + (0.8f * f12);
            float f14 = (float) j13;
            if (f14 <= f13 || j13 > j12) {
                return 1.0f;
            }
            return 1.0f - ((f14 - f13) / (f12 * 0.2f));
        } else if (i11 == 6 && j13 > stayDurationMs && j13 <= j12) {
            return 1.0f - (((float) (j13 - stayDurationMs)) / ((float) motionDurationMs));
        } else {
            return 1.0f;
        }
    }

    private static float getCropOffset(int i11, long j11) {
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i11);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i11);
        long j12 = stayDurationMs + motionDurationMs;
        long j13 = j11 - ((j11 / j12) * j12);
        if (j13 < 0 || j13 > stayDurationMs) {
            return ((float) (j13 - stayDurationMs)) / ((float) motionDurationMs);
        }
        return 0.0f;
    }

    private TXVideoEditConstants.TXAbsoluteRect getFirstDrawRect(int i11, int i12) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        int i13 = this.mOutputPixelWidth;
        tXAbsoluteRect.width = i13;
        int i14 = this.mOutputPixelHeight;
        tXAbsoluteRect.height = i14;
        float f11 = (float) i11;
        float f12 = (float) i12;
        if (f11 / f12 >= ((float) i13) / ((float) i14)) {
            float f13 = ((float) (i13 * i12)) / f11;
            tXAbsoluteRect.f50068x = 0;
            tXAbsoluteRect.f50069y = ((int) (((float) i14) - f13)) / 2;
            tXAbsoluteRect.height = (int) f13;
        } else {
            float f14 = ((float) (i14 * i11)) / f12;
            tXAbsoluteRect.f50068x = ((int) (((float) i13) - f14)) / 2;
            tXAbsoluteRect.f50069y = 0;
            tXAbsoluteRect.width = (int) f14;
        }
        return tXAbsoluteRect;
    }

    private static int getRotation(int i11, long j11) {
        if (i11 != 3) {
            return 0;
        }
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i11);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i11);
        long j12 = stayDurationMs + motionDurationMs;
        long j13 = j11 - ((j11 / j12) * j12);
        if (j13 <= stayDurationMs || j13 > j12) {
            return 0;
        }
        return (int) ((((float) (j13 - stayDurationMs)) / ((float) motionDurationMs)) * 360.0f);
    }

    private static float getScale(int i11, long j11) {
        long stayDurationMs = UGCTransitionRules.getStayDurationMs(i11);
        long motionDurationMs = UGCTransitionRules.getMotionDurationMs(i11);
        long j12 = stayDurationMs + motionDurationMs;
        long j13 = j11 - ((j11 / j12) * j12);
        if (i11 != 3) {
            if (i11 != 4) {
                if (i11 == 5) {
                    if (j13 >= 0 && j13 <= stayDurationMs) {
                        return 1.1f;
                    }
                    if (j13 > stayDurationMs && j13 <= j12) {
                        return 1.1f - ((((float) (j13 - stayDurationMs)) * 0.1f) / ((float) motionDurationMs));
                    }
                }
            } else if (j13 > stayDurationMs && j13 < j12) {
                return ((((float) (j13 - stayDurationMs)) * 0.1f) / ((float) motionDurationMs)) + 1.0f;
            }
        } else if (j13 > stayDurationMs && j13 <= j12) {
            return 1.0f - (((float) (j13 - stayDurationMs)) / ((float) motionDurationMs));
        }
        return 1.0f;
    }

    private TXVideoEditConstants.TXAbsoluteRect getSecondDrawRect(int i11, int i12, int i13) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        int i14 = this.mOutputPixelWidth;
        tXAbsoluteRect.width = i14;
        int i15 = this.mOutputPixelHeight;
        tXAbsoluteRect.height = i15;
        float f11 = (float) i11;
        float f12 = (float) i12;
        if (f11 / f12 >= ((float) i14) / ((float) i15)) {
            float f13 = ((float) (i12 * i14)) / f11;
            if (i13 == 1) {
                tXAbsoluteRect.f50068x = i14;
            } else {
                tXAbsoluteRect.f50068x = 0;
            }
            if (i13 == 2) {
                tXAbsoluteRect.f50069y = i15 + (((int) (((float) i15) - f13)) / 2);
            } else {
                tXAbsoluteRect.f50069y = ((int) (((float) i15) - f13)) / 2;
            }
            tXAbsoluteRect.height = (int) f13;
        } else {
            float f14 = ((float) (i11 * i15)) / f12;
            if (i13 == 1) {
                tXAbsoluteRect.f50068x = i14 + (((int) (((float) i14) - f14)) / 2);
            } else {
                tXAbsoluteRect.f50068x = ((int) (((float) i14) - f14)) / 2;
            }
            if (i13 == 2) {
                tXAbsoluteRect.f50069y = i15;
            } else {
                tXAbsoluteRect.f50069y = 0;
            }
            tXAbsoluteRect.width = (int) f14;
        }
        return tXAbsoluteRect;
    }

    private GLTexture processTwoPicFaceInOut(List<TXCCombineFrame> list, long j11) {
        float alpha = getAlpha(6, j11);
        TransformParams transformParams = new TransformParams();
        list.get(0).transformParams = transformParams;
        transformParams.alpha = alpha;
        if (list.size() > 1) {
            TransformParams transformParams2 = new TransformParams();
            list.get(1).transformParams = transformParams2;
            transformParams2.alpha = 1.0f - alpha;
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect((TXVideoEditConstants.TXAbsoluteRect) null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private GLTexture processTwoPicLeftRightCombine(List<TXCCombineFrame> list, long j11) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.f50068x = (int) (getCropOffset(1, j11) * ((float) this.mOutputPixelWidth));
        int i11 = this.mOutputPixelWidth;
        tXAbsoluteRect.width = i11;
        int i12 = this.mOutputPixelHeight;
        tXAbsoluteRect.height = i12;
        this.mCombineFrameFilter.setCanvasSize(i11 * 2, i12);
        this.mCombineFrameFilter.setCropRect(tXAbsoluteRect);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private GLTexture processTwoPicRotation(List<TXCCombineFrame> list, long j11) {
        TXCCombineFrame tXCCombineFrame;
        int rotation = getRotation(3, j11);
        float scale = getScale(3, j11);
        TXCCombineFrame tXCCombineFrame2 = list.get(0);
        TransformParams transformParams = new TransformParams();
        tXCCombineFrame2.transformParams = transformParams;
        transformParams.rotate = rotation;
        transformParams.scale = scale;
        transformParams.isBackgroundTransparent = true;
        if (list.size() > 1) {
            tXCCombineFrame = list.get(1);
            tXCCombineFrame.transformParams = new TransformParams();
        } else {
            tXCCombineFrame = null;
        }
        if (rotation != 0) {
            tXCCombineFrame2.transformParams.isBackgroundTransparent = true;
            if (tXCCombineFrame != null) {
                tXCCombineFrame.transformParams.isBackgroundTransparent = true;
            }
        } else {
            tXCCombineFrame2.transformParams.alpha = 1.0f;
            if (tXCCombineFrame != null) {
                tXCCombineFrame.transformParams.alpha = 0.0f;
            }
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect((TXVideoEditConstants.TXAbsoluteRect) null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private GLTexture processTwoPicUpDownCombine(List<TXCCombineFrame> list, long j11) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = new TXVideoEditConstants.TXAbsoluteRect();
        tXAbsoluteRect.f50069y = (int) (getCropOffset(2, j11) * ((float) this.mOutputPixelHeight));
        int i11 = this.mOutputPixelWidth;
        tXAbsoluteRect.width = i11;
        int i12 = this.mOutputPixelHeight;
        tXAbsoluteRect.height = i12;
        this.mCombineFrameFilter.setCanvasSize(i11, i12 * 2);
        this.mCombineFrameFilter.setCropRect(tXAbsoluteRect);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private GLTexture processTwoPicZoom(List<TXCCombineFrame> list, long j11, int i11) {
        float scale = getScale(i11, j11);
        float alpha = getAlpha(i11, j11);
        TransformParams transformParams = new TransformParams();
        list.get(0).transformParams = transformParams;
        transformParams.scale = scale;
        transformParams.alpha = alpha;
        if (list.size() > 1) {
            TransformParams transformParams2 = new TransformParams();
            list.get(1).transformParams = transformParams2;
            if (i11 == 5) {
                transformParams2.scale = 1.1f;
            }
            transformParams2.alpha = 1.0f - alpha;
        }
        this.mCombineFrameFilter.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mCombineFrameFilter.setCropRect((TXVideoEditConstants.TXAbsoluteRect) null);
        return this.mCombineFrameFilter.combineFrame(list);
    }

    private void releaseFrameList(List<TXCCombineFrame> list) {
        for (TXCCombineFrame tXCCombineFrame : list) {
            PixelFrame pixelFrame = tXCCombineFrame.drawInputFrame;
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        }
    }

    public PixelFrame processFrame(List<PixelFrame> list, int i11) {
        if (list == null || list.size() == 0) {
            LiteavLog.e("UGCTransitionProcessor", "frameList is empty");
            return null;
        }
        Retain(list);
        ArrayList arrayList = new ArrayList();
        TXCCombineFrame tXCCombineFrame = new TXCCombineFrame();
        PixelFrame pixelFrame = list.get(0);
        tXCCombineFrame.drawInputFrame = pixelFrame;
        tXCCombineFrame.drawRect = getFirstDrawRect(pixelFrame.getWidth(), tXCCombineFrame.drawInputFrame.getHeight());
        arrayList.add(tXCCombineFrame);
        if (list.size() > 1) {
            TXCCombineFrame tXCCombineFrame2 = new TXCCombineFrame();
            PixelFrame pixelFrame2 = list.get(1);
            tXCCombineFrame2.drawInputFrame = pixelFrame2;
            tXCCombineFrame2.drawRect = getSecondDrawRect(pixelFrame2.getWidth(), tXCCombineFrame2.drawInputFrame.getHeight(), i11);
            arrayList.add(tXCCombineFrame2);
        }
        long timestamp = list.get(0).getTimestamp();
        GLTexture combineFramesWithTransitionType = combineFramesWithTransitionType(arrayList, timestamp, i11);
        releaseFrameList(arrayList);
        if (combineFramesWithTransitionType == null) {
            return null;
        }
        PixelFrame wrap = combineFramesWithTransitionType.wrap(list.get(0).getGLContext());
        wrap.setTimestamp(timestamp);
        combineFramesWithTransitionType.release();
        return wrap;
    }

    public void release() {
        this.mCombineFrameFilter.release();
    }
}
