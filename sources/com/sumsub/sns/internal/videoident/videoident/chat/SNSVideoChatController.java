package com.sumsub.sns.internal.videoident.videoident.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.internal.core.SNSDebugConstants;
import com.sumsub.sns.internal.core.common.x;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.chat.FocusStatus;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.sumsub.sns.internal.videoident.videoident.twilio.CameraCapturerCompat;
import com.twilio.audioswitch.AudioSwitch;
import com.twilio.video.ConnectOptions;
import com.twilio.video.DataTrackPublication;
import com.twilio.video.H264Codec;
import com.twilio.video.LocalAudioTrack;
import com.twilio.video.LocalAudioTrackPublication;
import com.twilio.video.LocalDataTrack;
import com.twilio.video.LocalDataTrackPublication;
import com.twilio.video.LocalParticipant;
import com.twilio.video.LocalVideoTrack;
import com.twilio.video.LocalVideoTrackPublication;
import com.twilio.video.RemoteParticipant;
import com.twilio.video.Room;
import com.twilio.video.TwilioException;
import com.twilio.video.Video;
import com.twilio.video.VideoCodec;
import com.twilio.video.VideoDimensions;
import com.twilio.video.VideoFormat;
import com.twilio.video.VideoView;
import com.twilio.video.Vp8Codec;
import d10.l;
import d10.p;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import tvi.webrtc.VideoCodecInfo;
import tvi.webrtc.VideoProcessor;
import tvi.webrtc.VideoSink;
import tvi.webrtc.VideoSource;

public final class SNSVideoChatController {

    /* renamed from: a  reason: collision with root package name */
    public e f36984a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f36985b;

    /* renamed from: c  reason: collision with root package name */
    public long f36986c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36987d;

    /* renamed from: e  reason: collision with root package name */
    public kotlinx.coroutines.flow.d<Long> f36988e = kotlinx.coroutines.flow.f.F(new e(this, (kotlin.coroutines.c<? super e>) null));

    /* renamed from: f  reason: collision with root package name */
    public final h0 f36989f;

    /* renamed from: g  reason: collision with root package name */
    public g f36990g;

    /* renamed from: h  reason: collision with root package name */
    public final d f36991h;

    /* renamed from: i  reason: collision with root package name */
    public LocalDataTrack f36992i;

    /* renamed from: j  reason: collision with root package name */
    public LocalAudioTrack f36993j;

    /* renamed from: k  reason: collision with root package name */
    public LocalVideoTrack f36994k;

    /* renamed from: l  reason: collision with root package name */
    public a f36995l;

    /* renamed from: m  reason: collision with root package name */
    public LocalParticipant f36996m;

    /* renamed from: n  reason: collision with root package name */
    public Room f36997n;

    /* renamed from: o  reason: collision with root package name */
    public final b1<SNSVideoChatState> f36998o;

    /* renamed from: p  reason: collision with root package name */
    public final a1<String> f36999p;

    /* renamed from: q  reason: collision with root package name */
    public l<? super Long, Unit> f37000q;

    /* renamed from: r  reason: collision with root package name */
    public final kotlinx.coroutines.flow.d<String> f37001r;

    /* renamed from: s  reason: collision with root package name */
    public d10.a<Unit> f37002s;

    /* renamed from: t  reason: collision with root package name */
    public l<? super Bitmap, Unit> f37003t;

    /* renamed from: u  reason: collision with root package name */
    public d10.a<Unit> f37004u;

    /* renamed from: v  reason: collision with root package name */
    public final a f37005v;

    /* renamed from: w  reason: collision with root package name */
    public final f f37006w;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatController$CameraId;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FRONT", "BACK", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum CameraId {
        FRONT("FRONT"),
        BACK("BACK");
        
        private final String value;

        private CameraId(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static final class a implements LocalParticipant.Listener {
        public void onAudioTrackPublicationFailed(LocalParticipant localParticipant, LocalAudioTrack localAudioTrack, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onAudioTrackPublicationFailed: " + localAudioTrack + ", e=" + com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
        }

        public void onAudioTrackPublished(LocalParticipant localParticipant, LocalAudioTrackPublication localAudioTrackPublication) {
        }

        public void onDataTrackPublicationFailed(LocalParticipant localParticipant, LocalDataTrack localDataTrack, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDataTrackPublicationFailed: " + localDataTrack + ", e=" + com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
        }

        public void onDataTrackPublished(LocalParticipant localParticipant, LocalDataTrackPublication localDataTrackPublication) {
        }

        public void onVideoTrackPublicationFailed(LocalParticipant localParticipant, LocalVideoTrack localVideoTrack, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onVideoTrackPublicationFailed: " + localVideoTrack + ", e=" + com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
            if (twilioException.getCode() == 53404) {
                com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).w(com.sumsub.sns.internal.videoident.videoident.a.f36980b, "Video codec NOT supported", new SNSException.Unknown(twilioException));
            }
        }

        public void onVideoTrackPublished(LocalParticipant localParticipant, LocalVideoTrackPublication localVideoTrackPublication) {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$participantController$1$1", f = "SNSVideoChatController.kt", l = {170}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f37007a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f37008b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37009c;

        public static final class a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SNSVideoChatController f37010a;

            public a(SNSVideoChatController sNSVideoChatController) {
                this.f37010a = sNSVideoChatController;
            }

            /* renamed from: a */
            public final Object emit(b bVar, kotlin.coroutines.c<? super Unit> cVar) {
                this.f37010a.a(bVar);
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f37008b = dVar;
            this.f37009c = sNSVideoChatController;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f37008b, this.f37009c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f37007a;
            if (i11 == 0) {
                k.b(obj);
                j1<b> e11 = this.f37008b.e();
                a aVar = new a(this.f37009c);
                this.f37007a = 1;
                if (e11.collect(aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                k.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public static final class c extends Lambda implements l<VideoCodecInfo, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f37011a = new c();

        public c() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(VideoCodecInfo videoCodecInfo) {
            return videoCodecInfo.name;
        }
    }

    public static final class d extends Lambda implements l<VideoCodecInfo, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f37012a = new d();

        public d() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(VideoCodecInfo videoCodecInfo) {
            return videoCodecInfo.name;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$recordTimerFlow$1", f = "SNSVideoChatController.kt", l = {155, 158, 160}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<kotlinx.coroutines.flow.e<? super Long>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public long f37013a;

        /* renamed from: b  reason: collision with root package name */
        public int f37014b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f37015c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37016d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f37016d = sNSVideoChatController;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super Long> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f37016d, cVar);
            eVar.f37015c = obj;
            return eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0080 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r10.f37014b
                r2 = 1
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x0031
                if (r1 == r6) goto L_0x0027
                if (r1 == r5) goto L_0x001c
                if (r1 != r4) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001c:
                long r6 = r10.f37013a
                java.lang.Object r1 = r10.f37015c
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r11)
                r11 = r10
                goto L_0x0069
            L_0x0027:
                long r6 = r10.f37013a
                java.lang.Object r1 = r10.f37015c
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r11)
                goto L_0x004d
            L_0x0031:
                kotlin.k.b(r11)
                java.lang.Object r11 = r10.f37015c
                kotlinx.coroutines.flow.e r11 = (kotlinx.coroutines.flow.e) r11
                r7 = 0
                java.lang.Long r1 = kotlin.coroutines.jvm.internal.a.d(r7)
                r10.f37015c = r11
                r10.f37013a = r7
                r10.f37014b = r6
                java.lang.Object r1 = r11.emit(r1, r10)
                if (r1 != r0) goto L_0x004b
                return r0
            L_0x004b:
                r1 = r11
                r6 = r7
            L_0x004d:
                r11 = r10
            L_0x004e:
                com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController r8 = r11.f37016d
                boolean r8 = r8.f36987d
                if (r8 == 0) goto L_0x0081
                java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
                long r8 = r8.toMillis(r2)
                r11.f37015c = r1
                r11.f37013a = r6
                r11.f37014b = r5
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r8, r11)
                if (r8 != r0) goto L_0x0069
                return r0
            L_0x0069:
                java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
                long r8 = r8.toMillis(r2)
                long r6 = r6 + r8
                java.lang.Long r8 = kotlin.coroutines.jvm.internal.a.d(r6)
                r11.f37015c = r1
                r11.f37013a = r6
                r11.f37014b = r4
                java.lang.Object r8 = r1.emit(r8, r11)
                if (r8 != r0) goto L_0x004e
                return r0
            L_0x0081:
                kotlin.Unit r11 = kotlin.Unit.f56620a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f implements Room.Listener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37017a;

        public f(SNSVideoChatController sNSVideoChatController) {
            this.f37017a = sNSVideoChatController;
        }

        public final void a() {
            e a11 = this.f37017a.f36984a;
            if (a11 != null) {
                a11.c();
            }
            this.f37017a.f36998o.setValue(SNSVideoChatState.e.f37041a);
            this.f37017a.f36991h.g();
            this.f37017a.s();
        }

        public void onConnectFailure(Room room, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onConnectFailure: " + room + ", thread=" + Thread.currentThread(), twilioException);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
            this.f37017a.f36998o.setValue(new SNSVideoChatState.c((Throwable) null, 1, (r) null));
            this.f37017a.a();
        }

        public void onConnected(Room room) {
            LocalDataTrack dataTrack;
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onConnected " + room, (Throwable) null, 4, (Object) null);
            SNSVideoChatController sNSVideoChatController = this.f37017a;
            LocalParticipant localParticipant = room.getLocalParticipant();
            if (localParticipant != null) {
                localParticipant.setListener(this.f37017a.f37005v);
            } else {
                localParticipant = null;
            }
            sNSVideoChatController.f36996m = localParticipant;
            this.f37017a.f36998o.setValue(new SNSVideoChatState.a(false, 1, (r) null));
            RemoteParticipant remoteParticipant = (RemoteParticipant) CollectionsKt___CollectionsKt.c0(room.getRemoteParticipants());
            if (remoteParticipant != null) {
                SNSVideoChatController sNSVideoChatController2 = this.f37017a;
                e a11 = sNSVideoChatController2.f36984a;
                if (a11 != null) {
                    a11.b();
                }
                sNSVideoChatController2.f36991h.a(remoteParticipant);
                sNSVideoChatController2.f36998o.setValue(c.a(SNSVideoChatState.d.f37036e, sNSVideoChatController2.f36991h.e().getValue()));
                sNSVideoChatController2.r();
            }
            LocalParticipant localParticipant2 = room.getLocalParticipant();
            if (localParticipant2 != null) {
                SNSVideoChatController sNSVideoChatController3 = this.f37017a;
                DataTrackPublication dataTrackPublication = (DataTrackPublication) CollectionsKt___CollectionsKt.c0(localParticipant2.getDataTracks());
                if (dataTrackPublication != null && (dataTrack = dataTrackPublication.getDataTrack()) != null && (dataTrack instanceof LocalDataTrack)) {
                    sNSVideoChatController3.a(localParticipant2, dataTrack);
                }
            }
        }

        public void onDisconnected(Room room, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onDisconnected", twilioException);
            if (twilioException != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
            }
            this.f37017a.f36996m = null;
            this.f37017a.f36997n = null;
            e a11 = this.f37017a.f36984a;
            if (a11 != null) {
                a11.c();
            }
            this.f37017a.s();
            if (this.f37017a.f36991h.e().getValue().f()) {
                this.f37017a.f36991h.g();
            }
            this.f37017a.f36998o.setValue(new SNSVideoChatState.c(twilioException));
        }

        public void onParticipantConnected(Room room, RemoteParticipant remoteParticipant) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onParticipantConnected", (Throwable) null, 4, (Object) null);
            e a11 = this.f37017a.f36984a;
            if (a11 != null) {
                a11.b();
            }
            if ((this.f37017a.f36998o.getValue() instanceof SNSVideoChatState.d) || this.f37017a.f36991h.e().getValue().f()) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onParticipantConnected: already have a participant!", (Throwable) null, 4, (Object) null);
                return;
            }
            this.f37017a.f36991h.a(remoteParticipant);
            this.f37017a.f36998o.setValue(c.a(SNSVideoChatState.d.f37036e, this.f37017a.f36991h.e().getValue()));
            this.f37017a.r();
        }

        public void onParticipantDisconnected(Room room, RemoteParticipant remoteParticipant) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onParticipantDisconnected", (Throwable) null, 4, (Object) null);
            a();
        }

        public void onReconnected(Room room) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onReconnected: " + room, (Throwable) null, 4, (Object) null);
            if (!room.getRemoteParticipants().isEmpty()) {
                this.f37017a.f36998o.setValue(SNSVideoChatState.d.a(c.a(SNSVideoChatState.d.f37036e, this.f37017a.f36991h.e().getValue()), false, false, false, true, 7, (Object) null));
            } else {
                this.f37017a.f36998o.setValue(new SNSVideoChatState.a(true));
            }
        }

        public void onReconnecting(Room room, TwilioException twilioException) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onReconnecting:", twilioException);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(twilioException), (Throwable) null, 4, (Object) null);
            this.f37017a.f36998o.setValue(new SNSVideoChatState.f(twilioException));
        }

        public void onRecordingStarted(Room room) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onRecordingStarted", (Throwable) null, 4, (Object) null);
        }

        public void onRecordingStopped(Room room) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onRecordingStopped", (Throwable) null, 4, (Object) null);
        }
    }

    public static final class g extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37018a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$startLocalVideoTracking$2$1", f = "SNSVideoChatController.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f37019a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SNSVideoChatController f37020b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f37020b = sNSVideoChatController;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f37020b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f37019a == 0) {
                    k.b(obj);
                    d10.a<Unit> e11 = this.f37020b.e();
                    if (e11 != null) {
                        e11.invoke();
                    }
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SNSVideoChatController sNSVideoChatController) {
            super(0);
            this.f37018a = sNSVideoChatController;
        }

        public final void a() {
            n1 unused = kotlinx.coroutines.i.d(this.f37018a.f36989f, (CoroutineContext) null, (CoroutineStart) null, new a(this.f37018a, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class h extends Lambda implements l<Bitmap, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37021a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$startLocalVideoTracking$3$1", f = "SNSVideoChatController.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f37022a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Bitmap f37023b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SNSVideoChatController f37024c;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$startLocalVideoTracking$3$1$1", f = "SNSVideoChatController.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$h$a$a  reason: collision with other inner class name */
            public static final class C0503a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f37025a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SNSVideoChatController f37026b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Bitmap f37027c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0503a(SNSVideoChatController sNSVideoChatController, Bitmap bitmap, kotlin.coroutines.c<? super C0503a> cVar) {
                    super(2, cVar);
                    this.f37026b = sNSVideoChatController;
                    this.f37027c = bitmap;
                }

                /* renamed from: a */
                public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                    return ((C0503a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new C0503a(this.f37026b, this.f37027c, cVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f37025a == 0) {
                        k.b(obj);
                        l<Bitmap, Unit> f11 = this.f37026b.f();
                        if (f11 != null) {
                            f11.invoke(this.f37027c);
                        }
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$startLocalVideoTracking$3$1$2", f = "SNSVideoChatController.kt", l = {}, m = "invokeSuspend")
            public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f37028a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SNSVideoChatController f37029b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public b(SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super b> cVar) {
                    super(2, cVar);
                    this.f37029b = sNSVideoChatController;
                }

                /* renamed from: a */
                public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                    return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new b(this.f37029b, cVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f37028a == 0) {
                        k.b(obj);
                        d10.a<Unit> g11 = this.f37029b.g();
                        if (g11 != null) {
                            g11.invoke();
                        }
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Bitmap bitmap, SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f37023b = bitmap;
                this.f37024c = sNSVideoChatController;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f37023b, this.f37024c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f37022a == 0) {
                    k.b(obj);
                    if (this.f37023b != null) {
                        n1 unused2 = kotlinx.coroutines.i.d(this.f37024c.f36989f, (CoroutineContext) null, (CoroutineStart) null, new C0503a(this.f37024c, this.f37023b, (kotlin.coroutines.c<? super C0503a>) null), 3, (Object) null);
                    } else {
                        n1 unused3 = kotlinx.coroutines.i.d(this.f37024c.f36989f, (CoroutineContext) null, (CoroutineStart) null, new b(this.f37024c, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
                    }
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(SNSVideoChatController sNSVideoChatController) {
            super(1);
            this.f37021a = sNSVideoChatController;
        }

        public final void a(Bitmap bitmap) {
            VideoSource videoSource;
            LocalVideoTrack c11 = this.f37021a.f36994k;
            if (!(c11 == null || (videoSource = c11.getVideoSource()) == null)) {
                videoSource.setVideoProcessor((VideoProcessor) null);
            }
            n1 unused = kotlinx.coroutines.i.d(this.f37021a.f36989f, (CoroutineContext) null, (CoroutineStart) null, new a(bitmap, this.f37021a, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Bitmap) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController$startRecordTimer$1", f = "SNSVideoChatController.kt", l = {578}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f37030a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVideoChatController f37031b;

        public static final class a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SNSVideoChatController f37032a;

            public a(SNSVideoChatController sNSVideoChatController) {
                this.f37032a = sNSVideoChatController;
            }

            public final Object a(long j11, kotlin.coroutines.c<? super Unit> cVar) {
                l<Long, Unit> i11 = this.f37032a.i();
                if (i11 != null) {
                    i11.invoke(kotlin.coroutines.jvm.internal.a.d(System.currentTimeMillis() - this.f37032a.f36986c));
                }
                return Unit.f56620a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, kotlin.coroutines.c cVar) {
                return a(((Number) obj).longValue(), cVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(SNSVideoChatController sNSVideoChatController, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f37031b = sNSVideoChatController;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f37031b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f37030a;
            if (i11 == 0) {
                k.b(obj);
                this.f37031b.f36987d = true;
                kotlinx.coroutines.flow.d e11 = this.f37031b.f36988e;
                a aVar = new a(this.f37031b);
                this.f37030a = 1;
                if (e11.collect(aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public SNSVideoChatController() {
        h0 a11 = i0.a(v0.c());
        this.f36989f = a11;
        d dVar = new d();
        n1 unused = kotlinx.coroutines.i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new b(dVar, this, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
        this.f36991h = dVar;
        this.f36998o = k1.a(new SNSVideoChatState.c((Throwable) null, 1, (r) null));
        a1<String> b11 = g1.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.f36999p = b11;
        this.f37001r = kotlinx.coroutines.flow.f.N(dVar.c(), b11);
        this.f37005v = new a();
        this.f37006w = new f(this);
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void n() {
    }

    public final VideoCodec a(VideoCodec videoCodec) {
        throw null;
    }

    public final j1<SNSVideoChatState> l() {
        return this.f36998o;
    }

    public final h0 m() {
        return this.f36989f;
    }

    public final void o() {
        VideoSource videoSource;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "makePhoto", (Throwable) null, 4, (Object) null);
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (!(localVideoTrack == null || (videoSource = localVideoTrack.getVideoSource()) == null)) {
            videoSource.setVideoProcessor(this.f36995l);
        }
        a aVar = this.f36995l;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void p() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "releaseLocalTracks", (Throwable) null, 4, (Object) null);
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (localVideoTrack != null) {
            localVideoTrack.getVideoSource().setVideoProcessor((VideoProcessor) null);
            localVideoTrack.release();
            this.f36994k = null;
        }
        LocalAudioTrack localAudioTrack = this.f36993j;
        if (localAudioTrack != null) {
            localAudioTrack.release();
            this.f36993j = null;
        }
        LocalDataTrack localDataTrack = this.f36992i;
        if (localDataTrack != null) {
            localDataTrack.release();
            this.f36992i = null;
        }
    }

    public final void q() {
        LocalParticipant localParticipant;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "releaseLocalVideoTrack", (Throwable) null, 4, (Object) null);
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (!(localVideoTrack == null || (localParticipant = this.f36996m) == null)) {
            localParticipant.unpublishTrack(localVideoTrack);
        }
        LocalVideoTrack localVideoTrack2 = this.f36994k;
        if (localVideoTrack2 != null) {
            localVideoTrack2.release();
        }
        this.f36994k = null;
    }

    public final void r() {
        if (this.f36985b != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "startRecordTimer: already started", (Throwable) null, 4, (Object) null);
            return;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "startRecordTimer", (Throwable) null, 4, (Object) null);
        this.f36986c = System.currentTimeMillis();
        this.f36985b = kotlinx.coroutines.i.d(this.f36989f, (CoroutineContext) null, (CoroutineStart) null, new i(this, (kotlin.coroutines.c<? super i>) null), 3, (Object) null);
    }

    public final void s() {
        this.f36987d = false;
        n1 n1Var = this.f36985b;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            this.f36985b = null;
        }
    }

    public final CameraId t() {
        CameraCapturerCompat videoCapturer;
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (localVideoTrack == null || (videoCapturer = localVideoTrack.getVideoCapturer()) == null) {
            return null;
        }
        CameraCapturerCompat cameraCapturerCompat = videoCapturer instanceof CameraCapturerCompat ? videoCapturer : null;
        if (cameraCapturerCompat == null) {
            return null;
        }
        try {
            CameraCapturerCompat.Source c11 = cameraCapturerCompat.c();
            if (c11 == null) {
                return null;
            }
            if (c11 == CameraCapturerCompat.Source.FRONT_CAMERA) {
                return CameraId.FRONT;
            }
            return CameraId.BACK;
        } catch (TwilioException e11) {
            com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA).e(SNSVideoIdent.logTag, "error switching camera", e11);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, com.sumsub.sns.internal.videoident.videoident.twilio.b.a(e11), (Throwable) null, 4, (Object) null);
            return null;
        }
    }

    public final void b(l<? super Long, Unit> lVar) {
        this.f37000q = lVar;
    }

    public final void c(VideoSink videoSink) {
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (localVideoTrack != null) {
            localVideoTrack.removeSink(videoSink);
        }
        LocalVideoTrack localVideoTrack2 = this.f36994k;
        if (localVideoTrack2 != null) {
            localVideoTrack2.enable(false);
        }
    }

    public final kotlinx.coroutines.flow.d<String> d() {
        return this.f37001r;
    }

    public final d10.a<Unit> e() {
        return this.f37002s;
    }

    public final l<Bitmap, Unit> f() {
        return this.f37003t;
    }

    public final d10.a<Unit> g() {
        return this.f37004u;
    }

    public final long h() {
        if (!this.f36987d) {
            return 0;
        }
        return RangesKt___RangesKt.e(System.currentTimeMillis() - this.f36986c, 0);
    }

    public final l<Long, Unit> i() {
        return this.f37000q;
    }

    public final Room.Listener j() {
        return this.f37006w;
    }

    public final void b(d10.a<Unit> aVar) {
        this.f37004u = aVar;
    }

    public final void d(VideoSink videoSink) {
        this.f36991h.b(videoSink);
    }

    public final void b() {
        this.f36984a = null;
        i0.f(this.f36989f, (CancellationException) null, 1, (Object) null);
        a();
        p();
        this.f36991h.a();
        g gVar = this.f36990g;
        if (gVar != null) {
            gVar.a(true);
        }
        this.f36990g = null;
        s();
        e eVar = this.f36984a;
        if (eVar != null) {
            eVar.a();
        }
        this.f36984a = null;
    }

    public final CameraId c() {
        CameraCapturerCompat videoCapturer;
        CameraCapturerCompat.Source a11;
        LocalVideoTrack localVideoTrack = this.f36994k;
        if (localVideoTrack == null || (videoCapturer = localVideoTrack.getVideoCapturer()) == null) {
            return null;
        }
        CameraCapturerCompat cameraCapturerCompat = videoCapturer instanceof CameraCapturerCompat ? videoCapturer : null;
        if (cameraCapturerCompat == null || (a11 = cameraCapturerCompat.a()) == null) {
            return null;
        }
        return c.b(a11);
    }

    public final void a(d10.a<Unit> aVar) {
        this.f37002s = aVar;
    }

    public final void a(l<? super Bitmap, Unit> lVar) {
        this.f37003t = lVar;
    }

    public final FocusStatus a(int i11) {
        FocusStatus focusStatus;
        boolean z11 = false;
        if (i11 == -3 || i11 == -2 || i11 == -1) {
            if (i11 != -1) {
                z11 = true;
            }
            focusStatus = new FocusStatus.b(z11);
        } else if (i11 != 1 && i11 != 2 && i11 != 3 && i11 != 4) {
            return FocusStatus.c.f36983a;
        } else {
            if (i11 != 1) {
                z11 = true;
            }
            focusStatus = new FocusStatus.a(z11);
        }
        return focusStatus;
    }

    public final void a(VideoView videoView) {
        if (this.f36994k == null) {
            Context applicationContext = videoView.getContext().getApplicationContext();
            this.f36984a = new e((AudioManager) applicationContext.getSystemService("audio"), new com.sumsub.sns.internal.videoident.videoident.twilio.a(new AudioSwitch(applicationContext, false, new i(this), (List) null, 10, (r) null)));
            if (this.f36992i == null) {
                this.f36992i = LocalDataTrack.create(applicationContext);
            }
            a(applicationContext);
            a((VideoSink) videoView);
            if (this.f36993j != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "startLocalMediaTracking: audio already started", (Throwable) null, 4, (Object) null);
            } else if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.RECORD_AUDIO") == 0) {
                LocalAudioTrack create = LocalAudioTrack.create(applicationContext, true);
                this.f36993j = create;
                if (create != null) {
                    create.enable(true ^ SNSDebugConstants.INSTANCE.getMuteVideoIdent());
                }
            }
        }
    }

    public final void b(VideoSink videoSink) {
        this.f36991h.a(videoSink);
    }

    public static final void a(SNSVideoChatController sNSVideoChatController, int i11) {
        sNSVideoChatController.a(sNSVideoChatController.a(i11));
    }

    public final void a(FocusStatus focusStatus) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleFocusStatusChange: " + focusStatus, (Throwable) null, 4, (Object) null);
        boolean z11 = focusStatus instanceof FocusStatus.a;
        LocalAudioTrack localAudioTrack = this.f36993j;
        if (localAudioTrack != null) {
            localAudioTrack.enable(z11);
        }
        this.f36991h.a(z11);
    }

    public final LocalVideoTrack a(Context context) {
        if (this.f36994k != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "startVideoTracking: video already started", (Throwable) null, 4, (Object) null);
            LocalVideoTrack localVideoTrack = this.f36994k;
            if (localVideoTrack != null) {
                return localVideoTrack;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        CameraCapturerCompat cameraCapturerCompat = new CameraCapturerCompat();
        boolean a11 = cameraCapturerCompat.a(context, CameraCapturerCompat.Source.FRONT_CAMERA);
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "startLocalVideoTracking: camera=" + cameraCapturerCompat.a(), (Throwable) null, 4, (Object) null);
        if (a11) {
            LocalVideoTrack create = LocalVideoTrack.create(context, true, cameraCapturerCompat, new VideoFormat(VideoDimensions.HD_1080P_VIDEO_DIMENSIONS, 24));
            if (create != null) {
                LocalParticipant localParticipant = this.f36996m;
                if (localParticipant != null) {
                    localParticipant.publishTrack(create);
                }
            } else {
                create = null;
            }
            this.f36994k = create;
        }
        if (this.f36994k == null) {
            com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), SNSVideoIdent.logTag, "startLocalVideoTracking: error creating local video track", (Throwable) null, 4, (Object) null);
        }
        a aVar = new a((VideoSink) null);
        this.f36995l = aVar;
        aVar.a((d10.a<Unit>) new g(this));
        a aVar2 = this.f36995l;
        if (aVar2 != null) {
            aVar2.a((l<? super Bitmap, Unit>) new h(this));
        }
        LocalVideoTrack localVideoTrack2 = this.f36994k;
        if (localVideoTrack2 != null) {
            return localVideoTrack2;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void a(VideoSink videoSink) {
        List sinks;
        LocalVideoTrack localVideoTrack = this.f36994k;
        boolean z11 = true;
        if (localVideoTrack != null) {
            localVideoTrack.enable(true);
        }
        LocalVideoTrack localVideoTrack2 = this.f36994k;
        if (localVideoTrack2 == null || (sinks = localVideoTrack2.getSinks()) == null || !sinks.contains(videoSink)) {
            z11 = false;
        }
        if (z11) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "bindLocalVideoView: already added", (Throwable) null, 4, (Object) null);
            return;
        }
        LocalVideoTrack localVideoTrack3 = this.f36994k;
        if (localVideoTrack3 != null) {
            localVideoTrack3.addSink(videoSink);
        }
    }

    public final void a(Context context, String str, String str2) {
        VideoCodec videoCodec;
        Map l11 = MapsKt__MapsKt.l(kotlin.l.a("vp8", new Vp8Codec()), kotlin.l.a("h264", new H264Codec()));
        com.sumsub.sns.internal.ff.a aVar = com.sumsub.sns.internal.ff.a.f34215a;
        String f11 = aVar.D().f();
        if (f11 == null) {
            f11 = aVar.D().b().c();
        }
        if (f11 != null) {
            kotlinx.serialization.json.a a11 = x.a(false, 1, (Object) null);
            kotlinx.serialization.modules.d a12 = a11.a();
            kotlin.reflect.p n11 = Reflection.n(h.class);
            MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
            String b11 = ((h) a11.c(kotlinx.serialization.h.d(a12, n11), f11)).b();
            if (b11 == null || (videoCodec = (VideoCodec) l11.get(b11)) == null) {
                videoCodec = new H264Codec();
            }
            ConnectOptions.Builder preferVideoCodecs = new ConnectOptions.Builder(str).roomName(str2).preferVideoCodecs(CollectionsKt__CollectionsJVMKt.e(a(videoCodec)));
            LocalAudioTrack localAudioTrack = this.f36993j;
            if (localAudioTrack != null) {
                preferVideoCodecs.audioTracks(CollectionsKt__CollectionsJVMKt.e(localAudioTrack));
            }
            LocalDataTrack localDataTrack = this.f36992i;
            if (localDataTrack != null) {
                preferVideoCodecs.dataTracks(CollectionsKt__CollectionsJVMKt.e(localDataTrack));
            }
            LocalVideoTrack localVideoTrack = this.f36994k;
            if (localVideoTrack != null) {
                preferVideoCodecs.videoTracks(CollectionsKt__CollectionsJVMKt.e(localVideoTrack));
            }
            ConnectOptions build = preferVideoCodecs.build();
            this.f36998o.setValue(SNSVideoChatState.b.f37034a);
            this.f36997n = Video.connect(context, build, this.f37006w);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connectToRoom: localDataTrack=");
            LocalDataTrack localDataTrack2 = this.f36992i;
            sb2.append(localDataTrack2 != null ? localDataTrack2.getName() : null);
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, sb2.toString(), (Throwable) null, 4, (Object) null);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void a(LocalParticipant localParticipant, LocalDataTrack localDataTrack) {
        if (localDataTrack != this.f36992i) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "switchDataTrack: switching to datatrack " + localDataTrack, (Throwable) null, 4, (Object) null);
            LocalDataTrack localDataTrack2 = this.f36992i;
            if (localDataTrack2 != null) {
                boolean unpublishTrack = localParticipant.unpublishTrack(localDataTrack2);
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "switchDataTrack: unpublished previous=" + unpublishTrack, (Throwable) null, 4, (Object) null);
                localDataTrack2.release();
            }
        }
        this.f36992i = localDataTrack;
    }

    public final void a() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "disconnect", (Throwable) null, 4, (Object) null);
        this.f36991h.g();
        Room room = this.f36997n;
        if (room != null) {
            room.disconnect();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r1 = (com.twilio.video.LocalDataTrackPublication) kotlin.collections.CollectionsKt___CollectionsKt.a0((r1 = r1.getLocalDataTracks()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r15) {
        /*
            r14 = this;
            com.twilio.video.LocalDataTrack r0 = r14.f36992i
            if (r0 == 0) goto L_0x0075
            com.twilio.video.LocalParticipant r1 = r14.f36996m
            r2 = 0
            if (r1 == 0) goto L_0x001c
            java.util.List r1 = r1.getLocalDataTracks()
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r1)
            com.twilio.video.LocalDataTrackPublication r1 = (com.twilio.video.LocalDataTrackPublication) r1
            if (r1 == 0) goto L_0x001c
            com.twilio.video.LocalDataTrack r1 = r1.getLocalDataTrack()
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            com.twilio.video.LocalDataTrack r3 = r14.f36992i
            boolean r3 = kotlin.jvm.internal.x.b(r3, r1)
            r4 = 4
            java.lang.String r5 = "SNSVideoIdent"
            if (r3 != 0) goto L_0x005e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "sendMessage: published dt="
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = ", local dt="
            r3.append(r1)
            com.twilio.video.LocalDataTrack r1 = r14.f36992i
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r5, r1, r2, r4, r2)
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            r3 = 1
            com.sumsub.sns.internal.log.LoggerType[] r3 = new com.sumsub.sns.internal.log.LoggerType[r3]
            com.sumsub.sns.internal.log.LoggerType r6 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r7 = 0
            r3[r7] = r6
            com.sumsub.log.logger.Logger r8 = r1.a((com.sumsub.sns.internal.log.LoggerType[]) r3)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "SNSVideoIdent"
            java.lang.String r10 = "local data track changed"
            com.sumsub.log.logger.a.e(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "sendMessage: "
            r1.append(r3)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r5, r1, r2, r4, r2)
            r0.send(r15)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController.a(java.lang.String):void");
    }

    public final void a(b bVar) {
        if ((this.f36998o.getValue() instanceof SNSVideoChatState.d) && bVar.f()) {
            this.f36998o.setValue(new SNSVideoChatState.d(bVar.e(), bVar.h(), bVar.g(), false, 8, (r) null));
        }
    }
}
