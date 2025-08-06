package com.jumio.core.enums;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.jumio.core.R;

public enum ErrorCase {
    GENERAL_NETWORK_ERROR("A", R.string.jumio_error_case_network_problems, true),
    CERTIFICATE_ERROR("B", r11, false),
    AUTH_FAILED("C", r11, false),
    DEVICE_IS_OFFLINE("E", R.string.jumio_error_case_device_is_offline, true),
    OCR_LOADING_FAILED("F", r4, false),
    CANCEL_TYPE_USER("G", R.string.jumio_error_case_cancelled_by_user, false),
    NO_CAMERA_CONNECTION("H", R.string.jumio_error_case_no_camera_connection, false),
    ALE_KEY_NOT_VALID("I", R.string.jumio_error_case_certificate_not_valid_anymore, false),
    TRANSACTION_FINISHED("J", R.string.jumio_error_case_session_expired, false),
    PROCESS_CANT_BE_COMPLETED(KvStore.N, r4, false);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f39130a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39131b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f39132c;

    /* access modifiers changed from: public */
    ErrorCase(String str, int i11, boolean z11) {
        this.f39130a = str;
        this.f39131b = i11;
        this.f39132c = z11;
    }

    public final String getDomain() {
        return this.f39130a;
    }

    public final int getMessage() {
        return this.f39131b;
    }

    public final boolean getRetry() {
        return this.f39132c;
    }
}
