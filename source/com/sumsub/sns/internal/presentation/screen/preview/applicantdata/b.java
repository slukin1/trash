package com.sumsub.sns.internal.presentation.screen.preview.applicantdata;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.a1;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.presentation.screen.preview.a;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
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
import kotlin.jvm.internal.Lambda;
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

public final class b extends com.sumsub.sns.internal.presentation.screen.preview.a<d> implements com.sumsub.sns.internal.core.presentation.form.b {
    public static final /* synthetic */ kotlin.reflect.l<Object>[] K = {Reflection.e(new MutablePropertyReference1Impl(b.class, "fieldValueCache", "getFieldValueCache()Ljava/util/Map;", 0))};
    public final com.sumsub.sns.internal.domain.m D;
    public final a1 E;
    public com.sumsub.sns.internal.domain.c F;
    public final boolean G = com.sumsub.sns.internal.ff.a.f34215a.b().g();
    public final b1<b.a> H = k1.a(new b.a(0, CollectionsKt__CollectionsKt.k(), (String) null, new b.c((String) null, (String) null, 3, (r) null)));
    public final com.sumsub.sns.internal.core.presentation.form.d I = new f(this);
    public final com.sumsub.sns.internal.core.presentation.screen.base.a J;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<d, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35304a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35305b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35306c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f35306c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f35306c, cVar);
            aVar.f35305b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35304a == 0) {
                kotlin.k.b(obj);
                d dVar = (d) this.f35305b;
                b1 j11 = this.f35306c.H;
                CharSequence p11 = dVar.p();
                String obj2 = p11 != null ? p11.toString() : null;
                CharSequence o11 = dVar.o();
                j11.setValue(new b.a(0, CollectionsKt__CollectionsJVMKt.e(new b.C0375b(0, obj2, o11 != null ? o11.toString() : null, dVar.l())), (String) null, new b.c((String) null, (String) null, 3, (r) null)));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$b  reason: collision with other inner class name */
    public static final class C0426b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f35307a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35308b;

        public C0426b(CharSequence charSequence, CharSequence charSequence2) {
            this.f35307a = charSequence;
            this.f35308b = charSequence2;
        }

        public final CharSequence a() {
            return this.f35307a;
        }

        public final CharSequence b() {
            return this.f35308b;
        }

        public final CharSequence c() {
            return this.f35307a;
        }

        public final CharSequence d() {
            return this.f35308b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0426b)) {
                return false;
            }
            C0426b bVar = (C0426b) obj;
            return x.b(this.f35307a, bVar.f35307a) && x.b(this.f35308b, bVar.f35308b);
        }

        public int hashCode() {
            CharSequence charSequence = this.f35307a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f35308b;
            if (charSequence2 != null) {
                i11 = charSequence2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "ErrorEvent(message=" + this.f35307a + ", positiveButton=" + this.f35308b + ')';
        }

        public final C0426b a(CharSequence charSequence, CharSequence charSequence2) {
            return new C0426b(charSequence, charSequence2);
        }

        public static /* synthetic */ C0426b a(C0426b bVar, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = bVar.f35307a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = bVar.f35308b;
            }
            return bVar.a(charSequence, charSequence2);
        }
    }

    public static final class c extends a.c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f35309a = new c();
    }

    public static final class d extends a.d {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.domain.c f35310a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.sumsub.sns.internal.domain.b> f35311b;

        /* renamed from: c  reason: collision with root package name */
        public final List<FormItem> f35312c;

        /* renamed from: d  reason: collision with root package name */
        public final String f35313d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f35314e;

        /* renamed from: f  reason: collision with root package name */
        public final CharSequence f35315f;

        /* renamed from: g  reason: collision with root package name */
        public final CharSequence f35316g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f35317h;

        public d() {
            this((com.sumsub.sns.internal.domain.c) null, (List) null, (List) null, (String) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 255, (r) null);
        }

        public final com.sumsub.sns.internal.domain.c a() {
            return this.f35310a;
        }

        public final List<com.sumsub.sns.internal.domain.b> b() {
            return this.f35311b;
        }

        public final List<FormItem> c() {
            return this.f35312c;
        }

        public final String d() {
            return this.f35313d;
        }

        public final CharSequence e() {
            return this.f35314e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f35310a, dVar.f35310a) && x.b(this.f35311b, dVar.f35311b) && x.b(this.f35312c, dVar.f35312c) && x.b(this.f35313d, dVar.f35313d) && x.b(this.f35314e, dVar.f35314e) && x.b(this.f35315f, dVar.f35315f) && x.b(this.f35316g, dVar.f35316g) && this.f35317h == dVar.f35317h;
        }

        public final CharSequence f() {
            return this.f35315f;
        }

        public final CharSequence g() {
            return this.f35316g;
        }

        public final boolean h() {
            return this.f35317h;
        }

        public int hashCode() {
            int hashCode = ((((this.f35310a.hashCode() * 31) + this.f35311b.hashCode()) * 31) + this.f35312c.hashCode()) * 31;
            String str = this.f35313d;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            CharSequence charSequence = this.f35314e;
            int hashCode3 = (hashCode2 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f35315f;
            int hashCode4 = (hashCode3 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35316g;
            if (charSequence3 != null) {
                i11 = charSequence3.hashCode();
            }
            int i12 = (hashCode4 + i11) * 31;
            boolean z11 = this.f35317h;
            if (z11) {
                z11 = true;
            }
            return i12 + (z11 ? 1 : 0);
        }

        public final CharSequence i() {
            return this.f35316g;
        }

        public final String j() {
            return this.f35313d;
        }

        public final List<com.sumsub.sns.internal.domain.b> k() {
            return this.f35311b;
        }

        public final List<FormItem> l() {
            return this.f35312c;
        }

        public final com.sumsub.sns.internal.domain.c m() {
            return this.f35310a;
        }

        public final boolean n() {
            return this.f35317h;
        }

        public final CharSequence o() {
            return this.f35315f;
        }

        public final CharSequence p() {
            return this.f35314e;
        }

        public String toString() {
            return "ViewState(resources=" + this.f35310a + ", errors=" + this.f35311b + ", formItems=" + this.f35312c + ", currentCountry=" + this.f35313d + ", title=" + this.f35314e + ", subtitle=" + this.f35315f + ", buttonContinue=" + this.f35316g + ", showContent=" + this.f35317h + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ d(com.sumsub.sns.internal.domain.c r11, java.util.List r12, java.util.List r13, java.lang.String r14, java.lang.CharSequence r15, java.lang.CharSequence r16, java.lang.CharSequence r17, boolean r18, int r19, kotlin.jvm.internal.r r20) {
            /*
                r10 = this;
                r0 = r19
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0015
                com.sumsub.sns.internal.domain.c r1 = new com.sumsub.sns.internal.domain.c
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 31
                r9 = 0
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                goto L_0x0016
            L_0x0015:
                r1 = r11
            L_0x0016:
                r2 = r0 & 2
                if (r2 == 0) goto L_0x001f
                java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                goto L_0x0020
            L_0x001f:
                r2 = r12
            L_0x0020:
                r3 = r0 & 4
                if (r3 == 0) goto L_0x0029
                java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                goto L_0x002a
            L_0x0029:
                r3 = r13
            L_0x002a:
                r4 = r0 & 8
                r5 = 0
                if (r4 == 0) goto L_0x0031
                r4 = r5
                goto L_0x0032
            L_0x0031:
                r4 = r14
            L_0x0032:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0038
                r6 = r5
                goto L_0x0039
            L_0x0038:
                r6 = r15
            L_0x0039:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x003f
                r7 = r5
                goto L_0x0041
            L_0x003f:
                r7 = r16
            L_0x0041:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0046
                goto L_0x0048
            L_0x0046:
                r5 = r17
            L_0x0048:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x004e
                r0 = 0
                goto L_0x0050
            L_0x004e:
                r0 = r18
            L_0x0050:
                r11 = r10
                r12 = r1
                r13 = r2
                r14 = r3
                r15 = r4
                r16 = r6
                r17 = r7
                r18 = r5
                r19 = r0
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d.<init>(com.sumsub.sns.internal.domain.c, java.util.List, java.util.List, java.lang.String, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, boolean, int, kotlin.jvm.internal.r):void");
        }

        public final d a(com.sumsub.sns.internal.domain.c cVar, List<com.sumsub.sns.internal.domain.b> list, List<? extends FormItem> list2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z11) {
            return new d(cVar, list, list2, str, charSequence, charSequence2, charSequence3, z11);
        }

        public static /* synthetic */ d a(d dVar, com.sumsub.sns.internal.domain.c cVar, List list, List list2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z11, int i11, Object obj) {
            d dVar2 = dVar;
            int i12 = i11;
            return dVar.a((i12 & 1) != 0 ? dVar2.f35310a : cVar, (i12 & 2) != 0 ? dVar2.f35311b : list, (i12 & 4) != 0 ? dVar2.f35312c : list2, (i12 & 8) != 0 ? dVar2.f35313d : str, (i12 & 16) != 0 ? dVar2.f35314e : charSequence, (i12 & 32) != 0 ? dVar2.f35315f : charSequence2, (i12 & 64) != 0 ? dVar2.f35316g : charSequence3, (i12 & 128) != 0 ? dVar2.f35317h : z11);
        }

        public d(com.sumsub.sns.internal.domain.c cVar, List<com.sumsub.sns.internal.domain.b> list, List<? extends FormItem> list2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z11) {
            this.f35310a = cVar;
            this.f35311b = list;
            this.f35312c = list2;
            this.f35313d = str;
            this.f35314e = charSequence;
            this.f35315f = charSequence2;
            this.f35316g = charSequence3;
            this.f35317h = z11;
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35318a;

        static {
            int[] iArr = new int[FieldName.values().length];
            iArr[FieldName.countryOfBirth.ordinal()] = 1;
            iArr[FieldName.country.ordinal()] = 2;
            iArr[FieldName.taxResidenceCountry.ordinal()] = 3;
            iArr[FieldName.stateOfBirth.ordinal()] = 4;
            iArr[FieldName.state.ordinal()] = 5;
            iArr[FieldName.firstName.ordinal()] = 6;
            iArr[FieldName.lastName.ordinal()] = 7;
            iArr[FieldName.middleName.ordinal()] = 8;
            iArr[FieldName.tin.ordinal()] = 9;
            iArr[FieldName.phone.ordinal()] = 10;
            iArr[FieldName.placeOfBirth.ordinal()] = 11;
            iArr[FieldName.legalName.ordinal()] = 12;
            iArr[FieldName.gender.ordinal()] = 13;
            iArr[FieldName.nationality.ordinal()] = 14;
            iArr[FieldName.dob.ordinal()] = 15;
            iArr[FieldName.email.ordinal()] = 16;
            iArr[FieldName.buildingNumber.ordinal()] = 17;
            iArr[FieldName.flatNumber.ordinal()] = 18;
            iArr[FieldName.postCode.ordinal()] = 19;
            iArr[FieldName.street.ordinal()] = 20;
            iArr[FieldName.subStreet.ordinal()] = 21;
            iArr[FieldName.town.ordinal()] = 22;
            f35318a = iArr;
        }
    }

    public static final class f implements com.sumsub.sns.internal.core.presentation.form.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35319a;

        public f(b bVar) {
            this.f35319a = bVar;
        }

        public String a(String str, String str2) {
            return (String) this.f35319a.C().get(str2);
        }

        public /* synthetic */ List b(String str, String str2) {
            return com.sumsub.sns.internal.core.presentation.form.f.a(this, str, str2);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onDataLoaded$3", f = "SNSApplicantDataDocumentViewModel.kt", l = {219}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35321b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b bVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f35321b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f35321b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35320a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                this.f35321b.D();
                b bVar = this.f35321b;
                this.f35320a = 1;
                if (bVar.a((List<com.sumsub.sns.internal.domain.b>) null, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f35321b.c(true);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onFieldValueChanged$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {164}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f35323b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(b bVar, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f35323b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new h(this.f35323b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35322a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b bVar = this.f35323b;
                this.f35322a = 1;
                if (bVar.a((List<com.sumsub.sns.internal.domain.b>) null, (kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onPrepare$2", f = "SNSApplicantDataDocumentViewModel.kt", l = {131, 132, 133}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35324a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35325b;

        /* renamed from: c  reason: collision with root package name */
        public int f35326c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f35327d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f35328e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f35328e = bVar;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((i) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            i iVar = new i(this.f35328e, cVar);
            iVar.f35327d = obj;
            return iVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r12.f35326c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0040
                if (r1 == r4) goto L_0x0038
                if (r1 == r3) goto L_0x002c
                if (r1 != r2) goto L_0x0024
                java.lang.Object r0 = r12.f35325b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r12.f35324a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r12.f35327d
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d r2 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d) r2
                kotlin.k.b(r13)
                r6 = r0
                r5 = r1
                r0 = r2
                goto L_0x0087
            L_0x0024:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x002c:
                java.lang.Object r1 = r12.f35324a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r12.f35327d
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d r3 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d) r3
                kotlin.k.b(r13)
                goto L_0x006e
            L_0x0038:
                java.lang.Object r1 = r12.f35327d
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d r1 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d) r1
                kotlin.k.b(r13)
                goto L_0x0057
            L_0x0040:
                kotlin.k.b(r13)
                java.lang.Object r13 = r12.f35327d
                r1 = r13
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d r1 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d) r1
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r13 = r12.f35328e
                r12.f35327d = r1
                r12.f35326c = r4
                java.lang.String r4 = "sns_step_APPLICANT_DATA_title"
                java.lang.Object r13 = r13.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r12)
                if (r13 != r0) goto L_0x0057
                return r0
            L_0x0057:
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r4 = r12.f35328e
                r12.f35327d = r1
                r12.f35324a = r13
                r12.f35326c = r3
                java.lang.String r3 = "sns_step_APPLICANT_DATA_prompt"
                java.lang.Object r3 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r12)
                if (r3 != r0) goto L_0x006a
                return r0
            L_0x006a:
                r11 = r1
                r1 = r13
                r13 = r3
                r3 = r11
            L_0x006e:
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r4 = r12.f35328e
                r12.f35327d = r3
                r12.f35324a = r1
                r12.f35325b = r13
                r12.f35326c = r2
                java.lang.String r2 = "sns_data_action_submit"
                java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r12)
                if (r2 != r0) goto L_0x0083
                return r0
            L_0x0083:
                r6 = r13
                r5 = r1
                r13 = r2
                r0 = r3
            L_0x0087:
                r7 = r13
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r1 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r8 = 0
                r9 = 143(0x8f, float:2.0E-43)
                r10 = 0
                com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$d r13 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onSubmitClick$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {371}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35329a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35331c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onSubmitClick$1$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {372, 413, 479}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.l<kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f35332a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f35333b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ h0 f35334c;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$onSubmitClick$1$1$2", f = "SNSApplicantDataDocumentViewModel.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$a  reason: collision with other inner class name */
            public static final class C0427a extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f35335a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ Object f35336b;

                public C0427a(kotlin.coroutines.c<? super C0427a> cVar) {
                    super(2, cVar);
                }

                /* renamed from: a */
                public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
                    return ((C0427a) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    C0427a aVar = new C0427a(cVar);
                    aVar.f35336b = obj;
                    return aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f35335a == 0) {
                        kotlin.k.b(obj);
                        return d.a((d) this.f35336b, (com.sumsub.sns.internal.domain.c) null, CollectionsKt__CollectionsKt.k(), (List) null, (String) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, (Object) null);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$b  reason: collision with other inner class name */
            public static final class C0428b extends Lambda implements d10.l<h.d, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35337a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0428b(b bVar) {
                    super(1);
                    this.f35337a = bVar;
                }

                /* renamed from: a */
                public final Boolean invoke(h.d dVar) {
                    Map e11 = this.f35337a.C();
                    FieldName q11 = dVar.q();
                    CharSequence charSequence = (CharSequence) e11.get(q11 != null ? q11.getValue() : null);
                    return Boolean.valueOf(!(charSequence == null || charSequence.length() == 0));
                }
            }

            public static final class c extends Lambda implements d10.l<h.d, Pair<? extends String, ? extends String>> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35338a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public c(b bVar) {
                    super(1);
                    this.f35338a = bVar;
                }

                /* renamed from: a */
                public final Pair<String, String> invoke(h.d dVar) {
                    String str;
                    FieldName q11 = dVar.q();
                    String str2 = "";
                    if (q11 == null || (str = q11.getValue()) == null) {
                        str = str2;
                    }
                    Map e11 = this.f35338a.C();
                    FieldName q12 = dVar.q();
                    String str3 = (String) e11.get(q12 != null ? q12.getValue() : null);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return kotlin.l.a(str, str2);
                }
            }

            public static final class d extends Lambda implements d10.l<h.d, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35339a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public d(b bVar) {
                    super(1);
                    this.f35339a = bVar;
                }

                /* renamed from: a */
                public final Boolean invoke(h.d dVar) {
                    Map e11 = this.f35339a.C();
                    FieldName q11 = dVar.q();
                    CharSequence charSequence = (CharSequence) e11.get(q11 != null ? q11.getValue() : null);
                    boolean z11 = false;
                    if (!(charSequence == null || charSequence.length() == 0) && dVar.w()) {
                        z11 = true;
                    }
                    return Boolean.valueOf(z11);
                }
            }

            public static final class e extends Lambda implements d10.l<h.d, Pair<? extends String, ? extends String>> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35340a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public e(b bVar) {
                    super(1);
                    this.f35340a = bVar;
                }

                /* renamed from: a */
                public final Pair<String, String> invoke(h.d dVar) {
                    String str;
                    FieldName q11 = dVar.q();
                    String str2 = "";
                    if (q11 == null || (str = q11.getValue()) == null) {
                        str = str2;
                    }
                    Map e11 = this.f35340a.C();
                    FieldName q12 = dVar.q();
                    String str3 = (String) e11.get(q12 != null ? q12.getValue() : null);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return kotlin.l.a(str, str2);
                }
            }

            public static final class f extends Lambda implements d10.l<h.c, com.sumsub.sns.internal.core.data.model.remote.e> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35341a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public f(b bVar) {
                    super(1);
                    this.f35341a = bVar;
                }

                /* renamed from: a */
                public final com.sumsub.sns.internal.core.data.model.remote.e invoke(h.c cVar) {
                    String i11 = cVar.i();
                    String str = "";
                    if (i11 == null) {
                        i11 = str;
                    }
                    String str2 = (String) this.f35341a.C().get(cVar.i());
                    if (str2 != null) {
                        str = str2;
                    }
                    return new com.sumsub.sns.internal.core.data.model.remote.e(i11, str);
                }
            }

            public static final class g extends Lambda implements d10.l<h.d, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35342a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.sumsub.sns.internal.core.data.model.g f35343b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public g(b bVar, com.sumsub.sns.internal.core.data.model.g gVar) {
                    super(1);
                    this.f35342a = bVar;
                    this.f35343b = gVar;
                }

                /* renamed from: a */
                public final Boolean invoke(h.d dVar) {
                    b bVar = this.f35342a;
                    com.sumsub.sns.internal.core.data.model.g gVar = this.f35343b;
                    Map e11 = bVar.C();
                    FieldName q11 = dVar.q();
                    String str = (String) e11.get(q11 != null ? q11.getValue() : null);
                    if (str == null) {
                        str = "";
                    }
                    return Boolean.valueOf(bVar.a((com.sumsub.sns.internal.core.data.model.h) dVar, gVar, str));
                }
            }

            public static final class h extends Lambda implements d10.l<h.d, String> {

                /* renamed from: a  reason: collision with root package name */
                public static final h f35344a = new h();

                public h() {
                    super(1);
                }

                /* renamed from: a */
                public final String invoke(h.d dVar) {
                    FieldName q11 = dVar.q();
                    if (q11 != null) {
                        return q11.getValue();
                    }
                    return null;
                }
            }

            public static final class i extends Lambda implements d10.l<h.d, Boolean> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35345a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.sumsub.sns.internal.core.data.model.g f35346b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public i(b bVar, com.sumsub.sns.internal.core.data.model.g gVar) {
                    super(1);
                    this.f35345a = bVar;
                    this.f35346b = gVar;
                }

                /* renamed from: a */
                public final Boolean invoke(h.d dVar) {
                    b bVar = this.f35345a;
                    com.sumsub.sns.internal.core.data.model.g gVar = this.f35346b;
                    Map e11 = bVar.C();
                    FieldName q11 = dVar.q();
                    String str = (String) e11.get(q11 != null ? q11.getValue() : null);
                    if (str == null) {
                        str = "";
                    }
                    return Boolean.valueOf(bVar.b(dVar, gVar, str));
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$j  reason: collision with other inner class name */
            public static final class C0429j extends Lambda implements d10.l<h.d, String> {

                /* renamed from: a  reason: collision with root package name */
                public static final C0429j f35347a = new C0429j();

                public C0429j() {
                    super(1);
                }

                /* renamed from: a */
                public final String invoke(h.d dVar) {
                    FieldName q11 = dVar.q();
                    if (q11 != null) {
                        return q11.getValue();
                    }
                    return null;
                }
            }

            public static final class k extends Lambda implements d10.l<String, String> {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35348a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public k(b bVar) {
                    super(1);
                    this.f35348a = bVar;
                }

                /* renamed from: a */
                public final String invoke(String str) {
                    String str2 = (String) this.f35348a.C().get(str);
                    return str2 == null ? "" : str2;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, h0 h0Var, kotlin.coroutines.c<? super a> cVar) {
                super(1, cVar);
                this.f35333b = bVar;
                this.f35334c = h0Var;
            }

            /* renamed from: a */
            public final Object invoke(kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(kotlin.coroutines.c<?> cVar) {
                return new a(this.f35333b, this.f35334c, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:96:0x02d2  */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x02e4  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r21) {
                /*
                    r20 = this;
                    r6 = r20
                    java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r0 = r6.f35332a
                    r8 = 3
                    r9 = 2
                    r10 = 0
                    r11 = 0
                    r12 = 1
                    if (r0 == 0) goto L_0x002f
                    if (r0 == r12) goto L_0x0029
                    if (r0 == r9) goto L_0x0024
                    if (r0 != r8) goto L_0x001c
                    kotlin.k.b(r21)
                    r0 = r21
                    goto L_0x02cc
                L_0x001c:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L_0x0024:
                    kotlin.k.b(r21)
                    goto L_0x016d
                L_0x0029:
                    kotlin.k.b(r21)
                    r0 = r21
                    goto L_0x0047
                L_0x002f:
                    kotlin.k.b(r21)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r0 = r6.f35333b
                    com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r0.t()
                    r6.f35332a = r12
                    r1 = 0
                    r2 = 0
                    r4 = 3
                    r5 = 0
                    r3 = r20
                    java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r0, r1, r2, r3, r4, r5)
                    if (r0 != r7) goto L_0x0047
                    return r7
                L_0x0047:
                    com.sumsub.sns.internal.core.data.source.dynamic.e r0 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r0
                    java.lang.Object r0 = r0.d()
                    com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
                    if (r0 != 0) goto L_0x0062
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r0 = r6.f35333b
                    java.lang.Exception r1 = new java.lang.Exception
                    java.lang.String r2 = "No applicant"
                    r1.<init>(r2)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$c r2 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.c.f35309a
                    r0.a((java.lang.Throwable) r1, (java.lang.Object) r2)
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                L_0x0062:
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r1 = r6.f35333b
                    com.sumsub.sns.internal.core.data.model.Document r1 = r1.u()
                    com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.getType()
                    com.sumsub.sns.internal.core.data.model.g$c$a r1 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.d.b(r0, r1)
                    if (r1 != 0) goto L_0x0075
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                L_0x0075:
                    java.util.List r2 = r1.l()
                    if (r2 != 0) goto L_0x007f
                    java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                L_0x007f:
                    java.util.List r1 = r1.k()
                    if (r1 != 0) goto L_0x0089
                    java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                L_0x0089:
                    java.util.ArrayList r3 = new java.util.ArrayList
                    r3.<init>()
                    r3.addAll(r2)
                    r3.addAll(r1)
                    java.util.List r3 = com.sumsub.sns.internal.core.common.i.a(r3)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$k r4 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$k
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r5 = r6.f35333b
                    r4.<init>(r5)
                    java.util.Iterator r5 = r3.iterator()
                L_0x00a3:
                    boolean r13 = r5.hasNext()
                    if (r13 == 0) goto L_0x00c4
                    java.lang.Object r13 = r5.next()
                    r14 = r13
                    com.sumsub.sns.internal.core.data.model.h r14 = (com.sumsub.sns.internal.core.data.model.h) r14
                    boolean r15 = r14 instanceof com.sumsub.sns.internal.core.data.model.h.d
                    if (r15 == 0) goto L_0x00c0
                    com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
                    com.sumsub.sns.internal.core.data.model.FieldName r14 = r14.q()
                    com.sumsub.sns.internal.core.data.model.FieldName r15 = com.sumsub.sns.internal.core.data.model.FieldName.phone
                    if (r14 != r15) goto L_0x00c0
                    r14 = r12
                    goto L_0x00c1
                L_0x00c0:
                    r14 = r10
                L_0x00c1:
                    if (r14 == 0) goto L_0x00a3
                    goto L_0x00c5
                L_0x00c4:
                    r13 = r11
                L_0x00c5:
                    com.sumsub.sns.internal.core.data.model.h r13 = (com.sumsub.sns.internal.core.data.model.h) r13
                    java.lang.String r5 = ""
                    if (r13 == 0) goto L_0x00e9
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r14 = r6.f35333b
                    java.util.Map r14 = r14.C()
                    java.lang.String r13 = r13.b()
                    java.lang.Object r13 = r14.get(r13)
                    java.lang.String r13 = (java.lang.String) r13
                    if (r13 != 0) goto L_0x00de
                    r13 = r5
                L_0x00de:
                    boolean r13 = com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a((java.lang.String) r13)
                    java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.a.a(r13)
                    r18 = r13
                    goto L_0x00eb
                L_0x00e9:
                    r18 = r11
                L_0x00eb:
                    kotlin.sequences.g r13 = kotlin.collections.CollectionsKt___CollectionsKt.P(r3)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r3 = r6.f35333b
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r14 = r3.h()
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r3 = r6.f35333b
                    com.sumsub.sns.internal.core.common.a1 r15 = r3.E
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r3 = r6.f35333b
                    com.sumsub.sns.internal.domain.c r16 = r3.F
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r3 = r6.f35333b
                    boolean r17 = r3.G
                    r19 = r4
                    java.util.List r3 = com.sumsub.sns.internal.presentation.utils.b.a(r13, r14, r15, r16, r17, r18, r19)
                    if (r3 == 0) goto L_0x0170
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r0 = r6.f35333b
                    com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "submitApplicantData: errors="
                    r1.append(r2)
                    int r2 = r3.size()
                    r1.append(r2)
                    java.lang.String r12 = r1.toString()
                    r13 = 0
                    r14 = 4
                    r15 = 0
                    java.lang.String r11 = "AppData"
                    com.sumsub.log.logger.a.d(r10, r11, r12, r13, r14, r15)
                    java.util.Iterator r1 = r3.iterator()
                L_0x0134:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x0164
                    java.lang.Object r2 = r1.next()
                    com.sumsub.sns.internal.domain.b r2 = (com.sumsub.sns.internal.domain.b) r2
                    com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "submitApplicantData: invalid field value="
                    r4.append(r5)
                    com.sumsub.sns.internal.core.data.model.h r2 = r2.c()
                    java.lang.String r2 = r2.b()
                    r4.append(r2)
                    java.lang.String r12 = r4.toString()
                    r13 = 0
                    r14 = 4
                    r15 = 0
                    java.lang.String r11 = "AppData"
                    com.sumsub.log.logger.a.d(r10, r11, r12, r13, r14, r15)
                    goto L_0x0134
                L_0x0164:
                    r6.f35332a = r9
                    java.lang.Object r0 = r0.a((java.util.List<com.sumsub.sns.internal.domain.b>) r3, (kotlin.coroutines.c<? super kotlin.Unit>) r6)
                    if (r0 != r7) goto L_0x016d
                    return r7
                L_0x016d:
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                L_0x0170:
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r3 = r6.f35333b
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$a r4 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$a
                    r4.<init>(r11)
                    com.sumsub.sns.core.presentation.base.a.a(r3, r10, r4, r12, r11)
                    java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
                    r3.<init>()
                    kotlin.sequences.g r4 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$b r9 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$b
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r13 = r6.f35333b
                    r9.<init>(r13)
                    kotlin.sequences.g r4 = kotlin.sequences.SequencesKt___SequencesKt.k(r4, r9)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$c r9 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$c
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r13 = r6.f35333b
                    r9.<init>(r13)
                    kotlin.sequences.g r4 = kotlin.sequences.SequencesKt___SequencesKt.s(r4, r9)
                    java.util.Map unused = kotlin.collections.MapsKt__MapsKt.v(r4, r3)
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>()
                    kotlin.sequences.g r9 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$d r13 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$d
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r14 = r6.f35333b
                    r13.<init>(r14)
                    kotlin.sequences.g r9 = kotlin.sequences.SequencesKt___SequencesKt.k(r9, r13)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$e r13 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$e
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r14 = r6.f35333b
                    r13.<init>(r14)
                    kotlin.sequences.g r9 = kotlin.sequences.SequencesKt___SequencesKt.s(r9, r13)
                    java.util.Map unused = kotlin.collections.MapsKt__MapsKt.v(r9, r4)
                    kotlin.sequences.g r9 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$i r13 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$i
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r14 = r6.f35333b
                    r13.<init>(r14, r0)
                    kotlin.sequences.g r9 = kotlin.sequences.SequencesKt___SequencesKt.k(r9, r13)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$j r13 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.j.a.C0429j.f35347a
                    kotlin.sequences.g r9 = kotlin.sequences.SequencesKt___SequencesKt.s(r9, r13)
                    kotlin.sequences.g r9 = kotlin.sequences.SequencesKt___SequencesKt.m(r9)
                    java.util.List r9 = kotlin.sequences.SequencesKt___SequencesKt.w(r9)
                    boolean r13 = r9.isEmpty()
                    r13 = r13 ^ r12
                    if (r13 == 0) goto L_0x01e3
                    goto L_0x01e4
                L_0x01e3:
                    r9 = r11
                L_0x01e4:
                    kotlin.sequences.g r13 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$g r14 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$g
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r15 = r6.f35333b
                    r14.<init>(r15, r0)
                    kotlin.sequences.g r0 = kotlin.sequences.SequencesKt___SequencesKt.k(r13, r14)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$h r13 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.j.a.h.f35344a
                    kotlin.sequences.g r0 = kotlin.sequences.SequencesKt___SequencesKt.s(r0, r13)
                    kotlin.sequences.g r0 = kotlin.sequences.SequencesKt___SequencesKt.m(r0)
                    java.util.List r0 = kotlin.sequences.SequencesKt___SequencesKt.w(r0)
                    boolean r13 = r0.isEmpty()
                    r13 = r13 ^ r12
                    if (r13 == 0) goto L_0x0209
                    goto L_0x020a
                L_0x0209:
                    r0 = r11
                L_0x020a:
                    boolean r13 = r4.isEmpty()
                    r13 = r13 ^ r12
                    if (r13 == 0) goto L_0x0263
                    java.util.Iterator r2 = r2.iterator()
                L_0x0215:
                    boolean r13 = r2.hasNext()
                    if (r13 == 0) goto L_0x0230
                    java.lang.Object r13 = r2.next()
                    r14 = r13
                    com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
                    com.sumsub.sns.internal.core.data.model.FieldName r14 = r14.q()
                    com.sumsub.sns.internal.core.data.model.FieldName r15 = com.sumsub.sns.internal.core.data.model.FieldName.country
                    if (r14 != r15) goto L_0x022c
                    r14 = r12
                    goto L_0x022d
                L_0x022c:
                    r14 = r10
                L_0x022d:
                    if (r14 == 0) goto L_0x0215
                    goto L_0x0231
                L_0x0230:
                    r13 = r11
                L_0x0231:
                    com.sumsub.sns.internal.core.data.model.h$d r13 = (com.sumsub.sns.internal.core.data.model.h.d) r13
                    if (r13 == 0) goto L_0x025a
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r2 = r6.f35333b
                    com.sumsub.sns.internal.core.data.model.FieldName r14 = com.sumsub.sns.internal.core.data.model.FieldName.country
                    java.lang.String r14 = r14.getValue()
                    java.util.Map r2 = r2.C()
                    com.sumsub.sns.internal.core.data.model.FieldName r13 = r13.q()
                    if (r13 == 0) goto L_0x024c
                    java.lang.String r13 = r13.getValue()
                    goto L_0x024d
                L_0x024c:
                    r13 = r11
                L_0x024d:
                    java.lang.Object r2 = r2.get(r13)
                    java.lang.String r2 = (java.lang.String) r2
                    if (r2 != 0) goto L_0x0256
                    goto L_0x0257
                L_0x0256:
                    r5 = r2
                L_0x0257:
                    r4.put(r14, r5)
                L_0x025a:
                    java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r4)
                    java.lang.String r4 = "addresses"
                    r3.put(r4, r2)
                L_0x0263:
                    kotlin.sequences.g r1 = kotlin.collections.CollectionsKt___CollectionsKt.P(r1)
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$f r2 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$j$a$f
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r4 = r6.f35333b
                    r2.<init>(r4)
                    kotlin.sequences.g r1 = kotlin.sequences.SequencesKt___SequencesKt.s(r1, r2)
                    java.util.List r1 = kotlin.sequences.SequencesKt___SequencesKt.w(r1)
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Set r4 = r3.keySet()
                    r2.addAll(r4)
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r5 = 10
                    int r5 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r5)
                    r4.<init>(r5)
                    java.util.Iterator r5 = r1.iterator()
                L_0x0291:
                    boolean r13 = r5.hasNext()
                    if (r13 == 0) goto L_0x02a5
                    java.lang.Object r13 = r5.next()
                    com.sumsub.sns.internal.core.data.model.remote.e r13 = (com.sumsub.sns.internal.core.data.model.remote.e) r13
                    java.lang.String r13 = r13.c()
                    r4.add(r13)
                    goto L_0x0291
                L_0x02a5:
                    r2.addAll(r4)
                    com.sumsub.sns.internal.core.common.e0 r4 = com.sumsub.sns.internal.core.common.e0.f32018a
                    com.sumsub.sns.core.data.listener.SNSEventHandler r4 = r4.getEventHandler()
                    if (r4 == 0) goto L_0x02b8
                    com.sumsub.sns.core.data.listener.SNSEvent$ApplicantDataUpdated r5 = new com.sumsub.sns.core.data.listener.SNSEvent$ApplicantDataUpdated
                    r5.<init>(r2)
                    r4.onEvent(r5)
                L_0x02b8:
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r2 = r6.f35333b
                    com.sumsub.sns.internal.domain.m r2 = r2.D
                    com.sumsub.sns.internal.domain.m$a r4 = new com.sumsub.sns.internal.domain.m$a
                    r4.<init>(r3, r9, r1, r0)
                    r6.f35332a = r8
                    java.lang.Object r0 = r2.a(r4, r6)
                    if (r0 != r7) goto L_0x02cc
                    return r7
                L_0x02cc:
                    com.sumsub.sns.internal.core.domain.model.a r0 = (com.sumsub.sns.internal.core.domain.model.a) r0
                    boolean r1 = r0 instanceof com.sumsub.sns.internal.core.domain.model.a.b
                    if (r1 == 0) goto L_0x02e4
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r13 = r6.f35333b
                    com.sumsub.sns.internal.core.common.q$b r14 = new com.sumsub.sns.internal.core.common.q$b
                    r14.<init>(r10, r12, r11)
                    r15 = 0
                    r16 = 0
                    r17 = 6
                    r18 = 0
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r13, (com.sumsub.sns.internal.core.common.q) r14, (java.lang.Object) r15, (java.lang.Long) r16, (int) r17, (java.lang.Object) r18)
                    goto L_0x0305
                L_0x02e4:
                    boolean r1 = r0 instanceof com.sumsub.sns.internal.core.domain.model.a.C0372a
                    if (r1 == 0) goto L_0x0305
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r1 = r6.f35333b
                    com.sumsub.sns.internal.core.domain.model.a$a r0 = (com.sumsub.sns.internal.core.domain.model.a.C0372a) r0
                    java.lang.Object r0 = r0.d()
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r2 = r6.f35333b
                    com.sumsub.sns.internal.core.data.model.Document r2 = r2.u()
                    com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.getType()
                    java.lang.String r2 = r2.c()
                    com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$c r3 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.c.f35309a
                    r1.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.Object) r3)
                L_0x0305:
                    kotlin.Unit r0 = kotlin.Unit.f56620a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b bVar, kotlin.coroutines.c<? super j> cVar) {
            super(2, cVar);
            this.f35331c = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            j jVar = new j(this.f35331c, cVar);
            jVar.f35330b = obj;
            return jVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35329a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b bVar = this.f35331c;
                a aVar = new a(bVar, (h0) this.f35330b, (kotlin.coroutines.c<? super a>) null);
                this.f35329a = 1;
                if (bVar.a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) aVar, (kotlin.coroutines.c<? super Unit>) this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel", f = "SNSApplicantDataDocumentViewModel.kt", l = {321, 327, 334, 336}, m = "reloadFields")
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35349a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35350b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35351c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35352d;

        /* renamed from: e  reason: collision with root package name */
        public Object f35353e;

        /* renamed from: f  reason: collision with root package name */
        public Object f35354f;

        /* renamed from: g  reason: collision with root package name */
        public Object f35355g;

        /* renamed from: h  reason: collision with root package name */
        public Object f35356h;

        /* renamed from: i  reason: collision with root package name */
        public Object f35357i;

        /* renamed from: j  reason: collision with root package name */
        public Object f35358j;

        /* renamed from: k  reason: collision with root package name */
        public /* synthetic */ Object f35359k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ b f35360l;

        /* renamed from: m  reason: collision with root package name */
        public int f35361m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(b bVar, kotlin.coroutines.c<? super k> cVar) {
            super(cVar);
            this.f35360l = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35359k = obj;
            this.f35361m |= Integer.MIN_VALUE;
            return this.f35360l.a((List<com.sumsub.sns.internal.domain.b>) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$reloadFields$4", f = "SNSApplicantDataDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class l extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35362a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35363b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f35364c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List<FormItem> f35365d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b bVar, List<FormItem> list, kotlin.coroutines.c<? super l> cVar) {
            super(2, cVar);
            this.f35364c = bVar;
            this.f35365d = list;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((l) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            l lVar = new l(this.f35364c, this.f35365d, cVar);
            lVar.f35363b = obj;
            return lVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35362a == 0) {
                kotlin.k.b(obj);
                d dVar = (d) this.f35363b;
                com.sumsub.sns.internal.domain.c f11 = this.f35364c.F;
                return d.a(dVar, f11 == null ? new com.sumsub.sns.internal.domain.c((com.sumsub.sns.internal.core.data.model.g) null, (com.sumsub.sns.internal.core.data.model.e) null, (Map) null, (Map) null, (Map) null, 31, (r) null) : f11, (List) null, this.f35365d, this.f35364c.s(), (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 242, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class m extends Lambda implements d10.l<FieldName, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f35366a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Map<String, String> map) {
            super(1);
            this.f35366a = map;
        }

        /* renamed from: a */
        public final String invoke(FieldName fieldName) {
            return this.f35366a.get(fieldName.getValue());
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$resetCurrentFieldError$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35367a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35368b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem f35369c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(FormItem formItem, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f35369c = formItem;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((n) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            n nVar = new n(this.f35369c, cVar);
            nVar.f35368b = obj;
            return nVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35367a == 0) {
                kotlin.k.b(obj);
                d dVar = (d) this.f35368b;
                List<FormItem> l11 = dVar.l();
                FormItem formItem = this.f35369c;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(l11, 10));
                for (FormItem formItem2 : l11) {
                    FormItem formItem3 = x.b(com.sumsub.sns.internal.presentation.screen.questionnary.model.f.a(formItem2), com.sumsub.sns.internal.presentation.screen.questionnary.model.f.a(formItem)) ^ true ? formItem2 : null;
                    if (formItem3 == null) {
                        formItem3 = com.sumsub.sns.internal.core.presentation.form.model.e.a(formItem2, (CharSequence) null);
                    }
                    arrayList.add(formItem3);
                }
                return d.a(dVar, (com.sumsub.sns.internal.domain.c) null, (List) null, arrayList, (String) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 251, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.applicantdata.SNSApplicantDataDocumentViewModel$showContent$1", f = "SNSApplicantDataDocumentViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35370a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35371b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f35372c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(boolean z11, kotlin.coroutines.c<? super o> cVar) {
            super(2, cVar);
            this.f35372c = z11;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((o) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            o oVar = new o(this.f35372c, cVar);
            oVar.f35371b = obj;
            return oVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35370a == 0) {
                kotlin.k.b(obj);
                return d.a((d) this.f35371b, (com.sumsub.sns.internal.domain.c) null, (List) null, (List) null, (String) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, this.f35372c, 127, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public b(Document document, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.domain.m mVar, com.sumsub.sns.internal.core.domain.d dVar, a1 a1Var) {
        super(document, savedStateHandle, aVar, bVar, dVar);
        this.D = mVar;
        this.E = a1Var;
        this.J = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, "KEY_FIELD_CACHE", MapsKt__MapsKt.h());
        b0.b(j(), m0.a(this), new a(this, (kotlin.coroutines.c<? super a>) null));
    }

    /* renamed from: A */
    public d e() {
        return new d((com.sumsub.sns.internal.domain.c) null, (List) null, (List) null, (String) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, false, 255, (r) null);
    }

    public final g.c.a B() {
        com.sumsub.sns.internal.core.data.model.g g11;
        com.sumsub.sns.internal.domain.c cVar = this.F;
        if (cVar == null || (g11 = cVar.g()) == null) {
            return null;
        }
        return d.b(g11, u().getType());
    }

    public final Map<String, String> C() {
        return (Map) this.J.a(this, K[0]);
    }

    public final void D() {
        com.sumsub.sns.internal.core.data.model.g g11;
        com.sumsub.sns.internal.domain.c cVar = this.F;
        if (cVar != null && (g11 = cVar.g()) != null) {
            g.c.a B = B();
            if (B == null) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
                return;
            }
            List<h.d> l11 = B.l();
            if (l11 != null && C().isEmpty()) {
                Map y11 = MapsKt__MapsKt.y(C());
                for (h.d next : l11) {
                    String a11 = a(g11, next);
                    if (a11 != null) {
                        y11.put(next.b(), a11);
                    }
                }
                c((Map<String, String>) y11);
            }
        }
    }

    public final void E() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, a.f35303b, "submitApplicantData", (Throwable) null, 4, (Object) null);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new j(this, (kotlin.coroutines.c<? super j>) null), 3, (Object) null);
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

    public final void c(Map<String, String> map) {
        this.J.a(this, K[0], map);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new i(this, (kotlin.coroutines.c<? super i>) null), 1, (Object) null);
        m();
        return Unit.f56620a;
    }

    public j1<b.a> b() {
        return this.H;
    }

    public void c(boolean z11) {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new o(z11, (kotlin.coroutines.c<? super o>) null), 1, (Object) null);
    }

    public void b(FormItem formItem, String str) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.d(aVar, a.f35303b, "onFieldValueChanged: " + formItem.k() + " -> " + str, (Throwable) null, 4, (Object) null);
        Map<String, String> C = C();
        String p11 = formItem.d().p();
        if (p11 == null) {
            p11 = "";
        }
        c(com.sumsub.sns.internal.core.common.i.a(C, p11, str));
        int i11 = e.f35318a[FieldName.Companion.a(formItem.d().p()).ordinal()];
        boolean z11 = true;
        if (i11 == 1) {
            c(com.sumsub.sns.internal.core.common.i.a(C(), FieldName.stateOfBirth.getValue(), null));
        } else if (i11 == 2) {
            c(com.sumsub.sns.internal.core.common.i.a(C(), FieldName.state.getValue(), null));
        } else if (i11 != 3) {
            z11 = false;
        } else {
            c(com.sumsub.sns.internal.core.common.i.a(C(), FieldName.tin.getValue(), null));
        }
        if (z11) {
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new h(this, (kotlin.coroutines.c<? super h>) null), 3, (Object) null);
        } else {
            a(formItem);
        }
    }

    public com.sumsub.sns.internal.core.presentation.form.d a() {
        return this.I;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.core.presentation.form.model.FormItem r11) {
        /*
            r10 = this;
            kotlinx.coroutines.flow.b1<com.sumsub.sns.internal.core.presentation.form.b$a> r0 = r10.H
            java.lang.Object r0 = r0.getValue()
            com.sumsub.sns.internal.core.presentation.form.b$a r0 = (com.sumsub.sns.internal.core.presentation.form.b.a) r0
            com.sumsub.sns.internal.core.presentation.form.b$b r0 = r0.e()
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            java.util.List r0 = r0.f()
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0020
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0020
            goto L_0x0057
        L_0x0020:
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r0.next()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r1 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem) r1
            com.sumsub.sns.internal.core.presentation.form.FieldId r4 = com.sumsub.sns.internal.presentation.screen.questionnary.model.f.a((com.sumsub.sns.internal.core.presentation.form.model.FormItem) r1)
            com.sumsub.sns.internal.core.presentation.form.FieldId r5 = com.sumsub.sns.internal.presentation.screen.questionnary.model.f.a((com.sumsub.sns.internal.core.presentation.form.model.FormItem) r11)
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
            if (r4 == 0) goto L_0x0052
            java.lang.CharSequence r1 = r1.b()
            if (r1 == 0) goto L_0x004d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r1 = r3
            goto L_0x004e
        L_0x004d:
            r1 = r2
        L_0x004e:
            if (r1 != 0) goto L_0x0052
            r1 = r2
            goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            if (r1 == 0) goto L_0x0024
            r0 = r2
            goto L_0x0058
        L_0x0057:
            r0 = r3
        L_0x0058:
            if (r0 != 0) goto L_0x005b
            return
        L_0x005b:
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reseting field error: "
            r0.append(r1)
            com.sumsub.sns.internal.core.presentation.form.FieldId r1 = com.sumsub.sns.internal.presentation.screen.questionnary.model.f.a((com.sumsub.sns.internal.core.presentation.form.model.FormItem) r11)
            r0.append(r1)
            java.lang.String r6 = r0.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "AppData"
            com.sumsub.log.logger.a.d(r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$n r0 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$n
            r1 = 0
            r0.<init>(r11, r1)
            com.sumsub.sns.core.presentation.base.a.a(r10, r3, r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.a(com.sumsub.sns.internal.core.presentation.form.model.FormItem):void");
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        if (!(oVar instanceof o.e) || !(oVar.c() instanceof c)) {
            super.b(oVar);
        } else {
            E();
        }
    }

    public Object a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
        Map<String, String> map;
        Map<String, Map<String, String>> map2;
        Map<String, com.sumsub.sns.internal.core.data.model.remote.o> D2;
        if (!(eVar == null || (D2 = eVar.D()) == null)) {
            this.E.a(D2);
        }
        if (gVar == null) {
            com.sumsub.log.logger.a.b(com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA), com.sumsub.sns.internal.log.c.a(this), "onDataLoaded: applicant null!", (Throwable) null, 4, (Object) null);
            return Unit.f56620a;
        }
        Map<String, String> r11 = r();
        if (r11 == null) {
            r11 = MapsKt__MapsKt.h();
        }
        Map<String, String> map3 = r11;
        if (eVar == null || (map = com.sumsub.sns.internal.core.data.model.f.k(eVar)) == null) {
            map = MapsKt__MapsKt.h();
        }
        Map<String, String> map4 = map;
        if (eVar == null || (map2 = eVar.u()) == null) {
            map2 = MapsKt__MapsKt.h();
        }
        this.F = new com.sumsub.sns.internal.domain.c(gVar, eVar, map4, map3, map2);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g(this, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
        return Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.sumsub.sns.internal.core.data.model.h r4, com.sumsub.sns.internal.core.data.model.g r5, java.lang.String r6) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r0 == 0) goto L_0x0007
            com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
            goto L_0x0008
        L_0x0007:
            r4 = 0
        L_0x0008:
            r0 = 0
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            boolean r1 = r4.z()
            r2 = 1
            if (r1 == 0) goto L_0x0035
            int r6 = r6.length()
            if (r6 != 0) goto L_0x001b
            r6 = r2
            goto L_0x001c
        L_0x001b:
            r6 = r0
        L_0x001c:
            if (r6 == 0) goto L_0x0035
            java.lang.String r4 = r3.a((com.sumsub.sns.internal.core.data.model.g) r5, (com.sumsub.sns.internal.core.data.model.h.d) r4)
            if (r4 == 0) goto L_0x0031
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x002c
            r4 = r2
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            if (r4 != r2) goto L_0x0031
            r4 = r2
            goto L_0x0032
        L_0x0031:
            r4 = r0
        L_0x0032:
            if (r4 == 0) goto L_0x0035
            r0 = r2
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.b(com.sumsub.sns.internal.core.data.model.h, com.sumsub.sns.internal.core.data.model.g, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01f5, code lost:
        if (r12 == null) goto L_0x01f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x044f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x01d8 A[EDGE_INSN: B:236:0x01d8->B:79:0x01d8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0309 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01d5 A[LOOP:1: B:64:0x01a8->B:77:0x01d5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.List<com.sumsub.sns.internal.domain.b> r39, kotlin.coroutines.c<? super kotlin.Unit> r40) {
        /*
            r38 = this;
            r6 = r38
            r0 = r40
            boolean r1 = r0 instanceof com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.k
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$k r1 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.k) r1
            int r2 = r1.f35361m
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f35361m = r2
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$k r1 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$k
            r1.<init>(r6, r0)
        L_0x001c:
            java.lang.Object r0 = r1.f35359k
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r1.f35361m
            r4 = 3
            r5 = 2
            r7 = 4
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L_0x00f1
            if (r3 == r10) goto L_0x00cc
            if (r3 == r5) goto L_0x009a
            if (r3 == r4) goto L_0x006b
            if (r3 != r7) goto L_0x0063
            java.lang.Object r3 = r1.f35358j
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r11 = r1.f35357i
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.f35356h
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r1.f35355g
            com.sumsub.sns.internal.core.data.model.h$c r13 = (com.sumsub.sns.internal.core.data.model.h.c) r13
            java.lang.Object r14 = r1.f35354f
            java.util.Iterator r14 = (java.util.Iterator) r14
            java.lang.Object r15 = r1.f35353e
            java.util.Map r15 = (java.util.Map) r15
            java.lang.Object r4 = r1.f35352d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r1.f35351c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r7 = r1.f35350b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.f35349a
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r8 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b) r8
            kotlin.k.b(r0)
            r10 = r0
            r0 = 3
            r9 = 4
            goto L_0x0450
        L_0x0063:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x006b:
            java.lang.Object r3 = r1.f35358j
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r1.f35357i
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.f35356h
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r1.f35355g
            com.sumsub.sns.internal.core.data.model.h$c r7 = (com.sumsub.sns.internal.core.data.model.h.c) r7
            java.lang.Object r8 = r1.f35354f
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r11 = r1.f35353e
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Object r12 = r1.f35352d
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.f35351c
            com.sumsub.sns.internal.core.data.model.g r13 = (com.sumsub.sns.internal.core.data.model.g) r13
            java.lang.Object r14 = r1.f35350b
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r1.f35349a
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r15 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b) r15
            kotlin.k.b(r0)
            r9 = r0
            r0 = 3
            goto L_0x041b
        L_0x009a:
            java.lang.Object r3 = r1.f35357i
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r1.f35356h
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.f35355g
            com.sumsub.sns.internal.core.data.model.h$c r5 = (com.sumsub.sns.internal.core.data.model.h.c) r5
            java.lang.Object r7 = r1.f35354f
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r1.f35353e
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r11 = r1.f35352d
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.f35351c
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            java.lang.Object r13 = r1.f35350b
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r1.f35349a
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r14 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b) r14
            kotlin.k.b(r0)
            r15 = r8
            r8 = r14
            r9 = 2
            r14 = r7
            r7 = r13
            r13 = r5
            r5 = r12
            r12 = r4
            r4 = r11
            goto L_0x03dd
        L_0x00cc:
            java.lang.Object r3 = r1.f35356h
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r1.f35355g
            com.sumsub.sns.internal.core.data.model.h$c r4 = (com.sumsub.sns.internal.core.data.model.h.c) r4
            java.lang.Object r5 = r1.f35354f
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r7 = r1.f35353e
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r1.f35352d
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r11 = r1.f35351c
            com.sumsub.sns.internal.core.data.model.g r11 = (com.sumsub.sns.internal.core.data.model.g) r11
            java.lang.Object r12 = r1.f35350b
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.f35349a
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b r13 = (com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b) r13
            kotlin.k.b(r0)
            goto L_0x037f
        L_0x00f1:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.domain.c r0 = r6.F
            if (r0 == 0) goto L_0x04f5
            com.sumsub.sns.internal.core.data.model.g r0 = r0.g()
            if (r0 != 0) goto L_0x0100
            goto L_0x04f5
        L_0x0100:
            com.sumsub.sns.internal.core.data.model.g$c$a r3 = r38.B()
            if (r3 != 0) goto L_0x0118
            com.sumsub.sns.internal.core.common.q$b r1 = new com.sumsub.sns.internal.core.common.q$b
            r0 = 0
            r1.<init>(r0, r10, r9)
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r38
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (com.sumsub.sns.internal.core.common.q) r1, (java.lang.Object) r2, (java.lang.Long) r3, (int) r4, (java.lang.Object) r5)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x0118:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Map r5 = r38.C()
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.y(r5)
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$m r7 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$m
            r7.<init>(r5)
            java.util.List r8 = r3.l()
            if (r8 == 0) goto L_0x0323
            com.sumsub.sns.internal.ff.a r11 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r11 = r11.i()
            boolean r11 = r11.g()
            if (r11 == 0) goto L_0x0141
            java.util.Map r11 = r38.r()
            goto L_0x0145
        L_0x0141:
            java.util.Map r11 = r38.w()
        L_0x0145:
            java.util.Iterator r12 = r8.iterator()
        L_0x0149:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0164
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
            com.sumsub.sns.internal.core.data.model.FieldName r14 = r14.q()
            com.sumsub.sns.internal.core.data.model.FieldName r15 = com.sumsub.sns.internal.core.data.model.FieldName.country
            if (r14 != r15) goto L_0x0160
            r14 = r10
            goto L_0x0161
        L_0x0160:
            r14 = 0
        L_0x0161:
            if (r14 == 0) goto L_0x0149
            goto L_0x0165
        L_0x0164:
            r13 = r9
        L_0x0165:
            com.sumsub.sns.internal.core.data.model.h$d r13 = (com.sumsub.sns.internal.core.data.model.h.d) r13
            if (r13 == 0) goto L_0x01a4
            java.lang.String r12 = r38.s()
            if (r12 == 0) goto L_0x01a4
            java.util.Map r14 = r38.C()
            com.sumsub.sns.internal.core.data.model.FieldName r15 = r13.q()
            if (r15 == 0) goto L_0x017e
            java.lang.String r15 = r15.getValue()
            goto L_0x017f
        L_0x017e:
            r15 = r9
        L_0x017f:
            java.lang.Object r14 = r14.get(r15)
            if (r14 != 0) goto L_0x0194
            if (r11 == 0) goto L_0x018f
            boolean r14 = r11.containsKey(r12)
            if (r14 != r10) goto L_0x018f
            r14 = r10
            goto L_0x0190
        L_0x018f:
            r14 = 0
        L_0x0190:
            if (r14 == 0) goto L_0x0194
            r14 = r10
            goto L_0x0195
        L_0x0194:
            r14 = 0
        L_0x0195:
            if (r14 == 0) goto L_0x0198
            goto L_0x0199
        L_0x0198:
            r12 = r9
        L_0x0199:
            if (r12 == 0) goto L_0x01a4
            java.lang.String r13 = r13.b()
            r5.put(r13, r12)
            kotlin.Unit r12 = kotlin.Unit.f56620a
        L_0x01a4:
            java.util.Iterator r12 = r8.iterator()
        L_0x01a8:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01d7
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
            com.sumsub.sns.internal.core.data.model.FieldName r15 = r14.q()
            com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.taxResidenceCountry
            if (r15 != r9) goto L_0x01d1
            com.sumsub.sns.internal.core.data.model.FieldName r9 = r14.q()
            if (r9 == 0) goto L_0x01c8
            java.lang.String r9 = r9.getValue()
            goto L_0x01c9
        L_0x01c8:
            r9 = 0
        L_0x01c9:
            java.lang.Object r9 = r5.get(r9)
            if (r9 != 0) goto L_0x01d1
            r9 = r10
            goto L_0x01d2
        L_0x01d1:
            r9 = 0
        L_0x01d2:
            if (r9 == 0) goto L_0x01d5
            goto L_0x01d8
        L_0x01d5:
            r9 = 0
            goto L_0x01a8
        L_0x01d7:
            r13 = 0
        L_0x01d8:
            com.sumsub.sns.internal.core.data.model.h$d r13 = (com.sumsub.sns.internal.core.data.model.h.d) r13
            if (r13 == 0) goto L_0x01fc
            java.lang.String r9 = r13.b()
            java.lang.String r12 = r38.s()
            if (r12 == 0) goto L_0x01f7
            if (r11 == 0) goto L_0x01f0
            boolean r11 = r11.containsKey(r12)
            if (r11 != r10) goto L_0x01f0
            r11 = r10
            goto L_0x01f1
        L_0x01f0:
            r11 = 0
        L_0x01f1:
            if (r11 == 0) goto L_0x01f4
            goto L_0x01f5
        L_0x01f4:
            r12 = 0
        L_0x01f5:
            if (r12 != 0) goto L_0x01f9
        L_0x01f7:
            java.lang.String r12 = ""
        L_0x01f9:
            r5.put(r9, r12)
        L_0x01fc:
            java.util.ArrayList r9 = new java.util.ArrayList
            r11 = 10
            int r11 = kotlin.collections.CollectionsKt__IterablesKt.u(r8, r11)
            r9.<init>(r11)
            java.util.Iterator r11 = r8.iterator()
        L_0x020b:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x031d
            java.lang.Object r12 = r11.next()
            com.sumsub.sns.internal.core.data.model.h$d r12 = (com.sumsub.sns.internal.core.data.model.h.d) r12
            java.lang.String r17 = r38.s()
            com.sumsub.sns.internal.core.data.model.e r18 = r38.d()
            com.sumsub.sns.internal.domain.c r13 = r6.F
            if (r13 == 0) goto L_0x0311
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r20 = r38.h()
            if (r39 == 0) goto L_0x0254
            java.util.Iterator r14 = r39.iterator()
        L_0x022d:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0248
            java.lang.Object r15 = r14.next()
            r16 = r15
            com.sumsub.sns.internal.domain.b r16 = (com.sumsub.sns.internal.domain.b) r16
            com.sumsub.sns.internal.core.data.model.h r10 = r16.c()
            boolean r10 = kotlin.jvm.internal.x.b(r10, r12)
            if (r10 == 0) goto L_0x0246
            goto L_0x0249
        L_0x0246:
            r10 = 1
            goto L_0x022d
        L_0x0248:
            r15 = 0
        L_0x0249:
            com.sumsub.sns.internal.domain.b r15 = (com.sumsub.sns.internal.domain.b) r15
            if (r15 == 0) goto L_0x0254
            java.lang.CharSequence r10 = r15.d()
            r22 = r10
            goto L_0x0256
        L_0x0254:
            r22 = 0
        L_0x0256:
            com.sumsub.sns.internal.core.data.model.FieldName r10 = r12.q()
            if (r10 != 0) goto L_0x025e
            r10 = -1
            goto L_0x0266
        L_0x025e:
            int[] r14 = com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.e.f35318a
            int r10 = r10.ordinal()
            r10 = r14[r10]
        L_0x0266:
            r14 = 4
            if (r10 == r14) goto L_0x02b4
            r14 = 5
            if (r10 == r14) goto L_0x0277
            r10 = 0
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.a.a(r10)
            r25 = r0
            r23 = r14
            goto L_0x02f0
        L_0x0277:
            java.util.Iterator r10 = r8.iterator()
        L_0x027b:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x029b
            java.lang.Object r14 = r10.next()
            r15 = r14
            com.sumsub.sns.internal.core.data.model.h$d r15 = (com.sumsub.sns.internal.core.data.model.h.d) r15
            com.sumsub.sns.internal.core.data.model.FieldName r15 = r15.q()
            r25 = r0
            com.sumsub.sns.internal.core.data.model.FieldName r0 = com.sumsub.sns.internal.core.data.model.FieldName.country
            if (r15 != r0) goto L_0x0294
            r0 = 1
            goto L_0x0295
        L_0x0294:
            r0 = 0
        L_0x0295:
            if (r0 == 0) goto L_0x0298
            goto L_0x029e
        L_0x0298:
            r0 = r25
            goto L_0x027b
        L_0x029b:
            r25 = r0
            r14 = 0
        L_0x029e:
            com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
            if (r14 == 0) goto L_0x02ee
            boolean r0 = r14.A()
            if (r0 == 0) goto L_0x02ae
            boolean r0 = r6.G
            if (r0 == 0) goto L_0x02ae
            r0 = 1
            goto L_0x02af
        L_0x02ae:
            r0 = 0
        L_0x02af:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r0)
            goto L_0x02eb
        L_0x02b4:
            r25 = r0
            java.util.Iterator r0 = r8.iterator()
        L_0x02ba:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x02d5
            java.lang.Object r10 = r0.next()
            r14 = r10
            com.sumsub.sns.internal.core.data.model.h$d r14 = (com.sumsub.sns.internal.core.data.model.h.d) r14
            com.sumsub.sns.internal.core.data.model.FieldName r14 = r14.q()
            com.sumsub.sns.internal.core.data.model.FieldName r15 = com.sumsub.sns.internal.core.data.model.FieldName.countryOfBirth
            if (r14 != r15) goto L_0x02d1
            r14 = 1
            goto L_0x02d2
        L_0x02d1:
            r14 = 0
        L_0x02d2:
            if (r14 == 0) goto L_0x02ba
            goto L_0x02d6
        L_0x02d5:
            r10 = 0
        L_0x02d6:
            com.sumsub.sns.internal.core.data.model.h$d r10 = (com.sumsub.sns.internal.core.data.model.h.d) r10
            if (r10 == 0) goto L_0x02ee
            boolean r0 = r10.A()
            if (r0 == 0) goto L_0x02e6
            boolean r0 = r6.G
            if (r0 == 0) goto L_0x02e6
            r0 = 1
            goto L_0x02e7
        L_0x02e6:
            r0 = 0
        L_0x02e7:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r0)
        L_0x02eb:
            r23 = r0
            goto L_0x02f0
        L_0x02ee:
            r23 = 0
        L_0x02f0:
            r21 = 0
            r16 = r12
            r19 = r13
            r24 = r7
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r0 = com.sumsub.sns.internal.presentation.utils.a.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            java.lang.String r10 = r0.f()
            if (r10 == 0) goto L_0x0309
            java.lang.String r12 = r0.c()
            r5.put(r12, r10)
        L_0x0309:
            r9.add(r0)
            r0 = r25
            r10 = 1
            goto L_0x020b
        L_0x0311:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Required value was null."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x031d:
            r25 = r0
            r4.addAll(r9)
            goto L_0x0325
        L_0x0323:
            r25 = r0
        L_0x0325:
            java.util.List r0 = r3.k()
            if (r0 == 0) goto L_0x04e3
            java.util.Iterator r0 = r0.iterator()
            r8 = r4
            r7 = r5
            r13 = r6
            r11 = r25
            r5 = r0
            r0 = r39
        L_0x0337:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x04de
            java.lang.Object r3 = r5.next()
            r4 = r3
            com.sumsub.sns.internal.core.data.model.h$c r4 = (com.sumsub.sns.internal.core.data.model.h.c) r4
            java.lang.String r3 = r4.b()
            kotlin.jvm.internal.d0 r9 = kotlin.jvm.internal.d0.f56774a
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            java.lang.String r12 = r4.i()
            r14 = 0
            r10[r14] = r12
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r9)
            java.lang.String r9 = "sns_data_custom_field_%s"
            java.lang.String r9 = java.lang.String.format(r9, r10)
            r1.f35349a = r13
            r1.f35350b = r0
            r1.f35351c = r11
            r1.f35352d = r8
            r1.f35353e = r7
            r1.f35354f = r5
            r1.f35355g = r4
            r1.f35356h = r3
            r10 = 0
            r1.f35357i = r10
            r1.f35358j = r10
            r10 = 1
            r1.f35361m = r10
            java.lang.Object r9 = r13.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r1)
            if (r9 != r2) goto L_0x037d
            return r2
        L_0x037d:
            r12 = r0
            r0 = r9
        L_0x037f:
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0391
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x038c
            r9 = r10
            goto L_0x038d
        L_0x038c:
            r9 = 0
        L_0x038d:
            if (r9 != r10) goto L_0x0391
            r9 = 1
            goto L_0x0392
        L_0x0391:
            r9 = 0
        L_0x0392:
            if (r9 == 0) goto L_0x0396
            r10 = r0
            goto L_0x0397
        L_0x0396:
            r10 = 0
        L_0x0397:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x039f
            java.lang.String r10 = r4.g()
        L_0x039f:
            kotlin.jvm.internal.d0 r0 = kotlin.jvm.internal.d0.f56774a
            r0 = 1
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r14 = r4.i()
            r15 = 0
            r9[r15] = r14
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            java.lang.String r0 = "sns_data_custom_hint_%s"
            java.lang.String r0 = java.lang.String.format(r0, r9)
            r1.f35349a = r13
            r1.f35350b = r12
            r1.f35351c = r11
            r1.f35352d = r8
            r1.f35353e = r7
            r1.f35354f = r5
            r1.f35355g = r4
            r1.f35356h = r3
            r1.f35357i = r10
            r9 = 2
            r1.f35361m = r9
            java.lang.Object r0 = r13.a((java.lang.String) r0, (kotlin.coroutines.c<? super java.lang.String>) r1)
            if (r0 != r2) goto L_0x03d1
            return r2
        L_0x03d1:
            r14 = r5
            r15 = r7
            r5 = r11
            r7 = r12
            r12 = r3
            r3 = r10
            r37 = r13
            r13 = r4
            r4 = r8
            r8 = r37
        L_0x03dd:
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Boolean r0 = r13.k()
            r10 = 1
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r10)
            boolean r0 = kotlin.jvm.internal.x.b(r0, r9)
            if (r0 == 0) goto L_0x042f
            r1.f35349a = r8
            r1.f35350b = r7
            r1.f35351c = r5
            r1.f35352d = r4
            r1.f35353e = r15
            r1.f35354f = r14
            r1.f35355g = r13
            r1.f35356h = r12
            r1.f35357i = r11
            r1.f35358j = r3
            r0 = 3
            r1.f35361m = r0
            java.lang.String r9 = "sns_data_placeholder_required"
            java.lang.Object r9 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r1)
            if (r9 != r2) goto L_0x040f
            return r2
        L_0x040f:
            r37 = r12
            r12 = r4
            r4 = r11
            r11 = r15
            r15 = r8
            r8 = r14
            r14 = r7
            r7 = r13
            r13 = r5
            r5 = r37
        L_0x041b:
            java.lang.String r9 = (java.lang.String) r9
            r27 = r3
            r28 = r4
            r26 = r5
            r5 = r8
            r32 = r9
            r8 = r12
            r9 = 4
            r37 = r15
            r15 = r11
            r11 = r13
            r13 = r37
            goto L_0x0460
        L_0x042f:
            r0 = 3
            r1.f35349a = r8
            r1.f35350b = r7
            r1.f35351c = r5
            r1.f35352d = r4
            r1.f35353e = r15
            r1.f35354f = r14
            r1.f35355g = r13
            r1.f35356h = r12
            r1.f35357i = r11
            r1.f35358j = r3
            r9 = 4
            r1.f35361m = r9
            java.lang.String r10 = "sns_data_placeholder_optional"
            java.lang.Object r10 = r8.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r1)
            if (r10 != r2) goto L_0x0450
            return r2
        L_0x0450:
            java.lang.String r10 = (java.lang.String) r10
            r27 = r3
            r32 = r10
            r28 = r11
            r26 = r12
            r11 = r5
            r5 = r14
            r14 = r7
            r7 = r13
            r13 = r8
            r8 = r4
        L_0x0460:
            java.lang.Boolean r30 = r7.k()
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r17 = new com.sumsub.sns.internal.core.data.source.applicant.remote.k
            r29 = 0
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = 392(0x188, float:5.5E-43)
            r36 = 0
            r25 = r17
            r25.<init>((java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (java.lang.Boolean) r30, (java.lang.String) r31, (java.lang.String) r32, (java.lang.String) r33, (java.util.List) r34, (int) r35, (kotlin.jvm.internal.r) r36)
            java.util.Map r3 = r13.C()
            java.lang.String r4 = r7.b()
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x048b
            java.lang.String r3 = r13.a((com.sumsub.sns.internal.core.data.model.g) r11, (com.sumsub.sns.internal.core.data.model.h.c) r7)
        L_0x048b:
            r19 = r3
            if (r14 == 0) goto L_0x04b7
            java.util.Iterator r3 = r14.iterator()
        L_0x0493:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r10 = r3.next()
            r4 = r10
            com.sumsub.sns.internal.domain.b r4 = (com.sumsub.sns.internal.domain.b) r4
            com.sumsub.sns.internal.core.data.model.h r4 = r4.c()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r7)
            if (r4 == 0) goto L_0x0493
            goto L_0x04ac
        L_0x04ab:
            r10 = 0
        L_0x04ac:
            com.sumsub.sns.internal.domain.b r10 = (com.sumsub.sns.internal.domain.b) r10
            if (r10 == 0) goto L_0x04b7
            java.lang.CharSequence r10 = r10.d()
            r21 = r10
            goto L_0x04b9
        L_0x04b7:
            r21 = 0
        L_0x04b9:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r3 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            r20 = 0
            r22 = 0
            r23 = 40
            r24 = 0
            java.lang.String r18 = "appdata.custom"
            r16 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            java.lang.String r4 = r3.f()
            if (r4 == 0) goto L_0x04d7
            java.lang.String r7 = r3.c()
            r15.put(r7, r4)
        L_0x04d7:
            r8.add(r3)
            r0 = r14
            r7 = r15
            goto L_0x0337
        L_0x04de:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            r5 = r7
            r4 = r8
            goto L_0x04e4
        L_0x04e3:
            r13 = r6
        L_0x04e4:
            r13.c((java.util.Map<java.lang.String, java.lang.String>) r5)
            com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$l r0 = new com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b$l
            r1 = 0
            r0.<init>(r13, r4, r1)
            r2 = 0
            r3 = 1
            com.sumsub.sns.core.presentation.base.a.a(r13, r2, r0, r3, r1)
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x04f5:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.a(java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(b bVar, List list, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = null;
        }
        return bVar.a((List<com.sumsub.sns.internal.domain.b>) list, (kotlin.coroutines.c<? super Unit>) cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.sumsub.sns.internal.core.data.model.h r4, com.sumsub.sns.internal.core.data.model.g r5, java.lang.String r6) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.sumsub.sns.internal.core.data.model.h.d
            if (r0 == 0) goto L_0x0007
            com.sumsub.sns.internal.core.data.model.h$d r4 = (com.sumsub.sns.internal.core.data.model.h.d) r4
            goto L_0x0008
        L_0x0007:
            r4 = 0
        L_0x0008:
            r0 = 0
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            boolean r1 = r4.x()
            r2 = 1
            if (r1 == 0) goto L_0x0035
            int r6 = r6.length()
            if (r6 != 0) goto L_0x001b
            r6 = r2
            goto L_0x001c
        L_0x001b:
            r6 = r0
        L_0x001c:
            if (r6 == 0) goto L_0x0035
            java.lang.String r4 = r3.a((com.sumsub.sns.internal.core.data.model.g) r5, (com.sumsub.sns.internal.core.data.model.h.d) r4)
            if (r4 == 0) goto L_0x0031
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x002c
            r4 = r2
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            if (r4 != r2) goto L_0x0031
            r4 = r2
            goto L_0x0032
        L_0x0031:
            r4 = r0
        L_0x0032:
            if (r4 == 0) goto L_0x0035
            r0 = r2
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.applicantdata.b.a(com.sumsub.sns.internal.core.data.model.h, com.sumsub.sns.internal.core.data.model.g, java.lang.String):boolean");
    }

    public final String a(com.sumsub.sns.internal.core.data.model.g gVar, h.d dVar) {
        List<Map<String, String>> n11;
        Map map;
        FieldName q11 = dVar.q();
        int i11 = q11 == null ? -1 : e.f35318a[q11.ordinal()];
        String str = null;
        if (i11 != 1) {
            switch (i11) {
                case 4:
                    g.a C = gVar.C();
                    if (C != null) {
                        return C.y();
                    }
                    return null;
                case 5:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    g.a C2 = gVar.C();
                    if (C2 == null || (n11 = C2.n()) == null || (map = (Map) CollectionsKt___CollectionsKt.c0(n11)) == null) {
                        return null;
                    }
                    FieldName q12 = dVar.q();
                    if (q12 != null) {
                        str = q12.getValue();
                    }
                    return (String) map.get(str);
                case 6:
                    g.a C3 = gVar.C();
                    if (C3 != null) {
                        return C3.r();
                    }
                    return null;
                case 7:
                    g.a C4 = gVar.C();
                    if (C4 != null) {
                        return C4.t();
                    }
                    return null;
                case 8:
                    g.a C5 = gVar.C();
                    if (C5 != null) {
                        return C5.v();
                    }
                    return null;
                case 9:
                    g.a C6 = gVar.C();
                    if (C6 != null) {
                        return C6.z();
                    }
                    return null;
                case 10:
                    return gVar.G();
                case 11:
                    g.a C7 = gVar.C();
                    if (C7 != null) {
                        return C7.x();
                    }
                    return null;
                case 12:
                    g.a C8 = gVar.C();
                    if (C8 != null) {
                        return C8.u();
                    }
                    return null;
                case 13:
                    g.a C9 = gVar.C();
                    if (C9 != null) {
                        return C9.s();
                    }
                    return null;
                case 14:
                    g.a C10 = gVar.C();
                    if (C10 != null) {
                        return C10.w();
                    }
                    return null;
                case 15:
                    g.a C11 = gVar.C();
                    if (C11 != null) {
                        return C11.q();
                    }
                    return null;
                case 16:
                    return gVar.x();
                default:
                    return null;
            }
        } else {
            g.a C12 = gVar.C();
            if (C12 != null) {
                return C12.p();
            }
            return null;
        }
    }

    public final String a(com.sumsub.sns.internal.core.data.model.g gVar, h.c cVar) {
        T t11;
        List<g.b> F2 = gVar.F();
        if (F2 == null) {
            return null;
        }
        Iterator<T> it2 = F2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((g.b) t11).c(), cVar.i())) {
                break;
            }
        }
        g.b bVar = (g.b) t11;
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }
}
