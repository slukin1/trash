package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a  reason: collision with root package name */
    private static final OpenDeviceHmsClientBuilder f38302a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final Api<OpenDeviceOptions> f38303b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c  reason: collision with root package name */
    private static OpenDeviceOptions f38304c = new OpenDeviceOptions();

    public OpenDeviceClientImpl(Context context) {
        super(context, f38303b, f38304c, (AbstractClientBuilder) f38302a);
        super.setKitSdkVersion(61200300);
    }

    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString((IMessageEntity) null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 61200300)));
    }
}
