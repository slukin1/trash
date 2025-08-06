package com.tencent.ugc.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.utils.OpenGlUtils;

public class GLFrameBuffer {
    private static final String TAG = "GLFrameBuffer";
    private int mFrameBufferId = -1;

    public void attachTexture(int i11) {
        int i12 = this.mFrameBufferId;
        if (i12 == -1) {
            LiteavLog.d(TAG, "FrameBuffer is invalid");
        } else {
            OpenGlUtils.attachTextureToFrameBuffer(i11, i12);
        }
    }

    public void bindToContext() {
        OpenGlUtils.bindFramebuffer(36160, this.mFrameBufferId);
    }

    public void detachTexture() {
        int i11 = this.mFrameBufferId;
        if (i11 == -1) {
            LiteavLog.d(TAG, "FrameBuffer is invalid");
        } else {
            OpenGlUtils.detachTextureFromFrameBuffer(i11);
        }
    }

    public void initialize() {
        if (this.mFrameBufferId == -1) {
            this.mFrameBufferId = OpenGlUtils.generateFrameBufferId();
        }
    }

    public void unbindFromContext() {
        OpenGlUtils.bindFramebuffer(36160, 0);
    }

    public void uninitialize() {
        int i11 = this.mFrameBufferId;
        if (i11 != -1) {
            OpenGlUtils.deleteFrameBuffer(i11);
            this.mFrameBufferId = -1;
        }
    }
}
