package bx;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.kurenai7968.volume_controller.VolumeBroadcastReceiver;
import io.flutter.plugin.common.EventChannel;

public final class a implements EventChannel.StreamHandler {

    /* renamed from: b  reason: collision with root package name */
    public final Context f23481b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23482c = "android.media.VOLUME_CHANGED_ACTION";

    /* renamed from: d  reason: collision with root package name */
    public VolumeBroadcastReceiver f23483d;

    /* renamed from: e  reason: collision with root package name */
    public AudioManager f23484e;

    /* renamed from: f  reason: collision with root package name */
    public EventChannel.EventSink f23485f;

    public a(Context context) {
        this.f23481b = context;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter(this.f23482c);
        Context context = this.f23481b;
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.f23483d;
        if (volumeBroadcastReceiver == null) {
            volumeBroadcastReceiver = null;
        }
        context.registerReceiver(volumeBroadcastReceiver, intentFilter);
    }

    public final double b() {
        AudioManager audioManager = this.f23484e;
        AudioManager audioManager2 = null;
        if (audioManager == null) {
            audioManager = null;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        AudioManager audioManager3 = this.f23484e;
        if (audioManager3 != null) {
            audioManager2 = audioManager3;
        }
        double streamMaxVolume = ((double) streamVolume) / ((double) audioManager2.getStreamMaxVolume(3));
        double d11 = (double) 10000;
        return Math.rint(streamMaxVolume * d11) / d11;
    }

    public void onCancel(Object obj) {
        Context context = this.f23481b;
        VolumeBroadcastReceiver volumeBroadcastReceiver = this.f23483d;
        if (volumeBroadcastReceiver == null) {
            volumeBroadcastReceiver = null;
        }
        context.unregisterReceiver(volumeBroadcastReceiver);
        this.f23485f = null;
    }

    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.f23485f = eventSink;
        this.f23484e = (AudioManager) this.f23481b.getSystemService("audio");
        this.f23483d = new VolumeBroadcastReceiver(this.f23485f);
        a();
        EventChannel.EventSink eventSink2 = this.f23485f;
        if (eventSink2 != null) {
            eventSink2.success(Double.valueOf(b()));
        }
    }
}
