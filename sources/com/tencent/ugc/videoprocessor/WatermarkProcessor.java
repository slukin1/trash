package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCLicenseChecker;
import com.tencent.ugc.UGCWatermarkFilter;
import com.tencent.ugc.beauty.gpufilters.WatermarkItem;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.DelayQueue;
import com.tencent.ugc.videoprocessor.util.BitmapUtils;
import com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain;
import com.tencent.ugc.videoprocessor.watermark.PasterFilterChain;
import com.tencent.ugc.videoprocessor.watermark.SubtitleFilterChain;
import com.tencent.ugc.videoprocessor.watermark.TailWaterMarkChain;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPaster;
import com.tencent.ugc.videoprocessor.watermark.data.TailWaterMark;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class WatermarkProcessor {
    private static final String TAG = "WatermarkProcessor";
    private AnimatedPasterFilterChain mAnimatedPasterFilterChain = new AnimatedPasterFilterChain();
    private DelayQueue mDelayQueue = new DelayQueue();
    private GLTexturePool mGLTexturePool;
    private boolean mHasSetWaterMark = false;
    private boolean mIsReverse = false;
    private ArrayList<WatermarkItem> mLastWaterMarkList = new ArrayList<>();
    private PasterFilterChain mPasterFilterChain = new PasterFilterChain();
    private int mRenderMode = 1;
    private Size mRenderTargetSize = null;
    private SubtitleFilterChain mSubtitleFilterChain = new SubtitleFilterChain();
    private TailWaterMarkChain mTailWaterMarkChain = new TailWaterMarkChain();
    private long mVideoDuration = 0;
    private UGCWatermarkFilter mWatermarkFilter = new UGCWatermarkFilter();

    private void collectWaterMarkFromAnimatedPaster(ArrayList<WatermarkItem> arrayList, PixelFrame pixelFrame) {
        Bitmap decodeFile;
        List<AnimatedPaster> animatedPasterList = this.mAnimatedPasterFilterChain.getAnimatedPasterList();
        if (animatedPasterList == null || animatedPasterList.size() == 0) {
            this.mAnimatedPasterFilterChain.normalized(pixelFrame.getWidth(), pixelFrame.getHeight(), this.mRenderMode);
            animatedPasterList = this.mAnimatedPasterFilterChain.getAnimatedPasterList();
        }
        for (AnimatedPaster next : animatedPasterList) {
            long timeInEffect = getTimeInEffect(pixelFrame);
            if (timeInEffect >= next.mStartTime && timeInEffect <= next.mEndTime && (decodeFile = BitmapFactory.decodeFile(next.mPasterPath)) != null) {
                float f11 = next.mRotation;
                if (f11 == 0.0f) {
                    arrayList.add(newWaterMarkTag(decodeFile, next.mFrame));
                } else {
                    arrayList.add(newWaterMarkTag(BitmapUtils.rotateImage(f11, decodeFile), next.mFrame));
                }
            }
        }
    }

    private void collectWaterMarkFromStaticPaster(ArrayList<WatermarkItem> arrayList, PixelFrame pixelFrame) {
        List<TXVideoEditConstants.TXPaster> pasterList = this.mPasterFilterChain.getPasterList();
        if (pasterList == null || pasterList.size() == 0) {
            this.mPasterFilterChain.normalized(pixelFrame.getWidth(), pixelFrame.getHeight(), this.mRenderMode);
            pasterList = this.mPasterFilterChain.getPasterList();
        }
        for (TXVideoEditConstants.TXPaster next : pasterList) {
            long timeInEffect = getTimeInEffect(pixelFrame);
            if (timeInEffect >= next.startTime && timeInEffect <= next.endTime) {
                arrayList.add(newWaterMarkTag(next.pasterImage, next.frame));
            }
        }
    }

    private void collectWaterMarkFromSubtitle(ArrayList<WatermarkItem> arrayList, PixelFrame pixelFrame) {
        List<TXVideoEditConstants.TXSubtitle> subtitleList = this.mSubtitleFilterChain.getSubtitleList();
        if (subtitleList == null || subtitleList.size() == 0) {
            this.mSubtitleFilterChain.normalized(pixelFrame.getWidth(), pixelFrame.getHeight(), this.mRenderMode);
            subtitleList = this.mSubtitleFilterChain.getSubtitleList();
        }
        for (TXVideoEditConstants.TXSubtitle next : subtitleList) {
            long timeInEffect = getTimeInEffect(pixelFrame);
            if (timeInEffect >= next.startTime && timeInEffect <= next.endTime) {
                arrayList.add(newWaterMarkTag(next.titleImage, next.frame));
            }
        }
    }

    private void collectWaterMarkFromTail(ArrayList<WatermarkItem> arrayList, PixelFrame pixelFrame) {
        TailWaterMark tailWaterMark = this.mTailWaterMarkChain.getTailWaterMark(pixelFrame);
        if (tailWaterMark != null) {
            arrayList.add(newWaterMarkTag(tailWaterMark.getWaterMark(), tailWaterMark.getmWaterMarkRect()));
            this.mWatermarkFilter.setAlpha(this.mTailWaterMarkChain.getAlpha());
        }
    }

    private boolean compareWaterMarkList(List<WatermarkItem> list, List<WatermarkItem> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            WatermarkItem watermarkItem = list.get(i11);
            WatermarkItem watermarkItem2 = list2.get(i11);
            if (!watermarkItem.bitmap.equals(watermarkItem2.bitmap) || ((double) Math.abs(watermarkItem.xOffset - watermarkItem2.xOffset)) > 1.0E-5d || ((double) Math.abs(watermarkItem.yOffset - watermarkItem2.yOffset)) > 1.0E-5d || ((double) Math.abs(watermarkItem.fWidth - watermarkItem2.fWidth)) > 1.0E-5d) {
                return false;
            }
        }
        return true;
    }

    private long getTimeInEffect(PixelFrame pixelFrame) {
        long timestamp = pixelFrame.getTimestamp();
        if (!this.mIsReverse) {
            return timestamp;
        }
        long j11 = this.mVideoDuration;
        return g.a(j11 - timestamp, 0, j11);
    }

    public static /* synthetic */ void lambda$setWaterMark$0(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        watermarkProcessor.mHasSetWaterMark = true;
        watermarkProcessor.mWatermarkFilter.enableWatermark(true);
        watermarkProcessor.mWatermarkFilter.setWatermark(bitmap, tXRect.f50070x, tXRect.f50071y, tXRect.width);
    }

    private WatermarkItem newWaterMarkTag(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        WatermarkItem watermarkItem = new WatermarkItem();
        watermarkItem.bitmap = bitmap;
        watermarkItem.xOffset = tXRect.f50070x;
        watermarkItem.yOffset = tXRect.f50071y;
        watermarkItem.fWidth = tXRect.width;
        return watermarkItem;
    }

    /* access modifiers changed from: private */
    public void setAnimatedPasterListInternal(List<TXVideoEditConstants.TXAnimatedPaster> list, Size size) {
        LiteavLog.i(TAG, "setAnimatedPasterListInternal animatedPasterList: ".concat(String.valueOf(list)));
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setAnimatedPasterList is not supported in UGC_Smart license");
            return;
        }
        if (size == null) {
            Size size2 = this.mRenderTargetSize;
            size = size2 == null ? null : new Size(size2);
        }
        if (size != null) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster = list.get(i11);
                    TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster2 = new TXVideoEditConstants.TXAnimatedPaster();
                    TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
                    TXVideoEditConstants.TXRect tXRect2 = tXAnimatedPaster.frame;
                    tXRect.width = tXRect2.width;
                    tXRect.f50070x = tXRect2.f50070x;
                    tXRect.f50071y = tXRect2.f50071y;
                    tXAnimatedPaster2.frame = tXRect;
                    tXAnimatedPaster2.animatedPasterPathFolder = tXAnimatedPaster.animatedPasterPathFolder;
                    tXAnimatedPaster2.startTime = tXAnimatedPaster.startTime;
                    tXAnimatedPaster2.endTime = tXAnimatedPaster.endTime;
                    tXAnimatedPaster2.rotation = tXAnimatedPaster.rotation;
                    arrayList.add(tXAnimatedPaster2);
                }
                this.mAnimatedPasterFilterChain.setAnimatedPasterList(arrayList, size);
                return;
            }
            this.mAnimatedPasterFilterChain.setAnimatedPasterList((List<TXVideoEditConstants.TXAnimatedPaster>) null, size);
        }
    }

    /* access modifiers changed from: private */
    public void setPasterListInternal(List<TXVideoEditConstants.TXPaster> list, Size size) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPasterList is not supported in UGC_Smart license");
            return;
        }
        if (size == null) {
            Size size2 = this.mRenderTargetSize;
            size = size2 == null ? null : new Size(size2);
        }
        if (size != null) {
            LiteavLog.i(TAG, "==== setPasterList ==== pasterList: ".concat(String.valueOf(list)));
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    TXVideoEditConstants.TXPaster tXPaster = list.get(i11);
                    TXVideoEditConstants.TXPaster tXPaster2 = new TXVideoEditConstants.TXPaster();
                    TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
                    TXVideoEditConstants.TXRect tXRect2 = tXPaster.frame;
                    tXRect.width = tXRect2.width;
                    tXRect.f50070x = tXRect2.f50070x;
                    tXRect.f50071y = tXRect2.f50071y;
                    tXPaster2.frame = tXRect;
                    tXPaster2.pasterImage = tXPaster.pasterImage;
                    tXPaster2.startTime = tXPaster.startTime;
                    tXPaster2.endTime = tXPaster.endTime;
                    arrayList.add(tXPaster2);
                }
                this.mPasterFilterChain.setPasterList(arrayList, size);
                return;
            }
            this.mPasterFilterChain.setPasterList((List<TXVideoEditConstants.TXPaster>) null, size);
        }
    }

    /* access modifiers changed from: private */
    public void setSubtitleListInternal(List<TXVideoEditConstants.TXSubtitle> list, Size size) {
        if (size == null) {
            Size size2 = this.mRenderTargetSize;
            size = size2 == null ? null : new Size(size2);
        }
        if (size != null) {
            LiteavLog.i(TAG, "setSubtitleListInternal subtitleList: ".concat(String.valueOf(list)));
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    TXVideoEditConstants.TXSubtitle tXSubtitle = list.get(i11);
                    TXVideoEditConstants.TXSubtitle tXSubtitle2 = new TXVideoEditConstants.TXSubtitle();
                    TXVideoEditConstants.TXRect tXRect = new TXVideoEditConstants.TXRect();
                    TXVideoEditConstants.TXRect tXRect2 = tXSubtitle.frame;
                    tXRect.width = tXRect2.width;
                    tXRect.f50070x = tXRect2.f50070x;
                    tXRect.f50071y = tXRect2.f50071y;
                    tXSubtitle2.frame = tXRect;
                    tXSubtitle2.titleImage = tXSubtitle.titleImage;
                    tXSubtitle2.startTime = tXSubtitle.startTime;
                    tXSubtitle2.endTime = tXSubtitle.endTime;
                    arrayList.add(tXSubtitle2);
                }
                this.mSubtitleFilterChain.setSubtitleList(arrayList, size);
                return;
            }
            this.mSubtitleFilterChain.setSubtitleList((List<TXVideoEditConstants.TXSubtitle>) null, size);
        }
    }

    /* access modifiers changed from: private */
    public void setTailWaterMarkInternal(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j11, int i11) {
        LiteavLog.i(TAG, "setTailWaterMarkInternal: " + bitmap + ", rect: " + tXRect + ", startTime: " + j11 + ", duration: " + i11);
        TXVideoEditConstants.TXRect tXRect2 = new TXVideoEditConstants.TXRect();
        tXRect2.width = tXRect.width;
        tXRect2.f50070x = tXRect.f50070x;
        tXRect2.f50071y = tXRect.f50071y;
        this.mTailWaterMarkChain.setTailWaterMark(new TailWaterMark(bitmap, tXRect2, j11, i11 * 1000));
    }

    private boolean updateWaterMarkList(PixelFrame pixelFrame) {
        ArrayList<WatermarkItem> arrayList = new ArrayList<>();
        collectWaterMarkFromSubtitle(arrayList, pixelFrame);
        collectWaterMarkFromStaticPaster(arrayList, pixelFrame);
        collectWaterMarkFromAnimatedPaster(arrayList, pixelFrame);
        collectWaterMarkFromTail(arrayList, pixelFrame);
        if (!compareWaterMarkList(this.mLastWaterMarkList, arrayList)) {
            this.mWatermarkFilter.setWaterMarkList(arrayList);
            this.mLastWaterMarkList.clear();
            this.mLastWaterMarkList = arrayList;
            return true;
        }
        ArrayList<WatermarkItem> arrayList2 = this.mLastWaterMarkList;
        if ((arrayList2 == null || arrayList2.size() <= 0) && !this.mHasSetWaterMark) {
            return false;
        }
        return true;
    }

    public float getBlurLevel() {
        return this.mTailWaterMarkChain.getBlurLevel();
    }

    public void initialize(GLTexturePool gLTexturePool, int i11, int i12) {
        this.mGLTexturePool = gLTexturePool;
        this.mWatermarkFilter.initialize(gLTexturePool);
        this.mWatermarkFilter.enableWatermark(true);
        this.mWatermarkFilter.onOutputSizeChanged(i11, i12);
        if (i11 > 1 && i12 > 1) {
            this.mRenderTargetSize = new Size(i11, i12);
        }
    }

    public PixelFrame process(PixelFrame pixelFrame, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.mDelayQueue.rerun();
        if (!updateWaterMarkList(pixelFrame)) {
            return null;
        }
        GLTexture obtain = this.mGLTexturePool.obtain(pixelFrame.getWidth(), pixelFrame.getHeight());
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        this.mWatermarkFilter.onDraw(pixelFrame.getTextureId(), obtain, floatBuffer, floatBuffer2);
        PixelFrame wrap = obtain.wrap(pixelFrame.getGLContext());
        wrap.setTimestamp(pixelFrame.getTimestamp());
        obtain.release();
        return wrap;
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list) {
        Size size = this.mRenderTargetSize;
        this.mDelayQueue.add(d.a(this, list, size == null ? null : new Size(size)));
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list) {
        Size size = this.mRenderTargetSize;
        this.mDelayQueue.add(e.a(this, list, size == null ? null : new Size(size)));
    }

    public void setRenderMode(int i11) {
        this.mRenderMode = i11;
    }

    public void setRenderTargetSize(int i11, int i12) {
        LiteavLog.i(TAG, "setRenderResolution: width:" + i11 + "  height:" + i12);
        if (i11 > 0 && i12 > 0) {
            this.mRenderTargetSize = new Size(i11, i12);
        }
    }

    public void setReverse(boolean z11, long j11) {
        this.mIsReverse = z11;
        this.mVideoDuration = j11;
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        Size size = this.mRenderTargetSize;
        this.mDelayQueue.add(c.a(this, list, size == null ? null : new Size(size)));
    }

    public void setTailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j11, int i11) {
        this.mDelayQueue.add(b.a(this, bitmap, tXRect, j11, i11));
    }

    public void setWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.mDelayQueue.add(a.a(this, bitmap, tXRect));
    }

    public void uninitialize() {
        this.mWatermarkFilter.uninitialize();
        TailWaterMarkChain tailWaterMarkChain = this.mTailWaterMarkChain;
        if (tailWaterMarkChain != null) {
            tailWaterMarkChain.clear();
            this.mTailWaterMarkChain = null;
        }
        AnimatedPasterFilterChain animatedPasterFilterChain = this.mAnimatedPasterFilterChain;
        if (animatedPasterFilterChain != null) {
            animatedPasterFilterChain.clear();
            this.mAnimatedPasterFilterChain = null;
        }
        SubtitleFilterChain subtitleFilterChain = this.mSubtitleFilterChain;
        if (subtitleFilterChain != null) {
            subtitleFilterChain.clear();
            this.mSubtitleFilterChain = null;
        }
        PasterFilterChain pasterFilterChain = this.mPasterFilterChain;
        if (pasterFilterChain != null) {
            pasterFilterChain.clear();
            this.mPasterFilterChain = null;
        }
    }
}
