package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
@Deprecated
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i11, String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(Context context, String str, String str2, String str3, int i11, List<String> list, boolean z11, long j11) {
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i11, String str2, String str3, String str4, int i12, List<String> list) {
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i11, String str2, String str3, String str4, int i12, List<String> list, long j11) {
    }

    @KeepForSdk
    public void registerReleaseEvent(Context context, Intent intent) {
    }
}
