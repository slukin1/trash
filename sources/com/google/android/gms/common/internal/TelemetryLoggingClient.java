package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

@KeepForSdk
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    @KeepForSdk
    Task<Void> log(TelemetryData telemetryData);
}
