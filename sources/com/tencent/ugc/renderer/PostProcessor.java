package com.tencent.ugc.renderer;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.filter.TXCGPUImagePerspectiveCorrectionFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class PostProcessor {
    private final GLTexturePool mGLTexturePool;
    private boolean mNeedUpdatePerspectivePointsToFilter;
    private FloatBuffer mNormalCubeVerticesBuffer;
    private FloatBuffer mNormalTextureCoordsBuffer;
    private final Size mOutputSize;
    private List<PointF> mPerspectiveCorrectionDstViewPoints;
    private TXCGPUImagePerspectiveCorrectionFilter mPerspectiveCorrectionFilter;
    private List<PointF> mPerspectiveCorrectionSrcViewPoints;
    private PixelFrameRenderer mPixelFrameRender;
    private Matrix mRenderViewTransformMatrix;
    private final String mTAG = ("PostProcessor_" + hashCode());

    public PostProcessor(GLTexturePool gLTexturePool, int i11, int i12) {
        Size size = new Size();
        this.mOutputSize = size;
        this.mNeedUpdatePerspectivePointsToFilter = false;
        this.mGLTexturePool = gLTexturePool;
        size.set(i11, i12);
    }

    private void initializePerspectiveCorrectionFilter() {
        if (this.mPerspectiveCorrectionFilter == null) {
            TXCGPUImagePerspectiveCorrectionFilter tXCGPUImagePerspectiveCorrectionFilter = new TXCGPUImagePerspectiveCorrectionFilter();
            this.mPerspectiveCorrectionFilter = tXCGPUImagePerspectiveCorrectionFilter;
            tXCGPUImagePerspectiveCorrectionFilter.initialize(this.mGLTexturePool);
            if (this.mNormalCubeVerticesBuffer == null || this.mNormalTextureCoordsBuffer == null) {
                this.mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
                this.mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
            }
        }
    }

    private static PointF reversePointWithTransformMatrix(PointF pointF, Matrix matrix) {
        if (matrix == null) {
            return pointF;
        }
        Matrix matrix2 = new Matrix();
        if (!matrix.invert(matrix2)) {
            return pointF;
        }
        float[] fArr = new float[2];
        matrix2.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        return new PointF(fArr[0], fArr[1]);
    }

    private List<PointF> reverseViewPointsToMappingGLPoints(List<PointF> list) {
        ArrayList arrayList = new ArrayList();
        for (PointF next : list) {
            float f11 = next.x;
            Size size = this.mOutputSize;
            PointF reversePointWithTransformMatrix = reversePointWithTransformMatrix(new PointF(f11 * ((float) size.width), next.y * ((float) size.height)), this.mRenderViewTransformMatrix);
            float f12 = reversePointWithTransformMatrix.x;
            Size size2 = this.mOutputSize;
            PointF pointF = new PointF(f12 / ((float) size2.width), reversePointWithTransformMatrix.y / ((float) size2.height));
            pointF.y = 1.0f - pointF.y;
            arrayList.add(pointF);
        }
        return arrayList;
    }

    private void setPerspectivePointsToFilter(List<PointF> list, List<PointF> list2) {
        if (list != null && list.size() == 4 && list2 != null && list2.size() == 4 && this.mOutputSize.isValid() && this.mPerspectiveCorrectionFilter != null) {
            this.mPerspectiveCorrectionFilter.setPerspectiveCorrectionPoints(reverseViewPointsToMappingGLPoints(list), reverseViewPointsToMappingGLPoints(list2));
        }
    }

    private void uninitializePerspectiveCorrectionFilter() {
        TXCGPUImagePerspectiveCorrectionFilter tXCGPUImagePerspectiveCorrectionFilter = this.mPerspectiveCorrectionFilter;
        if (tXCGPUImagePerspectiveCorrectionFilter != null) {
            tXCGPUImagePerspectiveCorrectionFilter.uninitialize();
            this.mPerspectiveCorrectionFilter = null;
        }
    }

    private void uninitializePixelFrameRender() {
        PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRender;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.mPixelFrameRender = null;
        }
    }

    public void processFrame(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        if (this.mOutputSize.isValid()) {
            if (this.mPixelFrameRender == null) {
                String str = this.mTAG;
                LiteavLog.i(str, "create PixelFrameRenderer, size =" + this.mOutputSize);
                Size size = this.mOutputSize;
                this.mPixelFrameRender = new PixelFrameRenderer(size.width, size.height);
            }
            Size size2 = this.mOutputSize;
            OpenGlUtils.glViewport(0, 0, size2.width, size2.height);
            GLTexturePool gLTexturePool = this.mGLTexturePool;
            Size size3 = this.mOutputSize;
            GLTexture obtain = gLTexturePool.obtain(size3.width, size3.height);
            obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
            PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRender;
            Size size4 = this.mOutputSize;
            pixelFrameRenderer.setOutputSize(size4.width, size4.height);
            this.mPixelFrameRender.renderFrame(pixelFrame, gLScaleType, obtain);
            if (this.mPerspectiveCorrectionFilter == null) {
                initializePerspectiveCorrectionFilter();
            }
            if (this.mNeedUpdatePerspectivePointsToFilter) {
                setPerspectivePointsToFilter(this.mPerspectiveCorrectionSrcViewPoints, this.mPerspectiveCorrectionDstViewPoints);
                this.mNeedUpdatePerspectivePointsToFilter = false;
            }
            this.mPerspectiveCorrectionFilter.onDraw(obtain.getId(), (GLTexture) null, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            obtain.release();
        }
    }

    public void setOutputSize(int i11, int i12) {
        Size size = this.mOutputSize;
        if (size.width != i11 || size.height != i12) {
            size.set(i11, i12);
            this.mNeedUpdatePerspectivePointsToFilter = true;
        }
    }

    public void setPerspectiveCorrectionPoints(List<PointF> list, List<PointF> list2) {
        this.mPerspectiveCorrectionSrcViewPoints = list;
        this.mPerspectiveCorrectionDstViewPoints = list2;
        this.mNeedUpdatePerspectivePointsToFilter = true;
    }

    public void setRenderViewTransformMatrix(Matrix matrix) {
        if (!h.a(this.mRenderViewTransformMatrix, matrix)) {
            this.mRenderViewTransformMatrix = matrix;
            this.mNeedUpdatePerspectivePointsToFilter = true;
        }
    }

    public void uninitialize() {
        uninitializePixelFrameRender();
        uninitializePerspectiveCorrectionFilter();
    }
}
