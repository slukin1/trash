package com.huawei.hms.common.api;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.log.HMSLog;

public class AvailabilityException extends Exception {
    private static final String TAG = "AvailabilityException";
    private String message = null;

    private ConnectionResult generateConnectionResult(int i11) {
        HMSLog.i(TAG, "The availability check result is: " + i11);
        setMessage(i11);
        return new ConnectionResult(i11);
    }

    private void setMessage(int i11) {
        if (i11 == 21) {
            this.message = "ANDROID_VERSION_UNSUPPORT";
        } else if (i11 == 0) {
            this.message = "success";
        } else if (i11 == 1) {
            this.message = "SERVICE_MISSING";
        } else if (i11 == 2) {
            this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
        } else if (i11 != 3) {
            this.message = "INTERNAL_ERROR";
        } else {
            this.message = "SERVICE_DISABLED";
        }
    }

    public ConnectionResult getConnectionResult(HuaweiApiCallable huaweiApiCallable) {
        if (huaweiApiCallable == null || huaweiApiCallable.getHuaweiApi() == null) {
            HMSLog.e(TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApiCallable.getHuaweiApi().getContext(), 30000000));
    }

    public String getMessage() {
        return this.message;
    }

    public ConnectionResult getConnectionResult(HuaweiApi<? extends Api.ApiOptions> huaweiApi) {
        if (huaweiApi == null) {
            HMSLog.e(TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApi.getContext(), 30000000));
    }
}
