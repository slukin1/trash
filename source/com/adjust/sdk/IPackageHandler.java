package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.network.IActivityPackageSender;

public interface IPackageHandler {
    void addPackage(ActivityPackage activityPackage);

    void flush();

    void init(IActivityHandler iActivityHandler, Context context, boolean z11, IActivityPackageSender iActivityPackageSender);

    void pauseSending();

    void resumeSending();

    void sendFirstPackage();

    void teardown();
}
