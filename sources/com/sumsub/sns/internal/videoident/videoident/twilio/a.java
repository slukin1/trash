package com.sumsub.sns.internal.videoident.videoident.twilio;

import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.twilio.audioswitch.AudioDevice;
import com.twilio.audioswitch.AudioSwitch;
import d10.l;
import d10.p;
import java.util.List;
import kotlin.Unit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final AudioSwitch f37144a;

    /* renamed from: b  reason: collision with root package name */
    public AudioDevice f37145b;

    /* renamed from: c  reason: collision with root package name */
    public AudioDevice f37146c;

    /* renamed from: d  reason: collision with root package name */
    public p<? super List<? extends AudioDevice>, ? super AudioDevice, Unit> f37147d;

    /* renamed from: e  reason: collision with root package name */
    public l<? super Boolean, Unit> f37148e;

    /* renamed from: com.sumsub.sns.internal.videoident.videoident.twilio.a$a  reason: collision with other inner class name */
    public static final class C0506a implements p<List<? extends AudioDevice>, AudioDevice, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f37149a;

        public C0506a(a aVar) {
            this.f37149a = aVar;
        }

        public void a(List<? extends AudioDevice> list, AudioDevice audioDevice) {
            this.f37149a.a(list, audioDevice);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((List) obj, (AudioDevice) obj2);
            return Unit.f56620a;
        }
    }

    public a(AudioSwitch audioSwitch) {
        this.f37144a = audioSwitch;
    }

    public final void b() {
        if (this.f37147d == null) {
            C0506a aVar = new C0506a(this);
            this.f37144a.start(aVar);
            this.f37147d = aVar;
        }
    }

    public final void c() {
        try {
            this.f37144a.stop();
            this.f37144a.deactivate();
        } catch (Exception e11) {
            com.sumsub.sns.internal.log.a.f34862a.w(SNSVideoIdent.logTag, "error stopping/deactivating AudioSwitch", e11);
        }
        this.f37147d = null;
        this.f37148e = null;
    }

    public final l<Boolean, Unit> a() {
        return this.f37148e;
    }

    public final void a(l<? super Boolean, Unit> lVar) {
        this.f37148e = lVar;
    }

    public final void a(List<? extends AudioDevice> list, AudioDevice audioDevice) {
        boolean z11;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "selectedAudioDevice: " + audioDevice, (Throwable) null, 4, (Object) null);
        if (this.f37146c != null) {
            this.f37144a.deactivate();
        }
        AudioDevice audioDevice2 = this.f37146c;
        if (audioDevice2 == null && this.f37145b == null) {
            this.f37145b = audioDevice;
        }
        if (!(audioDevice2 == null || audioDevice == null)) {
            try {
                this.f37144a.activate();
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "selectedAudioDevice: activated=" + audioDevice, (Throwable) null, 4, (Object) null);
                l<? super Boolean, Unit> lVar = this.f37148e;
                if (lVar != null) {
                    if (!(audioDevice instanceof AudioDevice.BluetoothHeadset)) {
                        if (!(audioDevice instanceof AudioDevice.WiredHeadset)) {
                            z11 = false;
                            lVar.invoke(Boolean.valueOf(z11));
                        }
                    }
                    z11 = true;
                    lVar.invoke(Boolean.valueOf(z11));
                }
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.a.f34862a.w(SNSVideoIdent.logTag, "audioSwitch.activate", th2);
                return;
            }
        }
        this.f37146c = audioDevice;
    }
}
