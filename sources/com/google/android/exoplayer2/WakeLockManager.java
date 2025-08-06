package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

final class WakeLockManager {
    private static final String TAG = "WakeLockManager";
    private static final String WAKE_LOCK_TAG = "ExoPlayer:WakeLockManager";
    private boolean enabled;
    private final PowerManager powerManager;
    private boolean stayAwake;
    private PowerManager.WakeLock wakeLock;

    public WakeLockManager(Context context) {
        this.powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    private void updateWakeLock() {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            if (!this.enabled || !this.stayAwake) {
                wakeLock2.release();
            } else {
                wakeLock2.acquire();
            }
        }
    }

    public void setEnabled(boolean z11) {
        if (z11 && this.wakeLock == null) {
            PowerManager powerManager2 = this.powerManager;
            if (powerManager2 == null) {
                Log.w(TAG, "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager2.newWakeLock(1, WAKE_LOCK_TAG);
            this.wakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.enabled = z11;
        updateWakeLock();
    }

    public void setStayAwake(boolean z11) {
        this.stayAwake = z11;
        updateWakeLock();
    }
}
