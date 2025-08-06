package com.sumsub.sns.internal.videoident.videoident.chat;

import android.media.AudioManager;
import android.os.Build;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f37069a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.videoident.videoident.twilio.a f37070b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37071c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37072d;

    public static final class a extends Lambda implements l<Boolean, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f37073a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar) {
            super(1);
            this.f37073a = eVar;
        }

        public final void a(boolean z11) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioDeviceSwitch: externalDevice=" + z11, (Throwable) null, 4, (Object) null);
            AudioManager a11 = this.f37073a.f37069a;
            if (a11 != null) {
                f.b(a11, !z11);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.f56620a;
        }
    }

    public e(AudioManager audioManager, com.sumsub.sns.internal.videoident.videoident.twilio.a aVar) {
        this.f37069a = audioManager;
        this.f37070b = aVar;
    }

    public final void a() {
    }

    public final void b() {
        if (!this.f37072d) {
            AudioManager audioManager = this.f37069a;
            boolean z11 = false;
            this.f37071c = audioManager != null && f.c(audioManager);
            AudioManager audioManager2 = this.f37069a;
            if (audioManager2 != null) {
                audioManager2.setMode(3);
            }
            AudioManager audioManager3 = this.f37069a;
            if (audioManager3 != null) {
                if (f.d(audioManager3)) {
                    z11 = true;
                }
                f.b(audioManager3, !z11);
            }
            this.f37070b.b();
            this.f37070b.a(new a(this));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onParticipantConnected: speakerphone=");
            AudioManager audioManager4 = this.f37069a;
            sb2.append(audioManager4 != null ? Boolean.valueOf(f.c(audioManager4)) : null);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, sb2.toString(), (Throwable) null, 4, (Object) null);
            this.f37072d = true;
        }
    }

    public final void c() {
        AudioManager audioManager;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onParticipantDisconnected: wasSpeakerPhoneOn=" + this.f37071c + ", started=" + this.f37072d, (Throwable) null, 4, (Object) null);
        if (this.f37072d) {
            this.f37072d = false;
            AudioManager audioManager2 = this.f37069a;
            if (audioManager2 != null) {
                audioManager2.setMode(0);
            }
            AudioManager audioManager3 = this.f37069a;
            if (audioManager3 != null) {
                audioManager3.setSpeakerphoneOn(this.f37071c);
            }
            this.f37070b.c();
            if (Build.VERSION.SDK_INT >= 31 && (audioManager = this.f37069a) != null) {
                audioManager.clearCommunicationDevice();
            }
        }
    }
}
