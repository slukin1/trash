package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

public class TXCGPUSplitScreenFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_SPLIT_SCREEN = 1000;
    private SplitSceenParam mSplitScreenParam;
    private int mSpliteNumber = 0;
    private a[] mSubWindowPosition = null;
    private final int[] mSupportSplitNumber = {1, 4, 9};

    public static class SplitSceenParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public int splitScreenNumber;
    }

    private void updateParams(SplitSceenParam splitSceenParam) {
        int i11 = splitSceenParam.splitScreenNumber;
        if (i11 != this.mSpliteNumber) {
            int[] iArr = this.mSupportSplitNumber;
            int i12 = 0;
            if (i11 == iArr[0] || i11 == iArr[1] || i11 == iArr[2]) {
                this.mSpliteNumber = i11;
                this.mSubWindowPosition = new a[i11];
                for (int i13 = 0; i13 < this.mSpliteNumber; i13++) {
                    this.mSubWindowPosition[i13] = new a((byte) 0);
                }
                int i14 = getOutputSize().width;
                int i15 = getOutputSize().height;
                int i16 = splitSceenParam.splitScreenNumber;
                int[] iArr2 = this.mSupportSplitNumber;
                if (i16 == iArr2[0]) {
                    a[] aVarArr = this.mSubWindowPosition;
                    aVarArr[0].f50916a = 0;
                    aVarArr[0].f50917b = 0;
                    aVarArr[0].f50918c = i14;
                    aVarArr[0].f50919d = i15;
                } else if (i16 == iArr2[1]) {
                    while (i12 < this.mSupportSplitNumber[1]) {
                        a[] aVarArr2 = this.mSubWindowPosition;
                        aVarArr2[i12].f50916a = ((i12 % 2) * i14) / 2;
                        aVarArr2[i12].f50917b = ((i12 / 2) * i15) / 2;
                        aVarArr2[i12].f50918c = i14 / 2;
                        aVarArr2[i12].f50919d = i15 / 2;
                        i12++;
                    }
                } else if (i16 == iArr2[2]) {
                    while (i12 < this.mSupportSplitNumber[2]) {
                        a[] aVarArr3 = this.mSubWindowPosition;
                        aVarArr3[i12].f50916a = ((i12 % 3) * i14) / 3;
                        aVarArr3[i12].f50917b = ((i12 / 3) * i15) / 3;
                        aVarArr3[i12].f50918c = i14 / 3;
                        aVarArr3[i12].f50919d = i15 / 3;
                        i12++;
                    }
                }
            }
        }
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mSubWindowPosition == null) {
            super.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
        }
        for (a aVar : this.mSubWindowPosition) {
            if (aVar != null) {
                GLES20.glViewport(aVar.f50916a, aVar.f50917b, aVar.f50918c, aVar.f50919d);
            }
            super.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
        }
        GLES20.glViewport(0, 0, getOutputSize().width, getOutputSize().height);
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mSplitScreenParam == null) {
            this.mSplitScreenParam = new SplitSceenParam();
        }
        long abs = Math.abs(j11 - this.mEffectStartTime);
        if (abs <= 1000) {
            this.mSplitScreenParam.splitScreenNumber = 4;
        } else if (abs <= 2000) {
            this.mSplitScreenParam.splitScreenNumber = 9;
        } else {
            this.mEffectStartTime = -1;
        }
        updateParams(this.mSplitScreenParam);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f50916a;

        /* renamed from: b  reason: collision with root package name */
        public int f50917b;

        /* renamed from: c  reason: collision with root package name */
        public int f50918c;

        /* renamed from: d  reason: collision with root package name */
        public int f50919d;

        private a() {
            this.f50916a = 0;
            this.f50917b = 0;
            this.f50918c = 0;
            this.f50919d = 0;
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }
}
