package com.tencent.ugc;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCTransitionProcessor;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import java.util.LinkedList;
import java.util.List;

public class UGCCombineProcessor {
    private final String TAG = "UGCCombineProcessor";
    private final GLTexturePool mGLTexturePool;
    private final int mOutputPixelHeight;
    private final int mOutputPixelWidth;
    private final List<TXVideoEditConstants.TXAbsoluteRect> mScaleRectList;
    private final List<PixelFrameRenderer> mScaleRendererList;
    private final UGCCombineFrameFilter mUGCCombineProcessor;

    public UGCCombineProcessor(int i11, int i12, GLTexturePool gLTexturePool) {
        LiteavLog.i("UGCCombineProcessor", "UGCCombineProcessor pixelWidth = " + i11 + " pixelHeight = " + i12);
        this.mOutputPixelWidth = i11;
        this.mOutputPixelHeight = i12;
        this.mGLTexturePool = gLTexturePool;
        this.mScaleRendererList = new LinkedList();
        this.mScaleRectList = new LinkedList();
        this.mUGCCombineProcessor = new UGCCombineFrameFilter(gLTexturePool);
    }

    private void Retain(List<PixelFrame> list) {
        for (PixelFrame next : list) {
            if (next != null) {
                next.retain();
            }
        }
    }

    private PixelFrame preScale(PixelFrame pixelFrame, TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect, int i11) {
        if (this.mScaleRendererList.size() < i11 + 1) {
            this.mScaleRendererList.add(new PixelFrameRenderer(tXAbsoluteRect.width, tXAbsoluteRect.height));
            this.mScaleRectList.add(tXAbsoluteRect);
        }
        PixelFrameRenderer pixelFrameRenderer = this.mScaleRendererList.get(i11);
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect2 = this.mScaleRectList.get(i11);
        if (!(tXAbsoluteRect2.width == tXAbsoluteRect.width && tXAbsoluteRect2.height == tXAbsoluteRect.height)) {
            pixelFrameRenderer.uninitialize();
            pixelFrameRenderer = new PixelFrameRenderer(tXAbsoluteRect.width, tXAbsoluteRect.height);
            this.mScaleRendererList.remove(i11);
            this.mScaleRendererList.add(i11, pixelFrameRenderer);
        }
        GLTexture obtain = this.mGLTexturePool.obtain(tXAbsoluteRect.width, tXAbsoluteRect.height);
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        pixelFrameRenderer.renderFrame(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, obtain);
        PixelFrame wrap = obtain.wrap(pixelFrame.getGLContext());
        wrap.setTimestamp(pixelFrame.getTimestamp());
        obtain.release();
        pixelFrame.release();
        return wrap;
    }

    private void releaseFrameList(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        for (UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame : list) {
            PixelFrame pixelFrame = tXCCombineFrame.drawInputFrame;
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        }
    }

    public PixelFrame processFrame(List<PixelFrame> list, List<TXVideoEditConstants.TXAbsoluteRect> list2) {
        if (list == null || list.size() == 0) {
            LiteavLog.e("UGCCombineProcessor", "frameList is empty");
            return null;
        }
        Retain(list);
        LinkedList linkedList = new LinkedList();
        long j11 = 0;
        int i11 = 0;
        while (i11 < list.size()) {
            PixelFrame pixelFrame = list.get(i11);
            if (pixelFrame.getTimestamp() > j11) {
                j11 = pixelFrame.getTimestamp();
            }
            UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame = new UGCTransitionProcessor.TXCCombineFrame();
            TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = i11 < list2.size() ? list2.get(i11) : new TXVideoEditConstants.TXAbsoluteRect();
            tXCCombineFrame.drawRect = tXAbsoluteRect;
            tXCCombineFrame.drawInputFrame = preScale(pixelFrame, tXAbsoluteRect, i11);
            linkedList.add(tXCCombineFrame);
            i11++;
        }
        this.mUGCCombineProcessor.setCanvasSize(this.mOutputPixelWidth, this.mOutputPixelHeight);
        this.mUGCCombineProcessor.setCropRect((TXVideoEditConstants.TXAbsoluteRect) null);
        GLTexture combineFrame = this.mUGCCombineProcessor.combineFrame(linkedList);
        releaseFrameList(linkedList);
        if (combineFrame == null) {
            return null;
        }
        PixelFrame wrap = combineFrame.wrap(list.get(0).getGLContext());
        combineFrame.release();
        wrap.setTimestamp(j11);
        return wrap;
    }

    public void release() {
        this.mUGCCombineProcessor.release();
        for (PixelFrameRenderer next : this.mScaleRendererList) {
            if (next != null) {
                next.uninitialize();
            }
        }
        this.mScaleRendererList.clear();
        this.mScaleRectList.clear();
    }
}
