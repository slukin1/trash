package com.kurenai7968.volume_controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import io.flutter.plugin.common.EventChannel;

public final class VolumeBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final EventChannel.EventSink f25166a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f25167b;

    /* renamed from: c  reason: collision with root package name */
    public double f25168c;

    /* renamed from: d  reason: collision with root package name */
    public int f25169d;

    /* renamed from: e  reason: collision with root package name */
    public int f25170e;

    public VolumeBroadcastReceiver(EventChannel.EventSink eventSink) {
        this.f25166a = eventSink;
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.f25167b = audioManager;
        AudioManager audioManager2 = null;
        if (audioManager == null) {
            audioManager = null;
        }
        this.f25169d = audioManager.getStreamVolume(3);
        AudioManager audioManager3 = this.f25167b;
        if (audioManager3 != null) {
            audioManager2 = audioManager3;
        }
        int streamMaxVolume = audioManager2.getStreamMaxVolume(3);
        this.f25170e = streamMaxVolume;
        double d11 = ((double) this.f25169d) / ((double) streamMaxVolume);
        double d12 = (double) 10000;
        double rint = Math.rint(d11 * d12) / d12;
        this.f25168c = rint;
        EventChannel.EventSink eventSink = this.f25166a;
        if (eventSink != null) {
            eventSink.success(Double.valueOf(rint));
        }
    }
}
