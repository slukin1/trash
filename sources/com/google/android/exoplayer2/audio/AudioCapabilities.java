package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final AudioCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    public AudioCapabilities(int[] iArr, int i11) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.supportedEncodings = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i11;
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() {
        if (Util.SDK_INT >= 17) {
            String str = Util.MANUFACTURER;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static AudioCapabilities getCapabilities(Context context) {
        return getCapabilities(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public static Uri getExternalSurroundSoundGlobalSettingUri() {
        if (deviceMaySetExternalSurroundSoundGlobalSetting()) {
            return Settings.Global.getUriFor(EXTERNAL_SURROUND_SOUND_KEY);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (!Arrays.equals(this.supportedEncodings, audioCapabilities.supportedEncodings) || this.maxChannelCount != audioCapabilities.maxChannelCount) {
            return false;
        }
        return true;
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public int hashCode() {
        return this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
    }

    public boolean supportsEncoding(int i11) {
        return Arrays.binarySearch(this.supportedEncodings, i11) >= 0;
    }

    public String toString() {
        int i11 = this.maxChannelCount;
        String arrays = Arrays.toString(this.supportedEncodings);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb2.append("AudioCapabilities[maxChannelCount=");
        sb2.append(i11);
        sb2.append(", supportedEncodings=");
        sb2.append(arrays);
        sb2.append("]");
        return sb2.toString();
    }

    @SuppressLint({"InlinedApi"})
    public static AudioCapabilities getCapabilities(Context context, Intent intent) {
        if (deviceMaySetExternalSurroundSoundGlobalSetting() && Settings.Global.getInt(context.getContentResolver(), EXTERNAL_SURROUND_SOUND_KEY, 0) == 1) {
            return EXTERNAL_SURROUND_SOUND_CAPABILITIES;
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }
}
