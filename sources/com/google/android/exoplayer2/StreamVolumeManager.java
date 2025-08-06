package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

final class StreamVolumeManager {
    private static final String TAG = "StreamVolumeManager";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static final int VOLUME_FLAGS = 1;
    private final Context applicationContext;
    private final AudioManager audioManager;
    /* access modifiers changed from: private */
    public final Handler eventHandler;
    private final Listener listener;
    private boolean muted;
    private VolumeChangeReceiver receiver;
    private int streamType = 3;
    private int volume;

    public interface Listener {
        void onStreamTypeChanged(int i11);

        void onStreamVolumeChanged(int i11, boolean z11);
    }

    public final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.eventHandler.post(new u0(StreamVolumeManager.this));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener2) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        this.eventHandler = handler;
        this.listener = listener2;
        AudioManager audioManager2 = (AudioManager) Assertions.checkStateNotNull((AudioManager) applicationContext2.getSystemService("audio"));
        this.audioManager = audioManager2;
        this.volume = getVolumeFromManager(audioManager2, 3);
        this.muted = getMutedFromManager(audioManager2, this.streamType);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext2.registerReceiver(volumeChangeReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
            this.receiver = volumeChangeReceiver;
        } catch (RuntimeException e11) {
            Log.w(TAG, "Error registering stream volume receiver", e11);
        }
    }

    private static boolean getMutedFromManager(AudioManager audioManager2, int i11) {
        if (Util.SDK_INT >= 23) {
            return audioManager2.isStreamMute(i11);
        }
        return getVolumeFromManager(audioManager2, i11) == 0;
    }

    private static int getVolumeFromManager(AudioManager audioManager2, int i11) {
        try {
            return audioManager2.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Could not retrieve stream volume for stream type ");
            sb2.append(i11);
            Log.w(TAG, sb2.toString(), e11);
            return audioManager2.getStreamMaxVolume(i11);
        }
    }

    /* access modifiers changed from: private */
    public void updateVolumeAndNotifyIfChanged() {
        int volumeFromManager = getVolumeFromManager(this.audioManager, this.streamType);
        boolean mutedFromManager = getMutedFromManager(this.audioManager, this.streamType);
        if (this.volume != volumeFromManager || this.muted != mutedFromManager) {
            this.volume = volumeFromManager;
            this.muted = mutedFromManager;
            this.listener.onStreamVolumeChanged(volumeFromManager, mutedFromManager);
        }
    }

    public void decreaseVolume() {
        if (this.volume > getMinVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, -1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(this.streamType);
    }

    public int getMinVolume() {
        if (Util.SDK_INT >= 28) {
            return this.audioManager.getStreamMinVolume(this.streamType);
        }
        return 0;
    }

    public int getVolume() {
        return this.volume;
    }

    public void increaseVolume() {
        if (this.volume < getMaxVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, 1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public boolean isMuted() {
        return this.muted;
    }

    public void release() {
        VolumeChangeReceiver volumeChangeReceiver = this.receiver;
        if (volumeChangeReceiver != null) {
            try {
                this.applicationContext.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e11) {
                Log.w(TAG, "Error unregistering stream volume receiver", e11);
            }
            this.receiver = null;
        }
    }

    public void setMuted(boolean z11) {
        if (Util.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(this.streamType, z11 ? -100 : 100, 1);
        } else {
            this.audioManager.setStreamMute(this.streamType, z11);
        }
        updateVolumeAndNotifyIfChanged();
    }

    public void setStreamType(int i11) {
        if (this.streamType != i11) {
            this.streamType = i11;
            updateVolumeAndNotifyIfChanged();
            this.listener.onStreamTypeChanged(i11);
        }
    }

    public void setVolume(int i11) {
        if (i11 >= getMinVolume() && i11 <= getMaxVolume()) {
            this.audioManager.setStreamVolume(this.streamType, i11, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }
}
