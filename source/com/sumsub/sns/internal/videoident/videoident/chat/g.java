package com.sumsub.sns.internal.videoident.videoident.chat;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import tvi.webrtc.VideoFrame;
import tvi.webrtc.VideoSink;

public final class g implements VideoSink {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f37074a;

    /* renamed from: b  reason: collision with root package name */
    public l<? super Float, Unit> f37075b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37076c;

    @d(c = "com.sumsub.sns.internal.videoident.videoident.chat.VideoFrameScaleCaptureController$onFrame$1$1", f = "SNSVideoChatController.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f37077a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f37078b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f37079c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, float f11, c<? super a> cVar) {
            super(2, cVar);
            this.f37078b = gVar;
            this.f37079c = f11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f37078b, this.f37079c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f37077a == 0) {
                k.b(obj);
                this.f37078b.a().invoke(kotlin.coroutines.jvm.internal.a.b(this.f37079c));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public g(h0 h0Var, l<? super Float, Unit> lVar) {
        this.f37074a = h0Var;
        this.f37075b = lVar;
    }

    public final l<Float, Unit> a() {
        return this.f37075b;
    }

    public final h0 b() {
        return this.f37074a;
    }

    public final boolean c() {
        return this.f37076c;
    }

    public void onFrame(VideoFrame videoFrame) {
        if (!this.f37076c) {
            if (videoFrame != null) {
                videoFrame.retain();
            }
            if (videoFrame != null) {
                VideoFrame.Buffer buffer = videoFrame.getBuffer();
                n1 unused = i.d(this.f37074a, (CoroutineContext) null, (CoroutineStart) null, new a(this, ((float) buffer.getWidth()) / ((float) buffer.getHeight()), (c<? super a>) null), 3, (Object) null);
            }
            this.f37076c = true;
            if (videoFrame != null) {
                videoFrame.release();
            }
        }
    }

    public final void a(l<? super Float, Unit> lVar) {
        this.f37075b = lVar;
    }

    public final void a(boolean z11) {
        this.f37076c = z11;
    }
}
