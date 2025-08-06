package com.sumsub.sns.internal.camera.photo.presentation.document;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Size;
import androidx.lifecycle.SavedStateHandle;
import com.luck.picture.lib.config.PictureMimeType;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.camera.c;
import com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult;
import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.domain.camera.CameraX;
import com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig;
import com.sumsub.sns.internal.ml.core.e;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.n1;

public final class SNSPhotoDocumentPickerViewModel extends com.sumsub.sns.internal.camera.b {
    public static final b A = new b((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] B;
    public static final long C = 2000;
    public static final String D = "key_collected_results";
    public static final double E = 0.2d;
    public static final String F = "sns_seamless_error_general";
    public static final String G = "sns_seamless_error_timeExceeded";
    public static final String H = "sns_seamless_error_notEnoughStorage";
    public static final String I = "sns_instructions_hint_turnOver";
    public static final String J = "sns_instructions_hint_allSet";
    public static final String K = "sns_autocapture_hint_targetAt";
    public static final String L = "sns_autocapture_hint_moveIn";
    public static final String M = "sns_autocapture_hint_moveOut";
    public static final String N = "sns_autocapture_hint_holdLikeThis";
    public static final String O = "sns_autocapture_hint_keepFocusing";
    public static final String P = "sns_autocapture_action_auto";
    public static final String Q = "sns_autocapture_action_manual";
    public boolean A0;
    public final com.sumsub.sns.internal.core.data.source.dynamic.b R;
    public final com.sumsub.sns.internal.ml.badphotos.a S;
    public final com.sumsub.sns.internal.ml.docdetector.b T;
    public final com.sumsub.sns.internal.ml.badphotos.c U;
    public final com.sumsub.sns.internal.ml.autocapture.a V;
    public final SeamlessDocaptureMobileConfig W;
    public boolean X;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a Y;
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public final kotlin.i f31493a0 = LazyKt__LazyJVMKt.a(new m(this));

    /* renamed from: b0  reason: collision with root package name */
    public com.sumsub.sns.internal.ff.core.a f31494b0 = com.sumsub.sns.internal.ff.a.f34215a.h();

    /* renamed from: c0  reason: collision with root package name */
    public final kotlin.i f31495c0 = LazyKt__LazyJVMKt.a(new n(this));

    /* renamed from: d0  reason: collision with root package name */
    public File f31496d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f31497e0;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f31498f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f31499g0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f31500h0;

    /* renamed from: i0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f31501i0;

    /* renamed from: j0  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f31502j0;

    /* renamed from: k0  reason: collision with root package name */
    public final kotlinx.coroutines.flow.b1<c> f31503k0;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f31504l0;

    /* renamed from: m0  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.badphotos.models.b f31505m0;

    /* renamed from: n0  reason: collision with root package name */
    public final boolean f31506n0;

    /* renamed from: o0  reason: collision with root package name */
    public final List<IdentitySide> f31507o0;

    /* renamed from: p0  reason: collision with root package name */
    public final DocCapture.PreferredMode f31508p0;

    /* renamed from: q0  reason: collision with root package name */
    public final boolean f31509q0;

    /* renamed from: r0  reason: collision with root package name */
    public long f31510r0;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f31511s0;

    /* renamed from: t0  reason: collision with root package name */
    public PhotoCheckResult f31512t0;

    /* renamed from: u0  reason: collision with root package name */
    public kotlinx.coroutines.channels.d<Unit> f31513u0;

    /* renamed from: v0  reason: collision with root package name */
    public kotlinx.coroutines.channels.d<Unit> f31514v0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f31515w0;

    /* renamed from: x0  reason: collision with root package name */
    public long f31516x0;

    /* renamed from: y0  reason: collision with root package name */
    public a f31517y0;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f31518z0;

    public static final class AutoCaptureHint {

        /* renamed from: a  reason: collision with root package name */
        public final String f31519a;

        /* renamed from: b  reason: collision with root package name */
        public final State f31520b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State;", "", "(Ljava/lang/String;I)V", "DEFAULT", "INVALID", "INTERMEDIATE", "OK", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum State {
            DEFAULT,
            INVALID,
            INTERMEDIATE,
            OK
        }

        public AutoCaptureHint(String str, State state) {
            this.f31519a = str;
            this.f31520b = state;
        }

        public final String a() {
            return this.f31519a;
        }

        public final State b() {
            return this.f31520b;
        }

        public final String c() {
            return this.f31519a;
        }

        public final State d() {
            return this.f31520b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AutoCaptureHint)) {
                return false;
            }
            AutoCaptureHint autoCaptureHint = (AutoCaptureHint) obj;
            return kotlin.jvm.internal.x.b(this.f31519a, autoCaptureHint.f31519a) && this.f31520b == autoCaptureHint.f31520b;
        }

        public int hashCode() {
            return (this.f31519a.hashCode() * 31) + this.f31520b.hashCode();
        }

        public String toString() {
            return "AutoCaptureHint(hint=" + this.f31519a + ", state=" + this.f31520b + ')';
        }

        public final AutoCaptureHint a(String str, State state) {
            return new AutoCaptureHint(str, state);
        }

        public static /* synthetic */ AutoCaptureHint a(AutoCaptureHint autoCaptureHint, String str, State state, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = autoCaptureHint.f31519a;
            }
            if ((i11 & 2) != 0) {
                state = autoCaptureHint.f31520b;
            }
            return autoCaptureHint.a(str, state);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$FrameHandleResult;", "", "(Ljava/lang/String;I)V", "RELEASED", "TAKEN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum FrameHandleResult {
        RELEASED,
        TAKEN
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/internal/camera/photo/presentation/document/SNSPhotoDocumentPickerViewModel$PhotoCheckResult;", "", "(Ljava/lang/String;I)V", "SKIPPED", "FOCUSING", "WAITING", "CAPTURED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum PhotoCheckResult {
        SKIPPED,
        FOCUSING,
        WAITING,
        CAPTURED
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f31521a;

        /* renamed from: b  reason: collision with root package name */
        public final com.sumsub.sns.internal.ml.badphotos.models.b f31522b;

        public a(Bitmap bitmap, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
            this.f31521a = bitmap;
            this.f31522b = bVar;
        }

        public final Bitmap a() {
            return this.f31521a;
        }

        public final com.sumsub.sns.internal.ml.badphotos.models.b b() {
            return this.f31522b;
        }

        public final Bitmap c() {
            return this.f31521a;
        }

        public final com.sumsub.sns.internal.ml.badphotos.models.b d() {
            return this.f31522b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.x.b(this.f31521a, aVar.f31521a) && kotlin.jvm.internal.x.b(this.f31522b, aVar.f31522b);
        }

        public int hashCode() {
            return (this.f31521a.hashCode() * 31) + this.f31522b.hashCode();
        }

        public String toString() {
            return "AutoCapturedFrame(frame=" + this.f31521a + ", quality=" + this.f31522b + ')';
        }

        public final a a(Bitmap bitmap, com.sumsub.sns.internal.ml.badphotos.models.b bVar) {
            return new a(bitmap, bVar);
        }

        public static /* synthetic */ a a(a aVar, Bitmap bitmap, com.sumsub.sns.internal.ml.badphotos.models.b bVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bitmap = aVar.f31521a;
            }
            if ((i11 & 2) != 0) {
                bVar = aVar.f31522b;
            }
            return aVar.a(bitmap, bVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onCleared$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1413}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31524b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
            this.f31524b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a0(this.f31524b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31523a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.ml.docdetector.b d12 = this.f31524b.T;
                this.f31523a = 1;
                if (d12.a((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$showInitialViewState$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {414}, m = "invokeSuspend")
    public static final class a1 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31525a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31526b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super a1> cVar) {
            super(2, cVar);
            this.f31526b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a1(this.f31526b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31525a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31526b;
                this.f31525a = 1;
                if (sNSPhotoDocumentPickerViewModel.i((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1178}, m = "onFirstSideManuallyCapturedInSeamlessMode")
    public static final class b0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31527a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31528b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31529c;

        /* renamed from: d  reason: collision with root package name */
        public int f31530d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super b0> cVar) {
            super(cVar);
            this.f31529c = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31528b = obj;
            this.f31530d |= Integer.MIN_VALUE;
            return this.f31529c.a((Context) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1147}, m = "showWaitPopup")
    public static final class b1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31531a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31532b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31533c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31534d;

        /* renamed from: e  reason: collision with root package name */
        public Object f31535e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f31536f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31537g;

        /* renamed from: h  reason: collision with root package name */
        public int f31538h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super b1> cVar) {
            super(cVar);
            this.f31537g = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31536f = obj;
            this.f31538h |= Integer.MIN_VALUE;
            return this.f31537g.k((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class c implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final k f31539a;

        /* renamed from: b  reason: collision with root package name */
        public final a f31540b;

        /* renamed from: c  reason: collision with root package name */
        public final AutoCaptureHint f31541c;

        /* renamed from: d  reason: collision with root package name */
        public final d f31542d;

        /* renamed from: e  reason: collision with root package name */
        public final a.d f31543e;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final Boolean f31544a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f31545b;

            /* renamed from: c  reason: collision with root package name */
            public final CharSequence f31546c;

            /* renamed from: d  reason: collision with root package name */
            public final Boolean f31547d;

            public a(Boolean bool, CharSequence charSequence, CharSequence charSequence2, Boolean bool2) {
                this.f31544a = bool;
                this.f31545b = charSequence;
                this.f31546c = charSequence2;
                this.f31547d = bool2;
            }

            public final Boolean a() {
                return this.f31544a;
            }

            public final CharSequence b() {
                return this.f31545b;
            }

            public final CharSequence c() {
                return this.f31546c;
            }

            public final Boolean d() {
                return this.f31547d;
            }

            public final Boolean e() {
                return this.f31544a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.x.b(this.f31544a, aVar.f31544a) && kotlin.jvm.internal.x.b(this.f31545b, aVar.f31545b) && kotlin.jvm.internal.x.b(this.f31546c, aVar.f31546c) && kotlin.jvm.internal.x.b(this.f31547d, aVar.f31547d);
            }

            public final CharSequence f() {
                return this.f31545b;
            }

            public final CharSequence g() {
                return this.f31546c;
            }

            public final Boolean h() {
                return this.f31547d;
            }

            public int hashCode() {
                Boolean bool = this.f31544a;
                int i11 = 0;
                int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                CharSequence charSequence = this.f31545b;
                int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
                CharSequence charSequence2 = this.f31546c;
                int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                Boolean bool2 = this.f31547d;
                if (bool2 != null) {
                    i11 = bool2.hashCode();
                }
                return hashCode3 + i11;
            }

            public String toString() {
                return "AutoManualSwitch(auto=" + this.f31544a + ", autoText=" + this.f31545b + ", manualText=" + this.f31546c + ", visible=" + this.f31547d + ')';
            }

            public final a a(Boolean bool, CharSequence charSequence, CharSequence charSequence2, Boolean bool2) {
                return new a(bool, charSequence, charSequence2, bool2);
            }

            public static /* synthetic */ a a(a aVar, Boolean bool, CharSequence charSequence, CharSequence charSequence2, Boolean bool2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    bool = aVar.f31544a;
                }
                if ((i11 & 2) != 0) {
                    charSequence = aVar.f31545b;
                }
                if ((i11 & 4) != 0) {
                    charSequence2 = aVar.f31546c;
                }
                if ((i11 & 8) != 0) {
                    bool2 = aVar.f31547d;
                }
                return aVar.a(bool, charSequence, charSequence2, bool2);
            }
        }

        public c(k kVar, a aVar, AutoCaptureHint autoCaptureHint, d dVar, a.d dVar2) {
            this.f31539a = kVar;
            this.f31540b = aVar;
            this.f31541c = autoCaptureHint;
            this.f31542d = dVar;
            this.f31543e = dVar2;
        }

        public final k a() {
            return this.f31539a;
        }

        public final a b() {
            return this.f31540b;
        }

        public final AutoCaptureHint c() {
            return this.f31541c;
        }

        public final d d() {
            return this.f31542d;
        }

        public final a.d e() {
            return this.f31543e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.x.b(this.f31539a, cVar.f31539a) && kotlin.jvm.internal.x.b(this.f31540b, cVar.f31540b) && kotlin.jvm.internal.x.b(this.f31541c, cVar.f31541c) && kotlin.jvm.internal.x.b(this.f31542d, cVar.f31542d) && kotlin.jvm.internal.x.b(this.f31543e, cVar.f31543e);
        }

        public final AutoCaptureHint f() {
            return this.f31541c;
        }

        public final a.d g() {
            return this.f31543e;
        }

        public final d h() {
            return this.f31542d;
        }

        public int hashCode() {
            k kVar = this.f31539a;
            int i11 = 0;
            int hashCode = (((kVar == null ? 0 : kVar.hashCode()) * 31) + this.f31540b.hashCode()) * 31;
            AutoCaptureHint autoCaptureHint = this.f31541c;
            int hashCode2 = (hashCode + (autoCaptureHint == null ? 0 : autoCaptureHint.hashCode())) * 31;
            d dVar = this.f31542d;
            int hashCode3 = (hashCode2 + (dVar == null ? 0 : dVar.hashCode())) * 31;
            a.d dVar2 = this.f31543e;
            if (dVar2 != null) {
                i11 = dVar2.hashCode();
            }
            return hashCode3 + i11;
        }

        public final a i() {
            return this.f31540b;
        }

        public final k j() {
            return this.f31539a;
        }

        public String toString() {
            return "DocumentCaptureViewState(videoCapture=" + this.f31539a + ", switch=" + this.f31540b + ", autoCaptureHint=" + this.f31541c + ", frameHint=" + this.f31542d + ", error=" + this.f31543e + ')';
        }

        public final c a(k kVar, a aVar, AutoCaptureHint autoCaptureHint, d dVar, a.d dVar2) {
            return new c(kVar, aVar, autoCaptureHint, dVar, dVar2);
        }

        public static /* synthetic */ c a(c cVar, k kVar, a aVar, AutoCaptureHint autoCaptureHint, d dVar, a.d dVar2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                kVar = cVar.f31539a;
            }
            if ((i11 & 2) != 0) {
                aVar = cVar.f31540b;
            }
            a aVar2 = aVar;
            if ((i11 & 4) != 0) {
                autoCaptureHint = cVar.f31541c;
            }
            AutoCaptureHint autoCaptureHint2 = autoCaptureHint;
            if ((i11 & 8) != 0) {
                dVar = cVar.f31542d;
            }
            d dVar3 = dVar;
            if ((i11 & 16) != 0) {
                dVar2 = cVar.f31543e;
            }
            return cVar.a(kVar, aVar2, autoCaptureHint2, dVar3, dVar2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(k kVar, a aVar, AutoCaptureHint autoCaptureHint, d dVar, a.d dVar2, int i11, kotlin.jvm.internal.r rVar) {
            this(kVar, aVar, autoCaptureHint, (i11 & 8) != 0 ? null : dVar, dVar2);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onFirstSideManuallyCapturedInSeamlessMode$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31548a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31549b;

        public c0(kotlin.coroutines.c<? super c0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((c0) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c0 c0Var = new c0(cVar);
            c0Var.f31549b = obj;
            return c0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31548a == 0) {
                kotlin.k.b(obj);
                return c.b.a((c.b) this.f31549b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 59, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$showWaitPopup$3", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class c1 extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31550a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31551b;

        public c1(kotlin.coroutines.c<? super c1> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((c1) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c1 c1Var = new c1(cVar);
            c1Var.f31551b = obj;
            return c1Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31550a == 0) {
                kotlin.k.b(obj);
                return c.b.a((c.b) this.f31551b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 59, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f31552a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31553b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f31554c;

        public d(String str, CharSequence charSequence, boolean z11) {
            this.f31552a = str;
            this.f31553b = charSequence;
            this.f31554c = z11;
        }

        public final String a() {
            return this.f31552a;
        }

        public final CharSequence b() {
            return this.f31553b;
        }

        public final boolean c() {
            return this.f31554c;
        }

        public final String d() {
            return this.f31552a;
        }

        public final boolean e() {
            return this.f31554c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.jvm.internal.x.b(this.f31552a, dVar.f31552a) && kotlin.jvm.internal.x.b(this.f31553b, dVar.f31553b) && this.f31554c == dVar.f31554c;
        }

        public final CharSequence f() {
            return this.f31553b;
        }

        public int hashCode() {
            int hashCode = this.f31552a.hashCode() * 31;
            CharSequence charSequence = this.f31553b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            boolean z11 = this.f31554c;
            if (z11) {
                z11 = true;
            }
            return hashCode2 + (z11 ? 1 : 0);
        }

        public String toString() {
            return "FrameHint(icon=" + this.f31552a + ", text=" + this.f31553b + ", loading=" + this.f31554c + ')';
        }

        public final d a(String str, CharSequence charSequence, boolean z11) {
            return new d(str, charSequence, z11);
        }

        public static /* synthetic */ d a(d dVar, String str, CharSequence charSequence, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = dVar.f31552a;
            }
            if ((i11 & 2) != 0) {
                charSequence = dVar.f31553b;
            }
            if ((i11 & 4) != 0) {
                z11 = dVar.f31554c;
            }
            return dVar.a(str, charSequence, z11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(String str, CharSequence charSequence, boolean z11, int i11, kotlin.jvm.internal.r rVar) {
            this(str, charSequence, (i11 & 4) != 0 ? false : z11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onFirstSideManuallyCapturedInSeamlessMode$3", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1170}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31555a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31556b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super d0> cVar) {
            super(2, cVar);
            this.f31556b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d0(this.f31556b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31555a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31556b;
                this.f31555a = 1;
                if (sNSPhotoDocumentPickerViewModel.g((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$switchToAutoMode$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {918, 923}, m = "invokeSuspend")
    public static final class d1 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31557a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31558b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31559c;

        /* renamed from: d  reason: collision with root package name */
        public int f31560d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31561e;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$switchToAutoMode$1$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31562a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31563b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
                return ((a) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f31563b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31562a == 0) {
                    kotlin.k.b(obj);
                    return c.b.a((c.b) this.f31563b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 57, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super d1> cVar) {
            super(2, cVar);
            this.f31561e = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d1(this.f31561e, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f31560d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0038
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                java.lang.Object r0 = r14.f31559c
                kotlinx.coroutines.flow.b1 r0 = (kotlinx.coroutines.flow.b1) r0
                java.lang.Object r1 = r14.f31558b
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r1
                java.lang.Object r2 = r14.f31557a
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a) r2
                kotlin.k.b(r15)
                r3 = r2
                goto L_0x00a5
            L_0x0020:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0028:
                java.lang.Object r1 = r14.f31559c
                kotlinx.coroutines.flow.b1 r1 = (kotlinx.coroutines.flow.b1) r1
                java.lang.Object r4 = r14.f31558b
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r4
                java.lang.Object r5 = r14.f31557a
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r5 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r5
                kotlin.k.b(r15)
                goto L_0x0073
            L_0x0038:
                kotlin.k.b(r15)
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r15 = r14.f31561e
                r15.f31499g0 = r3
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r15 = r14.f31561e
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d1$a r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d1$a
                r4 = 0
                r1.<init>(r4)
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a(r15, r5, r1, r3, r4)
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r15 = r14.f31561e
                kotlinx.coroutines.flow.b1 r15 = r15.f31503k0
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r1 = r14.f31561e
                kotlinx.coroutines.flow.b1 r1 = r1.f31503k0
                java.lang.Object r1 = r1.getValue()
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r5 = r14.f31561e
                r4 = r1
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r4
                r14.f31557a = r5
                r14.f31558b = r4
                r14.f31559c = r15
                r14.f31560d = r3
                java.lang.Object r1 = r5.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c>) r14)
                if (r1 != r0) goto L_0x0070
                return r0
            L_0x0070:
                r13 = r1
                r1 = r15
                r15 = r13
            L_0x0073:
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r15 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r15
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r6 = r4.i()
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r3)
                java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.a.a(r3)
                r8 = 0
                r9 = 0
                r11 = 6
                r12 = 0
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r3 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a.a(r6, r7, r8, r9, r10, r11, r12)
                com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$a r4 = com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult.f31486d
                com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r6 = r4.a()
                r14.f31557a = r3
                r14.f31558b = r15
                r14.f31559c = r1
                r14.f31560d = r2
                r7 = 0
                r9 = 2
                r10 = 0
                r8 = r14
                java.lang.Object r2 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r5, (com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r6, (boolean) r7, (kotlin.coroutines.c) r8, (int) r9, (java.lang.Object) r10)
                if (r2 != r0) goto L_0x00a2
                return r0
            L_0x00a2:
                r0 = r1
                r1 = r15
                r15 = r2
            L_0x00a5:
                r4 = r15
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r4
                r2 = 0
                r5 = 0
                r6 = 0
                r7 = 25
                r8 = 0
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r15 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r1, r2, r3, r4, r5, r6, r7, r8)
                r0.setValue(r15)
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.d1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class e implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public static final e f31564a = new e();
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onFirstSideManuallyCapturedInSeamlessMode$4", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1184}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31566b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super e0> cVar) {
            super(2, cVar);
            this.f31566b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e0(this.f31566b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31565a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31566b;
                this.f31565a = 1;
                if (sNSPhotoDocumentPickerViewModel.i((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$switchToManualMode$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {940}, m = "invokeSuspend")
    public static final class e1 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31567a;

        /* renamed from: b  reason: collision with root package name */
        public int f31568b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31569c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f31570d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$switchToManualMode$1$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31571a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31572b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
                return ((a) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f31572b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31571a == 0) {
                    kotlin.k.b(obj);
                    return c.b.a((c.b) this.f31572b, false, true, true, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 57, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, boolean z11, kotlin.coroutines.c<? super e1> cVar) {
            super(2, cVar);
            this.f31569c = sNSPhotoDocumentPickerViewModel;
            this.f31570d = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e1(this.f31569c, this.f31570d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.b1 b1Var;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31568b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f31569c.f31499g0 = false;
                com.sumsub.sns.core.presentation.base.a.a(this.f31569c, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                kotlinx.coroutines.flow.b1 i12 = this.f31569c.f31503k0;
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31569c;
                this.f31567a = i12;
                this.f31568b = 1;
                Object c11 = sNSPhotoDocumentPickerViewModel.h((kotlin.coroutines.c<? super c>) this);
                if (c11 == d11) {
                    return d11;
                }
                b1Var = i12;
                obj = c11;
            } else if (i11 == 1) {
                b1Var = (kotlinx.coroutines.flow.b1) this.f31567a;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c cVar = (c) obj;
            b1Var.setValue(c.a(cVar, (k) null, c.a.a(cVar.i(), (Boolean) null, (CharSequence) null, (CharSequence) null, kotlin.coroutines.jvm.internal.a.a(this.f31570d), 7, (Object) null), (AutoCaptureHint) null, (d) null, (a.d) null, 29, (Object) null));
            return Unit.f56620a;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public final String f31573a;

        public static final class a extends f {

            /* renamed from: b  reason: collision with root package name */
            public final String f31574b;

            public a(String str) {
                super(str, (kotlin.jvm.internal.r) null);
                this.f31574b = str;
            }

            public final a a(String str) {
                return new a(str);
            }

            public final String b() {
                return a();
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.x.b(a(), ((a) obj).a());
            }

            public int hashCode() {
                return a().hashCode();
            }

            public String toString() {
                return "VideoRecordingInterrupted(message=" + a() + ')';
            }

            public static /* synthetic */ a a(a aVar, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = aVar.a();
                }
                return aVar.a(str);
            }

            public String a() {
                return this.f31574b;
            }
        }

        public /* synthetic */ f(String str, kotlin.jvm.internal.r rVar) {
            this(str);
        }

        public String a() {
            return this.f31573a;
        }

        public f(String str) {
            this.f31573a = str;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {481, 509, 553, 591, 610}, m = "onFrameCaptured")
    public static final class f0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31575a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31576b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31577c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31578d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31579e;

        /* renamed from: f  reason: collision with root package name */
        public long f31580f;

        /* renamed from: g  reason: collision with root package name */
        public int f31581g;

        /* renamed from: h  reason: collision with root package name */
        public int f31582h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f31583i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31584j;

        /* renamed from: k  reason: collision with root package name */
        public int f31585k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super f0> cVar) {
            super(cVar);
            this.f31584j = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31583i = obj;
            this.f31585k |= Integer.MIN_VALUE;
            return this.f31584j.a((Context) null, (Bitmap) null, (Rect) null, (kotlin.coroutines.c<? super FrameHandleResult>) this);
        }
    }

    public static final class f1 extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31586a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f31587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31588c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Rect f31589d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.d<Unit> f31590e;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$takeAutoCapturedFrame$2$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {672}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31591a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31592b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Context f31593c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f31594d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Rect f31595e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.d<Unit> f31596f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, Context context, a aVar, Rect rect, kotlinx.coroutines.channels.d<Unit> dVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f31592b = sNSPhotoDocumentPickerViewModel;
                this.f31593c = context;
                this.f31594d = aVar;
                this.f31595e = rect;
                this.f31596f = dVar;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f31592b, this.f31593c, this.f31594d, this.f31595e, this.f31596f, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f31591a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    this.f31592b.f31500h0 = false;
                    SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31592b;
                    Context context = this.f31593c;
                    Bitmap c11 = this.f31594d.c();
                    Rect rect = this.f31595e;
                    com.sumsub.sns.internal.ml.badphotos.models.b d12 = this.f31594d.d();
                    this.f31591a = 1;
                    if (sNSPhotoDocumentPickerViewModel.a(context, c11, rect, d12, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlinx.coroutines.channels.d<Unit> dVar = this.f31596f;
                Unit unit = Unit.f56620a;
                dVar.q(unit);
                return unit;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, Context context, a aVar, Rect rect, kotlinx.coroutines.channels.d<Unit> dVar) {
            super(0);
            this.f31586a = sNSPhotoDocumentPickerViewModel;
            this.f31587b = context;
            this.f31588c = aVar;
            this.f31589d = rect;
            this.f31590e = dVar;
        }

        public final void a() {
            b.b(b.f31751a, DocCapture.f31492c, "photo animation finished", (Throwable) null, 4, (Object) null);
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this.f31586a), (CoroutineContext) null, (CoroutineStart) null, new a(this.f31586a, this.f31587b, this.f31588c, this.f31589d, this.f31590e, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class g implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public static final g f31597a = new g();
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onFrameCaptured$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {467}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31598a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31599b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super g0> cVar) {
            super(2, cVar);
            this.f31599b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g0(this.f31599b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31598a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31599b;
                this.f31598a = 1;
                if (sNSPhotoDocumentPickerViewModel.i((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1052, 1057}, m = "takeFrameAsResult")
    public static final class g1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31600a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31601b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31602c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31603d;

        /* renamed from: e  reason: collision with root package name */
        public Object f31604e;

        /* renamed from: f  reason: collision with root package name */
        public int f31605f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f31606g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31607h;

        /* renamed from: i  reason: collision with root package name */
        public int f31608i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super g1> cVar) {
            super(cVar);
            this.f31607h = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31606g = obj;
            this.f31608i |= Integer.MIN_VALUE;
            return this.f31607h.a((Context) null, (Bitmap) null, (Rect) null, (com.sumsub.sns.internal.ml.badphotos.models.b) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class h implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final Size f31609a;

        /* renamed from: b  reason: collision with root package name */
        public final Size f31610b;

        /* renamed from: c  reason: collision with root package name */
        public final com.sumsub.sns.internal.ml.docdetector.a f31611c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f31612d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f31613e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f31614f;

        public h(Size size, Size size2, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11, boolean z12, boolean z13) {
            this.f31609a = size;
            this.f31610b = size2;
            this.f31611c = aVar;
            this.f31612d = z11;
            this.f31613e = z12;
            this.f31614f = z13;
        }

        public final Size a() {
            return this.f31609a;
        }

        public final Size b() {
            return this.f31610b;
        }

        public final com.sumsub.sns.internal.ml.docdetector.a c() {
            return this.f31611c;
        }

        public final boolean d() {
            return this.f31612d;
        }

        public final boolean e() {
            return this.f31613e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return kotlin.jvm.internal.x.b(this.f31609a, hVar.f31609a) && kotlin.jvm.internal.x.b(this.f31610b, hVar.f31610b) && kotlin.jvm.internal.x.b(this.f31611c, hVar.f31611c) && this.f31612d == hVar.f31612d && this.f31613e == hVar.f31613e && this.f31614f == hVar.f31614f;
        }

        public final boolean f() {
            return this.f31614f;
        }

        public final boolean g() {
            return this.f31613e;
        }

        public final boolean h() {
            return this.f31612d;
        }

        public int hashCode() {
            int hashCode = ((((this.f31609a.hashCode() * 31) + this.f31610b.hashCode()) * 31) + this.f31611c.hashCode()) * 31;
            boolean z11 = this.f31612d;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.f31613e;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f31614f;
            if (!z14) {
                z12 = z14;
            }
            return i12 + (z12 ? 1 : 0);
        }

        public final Size i() {
            return this.f31609a;
        }

        public final com.sumsub.sns.internal.ml.docdetector.a j() {
            return this.f31611c;
        }

        public final Size k() {
            return this.f31610b;
        }

        public final boolean l() {
            return this.f31614f;
        }

        public String toString() {
            return "ShowDocDetectionResult(photoSize=" + this.f31609a + ", sampleSize=" + this.f31610b + ", result=" + this.f31611c + ", frameHit=" + this.f31612d + ", drawDetectedFrame=" + this.f31613e + ", saveScreen=" + this.f31614f + ')';
        }

        public final h a(Size size, Size size2, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11, boolean z12, boolean z13) {
            return new h(size, size2, aVar, z11, z12, z13);
        }

        public static /* synthetic */ h a(h hVar, Size size, Size size2, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                size = hVar.f31609a;
            }
            if ((i11 & 2) != 0) {
                size2 = hVar.f31610b;
            }
            Size size3 = size2;
            if ((i11 & 4) != 0) {
                aVar = hVar.f31611c;
            }
            com.sumsub.sns.internal.ml.docdetector.a aVar2 = aVar;
            if ((i11 & 8) != 0) {
                z11 = hVar.f31612d;
            }
            boolean z14 = z11;
            if ((i11 & 16) != 0) {
                z12 = hVar.f31613e;
            }
            boolean z15 = z12;
            if ((i11 & 32) != 0) {
                z13 = hVar.f31614f;
            }
            return hVar.a(size, size3, aVar2, z14, z15, z13);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ h(Size size, Size size2, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11, boolean z12, boolean z13, int i11, kotlin.jvm.internal.r rVar) {
            this(size, size2, aVar, z11, z12, (i11 & 32) != 0 ? false : z13);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onFrameCaptured$docBounds$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {510}, m = "invokeSuspend")
    public static final class h0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.docdetector.a>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31615a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31616b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f31617c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f31618d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, Bitmap bitmap, boolean z11, kotlin.coroutines.c<? super h0> cVar) {
            super(2, cVar);
            this.f31616b = sNSPhotoDocumentPickerViewModel;
            this.f31617c = bitmap;
            this.f31618d = z11;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.docdetector.a> cVar) {
            return ((h0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h0(this.f31616b, this.f31617c, this.f31618d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31615a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.ml.docdetector.b d12 = this.f31616b.T;
                Bitmap bitmap = this.f31617c;
                boolean z11 = this.f31618d;
                this.f31615a = 1;
                obj = d12.a(bitmap, z11, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {637, 641, 645, 649}, m = "updateDocCaptureHint")
    public static final class h1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31619a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31620b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31621c;

        /* renamed from: d  reason: collision with root package name */
        public int f31622d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h1(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super h1> cVar) {
            super(cVar);
            this.f31621c = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31620b = obj;
            this.f31622d |= Integer.MIN_VALUE;
            return this.f31621c.a((CheckDetectionResult) null, (PhotoCheckResult) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class i implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final d10.a<Unit> f31623a;

        public i(d10.a<Unit> aVar) {
            this.f31623a = aVar;
        }

        public final d10.a<Unit> a() {
            return this.f31623a;
        }

        public final d10.a<Unit> b() {
            return this.f31623a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && kotlin.jvm.internal.x.b(this.f31623a, ((i) obj).f31623a);
        }

        public int hashCode() {
            return this.f31623a.hashCode();
        }

        public String toString() {
            return "ShowPhotoMadeAnimation(finishCallback=" + this.f31623a + ')';
        }

        public final i a(d10.a<Unit> aVar) {
            return new i(aVar);
        }

        public static /* synthetic */ i a(i iVar, d10.a<Unit> aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                aVar = iVar.f31623a;
            }
            return iVar.a(aVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1124, 1127, 1132}, m = "onPhotoTakenManuallyInSeamlessMode")
    public static final class i0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31624a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31625b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31626c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31627d;

        /* renamed from: e  reason: collision with root package name */
        public int f31628e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super i0> cVar) {
            super(cVar);
            this.f31627d = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31626c = obj;
            this.f31628e |= Integer.MIN_VALUE;
            return this.f31627d.b((Context) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class j implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31629a;

        /* renamed from: b  reason: collision with root package name */
        public final float f31630b;

        /* renamed from: c  reason: collision with root package name */
        public final long f31631c;

        public j(boolean z11, float f11, long j11) {
            this.f31629a = z11;
            this.f31630b = f11;
            this.f31631c = j11;
        }

        public final boolean a() {
            return this.f31629a;
        }

        public final float b() {
            return this.f31630b;
        }

        public final long c() {
            return this.f31631c;
        }

        public final float d() {
            return this.f31630b;
        }

        public final boolean e() {
            return this.f31629a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.f31629a == jVar.f31629a && kotlin.jvm.internal.x.b(Float.valueOf(this.f31630b), Float.valueOf(jVar.f31630b)) && this.f31631c == jVar.f31631c;
        }

        public final long f() {
            return this.f31631c;
        }

        public int hashCode() {
            boolean z11 = this.f31629a;
            if (z11) {
                z11 = true;
            }
            return ((((z11 ? 1 : 0) * true) + Float.floatToIntBits(this.f31630b)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f31631c);
        }

        public String toString() {
            return "ShowQualityCheckResult(ok=" + this.f31629a + ", confidence=" + this.f31630b + ", timeMs=" + this.f31631c + ')';
        }

        public final j a(boolean z11, float f11, long j11) {
            return new j(z11, f11, j11);
        }

        public static /* synthetic */ j a(j jVar, boolean z11, float f11, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = jVar.f31629a;
            }
            if ((i11 & 2) != 0) {
                f11 = jVar.f31630b;
            }
            if ((i11 & 4) != 0) {
                j11 = jVar.f31631c;
            }
            return jVar.a(z11, f11, j11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPhotoTakenManuallyInSeamlessMode$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1134}, m = "invokeSuspend")
    public static final class j0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31633b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super j0> cVar) {
            super(2, cVar);
            this.f31633b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j0(this.f31633b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31632a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31633b;
                this.f31632a = 1;
                if (sNSPhotoDocumentPickerViewModel.g((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public final File f31634a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31635b;

        public k(File file, boolean z11) {
            this.f31634a = file;
            this.f31635b = z11;
        }

        public final File a() {
            return this.f31634a;
        }

        public final boolean b() {
            return this.f31635b;
        }

        public final File c() {
            return this.f31634a;
        }

        public final boolean d() {
            return this.f31635b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return kotlin.jvm.internal.x.b(this.f31634a, kVar.f31634a) && this.f31635b == kVar.f31635b;
        }

        public int hashCode() {
            File file = this.f31634a;
            int hashCode = (file == null ? 0 : file.hashCode()) * 31;
            boolean z11 = this.f31635b;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        public String toString() {
            return "VideoCapture(file=" + this.f31634a + ", started=" + this.f31635b + ')';
        }

        public final k a(File file, boolean z11) {
            return new k(file, z11);
        }

        public static /* synthetic */ k a(k kVar, File file, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                file = kVar.f31634a;
            }
            if ((i11 & 2) != 0) {
                z11 = kVar.f31635b;
            }
            return kVar.a(file, z11);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPictureTaken$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {425}, m = "invokeSuspend")
    public static final class k0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31636a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f31638c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, File file, kotlin.coroutines.c<? super k0> cVar) {
            super(2, cVar);
            this.f31637b = sNSPhotoDocumentPickerViewModel;
            this.f31638c = file;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k0(this.f31637b, this.f31638c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31636a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.channels.d f11 = this.f31637b.f31514v0;
                this.f31636a = 1;
                if (f11.J(this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            SNSPhotoDocumentPickerViewModel.super.a(this.f31638c);
            return Unit.f56620a;
        }
    }

    public /* synthetic */ class l {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31639a;

        static {
            int[] iArr = new int[CheckDetectionResult.SizeCheckResult.values().length];
            iArr[CheckDetectionResult.SizeCheckResult.OK.ordinal()] = 1;
            iArr[CheckDetectionResult.SizeCheckResult.SMALL.ordinal()] = 2;
            iArr[CheckDetectionResult.SizeCheckResult.BIG.ordinal()] = 3;
            f31639a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPictureTaken$4", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class l0 extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31640a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31641b;

        public l0(kotlin.coroutines.c<? super l0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((l0) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            l0 l0Var = new l0(cVar);
            l0Var.f31641b = obj;
            return l0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31640a == 0) {
                kotlin.k.b(obj);
                return c.b.a((c.b) this.f31641b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 61, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class m extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31642a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel) {
            super(0);
            this.f31642a = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f31642a.I().g() && Build.VERSION.SDK_INT >= 26);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPictureTaken$5", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1106}, m = "invokeSuspend")
    public static final class m0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31644b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super m0> cVar) {
            super(2, cVar);
            this.f31644b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((m0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m0(this.f31644b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31643a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31644b;
                this.f31643a = 1;
                if (sNSPhotoDocumentPickerViewModel.g((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class n extends Lambda implements d10.a<a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31645a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel) {
            super(0);
            this.f31645a = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final a invoke() {
            return new a(this.f31645a.V);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPictureTaken$6", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1117}, m = "invokeSuspend")
    public static final class n0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31647b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super n0> cVar) {
            super(2, cVar);
            this.f31647b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n0(this.f31647b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31646a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31647b;
                this.f31646a = 1;
                if (sNSPhotoDocumentPickerViewModel.i((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {960, 962, 968, 973, 978, 980}, m = "buildAutoCaptureHint")
    public static final class o extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31648a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31649b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31650c;

        /* renamed from: d  reason: collision with root package name */
        public int f31651d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super o> cVar) {
            super(cVar);
            this.f31650c = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31649b = obj;
            this.f31651d |= Integer.MIN_VALUE;
            return this.f31650c.a((CheckDetectionResult) null, false, (kotlin.coroutines.c<? super AutoCaptureHint>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {325, 335, 336}, m = "onPrepare")
    public static final class o0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31652a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31653b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31654c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31655d;

        /* renamed from: e  reason: collision with root package name */
        public int f31656e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super o0> cVar) {
            super(cVar);
            this.f31655d = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31654c = obj;
            this.f31656e |= Integer.MIN_VALUE;
            return this.f31655d.d((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {377}, m = "checkAutoCaptureAllowedForStep")
    public static final class p extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31657a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31659c;

        /* renamed from: d  reason: collision with root package name */
        public int f31660d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super p> cVar) {
            super(cVar);
            this.f31659c = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31658b = obj;
            this.f31660d |= Integer.MIN_VALUE;
            return this.f31659c.f((kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onPrepare$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {341}, m = "invokeSuspend")
    public static final class p0 extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31662b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super p0> cVar) {
            super(1, cVar);
            this.f31662b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
            return ((p0) create(cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
            return new p0(this.f31662b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31661a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31662b;
                this.f31661a = 1;
                if (sNSPhotoDocumentPickerViewModel.j((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {814}, m = "checkManualyCapturedPicture")
    public static final class q extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31663a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31665c;

        /* renamed from: d  reason: collision with root package name */
        public int f31666d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super q> cVar) {
            super(cVar);
            this.f31665c = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31664b = obj;
            this.f31666d |= Integer.MIN_VALUE;
            return this.f31665c.a((Bitmap) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {794, 799, 804}, m = "onRequestedPictureTaken")
    public static final class q0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31667a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31668b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31669c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31670d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31671e;

        /* renamed from: f  reason: collision with root package name */
        public int f31672f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super q0> cVar) {
            super(cVar);
            this.f31671e = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31670d = obj;
            this.f31672f |= Integer.MIN_VALUE;
            return this.f31671e.b((Context) null, (Bitmap) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1351}, m = "checkPhotoQuality")
    public static final class r extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31673a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31674b;

        /* renamed from: c  reason: collision with root package name */
        public long f31675c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31676d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31677e;

        /* renamed from: f  reason: collision with root package name */
        public int f31678f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super r> cVar) {
            super(cVar);
            this.f31677e = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31676d = obj;
            this.f31678f |= Integer.MIN_VALUE;
            return this.f31677e.a((Bitmap) null, false, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b>) this);
        }
    }

    public static final class r0 extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31679a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onTakePictureClicked$1$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31680a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31681b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
                return ((a) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f31681b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31680a == 0) {
                    kotlin.k.b(obj);
                    return c.b.a((c.b) this.f31681b, false, false, false, true, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 55, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onTakePictureClicked$1$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {457}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31682a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31683b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f31683b = sNSPhotoDocumentPickerViewModel;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f31683b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f31682a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    kotlinx.coroutines.channels.d f11 = this.f31683b.f31514v0;
                    Unit unit = Unit.f56620a;
                    this.f31682a = 1;
                    if (f11.send(unit, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel) {
            super(0);
            this.f31679a = sNSPhotoDocumentPickerViewModel;
        }

        public final void a() {
            this.f31679a.f31500h0 = false;
            b.b(b.f31751a, DocCapture.f31492c, "photo animation finished", (Throwable) null, 4, (Object) null);
            com.sumsub.sns.core.presentation.base.a.a(this.f31679a, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this.f31679a), (CoroutineContext) null, (CoroutineStart) null, new b(this.f31679a, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$checkPhotoQuality$badPhotosDetectorResult$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1352}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31684a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31685b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f31686c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, Bitmap bitmap, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f31685b = sNSPhotoDocumentPickerViewModel;
            this.f31686c = bitmap;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super e.a<com.sumsub.sns.internal.ml.badphotos.models.a>> cVar) {
            return ((s) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s(this.f31685b, this.f31686c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31684a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.ml.badphotos.a a11 = this.f31685b.S;
                if (a11 != null) {
                    Bitmap bitmap = this.f31686c;
                    this.f31684a = 1;
                    obj = a11.a(bitmap, this);
                    if (obj == d11) {
                        return d11;
                    }
                }
                return new e.a.c();
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e.a aVar = (e.a) obj;
            if (aVar != null) {
                return aVar;
            }
            return new e.a.c();
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onVideoRecordingFinalized$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {277}, m = "invokeSuspend")
    public static final class s0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31687a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31688b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CameraX.c.a f31689c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, CameraX.c.a aVar, kotlin.coroutines.c<? super s0> cVar) {
            super(2, cVar);
            this.f31688b = sNSPhotoDocumentPickerViewModel;
            this.f31689c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((s0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s0(this.f31688b, this.f31689c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31687a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f31687a = 1;
                if (this.f31688b.a((CameraX.c.a.C0371a) this.f31689c, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {690}, m = "checkPhotoQualityAndUpdateLastCaptured")
    public static final class t extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31690a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31691b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31692c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31693d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31694e;

        /* renamed from: f  reason: collision with root package name */
        public int f31695f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super t> cVar) {
            super(cVar);
            this.f31694e = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31693d = obj;
            this.f31695f |= Integer.MIN_VALUE;
            return this.f31694e.a((Context) null, (Bitmap) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onVideoRecordingFinalized$3", f = "SNSPhotoDocumentPickerViewModel.kt", l = {301}, m = "invokeSuspend")
    public static final class t0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31696a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31697b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super t0> cVar) {
            super(2, cVar);
            this.f31697b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((t0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new t0(this.f31697b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31696a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31697b;
                this.f31696a = 1;
                if (sNSPhotoDocumentPickerViewModel.g((kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1270, 1272}, m = "finishWithCurrentResults")
    public static final class u extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31698a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31699b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31700c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31701d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f31702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31703f;

        /* renamed from: g  reason: collision with root package name */
        public int f31704g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super u> cVar) {
            super(cVar);
            this.f31703f = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31702e = obj;
            this.f31704g |= Integer.MIN_VALUE;
            return this.f31703f.g((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$onVideoRecordingStarted$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {229}, m = "invokeSuspend")
    public static final class u0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31705a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31706b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super u0> cVar) {
            super(2, cVar);
            this.f31706b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((u0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u0(this.f31706b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31705a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.channels.d h11 = this.f31706b.f31513u0;
                Unit unit = Unit.f56620a;
                this.f31705a = 1;
                if (h11.send(unit, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$finishWithCurrentResults$2", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31707a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31708b;

        public v(kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((v) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            v vVar = new v(cVar);
            vVar.f31708b = obj;
            return vVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31707a == 0) {
                kotlin.k.b(obj);
                return c.b.a((c.b) this.f31708b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 59, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class v0 extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31709a;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$requestDocumentFlip$2$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31710a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f31711b;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
                return ((a) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(cVar);
                aVar.f31711b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31710a == 0) {
                    kotlin.k.b(obj);
                    return c.b.a((c.b) this.f31711b, false, true, true, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 49, (Object) null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel) {
            super(0);
            this.f31709a = sNSPhotoDocumentPickerViewModel;
        }

        public final void a() {
            this.f31709a.O();
            int size = this.f31709a.H().size();
            SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel = this.f31709a;
            sNSPhotoDocumentPickerViewModel.a((IdentitySide) sNSPhotoDocumentPickerViewModel.f31507o0.get(size));
            b bVar = b.f31751a;
            b.b(bVar, DocCapture.f31492c, "requestDocumentNextSide: " + this.f31709a.q(), (Throwable) null, 4, (Object) null);
            if (!this.f31709a.f31499g0) {
                com.sumsub.sns.core.presentation.base.a.a(this.f31709a, false, new a((kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$finishWithCurrentResults$3", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1286}, m = "invokeSuspend")
    public static final class w extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31713b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super w> cVar) {
            super(2, cVar);
            this.f31713b = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((w) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new w(this.f31713b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31712a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f31712a = 1;
                if (DelayKt.b(2000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f31713b.b((f) null);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1234}, m = "showDocumentFlipHint")
    public static final class w0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31714a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31715b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31716c;

        /* renamed from: d  reason: collision with root package name */
        public Object f31717d;

        /* renamed from: e  reason: collision with root package name */
        public Object f31718e;

        /* renamed from: f  reason: collision with root package name */
        public Object f31719f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f31720g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31721h;

        /* renamed from: i  reason: collision with root package name */
        public int f31722i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super w0> cVar) {
            super(cVar);
            this.f31721h = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31720g = obj;
            this.f31722i |= Integer.MIN_VALUE;
            return this.f31721h.a((d10.a<Unit>) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {305, 307, 310}, m = "handleVideoRecordingErrorStatus")
    public static final class x extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31723a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31724b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31725c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31726d;

        /* renamed from: e  reason: collision with root package name */
        public int f31727e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super x> cVar) {
            super(cVar);
            this.f31726d = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31725c = obj;
            this.f31727e |= Integer.MIN_VALUE;
            return this.f31726d.a((CameraX.c.a.C0371a) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$showDocumentFlipHint$3", f = "SNSPhotoDocumentPickerViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class x0 extends SuspendLambda implements d10.p<c.b, kotlin.coroutines.c<? super c.b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31728a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31729b;

        public x0(kotlin.coroutines.c<? super x0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(c.b bVar, kotlin.coroutines.c<? super c.b> cVar) {
            return ((x0) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            x0 x0Var = new x0(cVar);
            x0Var.f31729b = obj;
            return x0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31728a == 0) {
                kotlin.k.b(obj);
                return c.b.a((c.b) this.f31729b, false, false, false, false, false, (com.sumsub.sns.internal.core.presentation.helper.camera.b) null, 59, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$initMlModels$1", f = "SNSPhotoDocumentPickerViewModel.kt", l = {353, 355, 365, 373}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f31730a;

        /* renamed from: b  reason: collision with root package name */
        public int f31731b;

        /* renamed from: c  reason: collision with root package name */
        public int f31732c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31733d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d10.l<kotlin.coroutines.c<? super Unit>, Object> f31734e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object> lVar, kotlin.coroutines.c<? super y> cVar) {
            super(2, cVar);
            this.f31733d = sNSPhotoDocumentPickerViewModel;
            this.f31734e = lVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((y) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new y(this.f31733d, this.f31734e, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x011c A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f31732c
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 0
                r7 = 0
                r8 = 1
                if (r2 == 0) goto L_0x004a
                if (r2 == r8) goto L_0x0044
                if (r2 == r5) goto L_0x0036
                if (r2 == r4) goto L_0x0025
                if (r2 != r3) goto L_0x001d
                kotlin.k.b(r17)
                goto L_0x011d
            L_0x001d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0025:
                int r2 = r0.f31731b
                boolean r4 = r0.f31730a
                kotlin.k.b(r17)
                r5 = r17
                kotlin.Result r5 = (kotlin.Result) r5
                java.lang.Object r5 = r5.m3081unboximpl()
                goto L_0x00c4
            L_0x0036:
                boolean r2 = r0.f31730a
                kotlin.k.b(r17)
                r5 = r17
                kotlin.Result r5 = (kotlin.Result) r5
                java.lang.Object r5 = r5.m3081unboximpl()
                goto L_0x0087
            L_0x0044:
                kotlin.k.b(r17)
                r2 = r17
                goto L_0x0064
            L_0x004a:
                kotlin.k.b(r17)
                com.sumsub.sns.internal.camera.photo.presentation.document.b r9 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "DocCapture"
                java.lang.String r11 = "initModels"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r9, r10, r11, r12, r13, r14)
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = r0.f31733d
                r0.f31732c = r8
                java.lang.Object r2 = r2.f((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
                if (r2 != r1) goto L_0x0064
                return r1
            L_0x0064:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = r0.f31733d
                boolean r9 = r9.f31509q0
                if (r9 != 0) goto L_0x0074
                if (r2 == 0) goto L_0x008c
            L_0x0074:
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = r0.f31733d
                com.sumsub.sns.internal.ml.badphotos.a r9 = r9.S
                if (r9 == 0) goto L_0x008c
                r0.f31730a = r2
                r0.f31732c = r5
                java.lang.Object r5 = r9.b((kotlin.coroutines.c<? super kotlin.Result<java.lang.Boolean>>) r0)
                if (r5 != r1) goto L_0x0087
                return r1
            L_0x0087:
                kotlin.Result r5 = kotlin.Result.m3071boximpl(r5)
                goto L_0x008d
            L_0x008c:
                r5 = r7
            L_0x008d:
                if (r5 == 0) goto L_0x00a3
                java.lang.Object r5 = r5.m3081unboximpl()
                boolean r9 = kotlin.Result.m3078isFailureimpl(r5)
                if (r9 == 0) goto L_0x009a
                r5 = r7
            L_0x009a:
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r8)
                boolean r5 = kotlin.jvm.internal.x.b(r5, r9)
                goto L_0x00a4
            L_0x00a3:
                r5 = r6
            L_0x00a4:
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = r0.f31733d
                r9.e((boolean) r5)
                if (r2 == 0) goto L_0x00cc
                if (r5 == 0) goto L_0x00cc
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = r0.f31733d
                com.sumsub.sns.internal.ml.docdetector.b r9 = r9.T
                r0.f31730a = r2
                r0.f31731b = r5
                r0.f31732c = r4
                java.lang.Object r4 = r9.b((kotlin.coroutines.c<? super kotlin.Result<java.lang.Boolean>>) r0)
                if (r4 != r1) goto L_0x00c0
                return r1
            L_0x00c0:
                r15 = r4
                r4 = r2
                r2 = r5
                r5 = r15
            L_0x00c4:
                kotlin.Result r5 = kotlin.Result.m3071boximpl(r5)
                r15 = r4
                r4 = r2
                r2 = r15
                goto L_0x00ce
            L_0x00cc:
                r4 = r5
                r5 = r7
            L_0x00ce:
                if (r5 == 0) goto L_0x00e5
                java.lang.Object r5 = r5.m3081unboximpl()
                boolean r9 = kotlin.Result.m3078isFailureimpl(r5)
                if (r9 == 0) goto L_0x00db
                goto L_0x00dc
            L_0x00db:
                r7 = r5
            L_0x00dc:
                java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r8)
                boolean r5 = kotlin.jvm.internal.x.b(r7, r5)
                goto L_0x00e6
            L_0x00e5:
                r5 = r6
            L_0x00e6:
                com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r7 = r0.f31733d
                r2 = r2 & r5
                r7.d((boolean) r2)
                com.sumsub.sns.internal.camera.photo.presentation.document.b r9 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = "initModels: badPhotos="
                r2.append(r7)
                if (r4 == 0) goto L_0x00fb
                r6 = r8
            L_0x00fb:
                r2.append(r6)
                java.lang.String r4 = ", autoCapture="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r11 = r2.toString()
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "DocCapture"
                com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r9, r10, r11, r12, r13, r14)
                d10.l<kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r2 = r0.f31734e
                r0.f31732c = r3
                java.lang.Object r2 = r2.invoke(r0)
                if (r2 != r1) goto L_0x011d
                return r1
            L_0x011d:
                kotlin.Unit r1 = kotlin.Unit.f56620a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$showDocumentFlipHint$4", f = "SNSPhotoDocumentPickerViewModel.kt", l = {1248}, m = "invokeSuspend")
    public static final class y0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31735a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f31736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31737c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y0(d10.a<Unit> aVar, SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super y0> cVar) {
            super(2, cVar);
            this.f31736b = aVar;
            this.f31737c = sNSPhotoDocumentPickerViewModel;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((y0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new y0(this.f31736b, this.f31737c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31735a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b.b(b.f31751a, DocCapture.f31492c, "waiting for doc flip ... ", (Throwable) null, 4, (Object) null);
                this.f31735a = 1;
                if (DelayKt.b(3000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d10.a<Unit> aVar = this.f31736b;
            if (aVar != null) {
                aVar.invoke();
            }
            this.f31737c.f31518z0 = false;
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {178, 179}, m = "manualDocumentCaptureState")
    public static final class z extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31738a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31739b;

        /* renamed from: c  reason: collision with root package name */
        public Object f31740c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31741d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31742e;

        /* renamed from: f  reason: collision with root package name */
        public int f31743f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super z> cVar) {
            super(cVar);
            this.f31742e = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31741d = obj;
            this.f31743f |= Integer.MIN_VALUE;
            return this.f31742e.h((kotlin.coroutines.c<? super c>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel", f = "SNSPhotoDocumentPickerViewModel.kt", l = {398, 409}, m = "showInitialViewState")
    public static final class z0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31744a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31745b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31746c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SNSPhotoDocumentPickerViewModel f31747d;

        /* renamed from: e  reason: collision with root package name */
        public int f31748e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z0(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, kotlin.coroutines.c<? super z0> cVar) {
            super(cVar);
            this.f31747d = sNSPhotoDocumentPickerViewModel;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31746c = obj;
            this.f31748e |= Integer.MIN_VALUE;
            return this.f31747d.j((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    static {
        Class<SNSPhotoDocumentPickerViewModel> cls = SNSPhotoDocumentPickerViewModel.class;
        B = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "collectedResults", "getCollectedResults()Ljava/util/List;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "badPhotosAllowed", "getBadPhotosAllowed()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "autoCaptureAllowed", "getAutoCaptureAllowed()Z", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPhotoDocumentPickerViewModel(DocumentType documentType, String str, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.ml.badphotos.a aVar2, com.sumsub.sns.internal.ml.docdetector.b bVar2, com.sumsub.sns.internal.ml.badphotos.c cVar, com.sumsub.sns.internal.ml.autocapture.a aVar3, SeamlessDocaptureMobileConfig seamlessDocaptureMobileConfig, SavedStateHandle savedStateHandle, boolean z11) {
        super(documentType, str, z11, aVar, bVar);
        List<IdentitySide> list;
        SavedStateHandle savedStateHandle2 = savedStateHandle;
        this.R = bVar;
        this.S = aVar2;
        this.T = bVar2;
        this.U = cVar;
        this.V = aVar3;
        this.W = seamlessDocaptureMobileConfig;
        this.Y = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, D, CollectionsKt__CollectionsKt.k());
        Boolean bool = Boolean.FALSE;
        this.f31501i0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "badPhotosAllowed", bool);
        this.f31502j0 = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle2, "autoCaptureAllowed", bool);
        this.f31503k0 = k1.a(new c((k) null, new c.a((Boolean) null, (CharSequence) null, (CharSequence) null, (Boolean) null), (AutoCaptureHint) null, (d) null, (a.d) null, 8, (kotlin.jvm.internal.r) null));
        this.f31505m0 = (com.sumsub.sns.internal.ml.badphotos.models.b) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31322f);
        Boolean bool2 = (Boolean) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31325i);
        this.f31506n0 = bool2 != null ? bool2.booleanValue() : false;
        List<String> list2 = (List) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31320d);
        if (list2 != null) {
            list = new ArrayList<>(CollectionsKt__IterablesKt.u(list2, 10));
            for (String a11 : list2) {
                IdentitySide a12 = IdentitySide.Companion.a(a11);
                if (a12 == null) {
                    a12 = IdentitySide.Front;
                }
                list.add(a12);
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        this.f31507o0 = list;
        String str2 = (String) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31324h);
        this.f31508p0 = str2 != null ? DocCapture.PreferredMode.Companion.a(str2) : null;
        Boolean bool3 = (Boolean) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31318b);
        this.f31509q0 = bool3 != null ? bool3.booleanValue() : false;
        this.f31510r0 = Long.MIN_VALUE;
        this.f31513u0 = kotlinx.coroutines.channels.f.b(0, (BufferOverflow) null, (d10.l) null, 7, (Object) null);
        this.f31514v0 = kotlinx.coroutines.channels.f.b(0, (BufferOverflow) null, (d10.l) null, 7, (Object) null);
        this.f31516x0 = Long.MIN_VALUE;
    }

    public static /* synthetic */ void J() {
    }

    public final boolean C() {
        return ((Boolean) this.f31502j0.a(this, B[2])).booleanValue();
    }

    public final boolean D() {
        return ((Boolean) this.f31493a0.getValue()).booleanValue();
    }

    public final a E() {
        return (a) this.f31495c0.getValue();
    }

    public final boolean F() {
        return ((Boolean) this.f31501i0.a(this, B[1])).booleanValue();
    }

    public final CameraX.Mode G() {
        CameraX.Mode mode;
        if (this.f31509q0) {
            mode = CameraX.Mode.SEAMLESS_DOC_CAPTURE;
        } else if (C()) {
            mode = CameraX.Mode.PHOTO_AND_ANALYZER;
            if (!this.V.s()) {
                mode = null;
            }
            if (mode == null) {
                mode = CameraX.Mode.ANALYZER;
            }
        } else {
            mode = CameraX.Mode.PHOTO;
        }
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "cameraMode: " + mode, (Throwable) null, 4, (Object) null);
        return mode;
    }

    public final List<com.sumsub.sns.internal.core.data.model.n> H() {
        return (List) this.Y.a(this, B[0]);
    }

    public final com.sumsub.sns.internal.ff.core.a I() {
        return this.f31494b0;
    }

    public final j1<c> K() {
        return this.f31503k0;
    }

    public final boolean L() {
        return this.f31507o0.isEmpty() || this.f31507o0.size() <= H().size();
    }

    public final boolean M() {
        return this.f31515w0;
    }

    public final a.j N() {
        b.b(b.f31751a, DocCapture.f31492c, "lost document bounds", (Throwable) null, 4, (Object) null);
        this.A0 = false;
        E().a();
        this.f31516x0 = Long.MIN_VALUE;
        return e.f31564a;
    }

    public final void O() {
        kotlinx.coroutines.flow.b1<c> b1Var = this.f31503k0;
        b1Var.setValue(c.a(b1Var.getValue(), (k) null, (c.a) null, (AutoCaptureHint) null, (d) null, (a.d) null, 23, (Object) null));
    }

    public final void P() {
        b.b(b.f31751a, DocCapture.f31492c, "onCameraPreviewReady", (Throwable) null, 4, (Object) null);
    }

    public final void Q() {
        IdentitySide identitySide = (IdentitySide) CollectionsKt___CollectionsKt.c0(this.f31507o0);
        if (identitySide == null) {
            identitySide = IdentitySide.Front;
        }
        a(identitySide);
        a((List<com.sumsub.sns.internal.core.data.model.n>) CollectionsKt__CollectionsKt.k());
    }

    public final boolean R() {
        Float n11;
        Integer k11;
        Integer j11;
        com.sumsub.sns.internal.core.data.model.n nVar = (com.sumsub.sns.internal.core.data.model.n) CollectionsKt___CollectionsKt.n0(H());
        com.sumsub.sns.internal.ml.badphotos.models.b l11 = nVar != null ? nVar.l() : null;
        int intValue = (l11 == null || (j11 = l11.j()) == null) ? 0 : j11.intValue();
        int intValue2 = (l11 == null || (k11 = l11.k()) == null) ? 0 : k11.intValue();
        float floatValue = (l11 == null || (n11 = l11.n()) == null) ? 1.0f : n11.floatValue();
        if (l11 == null || intValue > intValue2 || floatValue >= this.U.l()) {
            return false;
        }
        return true;
    }

    public final void S() {
        b.b(b.f31751a, DocCapture.f31492c, "started waiting for better photo", (Throwable) null, 4, (Object) null);
        this.f31510r0 = System.currentTimeMillis();
        this.f31511s0 = true;
    }

    public final void T() {
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new d1(this, (kotlin.coroutines.c<? super d1>) null), 3, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new a0(this, (kotlin.coroutines.c<? super a0>) null), 3, (Object) null);
    }

    public Size t() {
        Size r11 = this.V.r();
        if (r11 != null) {
            if (!C()) {
                r11 = null;
            }
            if (r11 != null) {
                return r11;
            }
        }
        return super.t();
    }

    public CameraX.b v() {
        return new CameraX.b(this.W.j(), e.b(this.W.l()), e.b(this.W.k()), TimeUnit.SECONDS.toMillis((long) this.W.h()), ((long) this.W.i()) * 1048576);
    }

    public void x() {
        b.b(b.f31751a, DocCapture.f31492c, "onTakePictureClicked", (Throwable) null, 4, (Object) null);
        this.f31500h0 = true;
        if (G() == CameraX.Mode.PHOTO) {
            super.x();
        } else {
            this.f31504l0 = true;
        }
        a((a.j) new i(new r0(this)));
    }

    public final void g(boolean z11) {
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new e1(this, z11, (kotlin.coroutines.c<? super e1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.z
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.z) r2
            int r3 = r2.f31743f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31743f = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31741d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31743f
            java.lang.String r5 = " "
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0057
            if (r4 == r7) goto L_0x0047
            if (r4 != r6) goto L_0x003f
            java.lang.Object r3 = r2.f31740c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r4 = r2.f31739b
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            java.lang.Object r2 = r2.f31738a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.k) r2
            kotlin.k.b(r1)
            r9 = r2
            goto L_0x009e
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            java.lang.Object r4 = r2.f31740c
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            java.lang.Object r8 = r2.f31739b
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r8 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.k) r8
            java.lang.Object r9 = r2.f31738a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r1)
            goto L_0x0085
        L_0x0057:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$k
            java.io.File r4 = r0.f31496d0
            boolean r8 = r0.f31498f0
            r1.<init>(r4, r8)
            boolean r4 = r0.f31509q0
            if (r4 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r1 = 0
        L_0x0069:
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.a.a(r4)
            r2.f31738a = r0
            r2.f31739b = r1
            r2.f31740c = r4
            r2.f31743f = r7
            java.lang.String r8 = "sns_autocapture_action_auto"
            java.lang.Object r8 = r0.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r8 != r3) goto L_0x007f
            return r3
        L_0x007f:
            r9 = r0
            r16 = r8
            r8 = r1
            r1 = r16
        L_0x0085:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x008a
            r1 = r5
        L_0x008a:
            r2.f31738a = r8
            r2.f31739b = r4
            r2.f31740c = r1
            r2.f31743f = r6
            java.lang.String r6 = "sns_autocapture_action_manual"
            java.lang.Object r2 = r9.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x009b
            return r3
        L_0x009b:
            r3 = r1
            r1 = r2
            r9 = r8
        L_0x009e:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r5 = r1
        L_0x00a4:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.a.a(r7)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r10 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a
            r10.<init>(r4, r3, r5, r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 8
            r15 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.h(kotlin.coroutines.c):java.lang.Object");
    }

    public final Object i(kotlin.coroutines.c<? super Unit> cVar) {
        Object a11 = a((d10.a<Unit>) new v0(this), cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.c<? super kotlin.Unit> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.z0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z0 r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.z0) r2
            int r3 = r2.f31748e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31748e = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z0 r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$z0
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31746c
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31748e
            r5 = 0
            r6 = 2
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x004a
            if (r4 == r8) goto L_0x003e
            if (r4 != r6) goto L_0x0036
            java.lang.Object r2 = r2.f31744a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r1)
            goto L_0x0097
        L_0x0036:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003e:
            java.lang.Object r4 = r2.f31745b
            kotlinx.coroutines.flow.b1 r4 = (kotlinx.coroutines.flow.b1) r4
            java.lang.Object r9 = r2.f31744a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r1)
            goto L_0x005d
        L_0x004a:
            kotlin.k.b(r1)
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c> r4 = r0.f31503k0
            r2.f31744a = r0
            r2.f31745b = r4
            r2.f31748e = r8
            java.lang.Object r1 = r0.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c>) r2)
            if (r1 != r3) goto L_0x005c
            return r3
        L_0x005c:
            r9 = r0
        L_0x005d:
            r10 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r10 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r10
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 23
            r17 = 0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r10, r11, r12, r13, r14, r15, r16, r17)
            r4.setValue(r1)
            boolean r1 = r9.C()
            if (r1 == 0) goto L_0x0080
            com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture$PreferredMode r1 = r9.f31508p0
            com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture$PreferredMode r4 = com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture.PreferredMode.MANUAL
            if (r1 == r4) goto L_0x0080
            r9.T()
            goto L_0x0087
        L_0x0080:
            boolean r1 = r9.C()
            r9.g((boolean) r1)
        L_0x0087:
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r9.R
            r2.f31744a = r9
            r2.f31745b = r7
            r2.f31748e = r6
            java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.d(r1, r5, r2, r8, r7)
            if (r1 != r3) goto L_0x0096
            return r3
        L_0x0096:
            r2 = r9
        L_0x0097:
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            com.sumsub.sns.internal.core.data.model.DocumentType r3 = r2.u()
            java.util.List r1 = r1.b(r3)
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r1)
            com.sumsub.sns.internal.core.data.model.q r1 = (com.sumsub.sns.internal.core.data.model.q) r1
            com.sumsub.sns.internal.core.data.model.IdentitySide r3 = r2.q()
            com.sumsub.sns.internal.core.data.model.IdentitySide r4 = com.sumsub.sns.internal.core.data.model.IdentitySide.Back
            if (r3 != r4) goto L_0x00d6
            boolean r3 = r2.C()
            if (r3 == 0) goto L_0x00ba
            boolean r3 = r2.f31506n0
            if (r3 != 0) goto L_0x00ba
            r5 = r8
        L_0x00ba:
            r2.Z = r5
            boolean r3 = r2.C()
            if (r3 != 0) goto L_0x00d6
            boolean r3 = r2.f31506n0
            if (r3 != 0) goto L_0x00d6
            kotlinx.coroutines.h0 r8 = androidx.lifecycle.m0.a(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a1 r11 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a1
            r11.<init>(r2, r7)
            r9 = 0
            r10 = 0
            r12 = 3
            r13 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r8, r9, r10, r11, r12, r13)
        L_0x00d6:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r2 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SDK is using - "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = r3.toString()
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.j(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b1 r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b1) r0
            int r1 = r0.f31538h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31538h = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b1 r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f31536f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31538h
            java.lang.String r3 = ""
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 != r5) goto L_0x0044
            java.lang.Object r1 = r0.f31535e
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r0.f31534d
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r1
            java.lang.Object r2 = r0.f31533c
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r2
            java.lang.Object r6 = r0.f31532b
            kotlinx.coroutines.flow.b1 r6 = (kotlinx.coroutines.flow.b1) r6
            java.lang.Object r0 = r0.f31531a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r0
            kotlin.k.b(r15)
            r9 = r1
            r1 = r6
        L_0x0042:
            r6 = r2
            goto L_0x008b
        L_0x0044:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x004c:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "DocCapture"
            java.lang.String r8 = "showWaitPopup"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c> r6 = r14.f31503k0
            java.lang.Object r15 = r6.getValue()
            r2 = r15
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r2
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r15 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.DEFAULT
            r15.<init>(r3, r7)
            boolean r7 = r14.f31499g0
            if (r7 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r15 = r4
        L_0x0071:
            r0.f31531a = r14
            r0.f31532b = r6
            r0.f31533c = r2
            r0.f31534d = r15
            r0.f31535e = r3
            r0.f31538h = r5
            java.lang.String r7 = "sns_general_progress_text"
            java.lang.Object r0 = r14.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r9 = r15
            r15 = r0
            r1 = r6
            r0 = r14
            goto L_0x0042
        L_0x008b:
            r8 = 0
            r7 = 0
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L_0x0093
            java.lang.String r15 = " "
        L_0x0093:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d r10 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d
            r10.<init>(r3, r15, r5)
            r11 = 0
            r12 = 19
            r13 = 0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r15 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.setValue(r15)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c1 r15 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c1
            r15.<init>(r4)
            r1 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r1, r15, r5, r4)
            kotlin.Unit r15 = kotlin.Unit.f56620a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.k(kotlin.coroutines.c):java.lang.Object");
    }

    public final void f(boolean z11) {
        this.f31515w0 = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.c<? super kotlin.Unit> r19) {
        /*
            r18 = this;
            r6 = r18
            r0 = r19
            boolean r1 = r0 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.u
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$u r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.u) r1
            int r2 = r1.f31704g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f31704g = r2
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$u r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$u
            r1.<init>(r6, r0)
        L_0x001c:
            r10 = r1
            java.lang.Object r0 = r10.f31702e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r10.f31704g
            java.lang.String r3 = " "
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x006a
            if (r2 == r5) goto L_0x004f
            if (r2 != r4) goto L_0x0047
            java.lang.Object r1 = r10.f31701d
            kotlinx.coroutines.flow.b1 r1 = (kotlinx.coroutines.flow.b1) r1
            java.lang.Object r2 = r10.f31700c
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.d) r2
            java.lang.Object r4 = r10.f31699b
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r4
            java.lang.Object r7 = r10.f31698a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r7
            kotlin.k.b(r0)
            r11 = r2
            r2 = r7
            r7 = r4
            goto L_0x00ee
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004f:
            java.lang.Object r2 = r10.f31701d
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r7 = r10.f31700c
            kotlinx.coroutines.flow.b1 r7 = (kotlinx.coroutines.flow.b1) r7
            java.lang.Object r8 = r10.f31699b
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r8 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r8
            java.lang.Object r9 = r10.f31698a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r0)
            r12 = r2
            r2 = r7
            r17 = r9
            r9 = r8
            r8 = r17
            goto L_0x00b7
        L_0x006a:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r11 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "finishWithCurrentResults: isCapturingVideo="
            r0.append(r2)
            boolean r2 = r6.f31498f0
            r0.append(r2)
            java.lang.String r13 = r0.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r11, r12, r13, r14, r15, r16)
            boolean r0 = r6.f31498f0
            if (r0 == 0) goto L_0x011d
            r6.f31497e0 = r5
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c> r0 = r6.f31503k0
            java.lang.Object r2 = r0.getValue()
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r2
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r7 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.SUCCESS_CHECK
            java.lang.String r7 = r7.getImageName()
            r10.f31698a = r6
            r10.f31699b = r2
            r10.f31700c = r0
            r10.f31701d = r7
            r10.f31704g = r5
            java.lang.String r8 = "sns_instructions_hint_allSet"
            java.lang.Object r8 = r6.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r10)
            if (r8 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            r9 = r2
            r12 = r7
            r2 = r0
            r0 = r8
            r8 = r6
        L_0x00b7:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00bd
            r13 = r3
            goto L_0x00be
        L_0x00bd:
            r13 = r0
        L_0x00be:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d
            r14 = 0
            r15 = 4
            r16 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$a r7 = com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult.f31486d
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r11 = r7.a()
            r10.f31698a = r8
            r10.f31699b = r9
            r10.f31700c = r0
            r10.f31701d = r2
            r10.f31704g = r4
            r4 = 0
            r12 = 2
            r13 = 0
            r7 = r8
            r14 = r8
            r8 = r11
            r15 = r9
            r9 = r4
            r11 = r12
            r12 = r13
            java.lang.Object r4 = a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r7, (com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r8, (boolean) r9, (kotlin.coroutines.c) r10, (int) r11, (java.lang.Object) r12)
            if (r4 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            r11 = r0
            r1 = r2
            r0 = r4
            r2 = r14
            r7 = r15
        L_0x00ee:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r4 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.DEFAULT
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r10 = r0.a(r3, r4)
            r8 = 0
            r9 = 0
            r12 = 0
            r13 = 19
            r14 = 0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r0 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r7, r8, r9, r10, r11, r12, r13, r14)
            r1.setValue(r0)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$v r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$v
            r1 = 0
            r0.<init>(r1)
            r3 = 0
            com.sumsub.sns.core.presentation.base.a.a(r2, r3, r0, r5, r1)
            kotlinx.coroutines.h0 r7 = androidx.lifecycle.m0.a(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$w r10 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$w
            r10.<init>(r2, r1)
            r11 = 3
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r7, r8, r9, r10, r11, r12)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x011d:
            com.sumsub.sns.internal.core.data.model.l r2 = new com.sumsub.sns.internal.core.data.model.l
            java.util.List r0 = r18.H()
            r2.<init>(r0, r5)
            r1 = 0
            r3 = 0
            r4 = 5
            r5 = 0
            r0 = r18
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (com.sumsub.sns.internal.core.common.q) r1, (java.lang.Object) r2, (java.lang.Long) r3, (int) r4, (java.lang.Object) r5)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.g(kotlin.coroutines.c):java.lang.Object");
    }

    public final void c(boolean z11) {
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "onAutoEnabled: " + z11, (Throwable) null, 4, (Object) null);
        if (z11) {
            T();
        } else {
            g(true);
        }
    }

    public final void d(boolean z11) {
        this.f31502j0.a(this, B[2], Boolean.valueOf(z11));
    }

    public final void e(boolean z11) {
        this.f31501i0.a(this, B[1], Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super java.lang.Boolean> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.p
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$p r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.p) r0
            int r1 = r0.f31660d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31660d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$p r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$p
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f31658b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31660d
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            java.lang.Object r0 = r0.f31657a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r0
            kotlin.k.b(r13)
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0037:
            kotlin.k.b(r13)
            com.sumsub.sns.internal.core.data.source.dynamic.b r13 = r12.R
            r0.f31657a = r12
            r0.f31660d = r5
            java.lang.Object r13 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r13, r4, r0, r5, r3)
            if (r13 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r12
        L_0x0048:
            com.sumsub.sns.internal.core.data.source.dynamic.e r13 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r13
            java.lang.Object r13 = r13.c()
            com.sumsub.sns.internal.core.data.model.g r13 = (com.sumsub.sns.internal.core.data.model.g) r13
            if (r13 != 0) goto L_0x0057
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r4)
            return r13
        L_0x0057:
            com.sumsub.sns.internal.core.data.model.g$c r13 = r13.I()
            java.util.List r13 = r13.g()
            java.util.Iterator r13 = r13.iterator()
        L_0x0063:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x007f
            java.lang.Object r1 = r13.next()
            r2 = r1
            com.sumsub.sns.internal.core.data.model.g$c$a r2 = (com.sumsub.sns.internal.core.data.model.g.c.a) r2
            com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.m()
            com.sumsub.sns.internal.core.data.model.DocumentType r6 = r0.u()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r6)
            if (r2 == 0) goto L_0x0063
            goto L_0x0080
        L_0x007f:
            r1 = r3
        L_0x0080:
            com.sumsub.sns.internal.core.data.model.g$c$a r1 = (com.sumsub.sns.internal.core.data.model.g.c.a) r1
            if (r1 == 0) goto L_0x008c
            boolean r13 = r1.s()
            if (r13 != r5) goto L_0x008c
            r13 = r5
            goto L_0x008d
        L_0x008c:
            r13 = r4
        L_0x008d:
            if (r13 == 0) goto L_0x00a1
            java.lang.String r13 = r1.r()
            com.sumsub.sns.internal.core.data.model.VideoRequiredType r1 = com.sumsub.sns.internal.core.data.model.VideoRequiredType.DocCapture
            java.lang.String r1 = r1.getValue()
            boolean r13 = kotlin.jvm.internal.x.b(r13, r1)
            if (r13 == 0) goto L_0x00a1
            r13 = r5
            goto L_0x00a2
        L_0x00a1:
            r13 = r4
        L_0x00a2:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkAutoCaptureAllowedForStep: auto capture ff.enabled="
            r1.append(r2)
            boolean r2 = r0.D()
            r1.append(r2)
            java.lang.String r2 = ", level.autoEnabled="
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = ", seamlessDocapture.enabled="
            r1.append(r2)
            boolean r2 = r0.f31509q0
            r1.append(r2)
            java.lang.String r2 = ", preferredMode="
            r1.append(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture$PreferredMode r2 = r0.f31508p0
            if (r2 == 0) goto L_0x00d4
            java.lang.String r3 = r2.getValue()
        L_0x00d4:
            r1.append(r3)
            java.lang.String r2 = ", isRetake="
            r1.append(r2)
            boolean r2 = r0.f31506n0
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
            r0.b((boolean) r4)
            boolean r0 = r0.D()
            if (r0 == 0) goto L_0x00f9
            if (r13 == 0) goto L_0x00f9
            r4 = r5
        L_0x00f9:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r4)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.f(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.o0
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o0 r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.o0) r0
            int r1 = r0.f31656e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31656e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o0 r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o0
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f31654c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31656e
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r6) goto L_0x004c
            if (r2 == r5) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r0 = r0.f31652a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r0
            kotlin.k.b(r14)
            goto L_0x00c0
        L_0x0035:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x003d:
            java.lang.Object r2 = r0.f31653b
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            java.lang.Object r5 = r0.f31652a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r5 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r5
            kotlin.k.b(r14)
            r12 = r5
            r5 = r2
            r2 = r12
            goto L_0x00a9
        L_0x004c:
            java.lang.Object r2 = r0.f31652a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r14)
            goto L_0x0063
        L_0x0054:
            kotlin.k.b(r14)
            r0.f31652a = r13
            r0.f31656e = r6
            java.lang.Object r14 = super.d(r0)
            if (r14 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r2 = r13
        L_0x0063:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r6 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r7 = "onPrepare: docType: "
            r14.append(r7)
            com.sumsub.sns.internal.core.data.model.DocumentType r7 = r2.u()
            r14.append(r7)
            java.lang.String r7 = ", idType: "
            r14.append(r7)
            java.lang.String r7 = r2.s()
            r14.append(r7)
            java.lang.String r7 = ", sides: "
            r14.append(r7)
            java.util.List<com.sumsub.sns.internal.core.data.model.IdentitySide> r7 = r2.f31507o0
            r14.append(r7)
            java.lang.String r8 = r14.toString()
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r7 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r6, r7, r8, r9, r10, r11)
            r2.Q()
            r0.f31652a = r2
            r0.f31653b = r2
            r0.f31656e = r5
            java.lang.Object r14 = r2.f((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
            if (r14 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            r5 = r2
        L_0x00a9:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            r5.d((boolean) r14)
            r0.f31652a = r2
            r0.f31653b = r3
            r0.f31656e = r4
            java.lang.Object r14 = r2.k((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r14 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            r0 = r2
        L_0x00c0:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$p0 r14 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$p0
            r14.<init>(r0, r3)
            r0.a((d10.l<? super kotlin.coroutines.c<? super kotlin.Unit>, ? extends java.lang.Object>) r14)
            kotlin.Unit r14 = kotlin.Unit.f56620a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.d(kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(File file) {
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "onVideoRecordingStarted: " + file, (Throwable) null, 4, (Object) null);
        this.X = false;
        this.f31498f0 = true;
        n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new u0(this, (kotlin.coroutines.c<? super u0>) null), 3, (Object) null);
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        Object c11 = oVar.c();
        f fVar = c11 instanceof f ? (f) c11 : null;
        if (fVar != null) {
            a(fVar);
        } else {
            super.b(oVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r19, android.graphics.Bitmap r20, kotlin.coroutines.c<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.q0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q0 r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.q0) r2
            int r3 = r2.f31672f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31672f = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q0 r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q0
            r2.<init>(r0, r1)
        L_0x001c:
            r8 = r2
            java.lang.Object r1 = r8.f31670d
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r8.f31672f
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            r9 = 0
            if (r3 == 0) goto L_0x0066
            if (r3 == r6) goto L_0x0050
            if (r3 == r5) goto L_0x003f
            if (r3 != r4) goto L_0x0037
            kotlin.k.b(r1)
            goto L_0x00e2
        L_0x0037:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003f:
            java.lang.Object r3 = r8.f31669c
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            java.lang.Object r5 = r8.f31668b
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r6 = r8.f31667a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r6 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r6
            kotlin.k.b(r1)
            goto L_0x00c7
        L_0x0050:
            java.lang.Object r3 = r8.f31669c
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            java.lang.Object r6 = r8.f31668b
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r10 = r8.f31667a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r10 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r10
            kotlin.k.b(r1)
            r17 = r10
            r10 = r3
            r3 = r6
            r6 = r17
            goto L_0x00a7
        L_0x0066:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r11 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "onRequestedPictureTaken: waiting="
            r1.append(r3)
            boolean r3 = r0.f31500h0
            r1.append(r3)
            java.lang.String r13 = r1.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r11, r12, r13, r14, r15, r16)
            r0.f31504l0 = r9
            boolean r1 = r0.f31500h0
            if (r1 == 0) goto L_0x00a2
            kotlinx.coroutines.channels.d<kotlin.Unit> r1 = r0.f31514v0
            r8.f31667a = r0
            r3 = r19
            r8.f31668b = r3
            r10 = r20
            r8.f31669c = r10
            r8.f31672f = r6
            java.lang.Object r1 = r1.J(r8)
            if (r1 != r2) goto L_0x00a6
            return r2
        L_0x00a2:
            r3 = r19
            r10 = r20
        L_0x00a6:
            r6 = r0
        L_0x00a7:
            boolean r1 = r6.f31509q0
            if (r1 != 0) goto L_0x00b6
            boolean r1 = r6.C()
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b6
        L_0x00b2:
            r5 = r3
            r3 = r6
            r1 = r7
            goto L_0x00cb
        L_0x00b6:
            r8.f31667a = r6
            r8.f31668b = r3
            r8.f31669c = r10
            r8.f31672f = r5
            java.lang.Object r1 = r6.a((android.graphics.Bitmap) r10, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b>) r8)
            if (r1 != r2) goto L_0x00c5
            return r2
        L_0x00c5:
            r5 = r3
            r3 = r10
        L_0x00c7:
            com.sumsub.sns.internal.ml.badphotos.models.b r1 = (com.sumsub.sns.internal.ml.badphotos.models.b) r1
            r10 = r3
            r3 = r6
        L_0x00cb:
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r9, r9, r9, r9)
            r8.f31667a = r7
            r8.f31668b = r7
            r8.f31669c = r7
            r8.f31672f = r4
            r4 = r5
            r5 = r10
            r7 = r1
            java.lang.Object r1 = r3.a((android.content.Context) r4, (android.graphics.Bitmap) r5, (android.graphics.Rect) r6, (com.sumsub.sns.internal.ml.badphotos.models.b) r7, (kotlin.coroutines.c<? super kotlin.Unit>) r8)
            if (r1 != r2) goto L_0x00e2
            return r2
        L_0x00e2:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b(android.content.Context, android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(List<com.sumsub.sns.internal.core.data.model.n> list) {
        this.Y.a(this, B[0], list);
    }

    public final void a(com.sumsub.sns.internal.ff.core.a aVar) {
        this.f31494b0 = aVar;
    }

    public final void a(f fVar) {
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "handleVideoRecordError: " + fVar, (Throwable) null, 4, (Object) null);
        a((a.j) g.f31597a);
    }

    public final void a(CameraX.c cVar) {
        File c11 = cVar.c();
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "video recording stopped. isWaitingForVideo=" + this.f31497e0 + ", " + c11, (Throwable) null, 4, (Object) null);
        this.f31498f0 = false;
        this.X = false;
        this.f31496d0 = null;
        CameraX.c.a d11 = cVar.d();
        boolean z11 = d11 instanceof CameraX.c.a.C0371a;
        if (z11) {
            bVar.b(DocCapture.f31492c, "onVideoRecordingFinalized: " + d11, ((CameraX.c.a.C0371a) d11).c());
        }
        if (!this.f31497e0) {
            b.b(bVar, DocCapture.f31492c, "onVideoRecorded: removing video file", (Throwable) null, 4, (Object) null);
            c11.delete();
            if (z11) {
                n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new s0(this, d11, (kotlin.coroutines.c<? super s0>) null), 3, (Object) null);
                return;
            }
            return;
        }
        this.f31497e0 = false;
        CameraX.c.a.b bVar2 = d11 instanceof CameraX.c.a.b ? (CameraX.c.a.b) d11 : null;
        if (bVar2 != null) {
            List L0 = CollectionsKt___CollectionsKt.L0(H());
            L0.add(new com.sumsub.sns.internal.core.data.model.n(c11, c11, (String) null, DocCapture.f31491b, (IdentitySide) null, false, (com.sumsub.sns.internal.ml.badphotos.models.b) null, new n.b(bVar2.c(), bVar2.d()), false, 356, (kotlin.jvm.internal.r) null));
            a((List<com.sumsub.sns.internal.core.data.model.n>) L0);
            n1 unused2 = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new t0(this, (kotlin.coroutines.c<? super t0>) null), 3, (Object) null);
        }
    }

    public final void b(Context context) {
        if (this.f31509q0 && this.f31496d0 == null) {
            this.X = true;
            a(context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r11, kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.i0
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$i0 r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.i0) r0
            int r1 = r0.f31628e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31628e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$i0 r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$i0
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f31626c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31628e
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r6) goto L_0x004a
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r11 = r0.f31624a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r11
            kotlin.k.b(r12)
            goto L_0x0097
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003c:
            java.lang.Object r11 = r0.f31624a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r11
            kotlin.k.b(r12)
            kotlinx.coroutines.channels.ChannelResult r12 = (kotlinx.coroutines.channels.ChannelResult) r12
            java.lang.Object r12 = r12.l()
            goto L_0x0080
        L_0x004a:
            java.lang.Object r11 = r0.f31625b
            android.content.Context r11 = (android.content.Context) r11
            java.lang.Object r2 = r0.f31624a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r12)
            goto L_0x006d
        L_0x0056:
            kotlin.k.b(r12)
            r10.f31518z0 = r6
            boolean r12 = r10.f31498f0
            if (r12 != 0) goto L_0x0096
            r0.f31624a = r10
            r0.f31625b = r11
            r0.f31628e = r6
            java.lang.Object r12 = r10.k((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r2 = r10
        L_0x006d:
            r2.b((android.content.Context) r11)
            kotlinx.coroutines.channels.d<kotlin.Unit> r11 = r2.f31513u0
            r0.f31624a = r2
            r0.f31625b = r3
            r0.f31628e = r5
            java.lang.Object r12 = r11.t(r0)
            if (r12 != r1) goto L_0x007f
            return r1
        L_0x007f:
            r11 = r2
        L_0x0080:
            boolean r12 = kotlinx.coroutines.channels.ChannelResult.i(r12)
            if (r12 == 0) goto L_0x0089
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        L_0x0089:
            r0.f31624a = r11
            r0.f31628e = r4
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r12 != r1) goto L_0x0097
            return r1
        L_0x0096:
            r11 = r10
        L_0x0097:
            kotlinx.coroutines.h0 r4 = androidx.lifecycle.m0.a(r11)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$j0 r7 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$j0
            r7.<init>(r11, r3)
            r5 = 0
            r6 = 0
            r8 = 3
            r9 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(f fVar) {
        a.d dVar;
        f fVar2 = fVar;
        if (fVar2 != null) {
            b.b(b.f31751a, DocCapture.f31492c, "stopVideoRecording with error: " + fVar2, (Throwable) null, 4, (Object) null);
        }
        kotlinx.coroutines.flow.b1<c> b1Var = this.f31503k0;
        c value = b1Var.getValue();
        k kVar = new k((File) null, false);
        if (fVar2 != null) {
            dVar = new a.d(new o.d((Throwable) null, fVar, new o.a(fVar.a(), (String) null, (String) null, 6, (kotlin.jvm.internal.r) null), 1, (kotlin.jvm.internal.r) null), u().c(), (CharSequence) null);
        } else {
            dVar = null;
        }
        b1Var.setValue(c.a(value, kVar, (c.a) null, (AutoCaptureHint) null, (d) null, dVar, 6, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r11 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ac, code lost:
        if (r11 != null) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.domain.camera.CameraX.c.a.C0371a r10, kotlin.coroutines.c<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.x
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$x r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.x) r0
            int r1 = r0.f31727e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31727e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$x r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$x
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f31725c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31727e
            r3 = 1
            java.lang.String r4 = " "
            r5 = 3
            r6 = 2
            if (r2 == 0) goto L_0x0052
            if (r2 == r3) goto L_0x0046
            if (r2 == r6) goto L_0x003e
            if (r2 != r5) goto L_0x0036
            java.lang.Object r10 = r0.f31723a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r10 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r10
            kotlin.k.b(r11)
            goto L_0x00aa
        L_0x0036:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003e:
            java.lang.Object r10 = r0.f31723a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r10 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r10
            kotlin.k.b(r11)
            goto L_0x0081
        L_0x0046:
            java.lang.Object r10 = r0.f31724b
            com.sumsub.sns.internal.core.domain.camera.CameraX$c$a$a r10 = (com.sumsub.sns.internal.core.domain.camera.CameraX.c.a.C0371a) r10
            java.lang.Object r2 = r0.f31723a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r11)
            goto L_0x0065
        L_0x0052:
            kotlin.k.b(r11)
            r0.f31723a = r9
            r0.f31724b = r10
            r0.f31727e = r3
            java.lang.String r11 = "sns_seamless_error_general"
            java.lang.Object r11 = r9.a((java.lang.String) r11, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r11 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r9
        L_0x0065:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x006a
            r11 = r4
        L_0x006a:
            int r3 = r10.d()
            r7 = 0
            if (r3 != r5) goto L_0x0089
            r0.f31723a = r2
            r0.f31724b = r7
            r0.f31727e = r6
            java.lang.String r10 = "sns_seamless_error_notEnoughStorage"
            java.lang.Object r11 = r2.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r11 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r10 = r2
        L_0x0081:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x0087
        L_0x0085:
            r2 = r10
            goto L_0x00af
        L_0x0087:
            r2 = r10
            goto L_0x0098
        L_0x0089:
            int r3 = r10.d()
            r8 = 9
            if (r3 == r8) goto L_0x009a
            int r10 = r10.d()
            if (r10 != r6) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r4 = r11
            goto L_0x00af
        L_0x009a:
            r0.f31723a = r2
            r0.f31724b = r7
            r0.f31727e = r5
            java.lang.String r10 = "sns_seamless_error_timeExceeded"
            java.lang.Object r11 = r2.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r11 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r10 = r2
        L_0x00aa:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x0087
            goto L_0x0085
        L_0x00af:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$f$a r10 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$f$a
            r10.<init>(r4)
            r2.b((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.f) r10)
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(com.sumsub.sns.internal.core.domain.camera.CameraX$c$a$a, kotlin.coroutines.c):java.lang.Object");
    }

    public final n1 a(d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object> lVar) {
        return kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new y(this, lVar, (kotlin.coroutines.c<? super y>) null), 3, (Object) null);
    }

    public void a(File file) {
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "onPictureTaken: waiting=" + this.f31500h0, (Throwable) null, 4, (Object) null);
        if (this.f31500h0) {
            n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k0(this, file, (kotlin.coroutines.c<? super k0>) null), 3, (Object) null);
        } else {
            super.a(file);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x02c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0230  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r28, android.graphics.Bitmap r29, android.graphics.Rect r30, kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult> r31) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r31
            boolean r4 = r3 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.f0
            if (r4 == 0) goto L_0x001b
            r4 = r3
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$f0 r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.f0) r4
            int r5 = r4.f31585k
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f31585k = r5
            goto L_0x0020
        L_0x001b:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$f0 r4 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$f0
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f31583i
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r6 = r4.f31585k
            java.lang.String r7 = " ms"
            r8 = 5
            r9 = 4
            r10 = 3
            r11 = 2
            r12 = 0
            r13 = 1
            r14 = 0
            if (r6 == 0) goto L_0x00a5
            if (r6 == r13) goto L_0x009d
            if (r6 == r11) goto L_0x007e
            if (r6 == r10) goto L_0x0064
            if (r6 == r9) goto L_0x004e
            if (r6 != r8) goto L_0x0046
            java.lang.Object r1 = r4.f31575a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult) r1
            kotlin.k.b(r3)
            goto L_0x02c9
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            java.lang.Object r1 = r4.f31578d
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1
            java.lang.Object r2 = r4.f31577c
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult) r2
            java.lang.Object r6 = r4.f31576b
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r6 = (com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r6
            java.lang.Object r7 = r4.f31575a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r7
            kotlin.k.b(r3)
            r8 = r2
            goto L_0x02b2
        L_0x0064:
            int r1 = r4.f31582h
            int r2 = r4.f31581g
            java.lang.Object r6 = r4.f31578d
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r6 = (com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r6
            java.lang.Object r10 = r4.f31577c
            android.graphics.Rect r10 = (android.graphics.Rect) r10
            java.lang.Object r11 = r4.f31576b
            android.content.Context r11 = (android.content.Context) r11
            java.lang.Object r15 = r4.f31575a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r15 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r15
            kotlin.k.b(r3)
            r12 = r13
            goto L_0x0201
        L_0x007e:
            long r1 = r4.f31580f
            boolean r6 = r4.f31579e
            java.lang.Object r11 = r4.f31578d
            android.graphics.Rect r11 = (android.graphics.Rect) r11
            java.lang.Object r15 = r4.f31577c
            android.graphics.Bitmap r15 = (android.graphics.Bitmap) r15
            java.lang.Object r8 = r4.f31576b
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r9 = r4.f31575a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r3)
            r25 = r1
            r1 = r8
            r2 = r9
            r8 = r25
            goto L_0x015b
        L_0x009d:
            java.lang.Object r1 = r4.f31575a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r1 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r1
            kotlin.k.b(r3)
            goto L_0x00e7
        L_0x00a5:
            kotlin.k.b(r3)
            boolean r3 = r0.Z
            if (r3 == 0) goto L_0x00c4
            r0.Z = r14
            kotlinx.coroutines.h0 r16 = androidx.lifecycle.m0.a(r27)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$g0 r3 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$g0
            r3.<init>(r0, r12)
            r17 = 0
            r18 = 0
            r20 = 3
            r21 = 0
            r19 = r3
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r16, r17, r18, r19, r20, r21)
        L_0x00c4:
            boolean r3 = r0.X
            if (r3 == 0) goto L_0x00cb
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        L_0x00cb:
            boolean r3 = r0.f31518z0
            if (r3 == 0) goto L_0x00d7
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            r0.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        L_0x00d7:
            boolean r3 = r0.f31504l0
            if (r3 == 0) goto L_0x00ef
            r4.f31575a = r0
            r4.f31585k = r13
            java.lang.Object r1 = r0.b((android.content.Context) r1, (android.graphics.Bitmap) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r4)
            if (r1 != r5) goto L_0x00e6
            return r5
        L_0x00e6:
            r1 = r0
        L_0x00e7:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r2 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.CAPTURED
            r1.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        L_0x00ef:
            kotlinx.coroutines.flow.j1 r3 = r27.K()
            java.lang.Object r3 = r3.getValue()
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r3 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r3
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c$a r3 = r3.i()
            java.lang.Boolean r3 = r3.e()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r13)
            boolean r3 = kotlin.jvm.internal.x.b(r3, r6)
            if (r3 != 0) goto L_0x0113
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            r0.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        L_0x0113:
            com.sumsub.sns.internal.ml.docdetector.b r3 = r0.T
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x0126
            r0.g((boolean) r14)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            r0.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        L_0x0126:
            boolean r3 = r0.f31518z0
            if (r3 != 0) goto L_0x02ca
            boolean r3 = r0.f31497e0
            if (r3 == 0) goto L_0x0130
            goto L_0x02ca
        L_0x0130:
            boolean r6 = r0.f31515w0
            r0.f31515w0 = r14
            long r8 = java.lang.System.currentTimeMillis()
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.v0.a()
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$h0 r15 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$h0
            r15.<init>(r0, r2, r6, r12)
            r4.f31575a = r0
            r4.f31576b = r1
            r4.f31577c = r2
            r12 = r30
            r4.f31578d = r12
            r4.f31579e = r6
            r4.f31580f = r8
            r4.f31585k = r11
            java.lang.Object r3 = kotlinx.coroutines.g.g(r3, r15, r4)
            if (r3 != r5) goto L_0x0158
            return r5
        L_0x0158:
            r15 = r2
            r11 = r12
            r2 = r0
        L_0x015b:
            com.sumsub.sns.internal.ml.docdetector.a r3 = (com.sumsub.sns.internal.ml.docdetector.a) r3
            if (r3 == 0) goto L_0x0193
            int r12 = r15.getWidth()
            float r12 = (float) r12
            com.sumsub.sns.internal.ml.docdetector.b r14 = r2.T
            android.util.Size r14 = r14.l()
            int r14 = r14.getWidth()
            float r14 = (float) r14
            float r12 = r12 / r14
            int r14 = r15.getHeight()
            float r14 = (float) r14
            com.sumsub.sns.internal.ml.docdetector.b r10 = r2.T
            android.util.Size r10 = r10.l()
            int r10 = r10.getHeight()
            float r10 = (float) r10
            float r14 = r14 / r10
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r10 = r2.a((float) r12, (float) r14, (android.graphics.Rect) r11, (com.sumsub.sns.internal.ml.docdetector.a) r3)
            if (r6 == 0) goto L_0x0194
            android.graphics.Rect r13 = r3.m()
            android.graphics.Rect r12 = com.sumsub.sns.internal.camera.photo.presentation.document.c.a(r13, r12, r14)
            r2.a((android.content.Context) r1, (android.graphics.Bitmap) r15, (android.graphics.Rect) r12, (android.graphics.Rect) r11)
            goto L_0x0194
        L_0x0193:
            r10 = 0
        L_0x0194:
            r2.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r10, (com.sumsub.sns.internal.ml.docdetector.a) r3, (boolean) r6, (android.graphics.Bitmap) r15)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r3 = r2.f31517y0
            if (r3 == 0) goto L_0x019d
            r3 = 1
            goto L_0x019e
        L_0x019d:
            r3 = 0
        L_0x019e:
            if (r10 == 0) goto L_0x01a9
            boolean r6 = r10.e()
            r12 = 1
            if (r6 != r12) goto L_0x01aa
            r6 = r12
            goto L_0x01ab
        L_0x01a9:
            r12 = 1
        L_0x01aa:
            r6 = 0
        L_0x01ab:
            if (r6 == 0) goto L_0x01b7
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$SizeCheckResult r6 = r10.f()
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$SizeCheckResult r13 = com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult.SizeCheckResult.OK
            if (r6 != r13) goto L_0x01b7
            r6 = r12
            goto L_0x01b8
        L_0x01b7:
            r6 = 0
        L_0x01b8:
            if (r6 == 0) goto L_0x020f
            com.sumsub.sns.internal.camera.photo.presentation.document.b r19 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "docDetector took "
            r13.append(r14)
            long r20 = java.lang.System.currentTimeMillis()
            long r8 = r20 - r8
            r13.append(r8)
            r13.append(r7)
            java.lang.String r21 = r13.toString()
            r22 = 0
            r23 = 4
            r24 = 0
            java.lang.String r20 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r19, r20, r21, r22, r23, r24)
            r4.f31575a = r2
            r4.f31576b = r1
            r4.f31577c = r11
            r4.f31578d = r10
            r4.f31581g = r3
            r4.f31582h = r6
            r8 = 3
            r4.f31585k = r8
            java.lang.Object r8 = r2.a((android.content.Context) r1, (android.graphics.Bitmap) r15, (kotlin.coroutines.c<? super java.lang.Boolean>) r4)
            if (r8 != r5) goto L_0x01f7
            return r5
        L_0x01f7:
            r15 = r2
            r2 = r3
            r3 = r8
            r25 = r11
            r11 = r1
            r1 = r6
            r6 = r10
            r10 = r25
        L_0x0201:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r25 = r6
            r6 = r1
            r1 = r11
            r11 = r10
            r10 = r25
            goto L_0x0225
        L_0x020f:
            r8 = 0
            r2.f31511s0 = r8
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r8 = r2.f31517y0
            if (r8 == 0) goto L_0x021f
            android.graphics.Bitmap r8 = r8.c()
            if (r8 == 0) goto L_0x021f
            r8.recycle()
        L_0x021f:
            r8 = 0
            r2.f31517y0 = r8
            r15 = r2
            r2 = r3
            r3 = 0
        L_0x0225:
            if (r3 == 0) goto L_0x022a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r8 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.TAKEN
            goto L_0x022c
        L_0x022a:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r8 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
        L_0x022c:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r9 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            if (r6 == 0) goto L_0x02af
            if (r3 == 0) goto L_0x023c
            if (r2 != 0) goto L_0x023c
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r2 = r15.f31512t0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r3 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.FOCUSING
            if (r2 != r3) goto L_0x023c
            r2 = r12
            goto L_0x023d
        L_0x023c:
            r2 = 0
        L_0x023d:
            boolean r3 = r15.f31511s0
            if (r3 == 0) goto L_0x0243
            if (r2 == 0) goto L_0x0246
        L_0x0243:
            r15.S()
        L_0x0246:
            long r2 = java.lang.System.currentTimeMillis()
            long r13 = r15.f31510r0
            long r2 = r2 - r13
            boolean r6 = r15.f31511s0
            if (r6 == 0) goto L_0x025d
            com.sumsub.sns.internal.ml.autocapture.a r6 = r15.V
            long r13 = r6.x()
            int r6 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x025d
            r13 = r12
            goto L_0x025e
        L_0x025d:
            r13 = 0
        L_0x025e:
            if (r13 == 0) goto L_0x02a7
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r6 = r15.f31512t0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r9 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.FOCUSING
            if (r6 == r9) goto L_0x02a7
            r6 = 0
            r15.f31511s0 = r6
            com.sumsub.sns.internal.camera.photo.presentation.document.b r17 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = "timeout waiting for better photo after: "
            r6.append(r12)
            r6.append(r2)
            r6.append(r7)
            java.lang.String r19 = r6.toString()
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r18 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r17, r18, r19, r20, r21, r22)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r2 = r15.f31517y0
            if (r2 == 0) goto L_0x02af
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r3 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.CAPTURED
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r6 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            r4.f31575a = r15
            r4.f31576b = r10
            r4.f31577c = r6
            r4.f31578d = r3
            r7 = 4
            r4.f31585k = r7
            java.lang.Object r1 = r15.a((android.content.Context) r1, (android.graphics.Rect) r11, (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r4)
            if (r1 != r5) goto L_0x02a4
            return r5
        L_0x02a4:
            r1 = r3
            r8 = r6
            goto L_0x02b0
        L_0x02a7:
            if (r13 == 0) goto L_0x02ac
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.FOCUSING
            goto L_0x02b0
        L_0x02ac:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.WAITING
            goto L_0x02b0
        L_0x02af:
            r1 = r9
        L_0x02b0:
            r6 = r10
            r7 = r15
        L_0x02b2:
            r7.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1)
            r4.f31575a = r8
            r2 = 0
            r4.f31576b = r2
            r4.f31577c = r2
            r4.f31578d = r2
            r2 = 5
            r4.f31585k = r2
            java.lang.Object r1 = r7.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r6, (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r4)
            if (r1 != r5) goto L_0x02c8
            return r5
        L_0x02c8:
            r1 = r8
        L_0x02c9:
            return r1
        L_0x02ca:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            r0.a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult) r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$FrameHandleResult r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.FrameHandleResult.RELEASED
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.content.Context, android.graphics.Bitmap, android.graphics.Rect, kotlin.coroutines.c):java.lang.Object");
    }

    public void a(Context context, String str, Uri uri) {
        if (this.f31499g0 || (this.f31509q0 && C())) {
            b.b(b.f31751a, DocCapture.f31492c, "Gallery picking NOT allowed here!!", (Throwable) null, 4, (Object) null);
            com.sumsub.sns.internal.log.a.f34862a.w(DocCapture.f31492c, "Gallery picking NOT allowed here!!", new RuntimeException("Gallery picking NOT allowed here!!"));
            if (!(!com.sumsub.sns.internal.core.common.e0.f32018a.isDebug())) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        super.a(context, str, uri);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r9, com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult r10, kotlin.coroutines.c<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.h1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$h1 r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.h1) r0
            int r1 = r0.f31622d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31622d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$h1 r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$h1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f31620b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31622d
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r6) goto L_0x004f
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r9 = r0.f31619a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r11)
            goto L_0x00a9
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            java.lang.Object r9 = r0.f31619a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r11)
            goto L_0x0096
        L_0x0047:
            java.lang.Object r9 = r0.f31619a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r11)
            goto L_0x0083
        L_0x004f:
            java.lang.Object r9 = r0.f31619a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r9 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r9
            kotlin.k.b(r11)
            goto L_0x006f
        L_0x0057:
            kotlin.k.b(r11)
            r11 = 0
            if (r9 != 0) goto L_0x0073
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$a r9 = com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult.f31486d
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r9 = r9.a()
            r0.f31619a = r8
            r0.f31622d = r6
            java.lang.Object r11 = r8.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r9, (boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint>) r0)
            if (r11 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r9 = r8
        L_0x006f:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r11
        L_0x0071:
            r3 = r11
            goto L_0x00af
        L_0x0073:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r2 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.SKIPPED
            if (r10 != r2) goto L_0x0086
            r0.f31619a = r8
            r0.f31622d = r5
            java.lang.Object r11 = r8.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r9, (boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint>) r0)
            if (r11 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r9 = r8
        L_0x0083:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r11
            goto L_0x0071
        L_0x0086:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r2 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.FOCUSING
            if (r10 != r2) goto L_0x0099
            r0.f31619a = r8
            r0.f31622d = r4
            java.lang.Object r11 = r8.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r9, (boolean) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint>) r0)
            if (r11 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r9 = r8
        L_0x0096:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r11
            goto L_0x0071
        L_0x0099:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult r2 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.PhotoCheckResult.WAITING
            if (r10 != r2) goto L_0x00ac
            r0.f31619a = r8
            r0.f31622d = r3
            java.lang.Object r11 = r8.a((com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult) r9, (boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint>) r0)
            if (r11 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            r9 = r8
        L_0x00a9:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r11 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r11
            goto L_0x0071
        L_0x00ac:
            r11 = 0
            r9 = r8
            goto L_0x0071
        L_0x00af:
            if (r3 == 0) goto L_0x00c8
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c> r9 = r9.f31503k0
            java.lang.Object r10 = r9.getValue()
            r0 = r10
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r0
            r1 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 27
            r7 = 0
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r10 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r0, r1, r2, r3, r4, r5, r6, r7)
            r9.setValue(r10)
        L_0x00c8:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult, com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$PhotoCheckResult, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object a(Context context, Rect rect, a aVar, kotlin.coroutines.c<? super Unit> cVar) {
        kotlinx.coroutines.channels.d b11 = kotlinx.coroutines.channels.f.b(0, (BufferOverflow) null, (d10.l) null, 7, (Object) null);
        a((a.j) new i(new f1(this, context, aVar, rect, b11)));
        Object J2 = b11.J(cVar);
        return J2 == IntrinsicsKt__IntrinsicsKt.d() ? J2 : Unit.f56620a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r1 = r11.n();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r9, android.graphics.Bitmap r10, kotlin.coroutines.c<? super java.lang.Boolean> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.t
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$t r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.t) r0
            int r1 = r0.f31695f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31695f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$t r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$t
            r0.<init>(r8, r11)
        L_0x0018:
            r4 = r0
            java.lang.Object r11 = r4.f31693d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f31695f
            r7 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 != r7) goto L_0x0037
            java.lang.Object r9 = r4.f31692c
            r10 = r9
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            java.lang.Object r9 = r4.f31691b
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r0 = r4.f31690a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r0
            kotlin.k.b(r11)
            goto L_0x0057
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            kotlin.k.b(r11)
            r4.f31690a = r8
            r4.f31691b = r9
            r4.f31692c = r10
            r4.f31695f = r7
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r8
            r2 = r10
            java.lang.Object r11 = a((com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r1, (android.graphics.Bitmap) r2, (boolean) r3, (kotlin.coroutines.c) r4, (int) r5, (java.lang.Object) r6)
            if (r11 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r0 = r8
        L_0x0057:
            com.sumsub.sns.internal.ml.badphotos.models.b r11 = (com.sumsub.sns.internal.ml.badphotos.models.b) r11
            if (r11 == 0) goto L_0x0066
            java.lang.Float r1 = r11.n()
            if (r1 == 0) goto L_0x0066
            float r1 = r1.floatValue()
            goto L_0x0068
        L_0x0066:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0068:
            com.sumsub.sns.internal.ml.badphotos.c r2 = r0.U
            float r2 = r2.k()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 0
            if (r1 < 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r7 = r2
        L_0x0075:
            if (r7 == 0) goto L_0x0082
            if (r11 == 0) goto L_0x0082
            boolean r9 = r0.a((android.content.Context) r9, (android.graphics.Bitmap) r10, (com.sumsub.sns.internal.ml.badphotos.models.b) r11)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r9
        L_0x0082:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.content.Context, android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }

    public final PhotoCheckResult a(PhotoCheckResult photoCheckResult) {
        if (photoCheckResult != this.f31512t0) {
            b bVar = b.f31751a;
            b.b(bVar, DocCapture.f31492c, "requestFrameCheckResultUpdate: -> " + photoCheckResult, (Throwable) null, 4, (Object) null);
        }
        this.f31512t0 = photoCheckResult;
        return photoCheckResult;
    }

    public final void a(CheckDetectionResult checkDetectionResult, com.sumsub.sns.internal.ml.docdetector.a aVar, boolean z11, Bitmap bitmap) {
        if (checkDetectionResult != null && aVar != null) {
            a.j a11 = a(checkDetectionResult, aVar, bitmap, z11);
            if (a11 != null) {
                a(a11);
            }
        } else if (this.A0) {
            a(N());
        }
    }

    public final a.j a(CheckDetectionResult checkDetectionResult, com.sumsub.sns.internal.ml.docdetector.a aVar, Bitmap bitmap, boolean z11) {
        if (!checkDetectionResult.e()) {
            this.f31516x0 = Long.MIN_VALUE;
        }
        if (!this.A0 && com.sumsub.sns.internal.core.common.e0.f32018a.isDebug()) {
            b bVar = b.f31751a;
            b.b(bVar, DocCapture.f31492c, "started tracking document bounds: " + aVar, (Throwable) null, 4, (Object) null);
        }
        if (z11) {
            b bVar2 = b.f31751a;
            b.b(bVar2, DocCapture.f31492c, "detected bounds " + aVar, (Throwable) null, 4, (Object) null);
        }
        this.A0 = true;
        if (!this.V.w()) {
            return null;
        }
        return new h(new Size(bitmap.getWidth(), bitmap.getHeight()), new Size(this.T.l().getWidth(), this.T.l().getHeight()), aVar, checkDetectionResult.e(), this.V.w(), z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r19, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b> r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.q
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.q) r2
            int r3 = r2.f31666d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31666d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$q
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31664b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31666d
            r5 = 1
            if (r4 == 0) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            java.lang.Object r2 = r2.f31663a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r1)
            goto L_0x004a
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            kotlin.k.b(r1)
            r2.f31663a = r0
            r2.f31666d = r5
            r1 = r19
            java.lang.Object r1 = r0.a((android.graphics.Bitmap) r1, (boolean) r5, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b>) r2)
            if (r1 != r3) goto L_0x0049
            return r3
        L_0x0049:
            r2 = r0
        L_0x004a:
            r6 = r1
            com.sumsub.sns.internal.ml.badphotos.models.b r6 = (com.sumsub.sns.internal.ml.badphotos.models.b) r6
            r1 = 0
            if (r6 == 0) goto L_0x0065
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.a.a(r1)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 255(0xff, float:3.57E-43)
            r17 = 0
            com.sumsub.sns.internal.ml.badphotos.models.b r3 = com.sumsub.sns.internal.ml.badphotos.models.b.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            r6 = r3
            r3 = 0
            if (r6 == 0) goto L_0x0075
            java.lang.Float r4 = r6.n()
            if (r4 == 0) goto L_0x0075
            float r4 = r4.floatValue()
            goto L_0x0076
        L_0x0075:
            r4 = r3
        L_0x0076:
            if (r6 == 0) goto L_0x0082
            java.lang.Float r7 = r6.q()
            if (r7 == 0) goto L_0x0082
            float r3 = r7.floatValue()
        L_0x0082:
            com.sumsub.sns.internal.ml.badphotos.models.b r2 = r2.f31505m0
            if (r2 == 0) goto L_0x0090
            java.lang.Integer r2 = r2.j()
            if (r2 == 0) goto L_0x0090
            int r1 = r2.intValue()
        L_0x0090:
            if (r6 == 0) goto L_0x00ab
            int r2 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ab
            int r1 = r1 + r5
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.a.c(r1)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 447(0x1bf, float:6.26E-43)
            r17 = 0
            com.sumsub.sns.internal.ml.badphotos.models.b r6 = com.sumsub.sns.internal.ml.badphotos.models.b.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x00ab:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(Context context, Bitmap bitmap, Rect rect, Rect rect2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        createBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.sns_frame_stroke_width));
        canvas.drawRect(rect, paint);
        paint.setColor(-65536);
        canvas.drawRect(rect2, paint);
        a(context, createBitmap, "frame");
        createBitmap.recycle();
    }

    public final void a(Context context, Bitmap bitmap, String str) {
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, str + '_' + System.currentTimeMillis() + PictureMimeType.JPG);
            b bVar = b.f31751a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saving to ");
            sb2.append(file.getAbsolutePath());
            b.b(bVar, DocCapture.f31492c, sb2.toString(), (Throwable) null, 4, (Object) null);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (compress) {
                b.b(bVar, DocCapture.f31492c, "saved!", (Throwable) null, 4, (Object) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ab, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c3, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c6, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f0, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f2, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0106, code lost:
        r9 = (java.lang.String) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0108, code lost:
        if (r9 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010f, code lost:
        return new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint(r3, r7);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult r7, boolean r8, kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.o
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o r0 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.o) r0
            int r1 = r0.f31651d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31651d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$o
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f31649b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31651d
            java.lang.String r3 = " "
            switch(r2) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0058;
                case 2: goto L_0x004f;
                case 3: goto L_0x0047;
                case 4: goto L_0x003f;
                case 5: goto L_0x0036;
                case 6: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x0106
        L_0x0036:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x00f0
        L_0x003f:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x0090
        L_0x0047:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x00ab
        L_0x004f:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x00d5
        L_0x0058:
            java.lang.Object r7 = r0.f31648a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State) r7
            kotlin.k.b(r9)
            goto L_0x00c1
        L_0x0060:
            kotlin.k.b(r9)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r9 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INVALID
            boolean r2 = r7.e()
            java.lang.String r4 = "sns_autocapture_hint_moveOut"
            if (r2 == 0) goto L_0x00da
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$SizeCheckResult r7 = r7.f()
            int[] r9 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.l.f31639a
            int r7 = r7.ordinal()
            r7 = r9[r7]
            r9 = 2
            r2 = 1
            if (r7 == r2) goto L_0x00b0
            r8 = 3
            if (r7 == r9) goto L_0x009c
            if (r7 != r8) goto L_0x0096
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INTERMEDIATE
            r0.f31648a = r7
            r8 = 4
            r0.f31651d = r8
            java.lang.Object r9 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x0090
            return r1
        L_0x0090:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
            goto L_0x010a
        L_0x0096:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x009c:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INTERMEDIATE
            r0.f31648a = r7
            r0.f31651d = r8
            java.lang.String r8 = "sns_autocapture_hint_moveIn"
            java.lang.Object r9 = r6.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
            goto L_0x010a
        L_0x00b0:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.OK
            if (r8 == 0) goto L_0x00c8
            r0.f31648a = r7
            r0.f31651d = r2
            java.lang.String r8 = "sns_autocapture_hint_keepFocusing"
            java.lang.Object r9 = r6.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
            goto L_0x010a
        L_0x00c6:
            r3 = r9
            goto L_0x010a
        L_0x00c8:
            r0.f31648a = r7
            r0.f31651d = r9
            java.lang.String r8 = "sns_autocapture_hint_holdLikeThis"
            java.lang.Object r9 = r6.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x00d5
            return r1
        L_0x00d5:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
            goto L_0x010a
        L_0x00da:
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$SizeCheckResult r7 = r7.f()
            com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult$SizeCheckResult r8 = com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult.SizeCheckResult.BIG
            if (r7 != r8) goto L_0x00f5
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r7 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.INTERMEDIATE
            r0.f31648a = r7
            r8 = 5
            r0.f31651d = r8
            java.lang.Object r9 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x00f0
            return r1
        L_0x00f0:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
            goto L_0x010a
        L_0x00f5:
            r0.f31648a = r9
            r7 = 6
            r0.f31651d = r7
            java.lang.String r7 = "sns_autocapture_hint_targetAt"
            java.lang.Object r7 = r6.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r7 != r1) goto L_0x0103
            return r1
        L_0x0103:
            r5 = r9
            r9 = r7
            r7 = r5
        L_0x0106:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00c6
        L_0x010a:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r8 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint
            r8.<init>(r3, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, CheckDetectionResult checkDetectionResult, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return sNSPhotoDocumentPickerViewModel.a(checkDetectionResult, z11, (kotlin.coroutines.c<? super AutoCaptureHint>) cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = (r0 = r0.d()).n();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r9, android.graphics.Bitmap r10, com.sumsub.sns.internal.ml.badphotos.models.b r11) {
        /*
            r8 = this;
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r0 = r8.f31517y0
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.sumsub.sns.internal.ml.badphotos.models.b r0 = r0.d()
            if (r0 == 0) goto L_0x0016
            java.lang.Float r0 = r0.n()
            if (r0 == 0) goto L_0x0016
            float r0 = r0.floatValue()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            java.lang.Float r2 = r11.n()
            if (r2 == 0) goto L_0x0021
            float r1 = r2.floatValue()
        L_0x0021:
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0059
            com.sumsub.sns.internal.camera.photo.presentation.document.b r2 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "better frame detected: score -> "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r2, r3, r4, r5, r6, r7)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r0 = r8.f31517y0
            if (r0 == 0) goto L_0x004d
            android.graphics.Bitmap r0 = r0.c()
            if (r0 == 0) goto L_0x004d
            r0.recycle()
        L_0x004d:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a r0 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$a
            r0.<init>(r10, r11)
            r8.f31517y0 = r0
            r8.b((android.content.Context) r9)
            r9 = 1
            return r9
        L_0x0059:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.content.Context, android.graphics.Bitmap, com.sumsub.sns.internal.ml.badphotos.models.b):boolean");
    }

    public final void a(Context context) {
        b.b(b.f31751a, DocCapture.f31492c, "initiateVideoRecord", (Throwable) null, 4, (Object) null);
        File externalCacheDir = context.getExternalCacheDir();
        if (!com.sumsub.sns.internal.core.common.e0.f32018a.isDebug()) {
            externalCacheDir = null;
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        this.f31496d0 = new File(externalCacheDir, "docapture_" + UUID.randomUUID() + PictureMimeType.MP4);
        kotlinx.coroutines.flow.b1<c> b1Var = this.f31503k0;
        b1Var.setValue(c.a(b1Var.getValue(), new k(this.f31496d0, true), (c.a) null, (AutoCaptureHint) null, (d) null, (a.d) null, 30, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ce, code lost:
        if (r12 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r22, android.graphics.Bitmap r23, android.graphics.Rect r24, com.sumsub.sns.internal.ml.badphotos.models.b r25, kotlin.coroutines.c<? super kotlin.Unit> r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r25
            r4 = r26
            boolean r5 = r4 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.g1
            if (r5 == 0) goto L_0x001d
            r5 = r4
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$g1 r5 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.g1) r5
            int r6 = r5.f31608i
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.f31608i = r6
            goto L_0x0022
        L_0x001d:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$g1 r5 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$g1
            r5.<init>(r0, r4)
        L_0x0022:
            java.lang.Object r4 = r5.f31606g
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r7 = r5.f31608i
            r9 = 2
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x006d
            if (r7 == r11) goto L_0x004c
            if (r7 != r9) goto L_0x0044
            java.lang.Object r1 = r5.f31602c
            java.io.File r1 = (java.io.File) r1
            java.lang.Object r1 = r5.f31601b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            java.lang.Object r2 = r5.f31600a
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            kotlin.k.b(r4)
            goto L_0x014e
        L_0x0044:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004c:
            int r1 = r5.f31605f
            java.lang.Object r2 = r5.f31604e
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            java.lang.Object r3 = r5.f31603d
            com.sumsub.sns.internal.ml.badphotos.models.b r3 = (com.sumsub.sns.internal.ml.badphotos.models.b) r3
            java.lang.Object r7 = r5.f31602c
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            java.lang.Object r12 = r5.f31601b
            android.content.Context r12 = (android.content.Context) r12
            java.lang.Object r13 = r5.f31600a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r13 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r13
            kotlin.k.b(r4)
            r20 = r4
            r4 = r2
            r2 = r7
        L_0x0069:
            r7 = r20
            goto L_0x0107
        L_0x006d:
            kotlin.k.b(r4)
            com.sumsub.sns.internal.ml.autocapture.a r4 = r0.V
            boolean r4 = r4.n()
            r4 = r4 ^ r11
            if (r4 == 0) goto L_0x007b
            r4 = r2
            goto L_0x007c
        L_0x007b:
            r4 = r10
        L_0x007c:
            if (r4 != 0) goto L_0x0084
            r7 = r24
            android.graphics.Bitmap r4 = r0.a((android.graphics.Bitmap) r2, (android.graphics.Rect) r7)
        L_0x0084:
            if (r3 == 0) goto L_0x0093
            java.lang.Boolean r7 = r25.r()
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.a.a(r11)
            boolean r7 = kotlin.jvm.internal.x.b(r7, r12)
            goto L_0x0094
        L_0x0093:
            r7 = 0
        L_0x0094:
            com.sumsub.sns.internal.camera.photo.presentation.document.b r12 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "taking picture, photo quality result="
            r13.append(r14)
            r13.append(r3)
            java.lang.String r14 = r13.toString()
            r15 = 0
            r16 = 4
            r17 = 0
            java.lang.String r13 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r12, r13, r14, r15, r16, r17)
            com.sumsub.sns.internal.core.data.model.IdentitySide r12 = r21.q()
            if (r12 == 0) goto L_0x00d0
            java.lang.String r12 = r12.getValue()
            if (r12 == 0) goto L_0x00d0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            r12 = 95
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            if (r12 != 0) goto L_0x00d2
        L_0x00d0:
            java.lang.String r12 = ""
        L_0x00d2:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            if (r7 == 0) goto L_0x00df
            java.lang.String r12 = "autocapture_"
            goto L_0x00e0
        L_0x00df:
            r12 = r10
        L_0x00e0:
            if (r12 != 0) goto L_0x00e4
            java.lang.String r12 = "manual_"
        L_0x00e4:
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r5.f31600a = r0
            r5.f31601b = r1
            r5.f31602c = r2
            r5.f31603d = r3
            r5.f31604e = r4
            r5.f31605f = r7
            r5.f31608i = r11
            java.lang.Object r12 = com.sumsub.sns.internal.core.common.m0.a(r4, r1, r12, r5)
            if (r12 != r6) goto L_0x0100
            return r6
        L_0x0100:
            r13 = r0
            r20 = r12
            r12 = r1
            r1 = r7
            goto L_0x0069
        L_0x0107:
            java.io.File r7 = (java.io.File) r7
            if (r7 == 0) goto L_0x014d
            com.sumsub.sns.internal.camera.photo.presentation.document.b r14 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r8 = "picture taken, isAutoCaptured="
            r15.append(r8)
            if (r1 == 0) goto L_0x011b
            r8 = r11
            goto L_0x011c
        L_0x011b:
            r8 = 0
        L_0x011c:
            r15.append(r8)
            java.lang.String r1 = ". Side - "
            r15.append(r1)
            com.sumsub.sns.internal.core.data.model.IdentitySide r1 = r13.q()
            r15.append(r1)
            java.lang.String r16 = r15.toString()
            r17 = 0
            r18 = 4
            r19 = 0
            java.lang.String r15 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r14, r15, r16, r17, r18, r19)
            r5.f31600a = r2
            r5.f31601b = r4
            r5.f31602c = r7
            r5.f31603d = r10
            r5.f31604e = r10
            r5.f31608i = r9
            java.lang.Object r1 = r13.a((android.content.Context) r12, (java.io.File) r7, (com.sumsub.sns.internal.ml.badphotos.models.b) r3, (kotlin.coroutines.c<? super kotlin.Unit>) r5)
            if (r1 != r6) goto L_0x014d
            return r6
        L_0x014d:
            r1 = r4
        L_0x014e:
            boolean r2 = kotlin.jvm.internal.x.b(r1, r2)
            if (r2 != 0) goto L_0x0157
            r1.recycle()
        L_0x0157:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.content.Context, android.graphics.Bitmap, android.graphics.Rect, com.sumsub.sns.internal.ml.badphotos.models.b, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object a(Context context, File file, com.sumsub.sns.internal.ml.badphotos.models.b bVar, kotlin.coroutines.c<? super Unit> cVar) {
        Context context2 = context;
        kotlin.coroutines.c<? super Unit> cVar2 = cVar;
        b bVar2 = b.f31751a;
        b.b(bVar2, DocCapture.f31492c, "Picture is taken. Side - " + q(), (Throwable) null, 4, (Object) null);
        List L0 = CollectionsKt___CollectionsKt.L0(H());
        L0.add(new com.sumsub.sns.internal.core.data.model.n(file, file, (String) null, (String) null, q(), false, bVar, (n.b) null, false, 428, (kotlin.jvm.internal.r) null));
        a((List<com.sumsub.sns.internal.core.data.model.n>) L0);
        if (!this.f31509q0) {
            b(true);
            com.sumsub.sns.core.presentation.base.a.a(this, false, new l0((kotlin.coroutines.c<? super l0>) null), 1, (Object) null);
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) null, (Object) new com.sumsub.sns.internal.core.data.model.n(file, file, (String) null, (String) null, q(), false, bVar, (n.b) null, false, 428, (kotlin.jvm.internal.r) null), (Long) null, 5, (Object) null);
            return Unit.f56620a;
        } else if (L()) {
            if (this.f31499g0 || H().size() != 1) {
                n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new m0(this, (kotlin.coroutines.c<? super m0>) null), 3, (Object) null);
                return Unit.f56620a;
            }
            Object b11 = b(context2, cVar2);
            if (b11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return b11;
            }
            return Unit.f56620a;
        } else if (H().size() != 1 || this.f31499g0) {
            n1 unused2 = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new n0(this, (kotlin.coroutines.c<? super n0>) null), 3, (Object) null);
            return Unit.f56620a;
        } else {
            Object a11 = a(context2, cVar2);
            if (a11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return a11;
            }
            return Unit.f56620a;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r20, kotlin.coroutines.c<? super kotlin.Unit> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b0 r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.b0) r2
            int r3 = r2.f31530d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31530d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b0 r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$b0
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31528b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31530d
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0040
            if (r4 != r6) goto L_0x0038
            java.lang.Object r2 = r2.f31527a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r1)
            kotlinx.coroutines.channels.ChannelResult r1 = (kotlinx.coroutines.channels.ChannelResult) r1
            java.lang.Object r1 = r1.l()
            goto L_0x0088
        L_0x0038:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0040:
            kotlin.k.b(r1)
            r0.f31518z0 = r6
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c0 r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c0
            r1.<init>(r5)
            r4 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r4, r1, r6, r5)
            boolean r1 = r19.R()
            if (r1 == 0) goto L_0x0077
            com.sumsub.sns.internal.camera.photo.presentation.document.b r7 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "DocCapture"
            java.lang.String r9 = "interrupting the seamless due to the bad quality"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.h0 r13 = androidx.lifecycle.m0.a(r19)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d0 r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d0
            r1.<init>(r0, r5)
            r14 = 0
            r15 = 0
            r17 = 3
            r18 = 0
            r16 = r1
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r13, r14, r15, r16, r17, r18)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0077:
            r19.b((android.content.Context) r20)
            kotlinx.coroutines.channels.d<kotlin.Unit> r1 = r0.f31513u0
            r2.f31527a = r0
            r2.f31530d = r6
            java.lang.Object r1 = r1.t(r2)
            if (r1 != r3) goto L_0x0087
            return r3
        L_0x0087:
            r2 = r0
        L_0x0088:
            boolean r1 = kotlinx.coroutines.channels.ChannelResult.i(r1)
            if (r1 == 0) goto L_0x0091
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0091:
            kotlinx.coroutines.h0 r1 = androidx.lifecycle.m0.a(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$e0 r6 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$e0
            r6.<init>(r2, r5)
            r3 = 0
            r4 = 0
            r7 = 3
            r8 = 0
            r2 = r1
            r5 = r6
            r6 = r7
            r7 = r8
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(d10.a<kotlin.Unit> r21, kotlin.coroutines.c<? super kotlin.Unit> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.w0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$w0 r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.w0) r2
            int r3 = r2.f31722i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31722i = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$w0 r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$w0
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31720g
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31722i
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x004f
            if (r4 != r6) goto L_0x0047
            java.lang.Object r3 = r2.f31719f
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f31718e
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r4 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint) r4
            java.lang.Object r7 = r2.f31717d
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r7
            java.lang.Object r8 = r2.f31716c
            kotlinx.coroutines.flow.b1 r8 = (kotlinx.coroutines.flow.b1) r8
            java.lang.Object r9 = r2.f31715b
            d10.a r9 = (d10.a) r9
            java.lang.Object r2 = r2.f31714a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r1)
            r11 = r3
            goto L_0x009b
        L_0x0047:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004f:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.camera.photo.presentation.document.b r7 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "DocCapture"
            java.lang.String r9 = "showDocumentFlipHint"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r7, r8, r9, r10, r11, r12)
            r0.f31518z0 = r6
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c> r8 = r0.f31503k0
            java.lang.Object r1 = r8.getValue()
            r7 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r7 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c) r7
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$AutoCaptureHint$State r4 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.AutoCaptureHint.State.DEFAULT
            java.lang.String r9 = ""
            r1.<init>(r9, r4)
            boolean r4 = r0.f31499g0
            if (r4 == 0) goto L_0x0078
            r4 = r1
            goto L_0x0079
        L_0x0078:
            r4 = r5
        L_0x0079:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r1 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.FLIP
            java.lang.String r1 = r1.getImageName()
            r2.f31714a = r0
            r9 = r21
            r2.f31715b = r9
            r2.f31716c = r8
            r2.f31717d = r7
            r2.f31718e = r4
            r2.f31719f = r1
            r2.f31722i = r6
            java.lang.String r10 = "sns_instructions_hint_turnOver"
            java.lang.Object r2 = r0.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x0098
            return r3
        L_0x0098:
            r11 = r1
            r1 = r2
            r2 = r0
        L_0x009b:
            r3 = 0
            r16 = 0
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x00a4
            java.lang.String r1 = " "
        L_0x00a4:
            r12 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$d
            r13 = 0
            r14 = 4
            r15 = 0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            r17 = 0
            r18 = 19
            r19 = 0
            r12 = r7
            r13 = r16
            r14 = r3
            r15 = r4
            r16 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$c r1 = com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.c.a(r12, r13, r14, r15, r16, r17, r18, r19)
            r8.setValue(r1)
            boolean r1 = r2.f31499g0
            if (r1 != 0) goto L_0x00cf
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$x0 r1 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$x0
            r1.<init>(r5)
            r3 = 0
            com.sumsub.sns.core.presentation.base.a.a(r2, r3, r1, r6, r5)
        L_0x00cf:
            kotlinx.coroutines.h0 r10 = androidx.lifecycle.m0.a(r2)
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$y0 r13 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$y0
            r13.<init>(r9, r2, r5)
            r11 = 0
            r12 = 0
            r14 = 3
            r15 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r10, r11, r12, r13, r14, r15)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(d10.a, kotlin.coroutines.c):java.lang.Object");
    }

    public final Bitmap a(Bitmap bitmap, Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, (float) (rect.left * -1), (float) (rect.top * -1), (Paint) null);
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.graphics.Bitmap r25, boolean r26, kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b> r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r27
            boolean r2 = r1 instanceof com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.r
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$r r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.r) r2
            int r3 = r2.f31678f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f31678f = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$r r2 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$r
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f31676d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f31678f
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x003e
            if (r4 != r5) goto L_0x0036
            long r3 = r2.f31675c
            boolean r7 = r2.f31674b
            java.lang.Object r2 = r2.f31673a
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel r2 = (com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel) r2
            kotlin.k.b(r1)
            goto L_0x006a
        L_0x0036:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003e:
            kotlin.k.b(r1)
            long r7 = java.lang.System.currentTimeMillis()
            boolean r1 = r24.F()
            if (r1 == 0) goto L_0x006d
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.v0.a()
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$s r4 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$s
            r9 = r25
            r4.<init>(r0, r9, r6)
            r2.f31673a = r0
            r9 = r26
            r2.f31674b = r9
            r2.f31675c = r7
            r2.f31678f = r5
            java.lang.Object r1 = kotlinx.coroutines.g.g(r1, r4, r2)
            if (r1 != r3) goto L_0x0067
            return r3
        L_0x0067:
            r2 = r0
            r3 = r7
            r7 = r9
        L_0x006a:
            com.sumsub.sns.internal.ml.core.e$a r1 = (com.sumsub.sns.internal.ml.core.e.a) r1
            goto L_0x0077
        L_0x006d:
            r9 = r26
            com.sumsub.sns.internal.ml.core.e$a$c r1 = new com.sumsub.sns.internal.ml.core.e$a$c
            r1.<init>()
            r2 = r0
            r3 = r7
            r7 = r9
        L_0x0077:
            boolean r8 = r1 instanceof com.sumsub.sns.internal.ml.core.e.a.d
            if (r8 == 0) goto L_0x007f
            r9 = r1
            com.sumsub.sns.internal.ml.core.e$a$d r9 = (com.sumsub.sns.internal.ml.core.e.a.d) r9
            goto L_0x0080
        L_0x007f:
            r9 = r6
        L_0x0080:
            boolean r10 = r2.f31499g0
            if (r10 != 0) goto L_0x00a0
            com.sumsub.sns.internal.camera.photo.presentation.document.b r11 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "badPhotos result: "
            r10.append(r12)
            r10.append(r1)
            java.lang.String r13 = r10.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r11, r12, r13, r14, r15, r16)
        L_0x00a0:
            if (r9 == 0) goto L_0x00e2
            com.sumsub.sns.internal.camera.photo.presentation.document.b r17 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "badPhotoDetector took "
            r10.append(r11)
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r3
            r10.append(r11)
            java.lang.String r3 = " ms, score="
            r10.append(r3)
            java.lang.Object r3 = r9.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r3 = (com.sumsub.sns.internal.ml.badphotos.models.a) r3
            float r3 = r3.c()
            r10.append(r3)
            java.lang.String r19 = r10.toString()
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r18 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r17, r18, r19, r20, r21, r22)
            java.lang.Object r3 = r9.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r3 = (com.sumsub.sns.internal.ml.badphotos.models.a) r3
            float r3 = r3.c()
            goto L_0x00e4
        L_0x00e2:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x00e4:
            com.sumsub.sns.internal.ml.badphotos.c r4 = r2.U
            float r4 = r4.k()
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            r10 = 0
            if (r4 < 0) goto L_0x00f1
            r4 = r5
            goto L_0x00f2
        L_0x00f1:
            r4 = r10
        L_0x00f2:
            com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$j r11 = new com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel$j
            if (r8 == 0) goto L_0x00fa
            r8 = r1
            com.sumsub.sns.internal.ml.core.e$a$d r8 = (com.sumsub.sns.internal.ml.core.e.a.d) r8
            goto L_0x00fb
        L_0x00fa:
            r8 = r6
        L_0x00fb:
            if (r8 == 0) goto L_0x010a
            java.lang.Object r8 = r8.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r8 = (com.sumsub.sns.internal.ml.badphotos.models.a) r8
            if (r8 == 0) goto L_0x010a
            long r12 = r8.a()
            goto L_0x010c
        L_0x010a:
            r12 = -1
        L_0x010c:
            r11.<init>(r4, r3, r12)
            r2.a((com.sumsub.sns.core.presentation.base.a.j) r11)
            com.sumsub.sns.internal.ml.badphotos.models.b r4 = new com.sumsub.sns.internal.ml.badphotos.models.b
            java.lang.String r15 = r1.a()
            if (r9 == 0) goto L_0x0129
            java.lang.Object r1 = r9.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r1 = (com.sumsub.sns.internal.ml.badphotos.models.a) r1
            if (r1 == 0) goto L_0x0129
            java.lang.String r1 = r1.b()
            r16 = r1
            goto L_0x012b
        L_0x0129:
            r16 = r6
        L_0x012b:
            if (r9 == 0) goto L_0x0140
            java.lang.Object r1 = r9.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r1 = (com.sumsub.sns.internal.ml.badphotos.models.a) r1
            if (r1 == 0) goto L_0x0140
            float r1 = r1.c()
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.a.b(r1)
            r17 = r1
            goto L_0x0142
        L_0x0140:
            r17 = r6
        L_0x0142:
            if (r9 == 0) goto L_0x0157
            java.lang.Object r1 = r9.c()
            com.sumsub.sns.internal.ml.badphotos.models.a r1 = (com.sumsub.sns.internal.ml.badphotos.models.a) r1
            if (r1 == 0) goto L_0x0157
            long r8 = r1.a()
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.a.d(r8)
            r18 = r1
            goto L_0x0159
        L_0x0157:
            r18 = r6
        L_0x0159:
            com.sumsub.sns.internal.ml.badphotos.c r1 = r2.U
            float r1 = r1.l()
            java.lang.Float r19 = kotlin.coroutines.jvm.internal.a.b(r1)
            com.sumsub.sns.internal.ml.badphotos.c r1 = r2.U
            float r1 = r1.k()
            java.lang.Float r20 = kotlin.coroutines.jvm.internal.a.b(r1)
            com.sumsub.sns.internal.ml.badphotos.c r1 = r2.U
            int r1 = r1.m()
            java.lang.Integer r22 = kotlin.coroutines.jvm.internal.a.c(r1)
            java.lang.Boolean r23 = kotlin.coroutines.jvm.internal.a.a(r5)
            r21 = 0
            r14 = r4
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r1 = 0
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x018a
            if (r7 == 0) goto L_0x0189
            goto L_0x018a
        L_0x0189:
            r5 = r10
        L_0x018a:
            if (r5 == 0) goto L_0x018d
            r6 = r4
        L_0x018d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.document.SNSPhotoDocumentPickerViewModel.a(android.graphics.Bitmap, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(SNSPhotoDocumentPickerViewModel sNSPhotoDocumentPickerViewModel, Bitmap bitmap, boolean z11, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return sNSPhotoDocumentPickerViewModel.a(bitmap, z11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.ml.badphotos.models.b>) cVar);
    }

    public final CheckDetectionResult a(float f11, float f12, Rect rect, com.sumsub.sns.internal.ml.docdetector.a aVar) {
        return E().c(f11, f12, rect, aVar);
    }
}
