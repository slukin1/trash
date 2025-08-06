package com.sensorsdata.analytics.android.sdk.core.mediator.protocol;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;

public interface SAModuleProtocol {
    String getModuleName();

    void install(Context context, SAConfigOptions sAConfigOptions);

    boolean isEnable();

    void setModuleState(boolean z11);
}
