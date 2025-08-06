package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.b;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b;
import de.authada.library.api.Can;
import de.authada.library.api.CheckFailedReason;
import de.authada.library.api.RequiredData;
import de.authada.library.api.SecretWrong;
import de.authada.library.api.authentication.Pin;
import de.authada.library.api.authentication.PinTerminationReason;
import de.authada.library.api.authentication.StartCallback;
import de.authada.library.api.authentication.StartTerminationReason;
import de.authada.library.api.authentication.document.DocumentBuilder;
import de.authada.library.api.pinChanger.TPin;
import de.authada.library.api.pinChanger.TerminationReason;
import de.authada.library.api.unblock.Puk;
import de.authada.library.api.unblock.UnblockerCallback;
import de.authada.library.api.unblock.UnblockerCheckFailedReason;
import de.authada.library.api.unblock.UnblockerTerminationReason;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class a extends com.sumsub.sns.core.presentation.base.a<b> {
    public static final d F = new d((kotlin.jvm.internal.r) null);
    public static final /* synthetic */ kotlin.reflect.l<Object>[] G;
    public static final String H = "KEY_EID_STEP";
    public static final String I = "KEY_LEGAL_INFO";
    public static final String J = "eid_mobile_token";
    public static final String K = "eid_url";
    public static final String L = "eid_hash";
    public static final String M = "SNSEidMain";
    public static final n.e N = n.e.f35723a;
    public final q A;
    public final r B;
    public final x C;
    public final y D;
    public final d10.l<Throwable, Unit> E;

    /* renamed from: q  reason: collision with root package name */
    public final String f35646q;

    /* renamed from: r  reason: collision with root package name */
    public final String f35647r;

    /* renamed from: s  reason: collision with root package name */
    public final String f35648s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35649t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35650u;

    /* renamed from: v  reason: collision with root package name */
    public final b1<Integer> f35651v;

    /* renamed from: w  reason: collision with root package name */
    public final b1<String> f35652w;

    /* renamed from: x  reason: collision with root package name */
    public final j1<n> f35653x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f35654y;

    /* renamed from: z  reason: collision with root package name */
    public final j1<b> f35655z;

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$a  reason: collision with other inner class name */
    public static final class C0436a {

        /* renamed from: a  reason: collision with root package name */
        public final Screen f35656a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, Object> f35657b;

        public C0436a(Screen screen, Map<String, ? extends Object> map) {
            this.f35656a = screen;
            this.f35657b = map;
        }

        public final Screen a() {
            return this.f35656a;
        }

        public final Map<String, Object> b() {
            return this.f35657b;
        }

        public final Map<String, Object> c() {
            return this.f35657b;
        }

        public final Screen d() {
            return this.f35656a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0436a)) {
                return false;
            }
            C0436a aVar = (C0436a) obj;
            return this.f35656a == aVar.f35656a && kotlin.jvm.internal.x.b(this.f35657b, aVar.f35657b);
        }

        public int hashCode() {
            return (this.f35656a.hashCode() * 31) + this.f35657b.hashCode();
        }

        public String toString() {
            return "AnalyticsWrapper(screen=" + this.f35656a + ", payload=" + this.f35657b + ')';
        }

        public final C0436a a(Screen screen, Map<String, ? extends Object> map) {
            return new C0436a(screen, map);
        }

        public static /* synthetic */ C0436a a(C0436a aVar, Screen screen, Map<String, Object> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                screen = aVar.f35656a;
            }
            if ((i11 & 2) != 0) {
                map = aVar.f35657b;
            }
            return aVar.a(screen, map);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$setScanningState$1", f = "SNSEidMainViewModel.kt", l = {489, 491}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35658a;

        /* renamed from: b  reason: collision with root package name */
        public int f35659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f35660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f35661d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(boolean z11, a aVar, kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
            this.f35660c = z11;
            this.f35661d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a0(this.f35660c, this.f35661d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            b1 b1Var;
            b1 b1Var2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35659b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                if (this.f35660c) {
                    b1 d12 = this.f35661d.f35652w;
                    a aVar = this.f35661d;
                    this.f35658a = d12;
                    this.f35659b = 1;
                    Object a11 = aVar.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35631t, (kotlin.coroutines.c<? super String>) this);
                    if (a11 == d11) {
                        return d11;
                    }
                    b1Var2 = d12;
                    obj = a11;
                } else {
                    b1 d13 = this.f35661d.f35652w;
                    a aVar2 = this.f35661d;
                    this.f35658a = d13;
                    this.f35659b = 2;
                    Object a12 = aVar2.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35629s, (kotlin.coroutines.c<? super String>) this);
                    if (a12 == d11) {
                        return d11;
                    }
                    b1Var = d13;
                    obj = a12;
                    b1Var.setValue(obj);
                    return Unit.f56620a;
                }
            } else if (i11 == 1) {
                b1Var2 = (b1) this.f35658a;
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                b1Var = (b1) this.f35658a;
                kotlin.k.b(obj);
                b1Var.setValue(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b1Var2.setValue(obj);
            return Unit.f56620a;
        }
    }

    public static final class b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a f35662a;

        public b(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a aVar) {
            this.f35662a = aVar;
        }

        public final com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a a() {
            return this.f35662a;
        }

        public final com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a b() {
            return this.f35662a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.x.b(this.f35662a, ((b) obj).f35662a);
        }

        public int hashCode() {
            return this.f35662a.hashCode();
        }

        public String toString() {
            return "AuthadaInteractionEvent(interaction=" + this.f35662a + ')';
        }

        public final b a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a aVar) {
            return new b(aVar);
        }

        public static /* synthetic */ b a(b bVar, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                aVar = bVar.f35662a;
            }
            return bVar.a(aVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$showLegalInfoExplain$1", f = "SNSEidMainViewModel.kt", l = {719, 721}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35663a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35664b;

        /* renamed from: c  reason: collision with root package name */
        public int f35665c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f35666d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(a aVar, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f35666d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f35666d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            CharSequence charSequence;
            CharSequence charSequence2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35665c;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a aVar = this.f35666d;
                this.f35665c = 1;
                obj = aVar.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35621o, (kotlin.coroutines.c<? super String>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                charSequence2 = (CharSequence) this.f35664b;
                charSequence = (CharSequence) this.f35663a;
                kotlin.k.b(obj);
                this.f35666d.a((a.j) new j(charSequence, charSequence2, (CharSequence) obj));
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charSequence = (CharSequence) obj;
            CharSequence b11 = this.f35666d.s();
            a aVar2 = this.f35666d;
            this.f35663a = charSequence;
            this.f35664b = b11;
            this.f35665c = 2;
            Object a11 = aVar2.a("sns_alert_action_dismiss", (kotlin.coroutines.c<? super String>) this);
            if (a11 == d11) {
                return d11;
            }
            charSequence2 = b11;
            obj = a11;
            this.f35666d.a((a.j) new j(charSequence, charSequence2, (CharSequence) obj));
            return Unit.f56620a;
        }
    }

    public static final class c implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public static final c f35667a = new c();
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$showPinExplain$1", f = "SNSEidMainViewModel.kt", l = {711, 712}, m = "invokeSuspend")
    public static final class c0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35668a;

        /* renamed from: b  reason: collision with root package name */
        public int f35669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f35670c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(a aVar, kotlin.coroutines.c<? super c0> cVar) {
            super(2, cVar);
            this.f35670c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c0(this.f35670c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            CharSequence charSequence;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35669b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a aVar = this.f35670c;
                this.f35669b = 1;
                obj = aVar.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35611j, (kotlin.coroutines.c<? super String>) this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else if (i11 == 2) {
                charSequence = (CharSequence) this.f35668a;
                kotlin.k.b(obj);
                this.f35670c.a((a.j) new l(charSequence, (CharSequence) obj));
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CharSequence charSequence2 = (CharSequence) obj;
            a aVar2 = this.f35670c;
            this.f35668a = charSequence2;
            this.f35669b = 2;
            Object a11 = aVar2.a("sns_alert_action_dismiss", (kotlin.coroutines.c<? super String>) this);
            if (a11 == d11) {
                return d11;
            }
            charSequence = charSequence2;
            obj = a11;
            this.f35670c.a((a.j) new l(charSequence, (CharSequence) obj));
            return Unit.f56620a;
        }
    }

    public static final class d {
        public /* synthetic */ d(kotlin.jvm.internal.r rVar) {
            this();
        }

        public d() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$throwGeneralError$1", f = "SNSEidMainViewModel.kt", l = {830, 830, 830}, m = "invokeSuspend")
    public static final class d0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35671a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35672b;

        /* renamed from: c  reason: collision with root package name */
        public int f35673c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f35674d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f35675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f35676f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f35677g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Throwable f35678h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f35679i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(a aVar, String str, String str2, String str3, Throwable th2, i iVar, kotlin.coroutines.c<? super d0> cVar) {
            super(2, cVar);
            this.f35674d = aVar;
            this.f35675e = str;
            this.f35676f = str2;
            this.f35677g = str3;
            this.f35678h = th2;
            this.f35679i = iVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d0(this.f35674d, this.f35675e, this.f35676f, this.f35677g, this.f35678h, this.f35679i, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r6.f35673c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0031
                if (r1 == r4) goto L_0x002d
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                java.lang.Object r0 = r6.f35672b
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r1 = r6.f35671a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r7)
                goto L_0x006a
            L_0x001d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0025:
                java.lang.Object r1 = r6.f35671a
                java.lang.String r1 = (java.lang.String) r1
                kotlin.k.b(r7)
                goto L_0x0055
            L_0x002d:
                kotlin.k.b(r7)
                goto L_0x0041
            L_0x0031:
                kotlin.k.b(r7)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r7 = r6.f35674d
                java.lang.String r1 = r6.f35675e
                r6.f35673c = r4
                java.lang.Object r7 = r7.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r7 != r0) goto L_0x0041
                return r0
            L_0x0041:
                java.lang.String r7 = (java.lang.String) r7
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r1 = r6.f35674d
                java.lang.String r4 = r6.f35676f
                r6.f35671a = r7
                r6.f35673c = r3
                java.lang.Object r1 = r1.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r1 != r0) goto L_0x0052
                return r0
            L_0x0052:
                r5 = r1
                r1 = r7
                r7 = r5
            L_0x0055:
                java.lang.String r7 = (java.lang.String) r7
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r3 = r6.f35674d
                java.lang.String r4 = r6.f35677g
                r6.f35671a = r1
                r6.f35672b = r7
                r6.f35673c = r2
                java.lang.Object r2 = r3.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r6)
                if (r2 != r0) goto L_0x0068
                return r0
            L_0x0068:
                r0 = r7
                r7 = r2
            L_0x006a:
                java.lang.String r7 = (java.lang.String) r7
                com.sumsub.sns.internal.core.data.model.o$a r2 = new com.sumsub.sns.internal.core.data.model.o$a
                r2.<init>(r1, r0, r7)
                com.sumsub.sns.internal.core.data.model.o$d r7 = new com.sumsub.sns.internal.core.data.model.o$d
                java.lang.Throwable r0 = r6.f35678h
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i r1 = r6.f35679i
                r7.<init>(r0, r1, r2)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r0 = r6.f35674d
                java.lang.String r1 = r0.f()
                r0.a((com.sumsub.sns.internal.core.data.model.o) r7, (java.lang.String) r1)
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.d0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class e implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35680a;

        public e(String str) {
            this.f35680a = str;
        }

        public final String a() {
            return this.f35680a;
        }

        public final String b() {
            return this.f35680a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && kotlin.jvm.internal.x.b(this.f35680a, ((e) obj).f35680a);
        }

        public int hashCode() {
            return this.f35680a.hashCode();
        }

        public String toString() {
            return "EnterCanEvent(pin=" + this.f35680a + ')';
        }

        public final e a(String str) {
            return new e(str);
        }

        public static /* synthetic */ e a(e eVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = eVar.f35680a;
            }
            return eVar.a(str);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$viewState$1", f = "SNSEidMainViewModel.kt", l = {96, 97}, m = "invokeSuspend")
    public static final class e0 extends SuspendLambda implements d10.r<n, Integer, String, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35681a;

        /* renamed from: b  reason: collision with root package name */
        public int f35682b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35683c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ int f35684d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f35685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f35686f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(a aVar, kotlin.coroutines.c<? super e0> cVar) {
            super(4, cVar);
            this.f35686f = aVar;
        }

        public final Object a(n nVar, int i11, String str, kotlin.coroutines.c<? super b> cVar) {
            e0 e0Var = new e0(this.f35686f, cVar);
            e0Var.f35683c = nVar;
            e0Var.f35684d = i11;
            e0Var.f35685e = str;
            return e0Var.invokeSuspend(Unit.f56620a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return a((n) obj, ((Number) obj2).intValue(), (String) obj3, (kotlin.coroutines.c) obj4);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0097  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f35682b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0036
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                int r0 = r8.f35684d
                java.lang.Object r1 = r8.f35681a
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r2 = r8.f35685e
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r8.f35683c
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n) r3
                kotlin.k.b(r9)
                goto L_0x0074
            L_0x0020:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0028:
                int r1 = r8.f35684d
                java.lang.Object r3 = r8.f35685e
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r8.f35683c
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n) r4
                kotlin.k.b(r9)
                goto L_0x005a
            L_0x0036:
                kotlin.k.b(r9)
                java.lang.Object r9 = r8.f35683c
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n r9 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n) r9
                int r1 = r8.f35684d
                java.lang.Object r4 = r8.f35685e
                java.lang.String r4 = (java.lang.String) r4
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r8.f35686f
                r8.f35683c = r9
                r8.f35685e = r4
                r8.f35684d = r1
                r8.f35682b = r3
                java.lang.String r3 = "sns_eid_nfcScan_hint_searching"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r3 != r0) goto L_0x0056
                return r0
            L_0x0056:
                r7 = r4
                r4 = r9
                r9 = r3
                r3 = r7
            L_0x005a:
                java.lang.String r9 = (java.lang.String) r9
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r8.f35686f
                r8.f35683c = r4
                r8.f35685e = r3
                r8.f35681a = r9
                r8.f35684d = r1
                r8.f35682b = r2
                java.lang.Object r2 = r5.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r8)
                if (r2 != r0) goto L_0x006f
                return r0
            L_0x006f:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r3
                r3 = r4
            L_0x0074:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r9 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r9
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$a r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r8.f35686f
                com.sumsub.sns.internal.core.analytics.Screen r5 = r5.b((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n) r3)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r6 = r8.f35686f
                java.util.Map r6 = r6.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n) r3)
                r4.<init>(r5, r6)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$e r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.e.f35723a
                boolean r5 = kotlin.jvm.internal.x.b(r3, r5)
                if (r5 == 0) goto L_0x0097
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$d r9 = r0.c(r9, r4)
                goto L_0x0112
            L_0x0097:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$b r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.b.f35720a
                boolean r5 = kotlin.jvm.internal.x.b(r3, r5)
                if (r5 == 0) goto L_0x00a7
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$b r9 = r0.a(r9, r4)
                goto L_0x0112
            L_0x00a7:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$d r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.d.f35722a
                boolean r5 = kotlin.jvm.internal.x.b(r3, r5)
                if (r5 == 0) goto L_0x00ba
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                if (r2 != 0) goto L_0x00b4
                goto L_0x00b5
            L_0x00b4:
                r1 = r2
            L_0x00b5:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$e r9 = r0.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r9, (java.lang.String) r1, (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.C0436a) r4)
                goto L_0x0112
            L_0x00ba:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$c r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.c.f35721a
                boolean r5 = kotlin.jvm.internal.x.b(r3, r5)
                if (r5 == 0) goto L_0x00c9
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$f r9 = r0.b(r9, r4)
                goto L_0x0112
            L_0x00c9:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$h r5 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.h.f35726a
                boolean r5 = kotlin.jvm.internal.x.b(r3, r5)
                if (r5 == 0) goto L_0x00dc
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r3 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                if (r2 != 0) goto L_0x00d6
                goto L_0x00d7
            L_0x00d6:
                r1 = r2
            L_0x00d7:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$e r9 = r3.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r9, (int) r0, (java.lang.String) r1, (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.C0436a) r4)
                goto L_0x0112
            L_0x00dc:
                boolean r0 = r3 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.C0452a
                if (r0 == 0) goto L_0x00f1
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.C0452a) r3
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i r1 = r3.c()
                boolean r2 = r3.d()
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$a r9 = r0.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r9, (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.i) r1, (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.C0436a) r4, (boolean) r2)
                goto L_0x0112
            L_0x00f1:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$g r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.g.f35725a
                boolean r0 = kotlin.jvm.internal.x.b(r3, r0)
                if (r0 == 0) goto L_0x0104
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                if (r2 != 0) goto L_0x00fe
                goto L_0x00ff
            L_0x00fe:
                r1 = r2
            L_0x00ff:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$e r9 = r0.a((com.sumsub.sns.internal.core.data.source.dynamic.b.c) r9, (java.lang.CharSequence) r1, (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.C0436a) r4)
                goto L_0x0112
            L_0x0104:
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$f r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.n.f.f35724a
                boolean r0 = kotlin.jvm.internal.x.b(r3, r0)
                if (r0 == 0) goto L_0x0113
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c r0 = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.c.f35815a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$f r9 = r0.d(r9, r4)
            L_0x0112:
                return r9
            L_0x0113:
                kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
                r9.<init>()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.e0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35687a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35688b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35689c;

        public f(String str, String str2, String str3) {
            this.f35687a = str;
            this.f35688b = str2;
            this.f35689c = str3;
        }

        public final String a() {
            return this.f35687a;
        }

        public final String b() {
            return this.f35688b;
        }

        public final String c() {
            return this.f35689c;
        }

        public final String d() {
            return this.f35689c;
        }

        public final String e() {
            return this.f35688b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return kotlin.jvm.internal.x.b(this.f35687a, fVar.f35687a) && kotlin.jvm.internal.x.b(this.f35688b, fVar.f35688b) && kotlin.jvm.internal.x.b(this.f35689c, fVar.f35689c);
        }

        public final String f() {
            return this.f35687a;
        }

        public int hashCode() {
            int hashCode = ((this.f35687a.hashCode() * 31) + this.f35688b.hashCode()) * 31;
            String str = this.f35689c;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "EnterCanForTransportPinEvent(pin=" + this.f35687a + ", newPin=" + this.f35688b + ", lastPinDigit=" + this.f35689c + ')';
        }

        public final f a(String str, String str2, String str3) {
            return new f(str, str2, str3);
        }

        public static /* synthetic */ f a(f fVar, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = fVar.f35687a;
            }
            if ((i11 & 2) != 0) {
                str2 = fVar.f35688b;
            }
            if ((i11 & 4) != 0) {
                str3 = fVar.f35689c;
            }
            return fVar.a(str, str2, str3);
        }
    }

    public static final class g implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f35690a;

        public g(boolean z11) {
            this.f35690a = z11;
        }

        public final boolean a() {
            return this.f35690a;
        }

        public final boolean b() {
            return this.f35690a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && this.f35690a == ((g) obj).f35690a;
        }

        public int hashCode() {
            boolean z11 = this.f35690a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "EnterPinEvent(needCan=" + this.f35690a + ')';
        }

        public final g a(boolean z11) {
            return new g(z11);
        }

        public static /* synthetic */ g a(g gVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = gVar.f35690a;
            }
            return gVar.a(z11);
        }
    }

    public static final class h implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public static final h f35691a = new h();
    }

    public static abstract class i implements Parcelable {

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$a  reason: collision with other inner class name */
        public static final class C0437a extends i {
            public static final Parcelable.Creator<C0437a> CREATOR = new C0438a();

            /* renamed from: a  reason: collision with root package name */
            public static final C0437a f35692a = new C0437a();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$a$a  reason: collision with other inner class name */
            public static final class C0438a implements Parcelable.Creator<C0437a> {
                /* renamed from: a */
                public final C0437a createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return C0437a.f35692a;
                }

                /* renamed from: a */
                public final C0437a[] newArray(int i11) {
                    return new C0437a[i11];
                }
            }

            public C0437a() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class b extends i {
            public static final Parcelable.Creator<b> CREATOR = new C0439a();

            /* renamed from: a  reason: collision with root package name */
            public static final b f35693a = new b();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$b$a  reason: collision with other inner class name */
            public static final class C0439a implements Parcelable.Creator<b> {
                /* renamed from: a */
                public final b createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return b.f35693a;
                }

                /* renamed from: a */
                public final b[] newArray(int i11) {
                    return new b[i11];
                }
            }

            public b() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class c extends i {
            public static final Parcelable.Creator<c> CREATOR = new C0440a();

            /* renamed from: a  reason: collision with root package name */
            public static final c f35694a = new c();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$c$a  reason: collision with other inner class name */
            public static final class C0440a implements Parcelable.Creator<c> {
                /* renamed from: a */
                public final c createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return c.f35694a;
                }

                /* renamed from: a */
                public final c[] newArray(int i11) {
                    return new c[i11];
                }
            }

            public c() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class d extends i {
            public static final Parcelable.Creator<d> CREATOR = new C0441a();

            /* renamed from: a  reason: collision with root package name */
            public static final d f35695a = new d();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$d$a  reason: collision with other inner class name */
            public static final class C0441a implements Parcelable.Creator<d> {
                /* renamed from: a */
                public final d createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return d.f35695a;
                }

                /* renamed from: a */
                public final d[] newArray(int i11) {
                    return new d[i11];
                }
            }

            public d() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class e extends i {
            public static final Parcelable.Creator<e> CREATOR = new C0442a();

            /* renamed from: a  reason: collision with root package name */
            public static final e f35696a = new e();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$e$a  reason: collision with other inner class name */
            public static final class C0442a implements Parcelable.Creator<e> {
                /* renamed from: a */
                public final e createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return e.f35696a;
                }

                /* renamed from: a */
                public final e[] newArray(int i11) {
                    return new e[i11];
                }
            }

            public e() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class f extends i {
            public static final Parcelable.Creator<f> CREATOR = new C0443a();

            /* renamed from: a  reason: collision with root package name */
            public static final f f35697a = new f();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$f$a  reason: collision with other inner class name */
            public static final class C0443a implements Parcelable.Creator<f> {
                /* renamed from: a */
                public final f createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return f.f35697a;
                }

                /* renamed from: a */
                public final f[] newArray(int i11) {
                    return new f[i11];
                }
            }

            public f() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class g extends i {
            public static final Parcelable.Creator<g> CREATOR = new C0444a();

            /* renamed from: a  reason: collision with root package name */
            public final String f35698a;

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$g$a  reason: collision with other inner class name */
            public static final class C0444a implements Parcelable.Creator<g> {
                /* renamed from: a */
                public final g createFromParcel(Parcel parcel) {
                    return new g(parcel.readString());
                }

                /* renamed from: a */
                public final g[] newArray(int i11) {
                    return new g[i11];
                }
            }

            public g(String str) {
                super((kotlin.jvm.internal.r) null);
                this.f35698a = str;
            }

            public final String a() {
                return this.f35698a;
            }

            public final String b() {
                return this.f35698a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && kotlin.jvm.internal.x.b(this.f35698a, ((g) obj).f35698a);
            }

            public int hashCode() {
                return this.f35698a.hashCode();
            }

            public String toString() {
                return "RequestCan(pin=" + this.f35698a + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeString(this.f35698a);
            }

            public final g a(String str) {
                return new g(str);
            }

            public static /* synthetic */ g a(g gVar, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = gVar.f35698a;
                }
                return gVar.a(str);
            }
        }

        public static final class h extends i {
            public static final Parcelable.Creator<h> CREATOR = new C0445a();

            /* renamed from: a  reason: collision with root package name */
            public final String f35699a;

            /* renamed from: b  reason: collision with root package name */
            public final String f35700b;

            /* renamed from: c  reason: collision with root package name */
            public final String f35701c;

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$h$a  reason: collision with other inner class name */
            public static final class C0445a implements Parcelable.Creator<h> {
                /* renamed from: a */
                public final h createFromParcel(Parcel parcel) {
                    return new h(parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: a */
                public final h[] newArray(int i11) {
                    return new h[i11];
                }
            }

            public h(String str, String str2, String str3) {
                super((kotlin.jvm.internal.r) null);
                this.f35699a = str;
                this.f35700b = str2;
                this.f35701c = str3;
            }

            public final String a() {
                return this.f35699a;
            }

            public final String b() {
                return this.f35700b;
            }

            public final String c() {
                return this.f35701c;
            }

            public final String d() {
                return this.f35701c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f35700b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof h)) {
                    return false;
                }
                h hVar = (h) obj;
                return kotlin.jvm.internal.x.b(this.f35699a, hVar.f35699a) && kotlin.jvm.internal.x.b(this.f35700b, hVar.f35700b) && kotlin.jvm.internal.x.b(this.f35701c, hVar.f35701c);
            }

            public final String f() {
                return this.f35699a;
            }

            public int hashCode() {
                int hashCode = ((this.f35699a.hashCode() * 31) + this.f35700b.hashCode()) * 31;
                String str = this.f35701c;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "RequestCanForTransportPin(pin=" + this.f35699a + ", newPin=" + this.f35700b + ", lastPinDigit=" + this.f35701c + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeString(this.f35699a);
                parcel.writeString(this.f35700b);
                parcel.writeString(this.f35701c);
            }

            public final h a(String str, String str2, String str3) {
                return new h(str, str2, str3);
            }

            public static /* synthetic */ h a(h hVar, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = hVar.f35699a;
                }
                if ((i11 & 2) != 0) {
                    str2 = hVar.f35700b;
                }
                if ((i11 & 4) != 0) {
                    str3 = hVar.f35701c;
                }
                return hVar.a(str, str2, str3);
            }
        }

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$i  reason: collision with other inner class name */
        public static final class C0446i extends i {
            public static final Parcelable.Creator<C0446i> CREATOR = new C0447a();

            /* renamed from: a  reason: collision with root package name */
            public final SecretWrong f35702a;

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$i$a  reason: collision with other inner class name */
            public static final class C0447a implements Parcelable.Creator<C0446i> {
                /* renamed from: a */
                public final C0446i createFromParcel(Parcel parcel) {
                    return new C0446i(parcel.readInt() == 0 ? null : SecretWrong.valueOf(parcel.readString()));
                }

                /* renamed from: a */
                public final C0446i[] newArray(int i11) {
                    return new C0446i[i11];
                }
            }

            public C0446i(SecretWrong secretWrong) {
                super((kotlin.jvm.internal.r) null);
                this.f35702a = secretWrong;
            }

            public final SecretWrong a() {
                return this.f35702a;
            }

            public final SecretWrong b() {
                return this.f35702a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0446i) && this.f35702a == ((C0446i) obj).f35702a;
            }

            public int hashCode() {
                SecretWrong secretWrong = this.f35702a;
                if (secretWrong == null) {
                    return 0;
                }
                return secretWrong.hashCode();
            }

            public String toString() {
                return "RequestPin(triesLeft=" + this.f35702a + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                SecretWrong secretWrong = this.f35702a;
                if (secretWrong == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeString(secretWrong.name());
            }

            public final C0446i a(SecretWrong secretWrong) {
                return new C0446i(secretWrong);
            }

            public static /* synthetic */ C0446i a(C0446i iVar, SecretWrong secretWrong, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    secretWrong = iVar.f35702a;
                }
                return iVar.a(secretWrong);
            }
        }

        public static final class j extends i {
            public static final Parcelable.Creator<j> CREATOR = new C0448a();

            /* renamed from: a  reason: collision with root package name */
            public static final j f35703a = new j();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$j$a  reason: collision with other inner class name */
            public static final class C0448a implements Parcelable.Creator<j> {
                /* renamed from: a */
                public final j createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return j.f35703a;
                }

                /* renamed from: a */
                public final j[] newArray(int i11) {
                    return new j[i11];
                }
            }

            public j() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class k extends i {
            public static final Parcelable.Creator<k> CREATOR = new C0449a();

            /* renamed from: a  reason: collision with root package name */
            public static final k f35704a = new k();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$k$a  reason: collision with other inner class name */
            public static final class C0449a implements Parcelable.Creator<k> {
                /* renamed from: a */
                public final k createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return k.f35704a;
                }

                /* renamed from: a */
                public final k[] newArray(int i11) {
                    return new k[i11];
                }
            }

            public k() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class l extends i {
            public static final Parcelable.Creator<l> CREATOR = new C0450a();

            /* renamed from: a  reason: collision with root package name */
            public static final l f35705a = new l();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$l$a  reason: collision with other inner class name */
            public static final class C0450a implements Parcelable.Creator<l> {
                /* renamed from: a */
                public final l createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return l.f35705a;
                }

                /* renamed from: a */
                public final l[] newArray(int i11) {
                    return new l[i11];
                }
            }

            public l() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class m extends i {
            public static final Parcelable.Creator<m> CREATOR = new C0451a();

            /* renamed from: a  reason: collision with root package name */
            public static final m f35706a = new m();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$i$m$a  reason: collision with other inner class name */
            public static final class C0451a implements Parcelable.Creator<m> {
                /* renamed from: a */
                public final m createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return m.f35706a;
                }

                /* renamed from: a */
                public final m[] newArray(int i11) {
                    return new m[i11];
                }
            }

            public m() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public /* synthetic */ i(kotlin.jvm.internal.r rVar) {
            this();
        }

        public i() {
        }
    }

    public static final class j implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35707a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35708b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35709c;

        public j() {
            this((CharSequence) null, (CharSequence) null, (CharSequence) null, 7, (kotlin.jvm.internal.r) null);
        }

        public final CharSequence a() {
            return this.f35707a;
        }

        public final CharSequence b() {
            return this.f35708b;
        }

        public final CharSequence c() {
            return this.f35709c;
        }

        public final CharSequence d() {
            return this.f35709c;
        }

        public final CharSequence e() {
            return this.f35708b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return kotlin.jvm.internal.x.b(this.f35707a, jVar.f35707a) && kotlin.jvm.internal.x.b(this.f35708b, jVar.f35708b) && kotlin.jvm.internal.x.b(this.f35709c, jVar.f35709c);
        }

        public final CharSequence f() {
            return this.f35707a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f35707a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35708b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35709c;
            if (charSequence3 != null) {
                i11 = charSequence3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "LegalInfoExplainEvent(title=" + this.f35707a + ", text=" + this.f35708b + ", buttonText=" + this.f35709c + ')';
        }

        public j(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f35707a = charSequence;
            this.f35708b = charSequence2;
            this.f35709c = charSequence3;
        }

        public final j a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new j(charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ j a(j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = jVar.f35707a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = jVar.f35708b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = jVar.f35709c;
            }
            return jVar.a(charSequence, charSequence2, charSequence3);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ j(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3);
        }
    }

    public static final class k implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35710a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35711b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35712c;

        /* renamed from: d  reason: collision with root package name */
        public final String f35713d;

        public k(String str, String str2, String str3, String str4) {
            this.f35710a = str;
            this.f35711b = str2;
            this.f35712c = str3;
            this.f35713d = str4;
        }

        public final String a() {
            return this.f35710a;
        }

        public final String b() {
            return this.f35711b;
        }

        public final String c() {
            return this.f35712c;
        }

        public final String d() {
            return this.f35713d;
        }

        public final String e() {
            return this.f35713d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return kotlin.jvm.internal.x.b(this.f35710a, kVar.f35710a) && kotlin.jvm.internal.x.b(this.f35711b, kVar.f35711b) && kotlin.jvm.internal.x.b(this.f35712c, kVar.f35712c) && kotlin.jvm.internal.x.b(this.f35713d, kVar.f35713d);
        }

        public final String f() {
            return this.f35711b;
        }

        public final String g() {
            return this.f35712c;
        }

        public final String h() {
            return this.f35710a;
        }

        public int hashCode() {
            String str = this.f35710a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f35711b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f35712c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f35713d;
            if (str4 != null) {
                i11 = str4.hashCode();
            }
            return hashCode3 + i11;
        }

        public String toString() {
            return "NFCDisabledEvent(title=" + this.f35710a + ", message=" + this.f35711b + ", okButton=" + this.f35712c + ", cancelButton=" + this.f35713d + ')';
        }

        public final k a(String str, String str2, String str3, String str4) {
            return new k(str, str2, str3, str4);
        }

        public static /* synthetic */ k a(k kVar, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = kVar.f35710a;
            }
            if ((i11 & 2) != 0) {
                str2 = kVar.f35711b;
            }
            if ((i11 & 4) != 0) {
                str3 = kVar.f35712c;
            }
            if ((i11 & 8) != 0) {
                str4 = kVar.f35713d;
            }
            return kVar.a(str, str2, str3, str4);
        }
    }

    public static final class l implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35714a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35715b;

        public l() {
            this((CharSequence) null, (CharSequence) null, 3, (kotlin.jvm.internal.r) null);
        }

        public final CharSequence a() {
            return this.f35714a;
        }

        public final CharSequence b() {
            return this.f35715b;
        }

        public final CharSequence c() {
            return this.f35715b;
        }

        public final CharSequence d() {
            return this.f35714a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return kotlin.jvm.internal.x.b(this.f35714a, lVar.f35714a) && kotlin.jvm.internal.x.b(this.f35715b, lVar.f35715b);
        }

        public int hashCode() {
            CharSequence charSequence = this.f35714a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35715b;
            if (charSequence2 != null) {
                i11 = charSequence2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "PinExplainEvent(text=" + this.f35714a + ", buttonText=" + this.f35715b + ')';
        }

        public l(CharSequence charSequence, CharSequence charSequence2) {
            this.f35714a = charSequence;
            this.f35715b = charSequence2;
        }

        public final l a(CharSequence charSequence, CharSequence charSequence2) {
            return new l(charSequence, charSequence2);
        }

        public static /* synthetic */ l a(l lVar, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = lVar.f35714a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = lVar.f35715b;
            }
            return lVar.a(charSequence, charSequence2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ l(CharSequence charSequence, CharSequence charSequence2, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2);
        }
    }

    public static final class m extends AbstractSavedStateViewModelFactory {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.a f35716a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f35717b;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ m(androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, kotlin.jvm.internal.r rVar) {
            this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
        }

        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Bundle bundle = this.f35717b;
            String str2 = null;
            String string = bundle != null ? bundle.getString(a.J, (String) null) : null;
            Bundle bundle2 = this.f35717b;
            String string2 = bundle2 != null ? bundle2.getString(a.K, (String) null) : null;
            Bundle bundle3 = this.f35717b;
            if (bundle3 != null) {
                str2 = bundle3.getString(a.L, (String) null);
            }
            return new a(string, string2, str2, savedStateHandle, this.f35716a.n(), this.f35716a.p());
        }

        public m(androidx.savedstate.c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
            super(cVar, bundle);
            this.f35716a = aVar;
            this.f35717b = bundle;
        }
    }

    public static abstract class n implements Parcelable {

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$a  reason: collision with other inner class name */
        public static final class C0452a extends n {
            public static final Parcelable.Creator<C0452a> CREATOR = new C0453a();

            /* renamed from: a  reason: collision with root package name */
            public final i f35718a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f35719b;

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$a$a  reason: collision with other inner class name */
            public static final class C0453a implements Parcelable.Creator<C0452a> {
                /* renamed from: a */
                public final C0452a createFromParcel(Parcel parcel) {
                    return new C0452a((i) parcel.readParcelable(C0452a.class.getClassLoader()), parcel.readInt() != 0);
                }

                /* renamed from: a */
                public final C0452a[] newArray(int i11) {
                    return new C0452a[i11];
                }
            }

            public C0452a(i iVar, boolean z11) {
                super((kotlin.jvm.internal.r) null);
                this.f35718a = iVar;
                this.f35719b = z11;
            }

            public final i a() {
                return this.f35718a;
            }

            public final boolean b() {
                return this.f35719b;
            }

            public final i c() {
                return this.f35718a;
            }

            public final boolean d() {
                return this.f35719b;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0452a)) {
                    return false;
                }
                C0452a aVar = (C0452a) obj;
                return kotlin.jvm.internal.x.b(this.f35718a, aVar.f35718a) && this.f35719b == aVar.f35719b;
            }

            public int hashCode() {
                int hashCode = this.f35718a.hashCode() * 31;
                boolean z11 = this.f35719b;
                if (z11) {
                    z11 = true;
                }
                return hashCode + (z11 ? 1 : 0);
            }

            public String toString() {
                return "CanPrompt(action=" + this.f35718a + ", wrongCan=" + this.f35719b + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeParcelable(this.f35718a, i11);
                parcel.writeInt(this.f35719b ? 1 : 0);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0452a(i iVar, boolean z11, int i11, kotlin.jvm.internal.r rVar) {
                this(iVar, (i11 & 2) != 0 ? false : z11);
            }

            public final C0452a a(i iVar, boolean z11) {
                return new C0452a(iVar, z11);
            }

            public static /* synthetic */ C0452a a(C0452a aVar, i iVar, boolean z11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    iVar = aVar.f35718a;
                }
                if ((i11 & 2) != 0) {
                    z11 = aVar.f35719b;
                }
                return aVar.a(iVar, z11);
            }
        }

        public static final class b extends n {
            public static final Parcelable.Creator<b> CREATOR = new C0454a();

            /* renamed from: a  reason: collision with root package name */
            public static final b f35720a = new b();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$b$a  reason: collision with other inner class name */
            public static final class C0454a implements Parcelable.Creator<b> {
                /* renamed from: a */
                public final b createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return b.f35720a;
                }

                /* renamed from: a */
                public final b[] newArray(int i11) {
                    return new b[i11];
                }
            }

            public b() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class c extends n {
            public static final Parcelable.Creator<c> CREATOR = new C0455a();

            /* renamed from: a  reason: collision with root package name */
            public static final c f35721a = new c();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$c$a  reason: collision with other inner class name */
            public static final class C0455a implements Parcelable.Creator<c> {
                /* renamed from: a */
                public final c createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return c.f35721a;
                }

                /* renamed from: a */
                public final c[] newArray(int i11) {
                    return new c[i11];
                }
            }

            public c() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class d extends n {
            public static final Parcelable.Creator<d> CREATOR = new C0456a();

            /* renamed from: a  reason: collision with root package name */
            public static final d f35722a = new d();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$d$a  reason: collision with other inner class name */
            public static final class C0456a implements Parcelable.Creator<d> {
                /* renamed from: a */
                public final d createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return d.f35722a;
                }

                /* renamed from: a */
                public final d[] newArray(int i11) {
                    return new d[i11];
                }
            }

            public d() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class e extends n {
            public static final Parcelable.Creator<e> CREATOR = new C0457a();

            /* renamed from: a  reason: collision with root package name */
            public static final e f35723a = new e();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$e$a  reason: collision with other inner class name */
            public static final class C0457a implements Parcelable.Creator<e> {
                /* renamed from: a */
                public final e createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return e.f35723a;
                }

                /* renamed from: a */
                public final e[] newArray(int i11) {
                    return new e[i11];
                }
            }

            public e() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class f extends n {
            public static final Parcelable.Creator<f> CREATOR = new C0458a();

            /* renamed from: a  reason: collision with root package name */
            public static final f f35724a = new f();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$f$a  reason: collision with other inner class name */
            public static final class C0458a implements Parcelable.Creator<f> {
                /* renamed from: a */
                public final f createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return f.f35724a;
                }

                /* renamed from: a */
                public final f[] newArray(int i11) {
                    return new f[i11];
                }
            }

            public f() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class g extends n {
            public static final Parcelable.Creator<g> CREATOR = new C0459a();

            /* renamed from: a  reason: collision with root package name */
            public static final g f35725a = new g();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$g$a  reason: collision with other inner class name */
            public static final class C0459a implements Parcelable.Creator<g> {
                /* renamed from: a */
                public final g createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return g.f35725a;
                }

                /* renamed from: a */
                public final g[] newArray(int i11) {
                    return new g[i11];
                }
            }

            public g() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public static final class h extends n {
            public static final Parcelable.Creator<h> CREATOR = new C0460a();

            /* renamed from: a  reason: collision with root package name */
            public static final h f35726a = new h();

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$n$h$a  reason: collision with other inner class name */
            public static final class C0460a implements Parcelable.Creator<h> {
                /* renamed from: a */
                public final h createFromParcel(Parcel parcel) {
                    parcel.readInt();
                    return h.f35726a;
                }

                /* renamed from: a */
                public final h[] newArray(int i11) {
                    return new h[i11];
                }
            }

            public h() {
                super((kotlin.jvm.internal.r) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(1);
            }
        }

        public /* synthetic */ n(kotlin.jvm.internal.r rVar) {
            this();
        }

        public n() {
        }
    }

    public static final class o implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35727a;

        public o(String str) {
            this.f35727a = str;
        }

        public final String a() {
            return this.f35727a;
        }

        public final String b() {
            return this.f35727a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && kotlin.jvm.internal.x.b(this.f35727a, ((o) obj).f35727a);
        }

        public int hashCode() {
            return this.f35727a.hashCode();
        }

        public String toString() {
            return "SuccessEvent(resultToken=" + this.f35727a + ')';
        }

        public final o a(String str) {
            return new o(str);
        }

        public static /* synthetic */ o a(o oVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = oVar.f35727a;
            }
            return oVar.a(str);
        }
    }

    public /* synthetic */ class p {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35728a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35729b;

        static {
            int[] iArr = new int[CheckFailedReason.values().length];
            iArr[CheckFailedReason.ONE_PIN_TRY_LEFT_CAN_PIN_REQUIRED.ordinal()] = 1;
            iArr[CheckFailedReason.NO_EID_CARD.ordinal()] = 2;
            f35728a = iArr;
            int[] iArr2 = new int[SecretWrong.values().length];
            iArr2[SecretWrong.PIN_WRONG_TWO_PIN_TRIES_LEFT_PIN_REQUIRED.ordinal()] = 1;
            iArr2[SecretWrong.PIN_WRONG_ONE_PIN_TRY_LEFT_CAN_PIN_REQUIRED.ordinal()] = 2;
            iArr2[SecretWrong.CAN_WRONG_CAN_PIN_REQUIRED.ordinal()] = 3;
            f35729b = iArr2;
        }
    }

    public static final class q implements StartCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35730a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$q$a  reason: collision with other inner class name */
        public /* synthetic */ class C0461a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f35731a;

            static {
                int[] iArr = new int[StartTerminationReason.values().length];
                iArr[StartTerminationReason.GENERAL_HTTP_ERROR.ordinal()] = 1;
                iArr[StartTerminationReason.INVALID_MOBILE_TOKEN.ordinal()] = 2;
                iArr[StartTerminationReason.CERTIFICATE_PINNING_FAILED.ordinal()] = 3;
                iArr[StartTerminationReason.EID_AUTHENTICATE_ERROR.ordinal()] = 4;
                iArr[StartTerminationReason.INVALID_PROCESS_REQUIREMENTS.ordinal()] = 5;
                iArr[StartTerminationReason.NEW_MOBILE_TOKEN_NEEDED.ordinal()] = 6;
                iArr[StartTerminationReason.NFC_NOT_ACTIVE.ordinal()] = 7;
                iArr[StartTerminationReason.INCOMPATIBLE_CLIENT_VERSION.ordinal()] = 8;
                f35731a = iArr;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$authStartCallback$1$onSuccess$1", f = "SNSEidMainViewModel.kt", l = {162}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35732a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f35733b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ HashMap<String, String> f35734c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String[] f35735d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar, HashMap<String, String> hashMap, String[] strArr, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f35733b = aVar;
                this.f35734c = hashMap;
                this.f35735d = strArr;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f35733b, this.f35734c, this.f35735d, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35732a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    a aVar = this.f35733b;
                    HashMap<String, String> hashMap = this.f35734c;
                    String[] strArr = this.f35735d;
                    this.f35732a = 1;
                    if (aVar.a(hashMap, strArr, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.f35733b.c((n) n.b.f35720a);
                return Unit.f56620a;
            }
        }

        public q(a aVar) {
            this.f35730a = aVar;
        }

        public void onConnectionTimeout() {
            this.f35730a.b(false);
            this.f35730a.a("Auth start connection timeout", (i) i.m.f35706a);
        }

        public void onProcessTerminated(StartTerminationReason startTerminationReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "On start terminated " + startTerminationReason.name(), (Throwable) null, 4, (Object) null);
            this.f35730a.b(false);
            switch (C0461a.f35731a[startTerminationReason.ordinal()]) {
                case 1:
                    a.a(this.f35730a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, startTerminationReason.name(), (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, (String) null, (String) null, (i) null, 30, (Object) null);
                    return;
                case 2:
                    a.a(this.f35730a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Invalid token", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35620n0, (String) null, i.e.f35696a, 10, (Object) null);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    this.f35730a.d(startTerminationReason.name());
                    return;
                case 7:
                    this.f35730a.B();
                    return;
                case 8:
                    a.a(this.f35730a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Incompatible app", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35628r0, (String) null, i.e.f35696a, 10, (Object) null);
                    return;
                default:
                    return;
            }
        }

        public void onSuccess(String str, HashMap<String, String> hashMap, String[] strArr) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "On successful start", (Throwable) null, 4, (Object) null);
            this.f35730a.b(false);
            n1 unused = kotlinx.coroutines.i.d(m0.a(this.f35730a), (CoroutineContext) null, (CoroutineStart) null, new b(this.f35730a, hashMap, strArr, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
        }
    }

    public static final class r implements com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35736a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$r$a  reason: collision with other inner class name */
        public /* synthetic */ class C0462a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f35737a;

            static {
                int[] iArr = new int[PinTerminationReason.values().length];
                iArr[PinTerminationReason.CARD_BLOCKED.ordinal()] = 1;
                iArr[PinTerminationReason.CARD_DEACTIVATED.ordinal()] = 2;
                iArr[PinTerminationReason.CARD_LOST.ordinal()] = 3;
                iArr[PinTerminationReason.GENERAL_HTTP_ERROR.ordinal()] = 4;
                iArr[PinTerminationReason.EID_SESSION_EXPIRED.ordinal()] = 5;
                iArr[PinTerminationReason.EID_AUTHENTICATE_ERROR.ordinal()] = 6;
                iArr[PinTerminationReason.EID_INVALID.ordinal()] = 7;
                iArr[PinTerminationReason.CERTIFICATE_PINNING_FAILED.ordinal()] = 8;
                iArr[PinTerminationReason.DOCUMENT_NOT_ALLOWED.ordinal()] = 9;
                iArr[PinTerminationReason.EXTENDED_LENGTH_UNSUPPORTED.ordinal()] = 10;
                f35737a = iArr;
            }
        }

        public r(a aVar) {
            this.f35736a = aVar;
        }

        public void a(CheckFailedReason checkFailedReason, Pin pin) {
            this.f35736a.a(checkFailedReason, pin);
        }

        public void onAdditionalDataRequired(RequiredData requiredData) {
            a aVar = this.f35736a;
            aVar.d("Additional data required " + requiredData);
        }

        public void onAuthenticationProgress(int i11) {
            this.f35736a.f35651v.setValue(Integer.valueOf(i11));
        }

        public void onConnectionTimeout() {
            this.f35736a.a("Auth connection timeout", (i) i.c.f35694a);
        }

        public /* synthetic */ void onEidCardCheckFailed(CheckFailedReason checkFailedReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.j.a(this, checkFailedReason);
        }

        public void onEidCardFound() {
            this.f35736a.y();
        }

        public void onEidCardLost() {
            this.f35736a.z();
        }

        public void onImagesRequired(DocumentBuilder documentBuilder) {
        }

        public void onProcessTerminated(PinTerminationReason pinTerminationReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "On auth terminated " + pinTerminationReason.name(), (Throwable) null, 4, (Object) null);
            switch (C0462a.f35737a[pinTerminationReason.ordinal()]) {
                case 1:
                    this.f35736a.w();
                    return;
                case 2:
                    this.f35736a.x();
                    return;
                case 3:
                    a.a(this.f35736a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Card lost", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35624p0, (String) null, (i) null, 26, (Object) null);
                    return;
                case 4:
                    a.a(this.f35736a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, pinTerminationReason.name(), (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, (String) null, (String) null, (i) null, 30, (Object) null);
                    return;
                case 5:
                    a.a(this.f35736a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Session expired", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35620n0, (String) null, i.e.f35696a, 10, (Object) null);
                    return;
                case 6:
                case 7:
                case 8:
                case 9:
                    this.f35736a.d(pinTerminationReason.name());
                    return;
                case 10:
                    a.a(this.f35736a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Incompatible device", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35630s0, (String) null, i.e.f35696a, 10, (Object) null);
                    return;
                default:
                    return;
            }
        }

        public void onReturnUrl(URI uri) {
            b.a.a(this, uri);
        }

        public /* synthetic */ void onSecretWrong(SecretWrong secretWrong) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.j.b(this, secretWrong);
        }

        public void onSuccess(String str) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "Success", (Throwable) null, 4, (Object) null);
            n1 unused = this.f35736a.b(str);
        }

        public void a(SecretWrong secretWrong, Pin pin) {
            this.f35736a.a(secretWrong, pin);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel", f = "SNSEidMainViewModel.kt", l = {350}, m = "buildLegalInfo")
    public static final class s extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35738a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35739b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35740c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35741d;

        /* renamed from: e  reason: collision with root package name */
        public Object f35742e;

        /* renamed from: f  reason: collision with root package name */
        public Object f35743f;

        /* renamed from: g  reason: collision with root package name */
        public int f35744g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f35745h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f35746i;

        /* renamed from: j  reason: collision with root package name */
        public int f35747j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(a aVar, kotlin.coroutines.c<? super s> cVar) {
            super(cVar);
            this.f35746i = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35745h = obj;
            this.f35747j |= Integer.MIN_VALUE;
            return this.f35746i.a((HashMap<String, String>) null, (String[]) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    public static final class t extends Lambda implements d10.l<Throwable, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35748a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(a aVar) {
            super(1);
            this.f35748a = aVar;
        }

        public final void a(Throwable th2) {
            if (th2 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.h) {
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "Error starting auth. Restarting. " + th2.getMessage(), (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.h hVar = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.h) th2;
                this.f35748a.a(hVar.e(), hVar.d());
                return;
            }
            a.a(this.f35748a, th2, (String) null, (String) null, (String) null, (i) null, 30, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$finishWithSuccess$1", f = "SNSEidMainViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class u extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35749a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f35750b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35751c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(a aVar, String str, kotlin.coroutines.c<? super u> cVar) {
            super(2, cVar);
            this.f35750b = aVar;
            this.f35751c = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((u) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u(this.f35750b, this.f35751c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35749a == 0) {
                kotlin.k.b(obj);
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "Finish with success", (Throwable) null, 4, (Object) null);
                this.f35750b.f35654y = true;
                this.f35750b.a((a.j) new o(this.f35751c));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$onNetworkError$1", f = "SNSEidMainViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f f35753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f35754c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f35755d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f fVar, i iVar, a aVar, kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
            this.f35753b = fVar;
            this.f35754c = iVar;
            this.f35755d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((v) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new v(this.f35753b, this.f35754c, this.f35755d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35752a == 0) {
                kotlin.k.b(obj);
                o.e eVar = new o.e(this.f35753b, this.f35754c, (o.a) null, 4, (kotlin.jvm.internal.r) null);
                a aVar = this.f35755d;
                aVar.a((com.sumsub.sns.internal.core.data.model.o) eVar, aVar.f());
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$onNfcDisabled$1", f = "SNSEidMainViewModel.kt", l = {795, 796, 797, 798}, m = "invokeSuspend")
    public static final class w extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35756a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35757b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35758c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35759d;

        /* renamed from: e  reason: collision with root package name */
        public int f35760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f35761f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(a aVar, kotlin.coroutines.c<? super w> cVar) {
            super(2, cVar);
            this.f35761f = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((w) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new w(this.f35761f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0095 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f35760e
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0055
                if (r1 == r5) goto L_0x004d
                if (r1 == r4) goto L_0x0041
                if (r1 == r3) goto L_0x0031
                if (r1 != r2) goto L_0x0029
                java.lang.Object r0 = r7.f35759d
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r1 = r7.f35758c
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r2 = r7.f35757b
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r7.f35756a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r3 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) r3
                kotlin.k.b(r8)
                goto L_0x00b5
            L_0x0029:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0031:
                java.lang.Object r1 = r7.f35758c
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r7.f35757b
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r7.f35756a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) r4
                kotlin.k.b(r8)
                goto L_0x009a
            L_0x0041:
                java.lang.Object r1 = r7.f35757b
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r4 = r7.f35756a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r4 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) r4
                kotlin.k.b(r8)
                goto L_0x0081
            L_0x004d:
                java.lang.Object r1 = r7.f35756a
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r1 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) r1
                kotlin.k.b(r8)
                goto L_0x006a
            L_0x0055:
                kotlin.k.b(r8)
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r8 = r7.f35761f
                r7.f35756a = r8
                r7.f35760e = r5
                java.lang.String r1 = "sns_dialog_nfc_title"
                java.lang.Object r1 = r8.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r1 != r0) goto L_0x0067
                return r0
            L_0x0067:
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x006a:
                java.lang.String r8 = (java.lang.String) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r7.f35761f
                r7.f35756a = r1
                r7.f35757b = r8
                r7.f35760e = r4
                java.lang.String r4 = "sns_dialog_nfc_message"
                java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r4 != r0) goto L_0x007d
                return r0
            L_0x007d:
                r6 = r1
                r1 = r8
                r8 = r4
                r4 = r6
            L_0x0081:
                java.lang.String r8 = (java.lang.String) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r7.f35761f
                r7.f35756a = r4
                r7.f35757b = r1
                r7.f35758c = r8
                r7.f35760e = r3
                java.lang.String r3 = "sns_dialog_nfc_action_settings"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r3 != r0) goto L_0x0096
                return r0
            L_0x0096:
                r6 = r1
                r1 = r8
                r8 = r3
                r3 = r6
            L_0x009a:
                java.lang.String r8 = (java.lang.String) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r5 = r7.f35761f
                r7.f35756a = r4
                r7.f35757b = r3
                r7.f35758c = r1
                r7.f35759d = r8
                r7.f35760e = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r2 != r0) goto L_0x00b1
                return r0
            L_0x00b1:
                r0 = r8
                r8 = r2
                r2 = r3
                r3 = r4
            L_0x00b5:
                java.lang.String r8 = (java.lang.String) r8
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$k r4 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$k
                r4.<init>(r2, r1, r0, r8)
                r3.a((com.sumsub.sns.core.presentation.base.a.j) r4)
                kotlin.Unit r8 = kotlin.Unit.f56620a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.w.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class x implements com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35762a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$x$a  reason: collision with other inner class name */
        public /* synthetic */ class C0463a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f35763a;

            static {
                int[] iArr = new int[TerminationReason.values().length];
                iArr[TerminationReason.CARD_BLOCKED.ordinal()] = 1;
                iArr[TerminationReason.CARD_DEACTIVATED.ordinal()] = 2;
                iArr[TerminationReason.NFC_NOT_ACTIVE.ordinal()] = 3;
                iArr[TerminationReason.EXTENDED_LENGTH_UNSUPPORTED.ordinal()] = 4;
                f35763a = iArr;
            }
        }

        public x(a aVar) {
            this.f35762a = aVar;
        }

        public void a(CheckFailedReason checkFailedReason, TPin tPin, Pin pin, Integer num) {
            this.f35762a.a(checkFailedReason, tPin, pin, num);
        }

        public /* synthetic */ void onEidCardCheckFailed(CheckFailedReason checkFailedReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.k.a(this, checkFailedReason);
        }

        public void onEidCardFound() {
            this.f35762a.y();
        }

        public void onEidCardLost() {
            this.f35762a.z();
        }

        public void onProcessTerminated(TerminationReason terminationReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "On pin change terminated " + terminationReason.name(), (Throwable) null, 4, (Object) null);
            int i11 = C0463a.f35763a[terminationReason.ordinal()];
            if (i11 == 1) {
                this.f35762a.w();
            } else if (i11 == 2) {
                this.f35762a.x();
            } else if (i11 == 3) {
                this.f35762a.B();
            } else if (i11 == 4) {
                a.a(this.f35762a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Incompatible device", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35630s0, (String) null, i.e.f35696a, 10, (Object) null);
            }
        }

        public void onSecretWrong(SecretWrong secretWrong) {
            this.f35762a.a(secretWrong, (i) i.m.f35706a);
        }

        public void onSuccess() {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "Pin changed", (Throwable) null, 4, (Object) null);
            this.f35762a.c((n) n.c.f35721a);
        }
    }

    public static final class y implements UnblockerCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35764a;

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$y$a  reason: collision with other inner class name */
        public /* synthetic */ class C0464a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f35765a;

            static {
                int[] iArr = new int[UnblockerTerminationReason.values().length];
                iArr[UnblockerTerminationReason.CARD_DEACTIVATED.ordinal()] = 1;
                iArr[UnblockerTerminationReason.EXTENDED_LENGTH_UNSUPPORTED.ordinal()] = 2;
                iArr[UnblockerTerminationReason.GENERAL_ERROR.ordinal()] = 3;
                iArr[UnblockerTerminationReason.NFC_NOT_ACTIVE.ordinal()] = 4;
                f35765a = iArr;
            }
        }

        public y(a aVar) {
            this.f35764a = aVar;
        }

        public void onEidCardCheckFailed(UnblockerCheckFailedReason unblockerCheckFailedReason) {
            a aVar = this.f35764a;
            a.a(aVar, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Card check failed " + unblockerCheckFailedReason, (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35624p0, (String) null, (i) null, 26, (Object) null);
        }

        public void onEidCardFound() {
            this.f35764a.y();
        }

        public void onEidCardLost() {
            this.f35764a.z();
        }

        public void onEidCardNotBlocked() {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "onEidCardNotBlocked()", (Throwable) null, 4, (Object) null);
            this.f35764a.c((n) n.e.f35723a);
        }

        public void onProcessTerminated(UnblockerTerminationReason unblockerTerminationReason) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "On pin unblock terminated " + unblockerTerminationReason.name(), (Throwable) null, 4, (Object) null);
            int i11 = C0464a.f35765a[unblockerTerminationReason.ordinal()];
            if (i11 == 1) {
                this.f35764a.x();
            } else if (i11 == 2) {
                this.f35764a.d(unblockerTerminationReason.name());
            } else if (i11 == 3) {
                a.a(this.f35764a, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, (String) null, (String) null, 6, (kotlin.jvm.internal.r) null), (String) null, (String) null, (String) null, (i) null, 30, (Object) null);
            } else if (i11 == 4) {
                this.f35764a.B();
            }
        }

        public void onPukWrong() {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(a.M, "On PUK wrong", (Throwable) null, 4, (Object) null);
            this.f35764a.a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Wrong PUK", "eidWrongPuk"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35612j0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35614k0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35616l0, (i) i.j.f35703a);
        }

        public void onSuccess() {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "Pin unblocked", (Throwable) null, 4, (Object) null);
            this.f35764a.c((n) n.f.f35724a);
        }
    }

    public static final class z implements StartCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f35766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f35767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35768c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f35769d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.SNSEidMainViewModel$restartReading$1$onSuccess$1", f = "SNSEidMainViewModel.kt", l = {578}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$z$a  reason: collision with other inner class name */
        public static final class C0465a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35770a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f35771b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ HashMap<String, String> f35772c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String[] f35773d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f35774e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f35775f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0465a(a aVar, HashMap<String, String> hashMap, String[] strArr, String str, String str2, kotlin.coroutines.c<? super C0465a> cVar) {
                super(2, cVar);
                this.f35771b = aVar;
                this.f35772c = hashMap;
                this.f35773d = strArr;
                this.f35774e = str;
                this.f35775f = str2;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0465a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0465a(this.f35771b, this.f35772c, this.f35773d, this.f35774e, this.f35775f, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f35770a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(a.M, "On successful re-start", (Throwable) null, 4, (Object) null);
                    this.f35771b.b(false);
                    a aVar = this.f35771b;
                    HashMap<String, String> hashMap = this.f35772c;
                    String[] strArr = this.f35773d;
                    this.f35770a = 1;
                    if (aVar.a(hashMap, strArr, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.f35771b.b(this.f35774e, this.f35775f);
                return Unit.f56620a;
            }
        }

        public z(a aVar, String str, String str2) {
            this.f35767b = aVar;
            this.f35768c = str;
            this.f35769d = str2;
            this.f35766a = aVar.A;
        }

        public void onConnectionTimeout() {
            this.f35766a.onConnectionTimeout();
        }

        public void onProcessTerminated(StartTerminationReason startTerminationReason) {
            this.f35766a.onProcessTerminated(startTerminationReason);
        }

        public void onSuccess(String str, HashMap<String, String> hashMap, String[] strArr) {
            n1 unused = kotlinx.coroutines.i.d(m0.a(this.f35767b), (CoroutineContext) null, (CoroutineStart) null, new C0465a(this.f35767b, hashMap, strArr, this.f35768c, this.f35769d, (kotlin.coroutines.c<? super C0465a>) null), 3, (Object) null);
        }
    }

    static {
        Class<a> cls = a.class;
        G = new kotlin.reflect.l[]{Reflection.e(new MutablePropertyReference1Impl(cls, "legalInfo", "getLegalInfo()Ljava/lang/CharSequence;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "step", "getStep()Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/SNSEidMainViewModel$Step;", 0))};
    }

    public a(String str, String str2, String str3, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        boolean z11;
        this.f35646q = str;
        this.f35647r = str2;
        this.f35648s = str3;
        this.f35649t = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, I, null);
        n.e eVar = N;
        this.f35650u = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, H, eVar);
        b1<Integer> a11 = k1.a(0);
        this.f35651v = a11;
        b1<String> a12 = k1.a(null);
        this.f35652w = a12;
        j1<n> g11 = savedStateHandle.g(H, eVar);
        this.f35653x = g11;
        n t11 = t();
        boolean z12 = true;
        if (kotlin.jvm.internal.x.b(t11, n.h.f35726a)) {
            z11 = true;
        } else {
            z11 = kotlin.jvm.internal.x.b(t11, n.d.f35722a);
        }
        if (!z11 ? kotlin.jvm.internal.x.b(t11, n.g.f35725a) : z12) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Init state is scanning, aborting scan", (Throwable) null, 4, (Object) null);
            a((com.sumsub.sns.internal.core.common.q) q.c.f32251b);
        }
        this.f35655z = kotlinx.coroutines.flow.f.a0(kotlinx.coroutines.flow.f.k(g11, a11, a12, new e0(this, (kotlin.coroutines.c<? super e0>) null)), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), b.c.f35791b);
        this.A = new q(this);
        this.B = new r(this);
        this.C = new x(this);
        this.D = new y(this);
        this.E = new t(this);
    }

    public static /* synthetic */ void v() {
    }

    public final void A() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On NFC disabled", (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new w(this, (kotlin.coroutines.c<? super w>) null), 3, (Object) null);
    }

    public final void B() {
        a(this, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "NFC not active", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35622o0, (String) null, (i) null, 26, (Object) null);
    }

    public final n1 C() {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new b0(this, (kotlin.coroutines.c<? super b0>) null), 3, (Object) null);
    }

    public final n1 D() {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new c0(this, (kotlin.coroutines.c<? super c0>) null), 3, (Object) null);
    }

    public final void E() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Reset", (Throwable) null, 4, (Object) null);
        c((n) N);
    }

    public String f() {
        return DocumentType.f32357l;
    }

    public void onCleared() {
        super.onCleared();
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "ViewModel cleared", (Throwable) null, 4, (Object) null);
    }

    public final void p() {
        c(false);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Cancel pin change", (Throwable) null, 4, (Object) null);
        a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) a.C0435a.f35560a);
        c((n) n.e.f35723a);
    }

    public final void q() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Cancel pin unlocking", (Throwable) null, 4, (Object) null);
        a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) a.b.f35561a);
        c((n) n.b.f35720a);
    }

    public final void r() {
        c(false);
        this.f35651v.setValue(0);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Cancel reading", (Throwable) null, 4, (Object) null);
        c((n) n.b.f35720a);
        a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) a.c.f35562a);
    }

    public final CharSequence s() {
        return (CharSequence) this.f35649t.a(this, G[0]);
    }

    public final n t() {
        return (n) this.f35650u.a(this, G[1]);
    }

    /* renamed from: u */
    public j1<b> j() {
        return this.f35655z;
    }

    public final void w() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, "On card blocked", (Throwable) null, 4, (Object) null);
        if (com.sumsub.sns.internal.ff.a.f34215a.k().g()) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Card blocked", "eidCardLocked"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.T, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.U, "sns_alert_action_dismiss", (i) i.e.f35696a);
            return;
        }
        a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Card blocked", "eidCardLocked"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.T, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.U, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.V, (i) i.j.f35703a);
    }

    public final void x() {
        a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Card deactivated", "eidCardDeactivated"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.W, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.X, "sns_alert_action_ok", (i) i.e.f35696a);
    }

    public final void y() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On card found", (Throwable) null, 4, (Object) null);
        c(true);
    }

    public final void z() {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On card lost", (Throwable) null, 4, (Object) null);
        c(false);
    }

    public final void c(n nVar) {
        this.f35650u.a(this, G[1], nVar);
    }

    public final void d(String str) {
        a(this, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, str, (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, (String) null, (String) null, i.e.f35696a, 14, (Object) null);
    }

    public final n1 b(String str) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new u(this, str, (kotlin.coroutines.c<? super u>) null), 3, (Object) null);
    }

    public final void c(boolean z11) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Set scanning state: " + z11, (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new a0(z11, this, (kotlin.coroutines.c<? super a0>) null), 3, (Object) null);
    }

    public final void b(String str, String str2) {
        Can can = null;
        if (str == null) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Start reading, card pin is null. Aborting.", (Throwable) null, 4, (Object) null);
            return;
        }
        this.f35651v.setValue(0);
        c(false);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Start reading, canIsNull=");
        sb2.append(str2 == null || StringsKt__StringsJVMKt.z(str2));
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, sb2.toString(), (Throwable) null, 4, (Object) null);
        c((n) n.h.f35726a);
        try {
            ArrayList arrayList = new ArrayList(str.length());
            for (int i11 = 0; i11 < str.length(); i11++) {
                arrayList.add(Integer.valueOf(CharsKt__CharKt.d(str.charAt(i11))));
            }
            Pin pin = new Pin(CollectionsKt___CollectionsKt.H0(arrayList));
            if (str2 != null) {
                ArrayList arrayList2 = new ArrayList(str2.length());
                for (int i12 = 0; i12 < str2.length(); i12++) {
                    arrayList2.add(Integer.valueOf(CharsKt__CharKt.d(str2.charAt(i12))));
                }
                can = new Can(CollectionsKt___CollectionsKt.H0(arrayList2));
            }
            a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) new a.d(pin, can, this.B, this.E));
        } catch (Exception e11) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) e11, f(), (Object) null, 4, (Object) null);
        }
    }

    public final void c(String str) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On puk entered", (Throwable) null, 4, (Object) null);
        if (str == null || StringsKt__StringsJVMKt.z(str)) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "PUK is null or blank", (Throwable) null, 4, (Object) null);
            return;
        }
        this.f35651v.setValue(0);
        c((n) n.g.f35725a);
        try {
            ArrayList arrayList = new ArrayList(str.length());
            for (int i11 = 0; i11 < str.length(); i11++) {
                arrayList.add(Integer.valueOf(CharsKt__CharKt.d(str.charAt(i11))));
            }
            a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) new a.f(new Puk(CollectionsKt___CollectionsKt.H0(arrayList)), this.D, this.E));
        } catch (Exception e11) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) e11, f(), (Object) null, 4, (Object) null);
        }
    }

    public final void a(CharSequence charSequence) {
        this.f35649t.a(this, G[0], charSequence);
    }

    /* JADX WARNING: type inference failed for: r13v4, types: [java.lang.Appendable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8 A[LOOP:1: B:21:0x00d6->B:22:0x00d8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.HashMap<java.lang.String, java.lang.String> r12, java.lang.String[] r13, kotlin.coroutines.c<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.s
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$s r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.s) r0
            int r1 = r0.f35747j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35747j = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$s r0 = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a$s
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f35745h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35747j
            r3 = 17
            r4 = 10
            r5 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 != r5) goto L_0x0050
            int r12 = r0.f35744g
            java.lang.Object r13 = r0.f35743f
            java.lang.Appendable r13 = (java.lang.Appendable) r13
            java.lang.Object r1 = r0.f35742e
            android.text.style.StyleSpan r1 = (android.text.style.StyleSpan) r1
            java.lang.Object r2 = r0.f35741d
            android.text.SpannableStringBuilder r2 = (android.text.SpannableStringBuilder) r2
            java.lang.Object r5 = r0.f35740c
            android.text.SpannableStringBuilder r5 = (android.text.SpannableStringBuilder) r5
            java.lang.Object r6 = r0.f35739b
            java.lang.String[] r6 = (java.lang.String[]) r6
            java.lang.Object r0 = r0.f35738a
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a r0 = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) r0
            kotlin.k.b(r14)
            r10 = r14
            r14 = r13
            r13 = r6
            r6 = r5
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r10
            goto L_0x00c4
        L_0x0050:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0058:
            kotlin.k.b(r14)
            android.text.SpannableStringBuilder r14 = new android.text.SpannableStringBuilder
            r14.<init>()
            java.util.Set r2 = r12.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0068:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r12.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            android.text.style.StyleSpan r8 = new android.text.style.StyleSpan
            r8.<init>(r5)
            int r9 = r14.length()
            java.lang.Appendable r6 = r14.append(r6)
            r6.append(r4)
            int r6 = r14.length()
            r14.setSpan(r8, r9, r6, r3)
            java.lang.Appendable r6 = r14.append(r7)
            r6.append(r4)
            r14.append(r4)
            goto L_0x0068
        L_0x009c:
            android.text.style.StyleSpan r12 = new android.text.style.StyleSpan
            r12.<init>(r5)
            int r2 = r14.length()
            r0.f35738a = r11
            r0.f35739b = r13
            r0.f35740c = r14
            r0.f35741d = r14
            r0.f35742e = r12
            r0.f35743f = r14
            r0.f35744g = r2
            r0.f35747j = r5
            java.lang.String r5 = "sns_eid_serviceInfo_fieldsHeader"
            java.lang.Object r0 = r11.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x00be
            return r1
        L_0x00be:
            r1 = r11
            r5 = r14
            r6 = r5
            r10 = r2
            r2 = r12
            r12 = r10
        L_0x00c4:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.Appendable r14 = r14.append(r0)
            r14.append(r4)
            int r14 = r5.length()
            r5.setSpan(r2, r12, r14, r3)
            r12 = 0
            int r14 = r13.length
        L_0x00d6:
            if (r12 >= r14) goto L_0x00f5
            r0 = r13[r12]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "– "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Appendable r0 = r6.append(r0)
            r0.append(r4)
            int r12 = r12 + 1
            goto L_0x00d6
        L_0x00f5:
            r1.a((java.lang.CharSequence) r6)
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.a(java.util.HashMap, java.lang.String[], kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Screen b(a aVar, n nVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            nVar = aVar.t();
        }
        return aVar.b(nVar);
    }

    public final Screen b(n nVar) {
        if (kotlin.jvm.internal.x.b(nVar, n.e.f35723a)) {
            return Screen.EidPinSelection;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.b.f35720a)) {
            return Screen.EidIdentInfo;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.d.f35722a)) {
            return Screen.EidNfcScan;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.c.f35721a)) {
            return Screen.EidPinChangeSuccess;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.h.f35726a)) {
            return Screen.EidNfcScan;
        }
        if (nVar instanceof n.C0452a) {
            return Screen.EidCanRequired;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.g.f35725a)) {
            return Screen.EidNfcScan;
        }
        if (kotlin.jvm.internal.x.b(nVar, n.f.f35724a)) {
            return Screen.EidUnlockSuccess;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (oVar.c() instanceof i) {
            a((i) oVar.c());
        } else {
            super.b(oVar);
        }
    }

    public final void a(String str, i iVar) {
        this.f35651v.setValue(0);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f fVar = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, str, (String) null, 4, (kotlin.jvm.internal.r) null);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, "Network error " + fVar, (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new v(fVar, iVar, this, (kotlin.coroutines.c<? super v>) null), 3, (Object) null);
    }

    public final void a(CheckFailedReason checkFailedReason, TPin tPin, Pin pin, Integer num) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Pin change card check failed ");
        CheckFailedReason checkFailedReason2 = checkFailedReason;
        sb2.append(checkFailedReason);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, sb2.toString(), (Throwable) null, 4, (Object) null);
        int i11 = p.f35728a[checkFailedReason.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                a(this, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Incompatible card", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35626q0, (String) null, i.e.f35696a, 10, (Object) null);
            }
            return;
        }
        c((n) new n.C0452a(new i.h(ArraysKt___ArraysKt.g0(tPin.getTpin(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d10.l) null, 62, (Object) null), ArraysKt___ArraysKt.g0(pin.getPin(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d10.l) null, 62, (Object) null), num != null ? num.toString() : null), false, 2, (kotlin.jvm.internal.r) null));
    }

    public final void a(CheckFailedReason checkFailedReason, Pin pin) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, "Auth card check failed " + checkFailedReason, (Throwable) null, 4, (Object) null);
        int i11 = p.f35728a[checkFailedReason.ordinal()];
        if (i11 == 1) {
            c((n) new n.C0452a(new i.g(ArraysKt___ArraysKt.g0(pin.getPin(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d10.l) null, 62, (Object) null)), false, 2, (kotlin.jvm.internal.r) null));
        } else if (i11 == 2) {
            a(this, new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(true, "Incompatible card", (String) null, 4, (kotlin.jvm.internal.r) null), (String) null, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35626q0, (String) null, i.e.f35696a, 10, (Object) null);
        }
    }

    public final void a(SecretWrong secretWrong, Pin pin) {
        SecretWrong secretWrong2 = secretWrong;
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, "On secret wrong " + secretWrong2, (Throwable) null, 4, (Object) null);
        this.f35651v.setValue(0);
        int i11 = p.f35729b[secretWrong.ordinal()];
        if (i11 == 1) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Secret wrong", "eidWrongPinFirstAttempt"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35604f0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35606g0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35610i0, (i) new i.C0446i(secretWrong2));
        } else if (i11 == 2) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Secret wrong", "eidWrongPinLastAttempt"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35604f0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35608h0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35610i0, (i) new i.C0446i(secretWrong2));
        } else if (i11 == 3) {
            c((n) new n.C0452a(new i.g(ArraysKt___ArraysKt.g0(pin.getPin(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d10.l) null, 62, (Object) null)), true));
        }
    }

    public final void a(SecretWrong secretWrong, i iVar) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, "On transport secret wrong " + secretWrong, (Throwable) null, 4, (Object) null);
        this.f35651v.setValue(0);
        int i11 = p.f35729b[secretWrong.ordinal()];
        if (i11 == 1) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Secret wrong", "eidWrongTransportPinFirstAttempt"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.Y, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.Z, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35596b0, iVar);
        } else if (i11 == 2) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Secret wrong", "eidWrongTransportPinLastAttempt"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.Y, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35594a0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35596b0, iVar);
        } else if (i11 == 3) {
            a((Throwable) new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f(false, "Secret wrong", "eidWrongCan"), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35598c0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35600d0, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35602e0, iVar);
        }
    }

    public final void a(String str, String str2) {
        this.f35651v.setValue(0);
        a((StartCallback) new z(this, str, str2));
    }

    public static /* synthetic */ void a(a aVar, q qVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            qVar = aVar.A;
        }
        aVar.a((StartCallback) qVar);
    }

    public final void a(StartCallback startCallback) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Start", (Throwable) null, 4, (Object) null);
        b(true);
        String str = this.f35646q;
        if (str == null) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new IllegalStateException("No mobile token"), f(), (Object) null, 4, (Object) null);
        } else if (this.f35648s == null) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new IllegalStateException("No hash"), f(), (Object) null, 4, (Object) null);
        } else if (this.f35647r == null) {
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) new IllegalStateException("No url"), f(), (Object) null, 4, (Object) null);
        } else {
            a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) new a.g(str, new URL(this.f35647r), this.f35648s, startCallback, this.E));
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        Can can;
        Integer num = null;
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On pin change ready", (Throwable) null, 4, (Object) null);
        boolean z11 = true;
        if (!(str == null || StringsKt__StringsJVMKt.z(str))) {
            if (str2 != null && !StringsKt__StringsJVMKt.z(str2)) {
                z11 = false;
            }
            if (!z11) {
                c(false);
                this.f35651v.setValue(0);
                c((n) n.d.f35722a);
                try {
                    ArrayList arrayList = new ArrayList(str.length());
                    for (int i11 = 0; i11 < str.length(); i11++) {
                        arrayList.add(Integer.valueOf(CharsKt__CharKt.d(str.charAt(i11))));
                    }
                    TPin tPin = new TPin(CollectionsKt___CollectionsKt.H0(arrayList));
                    ArrayList arrayList2 = new ArrayList(str2.length());
                    for (int i12 = 0; i12 < str2.length(); i12++) {
                        arrayList2.add(Integer.valueOf(CharsKt__CharKt.d(str2.charAt(i12))));
                    }
                    Pin pin = new Pin(CollectionsKt___CollectionsKt.H0(arrayList2));
                    if (str3 != null) {
                        ArrayList arrayList3 = new ArrayList(str3.length());
                        for (int i13 = 0; i13 < str3.length(); i13++) {
                            arrayList3.add(Integer.valueOf(CharsKt__CharKt.d(str3.charAt(i13))));
                        }
                        can = new Can(CollectionsKt___CollectionsKt.H0(arrayList3));
                    } else {
                        can = null;
                    }
                    if (str4 != null) {
                        num = StringsKt__StringNumberConversionsKt.m(str4);
                    }
                    a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a) new a.e(tPin, pin, can, num, this.C, this.E));
                } catch (Exception e11) {
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (Throwable) e11, f(), (Object) null, 4, (Object) null);
                }
            }
        }
    }

    public final void a(String str, boolean z11) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On pin entered, need can: " + z11, (Throwable) null, 4, (Object) null);
        if (str != null) {
            if (z11) {
                c((n) new n.C0452a(new i.g(str), false, 2, (kotlin.jvm.internal.r) null));
            } else {
                b(str, (String) null);
            }
        }
    }

    public final void a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a aVar) {
        a((a.j) new b(aVar));
    }

    public final void a(SecretWrong secretWrong) {
        boolean z11 = secretWrong == SecretWrong.CAN_WRONG_CAN_PIN_REQUIRED || secretWrong == SecretWrong.PIN_WRONG_ONE_PIN_TRY_LEFT_CAN_PIN_REQUIRED;
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Request pin enter, triesLeft=" + secretWrong + ", needCan=" + z11, (Throwable) null, 4, (Object) null);
        a((a.j) new g(z11));
    }

    public final void a(i iVar) {
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "On action " + iVar, (Throwable) null, 4, (Object) null);
        if (iVar != null) {
            if (iVar instanceof i.l) {
                D();
            } else if (iVar instanceof i.k) {
                C();
            } else if (iVar instanceof i.m) {
                E();
            } else if (iVar instanceof i.f) {
                a(this, (StartCallback) null, 1, (Object) null);
            } else if (iVar instanceof i.d) {
                a((a.j) c.f35667a);
            } else if (iVar instanceof i.C0437a) {
                p();
            } else if (iVar instanceof i.c) {
                r();
            } else if (iVar instanceof i.j) {
                a((a.j) h.f35691a);
            } else if (iVar instanceof i.b) {
                q();
            } else if (iVar instanceof i.C0446i) {
                a(((i.C0446i) iVar).b());
            } else if (iVar instanceof i.g) {
                a((a.j) new e(((i.g) iVar).b()));
            } else if (iVar instanceof i.h) {
                i.h hVar = (i.h) iVar;
                a((a.j) new f(hVar.f(), hVar.e(), hVar.d()));
            } else if (iVar instanceof i.e) {
                this.f35654y = true;
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (com.sumsub.sns.internal.core.common.q) null, (Object) null, (Long) null, 7, (Object) null);
            }
        }
    }

    public final boolean a(com.sumsub.sns.internal.core.common.q qVar) {
        boolean z11;
        boolean z12;
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(M, "Try finish, reason=" + qVar, (Throwable) null, 4, (Object) null);
        boolean z13 = true;
        if (!(qVar instanceof q.c) || this.f35654y) {
            return true;
        }
        n t11 = t();
        if (kotlin.jvm.internal.x.b(t11, n.e.f35723a)) {
            return true;
        }
        if (kotlin.jvm.internal.x.b(t11, n.b.f35720a)) {
            z11 = true;
        } else {
            z11 = t11 instanceof n.C0452a;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = kotlin.jvm.internal.x.b(t11, n.c.f35721a);
        }
        if (!z12) {
            z13 = kotlin.jvm.internal.x.b(t11, n.f.f35724a);
        }
        if (z13) {
            c((n) N);
        } else if (kotlin.jvm.internal.x.b(t11, n.h.f35726a)) {
            r();
        } else if (kotlin.jvm.internal.x.b(t11, n.d.f35722a)) {
            p();
        } else if (kotlin.jvm.internal.x.b(t11, n.g.f35725a)) {
            q();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    public static /* synthetic */ Map a(a aVar, n nVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            nVar = aVar.t();
        }
        return aVar.a(nVar);
    }

    public final Map<String, Object> a(n nVar) {
        if (nVar instanceof n.C0452a) {
            return MapsKt__MapsJVMKt.e(kotlin.l.a(Constants.REASON, "eidCanRequired"));
        }
        return MapsKt__MapsKt.h();
    }

    public static /* synthetic */ void a(a aVar, Throwable th2, String str, String str2, String str3, i iVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e.f35618m0;
        }
        String str4 = str;
        String str5 = (i11 & 4) != 0 ? null : str2;
        String str6 = (i11 & 8) != 0 ? null : str3;
        if ((i11 & 16) != 0) {
            iVar = i.m.f35706a;
        }
        aVar.a(th2, str4, str5, str6, iVar);
    }

    public final void a(Throwable th2, String str, String str2, String str3, i iVar) {
        this.f35651v.setValue(0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error ");
        Throwable th3 = th2;
        sb2.append(th3);
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.a(M, sb2.toString(), (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new d0(this, str, str2, str3, th3, iVar, (kotlin.coroutines.c<? super d0>) null), 3, (Object) null);
    }

    public void a(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (!(oVar.b() instanceof com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f)) {
            super.a(oVar);
        } else if (((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.f) oVar.b()).a()) {
            a((i) i.e.f35696a);
        } else {
            E();
        }
    }
}
