package com.huawei.face.antispoofing.listener;

import com.huawei.face.antispoofing.meta.DetectResult;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;

public interface FaceAntispoofingResultListener {
    void onDetectChange(DetectTypeEnum detectTypeEnum);

    void onDetectFinish(DetectResult detectResult);

    void onDetectLocalFinish(DetectResult detectResult);

    void onDetectTimeOut();

    void onDetecting(int i11, String str);
}
