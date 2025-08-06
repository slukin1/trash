package com.tencent.ugc.videobase.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.PerspectiveTransformMatrixCalculator;
import java.util.List;

public class TXCGPUImagePerspectiveCorrectionFilter extends TXCGPUImageFilter {
    public static final String DISTORTION_CORRECTION_FILTER_FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform mat3 matrix;\n\nvoid main()\n{\n  float cv_y = 1.0 - textureCoordinate.y;\n  float denominator = matrix[0][2] * textureCoordinate.x + matrix[1][2] * cv_y + matrix[2][2];\n  vec2 dst_coords;\n  dst_coords.x = matrix[0][0] * textureCoordinate.x + matrix[1][0] * cv_y + matrix[2][0];\n  dst_coords.y = matrix[0][1] * textureCoordinate.x + matrix[1][1] * cv_y + matrix[2][1];\n  dst_coords.x = dst_coords.x / denominator;\n  dst_coords.y = 1.0 - (dst_coords.y / denominator);\n  gl_FragColor = texture2D(inputImageTexture, dst_coords);\n}\n";
    private static final String TAG = "TXCGPUImageDistortionCorrectionFilter";
    private float[] mTransformMatrix3x3;
    private int mUniformTransformMatrix;

    public TXCGPUImagePerspectiveCorrectionFilter() {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, DISTORTION_CORRECTION_FILTER_FRAGMENT_SHADER);
    }

    public static /* synthetic */ void lambda$setTransformPoints$0(TXCGPUImagePerspectiveCorrectionFilter tXCGPUImagePerspectiveCorrectionFilter, List list, List list2) {
        float[] perspectiveTransformMatrix = PerspectiveTransformMatrixCalculator.getPerspectiveTransformMatrix(list, list2);
        float[] fArr = new float[9];
        for (int i11 = 0; i11 < 3; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                fArr[(i12 * 3) + i11] = perspectiveTransformMatrix[(i11 * 3) + i12];
            }
        }
        tXCGPUImagePerspectiveCorrectionFilter.mTransformMatrix3x3 = fArr;
    }

    private void setTransformPoints(List<PointF> list, List<PointF> list2) {
        runOnDraw(a.a(this, list2, list));
    }

    public void beforeDrawArrays(int i11) {
        super.beforeDrawArrays(i11);
        float[] fArr = this.mTransformMatrix3x3;
        if (fArr == null) {
            fArr = GLConstants.IDENTITY_MATRIX_3X3;
        }
        GLES20.glUniformMatrix3fv(this.mUniformTransformMatrix, 1, false, fArr, 0);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mUniformTransformMatrix = GLES20.glGetUniformLocation(getProgramId(), "matrix");
    }

    public void setPerspectiveCorrectionPoints(List<PointF> list, List<PointF> list2) {
        if (list != null && list.size() == 4 && list2 != null && list2.size() == 4) {
            setTransformPoints(list, list2);
        }
    }
}
