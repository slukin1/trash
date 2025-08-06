package com.sumsub.sns.internal.videoident.videoident.chat;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import java.util.Iterator;

public final class f {
    public static final boolean c(AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 31) {
            return audioManager.isSpeakerphoneOn();
        }
        AudioDeviceInfo communicationDevice = audioManager.getCommunicationDevice();
        if (communicationDevice == null) {
            return false;
        }
        int type = communicationDevice.getType();
        a.a(SNSVideoIdent.logTag, "CommunicationDevice: type=" + type, (Throwable) null, 4, (Object) null);
        if (type == 24 || type == 2) {
            return true;
        }
        return false;
    }

    public static final boolean d(AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 23) {
            return audioManager.isWiredHeadsetOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
            if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                return true;
            }
        }
        return false;
    }

    public static final void b(AudioManager audioManager, boolean z11) {
        Object obj;
        boolean z12;
        if (Build.VERSION.SDK_INT < 31) {
            audioManager.setSpeakerphoneOn(z11);
        } else if (z11) {
            Iterator it2 = audioManager.getAvailableCommunicationDevices().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
                if (audioDeviceInfo.getType() == 24 || audioDeviceInfo.getType() == 2) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            AudioDeviceInfo audioDeviceInfo2 = (AudioDeviceInfo) obj;
            if (audioDeviceInfo2 != null) {
                a.a(SNSVideoIdent.logTag, "setCommunicationDevice: enabling speaker success=" + audioManager.setCommunicationDevice(audioDeviceInfo2), (Throwable) null, 4, (Object) null);
            }
        }
    }
}
