package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;

public interface IPurchaseVerificationHandler {
    void init(IActivityHandler iActivityHandler, boolean z11, IActivityPackageSender iActivityPackageSender);

    void pauseSending();

    void resumeSending();

    void sendPurchaseVerificationPackage(ActivityPackage activityPackage);

    void teardown();
}
