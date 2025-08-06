package com.engagelab.privates.api;

import android.content.Context;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.push.api.MTPushPrivatesApi;

public class MTPrivatesApi {
    public static void configDebugMode(Context context, boolean z11) {
        MTCorePrivatesApi.configDebugMode(context, z11);
    }

    public static void init(Context context) {
        MTPushPrivatesApi.init(context);
    }
}
