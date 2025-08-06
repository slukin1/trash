package com.sumsub.sns.core.presentation.support;

import android.graphics.drawable.Drawable;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class b extends com.sumsub.sns.core.presentation.base.a<C0298b> {

    /* renamed from: q  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f31183q;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final SNSSupportItem f31184a;

        /* renamed from: b  reason: collision with root package name */
        public final SNSStepState f31185b;

        /* renamed from: c  reason: collision with root package name */
        public final Drawable f31186c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f31187d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f31188e;

        public a(SNSSupportItem sNSSupportItem, SNSStepState sNSStepState, Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
            this.f31184a = sNSSupportItem;
            this.f31185b = sNSStepState;
            this.f31186c = drawable;
            this.f31187d = charSequence;
            this.f31188e = charSequence2;
        }

        public final SNSSupportItem a() {
            return this.f31184a;
        }

        public final SNSStepState b() {
            return this.f31185b;
        }

        public final Drawable c() {
            return this.f31186c;
        }

        public final CharSequence d() {
            return this.f31187d;
        }

        public final CharSequence e() {
            return this.f31188e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f31184a, aVar.f31184a) && this.f31185b == aVar.f31185b && x.b(this.f31186c, aVar.f31186c) && x.b(this.f31187d, aVar.f31187d) && x.b(this.f31188e, aVar.f31188e);
        }

        public final Drawable f() {
            return this.f31186c;
        }

        public final SNSSupportItem g() {
            return this.f31184a;
        }

        public final SNSStepState h() {
            return this.f31185b;
        }

        public int hashCode() {
            int hashCode = ((this.f31184a.hashCode() * 31) + this.f31185b.hashCode()) * 31;
            Drawable drawable = this.f31186c;
            int i11 = 0;
            int hashCode2 = (hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31;
            CharSequence charSequence = this.f31187d;
            int hashCode3 = (hashCode2 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f31188e;
            if (charSequence2 != null) {
                i11 = charSequence2.hashCode();
            }
            return hashCode3 + i11;
        }

        public final CharSequence i() {
            return this.f31188e;
        }

        public final CharSequence j() {
            return this.f31187d;
        }

        public String toString() {
            return "SupportItem(item=" + this.f31184a + ", stepState=" + this.f31185b + ", icon=" + this.f31186c + ", title=" + this.f31187d + ", subtitle=" + this.f31188e + ')';
        }

        public final a a(SNSSupportItem sNSSupportItem, SNSStepState sNSStepState, Drawable drawable, CharSequence charSequence, CharSequence charSequence2) {
            return new a(sNSSupportItem, sNSStepState, drawable, charSequence, charSequence2);
        }

        public static /* synthetic */ a a(a aVar, SNSSupportItem sNSSupportItem, SNSStepState sNSStepState, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sNSSupportItem = aVar.f31184a;
            }
            if ((i11 & 2) != 0) {
                sNSStepState = aVar.f31185b;
            }
            SNSStepState sNSStepState2 = sNSStepState;
            if ((i11 & 4) != 0) {
                drawable = aVar.f31186c;
            }
            Drawable drawable2 = drawable;
            if ((i11 & 8) != 0) {
                charSequence = aVar.f31187d;
            }
            CharSequence charSequence3 = charSequence;
            if ((i11 & 16) != 0) {
                charSequence2 = aVar.f31188e;
            }
            return aVar.a(sNSSupportItem, sNSStepState2, drawable2, charSequence3, charSequence2);
        }
    }

    /* renamed from: com.sumsub.sns.core.presentation.support.b$b  reason: collision with other inner class name */
    public static final class C0298b implements a.l {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f31189a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f31190b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f31191c;

        public C0298b() {
            this((CharSequence) null, (CharSequence) null, (List) null, 7, (r) null);
        }

        public final CharSequence a() {
            return this.f31189a;
        }

        public final CharSequence b() {
            return this.f31190b;
        }

        public final List<a> c() {
            return this.f31191c;
        }

        public final CharSequence d() {
            return this.f31190b;
        }

        public final List<a> e() {
            return this.f31191c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0298b)) {
                return false;
            }
            C0298b bVar = (C0298b) obj;
            return x.b(this.f31189a, bVar.f31189a) && x.b(this.f31190b, bVar.f31190b) && x.b(this.f31191c, bVar.f31191c);
        }

        public final CharSequence f() {
            return this.f31189a;
        }

        public int hashCode() {
            CharSequence charSequence = this.f31189a;
            int i11 = 0;
            int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
            CharSequence charSequence2 = this.f31190b;
            if (charSequence2 != null) {
                i11 = charSequence2.hashCode();
            }
            return ((hashCode + i11) * 31) + this.f31191c.hashCode();
        }

        public String toString() {
            return "ViewState(title=" + this.f31189a + ", subtitle=" + this.f31190b + ", supportItems=" + this.f31191c + ')';
        }

        public C0298b(CharSequence charSequence, CharSequence charSequence2, List<a> list) {
            this.f31189a = charSequence;
            this.f31190b = charSequence2;
            this.f31191c = list;
        }

        public final C0298b a(CharSequence charSequence, CharSequence charSequence2, List<a> list) {
            return new C0298b(charSequence, charSequence2, list);
        }

        public static /* synthetic */ C0298b a(C0298b bVar, CharSequence charSequence, CharSequence charSequence2, List<a> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = bVar.f31189a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = bVar.f31190b;
            }
            if ((i11 & 4) != 0) {
                list = bVar.f31191c;
            }
            return bVar.a(charSequence, charSequence2, list);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0298b(CharSequence charSequence, CharSequence charSequence2, List list, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.k() : list);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.support.SNSSupportViewModel", f = "SNSSupportViewModel.kt", l = {24}, m = "onPrepare")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f31192a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f31193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f31194c;

        /* renamed from: d  reason: collision with root package name */
        public int f31195d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f31194c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f31193b = obj;
            this.f31195d |= Integer.MIN_VALUE;
            return this.f31194c.d(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.support.SNSSupportViewModel$onPrepare$2", f = "SNSSupportViewModel.kt", l = {41, 42}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<C0298b, kotlin.coroutines.c<? super C0298b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31196a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31197b;

        /* renamed from: c  reason: collision with root package name */
        public int f31198c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f31199d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f31200e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f31200e = bVar;
        }

        /* renamed from: a */
        public final Object invoke(C0298b bVar, kotlin.coroutines.c<? super C0298b> cVar) {
            return ((d) create(bVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f31200e, cVar);
            dVar.f31199d = obj;
            return dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ab, code lost:
            if (r1 == null) goto L_0x00ad;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f31198c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0034
                if (r1 == r3) goto L_0x0027
                if (r1 != r2) goto L_0x001f
                java.lang.Object r0 = r14.f31197b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r14.f31196a
                com.sumsub.sns.core.presentation.support.b$b r1 = (com.sumsub.sns.core.presentation.support.b.C0298b) r1
                java.lang.Object r2 = r14.f31199d
                java.util.List r2 = (java.util.List) r2
                kotlin.k.b(r15)
                goto L_0x00de
            L_0x001f:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0027:
                java.lang.Object r1 = r14.f31196a
                com.sumsub.sns.core.presentation.support.b$b r1 = (com.sumsub.sns.core.presentation.support.b.C0298b) r1
                java.lang.Object r3 = r14.f31199d
                java.util.List r3 = (java.util.List) r3
                kotlin.k.b(r15)
                goto L_0x00c6
            L_0x0034:
                kotlin.k.b(r15)
                java.lang.Object r15 = r14.f31199d
                com.sumsub.sns.core.presentation.support.b$b r15 = (com.sumsub.sns.core.presentation.support.b.C0298b) r15
                com.sumsub.sns.internal.core.common.e0 r1 = com.sumsub.sns.internal.core.common.e0.f32018a
                java.util.List r1 = r1.getSupportItems()
                if (r1 == 0) goto L_0x00ad
                com.sumsub.sns.core.presentation.support.b r4 = r14.f31200e
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r6)
                r5.<init>(r6)
                java.util.Iterator r1 = r1.iterator()
            L_0x0054:
                boolean r6 = r1.hasNext()
                if (r6 == 0) goto L_0x00a7
                java.lang.Object r6 = r1.next()
                r8 = r6
                com.sumsub.sns.core.data.model.SNSSupportItem r8 = (com.sumsub.sns.core.data.model.SNSSupportItem) r8
                java.lang.String r6 = r8.isValid()
                if (r6 == 0) goto L_0x0070
                int r6 = r6.length()
                if (r6 != 0) goto L_0x006e
                goto L_0x0070
            L_0x006e:
                r6 = 0
                goto L_0x0071
            L_0x0070:
                r6 = r3
            L_0x0071:
                r7 = 0
                if (r6 != 0) goto L_0x0075
                goto L_0x00a3
            L_0x0075:
                com.sumsub.sns.internal.core.widget.SNSStepState r9 = com.sumsub.sns.internal.core.widget.SNSStepState.INIT
                android.graphics.drawable.Drawable r10 = r8.getIconDrawable()
                java.lang.String r6 = r8.getTitle()
                if (r6 == 0) goto L_0x008b
                com.sumsub.sns.internal.core.data.source.extensions.a r11 = r4.f31183q
                android.text.Spanned r6 = r11.a(r6)
                r11 = r6
                goto L_0x008c
            L_0x008b:
                r11 = r7
            L_0x008c:
                java.lang.String r6 = r8.getSubtitle()
                if (r6 == 0) goto L_0x009c
                com.sumsub.sns.internal.core.data.source.extensions.a r7 = r4.f31183q
                android.text.Spanned r6 = r7.a(r6)
                r12 = r6
                goto L_0x009d
            L_0x009c:
                r12 = r7
            L_0x009d:
                com.sumsub.sns.core.presentation.support.b$a r6 = new com.sumsub.sns.core.presentation.support.b$a
                r7 = r6
                r7.<init>(r8, r9, r10, r11, r12)
            L_0x00a3:
                r5.add(r7)
                goto L_0x0054
            L_0x00a7:
                java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.X(r5)
                if (r1 != 0) goto L_0x00b1
            L_0x00ad:
                java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            L_0x00b1:
                com.sumsub.sns.core.presentation.support.b r4 = r14.f31200e
                r14.f31199d = r1
                r14.f31196a = r15
                r14.f31198c = r3
                java.lang.String r3 = "sns_support_title"
                java.lang.Object r3 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r14)
                if (r3 != r0) goto L_0x00c2
                return r0
            L_0x00c2:
                r13 = r1
                r1 = r15
                r15 = r3
                r3 = r13
            L_0x00c6:
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                com.sumsub.sns.core.presentation.support.b r4 = r14.f31200e
                r14.f31199d = r3
                r14.f31196a = r1
                r14.f31197b = r15
                r14.f31198c = r2
                java.lang.String r2 = "sns_support_subtitle"
                java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r14)
                if (r2 != r0) goto L_0x00db
                return r0
            L_0x00db:
                r0 = r15
                r15 = r2
                r2 = r3
            L_0x00de:
                java.lang.CharSequence r15 = (java.lang.CharSequence) r15
                com.sumsub.sns.core.presentation.support.b$b r15 = r1.a(r0, r15, r2)
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.support.b.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public b(com.sumsub.sns.internal.core.data.source.extensions.a aVar, com.sumsub.sns.internal.core.data.source.common.a aVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar2, bVar);
        this.f31183q = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.core.presentation.support.b.c
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.core.presentation.support.b$c r0 = (com.sumsub.sns.core.presentation.support.b.c) r0
            int r1 = r0.f31195d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f31195d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.support.b$c r0 = new com.sumsub.sns.core.presentation.support.b$c
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f31193b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f31195d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f31192a
            com.sumsub.sns.core.presentation.support.b r0 = (com.sumsub.sns.core.presentation.support.b) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f31192a = r4
            r0.f31195d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.sumsub.sns.core.presentation.support.b$d r5 = new com.sumsub.sns.core.presentation.support.b$d
            r1 = 0
            r5.<init>(r0, r1)
            r2 = 0
            com.sumsub.sns.core.presentation.base.a.a(r0, r2, r5, r3, r1)
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.support.b.d(kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: p */
    public C0298b e() {
        return new C0298b((CharSequence) null, (CharSequence) null, (List) null, 7, (r) null);
    }
}
