package com.tencent.liteav.videobase.b;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.a;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.liteav.videobase.utils.PerspectiveTransformMatrixCalculator;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.filter.TXCGPUImagePerspectiveCorrectionFilter;
import java.util.List;

public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    private int f22063h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f22064i;

    public b() {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, TXCGPUImagePerspectiveCorrectionFilter.DISTORTION_CORRECTION_FILTER_FRAGMENT_SHADER);
    }

    public final void a(int i11) {
        super.a(i11);
        float[] fArr = this.f22064i;
        if (fArr == null) {
            fArr = GLConstants.f22071a;
        }
        GLES20.glUniformMatrix3fv(this.f22063h, 1, false, fArr, 0);
    }

    public final void b(e eVar) {
        super.b(eVar);
        this.f22063h = GLES20.glGetUniformLocation(this.f22056f, "matrix");
    }

    public static /* synthetic */ void a(b bVar, List list, List list2) {
        float[] perspectiveTransformMatrix = PerspectiveTransformMatrixCalculator.getPerspectiveTransformMatrix(list, list2);
        float[] fArr = new float[9];
        for (int i11 = 0; i11 < 3; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                fArr[(i12 * 3) + i11] = perspectiveTransformMatrix[(i11 * 3) + i12];
            }
        }
        bVar.f22064i = fArr;
    }
}
