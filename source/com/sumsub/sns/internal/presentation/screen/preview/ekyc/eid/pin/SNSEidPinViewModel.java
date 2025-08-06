package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a;
import d10.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class SNSEidPinViewModel extends com.sumsub.sns.core.presentation.base.a<e> {
    public static final String A = "pin_step";
    public static final String B = "original_pin";
    public static final String C = "current_pin";
    public static final String D = "last_pin_digit";
    public static final String E = "can";
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 10;
    public static final long I = 300;
    public static final String J = "pin_mode";
    public static final String K = "SNSEidPin";

    /* renamed from: y  reason: collision with root package name */
    public static final a f35816y = new a((r) null);

    /* renamed from: z  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f35817z;

    /* renamed from: q  reason: collision with root package name */
    public final a f35818q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35819r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35820s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35821t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35822u;

    /* renamed from: v  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35823v;

    /* renamed from: w  reason: collision with root package name */
    public final kotlinx.coroutines.flow.d<Step> f35824w;

    /* renamed from: x  reason: collision with root package name */
    public final j1<e> f35825x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/pin/SNSEidPinViewModel$Step;", "", "(Ljava/lang/String;I)V", "ENTER_OLD_PIN", "TESTING_ENTER_LAST_DIGIT", "ENTER_NEW_PIN", "REPEAT_NEW_PIN", "ENTER_PIN", "ENTER_CAN", "ENTER_PUK", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Step {
        ENTER_OLD_PIN,
        TESTING_ENTER_LAST_DIGIT,
        ENTER_NEW_PIN,
        REPEAT_NEW_PIN,
        ENTER_PIN,
        ENTER_CAN,
        ENTER_PUK
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final b f35826a;

        public b(b bVar) {
            this.f35826a = bVar;
        }

        public final b a() {
            return this.f35826a;
        }

        public final b b() {
            return this.f35826a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f35826a, ((b) obj).f35826a);
        }

        public int hashCode() {
            return this.f35826a.hashCode();
        }

        public String toString() {
            return "PinSuccessEvent(result=" + this.f35826a + ')';
        }

        public final b a(b bVar) {
            return new b(bVar);
        }

        public static /* synthetic */ b a(b bVar, b bVar2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bVar2 = bVar.f35826a;
            }
            return bVar.a(bVar2);
        }
    }

    public static final class c implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35827a;

        public c(String str) {
            this.f35827a = str;
        }

        public final String a() {
            return this.f35827a;
        }

        public final String b() {
            return this.f35827a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f35827a, ((c) obj).f35827a);
        }

        public int hashCode() {
            String str = this.f35827a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "RepeatPinError(text=" + this.f35827a + ')';
        }

        public final c a(String str) {
            return new c(str);
        }

        public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f35827a;
            }
            return cVar.a(str);
        }
    }

    public static final class d extends AbstractSavedStateViewModelFactory {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.a f35828a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f35829b;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, r rVar) {
            this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
        }

        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            com.sumsub.sns.internal.core.data.source.common.a n11 = this.f35828a.n();
            com.sumsub.sns.internal.core.data.source.dynamic.b p11 = this.f35828a.p();
            Bundle bundle = this.f35829b;
            a aVar = bundle != null ? (a) bundle.getParcelable(SNSEidPinViewModel.J) : null;
            if (aVar == null) {
                aVar = new a.c(false);
            }
            return new SNSEidPinViewModel(aVar, savedStateHandle, n11, p11);
        }

        public d(androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
            super(cVar, bundle);
            this.f35828a = aVar;
            this.f35829b = bundle;
        }
    }

    public static abstract class e implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35830a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35831b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35832c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<String, Object> f35833d;

        public static final class a extends e {
            public a(CharSequence charSequence, CharSequence charSequence2, int i11, Map<String, ? extends Object> map) {
                super(charSequence, charSequence2, i11, map, (r) null);
            }
        }

        public static final class b extends e {
            public b(CharSequence charSequence, CharSequence charSequence2, int i11, Map<String, ? extends Object> map) {
                super(charSequence, charSequence2, i11, map, (r) null);
            }
        }

        public static final class c extends e {
            public c(CharSequence charSequence, CharSequence charSequence2, int i11, Map<String, ? extends Object> map) {
                super(charSequence, charSequence2, i11, map, (r) null);
            }
        }

        public static final class d extends e {

            /* renamed from: e  reason: collision with root package name */
            public static final d f35834e = new d();

            public d() {
                super((CharSequence) null, (CharSequence) null, 0, (Map) null, 15, (r) null);
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$e  reason: collision with other inner class name */
        public static final class C0467e extends e {
            public C0467e(CharSequence charSequence, CharSequence charSequence2, int i11, Map<String, ? extends Object> map) {
                super(charSequence, charSequence2, i11, map, (r) null);
            }
        }

        public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, int i11, Map map, r rVar) {
            this(charSequence, charSequence2, i11, map);
        }

        public final Map<String, Object> a() {
            return this.f35833d;
        }

        public final int b() {
            return this.f35832c;
        }

        public final CharSequence c() {
            return this.f35831b;
        }

        public final CharSequence d() {
            return this.f35830a;
        }

        public e(CharSequence charSequence, CharSequence charSequence2, int i11, Map<String, ? extends Object> map) {
            this.f35830a = charSequence;
            this.f35831b = charSequence2;
            this.f35832c = i11;
            this.f35833d = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(CharSequence charSequence, CharSequence charSequence2, int i11, Map map, int i12, r rVar) {
            this((i12 & 1) != 0 ? null : charSequence, (i12 & 2) != 0 ? null : charSequence2, (i12 & 4) != 0 ? 6 : i11, (i12 & 8) != 0 ? MapsKt__MapsKt.h() : map, (r) null);
        }
    }

    public /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35835a;

        static {
            int[] iArr = new int[Step.values().length];
            iArr[Step.ENTER_PIN.ordinal()] = 1;
            iArr[Step.ENTER_CAN.ordinal()] = 2;
            iArr[Step.ENTER_PUK.ordinal()] = 3;
            iArr[Step.ENTER_OLD_PIN.ordinal()] = 4;
            iArr[Step.ENTER_NEW_PIN.ordinal()] = 5;
            iArr[Step.REPEAT_NEW_PIN.ordinal()] = 6;
            iArr[Step.TESTING_ENTER_LAST_DIGIT.ordinal()] = 7;
            f35835a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$onInput$1", f = "SNSEidPinViewModel.kt", l = {126, 136, 141, 161, 167, 173, 179}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSEidPinViewModel f35837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35838c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$onInput$1$1", f = "SNSEidPinViewModel.kt", l = {151}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f35839a;

            /* renamed from: b  reason: collision with root package name */
            public int f35840b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SNSEidPinViewModel f35841c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SNSEidPinViewModel sNSEidPinViewModel, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f35841c = sNSEidPinViewModel;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f35841c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                SNSEidPinViewModel sNSEidPinViewModel;
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35840b;
                if (i11 == 0) {
                    k.b(obj);
                    this.f35841c.d((String) null);
                    this.f35841c.b(Step.ENTER_NEW_PIN);
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(SNSEidPinViewModel.K, "Pins do not match", (Throwable) null, 4, (Object) null);
                    SNSEidPinViewModel sNSEidPinViewModel2 = this.f35841c;
                    this.f35839a = sNSEidPinViewModel2;
                    this.f35840b = 1;
                    Object a11 = sNSEidPinViewModel2.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.G, (kotlin.coroutines.c<? super String>) this);
                    if (a11 == d11) {
                        return d11;
                    }
                    sNSEidPinViewModel = sNSEidPinViewModel2;
                    obj = a11;
                } else if (i11 == 1) {
                    sNSEidPinViewModel = (SNSEidPinViewModel) this.f35839a;
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sNSEidPinViewModel.a((a.j) new c((String) obj));
                return Unit.f56620a;
            }
        }

        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f35842a;

            static {
                int[] iArr = new int[Step.values().length];
                iArr[Step.ENTER_OLD_PIN.ordinal()] = 1;
                iArr[Step.ENTER_NEW_PIN.ordinal()] = 2;
                iArr[Step.REPEAT_NEW_PIN.ordinal()] = 3;
                iArr[Step.TESTING_ENTER_LAST_DIGIT.ordinal()] = 4;
                iArr[Step.ENTER_PIN.ordinal()] = 5;
                iArr[Step.ENTER_PUK.ordinal()] = 6;
                iArr[Step.ENTER_CAN.ordinal()] = 7;
                f35842a = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SNSEidPinViewModel sNSEidPinViewModel, String str, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f35837b = sNSEidPinViewModel;
            this.f35838c = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f35837b, this.f35838c, cVar);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c6, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.ENTER_NEW_PIN);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ed, code lost:
            if (kotlin.jvm.internal.x.b(r6.f35838c, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.b(r6.f35837b)) == false) goto L_0x00f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ef, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f5, code lost:
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(androidx.lifecycle.m0.a(r6.f35837b), (kotlin.coroutines.CoroutineContext) null, (kotlinx.coroutines.CoroutineStart) null, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.g.a(r6.f35837b, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.g.a>) null), 3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0123, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6.f35837b, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.REPEAT_NEW_PIN);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0143, code lost:
            r7 = r6.f35837b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x014f, code lost:
            if (com.sumsub.sns.internal.ff.a.f34215a.j().g() == false) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0151, code lost:
            r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.TESTING_ENTER_LAST_DIGIT;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0154, code lost:
            r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.ENTER_NEW_PIN;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0156, code lost:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r7, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x015b, code lost:
            return kotlin.Unit.f56620a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f35836a
                switch(r1) {
                    case 0: goto L_0x0032;
                    case 1: goto L_0x002d;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0023;
                    case 4: goto L_0x001e;
                    case 5: goto L_0x0019;
                    case 6: goto L_0x0015;
                    case 7: goto L_0x0011;
                    default: goto L_0x0009;
                }
            L_0x0009:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0011:
                kotlin.k.b(r7)
                goto L_0x0066
            L_0x0015:
                kotlin.k.b(r7)
                goto L_0x0087
            L_0x0019:
                kotlin.k.b(r7)
                goto L_0x00a6
            L_0x001e:
                kotlin.k.b(r7)
                goto L_0x00c6
            L_0x0023:
                kotlin.k.b(r7)
                goto L_0x00e1
            L_0x0028:
                kotlin.k.b(r7)
                goto L_0x0123
            L_0x002d:
                kotlin.k.b(r7)
                goto L_0x0143
            L_0x0032:
                kotlin.k.b(r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r7 = r7.v()
                int[] r1 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.g.b.f35842a
                int r7 = r7.ordinal()
                r7 = r1[r7]
                r1 = 1
                r2 = 5
                r3 = 6
                r4 = 300(0x12c, double:1.48E-321)
                switch(r7) {
                    case 1: goto L_0x012b;
                    case 2: goto L_0x010a;
                    case 3: goto L_0x00cf;
                    case 4: goto L_0x00ad;
                    case 5: goto L_0x008e;
                    case 6: goto L_0x006d;
                    case 7: goto L_0x004d;
                    default: goto L_0x004b;
                }
            L_0x004b:
                goto L_0x0159
            L_0x004d:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r3) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r1 = r6.f35838c
                r7.c((java.lang.String) r1)
                r7 = 7
                r6.f35836a = r7
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x0066
                return r0
            L_0x0066:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                r7.p()
                goto L_0x0159
            L_0x006d:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                r1 = 10
                if (r7 != r1) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r1 = r6.f35838c
                r7.d(r1)
                r6.f35836a = r3
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x0087
                return r0
            L_0x0087:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                r7.p()
                goto L_0x0159
            L_0x008e:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r3) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r1 = r6.f35838c
                r7.d(r1)
                r6.f35836a = r2
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x00a6
                return r0
            L_0x00a6:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                r7.p()
                goto L_0x0159
            L_0x00ad:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r1) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r1 = r6.f35838c
                r7.e(r1)
                r7 = 4
                r6.f35836a = r7
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x00c6
                return r0
            L_0x00c6:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.ENTER_NEW_PIN
                r7.b((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r0)
                goto L_0x0159
            L_0x00cf:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r3) goto L_0x0159
                r7 = 3
                r6.f35836a = r7
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x00e1
                return r0
            L_0x00e1:
                java.lang.String r7 = r6.f35838c
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r0 = r6.f35837b
                java.lang.String r0 = r0.r()
                boolean r7 = kotlin.jvm.internal.x.b(r7, r0)
                if (r7 == 0) goto L_0x00f5
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                r7.p()
                goto L_0x0159
            L_0x00f5:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                kotlinx.coroutines.h0 r0 = androidx.lifecycle.m0.a(r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$g$a r3 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$g$a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                r1 = 0
                r3.<init>(r7, r1)
                r2 = 0
                r4 = 3
                r5 = 0
                kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r0, r1, r2, r3, r4, r5)
                goto L_0x0159
            L_0x010a:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r3) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r1 = r6.f35838c
                r7.d(r1)
                r7 = 2
                r6.f35836a = r7
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x0123
                return r0
            L_0x0123:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.REPEAT_NEW_PIN
                r7.b((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r0)
                goto L_0x0159
            L_0x012b:
                java.lang.String r7 = r6.f35838c
                int r7 = r7.length()
                if (r7 != r2) goto L_0x0159
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                java.lang.String r2 = r6.f35838c
                r7.f(r2)
                r6.f35836a = r1
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
                if (r7 != r0) goto L_0x0143
                return r0
            L_0x0143:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r7 = r6.f35837b
                com.sumsub.sns.internal.ff.a r0 = com.sumsub.sns.internal.ff.a.f34215a
                com.sumsub.sns.internal.ff.core.a r0 = r0.j()
                boolean r0 = r0.g()
                if (r0 == 0) goto L_0x0154
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.TESTING_ENTER_LAST_DIGIT
                goto L_0x0156
            L_0x0154:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step.ENTER_NEW_PIN
            L_0x0156:
                r7.b((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r0)
            L_0x0159:
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h implements kotlinx.coroutines.flow.d<e> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f35843a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSEidPinViewModel f35844b;

        public static final class a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f35845a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SNSEidPinViewModel f35846b;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$special$$inlined$mapNotNull$1$2", f = "SNSEidPinViewModel.kt", l = {226, 227, 233, 234, 240, 241, 247, 248, 254, 255, 261, 262, 272}, m = "emit")
            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a$a  reason: collision with other inner class name */
            public static final class C0468a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f35847a;

                /* renamed from: b  reason: collision with root package name */
                public int f35848b;

                /* renamed from: c  reason: collision with root package name */
                public Object f35849c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f35850d;

                /* renamed from: e  reason: collision with root package name */
                public Object f35851e;

                /* renamed from: f  reason: collision with root package name */
                public Object f35852f;

                /* renamed from: g  reason: collision with root package name */
                public Object f35853g;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0468a(a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f35850d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f35847a = obj;
                    this.f35848b |= Integer.MIN_VALUE;
                    return this.f35850d.emit((Object) null, this);
                }
            }

            public a(kotlinx.coroutines.flow.e eVar, SNSEidPinViewModel sNSEidPinViewModel) {
                this.f35845a = eVar;
                this.f35846b = sNSEidPinViewModel;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
                r2 = r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ac, code lost:
                r2 = r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ff, code lost:
                r2 = r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0128, code lost:
                r2 = r9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x016f, code lost:
                r9 = (java.lang.CharSequence) r10;
                r10 = r4.f35846b;
                r0.f35849c = r4;
                r0.f35851e = r3;
                r0.f35852f = r2;
                r0.f35853g = r9;
                r0.f35848b = 12;
                r10 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r10, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.B, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0186, code lost:
                if (r10 != r1) goto L_0x0189;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0188, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0189, code lost:
                r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.C0467e(r9, (java.lang.CharSequence) r10, 6, r4.f35846b.a(r2));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b2, code lost:
                r10 = (java.lang.CharSequence) r10;
                r6 = r4.f35846b;
                r0.f35849c = r4;
                r0.f35851e = r9;
                r0.f35852f = r2;
                r0.f35853g = r10;
                r0.f35848b = 10;
                r3 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35637z, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c6, code lost:
                if (r3 != r1) goto L_0x01c9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c8, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x01c9, code lost:
                r7 = r3;
                r3 = r9;
                r9 = r10;
                r10 = r7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x01cd, code lost:
                r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.a(r9, (java.lang.CharSequence) r10, 6, r4.f35846b.a(r2));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f5, code lost:
                r9 = (java.lang.CharSequence) r10;
                r10 = r5.f35846b;
                r0.f35849c = r5;
                r0.f35851e = r3;
                r0.f35852f = r2;
                r0.f35853g = r9;
                r0.f35848b = 8;
                r10 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r10, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35635x, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:0x020c, code lost:
                if (r10 != r1) goto L_0x020f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x020e, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x020f, code lost:
                r5 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.b(r9, (java.lang.CharSequence) r10, 5, r5.f35846b.a(r2));
                r10 = r3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x0235, code lost:
                r10 = (java.lang.CharSequence) r10;
                r6 = r9.f35846b;
                r0.f35849c = r9;
                r0.f35851e = r4;
                r0.f35852f = r2;
                r0.f35853g = r10;
                r0.f35848b = 6;
                r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r6, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.F, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:62:0x0249, code lost:
                if (r5 != r1) goto L_0x024c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x024b, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:0x024c, code lost:
                r7 = r5;
                r5 = r9;
                r9 = r10;
                r10 = r7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x0250, code lost:
                r5 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.c(r9, (java.lang.CharSequence) r10, 10, r5.f35846b.a(r2));
                r10 = r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x025e, code lost:
                r2 = r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:71:0x027a, code lost:
                r9 = (java.lang.CharSequence) r10;
                r10 = r4.f35846b;
                r0.f35849c = r4;
                r0.f35851e = r3;
                r0.f35852f = r2;
                r0.f35853g = r9;
                r0.f35848b = 4;
                r10 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r10, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.D, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:72:0x0290, code lost:
                if (r10 != r1) goto L_0x0293;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:73:0x0292, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:0x0293, code lost:
                r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.c(r9, (java.lang.CharSequence) r10, 6, r4.f35846b.a(r2));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:79:0x02b9, code lost:
                r9 = (java.lang.CharSequence) r10;
                r10 = r4.f35846b;
                r0.f35849c = r4;
                r0.f35851e = r3;
                r0.f35852f = r2;
                r0.f35853g = r9;
                r0.f35848b = 2;
                r10 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.a(r10, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35633v, r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:80:0x02cf, code lost:
                if (r10 != r1) goto L_0x02d2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:81:0x02d1, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:82:0x02d2, code lost:
                r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.e.c(r9, (java.lang.CharSequence) r10, 6, r4.f35846b.a(r2));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:83:0x02df, code lost:
                r10 = r3;
                r2 = r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:84:0x02e1, code lost:
                r0.f35849c = null;
                r0.f35851e = null;
                r0.f35852f = null;
                r0.f35853g = null;
                r0.f35848b = 13;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:85:0x02f2, code lost:
                if (r10.emit(r2, r0) != r1) goto L_0x02f5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:86:0x02f4, code lost:
                return r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:88:0x02f7, code lost:
                return kotlin.Unit.f56620a;
             */
            /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x0072  */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0086  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x009b  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00ee  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0102  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0117  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x012b  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.c r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a.C0468a
                    if (r0 == 0) goto L_0x0013
                    r0 = r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a$a r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a.C0468a) r0
                    int r1 = r0.f35848b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f35848b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a$a r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a$a
                    r0.<init>(r8, r10)
                L_0x0018:
                    java.lang.Object r10 = r0.f35847a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f35848b
                    r3 = 10
                    r4 = 5
                    r5 = 6
                    switch(r2) {
                        case 0: goto L_0x012b;
                        case 1: goto L_0x0117;
                        case 2: goto L_0x0102;
                        case 3: goto L_0x00ee;
                        case 4: goto L_0x00d9;
                        case 5: goto L_0x00c4;
                        case 6: goto L_0x00af;
                        case 7: goto L_0x009b;
                        case 8: goto L_0x0086;
                        case 9: goto L_0x0072;
                        case 10: goto L_0x005d;
                        case 11: goto L_0x0049;
                        case 12: goto L_0x0034;
                        case 13: goto L_0x002f;
                        default: goto L_0x0027;
                    }
                L_0x0027:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x002f:
                    kotlin.k.b(r10)
                    goto L_0x02f5
                L_0x0034:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r3 = r0.f35851e
                    kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    goto L_0x0189
                L_0x0049:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r3 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r3
                    kotlin.k.b(r10)
                    r4 = r3
                    r3 = r2
                L_0x005a:
                    r2 = r9
                    goto L_0x016f
                L_0x005d:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r3 = r0.f35851e
                    kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    goto L_0x01cd
                L_0x0072:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    r7 = r2
                    r2 = r9
                    r9 = r7
                    goto L_0x01b2
                L_0x0086:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r3 = r0.f35851e
                    kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                    java.lang.Object r5 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r5 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r5
                    kotlin.k.b(r10)
                    goto L_0x020f
                L_0x009b:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r3 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r3
                    kotlin.k.b(r10)
                    r5 = r3
                    r3 = r2
                L_0x00ac:
                    r2 = r9
                    goto L_0x01f5
                L_0x00af:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r4 = r0.f35851e
                    kotlinx.coroutines.flow.e r4 = (kotlinx.coroutines.flow.e) r4
                    java.lang.Object r5 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r5 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r5
                    kotlin.k.b(r10)
                    goto L_0x0250
                L_0x00c4:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    r7 = r2
                    r2 = r9
                    r9 = r4
                    r4 = r7
                    goto L_0x0235
                L_0x00d9:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r3 = r0.f35851e
                    kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    goto L_0x0293
                L_0x00ee:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r3 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r3
                    kotlin.k.b(r10)
                    r4 = r3
                    r3 = r2
                L_0x00ff:
                    r2 = r9
                    goto L_0x027a
                L_0x0102:
                    java.lang.Object r9 = r0.f35853g
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r2 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r2 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2
                    java.lang.Object r3 = r0.f35851e
                    kotlinx.coroutines.flow.e r3 = (kotlinx.coroutines.flow.e) r3
                    java.lang.Object r4 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r4
                    kotlin.k.b(r10)
                    goto L_0x02d2
                L_0x0117:
                    java.lang.Object r9 = r0.f35852f
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    java.lang.Object r2 = r0.f35851e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r3 = r0.f35849c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$h$a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a) r3
                    kotlin.k.b(r10)
                    r4 = r3
                    r3 = r2
                L_0x0128:
                    r2 = r9
                    goto L_0x02b9
                L_0x012b:
                    kotlin.k.b(r10)
                    kotlinx.coroutines.flow.e r10 = r8.f35845a
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$Step r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9
                    int[] r2 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.f.f35835a
                    int r6 = r9.ordinal()
                    r2 = r2[r6]
                    r6 = 1
                    switch(r2) {
                        case 1: goto L_0x02a1;
                        case 2: goto L_0x0261;
                        case 3: goto L_0x021e;
                        case 4: goto L_0x01dc;
                        case 5: goto L_0x0198;
                        case 6: goto L_0x0155;
                        case 7: goto L_0x0144;
                        default: goto L_0x013e;
                    }
                L_0x013e:
                    kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                    r9.<init>()
                    throw r9
                L_0x0144:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c r2 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r3 = r8.f35846b
                    java.util.Map r9 = r3.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r9)
                    java.lang.String r3 = "!!! FOR TESTING ONLY !!!"
                    java.lang.String r4 = "Enter the LAST digit of your old 6-digit PIN"
                    r2.<init>(r3, r4, r6, r9)
                    goto L_0x02e1
                L_0x0155:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r3 = 11
                    r0.f35848b = r3
                    java.lang.String r3 = "sns_eid_pinpad_newPinRepeat_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x016a
                    return r1
                L_0x016a:
                    r4 = r8
                    r3 = r10
                    r10 = r2
                    goto L_0x005a
                L_0x016f:
                    r9 = r10
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r10 = r4.f35846b
                    r0.f35849c = r4
                    r0.f35851e = r3
                    r0.f35852f = r2
                    r0.f35853g = r9
                    r6 = 12
                    r0.f35848b = r6
                    java.lang.String r6 = "sns_eid_pinpad_newPinRepeat_subtitle"
                    java.lang.Object r10 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r10 != r1) goto L_0x0189
                    return r1
                L_0x0189:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r4 = r4.f35846b
                    java.util.Map r2 = r4.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$e r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$e
                    r4.<init>(r9, r10, r5, r2)
                    goto L_0x02df
                L_0x0198:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r4 = 9
                    r0.f35848b = r4
                    java.lang.String r4 = "sns_eid_pinpad_newPin_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x01ad
                    return r1
                L_0x01ad:
                    r4 = r8
                    r7 = r2
                    r2 = r9
                    r9 = r10
                    r10 = r7
                L_0x01b2:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r6 = r4.f35846b
                    r0.f35849c = r4
                    r0.f35851e = r9
                    r0.f35852f = r2
                    r0.f35853g = r10
                    r0.f35848b = r3
                    java.lang.String r3 = "sns_eid_pinpad_newPin_subtitle"
                    java.lang.Object r3 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r3 != r1) goto L_0x01c9
                    return r1
                L_0x01c9:
                    r7 = r3
                    r3 = r9
                    r9 = r10
                    r10 = r7
                L_0x01cd:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r4 = r4.f35846b
                    java.util.Map r2 = r4.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$a r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$a
                    r4.<init>(r9, r10, r5, r2)
                    goto L_0x02df
                L_0x01dc:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r3 = 7
                    r0.f35848b = r3
                    java.lang.String r3 = "sns_eid_pinpad_transportPin_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x01f0
                    return r1
                L_0x01f0:
                    r5 = r8
                    r3 = r10
                    r10 = r2
                    goto L_0x00ac
                L_0x01f5:
                    r9 = r10
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r10 = r5.f35846b
                    r0.f35849c = r5
                    r0.f35851e = r3
                    r0.f35852f = r2
                    r0.f35853g = r9
                    r6 = 8
                    r0.f35848b = r6
                    java.lang.String r6 = "sns_eid_pinpad_transportPin_subtitle"
                    java.lang.Object r10 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r10 != r1) goto L_0x020f
                    return r1
                L_0x020f:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r5 = r5.f35846b
                    java.util.Map r2 = r5.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$b r5 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$b
                    r5.<init>(r9, r10, r4, r2)
                    r10 = r3
                    goto L_0x025e
                L_0x021e:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r0.f35848b = r4
                    java.lang.String r4 = "sns_eid_pinpad_puk_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x0231
                    return r1
                L_0x0231:
                    r4 = r10
                    r10 = r2
                    r2 = r9
                    r9 = r8
                L_0x0235:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r6 = r9.f35846b
                    r0.f35849c = r9
                    r0.f35851e = r4
                    r0.f35852f = r2
                    r0.f35853g = r10
                    r0.f35848b = r5
                    java.lang.String r5 = "sns_eid_pinpad_puk_subtitle"
                    java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r5 != r1) goto L_0x024c
                    return r1
                L_0x024c:
                    r7 = r5
                    r5 = r9
                    r9 = r10
                    r10 = r7
                L_0x0250:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r5 = r5.f35846b
                    java.util.Map r2 = r5.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c r5 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c
                    r5.<init>(r9, r10, r3, r2)
                    r10 = r4
                L_0x025e:
                    r2 = r5
                    goto L_0x02e1
                L_0x0261:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r3 = 3
                    r0.f35848b = r3
                    java.lang.String r3 = "sns_eid_pinpad_can_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x0275
                    return r1
                L_0x0275:
                    r4 = r8
                    r3 = r10
                    r10 = r2
                    goto L_0x00ff
                L_0x027a:
                    r9 = r10
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r10 = r4.f35846b
                    r0.f35849c = r4
                    r0.f35851e = r3
                    r0.f35852f = r2
                    r0.f35853g = r9
                    r6 = 4
                    r0.f35848b = r6
                    java.lang.String r6 = "sns_eid_pinpad_can_subtitle"
                    java.lang.Object r10 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r10 != r1) goto L_0x0293
                    return r1
                L_0x0293:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r4 = r4.f35846b
                    java.util.Map r2 = r4.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c
                    r4.<init>(r9, r10, r5, r2)
                    goto L_0x02df
                L_0x02a1:
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r2 = r8.f35846b
                    r0.f35849c = r8
                    r0.f35851e = r10
                    r0.f35852f = r9
                    r0.f35848b = r6
                    java.lang.String r3 = "sns_eid_pinpad_pin_title"
                    java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r2 != r1) goto L_0x02b4
                    return r1
                L_0x02b4:
                    r4 = r8
                    r3 = r10
                    r10 = r2
                    goto L_0x0128
                L_0x02b9:
                    r9 = r10
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r10 = r4.f35846b
                    r0.f35849c = r4
                    r0.f35851e = r3
                    r0.f35852f = r2
                    r0.f35853g = r9
                    r6 = 2
                    r0.f35848b = r6
                    java.lang.String r6 = "sns_eid_pinpad_pin_subtitle"
                    java.lang.Object r10 = r10.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                    if (r10 != r1) goto L_0x02d2
                    return r1
                L_0x02d2:
                    java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel r4 = r4.f35846b
                    java.util.Map r2 = r4.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.Step) r2)
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$e$c
                    r4.<init>(r9, r10, r5, r2)
                L_0x02df:
                    r10 = r3
                    r2 = r4
                L_0x02e1:
                    r9 = 0
                    r0.f35849c = r9
                    r0.f35851e = r9
                    r0.f35852f = r9
                    r0.f35853g = r9
                    r9 = 13
                    r0.f35848b = r9
                    java.lang.Object r9 = r10.emit(r2, r0)
                    if (r9 != r1) goto L_0x02f5
                    return r1
                L_0x02f5:
                    kotlin.Unit r9 = kotlin.Unit.f56620a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel.h.a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public h(kotlinx.coroutines.flow.d dVar, SNSEidPinViewModel sNSEidPinViewModel) {
            this.f35843a = dVar;
            this.f35844b = sNSEidPinViewModel;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f35843a.collect(new a(eVar, this.f35844b), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.SNSEidPinViewModel$stepFlow$1", f = "SNSEidPinViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements p<Step, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35854a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35855b;

        public i(kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(Step step, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(step, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            i iVar = new i(cVar);
            iVar.f35855b = obj;
            return iVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35854a == 0) {
                k.b(obj);
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(SNSEidPinViewModel.K, "Step changed " + ((Step) this.f35855b), (Throwable) null, 4, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Class<SNSEidPinViewModel> cls = SNSEidPinViewModel.class;
        f35817z = new l[]{Reflection.e(new MutablePropertyReference1Impl(cls, E, "getCan()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "lastPinDigit", "getLastPinDigit()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "currentPin", "getCurrentPin()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "originalPin", "getOriginalPin()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "step", "getStep()Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/pin/SNSEidPinViewModel$Step;", 0))};
    }

    public SNSEidPinViewModel(a aVar, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar2, bVar);
        this.f35818q = aVar;
        this.f35819r = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, E, null);
        this.f35820s = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, D, null);
        this.f35821t = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, C, null);
        this.f35822u = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, B, null);
        Step step = Step.ENTER_PIN;
        this.f35823v = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, A, step);
        kotlinx.coroutines.flow.d<Step> P = kotlinx.coroutines.flow.f.P(savedStateHandle.g(A, step), new i((kotlin.coroutines.c<? super i>) null));
        this.f35824w = P;
        this.f35825x = kotlinx.coroutines.flow.f.a0(new h(P, this), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), e.d.f35834e);
        if (!(aVar instanceof a.c)) {
            if (aVar instanceof a.e) {
                step = Step.ENTER_OLD_PIN;
            } else if (aVar instanceof a.d) {
                step = Step.ENTER_PUK;
            } else if (aVar instanceof a.C0469a) {
                d(((a.C0469a) aVar).b());
                step = Step.ENTER_CAN;
            } else if (aVar instanceof a.b) {
                a.b bVar2 = (a.b) aVar;
                f(bVar2.f());
                d(bVar2.e());
                e(bVar2.d());
                step = Step.ENTER_CAN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        b(step);
    }

    public final void e(String str) {
        this.f35820s.a(this, f35817z[1], str);
    }

    public final void f(String str) {
        this.f35822u.a(this, f35817z[3], str);
    }

    public final void p() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(K, "Finish with success", (Throwable) null, 4, (Object) null);
        a((a.j) new b(new b(this.f35818q, r(), t(), q(), s())));
    }

    public final String q() {
        return (String) this.f35819r.a(this, f35817z[0]);
    }

    public final String r() {
        return (String) this.f35821t.a(this, f35817z[2]);
    }

    public final String s() {
        return (String) this.f35820s.a(this, f35817z[1]);
    }

    public final String t() {
        return (String) this.f35822u.a(this, f35817z[3]);
    }

    public final a u() {
        return this.f35818q;
    }

    public final Step v() {
        return (Step) this.f35823v.a(this, f35817z[4]);
    }

    /* renamed from: w */
    public j1<e> j() {
        return this.f35825x;
    }

    public final void d(String str) {
        this.f35821t.a(this, f35817z[2], str);
    }

    public final void b(Step step) {
        this.f35823v.a(this, f35817z[4], step);
    }

    public final void c(String str) {
        this.f35819r.a(this, f35817z[0], str);
    }

    public final n1 b(String str) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g(this, str, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
    }

    public static /* synthetic */ Map a(SNSEidPinViewModel sNSEidPinViewModel, Step step, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            step = sNSEidPinViewModel.v();
        }
        return sNSEidPinViewModel.a(step);
    }

    public final Map<String, Object> a(Step step) {
        String str = "transportPin";
        switch (f.f35835a[step.ordinal()]) {
            case 1:
                str = "pin";
                break;
            case 2:
                str = E;
                break;
            case 3:
                str = "puk";
                break;
            case 4:
            case 7:
                break;
            case 5:
                str = "newPin";
                break;
            case 6:
                str = "newPinRepeat";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return MapsKt__MapsJVMKt.e(kotlin.l.a("mode", str));
    }
}
