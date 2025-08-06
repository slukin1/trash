package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zacd<T> implements OnCompleteListener<T> {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey<?> zac;
    private final long zad;
    private final long zae;

    @VisibleForTesting
    public zacd(GoogleApiManager googleApiManager, int i11, ApiKey<?> apiKey, long j11, long j12, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i11;
        this.zac = apiKey;
        this.zad = j11;
        this.zae = j12;
    }

    public static <T> zacd<T> zaa(GoogleApiManager googleApiManager, int i11, ApiKey<?> apiKey) {
        boolean z11;
        if (!googleApiManager.zaF()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z11 = true;
        } else if (!config.getMethodInvocationTelemetryEnabled()) {
            return null;
        } else {
            z11 = config.getMethodTimingTelemetryEnabled();
            zabq zak = googleApiManager.zak(apiKey);
            if (zak != null) {
                if (!(zak.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab2 = zab(zak, baseGmsClient, i11);
                    if (zab2 == null) {
                        return null;
                    }
                    zak.zaq();
                    z11 = zab2.getMethodTimingTelemetryEnabled();
                }
            }
        }
        return new zacd(googleApiManager, i11, apiKey, z11 ? System.currentTimeMillis() : 0, z11 ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration zab(zabq<?> zabq, BaseGmsClient<?> baseGmsClient, int i11) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i11) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i11))) || zabq.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void onComplete(Task<T> task) {
        zabq zak;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long j11;
        long j12;
        int i16;
        if (this.zaa.zaF()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zak = this.zaa.zak(this.zac)) != null && (zak.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                boolean z11 = true;
                int i17 = 0;
                boolean z12 = this.zad > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    boolean methodTimingTelemetryEnabled = z12 & config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i13 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab2 = zab(zak, baseGmsClient, this.zab);
                        if (zab2 != null) {
                            if (!zab2.getMethodTimingTelemetryEnabled() || this.zad <= 0) {
                                z11 = false;
                            }
                            maxMethodInvocationsInBatch = zab2.getMaxMethodInvocationsLogged();
                            methodTimingTelemetryEnabled = z11;
                        } else {
                            return;
                        }
                    }
                    i12 = batchPeriodMillis;
                    i11 = maxMethodInvocationsInBatch;
                } else {
                    i13 = 0;
                    i11 = 100;
                    i12 = 5000;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    i14 = 0;
                } else {
                    if (task.isCanceled()) {
                        i17 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult == null) {
                                i16 = -1;
                            } else {
                                i16 = connectionResult.getErrorCode();
                            }
                            i14 = i16;
                            i17 = statusCode;
                        } else {
                            i17 = 101;
                        }
                    }
                    i14 = -1;
                }
                if (z12) {
                    long j13 = this.zad;
                    long currentTimeMillis = System.currentTimeMillis();
                    i15 = (int) (SystemClock.elapsedRealtime() - this.zae);
                    j12 = j13;
                    j11 = currentTimeMillis;
                } else {
                    j12 = 0;
                    j11 = 0;
                    i15 = -1;
                }
                googleApiManager.zay(new MethodInvocation(this.zab, i17, i14, j12, j11, (String) null, (String) null, gCoreServiceId, i15), i13, (long) i12, i11);
            }
        }
    }
}
