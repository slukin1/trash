package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class TXCSavePreFrameFilter {
    private TXCGPUImageFilter mDrawFilter = null;
    private GLTexturePool mGLTexturePool;
    private ArrayList<GLTexture> mPreTextureBuffers = new ArrayList<>();
    private ArrayList<GLTexture> mRecyclerTextureBuffers = new ArrayList<>();
    private int mSavePreFrameNumber = 1;
    private int mVideoHeight = -1;
    private int mVideoWidth = -1;

    public void destroy() {
        TXCGPUImageFilter tXCGPUImageFilter = this.mDrawFilter;
        if (tXCGPUImageFilter != null) {
            tXCGPUImageFilter.uninitialize();
            this.mDrawFilter = null;
        }
        ArrayList<GLTexture> arrayList = this.mRecyclerTextureBuffers;
        if (arrayList != null) {
            Iterator<GLTexture> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
            this.mRecyclerTextureBuffers.clear();
            this.mRecyclerTextureBuffers = null;
        }
        ArrayList<GLTexture> arrayList2 = this.mPreTextureBuffers;
        if (arrayList2 != null) {
            Iterator<GLTexture> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                it3.next().release();
            }
            this.mPreTextureBuffers.clear();
            this.mPreTextureBuffers = null;
        }
    }

    public void initFilter(GLTexturePool gLTexturePool) {
        this.mGLTexturePool = gLTexturePool;
        if (this.mDrawFilter == null) {
            TXCGPUImageFilter tXCGPUImageFilter = new TXCGPUImageFilter();
            this.mDrawFilter = tXCGPUImageFilter;
            tXCGPUImageFilter.initialize(gLTexturePool);
        }
    }

    public boolean onDrawToTexture(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        boolean z11;
        GLTexture gLTexture2;
        if (this.mPreTextureBuffers.size() < this.mSavePreFrameNumber || this.mPreTextureBuffers.size() <= 0) {
            z11 = false;
        } else {
            GLTexture gLTexture3 = this.mPreTextureBuffers.get(0);
            TXCGPUImageFilter tXCGPUImageFilter = this.mDrawFilter;
            if (tXCGPUImageFilter != null) {
                tXCGPUImageFilter.onDraw(gLTexture3.getId(), gLTexture, floatBuffer, floatBuffer2);
            }
            this.mRecyclerTextureBuffers.add(gLTexture3);
            this.mPreTextureBuffers.remove(0);
            z11 = true;
        }
        if (this.mRecyclerTextureBuffers.size() > 0) {
            gLTexture2 = this.mRecyclerTextureBuffers.remove(0);
        } else {
            gLTexture2 = this.mGLTexturePool.obtain(this.mVideoWidth, this.mVideoHeight);
        }
        if (gLTexture2 != null) {
            this.mDrawFilter.onDraw(i11, gLTexture2, floatBuffer, floatBuffer2);
            this.mPreTextureBuffers.add(gLTexture2);
        }
        return z11;
    }

    public void onOutputSizeChanged(int i11, int i12) {
        this.mVideoWidth = i11;
        this.mVideoHeight = i12;
        TXCGPUImageFilter tXCGPUImageFilter = this.mDrawFilter;
        if (tXCGPUImageFilter != null) {
            tXCGPUImageFilter.onOutputSizeChanged(i11, i12);
        }
    }

    public void setSavePreFrameNumber(int i11) {
        if (i11 > 0) {
            this.mSavePreFrameNumber = i11;
        }
    }
}
