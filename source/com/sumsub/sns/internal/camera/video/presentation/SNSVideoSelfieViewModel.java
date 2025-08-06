package com.sumsub.sns.internal.camera.video.presentation;

import android.os.CountDownTimer;
import androidx.lifecycle.m0;
import com.luck.picture.lib.config.PictureMimeType;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.domain.f;
import d10.p;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class SNSVideoSelfieViewModel extends com.sumsub.sns.core.presentation.base.a<d> {
    public static final long A = 1000;
    public static final long B = 50;
    public static final long C = 1000;
    public static final String D = "EXTRA_ID_DOC_SET_TYPE";
    public static final String E = "EXTRA_TYPE";

    /* renamed from: x  reason: collision with root package name */
    public static final a f31757x = new a((r) null);

    /* renamed from: y  reason: collision with root package name */
    public static final long f31758y = 3000;

    /* renamed from: z  reason: collision with root package name */
    public static final long f31759z = 7600;

    /* renamed from: q  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.f f31760q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.k f31761r;

    /* renamed from: s  reason: collision with root package name */
    public final String f31762s;

    /* renamed from: t  reason: collision with root package name */
    public final String f31763t;

    /* renamed from: u  reason: collision with root package name */
    public CountDownTimer f31764u;

    /* renamed from: v  reason: collision with root package name */
    public String f31765v;

    /* renamed from: w  reason: collision with root package name */
    public File f31766w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/camera/video/presentation/SNSVideoSelfieViewModel$State;", "", "(Ljava/lang/String;I)V", "Countdown", "Recording", "Done", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum State {
        Countdown,
        Recording,
        Done
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static abstract class b implements a.j {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final c f31767a;

            public a(c cVar) {
                super((r) null);
                this.f31767a = cVar;
            }

            public final c a() {
                return this.f31767a;
            }

            public final c b() {
                return this.f31767a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && x.b(this.f31767a, ((a) obj).f31767a);
            }

            public int hashCode() {
                return this.f31767a.hashCode();
            }

            public String toString() {
                return "ResultObtained(result=" + this.f31767a + ')';
            }

            public final a a(c cVar) {
                return new a(cVar);
            }

            public static /* synthetic */ a a(a aVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = aVar.f31767a;
                }
                return aVar.a(cVar);
            }
        }

        /* renamed from: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$b$b  reason: collision with other inner class name */
        public static final class C0312b extends b {

            /* renamed from: a  reason: collision with root package name */
            public final File f31768a;

            public C0312b(File file) {
                super((r) null);
                this.f31768a = file;
            }

            public final File a() {
                return this.f31768a;
            }

            public final File b() {
                return this.f31768a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0312b) && x.b(this.f31768a, ((C0312b) obj).f31768a);
            }

            public int hashCode() {
                return this.f31768a.hashCode();
            }

            public String toString() {
                return "StartRecording(file=" + this.f31768a + ')';
            }

            public final C0312b a(File file) {
                return new C0312b(file);
            }

            public static /* synthetic */ C0312b a(C0312b bVar, File file, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    file = bVar.f31768a;
                }
                return bVar.a(file);
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f31769a = new c();

            public c() {
                super((r) null);
            }
        }

        public static abstract class d extends b {

            /* renamed from: a  reason: collision with root package name */
            public final State f31770a;

            public static final class a extends d {
                public a(State state) {
                    super(state, (r) null);
                }
            }

            /* renamed from: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$b$d$b  reason: collision with other inner class name */
            public static final class C0313b extends d {

                /* renamed from: b  reason: collision with root package name */
                public final long f31771b;

                public C0313b(State state, long j11) {
                    super(state, (r) null);
                    this.f31771b = j11;
                }

                public final long b() {
                    return this.f31771b;
                }
            }

            public /* synthetic */ d(State state, r rVar) {
                this(state);
            }

            public final State a() {
                return this.f31770a;
            }

            public d(State state) {
                super((r) null);
                this.f31770a = state;
            }
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final File f31772a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31773b;

        public c(File file, String str) {
            this.f31772a = file;
            this.f31773b = str;
        }

        public final File a() {
            return this.f31772a;
        }

        public final String b() {
            return this.f31773b;
        }

        public final File c() {
            return this.f31772a;
        }

        public final String d() {
            return this.f31773b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f31772a, cVar.f31772a) && x.b(this.f31773b, cVar.f31773b);
        }

        public int hashCode() {
            return (this.f31772a.hashCode() * 31) + this.f31773b.hashCode();
        }

        public String toString() {
            return "Result(file=" + this.f31772a + ", phrase=" + this.f31773b + ')';
        }

        public final c a(File file, String str) {
            return new c(file, str);
        }

        public static /* synthetic */ c a(c cVar, File file, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                file = cVar.f31772a;
            }
            if ((i11 & 2) != 0) {
                str = cVar.f31773b;
            }
            return cVar.a(file, str);
        }
    }

    public static final class d implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final e f31774a;

        /* renamed from: b  reason: collision with root package name */
        public final State f31775b;

        public d() {
            this((e) null, (State) null, 3, (r) null);
        }

        public final e a() {
            return this.f31774a;
        }

        public final State b() {
            return this.f31775b;
        }

        public final State c() {
            return this.f31775b;
        }

        public final e d() {
            return this.f31774a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f31774a, dVar.f31774a) && this.f31775b == dVar.f31775b;
        }

        public int hashCode() {
            int hashCode = this.f31774a.hashCode() * 31;
            State state = this.f31775b;
            return hashCode + (state == null ? 0 : state.hashCode());
        }

        public String toString() {
            return "ViewState(viewText=" + this.f31774a + ", state=" + this.f31775b + ')';
        }

        public d(e eVar, State state) {
            this.f31774a = eVar;
            this.f31775b = state;
        }

        public final d a(e eVar, State state) {
            return new d(eVar, state);
        }

        public static /* synthetic */ d a(d dVar, e eVar, State state, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                eVar = dVar.f31774a;
            }
            if ((i11 & 2) != 0) {
                state = dVar.f31775b;
            }
            return dVar.a(eVar, state);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(e eVar, State state, int i11, r rVar) {
            this((i11 & 1) != 0 ? new e((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, 63, (r) null) : eVar, (i11 & 2) != 0 ? null : state);
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f31776a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31777b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f31778c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f31779d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f31780e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f31781f;

        public e() {
            this((CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, 63, (r) null);
        }

        public final CharSequence a() {
            return this.f31776a;
        }

        public final CharSequence b() {
            return this.f31777b;
        }

        public final CharSequence c() {
            return this.f31778c;
        }

        public final CharSequence d() {
            return this.f31779d;
        }

        public final CharSequence e() {
            return this.f31780e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f31776a, eVar.f31776a) && x.b(this.f31777b, eVar.f31777b) && x.b(this.f31778c, eVar.f31778c) && x.b(this.f31779d, eVar.f31779d) && x.b(this.f31780e, eVar.f31780e) && x.b(this.f31781f, eVar.f31781f);
        }

        public final CharSequence f() {
            return this.f31781f;
        }

        public final CharSequence g() {
            return this.f31777b;
        }

        public final CharSequence h() {
            return this.f31778c;
        }

        public int hashCode() {
            CharSequence charSequence = this.f31776a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f31777b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f31778c;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f31779d;
            int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            CharSequence charSequence5 = this.f31780e;
            int hashCode5 = (hashCode4 + (charSequence5 == null ? 0 : charSequence5.hashCode())) * 31;
            CharSequence charSequence6 = this.f31781f;
            if (charSequence6 != null) {
                i11 = charSequence6.hashCode();
            }
            return hashCode5 + i11;
        }

        public final CharSequence i() {
            return this.f31779d;
        }

        public final CharSequence j() {
            return this.f31781f;
        }

        public final CharSequence k() {
            return this.f31780e;
        }

        public final CharSequence l() {
            return this.f31776a;
        }

        public String toString() {
            return "ViewText(message=" + this.f31776a + ", description1=" + this.f31777b + ", description2=" + this.f31778c + ", lackOfCameraMessage=" + this.f31779d + ", lackOfCameraPositive=" + this.f31780e + ", lackOfCameraNeutral=" + this.f31781f + ')';
        }

        public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
            this.f31776a = charSequence;
            this.f31777b = charSequence2;
            this.f31778c = charSequence3;
            this.f31779d = charSequence4;
            this.f31780e = charSequence5;
            this.f31781f = charSequence6;
        }

        public final e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
            return new e(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, charSequence6);
        }

        public static /* synthetic */ e a(e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = eVar.f31776a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = eVar.f31777b;
            }
            CharSequence charSequence7 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = eVar.f31778c;
            }
            CharSequence charSequence8 = charSequence3;
            if ((i11 & 8) != 0) {
                charSequence4 = eVar.f31779d;
            }
            CharSequence charSequence9 = charSequence4;
            if ((i11 & 16) != 0) {
                charSequence5 = eVar.f31780e;
            }
            CharSequence charSequence10 = charSequence5;
            if ((i11 & 32) != 0) {
                charSequence6 = eVar.f31781f;
            }
            return eVar.a(charSequence, charSequence7, charSequence8, charSequence9, charSequence10, charSequence6);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ e(java.lang.CharSequence r6, java.lang.CharSequence r7, java.lang.CharSequence r8, java.lang.CharSequence r9, java.lang.CharSequence r10, java.lang.CharSequence r11, int r12, kotlin.jvm.internal.r r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, kotlin.jvm.internal.r):void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel", f = "SNSVideoSelfieViewModel.kt", l = {67, 83}, m = "initPhase")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31782a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31783b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31784c;

        /* renamed from: d  reason: collision with root package name */
        public int f31785d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f31786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31787f;

        /* renamed from: g  reason: collision with root package name */
        public int f31788g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f31787f = sNSVideoSelfieViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31786e = obj;
            this.f31788g |= Integer.MIN_VALUE;
            return this.f31787f.e(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onCountdownFinished$1", f = "SNSVideoSelfieViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31789a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31790b;

        public g(kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((g) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            g gVar = new g(cVar);
            gVar.f31790b = obj;
            return gVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31789a == 0) {
                kotlin.k.b(obj);
                return d.a((d) this.f31790b, (e) null, State.Recording, 1, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onCountdownFinished$2", f = "SNSVideoSelfieViewModel.kt", l = {99}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31791a;

        /* renamed from: b  reason: collision with root package name */
        public int f31792b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31793c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f31793c = sNSVideoSelfieViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f31793c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            SNSVideoSelfieViewModel sNSVideoSelfieViewModel;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31792b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                String str = UUID.randomUUID().toString() + PictureMimeType.MP4;
                com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "File name is " + str, (Throwable) null, 4, (Object) null);
                SNSVideoSelfieViewModel sNSVideoSelfieViewModel2 = this.f31793c;
                com.sumsub.sns.internal.core.domain.f a11 = sNSVideoSelfieViewModel2.f31760q;
                f.a aVar = new f.a(str);
                this.f31791a = sNSVideoSelfieViewModel2;
                this.f31792b = 1;
                obj = a11.a(aVar, (kotlin.coroutines.c<? super File>) this);
                if (obj == d11) {
                    return d11;
                }
                sNSVideoSelfieViewModel = sNSVideoSelfieViewModel2;
            } else if (i11 == 1) {
                sNSVideoSelfieViewModel = (SNSVideoSelfieViewModel) this.f31791a;
                try {
                    kotlin.k.b(obj);
                } catch (Exception e11) {
                    com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "An error while creating new video selfie file...", e11);
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this.f31793c, (q) null, (Object) null, (Long) null, 7, (Object) null);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sNSVideoSelfieViewModel.f31766w = (File) obj;
            SNSVideoSelfieViewModel sNSVideoSelfieViewModel3 = this.f31793c;
            sNSVideoSelfieViewModel3.a((a.j) new b.C0312b(sNSVideoSelfieViewModel3.f31766w));
            return Unit.f56620a;
        }
    }

    public static final class i extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31794a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(SNSVideoSelfieViewModel sNSVideoSelfieViewModel) {
            super(SNSVideoSelfieViewModel.f31759z, 50);
            this.f31794a = sNSVideoSelfieViewModel;
        }

        public void onFinish() {
            this.f31794a.a((a.j) new b.d.a(State.Recording));
        }

        public void onTick(long j11) {
            this.f31794a.a((a.j) new b.d.C0313b(State.Recording, j11));
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel", f = "SNSVideoSelfieViewModel.kt", l = {53}, m = "onPrepare")
    public static final class j extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31795a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31796b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31797c;

        /* renamed from: d  reason: collision with root package name */
        public int f31798d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super j> cVar) {
            super(cVar);
            this.f31797c = sNSVideoSelfieViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31796b = obj;
            this.f31798d |= Integer.MIN_VALUE;
            return this.f31797c.d((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onPrepare$2", f = "SNSVideoSelfieViewModel.kt", l = {56, 57, 58, 59, 60}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31799a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31800b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31801c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31802d;

        /* renamed from: e  reason: collision with root package name */
        public Object f31803e;

        /* renamed from: f  reason: collision with root package name */
        public int f31804f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f31805g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31806h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f31806h = sNSVideoSelfieViewModel;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((k) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            k kVar = new k(this.f31806h, cVar);
            kVar.f31805g = obj;
            return kVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00f0 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0110 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0111  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0130 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0131  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f31804f
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 1
                r7 = 2
                if (r2 == 0) goto L_0x009f
                if (r2 == r6) goto L_0x0090
                if (r2 == r7) goto L_0x007e
                if (r2 == r5) goto L_0x0064
                if (r2 == r4) goto L_0x0045
                if (r2 != r3) goto L_0x003d
                java.lang.Object r1 = r0.f31803e
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r0.f31802d
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f31801c
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r0.f31800b
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                java.lang.Object r5 = r0.f31799a
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r5 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e) r5
                java.lang.Object r6 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r6 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r6
                kotlin.k.b(r19)
                r13 = r1
                r12 = r2
                r11 = r3
                r10 = r4
                r8 = r5
                r3 = r19
                goto L_0x0136
            L_0x003d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0045:
                java.lang.Object r2 = r0.f31802d
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r4 = r0.f31801c
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                java.lang.Object r5 = r0.f31800b
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.Object r6 = r0.f31799a
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r6 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e) r6
                java.lang.Object r8 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r8 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r8
                kotlin.k.b(r19)
                r9 = r8
                r8 = r6
                r6 = r5
                r5 = r4
                r4 = r19
                goto L_0x0116
            L_0x0064:
                java.lang.Object r2 = r0.f31801c
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r5 = r0.f31800b
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.Object r6 = r0.f31799a
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r6 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e) r6
                java.lang.Object r8 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r8 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r8
                kotlin.k.b(r19)
                r9 = r8
                r8 = r6
                r6 = r5
                r5 = r19
                goto L_0x00f8
            L_0x007e:
                java.lang.Object r2 = r0.f31800b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r6 = r0.f31799a
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r6 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e) r6
                java.lang.Object r8 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r8 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r8
                kotlin.k.b(r19)
                r9 = r19
                goto L_0x00da
            L_0x0090:
                java.lang.Object r2 = r0.f31799a
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r2 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e) r2
                java.lang.Object r6 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r6 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r6
                kotlin.k.b(r19)
                r8 = r6
                r6 = r19
                goto L_0x00c0
            L_0x009f:
                kotlin.k.b(r19)
                java.lang.Object r2 = r0.f31805g
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r2 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d) r2
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r8 = r2.d()
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r9 = r0.f31806h
                r0.f31805g = r2
                r0.f31799a = r8
                r0.f31804f = r6
                java.lang.String r6 = "sns_step_SELFIE_recording_header"
                java.lang.Object r6 = r9.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r6 != r1) goto L_0x00bb
                return r1
            L_0x00bb:
                r17 = r8
                r8 = r2
                r2 = r17
            L_0x00c0:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r9 = r0.f31806h
                r0.f31805g = r8
                r0.f31799a = r2
                r0.f31800b = r6
                r0.f31804f = r7
                java.lang.String r10 = "sns_step_SELFIE_recording_instructions"
                java.lang.Object r9 = r9.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r9 != r1) goto L_0x00d5
                return r1
            L_0x00d5:
                r17 = r6
                r6 = r2
                r2 = r17
            L_0x00da:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r10 = r0.f31806h
                r0.f31805g = r8
                r0.f31799a = r6
                r0.f31800b = r2
                r0.f31801c = r9
                r0.f31804f = r5
                java.lang.String r5 = "sns_alert_lackOfCameraPermissions"
                java.lang.Object r5 = r10.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r5 != r1) goto L_0x00f1
                return r1
            L_0x00f1:
                r17 = r6
                r6 = r2
                r2 = r9
                r9 = r8
                r8 = r17
            L_0x00f8:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r10 = r0.f31806h
                r0.f31805g = r9
                r0.f31799a = r8
                r0.f31800b = r6
                r0.f31801c = r2
                r0.f31802d = r5
                r0.f31804f = r4
                java.lang.String r4 = "sns_alert_action_ok"
                java.lang.Object r4 = r10.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r4 != r1) goto L_0x0111
                return r1
            L_0x0111:
                r17 = r5
                r5 = r2
                r2 = r17
            L_0x0116:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r10 = r0.f31806h
                r0.f31805g = r9
                r0.f31799a = r8
                r0.f31800b = r6
                r0.f31801c = r5
                r0.f31802d = r2
                r0.f31803e = r4
                r0.f31804f = r3
                java.lang.String r3 = "sns_alert_action_settings"
                java.lang.Object r3 = r10.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r3 != r1) goto L_0x0131
                return r1
            L_0x0131:
                r12 = r2
                r13 = r4
                r11 = r5
                r10 = r6
                r6 = r9
            L_0x0136:
                r14 = r3
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                r9 = 0
                r15 = 1
                r16 = 0
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$e r1 = com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e.a(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                r2 = 0
                com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$d r1 = com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d.a(r6, r1, r2, r7, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onRecordingFinished$1", f = "SNSVideoSelfieViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31807a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31808b;

        public l(kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((l) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            l lVar = new l(cVar);
            lVar.f31808b = obj;
            return lVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31807a == 0) {
                kotlin.k.b(obj);
                return d.a((d) this.f31808b, (e) null, State.Done, 1, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class m extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31809a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(SNSVideoSelfieViewModel sNSVideoSelfieViewModel) {
            super(1000, 1000);
            this.f31809a = sNSVideoSelfieViewModel;
        }

        public void onFinish() {
            this.f31809a.s();
        }

        public void onTick(long j11) {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onRecordingStarted$1", f = "SNSVideoSelfieViewModel.kt", l = {142}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31810a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f31811b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31812c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$onRecordingStarted$1$1$1", f = "SNSVideoSelfieViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31813a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31814b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f31815c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f31815c = str;
            }

            /* renamed from: a */
            public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
                return ((a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f31815c, cVar);
                aVar.f31814b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31813a == 0) {
                    kotlin.k.b(obj);
                    d dVar = (d) this.f31814b;
                    return d.a(dVar, e.a(dVar.d(), this.f31815c, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, 62, (Object) null), (State) null, 2, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(File file, SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f31811b = file;
            this.f31812c = sNSVideoSelfieViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n(this.f31811b, this.f31812c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31810a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "onRecordingStarted: " + this.f31811b.getName(), (Throwable) null, 4, (Object) null);
                this.f31810a = 1;
                if (DelayKt.b(1000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String c11 = this.f31812c.f31765v;
            if (c11 != null) {
                com.sumsub.sns.core.presentation.base.a.a(this.f31812c, false, new a(c11, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$startCountdown$1", f = "SNSVideoSelfieViewModel.kt", l = {127}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVideoSelfieViewModel f31817b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$startCountdown$1$1", f = "SNSVideoSelfieViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31818a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31819b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
                return ((a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f31819b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31818a == 0) {
                    kotlin.k.b(obj);
                    return d.a((d) this.f31819b, (e) null, State.Countdown, 1, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public static final class b extends CountDownTimer {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SNSVideoSelfieViewModel f31820a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(SNSVideoSelfieViewModel sNSVideoSelfieViewModel) {
                super(3000, 50);
                this.f31820a = sNSVideoSelfieViewModel;
            }

            public void onFinish() {
                this.f31820a.r();
            }

            public void onTick(long j11) {
                this.f31820a.a((a.j) new b.d.C0313b(State.Countdown, j11));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(SNSVideoSelfieViewModel sNSVideoSelfieViewModel, kotlin.coroutines.c<? super o> cVar) {
            super(2, cVar);
            this.f31817b = sNSVideoSelfieViewModel;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((o) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new o(this.f31817b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31816a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                if (this.f31817b.f31765v == null) {
                    SNSVideoSelfieViewModel sNSVideoSelfieViewModel = this.f31817b;
                    this.f31816a = 1;
                    if (sNSVideoSelfieViewModel.e(this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.sumsub.sns.core.presentation.base.a.a(this.f31817b, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            this.f31817b.p();
            this.f31817b.f31764u = new b(this.f31817b).start();
            return Unit.f56620a;
        }
    }

    public SNSVideoSelfieViewModel(com.sumsub.sns.internal.core.domain.f fVar, com.sumsub.sns.internal.core.domain.k kVar, String str, String str2, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f31760q = fVar;
        this.f31761r = kVar;
        this.f31762s = str;
        this.f31763t = str2;
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "Video Selfie is created", (Throwable) null, 4, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        p();
    }

    public final void p() {
        CountDownTimer countDownTimer = this.f31764u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f31764u = null;
    }

    /* renamed from: q */
    public d e() {
        return new d((e) null, (State) null, 3, (r) null);
    }

    public final void r() {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "Countdown is finished", (Throwable) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new g((kotlin.coroutines.c<? super g>) null), 1, (Object) null);
        p();
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h(this, (kotlin.coroutines.c<? super h>) null), 3, (Object) null);
        this.f31764u = new i(this).start();
    }

    public final void s() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("File is created. File - ");
        File file = this.f31766w;
        sb2.append(file != null ? file.getAbsolutePath() : null);
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, sb2.toString(), (Throwable) null, 4, (Object) null);
        File file2 = this.f31766w;
        if (file2 != null) {
            String str = this.f31765v;
            if (str == null) {
                str = "";
            }
            a((a.j) new b.a(new c(file2, str)));
        }
    }

    public final void t() {
        com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(com.sumsub.sns.internal.presentation.screen.preview.selfie.c.f36237b, "Recording is finished", (Throwable) null, 4, (Object) null);
        p();
        a((a.j) b.c.f31769a);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new l((kotlin.coroutines.c<? super l>) null), 1, (Object) null);
        this.f31764u = new m(this).start();
    }

    public final n1 u() {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new o(this, (kotlin.coroutines.c<? super o>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.j
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$j r0 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.j) r0
            int r1 = r0.f31798d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31798d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$j r0 = new com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$j
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f31796b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31798d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f31795a
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r0 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f31795a = r4
            r0.f31798d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$k r5 = new com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$k
            r1 = 0
            r5.<init>(r0, r1)
            r2 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r2, r5, r3, r1)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.d(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.f
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$f r0 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.f) r0
            int r1 = r0.f31788g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31788g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$f r0 = new com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel$f
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f31786e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31788g
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r6) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r1 = r0.f31785d
            java.lang.Object r2 = r0.f31784c
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r7 = r0.f31783b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.f31782a
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r0 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel) r0
            kotlin.k.b(r15)
            goto L_0x00de
        L_0x003d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0045:
            java.lang.Object r2 = r0.f31782a
            com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel r2 = (com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel) r2
            kotlin.k.b(r15)
            goto L_0x0063
        L_0x004d:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.core.domain.k r15 = r14.f31761r
            com.sumsub.sns.internal.core.domain.k$a r2 = new com.sumsub.sns.internal.core.domain.k$a
            r2.<init>()
            r0.f31782a = r14
            r0.f31788g = r6
            java.lang.Object r15 = r15.a(r2, r0)
            if (r15 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r2 = r14
        L_0x0063:
            boolean r7 = r15 instanceof com.sumsub.sns.internal.core.domain.model.a.b
            if (r7 == 0) goto L_0x006a
            com.sumsub.sns.internal.core.domain.model.a$b r15 = (com.sumsub.sns.internal.core.domain.model.a.b) r15
            goto L_0x006b
        L_0x006a:
            r15 = r4
        L_0x006b:
            if (r15 == 0) goto L_0x0074
            java.lang.Object r15 = r15.d()
            com.sumsub.sns.internal.core.data.model.e r15 = (com.sumsub.sns.internal.core.data.model.e) r15
            goto L_0x0075
        L_0x0074:
            r15 = r4
        L_0x0075:
            if (r15 == 0) goto L_0x0099
            kotlin.jvm.internal.d0 r7 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r8 = r2.f31763t
            r7[r5] = r8
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r8 = "selfiePhrase_%s"
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.util.Map r15 = r15.A()
            if (r15 == 0) goto L_0x0096
            java.lang.Object r15 = r15.get(r7)
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0097
        L_0x0096:
            r15 = r4
        L_0x0097:
            r2.f31765v = r15
        L_0x0099:
            java.lang.String r15 = r2.f31765v
            if (r15 == 0) goto L_0x00a6
            boolean r15 = kotlin.text.StringsKt__StringsJVMKt.z(r15)
            if (r15 == 0) goto L_0x00a4
            goto L_0x00a6
        L_0x00a4:
            r15 = r5
            goto L_0x00a7
        L_0x00a6:
            r15 = r6
        L_0x00a7:
            if (r15 == 0) goto L_0x0104
            kotlin.jvm.internal.d0 r7 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r8 = r2.f31762s
            r7[r5] = r8
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r8 = "sns_step_%s_recording_readAloudText"
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.String r10 = "defaults"
            r9[r5] = r10
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r6)
            java.lang.String r8 = java.lang.String.format(r8, r9)
            r0.f31782a = r2
            r0.f31783b = r7
            r0.f31784c = r8
            r0.f31785d = r15
            r0.f31788g = r3
            java.lang.Object r0 = r2.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
            if (r0 != r1) goto L_0x00da
            return r1
        L_0x00da:
            r1 = r15
            r15 = r0
            r0 = r2
            r2 = r8
        L_0x00de:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r15 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r15
            java.lang.String[] r3 = new java.lang.String[r3]
            r3[r5] = r7
            r3[r6] = r2
            java.lang.CharSequence r8 = com.sumsub.sns.internal.core.common.w.a(r15, r3)
            java.lang.String r15 = ";"
            java.lang.String[] r9 = new java.lang.String[]{r15}
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.util.List r15 = kotlin.text.StringsKt__StringsKt.L0(r8, r9, r10, r11, r12, r13)
            kotlin.random.Random$Default r2 = kotlin.random.Random.Default
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.t0(r15, r2)
            java.lang.String r15 = (java.lang.String) r15
            r0.f31765v = r15
            r2 = r0
            r15 = r1
        L_0x0104:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "initPhase: fromConfig="
            r0.append(r1)
            if (r15 != 0) goto L_0x0111
            r5 = r6
        L_0x0111:
            r0.append(r5)
            java.lang.String r15 = ", phrase="
            r0.append(r15)
            java.lang.String r15 = r2.f31765v
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r0 = 4
            java.lang.String r1 = "SumSubVideoSelfie"
            com.sumsub.sns.internal.presentation.screen.preview.selfie.c.a(r1, r15, r4, r0, r4)
            kotlin.Unit r15 = kotlin.Unit.f56620a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.video.presentation.SNSVideoSelfieViewModel.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final n1 a(File file) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new n(file, this, (kotlin.coroutines.c<? super n>) null), 3, (Object) null);
    }

    public void a(a.j jVar) {
        if (jVar instanceof b.d.C0313b) {
            super.a(jVar, false);
        } else {
            super.a(jVar);
        }
    }
}
