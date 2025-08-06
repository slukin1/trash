package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;

@JNINamespace("liteav::video")
public class FrameMetaData {
    private final MirrorInfo mCaptureMirror = new MirrorInfo();
    private final Size mCaptureRealFrameSize = new Size();
    private final MirrorInfo mEncodeMirror;
    private k mEncodeRotation;
    private final Size mEncodeSize;
    private boolean mIsBlackFrame = false;
    private boolean mIsFrontCamera = false;
    private final MirrorInfo mPreprocessorMirror = new MirrorInfo();
    private k mPreprocessorRotation;
    private GLConstants.GLScaleType mPreprocessorScaleType;
    private final MirrorInfo mRenderMirror;
    private k mRenderRotation;
    private final Size mRenderSize;

    public FrameMetaData() {
        k kVar = k.NORMAL;
        this.mPreprocessorRotation = kVar;
        this.mPreprocessorScaleType = GLConstants.GLScaleType.CENTER_CROP;
        this.mRenderMirror = new MirrorInfo();
        this.mRenderRotation = kVar;
        this.mRenderSize = new Size();
        this.mEncodeMirror = new MirrorInfo();
        this.mEncodeRotation = kVar;
        this.mEncodeSize = new Size();
    }

    public Size getCaptureRealSize() {
        return this.mCaptureRealFrameSize;
    }

    public int getEncodeHeight() {
        return this.mEncodeSize.height;
    }

    public k getEncodeRotation() {
        return this.mEncodeRotation;
    }

    public int getEncodeRotationValue() {
        return this.mEncodeRotation.mValue;
    }

    public Size getEncodeSize() {
        return this.mEncodeSize;
    }

    public int getEncodeWidth() {
        return this.mEncodeSize.width;
    }

    public k getPreprocessorRotation() {
        return this.mPreprocessorRotation;
    }

    public int getPreprocessorRotationValue() {
        return this.mPreprocessorRotation.mValue;
    }

    public GLConstants.GLScaleType getPreprocessorScaleType() {
        return this.mPreprocessorScaleType;
    }

    public int getPreprocessorScaleTypeValue() {
        return this.mPreprocessorScaleType.mValue;
    }

    public int getRenderHeight() {
        return this.mRenderSize.height;
    }

    public k getRenderRotation() {
        return this.mRenderRotation;
    }

    public int getRenderRotationValue() {
        return this.mRenderRotation.mValue;
    }

    public Size getRenderSize() {
        return this.mRenderSize;
    }

    public int getRenderWidth() {
        return this.mRenderSize.width;
    }

    public boolean isBlackFrame() {
        return this.mIsBlackFrame;
    }

    public boolean isCaptureMirrorHorizontal() {
        return this.mCaptureMirror.isHorizontal;
    }

    public boolean isCaptureMirrorVertical() {
        return this.mCaptureMirror.isVertical;
    }

    public boolean isEncodeMirrorHorizontal() {
        return this.mEncodeMirror.isHorizontal;
    }

    public boolean isEncodeMirrorVertical() {
        return this.mEncodeMirror.isVertical;
    }

    public boolean isFrontCamera() {
        return this.mIsFrontCamera;
    }

    public boolean isPreprocessorMirrorHorizontal() {
        return this.mPreprocessorMirror.isHorizontal;
    }

    public boolean isPreprocessorMirrorVertical() {
        return this.mPreprocessorMirror.isVertical;
    }

    public boolean isRenderMirrorHorizontal() {
        return this.mRenderMirror.isHorizontal;
    }

    public boolean isRenderMirrorVertical() {
        return this.mRenderMirror.isVertical;
    }

    public void setCaptureMetaData(boolean z11, boolean z12, boolean z13, int i11, int i12) {
        MirrorInfo mirrorInfo = this.mCaptureMirror;
        mirrorInfo.isHorizontal = z11;
        mirrorInfo.isVertical = z12;
        this.mIsFrontCamera = z13;
        Size size = this.mCaptureRealFrameSize;
        size.width = i11;
        size.height = i12;
    }

    public void setEncodeMetaData(boolean z11, boolean z12, int i11, int i12, int i13) {
        MirrorInfo mirrorInfo = this.mEncodeMirror;
        mirrorInfo.isHorizontal = z11;
        mirrorInfo.isVertical = z12;
        this.mEncodeRotation = k.a(i11);
        Size size = this.mEncodeSize;
        size.width = i12;
        size.height = i13;
    }

    public void setEncodeMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo != null) {
            MirrorInfo mirrorInfo2 = this.mEncodeMirror;
            mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
            mirrorInfo2.isVertical = mirrorInfo.isVertical;
        }
    }

    public void setEncodeRotation(k kVar) {
        if (kVar != null) {
            this.mEncodeRotation = kVar;
        }
    }

    public void setEncodeSize(Size size) {
        this.mEncodeSize.set(size);
    }

    public void setIsBlackFrame(boolean z11) {
        this.mIsBlackFrame = z11;
    }

    public void setPreprocessorMetaData(boolean z11, boolean z12, int i11, int i12) {
        MirrorInfo mirrorInfo = this.mPreprocessorMirror;
        mirrorInfo.isHorizontal = z11;
        mirrorInfo.isVertical = z12;
        this.mPreprocessorRotation = k.a(i11);
        this.mPreprocessorScaleType = GLConstants.GLScaleType.a(i12);
    }

    public void setPreprocessorMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo != null) {
            MirrorInfo mirrorInfo2 = this.mPreprocessorMirror;
            mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
            mirrorInfo2.isVertical = mirrorInfo.isVertical;
        }
    }

    public void setPreprocessorRotation(k kVar) {
        if (kVar != null) {
            this.mPreprocessorRotation = kVar;
        }
    }

    public void setPreprocessorScaleType(GLConstants.GLScaleType gLScaleType) {
        if (gLScaleType != null) {
            this.mPreprocessorScaleType = gLScaleType;
        }
    }

    public void setRenderMetaData(boolean z11, boolean z12, int i11, int i12, int i13) {
        MirrorInfo mirrorInfo = this.mRenderMirror;
        mirrorInfo.isHorizontal = z11;
        mirrorInfo.isVertical = z12;
        this.mRenderRotation = k.a(i11);
        Size size = this.mRenderSize;
        size.width = i12;
        size.height = i13;
    }

    public void setRenderMirror(MirrorInfo mirrorInfo) {
        if (mirrorInfo != null) {
            MirrorInfo mirrorInfo2 = this.mRenderMirror;
            mirrorInfo2.isHorizontal = mirrorInfo.isHorizontal;
            mirrorInfo2.isVertical = mirrorInfo.isVertical;
        }
    }

    public void setRenderRotation(k kVar) {
        if (kVar != null) {
            this.mRenderRotation = kVar;
        }
    }

    public void setRenderSize(Size size) {
        this.mRenderSize.set(size);
    }
}
