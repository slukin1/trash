package com.sumsub.sns.internal.camera.photo.presentation;

import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.w;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.domain.g;
import d10.t;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;

public final class a extends com.sumsub.sns.core.presentation.base.a<e> {
    public static final C0304a B = new C0304a((kotlin.jvm.internal.r) null);
    public static final String C = "extra_document_type";
    public final j1<e> A;

    /* renamed from: q  reason: collision with root package name */
    public final String f31395q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f31396r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.d f31397s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.g f31398t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f31399u;

    /* renamed from: v  reason: collision with root package name */
    public final j1<com.sumsub.sns.internal.core.domain.e> f31400v;

    /* renamed from: w  reason: collision with root package name */
    public final b1<Boolean> f31401w;

    /* renamed from: x  reason: collision with root package name */
    public final b1<SNSCountryPicker.CountryItem> f31402x;

    /* renamed from: y  reason: collision with root package name */
    public final j1<c> f31403y;

    /* renamed from: z  reason: collision with root package name */
    public final j1<List<SNSCountryPicker.CountryItem>> f31404z;

    /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$a  reason: collision with other inner class name */
    public static final class C0304a {
        public /* synthetic */ C0304a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public C0304a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.q f31405a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31406b;

        public b(com.sumsub.sns.internal.core.data.model.q qVar, CharSequence charSequence) {
            this.f31405a = qVar;
            this.f31406b = charSequence;
        }

        public final com.sumsub.sns.internal.core.data.model.q a() {
            return this.f31405a;
        }

        public final CharSequence b() {
            return this.f31406b;
        }

        public final com.sumsub.sns.internal.core.data.model.q c() {
            return this.f31405a;
        }

        public final CharSequence d() {
            return this.f31406b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f31405a, bVar.f31405a) && x.b(this.f31406b, bVar.f31406b);
        }

        public int hashCode() {
            int hashCode = this.f31405a.hashCode() * 31;
            CharSequence charSequence = this.f31406b;
            return hashCode + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public String toString() {
            return "DocumentWrapper(document=" + this.f31405a + ", title=" + this.f31406b + ')';
        }

        public final b a(com.sumsub.sns.internal.core.data.model.q qVar, CharSequence charSequence) {
            return new b(qVar, charSequence);
        }

        public static /* synthetic */ b a(b bVar, com.sumsub.sns.internal.core.data.model.q qVar, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                qVar = bVar.f31405a;
            }
            if ((i11 & 2) != 0) {
                charSequence = bVar.f31406b;
            }
            return bVar.a(qVar, charSequence);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f31407a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31408b;

        public c() {
            this((List) null, (String) null, 3, (kotlin.jvm.internal.r) null);
        }

        public final List<b> a() {
            return this.f31407a;
        }

        public final String b() {
            return this.f31408b;
        }

        public final String c() {
            return this.f31408b;
        }

        public final List<b> d() {
            return this.f31407a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f31407a, cVar.f31407a) && x.b(this.f31408b, cVar.f31408b);
        }

        public int hashCode() {
            int hashCode = this.f31407a.hashCode() * 31;
            String str = this.f31408b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Documents(documents=" + this.f31407a + ", currentCountryKey=" + this.f31408b + ')';
        }

        public c(List<b> list, String str) {
            this.f31407a = list;
            this.f31408b = str;
        }

        public final c a(List<b> list, String str) {
            return new c(list, str);
        }

        public static /* synthetic */ c a(c cVar, List<b> list, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = cVar.f31407a;
            }
            if ((i11 & 2) != 0) {
                str = cVar.f31408b;
            }
            return cVar.a(list, str);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(List list, String str, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i11 & 2) != 0 ? null : str);
        }
    }

    public static final class d implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f31409a;

        /* renamed from: b  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.q f31410b;

        public d(String str, com.sumsub.sns.internal.core.data.model.q qVar) {
            this.f31409a = str;
            this.f31410b = qVar;
        }

        public final String a() {
            return this.f31409a;
        }

        public final com.sumsub.sns.internal.core.data.model.q b() {
            return this.f31410b;
        }

        public final String c() {
            return this.f31409a;
        }

        public final com.sumsub.sns.internal.core.data.model.q d() {
            return this.f31410b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f31409a, dVar.f31409a) && x.b(this.f31410b, dVar.f31410b);
        }

        public int hashCode() {
            int hashCode = this.f31409a.hashCode() * 31;
            com.sumsub.sns.internal.core.data.model.q qVar = this.f31410b;
            return hashCode + (qVar == null ? 0 : qVar.hashCode());
        }

        public String toString() {
            return "SelectionChanged(countryKey=" + this.f31409a + ", identityType=" + this.f31410b + ')';
        }

        public final d a(String str, com.sumsub.sns.internal.core.data.model.q qVar) {
            return new d(str, qVar);
        }

        public static /* synthetic */ d a(d dVar, String str, com.sumsub.sns.internal.core.data.model.q qVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = dVar.f31409a;
            }
            if ((i11 & 2) != 0) {
                qVar = dVar.f31410b;
            }
            return dVar.a(str, qVar);
        }
    }

    public static final class e implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.domain.e f31411a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31412b;

        /* renamed from: c  reason: collision with root package name */
        public final c f31413c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f31414d;

        /* renamed from: e  reason: collision with root package name */
        public final List<SNSCountryPicker.CountryItem> f31415e;

        /* renamed from: f  reason: collision with root package name */
        public final SNSCountryPicker.CountryItem f31416f;

        /* renamed from: g  reason: collision with root package name */
        public final f f31417g;

        public e() {
            this((com.sumsub.sns.internal.core.domain.e) null, (String) null, (c) null, false, (List) null, (SNSCountryPicker.CountryItem) null, (f) null, 127, (kotlin.jvm.internal.r) null);
        }

        public final com.sumsub.sns.internal.core.domain.e a() {
            return this.f31411a;
        }

        public final String b() {
            return this.f31412b;
        }

        public final c c() {
            return this.f31413c;
        }

        public final boolean d() {
            return this.f31414d;
        }

        public final List<SNSCountryPicker.CountryItem> e() {
            return this.f31415e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f31411a, eVar.f31411a) && x.b(this.f31412b, eVar.f31412b) && x.b(this.f31413c, eVar.f31413c) && this.f31414d == eVar.f31414d && x.b(this.f31415e, eVar.f31415e) && x.b(this.f31416f, eVar.f31416f) && x.b(this.f31417g, eVar.f31417g);
        }

        public final SNSCountryPicker.CountryItem f() {
            return this.f31416f;
        }

        public final f g() {
            return this.f31417g;
        }

        public final com.sumsub.sns.internal.core.domain.e h() {
            return this.f31411a;
        }

        public int hashCode() {
            com.sumsub.sns.internal.core.domain.e eVar = this.f31411a;
            int i11 = 0;
            int hashCode = (eVar == null ? 0 : eVar.hashCode()) * 31;
            String str = this.f31412b;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f31413c.hashCode()) * 31;
            boolean z11 = this.f31414d;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
            List<SNSCountryPicker.CountryItem> list = this.f31415e;
            int hashCode3 = (i12 + (list == null ? 0 : list.hashCode())) * 31;
            SNSCountryPicker.CountryItem countryItem = this.f31416f;
            int hashCode4 = (hashCode3 + (countryItem == null ? 0 : countryItem.hashCode())) * 31;
            f fVar = this.f31417g;
            if (fVar != null) {
                i11 = fVar.hashCode();
            }
            return hashCode4 + i11;
        }

        public final String i() {
            return this.f31412b;
        }

        public final List<SNSCountryPicker.CountryItem> j() {
            return this.f31415e;
        }

        public final boolean k() {
            return this.f31414d;
        }

        public final c l() {
            return this.f31413c;
        }

        public final SNSCountryPicker.CountryItem m() {
            return this.f31416f;
        }

        public final f n() {
            return this.f31417g;
        }

        public String toString() {
            return "ViewState(countries=" + this.f31411a + ", currentCountryKey=" + this.f31412b + ", documents=" + this.f31413c + ", dialogIsVisible=" + this.f31414d + ", dialogCountryItems=" + this.f31415e + ", selectedCountry=" + this.f31416f + ", viewText=" + this.f31417g + ')';
        }

        public e(com.sumsub.sns.internal.core.domain.e eVar, String str, c cVar, boolean z11, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.CountryItem countryItem, f fVar) {
            this.f31411a = eVar;
            this.f31412b = str;
            this.f31413c = cVar;
            this.f31414d = z11;
            this.f31415e = list;
            this.f31416f = countryItem;
            this.f31417g = fVar;
        }

        public final e a(com.sumsub.sns.internal.core.domain.e eVar, String str, c cVar, boolean z11, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.CountryItem countryItem, f fVar) {
            return new e(eVar, str, cVar, z11, list, countryItem, fVar);
        }

        public static /* synthetic */ e a(e eVar, com.sumsub.sns.internal.core.domain.e eVar2, String str, c cVar, boolean z11, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.CountryItem countryItem, f fVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                eVar2 = eVar.f31411a;
            }
            if ((i11 & 2) != 0) {
                str = eVar.f31412b;
            }
            String str2 = str;
            if ((i11 & 4) != 0) {
                cVar = eVar.f31413c;
            }
            c cVar2 = cVar;
            if ((i11 & 8) != 0) {
                z11 = eVar.f31414d;
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                list = eVar.f31415e;
            }
            List<SNSCountryPicker.CountryItem> list2 = list;
            if ((i11 & 32) != 0) {
                countryItem = eVar.f31416f;
            }
            SNSCountryPicker.CountryItem countryItem2 = countryItem;
            if ((i11 & 64) != 0) {
                fVar = eVar.f31417g;
            }
            return eVar.a(eVar2, str2, cVar2, z12, list2, countryItem2, fVar);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ e(com.sumsub.sns.internal.core.domain.e r7, java.lang.String r8, com.sumsub.sns.internal.camera.photo.presentation.a.c r9, boolean r10, java.util.List r11, com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem r12, com.sumsub.sns.internal.camera.photo.presentation.a.f r13, int r14, kotlin.jvm.internal.r r15) {
            /*
                r6 = this;
                r15 = r14 & 1
                r0 = 0
                if (r15 == 0) goto L_0x0007
                r15 = r0
                goto L_0x0008
            L_0x0007:
                r15 = r7
            L_0x0008:
                r7 = r14 & 2
                if (r7 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r8
            L_0x000f:
                r7 = r14 & 4
                if (r7 == 0) goto L_0x0019
                com.sumsub.sns.internal.camera.photo.presentation.a$c r9 = new com.sumsub.sns.internal.camera.photo.presentation.a$c
                r7 = 3
                r9.<init>(r0, r0, r7, r0)
            L_0x0019:
                r2 = r9
                r7 = r14 & 8
                if (r7 == 0) goto L_0x001f
                r10 = 0
            L_0x001f:
                r3 = r10
                r7 = r14 & 16
                if (r7 == 0) goto L_0x0026
                r4 = r0
                goto L_0x0027
            L_0x0026:
                r4 = r11
            L_0x0027:
                r7 = r14 & 32
                if (r7 == 0) goto L_0x002d
                r5 = r0
                goto L_0x002e
            L_0x002d:
                r5 = r12
            L_0x002e:
                r7 = r14 & 64
                if (r7 == 0) goto L_0x0034
                r14 = r0
                goto L_0x0035
            L_0x0034:
                r14 = r13
            L_0x0035:
                r7 = r6
                r8 = r15
                r9 = r1
                r10 = r2
                r11 = r3
                r12 = r4
                r13 = r5
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.e.<init>(com.sumsub.sns.internal.core.domain.e, java.lang.String, com.sumsub.sns.internal.camera.photo.presentation.a$c, boolean, java.util.List, com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem, com.sumsub.sns.internal.camera.photo.presentation.a$f, int, kotlin.jvm.internal.r):void");
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f31418a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31419b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f31420c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f31421d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f31422e;

        public f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            this.f31418a = charSequence;
            this.f31419b = charSequence2;
            this.f31420c = charSequence3;
            this.f31421d = charSequence4;
            this.f31422e = charSequence5;
        }

        public final CharSequence a() {
            return this.f31418a;
        }

        public final CharSequence b() {
            return this.f31419b;
        }

        public final CharSequence c() {
            return this.f31420c;
        }

        public final CharSequence d() {
            return this.f31421d;
        }

        public final CharSequence e() {
            return this.f31422e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return x.b(this.f31418a, fVar.f31418a) && x.b(this.f31419b, fVar.f31419b) && x.b(this.f31420c, fVar.f31420c) && x.b(this.f31421d, fVar.f31421d) && x.b(this.f31422e, fVar.f31422e);
        }

        public final CharSequence f() {
            return this.f31422e;
        }

        public final CharSequence g() {
            return this.f31418a;
        }

        public final CharSequence h() {
            return this.f31419b;
        }

        public int hashCode() {
            CharSequence charSequence = this.f31418a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f31419b;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f31420c;
            int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
            CharSequence charSequence4 = this.f31421d;
            int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
            CharSequence charSequence5 = this.f31422e;
            if (charSequence5 != null) {
                i11 = charSequence5.hashCode();
            }
            return hashCode4 + i11;
        }

        public final CharSequence i() {
            return this.f31420c;
        }

        public final CharSequence j() {
            return this.f31421d;
        }

        public String toString() {
            return "ViewText(countryTitleText=" + this.f31418a + ", documentTitleText=" + this.f31419b + ", footerText=" + this.f31420c + ", infoText=" + this.f31421d + ", countryPlaceholder=" + this.f31422e + ')';
        }

        public final f a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            return new f(charSequence, charSequence2, charSequence3, charSequence4, charSequence5);
        }

        public static /* synthetic */ f a(f fVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = fVar.f31418a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = fVar.f31419b;
            }
            CharSequence charSequence6 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = fVar.f31420c;
            }
            CharSequence charSequence7 = charSequence3;
            if ((i11 & 8) != 0) {
                charSequence4 = fVar.f31421d;
            }
            CharSequence charSequence8 = charSequence4;
            if ((i11 & 16) != 0) {
                charSequence5 = fVar.f31422e;
            }
            return fVar.a(charSequence, charSequence6, charSequence7, charSequence8, charSequence5);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : charSequence3, (i11 & 8) != 0 ? null : charSequence4, charSequence5);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel", f = "SNSDocumentSelectorViewModel.kt", l = {213, 214}, m = "buildViewText")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31423a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31424b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31425c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f31426d;

        /* renamed from: e  reason: collision with root package name */
        public int f31427e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f31426d = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31425c = obj;
            this.f31427e |= Integer.MIN_VALUE;
            return this.f31426d.e((kotlin.coroutines.c<? super f>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$countries$1", f = "SNSDocumentSelectorViewModel.kt", l = {49, 55}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements d10.p<kotlinx.coroutines.flow.e<? super com.sumsub.sns.internal.core.domain.e>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31428a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31430c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, kotlin.coroutines.c<? super h> cVar) {
            super(2, cVar);
            this.f31430c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super com.sumsub.sns.internal.core.domain.e> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((h) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            h hVar = new h(this.f31430c, cVar);
            hVar.f31429b = obj;
            return hVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.flow.e} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f31428a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0028
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.k.b(r9)
                goto L_0x007f
            L_0x0012:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x001a:
                java.lang.Object r1 = r8.f31429b
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                kotlin.k.b(r9)
                kotlin.Result r9 = (kotlin.Result) r9
                java.lang.Object r9 = r9.m3081unboximpl()
                goto L_0x0041
            L_0x0028:
                kotlin.k.b(r9)
                java.lang.Object r9 = r8.f31429b
                r1 = r9
                kotlinx.coroutines.flow.e r1 = (kotlinx.coroutines.flow.e) r1
                com.sumsub.sns.internal.camera.photo.presentation.a r9 = r8.f31430c
                com.sumsub.sns.internal.core.domain.d r9 = r9.f31397s
                r8.f31429b = r1
                r8.f31428a = r3
                java.lang.Object r9 = r9.a(r3, r8)
                if (r9 != r0) goto L_0x0041
                return r0
            L_0x0041:
                boolean r3 = kotlin.Result.m3078isFailureimpl(r9)
                if (r3 == 0) goto L_0x006c
                java.lang.Throwable r9 = kotlin.Result.m3075exceptionOrNullimpl(r9)
                r3 = r9
                java.lang.Exception r3 = (java.lang.Exception) r3
                com.sumsub.sns.internal.log.a r9 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r0 = com.sumsub.sns.internal.log.c.a(r1)
                java.lang.String r1 = r3.getMessage()
                if (r1 != 0) goto L_0x005c
                java.lang.String r1 = ""
            L_0x005c:
                r9.e(r0, r1, r3)
                com.sumsub.sns.internal.camera.photo.presentation.a r2 = r8.f31430c
                java.lang.String r4 = r2.f31395q
                r5 = 0
                r6 = 4
                r7 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r2, (java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.Object) r5, (int) r6, (java.lang.Object) r7)
                goto L_0x007f
            L_0x006c:
                boolean r3 = kotlin.Result.m3078isFailureimpl(r9)
                r4 = 0
                if (r3 == 0) goto L_0x0074
                r9 = r4
            L_0x0074:
                r8.f31429b = r4
                r8.f31428a = r2
                java.lang.Object r9 = r1.emit(r9, r8)
                if (r9 != r0) goto L_0x007f
                return r0
            L_0x007f:
                kotlin.Unit r9 = kotlin.Unit.f56620a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$countries$2", f = "SNSDocumentSelectorViewModel.kt", l = {59}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements d10.p<com.sumsub.sns.internal.core.domain.e, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31431a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31432b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31433c;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$countries$2$1", f = "SNSDocumentSelectorViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$i$a  reason: collision with other inner class name */
        public static final class C0305a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31434a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.sumsub.sns.internal.core.domain.e f31435b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0305a(com.sumsub.sns.internal.core.domain.e eVar, kotlin.coroutines.c<? super C0305a> cVar) {
                super(2, cVar);
                this.f31435b = eVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0305a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0305a(this.f31435b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                String i11;
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f31434a == 0) {
                    kotlin.k.b(obj);
                    SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
                    if (eventHandler != null) {
                        com.sumsub.sns.internal.core.domain.e eVar = this.f31435b;
                        if (eVar == null || (i11 = eVar.i()) == null) {
                            return Unit.f56620a;
                        }
                        eventHandler.onEvent(new SNSEvent.CountrySelected(i11, false));
                    }
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f31433c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(com.sumsub.sns.internal.core.domain.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            i iVar = new i(this.f31433c, cVar);
            iVar.f31432b = obj;
            return iVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31431a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                CoroutineContext coroutineContext = m0.a(this.f31433c).getCoroutineContext();
                C0305a aVar = new C0305a((com.sumsub.sns.internal.core.domain.e) this.f31432b, (kotlin.coroutines.c<? super C0305a>) null);
                this.f31431a = 1;
                if (kotlinx.coroutines.g.g(coroutineContext, aVar, this) == d11) {
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

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$documents$3", f = "SNSDocumentSelectorViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super c>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31436a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31437b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f31438c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f31439d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a aVar, kotlin.coroutines.c<? super j> cVar) {
            super(3, cVar);
            this.f31439d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super c> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            j jVar = new j(this.f31439d, cVar);
            jVar.f31437b = eVar;
            jVar.f31438c = th2;
            return jVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31436a == 0) {
                kotlin.k.b(obj);
                Throwable th2 = (Throwable) this.f31438c;
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a((kotlinx.coroutines.flow.e) this.f31437b);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                aVar.e(a11, message, th2);
                a aVar2 = this.f31439d;
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) aVar2, th2, aVar2.f31395q, (Object) null, 4, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$documents$4", f = "SNSDocumentSelectorViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<c, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f31441b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(a aVar, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f31441b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(c cVar, kotlin.coroutines.c<? super Unit> cVar2) {
            return ((k) create(cVar, cVar2)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f31441b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f31440a == 0) {
                kotlin.k.b(obj);
                this.f31441b.f31401w.setValue(kotlin.coroutines.jvm.internal.a.a(false));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel", f = "SNSDocumentSelectorViewModel.kt", l = {157}, m = "getCountryTitle")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31442a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31443b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31444c;

        /* renamed from: d  reason: collision with root package name */
        public int f31445d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(a aVar, kotlin.coroutines.c<? super l> cVar) {
            super(cVar);
            this.f31444c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31443b = obj;
            this.f31445d |= Integer.MIN_VALUE;
            return this.f31444c.f((kotlin.coroutines.c<? super CharSequence>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel", f = "SNSDocumentSelectorViewModel.kt", l = {168}, m = "getDocumentsTitle")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31446a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31448c;

        /* renamed from: d  reason: collision with root package name */
        public int f31449d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(a aVar, kotlin.coroutines.c<? super m> cVar) {
            super(cVar);
            this.f31448c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31447b = obj;
            this.f31449d |= Integer.MIN_VALUE;
            return this.f31448c.g((kotlin.coroutines.c<? super CharSequence>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$selectedDialogCountryItems$2", f = "SNSDocumentSelectorViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements d10.p<List<? extends SNSCountryPicker.CountryItem>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31450a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31451b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f31452c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(a aVar, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f31452c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(List<SNSCountryPicker.CountryItem> list, kotlin.coroutines.c<? super Unit> cVar) {
            return ((n) create(list, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            n nVar = new n(this.f31452c, cVar);
            nVar.f31451b = obj;
            return nVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r6.f31450a
                if (r0 != 0) goto L_0x0049
                kotlin.k.b(r7)
                java.lang.Object r7 = r6.f31451b
                java.util.List r7 = (java.util.List) r7
                com.sumsub.sns.internal.camera.photo.presentation.a r0 = r6.f31452c
                kotlinx.coroutines.flow.b1 r0 = r0.f31402x
                com.sumsub.sns.internal.camera.photo.presentation.a r1 = r6.f31452c
                java.util.Iterator r7 = r7.iterator()
            L_0x001a:
                boolean r2 = r7.hasNext()
                r3 = 0
                if (r2 == 0) goto L_0x0043
                java.lang.Object r2 = r7.next()
                r4 = r2
                com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r4 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r4
                java.lang.String r4 = r4.getCode()
                kotlinx.coroutines.flow.j1 r5 = r1.f31400v
                java.lang.Object r5 = r5.getValue()
                com.sumsub.sns.internal.core.domain.e r5 = (com.sumsub.sns.internal.core.domain.e) r5
                if (r5 == 0) goto L_0x003c
                java.lang.String r3 = r5.i()
            L_0x003c:
                boolean r3 = kotlin.jvm.internal.x.b(r4, r3)
                if (r3 == 0) goto L_0x001a
                r3 = r2
            L_0x0043:
                r0.setValue(r3)
                kotlin.Unit r7 = kotlin.Unit.f56620a
                return r7
            L_0x0049:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class o implements kotlinx.coroutines.flow.d<g.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f31453a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f31454b;

        /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$o$a  reason: collision with other inner class name */
        public static final class C0306a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f31455a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f31456b;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$special$$inlined$map$1$2", f = "SNSDocumentSelectorViewModel.kt", l = {224, 229, 226}, m = "emit")
            /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$o$a$a  reason: collision with other inner class name */
            public static final class C0307a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f31457a;

                /* renamed from: b  reason: collision with root package name */
                public int f31458b;

                /* renamed from: c  reason: collision with root package name */
                public Object f31459c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ C0306a f31460d;

                /* renamed from: e  reason: collision with root package name */
                public Object f31461e;

                /* renamed from: f  reason: collision with root package name */
                public Object f31462f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0307a(C0306a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f31460d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f31457a = obj;
                    this.f31458b |= Integer.MIN_VALUE;
                    return this.f31460d.emit((Object) null, this);
                }
            }

            public C0306a(kotlinx.coroutines.flow.e eVar, a aVar) {
                this.f31455a = eVar;
                this.f31456b = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.c r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.o.C0306a.C0307a
                    if (r0 == 0) goto L_0x0013
                    r0 = r11
                    com.sumsub.sns.internal.camera.photo.presentation.a$o$a$a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.o.C0306a.C0307a) r0
                    int r1 = r0.f31458b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f31458b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.internal.camera.photo.presentation.a$o$a$a r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$o$a$a
                    r0.<init>(r9, r11)
                L_0x0018:
                    java.lang.Object r11 = r0.f31457a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f31458b
                    r3 = 2
                    r4 = 1
                    r5 = 3
                    r6 = 0
                    if (r2 == 0) goto L_0x0052
                    if (r2 == r4) goto L_0x0041
                    if (r2 == r3) goto L_0x0039
                    if (r2 != r5) goto L_0x0031
                    kotlin.k.b(r11)
                    goto L_0x00a9
                L_0x0031:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0039:
                    java.lang.Object r10 = r0.f31459c
                    kotlinx.coroutines.flow.e r10 = (kotlinx.coroutines.flow.e) r10
                    kotlin.k.b(r11)
                    goto L_0x009a
                L_0x0041:
                    java.lang.Object r10 = r0.f31462f
                    com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r10 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r10
                    java.lang.Object r2 = r0.f31461e
                    kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
                    java.lang.Object r4 = r0.f31459c
                    com.sumsub.sns.internal.camera.photo.presentation.a$o$a r4 = (com.sumsub.sns.internal.camera.photo.presentation.a.o.C0306a) r4
                    kotlin.k.b(r11)
                    r11 = r2
                    goto L_0x006b
                L_0x0052:
                    kotlin.k.b(r11)
                    kotlinx.coroutines.flow.e r11 = r9.f31455a
                    com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r10 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r10
                    com.sumsub.sns.internal.camera.photo.presentation.a r2 = r9.f31456b
                    r0.f31459c = r9
                    r0.f31461e = r11
                    r0.f31462f = r10
                    r0.f31458b = r4
                    java.lang.Object r2 = r2.a((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
                    if (r2 != r1) goto L_0x006a
                    return r1
                L_0x006a:
                    r4 = r9
                L_0x006b:
                    if (r10 != 0) goto L_0x0073
                    com.sumsub.sns.internal.core.domain.g$b r10 = new com.sumsub.sns.internal.core.domain.g$b
                    r10.<init>(r6, r6, r5, r6)
                    goto L_0x0097
                L_0x0073:
                    com.sumsub.sns.internal.camera.photo.presentation.a r2 = r4.f31456b
                    com.sumsub.sns.internal.core.domain.g r2 = r2.f31398t
                    com.sumsub.sns.internal.core.domain.g$a r7 = new com.sumsub.sns.internal.core.domain.g$a
                    java.lang.String r10 = r10.getCode()
                    com.sumsub.sns.internal.camera.photo.presentation.a r4 = r4.f31456b
                    java.lang.String r4 = r4.f31395q
                    r7.<init>(r10, r4)
                    r0.f31459c = r11
                    r0.f31461e = r6
                    r0.f31462f = r6
                    r0.f31458b = r3
                    java.lang.Object r10 = r2.a((com.sumsub.sns.internal.core.domain.g.a) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.g.b>) r0)
                    if (r10 != r1) goto L_0x0097
                    return r1
                L_0x0097:
                    r8 = r11
                    r11 = r10
                    r10 = r8
                L_0x009a:
                    r0.f31459c = r6
                    r0.f31461e = r6
                    r0.f31462f = r6
                    r0.f31458b = r5
                    java.lang.Object r10 = r10.emit(r11, r0)
                    if (r10 != r1) goto L_0x00a9
                    return r1
                L_0x00a9:
                    kotlin.Unit r10 = kotlin.Unit.f56620a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.o.C0306a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public o(kotlinx.coroutines.flow.d dVar, a aVar) {
            this.f31453a = dVar;
            this.f31454b = aVar;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f31453a.collect(new C0306a(eVar, this.f31454b), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    public static final class p implements kotlinx.coroutines.flow.d<c> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f31463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f31464b;

        /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$p$a  reason: collision with other inner class name */
        public static final class C0308a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f31465a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f31466b;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$special$$inlined$map$2$2", f = "SNSDocumentSelectorViewModel.kt", l = {230}, m = "emit")
            /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$p$a$a  reason: collision with other inner class name */
            public static final class C0309a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f31467a;

                /* renamed from: b  reason: collision with root package name */
                public int f31468b;

                /* renamed from: c  reason: collision with root package name */
                public Object f31469c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ C0308a f31470d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0309a(C0308a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f31470d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f31467a = obj;
                    this.f31468b |= Integer.MIN_VALUE;
                    return this.f31470d.emit((Object) null, this);
                }
            }

            public C0308a(kotlinx.coroutines.flow.e eVar, a aVar) {
                this.f31465a = eVar;
                this.f31466b = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.c r13) {
                /*
                    r11 = this;
                    boolean r0 = r13 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.p.C0308a.C0309a
                    if (r0 == 0) goto L_0x0013
                    r0 = r13
                    com.sumsub.sns.internal.camera.photo.presentation.a$p$a$a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.p.C0308a.C0309a) r0
                    int r1 = r0.f31468b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f31468b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.internal.camera.photo.presentation.a$p$a$a r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$p$a$a
                    r0.<init>(r11, r13)
                L_0x0018:
                    java.lang.Object r13 = r0.f31467a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f31468b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r13)
                    goto L_0x0082
                L_0x0029:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r13)
                    throw r12
                L_0x0031:
                    kotlin.k.b(r13)
                    kotlinx.coroutines.flow.e r13 = r11.f31465a
                    com.sumsub.sns.internal.core.domain.g$b r12 = (com.sumsub.sns.internal.core.domain.g.b) r12
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.List r4 = r12.d()
                    java.util.Iterator r4 = r4.iterator()
                L_0x0045:
                    boolean r5 = r4.hasNext()
                    if (r5 == 0) goto L_0x0070
                    java.lang.Object r5 = r4.next()
                    com.sumsub.sns.internal.core.data.model.q r5 = (com.sumsub.sns.internal.core.data.model.q) r5
                    com.sumsub.sns.internal.camera.photo.presentation.a$b r6 = new com.sumsub.sns.internal.camera.photo.presentation.a$b
                    com.sumsub.sns.internal.camera.photo.presentation.a r7 = r11.f31466b
                    com.sumsub.sns.internal.core.data.source.extensions.a r7 = r7.f31396r
                    com.sumsub.sns.internal.camera.photo.presentation.a r8 = r11.f31466b
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r8 = r8.h()
                    r9 = 2
                    r10 = 0
                    java.lang.CharSequence r8 = com.sumsub.sns.internal.core.data.model.q.a(r5, r8, r10, r9, r10)
                    android.text.Spanned r7 = r7.a(r8)
                    r6.<init>(r5, r7)
                    r2.add(r6)
                    goto L_0x0045
                L_0x0070:
                    com.sumsub.sns.internal.camera.photo.presentation.a$c r4 = new com.sumsub.sns.internal.camera.photo.presentation.a$c
                    java.lang.String r12 = r12.c()
                    r4.<init>(r2, r12)
                    r0.f31468b = r3
                    java.lang.Object r12 = r13.emit(r4, r0)
                    if (r12 != r1) goto L_0x0082
                    return r1
                L_0x0082:
                    kotlin.Unit r12 = kotlin.Unit.f56620a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.p.C0308a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public p(kotlinx.coroutines.flow.d dVar, a aVar) {
            this.f31463a = dVar;
            this.f31464b = aVar;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f31463a.collect(new C0308a(eVar, this.f31464b), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    public static final class q implements kotlinx.coroutines.flow.d<List<? extends SNSCountryPicker.CountryItem>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f31471a;

        /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$q$a  reason: collision with other inner class name */
        public static final class C0310a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f31472a;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$special$$inlined$map$3$2", f = "SNSDocumentSelectorViewModel.kt", l = {224}, m = "emit")
            /* renamed from: com.sumsub.sns.internal.camera.photo.presentation.a$q$a$a  reason: collision with other inner class name */
            public static final class C0311a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f31473a;

                /* renamed from: b  reason: collision with root package name */
                public int f31474b;

                /* renamed from: c  reason: collision with root package name */
                public Object f31475c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ C0310a f31476d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0311a(C0310a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f31476d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f31473a = obj;
                    this.f31474b |= Integer.MIN_VALUE;
                    return this.f31476d.emit((Object) null, this);
                }
            }

            public C0310a(kotlinx.coroutines.flow.e eVar) {
                this.f31472a = eVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.c r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.q.C0310a.C0311a
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.sumsub.sns.internal.camera.photo.presentation.a$q$a$a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.q.C0310a.C0311a) r0
                    int r1 = r0.f31474b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f31474b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.internal.camera.photo.presentation.a$q$a$a r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$q$a$a
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.f31473a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f31474b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r9)
                    goto L_0x007f
                L_0x0029:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0031:
                    kotlin.k.b(r9)
                    kotlinx.coroutines.flow.e r9 = r7.f31472a
                    com.sumsub.sns.internal.core.domain.e r8 = (com.sumsub.sns.internal.core.domain.e) r8
                    if (r8 == 0) goto L_0x0072
                    java.util.Map r8 = r8.h()
                    if (r8 == 0) goto L_0x0072
                    java.util.ArrayList r2 = new java.util.ArrayList
                    int r4 = r8.size()
                    r2.<init>(r4)
                    java.util.Set r8 = r8.entrySet()
                    java.util.Iterator r8 = r8.iterator()
                L_0x0051:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x0076
                    java.lang.Object r4 = r8.next()
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r5 = r4.getKey()
                    java.lang.String r5 = (java.lang.String) r5
                    java.lang.Object r4 = r4.getValue()
                    java.lang.String r4 = (java.lang.String) r4
                    com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r6 = new com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem
                    r6.<init>(r5, r4)
                    r2.add(r6)
                    goto L_0x0051
                L_0x0072:
                    java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
                L_0x0076:
                    r0.f31474b = r3
                    java.lang.Object r8 = r9.emit(r2, r0)
                    if (r8 != r1) goto L_0x007f
                    return r1
                L_0x007f:
                    kotlin.Unit r8 = kotlin.Unit.f56620a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.q.C0310a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public q(kotlinx.coroutines.flow.d dVar) {
            this.f31471a = dVar;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f31471a.collect(new C0310a(eVar), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.camera.photo.presentation.SNSDocumentSelectorViewModel$viewState$1", f = "SNSDocumentSelectorViewModel.kt", l = {116, 124}, m = "invokeSuspend")
    public static final class r extends SuspendLambda implements t<com.sumsub.sns.internal.core.domain.e, Boolean, c, List<? extends SNSCountryPicker.CountryItem>, SNSCountryPicker.CountryItem, kotlin.coroutines.c<? super e>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31477a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31478b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ boolean f31479c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31480d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f31481e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f31482f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f31483g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(a aVar, kotlin.coroutines.c<? super r> cVar) {
            super(6, cVar);
            this.f31483g = aVar;
        }

        public final Object a(com.sumsub.sns.internal.core.domain.e eVar, boolean z11, c cVar, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.CountryItem countryItem, kotlin.coroutines.c<? super e> cVar2) {
            r rVar = new r(this.f31483g, cVar2);
            rVar.f31478b = eVar;
            rVar.f31479c = z11;
            rVar.f31480d = cVar;
            rVar.f31481e = list;
            rVar.f31482f = countryItem;
            return rVar.invokeSuspend(Unit.f56620a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return a((com.sumsub.sns.internal.core.domain.e) obj, ((Boolean) obj2).booleanValue(), (c) obj3, (List) obj4, (SNSCountryPicker.CountryItem) obj5, (kotlin.coroutines.c) obj6);
        }

        public final Object invokeSuspend(Object obj) {
            SNSCountryPicker.CountryItem countryItem;
            List list;
            boolean z11;
            c cVar;
            com.sumsub.sns.internal.core.domain.e eVar;
            com.sumsub.sns.internal.core.domain.e eVar2;
            c cVar2;
            List list2;
            SNSCountryPicker.CountryItem countryItem2;
            boolean z12;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31477a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                eVar2 = (com.sumsub.sns.internal.core.domain.e) this.f31478b;
                z12 = this.f31479c;
                c cVar3 = (c) this.f31480d;
                List list3 = (List) this.f31481e;
                SNSCountryPicker.CountryItem countryItem3 = (SNSCountryPicker.CountryItem) this.f31482f;
                a aVar = this.f31483g;
                this.f31478b = eVar2;
                this.f31480d = cVar3;
                this.f31481e = list3;
                this.f31482f = countryItem3;
                this.f31479c = z12;
                this.f31477a = 1;
                if (aVar.a((kotlin.coroutines.c<? super Boolean>) this) == d11) {
                    return d11;
                }
                countryItem2 = countryItem3;
                List list4 = list3;
                cVar2 = cVar3;
                list2 = list4;
            } else if (i11 == 1) {
                z12 = this.f31479c;
                countryItem2 = (SNSCountryPicker.CountryItem) this.f31482f;
                list2 = (List) this.f31481e;
                cVar2 = (c) this.f31480d;
                kotlin.k.b(obj);
                eVar2 = (com.sumsub.sns.internal.core.domain.e) this.f31478b;
            } else if (i11 == 2) {
                boolean z13 = this.f31479c;
                cVar = (c) this.f31480d;
                kotlin.k.b(obj);
                countryItem = (SNSCountryPicker.CountryItem) this.f31482f;
                list = (List) this.f31481e;
                eVar = (com.sumsub.sns.internal.core.domain.e) this.f31478b;
                z11 = z13;
                return new e(eVar, (String) null, cVar, z11, list, countryItem, (f) obj, 2, (kotlin.jvm.internal.r) null);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a aVar2 = this.f31483g;
            this.f31478b = eVar2;
            this.f31480d = cVar2;
            this.f31481e = list2;
            this.f31482f = countryItem2;
            this.f31479c = z12;
            this.f31477a = 2;
            Object b11 = aVar2.e((kotlin.coroutines.c<? super f>) this);
            if (b11 == d11) {
                return d11;
            }
            countryItem = countryItem2;
            cVar = cVar2;
            list = list2;
            z11 = z12;
            eVar = eVar2;
            obj = b11;
            return new e(eVar, (String) null, cVar, z11, list, countryItem, (f) obj, 2, (kotlin.jvm.internal.r) null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.lang.String r14, com.sumsub.sns.internal.core.data.source.extensions.a r15, com.sumsub.sns.internal.core.domain.d r16, com.sumsub.sns.internal.core.domain.g r17, com.sumsub.sns.internal.core.data.source.common.a r18, com.sumsub.sns.internal.core.data.source.dynamic.b r19) {
        /*
            r13 = this;
            r0 = r13
            r1 = r18
            r2 = r19
            r13.<init>(r1, r2)
            r2 = r14
            r0.f31395q = r2
            r2 = r15
            r0.f31396r = r2
            r2 = r16
            r0.f31397s = r2
            r2 = r17
            r0.f31398t = r2
            r0.f31399u = r1
            com.sumsub.sns.internal.camera.photo.presentation.a$h r1 = new com.sumsub.sns.internal.camera.photo.presentation.a$h
            r2 = 0
            r1.<init>(r13, r2)
            kotlinx.coroutines.flow.d r1 = kotlinx.coroutines.flow.f.F(r1)
            com.sumsub.sns.internal.camera.photo.presentation.a$i r3 = new com.sumsub.sns.internal.camera.photo.presentation.a$i
            r3.<init>(r13, r2)
            kotlinx.coroutines.flow.d r1 = kotlinx.coroutines.flow.f.P(r1, r3)
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.v0.b()
            kotlinx.coroutines.flow.d r1 = kotlinx.coroutines.flow.f.I(r1, r3)
            kotlinx.coroutines.flow.j1 r1 = r13.a(r1, r2)
            r0.f31400v = r1
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            kotlinx.coroutines.flow.b1 r3 = kotlinx.coroutines.flow.k1.a(r3)
            r0.f31401w = r3
            kotlinx.coroutines.flow.b1 r4 = kotlinx.coroutines.flow.k1.a(r2)
            r0.f31402x = r4
            com.sumsub.sns.internal.camera.photo.presentation.a$o r5 = new com.sumsub.sns.internal.camera.photo.presentation.a$o
            r5.<init>(r4, r13)
            com.sumsub.sns.internal.camera.photo.presentation.a$p r6 = new com.sumsub.sns.internal.camera.photo.presentation.a$p
            r6.<init>(r5, r13)
            com.sumsub.sns.internal.camera.photo.presentation.a$j r5 = new com.sumsub.sns.internal.camera.photo.presentation.a$j
            r5.<init>(r13, r2)
            kotlinx.coroutines.flow.d r5 = kotlinx.coroutines.flow.f.f(r6, r5)
            com.sumsub.sns.internal.camera.photo.presentation.a$k r6 = new com.sumsub.sns.internal.camera.photo.presentation.a$k
            r6.<init>(r13, r2)
            kotlinx.coroutines.flow.d r5 = kotlinx.coroutines.flow.f.P(r5, r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.v0.b()
            kotlinx.coroutines.flow.d r5 = kotlinx.coroutines.flow.f.I(r5, r6)
            com.sumsub.sns.internal.camera.photo.presentation.a$c r6 = new com.sumsub.sns.internal.camera.photo.presentation.a$c
            r7 = 3
            r6.<init>(r2, r2, r7, r2)
            kotlinx.coroutines.flow.j1 r5 = r13.a(r5, r6)
            r0.f31403y = r5
            com.sumsub.sns.internal.camera.photo.presentation.a$q r6 = new com.sumsub.sns.internal.camera.photo.presentation.a$q
            r6.<init>(r1)
            com.sumsub.sns.internal.camera.photo.presentation.a$n r7 = new com.sumsub.sns.internal.camera.photo.presentation.a$n
            r7.<init>(r13, r2)
            kotlinx.coroutines.flow.d r6 = kotlinx.coroutines.flow.f.P(r6, r7)
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            kotlinx.coroutines.flow.j1 r6 = r13.a(r6, r7)
            r0.f31404z = r6
            com.sumsub.sns.internal.camera.photo.presentation.a$r r7 = new com.sumsub.sns.internal.camera.photo.presentation.a$r
            r7.<init>(r13, r2)
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r4
            r19 = r7
            kotlinx.coroutines.flow.d r1 = kotlinx.coroutines.flow.f.m(r14, r15, r16, r17, r18, r19)
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.v0.c()
            kotlinx.coroutines.flow.d r1 = kotlinx.coroutines.flow.f.I(r1, r2)
            com.sumsub.sns.internal.camera.photo.presentation.a$e r12 = new com.sumsub.sns.internal.camera.photo.presentation.a$e
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.j1 r1 = r13.a(r1, r12)
            r0.A = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.<init>(java.lang.String, com.sumsub.sns.internal.core.data.source.extensions.a, com.sumsub.sns.internal.core.domain.d, com.sumsub.sns.internal.core.domain.g, com.sumsub.sns.internal.core.data.source.common.a, com.sumsub.sns.internal.core.data.source.dynamic.b):void");
    }

    public final CharSequence p() {
        b.c h11 = h();
        d0 d0Var = d0.f56774a;
        return w.a(h11, String.format(n0.j.a.C, Arrays.copyOf(new Object[]{this.f31395q}, 1)), String.format(n0.j.a.C, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1)));
    }

    public final CharSequence q() {
        b.c h11 = h();
        d0 d0Var = d0.f56774a;
        return w.a(h11, String.format(n0.j.a.F, Arrays.copyOf(new Object[]{this.f31395q}, 1)), String.format(n0.j.a.F, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1)));
    }

    public final CharSequence r() {
        b.c h11 = h();
        d0 d0Var = d0.f56774a;
        return w.a(h11, String.format(n0.j.a.E, Arrays.copyOf(new Object[]{this.f31395q}, 1)), String.format(n0.j.a.E, Arrays.copyOf(new Object[]{n0.j.a.f32226g}, 1)));
    }

    /* renamed from: s */
    public j1<e> j() {
        return this.A;
    }

    public final void t() {
        if (this.f31401w.getValue().booleanValue()) {
            this.f31401w.setValue(Boolean.FALSE);
        }
    }

    public final void u() {
        if (!this.f31404z.getValue().isEmpty()) {
            if (this.f31401w.getValue().booleanValue()) {
                com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "onSelectCountryClick: dialog already shown", (Throwable) null, 4, (Object) null);
            } else {
                this.f31401w.setValue(Boolean.TRUE);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.camera.photo.presentation.a.f> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.g
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.camera.photo.presentation.a$g r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.g) r0
            int r1 = r0.f31427e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31427e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.a$g r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$g
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f31425c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31427e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.f31424b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r0 = r0.f31423a
            com.sumsub.sns.internal.camera.photo.presentation.a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a) r0
            kotlin.k.b(r9)
            r2 = r1
            goto L_0x0067
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003d:
            java.lang.Object r2 = r0.f31423a
            com.sumsub.sns.internal.camera.photo.presentation.a r2 = (com.sumsub.sns.internal.camera.photo.presentation.a) r2
            kotlin.k.b(r9)
            goto L_0x0054
        L_0x0045:
            kotlin.k.b(r9)
            r0.f31423a = r8
            r0.f31427e = r4
            java.lang.Object r9 = r8.f((kotlin.coroutines.c<? super java.lang.CharSequence>) r0)
            if (r9 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r8
        L_0x0054:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.f31423a = r2
            r0.f31424b = r9
            r0.f31427e = r3
            java.lang.Object r0 = r2.g((kotlin.coroutines.c<? super java.lang.CharSequence>) r0)
            if (r0 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r7 = r2
            r2 = r9
            r9 = r0
            r0 = r7
        L_0x0067:
            r3 = r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            com.sumsub.sns.internal.core.data.source.extensions.a r9 = r0.f31396r
            java.lang.CharSequence r1 = r0.q()
            android.text.Spanned r4 = r9.a(r1)
            com.sumsub.sns.internal.core.data.source.extensions.a r9 = r0.f31396r
            java.lang.CharSequence r1 = r0.r()
            android.text.Spanned r5 = r9.a(r1)
            java.lang.CharSequence r6 = r0.p()
            com.sumsub.sns.internal.camera.photo.presentation.a$f r9 = new com.sumsub.sns.internal.camera.photo.presentation.a$f
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super java.lang.CharSequence> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.l
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.camera.photo.presentation.a$l r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.l) r0
            int r1 = r0.f31445d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31445d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.a$l r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$l
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f31443b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31445d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f31442a
            com.sumsub.sns.internal.camera.photo.presentation.a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a) r0
            kotlin.k.b(r7)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            kotlin.k.b(r7)
            r0.f31442a = r6
            r0.f31445d = r3
            java.lang.Object r7 = r6.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
            if (r7 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r6
        L_0x0044:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r0 = r0.f31395q
            r4 = 0
            r2[r4] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r2 = "sns_step_%s_selector_country_prompt"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r1[r4] = r0
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r5 = "defaults"
            r0[r4] = r5
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r1[r3] = r0
            java.lang.CharSequence r7 = com.sumsub.sns.internal.core.common.w.a(r7, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.f(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.c<? super java.lang.CharSequence> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.camera.photo.presentation.a.m
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.camera.photo.presentation.a$m r0 = (com.sumsub.sns.internal.camera.photo.presentation.a.m) r0
            int r1 = r0.f31449d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31449d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.camera.photo.presentation.a$m r0 = new com.sumsub.sns.internal.camera.photo.presentation.a$m
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f31447b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31449d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f31446a
            com.sumsub.sns.internal.camera.photo.presentation.a r0 = (com.sumsub.sns.internal.camera.photo.presentation.a) r0
            kotlin.k.b(r7)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            kotlin.k.b(r7)
            r0.f31446a = r6
            r0.f31449d = r3
            java.lang.Object r7 = r6.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
            if (r7 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r6
        L_0x0044:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r0 = r0.f31395q
            r4 = 0
            r2[r4] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r2 = "sns_step_%s_selector_iddoc_prompt"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r1[r4] = r0
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r5 = "defaults"
            r0[r4] = r5
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.lang.String r0 = java.lang.String.format(r2, r0)
            r1[r3] = r0
            java.lang.CharSequence r7 = com.sumsub.sns.internal.core.common.w.a(r7, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.camera.photo.presentation.a.g(kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(SNSCountryPicker.CountryItem countryItem) {
        if (countryItem != null && !x.b(this.f31402x.getValue(), countryItem)) {
            this.f31402x.setValue(countryItem);
            this.f31399u.a(countryItem.getCode());
            SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
            if (eventHandler != null) {
                eventHandler.onEvent(new SNSEvent.CountrySelected(countryItem.getCode(), true));
            }
        }
    }

    public final void a(com.sumsub.sns.internal.core.data.model.q qVar) {
        String c11 = this.f31403y.getValue().c();
        if (c11 != null) {
            SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
            if (eventHandler != null) {
                eventHandler.onEvent(new SNSEvent.DocumentTypeSelected(c11, qVar.b()));
            }
            a((a.j) new d(c11, qVar));
        }
    }

    public final <T> j1<T> a(kotlinx.coroutines.flow.d<? extends T> dVar, T t11) {
        return kotlinx.coroutines.flow.f.a0(dVar, m0.a(this), i1.a.b(i1.f57228a, 0, 0, 3, (Object) null), t11);
    }
}
