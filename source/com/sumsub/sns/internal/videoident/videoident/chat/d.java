package com.sumsub.sns.internal.videoident.videoident.chat;

import android.os.Handler;
import android.os.HandlerThread;
import com.sumsub.sns.internal.core.SNSDebugConstants;
import com.sumsub.sns.internal.core.common.w0;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.twilio.video.RemoteAudioTrack;
import com.twilio.video.RemoteAudioTrackPublication;
import com.twilio.video.RemoteDataTrack;
import com.twilio.video.RemoteDataTrackPublication;
import com.twilio.video.RemoteParticipant;
import com.twilio.video.RemoteVideoTrack;
import com.twilio.video.RemoteVideoTrackPublication;
import com.twilio.video.TwilioException;
import d10.p;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import tvi.webrtc.VideoSink;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f37052a = i0.a(v0.c());

    /* renamed from: b  reason: collision with root package name */
    public final Handler f37053b;

    /* renamed from: c  reason: collision with root package name */
    public final a1<String> f37054c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteVideoTrack f37055d;

    /* renamed from: e  reason: collision with root package name */
    public VideoSink f37056e;

    /* renamed from: f  reason: collision with root package name */
    public b1<b> f37057f;

    /* renamed from: g  reason: collision with root package name */
    public RemoteAudioTrack f37058g;

    /* renamed from: h  reason: collision with root package name */
    public final f1<String> f37059h;

    /* renamed from: i  reason: collision with root package name */
    public final j1<b> f37060i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37061j;

    /* renamed from: k  reason: collision with root package name */
    public final a f37062k;

    /* renamed from: l  reason: collision with root package name */
    public final b f37063l;

    public static final class a implements RemoteDataTrack.Listener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f37064a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatParticipantController$dataTrackListener$1$onMessage$1", f = "SNSVideoChatParticipantController.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.videoident.videoident.chat.d$a$a  reason: collision with other inner class name */
        public static final class C0504a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f37065a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f37066b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f37067c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0504a(d dVar, String str, c<? super C0504a> cVar) {
                super(2, cVar);
                this.f37066b = dVar;
                this.f37067c = str;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((C0504a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new C0504a(this.f37066b, this.f37067c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f37065a == 0) {
                    k.b(obj);
                    this.f37066b.f37054c.d(this.f37067c);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public a(d dVar) {
            this.f37064a = dVar;
        }

        public void onMessage(RemoteDataTrack remoteDataTrack, ByteBuffer byteBuffer) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onMessage: bytes " + byteBuffer, (Throwable) null, 4, (Object) null);
        }

        public void onMessage(RemoteDataTrack remoteDataTrack, String str) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "dataTrack message: " + w0.a(str, 15), (Throwable) null, 4, (Object) null);
            n1 unused = i.d(this.f37064a.f37052a, (CoroutineContext) null, (CoroutineStart) null, new C0504a(this.f37064a, str, (c<? super C0504a>) null), 3, (Object) null);
        }
    }

    public static final class b implements RemoteParticipant.Listener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f37068a;

        public b(d dVar) {
            this.f37068a = dVar;
        }

        public static final void a(RemoteDataTrackPublication remoteDataTrackPublication, d dVar) {
            RemoteDataTrack remoteDataTrack = remoteDataTrackPublication.getRemoteDataTrack();
            if (remoteDataTrack != null) {
                remoteDataTrack.setListener(dVar.f37062k);
            }
        }

        public void onAudioTrackDisabled(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackDisabled", (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackEnabled(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackEnabled", (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackPublished(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackPublished", (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackSubscribed(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication, RemoteAudioTrack remoteAudioTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackSubscribed: isAudioEnabled=" + this.f37068a.f(), (Throwable) null, 4, (Object) null);
            remoteAudioTrack.enablePlayback(!SNSDebugConstants.INSTANCE.getMuteVideoIdent() && this.f37068a.f());
            this.f37068a.f37058g = remoteAudioTrack;
        }

        public void onAudioTrackSubscriptionFailed(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackSubscriptionFailed:", twilioException);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackUnpublished(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackUnpublished", (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackUnsubscribed(RemoteParticipant remoteParticipant, RemoteAudioTrackPublication remoteAudioTrackPublication, RemoteAudioTrack remoteAudioTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackUnsubscribed", (Throwable) null, 4, (Object) null);
            this.f37068a.f37058g = null;
        }

        public void onDataTrackPublished(RemoteParticipant remoteParticipant, RemoteDataTrackPublication remoteDataTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackPublished:", (Throwable) null, 4, (Object) null);
        }

        public void onDataTrackSubscribed(RemoteParticipant remoteParticipant, RemoteDataTrackPublication remoteDataTrackPublication, RemoteDataTrack remoteDataTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackSubscribed: " + remoteDataTrack.getName(), (Throwable) null, 4, (Object) null);
            this.f37068a.f37053b.post(new k(remoteDataTrackPublication, this.f37068a));
            this.f37068a.f37057f.setValue(b.a((b) this.f37068a.f37057f.getValue(), true, false, false, true, 6, (Object) null));
        }

        public void onDataTrackSubscriptionFailed(RemoteParticipant remoteParticipant, RemoteDataTrackPublication remoteDataTrackPublication, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackSubscriptionFailed", twilioException);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
        }

        public void onDataTrackUnpublished(RemoteParticipant remoteParticipant, RemoteDataTrackPublication remoteDataTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackUnpublished", (Throwable) null, 4, (Object) null);
        }

        public void onDataTrackUnsubscribed(RemoteParticipant remoteParticipant, RemoteDataTrackPublication remoteDataTrackPublication, RemoteDataTrack remoteDataTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackUnsubscribed", (Throwable) null, 4, (Object) null);
            this.f37068a.f37057f.setValue(b.a((b) this.f37068a.f37057f.getValue(), false, false, false, false, 7, (Object) null));
        }

        public void onVideoTrackDisabled(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackDisabled", (Throwable) null, 4, (Object) null);
        }

        public void onVideoTrackEnabled(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackEnabled", (Throwable) null, 4, (Object) null);
        }

        public void onVideoTrackPublished(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackPublished", (Throwable) null, 4, (Object) null);
        }

        public void onVideoTrackSubscribed(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication, RemoteVideoTrack remoteVideoTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackSubscribed", (Throwable) null, 4, (Object) null);
            this.f37068a.f37055d = remoteVideoTrack;
            VideoSink d11 = this.f37068a.f37056e;
            if (d11 != null) {
                remoteVideoTrack.addSink(d11);
            }
            this.f37068a.f37057f.setValue(b.a((b) this.f37068a.f37057f.getValue(), true, false, true, false, 10, (Object) null));
        }

        public void onVideoTrackSubscriptionFailed(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackSubscriptionFailed", twilioException);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
        }

        public void onVideoTrackUnpublished(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackUnpublished", (Throwable) null, 4, (Object) null);
        }

        public void onVideoTrackUnsubscribed(RemoteParticipant remoteParticipant, RemoteVideoTrackPublication remoteVideoTrackPublication, RemoteVideoTrack remoteVideoTrack) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackUnsubscribed", (Throwable) null, 4, (Object) null);
            this.f37068a.f37057f.setValue(b.a((b) this.f37068a.f37057f.getValue(), false, false, false, false, 11, (Object) null));
            VideoSink d11 = this.f37068a.f37056e;
            if (d11 != null) {
                remoteVideoTrack.removeSink(d11);
            }
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("RemoteDataTrack");
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "init messageReceiveThread", (Throwable) null, 4, (Object) null);
        handlerThread.start();
        this.f37053b = new Handler(handlerThread.getLooper());
        a1<String> b11 = g1.b(0, 10, BufferOverflow.DROP_LATEST, 1, (Object) null);
        this.f37054c = b11;
        b1<b> a11 = k1.a(b.f37047e.a());
        this.f37057f = a11;
        this.f37059h = b11;
        this.f37060i = a11;
        this.f37061j = true;
        this.f37062k = new a(this);
        this.f37063l = new b(this);
    }

    public static /* synthetic */ void d() {
    }

    public final void g() {
        b();
        this.f37057f.setValue(b.f37047e.b());
    }

    public final void b() {
        RemoteVideoTrack remoteVideoTrack;
        VideoSink videoSink = this.f37056e;
        if (!(videoSink == null || (remoteVideoTrack = this.f37055d) == null)) {
            remoteVideoTrack.removeSink(videoSink);
        }
        this.f37055d = null;
        this.f37056e = null;
    }

    public final f1<String> c() {
        return this.f37059h;
    }

    public final j1<b> e() {
        return this.f37060i;
    }

    public final boolean f() {
        return this.f37061j;
    }

    public final void a(boolean z11) {
        this.f37061j = z11;
        RemoteAudioTrack remoteAudioTrack = this.f37058g;
        if (remoteAudioTrack != null) {
            remoteAudioTrack.enablePlayback(z11 && !SNSDebugConstants.INSTANCE.getMuteVideoIdent());
        }
    }

    public final void a() {
        b();
        i0.f(this.f37052a, (CancellationException) null, 1, (Object) null);
        this.f37053b.getLooper().quit();
    }

    public final void b(VideoSink videoSink) {
        this.f37056e = null;
        RemoteVideoTrack remoteVideoTrack = this.f37055d;
        if (remoteVideoTrack != null) {
            remoteVideoTrack.removeSink(videoSink);
        }
    }

    public final void a(RemoteParticipant remoteParticipant) {
        remoteParticipant.setListener(this.f37063l);
        boolean z11 = false;
        for (RemoteDataTrackPublication remoteDataTrackPublication : remoteParticipant.getRemoteDataTracks()) {
            if (remoteDataTrackPublication.isTrackSubscribed()) {
                z11 = true;
                this.f37053b.post(new j(remoteDataTrackPublication, this));
            }
        }
        b1<b> b1Var = this.f37057f;
        b1Var.setValue(b.a(b1Var.getValue(), true, false, false, z11, 6, (Object) null));
    }

    public static final void a(RemoteDataTrackPublication remoteDataTrackPublication, d dVar) {
        RemoteDataTrack remoteDataTrack = remoteDataTrackPublication.getRemoteDataTrack();
        if (remoteDataTrack != null) {
            remoteDataTrack.setListener(dVar.f37062k);
        }
    }

    public final void a(VideoSink videoSink) {
        if (this.f37056e == videoSink) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "bindRemoteView: already added ", (Throwable) null, 4, (Object) null);
            return;
        }
        this.f37056e = videoSink;
        RemoteVideoTrack remoteVideoTrack = this.f37055d;
        if (remoteVideoTrack != null) {
            remoteVideoTrack.addSink(videoSink);
        }
    }
}
