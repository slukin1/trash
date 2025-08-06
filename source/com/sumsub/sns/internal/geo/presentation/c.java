package com.sumsub.sns.internal.geo.presentation;

import android.content.Context;
import android.location.Location;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Action;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.geo.presentation.e;
import d10.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

public final class c extends com.sumsub.sns.core.presentation.base.a<e> implements com.sumsub.sns.internal.core.presentation.form.b {
    public static final String A = "sns_geolocation_form_subtitle";
    public static final String B = "sns_data_field_%s";
    public static final String C = "sns_geolocation_preview_subtitle";
    public static final String D = "sns_data_field_%s_placeholder";
    public static final String E = "sns_data_error_fieldIsRequired";
    public static final String F = "sns_geolocation_detection_invalidLocation";
    public static final String G = "attempt";
    public static final String H = "isAuthorized";
    public static final String I = "accuracy";
    public static final String J = "is_mock_geo";
    public static final int K = 9001;
    public static final String L = "ARGS_DOCUMENT";

    /* renamed from: q  reason: collision with root package name */
    public static final b f34727q = new b((r) null);

    /* renamed from: r  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f34728r = {Reflection.e(new MutablePropertyReference1Impl(c.class, "addressDataCache", "getAddressDataCache()Ljava/util/List;", 0))};

    /* renamed from: s  reason: collision with root package name */
    public static final String f34729s = "sns_step_%s_title";

    /* renamed from: t  reason: collision with root package name */
    public static final String f34730t = "sns_geolocation_detection_description";

    /* renamed from: u  reason: collision with root package name */
    public static final String f34731u = "sns_geolocation_detection_blocked";

    /* renamed from: v  reason: collision with root package name */
    public static final String f34732v = "sns_geolocation_detection_cameraFallback";

    /* renamed from: w  reason: collision with root package name */
    public static final String f34733w = "sns_geolocation_action_allowAccess";

    /* renamed from: x  reason: collision with root package name */
    public static final String f34734x = "sns_geolocation_action_tryAgain";

    /* renamed from: y  reason: collision with root package name */
    public static final String f34735y = "sns_geolocation_action_uploadDocument";

    /* renamed from: z  reason: collision with root package name */
    public static final String f34736z = "sns_geolocation_action_continue";
    public final com.sumsub.sns.internal.core.data.source.dynamic.b M;
    public final com.sumsub.sns.internal.geo.domain.b N;
    public final com.sumsub.sns.internal.geo.domain.c O;
    public final boolean P;
    public final com.sumsub.sns.internal.core.domain.d Q;
    public final Document R;
    public final com.sumsub.sns.internal.core.presentation.form.d S = new f(this);
    public final String[] T = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public final com.sumsub.sns.internal.core.presentation.screen.base.a U;
    public int V;
    public final b1<b.a> W;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$1", f = "SNSGeoViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<e, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34737a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34738b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f34739c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
            super(2, cVar2);
            this.f34739c = cVar;
        }

        /* renamed from: a */
        public final Object invoke(e eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f34739c, cVar);
            aVar.f34738b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f34737a == 0) {
                kotlin.k.b(obj);
                e eVar = (e) this.f34738b;
                if (eVar instanceof e.d) {
                    b1 g11 = this.f34739c.W;
                    CharSequence d11 = eVar.d();
                    String obj2 = d11 != null ? d11.toString() : null;
                    CharSequence c11 = eVar.c();
                    g11.setValue(new b.a(0, CollectionsKt__CollectionsJVMKt.e(new b.C0375b(0, obj2, c11 != null ? c11.toString() : null, ((e.d) eVar).g())), (String) null, new b.c((String) null, (String) null, 3, (r) null)));
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel", f = "SNSGeoViewModel.kt", l = {78, 79, 80, 82, 83}, m = "enableLocationAccessState")
    /* renamed from: com.sumsub.sns.internal.geo.presentation.c$c  reason: collision with other inner class name */
    public static final class C0397c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34740a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34741b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34742c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34743d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34744e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f34745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f34746g;

        /* renamed from: h  reason: collision with root package name */
        public int f34747h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0397c(c cVar, kotlin.coroutines.c<? super C0397c> cVar2) {
            super(cVar2);
            this.f34746g = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34745f = obj;
            this.f34747h |= Integer.MIN_VALUE;
            return this.f34746g.e((kotlin.coroutines.c<? super e.b>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$handlePermissionResults$1", f = "SNSGeoViewModel.kt", l = {171}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34748a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f34749b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, kotlin.coroutines.c<? super d> cVar2) {
            super(2, cVar2);
            this.f34749b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
            return ((d) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f34749b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34748a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                c cVar = this.f34749b;
                this.f34748a = 1;
                obj = cVar.f((kotlin.coroutines.c<? super e.f>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$handlePermissionResults$2", f = "SNSGeoViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34750a;

        public e(kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
            return ((e) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f34750a == 0) {
                kotlin.k.b(obj);
                return e.C0400e.f34858e;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class f implements com.sumsub.sns.internal.core.presentation.form.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f34751a;

        public f(c cVar) {
            this.f34751a = cVar;
        }

        public String a(String str, String str2) {
            Object obj;
            Iterator it2 = this.f34751a.p().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                FieldName q11 = ((com.sumsub.sns.internal.geo.model.a) obj).c().q();
                if (x.b(q11 != null ? q11.getValue() : null, str2)) {
                    break;
                }
            }
            com.sumsub.sns.internal.geo.model.a aVar = (com.sumsub.sns.internal.geo.model.a) obj;
            if (aVar != null) {
                return aVar.d();
            }
            return null;
        }

        public /* synthetic */ List b(String str, String str2) {
            return com.sumsub.sns.internal.core.presentation.form.f.a(this, str, str2);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onEnableLocationAccessConfirmed$1", f = "SNSGeoViewModel.kt", l = {441, 442, 443}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f34752a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34753b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34754c;

        /* renamed from: d  reason: collision with root package name */
        public int f34755d;

        /* renamed from: e  reason: collision with root package name */
        public int f34756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f34757f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(c cVar, kotlin.coroutines.c<? super g> cVar2) {
            super(2, cVar2);
            this.f34757f = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f34757f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0089 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f34756e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0044
                if (r1 == r4) goto L_0x003a
                if (r1 == r3) goto L_0x002c
                if (r1 != r2) goto L_0x0024
                int r0 = r8.f34755d
                java.lang.Object r1 = r8.f34754c
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r8.f34753b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r8.f34752a
                com.sumsub.sns.internal.geo.presentation.c r3 = (com.sumsub.sns.internal.geo.presentation.c) r3
                kotlin.k.b(r9)
                goto L_0x008f
            L_0x0024:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x002c:
                int r1 = r8.f34755d
                java.lang.Object r3 = r8.f34753b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r8.f34752a
                com.sumsub.sns.internal.geo.presentation.c r4 = (com.sumsub.sns.internal.geo.presentation.c) r4
                kotlin.k.b(r9)
                goto L_0x0073
            L_0x003a:
                int r4 = r8.f34755d
                java.lang.Object r1 = r8.f34752a
                com.sumsub.sns.internal.geo.presentation.c r1 = (com.sumsub.sns.internal.geo.presentation.c) r1
                kotlin.k.b(r9)
                goto L_0x0058
            L_0x0044:
                kotlin.k.b(r9)
                com.sumsub.sns.internal.geo.presentation.c r1 = r8.f34757f
                r8.f34752a = r1
                r8.f34755d = r4
                r8.f34756e = r4
                java.lang.String r9 = "sns_alert_lackOfLocationPermissions"
                java.lang.Object r9 = r1.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r9 != r0) goto L_0x0058
                return r0
            L_0x0058:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.internal.geo.presentation.c r5 = r8.f34757f
                r8.f34752a = r1
                r8.f34753b = r9
                r8.f34755d = r4
                r8.f34756e = r3
                java.lang.String r3 = "sns_alert_action_settings"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r3 != r0) goto L_0x006d
                return r0
            L_0x006d:
                r6 = r3
                r3 = r9
                r9 = r6
                r7 = r4
                r4 = r1
                r1 = r7
            L_0x0073:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.internal.geo.presentation.c r5 = r8.f34757f
                r8.f34752a = r4
                r8.f34753b = r3
                r8.f34754c = r9
                r8.f34755d = r1
                r8.f34756e = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r2 != r0) goto L_0x008a
                return r0
            L_0x008a:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r3
                r3 = r4
            L_0x008f:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.core.presentation.base.a$n r4 = new com.sumsub.sns.core.presentation.base.a$n
                r4.<init>(r0, r2, r1, r9)
                r3.a((com.sumsub.sns.core.presentation.base.a.j) r4)
                kotlin.Unit r9 = kotlin.Unit.f56620a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onLocationDisabled$1", f = "SNSGeoViewModel.kt", l = {181}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f34759b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(c cVar, kotlin.coroutines.c<? super h> cVar2) {
            super(2, cVar2);
            this.f34759b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
            return ((h) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f34759b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34758a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                c cVar = this.f34759b;
                this.f34758a = 1;
                obj = cVar.f((kotlin.coroutines.c<? super e.f>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onPrepare$2", f = "SNSGeoViewModel.kt", l = {139}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f34761b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(c cVar, kotlin.coroutines.c<? super i> cVar2) {
            super(2, cVar2);
            this.f34761b = cVar;
        }

        /* renamed from: a */
        public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
            return ((i) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f34761b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34760a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                c cVar = this.f34761b;
                this.f34760a = 1;
                obj = cVar.e((kotlin.coroutines.c<? super e.b>) this);
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onRequestLocationAccessConfirmed$1", f = "SNSGeoViewModel.kt", l = {428, 429, 430}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f34762a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34763b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34764c;

        /* renamed from: d  reason: collision with root package name */
        public int f34765d;

        /* renamed from: e  reason: collision with root package name */
        public int f34766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f34767f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c cVar, kotlin.coroutines.c<? super j> cVar2) {
            super(2, cVar2);
            this.f34767f = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j(this.f34767f, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f34766e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0044
                if (r1 == r4) goto L_0x003a
                if (r1 == r3) goto L_0x002c
                if (r1 != r2) goto L_0x0024
                int r0 = r7.f34765d
                java.lang.Object r1 = r7.f34764c
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r7.f34763b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r7.f34762a
                com.sumsub.sns.internal.geo.presentation.c r3 = (com.sumsub.sns.internal.geo.presentation.c) r3
                kotlin.k.b(r8)
                goto L_0x0090
            L_0x0024:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x002c:
                int r1 = r7.f34765d
                java.lang.Object r3 = r7.f34763b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r7.f34762a
                com.sumsub.sns.internal.geo.presentation.c r4 = (com.sumsub.sns.internal.geo.presentation.c) r4
                kotlin.k.b(r8)
                goto L_0x0074
            L_0x003a:
                int r1 = r7.f34765d
                java.lang.Object r4 = r7.f34762a
                com.sumsub.sns.internal.geo.presentation.c r4 = (com.sumsub.sns.internal.geo.presentation.c) r4
                kotlin.k.b(r8)
                goto L_0x005c
            L_0x0044:
                kotlin.k.b(r8)
                com.sumsub.sns.internal.geo.presentation.c r8 = r7.f34767f
                r1 = 0
                r7.f34762a = r8
                r7.f34765d = r1
                r7.f34766e = r4
                java.lang.String r4 = "sns_alert_lackOfLocationPermissions"
                java.lang.Object r4 = r8.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r4 != r0) goto L_0x0059
                return r0
            L_0x0059:
                r6 = r4
                r4 = r8
                r8 = r6
            L_0x005c:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.geo.presentation.c r5 = r7.f34767f
                r7.f34762a = r4
                r7.f34763b = r8
                r7.f34765d = r1
                r7.f34766e = r3
                java.lang.String r3 = "sns_alert_action_settings"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r3 != r0) goto L_0x0071
                return r0
            L_0x0071:
                r6 = r3
                r3 = r8
                r8 = r6
            L_0x0074:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.geo.presentation.c r5 = r7.f34767f
                r7.f34762a = r4
                r7.f34763b = r3
                r7.f34764c = r8
                r7.f34765d = r1
                r7.f34766e = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r2 != r0) goto L_0x008b
                return r0
            L_0x008b:
                r0 = r1
                r1 = r8
                r8 = r2
                r2 = r3
                r3 = r4
            L_0x0090:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.core.presentation.base.a$n r4 = new com.sumsub.sns.core.presentation.base.a$n
                r4.<init>(r0, r2, r1, r8)
                r3.a((com.sumsub.sns.core.presentation.base.a.j) r4)
                kotlin.Unit r8 = kotlin.Unit.f56620a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onSendAddressDataClick$1", f = "SNSGeoViewModel.kt", l = {190, 218, 221, 224, 230, 233, 276}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f34768a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34769b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34770c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34771d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34772e;

        /* renamed from: f  reason: collision with root package name */
        public Object f34773f;

        /* renamed from: g  reason: collision with root package name */
        public Object f34774g;

        /* renamed from: h  reason: collision with root package name */
        public Object f34775h;

        /* renamed from: i  reason: collision with root package name */
        public Object f34776i;

        /* renamed from: j  reason: collision with root package name */
        public Object f34777j;

        /* renamed from: k  reason: collision with root package name */
        public Object f34778k;

        /* renamed from: l  reason: collision with root package name */
        public Object f34779l;

        /* renamed from: m  reason: collision with root package name */
        public int f34780m;

        /* renamed from: n  reason: collision with root package name */
        public final /* synthetic */ c f34781n;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onSendAddressDataClick$1$1", f = "SNSGeoViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f34782a;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((a) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f34782a == 0) {
                    kotlin.k.b(obj);
                    return e.c.f34854e;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onSendAddressDataClick$1$3", f = "SNSGeoViewModel.kt", l = {247, 248, 255, 256}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34783a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34784b;

            /* renamed from: c  reason: collision with root package name */
            public Object f34785c;

            /* renamed from: d  reason: collision with root package name */
            public Object f34786d;

            /* renamed from: e  reason: collision with root package name */
            public Object f34787e;

            /* renamed from: f  reason: collision with root package name */
            public Object f34788f;

            /* renamed from: g  reason: collision with root package name */
            public int f34789g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ c f34790h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ List<FormItem> f34791i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ List<a> f34792j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ com.sumsub.sns.internal.core.data.model.e f34793k;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, List<? extends FormItem> list, List<a> list2, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super b> cVar2) {
                super(2, cVar2);
                this.f34790h = cVar;
                this.f34791i = list;
                this.f34792j = list2;
                this.f34793k = eVar;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((b) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f34790h, this.f34791i, this.f34792j, this.f34793k, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:21:0x00ab  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f6  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0117 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0118  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x00ce A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                /*
                    r14 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r14.f34789g
                    r2 = 0
                    r3 = 4
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r1 == 0) goto L_0x0066
                    if (r1 == r6) goto L_0x0062
                    if (r1 == r5) goto L_0x005a
                    if (r1 == r4) goto L_0x0041
                    if (r1 != r3) goto L_0x0039
                    java.lang.Object r0 = r14.f34788f
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r14.f34787e
                    com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
                    java.lang.Object r2 = r14.f34786d
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.Object r3 = r14.f34785c
                    java.util.List r3 = (java.util.List) r3
                    java.lang.Object r4 = r14.f34784b
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    java.lang.Object r5 = r14.f34783a
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    kotlin.k.b(r15)
                    r6 = r0
                    r12 = r5
                    r5 = r1
                    r1 = r12
                    r13 = r4
                    r4 = r2
                    r2 = r13
                    goto L_0x0120
                L_0x0039:
                    java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r15.<init>(r0)
                    throw r15
                L_0x0041:
                    java.lang.Object r1 = r14.f34787e
                    com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
                    java.lang.Object r2 = r14.f34786d
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.Object r4 = r14.f34785c
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Object r5 = r14.f34784b
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    java.lang.Object r6 = r14.f34783a
                    java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                    kotlin.k.b(r15)
                    goto L_0x00fd
                L_0x005a:
                    java.lang.Object r1 = r14.f34783a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r15)
                    goto L_0x009a
                L_0x0062:
                    kotlin.k.b(r15)
                    goto L_0x0088
                L_0x0066:
                    kotlin.k.b(r15)
                    com.sumsub.sns.internal.geo.presentation.c r15 = r14.f34790h
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r6]
                    java.lang.String r7 = r15.f()
                    r1[r2] = r7
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r6)
                    java.lang.String r7 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r7, r1)
                    r14.f34789g = r6
                    java.lang.Object r15 = r15.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r14)
                    if (r15 != r0) goto L_0x0088
                    return r0
                L_0x0088:
                    r1 = r15
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    com.sumsub.sns.internal.geo.presentation.c r15 = r14.f34790h
                    r14.f34783a = r1
                    r14.f34789g = r5
                    java.lang.String r5 = "sns_geolocation_form_subtitle"
                    java.lang.Object r15 = r15.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r14)
                    if (r15 != r0) goto L_0x009a
                    return r0
                L_0x009a:
                    java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                    java.util.List<com.sumsub.sns.internal.core.presentation.form.model.FormItem> r5 = r14.f34791i
                    java.util.List<com.sumsub.sns.internal.geo.presentation.a> r7 = r14.f34792j
                    java.util.Iterator r7 = r7.iterator()
                L_0x00a4:
                    boolean r8 = r7.hasNext()
                    r9 = 0
                    if (r8 == 0) goto L_0x00ce
                    java.lang.Object r8 = r7.next()
                    r10 = r8
                    com.sumsub.sns.internal.geo.presentation.a r10 = (com.sumsub.sns.internal.geo.presentation.a) r10
                    com.sumsub.sns.internal.core.data.model.h$d r10 = r10.g()
                    boolean r11 = r10 instanceof com.sumsub.sns.internal.core.data.model.h.d
                    if (r11 == 0) goto L_0x00bb
                    goto L_0x00bc
                L_0x00bb:
                    r10 = r9
                L_0x00bc:
                    if (r10 == 0) goto L_0x00c3
                    com.sumsub.sns.internal.core.data.model.FieldName r10 = r10.q()
                    goto L_0x00c4
                L_0x00c3:
                    r10 = r9
                L_0x00c4:
                    com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.country
                    if (r10 != r11) goto L_0x00ca
                    r10 = r6
                    goto L_0x00cb
                L_0x00ca:
                    r10 = r2
                L_0x00cb:
                    if (r10 == 0) goto L_0x00a4
                    goto L_0x00cf
                L_0x00ce:
                    r8 = r9
                L_0x00cf:
                    com.sumsub.sns.internal.geo.presentation.a r8 = (com.sumsub.sns.internal.geo.presentation.a) r8
                    if (r8 == 0) goto L_0x00dd
                    java.lang.CharSequence r2 = r8.j()
                    if (r2 == 0) goto L_0x00dd
                    java.lang.String r9 = r2.toString()
                L_0x00dd:
                    com.sumsub.sns.internal.core.data.model.e r2 = r14.f34793k
                    com.sumsub.sns.internal.geo.presentation.c r6 = r14.f34790h
                    r14.f34783a = r1
                    r14.f34784b = r15
                    r14.f34785c = r5
                    r14.f34786d = r9
                    r14.f34787e = r2
                    r14.f34789g = r4
                    java.lang.String r4 = "sns_geolocation_action_continue"
                    java.lang.Object r4 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r14)
                    if (r4 != r0) goto L_0x00f6
                    return r0
                L_0x00f6:
                    r6 = r1
                    r1 = r2
                    r2 = r9
                    r12 = r5
                    r5 = r15
                    r15 = r4
                    r4 = r12
                L_0x00fd:
                    java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                    com.sumsub.sns.internal.geo.presentation.c r7 = r14.f34790h
                    r14.f34783a = r6
                    r14.f34784b = r5
                    r14.f34785c = r4
                    r14.f34786d = r2
                    r14.f34787e = r1
                    r14.f34788f = r15
                    r14.f34789g = r3
                    java.lang.String r3 = "sns_geolocation_action_uploadDocument"
                    java.lang.Object r3 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r14)
                    if (r3 != r0) goto L_0x0118
                    return r0
                L_0x0118:
                    r12 = r6
                    r6 = r15
                    r15 = r3
                    r3 = r4
                    r4 = r2
                    r2 = r5
                    r5 = r1
                    r1 = r12
                L_0x0120:
                    r7 = r15
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                    com.sumsub.sns.internal.geo.presentation.e$d r15 = new com.sumsub.sns.internal.geo.presentation.e$d
                    r0 = r15
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                    return r15
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.k.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$onSendAddressDataClick$1$4", f = "SNSGeoViewModel.kt", l = {281, 282, 284}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.geo.presentation.c$k$c  reason: collision with other inner class name */
        public static final class C0398c extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34794a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34795b;

            /* renamed from: c  reason: collision with root package name */
            public Object f34796c;

            /* renamed from: d  reason: collision with root package name */
            public int f34797d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f34798e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f34799f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0398c(c cVar, Object obj, kotlin.coroutines.c<? super C0398c> cVar2) {
                super(2, cVar2);
                this.f34798e = cVar;
                this.f34799f = obj;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((C0398c) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0398c(this.f34798e, this.f34799f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0090 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r8.f34797d
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x003a
                    if (r1 == r4) goto L_0x0036
                    if (r1 == r3) goto L_0x002e
                    if (r1 != r2) goto L_0x0026
                    java.lang.Object r0 = r8.f34796c
                    com.sumsub.sns.internal.core.data.model.g$a r0 = (com.sumsub.sns.internal.core.data.model.g.a) r0
                    java.lang.Object r1 = r8.f34795b
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    java.lang.Object r2 = r8.f34794a
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    kotlin.k.b(r9)
                    r3 = r0
                    r7 = r2
                    r2 = r1
                    r1 = r7
                    goto L_0x0094
                L_0x0026:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L_0x002e:
                    java.lang.Object r1 = r8.f34794a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r9)
                    goto L_0x0071
                L_0x0036:
                    kotlin.k.b(r9)
                    goto L_0x005d
                L_0x003a:
                    kotlin.k.b(r9)
                    com.sumsub.sns.internal.geo.presentation.c r9 = r8.f34798e
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r4]
                    java.lang.String r5 = r9.f()
                    r6 = 0
                    r1[r6] = r5
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)
                    java.lang.String r5 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r5, r1)
                    r8.f34797d = r4
                    java.lang.Object r9 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r9 != r0) goto L_0x005d
                    return r0
                L_0x005d:
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.geo.presentation.c r1 = r8.f34798e
                    r8.f34794a = r9
                    r8.f34797d = r3
                    java.lang.String r3 = "sns_geolocation_preview_subtitle"
                    java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r1 != r0) goto L_0x006e
                    return r0
                L_0x006e:
                    r7 = r1
                    r1 = r9
                    r9 = r7
                L_0x0071:
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    java.lang.Object r3 = r8.f34799f
                    boolean r4 = kotlin.Result.m3078isFailureimpl(r3)
                    if (r4 == 0) goto L_0x007c
                    r3 = 0
                L_0x007c:
                    com.sumsub.sns.internal.core.data.model.g$a r3 = (com.sumsub.sns.internal.core.data.model.g.a) r3
                    com.sumsub.sns.internal.geo.presentation.c r4 = r8.f34798e
                    r8.f34794a = r1
                    r8.f34795b = r9
                    r8.f34796c = r3
                    r8.f34797d = r2
                    java.lang.String r2 = "sns_geolocation_action_continue"
                    java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r2 != r0) goto L_0x0091
                    return r0
                L_0x0091:
                    r7 = r2
                    r2 = r9
                    r9 = r7
                L_0x0094:
                    r4 = r9
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    com.sumsub.sns.internal.geo.presentation.e$a r9 = new com.sumsub.sns.internal.geo.presentation.e$a
                    r5 = 0
                    r0 = r9
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.k.C0398c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(c cVar, kotlin.coroutines.c<? super k> cVar2) {
            super(2, cVar2);
            this.f34781n = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((k) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f34781n, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: com.sumsub.sns.internal.geo.model.a} */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f2, code lost:
            if (r5 != r1) goto L_0x02f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x02f4, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x02f5, code lost:
            r5 = (java.lang.CharSequence) r5;
            r15 = kotlin.jvm.internal.d0.f56774a;
            r0 = java.lang.String.format(com.sumsub.sns.internal.geo.presentation.c.D, java.util.Arrays.copyOf(new java.lang.Object[]{r6}, 1));
            r2.f34768a = r14;
            r2.f34769b = r13;
            r2.f34770c = r12;
            r2.f34771d = r11;
            r2.f34772e = r10;
            r2.f34773f = r9;
            r2.f34774g = r8;
            r2.f34775h = r7;
            r2.f34776i = r3;
            r2.f34777j = r4;
            r2.f34778k = r5;
            r2.f34780m = 3;
            r0 = com.sumsub.sns.internal.geo.presentation.c.a(r10, r0, (kotlin.coroutines.c) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0327, code lost:
            if (r0 != r1) goto L_0x032a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0329, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x032a, code lost:
            r6 = r5;
            r15 = r13;
            r13 = r11;
            r11 = r9;
            r9 = r7;
            r7 = r4;
            r19 = r8;
            r8 = r3;
            r3 = r14;
            r14 = r12;
            r12 = r10;
            r10 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0338, code lost:
            r0 = (java.lang.CharSequence) r0;
            r2.f34768a = r3;
            r2.f34769b = r15;
            r2.f34770c = r14;
            r2.f34771d = r13;
            r2.f34772e = r12;
            r2.f34773f = r11;
            r2.f34774g = r10;
            r2.f34775h = r9;
            r2.f34776i = r8;
            r2.f34777j = r7;
            r2.f34778k = r6;
            r2.f34779l = r0;
            r2.f34780m = 4;
            r4 = com.sumsub.sns.internal.geo.presentation.c.a(r12, com.sumsub.sns.internal.geo.presentation.c.E, (kotlin.coroutines.c) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x035b, code lost:
            if (r4 != r1) goto L_0x035e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x035d, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x035e, code lost:
            r18 = r15;
            r15 = r14;
            r14 = r13;
            r13 = r12;
            r12 = r11;
            r11 = r10;
            r19 = r9;
            r9 = r0;
            r0 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x036c, code lost:
            r4 = (java.lang.String) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x036e, code lost:
            if (r4 == null) goto L_0x038b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0378, code lost:
            if (r0.c().A() == false) goto L_0x0386;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0382, code lost:
            if (kotlin.text.StringsKt__StringsJVMKt.z(r0.d()) == false) goto L_0x0386;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0384, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0386, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0387, code lost:
            if (r0 == false) goto L_0x038b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0389, code lost:
            r10 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x038b, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x038c, code lost:
            r5 = new com.sumsub.sns.internal.geo.presentation.a(r6, r7, r8, r9, r10);
            r8 = r11;
            r9 = r12;
            r10 = r13;
            r11 = r14;
            r12 = r15;
            r13 = r18;
            r14 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x039b, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x039c, code lost:
            if (r0 == null) goto L_0x03a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x039e, code lost:
            r9.add(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x03a1, code lost:
            r0 = r21;
            r5 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x03a7, code lost:
            r9 = (java.util.List) r9;
            r0 = com.sumsub.sns.internal.geo.presentation.c.b(r2.f34781n);
            r2.f34768a = r14;
            r2.f34769b = r12;
            r2.f34770c = r9;
            r2.f34771d = null;
            r2.f34772e = null;
            r2.f34773f = null;
            r2.f34774g = null;
            r2.f34775h = null;
            r2.f34776i = null;
            r2.f34777j = null;
            r2.f34778k = null;
            r2.f34779l = null;
            r2.f34780m = 5;
            r0 = r0.a(false, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x03d0, code lost:
            if (r0 != r1) goto L_0x03d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x03d2, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x03d3, code lost:
            r6 = r12;
            r7 = r14;
            r19 = r1;
            r1 = r0;
            r0 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x03de, code lost:
            if (kotlin.Result.m3078isFailureimpl(r1) == false) goto L_0x03e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x03e0, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x03e2, code lost:
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x03e5, code lost:
            if (((com.sumsub.sns.internal.core.domain.e) r3) != null) goto L_0x03ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x03e9, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x03ea, code lost:
            r3 = com.sumsub.sns.internal.geo.presentation.c.c(r2.f34781n);
            r2.f34768a = r7;
            r2.f34769b = r6;
            r2.f34770c = r9;
            r2.f34771d = r1;
            r2.f34780m = 6;
            r3 = r3.a(false, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0400, code lost:
            if (r3 != r0) goto L_0x0403;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0402, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0403, code lost:
            r8 = r7;
            r7 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0405, code lost:
            r0 = ((com.sumsub.sns.internal.core.data.model.e) r3).B();
            kotlin.k.b(r1);
            r3 = new com.sumsub.sns.internal.core.presentation.form.model.d(r0, (com.sumsub.sns.internal.core.domain.e) r1);
            r0 = new java.util.ArrayList();
            r1 = r7.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0422, code lost:
            if (r1.hasNext() == false) goto L_0x0434;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0424, code lost:
            r4 = com.sumsub.sns.internal.geo.presentation.b.a((com.sumsub.sns.internal.geo.presentation.a) r1.next(), r3, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x042e, code lost:
            if (r4 == null) goto L_0x041e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x0430, code lost:
            r0.add(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x0434, code lost:
            com.sumsub.sns.internal.geo.a.a(com.sumsub.sns.internal.geo.a.f34682a, com.sumsub.sns.internal.geo.a.f34683b, "not all required fields are ", (java.lang.Throwable) null, 4, (java.lang.Object) null);
            r1 = r2.f34781n;
            com.sumsub.sns.core.presentation.base.a.a(r1, false, new com.sumsub.sns.internal.geo.presentation.c.k.b(r1, r0, r7, r8, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.k.b>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0453, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0454, code lost:
            r2 = new java.util.LinkedHashMap(kotlin.ranges.RangesKt___RangesKt.d(kotlin.collections.MapsKt__MapsJVMKt.d(kotlin.collections.CollectionsKt__IterablesKt.u(r7, 10)), 16));
            r0 = r7.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0471, code lost:
            if (r0.hasNext() == false) goto L_0x0531;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0473, code lost:
            r4 = (com.sumsub.sns.internal.geo.model.a) r0.next();
            r5 = r4.c().q();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0481, code lost:
            if (r5 == null) goto L_0x0489;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0483, code lost:
            r5 = r5.getValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0487, code lost:
            if (r5 != null) goto L_0x048b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0489, code lost:
            r5 = "";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x048b, code lost:
            r7 = r4.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0499, code lost:
            if (kotlin.jvm.internal.x.b(r5, com.sumsub.sns.internal.core.data.model.FieldName.country.getValue()) == false) goto L_0x04cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x013a, code lost:
            r2 = (com.sumsub.sns.internal.core.data.model.e) r2;
            r3 = com.sumsub.sns.internal.core.data.model.f.a(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x049b, code lost:
            r4 = r3.entrySet().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x04a7, code lost:
            if (r4.hasNext() == false) goto L_0x04bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x04a9, code lost:
            r15 = r4.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x04b8, code lost:
            if (kotlin.jvm.internal.x.b(((java.util.Map.Entry) r15).getValue(), r7) == false) goto L_0x04a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x04bb, code lost:
            r15 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x04bc, code lost:
            r15 = (java.util.Map.Entry) r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x04be, code lost:
            if (r15 == null) goto L_0x04ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x04c0, code lost:
            r4 = (java.lang.String) r15.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x04c6, code lost:
            if (r4 != null) goto L_0x04c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0140, code lost:
            if (r3 != null) goto L_0x0146;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x04c9, code lost:
            r7 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x04ca, code lost:
            r4 = kotlin.l.a(r5, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x04d9, code lost:
            if (kotlin.jvm.internal.x.b(r5, com.sumsub.sns.internal.core.data.model.FieldName.state.getValue()) == false) goto L_0x0520;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x04db, code lost:
            r7 = r6.get(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x04e1, code lost:
            if (r7 == null) goto L_0x0517;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x04e3, code lost:
            r7 = r7.entrySet();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x04e7, code lost:
            if (r7 == null) goto L_0x0517;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x04e9, code lost:
            r7 = r7.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0142, code lost:
            r3 = kotlin.collections.MapsKt__MapsKt.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x04f1, code lost:
            if (r7.hasNext() == false) goto L_0x0509;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x04f3, code lost:
            r15 = r7.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0506, code lost:
            if (kotlin.jvm.internal.x.b(((java.util.Map.Entry) r15).getValue(), r4.d()) == false) goto L_0x04ed;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x0509, code lost:
            r15 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x050a, code lost:
            r15 = (java.util.Map.Entry) r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x050c, code lost:
            if (r15 == null) goto L_0x0517;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x050e, code lost:
            r7 = (java.lang.String) r15.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0514, code lost:
            if (r7 == null) goto L_0x0517;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0517, code lost:
            r7 = r4.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x051b, code lost:
            r4 = kotlin.l.a(r5, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0146, code lost:
            r6 = r2.u();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0520, code lost:
            r4 = kotlin.l.a(r5, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0524, code lost:
            r2.put(r4.getFirst(), r4.getSecond());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0531, code lost:
            r4 = r21;
            r0 = com.sumsub.sns.internal.geo.presentation.c.e(r4.f34781n);
            r4.f34780m = 7;
            r0 = r0.a(r2, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0540, code lost:
            if (r0 != r1) goto L_0x0543;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0542, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0543, code lost:
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0548, code lost:
            if (kotlin.Result.m3079isSuccessimpl(r1) == false) goto L_0x0561;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x054a, code lost:
            com.sumsub.sns.internal.geo.presentation.c.a(r4.f34781n, kotlin.collections.CollectionsKt__CollectionsKt.k());
            r0 = r4.f34781n;
            com.sumsub.sns.core.presentation.base.a.a(r0, false, new com.sumsub.sns.internal.geo.presentation.c.k.C0398c(r0, r1, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.k.C0398c>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0561, code lost:
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r4.f34781n, (java.lang.Throwable) (java.lang.Exception) kotlin.Result.m3075exceptionOrNullimpl(r1), r4.f34781n.f(), (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x014a, code lost:
            if (r6 != null) goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0578, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x014c, code lost:
            r6 = kotlin.collections.MapsKt__MapsKt.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0150, code lost:
            r7 = com.sumsub.sns.internal.geo.presentation.c.a(r0.f34781n);
            r8 = r7.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x015e, code lost:
            if (r8.hasNext() == false) goto L_0x0179;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0160, code lost:
            r9 = r8.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0171, code lost:
            if (((com.sumsub.sns.internal.geo.model.a) r9).c().q() != com.sumsub.sns.internal.core.data.model.FieldName.country) goto L_0x0175;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0173, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0175, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0176, code lost:
            if (r10 == false) goto L_0x015a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0179, code lost:
            r9 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x017a, code lost:
            r9 = (com.sumsub.sns.internal.geo.model.a) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x017c, code lost:
            if (r9 == null) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x017e, code lost:
            r8 = r9.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0183, code lost:
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0184, code lost:
            r9 = r3.entrySet().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0190, code lost:
            if (r9.hasNext() == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0192, code lost:
            r10 = r9.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x01a1, code lost:
            if (kotlin.jvm.internal.x.b(((java.util.Map.Entry) r10).getValue(), r8) == false) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a4, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01a5, code lost:
            r10 = (java.util.Map.Entry) r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a7, code lost:
            if (r10 == null) goto L_0x01b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a9, code lost:
            r8 = (java.lang.String) r10.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01b0, code lost:
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b1, code lost:
            com.sumsub.sns.internal.geo.a.a(com.sumsub.sns.internal.geo.a.f34682a, com.sumsub.sns.internal.geo.a.f34683b, "check required fields...", (java.lang.Throwable) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c1, code lost:
            if (r7.isEmpty() == false) goto L_0x01c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c4, code lost:
            r9 = r7.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01cc, code lost:
            if (r9.hasNext() == false) goto L_0x01ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ce, code lost:
            r10 = (com.sumsub.sns.internal.geo.model.a) r9.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x01dc, code lost:
            if (r10.c().A() == false) goto L_0x01ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x01e6, code lost:
            if (kotlin.text.StringsKt__StringsJVMKt.z(r10.d()) == false) goto L_0x01ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01e8, code lost:
            r10 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ea, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01eb, code lost:
            if (r10 == false) goto L_0x01c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ed, code lost:
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ef, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01f0, code lost:
            if (r9 == false) goto L_0x0454;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01f2, code lost:
            r9 = r0.f34781n;
            r10 = new java.util.ArrayList();
            r14 = r2;
            r13 = r3;
            r12 = r6;
            r11 = r8;
            r2 = r0;
            r8 = r7.iterator();
            r19 = r10;
            r10 = r9;
            r9 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x020c, code lost:
            if (r8.hasNext() == false) goto L_0x03a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x020e, code lost:
            r7 = r8.next();
            r3 = r7.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x021b, code lost:
            if ((r3 instanceof com.sumsub.sns.internal.core.data.model.h.d) == false) goto L_0x021e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x021e, code lost:
            r3 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x021f, code lost:
            if (r3 == null) goto L_0x039b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0221, code lost:
            r6 = r3.q();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0225, code lost:
            if (r6 != null) goto L_0x0229;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0233, code lost:
            if (r7.c().q() != com.sumsub.sns.internal.core.data.model.FieldName.country) goto L_0x026b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0235, code lost:
            r3 = r13.entrySet().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0241, code lost:
            if (r3.hasNext() == false) goto L_0x025d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0243, code lost:
            r15 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0257, code lost:
            if (kotlin.jvm.internal.x.b(((java.util.Map.Entry) r15).getValue(), r7.d()) == false) goto L_0x025a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x025d, code lost:
            r15 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x025e, code lost:
            r15 = (java.util.Map.Entry) r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0260, code lost:
            if (r15 == null) goto L_0x0269;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0262, code lost:
            r3 = (java.lang.String) r15.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0269, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0275, code lost:
            if (r7.c().q() != com.sumsub.sns.internal.core.data.model.FieldName.state) goto L_0x02b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0277, code lost:
            r3 = r12.get(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x027d, code lost:
            if (r3 == null) goto L_0x02b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x027f, code lost:
            r3 = r3.entrySet();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0283, code lost:
            if (r3 == null) goto L_0x02b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0285, code lost:
            r3 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x028d, code lost:
            if (r3.hasNext() == false) goto L_0x02a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x009b, code lost:
            r20 = r8;
            r8 = r6;
            r6 = r7;
            r7 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x028f, code lost:
            r4 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x02a2, code lost:
            if (kotlin.jvm.internal.x.b(((java.util.Map.Entry) r4).getValue(), r7.d()) == false) goto L_0x0289;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x02a5, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x02a6, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x02a8, code lost:
            if (r4 == null) goto L_0x02b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x02aa, code lost:
            r3 = (java.lang.String) r4.getKey();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x02b0, code lost:
            if (r3 != null) goto L_0x02bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x02b2, code lost:
            r3 = r7.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b7, code lost:
            r3 = r7.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x02bb, code lost:
            r4 = r7.c();
            r5 = kotlin.jvm.internal.d0.f56774a;
            r5 = java.lang.String.format(com.sumsub.sns.internal.geo.presentation.c.B, java.util.Arrays.copyOf(new java.lang.Object[]{r6}, 1));
            r2.f34768a = r14;
            r2.f34769b = r13;
            r2.f34770c = r12;
            r2.f34771d = r11;
            r2.f34772e = r10;
            r2.f34773f = r9;
            r2.f34774g = r8;
            r2.f34775h = r7;
            r2.f34776i = r6;
            r2.f34777j = r3;
            r2.f34778k = r4;
            r2.f34779l = null;
            r2.f34780m = 2;
            r5 = com.sumsub.sns.internal.geo.presentation.c.a(r10, r5, (kotlin.coroutines.c) r2);
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r0 = r21
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f34780m
                r4 = 0
                r5 = 0
                switch(r2) {
                    case 0: goto L_0x011d;
                    case 1: goto L_0x0117;
                    case 2: goto L_0x00e2;
                    case 3: goto L_0x00a3;
                    case 4: goto L_0x0059;
                    case 5: goto L_0x003c;
                    case 6: goto L_0x0024;
                    case 7: goto L_0x0016;
                    default: goto L_0x000d;
                }
            L_0x000d:
                r4 = r0
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0016:
                kotlin.k.b(r22)
                r1 = r22
                kotlin.Result r1 = (kotlin.Result) r1
                java.lang.Object r1 = r1.m3081unboximpl()
                r4 = r0
                goto L_0x0544
            L_0x0024:
                java.lang.Object r1 = r0.f34771d
                java.lang.Object r2 = r0.f34770c
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r6 = r0.f34769b
                java.util.Map r6 = (java.util.Map) r6
                java.lang.Object r7 = r0.f34768a
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
                kotlin.k.b(r22)
                r3 = r22
                r8 = r7
                r7 = r2
                r2 = r0
                goto L_0x0405
            L_0x003c:
                java.lang.Object r2 = r0.f34770c
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r6 = r0.f34769b
                java.util.Map r6 = (java.util.Map) r6
                java.lang.Object r7 = r0.f34768a
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
                kotlin.k.b(r22)
                r8 = r22
                kotlin.Result r8 = (kotlin.Result) r8
                java.lang.Object r8 = r8.m3081unboximpl()
                r9 = r2
                r2 = r0
                r0 = r1
                r1 = r8
                goto L_0x03da
            L_0x0059:
                java.lang.Object r2 = r0.f34779l
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r6 = r0.f34778k
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.Object r7 = r0.f34777j
                com.sumsub.sns.internal.core.data.model.h$d r7 = (com.sumsub.sns.internal.core.data.model.h.d) r7
                java.lang.Object r8 = r0.f34776i
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.Object r9 = r0.f34775h
                com.sumsub.sns.internal.geo.model.a r9 = (com.sumsub.sns.internal.geo.model.a) r9
                java.lang.Object r10 = r0.f34774g
                java.util.Iterator r10 = (java.util.Iterator) r10
                java.lang.Object r11 = r0.f34773f
                java.util.Collection r11 = (java.util.Collection) r11
                java.lang.Object r12 = r0.f34772e
                com.sumsub.sns.internal.geo.presentation.c r12 = (com.sumsub.sns.internal.geo.presentation.c) r12
                java.lang.Object r13 = r0.f34771d
                java.lang.String r13 = (java.lang.String) r13
                java.lang.Object r14 = r0.f34770c
                java.util.Map r14 = (java.util.Map) r14
                java.lang.Object r15 = r0.f34769b
                java.util.Map r15 = (java.util.Map) r15
                java.lang.Object r3 = r0.f34768a
                com.sumsub.sns.internal.core.data.model.e r3 = (com.sumsub.sns.internal.core.data.model.e) r3
                kotlin.k.b(r22)
                r4 = r22
                r18 = r15
                r15 = r14
                r14 = r13
                r13 = r12
                r12 = r11
                r11 = r10
                r19 = r2
                r2 = r0
                r0 = r9
                r9 = r19
            L_0x009b:
                r20 = r8
                r8 = r6
                r6 = r7
                r7 = r20
                goto L_0x036c
            L_0x00a3:
                java.lang.Object r2 = r0.f34778k
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f34777j
                com.sumsub.sns.internal.core.data.model.h$d r3 = (com.sumsub.sns.internal.core.data.model.h.d) r3
                java.lang.Object r6 = r0.f34776i
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                java.lang.Object r7 = r0.f34775h
                com.sumsub.sns.internal.geo.model.a r7 = (com.sumsub.sns.internal.geo.model.a) r7
                java.lang.Object r8 = r0.f34774g
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r0.f34773f
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.Object r10 = r0.f34772e
                com.sumsub.sns.internal.geo.presentation.c r10 = (com.sumsub.sns.internal.geo.presentation.c) r10
                java.lang.Object r11 = r0.f34771d
                java.lang.String r11 = (java.lang.String) r11
                java.lang.Object r12 = r0.f34770c
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f34769b
                java.util.Map r13 = (java.util.Map) r13
                java.lang.Object r14 = r0.f34768a
                com.sumsub.sns.internal.core.data.model.e r14 = (com.sumsub.sns.internal.core.data.model.e) r14
                kotlin.k.b(r22)
                r15 = r13
                r13 = r11
                r11 = r9
                r9 = r7
                r7 = r3
                r3 = r14
                r14 = r12
                r12 = r10
                r10 = r8
                r8 = r6
                r6 = r2
                r2 = r0
                r0 = r22
                goto L_0x0338
            L_0x00e2:
                java.lang.Object r2 = r0.f34778k
                com.sumsub.sns.internal.core.data.model.h$d r2 = (com.sumsub.sns.internal.core.data.model.h.d) r2
                java.lang.Object r3 = r0.f34777j
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r6 = r0.f34776i
                com.sumsub.sns.internal.core.data.model.FieldName r6 = (com.sumsub.sns.internal.core.data.model.FieldName) r6
                java.lang.Object r7 = r0.f34775h
                com.sumsub.sns.internal.geo.model.a r7 = (com.sumsub.sns.internal.geo.model.a) r7
                java.lang.Object r8 = r0.f34774g
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r0.f34773f
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.Object r10 = r0.f34772e
                com.sumsub.sns.internal.geo.presentation.c r10 = (com.sumsub.sns.internal.geo.presentation.c) r10
                java.lang.Object r11 = r0.f34771d
                java.lang.String r11 = (java.lang.String) r11
                java.lang.Object r12 = r0.f34770c
                java.util.Map r12 = (java.util.Map) r12
                java.lang.Object r13 = r0.f34769b
                java.util.Map r13 = (java.util.Map) r13
                java.lang.Object r14 = r0.f34768a
                com.sumsub.sns.internal.core.data.model.e r14 = (com.sumsub.sns.internal.core.data.model.e) r14
                kotlin.k.b(r22)
                r5 = r22
                r4 = r2
                r2 = r0
                goto L_0x02f5
            L_0x0117:
                kotlin.k.b(r22)
                r2 = r22
                goto L_0x013a
            L_0x011d:
                kotlin.k.b(r22)
                com.sumsub.sns.internal.geo.presentation.c r2 = r0.f34781n
                com.sumsub.sns.internal.geo.presentation.c$k$a r3 = new com.sumsub.sns.internal.geo.presentation.c$k$a
                r3.<init>(r5)
                r6 = 1
                com.sumsub.sns.core.presentation.base.a.a(r2, r4, r3, r6, r5)
                com.sumsub.sns.internal.geo.presentation.c r2 = r0.f34781n
                com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r2.M
                r0.f34780m = r6
                java.lang.Object r2 = r2.a((boolean) r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r0)
                if (r2 != r1) goto L_0x013a
                return r1
            L_0x013a:
                com.sumsub.sns.internal.core.data.model.e r2 = (com.sumsub.sns.internal.core.data.model.e) r2
                java.util.Map r3 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r2)
                if (r3 != 0) goto L_0x0146
                java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.h()
            L_0x0146:
                java.util.Map r6 = r2.u()
                if (r6 != 0) goto L_0x0150
                java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.h()
            L_0x0150:
                com.sumsub.sns.internal.geo.presentation.c r7 = r0.f34781n
                java.util.List r7 = r7.p()
                java.util.Iterator r8 = r7.iterator()
            L_0x015a:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L_0x0179
                java.lang.Object r9 = r8.next()
                r10 = r9
                com.sumsub.sns.internal.geo.model.a r10 = (com.sumsub.sns.internal.geo.model.a) r10
                com.sumsub.sns.internal.core.data.model.h$d r10 = r10.c()
                com.sumsub.sns.internal.core.data.model.FieldName r10 = r10.q()
                com.sumsub.sns.internal.core.data.model.FieldName r11 = com.sumsub.sns.internal.core.data.model.FieldName.country
                if (r10 != r11) goto L_0x0175
                r10 = 1
                goto L_0x0176
            L_0x0175:
                r10 = r4
            L_0x0176:
                if (r10 == 0) goto L_0x015a
                goto L_0x017a
            L_0x0179:
                r9 = r5
            L_0x017a:
                com.sumsub.sns.internal.geo.model.a r9 = (com.sumsub.sns.internal.geo.model.a) r9
                if (r9 == 0) goto L_0x0183
                java.lang.String r8 = r9.d()
                goto L_0x0184
            L_0x0183:
                r8 = r5
            L_0x0184:
                java.util.Set r9 = r3.entrySet()
                java.util.Iterator r9 = r9.iterator()
            L_0x018c:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x01a4
                java.lang.Object r10 = r9.next()
                r11 = r10
                java.util.Map$Entry r11 = (java.util.Map.Entry) r11
                java.lang.Object r11 = r11.getValue()
                boolean r11 = kotlin.jvm.internal.x.b(r11, r8)
                if (r11 == 0) goto L_0x018c
                goto L_0x01a5
            L_0x01a4:
                r10 = r5
            L_0x01a5:
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                if (r10 == 0) goto L_0x01b0
                java.lang.Object r8 = r10.getKey()
                java.lang.String r8 = (java.lang.String) r8
                goto L_0x01b1
            L_0x01b0:
                r8 = r5
            L_0x01b1:
                com.sumsub.sns.internal.geo.a r9 = com.sumsub.sns.internal.geo.a.f34682a
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "SumSubGeo"
                java.lang.String r11 = "check required fields..."
                com.sumsub.sns.internal.geo.a.a(r9, r10, r11, r12, r13, r14)
                boolean r9 = r7.isEmpty()
                if (r9 == 0) goto L_0x01c4
                goto L_0x01ef
            L_0x01c4:
                java.util.Iterator r9 = r7.iterator()
            L_0x01c8:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x01ef
                java.lang.Object r10 = r9.next()
                com.sumsub.sns.internal.geo.model.a r10 = (com.sumsub.sns.internal.geo.model.a) r10
                com.sumsub.sns.internal.core.data.model.h$d r11 = r10.c()
                boolean r11 = r11.A()
                if (r11 == 0) goto L_0x01ea
                java.lang.String r10 = r10.d()
                boolean r10 = kotlin.text.StringsKt__StringsJVMKt.z(r10)
                if (r10 == 0) goto L_0x01ea
                r10 = 1
                goto L_0x01eb
            L_0x01ea:
                r10 = r4
            L_0x01eb:
                if (r10 == 0) goto L_0x01c8
                r9 = 1
                goto L_0x01f0
            L_0x01ef:
                r9 = r4
            L_0x01f0:
                if (r9 == 0) goto L_0x0454
                com.sumsub.sns.internal.geo.presentation.c r9 = r0.f34781n
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Iterator r7 = r7.iterator()
                r14 = r2
                r13 = r3
                r12 = r6
                r11 = r8
                r2 = r0
                r8 = r7
                r19 = r10
                r10 = r9
                r9 = r19
            L_0x0208:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto L_0x03a7
                java.lang.Object r3 = r8.next()
                r7 = r3
                com.sumsub.sns.internal.geo.model.a r7 = (com.sumsub.sns.internal.geo.model.a) r7
                com.sumsub.sns.internal.core.data.model.h$d r3 = r7.c()
                boolean r6 = r3 instanceof com.sumsub.sns.internal.core.data.model.h.d
                if (r6 == 0) goto L_0x021e
                goto L_0x021f
            L_0x021e:
                r3 = r5
            L_0x021f:
                if (r3 == 0) goto L_0x039b
                com.sumsub.sns.internal.core.data.model.FieldName r6 = r3.q()
                if (r6 != 0) goto L_0x0229
                goto L_0x039b
            L_0x0229:
                com.sumsub.sns.internal.core.data.model.h$d r3 = r7.c()
                com.sumsub.sns.internal.core.data.model.FieldName r3 = r3.q()
                com.sumsub.sns.internal.core.data.model.FieldName r15 = com.sumsub.sns.internal.core.data.model.FieldName.country
                if (r3 != r15) goto L_0x026b
                java.util.Set r3 = r13.entrySet()
                java.util.Iterator r3 = r3.iterator()
            L_0x023d:
                boolean r15 = r3.hasNext()
                if (r15 == 0) goto L_0x025d
                java.lang.Object r15 = r3.next()
                r17 = r15
                java.util.Map$Entry r17 = (java.util.Map.Entry) r17
                java.lang.Object r5 = r17.getValue()
                java.lang.String r4 = r7.d()
                boolean r4 = kotlin.jvm.internal.x.b(r5, r4)
                if (r4 == 0) goto L_0x025a
                goto L_0x025e
            L_0x025a:
                r4 = 0
                r5 = 0
                goto L_0x023d
            L_0x025d:
                r15 = 0
            L_0x025e:
                java.util.Map$Entry r15 = (java.util.Map.Entry) r15
                if (r15 == 0) goto L_0x0269
                java.lang.Object r3 = r15.getKey()
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x02bb
            L_0x0269:
                r3 = 0
                goto L_0x02bb
            L_0x026b:
                com.sumsub.sns.internal.core.data.model.h$d r3 = r7.c()
                com.sumsub.sns.internal.core.data.model.FieldName r3 = r3.q()
                com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.state
                if (r3 != r4) goto L_0x02b7
                java.lang.Object r3 = r12.get(r11)
                java.util.Map r3 = (java.util.Map) r3
                if (r3 == 0) goto L_0x02b2
                java.util.Set r3 = r3.entrySet()
                if (r3 == 0) goto L_0x02b2
                java.util.Iterator r3 = r3.iterator()
            L_0x0289:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x02a5
                java.lang.Object r4 = r3.next()
                r5 = r4
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r5 = r5.getValue()
                java.lang.String r15 = r7.d()
                boolean r5 = kotlin.jvm.internal.x.b(r5, r15)
                if (r5 == 0) goto L_0x0289
                goto L_0x02a6
            L_0x02a5:
                r4 = 0
            L_0x02a6:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                if (r4 == 0) goto L_0x02b2
                java.lang.Object r3 = r4.getKey()
                java.lang.String r3 = (java.lang.String) r3
                if (r3 != 0) goto L_0x02bb
            L_0x02b2:
                java.lang.String r3 = r7.d()
                goto L_0x02bb
            L_0x02b7:
                java.lang.String r3 = r7.d()
            L_0x02bb:
                com.sumsub.sns.internal.core.data.model.h$d r4 = r7.c()
                kotlin.jvm.internal.d0 r5 = kotlin.jvm.internal.d0.f56774a
                r5 = 1
                java.lang.Object[] r15 = new java.lang.Object[r5]
                r16 = 0
                r15[r16] = r6
                java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r5)
                java.lang.String r5 = "sns_data_field_%s"
                java.lang.String r5 = java.lang.String.format(r5, r15)
                r2.f34768a = r14
                r2.f34769b = r13
                r2.f34770c = r12
                r2.f34771d = r11
                r2.f34772e = r10
                r2.f34773f = r9
                r2.f34774g = r8
                r2.f34775h = r7
                r2.f34776i = r6
                r2.f34777j = r3
                r2.f34778k = r4
                r15 = 0
                r2.f34779l = r15
                r15 = 2
                r2.f34780m = r15
                java.lang.Object r5 = r10.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r2)
                if (r5 != r1) goto L_0x02f5
                return r1
            L_0x02f5:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                kotlin.jvm.internal.d0 r15 = kotlin.jvm.internal.d0.f56774a
                r15 = 1
                java.lang.Object[] r0 = new java.lang.Object[r15]
                r16 = 0
                r0[r16] = r6
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r15)
                java.lang.String r6 = "sns_data_field_%s_placeholder"
                java.lang.String r0 = java.lang.String.format(r6, r0)
                r2.f34768a = r14
                r2.f34769b = r13
                r2.f34770c = r12
                r2.f34771d = r11
                r2.f34772e = r10
                r2.f34773f = r9
                r2.f34774g = r8
                r2.f34775h = r7
                r2.f34776i = r3
                r2.f34777j = r4
                r2.f34778k = r5
                r6 = 3
                r2.f34780m = r6
                java.lang.Object r0 = r10.a((java.lang.String) r0, (kotlin.coroutines.c<? super java.lang.String>) r2)
                if (r0 != r1) goto L_0x032a
                return r1
            L_0x032a:
                r6 = r5
                r15 = r13
                r13 = r11
                r11 = r9
                r9 = r7
                r7 = r4
                r19 = r8
                r8 = r3
                r3 = r14
                r14 = r12
                r12 = r10
                r10 = r19
            L_0x0338:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r2.f34768a = r3
                r2.f34769b = r15
                r2.f34770c = r14
                r2.f34771d = r13
                r2.f34772e = r12
                r2.f34773f = r11
                r2.f34774g = r10
                r2.f34775h = r9
                r2.f34776i = r8
                r2.f34777j = r7
                r2.f34778k = r6
                r2.f34779l = r0
                r4 = 4
                r2.f34780m = r4
                java.lang.String r4 = "sns_data_error_fieldIsRequired"
                java.lang.Object r4 = r12.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r2)
                if (r4 != r1) goto L_0x035e
                return r1
            L_0x035e:
                r18 = r15
                r15 = r14
                r14 = r13
                r13 = r12
                r12 = r11
                r11 = r10
                r19 = r9
                r9 = r0
                r0 = r19
                goto L_0x009b
            L_0x036c:
                java.lang.String r4 = (java.lang.String) r4
                if (r4 == 0) goto L_0x038b
                com.sumsub.sns.internal.core.data.model.h$d r5 = r0.c()
                boolean r5 = r5.A()
                if (r5 == 0) goto L_0x0386
                java.lang.String r0 = r0.d()
                boolean r0 = kotlin.text.StringsKt__StringsJVMKt.z(r0)
                if (r0 == 0) goto L_0x0386
                r0 = 1
                goto L_0x0387
            L_0x0386:
                r0 = 0
            L_0x0387:
                if (r0 == 0) goto L_0x038b
                r10 = r4
                goto L_0x038c
            L_0x038b:
                r10 = 0
            L_0x038c:
                com.sumsub.sns.internal.geo.presentation.a r0 = new com.sumsub.sns.internal.geo.presentation.a
                r5 = r0
                r5.<init>(r6, r7, r8, r9, r10)
                r8 = r11
                r9 = r12
                r10 = r13
                r11 = r14
                r12 = r15
                r13 = r18
                r14 = r3
                goto L_0x039c
            L_0x039b:
                r0 = 0
            L_0x039c:
                if (r0 == 0) goto L_0x03a1
                r9.add(r0)
            L_0x03a1:
                r0 = r21
                r4 = 0
                r5 = 0
                goto L_0x0208
            L_0x03a7:
                java.util.List r9 = (java.util.List) r9
                com.sumsub.sns.internal.geo.presentation.c r0 = r2.f34781n
                com.sumsub.sns.internal.core.domain.d r0 = r0.Q
                r2.f34768a = r14
                r2.f34769b = r12
                r2.f34770c = r9
                r3 = 0
                r2.f34771d = r3
                r2.f34772e = r3
                r2.f34773f = r3
                r2.f34774g = r3
                r2.f34775h = r3
                r2.f34776i = r3
                r2.f34777j = r3
                r2.f34778k = r3
                r2.f34779l = r3
                r3 = 5
                r2.f34780m = r3
                r3 = 0
                java.lang.Object r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x03d3
                return r1
            L_0x03d3:
                r6 = r12
                r7 = r14
                r19 = r1
                r1 = r0
                r0 = r19
            L_0x03da:
                boolean r3 = kotlin.Result.m3078isFailureimpl(r1)
                if (r3 == 0) goto L_0x03e2
                r3 = 0
                goto L_0x03e3
            L_0x03e2:
                r3 = r1
            L_0x03e3:
                com.sumsub.sns.internal.core.domain.e r3 = (com.sumsub.sns.internal.core.domain.e) r3
                if (r3 != 0) goto L_0x03ea
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x03ea:
                com.sumsub.sns.internal.geo.presentation.c r3 = r2.f34781n
                com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r3.M
                r2.f34768a = r7
                r2.f34769b = r6
                r2.f34770c = r9
                r2.f34771d = r1
                r4 = 6
                r2.f34780m = r4
                r4 = 0
                java.lang.Object r3 = r3.a((boolean) r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r2)
                if (r3 != r0) goto L_0x0403
                return r0
            L_0x0403:
                r8 = r7
                r7 = r9
            L_0x0405:
                com.sumsub.sns.internal.core.data.model.e r3 = (com.sumsub.sns.internal.core.data.model.e) r3
                java.util.Map r0 = r3.B()
                kotlin.k.b(r1)
                com.sumsub.sns.internal.core.domain.e r1 = (com.sumsub.sns.internal.core.domain.e) r1
                com.sumsub.sns.internal.core.presentation.form.model.d r3 = new com.sumsub.sns.internal.core.presentation.form.model.d
                r3.<init>(r0, r1)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r1 = r7.iterator()
            L_0x041e:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x0434
                java.lang.Object r4 = r1.next()
                com.sumsub.sns.internal.geo.presentation.a r4 = (com.sumsub.sns.internal.geo.presentation.a) r4
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r4 = com.sumsub.sns.internal.geo.presentation.b.a(r4, r3, r6)
                if (r4 == 0) goto L_0x041e
                r0.add(r4)
                goto L_0x041e
            L_0x0434:
                com.sumsub.sns.internal.geo.a r9 = com.sumsub.sns.internal.geo.a.f34682a
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "SumSubGeo"
                java.lang.String r11 = "not all required fields are "
                com.sumsub.sns.internal.geo.a.a(r9, r10, r11, r12, r13, r14)
                com.sumsub.sns.internal.geo.presentation.c r1 = r2.f34781n
                com.sumsub.sns.internal.geo.presentation.c$k$b r2 = new com.sumsub.sns.internal.geo.presentation.c$k$b
                r9 = 0
                r4 = r2
                r5 = r1
                r6 = r0
                r4.<init>(r5, r6, r7, r8, r9)
                r0 = 1
                r3 = 0
                r4 = 0
                com.sumsub.sns.core.presentation.base.a.a(r1, r3, r2, r0, r4)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x0454:
                r0 = 10
                int r0 = kotlin.collections.CollectionsKt__IterablesKt.u(r7, r0)
                int r0 = kotlin.collections.MapsKt__MapsJVMKt.d(r0)
                r2 = 16
                int r0 = kotlin.ranges.RangesKt___RangesKt.d(r0, r2)
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                r2.<init>(r0)
                java.util.Iterator r0 = r7.iterator()
            L_0x046d:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L_0x0531
                java.lang.Object r4 = r0.next()
                com.sumsub.sns.internal.geo.model.a r4 = (com.sumsub.sns.internal.geo.model.a) r4
                com.sumsub.sns.internal.core.data.model.h$d r5 = r4.c()
                com.sumsub.sns.internal.core.data.model.FieldName r5 = r5.q()
                if (r5 == 0) goto L_0x0489
                java.lang.String r5 = r5.getValue()
                if (r5 != 0) goto L_0x048b
            L_0x0489:
                java.lang.String r5 = ""
            L_0x048b:
                java.lang.String r7 = r4.d()
                com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.country
                java.lang.String r9 = r9.getValue()
                boolean r9 = kotlin.jvm.internal.x.b(r5, r9)
                if (r9 == 0) goto L_0x04cf
                java.util.Set r4 = r3.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x04a3:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x04bb
                java.lang.Object r15 = r4.next()
                r9 = r15
                java.util.Map$Entry r9 = (java.util.Map.Entry) r9
                java.lang.Object r9 = r9.getValue()
                boolean r9 = kotlin.jvm.internal.x.b(r9, r7)
                if (r9 == 0) goto L_0x04a3
                goto L_0x04bc
            L_0x04bb:
                r15 = 0
            L_0x04bc:
                java.util.Map$Entry r15 = (java.util.Map.Entry) r15
                if (r15 == 0) goto L_0x04ca
                java.lang.Object r4 = r15.getKey()
                java.lang.String r4 = (java.lang.String) r4
                if (r4 != 0) goto L_0x04c9
                goto L_0x04ca
            L_0x04c9:
                r7 = r4
            L_0x04ca:
                kotlin.Pair r4 = kotlin.l.a(r5, r7)
                goto L_0x0524
            L_0x04cf:
                com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.state
                java.lang.String r9 = r9.getValue()
                boolean r9 = kotlin.jvm.internal.x.b(r5, r9)
                if (r9 == 0) goto L_0x0520
                java.lang.Object r7 = r6.get(r8)
                java.util.Map r7 = (java.util.Map) r7
                if (r7 == 0) goto L_0x0517
                java.util.Set r7 = r7.entrySet()
                if (r7 == 0) goto L_0x0517
                java.util.Iterator r7 = r7.iterator()
            L_0x04ed:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x0509
                java.lang.Object r15 = r7.next()
                r9 = r15
                java.util.Map$Entry r9 = (java.util.Map.Entry) r9
                java.lang.Object r9 = r9.getValue()
                java.lang.String r10 = r4.d()
                boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
                if (r9 == 0) goto L_0x04ed
                goto L_0x050a
            L_0x0509:
                r15 = 0
            L_0x050a:
                java.util.Map$Entry r15 = (java.util.Map.Entry) r15
                if (r15 == 0) goto L_0x0517
                java.lang.Object r7 = r15.getKey()
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L_0x0517
                goto L_0x051b
            L_0x0517:
                java.lang.String r7 = r4.d()
            L_0x051b:
                kotlin.Pair r4 = kotlin.l.a(r5, r7)
                goto L_0x0524
            L_0x0520:
                kotlin.Pair r4 = kotlin.l.a(r5, r7)
            L_0x0524:
                java.lang.Object r5 = r4.getFirst()
                java.lang.Object r4 = r4.getSecond()
                r2.put(r5, r4)
                goto L_0x046d
            L_0x0531:
                r4 = r21
                com.sumsub.sns.internal.geo.presentation.c r0 = r4.f34781n
                com.sumsub.sns.internal.geo.domain.c r0 = r0.O
                r3 = 7
                r4.f34780m = r3
                java.lang.Object r0 = r0.a(r2, r4)
                if (r0 != r1) goto L_0x0543
                return r1
            L_0x0543:
                r1 = r0
            L_0x0544:
                boolean r0 = kotlin.Result.m3079isSuccessimpl(r1)
                if (r0 == 0) goto L_0x0561
                com.sumsub.sns.internal.geo.presentation.c r0 = r4.f34781n
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                r0.a((java.util.List<com.sumsub.sns.internal.geo.model.a>) r2)
                com.sumsub.sns.internal.geo.presentation.c r0 = r4.f34781n
                com.sumsub.sns.internal.geo.presentation.c$k$c r2 = new com.sumsub.sns.internal.geo.presentation.c$k$c
                r3 = 0
                r2.<init>(r0, r1, r3)
                r1 = 1
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a(r0, r5, r2, r1, r3)
                goto L_0x0576
            L_0x0561:
                com.sumsub.sns.internal.geo.presentation.c r6 = r4.f34781n
                java.lang.Throwable r0 = kotlin.Result.m3075exceptionOrNullimpl(r1)
                r7 = r0
                java.lang.Exception r7 = (java.lang.Exception) r7
                com.sumsub.sns.internal.geo.presentation.c r0 = r4.f34781n
                java.lang.String r8 = r0.f()
                r9 = 0
                r10 = 4
                r11 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r6, (java.lang.Throwable) r7, (java.lang.String) r8, (java.lang.Object) r9, (int) r10, (java.lang.Object) r11)
            L_0x0576:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel", f = "SNSGeoViewModel.kt", l = {87, 88, 89, 91, 92}, m = "requestLocationAccessState")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34800a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34801b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34802c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34803d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34804e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f34805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f34806g;

        /* renamed from: h  reason: collision with root package name */
        public int f34807h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(c cVar, kotlin.coroutines.c<? super l> cVar2) {
            super(cVar2);
            this.f34806g = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34805f = obj;
            this.f34807h |= Integer.MIN_VALUE;
            return this.f34806g.f((kotlin.coroutines.c<? super e.f>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1", f = "SNSGeoViewModel.kt", l = {314, 316, 326, 329, 366, 369}, m = "invokeSuspend")
    public static final class m extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f34808a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34809b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34810c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34811d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34812e;

        /* renamed from: f  reason: collision with root package name */
        public Object f34813f;

        /* renamed from: g  reason: collision with root package name */
        public Object f34814g;

        /* renamed from: h  reason: collision with root package name */
        public Object f34815h;

        /* renamed from: i  reason: collision with root package name */
        public int f34816i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Location f34817j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ c f34818k;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1$1", f = "SNSGeoViewModel.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f34819a;

            public a(kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((a) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f34819a == 0) {
                    kotlin.k.b(obj);
                    return e.c.f34854e;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1$3", f = "SNSGeoViewModel.kt", l = {343, 344, 346, 347}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34820a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34821b;

            /* renamed from: c  reason: collision with root package name */
            public Object f34822c;

            /* renamed from: d  reason: collision with root package name */
            public Object f34823d;

            /* renamed from: e  reason: collision with root package name */
            public int f34824e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f34825f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
                super(2, cVar2);
                this.f34825f = cVar;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((b) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new b(this.f34825f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r10.f34824e
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x0051
                    if (r1 == r5) goto L_0x004d
                    if (r1 == r4) goto L_0x0045
                    if (r1 == r3) goto L_0x0035
                    if (r1 != r2) goto L_0x002d
                    java.lang.Object r0 = r10.f34823d
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r10.f34822c
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r2 = r10.f34821b
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    java.lang.Object r3 = r10.f34820a
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    kotlin.k.b(r11)
                    r4 = r0
                    r8 = r3
                L_0x0029:
                    r3 = r1
                    r1 = r8
                    goto L_0x00c4
                L_0x002d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L_0x0035:
                    java.lang.Object r1 = r10.f34822c
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r3 = r10.f34821b
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    java.lang.Object r4 = r10.f34820a
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    kotlin.k.b(r11)
                    goto L_0x00a7
                L_0x0045:
                    java.lang.Object r1 = r10.f34820a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r11)
                    goto L_0x0086
                L_0x004d:
                    kotlin.k.b(r11)
                    goto L_0x0074
                L_0x0051:
                    kotlin.k.b(r11)
                    com.sumsub.sns.internal.geo.presentation.c r11 = r10.f34825f
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    java.lang.String r6 = r11.f()
                    r7 = 0
                    r1[r7] = r6
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
                    java.lang.String r6 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r6, r1)
                    r10.f34824e = r5
                    java.lang.Object r11 = r11.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r11 != r0) goto L_0x0074
                    return r0
                L_0x0074:
                    r1 = r11
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    com.sumsub.sns.internal.geo.presentation.c r11 = r10.f34825f
                    r10.f34820a = r1
                    r10.f34824e = r4
                    java.lang.String r4 = "sns_geolocation_detection_invalidLocation"
                    java.lang.Object r11 = r11.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r11 != r0) goto L_0x0086
                    return r0
                L_0x0086:
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.LOCATION_OFF
                    java.lang.String r4 = r4.getImageName()
                    com.sumsub.sns.internal.geo.presentation.c r5 = r10.f34825f
                    r10.f34820a = r1
                    r10.f34821b = r11
                    r10.f34822c = r4
                    r10.f34824e = r3
                    java.lang.String r3 = "sns_geolocation_action_tryAgain"
                    java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r3 != r0) goto L_0x00a1
                    return r0
                L_0x00a1:
                    r8 = r3
                    r3 = r11
                    r11 = r8
                    r9 = r4
                    r4 = r1
                    r1 = r9
                L_0x00a7:
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    com.sumsub.sns.internal.geo.presentation.c r5 = r10.f34825f
                    r10.f34820a = r4
                    r10.f34821b = r3
                    r10.f34822c = r1
                    r10.f34823d = r11
                    r10.f34824e = r2
                    java.lang.String r2 = "sns_geolocation_action_uploadDocument"
                    java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r2 != r0) goto L_0x00be
                    return r0
                L_0x00be:
                    r8 = r4
                    r4 = r11
                    r11 = r2
                    r2 = r3
                    goto L_0x0029
                L_0x00c4:
                    r5 = r11
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    com.sumsub.sns.internal.geo.presentation.e$g r11 = new com.sumsub.sns.internal.geo.presentation.e$g
                    r0 = r11
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.m.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1$4", f = "SNSGeoViewModel.kt", l = {356, 357, 359}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.geo.presentation.c$m$c  reason: collision with other inner class name */
        public static final class C0399c extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34826a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34827b;

            /* renamed from: c  reason: collision with root package name */
            public int f34828c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f34829d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0399c(c cVar, kotlin.coroutines.c<? super C0399c> cVar2) {
                super(2, cVar2);
                this.f34829d = cVar;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((C0399c) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0399c(this.f34829d, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x007b A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r8.f34828c
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0032
                    if (r1 == r4) goto L_0x002e
                    if (r1 == r3) goto L_0x0026
                    if (r1 != r2) goto L_0x001e
                    java.lang.Object r0 = r8.f34827b
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r8.f34826a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r9)
                    r2 = r0
                    goto L_0x007f
                L_0x001e:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L_0x0026:
                    java.lang.Object r1 = r8.f34826a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r9)
                    goto L_0x0069
                L_0x002e:
                    kotlin.k.b(r9)
                    goto L_0x0055
                L_0x0032:
                    kotlin.k.b(r9)
                    com.sumsub.sns.internal.geo.presentation.c r9 = r8.f34829d
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r4]
                    java.lang.String r5 = r9.f()
                    r6 = 0
                    r1[r6] = r5
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)
                    java.lang.String r5 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r5, r1)
                    r8.f34828c = r4
                    java.lang.Object r9 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r9 != r0) goto L_0x0055
                    return r0
                L_0x0055:
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.geo.presentation.c r1 = r8.f34829d
                    r8.f34826a = r9
                    r8.f34828c = r3
                    java.lang.String r3 = "sns_geolocation_preview_subtitle"
                    java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r1 != r0) goto L_0x0066
                    return r0
                L_0x0066:
                    r7 = r1
                    r1 = r9
                    r9 = r7
                L_0x0069:
                    java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                    com.sumsub.sns.internal.geo.presentation.c r3 = r8.f34829d
                    r8.f34826a = r1
                    r8.f34827b = r9
                    r8.f34828c = r2
                    java.lang.String r2 = "sns_geolocation_action_continue"
                    java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                    if (r2 != r0) goto L_0x007c
                    return r0
                L_0x007c:
                    r7 = r2
                    r2 = r9
                    r9 = r7
                L_0x007f:
                    r4 = r9
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    com.sumsub.sns.internal.geo.presentation.e$a r9 = new com.sumsub.sns.internal.geo.presentation.e$a
                    r3 = 0
                    r5 = 0
                    r0 = r9
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.m.C0399c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1$5", f = "SNSGeoViewModel.kt", l = {381, 382, 388}, m = "invokeSuspend")
        public static final class d extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34830a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34831b;

            /* renamed from: c  reason: collision with root package name */
            public Object f34832c;

            /* renamed from: d  reason: collision with root package name */
            public Object f34833d;

            /* renamed from: e  reason: collision with root package name */
            public Object f34834e;

            /* renamed from: f  reason: collision with root package name */
            public int f34835f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f34836g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ List<FormItem> f34837h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ List<a> f34838i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ com.sumsub.sns.internal.core.data.model.e f34839j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(c cVar, List<? extends FormItem> list, List<a> list2, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super d> cVar2) {
                super(2, cVar2);
                this.f34836g = cVar;
                this.f34837h = list;
                this.f34838i = list2;
                this.f34839j = eVar;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((d) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new d(this.f34836g, this.f34837h, this.f34838i, this.f34839j, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x00b0 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    r13 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r13.f34835f
                    r2 = 0
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x0047
                    if (r1 == r5) goto L_0x0043
                    if (r1 == r4) goto L_0x003a
                    if (r1 != r3) goto L_0x0032
                    java.lang.Object r0 = r13.f34834e
                    com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                    java.lang.Object r1 = r13.f34833d
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r2 = r13.f34832c
                    java.util.List r2 = (java.util.List) r2
                    java.lang.Object r3 = r13.f34831b
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    java.lang.Object r4 = r13.f34830a
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    kotlin.k.b(r14)
                    r5 = r0
                    r11 = r4
                    r4 = r1
                    r1 = r11
                    r12 = r3
                    r3 = r2
                    r2 = r12
                    goto L_0x00e0
                L_0x0032:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r0)
                    throw r14
                L_0x003a:
                    java.lang.Object r1 = r13.f34830a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r14)
                    r4 = r1
                    goto L_0x007c
                L_0x0043:
                    kotlin.k.b(r14)
                    goto L_0x0069
                L_0x0047:
                    kotlin.k.b(r14)
                    com.sumsub.sns.internal.geo.presentation.c r14 = r13.f34836g
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    java.lang.String r6 = r14.f()
                    r1[r2] = r6
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
                    java.lang.String r6 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r6, r1)
                    r13.f34835f = r5
                    java.lang.Object r14 = r14.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r14 != r0) goto L_0x0069
                    return r0
                L_0x0069:
                    java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                    com.sumsub.sns.internal.geo.presentation.c r1 = r13.f34836g
                    r13.f34830a = r14
                    r13.f34835f = r4
                    java.lang.String r4 = "sns_geolocation_form_subtitle"
                    java.lang.Object r1 = r1.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r1 != r0) goto L_0x007a
                    return r0
                L_0x007a:
                    r4 = r14
                    r14 = r1
                L_0x007c:
                    java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                    java.util.List<com.sumsub.sns.internal.core.presentation.form.model.FormItem> r1 = r13.f34837h
                    java.util.List<com.sumsub.sns.internal.geo.presentation.a> r6 = r13.f34838i
                    java.util.Iterator r6 = r6.iterator()
                L_0x0086:
                    boolean r7 = r6.hasNext()
                    r8 = 0
                    if (r7 == 0) goto L_0x00b0
                    java.lang.Object r7 = r6.next()
                    r9 = r7
                    com.sumsub.sns.internal.geo.presentation.a r9 = (com.sumsub.sns.internal.geo.presentation.a) r9
                    com.sumsub.sns.internal.core.data.model.h$d r9 = r9.g()
                    boolean r10 = r9 instanceof com.sumsub.sns.internal.core.data.model.h.d
                    if (r10 == 0) goto L_0x009d
                    goto L_0x009e
                L_0x009d:
                    r9 = r8
                L_0x009e:
                    if (r9 == 0) goto L_0x00a5
                    com.sumsub.sns.internal.core.data.model.FieldName r9 = r9.q()
                    goto L_0x00a6
                L_0x00a5:
                    r9 = r8
                L_0x00a6:
                    com.sumsub.sns.internal.core.data.model.FieldName r10 = com.sumsub.sns.internal.core.data.model.FieldName.country
                    if (r9 != r10) goto L_0x00ac
                    r9 = r5
                    goto L_0x00ad
                L_0x00ac:
                    r9 = r2
                L_0x00ad:
                    if (r9 == 0) goto L_0x0086
                    goto L_0x00b1
                L_0x00b0:
                    r7 = r8
                L_0x00b1:
                    com.sumsub.sns.internal.geo.presentation.a r7 = (com.sumsub.sns.internal.geo.presentation.a) r7
                    if (r7 == 0) goto L_0x00c0
                    java.lang.CharSequence r2 = r7.j()
                    if (r2 == 0) goto L_0x00c0
                    java.lang.String r2 = r2.toString()
                    goto L_0x00c1
                L_0x00c0:
                    r2 = r8
                L_0x00c1:
                    com.sumsub.sns.internal.core.data.model.e r5 = r13.f34839j
                    com.sumsub.sns.internal.geo.presentation.c r6 = r13.f34836g
                    r13.f34830a = r4
                    r13.f34831b = r14
                    r13.f34832c = r1
                    r13.f34833d = r2
                    r13.f34834e = r5
                    r13.f34835f = r3
                    java.lang.String r3 = "sns_geolocation_action_continue"
                    java.lang.Object r3 = r6.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r13)
                    if (r3 != r0) goto L_0x00da
                    return r0
                L_0x00da:
                    r11 = r2
                    r2 = r14
                    r14 = r3
                    r3 = r1
                    r1 = r4
                    r4 = r11
                L_0x00e0:
                    r6 = r14
                    java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                    com.sumsub.sns.internal.geo.presentation.e$d r14 = new com.sumsub.sns.internal.geo.presentation.e$d
                    r7 = 0
                    r0 = r14
                    r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.m.d.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.geo.presentation.SNSGeoViewModel$sendLocation$1$6", f = "SNSGeoViewModel.kt", l = {397, 398, 400, 401}, m = "invokeSuspend")
        public static final class e extends SuspendLambda implements p<e, kotlin.coroutines.c<? super e>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f34840a;

            /* renamed from: b  reason: collision with root package name */
            public Object f34841b;

            /* renamed from: c  reason: collision with root package name */
            public Object f34842c;

            /* renamed from: d  reason: collision with root package name */
            public Object f34843d;

            /* renamed from: e  reason: collision with root package name */
            public int f34844e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f34845f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(c cVar, kotlin.coroutines.c<? super e> cVar2) {
                super(2, cVar2);
                this.f34845f = cVar;
            }

            /* renamed from: a */
            public final Object invoke(e eVar, kotlin.coroutines.c<? super e> cVar) {
                return ((e) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new e(this.f34845f, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00bd A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r10.f34844e
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x0051
                    if (r1 == r5) goto L_0x004d
                    if (r1 == r4) goto L_0x0045
                    if (r1 == r3) goto L_0x0035
                    if (r1 != r2) goto L_0x002d
                    java.lang.Object r0 = r10.f34843d
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r10.f34842c
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r2 = r10.f34841b
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    java.lang.Object r3 = r10.f34840a
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    kotlin.k.b(r11)
                    r4 = r0
                    r8 = r3
                L_0x0029:
                    r3 = r1
                    r1 = r8
                    goto L_0x00c4
                L_0x002d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L_0x0035:
                    java.lang.Object r1 = r10.f34842c
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r3 = r10.f34841b
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    java.lang.Object r4 = r10.f34840a
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    kotlin.k.b(r11)
                    goto L_0x00a7
                L_0x0045:
                    java.lang.Object r1 = r10.f34840a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r11)
                    goto L_0x0086
                L_0x004d:
                    kotlin.k.b(r11)
                    goto L_0x0074
                L_0x0051:
                    kotlin.k.b(r11)
                    com.sumsub.sns.internal.geo.presentation.c r11 = r10.f34845f
                    kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a
                    java.lang.Object[] r1 = new java.lang.Object[r5]
                    java.lang.String r6 = r11.f()
                    r7 = 0
                    r1[r7] = r6
                    java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
                    java.lang.String r6 = "sns_step_%s_title"
                    java.lang.String r1 = java.lang.String.format(r6, r1)
                    r10.f34844e = r5
                    java.lang.Object r11 = r11.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r11 != r0) goto L_0x0074
                    return r0
                L_0x0074:
                    r1 = r11
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    com.sumsub.sns.internal.geo.presentation.c r11 = r10.f34845f
                    r10.f34840a = r1
                    r10.f34844e = r4
                    java.lang.String r4 = "sns_geolocation_detection_invalidLocation"
                    java.lang.Object r11 = r11.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r11 != r0) goto L_0x0086
                    return r0
                L_0x0086:
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r4 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.LOCATION_OFF
                    java.lang.String r4 = r4.getImageName()
                    com.sumsub.sns.internal.geo.presentation.c r5 = r10.f34845f
                    r10.f34840a = r1
                    r10.f34841b = r11
                    r10.f34842c = r4
                    r10.f34844e = r3
                    java.lang.String r3 = "sns_geolocation_action_tryAgain"
                    java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r3 != r0) goto L_0x00a1
                    return r0
                L_0x00a1:
                    r8 = r3
                    r3 = r11
                    r11 = r8
                    r9 = r4
                    r4 = r1
                    r1 = r9
                L_0x00a7:
                    java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                    com.sumsub.sns.internal.geo.presentation.c r5 = r10.f34845f
                    r10.f34840a = r4
                    r10.f34841b = r3
                    r10.f34842c = r1
                    r10.f34843d = r11
                    r10.f34844e = r2
                    java.lang.String r2 = "sns_geolocation_action_uploadDocument"
                    java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r10)
                    if (r2 != r0) goto L_0x00be
                    return r0
                L_0x00be:
                    r8 = r4
                    r4 = r11
                    r11 = r2
                    r2 = r3
                    goto L_0x0029
                L_0x00c4:
                    r5 = r11
                    java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                    com.sumsub.sns.internal.geo.presentation.e$g r11 = new com.sumsub.sns.internal.geo.presentation.e$g
                    r0 = r11
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.m.e.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Location location, c cVar, kotlin.coroutines.c<? super m> cVar2) {
            super(2, cVar2);
            this.f34817j = location;
            this.f34818k = cVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((m) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m(this.f34817j, this.f34818k, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x02e5, code lost:
            r3 = kotlin.collections.MapsKt__MapsKt.h();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x02e9, code lost:
            r1 = com.sumsub.sns.internal.geo.presentation.b.a(r1, r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x02ed, code lost:
            if (r1 == null) goto L_0x02d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x02ef, code lost:
            r15.add(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x02f3, code lost:
            r0 = r5.f34818k;
            com.sumsub.sns.core.presentation.base.a.a(r0, false, new com.sumsub.sns.internal.geo.presentation.c.m.d(r0, r15, r16, r17, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.m.d>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0302, code lost:
            r0 = kotlin.Result.m3075exceptionOrNullimpl(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0308, code lost:
            if ((r0 instanceof com.sumsub.sns.core.data.model.SNSException.Api) == false) goto L_0x030d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x030a, code lost:
            r0 = (com.sumsub.sns.core.data.model.SNSException.Api) r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x030d, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x030e, code lost:
            if (r0 == null) goto L_0x0321;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0310, code lost:
            r0 = r0.getErrorCode();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0316, code lost:
            if (r0 != null) goto L_0x0319;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x031d, code lost:
            if (r0.intValue() != 9001) goto L_0x0321;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x031f, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0321, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0322, code lost:
            if (r0 == false) goto L_0x0331;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0324, code lost:
            r0 = r8.f34818k;
            com.sumsub.sns.core.presentation.base.a.a(r0, false, new com.sumsub.sns.internal.geo.presentation.c.m.e(r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.m.e>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0330, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0331, code lost:
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r8.f34818k, (java.lang.Throwable) (java.lang.Exception) kotlin.Result.m3075exceptionOrNullimpl(r1), r8.f34818k.f(), (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x034f, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00f4, code lost:
            r13 = (com.sumsub.sns.internal.core.data.model.e) r0;
            r0 = com.sumsub.sns.internal.geo.presentation.c.d(r8.f34818k);
            r1 = r8.f34818k.f();
            r2 = r8.f34817j.getLatitude();
            r4 = r8.f34817j.getLongitude();
            r6 = r8.f34817j.getAccuracy();
            r8.f34808a = r13;
            r8.f34816i = 2;
            r1 = r0.a(r1, r2, r4, r6, r21);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0120, code lost:
            if (r1 != r9) goto L_0x0123;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0122, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0123, code lost:
            r0 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0124, code lost:
            r2 = new java.util.ArrayList();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x012d, code lost:
            if (kotlin.Result.m3079isSuccessimpl(r1) == false) goto L_0x0302;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0133, code lost:
            if (kotlin.Result.m3078isFailureimpl(r1) == false) goto L_0x0136;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0135, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0136, code lost:
            r1 = (java.util.List) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0138, code lost:
            if (r1 == null) goto L_0x01ff;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x013a, code lost:
            r3 = r8.f34818k;
            r4 = new java.util.ArrayList();
            r1 = r1.iterator();
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x014a, code lost:
            if (r1.hasNext() == false) goto L_0x01fa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x014c, code lost:
            r6 = (com.sumsub.sns.internal.geo.model.a) r1.next();
            r2.add(r6);
            r7 = r6.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x015b, code lost:
            if ((r7 instanceof com.sumsub.sns.internal.core.data.model.h.d) == false) goto L_0x015e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x015e, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x015f, code lost:
            if (r7 == null) goto L_0x01ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0161, code lost:
            r7 = r7.q();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0165, code lost:
            if (r7 != null) goto L_0x0169;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0169, code lost:
            r13 = r6.c();
            r6 = r6.d();
            r14 = kotlin.jvm.internal.d0.f56774a;
            r14 = java.lang.String.format(com.sumsub.sns.internal.geo.presentation.c.B, java.util.Arrays.copyOf(new java.lang.Object[]{r7}, 1));
            r5.f34808a = r0;
            r5.f34809b = r2;
            r5.f34810c = r3;
            r5.f34811d = r4;
            r5.f34812e = r1;
            r5.f34813f = r7;
            r5.f34814g = r6;
            r5.f34815h = r13;
            r5.f34816i = 3;
            r14 = com.sumsub.sns.internal.geo.presentation.c.a(r3, r14, (kotlin.coroutines.c) r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0198, code lost:
            if (r14 != r9) goto L_0x019b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x019a, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x019b, code lost:
            r19 = r9;
            r9 = r0;
            r0 = r5;
            r5 = r3;
            r3 = r1;
            r1 = r13;
            r13 = r19;
            r20 = r7;
            r7 = r2;
            r2 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a9, code lost:
            r14 = (java.lang.CharSequence) r14;
            r15 = kotlin.jvm.internal.d0.f56774a;
            r2 = java.lang.String.format(com.sumsub.sns.internal.geo.presentation.c.D, java.util.Arrays.copyOf(new java.lang.Object[]{r2}, 1));
            r0.f34808a = r9;
            r0.f34809b = r7;
            r0.f34810c = r5;
            r0.f34811d = r4;
            r0.f34812e = r3;
            r0.f34813f = r6;
            r0.f34814g = r1;
            r0.f34815h = r14;
            r0.f34816i = 4;
            r2 = com.sumsub.sns.internal.geo.presentation.c.a(r5, r2, (kotlin.coroutines.c) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d2, code lost:
            if (r2 != r13) goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01d4, code lost:
            return r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01d5, code lost:
            r15 = r6;
            r6 = r7;
            r7 = r9;
            r9 = r13;
            r16 = r14;
            r14 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01dc, code lost:
            r13 = new com.sumsub.sns.internal.geo.presentation.a(r14, r15, r16, (java.lang.CharSequence) r2, (java.lang.CharSequence) null);
            r2 = r6;
            r6 = r0;
            r0 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x01ec, code lost:
            r6 = r5;
            r5 = r3;
            r3 = r1;
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01f0, code lost:
            if (r1 == null) goto L_0x01f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01f2, code lost:
            r4.add(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01f5, code lost:
            r1 = r3;
            r3 = r5;
            r5 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01fa, code lost:
            r4 = (java.util.List) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01fc, code lost:
            if (r4 != null) goto L_0x0204;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ff, code lost:
            r5 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0200, code lost:
            r4 = kotlin.collections.CollectionsKt__CollectionsKt.k();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0206, code lost:
            if ((r4 instanceof java.util.Collection) == false) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x020c, code lost:
            if (r4.isEmpty() == false) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x020f, code lost:
            r1 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0217, code lost:
            if (r1.hasNext() == false) goto L_0x0244;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0219, code lost:
            r3 = (com.sumsub.sns.internal.geo.presentation.a) r1.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0229, code lost:
            if (r3.g().q() != com.sumsub.sns.internal.core.data.model.FieldName.country) goto L_0x023f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x022b, code lost:
            r3 = r3.j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x022f, code lost:
            if (r3 == null) goto L_0x023a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0235, code lost:
            if (kotlin.text.StringsKt__StringsJVMKt.z(r3) == false) goto L_0x0238;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0238, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x023a, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x023b, code lost:
            if (r3 == false) goto L_0x023f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x023d, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x023f, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0240, code lost:
            if (r3 == false) goto L_0x0213;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0242, code lost:
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0244, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0245, code lost:
            if (r1 == false) goto L_0x0254;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0247, code lost:
            r0 = r5.f34818k;
            com.sumsub.sns.core.presentation.base.a.a(r0, false, new com.sumsub.sns.internal.geo.presentation.c.m.b(r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.m.b>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0253, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x025a, code lost:
            if (com.sumsub.sns.internal.geo.presentation.c.f(r5.f34818k) == false) goto L_0x0268;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x025c, code lost:
            r0 = r5.f34818k;
            com.sumsub.sns.core.presentation.base.a.a(r0, false, new com.sumsub.sns.internal.geo.presentation.c.m.C0399c(r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.c.m.C0399c>) null), 1, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0268, code lost:
            com.sumsub.sns.internal.geo.presentation.c.a(r5.f34818k, r2);
            r1 = com.sumsub.sns.internal.geo.presentation.c.b(r5.f34818k);
            r5.f34808a = r0;
            r5.f34809b = r4;
            r5.f34810c = null;
            r5.f34811d = null;
            r5.f34812e = null;
            r5.f34813f = null;
            r5.f34814g = null;
            r5.f34815h = null;
            r5.f34816i = 5;
            r1 = r1.a(false, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x028a, code lost:
            if (r1 != r9) goto L_0x028d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x028c, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x028d, code lost:
            r2 = r0;
            r0 = r1;
            r1 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0294, code lost:
            if (kotlin.Result.m3078isFailureimpl(r0) == false) goto L_0x0298;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0296, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0298, code lost:
            r3 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x029b, code lost:
            if (((com.sumsub.sns.internal.core.domain.e) r3) != null) goto L_0x02a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x029f, code lost:
            return kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x02a0, code lost:
            r3 = com.sumsub.sns.internal.geo.presentation.c.c(r5.f34818k);
            r5.f34808a = r2;
            r5.f34809b = r1;
            r5.f34810c = r0;
            r5.f34816i = 6;
            r3 = r3.a(false, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b3, code lost:
            if (r3 != r9) goto L_0x02b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b5, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b6, code lost:
            r16 = r1;
            r17 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x02ba, code lost:
            r1 = ((com.sumsub.sns.internal.core.data.model.e) r3).B();
            kotlin.k.b(r0);
            r2 = new com.sumsub.sns.internal.core.presentation.form.model.d(r1, (com.sumsub.sns.internal.core.domain.e) r0);
            r15 = new java.util.ArrayList();
            r0 = r16.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x02d7, code lost:
            if (r0.hasNext() == false) goto L_0x02f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x02d9, code lost:
            r1 = (com.sumsub.sns.internal.geo.presentation.a) r0.next();
            r3 = r17.u();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x02e3, code lost:
            if (r3 != null) goto L_0x02e9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r8 = r21
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r8.f34816i
                r10 = 1
                r11 = 0
                r12 = 0
                switch(r0) {
                    case 0: goto L_0x00b7;
                    case 1: goto L_0x00b1;
                    case 2: goto L_0x00a1;
                    case 3: goto L_0x0074;
                    case 4: goto L_0x0048;
                    case 5: goto L_0x002c;
                    case 6: goto L_0x0016;
                    default: goto L_0x000e;
                }
            L_0x000e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0016:
                java.lang.Object r0 = r8.f34810c
                java.lang.Object r1 = r8.f34809b
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r2 = r8.f34808a
                com.sumsub.sns.internal.core.data.model.e r2 = (com.sumsub.sns.internal.core.data.model.e) r2
                kotlin.k.b(r22)
                r3 = r22
                r16 = r1
                r17 = r2
                r5 = r8
                goto L_0x02ba
            L_0x002c:
                java.lang.Object r0 = r8.f34809b
                java.util.List r0 = (java.util.List) r0
                java.lang.Object r1 = r8.f34808a
                com.sumsub.sns.internal.core.data.model.e r1 = (com.sumsub.sns.internal.core.data.model.e) r1
                kotlin.k.b(r22)
                r2 = r22
                kotlin.Result r2 = (kotlin.Result) r2
                java.lang.Object r2 = r2.m3081unboximpl()
                r5 = r8
                r19 = r1
                r1 = r0
                r0 = r2
                r2 = r19
                goto L_0x0290
            L_0x0048:
                java.lang.Object r0 = r8.f34815h
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r8.f34814g
                com.sumsub.sns.internal.core.data.model.h$d r1 = (com.sumsub.sns.internal.core.data.model.h.d) r1
                java.lang.Object r2 = r8.f34813f
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r8.f34812e
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r8.f34811d
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r8.f34810c
                com.sumsub.sns.internal.geo.presentation.c r5 = (com.sumsub.sns.internal.geo.presentation.c) r5
                java.lang.Object r6 = r8.f34809b
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r7 = r8.f34808a
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
                kotlin.k.b(r22)
                r16 = r0
                r14 = r1
                r15 = r2
                r0 = r8
                r2 = r22
                goto L_0x01dc
            L_0x0074:
                java.lang.Object r0 = r8.f34815h
                com.sumsub.sns.internal.core.data.model.h$d r0 = (com.sumsub.sns.internal.core.data.model.h.d) r0
                java.lang.Object r1 = r8.f34814g
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r8.f34813f
                com.sumsub.sns.internal.core.data.model.FieldName r2 = (com.sumsub.sns.internal.core.data.model.FieldName) r2
                java.lang.Object r3 = r8.f34812e
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r8.f34811d
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r8.f34810c
                com.sumsub.sns.internal.geo.presentation.c r5 = (com.sumsub.sns.internal.geo.presentation.c) r5
                java.lang.Object r6 = r8.f34809b
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r7 = r8.f34808a
                com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7
                kotlin.k.b(r22)
                r14 = r22
                r13 = r9
                r9 = r7
                r7 = r6
                r6 = r1
                r1 = r0
                r0 = r8
                goto L_0x01a9
            L_0x00a1:
                java.lang.Object r0 = r8.f34808a
                com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0
                kotlin.k.b(r22)
                r1 = r22
                kotlin.Result r1 = (kotlin.Result) r1
                java.lang.Object r1 = r1.m3081unboximpl()
                goto L_0x0124
            L_0x00b1:
                kotlin.k.b(r22)
                r0 = r22
                goto L_0x00f4
            L_0x00b7:
                kotlin.k.b(r22)
                com.sumsub.sns.internal.geo.a r2 = com.sumsub.sns.internal.geo.a.f34682a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "got location: "
                r0.append(r1)
                android.location.Location r1 = r8.f34817j
                r0.append(r1)
                java.lang.String r4 = r0.toString()
                r5 = 0
                r6 = 4
                r7 = 0
                java.lang.String r3 = "SumSubGeo"
                com.sumsub.sns.internal.geo.a.a(r2, r3, r4, r5, r6, r7)
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                com.sumsub.sns.internal.geo.presentation.c$m$a r1 = new com.sumsub.sns.internal.geo.presentation.c$m$a
                r1.<init>(r12)
                com.sumsub.sns.core.presentation.base.a.a(r0, r11, r1, r10, r12)
                android.location.Location r0 = r8.f34817j
                if (r0 == 0) goto L_0x0348
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.M
                r8.f34816i = r10
                java.lang.Object r0 = r0.a((boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r8)
                if (r0 != r9) goto L_0x00f4
                return r9
            L_0x00f4:
                r13 = r0
                com.sumsub.sns.internal.core.data.model.e r13 = (com.sumsub.sns.internal.core.data.model.e) r13
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                com.sumsub.sns.internal.geo.domain.b r0 = r0.N
                com.sumsub.sns.internal.geo.presentation.c r1 = r8.f34818k
                java.lang.String r1 = r1.f()
                android.location.Location r2 = r8.f34817j
                double r2 = r2.getLatitude()
                android.location.Location r4 = r8.f34817j
                double r4 = r4.getLongitude()
                android.location.Location r6 = r8.f34817j
                float r6 = r6.getAccuracy()
                r8.f34808a = r13
                r7 = 2
                r8.f34816i = r7
                r7 = r21
                java.lang.Object r1 = r0.a(r1, r2, r4, r6, r7)
                if (r1 != r9) goto L_0x0123
                return r9
            L_0x0123:
                r0 = r13
            L_0x0124:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                boolean r3 = kotlin.Result.m3079isSuccessimpl(r1)
                if (r3 == 0) goto L_0x0302
                boolean r3 = kotlin.Result.m3078isFailureimpl(r1)
                if (r3 == 0) goto L_0x0136
                r1 = r12
            L_0x0136:
                java.util.List r1 = (java.util.List) r1
                if (r1 == 0) goto L_0x01ff
                com.sumsub.sns.internal.geo.presentation.c r3 = r8.f34818k
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Iterator r1 = r1.iterator()
                r5 = r8
            L_0x0146:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L_0x01fa
                java.lang.Object r6 = r1.next()
                com.sumsub.sns.internal.geo.model.a r6 = (com.sumsub.sns.internal.geo.model.a) r6
                r2.add(r6)
                com.sumsub.sns.internal.core.data.model.h$d r7 = r6.c()
                boolean r13 = r7 instanceof com.sumsub.sns.internal.core.data.model.h.d
                if (r13 == 0) goto L_0x015e
                goto L_0x015f
            L_0x015e:
                r7 = r12
            L_0x015f:
                if (r7 == 0) goto L_0x01ec
                com.sumsub.sns.internal.core.data.model.FieldName r7 = r7.q()
                if (r7 != 0) goto L_0x0169
                goto L_0x01ec
            L_0x0169:
                com.sumsub.sns.internal.core.data.model.h$d r13 = r6.c()
                java.lang.String r6 = r6.d()
                kotlin.jvm.internal.d0 r14 = kotlin.jvm.internal.d0.f56774a
                java.lang.Object[] r14 = new java.lang.Object[r10]
                r14[r11] = r7
                java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r10)
                java.lang.String r15 = "sns_data_field_%s"
                java.lang.String r14 = java.lang.String.format(r15, r14)
                r5.f34808a = r0
                r5.f34809b = r2
                r5.f34810c = r3
                r5.f34811d = r4
                r5.f34812e = r1
                r5.f34813f = r7
                r5.f34814g = r6
                r5.f34815h = r13
                r15 = 3
                r5.f34816i = r15
                java.lang.Object r14 = r3.a((java.lang.String) r14, (kotlin.coroutines.c<? super java.lang.String>) r5)
                if (r14 != r9) goto L_0x019b
                return r9
            L_0x019b:
                r19 = r9
                r9 = r0
                r0 = r5
                r5 = r3
                r3 = r1
                r1 = r13
                r13 = r19
                r20 = r7
                r7 = r2
                r2 = r20
            L_0x01a9:
                java.lang.CharSequence r14 = (java.lang.CharSequence) r14
                kotlin.jvm.internal.d0 r15 = kotlin.jvm.internal.d0.f56774a
                java.lang.Object[] r15 = new java.lang.Object[r10]
                r15[r11] = r2
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r15, r10)
                java.lang.String r15 = "sns_data_field_%s_placeholder"
                java.lang.String r2 = java.lang.String.format(r15, r2)
                r0.f34808a = r9
                r0.f34809b = r7
                r0.f34810c = r5
                r0.f34811d = r4
                r0.f34812e = r3
                r0.f34813f = r6
                r0.f34814g = r1
                r0.f34815h = r14
                r15 = 4
                r0.f34816i = r15
                java.lang.Object r2 = r5.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r2 != r13) goto L_0x01d5
                return r13
            L_0x01d5:
                r15 = r6
                r6 = r7
                r7 = r9
                r9 = r13
                r16 = r14
                r14 = r1
            L_0x01dc:
                r17 = r2
                java.lang.CharSequence r17 = (java.lang.CharSequence) r17
                com.sumsub.sns.internal.geo.presentation.a r1 = new com.sumsub.sns.internal.geo.presentation.a
                r18 = 0
                r13 = r1
                r13.<init>(r14, r15, r16, r17, r18)
                r2 = r6
                r6 = r0
                r0 = r7
                goto L_0x01f0
            L_0x01ec:
                r6 = r5
                r5 = r3
                r3 = r1
                r1 = r12
            L_0x01f0:
                if (r1 == 0) goto L_0x01f5
                r4.add(r1)
            L_0x01f5:
                r1 = r3
                r3 = r5
                r5 = r6
                goto L_0x0146
            L_0x01fa:
                java.util.List r4 = (java.util.List) r4
                if (r4 != 0) goto L_0x0204
                goto L_0x0200
            L_0x01ff:
                r5 = r8
            L_0x0200:
                java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x0204:
                boolean r1 = r4 instanceof java.util.Collection
                if (r1 == 0) goto L_0x020f
                boolean r1 = r4.isEmpty()
                if (r1 == 0) goto L_0x020f
                goto L_0x0244
            L_0x020f:
                java.util.Iterator r1 = r4.iterator()
            L_0x0213:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0244
                java.lang.Object r3 = r1.next()
                com.sumsub.sns.internal.geo.presentation.a r3 = (com.sumsub.sns.internal.geo.presentation.a) r3
                com.sumsub.sns.internal.core.data.model.h$d r6 = r3.g()
                com.sumsub.sns.internal.core.data.model.FieldName r6 = r6.q()
                com.sumsub.sns.internal.core.data.model.FieldName r7 = com.sumsub.sns.internal.core.data.model.FieldName.country
                if (r6 != r7) goto L_0x023f
                java.lang.CharSequence r3 = r3.j()
                if (r3 == 0) goto L_0x023a
                boolean r3 = kotlin.text.StringsKt__StringsJVMKt.z(r3)
                if (r3 == 0) goto L_0x0238
                goto L_0x023a
            L_0x0238:
                r3 = r11
                goto L_0x023b
            L_0x023a:
                r3 = r10
            L_0x023b:
                if (r3 == 0) goto L_0x023f
                r3 = r10
                goto L_0x0240
            L_0x023f:
                r3 = r11
            L_0x0240:
                if (r3 == 0) goto L_0x0213
                r1 = r10
                goto L_0x0245
            L_0x0244:
                r1 = r11
            L_0x0245:
                if (r1 == 0) goto L_0x0254
                com.sumsub.sns.internal.geo.presentation.c r0 = r5.f34818k
                com.sumsub.sns.internal.geo.presentation.c$m$b r1 = new com.sumsub.sns.internal.geo.presentation.c$m$b
                r1.<init>(r0, r12)
                com.sumsub.sns.core.presentation.base.a.a(r0, r11, r1, r10, r12)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x0254:
                com.sumsub.sns.internal.geo.presentation.c r1 = r5.f34818k
                boolean r1 = r1.P
                if (r1 == 0) goto L_0x0268
                com.sumsub.sns.internal.geo.presentation.c r0 = r5.f34818k
                com.sumsub.sns.internal.geo.presentation.c$m$c r1 = new com.sumsub.sns.internal.geo.presentation.c$m$c
                r1.<init>(r0, r12)
                com.sumsub.sns.core.presentation.base.a.a(r0, r11, r1, r10, r12)
                goto L_0x034d
            L_0x0268:
                com.sumsub.sns.internal.geo.presentation.c r1 = r5.f34818k
                r1.a((java.util.List<com.sumsub.sns.internal.geo.model.a>) r2)
                com.sumsub.sns.internal.geo.presentation.c r1 = r5.f34818k
                com.sumsub.sns.internal.core.domain.d r1 = r1.Q
                r5.f34808a = r0
                r5.f34809b = r4
                r5.f34810c = r12
                r5.f34811d = r12
                r5.f34812e = r12
                r5.f34813f = r12
                r5.f34814g = r12
                r5.f34815h = r12
                r2 = 5
                r5.f34816i = r2
                java.lang.Object r1 = r1.a(r11, r5)
                if (r1 != r9) goto L_0x028d
                return r9
            L_0x028d:
                r2 = r0
                r0 = r1
                r1 = r4
            L_0x0290:
                boolean r3 = kotlin.Result.m3078isFailureimpl(r0)
                if (r3 == 0) goto L_0x0298
                r3 = r12
                goto L_0x0299
            L_0x0298:
                r3 = r0
            L_0x0299:
                com.sumsub.sns.internal.core.domain.e r3 = (com.sumsub.sns.internal.core.domain.e) r3
                if (r3 != 0) goto L_0x02a0
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x02a0:
                com.sumsub.sns.internal.geo.presentation.c r3 = r5.f34818k
                com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r3.M
                r5.f34808a = r2
                r5.f34809b = r1
                r5.f34810c = r0
                r4 = 6
                r5.f34816i = r4
                java.lang.Object r3 = r3.a((boolean) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r5)
                if (r3 != r9) goto L_0x02b6
                return r9
            L_0x02b6:
                r16 = r1
                r17 = r2
            L_0x02ba:
                com.sumsub.sns.internal.core.data.model.e r3 = (com.sumsub.sns.internal.core.data.model.e) r3
                java.util.Map r1 = r3.B()
                kotlin.k.b(r0)
                com.sumsub.sns.internal.core.domain.e r0 = (com.sumsub.sns.internal.core.domain.e) r0
                com.sumsub.sns.internal.core.presentation.form.model.d r2 = new com.sumsub.sns.internal.core.presentation.form.model.d
                r2.<init>(r1, r0)
                java.util.ArrayList r15 = new java.util.ArrayList
                r15.<init>()
                java.util.Iterator r0 = r16.iterator()
            L_0x02d3:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x02f3
                java.lang.Object r1 = r0.next()
                com.sumsub.sns.internal.geo.presentation.a r1 = (com.sumsub.sns.internal.geo.presentation.a) r1
                java.util.Map r3 = r17.u()
                if (r3 != 0) goto L_0x02e9
                java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.h()
            L_0x02e9:
                com.sumsub.sns.internal.core.presentation.form.model.FormItem r1 = com.sumsub.sns.internal.geo.presentation.b.a(r1, r2, r3)
                if (r1 == 0) goto L_0x02d3
                r15.add(r1)
                goto L_0x02d3
            L_0x02f3:
                com.sumsub.sns.internal.geo.presentation.c r0 = r5.f34818k
                com.sumsub.sns.internal.geo.presentation.c$m$d r1 = new com.sumsub.sns.internal.geo.presentation.c$m$d
                r18 = 0
                r13 = r1
                r14 = r0
                r13.<init>(r14, r15, r16, r17, r18)
                com.sumsub.sns.core.presentation.base.a.a(r0, r11, r1, r10, r12)
                goto L_0x034d
            L_0x0302:
                java.lang.Throwable r0 = kotlin.Result.m3075exceptionOrNullimpl(r1)
                boolean r2 = r0 instanceof com.sumsub.sns.core.data.model.SNSException.Api
                if (r2 == 0) goto L_0x030d
                com.sumsub.sns.core.data.model.SNSException$Api r0 = (com.sumsub.sns.core.data.model.SNSException.Api) r0
                goto L_0x030e
            L_0x030d:
                r0 = r12
            L_0x030e:
                if (r0 == 0) goto L_0x0321
                java.lang.Integer r0 = r0.getErrorCode()
                r2 = 9001(0x2329, float:1.2613E-41)
                if (r0 != 0) goto L_0x0319
                goto L_0x0321
            L_0x0319:
                int r0 = r0.intValue()
                if (r0 != r2) goto L_0x0321
                r0 = r10
                goto L_0x0322
            L_0x0321:
                r0 = r11
            L_0x0322:
                if (r0 == 0) goto L_0x0331
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                com.sumsub.sns.internal.geo.presentation.c$m$e r1 = new com.sumsub.sns.internal.geo.presentation.c$m$e
                r1.<init>(r0, r12)
                com.sumsub.sns.core.presentation.base.a.a(r0, r11, r1, r10, r12)
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            L_0x0331:
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                java.lang.Throwable r1 = kotlin.Result.m3075exceptionOrNullimpl(r1)
                r2 = r1
                java.lang.Exception r2 = (java.lang.Exception) r2
                com.sumsub.sns.internal.geo.presentation.c r1 = r8.f34818k
                java.lang.String r3 = r1.f()
                r4 = 0
                r5 = 4
                r6 = 0
                r1 = r0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r1, (java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.Object) r4, (int) r5, (java.lang.Object) r6)
                goto L_0x034d
            L_0x0348:
                com.sumsub.sns.internal.geo.presentation.c r0 = r8.f34818k
                r0.u()
            L_0x034d:
                kotlin.Unit r0 = kotlin.Unit.f56620a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public c(SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.geo.domain.b bVar2, com.sumsub.sns.internal.geo.domain.c cVar, boolean z11, com.sumsub.sns.internal.core.domain.d dVar, Document document) {
        super(aVar, bVar);
        this.M = bVar;
        this.N = bVar2;
        this.O = cVar;
        this.P = z11;
        this.Q = dVar;
        this.R = document;
        this.U = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "addressDataCache", CollectionsKt__CollectionsKt.k());
        this.W = k1.a(new b.a(0, CollectionsKt__CollectionsKt.k(), (String) null, new b.c((String) null, (String) null, 3, (r) null)));
        a((List<com.sumsub.sns.internal.geo.model.a>) CollectionsKt__CollectionsKt.k());
        b0.b(j(), m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
    }

    public /* synthetic */ void a(Context context, FieldId fieldId, List list) {
        com.sumsub.sns.internal.core.presentation.form.e.a(this, context, fieldId, list);
    }

    public /* synthetic */ void a(FormItem formItem, String str) {
        com.sumsub.sns.internal.core.presentation.form.e.b(this, formItem, str);
    }

    public /* synthetic */ void a(FormItem formItem, List list) {
        com.sumsub.sns.internal.core.presentation.form.e.c(this, formItem, list);
    }

    public final List<com.sumsub.sns.internal.geo.model.a> p() {
        return (List) this.U.a(this, f34728r[0]);
    }

    /* renamed from: q */
    public e.c e() {
        return e.c.f34854e;
    }

    public final Document r() {
        return this.R;
    }

    public final String[] s() {
        return this.T;
    }

    public final void t() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g(this, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
    }

    public final void u() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new h(this, (kotlin.coroutines.c<? super h>) null), 1, (Object) null);
    }

    public final void v() {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new j(this, (kotlin.coroutines.c<? super j>) null), 3, (Object) null);
    }

    public final void w() {
        com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "sendAddressData: " + p(), (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new k(this, (kotlin.coroutines.c<? super k>) null), 3, (Object) null);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        this.V++;
        o.a(com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(Action.Geolocation).l().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("attempt", kotlin.coroutines.jvm.internal.a.c(this.V)), kotlin.l.a(H, kotlin.coroutines.jvm.internal.a.a(false))}), false, 1, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new i(this, (kotlin.coroutines.c<? super i>) null), 1, (Object) null);
        return Unit.f56620a;
    }

    public String f() {
        return this.R.getType().c();
    }

    public j1<b.a> b() {
        return this.W;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0107 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.e.b> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.geo.presentation.c.C0397c
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.geo.presentation.c$c r0 = (com.sumsub.sns.internal.geo.presentation.c.C0397c) r0
            int r1 = r0.f34747h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34747h = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.geo.presentation.c$c r0 = new com.sumsub.sns.internal.geo.presentation.c$c
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f34745f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34747h
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x009a
            if (r2 == r7) goto L_0x0092
            if (r2 == r6) goto L_0x0086
            if (r2 == r5) goto L_0x0074
            if (r2 == r4) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            java.lang.Object r1 = r0.f34744e
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.f34743d
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.f34742c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.f34741b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r0 = r0.f34740a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.k.b(r12)
            r5 = r1
            r1 = r0
            r9 = r3
            r3 = r2
            r2 = r4
            r4 = r9
            goto L_0x012a
        L_0x0050:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0058:
            java.lang.Object r2 = r0.f34744e
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f34743d
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.f34742c
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.f34741b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.f34740a
            com.sumsub.sns.internal.geo.presentation.c r7 = (com.sumsub.sns.internal.geo.presentation.c) r7
            kotlin.k.b(r12)
            r9 = r6
            r6 = r5
            r5 = r9
            goto L_0x010e
        L_0x0074:
            java.lang.Object r2 = r0.f34742c
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.f34741b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.f34740a
            com.sumsub.sns.internal.geo.presentation.c r6 = (com.sumsub.sns.internal.geo.presentation.c) r6
            kotlin.k.b(r12)
            r7 = r6
            goto L_0x00eb
        L_0x0086:
            java.lang.Object r2 = r0.f34741b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.f34740a
            com.sumsub.sns.internal.geo.presentation.c r6 = (com.sumsub.sns.internal.geo.presentation.c) r6
            kotlin.k.b(r12)
            goto L_0x00d3
        L_0x0092:
            java.lang.Object r2 = r0.f34740a
            com.sumsub.sns.internal.geo.presentation.c r2 = (com.sumsub.sns.internal.geo.presentation.c) r2
            kotlin.k.b(r12)
            goto L_0x00be
        L_0x009a:
            kotlin.k.b(r12)
            kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r12 = new java.lang.Object[r7]
            java.lang.String r2 = r11.f()
            r8 = 0
            r12[r8] = r2
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r7)
            java.lang.String r2 = "sns_step_%s_title"
            java.lang.String r12 = java.lang.String.format(r2, r12)
            r0.f34740a = r11
            r0.f34747h = r7
            java.lang.Object r12 = r11.a((java.lang.String) r12, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r12 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            r2 = r11
        L_0x00be:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34740a = r2
            r0.f34741b = r12
            r0.f34747h = r6
            java.lang.String r6 = "sns_geolocation_detection_description"
            java.lang.Object r6 = r2.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r6 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            r9 = r2
            r2 = r12
            r12 = r6
            r6 = r9
        L_0x00d3:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34740a = r6
            r0.f34741b = r2
            r0.f34742c = r12
            r0.f34747h = r5
            java.lang.String r5 = "sns_geolocation_detection_cameraFallback"
            java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x00e6
            return r1
        L_0x00e6:
            r7 = r6
            r9 = r2
            r2 = r12
            r12 = r5
            r5 = r9
        L_0x00eb:
            java.lang.String r12 = (java.lang.String) r12
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r6 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.LOCATION_ON
            java.lang.String r6 = r6.getImageName()
            r0.f34740a = r7
            r0.f34741b = r5
            r0.f34742c = r2
            r0.f34743d = r12
            r0.f34744e = r6
            r0.f34747h = r4
            java.lang.String r4 = "sns_geolocation_action_allowAccess"
            java.lang.Object r4 = r7.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x0108
            return r1
        L_0x0108:
            r9 = r4
            r4 = r12
            r12 = r9
            r10 = r6
            r6 = r2
            r2 = r10
        L_0x010e:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34740a = r5
            r0.f34741b = r6
            r0.f34742c = r4
            r0.f34743d = r2
            r0.f34744e = r12
            r0.f34747h = r3
            java.lang.String r3 = "sns_geolocation_action_uploadDocument"
            java.lang.Object r0 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x0125
            return r1
        L_0x0125:
            r3 = r2
            r1 = r5
            r2 = r6
            r5 = r12
            r12 = r0
        L_0x012a:
            r6 = r12
            java.lang.String r6 = (java.lang.String) r6
            com.sumsub.sns.internal.geo.presentation.e$b r12 = new com.sumsub.sns.internal.geo.presentation.e$b
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0107 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super com.sumsub.sns.internal.geo.presentation.e.f> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.geo.presentation.c.l
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.geo.presentation.c$l r0 = (com.sumsub.sns.internal.geo.presentation.c.l) r0
            int r1 = r0.f34807h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34807h = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.geo.presentation.c$l r0 = new com.sumsub.sns.internal.geo.presentation.c$l
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f34805f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34807h
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x009a
            if (r2 == r7) goto L_0x0092
            if (r2 == r6) goto L_0x0086
            if (r2 == r5) goto L_0x0074
            if (r2 == r4) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            java.lang.Object r1 = r0.f34804e
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.f34803d
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r0.f34802c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.f34801b
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r0 = r0.f34800a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.k.b(r12)
            r5 = r1
            r1 = r0
            r9 = r3
            r3 = r2
            r2 = r4
            r4 = r9
            goto L_0x012a
        L_0x0050:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0058:
            java.lang.Object r2 = r0.f34804e
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f34803d
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.f34802c
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.f34801b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.f34800a
            com.sumsub.sns.internal.geo.presentation.c r7 = (com.sumsub.sns.internal.geo.presentation.c) r7
            kotlin.k.b(r12)
            r9 = r6
            r6 = r5
            r5 = r9
            goto L_0x010e
        L_0x0074:
            java.lang.Object r2 = r0.f34802c
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.f34801b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.f34800a
            com.sumsub.sns.internal.geo.presentation.c r6 = (com.sumsub.sns.internal.geo.presentation.c) r6
            kotlin.k.b(r12)
            r7 = r6
            goto L_0x00eb
        L_0x0086:
            java.lang.Object r2 = r0.f34801b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.f34800a
            com.sumsub.sns.internal.geo.presentation.c r6 = (com.sumsub.sns.internal.geo.presentation.c) r6
            kotlin.k.b(r12)
            goto L_0x00d3
        L_0x0092:
            java.lang.Object r2 = r0.f34800a
            com.sumsub.sns.internal.geo.presentation.c r2 = (com.sumsub.sns.internal.geo.presentation.c) r2
            kotlin.k.b(r12)
            goto L_0x00be
        L_0x009a:
            kotlin.k.b(r12)
            kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r12 = new java.lang.Object[r7]
            java.lang.String r2 = r11.f()
            r8 = 0
            r12[r8] = r2
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r7)
            java.lang.String r2 = "sns_step_%s_title"
            java.lang.String r12 = java.lang.String.format(r2, r12)
            r0.f34800a = r11
            r0.f34807h = r7
            java.lang.Object r12 = r11.a((java.lang.String) r12, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r12 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            r2 = r11
        L_0x00be:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34800a = r2
            r0.f34801b = r12
            r0.f34807h = r6
            java.lang.String r6 = "sns_geolocation_detection_blocked"
            java.lang.Object r6 = r2.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r6 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            r9 = r2
            r2 = r12
            r12 = r6
            r6 = r9
        L_0x00d3:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34800a = r6
            r0.f34801b = r2
            r0.f34802c = r12
            r0.f34807h = r5
            java.lang.String r5 = "sns_geolocation_detection_cameraFallback"
            java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x00e6
            return r1
        L_0x00e6:
            r7 = r6
            r9 = r2
            r2 = r12
            r12 = r5
            r5 = r9
        L_0x00eb:
            java.lang.String r12 = (java.lang.String) r12
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r6 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.LOCATION_OFF
            java.lang.String r6 = r6.getImageName()
            r0.f34800a = r7
            r0.f34801b = r5
            r0.f34802c = r2
            r0.f34803d = r12
            r0.f34804e = r6
            r0.f34807h = r4
            java.lang.String r4 = "sns_geolocation_action_tryAgain"
            java.lang.Object r4 = r7.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r4 != r1) goto L_0x0108
            return r1
        L_0x0108:
            r9 = r4
            r4 = r12
            r12 = r9
            r10 = r6
            r6 = r2
            r2 = r10
        L_0x010e:
            java.lang.String r12 = (java.lang.String) r12
            r0.f34800a = r5
            r0.f34801b = r6
            r0.f34802c = r4
            r0.f34803d = r2
            r0.f34804e = r12
            r0.f34807h = r3
            java.lang.String r3 = "sns_geolocation_action_uploadDocument"
            java.lang.Object r0 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x0125
            return r1
        L_0x0125:
            r3 = r2
            r1 = r5
            r2 = r6
            r5 = r12
            r12 = r0
        L_0x012a:
            r6 = r12
            java.lang.String r6 = (java.lang.String) r6
            com.sumsub.sns.internal.geo.presentation.e$f r12 = new com.sumsub.sns.internal.geo.presentation.e$f
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.presentation.c.f(kotlin.coroutines.c):java.lang.Object");
    }

    public void b(FormItem formItem, String str) {
        ArrayList arrayList = new ArrayList(p());
        Iterator it2 = arrayList.iterator();
        int i11 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i11 = -1;
                break;
            }
            FieldName q11 = ((com.sumsub.sns.internal.geo.model.a) it2.next()).c().q();
            if (x.b(q11 != null ? q11.getValue() : null, formItem.d().p())) {
                break;
            }
            i11++;
        }
        if (i11 >= 0) {
            h.d c11 = ((com.sumsub.sns.internal.geo.model.a) arrayList.get(i11)).c();
            if (str == null) {
                str = "";
            }
            arrayList.set(i11, new com.sumsub.sns.internal.geo.model.a(c11, str));
            a((List<com.sumsub.sns.internal.geo.model.a>) arrayList);
        }
    }

    public com.sumsub.sns.internal.core.presentation.form.d a() {
        return this.S;
    }

    public final void a(List<com.sumsub.sns.internal.geo.model.a> list) {
        this.U.a(this, f34728r[0], list);
    }

    public final void a(Map<String, Boolean> map) {
        com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "handlePermissionResults: " + map, (Throwable) null, 4, (Object) null);
        Boolean bool = map.get("android.permission.ACCESS_COARSE_LOCATION");
        Boolean bool2 = Boolean.TRUE;
        if (x.b(bool, bool2) || x.b(map.get("android.permission.ACCESS_FINE_LOCATION"), bool2)) {
            com.sumsub.sns.core.presentation.base.a.a(this, false, new e((kotlin.coroutines.c<? super e>) null), 1, (Object) null);
            return;
        }
        o.a(com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(Action.Geolocation).d().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("attempt", Integer.valueOf(this.V)), kotlin.l.a(H, Boolean.FALSE)}), false, 1, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new d(this, (kotlin.coroutines.c<? super d>) null), 1, (Object) null);
    }

    public final void a(Location location) {
        String str;
        com.sumsub.sns.internal.geo.a aVar = com.sumsub.sns.internal.geo.a.f34682a;
        com.sumsub.sns.internal.geo.a.a(aVar, com.sumsub.sns.internal.geo.a.f34683b, "sendLocation: " + location, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.analytics.j e11 = com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(Action.Geolocation).e();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = kotlin.l.a("attempt", Integer.valueOf(this.V));
        pairArr[1] = kotlin.l.a(H, Boolean.TRUE);
        if (location == null || (str = Float.valueOf(location.getAccuracy()).toString()) == null) {
            str = "N/A";
        }
        pairArr[2] = kotlin.l.a(I, str);
        pairArr[3] = kotlin.l.a(J, String.valueOf(location != null ? Boolean.valueOf(com.sumsub.sns.internal.geo.domain.a.a(location)) : null));
        o.a(e11.a((Pair<String, ? extends Object>[]) pairArr), false, 1, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new m(location, this, (kotlin.coroutines.c<? super m>) null), 3, (Object) null);
    }

    public final void a(int i11) {
        if (i11 == 0) {
            a((a.j) a.f.f30841a);
        } else {
            a((a.j) a.g.f30845a);
        }
    }
}
