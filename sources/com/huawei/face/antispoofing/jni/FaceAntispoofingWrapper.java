package com.huawei.face.antispoofing.jni;

import android.app.Activity;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.utils.LogFace;
import org.opencv.core.Mat;

public class FaceAntispoofingWrapper extends DetectorJNI {
    public FaceAntispoofingWrapper(String str, String str2, String str3) {
        try {
            super.createAndSetModelPath(str, str2, str3);
        } catch (Exception e11) {
            LogFace.e("FaceAntispoofingWrapper", "[FaceAntispoofingWrapper] createAndSetModelPath error", e11);
            throw new RuntimeException("createAndSetModelPath error", e11);
        }
    }

    public static boolean initSdk(Activity activity, String str) {
        return DetectorJNI.init(activity, str);
    }

    public void deleteFaceAntispoofingDetector() {
        LogFace.i("FaceAntispoofingWrapper", "[deleteFaceAntispoofingDetector] delete FaceAntispoofingDetector start.");
        if (this.detectorObject > 0) {
            try {
                super.delete();
            } catch (Exception e11) {
                LogFace.e("FaceAntispoofingWrapper", "[deleteFaceAntispoofingDetector] delete FaceAntispoofing error", e11);
            }
        }
    }

    public boolean getFaceAntispoofingDetectorResult(DetectTypeEnum detectTypeEnum) throws Exception {
        return '1' == super.getResult().charAt(detectTypeEnum.getResultIndex());
    }

    public Mat getFaceImageResult() throws Exception {
        Mat mat = new Mat();
        getFaceImage(mat.getNativeObjAddr());
        return mat;
    }

    public ErrorCodeEnum runFaceAntispoofingDetector(byte[] bArr, int i11, int i12, DetectTypeEnum detectTypeEnum) throws Exception {
        int runDetect = super.runDetect(bArr, i11, i12, detectTypeEnum.getTypeValue());
        ErrorCodeEnum formCode = ErrorCodeEnum.formCode(runDetect);
        if (formCode == null) {
            LogFace.e("FaceAntispoofingWrapper", "[runFaceAntispoofingDetector] undefined ErrorCode type, code=" + runDetect);
        }
        return formCode;
    }
}
