package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;

public interface IAttributionHandler {
    void checkSdkClickResponse(SdkClickResponseData sdkClickResponseData);

    void checkSessionResponse(SessionResponseData sessionResponseData);

    void getAttribution();

    void init(IActivityHandler iActivityHandler, boolean z11, IActivityPackageSender iActivityPackageSender);

    void pauseSending();

    void resumeSending();

    void teardown();
}
