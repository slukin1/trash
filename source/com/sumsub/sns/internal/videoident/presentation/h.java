package com.sumsub.sns.internal.videoident.presentation;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.lifecycle.SavedStateHandle;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.ReviewStatusType;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.videoident.presentation.SNSStepViewItem;
import com.sumsub.sns.internal.videoident.presentation.SNSViewState;
import com.sumsub.sns.internal.videoident.presentation.c;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.n1;

public final class h extends com.sumsub.sns.core.presentation.base.a<SNSViewState> {
    public static final String A = "sns_videoident_action_start";
    public static final String B = "sns_videoident_langPanel_text";
    public static final String C = "sns_videoident_langPanel_action_change";
    public static final long D = TimeUnit.SECONDS.toMillis(15);

    /* renamed from: q  reason: collision with root package name */
    public static final c f36695q = new c((kotlin.jvm.internal.r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f36696r;

    /* renamed from: s  reason: collision with root package name */
    public static final String f36697s = "isChatRunning";

    /* renamed from: t  reason: collision with root package name */
    public static final String f36698t = "sns_videoident_error_connectionLost_title";

    /* renamed from: u  reason: collision with root package name */
    public static final String f36699u = "sns_videoident_state_followIntructions_text";

    /* renamed from: v  reason: collision with root package name */
    public static final String f36700v = "sns_videoident_warning_waitForConnect";

    /* renamed from: w  reason: collision with root package name */
    public static final String f36701w = "sns_videoident_warning_waitForConnect_adaptive";

    /* renamed from: x  reason: collision with root package name */
    public static final String f36702x = "sns_videoident_state_checkingCamera_title";

    /* renamed from: y  reason: collision with root package name */
    public static final String f36703y = "sns_videoident_state_checkingCamera_text";

    /* renamed from: z  reason: collision with root package name */
    public static final String f36704z = "sns_videoident_state_connecting";
    public final List<Document> E;
    public final kotlinx.serialization.json.a F;
    public final com.sumsub.sns.internal.core.data.source.dynamic.b G;
    public final com.sumsub.sns.internal.videoident.videoident.domain.d H;
    public final com.sumsub.sns.internal.videoident.videoident.domain.e I;
    public final com.sumsub.sns.internal.videoident.videoident.domain.c J;
    public final com.sumsub.sns.internal.videoident.videoident.domain.b K;
    public final com.sumsub.sns.internal.videoident.videoident.domain.a L;
    public final com.sumsub.sns.internal.domain.j M;
    public g N;
    public final com.sumsub.sns.internal.core.common.c1 O;
    public final com.sumsub.sns.internal.core.data.source.applicant.b P;
    public final kotlinx.coroutines.h0 Q = kotlinx.coroutines.i0.a(kotlinx.coroutines.v0.c().plus(e2.b((kotlinx.coroutines.n1) null, 1, (Object) null)));
    public final com.sumsub.sns.internal.core.presentation.screen.base.a R;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a S;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a T;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a U;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a V;
    public boolean W;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a X;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a Y;
    public final com.sumsub.sns.internal.core.presentation.screen.base.a Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f36705a0;

    /* renamed from: b0  reason: collision with root package name */
    public Bitmap f36706b0;

    /* renamed from: c0  reason: collision with root package name */
    public File f36707c0;

    /* renamed from: d0  reason: collision with root package name */
    public final long f36708d0;

    /* renamed from: e0  reason: collision with root package name */
    public long f36709e0;

    /* renamed from: f0  reason: collision with root package name */
    public long f36710f0;

    /* renamed from: g0  reason: collision with root package name */
    public final String[] f36711g0;

    /* renamed from: h0  reason: collision with root package name */
    public d10.a<Unit> f36712h0;

    /* renamed from: i0  reason: collision with root package name */
    public d10.a<Unit> f36713i0;

    /* renamed from: j0  reason: collision with root package name */
    public d10.l<? super Boolean, Unit> f36714j0;

    /* renamed from: k0  reason: collision with root package name */
    public d10.l<? super String, Unit> f36715k0;

    /* renamed from: l0  reason: collision with root package name */
    public kotlinx.coroutines.n1 f36716l0;

    /* renamed from: m0  reason: collision with root package name */
    public kotlinx.coroutines.n1 f36717m0;

    /* renamed from: n0  reason: collision with root package name */
    public kotlinx.coroutines.n1 f36718n0;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36719a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36720b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36721c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f36721c = hVar;
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f36721c, cVar);
            aVar.f36720b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36719a == 0) {
                kotlin.k.b(obj);
                b.a aVar = (b.a) this.f36720b;
                if (aVar != null) {
                    h hVar = this.f36721c;
                    com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "data repository flow updated", (Throwable) null, 4, (Object) null);
                    hVar.a(aVar);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$2", f = "SNSVideoIdentViewModel.kt", l = {679}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36723b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(h hVar, kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
            this.f36723b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((a0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a0(this.f36723b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36722a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36723b;
                this.f36722a = 1;
                obj = hVar.j((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {147, 148, 149}, m = "readyForPhoto")
    public static final class a1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36724a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36725b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36726c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36727d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f36728e;

        /* renamed from: f  reason: collision with root package name */
        public int f36729f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a1(h hVar, kotlin.coroutines.c<? super a1> cVar) {
            super(cVar);
            this.f36728e = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36727d = obj;
            this.f36729f |= Integer.MIN_VALUE;
            return this.f36728e.k((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$2", f = "SNSVideoIdentViewModel.kt", l = {292}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements d10.p<SNSMessage.ServerMessage, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36730a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36732c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h hVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f36732c = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSMessage.ServerMessage serverMessage, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(serverMessage, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f36732c, cVar);
            bVar.f36731b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36730a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                SNSMessage.ServerMessage serverMessage = (SNSMessage.ServerMessage) this.f36731b;
                if (serverMessage instanceof SNSMessage.ServerMessage.f) {
                    this.f36730a = 1;
                    if (this.f36732c.a((SNSMessage.ServerMessage.f) serverMessage, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$3", f = "SNSVideoIdentViewModel.kt", l = {683}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36733a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36734b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(h hVar, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f36734b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((b0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f36734b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36733a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36734b;
                this.f36733a = 1;
                obj = hVar.r((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {412}, m = "requestAvailableLanguages")
    public static final class b1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36735a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36737c;

        /* renamed from: d  reason: collision with root package name */
        public int f36738d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b1(h hVar, kotlin.coroutines.c<? super b1> cVar) {
            super(cVar);
            this.f36737c = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36736b = obj;
            this.f36738d |= Integer.MIN_VALUE;
            return this.f36737c.l((kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final long a() {
            return h.D;
        }

        public c() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$4", f = "SNSVideoIdentViewModel.kt", l = {693}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36739a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36740b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(h hVar, kotlin.coroutines.c<? super c0> cVar) {
            super(2, cVar);
            this.f36740b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((c0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c0(this.f36740b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36739a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36740b;
                this.f36739a = 1;
                obj = hVar.g((kotlin.coroutines.c<? super SNSViewState>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$requestAvailableLanguages$2", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class c1 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36741a;

        public c1(kotlin.coroutines.c<? super c1> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((c1) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c1(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36741a == 0) {
                kotlin.k.b(obj);
                return SNSViewState.c.f36612a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36742a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f36743b;

        static {
            int[] iArr = new int[ButtonAction.values().length];
            iArr[ButtonAction.UPLOAD.ordinal()] = 1;
            iArr[ButtonAction.START_CALL.ordinal()] = 2;
            f36742a = iArr;
            int[] iArr2 = new int[PhoneVerificationStatus.values().length];
            iArr2[PhoneVerificationStatus.REQUESTED.ordinal()] = 1;
            iArr2[PhoneVerificationStatus.SUCCESS.ordinal()] = 2;
            iArr2[PhoneVerificationStatus.CANCELED.ordinal()] = 3;
            iArr2[PhoneVerificationStatus.RETRY_CODE.ordinal()] = 4;
            f36743b = iArr2;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$5", f = "SNSVideoIdentViewModel.kt", l = {705}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36745b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(h hVar, kotlin.coroutines.c<? super d0> cVar) {
            super(2, cVar);
            this.f36745b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((d0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d0(this.f36745b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36744a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36745b;
                this.f36744a = 1;
                obj = hVar.f((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$requestAvailableLanguages$3", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class d1 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36746a;

        public d1(kotlin.coroutines.c<? super d1> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((d1) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d1(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36746a == 0) {
                kotlin.k.b(obj);
                return new SNSViewState.d(false, false, (f) null, 7, (kotlin.jvm.internal.r) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {214, 215, 216, 218}, m = "connectionLostCallAgainState")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36747a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36748b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36749c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36750d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36751e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f36752f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f36753g;

        /* renamed from: h  reason: collision with root package name */
        public int f36754h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(h hVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f36753g = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36752f = obj;
            this.f36754h |= Integer.MIN_VALUE;
            return this.f36753g.e((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$6", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36755a;

        public e0(kotlin.coroutines.c<? super e0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((e0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e0(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36755a == 0) {
                kotlin.k.b(obj);
                return SNSViewState.c.f36612a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$requestAvailableLanguages$4", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e1 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36756a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36757b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List<com.sumsub.sns.internal.core.data.source.applicant.remote.n> f36758c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e1(h hVar, List<com.sumsub.sns.internal.core.data.source.applicant.remote.n> list, kotlin.coroutines.c<? super e1> cVar) {
            super(2, cVar);
            this.f36757b = hVar;
            this.f36758c = list;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((e1) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e1(this.f36757b, this.f36758c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36756a == 0) {
                kotlin.k.b(obj);
                return new SNSViewState.b(this.f36757b.J(), this.f36758c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {204, 207, 209}, m = "connectionLostState")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36759a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36760b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36761c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36762d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36764f;

        /* renamed from: g  reason: collision with root package name */
        public int f36765g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(h hVar, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f36764f = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36763e = obj;
            this.f36765g |= Integer.MIN_VALUE;
            return this.f36764f.f((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$7", f = "SNSVideoIdentViewModel.kt", l = {746}, m = "invokeSuspend")
    public static final class f0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36767b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(h hVar, kotlin.coroutines.c<? super f0> cVar) {
            super(2, cVar);
            this.f36767b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((f0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f0(this.f36767b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36766a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36767b;
                this.f36766a = 1;
                obj = hVar.e((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$scheduleDisconnectTimeout$1", f = "SNSVideoIdentViewModel.kt", l = {822}, m = "invokeSuspend")
    public static final class f1 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36768a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36769b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f1(h hVar, kotlin.coroutines.c<? super f1> cVar) {
            super(2, cVar);
            this.f36769b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f1(this.f36769b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36768a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                long E = this.f36769b.E();
                this.f36768a = 1;
                if (DelayKt.b(E, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f36769b.V();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$doStartCall$1", f = "SNSVideoIdentViewModel.kt", l = {610}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36771b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(h hVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f36771b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((g) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f36771b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36770a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36771b;
                this.f36770a = 1;
                obj = hVar.j((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$8", f = "SNSVideoIdentViewModel.kt", l = {748}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36772a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36773b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(h hVar, kotlin.coroutines.c<? super g0> cVar) {
            super(2, cVar);
            this.f36773b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((g0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g0(this.f36773b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36772a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36773b;
                this.f36772a = 1;
                obj = hVar.a(true, (kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$scheduleWaitForStatusUpdate$1", f = "SNSVideoIdentViewModel.kt", l = {1332}, m = "invokeSuspend")
    public static final class g1 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36775b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g1(h hVar, kotlin.coroutines.c<? super g1> cVar) {
            super(2, cVar);
            this.f36775b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g1(this.f36775b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36774a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                long n11 = this.f36775b.f36708d0;
                this.f36774a = 1;
                if (DelayKt.b(n11, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f36775b.c0();
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$doStartCall$2", f = "SNSVideoIdentViewModel.kt", l = {614}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.internal.videoident.presentation.h$h  reason: collision with other inner class name */
    public static final class C0502h extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36776a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36777b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$doStartCall$2$1", f = "SNSVideoIdentViewModel.kt", l = {624}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.videoident.presentation.h$h$a */
        public static final class a extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36778a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36779b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f36780c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h hVar, Object obj, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36779b = hVar;
                this.f36780c = obj;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((a) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36779b, this.f36780c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36778a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36779b;
                    this.f36778a = 1;
                    obj = hVar.m((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return j.b((SNSViewState.e) obj, this.f36779b.h(), (Exception) Result.m3075exceptionOrNullimpl(this.f36780c));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0502h(h hVar, kotlin.coroutines.c<? super C0502h> cVar) {
            super(2, cVar);
            this.f36777b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0502h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0502h(this.f36777b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36776a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "applying for a room ...", (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.videoident.videoident.domain.d c11 = this.f36777b.H;
                this.f36776a = 1;
                obj2 = c11.a(this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                obj2 = ((Result) obj).m3081unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (Result.m3079isSuccessimpl(obj2)) {
                h hVar = this.f36777b;
                kotlin.k.b(obj2);
                hVar.a((com.sumsub.sns.internal.core.data.source.applicant.remote.h0) obj2);
            } else {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "apply room error", (Exception) Result.m3075exceptionOrNullimpl(obj2));
                h hVar2 = this.f36777b;
                com.sumsub.sns.core.presentation.base.a.a(hVar2, false, new a(hVar2, obj2, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onChangeLanguageClick$1", f = "SNSVideoIdentViewModel.kt", l = {371}, m = "invokeSuspend")
    public static final class h0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36781a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36782b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h0(h hVar, kotlin.coroutines.c<? super h0> cVar) {
            super(2, cVar);
            this.f36782b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h0(this.f36782b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36781a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36782b;
                this.f36781a = 1;
                if (hVar.l((kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {234, 238}, m = "startCallErrorState")
    public static final class h1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36783a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36784b;

        /* renamed from: c  reason: collision with root package name */
        public int f36785c;

        /* renamed from: d  reason: collision with root package name */
        public int f36786d;

        /* renamed from: e  reason: collision with root package name */
        public int f36787e;

        /* renamed from: f  reason: collision with root package name */
        public int f36788f;

        /* renamed from: g  reason: collision with root package name */
        public int f36789g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f36790h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f36791i;

        /* renamed from: j  reason: collision with root package name */
        public int f36792j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h1(h hVar, kotlin.coroutines.c<? super h1> cVar) {
            super(cVar);
            this.f36791i = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36790h = obj;
            this.f36792j |= Integer.MIN_VALUE;
            return this.f36791i.m((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {154, 156, 158, 159}, m = "exitConfirmationDialog")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36793a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36794b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36795c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f36796d;

        /* renamed from: e  reason: collision with root package name */
        public int f36797e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(h hVar, kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
            this.f36796d = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36795c = obj;
            this.f36797e |= Integer.MIN_VALUE;
            return this.f36796d.h((kotlin.coroutines.c<? super SNSViewState.a>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {846, 894}, m = "onChatMessage")
    public static final class i0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36798a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36799b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f36801d;

        /* renamed from: e  reason: collision with root package name */
        public int f36802e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i0(h hVar, kotlin.coroutines.c<? super i0> cVar) {
            super(cVar);
            this.f36801d = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36800c = obj;
            this.f36802e |= Integer.MIN_VALUE;
            return this.f36801d.b((String) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$switchToReconnectingViewState$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class i1 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36804b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSViewState.e f36805c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i1(h hVar, SNSViewState.e eVar, kotlin.coroutines.c<? super i1> cVar) {
            super(2, cVar);
            this.f36804b = hVar;
            this.f36805c = eVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((i1) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i1(this.f36804b, this.f36805c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36803a == 0) {
                kotlin.k.b(obj);
                boolean z11 = false;
                e eVar = new e(false, this.f36804b.F(), true);
                if (this.f36805c.O() != null) {
                    z11 = true;
                }
                if (!z11) {
                    eVar = null;
                }
                e eVar2 = eVar;
                SNSViewState.VideoStepState videoStepState = SNSViewState.VideoStepState.RECONNECTING;
                SNSViewState.e eVar3 = this.f36805c;
                return SNSViewState.e.a(eVar3, videoStepState, (SNSViewState.ErrorState) null, false, false, false, false, false, (CharSequence) null, (CharSequence) null, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, false, false, eVar2, (CharSequence) null, (List) null, (Bitmap) null, eVar3, (AnalyticsCallState) null, (SNSViewState.a) null, (SNSViewState.e.a.C0498a) null, 15663102, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleCancelScreenshot$1", f = "SNSVideoIdentViewModel.kt", l = {911}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36807b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(h hVar, kotlin.coroutines.c<? super j> cVar) {
            super(2, cVar);
            this.f36807b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((j) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j(this.f36807b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36806a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36807b;
                this.f36806a = 1;
                obj = hVar.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onChatMessage$message$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class j0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super SNSMessage.ServerMessage>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36808a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36809b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36810c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j0(h hVar, String str, kotlin.coroutines.c<? super j0> cVar) {
            super(2, cVar);
            this.f36809b = hVar;
            this.f36810c = str;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super SNSMessage.ServerMessage> cVar) {
            return ((j0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j0(this.f36809b, this.f36810c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36808a == 0) {
                kotlin.k.b(obj);
                return SNSMessage.ServerMessage.Companion.a(this.f36809b.y(), this.f36810c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {192, 193, 194, 196, 198}, m = "uploadFailedState")
    public static final class j1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36811a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36812b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36813c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36814d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36815e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36816f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36817g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f36818h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f36819i;

        /* renamed from: j  reason: collision with root package name */
        public int f36820j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j1(h hVar, kotlin.coroutines.c<? super j1> cVar) {
            super(cVar);
            this.f36819i = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36818h = obj;
            this.f36820j |= Integer.MIN_VALUE;
            return this.f36819i.n((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleFileSelectedForDocSetType$1", f = "SNSVideoIdentViewModel.kt", l = {1367, 1375, 1387, 1389}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36821a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Uri f36823c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleFileSelectedForDocSetType$1$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36824a;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((a) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f36824a == 0) {
                    kotlin.k.b(obj);
                    return SNSViewState.c.f36612a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleFileSelectedForDocSetType$1$5$1", f = "SNSVideoIdentViewModel.kt", l = {1397}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36825a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36826b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Bitmap f36827c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(h hVar, Bitmap bitmap, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f36826b = hVar;
                this.f36827c = bitmap;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((b) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f36826b, this.f36827c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36825a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36826b;
                    this.f36825a = 1;
                    obj = hVar.o((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ((SNSViewState.e) obj).a(this.f36827c);
                return obj;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleFileSelectedForDocSetType$1$6", f = "SNSVideoIdentViewModel.kt", l = {1406}, m = "invokeSuspend")
        public static final class c extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36828a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36829b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(h hVar, kotlin.coroutines.c<? super c> cVar) {
                super(2, cVar);
                this.f36829b = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((c) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new c(this.f36829b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36828a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36829b;
                    this.f36828a = 1;
                    obj = hVar.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleFileSelectedForDocSetType$1$fileUri$1", f = "SNSVideoIdentViewModel.kt", l = {1376}, m = "invokeSuspend")
        public static final class d extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super String>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36830a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36831b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Uri f36832c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(h hVar, Uri uri, kotlin.coroutines.c<? super d> cVar) {
                super(2, cVar);
                this.f36831b = hVar;
                this.f36832c = uri;
            }

            /* renamed from: a */
            public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super String> cVar) {
                return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new d(this.f36831b, this.f36832c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36830a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    com.sumsub.sns.internal.core.common.c1 l11 = this.f36831b.O;
                    Uri uri = this.f36832c;
                    this.f36830a = 1;
                    obj = l11.copyContentsToCacheFile(uri, this);
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(h hVar, Uri uri, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f36822b = hVar;
            this.f36823c = uri;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f36822b, this.f36823c, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r1.f36821a
                java.lang.String r3 = "SNSVideoIdent"
                r4 = 3
                r5 = 4
                r6 = 2
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x003d
                if (r2 == r8) goto L_0x0039
                if (r2 == r6) goto L_0x0033
                if (r2 == r4) goto L_0x0029
                if (r2 != r5) goto L_0x0021
                kotlin.k.b(r17)     // Catch:{ all -> 0x0030 }
                r2 = r17
                goto L_0x00ca
            L_0x0021:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0029:
                kotlin.k.b(r17)     // Catch:{ all -> 0x0030 }
                r2 = r17
                goto L_0x00be
            L_0x0030:
                r0 = move-exception
                goto L_0x00cd
            L_0x0033:
                kotlin.k.b(r17)
                r2 = r17
                goto L_0x0070
            L_0x0039:
                kotlin.k.b(r17)
                goto L_0x004b
            L_0x003d:
                kotlin.k.b(r17)
                com.sumsub.sns.internal.videoident.presentation.h r2 = r1.f36822b
                r1.f36821a = r8
                java.lang.Object r2 = r2.b((kotlin.coroutines.c<? super java.lang.Boolean>) r1)
                if (r2 != r0) goto L_0x004b
                return r0
            L_0x004b:
                com.sumsub.sns.internal.videoident.presentation.h r2 = r1.f36822b
                com.sumsub.sns.internal.videoident.presentation.h$k$a r10 = new com.sumsub.sns.internal.videoident.presentation.h$k$a
                r10.<init>(r9)
                com.sumsub.sns.core.presentation.base.a.a(r2, r7, r10, r8, r9)
                java.lang.String r2 = "handleFileSelectedForDocSetType: creating preview ..."
                com.sumsub.sns.internal.videoident.videoident.a.a(r3, r2, r9, r5, r9)
                kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.v0.a()
                com.sumsub.sns.internal.videoident.presentation.h$k$d r10 = new com.sumsub.sns.internal.videoident.presentation.h$k$d
                com.sumsub.sns.internal.videoident.presentation.h r11 = r1.f36822b
                android.net.Uri r12 = r1.f36823c
                r10.<init>(r11, r12, r9)
                r1.f36821a = r6
                java.lang.Object r2 = kotlinx.coroutines.g.g(r2, r10, r1)
                if (r2 != r0) goto L_0x0070
                return r0
            L_0x0070:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L_0x00ee
                java.lang.String r10 = "file://"
                boolean r6 = kotlin.text.StringsKt__StringsJVMKt.M(r2, r10, r7, r6, r9)
                if (r6 != 0) goto L_0x008a
                int r6 = r2.length()
                if (r6 != 0) goto L_0x0084
                r6 = r8
                goto L_0x0085
            L_0x0084:
                r6 = r7
            L_0x0085:
                if (r6 != 0) goto L_0x0088
                goto L_0x008a
            L_0x0088:
                r6 = r7
                goto L_0x008b
            L_0x008a:
                r6 = r8
            L_0x008b:
                if (r6 == 0) goto L_0x008f
                r10 = r2
                goto L_0x0090
            L_0x008f:
                r10 = r9
            L_0x0090:
                if (r10 == 0) goto L_0x00ee
                java.io.File r2 = new java.io.File
                r13 = 0
                r14 = 4
                r15 = 0
                java.lang.String r11 = "file://"
                java.lang.String r12 = ""
                java.lang.String r6 = kotlin.text.StringsKt__StringsJVMKt.G(r10, r11, r12, r13, r14, r15)
                r2.<init>(r6)
                com.sumsub.sns.internal.videoident.presentation.h r6 = r1.f36822b
                r6.f36707c0 = r2
                java.lang.String r6 = com.sumsub.sns.internal.core.common.m0.a(r2)     // Catch:{ all -> 0x0030 }
                java.lang.String r10 = "application/pdf"
                boolean r6 = kotlin.jvm.internal.x.b(r6, r10)     // Catch:{ all -> 0x0030 }
                r10 = 1920(0x780, float:2.69E-42)
                if (r6 == 0) goto L_0x00c1
                r1.f36821a = r4     // Catch:{ all -> 0x0030 }
                java.lang.Object r2 = com.sumsub.sns.internal.core.common.m0.b((java.io.File) r2, (int) r10, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r1)     // Catch:{ all -> 0x0030 }
                if (r2 != r0) goto L_0x00be
                return r0
            L_0x00be:
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ all -> 0x0030 }
                goto L_0x00df
            L_0x00c1:
                r1.f36821a = r5     // Catch:{ all -> 0x0030 }
                java.lang.Object r2 = com.sumsub.sns.internal.core.common.m0.a((java.io.File) r2, (int) r10, (kotlin.coroutines.c<? super android.graphics.Bitmap>) r1)     // Catch:{ all -> 0x0030 }
                if (r2 != r0) goto L_0x00ca
                return r0
            L_0x00ca:
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ all -> 0x0030 }
                goto L_0x00df
            L_0x00cd:
                com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
                com.sumsub.sns.internal.log.LoggerType[] r4 = new com.sumsub.sns.internal.log.LoggerType[r8]
                com.sumsub.sns.internal.log.LoggerType r5 = com.sumsub.sns.internal.log.LoggerType.KIBANA
                r4[r7] = r5
                com.sumsub.log.logger.Logger r2 = r2.a((com.sumsub.sns.internal.log.LoggerType[]) r4)
                java.lang.String r4 = "decoding image failed"
                r2.e(r3, r4, r0)
                r2 = r9
            L_0x00df:
                if (r2 == 0) goto L_0x00ee
                com.sumsub.sns.internal.videoident.presentation.h r0 = r1.f36822b
                com.sumsub.sns.internal.videoident.presentation.h$k$b r3 = new com.sumsub.sns.internal.videoident.presentation.h$k$b
                r3.<init>(r0, r2, r9)
                com.sumsub.sns.core.presentation.base.a.a(r0, r7, r3, r8, r9)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x00ee:
                com.sumsub.sns.internal.videoident.presentation.h r0 = r1.f36822b
                r0.f36707c0 = r9
                com.sumsub.sns.internal.videoident.presentation.h r0 = r1.f36822b
                r0.e0()
                com.sumsub.sns.internal.videoident.presentation.h r0 = r1.f36822b
                com.sumsub.sns.internal.videoident.presentation.h$k$c r2 = new com.sumsub.sns.internal.videoident.presentation.h$k$c
                r2.<init>(r0, r9)
                com.sumsub.sns.core.presentation.base.a.a(r0, r7, r2, r8, r9)
                com.sumsub.sns.internal.videoident.presentation.h r0 = r1.f36822b
                r0.X()
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onConnectedToRoom$1", f = "SNSVideoIdentViewModel.kt", l = {631}, m = "invokeSuspend")
    public static final class k0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36834b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onConnectedToRoom$1$1$1", f = "SNSVideoIdentViewModel.kt", l = {637}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36835a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36836b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h hVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36836b = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((a) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36836b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36835a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36836b;
                    this.f36835a = 1;
                    obj = hVar.r((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onConnectedToRoom$1$2", f = "SNSVideoIdentViewModel.kt", l = {645}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36837a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36838b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f36839c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(h hVar, Object obj, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f36838b = hVar;
                this.f36839c = obj;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((b) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f36838b, this.f36839c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36837a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36838b;
                    this.f36837a = 1;
                    obj = hVar.m((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return j.b((SNSViewState.e) obj, this.f36838b.h(), (Exception) Result.m3075exceptionOrNullimpl(this.f36839c));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(h hVar, kotlin.coroutines.c<? super k0> cVar) {
            super(2, cVar);
            this.f36834b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k0(this.f36834b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36833a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "confirming room connection", (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.videoident.videoident.domain.e d12 = this.f36834b.I;
                this.f36833a = 1;
                obj2 = d12.a(this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                obj2 = ((Result) obj).m3081unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (Result.m3079isSuccessimpl(obj2)) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "confirm success", (Throwable) null, 4, (Object) null);
                a.l c11 = this.f36834b.c();
                h hVar = this.f36834b;
                if (((SNSViewState) c11).isLoading() && !hVar.P()) {
                    com.sumsub.sns.core.presentation.base.a.a(hVar, false, new a(hVar, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
                    hVar.c(true);
                }
            } else {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " confirm room error", Result.m3075exceptionOrNullimpl(obj2));
                this.f36834b.N.disconnect();
                h hVar2 = this.f36834b;
                com.sumsub.sns.core.presentation.base.a.a(hVar2, false, new b(hVar2, obj2, (kotlin.coroutines.c<? super b>) null), 1, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {183, 185, 187}, m = "uploadPreview")
    public static final class k1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36840a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36841b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36842c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36843d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36845f;

        /* renamed from: g  reason: collision with root package name */
        public int f36846g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k1(h hVar, kotlin.coroutines.c<? super k1> cVar) {
            super(cVar);
            this.f36845f = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36844e = obj;
            this.f36846g |= Integer.MIN_VALUE;
            return this.f36845f.o((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleLanguageSelectionResult$1", f = "SNSVideoIdentViewModel.kt", l = {451}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36848b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36849c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(h hVar, String str, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f36848b = hVar;
            this.f36849c = str;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((l) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l(this.f36848b, this.f36849c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Throwable r52;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36847a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.domain.j h11 = this.f36848b.M;
                String str = this.f36849c;
                com.sumsub.sns.internal.core.data.source.applicant.b b11 = this.f36848b.P;
                this.f36847a = 1;
                obj2 = h11.a(str, b11, this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                obj2 = ((Result) obj).m3081unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (Result.m3078isFailureimpl(obj2) && (r52 = Result.m3075exceptionOrNullimpl(obj2)) != null) {
                this.f36848b.a(r52, DocumentType.f32355j, (Object) new SNSViewState.b((String) null, CollectionsKt__CollectionsKt.k()));
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onDecodingPhotoFrame$1", f = "SNSVideoIdentViewModel.kt", l = {1038}, m = "invokeSuspend")
    public static final class l0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36851b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l0(h hVar, kotlin.coroutines.c<? super l0> cVar) {
            super(2, cVar);
            this.f36851b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((l0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new l0(this.f36851b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36850a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36851b;
                this.f36850a = 1;
                obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {139, 142, 143}, m = "uploadingPhotoState")
    public static final class l1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36852a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36853b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36854c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36855d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f36856e;

        /* renamed from: f  reason: collision with root package name */
        public int f36857f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l1(h hVar, kotlin.coroutines.c<? super l1> cVar) {
            super(cVar);
            this.f36856e = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36855d = obj;
            this.f36857f |= Integer.MIN_VALUE;
            return this.f36856e.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleLanguageSelectionResult$2", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class m extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36858a;

        public m(kotlin.coroutines.c<? super m> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((m) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36858a == 0) {
                kotlin.k.b(obj);
                return new SNSViewState.d(false, false, (f) null, 7, (kotlin.jvm.internal.r) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onOperatorDisconnectTimeout$1", f = "SNSVideoIdentViewModel.kt", l = {831}, m = "invokeSuspend")
    public static final class m0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36860b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m0(h hVar, kotlin.coroutines.c<? super m0> cVar) {
            super(2, cVar);
            this.f36860b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((m0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m0(this.f36860b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36859a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36860b;
                this.f36859a = 1;
                obj = hVar.e((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {167, 176, 178}, m = "videoCallState")
    public static final class m1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36861a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36862b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36863c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36864d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36866f;

        /* renamed from: g  reason: collision with root package name */
        public int f36867g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m1(h hVar, kotlin.coroutines.c<? super m1> cVar) {
            super(cVar);
            this.f36866f = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36865e = obj;
            this.f36867g |= Integer.MIN_VALUE;
            return this.f36866f.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleModeratorName$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36868a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSViewState f36869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36870c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(SNSViewState sNSViewState, h hVar, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f36869b = sNSViewState;
            this.f36870c = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((n) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n(this.f36869b, this.f36870c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36868a == 0) {
                kotlin.k.b(obj);
                SNSViewState.e eVar = (SNSViewState.e) this.f36869b;
                e O = eVar.O();
                return SNSViewState.e.a(eVar, (SNSViewState.VideoStepState) null, (SNSViewState.ErrorState) null, false, false, false, false, false, (CharSequence) null, (CharSequence) null, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, false, false, O != null ? e.a(O, false, this.f36870c.F(), false, 5, (Object) null) : null, (CharSequence) null, (List) null, (Bitmap) null, (SNSViewState.e) null, (AnalyticsCallState) null, (SNSViewState.a) null, (SNSViewState.e.a.C0498a) null, 16711679, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPhotoMade$1", f = "SNSVideoIdentViewModel.kt", l = {1081, 1089}, m = "invokeSuspend")
    public static final class n0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36871a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36872b;

        /* renamed from: c  reason: collision with root package name */
        public int f36873c;

        /* renamed from: d  reason: collision with root package name */
        public int f36874d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f36875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bitmap f36876f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f36877g;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPhotoMade$1$1", f = "SNSVideoIdentViewModel.kt", l = {1073}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36878a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36879b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h hVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36879b = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((a) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36879b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36878a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36879b;
                    this.f36878a = 1;
                    obj = hVar.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPhotoMade$1$2", f = "SNSVideoIdentViewModel.kt", l = {1077}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36880a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36881b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(h hVar, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f36881b = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((b) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f36881b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36880a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36881b;
                    this.f36880a = 1;
                    obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPhotoMade$1$4", f = "SNSVideoIdentViewModel.kt", l = {1125, 1125}, m = "invokeSuspend")
        public static final class c extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36882a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f36883b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ h f36884c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Ref$BooleanRef ref$BooleanRef, h hVar, kotlin.coroutines.c<? super c> cVar) {
                super(2, cVar);
                this.f36883b = ref$BooleanRef;
                this.f36884c = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((c) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new c(this.f36883b, this.f36884c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36882a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    if (this.f36883b.element) {
                        h hVar = this.f36884c;
                        this.f36882a = 1;
                        obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
                        if (obj == d11) {
                            return d11;
                        }
                    } else {
                        h hVar2 = this.f36884c;
                        this.f36882a = 2;
                        obj = hVar2.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
                        if (obj == d11) {
                            return d11;
                        }
                    }
                } else if (i11 == 1 || i11 == 2) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (SNSViewState) obj;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPhotoMade$1$5", f = "SNSVideoIdentViewModel.kt", l = {1135}, m = "invokeSuspend")
        public static final class d extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36885a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36886b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef<Exception> f36887c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(h hVar, Ref$ObjectRef<Exception> ref$ObjectRef, kotlin.coroutines.c<? super d> cVar) {
                super(2, cVar);
                this.f36886b = hVar;
                this.f36887c = ref$ObjectRef;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((d) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new d(this.f36886b, this.f36887c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36885a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36886b;
                    this.f36885a = 1;
                    obj = hVar.n((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref$ObjectRef<Exception> ref$ObjectRef = this.f36887c;
                SNSViewState.e eVar = (SNSViewState.e) obj;
                return ref$ObjectRef.element != null ? j.b(eVar, this.f36886b.h(), (Exception) ref$ObjectRef.element) : eVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(h hVar, Bitmap bitmap, Ref$BooleanRef ref$BooleanRef, kotlin.coroutines.c<? super n0> cVar) {
            super(2, cVar);
            this.f36875e = hVar;
            this.f36876f = bitmap;
            this.f36877g = ref$BooleanRef;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n0(this.f36875e, this.f36876f, this.f36877g, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x012d A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0154  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x015a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                r22 = this;
                r7 = r22
                java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r7.f36874d
                r1 = 2
                r9 = 4
                java.lang.String r10 = "SNSVideoIdent"
                r11 = 0
                r12 = 1
                r13 = 0
                if (r0 == 0) goto L_0x0042
                if (r0 == r12) goto L_0x0034
                if (r0 != r1) goto L_0x002c
                int r0 = r7.f36873c
                java.lang.Object r1 = r7.f36872b
                kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref$BooleanRef) r1
                java.lang.Object r2 = r7.f36871a
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
                kotlin.k.b(r23)
                r3 = r23
                kotlin.Result r3 = (kotlin.Result) r3
                java.lang.Object r3 = r3.m3081unboximpl()
                goto L_0x00c9
            L_0x002c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0034:
                java.lang.Object r0 = r7.f36872b
                com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload r0 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload) r0
                java.lang.Object r2 = r7.f36871a
                com.sumsub.sns.internal.core.data.model.Document r2 = (com.sumsub.sns.internal.core.data.model.Document) r2
                kotlin.k.b(r23)
                r3 = r23
                goto L_0x0075
            L_0x0042:
                kotlin.k.b(r23)
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.core.data.model.Document r2 = r0.H()
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload r0 = r0.I()
                if (r2 == 0) goto L_0x016b
                if (r0 != 0) goto L_0x0057
                goto L_0x016b
            L_0x0057:
                com.sumsub.sns.internal.videoident.presentation.h r3 = r7.f36875e
                com.sumsub.sns.internal.videoident.presentation.h$n0$b r4 = new com.sumsub.sns.internal.videoident.presentation.h$n0$b
                r4.<init>(r3, r13)
                com.sumsub.sns.core.presentation.base.a.a(r3, r11, r4, r12, r13)
                java.lang.String r3 = "onPhotoMade: compressing ..."
                com.sumsub.sns.internal.videoident.videoident.a.a(r10, r3, r13, r9, r13)
                android.graphics.Bitmap r3 = r7.f36876f
                r7.f36871a = r2
                r7.f36872b = r0
                r7.f36874d = r12
                java.lang.Object r3 = com.sumsub.sns.internal.core.common.m0.a(r3, r7)
                if (r3 != r8) goto L_0x0075
                return r8
            L_0x0075:
                r5 = r3
                java.io.InputStream r5 = (java.io.InputStream) r5
                kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
                r14.<init>()
                kotlin.jvm.internal.Ref$BooleanRef r15 = new kotlin.jvm.internal.Ref$BooleanRef
                r15.<init>()
                if (r5 == 0) goto L_0x0086
                r3 = r12
                goto L_0x0087
            L_0x0086:
                r3 = r11
            L_0x0087:
                r15.element = r3
                if (r5 == 0) goto L_0x0123
                java.lang.String r3 = "uploading photo ..."
                com.sumsub.sns.internal.videoident.videoident.a.a(r10, r3, r13, r9, r13)
                com.sumsub.sns.internal.videoident.presentation.h r3 = r7.f36875e
                com.sumsub.sns.internal.videoident.videoident.domain.b r3 = r3.K
                com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.getType()
                java.lang.String r4 = r0.l()
                if (r4 != 0) goto L_0x00a2
                java.lang.String r4 = ""
            L_0x00a2:
                com.sumsub.sns.internal.core.data.model.IdentitySide$b r6 = com.sumsub.sns.internal.core.data.model.IdentitySide.Companion
                java.lang.String r11 = r0.j()
                com.sumsub.sns.internal.core.data.model.IdentitySide r6 = r6.a(r11)
                java.lang.String r11 = r0.f()
                r7.f36871a = r14
                r7.f36872b = r15
                r7.f36873c = r12
                r7.f36874d = r1
                r0 = r3
                r1 = r2
                r2 = r4
                r3 = r6
                r4 = r11
                r6 = r22
                java.lang.Object r3 = r0.a(r1, r2, r3, r4, r5, r6)
                if (r3 != r8) goto L_0x00c6
                return r8
            L_0x00c6:
                r0 = r12
                r2 = r14
                r1 = r15
            L_0x00c9:
                boolean r4 = kotlin.Result.m3079isSuccessimpl(r3)
                r1.element = r4
                boolean r4 = kotlin.Result.m3078isFailureimpl(r3)
                if (r4 == 0) goto L_0x00e8
                java.lang.Throwable r4 = kotlin.Result.m3075exceptionOrNullimpl(r3)
                java.lang.Exception r4 = (java.lang.Exception) r4
                r2.element = r4
                java.lang.Throwable r4 = kotlin.Result.m3075exceptionOrNullimpl(r3)
                java.lang.Exception r4 = (java.lang.Exception) r4
                java.lang.String r5 = "failed uploading image"
                com.sumsub.sns.internal.videoident.videoident.a.a(r10, r5, r4)
            L_0x00e8:
                boolean r4 = kotlin.Result.m3078isFailureimpl(r3)
                if (r4 == 0) goto L_0x00ef
                r3 = r13
            L_0x00ef:
                com.sumsub.sns.internal.core.data.model.remote.k r3 = (com.sumsub.sns.internal.core.data.model.remote.k) r3
                if (r3 == 0) goto L_0x0120
                java.lang.String r3 = r3.q()
                if (r3 == 0) goto L_0x0120
                com.sumsub.sns.internal.videoident.presentation.h r4 = r7.f36875e
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "uploaded imageId="
                r5.append(r6)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                com.sumsub.sns.internal.videoident.videoident.a.a(r10, r5, r13, r9, r13)
                com.sumsub.sns.internal.videoident.presentation.g r4 = r4.N
                com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e r5 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e
                com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e$c r6 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e$c
                r6.<init>(r3)
                r5.<init>(r6)
                r4.sendMessage(r5)
            L_0x0120:
                r15 = r1
                r14 = r2
                goto L_0x0129
            L_0x0123:
                java.lang.String r0 = "onPhotoMade: failed to get image content stream!"
                com.sumsub.sns.internal.videoident.videoident.a.a(r10, r0, r13, r9, r13)
                r0 = 0
            L_0x0129:
                boolean r1 = r15.element
                if (r1 != 0) goto L_0x0140
                if (r0 != 0) goto L_0x0130
                goto L_0x0140
            L_0x0130:
                kotlin.jvm.internal.Ref$BooleanRef r0 = r7.f36877g
                r1 = 0
                r0.element = r1
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.videoident.presentation.h$n0$d r2 = new com.sumsub.sns.internal.videoident.presentation.h$n0$d
                r2.<init>(r0, r14, r13)
                com.sumsub.sns.core.presentation.base.a.a(r0, r1, r2, r12, r13)
                goto L_0x0168
            L_0x0140:
                r1 = 0
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                r0.e0()
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.videoident.presentation.h$n0$c r2 = new com.sumsub.sns.internal.videoident.presentation.h$n0$c
                r2.<init>(r15, r0, r13)
                com.sumsub.sns.core.presentation.base.a.a(r0, r1, r2, r12, r13)
                boolean r0 = r15.element
                if (r0 == 0) goto L_0x015a
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                r0.g0()
                goto L_0x0168
            L_0x015a:
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.videoident.presentation.g r0 = r0.N
                com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$d r1 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$d
                r1.<init>()
                r0.sendMessage(r1)
            L_0x0168:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x016b:
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
                com.sumsub.sns.internal.log.LoggerType[] r1 = new com.sumsub.sns.internal.log.LoggerType[r12]
                com.sumsub.sns.internal.log.LoggerType r2 = com.sumsub.sns.internal.log.LoggerType.KIBANA
                r3 = 0
                r1[r3] = r2
                com.sumsub.log.logger.Logger r16 = r0.a((com.sumsub.sns.internal.log.LoggerType[]) r1)
                r19 = 0
                r20 = 4
                r21 = 0
                java.lang.String r17 = "SNSVideoIdent"
                java.lang.String r18 = "selected document info missing"
                com.sumsub.log.logger.a.e(r16, r17, r18, r19, r20, r21)
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                r0.e0()
                com.sumsub.sns.internal.videoident.presentation.h r0 = r7.f36875e
                com.sumsub.sns.internal.videoident.presentation.h$n0$a r1 = new com.sumsub.sns.internal.videoident.presentation.h$n0$a
                r1.<init>(r0, r13)
                r2 = 0
                com.sumsub.sns.core.presentation.base.a.a(r0, r2, r1, r12, r13)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.n0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {225, 226, 228}, m = "waitingForOperatorState")
    public static final class n1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36888a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36889b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36890c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36891d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f36892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36893f;

        /* renamed from: g  reason: collision with root package name */
        public int f36894g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n1(h hVar, kotlin.coroutines.c<? super n1> cVar) {
            super(cVar);
            this.f36893f = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36892e = obj;
            this.f36894g |= Integer.MIN_VALUE;
            return this.f36893f.r((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handlePermissionResults$2", f = "SNSVideoIdentViewModel.kt", l = {526, 527, 528}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36895a;

        /* renamed from: b  reason: collision with root package name */
        public int f36896b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36897c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36898d;

        /* renamed from: e  reason: collision with root package name */
        public int f36899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36900f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(h hVar, kotlin.coroutines.c<? super o> cVar) {
            super(2, cVar);
            this.f36900f = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((o) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new o(this.f36900f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0084 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f36899e
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x003f
                if (r1 == r5) goto L_0x0037
                if (r1 == r3) goto L_0x002b
                if (r1 != r2) goto L_0x0023
                int r0 = r9.f36896b
                int r1 = r9.f36895a
                java.lang.Object r2 = r9.f36898d
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r9.f36897c
                java.lang.String r3 = (java.lang.String) r3
                kotlin.k.b(r10)
                goto L_0x008b
            L_0x0023:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x002b:
                int r1 = r9.f36896b
                int r3 = r9.f36895a
                java.lang.Object r6 = r9.f36897c
                java.lang.String r6 = (java.lang.String) r6
                kotlin.k.b(r10)
                goto L_0x006e
            L_0x0037:
                int r1 = r9.f36896b
                int r6 = r9.f36895a
                kotlin.k.b(r10)
                goto L_0x0055
            L_0x003f:
                kotlin.k.b(r10)
                com.sumsub.sns.internal.videoident.presentation.h r10 = r9.f36900f
                r9.f36895a = r5
                r9.f36896b = r4
                r9.f36899e = r5
                java.lang.String r1 = "sns_alert_lackOfCameraPermissions"
                java.lang.Object r10 = r10.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r1 = r4
                r6 = r5
            L_0x0055:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.h r7 = r9.f36900f
                r9.f36897c = r10
                r9.f36895a = r6
                r9.f36896b = r1
                r9.f36899e = r3
                java.lang.String r3 = "sns_alert_action_cancel"
                java.lang.Object r3 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r3 != r0) goto L_0x006a
                return r0
            L_0x006a:
                r8 = r6
                r6 = r10
                r10 = r3
                r3 = r8
            L_0x006e:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.h r7 = r9.f36900f
                r9.f36897c = r6
                r9.f36898d = r10
                r9.f36895a = r3
                r9.f36896b = r1
                r9.f36899e = r2
                java.lang.String r2 = "sns_alert_action_settings"
                java.lang.Object r2 = r7.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x0085
                return r0
            L_0x0085:
                r0 = r1
                r1 = r3
                r3 = r6
                r8 = r2
                r2 = r10
                r10 = r8
            L_0x008b:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.f r6 = new com.sumsub.sns.internal.videoident.presentation.f
                r6.<init>(r3, r10, r2)
                com.sumsub.sns.internal.videoident.presentation.SNSViewState$d r10 = new com.sumsub.sns.internal.videoident.presentation.SNSViewState$d
                if (r1 == 0) goto L_0x0098
                r1 = r5
                goto L_0x0099
            L_0x0098:
                r1 = r4
            L_0x0099:
                if (r0 == 0) goto L_0x009c
                r4 = r5
            L_0x009c:
                r10.<init>(r1, r4, r6)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class o0 extends Lambda implements d10.l<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f36901a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f36902b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o0(h hVar, Ref$BooleanRef ref$BooleanRef) {
            super(1);
            this.f36901a = hVar;
            this.f36902b = ref$BooleanRef;
        }

        public final void a(Throwable th2) {
            this.f36901a.r();
            if (th2 != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "error after photo made ", th2);
            }
            if (this.f36902b.element) {
                this.f36901a.d0();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handlePermissionResults$3", f = "SNSVideoIdentViewModel.kt", l = {541, 542, 543}, m = "invokeSuspend")
    public static final class p extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36903a;

        /* renamed from: b  reason: collision with root package name */
        public int f36904b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36905c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36906d;

        /* renamed from: e  reason: collision with root package name */
        public int f36907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f36908f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(h hVar, kotlin.coroutines.c<? super p> cVar) {
            super(2, cVar);
            this.f36908f = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((p) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new p(this.f36908f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0084 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f36907e
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x003f
                if (r1 == r5) goto L_0x0037
                if (r1 == r3) goto L_0x002b
                if (r1 != r2) goto L_0x0023
                int r0 = r9.f36904b
                int r1 = r9.f36903a
                java.lang.Object r2 = r9.f36906d
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r9.f36905c
                java.lang.String r3 = (java.lang.String) r3
                kotlin.k.b(r10)
                goto L_0x008b
            L_0x0023:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x002b:
                int r1 = r9.f36904b
                int r3 = r9.f36903a
                java.lang.Object r6 = r9.f36905c
                java.lang.String r6 = (java.lang.String) r6
                kotlin.k.b(r10)
                goto L_0x006e
            L_0x0037:
                int r1 = r9.f36904b
                int r6 = r9.f36903a
                kotlin.k.b(r10)
                goto L_0x0055
            L_0x003f:
                kotlin.k.b(r10)
                com.sumsub.sns.internal.videoident.presentation.h r10 = r9.f36908f
                r9.f36903a = r4
                r9.f36904b = r5
                r9.f36907e = r5
                java.lang.String r1 = "sns_alert_lackOfMicrophonePermissions"
                java.lang.Object r10 = r10.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r10 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r6 = r4
                r1 = r5
            L_0x0055:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.h r7 = r9.f36908f
                r9.f36905c = r10
                r9.f36903a = r6
                r9.f36904b = r1
                r9.f36907e = r3
                java.lang.String r3 = "sns_alert_action_cancel"
                java.lang.Object r3 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r3 != r0) goto L_0x006a
                return r0
            L_0x006a:
                r8 = r6
                r6 = r10
                r10 = r3
                r3 = r8
            L_0x006e:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.h r7 = r9.f36908f
                r9.f36905c = r6
                r9.f36906d = r10
                r9.f36903a = r3
                r9.f36904b = r1
                r9.f36907e = r2
                java.lang.String r2 = "sns_alert_action_settings"
                java.lang.Object r2 = r7.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r2 != r0) goto L_0x0085
                return r0
            L_0x0085:
                r0 = r1
                r1 = r3
                r3 = r6
                r8 = r2
                r2 = r10
                r10 = r8
            L_0x008b:
                java.lang.String r10 = (java.lang.String) r10
                com.sumsub.sns.internal.videoident.presentation.f r6 = new com.sumsub.sns.internal.videoident.presentation.f
                r6.<init>(r3, r10, r2)
                com.sumsub.sns.internal.videoident.presentation.SNSViewState$d r10 = new com.sumsub.sns.internal.videoident.presentation.SNSViewState$d
                if (r1 == 0) goto L_0x0098
                r1 = r5
                goto L_0x0099
            L_0x0098:
                r1 = r4
            L_0x0099:
                if (r0 == 0) goto L_0x009c
                r4 = r5
            L_0x009c:
                r10.<init>(r1, r4, r6)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPrepare$2", f = "SNSVideoIdentViewModel.kt", l = {330}, m = "invokeSuspend")
    public static final class p0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36910b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p0(h hVar, kotlin.coroutines.c<? super p0> cVar) {
            super(2, cVar);
            this.f36910b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((p0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new p0(this.f36910b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36909a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36910b;
                this.f36909a = 1;
                obj = hVar.a(false, (kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handlePermissionResults$4", f = "SNSVideoIdentViewModel.kt", l = {550}, m = "invokeSuspend")
    public static final class q extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36911a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36912b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(h hVar, kotlin.coroutines.c<? super q> cVar) {
            super(2, cVar);
            this.f36912b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((q) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new q(this.f36912b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36911a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36912b;
                this.f36911a = 1;
                obj = hVar.a(true, (kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPrepare$3", f = "SNSVideoIdentViewModel.kt", l = {335}, m = "invokeSuspend")
    public static final class q0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36914b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(h hVar, kotlin.coroutines.c<? super q0> cVar) {
            super(2, cVar);
            this.f36914b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((q0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new q0(this.f36914b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36913a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36914b;
                this.f36913a = 1;
                if (hVar.l((kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleQueueStatusUpdated$2", f = "SNSVideoIdentViewModel.kt", l = {488}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f36917c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(h hVar, long j11, kotlin.coroutines.c<? super r> cVar) {
            super(2, cVar);
            this.f36916b = hVar;
            this.f36917c = j11;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((r) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new r(this.f36916b, this.f36917c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36915a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36916b;
                this.f36915a = 1;
                obj = hVar.r((kotlin.coroutines.c<? super SNSViewState.e>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return j.b((SNSViewState.e) obj, this.f36916b.h(), this.f36917c);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onPrepare$4", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class r0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36918a;

        public r0(kotlin.coroutines.c<? super r0> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((r0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new r0(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36918a == 0) {
                kotlin.k.b(obj);
                return new SNSViewState.d(false, false, (f) null, 7, (kotlin.jvm.internal.r) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleReadyForScreenshot$1", f = "SNSVideoIdentViewModel.kt", l = {947}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36919a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a f36921c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(h hVar, c.a aVar, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f36920b = hVar;
            this.f36921c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((s) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s(this.f36920b, this.f36921c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36919a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36920b;
                this.f36919a = 1;
                obj = hVar.k((kotlin.coroutines.c<? super SNSViewState.e>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.a aVar = this.f36921c;
            SNSViewState.e eVar = (SNSViewState.e) obj;
            eVar.c(aVar.e());
            eVar.b(aVar.d());
            eVar.d(aVar.f());
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onUploadCancel$1", f = "SNSVideoIdentViewModel.kt", l = {1164}, m = "invokeSuspend")
    public static final class s0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36922a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36923b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s0(h hVar, kotlin.coroutines.c<? super s0> cVar) {
            super(2, cVar);
            this.f36923b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((s0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s0(this.f36923b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36922a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36923b;
                this.f36922a = 1;
                obj = hVar.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleReadyForScreenshot$2", f = "SNSVideoIdentViewModel.kt", l = {957}, m = "invokeSuspend")
    public static final class t extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a f36926c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(h hVar, c.a aVar, kotlin.coroutines.c<? super t> cVar) {
            super(2, cVar);
            this.f36925b = hVar;
            this.f36926c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((t) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new t(this.f36925b, this.f36926c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36924a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36925b;
                this.f36924a = 1;
                obj = hVar.k((kotlin.coroutines.c<? super SNSViewState.e>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c.a aVar = this.f36926c;
            SNSViewState.e eVar = (SNSViewState.e) obj;
            eVar.c(aVar.e());
            eVar.b(aVar.d());
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {1193}, m = "onUploadFileForDocSetType")
    public static final class t0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36927a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36929c;

        /* renamed from: d  reason: collision with root package name */
        public int f36930d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(h hVar, kotlin.coroutines.c<? super t0> cVar) {
            super(cVar);
            this.f36929c = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36928b = obj;
            this.f36930d |= Integer.MIN_VALUE;
            return this.f36929c.a((String) null, (File) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleRequestLanguagesErrorAction$1", f = "SNSVideoIdentViewModel.kt", l = {404}, m = "invokeSuspend")
    public static final class u extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36932b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(h hVar, kotlin.coroutines.c<? super u> cVar) {
            super(2, cVar);
            this.f36932b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((u) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u(this.f36932b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36931a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f36932b.b(true);
                h hVar = this.f36932b;
                this.f36931a = 1;
                if (hVar.l((kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onUploadFileForDocSetType$2", f = "SNSVideoIdentViewModel.kt", l = {1190}, m = "invokeSuspend")
    public static final class u0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36934b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u0(h hVar, kotlin.coroutines.c<? super u0> cVar) {
            super(2, cVar);
            this.f36934b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((u0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u0(this.f36934b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36933a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36934b;
                this.f36933a = 1;
                obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleRetryUpload$2$1$1", f = "SNSVideoIdentViewModel.kt", l = {574}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36935a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36936b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36937c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ File f36938d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(h hVar, String str, File file, kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
            this.f36936b = hVar;
            this.f36937c = str;
            this.f36938d = file;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((v) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new v(this.f36936b, this.f36937c, this.f36938d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36935a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36936b;
                String str = this.f36937c;
                File file = this.f36938d;
                this.f36935a = 1;
                if (hVar.a(str, file, (kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onUploadFileForDocSetType$3", f = "SNSVideoIdentViewModel.kt", l = {1222}, m = "invokeSuspend")
    public static final class v0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36939a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36940b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Exception f36941c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(h hVar, Exception exc, kotlin.coroutines.c<? super v0> cVar) {
            super(2, cVar);
            this.f36940b = hVar;
            this.f36941c = exc;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((v0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new v0(this.f36940b, this.f36941c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36939a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36940b;
                this.f36939a = 1;
                obj = hVar.n((kotlin.coroutines.c<? super SNSViewState.e>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return j.b((SNSViewState.e) obj, this.f36940b.h(), this.f36941c);
        }
    }

    public static final class w extends Lambda implements d10.l<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f36942a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(h hVar) {
            super(1);
            this.f36942a = hVar;
        }

        public final void a(Throwable th2) {
            this.f36942a.r();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onUploadFileForDocSetType$4", f = "SNSVideoIdentViewModel.kt", l = {1232, 1234}, m = "invokeSuspend")
    public static final class w0 extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36943a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f36944b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36945c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(Object obj, h hVar, kotlin.coroutines.c<? super w0> cVar) {
            super(2, cVar);
            this.f36944b = obj;
            this.f36945c = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((w0) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new w0(this.f36944b, this.f36945c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36943a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                if (Result.m3079isSuccessimpl(this.f36944b)) {
                    this.f36945c.g0();
                    h hVar = this.f36945c;
                    this.f36943a = 1;
                    obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else {
                    h hVar2 = this.f36945c;
                    this.f36943a = 2;
                    obj = hVar2.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
                    if (obj == d11) {
                        return d11;
                    }
                    return (SNSViewState) obj;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                kotlin.k.b(obj);
                return (SNSViewState) obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (SNSViewState) obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleStepChange$2", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class x extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<SNSViewState> f36947b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(Ref$ObjectRef<SNSViewState> ref$ObjectRef, kotlin.coroutines.c<? super x> cVar) {
            super(2, cVar);
            this.f36947b = ref$ObjectRef;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((x) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new x(this.f36947b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36946a == 0) {
                kotlin.k.b(obj);
                return this.f36947b.element;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onWaitForStatusUpdateTimeout$1", f = "SNSVideoIdentViewModel.kt", l = {1342}, m = "invokeSuspend")
    public static final class x0 extends SuspendLambda implements d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36948a;

        /* renamed from: b  reason: collision with root package name */
        public int f36949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36950c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$onWaitForStatusUpdateTimeout$1$1", f = "SNSVideoIdentViewModel.kt", l = {1343}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36951a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f36952b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h hVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36952b = hVar;
            }

            /* renamed from: a */
            public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
                return ((a) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36952b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36951a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    h hVar = this.f36952b;
                    this.f36951a = 1;
                    obj = hVar.q((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x0(h hVar, kotlin.coroutines.c<? super x0> cVar) {
            super(2, cVar);
            this.f36950c = hVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((x0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new x0(this.f36950c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.l lVar;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36949b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a.l c11 = this.f36950c.c();
                h hVar = this.f36950c;
                this.f36948a = c11;
                this.f36949b = 1;
                Object m11 = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
                if (m11 == d11) {
                    return d11;
                }
                lVar = c11;
                obj = m11;
            } else if (i11 == 1) {
                lVar = (a.l) this.f36948a;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (kotlin.jvm.internal.x.b(lVar, obj)) {
                h hVar2 = this.f36950c;
                com.sumsub.sns.core.presentation.base.a.a(hVar2, false, new a(hVar2, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleUpdateDocsStatus$2", f = "SNSVideoIdentViewModel.kt", l = {1288}, m = "invokeSuspend")
    public static final class y extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36953a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f36954b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(h hVar, kotlin.coroutines.c<? super y> cVar) {
            super(2, cVar);
            this.f36954b = hVar;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((y) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new y(this.f36954b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36953a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h hVar = this.f36954b;
                this.f36953a = 1;
                obj = hVar.p((kotlin.coroutines.c<? super SNSViewState.e>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {258, 259, 260, 263, 264, 265}, m = "previewState")
    public static final class y0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36955a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36956b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36957c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36958d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36959e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36960f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36961g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f36962h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f36963i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ h f36964j;

        /* renamed from: k  reason: collision with root package name */
        public int f36965k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y0(h hVar, kotlin.coroutines.c<? super y0> cVar) {
            super(cVar);
            this.f36964j = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36963i = obj;
            this.f36965k |= Integer.MIN_VALUE;
            return this.f36964j.a(false, (kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel$handleVideoChatState$1", f = "SNSVideoIdentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class z extends SuspendLambda implements d10.p<SNSViewState, kotlin.coroutines.c<? super SNSViewState>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36966a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSViewState f36967b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(SNSViewState sNSViewState, kotlin.coroutines.c<? super z> cVar) {
            super(2, cVar);
            this.f36967b = sNSViewState;
        }

        /* renamed from: a */
        public final Object invoke(SNSViewState sNSViewState, kotlin.coroutines.c<? super SNSViewState> cVar) {
            return ((z) create(sNSViewState, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new z(this.f36967b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36966a == 0) {
                kotlin.k.b(obj);
                return ((SNSViewState.e) this.f36967b).N();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.SNSVideoIdentViewModel", f = "SNSVideoIdentViewModel.kt", l = {247}, m = "previewStateLoading")
    public static final class z0 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36968a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f36970c;

        /* renamed from: d  reason: collision with root package name */
        public int f36971d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z0(h hVar, kotlin.coroutines.c<? super z0> cVar) {
            super(cVar);
            this.f36970c = hVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36969b = obj;
            this.f36971d |= Integer.MIN_VALUE;
            return this.f36970c.j((kotlin.coroutines.c<? super SNSViewState.e>) this);
        }
    }

    static {
        Class<h> cls = h.class;
        f36696r = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, f36697s, "isChatRunning()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "updatedDocuments", "getUpdatedDocuments()Ljava/util/List;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "selectedDocument", "getSelectedDocument()Lcom/sumsub/sns/internal/core/data/model/Document;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "selectedDocumentPayload", "getSelectedDocumentPayload()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "operatorName", "getOperatorName()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "finishOnDisconnect", "getFinishOnDisconnect()Z", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "speakingLanguage", "getSpeakingLanguage()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "operatorCompletedCall", "getOperatorCompletedCall()Z", 0))};
    }

    public h(List<Document> list, kotlinx.serialization.json.a aVar, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.videoident.videoident.domain.d dVar, com.sumsub.sns.internal.videoident.videoident.domain.e eVar, com.sumsub.sns.internal.videoident.videoident.domain.c cVar, com.sumsub.sns.internal.videoident.videoident.domain.b bVar2, com.sumsub.sns.internal.videoident.videoident.domain.a aVar3, com.sumsub.sns.internal.domain.j jVar, g gVar, com.sumsub.sns.internal.core.common.c1 c1Var, com.sumsub.sns.internal.core.data.source.applicant.b bVar3) {
        super(aVar2, bVar);
        this.E = list;
        this.F = aVar;
        this.G = bVar;
        this.H = dVar;
        this.I = eVar;
        this.J = cVar;
        this.K = bVar2;
        this.L = aVar3;
        this.M = jVar;
        this.N = gVar;
        this.O = c1Var;
        this.P = bVar3;
        Boolean bool = Boolean.FALSE;
        this.R = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, f36697s, bool);
        this.S = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, FileUtil.DOCUMENTS_DIR, CollectionsKt__CollectionsKt.k());
        this.T = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "selectedDocument", null);
        this.U = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "selectedDocumentPayload", null);
        this.V = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "operatorName", null);
        this.X = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "finishOnDisconnect", bool);
        this.Y = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "speakingLanguage", null);
        this.Z = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "operatorCompletedCall", bool);
        this.f36708d0 = TimeUnit.SECONDS.toMillis(1);
        this.f36709e0 = TimeUnit.MINUTES.toSeconds(2);
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " created view model, " + this, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.common.b0.b(bVar.b(), androidx.lifecycle.m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
        com.sumsub.sns.internal.core.common.b0.b(bVar.a(), androidx.lifecycle.m0.a(this), new b(this, (kotlin.coroutines.c<? super b>) null));
        this.f36710f0 = D;
        this.f36711g0 = new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"};
    }

    public final d10.l<Boolean, Unit> A() {
        return this.f36714j0;
    }

    public final d10.l<String, Unit> B() {
        return this.f36715k0;
    }

    public final d10.a<Unit> C() {
        return this.f36712h0;
    }

    public final boolean D() {
        return ((Boolean) this.Z.a(this, f36696r[7])).booleanValue();
    }

    public final long E() {
        return this.f36710f0;
    }

    public final String F() {
        return (String) this.V.a(this, f36696r[4]);
    }

    public final String[] G() {
        return this.f36711g0;
    }

    public final Document H() {
        return (Document) this.T.a(this, f36696r[2]);
    }

    public final SNSMessage.ServerMessage.ScreenShotPayload I() {
        return (SNSMessage.ServerMessage.ScreenShotPayload) this.U.a(this, f36696r[3]);
    }

    public final String J() {
        return (String) this.Y.a(this, f36696r[6]);
    }

    public final List<Document> K() {
        return (List) this.S.a(this, f36696r[1]);
    }

    public final void L() {
        SNSVideoChatState state = this.N.getState();
        if (state != null && state.isConnected()) {
            r();
            d(true);
            this.N.disconnect();
            return;
        }
        d10.l<? super Boolean, Unit> lVar = this.f36714j0;
        if (lVar != null) {
            lVar.invoke(Boolean.TRUE);
        }
    }

    public final void M() {
        if (this.f36718n0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleCancelScreenshot: skipping. Upload is in progress", (Throwable) null, 4, (Object) null);
            return;
        }
        e0();
        com.sumsub.sns.core.presentation.base.a.a(this, false, new j(this, (kotlin.coroutines.c<? super j>) null), 1, (Object) null);
    }

    public final void N() {
        kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new u(this, (kotlin.coroutines.c<? super u>) null), 3, (Object) null);
    }

    public final void O() {
        Document H2;
        DocumentType type;
        String c11;
        Bitmap bitmap = this.f36706b0;
        if (bitmap != null) {
            a(bitmap);
            return;
        }
        File file = this.f36707c0;
        if (file == null || (H2 = H()) == null || (type = H2.getType()) == null || (c11 = type.c()) == null) {
            a0();
            return;
        }
        r();
        kotlinx.coroutines.n1 d11 = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new v(this, c11, file, (kotlin.coroutines.c<? super v>) null), 3, (Object) null);
        this.f36718n0 = d11;
        d11.L(new w(this));
    }

    public final boolean P() {
        return ((Boolean) this.R.a(this, f36696r[0])).booleanValue();
    }

    public final void Q() {
        com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.g> g11;
        com.sumsub.sns.internal.core.data.model.g d11;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onBackPressed", (Throwable) null, 4, (Object) null);
        kotlinx.coroutines.i0.f(this.Q, (CancellationException) null, 1, (Object) null);
        if (!this.W) {
            this.W = true;
            SNSVideoChatState state = this.N.getState();
            boolean z11 = false;
            if (state != null && state.isConnected()) {
                this.N.disconnect();
            }
            b.a value = this.G.b().getValue();
            if (!(value == null || (g11 = value.g()) == null || (d11 = g11.d()) == null || !d11.A())) {
                z11 = true;
            }
            d10.l<? super Boolean, Unit> lVar = this.f36714j0;
            if (lVar != null) {
                lVar.invoke(Boolean.valueOf(true ^ z11));
            }
        }
    }

    public final void R() {
        kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h0(this, (kotlin.coroutines.c<? super h0>) null), 3, (Object) null);
    }

    public final kotlinx.coroutines.n1 S() {
        return kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new k0(this, (kotlin.coroutines.c<? super k0>) null), 3, (Object) null);
    }

    public final void T() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new l0(this, (kotlin.coroutines.c<? super l0>) null), 1, (Object) null);
    }

    public final void U() {
        u();
    }

    public final void V() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onOperatorDisconnectTimeout", (Throwable) null, 4, (Object) null);
        q();
        if (kotlin.jvm.internal.x.b(this.N.getState(), SNSVideoChatState.e.f37041a)) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new m0(this, (kotlin.coroutines.c<? super m0>) null), 1, (Object) null);
            this.N.disconnect();
        }
    }

    public final void W() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " onPhotoMakeError!", (Throwable) null, 4, (Object) null);
        e0();
        this.N.sendMessage(new SNSMessage.ClientMessage.d());
    }

    public final void X() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " onSelectingFileError!", (Throwable) null, 4, (Object) null);
        e0();
        this.N.sendMessage(new SNSMessage.ClientMessage.d());
    }

    public final void Y() {
        if (Build.VERSION.SDK_INT < 33 || com.sumsub.sns.internal.ff.a.f34215a.E().g()) {
            u();
        } else {
            a((a.j) new a.i("android.permission.POST_NOTIFICATIONS"));
        }
    }

    public final void Z() {
        Document H2 = H();
        if (H2 == null) {
            com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), SNSVideoIdent.logTag, "onUploadCurrentDocumentClick: no current document", (Throwable) null, 4, (Object) null);
            return;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "upload click " + H2, (Throwable) null, 4, (Object) null);
        d0();
        this.f36707c0 = null;
        d10.l<? super String, Unit> lVar = this.f36715k0;
        if (lVar != null) {
            lVar.invoke(H2.getType().c());
        }
    }

    public final void a0() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onUploadCancel!", (Throwable) null, 4, (Object) null);
        d0();
        this.N.sendMessage(new SNSMessage.ClientMessage.d());
        e0();
        com.sumsub.sns.core.presentation.base.a.a(this, false, new s0(this, (kotlin.coroutines.c<? super s0>) null), 1, (Object) null);
    }

    public final void b0() {
    }

    public final void c0() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onWaitForStatusUpdateTimeout", (Throwable) null, 4, (Object) null);
        s();
        kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new x0(this, (kotlin.coroutines.c<? super x0>) null), 3, (Object) null);
    }

    public final void d0() {
        Bitmap bitmap = this.f36706b0;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "releaseUploadedBitmap", (Throwable) null, 4, (Object) null);
                bitmap.recycle();
            }
            this.f36706b0 = null;
        }
    }

    public final void e0() {
        this.f36705a0 = false;
        a((Document) null);
        a((SNSMessage.ServerMessage.ScreenShotPayload) null);
        d0();
        this.f36707c0 = null;
    }

    public final void f0() {
        if (this.f36717m0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "scheduleDisconnectTimeout: already scheduled", (Throwable) null, 4, (Object) null);
            return;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "scheduleDisconnectTimeout", (Throwable) null, 4, (Object) null);
        this.f36717m0 = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new f1(this, (kotlin.coroutines.c<? super f1>) null), 3, (Object) null);
    }

    public final void g0() {
        if (this.f36716l0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "scheduleWaitForStatusUpdate: already scheduled", (Throwable) null, 4, (Object) null);
            return;
        }
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "scheduleWaitForStatusUpdate", (Throwable) null, 4, (Object) null);
        this.f36716l0 = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new g1(this, (kotlin.coroutines.c<? super g1>) null), 3, (Object) null);
    }

    public void onCleared() {
        super.onCleared();
        q();
        s();
        d0();
        r();
        kotlinx.coroutines.i0.f(this.Q, (CancellationException) null, 1, (Object) null);
        this.f36707c0 = null;
    }

    /* renamed from: v */
    public SNSViewState.c e() {
        return SNSViewState.c.f36612a;
    }

    public final List<Document> w() {
        List<Document> K2 = K();
        if (!(!K2.isEmpty())) {
            K2 = null;
        }
        return K2 == null ? this.E : K2;
    }

    public final boolean x() {
        return ((Boolean) this.X.a(this, f36696r[5])).booleanValue();
    }

    public final kotlinx.serialization.json.a y() {
        return this.F;
    }

    public final d10.a<Unit> z() {
        return this.f36713i0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object q(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.videoident.presentation.h.m1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.videoident.presentation.h$m1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.m1) r0
            int r1 = r0.f36867g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36867g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$m1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$m1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f36865e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36867g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0065
            if (r2 == r5) goto L_0x0059
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r1 = r0.f36864d
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.f36863c
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.f36862b
            com.sumsub.sns.internal.videoident.presentation.e r3 = (com.sumsub.sns.internal.videoident.presentation.e) r3
            java.lang.Object r0 = r0.f36861a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r14)
            goto L_0x00e8
        L_0x0040:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0048:
            java.lang.Object r2 = r0.f36863c
            com.sumsub.sns.internal.videoident.presentation.e r2 = (com.sumsub.sns.internal.videoident.presentation.e) r2
            java.lang.Object r4 = r0.f36862b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r4
            java.lang.Object r5 = r0.f36861a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r14)
            goto L_0x00cc
        L_0x0059:
            java.lang.Object r2 = r0.f36862b
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState r2 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState) r2
            java.lang.Object r6 = r0.f36861a
            com.sumsub.sns.internal.videoident.presentation.h r6 = (com.sumsub.sns.internal.videoident.presentation.h) r6
            kotlin.k.b(r14)
            goto L_0x008b
        L_0x0065:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.videoident.presentation.g r14 = r13.N
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState r2 = r14.getState()
            boolean r14 = r2 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d
            if (r14 == 0) goto L_0x0090
            r14 = r2
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState$d r14 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d) r14
            boolean r14 = r14.f()
            if (r14 != 0) goto L_0x0090
            r0.f36861a = r13
            r0.f36862b = r2
            r0.f36867g = r5
            java.lang.String r14 = "sns_videoident_state_connecting"
            java.lang.Object r14 = r13.a((java.lang.String) r14, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r14 != r1) goto L_0x008a
            return r1
        L_0x008a:
            r6 = r13
        L_0x008b:
            java.lang.String r14 = (java.lang.String) r14
            r8 = r14
            r14 = r6
            goto L_0x0096
        L_0x0090:
            java.lang.String r14 = r13.F()
            r8 = r14
            r14 = r13
        L_0x0096:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r12 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            boolean r6 = r2 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d
            if (r6 == 0) goto L_0x00a6
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState$d r2 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d) r2
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x00a6
            r7 = r5
            goto L_0x00a8
        L_0x00a6:
            r2 = 0
            r7 = r2
        L_0x00a8:
            com.sumsub.sns.internal.videoident.presentation.e r2 = new com.sumsub.sns.internal.videoident.presentation.e
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11)
            boolean r6 = r14.f36705a0
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            r0.f36861a = r14
            r0.f36862b = r12
            r0.f36863c = r2
            r0.f36867g = r4
            java.lang.String r4 = "sns_videoident_state_followIntructions_text"
            java.lang.Object r4 = r14.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r5 = r14
            r14 = r4
            r4 = r12
        L_0x00cc:
            java.lang.String r14 = (java.lang.String) r14
            java.util.List r6 = r5.t()
            r0.f36861a = r4
            r0.f36862b = r2
            r0.f36863c = r14
            r0.f36864d = r6
            r0.f36867g = r3
            java.lang.Object r0 = r5.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x00e3
            return r1
        L_0x00e3:
            r3 = r2
            r1 = r6
            r2 = r14
            r14 = r0
            r0 = r4
        L_0x00e8:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r14 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r14
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r14 = r0.a((java.lang.CharSequence) r2, (com.sumsub.sns.internal.videoident.presentation.e) r3, (java.util.List<com.sumsub.sns.internal.videoident.presentation.SNSStepViewItem>) r1, (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.q(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.h.n1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.videoident.presentation.h$n1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.n1) r0
            int r1 = r0.f36894g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36894g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$n1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$n1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36892e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36894g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r5) goto L_0x005b
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r1 = r0.f36891d
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.f36890c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r3 = r0.f36889b
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r0 = r0.f36888a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r9)
            goto L_0x00af
        L_0x0040:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0048:
            java.lang.Object r2 = r0.f36890c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f36889b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r4
            java.lang.Object r5 = r0.f36888a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r9)
            r7 = r4
            r4 = r2
            r2 = r7
            goto L_0x0092
        L_0x005b:
            java.lang.Object r2 = r0.f36889b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            java.lang.Object r5 = r0.f36888a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r9)
            goto L_0x007c
        L_0x0067:
            kotlin.k.b(r9)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r0.f36888a = r8
            r0.f36889b = r2
            r0.f36894g = r5
            java.lang.String r9 = "sns_videoident_warning_waitForConnect"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r5 = r8
        L_0x007c:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.f36888a = r5
            r0.f36889b = r2
            r0.f36890c = r9
            r0.f36894g = r4
            java.lang.String r4 = "sns_videoident_state_followIntructions_text"
            java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x008f
            return r1
        L_0x008f:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x0092:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.util.List r6 = r5.t()
            r0.f36888a = r2
            r0.f36889b = r4
            r0.f36890c = r9
            r0.f36891d = r6
            r0.f36894g = r3
            java.lang.Object r0 = r5.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r3 = r4
            r1 = r6
            r7 = r2
            r2 = r9
            r9 = r0
            r0 = r7
        L_0x00af:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r9 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r9
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r9 = r0.a((java.lang.CharSequence) r3, (java.lang.CharSequence) r2, (java.util.List<com.sumsub.sns.internal.videoident.presentation.SNSStepViewItem>) r1, (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.r(kotlin.coroutines.c):java.lang.Object");
    }

    public final void s() {
        kotlinx.coroutines.n1 n1Var = this.f36716l0;
        if (n1Var != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "cancelWaitForUpdateStatusJob", (Throwable) null, 4, (Object) null);
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            this.f36716l0 = null;
        }
    }

    public final List<SNSStepViewItem> t() {
        List<Document> w11 = w();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(w11, 10));
        int i11 = 0;
        for (T next : w11) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            Document document = (Document) next;
            arrayList.add(new SNSStepViewItem(document.getType().b(), document.getType().a(h()), b(document)));
            i11 = i12;
        }
        return arrayList;
    }

    public final void u() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new g(this, (kotlin.coroutines.c<? super g>) null), 1, (Object) null);
        kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new C0502h(this, (kotlin.coroutines.c<? super C0502h>) null), 3, (Object) null);
    }

    public final void b(d10.a<Unit> aVar) {
        this.f36712h0 = aVar;
    }

    public final void c(boolean z11) {
        this.R.a(this, f36696r[0], Boolean.valueOf(z11));
    }

    public final void d(String str) {
        this.V.a(this, f36696r[4], str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.videoident.presentation.h.f
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.videoident.presentation.h$f r0 = (com.sumsub.sns.internal.videoident.presentation.h.f) r0
            int r1 = r0.f36765g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36765g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$f r0 = new com.sumsub.sns.internal.videoident.presentation.h$f
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f36763e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36765g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0067
            if (r2 == r5) goto L_0x005b
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r1 = r0.f36762d
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.f36761c
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.f36760b
            com.sumsub.sns.internal.videoident.presentation.e r3 = (com.sumsub.sns.internal.videoident.presentation.e) r3
            java.lang.Object r0 = r0.f36759a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r14)
            goto L_0x00ba
        L_0x0040:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0048:
            java.lang.Object r2 = r0.f36761c
            com.sumsub.sns.internal.videoident.presentation.e r2 = (com.sumsub.sns.internal.videoident.presentation.e) r2
            java.lang.Object r4 = r0.f36760b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r4
            java.lang.Object r5 = r0.f36759a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r14)
            r12 = r4
            r4 = r2
            r2 = r12
            goto L_0x009d
        L_0x005b:
            java.lang.Object r2 = r0.f36760b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            java.lang.Object r5 = r0.f36759a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r14)
            goto L_0x007c
        L_0x0067:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r0.f36759a = r13
            r0.f36760b = r2
            r0.f36765g = r5
            java.lang.String r14 = "sns_videoident_error_connectionLost_title"
            java.lang.Object r14 = r13.a((java.lang.String) r14, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r14 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r5 = r13
        L_0x007c:
            r8 = r14
            java.lang.String r8 = (java.lang.String) r8
            com.sumsub.sns.internal.videoident.presentation.e r14 = new com.sumsub.sns.internal.videoident.presentation.e
            r7 = 0
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            r0.f36759a = r5
            r0.f36760b = r2
            r0.f36761c = r14
            r0.f36765g = r4
            java.lang.String r4 = "sns_videoident_state_followIntructions_text"
            java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x009a
            return r1
        L_0x009a:
            r12 = r4
            r4 = r14
            r14 = r12
        L_0x009d:
            java.lang.String r14 = (java.lang.String) r14
            java.util.List r6 = r5.t()
            r0.f36759a = r2
            r0.f36760b = r4
            r0.f36761c = r14
            r0.f36762d = r6
            r0.f36765g = r3
            java.lang.Object r0 = r5.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            r3 = r4
            r1 = r6
            r12 = r2
            r2 = r14
            r14 = r0
            r0 = r12
        L_0x00ba:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r14 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r14
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r14 = r0.a((java.lang.CharSequence) r2, (com.sumsub.sns.internal.videoident.presentation.e) r3, (java.util.List<com.sumsub.sns.internal.videoident.presentation.SNSStepViewItem>) r1, (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.f(kotlin.coroutines.c):java.lang.Object");
    }

    public final Object g(kotlin.coroutines.c<? super SNSViewState> cVar) {
        a.l c11 = c();
        SNSViewState.e eVar = null;
        SNSViewState.e eVar2 = c11 instanceof SNSViewState.e ? (SNSViewState.e) c11 : null;
        if (eVar2 == null) {
            return c();
        }
        SNSViewState.e N2 = eVar2.N();
        if (N2 != null) {
            if (eVar2.isReconnecting()) {
                eVar = N2;
            }
            if (eVar != null) {
                return eVar;
            }
        }
        Object q11 = q((kotlin.coroutines.c<? super SNSViewState.e>) cVar);
        return q11 == IntrinsicsKt__IntrinsicsKt.d() ? q11 : (SNSViewState) q11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.h.i
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.videoident.presentation.h$i r0 = (com.sumsub.sns.internal.videoident.presentation.h.i) r0
            int r1 = r0.f36797e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36797e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$i r0 = new com.sumsub.sns.internal.videoident.presentation.h$i
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36795c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36797e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x005f
            if (r2 == r6) goto L_0x0057
            if (r2 == r5) goto L_0x004f
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r1 = r0.f36794b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r0 = r0.f36793a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.k.b(r9)
            goto L_0x00b6
        L_0x003b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0043:
            java.lang.Object r2 = r0.f36794b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f36793a
            com.sumsub.sns.internal.videoident.presentation.h r4 = (com.sumsub.sns.internal.videoident.presentation.h) r4
            kotlin.k.b(r9)
            goto L_0x00a2
        L_0x004f:
            java.lang.Object r2 = r0.f36793a
            com.sumsub.sns.internal.videoident.presentation.h r2 = (com.sumsub.sns.internal.videoident.presentation.h) r2
            kotlin.k.b(r9)
            goto L_0x008d
        L_0x0057:
            java.lang.Object r2 = r0.f36793a
            com.sumsub.sns.internal.videoident.presentation.h r2 = (com.sumsub.sns.internal.videoident.presentation.h) r2
            kotlin.k.b(r9)
            goto L_0x007c
        L_0x005f:
            kotlin.k.b(r9)
            com.sumsub.sns.internal.ff.a r9 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r9 = r9.s()
            boolean r9 = r9.g()
            if (r9 == 0) goto L_0x007f
            r0.f36793a = r8
            r0.f36797e = r6
            java.lang.String r9 = "sns_alert_aboutToExitVerification"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r2 = r8
        L_0x007c:
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x008f
        L_0x007f:
            r0.f36793a = r8
            r0.f36797e = r5
            java.lang.String r9 = "sns_videoident_alert_aboutToExit"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r2 = r8
        L_0x008d:
            java.lang.String r9 = (java.lang.String) r9
        L_0x008f:
            r0.f36793a = r2
            r0.f36794b = r9
            r0.f36797e = r4
            java.lang.String r4 = "sns_alert_action_confirm"
            java.lang.Object r4 = r2.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x009e
            return r1
        L_0x009e:
            r7 = r2
            r2 = r9
            r9 = r4
            r4 = r7
        L_0x00a2:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.f36793a = r2
            r0.f36794b = r9
            r0.f36797e = r3
            java.lang.String r3 = "sns_alert_action_cancel"
            java.lang.Object r0 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            r1 = r9
            r9 = r0
            r0 = r2
        L_0x00b6:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r2 = new com.sumsub.sns.internal.videoident.presentation.SNSViewState$a
            r2.<init>(r0, r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.h(kotlin.coroutines.c):java.lang.Object");
    }

    public final Object i(kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleUpdateDocsStatus", (Throwable) null, 4, (Object) null);
        if (this.f36718n0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleUpdateDocsStatus: skipping. Upload is in progress", (Throwable) null, 4, (Object) null);
            return Unit.f56620a;
        }
        com.sumsub.sns.core.presentation.base.a.a(this, false, new y(this, (kotlin.coroutines.c<? super y>) null), 1, (Object) null);
        g0();
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleUpdateDocsStatus: requesting doc status update", (Throwable) null, 4, (Object) null);
        Object c11 = this.G.c(true, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) cVar);
        return c11 == IntrinsicsKt__IntrinsicsKt.d() ? c11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r39) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            boolean r2 = r1 instanceof com.sumsub.sns.internal.videoident.presentation.h.z0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.videoident.presentation.h$z0 r2 = (com.sumsub.sns.internal.videoident.presentation.h.z0) r2
            int r3 = r2.f36971d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36971d = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.videoident.presentation.h$z0 r2 = new com.sumsub.sns.internal.videoident.presentation.h$z0
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36969b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36971d
            r5 = 1
            if (r4 == 0) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            java.lang.Object r2 = r2.f36968a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            kotlin.k.b(r1)
            goto L_0x0050
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r2.f36968a = r1
            r2.f36971d = r5
            java.lang.String r4 = "sns_videoident_state_connecting"
            java.lang.Object r2 = r0.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x004b
            return r3
        L_0x004b:
            r37 = r2
            r2 = r1
            r1 = r37
        L_0x0050:
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 8
            r9 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r10 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.a(r2, r3, r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r32 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.CONNECTING
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 14680043(0xdfffeb, float:2.0571122E-38)
            r36 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.j(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.videoident.presentation.h.a1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.videoident.presentation.h$a1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.a1) r0
            int r1 = r0.f36729f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36729f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$a1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$a1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36727d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36729f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0063
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r1 = r0.f36726c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r2 = r0.f36725b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r0 = r0.f36724a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r8)
            goto L_0x00a3
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0044:
            java.lang.Object r2 = r0.f36726c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f36725b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r4
            java.lang.Object r5 = r0.f36724a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r8)
            r6 = r4
            r4 = r2
            r2 = r6
            goto L_0x008e
        L_0x0057:
            java.lang.Object r2 = r0.f36725b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            java.lang.Object r5 = r0.f36724a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r8)
            goto L_0x0078
        L_0x0063:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r0.f36724a = r7
            r0.f36725b = r2
            r0.f36729f = r5
            java.lang.String r8 = "sns_step_defaults_scan_frontSide_title"
            java.lang.Object r8 = r7.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r8 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r5 = r7
        L_0x0078:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.f36724a = r5
            r0.f36725b = r2
            r0.f36726c = r8
            r0.f36729f = r4
            java.lang.String r4 = "sns_step_defaults_scan_frontSide_brief"
            java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r6 = r4
            r4 = r8
            r8 = r6
        L_0x008e:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.f36724a = r2
            r0.f36725b = r4
            r0.f36726c = r8
            r0.f36729f = r3
            java.lang.Object r0 = r5.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r1 = r8
            r8 = r0
            r0 = r2
            r2 = r4
        L_0x00a3:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r8 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r8
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r8 = r0.a(r2, r1, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.k(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.h.b1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.videoident.presentation.h$b1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.b1) r0
            int r1 = r0.f36738d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36738d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$b1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$b1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36736b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36738d
            r3 = 4
            java.lang.String r4 = "SNSVideoIdent"
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r6) goto L_0x0038
            java.lang.Object r0 = r0.f36735a
            com.sumsub.sns.internal.videoident.presentation.h r0 = (com.sumsub.sns.internal.videoident.presentation.h) r0
            kotlin.k.b(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.m3081unboximpl()
            goto L_0x005e
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0040:
            kotlin.k.b(r9)
            java.lang.String r9 = "requestAvailableLanguages"
            com.sumsub.sns.internal.videoident.videoident.a.a(r4, r9, r7, r3, r7)
            com.sumsub.sns.internal.videoident.presentation.h$c1 r9 = new com.sumsub.sns.internal.videoident.presentation.h$c1
            r9.<init>(r7)
            com.sumsub.sns.core.presentation.base.a.a(r8, r5, r9, r6, r7)
            com.sumsub.sns.internal.videoident.videoident.domain.a r9 = r8.L
            r0.f36735a = r8
            r0.f36738d = r6
            java.lang.Object r9 = r9.a(r0)
            if (r9 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r0 = r8
        L_0x005e:
            boolean r1 = kotlin.Result.m3079isSuccessimpl(r9)
            if (r1 == 0) goto L_0x00ad
            boolean r1 = kotlin.Result.m3078isFailureimpl(r9)
            if (r1 == 0) goto L_0x006b
            r9 = r7
        L_0x006b:
            java.util.List r9 = (java.util.List) r9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "available languages "
            r1.append(r2)
            if (r9 == 0) goto L_0x0082
            int r2 = r9.size()
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.a.c(r2)
            goto L_0x0083
        L_0x0082:
            r2 = r7
        L_0x0083:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r4, r1, r7, r3, r7)
            if (r9 == 0) goto L_0x0098
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r1 = r5
            goto L_0x0099
        L_0x0098:
            r1 = r6
        L_0x0099:
            if (r1 == 0) goto L_0x00a4
            com.sumsub.sns.internal.videoident.presentation.h$d1 r9 = new com.sumsub.sns.internal.videoident.presentation.h$d1
            r9.<init>(r7)
            com.sumsub.sns.core.presentation.base.a.a(r0, r5, r9, r6, r7)
            goto L_0x00c4
        L_0x00a4:
            com.sumsub.sns.internal.videoident.presentation.h$e1 r1 = new com.sumsub.sns.internal.videoident.presentation.h$e1
            r1.<init>(r0, r9, r7)
            com.sumsub.sns.core.presentation.base.a.a(r0, r5, r1, r6, r7)
            goto L_0x00c4
        L_0x00ad:
            java.lang.Throwable r9 = kotlin.Result.m3075exceptionOrNullimpl(r9)
            if (r9 != 0) goto L_0x00b6
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x00b6:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$b r1 = new com.sumsub.sns.internal.videoident.presentation.SNSViewState$b
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            r1.<init>(r7, r2)
            java.lang.String r2 = "TYPE_UNKNOWN"
            r0.a((java.lang.Throwable) r9, (java.lang.String) r2, (java.lang.Object) r1)
        L_0x00c4:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.l(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r38) {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
            boolean r2 = r1 instanceof com.sumsub.sns.internal.videoident.presentation.h.h1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.videoident.presentation.h$h1 r2 = (com.sumsub.sns.internal.videoident.presentation.h.h1) r2
            int r3 = r2.f36792j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36792j = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.videoident.presentation.h$h1 r2 = new com.sumsub.sns.internal.videoident.presentation.h$h1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36790h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36792j
            r5 = 0
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x005e
            if (r4 == r7) goto L_0x004d
            if (r4 != r6) goto L_0x0045
            int r3 = r2.f36789g
            int r4 = r2.f36788f
            int r6 = r2.f36787e
            int r9 = r2.f36786d
            int r10 = r2.f36785c
            java.lang.Object r2 = r2.f36783a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r2
            kotlin.k.b(r1)
            r36 = r9
            r9 = r2
            r2 = r36
            goto L_0x00a3
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004d:
            java.lang.Object r4 = r2.f36784b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r4
            java.lang.Object r9 = r2.f36783a
            com.sumsub.sns.internal.videoident.presentation.h r9 = (com.sumsub.sns.internal.videoident.presentation.h) r9
            kotlin.k.b(r1)
            r36 = r9
            r9 = r4
            r4 = r36
            goto L_0x0074
        L_0x005e:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r4 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r2.f36783a = r0
            r2.f36784b = r4
            r2.f36792j = r7
            java.lang.String r1 = "sns_videoident_action_retry"
            java.lang.Object r1 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r1 != r3) goto L_0x0072
            return r3
        L_0x0072:
            r9 = r4
            r4 = r0
        L_0x0074:
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 8
            r16 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.a(r9, r10, r11, r12, r13, r14, r15, r16)
            r2.f36783a = r1
            r2.f36784b = r5
            r2.f36785c = r8
            r2.f36786d = r8
            r2.f36787e = r8
            r2.f36788f = r8
            r2.f36789g = r8
            r2.f36792j = r6
            java.lang.String r6 = "sns_videoident_error_connectionFailed_title"
            java.lang.Object r2 = r4.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x009c
            return r3
        L_0x009c:
            r9 = r1
            r1 = r2
            r2 = r8
            r3 = r2
            r4 = r3
            r6 = r4
            r10 = r6
        L_0x00a3:
            r22 = 0
            r21 = 0
            r20 = 0
            r19 = 0
            r18 = 0
            r17 = 0
            r11 = 0
            r12 = 0
            if (r10 == 0) goto L_0x00b5
            r13 = r7
            goto L_0x00b6
        L_0x00b5:
            r13 = r8
        L_0x00b6:
            if (r2 == 0) goto L_0x00ba
            r2 = r7
            goto L_0x00bb
        L_0x00ba:
            r2 = r8
        L_0x00bb:
            if (r6 == 0) goto L_0x00bf
            r14 = r7
            goto L_0x00c0
        L_0x00bf:
            r14 = r8
        L_0x00c0:
            if (r4 == 0) goto L_0x00c4
            r15 = r7
            goto L_0x00c5
        L_0x00c4:
            r15 = r8
        L_0x00c5:
            if (r3 == 0) goto L_0x00ca
            r16 = r7
            goto L_0x00cc
        L_0x00ca:
            r16 = r8
        L_0x00cc:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            com.sumsub.sns.internal.videoident.presentation.k r3 = new com.sumsub.sns.internal.videoident.presentation.k
            r23 = r3
            r3.<init>(r1, r5)
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r31 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.CONNECTION_FAILED
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 14671871(0xdfdfff, float:2.055967E-38)
            r35 = 0
            r10 = r12
            r12 = r13
            r13 = r2
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.m(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0101 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.videoident.presentation.h.j1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.videoident.presentation.h$j1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.j1) r0
            int r1 = r0.f36820j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36820j = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$j1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$j1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f36818h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36820j
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x00b6
            if (r2 == r7) goto L_0x00a6
            if (r2 == r6) goto L_0x0092
            if (r2 == r5) goto L_0x0074
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r1 = r0.f36813c
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r1
            java.lang.Object r2 = r0.f36812b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r2
            java.lang.Object r0 = r0.f36811a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r0
            kotlin.k.b(r15)
            goto L_0x0152
        L_0x0042:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x004a:
            java.lang.Object r2 = r0.f36817g
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r2 = (com.sumsub.sns.internal.videoident.presentation.ButtonAction) r2
            java.lang.Object r4 = r0.f36816f
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r0.f36815e
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r0.f36814d
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.Object r7 = r0.f36813c
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r7 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState) r7
            java.lang.Object r8 = r0.f36812b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r8 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r8
            java.lang.Object r9 = r0.f36811a
            com.sumsub.sns.internal.videoident.presentation.h r9 = (com.sumsub.sns.internal.videoident.presentation.h) r9
            kotlin.k.b(r15)
            r11 = r9
            r9 = r2
            r2 = r11
            r12 = r8
            r8 = r4
            r4 = r12
        L_0x006f:
            r13 = r7
            r7 = r5
            r5 = r13
            goto L_0x012d
        L_0x0074:
            java.lang.Object r2 = r0.f36815e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r5 = r0.f36814d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r0.f36813c
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r6 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState) r6
            java.lang.Object r7 = r0.f36812b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r7 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r7
            java.lang.Object r8 = r0.f36811a
            com.sumsub.sns.internal.videoident.presentation.h r8 = (com.sumsub.sns.internal.videoident.presentation.h) r8
            kotlin.k.b(r15)
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r2
            goto L_0x0109
        L_0x0092:
            java.lang.Object r2 = r0.f36814d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r6 = r0.f36813c
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r6 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState) r6
            java.lang.Object r7 = r0.f36812b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r7 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r7
            java.lang.Object r8 = r0.f36811a
            com.sumsub.sns.internal.videoident.presentation.h r8 = (com.sumsub.sns.internal.videoident.presentation.h) r8
            kotlin.k.b(r15)
            goto L_0x00eb
        L_0x00a6:
            java.lang.Object r2 = r0.f36813c
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState) r2
            java.lang.Object r7 = r0.f36812b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r7 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r7
            java.lang.Object r8 = r0.f36811a
            com.sumsub.sns.internal.videoident.presentation.h r8 = (com.sumsub.sns.internal.videoident.presentation.h) r8
            kotlin.k.b(r15)
            goto L_0x00d2
        L_0x00b6:
            kotlin.k.b(r15)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r15 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r2 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState.UPLOAD_ERROR
            r0.f36811a = r14
            r0.f36812b = r15
            r0.f36813c = r2
            r0.f36820j = r7
            java.lang.String r7 = "sns_videoident_error_uploadFailed_title"
            java.lang.Object r7 = r14.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r7 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r8 = r14
            r11 = r7
            r7 = r15
            r15 = r11
        L_0x00d2:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.f36811a = r8
            r0.f36812b = r7
            r0.f36813c = r2
            r0.f36814d = r15
            r0.f36820j = r6
            java.lang.String r6 = "sns_videoident_error_uploadFailedFatal"
            java.lang.Object r6 = r8.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r6 != r1) goto L_0x00e7
            return r1
        L_0x00e7:
            r11 = r2
            r2 = r15
            r15 = r6
            r6 = r11
        L_0x00eb:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r0.f36811a = r8
            r0.f36812b = r7
            r0.f36813c = r6
            r0.f36814d = r2
            r0.f36815e = r15
            r0.f36820j = r5
            java.lang.String r5 = "sns_videoident_action_retry"
            java.lang.Object r5 = r8.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x0102
            return r1
        L_0x0102:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r2
            r11 = r5
            r5 = r15
            r15 = r11
        L_0x0109:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r2 = com.sumsub.sns.internal.videoident.presentation.ButtonAction.UPLOAD
            r0.f36811a = r9
            r0.f36812b = r8
            r0.f36813c = r7
            r0.f36814d = r6
            r0.f36815e = r5
            r0.f36816f = r15
            r0.f36817g = r2
            r0.f36820j = r4
            java.lang.Object r4 = r9.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r4 != r1) goto L_0x0124
            return r1
        L_0x0124:
            r11 = r8
            r8 = r15
            r15 = r4
            r4 = r11
            r12 = r9
            r9 = r2
            r2 = r12
            goto L_0x006f
        L_0x012d:
            r10 = r15
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r10 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r10
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r15 = r4.a(r5, r6, r7, r8, r9, r10)
            r0.f36811a = r15
            r0.f36812b = r15
            r0.f36813c = r15
            r4 = 0
            r0.f36814d = r4
            r0.f36815e = r4
            r0.f36816f = r4
            r0.f36817g = r4
            r0.f36820j = r3
            java.lang.String r3 = "sns_videoident_action_cancel"
            java.lang.Object r0 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x014e
            return r1
        L_0x014e:
            r1 = r15
            r2 = r1
            r15 = r0
            r0 = r2
        L_0x0152:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0157
            goto L_0x0159
        L_0x0157:
            java.lang.String r15 = "Cancel"
        L_0x0159:
            r1.a((java.lang.CharSequence) r15)
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r15 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.IN_PROGRESS
            r2.a((com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState) r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.n(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.h.k1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.videoident.presentation.h$k1 r0 = (com.sumsub.sns.internal.videoident.presentation.h.k1) r0
            int r1 = r0.f36846g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36846g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$k1 r0 = new com.sumsub.sns.internal.videoident.presentation.h$k1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36844e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36846g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x006f
            if (r2 == r5) goto L_0x0062
            if (r2 == r4) goto L_0x004b
            if (r2 != r3) goto L_0x0043
            java.lang.Object r1 = r0.f36843d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r2 = r0.f36842c
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r2 = (com.sumsub.sns.internal.videoident.presentation.ButtonAction) r2
            java.lang.Object r3 = r0.f36841b
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r0 = r0.f36840a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r9)
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x00b6
        L_0x0043:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x004b:
            java.lang.Object r2 = r0.f36843d
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r2 = (com.sumsub.sns.internal.videoident.presentation.ButtonAction) r2
            java.lang.Object r4 = r0.f36842c
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r0.f36841b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r5 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r5
            java.lang.Object r6 = r0.f36840a
            com.sumsub.sns.internal.videoident.presentation.h r6 = (com.sumsub.sns.internal.videoident.presentation.h) r6
            kotlin.k.b(r9)
            r7 = r5
            r5 = r2
            r2 = r7
            goto L_0x009e
        L_0x0062:
            java.lang.Object r2 = r0.f36841b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            java.lang.Object r5 = r0.f36840a
            com.sumsub.sns.internal.videoident.presentation.h r5 = (com.sumsub.sns.internal.videoident.presentation.h) r5
            kotlin.k.b(r9)
            r6 = r5
            goto L_0x0084
        L_0x006f:
            kotlin.k.b(r9)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r0.f36840a = r8
            r0.f36841b = r2
            r0.f36846g = r5
            java.lang.String r9 = "sns_videoident_action_upload"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x0083
            return r1
        L_0x0083:
            r6 = r8
        L_0x0084:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r5 = com.sumsub.sns.internal.videoident.presentation.ButtonAction.UPLOAD
            r0.f36840a = r6
            r0.f36841b = r2
            r0.f36842c = r9
            r0.f36843d = r5
            r0.f36846g = r4
            java.lang.String r4 = "sns_videoident_action_cancel"
            java.lang.Object r4 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x009b
            return r1
        L_0x009b:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x009e:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.f36840a = r2
            r0.f36841b = r4
            r0.f36842c = r5
            r0.f36843d = r9
            r0.f36846g = r3
            java.lang.Object r0 = r6.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            r3 = r9
            r9 = r0
            r0 = r2
            r1 = r4
            r2 = r5
        L_0x00b6:
            r5 = r9
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r5 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r5
            r4 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r9 = r0.a((java.lang.CharSequence) r1, (com.sumsub.sns.internal.videoident.presentation.ButtonAction) r2, (java.lang.CharSequence) r3, (android.graphics.Bitmap) r4, (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.o(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            boolean r2 = r1 instanceof com.sumsub.sns.internal.videoident.presentation.h.l1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.videoident.presentation.h$l1 r2 = (com.sumsub.sns.internal.videoident.presentation.h.l1) r2
            int r3 = r2.f36857f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f36857f = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.videoident.presentation.h$l1 r2 = new com.sumsub.sns.internal.videoident.presentation.h$l1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f36855d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36857f
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0063
            if (r4 == r7) goto L_0x005a
            if (r4 == r6) goto L_0x004a
            if (r4 != r5) goto L_0x0042
            java.lang.Object r3 = r2.f36854c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f36853b
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r2 = r2.f36852a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r2
            kotlin.k.b(r1)
            r11 = r3
            r21 = r4
            goto L_0x00a4
        L_0x0042:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004a:
            java.lang.Object r4 = r2.f36854c
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r6 = r2.f36853b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r6 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r6
            java.lang.Object r7 = r2.f36852a
            com.sumsub.sns.internal.videoident.presentation.h r7 = (com.sumsub.sns.internal.videoident.presentation.h) r7
            kotlin.k.b(r1)
            goto L_0x008e
        L_0x005a:
            java.lang.Object r4 = r2.f36852a
            com.sumsub.sns.internal.videoident.presentation.h r4 = (com.sumsub.sns.internal.videoident.presentation.h) r4
            kotlin.k.b(r1)
            r7 = r4
            goto L_0x0072
        L_0x0063:
            kotlin.k.b(r1)
            r2.f36852a = r0
            r2.f36857f = r7
            java.lang.Object r1 = r0.q((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e>) r2)
            if (r1 != r3) goto L_0x0071
            return r3
        L_0x0071:
            r7 = r0
        L_0x0072:
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r1
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            r2.f36852a = r7
            r2.f36853b = r1
            r2.f36854c = r4
            r2.f36857f = r6
            java.lang.String r6 = "sns_videoident_state_uploading"
            java.lang.Object r6 = r7.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r6 != r3) goto L_0x0089
            return r3
        L_0x0089:
            r29 = r6
            r6 = r1
            r1 = r29
        L_0x008e:
            java.lang.String r1 = (java.lang.String) r1
            r2.f36852a = r6
            r2.f36853b = r4
            r2.f36854c = r1
            r2.f36857f = r5
            java.lang.Object r2 = r7.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r2)
            if (r2 != r3) goto L_0x009f
            return r3
        L_0x009f:
            r11 = r1
            r1 = r2
            r21 = r4
            r2 = r6
        L_0x00a4:
            r25 = r1
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r25 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r25
            r3 = 0
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 12320507(0xbbfefb, float:1.7264708E-38)
            r28 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.p(kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(d10.l<? super String, Unit> lVar) {
        this.f36715k0 = lVar;
    }

    public final boolean c(com.sumsub.sns.internal.core.data.model.o oVar) {
        return (oVar instanceof o.e) && (oVar.c() instanceof SNSViewState.b);
    }

    public final void d(boolean z11) {
        this.X.a(this, f36696r[5], Boolean.valueOf(z11));
    }

    public final void e(String str) {
        this.Y.a(this, f36696r[6], str);
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (c(oVar)) {
            N();
        } else {
            super.b(oVar);
        }
    }

    public final void c(String str) {
        T t11;
        String str2 = str;
        if (str2 != null) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            T c11 = c();
            ref$ObjectRef.element = c11;
            if ((c11 instanceof SNSViewState.e) && !((SNSViewState.e) c11).I().isEmpty()) {
                Iterator<T> it2 = this.E.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t11 = null;
                        break;
                    }
                    t11 = it2.next();
                    if (kotlin.jvm.internal.x.b(((Document) t11).getType().c(), str2)) {
                        break;
                    }
                }
                a((Document) t11);
                T a11 = SNSViewState.e.a((SNSViewState.e) ref$ObjectRef.element, (SNSViewState.VideoStepState) null, (SNSViewState.ErrorState) null, false, false, false, false, false, (CharSequence) null, (CharSequence) null, (CharSequence) null, (ButtonAction) null, (CharSequence) null, (CharSequence) null, (k) null, false, false, (e) null, (CharSequence) null, (List) null, (Bitmap) null, (SNSViewState.e) null, (AnalyticsCallState) null, (SNSViewState.a) null, (SNSViewState.e.a.C0498a) null, FlexItem.MAX_SIZE, (Object) null);
                ref$ObjectRef.element = a11;
                a11.a(t());
                com.sumsub.sns.core.presentation.base.a.a(this, false, new x(ref$ObjectRef, (kotlin.coroutines.c<? super x>) null), 1, (Object) null);
            }
        }
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onPrepared", (Throwable) null, 4, (Object) null);
        if (P()) {
            SNSViewState sNSViewState = (SNSViewState) c();
            if ((sNSViewState instanceof SNSViewState.e) && ((SNSViewState.e) sNSViewState).M() != null) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onPrepared: skipping view update", (Throwable) null, 4, (Object) null);
                return Unit.f56620a;
            }
            com.sumsub.sns.core.presentation.base.a.a(this, false, new p0(this, (kotlin.coroutines.c<? super p0>) null), 1, (Object) null);
            return Unit.f56620a;
        } else if (J() == null) {
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new q0(this, (kotlin.coroutines.c<? super q0>) null), 3, (Object) null);
            return Unit.f56620a;
        } else {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new r0((kotlin.coroutines.c<? super r0>) null), 1, (Object) null);
            return Unit.f56620a;
        }
    }

    public final void e(boolean z11) {
        this.Z.a(this, f36696r[7], Boolean.valueOf(z11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.videoident.presentation.h.e
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.videoident.presentation.h$e r0 = (com.sumsub.sns.internal.videoident.presentation.h.e) r0
            int r1 = r0.f36754h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36754h = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$e r0 = new com.sumsub.sns.internal.videoident.presentation.h$e
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f36752f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36754h
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0084
            if (r2 == r6) goto L_0x0078
            if (r2 == r5) goto L_0x0068
            if (r2 == r4) goto L_0x0053
            if (r2 != r3) goto L_0x004b
            java.lang.Object r1 = r0.f36751e
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r1 = (com.sumsub.sns.internal.videoident.presentation.ButtonAction) r1
            java.lang.Object r2 = r0.f36750d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r3 = r0.f36749c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r4 = r0.f36748b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r0 = r0.f36747a
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r0
            kotlin.k.b(r11)
            r5 = r1
            r9 = r4
            r4 = r2
            r2 = r9
            goto L_0x00e9
        L_0x004b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0053:
            java.lang.Object r2 = r0.f36750d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r4 = r0.f36749c
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r0.f36748b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r5 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r5
            java.lang.Object r6 = r0.f36747a
            com.sumsub.sns.internal.videoident.presentation.h r6 = (com.sumsub.sns.internal.videoident.presentation.h) r6
            kotlin.k.b(r11)
            goto L_0x00cc
        L_0x0068:
            java.lang.Object r2 = r0.f36749c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r5 = r0.f36748b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r5 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r5
            java.lang.Object r6 = r0.f36747a
            com.sumsub.sns.internal.videoident.presentation.h r6 = (com.sumsub.sns.internal.videoident.presentation.h) r6
            kotlin.k.b(r11)
            goto L_0x00b3
        L_0x0078:
            java.lang.Object r2 = r0.f36748b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r2
            java.lang.Object r6 = r0.f36747a
            com.sumsub.sns.internal.videoident.presentation.h r6 = (com.sumsub.sns.internal.videoident.presentation.h) r6
            kotlin.k.b(r11)
            goto L_0x009c
        L_0x0084:
            kotlin.k.b(r11)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r11 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r0.f36747a = r10
            r0.f36748b = r11
            r0.f36754h = r6
            java.lang.String r2 = "sns_videoident_error_connectionLost_title"
            java.lang.Object r2 = r10.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r2 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r6 = r10
            r9 = r2
            r2 = r11
            r11 = r9
        L_0x009c:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.f36747a = r6
            r0.f36748b = r2
            r0.f36749c = r11
            r0.f36754h = r5
            java.lang.String r5 = "sns_videoident_error_connectionLostFatal"
            java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x00af
            return r1
        L_0x00af:
            r9 = r2
            r2 = r11
            r11 = r5
            r5 = r9
        L_0x00b3:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.f36747a = r6
            r0.f36748b = r5
            r0.f36749c = r2
            r0.f36750d = r11
            r0.f36754h = r4
            java.lang.String r4 = "sns_videoident_action_callAgain"
            java.lang.Object r4 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r9 = r2
            r2 = r11
            r11 = r4
            r4 = r9
        L_0x00cc:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            com.sumsub.sns.internal.videoident.presentation.ButtonAction r7 = com.sumsub.sns.internal.videoident.presentation.ButtonAction.START_CALL
            r0.f36747a = r5
            r0.f36748b = r4
            r0.f36749c = r2
            r0.f36750d = r11
            r0.f36751e = r7
            r0.f36754h = r3
            java.lang.Object r0 = r6.h((kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.a>) r0)
            if (r0 != r1) goto L_0x00e3
            return r1
        L_0x00e3:
            r3 = r2
            r2 = r4
            r4 = r11
            r11 = r0
            r0 = r5
            r5 = r7
        L_0x00e9:
            r6 = r11
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$a r6 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.a) r6
            r1 = 0
            r7 = 1
            r8 = 0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r11 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r0 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.CONNECTION_LOST
            r11.a((com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState) r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void b(String str) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleLanguageSelectionResult: " + J() + " -> " + str, (Throwable) null, 4, (Object) null);
        if (str == null && J() == null) {
            d10.l<? super Boolean, Unit> lVar = this.f36714j0;
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
                return;
            }
            return;
        }
        if (str != null) {
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new l(this, str, (kotlin.coroutines.c<? super l>) null), 3, (Object) null);
        }
        if (str != null) {
            e(str);
        }
        com.sumsub.sns.core.presentation.base.a.a(this, false, new m((kotlin.coroutines.c<? super m>) null), 1, (Object) null);
    }

    public final void a(List<Document> list) {
        this.S.a(this, f36696r[1], list);
    }

    public final void a(Document document) {
        this.T.a(this, f36696r[2], document);
    }

    public final void a(SNSMessage.ServerMessage.ScreenShotPayload screenShotPayload) {
        this.U.a(this, f36696r[3], screenShotPayload);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e8, code lost:
        r7 = (java.lang.String) r1;
        r2.f36955a = r9;
        r2.f36956b = r8;
        r2.f36957c = r7;
        r2.f36962h = r4;
        r2.f36965k = 2;
        r1 = r9.a(f36702x, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00fc, code lost:
        if (r1 != r3) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00fe, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ff, code lost:
        r1 = (java.lang.String) r1;
        r2.f36955a = r9;
        r2.f36956b = r8;
        r2.f36957c = r7;
        r2.f36958d = r1;
        r2.f36962h = r4;
        r2.f36965k = 3;
        r10 = r9.a(A, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0114, code lost:
        if (r10 != r3) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0116, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0117, code lost:
        r11 = r9;
        r9 = r7;
        r14 = r8;
        r8 = r1;
        r1 = r10;
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x011d, code lost:
        r7 = (java.lang.String) r1;
        r2.f36955a = r11;
        r2.f36956b = r10;
        r2.f36957c = r9;
        r2.f36958d = r8;
        r2.f36959e = r7;
        r2.f36962h = r4;
        r2.f36965k = 4;
        r1 = r11.a(B, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0135, code lost:
        if (r1 != r3) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0137, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0138, code lost:
        r1 = (java.lang.String) r1;
        r12 = r11.G;
        r2.f36955a = r11;
        r2.f36956b = r10;
        r2.f36957c = r9;
        r2.f36958d = r8;
        r2.f36959e = r7;
        r2.f36960f = r1;
        r2.f36962h = r4;
        r2.f36965k = 5;
        r6 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r12, false, r2, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0152, code lost:
        if (r6 != r3) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0154, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0155, code lost:
        r14 = r6;
        r6 = r1;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0158, code lost:
        r1 = com.sumsub.sns.internal.core.data.model.f.l((com.sumsub.sns.internal.core.data.model.e) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x015e, code lost:
        if (r1 == null) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0160, code lost:
        r1 = r1.get(r11.J());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x016a, code lost:
        if (r1 != null) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016c, code lost:
        r1 = r11.J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0170, code lost:
        r2.f36955a = r11;
        r2.f36956b = r10;
        r2.f36957c = r9;
        r2.f36958d = r8;
        r2.f36959e = r7;
        r2.f36960f = r6;
        r2.f36961g = r1;
        r2.f36962h = r4;
        r2.f36965k = 6;
        r2 = r11.a(C, (kotlin.coroutines.c<? super java.lang.String>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0189, code lost:
        if (r2 != r3) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x018b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x018c, code lost:
        r3 = r6;
        r6 = r10;
        r14 = r4;
        r4 = r1;
        r1 = r2;
        r2 = r11;
        r11 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0193, code lost:
        r1 = r6.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (java.lang.CharSequence) r9, new com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.C0498a(r3, r4, (java.lang.String) r1), r11);
        r3 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.COMPLETED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01ac, code lost:
        if (kotlin.coroutines.jvm.internal.a.a(r2.D()).booleanValue() == false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01ae, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01af, code lost:
        if (r5 != null) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01b1, code lost:
        r5 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.PREPARING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01b3, code lost:
        r1.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01b6, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r16, kotlin.coroutines.c<? super com.sumsub.sns.internal.videoident.presentation.SNSViewState.e> r17) {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            boolean r2 = r1 instanceof com.sumsub.sns.internal.videoident.presentation.h.y0
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.sumsub.sns.internal.videoident.presentation.h$y0 r2 = (com.sumsub.sns.internal.videoident.presentation.h.y0) r2
            int r3 = r2.f36965k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f36965k = r3
            goto L_0x001b
        L_0x0016:
            com.sumsub.sns.internal.videoident.presentation.h$y0 r2 = new com.sumsub.sns.internal.videoident.presentation.h$y0
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.f36963i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f36965k
            r5 = 0
            r6 = 1
            switch(r4) {
                case 0: goto L_0x00cd;
                case 1: goto L_0x00bd;
                case 2: goto L_0x00ab;
                case 3: goto L_0x0090;
                case 4: goto L_0x0075;
                case 5: goto L_0x0056;
                case 6: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            boolean r3 = r2.f36962h
            java.lang.Object r4 = r2.f36961g
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.f36960f
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.f36959e
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f36958d
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f36957c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r10 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r10
            java.lang.Object r2 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r2 = (com.sumsub.sns.internal.videoident.presentation.h) r2
            kotlin.k.b(r1)
            r11 = r3
            r3 = r6
            r6 = r10
            goto L_0x0193
        L_0x0056:
            boolean r4 = r2.f36962h
            java.lang.Object r6 = r2.f36960f
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.f36959e
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f36958d
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f36957c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r10 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r10
            java.lang.Object r11 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r11 = (com.sumsub.sns.internal.videoident.presentation.h) r11
            kotlin.k.b(r1)
            goto L_0x0158
        L_0x0075:
            boolean r4 = r2.f36962h
            java.lang.Object r7 = r2.f36959e
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f36958d
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f36957c
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r10 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r10
            java.lang.Object r11 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r11 = (com.sumsub.sns.internal.videoident.presentation.h) r11
            kotlin.k.b(r1)
            goto L_0x0138
        L_0x0090:
            boolean r4 = r2.f36962h
            java.lang.Object r7 = r2.f36958d
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f36957c
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r9 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r9
            java.lang.Object r10 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r10 = (com.sumsub.sns.internal.videoident.presentation.h) r10
            kotlin.k.b(r1)
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L_0x011d
        L_0x00ab:
            boolean r4 = r2.f36962h
            java.lang.Object r7 = r2.f36957c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r8 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r8
            java.lang.Object r9 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r9 = (com.sumsub.sns.internal.videoident.presentation.h) r9
            kotlin.k.b(r1)
            goto L_0x00ff
        L_0x00bd:
            boolean r4 = r2.f36962h
            java.lang.Object r7 = r2.f36956b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r7 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a) r7
            java.lang.Object r8 = r2.f36955a
            com.sumsub.sns.internal.videoident.presentation.h r8 = (com.sumsub.sns.internal.videoident.presentation.h) r8
            kotlin.k.b(r1)
            r9 = r8
            r8 = r7
            goto L_0x00e8
        L_0x00cd:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.f36616y
            r2.f36955a = r0
            r2.f36956b = r1
            r4 = r16
            r2.f36962h = r4
            r2.f36965k = r6
            java.lang.String r7 = "sns_videoident_state_checkingCamera_text"
            java.lang.Object r7 = r15.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r7 != r3) goto L_0x00e5
            return r3
        L_0x00e5:
            r9 = r0
            r8 = r1
            r1 = r7
        L_0x00e8:
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            r2.f36955a = r9
            r2.f36956b = r8
            r2.f36957c = r7
            r2.f36962h = r4
            r1 = 2
            r2.f36965k = r1
            java.lang.String r1 = "sns_videoident_state_checkingCamera_title"
            java.lang.Object r1 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r1 != r3) goto L_0x00ff
            return r3
        L_0x00ff:
            java.lang.String r1 = (java.lang.String) r1
            r2.f36955a = r9
            r2.f36956b = r8
            r2.f36957c = r7
            r2.f36958d = r1
            r2.f36962h = r4
            r10 = 3
            r2.f36965k = r10
            java.lang.String r10 = "sns_videoident_action_start"
            java.lang.Object r10 = r9.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r10 != r3) goto L_0x0117
            return r3
        L_0x0117:
            r11 = r9
            r9 = r7
            r14 = r8
            r8 = r1
            r1 = r10
            r10 = r14
        L_0x011d:
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            r2.f36955a = r11
            r2.f36956b = r10
            r2.f36957c = r9
            r2.f36958d = r8
            r2.f36959e = r7
            r2.f36962h = r4
            r1 = 4
            r2.f36965k = r1
            java.lang.String r1 = "sns_videoident_langPanel_text"
            java.lang.Object r1 = r11.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r1 != r3) goto L_0x0138
            return r3
        L_0x0138:
            java.lang.String r1 = (java.lang.String) r1
            com.sumsub.sns.internal.core.data.source.dynamic.b r12 = r11.G
            r2.f36955a = r11
            r2.f36956b = r10
            r2.f36957c = r9
            r2.f36958d = r8
            r2.f36959e = r7
            r2.f36960f = r1
            r2.f36962h = r4
            r13 = 5
            r2.f36965k = r13
            r13 = 0
            java.lang.Object r6 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r12, r13, r2, r6, r5)
            if (r6 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r14 = r6
            r6 = r1
            r1 = r14
        L_0x0158:
            com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
            java.util.Map r1 = com.sumsub.sns.internal.core.data.model.f.l(r1)
            if (r1 == 0) goto L_0x016c
            java.lang.String r12 = r11.J()
            java.lang.Object r1 = r1.get(r12)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0170
        L_0x016c:
            java.lang.String r1 = r11.J()
        L_0x0170:
            r2.f36955a = r11
            r2.f36956b = r10
            r2.f36957c = r9
            r2.f36958d = r8
            r2.f36959e = r7
            r2.f36960f = r6
            r2.f36961g = r1
            r2.f36962h = r4
            r12 = 6
            r2.f36965k = r12
            java.lang.String r12 = "sns_videoident_langPanel_action_change"
            java.lang.Object r2 = r11.a((java.lang.String) r12, (kotlin.coroutines.c<? super java.lang.String>) r2)
            if (r2 != r3) goto L_0x018c
            return r3
        L_0x018c:
            r3 = r6
            r6 = r10
            r14 = r4
            r4 = r1
            r1 = r2
            r2 = r11
            r11 = r14
        L_0x0193:
            java.lang.String r1 = (java.lang.String) r1
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a$a r10 = new com.sumsub.sns.internal.videoident.presentation.SNSViewState$e$a$a
            r10.<init>(r3, r4, r1)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r1 = r6.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e.a.C0498a) r10, (boolean) r11)
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r3 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.COMPLETED
            boolean r2 = r2.D()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.a.a(r2)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x01af
            r5 = r3
        L_0x01af:
            if (r5 != 0) goto L_0x01b3
            com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState r5 = com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState.PREPARING
        L_0x01b3:
            r1.a((com.sumsub.sns.internal.videoident.presentation.AnalyticsCallState) r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.a(boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(java.lang.String r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.videoident.presentation.h.i0
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.videoident.presentation.h$i0 r0 = (com.sumsub.sns.internal.videoident.presentation.h.i0) r0
            int r1 = r0.f36802e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36802e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.presentation.h$i0 r0 = new com.sumsub.sns.internal.videoident.presentation.h$i0
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f36800c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36802e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.k.b(r10)
            goto L_0x00ec
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.f36799b
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.f36798a
            com.sumsub.sns.internal.videoident.presentation.h r2 = (com.sumsub.sns.internal.videoident.presentation.h) r2
            kotlin.k.b(r10)
            goto L_0x005c
        L_0x0042:
            kotlin.k.b(r10)
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.v0.a()
            com.sumsub.sns.internal.videoident.presentation.h$j0 r2 = new com.sumsub.sns.internal.videoident.presentation.h$j0
            r2.<init>(r8, r9, r5)
            r0.f36798a = r8
            r0.f36799b = r9
            r0.f36802e = r4
            java.lang.Object r10 = kotlinx.coroutines.g.g(r10, r2, r0)
            if (r10 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r2 = r8
        L_0x005c:
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage) r10
            boolean r6 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.n
            if (r6 != 0) goto L_0x006f
            boolean r7 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.s
            if (r7 != 0) goto L_0x006f
            boolean r7 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.i
            if (r7 != 0) goto L_0x006f
            boolean r7 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.q
            if (r7 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean r7 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.p
            if (r4 == 0) goto L_0x0077
            r2.s()
        L_0x0077:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.i
            if (r4 == 0) goto L_0x0084
            d10.a<kotlin.Unit> r9 = r2.f36713i0
            if (r9 == 0) goto L_0x0106
            r9.invoke()
            goto L_0x0106
        L_0x0084:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.s
            if (r4 == 0) goto L_0x0091
            d10.a<kotlin.Unit> r9 = r2.f36712h0
            if (r9 == 0) goto L_0x0106
            r9.invoke()
            goto L_0x0106
        L_0x0091:
            if (r7 == 0) goto L_0x00a3
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$p r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.p) r10
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$p$c r9 = r10.d()
            if (r9 == 0) goto L_0x009f
            java.lang.String r5 = r9.b()
        L_0x009f:
            r2.c((java.lang.String) r5)
            goto L_0x0106
        L_0x00a3:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.k
            if (r4 == 0) goto L_0x00b7
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$k r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.k) r10
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$k$c r9 = r10.c()
            if (r9 == 0) goto L_0x00b3
            java.lang.Boolean r5 = r9.b()
        L_0x00b3:
            r2.a((java.lang.Boolean) r5)
            goto L_0x0106
        L_0x00b7:
            if (r6 == 0) goto L_0x00bf
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$n r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.n) r10
            r2.a((com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.n) r10)
            goto L_0x0106
        L_0x00bf:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.o
            if (r4 == 0) goto L_0x00c9
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$o r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.o) r10
            r2.a((com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.o) r10)
            goto L_0x0106
        L_0x00c9:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.m
            if (r4 == 0) goto L_0x00d3
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$m r10 = (com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.m) r10
            r2.a((com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.m) r10)
            goto L_0x0106
        L_0x00d3:
            boolean r4 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.h
            if (r4 == 0) goto L_0x00db
            r2.M()
            goto L_0x0106
        L_0x00db:
            boolean r10 = r10 instanceof com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.r
            if (r10 == 0) goto L_0x00ef
            r0.f36798a = r5
            r0.f36799b = r5
            r0.f36802e = r3
            java.lang.Object r9 = r2.i((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r9 != r1) goto L_0x00ec
            return r1
        L_0x00ec:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x00ef:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = " unknown message "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 4
            java.lang.String r0 = "SNSVideoIdent"
            com.sumsub.sns.internal.videoident.videoident.a.a(r0, r9, r5, r10, r5)
        L_0x0106:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.b(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void r() {
        kotlinx.coroutines.n1 n1Var = this.f36718n0;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            this.f36718n0 = null;
        }
    }

    public final void q() {
        kotlinx.coroutines.n1 n1Var = this.f36717m0;
        if (n1Var != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "cancelDisconnectTimeoutJob", (Throwable) null, 4, (Object) null);
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            this.f36717m0 = null;
        }
    }

    public final void a(long j11) {
        this.f36710f0 = j11;
    }

    public final void a(d10.a<Unit> aVar) {
        this.f36713i0 = aVar;
    }

    public final void a(d10.l<? super Boolean, Unit> lVar) {
        this.f36714j0 = lVar;
    }

    public void a(com.sumsub.sns.internal.core.data.model.o oVar) {
        d10.l<? super Boolean, Unit> lVar;
        if (c(oVar) && (lVar = this.f36714j0) != null) {
            lVar.invoke(Boolean.FALSE);
        }
    }

    public final void a(g gVar) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "updateVideoChatAdapter: was " + com.sumsub.sns.internal.core.common.i.a((Object) this.N) + " now " + com.sumsub.sns.internal.core.common.i.a((Object) gVar), (Throwable) null, 4, (Object) null);
        this.N = gVar;
    }

    public final Object a(SNSMessage.ServerMessage.f fVar, kotlin.coroutines.c<? super Unit> cVar) {
        Long e11;
        if (!((SNSViewState) c()).isWaiting()) {
            return Unit.f56620a;
        }
        SNSMessage.ServerMessage.f.c d11 = fVar.d();
        if (d11 == null || (e11 = d11.e()) == null) {
            return Unit.f56620a;
        }
        long longValue = e11.longValue();
        if (this.f36709e0 == longValue) {
            return Unit.f56620a;
        }
        this.f36709e0 = longValue;
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "wait time changed: " + fVar, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new r(this, longValue, (kotlin.coroutines.c<? super r>) null), 1, (Object) null);
        return Unit.f56620a;
    }

    public final void b(SNSMessage.ServerMessage.ScreenShotPayload screenShotPayload) {
        T t11;
        String str = null;
        a((SNSMessage.ServerMessage.ScreenShotPayload) null);
        Iterator<T> it2 = w().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (kotlin.jvm.internal.x.b(((Document) t11).getType().c(), screenShotPayload != null ? screenShotPayload.h() : null)) {
                break;
            }
        }
        Document document = (Document) t11;
        if (document != null) {
            a(screenShotPayload);
        } else {
            document = null;
        }
        a(document);
        if (screenShotPayload != null) {
            str = screenShotPayload.n();
        }
        this.f36705a0 = H() != null && !kotlin.jvm.internal.x.b(str, SNSMessage.ServerMessage.ScreenShotPayload.Variant.UPLOAD.getValue());
    }

    public final SNSStepViewItem.State b(Document document) {
        if (H() == document) {
            return SNSStepViewItem.State.SELECTED;
        }
        if (document.isSubmitted()) {
            return SNSStepViewItem.State.DONE;
        }
        return SNSStepViewItem.State.DEFAULT;
    }

    public final void a(b.a aVar) {
        if (this.f36716l0 != null) {
            b(aVar);
        }
        com.sumsub.sns.internal.core.data.model.g d11 = aVar.g().d();
        if (d11 != null && d11.K() == ReviewStatusType.Completed) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleDataUpdated: applicant status changed to completed. Closing ...", (Throwable) null, 4, (Object) null);
            L();
        }
    }

    public final void b(b.a aVar) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleDocStatusUpdated", (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.data.model.g d11 = aVar.g().d();
        com.sumsub.sns.internal.core.data.model.t d12 = aVar.j().d();
        if (d12 == null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " handleDocStatusUpdated getting doc status error", aVar.j().a());
        } else if (d11 == null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, " handleDocStatusUpdated getting applicant error", aVar.g().a());
        } else {
            a(com.sumsub.sns.internal.core.common.i.a(d12.d(), d11));
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleDocStatusUpdated. Docs updated", (Throwable) null, 4, (Object) null);
        }
    }

    public final void a(Map<String, Boolean> map) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handlePermissionResults: all granted=");
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, Boolean>> it2 = map.entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!((Boolean) it2.next().getValue()).booleanValue()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        sb2.append(z11);
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, sb2.toString(), (Throwable) null, 4, (Object) null);
        Boolean bool = map.get("android.permission.CAMERA");
        Boolean bool2 = Boolean.TRUE;
        if (!kotlin.jvm.internal.x.b(bool, bool2)) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new o(this, (kotlin.coroutines.c<? super o>) null), 1, (Object) null);
        } else if (!kotlin.jvm.internal.x.b(map.get("android.permission.RECORD_AUDIO"), bool2)) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new p(this, (kotlin.coroutines.c<? super p>) null), 1, (Object) null);
        } else {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new q(this, (kotlin.coroutines.c<? super q>) null), 1, (Object) null);
        }
    }

    public final void a(ButtonAction buttonAction) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "onPrimaryButtonClick: " + buttonAction, (Throwable) null, 4, (Object) null);
        int i11 = d.f36742a[buttonAction.ordinal()];
        if (i11 == 1) {
            O();
        } else if (i11 == 2) {
            Y();
        }
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [com.sumsub.sns.core.presentation.base.a$l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleVideoChatState: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", exitingWithBackPress="
            r0.append(r1)
            boolean r1 = r8.W
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SNSVideoIdent"
            r2 = 0
            r3 = 4
            com.sumsub.sns.internal.videoident.videoident.a.a(r1, r0, r2, r3, r2)
            r8.q()
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.a
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0089
            r8.d((java.lang.String) r2)
            r8.d((boolean) r4)
            com.sumsub.sns.core.presentation.base.a$l r9 = r8.c()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState r9 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState) r9
            boolean r0 = r9.isReconnecting()
            if (r0 == 0) goto L_0x006c
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r0 == 0) goto L_0x006c
            r0 = r9
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r6 = r0.N()
            if (r6 == 0) goto L_0x006c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "handleVideoChatState: restoring to previous state "
            r6.append(r7)
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r0 = r0.N()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r1, r0, r2, r3, r2)
            com.sumsub.sns.internal.videoident.presentation.h$z r0 = new com.sumsub.sns.internal.videoident.presentation.h$z
            r0.<init>(r9, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r0, r5, r2)
            goto L_0x019c
        L_0x006c:
            boolean r9 = r8.P()
            if (r9 != 0) goto L_0x007f
            com.sumsub.sns.internal.videoident.presentation.h$a0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$a0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            r8.S()
            goto L_0x019c
        L_0x007f:
            com.sumsub.sns.internal.videoident.presentation.h$b0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$b0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            goto L_0x019c
        L_0x0089:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d
            if (r0 == 0) goto L_0x00c3
            r8.c((boolean) r5)
            com.sumsub.sns.core.presentation.base.a$l r0 = r8.c()
            boolean r6 = r0 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r6 == 0) goto L_0x009b
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r0
            goto L_0x009c
        L_0x009b:
            r0 = r2
        L_0x009c:
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState$d r9 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.d) r9
            boolean r9 = r9.h()
            if (r9 == 0) goto L_0x00b9
            if (r0 == 0) goto L_0x00ae
            boolean r9 = r0.isReconnecting()
            if (r9 != r5) goto L_0x00ae
            r9 = r5
            goto L_0x00af
        L_0x00ae:
            r9 = r4
        L_0x00af:
            if (r9 == 0) goto L_0x00b2
            goto L_0x00b9
        L_0x00b2:
            java.lang.String r9 = "handleVideoChatState: skipping view update"
            com.sumsub.sns.internal.videoident.videoident.a.a(r1, r9, r2, r3, r2)
            goto L_0x019c
        L_0x00b9:
            com.sumsub.sns.internal.videoident.presentation.h$c0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$c0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            goto L_0x019c
        L_0x00c3:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.e
            if (r0 == 0) goto L_0x00dc
            r8.d((java.lang.String) r2)
            boolean r9 = r8.W
            if (r9 == 0) goto L_0x00cf
            return r5
        L_0x00cf:
            com.sumsub.sns.internal.videoident.presentation.h$d0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$d0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            r8.f0()
            goto L_0x019c
        L_0x00dc:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.c
            if (r0 == 0) goto L_0x0171
            r8.c((boolean) r4)
            r8.s()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "handleVideoChatState: finishOnDisconnect="
            r0.append(r6)
            boolean r6 = r8.x()
            r0.append(r6)
            java.lang.String r6 = ", error="
            r0.append(r6)
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState$c r9 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.c) r9
            java.lang.Throwable r6 = r9.b()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r1, r0, r2, r3, r2)
            d10.a<kotlin.Unit> r0 = r8.f36713i0
            if (r0 == 0) goto L_0x0113
            r0.invoke()
        L_0x0113:
            boolean r0 = r8.W
            if (r0 == 0) goto L_0x0118
            return r5
        L_0x0118:
            boolean r0 = r8.x()
            if (r0 == 0) goto L_0x0130
            com.sumsub.sns.internal.videoident.presentation.h$e0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$e0
            r9.<init>(r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            d10.l<? super java.lang.Boolean, kotlin.Unit> r9 = r8.f36714j0
            if (r9 == 0) goto L_0x012f
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r9.invoke(r0)
        L_0x012f:
            return r5
        L_0x0130:
            com.sumsub.sns.core.presentation.base.a$l r0 = r8.c()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState) r0
            boolean r1 = r0 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r1 == 0) goto L_0x014d
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r0
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$VideoStepState r1 = r0.V()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$VideoStepState r3 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.VideoStepState.ERROR
            if (r1 != r3) goto L_0x014d
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r0 = r0.J()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$ErrorState r1 = com.sumsub.sns.internal.videoident.presentation.SNSViewState.ErrorState.UPLOAD_ERROR
            if (r0 == r1) goto L_0x014d
            return r5
        L_0x014d:
            com.sumsub.sns.core.presentation.base.a$l r0 = r8.c()
            com.sumsub.sns.internal.videoident.presentation.SNSViewState r0 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState) r0
            boolean r0 = r0.isPreview()
            if (r0 != 0) goto L_0x0170
            java.lang.Throwable r9 = r9.b()
            if (r9 == 0) goto L_0x0168
            com.sumsub.sns.internal.videoident.presentation.h$f0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$f0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
            goto L_0x0170
        L_0x0168:
            com.sumsub.sns.internal.videoident.presentation.h$g0 r9 = new com.sumsub.sns.internal.videoident.presentation.h$g0
            r9.<init>(r8, r2)
            com.sumsub.sns.core.presentation.base.a.a(r8, r4, r9, r5, r2)
        L_0x0170:
            return r5
        L_0x0171:
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.f
            if (r0 == 0) goto L_0x019d
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            com.sumsub.sns.internal.log.LoggerType[] r3 = new com.sumsub.sns.internal.log.LoggerType[r5]
            com.sumsub.sns.internal.log.LoggerType r6 = com.sumsub.sns.internal.log.LoggerType.KIBANA
            r3[r4] = r6
            com.sumsub.log.logger.Logger r0 = r0.a((com.sumsub.sns.internal.log.LoggerType[]) r3)
            com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState$f r9 = (com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState.f) r9
            java.lang.Throwable r9 = r9.a()
            java.lang.String r3 = "reconnecting"
            r0.w(r1, r3, r9)
            com.sumsub.sns.core.presentation.base.a$l r9 = r8.c()
            boolean r0 = r9 instanceof com.sumsub.sns.internal.videoident.presentation.SNSViewState.e
            if (r0 == 0) goto L_0x0197
            r2 = r9
            com.sumsub.sns.internal.videoident.presentation.SNSViewState$e r2 = (com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r2
        L_0x0197:
            if (r2 == 0) goto L_0x019c
            r8.a((com.sumsub.sns.internal.videoident.presentation.SNSViewState.e) r2)
        L_0x019c:
            return r5
        L_0x019d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.a(com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState):boolean");
    }

    public final void a(SNSViewState.e eVar) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new i1(this, eVar, (kotlin.coroutines.c<? super i1>) null), 1, (Object) null);
    }

    public final void a(PhoneVerificationStatus phoneVerificationStatus) {
        int i11 = d.f36743b[phoneVerificationStatus.ordinal()];
        if (i11 == 1) {
            this.N.sendMessage(new SNSMessage.ClientMessage.f());
        } else if (i11 == 2) {
            this.N.sendMessage(new SNSMessage.ClientMessage.h());
        } else if (i11 == 3) {
            this.N.sendMessage(new SNSMessage.ClientMessage.b());
        } else if (i11 == 4) {
            this.N.sendMessage(new SNSMessage.ClientMessage.g());
        }
    }

    public final void a(SNSMessage.ServerMessage.m mVar) {
        if (this.f36718n0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleMakeScreenshot: skipping. Upload is in progress", (Throwable) null, 4, (Object) null);
            return;
        }
        d0();
        this.f36707c0 = null;
        b(mVar.d());
        this.N.makePhoto();
    }

    public final void a(SNSMessage.ServerMessage.o oVar) {
        String str;
        if (this.f36718n0 != null) {
            com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "handleReadyForScreenshot: skipping. Upload is in progress", (Throwable) null, 4, (Object) null);
            return;
        }
        b(oVar.d());
        c cVar = c.f36681a;
        b.c h11 = h();
        SNSMessage.ServerMessage.ScreenShotPayload I2 = I();
        if (I2 == null || (str = I2.h()) == null) {
            str = "";
        }
        IdentitySide.b bVar = IdentitySide.Companion;
        SNSMessage.ServerMessage.ScreenShotPayload I3 = I();
        IdentitySide a11 = bVar.a(I3 != null ? I3.j() : null);
        if (a11 == null) {
            a11 = IdentitySide.Front;
        }
        SNSMessage.ServerMessage.ScreenShotPayload I4 = I();
        c.a a12 = cVar.a(h11, str, a11, I4 != null ? I4.l() : null);
        String value = SNSMessage.ServerMessage.ScreenShotPayload.Variant.UPLOAD.getValue();
        SNSMessage.ServerMessage.ScreenShotPayload I5 = I();
        if (kotlin.jvm.internal.x.b(value, I5 != null ? I5.n() : null)) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new s(this, a12, (kotlin.coroutines.c<? super s>) null), 1, (Object) null);
        } else {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new t(this, a12, (kotlin.coroutines.c<? super t>) null), 1, (Object) null);
        }
    }

    public final void a(SNSMessage.ServerMessage.n nVar) {
        e O2;
        d(nVar.d().b());
        SNSViewState sNSViewState = (SNSViewState) c();
        if ((sNSViewState instanceof SNSViewState.e) && (O2 = ((SNSViewState.e) sNSViewState).O()) != null && O2.f()) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new n(sNSViewState, this, (kotlin.coroutines.c<? super n>) null), 1, (Object) null);
        }
    }

    public final void a(Boolean bool) {
        r();
        boolean z11 = true;
        e(true);
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            List<Document> w11 = w();
            if (!(w11 instanceof Collection) || !w11.isEmpty()) {
                Iterator<T> it2 = w11.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((Document) it2.next()).isSubmitted()) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        d(z11);
        this.N.disconnect();
    }

    public final void a(Bitmap bitmap) {
        r();
        if (bitmap != this.f36706b0) {
            d0();
        }
        this.f36706b0 = bitmap;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        kotlinx.coroutines.n1 d11 = kotlinx.coroutines.i.d(this.Q, (CoroutineContext) null, (CoroutineStart) null, new n0(this, bitmap, ref$BooleanRef, (kotlin.coroutines.c<? super n0>) null), 3, (Object) null);
        this.f36718n0 = d11;
        d11.L(new o0(this, ref$BooleanRef));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r16, java.io.File r17, kotlin.coroutines.c<? super kotlin.Unit> r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            boolean r2 = r1 instanceof com.sumsub.sns.internal.videoident.presentation.h.t0
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.sumsub.sns.internal.videoident.presentation.h$t0 r2 = (com.sumsub.sns.internal.videoident.presentation.h.t0) r2
            int r3 = r2.f36930d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f36930d = r3
            goto L_0x001b
        L_0x0016:
            com.sumsub.sns.internal.videoident.presentation.h$t0 r2 = new com.sumsub.sns.internal.videoident.presentation.h$t0
            r2.<init>(r15, r1)
        L_0x001b:
            r9 = r2
            java.lang.Object r1 = r9.f36928b
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r9.f36930d
            r10 = 4
            r11 = 0
            java.lang.String r12 = "SNSVideoIdent"
            r13 = 1
            r14 = 0
            if (r3 == 0) goto L_0x0045
            if (r3 != r13) goto L_0x003d
            java.lang.Object r2 = r9.f36927a
            com.sumsub.sns.internal.videoident.presentation.h r2 = (com.sumsub.sns.internal.videoident.presentation.h) r2
            kotlin.k.b(r1)
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r1 = r1.m3081unboximpl()
            goto L_0x00b4
        L_0x003d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0045:
            kotlin.k.b(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "onUploadFileForDocSetType: "
            r1.append(r3)
            r3 = r16
            r1.append(r3)
            java.lang.String r3 = ", "
            r1.append(r3)
            java.lang.String r3 = r17.getAbsolutePath()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r12, r1, r14, r10, r14)
            com.sumsub.sns.internal.core.data.model.Document r1 = r15.H()
            if (r1 != 0) goto L_0x0073
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0073:
            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload r3 = r15.I()
            if (r3 != 0) goto L_0x007c
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x007c:
            com.sumsub.sns.internal.videoident.presentation.h$u0 r4 = new com.sumsub.sns.internal.videoident.presentation.h$u0
            r4.<init>(r15, r14)
            com.sumsub.sns.core.presentation.base.a.a(r15, r11, r4, r13, r14)
            r8 = r17
            r0.f36707c0 = r8
            com.sumsub.sns.internal.videoident.videoident.domain.c r4 = r0.J
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
            java.lang.String r5 = r3.l()
            if (r5 != 0) goto L_0x0096
            java.lang.String r5 = ""
        L_0x0096:
            com.sumsub.sns.internal.core.data.model.IdentitySide$b r6 = com.sumsub.sns.internal.core.data.model.IdentitySide.Companion
            java.lang.String r7 = r3.j()
            com.sumsub.sns.internal.core.data.model.IdentitySide r6 = r6.a(r7)
            java.lang.String r7 = r3.f()
            r9.f36927a = r0
            r9.f36930d = r13
            r3 = r4
            r4 = r1
            r8 = r17
            java.lang.Object r1 = r3.a(r4, r5, r6, r7, r8, r9)
            if (r1 != r2) goto L_0x00b3
            return r2
        L_0x00b3:
            r2 = r0
        L_0x00b4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onUploadFileForDocSetType: uploaded="
            r3.append(r4)
            boolean r4 = kotlin.Result.m3079isSuccessimpl(r1)
            r3.append(r4)
            java.lang.String r4 = ", remoteDoc="
            r3.append(r4)
            boolean r4 = kotlin.Result.m3078isFailureimpl(r1)
            if (r4 == 0) goto L_0x00d2
            r4 = r14
            goto L_0x00d3
        L_0x00d2:
            r4 = r1
        L_0x00d3:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.sumsub.sns.internal.videoident.videoident.a.a(r12, r3, r14, r10, r14)
            boolean r3 = kotlin.Result.m3079isSuccessimpl(r1)
            if (r3 == 0) goto L_0x0105
            com.sumsub.sns.internal.videoident.presentation.g r3 = r2.N
            com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e r4 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e
            com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e$c r5 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$e$c
            boolean r6 = kotlin.Result.m3078isFailureimpl(r1)
            if (r6 == 0) goto L_0x00f1
            r6 = r14
            goto L_0x00f2
        L_0x00f1:
            r6 = r1
        L_0x00f2:
            com.sumsub.sns.internal.core.data.model.remote.k r6 = (com.sumsub.sns.internal.core.data.model.remote.k) r6
            if (r6 == 0) goto L_0x00fb
            java.lang.String r6 = r6.q()
            goto L_0x00fc
        L_0x00fb:
            r6 = r14
        L_0x00fc:
            r5.<init>(r6)
            r4.<init>(r5)
            r3.sendMessage(r4)
        L_0x0105:
            boolean r3 = kotlin.Result.m3078isFailureimpl(r1)
            if (r3 == 0) goto L_0x0121
            java.lang.Throwable r1 = kotlin.Result.m3075exceptionOrNullimpl(r1)
            java.lang.Exception r1 = (java.lang.Exception) r1
            java.lang.String r3 = "onUploadFileForDocSetType"
            com.sumsub.sns.internal.videoident.videoident.a.a(r12, r3, r1)
            com.sumsub.sns.internal.videoident.presentation.h$v0 r3 = new com.sumsub.sns.internal.videoident.presentation.h$v0
            r3.<init>(r2, r1, r14)
            com.sumsub.sns.core.presentation.base.a.a(r2, r11, r3, r13, r14)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x0121:
            r2.e0()
            com.sumsub.sns.internal.videoident.presentation.h$w0 r3 = new com.sumsub.sns.internal.videoident.presentation.h$w0
            r3.<init>(r1, r2, r14)
            com.sumsub.sns.core.presentation.base.a.a(r2, r11, r3, r13, r14)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.h.a(java.lang.String, java.io.File, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(com.sumsub.sns.internal.core.data.source.applicant.remote.h0 h0Var) {
        com.sumsub.sns.internal.core.data.source.applicant.remote.i0 c11;
        String b11;
        String e11 = h0Var.e();
        if (e11 != null && (c11 = h0Var.c()) != null && (b11 = c11.b()) != null) {
            this.N.connectToRoom(e11, b11);
        }
    }

    public final void a(Uri uri) {
        kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k(this, uri, (kotlin.coroutines.c<? super k>) null), 3, (Object) null);
    }
}
