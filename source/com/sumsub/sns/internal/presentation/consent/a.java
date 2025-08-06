package com.sumsub.sns.internal.presentation.consent;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.domain.p;
import d10.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
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

public final class a extends com.sumsub.sns.core.presentation.base.a<d> {
    public static final String A = "consent_selected_agreement";

    /* renamed from: y  reason: collision with root package name */
    public static final C0420a f35207y = new C0420a((r) null);

    /* renamed from: z  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f35208z = {Reflection.e(new MutablePropertyReference1Impl(a.class, "selectedAgreement", "getSelectedAgreement()Ljava/lang/Integer;", 0))};

    /* renamed from: q  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f35209q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.b f35210r;

    /* renamed from: s  reason: collision with root package name */
    public final p f35211s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f35212t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35213u;

    /* renamed from: v  reason: collision with root package name */
    public final j1<Integer> f35214v;

    /* renamed from: w  reason: collision with root package name */
    public final kotlinx.coroutines.flow.d<List<b>> f35215w;

    /* renamed from: x  reason: collision with root package name */
    public final j1<d> f35216x;

    /* renamed from: com.sumsub.sns.internal.presentation.consent.a$a  reason: collision with other inner class name */
    public static final class C0420a {
        public /* synthetic */ C0420a(r rVar) {
            this();
        }

        public C0420a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f35217a;

        /* renamed from: b  reason: collision with root package name */
        public final SNSCountryPicker.CountryItem f35218b;

        public b(int i11, SNSCountryPicker.CountryItem countryItem) {
            this.f35217a = i11;
            this.f35218b = countryItem;
        }

        public final int a() {
            return this.f35217a;
        }

        public final SNSCountryPicker.CountryItem b() {
            return this.f35218b;
        }

        public final SNSCountryPicker.CountryItem c() {
            return this.f35218b;
        }

        public final int d() {
            return this.f35217a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f35217a == bVar.f35217a && x.b(this.f35218b, bVar.f35218b);
        }

        public int hashCode() {
            return (this.f35217a * 31) + this.f35218b.hashCode();
        }

        public String toString() {
            return "CountryWrapperItem(id=" + this.f35217a + ", country=" + this.f35218b + ')';
        }

        public final b a(int i11, SNSCountryPicker.CountryItem countryItem) {
            return new b(i11, countryItem);
        }

        public static /* synthetic */ b a(b bVar, int i11, SNSCountryPicker.CountryItem countryItem, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = bVar.f35217a;
            }
            if ((i12 & 2) != 0) {
                countryItem = bVar.f35218b;
            }
            return bVar.a(i11, countryItem);
        }
    }

    public static final class c implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f35219a;

        public c(String str) {
            this.f35219a = str;
        }

        public final String a() {
            return this.f35219a;
        }

        public final String b() {
            return this.f35219a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f35219a, ((c) obj).f35219a);
        }

        public int hashCode() {
            return this.f35219a.hashCode();
        }

        public String toString() {
            return "ShowAgreementEvent(text=" + this.f35219a + ')';
        }

        public final c a(String str) {
            return new c(str);
        }

        public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f35219a;
            }
            return cVar.a(str);
        }
    }

    public static final class d implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f35220a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f35221b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f35222c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f35223d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f35224e;

        /* renamed from: f  reason: collision with root package name */
        public final List<b> f35225f;

        public d() {
            this((Integer) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (List) null, 63, (r) null);
        }

        public final Integer a() {
            return this.f35220a;
        }

        public final CharSequence b() {
            return this.f35221b;
        }

        public final CharSequence c() {
            return this.f35222c;
        }

        public final CharSequence d() {
            return this.f35223d;
        }

        public final CharSequence e() {
            return this.f35224e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f35220a, dVar.f35220a) && x.b(this.f35221b, dVar.f35221b) && x.b(this.f35222c, dVar.f35222c) && x.b(this.f35223d, dVar.f35223d) && x.b(this.f35224e, dVar.f35224e) && x.b(this.f35225f, dVar.f35225f);
        }

        public final List<b> f() {
            return this.f35225f;
        }

        public final CharSequence g() {
            return this.f35223d;
        }

        public final List<b> h() {
            return this.f35225f;
        }

        public int hashCode() {
            Integer num = this.f35220a;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            CharSequence charSequence = this.f35221b;
            int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f35222c;
            int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f35223d;
            int hashCode4 = (hashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f35224e;
            if (charSequence4 != null) {
                i11 = charSequence4.hashCode();
            }
            return ((hashCode4 + i11) * 31) + this.f35225f.hashCode();
        }

        public final CharSequence i() {
            return this.f35224e;
        }

        public final Integer j() {
            return this.f35220a;
        }

        public final CharSequence k() {
            return this.f35222c;
        }

        public final CharSequence l() {
            return this.f35221b;
        }

        public String toString() {
            return "ViewState(selectedAgreementId=" + this.f35220a + ", titleText=" + this.f35221b + ", subtitleText=" + this.f35222c + ", acceptText=" + this.f35223d + ", footerText=" + this.f35224e + ", countries=" + this.f35225f + ')';
        }

        public d(Integer num, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, List<b> list) {
            this.f35220a = num;
            this.f35221b = charSequence;
            this.f35222c = charSequence2;
            this.f35223d = charSequence3;
            this.f35224e = charSequence4;
            this.f35225f = list;
        }

        public final d a(Integer num, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, List<b> list) {
            return new d(num, charSequence, charSequence2, charSequence3, charSequence4, list);
        }

        public static /* synthetic */ d a(d dVar, Integer num, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, List<b> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = dVar.f35220a;
            }
            if ((i11 & 2) != 0) {
                charSequence = dVar.f35221b;
            }
            CharSequence charSequence5 = charSequence;
            if ((i11 & 4) != 0) {
                charSequence2 = dVar.f35222c;
            }
            CharSequence charSequence6 = charSequence2;
            if ((i11 & 8) != 0) {
                charSequence3 = dVar.f35223d;
            }
            CharSequence charSequence7 = charSequence3;
            if ((i11 & 16) != 0) {
                charSequence4 = dVar.f35224e;
            }
            CharSequence charSequence8 = charSequence4;
            if ((i11 & 32) != 0) {
                list = dVar.f35225f;
            }
            return dVar.a(num, charSequence5, charSequence6, charSequence7, charSequence8, list);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ d(java.lang.Integer r5, java.lang.CharSequence r6, java.lang.CharSequence r7, java.lang.CharSequence r8, java.lang.CharSequence r9, java.util.List r10, int r11, kotlin.jvm.internal.r r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                r0 = 0
                if (r12 == 0) goto L_0x0007
                r12 = r0
                goto L_0x0008
            L_0x0007:
                r12 = r5
            L_0x0008:
                r5 = r11 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r11 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r11 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r11 & 16
                if (r5 == 0) goto L_0x0022
                goto L_0x0023
            L_0x0022:
                r0 = r9
            L_0x0023:
                r5 = r11 & 32
                if (r5 == 0) goto L_0x002b
                java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x002b:
                r11 = r10
                r5 = r4
                r6 = r12
                r7 = r1
                r8 = r2
                r9 = r3
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.consent.a.d.<init>(java.lang.Integer, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, java.util.List, int, kotlin.jvm.internal.r):void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.consent.SNSAgreementSelectorViewModel$agreementsItems$1", f = "SNSAgreementSelectorViewModel.kt", l = {54, 66}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements d10.p<kotlinx.coroutines.flow.e<? super List<? extends b>>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35226a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f35228c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f35228c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super List<b>> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f35228c, cVar);
            eVar.f35227b = obj;
            return eVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            kotlinx.coroutines.flow.e eVar;
            ArrayList arrayList;
            String str;
            String str2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35226a;
            boolean z11 = true;
            if (i11 == 0) {
                k.b(obj);
                eVar = (kotlinx.coroutines.flow.e) this.f35227b;
                a aVar = this.f35228c;
                this.f35227b = eVar;
                this.f35226a = 1;
                obj2 = aVar.c((kotlin.coroutines.c<? super b.c>) this);
                if (obj2 == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                eVar = (kotlinx.coroutines.flow.e) this.f35227b;
                k.b(obj);
                obj2 = obj;
            } else if (i11 == 2) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<com.sumsub.sns.internal.core.data.model.d> c11 = ((b.c) obj2).c();
            if (c11 != null) {
                a aVar2 = this.f35228c;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.u(c11, 10));
                int i12 = 0;
                for (T next : c11) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    com.sumsub.sns.internal.core.data.model.d dVar = (com.sumsub.sns.internal.core.data.model.d) next;
                    com.sumsub.sns.internal.core.data.model.c e11 = dVar.e();
                    String str3 = "";
                    if (e11 == null || (str = e11.b()) == null) {
                        str = str3;
                    }
                    com.sumsub.sns.internal.core.data.model.e b11 = aVar2.d();
                    if (b11 != null) {
                        com.sumsub.sns.internal.core.data.model.b c12 = dVar.c();
                        str2 = com.sumsub.sns.internal.core.data.model.f.b(b11, c12 != null ? c12.q() : null);
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    arrayList.add(new b(i12, new SNSCountryPicker.CountryItem(str, str3)));
                    i12 = i13;
                }
            } else {
                arrayList = new ArrayList();
            }
            if (c11 == null || c11.size() != 1) {
                z11 = false;
            }
            if (z11) {
                this.f35228c.a(kotlin.coroutines.jvm.internal.a.c(0));
            }
            this.f35227b = null;
            this.f35226a = 2;
            if (eVar.emit(arrayList, this) == d11) {
                return d11;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.consent.SNSAgreementSelectorViewModel$onAgreeClicked$1", f = "SNSAgreementSelectorViewModel.kt", l = {102, 111}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35229a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f35230b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f35230b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f(this.f35230b, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0079  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r12.f35229a
                r2 = 2
                r3 = 0
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0025
                if (r1 == r5) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                kotlin.k.b(r13)
                kotlin.Result r13 = (kotlin.Result) r13
                r13.m3081unboximpl()
                goto L_0x0062
            L_0x0019:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0021:
                kotlin.k.b(r13)
                goto L_0x0037
            L_0x0025:
                kotlin.k.b(r13)
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                com.sumsub.sns.internal.core.data.source.dynamic.b r13 = r13.f35209q
                r12.f35229a = r5
                java.lang.Object r13 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r13, r4, r12, r5, r3)
                if (r13 != r0) goto L_0x0037
                return r0
            L_0x0037:
                com.sumsub.sns.internal.core.data.source.dynamic.e r13 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r13
                java.lang.Object r13 = r13.d()
                r8 = r13
                com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                com.sumsub.sns.internal.core.data.model.b r9 = r13.q()
                if (r8 == 0) goto L_0x008a
                if (r9 != 0) goto L_0x004b
                goto L_0x008a
            L_0x004b:
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                com.sumsub.sns.internal.core.domain.p r6 = r13.f35211s
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                com.sumsub.sns.internal.core.data.source.applicant.b r7 = r13.f35210r
                r12.f35229a = r2
                r10 = 0
                r11 = r12
                java.lang.Object r13 = r6.a(r7, r8, r9, r10, r11)
                if (r13 != r0) goto L_0x0062
                return r0
            L_0x0062:
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                r13.b((boolean) r4)
                com.sumsub.sns.internal.presentation.consent.a r6 = r12.f35230b
                com.sumsub.sns.internal.core.common.q$b r7 = new com.sumsub.sns.internal.core.common.q$b
                com.sumsub.sns.internal.core.data.model.e r13 = r6.d()
                if (r13 == 0) goto L_0x0075
                com.sumsub.sns.core.data.model.FlowType r3 = r13.y()
            L_0x0075:
                com.sumsub.sns.core.data.model.FlowType r13 = com.sumsub.sns.core.data.model.FlowType.Standalone
                if (r3 == r13) goto L_0x007a
                r4 = r5
            L_0x007a:
                r7.<init>(r4)
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.a.a(r5)
                r9 = 0
                r10 = 4
                r11 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r6, (com.sumsub.sns.internal.core.common.q) r7, (java.lang.Object) r8, (java.lang.Long) r9, (int) r10, (java.lang.Object) r11)
                kotlin.Unit r13 = kotlin.Unit.f56620a
                return r13
            L_0x008a:
                com.sumsub.sns.internal.presentation.consent.a r13 = r12.f35230b
                r13.b((boolean) r4)
                com.sumsub.sns.internal.presentation.consent.a r6 = r12.f35230b
                com.sumsub.sns.internal.core.common.q$b r7 = new com.sumsub.sns.internal.core.common.q$b
                r7.<init>(r4)
                java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.a.a(r5)
                r9 = 0
                r10 = 4
                r11 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r6, (com.sumsub.sns.internal.core.common.q) r7, (java.lang.Object) r8, (java.lang.Long) r9, (int) r10, (java.lang.Object) r11)
                kotlin.Unit r13 = kotlin.Unit.f56620a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.consent.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.consent.SNSAgreementSelectorViewModel$onTermsLinksClicked$1", f = "SNSAgreementSelectorViewModel.kt", l = {128, 129, 138, 139}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35231a;

        /* renamed from: b  reason: collision with root package name */
        public int f35232b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35233c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f35234d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str, a aVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f35233c = str;
            this.f35234d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f35233c, this.f35234d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00f8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f35232b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 0
                java.lang.String r6 = ""
                r7 = 1
                if (r1 == 0) goto L_0x003d
                if (r1 == r7) goto L_0x0039
                if (r1 == r4) goto L_0x0031
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                java.lang.Object r0 = r8.f35231a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.k.b(r9)
                goto L_0x00e0
            L_0x0020:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0028:
                java.lang.Object r1 = r8.f35231a
                com.sumsub.sns.internal.core.data.model.b r1 = (com.sumsub.sns.internal.core.data.model.b) r1
                kotlin.k.b(r9)
                goto L_0x00bf
            L_0x0031:
                java.lang.Object r0 = r8.f35231a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.k.b(r9)
                goto L_0x006d
            L_0x0039:
                kotlin.k.b(r9)
                goto L_0x0057
            L_0x003d:
                kotlin.k.b(r9)
                java.lang.String r9 = r8.f35233c
                java.lang.String r1 = "gtc"
                boolean r1 = kotlin.jvm.internal.x.b(r9, r1)
                if (r1 == 0) goto L_0x009a
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                r8.f35232b = r7
                java.lang.String r1 = "sns_tos_GTC_html"
                java.lang.Object r9 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r9 != r0) goto L_0x0057
                return r0
            L_0x0057:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 != 0) goto L_0x005c
                r9 = r6
            L_0x005c:
                com.sumsub.sns.internal.presentation.consent.a r1 = r8.f35234d
                r8.f35231a = r9
                r8.f35232b = r4
                java.lang.String r2 = "sns_tos_GTC_url"
                java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r1 != r0) goto L_0x006b
                return r0
            L_0x006b:
                r0 = r9
                r9 = r1
            L_0x006d:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 != 0) goto L_0x0072
                goto L_0x0073
            L_0x0072:
                r6 = r9
            L_0x0073:
                int r9 = r0.length()
                if (r9 <= 0) goto L_0x007b
                r9 = r7
                goto L_0x007c
            L_0x007b:
                r9 = r5
            L_0x007c:
                if (r9 == 0) goto L_0x008a
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                com.sumsub.sns.internal.presentation.consent.a$c r1 = new com.sumsub.sns.internal.presentation.consent.a$c
                r1.<init>(r0)
                r9.a((com.sumsub.sns.core.presentation.base.a.j) r1)
                goto L_0x0113
            L_0x008a:
                int r9 = r6.length()
                if (r9 <= 0) goto L_0x0091
                r5 = r7
            L_0x0091:
                if (r5 == 0) goto L_0x0113
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                r9.a((java.lang.String) r6)
                goto L_0x0113
            L_0x009a:
                java.lang.String r1 = "pp"
                boolean r9 = kotlin.jvm.internal.x.b(r9, r1)
                if (r9 == 0) goto L_0x010c
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                com.sumsub.sns.internal.core.data.model.b r1 = r9.q()
                if (r1 == 0) goto L_0x00b0
                java.lang.String r9 = r1.g()
                if (r9 != 0) goto L_0x00c4
            L_0x00b0:
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                r8.f35231a = r1
                r8.f35232b = r3
                java.lang.String r3 = "sns_tos_PP_html"
                java.lang.Object r9 = r9.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r9 != r0) goto L_0x00bf
                return r0
            L_0x00bf:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 != 0) goto L_0x00c4
                r9 = r6
            L_0x00c4:
                if (r1 == 0) goto L_0x00cf
                java.lang.String r1 = r1.k()
                if (r1 != 0) goto L_0x00cd
                goto L_0x00cf
            L_0x00cd:
                r6 = r1
                goto L_0x00e7
            L_0x00cf:
                com.sumsub.sns.internal.presentation.consent.a r1 = r8.f35234d
                r8.f35231a = r9
                r8.f35232b = r2
                java.lang.String r2 = "sns_tos_PP_url"
                java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r1 != r0) goto L_0x00de
                return r0
            L_0x00de:
                r0 = r9
                r9 = r1
            L_0x00e0:
                java.lang.String r9 = (java.lang.String) r9
                if (r9 != 0) goto L_0x00e5
                goto L_0x00e6
            L_0x00e5:
                r6 = r9
            L_0x00e6:
                r9 = r0
            L_0x00e7:
                int r0 = r6.length()
                if (r0 <= 0) goto L_0x00ef
                r0 = r7
                goto L_0x00f0
            L_0x00ef:
                r0 = r5
            L_0x00f0:
                if (r0 == 0) goto L_0x00f8
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                r9.a((java.lang.String) r6)
                goto L_0x0113
            L_0x00f8:
                int r0 = r9.length()
                if (r0 <= 0) goto L_0x00ff
                r5 = r7
            L_0x00ff:
                if (r5 == 0) goto L_0x0113
                com.sumsub.sns.internal.presentation.consent.a r0 = r8.f35234d
                com.sumsub.sns.internal.presentation.consent.a$c r1 = new com.sumsub.sns.internal.presentation.consent.a$c
                r1.<init>(r9)
                r0.a((com.sumsub.sns.core.presentation.base.a.j) r1)
                goto L_0x0113
            L_0x010c:
                com.sumsub.sns.internal.presentation.consent.a r9 = r8.f35234d
                java.lang.String r0 = r8.f35233c
                r9.a((java.lang.String) r0)
            L_0x0113:
                kotlin.Unit r9 = kotlin.Unit.f56620a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.consent.a.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.consent.SNSAgreementSelectorViewModel$viewState$1", f = "SNSAgreementSelectorViewModel.kt", l = {74, 76, 76, 83, 84}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements q<Integer, List<? extends b>, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35235a;

        /* renamed from: b  reason: collision with root package name */
        public Object f35236b;

        /* renamed from: c  reason: collision with root package name */
        public Object f35237c;

        /* renamed from: d  reason: collision with root package name */
        public int f35238d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f35239e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f35240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f35241g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, kotlin.coroutines.c<? super h> cVar) {
            super(3, cVar);
            this.f35241g = aVar;
        }

        /* renamed from: a */
        public final Object invoke(Integer num, List<b> list, kotlin.coroutines.c<? super d> cVar) {
            h hVar = new h(this.f35241g, cVar);
            hVar.f35239e = num;
            hVar.f35240f = list;
            return hVar.invokeSuspend(Unit.f56620a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0112 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0113  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x011e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f35238d
                r2 = 0
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                if (r1 == 0) goto L_0x0079
                if (r1 == r7) goto L_0x006d
                if (r1 == r6) goto L_0x0061
                if (r1 == r5) goto L_0x0052
                if (r1 == r4) goto L_0x003d
                if (r1 != r3) goto L_0x0035
                java.lang.Object r0 = r11.f35237c
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r11.f35236b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r11.f35235a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r11.f35240f
                java.lang.Integer r4 = (java.lang.Integer) r4
                java.lang.Object r5 = r11.f35239e
                java.util.List r5 = (java.util.List) r5
                kotlin.k.b(r12)
                r7 = r0
                r6 = r1
                r9 = r5
                r5 = r3
                goto L_0x011a
            L_0x0035:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x003d:
                java.lang.Object r1 = r11.f35236b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r4 = r11.f35235a
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                java.lang.Object r5 = r11.f35240f
                java.lang.Integer r5 = (java.lang.Integer) r5
                java.lang.Object r6 = r11.f35239e
                java.util.List r6 = (java.util.List) r6
                kotlin.k.b(r12)
                goto L_0x00fa
            L_0x0052:
                java.lang.Object r1 = r11.f35235a
                java.lang.Object r5 = r11.f35240f
                java.util.List r5 = (java.util.List) r5
                java.lang.Object r6 = r11.f35239e
                java.lang.Integer r6 = (java.lang.Integer) r6
                kotlin.k.b(r12)
                goto L_0x00ce
            L_0x0061:
                java.lang.Object r1 = r11.f35240f
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r6 = r11.f35239e
                java.lang.Integer r6 = (java.lang.Integer) r6
                kotlin.k.b(r12)
                goto L_0x00b7
            L_0x006d:
                java.lang.Object r1 = r11.f35240f
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r5 = r11.f35239e
                java.lang.Integer r5 = (java.lang.Integer) r5
                kotlin.k.b(r12)
                goto L_0x009e
            L_0x0079:
                kotlin.k.b(r12)
                java.lang.Object r12 = r11.f35239e
                java.lang.Integer r12 = (java.lang.Integer) r12
                java.lang.Object r1 = r11.f35240f
                java.util.List r1 = (java.util.List) r1
                int r8 = r1.size()
                if (r8 <= r7) goto L_0x00a3
                com.sumsub.sns.internal.presentation.consent.a r5 = r11.f35241g
                r11.f35239e = r12
                r11.f35240f = r1
                r11.f35238d = r7
                java.lang.String r6 = "sns_agreement_header"
                java.lang.Object r5 = r5.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r5 != r0) goto L_0x009b
                return r0
            L_0x009b:
                r10 = r5
                r5 = r12
                r12 = r10
            L_0x009e:
                kotlin.Pair r12 = kotlin.l.a(r12, r2)
                goto L_0x00d4
            L_0x00a3:
                com.sumsub.sns.internal.presentation.consent.a r7 = r11.f35241g
                r11.f35239e = r12
                r11.f35240f = r1
                r11.f35238d = r6
                java.lang.String r6 = "sns_agreement_special_title"
                java.lang.Object r6 = r7.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r6 != r0) goto L_0x00b4
                return r0
            L_0x00b4:
                r10 = r6
                r6 = r12
                r12 = r10
            L_0x00b7:
                com.sumsub.sns.internal.presentation.consent.a r7 = r11.f35241g
                r11.f35239e = r6
                r11.f35240f = r1
                r11.f35235a = r12
                r11.f35238d = r5
                java.lang.String r5 = "sns_agreement_special_subtitle"
                java.lang.Object r5 = r7.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r5 != r0) goto L_0x00ca
                return r0
            L_0x00ca:
                r10 = r1
                r1 = r12
                r12 = r5
                r5 = r10
            L_0x00ce:
                kotlin.Pair r12 = kotlin.l.a(r1, r12)
                r1 = r5
                r5 = r6
            L_0x00d4:
                java.lang.Object r6 = r12.component1()
                java.lang.String r6 = (java.lang.String) r6
                java.lang.Object r12 = r12.component2()
                java.lang.String r12 = (java.lang.String) r12
                com.sumsub.sns.internal.presentation.consent.a r7 = r11.f35241g
                r11.f35239e = r1
                r11.f35240f = r5
                r11.f35235a = r6
                r11.f35236b = r12
                r11.f35238d = r4
                java.lang.String r4 = "sns_agreement_action_continue"
                java.lang.Object r4 = r7.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r4 != r0) goto L_0x00f5
                return r0
            L_0x00f5:
                r10 = r1
                r1 = r12
                r12 = r4
                r4 = r6
                r6 = r10
            L_0x00fa:
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                com.sumsub.sns.internal.presentation.consent.a r7 = r11.f35241g
                r11.f35239e = r6
                r11.f35240f = r5
                r11.f35235a = r4
                r11.f35236b = r1
                r11.f35237c = r12
                r11.f35238d = r3
                java.lang.String r3 = "sns_agreement_footerHtml"
                java.lang.Object r3 = r7.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r11)
                if (r3 != r0) goto L_0x0113
                return r0
            L_0x0113:
                r7 = r12
                r12 = r3
                r9 = r6
                r6 = r1
                r10 = r5
                r5 = r4
                r4 = r10
            L_0x011a:
                java.lang.String r12 = (java.lang.String) r12
                if (r12 == 0) goto L_0x0128
                com.sumsub.sns.internal.presentation.consent.a r0 = r11.f35241g
                com.sumsub.sns.internal.core.data.source.extensions.a r0 = r0.f35212t
                android.text.Spanned r2 = r0.a(r12)
            L_0x0128:
                r8 = r2
                com.sumsub.sns.internal.presentation.consent.a$d r12 = new com.sumsub.sns.internal.presentation.consent.a$d
                r3 = r12
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.consent.a.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.consent.SNSAgreementSelectorViewModel$viewState$2", f = "SNSAgreementSelectorViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements q<kotlinx.coroutines.flow.e<? super d>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35242a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35243b;

        public i(kotlin.coroutines.c<? super i> cVar) {
            super(3, cVar);
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super d> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            i iVar = new i(cVar);
            iVar.f35243b = th2;
            return iVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f35242a == 0) {
                k.b(obj);
                Throwable th2 = (Throwable) this.f35243b;
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                aVar.e("SNSAgreementSelectorViewModel", "Error building state: " + th2.getMessage(), th2);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar2, p pVar, com.sumsub.sns.internal.core.data.source.extensions.a aVar2, SavedStateHandle savedStateHandle) {
        super(aVar, bVar);
        this.f35209q = bVar;
        this.f35210r = bVar2;
        this.f35211s = pVar;
        this.f35212t = aVar2;
        this.f35213u = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, A, null);
        j1<Integer> g11 = savedStateHandle.g(A, null);
        this.f35214v = g11;
        kotlinx.coroutines.flow.d<List<b>> F = kotlinx.coroutines.flow.f.F(new e(this, (kotlin.coroutines.c<? super e>) null));
        this.f35215w = F;
        this.f35216x = kotlinx.coroutines.flow.f.a0(kotlinx.coroutines.flow.f.f(kotlinx.coroutines.flow.f.j(g11, F, new h(this, (kotlin.coroutines.c<? super h>) null)), new i((kotlin.coroutines.c<? super i>) null)), m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), new d((Integer) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (CharSequence) null, (List) null, 63, (r) null));
    }

    public final b p() {
        T t11;
        boolean z11;
        Iterator<T> it2 = j().getValue().h().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            int d11 = ((b) t11).d();
            Integer r11 = r();
            if (r11 != null && d11 == r11.intValue()) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (b) t11;
    }

    public final com.sumsub.sns.internal.core.data.model.b q() {
        com.sumsub.sns.internal.core.data.model.d dVar;
        Integer r11 = r();
        if (r11 == null) {
            return null;
        }
        int intValue = r11.intValue();
        List<com.sumsub.sns.internal.core.data.model.d> c11 = h().c();
        if (c11 == null || (dVar = (com.sumsub.sns.internal.core.data.model.d) CollectionsKt___CollectionsKt.d0(c11, intValue)) == null) {
            return null;
        }
        return dVar.c();
    }

    public final Integer r() {
        return (Integer) this.f35213u.a(this, f35208z[0]);
    }

    /* renamed from: s */
    public j1<d> j() {
        return this.f35216x;
    }

    public final void t() {
        b(true);
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new f(this, (kotlin.coroutines.c<? super f>) null), 3, (Object) null);
    }

    public final n1 b(String str) {
        return kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g(str, this, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
    }

    public final void a(Integer num) {
        this.f35213u.a(this, f35208z[0], num);
    }

    public final void a(int i11) {
        a(Integer.valueOf(i11));
    }
}
