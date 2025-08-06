package com.tencent.ugc.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.h;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class SpsInfo {
    public Integer colourPrimaries = null;
    public int height = 0;
    public Integer matrixCoefficients = null;
    public Integer maxNumRefFrames = null;
    public Integer transferCharacteristics = null;
    public Integer videoFormat = null;
    public Integer videoFullRangeFlag = null;
    public int width = 0;

    public static native SpsInfo nativeDecodeSps(boolean z11, ByteBuffer byteBuffer);

    public static native byte[] nativeGetSpsPps(byte[] bArr, boolean z11, boolean z12);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpsInfo)) {
            return false;
        }
        SpsInfo spsInfo = (SpsInfo) obj;
        return spsInfo.width == this.width && spsInfo.height == this.height && h.a(this.videoFormat, spsInfo.videoFormat) && h.a(this.videoFullRangeFlag, spsInfo.videoFullRangeFlag) && h.a(this.colourPrimaries, spsInfo.colourPrimaries) && h.a(this.transferCharacteristics, spsInfo.transferCharacteristics) && h.a(this.matrixCoefficients, spsInfo.matrixCoefficients) && h.a(this.maxNumRefFrames, spsInfo.maxNumRefFrames);
    }

    public void set(SpsInfo spsInfo) {
        if (spsInfo == null) {
            spsInfo = new SpsInfo();
        }
        this.width = spsInfo.width;
        this.height = spsInfo.height;
        this.videoFormat = spsInfo.videoFormat;
        this.videoFullRangeFlag = spsInfo.videoFullRangeFlag;
        this.colourPrimaries = spsInfo.colourPrimaries;
        this.transferCharacteristics = spsInfo.transferCharacteristics;
        this.matrixCoefficients = spsInfo.matrixCoefficients;
        this.maxNumRefFrames = spsInfo.maxNumRefFrames;
    }

    public void setColourPrimaries(int i11) {
        this.colourPrimaries = Integer.valueOf(i11);
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setMatrixCoefficients(int i11) {
        this.matrixCoefficients = Integer.valueOf(i11);
    }

    public void setMaxNumRefFrames(int i11) {
        this.maxNumRefFrames = Integer.valueOf(i11);
    }

    public void setTransferCharacteristics(int i11) {
        this.transferCharacteristics = Integer.valueOf(i11);
    }

    public void setVideoFormat(int i11) {
        this.videoFormat = Integer.valueOf(i11);
    }

    public void setVideoFullRangeFlag(int i11) {
        this.videoFullRangeFlag = Integer.valueOf(i11);
    }

    public void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        return "SpsInfo(" + ("width=" + this.width + ",height=" + this.height + ",videoFormat=" + this.videoFormat + ",videoFullRangeFlag=" + this.videoFullRangeFlag + ",colourPrimaries=" + this.colourPrimaries + ",transferCharacteristics=" + this.transferCharacteristics + ",matrixCoefficients=" + this.matrixCoefficients + ",maxNumRefFrames=" + this.maxNumRefFrames) + ")";
    }
}
