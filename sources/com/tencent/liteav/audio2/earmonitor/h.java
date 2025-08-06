package com.tencent.liteav.audio2.earmonitor;

import android.content.Context;
import android.media.AudioManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.audio2.LiteavAudioTrack2;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.util.g;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class h extends SystemEarMonitoring {

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f21383a;

    /* renamed from: b  reason: collision with root package name */
    private a f21384b;

    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f21385a = false;

        /* renamed from: b  reason: collision with root package name */
        private final SystemEarMonitoring f21386b;

        public a(SystemEarMonitoring systemEarMonitoring) {
            this.f21386b = systemEarMonitoring;
        }

        public final void run() {
            LiteavAudioTrack2 liteavAudioTrack2 = new LiteavAudioTrack2();
            liteavAudioTrack2.startPlayout(3, 48000, 12, 3840);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3840);
            byte[] bArr = new byte[3840];
            Arrays.fill(bArr, (byte) 0);
            allocateDirect.put(bArr);
            while (!this.f21385a && !isInterrupted()) {
                try {
                    liteavAudioTrack2.write(allocateDirect, 0, 3840, false);
                } catch (Exception unused) {
                    this.f21386b.notifySystemEarMonitoringError(this.f21386b);
                }
            }
            liteavAudioTrack2.stopPlayout();
        }
    }

    public h(long j11, Context context) {
        super(j11);
        this.f21383a = (AudioManager) context.getSystemService("audio");
    }

    private boolean a() {
        try {
            String parameters = this.f21383a.getParameters("vivo_ktv_mic_type");
            if (parameters == null) {
                return false;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(parameters, ContainerUtils.KEY_VALUE_DELIMITER);
            if (stringTokenizer.countTokens() != 2 || !stringTokenizer.nextToken().equals("vivo_ktv_mic_type")) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                if (parseInt == 0 || parseInt == 1) {
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        } catch (Throwable th2) {
            Log.e("VivoSystemEarMonitoring", "getParameters failed. ".concat(String.valueOf(th2)), new Object[0]);
            return false;
        }
    }

    public final void initialize() {
        if (!a()) {
            Log.w("VivoSystemEarMonitoring", "initialize failed. current device dose not support system ear monitoring.", new Object[0]);
            notifySystemEarMonitoringInitialized(this, false);
            return;
        }
        try {
            this.f21383a.setParameters("vivo_ktv_mode=1");
            this.f21383a.setParameters("vivo_ktv_rec_source=0");
            this.f21383a.setParameters("vivo_ktv_play_source=0");
            notifySystemEarMonitoringInitialized(this, true);
        } catch (Throwable th2) {
            Log.d("VivoSystemEarMonitoring", "initialize failed. ".concat(String.valueOf(th2)), new Object[0]);
            notifySystemEarMonitoringInitialized(this, false);
        }
    }

    public final void setEarMonitoringVolume(int i11) {
        a("vivo_ktv_volume_mic=".concat(String.valueOf(Math.min(g.a(i11, 0, 100) / 6, 15))));
    }

    public final void startEarMonitoring() {
        if (this.f21384b == null) {
            a("vivo_ktv_play_source=1");
            a aVar = new a(this);
            this.f21384b = aVar;
            aVar.start();
        }
    }

    public final void stopEarMonitoring() {
        if (this.f21384b != null) {
            a("vivo_ktv_play_source=0");
            this.f21384b.f21385a = true;
            this.f21384b = null;
        }
    }

    public final void terminate() {
        a("vivo_ktv_mode=0");
        stopEarMonitoring();
    }

    private void a(String str) {
        try {
            this.f21383a.setParameters(str);
        } catch (Throwable th2) {
            Log.e("VivoSystemEarMonitoring", "setParameters failed. ".concat(String.valueOf(th2)), new Object[0]);
            notifySystemEarMonitoringError(this);
        }
    }
}
