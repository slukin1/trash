package com.huawei.face.antispoofing.meta;

public enum DetectErrorEnum {
    VerifyErrorSDKInitError,
    VerifyErrorTimeout,
    VerifyErrorCancel,
    VerifyErrorRemoteError,
    VerifyErrorSimilarityBlowThreshold,
    VerifyErrorIdNumberNotMatchName,
    VerifyErrorVerifyINfoNotMatchIdInfo,
    VerifyErrorFaceNotMatchIdInfo,
    VerifyErrorQualityOrFormatError,
    VerifyErrorNoFaceOrMoreFace,
    VerifyErrorNoImageInDatabase,
    VerifyErrorNoIdInfoInDatabase,
    VerifyErrorOrderIdIsNoneOrExpired,
    VerifyErrorFaceDetectError,
    VerifyErrorIdCardCannotRecognize,
    VerifyErrorImageCannotUse,
    VerifyErrorServerError
}
