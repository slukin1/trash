package com.jumio.ale.swig;

public class aleEngineJNI {
    public static final native void AESGCM_change_ownership(AESGCM aesgcm, long j11, boolean z11);

    public static final native void AESGCM_director_connect(AESGCM aesgcm, long j11, boolean z11, boolean z12);

    public static final native int AESGCM_finish(long j11, AESGCM aesgcm, byte[] bArr, int i11) throws Exception;

    public static final native void AESGCM_generateIV(long j11, AESGCM aesgcm) throws Exception;

    public static final native void AESGCM_generateKey(long j11, AESGCM aesgcm) throws Exception;

    public static final native void AESGCM_init(long j11, AESGCM aesgcm);

    public static final native void AESGCM_reset(long j11, AESGCM aesgcm) throws Exception;

    public static final native void AESGCM_setIV(long j11, AESGCM aesgcm, byte[] bArr) throws Exception;

    public static final native void AESGCM_setKey__SWIG_0(long j11, AESGCM aesgcm, byte[] bArr) throws Exception;

    public static final native void AESGCM_setMode(long j11, AESGCM aesgcm, int i11) throws Exception;

    public static final native int AESGCM_update(long j11, AESGCM aesgcm, byte[] bArr, int i11, byte[] bArr2, int i12) throws Exception;

    public static final native long ALECore_createRequest(long j11, ALECore aLECore) throws Exception;

    public static final native void ALECore_destroyRequest(long j11, ALECore aLECore, long j12, ALERequest aLERequest);

    public static final native void ALEHeader_add__SWIG_0(long j11, ALEHeader aLEHeader, String str, String str2);

    public static final native void ALEHeader_clear(long j11, ALEHeader aLEHeader);

    public static final native int ALERequest_calculateRequestFinish(long j11, ALERequest aLERequest);

    public static final native int ALERequest_calculateRequestInit(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, int i11);

    public static final native int ALERequest_calculateRequestSize(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, int i11);

    public static final native int ALERequest_calculateRequestUpdate(long j11, ALERequest aLERequest, int i11);

    public static final native int ALERequest_calculateResponseSize(long j11, ALERequest aLERequest, byte[] bArr) throws Exception;

    public static final native int ALERequest_finishRequest__SWIG_0(long j11, ALERequest aLERequest, byte[] bArr, int i11) throws Exception;

    public static final native int ALERequest_finishRequest__SWIG_1(long j11, ALERequest aLERequest, byte[] bArr) throws Exception;

    public static final native boolean ALERequest_finishResponse(long j11, ALERequest aLERequest) throws Exception;

    public static final native int ALERequest_getErrorCode(long j11, ALERequest aLERequest);

    public static final native int ALERequest_initRequest__SWIG_0(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, int i11, byte[] bArr, int i12) throws Exception;

    public static final native int ALERequest_initRequest__SWIG_1(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, int i11, byte[] bArr) throws Exception;

    public static final native void ALERequest_initResponse(long j11, ALERequest aLERequest);

    public static final native boolean ALERequest_isKeyUpdate(long j11, ALERequest aLERequest);

    public static final native boolean ALERequest_isVerified(long j11, ALERequest aLERequest);

    public static final native int ALERequest_request__SWIG_0(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, byte[] bArr, byte[] bArr2, int i11) throws Exception;

    public static final native int ALERequest_request__SWIG_1(long j11, ALERequest aLERequest, long j12, ALEHeader aLEHeader, byte[] bArr, byte[] bArr2) throws Exception;

    public static final native int ALERequest_response__SWIG_0(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2, int i11) throws Exception;

    public static final native int ALERequest_response__SWIG_1(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2) throws Exception;

    public static final native int ALERequest_updateRequest__SWIG_0(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2, int i11) throws Exception;

    public static final native int ALERequest_updateRequest__SWIG_1(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2) throws Exception;

    public static final native int ALERequest_updateResponse__SWIG_0(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2, int i11) throws Exception;

    public static final native int ALERequest_updateResponse__SWIG_1(long j11, ALERequest aLERequest, byte[] bArr, byte[] bArr2) throws Exception;

    public static final native void ALESettings_change_ownership(ALESettings aLESettings, long j11, boolean z11);

    public static final native void ALESettings_director_connect(ALESettings aLESettings, long j11, boolean z11, boolean z12);

    public static final native String ALESettings_getDirectory(long j11, ALESettings aLESettings);

    public static final native String ALESettings_getKeyID(long j11, ALESettings aLESettings);

    public static final native String ALESettings_getPublicKey(long j11, ALESettings aLESettings);

    public static final native void ALESettings_setDirectory(long j11, ALESettings aLESettings, String str);

    public static final native void ALESettings_setKeyID(long j11, ALESettings aLESettings, String str);

    public static final native void ALESettings_setPublicKey(long j11, ALESettings aLESettings, String str);

    public static final native void delete_AESGCM(long j11);

    public static final native void delete_ALECore(long j11);

    public static final native void delete_ALEHeader(long j11);

    public static final native void delete_ALESettings(long j11);

    public static final native long new_AESGCM() throws Exception;

    public static final native long new_ALECore(long j11, ALESettings aLESettings);

    public static final native long new_ALEHeader();

    public static final native long new_ALESettings();
}
