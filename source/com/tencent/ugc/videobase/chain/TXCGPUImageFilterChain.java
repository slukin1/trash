package com.tencent.ugc.videobase.chain;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TXCGPUImageFilterChain extends TXCGPUImageFilter {
    private static final String TAG = "TXCGPUImageFilterChain";
    private final List<TXCGPUImageFilter> mFilters = new ArrayList();
    private final Map<TXCGPUImageFilter, List<GPUInterceptor>> mInterceptorsBeforeFilter = new HashMap();
    private final List<GPUInterceptor> mLastInterceptors = new ArrayList();
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    private long mTimestamp = 0;

    private GLTexture doIntercept(List<GPUInterceptor> list, GLTexture gLTexture) {
        if (list == null || list.isEmpty()) {
            return gLTexture;
        }
        GLTexture gLTexture2 = null;
        Iterator<GPUInterceptor> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            GLTexture intercept = it2.next().intercept(this.mTimestamp, gLTexture2 == null ? gLTexture : gLTexture2);
            if (intercept == null) {
                LiteavLog.e(TAG, "doIntercept return null value");
                break;
            }
            if (!(gLTexture2 == null || intercept == gLTexture2)) {
                gLTexture2.release();
            }
            gLTexture2 = intercept;
        }
        return gLTexture2;
    }

    private GLTexture doLastIntercept(GLTexture gLTexture) {
        if (this.mLastInterceptors.isEmpty()) {
            return gLTexture;
        }
        if (gLTexture != null) {
            return doIntercept(this.mLastInterceptors, gLTexture);
        }
        LiteavLog.e(TAG, "last interceptors intecept on surface.");
        return null;
    }

    /* access modifiers changed from: private */
    public void initFiltersAndInterceptors() {
        for (TXCGPUImageFilter next : this.mFilters) {
            if (!next.isInitialized()) {
                next.initialize(this.mTexturePool);
            }
        }
        for (List<GPUInterceptor> next2 : this.mInterceptorsBeforeFilter.values()) {
            if (next2 != null && !next2.isEmpty()) {
                for (GPUInterceptor gPUInterceptor : next2) {
                    if (!gPUInterceptor.isInitialized()) {
                        gPUInterceptor.initialize(this.mTexturePool);
                    }
                }
            }
        }
        for (GPUInterceptor next3 : this.mLastInterceptors) {
            if (!next3.isInitialized()) {
                next3.initialize(this.mTexturePool);
            }
        }
    }

    private void initFiltersAndInterceptorsOnDraw() {
        runOnDraw(f.a(this));
    }

    public synchronized void addFilter(TXCGPUImageFilter tXCGPUImageFilter) {
        if (tXCGPUImageFilter != null) {
            if (!this.mLastInterceptors.isEmpty()) {
                if (this.mFilters.size() == 0) {
                    this.mFilters.add(new TXCGPUImageFilter());
                    LiteavLog.w(TAG, "add COPY filter to filter chain.");
                }
                this.mInterceptorsBeforeFilter.put(tXCGPUImageFilter, new ArrayList(this.mLastInterceptors));
                this.mLastInterceptors.clear();
            }
            this.mFilters.add(tXCGPUImageFilter);
            initFiltersAndInterceptorsOnDraw();
        }
    }

    public synchronized void addInterceptor(GPUInterceptor gPUInterceptor) {
        if (gPUInterceptor != null) {
            this.mLastInterceptors.add(gPUInterceptor);
            initFiltersAndInterceptorsOnDraw();
        }
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLTexture gLTexture2;
        int i12;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (i11 != -1) {
                List<TXCGPUImageFilter> list = this.mFilters;
                int size = list.size();
                GLTexture gLTexture3 = null;
                int i13 = 0;
                while (i13 < size) {
                    TXCGPUImageFilter tXCGPUImageFilter = list.get(i13);
                    Size outputSize = tXCGPUImageFilter.getOutputSize();
                    if (gLTexture3 != null) {
                        GLTexture doIntercept = doIntercept(this.mInterceptorsBeforeFilter.get(tXCGPUImageFilter), gLTexture3);
                        if (!(doIntercept == null || doIntercept == gLTexture3)) {
                            gLTexture3.release();
                        }
                        if (doIntercept != null) {
                            doIntercept.setMetaData(gLTexture.getMetaData());
                        }
                        gLTexture3 = doIntercept;
                    }
                    boolean z11 = true;
                    boolean z12 = i13 < size + -1;
                    if (!z12 || CollectionUtils.isEmpty((Collection<?>) this.mInterceptorsBeforeFilter.get(list.get(i13 + 1)))) {
                        z11 = false;
                    }
                    if (!z12 || !outputSize.equals(this.mOutputSize) || !tXCGPUImageFilter.canBeSkipped() || (gLTexture3 == null && z11)) {
                        if (z12) {
                            gLTexture2 = this.mTexturePool.obtain(outputSize.width, outputSize.height);
                            gLTexture2.setColorFormat(this.mColorRange, this.mColorSpace);
                        } else {
                            gLTexture2 = gLTexture;
                        }
                        OpenGlUtils.glViewport(0, 0, outputSize.width, outputSize.height);
                        if (gLTexture3 == null) {
                            i12 = i11;
                        } else {
                            i12 = gLTexture3.getId();
                        }
                        if (i13 == 0) {
                            tXCGPUImageFilter.onDraw(i12, gLTexture2, floatBuffer, floatBuffer2);
                        } else {
                            tXCGPUImageFilter.onDraw(i12, gLTexture2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                        }
                        if (gLTexture3 != null) {
                            gLTexture3.release();
                        }
                        if (gLTexture2 != null) {
                            gLTexture2.setMetaData(gLTexture.getMetaData());
                        }
                        gLTexture3 = gLTexture2;
                    } else {
                        tXCGPUImageFilter.onFilterBeenSkipped();
                    }
                    i13++;
                }
                if (!(gLTexture3 == null || gLTexture3 == gLTexture)) {
                    gLTexture3.release();
                }
                GLTexture doLastIntercept = doLastIntercept(gLTexture);
                if (doLastIntercept != null && doLastIntercept != gLTexture) {
                    OpenGlUtils.glViewport(0, 0, doLastIntercept.getWidth(), doLastIntercept.getHeight());
                    super.onDraw(doLastIntercept.getId(), gLTexture, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                    doLastIntercept.release();
                }
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        initFiltersAndInterceptors();
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        for (TXCGPUImageFilter onOutputSizeChanged : this.mFilters) {
            onOutputSizeChanged.onOutputSizeChanged(i11, i12);
        }
    }

    public void onUninit() {
        super.onUninit();
        for (TXCGPUImageFilter uninitialize : this.mFilters) {
            uninitialize.uninitialize();
        }
        for (List<GPUInterceptor> next : this.mInterceptorsBeforeFilter.values()) {
            if (next != null && !next.isEmpty()) {
                for (GPUInterceptor uninitialize2 : next) {
                    uninitialize2.uninitialize();
                }
            }
        }
        for (GPUInterceptor uninitialize3 : this.mLastInterceptors) {
            uninitialize3.uninitialize();
        }
    }

    public synchronized void removeAllFilterAndInterceptor() {
        this.mFilters.clear();
        this.mInterceptorsBeforeFilter.clear();
        this.mLastInterceptors.clear();
    }

    public void setTimestamp(long j11) {
        this.mTimestamp = j11;
    }
}
