package com.sumsub.sns.internal.domain;

import android.content.Context;
import android.provider.Settings;
import com.sumsub.sns.internal.core.analytics.SdkEvent;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.core.common.i0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.u0;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import d10.l;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class g extends com.sumsub.sns.internal.core.domain.base.b<b, a> {

    /* renamed from: b  reason: collision with root package name */
    public final Context f34096b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.settings.b f34097c;

    /* renamed from: d  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.log.a f34098d;

    /* renamed from: e  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.analythic.a f34099e;

    /* renamed from: f  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34100f;

    /* renamed from: g  reason: collision with root package name */
    public final i f34101g;

    /* renamed from: h  reason: collision with root package name */
    public final i f34102h;

    public static final class a {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.e f34103a;

        /* renamed from: b  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.g f34104b;

        /* renamed from: c  reason: collision with root package name */
        public final b.c f34105c;

        public b(com.sumsub.sns.internal.core.data.model.e eVar, com.sumsub.sns.internal.core.data.model.g gVar, b.c cVar) {
            this.f34103a = eVar;
            this.f34104b = gVar;
            this.f34105c = cVar;
        }

        public final com.sumsub.sns.internal.core.data.model.e a() {
            return this.f34103a;
        }

        public final com.sumsub.sns.internal.core.data.model.g b() {
            return this.f34104b;
        }

        public final b.c c() {
            return this.f34105c;
        }

        public final com.sumsub.sns.internal.core.data.model.g d() {
            return this.f34104b;
        }

        public final com.sumsub.sns.internal.core.data.model.e e() {
            return this.f34103a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f34103a, bVar.f34103a) && x.b(this.f34104b, bVar.f34104b) && x.b(this.f34105c, bVar.f34105c);
        }

        public final b.c f() {
            return this.f34105c;
        }

        public int hashCode() {
            return (((this.f34103a.hashCode() * 31) + this.f34104b.hashCode()) * 31) + this.f34105c.hashCode();
        }

        public String toString() {
            return "Result(config=" + this.f34103a + ", applicant=" + this.f34104b + ", strings=" + this.f34105c + ')';
        }

        public final b a(com.sumsub.sns.internal.core.data.model.e eVar, com.sumsub.sns.internal.core.data.model.g gVar, b.c cVar) {
            return new b(eVar, gVar, cVar);
        }

        public static /* synthetic */ b a(b bVar, com.sumsub.sns.internal.core.data.model.e eVar, com.sumsub.sns.internal.core.data.model.g gVar, b.c cVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                eVar = bVar.f34103a;
            }
            if ((i11 & 2) != 0) {
                gVar = bVar.f34104b;
            }
            if ((i11 & 4) != 0) {
                cVar = bVar.f34105c;
            }
            return bVar.a(eVar, gVar, cVar);
        }
    }

    public static final class c extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f34106a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar) {
            super(0);
            this.f34106a = gVar;
        }

        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(new i0(this.f34106a.f34096b).b());
        }
    }

    public static final class d extends Lambda implements d10.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f34107a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(g gVar) {
            super(0);
            this.f34107a = gVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
            if ((r0 != null ? r0.booleanValue() : false) != false) goto L_0x0025;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Boolean invoke() {
            /*
                r3 = this;
                com.sumsub.sns.internal.core.common.f r0 = new com.sumsub.sns.internal.core.common.f
                r0.<init>()
                com.sumsub.sns.internal.core.common.j0 r1 = new com.sumsub.sns.internal.core.common.j0
                com.sumsub.sns.internal.domain.g r2 = r3.f34107a
                android.content.Context r2 = r2.f34096b
                r1.<init>(r2, r0)
                boolean r1 = r1.f()
                r2 = 0
                if (r1 != 0) goto L_0x0025
                java.lang.Boolean r0 = r0.f()
                if (r0 == 0) goto L_0x0022
                boolean r0 = r0.booleanValue()
                goto L_0x0023
            L_0x0022:
                r0 = r2
            L_0x0023:
                if (r0 == 0) goto L_0x0026
            L_0x0025:
                r2 = 1
            L_0x0026:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.g.d.invoke():java.lang.Boolean");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.PrepareSDKUseCase", f = "PrepareSDKUseCase.kt", l = {77, 94, 99, 126, 140, 143, 179}, m = "run")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34108a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34109b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34110c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34111d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f34113f;

        /* renamed from: g  reason: collision with root package name */
        public int f34114g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(g gVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f34113f = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34112e = obj;
            this.f34114g |= Integer.MIN_VALUE;
            return this.f34113f.b((a) null, this);
        }
    }

    public static final class f extends Lambda implements l<DocumentType, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f34115a = new f();

        public f() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(DocumentType documentType) {
            return documentType.c();
        }
    }

    public g(Context context, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.settings.b bVar, com.sumsub.sns.internal.core.data.source.log.a aVar2, com.sumsub.sns.internal.core.data.source.analythic.a aVar3, com.sumsub.sns.internal.core.data.source.dynamic.b bVar2) {
        super(aVar);
        this.f34096b = context;
        this.f34097c = bVar;
        this.f34098d = aVar2;
        this.f34099e = aVar3;
        this.f34100f = bVar2;
        this.f34101g = LazyKt__LazyJVMKt.a(new c(this));
        this.f34102h = LazyKt__LazyJVMKt.a(new d(this));
    }

    public final boolean c() {
        return ((Boolean) this.f34102h.getValue()).booleanValue();
    }

    public final void d() {
        o.a(com.sumsub.sns.internal.core.analytics.f.a(0, 1, (Object) null).a(SdkEvent.Init).a((Map<String, ? extends Object>) MapsKt__MapsKt.m(kotlin.l.a(n0.a.C0327a.f32129h, Boolean.valueOf(Settings.System.getInt(this.f34096b.getContentResolver(), "always_finish_activities", 0) == 1)), kotlin.l.a(n0.a.C0327a.f32128g, Boolean.valueOf(b() || c())), kotlin.l.a(n0.a.C0327a.f32126e, Boolean.valueOf(u0.b())), kotlin.l.a(n0.a.C0327a.f32127f, Boolean.valueOf(u0.a())))), false, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020d, code lost:
        r10.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0211, code lost:
        r9.f34097c.d(r4.z());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x021f, code lost:
        if ((!r10.isEmpty()) == false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0221, code lost:
        r0 = r9.f34097c.a();
        r15 = r9.f34098d;
        r14 = com.sumsub.sns.internal.core.data.model.LogType.Warn;
        r12 = new java.lang.StringBuilder();
        r12.append("Unknown idDocSetType type: ");
        r5 = r12;
        r27 = r15;
        r5.append(kotlin.collections.CollectionsKt___CollectionsKt.k0(r10, (java.lang.CharSequence) null, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, com.sumsub.sns.internal.domain.g.f.f34115a, 31, (java.lang.Object) null));
        new com.sumsub.sns.internal.core.data.model.LogParams((java.lang.String) null, "", (java.lang.String) null, "PrepareSDKUseCase.kt", r0, r5.toString(), (java.lang.String) null, "", 65, (kotlin.jvm.internal.r) null);
        r2.f34108a = r9;
        r2.f34109b = r8;
        r2.f34110c = r4;
        r2.f34111d = null;
        r2.f34114g = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x029d, code lost:
        if (r27.a(r14, r31, r2) != r3) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x029f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a0, code lost:
        r0 = r9.f34100f;
        r2.f34108a = r9;
        r2.f34109b = r8;
        r2.f34110c = r4;
        r2.f34111d = null;
        r2.f34114g = 5;
        r0 = r0.d(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02b1, code lost:
        if (r0 != r3) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b3, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r4 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02bd, code lost:
        if (com.sumsub.sns.internal.core.common.e0.f32018a.getSupportItems() != null) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02bf, code lost:
        r0 = r10.a();
        r2.f34108a = r10;
        r2.f34109b = r9;
        r2.f34110c = r8;
        r2.f34111d = r4;
        r2.f34114g = 6;
        r0 = r0.a((kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02d2, code lost:
        if (r0 != r3) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02d4, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02d5, code lost:
        r0 = (java.util.Map) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02d7, code lost:
        if (r0 == null) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02d9, code lost:
        r5 = kotlin.text.StringsKt__StringsKt.K0("supportEmail", new char[]{(char) 47}, false, 0, 6, (java.lang.Object) null);
        r6 = new kotlin.jvm.internal.Ref$ObjectRef();
        r6.element = r0;
        r0 = kotlin.ranges.RangesKt___RangesKt.o(0, r5.size() - 1).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0307, code lost:
        if (r0.hasNext() == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0309, code lost:
        r12 = ((java.util.Map) r6.element).get(r5.get(((kotlin.collections.IntIterator) r0).a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x031e, code lost:
        if ((r12 instanceof java.util.Map) == false) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0320, code lost:
        r12 = (java.util.Map) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0323, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0324, code lost:
        if (r12 == null) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0326, code lost:
        r13 = new java.util.ArrayList();
        r12 = r12.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0337, code lost:
        if (r12.hasNext() == false) goto L_0x0365;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0339, code lost:
        r14 = (java.util.Map.Entry) r12.next();
        r15 = r14.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0345, code lost:
        if ((r15 instanceof java.lang.String) != false) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0347, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0348, code lost:
        r15 = (java.lang.String) r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x034a, code lost:
        if (r15 != null) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x034d, code lost:
        r11 = r14.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0353, code lost:
        if ((r11 instanceof java.lang.Object) != false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0355, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0356, code lost:
        if (r11 != null) goto L_0x035a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0358, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x035a, code lost:
        r11 = kotlin.l.a(r15, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x035e, code lost:
        if (r11 == null) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0360, code lost:
        r13.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0365, code lost:
        r11 = kotlin.collections.MapsKt__MapsKt.s(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0369, code lost:
        if (r11 != null) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x036c, code lost:
        r6.element = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0370, code lost:
        r0 = ((java.util.Map) r6.element).get(kotlin.collections.CollectionsKt___CollectionsKt.n0(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x037e, code lost:
        if ((r0 instanceof java.lang.String) != false) goto L_0x0381;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0380, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0381, code lost:
        r15 = (java.lang.String) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0385, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0386, code lost:
        r0 = com.sumsub.sns.internal.core.common.e0.f32018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0388, code lost:
        if (r15 == null) goto L_0x0393;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x038e, code lost:
        if (kotlin.text.StringsKt__StringsJVMKt.z(r15) == false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0391, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0393, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0394, code lost:
        if (r5 == false) goto L_0x03bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0396, code lost:
        r16 = new com.sumsub.sns.core.data.model.SNSSupportItem(r4.a("sns_support_URL_title"), r4.a("sns_support_URL_description"), com.sumsub.sns.core.data.model.SNSSupportItem.Type.Url, "https://support.sumsub.com/hc/", (android.graphics.drawable.Drawable) null, com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.MAIL.getImageName(), (d10.l) null, 80, (kotlin.jvm.internal.r) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03bc, code lost:
        r11 = new com.sumsub.sns.core.data.model.SNSSupportItem(r4.a("sns_support_EMAIL_title"), r4.a("sns_support_EMAIL_description"), com.sumsub.sns.core.data.model.SNSSupportItem.Type.Email, r15, (android.graphics.drawable.Drawable) null, com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.MAIL.getImageName(), (d10.l) null, 80, (kotlin.jvm.internal.r) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03de, code lost:
        r0.setSupportItems(kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03e5, code lost:
        r10.a().a((com.sumsub.sns.core.data.model.SNSSDKState) com.sumsub.sns.core.data.model.SNSSDKState.Ready.INSTANCE);
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, "PrepareSDKUseCase", "SDK got the following data: Config is " + r9 + ", Flow type is " + r9.y(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
        r17 = com.sumsub.sns.core.c.f30748a;
        r0 = new java.lang.StringBuilder();
        r0.append("SDK got the config for flow type ");
        r0.append(r9.y());
        com.sumsub.sns.core.c.b(r17, "PrepareSDKUseCase", r0.toString(), (java.lang.Throwable) null, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0449, code lost:
        throw new com.sumsub.sns.core.data.model.SNSApplicantNotFoundException((java.lang.String) null, 1, (kotlin.jvm.internal.r) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        return new com.sumsub.sns.internal.core.domain.model.a.b(new com.sumsub.sns.internal.domain.g.b(r9, r8, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r10 = r9;
        r9 = r8;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0 = (com.sumsub.sns.internal.core.data.model.e) r0;
        r9.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0109, code lost:
        if (r0.s().length() != 0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010b, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010e, code lost:
        if (r8 != false) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0114, code lost:
        if (r0.r() == null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0116, code lost:
        r9.f34097c.c(r0.s());
        r8 = r9.f34097c;
        r10 = r0.r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0125, code lost:
        if (r10 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0127, code lost:
        r10 = r10.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012c, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012d, code lost:
        r8.a(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0131, code lost:
        r9.f34097c.c(r0.s());
        r9.f34097c.a((java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013f, code lost:
        r8 = r9.f34100f;
        r10 = r0.s();
        r2.f34108a = r9;
        r2.f34109b = r4;
        r2.f34110c = r0;
        r2.f34114g = 2;
        r8 = r8.b(r10, true, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0152, code lost:
        if (r8 != r3) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0154, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0155, code lost:
        r28 = r4;
        r4 = r0;
        r0 = r8;
        r8 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015b, code lost:
        r0 = (com.sumsub.sns.internal.core.data.model.g) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0163, code lost:
        if (r4.y() != com.sumsub.sns.core.data.model.FlowType.Actions) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0165, code lost:
        r10 = r9.f34100f;
        r11 = r4.r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016b, code lost:
        if (r11 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016d, code lost:
        r11 = r11.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0172, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0173, code lost:
        r2.f34108a = r9;
        r2.f34109b = r8;
        r2.f34110c = r4;
        r2.f34111d = r0;
        r2.f34114g = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0182, code lost:
        if (r10.d(r11, true, r2) != r3) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0184, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
        r28 = r4;
        r4 = r0;
        r0 = r8;
        r8 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018b, code lost:
        r0.a(r8.s());
        r9.f34097c.c(r8.s());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a1, code lost:
        if (r8.y() == com.sumsub.sns.core.data.model.FlowType.Actions) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a3, code lost:
        r0 = r4.J().l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ab, code lost:
        if (r0 == null) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ad, code lost:
        com.sumsub.sns.internal.core.analytics.b.f31873a.a(com.sumsub.sns.internal.core.analytics.GlobalStatePayload.LevelName, r0);
        r0 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b8, code lost:
        if (r0 != null) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ba, code lost:
        com.sumsub.sns.internal.core.analytics.b.f31873a.a(com.sumsub.sns.internal.core.analytics.GlobalStatePayload.LevelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c1, code lost:
        r0 = r4.C();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        if (r0 == null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c7, code lost:
        r0 = r0.o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cb, code lost:
        if (r0 == null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01cd, code lost:
        com.sumsub.sns.internal.core.analytics.b.f31873a.a(com.sumsub.sns.internal.core.analytics.GlobalStatePayload.Country, r0);
        r0 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d8, code lost:
        if (r0 != null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01da, code lost:
        com.sumsub.sns.internal.core.analytics.b.f31873a.a(com.sumsub.sns.internal.core.analytics.GlobalStatePayload.Country);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e1, code lost:
        r0 = r4.I().g();
        r10 = new java.util.ArrayList();
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f6, code lost:
        if (r0.hasNext() == false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f8, code lost:
        r11 = ((com.sumsub.sns.internal.core.data.model.g.c.a) r0.next()).m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0207, code lost:
        if ((!r11.l()) == false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x020a, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x020b, code lost:
        if (r11 == null) goto L_0x01f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0482 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(com.sumsub.sns.internal.domain.g.a r30, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.model.a<? extends java.lang.Exception, com.sumsub.sns.internal.domain.g.b>> r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r31
            boolean r2 = r0 instanceof com.sumsub.sns.internal.domain.g.e
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.sumsub.sns.internal.domain.g$e r2 = (com.sumsub.sns.internal.domain.g.e) r2
            int r3 = r2.f34114g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f34114g = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.domain.g$e r2 = new com.sumsub.sns.internal.domain.g$e
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f34112e
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f34114g
            r6 = 1
            r7 = 0
            switch(r4) {
                case 0: goto L_0x00bb;
                case 1: goto L_0x00a6;
                case 2: goto L_0x0095;
                case 3: goto L_0x007e;
                case 4: goto L_0x0065;
                case 5: goto L_0x0051;
                case 6: goto L_0x0036;
                case 7: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0031:
            kotlin.k.b(r0)
            goto L_0x0483
        L_0x0036:
            java.lang.Object r4 = r2.f34111d
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r4 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r4
            java.lang.Object r8 = r2.f34110c
            com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8
            java.lang.Object r9 = r2.f34109b
            com.sumsub.sns.internal.core.data.model.e r9 = (com.sumsub.sns.internal.core.data.model.e) r9
            java.lang.Object r10 = r2.f34108a
            com.sumsub.sns.internal.domain.g r10 = (com.sumsub.sns.internal.domain.g) r10
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            goto L_0x02d5
        L_0x004b:
            r0 = move-exception
            goto L_0x044c
        L_0x004e:
            r0 = move-exception
            goto L_0x0471
        L_0x0051:
            java.lang.Object r4 = r2.f34110c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r8 = r2.f34109b
            com.sumsub.sns.internal.core.data.model.e r8 = (com.sumsub.sns.internal.core.data.model.e) r8
            java.lang.Object r9 = r2.f34108a
            com.sumsub.sns.internal.domain.g r9 = (com.sumsub.sns.internal.domain.g) r9
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x0060:
            r10 = r9
            r9 = r8
            r8 = r4
            goto L_0x02b4
        L_0x0065:
            java.lang.Object r4 = r2.f34110c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r8 = r2.f34109b
            com.sumsub.sns.internal.core.data.model.e r8 = (com.sumsub.sns.internal.core.data.model.e) r8
            java.lang.Object r9 = r2.f34108a
            com.sumsub.sns.internal.domain.g r9 = (com.sumsub.sns.internal.domain.g) r9
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x02a0
        L_0x0076:
            r0 = move-exception
            r10 = r9
            goto L_0x044c
        L_0x007a:
            r0 = move-exception
            r10 = r9
            goto L_0x0471
        L_0x007e:
            java.lang.Object r4 = r2.f34111d
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r8 = r2.f34110c
            com.sumsub.sns.internal.core.data.model.e r8 = (com.sumsub.sns.internal.core.data.model.e) r8
            java.lang.Object r9 = r2.f34109b
            com.sumsub.sns.internal.core.common.y r9 = (com.sumsub.sns.internal.core.common.y) r9
            java.lang.Object r10 = r2.f34108a
            com.sumsub.sns.internal.domain.g r10 = (com.sumsub.sns.internal.domain.g) r10
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0 = r9
            r9 = r10
            goto L_0x018b
        L_0x0095:
            java.lang.Object r4 = r2.f34110c
            com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
            java.lang.Object r8 = r2.f34109b
            com.sumsub.sns.internal.core.common.y r8 = (com.sumsub.sns.internal.core.common.y) r8
            java.lang.Object r9 = r2.f34108a
            com.sumsub.sns.internal.domain.g r9 = (com.sumsub.sns.internal.domain.g) r9
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x015b
        L_0x00a6:
            java.lang.Object r4 = r2.f34109b
            com.sumsub.sns.internal.core.common.y r4 = (com.sumsub.sns.internal.core.common.y) r4
            java.lang.Object r8 = r2.f34108a
            com.sumsub.sns.internal.domain.g r8 = (com.sumsub.sns.internal.domain.g) r8
            kotlin.k.b(r0)     // Catch:{ SNSApplicantNotFoundException -> 0x00b7, Exception -> 0x00b3 }
            r9 = r8
            goto L_0x00fc
        L_0x00b3:
            r0 = move-exception
            r10 = r8
            goto L_0x044c
        L_0x00b7:
            r0 = move-exception
            r10 = r8
            goto L_0x0471
        L_0x00bb:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.source.settings.b r0 = r1.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r0.e()     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.core.analytics.b r0 = com.sumsub.sns.internal.core.analytics.b.f31873a     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.core.data.source.analythic.a r4 = r1.f34099e     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r0.a((com.sumsub.sns.internal.core.data.source.analythic.a) r4)     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r0.c()     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.core.common.y r4 = new com.sumsub.sns.internal.core.common.y     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.core.data.source.log.a r9 = r1.f34098d     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            java.lang.String r10 = "<UNKNOWN>"
            android.content.Context r0 = r1.f34096b     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            java.io.File r11 = r0.getCacheDir()     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r12 = 0
            r13 = 8
            r14 = 0
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.log.LoggerType r9 = com.sumsub.sns.internal.log.LoggerType.KIBANA     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r11 = 0
            r12 = 4
            r13 = 0
            r10 = r4
            com.sumsub.sns.internal.log.a.a(r8, r9, r10, r11, r12, r13)     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r1.f34100f     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r2.f34108a = r1     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r2.f34109b = r4     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            r2.f34114g = r6     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            java.lang.Object r0 = r0.a((boolean) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>) r2)     // Catch:{ SNSApplicantNotFoundException -> 0x046f, Exception -> 0x044a }
            if (r0 != r3) goto L_0x00fb
            return r3
        L_0x00fb:
            r9 = r1
        L_0x00fc:
            com.sumsub.sns.internal.core.data.model.e r0 = (com.sumsub.sns.internal.core.data.model.e) r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r9.d()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r8 = r0.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            int r8 = r8.length()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r8 != 0) goto L_0x010d
            r8 = r6
            goto L_0x010e
        L_0x010d:
            r8 = 0
        L_0x010e:
            if (r8 != 0) goto L_0x0443
            com.sumsub.sns.internal.core.data.model.e$a r8 = r0.r()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r8 == 0) goto L_0x0131
            com.sumsub.sns.internal.core.data.source.settings.b r8 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r10 = r0.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r8.c(r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.source.settings.b r8 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.e$a r10 = r0.r()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r10 == 0) goto L_0x012c
            java.lang.String r10 = r10.c()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x012d
        L_0x012c:
            r10 = r7
        L_0x012d:
            r8.a((java.lang.String) r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x013f
        L_0x0131:
            com.sumsub.sns.internal.core.data.source.settings.b r8 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r10 = r0.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r8.c(r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.source.settings.b r8 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r8.a((java.lang.String) r7)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x013f:
            com.sumsub.sns.internal.core.data.source.dynamic.b r8 = r9.f34100f     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r10 = r0.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34108a = r9     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34109b = r4     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34110c = r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r11 = 2
            r2.f34114g = r11     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.Object r8 = r8.b(r10, r6, r2)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r8 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r28 = r4
            r4 = r0
            r0 = r8
            r8 = r28
        L_0x015b:
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.core.data.model.FlowType r10 = r4.y()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.core.data.model.FlowType r11 = com.sumsub.sns.core.data.model.FlowType.Actions     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r10 != r11) goto L_0x0185
            com.sumsub.sns.internal.core.data.source.dynamic.b r10 = r9.f34100f     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.e$a r11 = r4.r()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r11 == 0) goto L_0x0172
            java.lang.String r11 = r11.c()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x0173
        L_0x0172:
            r11 = r7
        L_0x0173:
            r2.f34108a = r9     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34109b = r8     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34110c = r4     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34111d = r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r12 = 3
            r2.f34114g = r12     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.Object r10 = r10.d(r11, r6, r2)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r10 != r3) goto L_0x0185
            return r3
        L_0x0185:
            r28 = r4
            r4 = r0
            r0 = r8
            r8 = r28
        L_0x018b:
            java.lang.String r10 = r8.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0.a((java.lang.String) r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.source.settings.b r0 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r10 = r8.s()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0.c(r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.core.data.model.FlowType r0 = r8.y()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.core.data.model.FlowType r10 = com.sumsub.sns.core.data.model.FlowType.Actions     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 == r10) goto L_0x02a0
            com.sumsub.sns.internal.core.data.model.g$d r0 = r4.J()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r0 = r0.l()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 == 0) goto L_0x01b7
            com.sumsub.sns.internal.core.analytics.b r10 = com.sumsub.sns.internal.core.analytics.b.f31873a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r11 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.LevelName     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r10.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r11, (java.lang.String) r0)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x01b8
        L_0x01b7:
            r0 = r7
        L_0x01b8:
            if (r0 != 0) goto L_0x01c1
            com.sumsub.sns.internal.core.analytics.b r0 = com.sumsub.sns.internal.core.analytics.b.f31873a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r10 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.LevelName     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x01c1:
            com.sumsub.sns.internal.core.data.model.g$a r0 = r4.C()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 == 0) goto L_0x01d7
            java.lang.String r0 = r0.o()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 == 0) goto L_0x01d7
            com.sumsub.sns.internal.core.analytics.b r10 = com.sumsub.sns.internal.core.analytics.b.f31873a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r11 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.Country     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r10.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r11, (java.lang.String) r0)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x01d8
        L_0x01d7:
            r0 = r7
        L_0x01d8:
            if (r0 != 0) goto L_0x01e1
            com.sumsub.sns.internal.core.analytics.b r0 = com.sumsub.sns.internal.core.analytics.b.f31873a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.analytics.GlobalStatePayload r10 = com.sumsub.sns.internal.core.analytics.GlobalStatePayload.Country     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0.a((com.sumsub.sns.internal.core.analytics.GlobalStatePayload) r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x01e1:
            com.sumsub.sns.internal.core.data.model.g$c r0 = r4.I()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.util.List r0 = r0.g()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r10.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x01f2:
            boolean r11 = r0.hasNext()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r11 == 0) goto L_0x0211
            java.lang.Object r11 = r0.next()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.g$c$a r11 = (com.sumsub.sns.internal.core.data.model.g.c.a) r11     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.DocumentType r11 = r11.m()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            boolean r12 = r11.l()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r12 = r12 ^ r6
            if (r12 == 0) goto L_0x020a
            goto L_0x020b
        L_0x020a:
            r11 = r7
        L_0x020b:
            if (r11 == 0) goto L_0x01f2
            r10.add(r11)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            goto L_0x01f2
        L_0x0211:
            com.sumsub.sns.internal.core.data.source.settings.b r0 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r11 = r4.z()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0.d(r11)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            boolean r0 = r10.isEmpty()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x02a0
            com.sumsub.sns.internal.core.data.source.settings.b r0 = r9.f34097c     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r0 = r0.a()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.source.log.a r15 = r9.f34098d     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.LogType r14 = com.sumsub.sns.internal.core.data.model.LogType.Warn     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            com.sumsub.sns.internal.core.data.model.LogParams r13 = new com.sumsub.sns.internal.core.data.model.LogParams     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r19 = 0
            java.lang.String r20 = ""
            r21 = 0
            java.lang.String r22 = "PrepareSDKUseCase.kt"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r12.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r11 = "Unknown idDocSetType type: "
            r12.append(r11)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r11 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r23 = 0
            com.sumsub.sns.internal.domain.g$f r24 = com.sumsub.sns.internal.domain.g.f.f34115a     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r25 = 31
            r26 = 0
            r5 = r12
            r12 = r16
            r31 = r13
            r13 = r17
            r6 = r14
            r14 = r18
            r27 = r15
            r15 = r23
            r16 = r24
            r17 = r25
            r18 = r26
            java.lang.String r10 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r5.append(r10)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.String r17 = r5.toString()     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r18 = 0
            java.lang.String r5 = ""
            r10 = 65
            r23 = 0
            r11 = r31
            r12 = r19
            r13 = r20
            r14 = r21
            r15 = r22
            r16 = r0
            r19 = r5
            r20 = r10
            r21 = r23
            r11.<init>((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (int) r20, (kotlin.jvm.internal.r) r21)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34108a = r9     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34109b = r8     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34110c = r4     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34111d = r7     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r0 = 4
            r2.f34114g = r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r5 = r31
            r0 = r27
            java.lang.Object r0 = r0.a(r6, r5, r2)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 != r3) goto L_0x02a0
            return r3
        L_0x02a0:
            com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r9.f34100f     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34108a = r9     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34109b = r8     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34110c = r4     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r2.f34111d = r7     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r5 = 5
            r2.f34114g = r5     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            java.lang.Object r0 = r0.d(r2)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            if (r0 != r3) goto L_0x0060
            return r3
        L_0x02b4:
            r4 = r0
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r4 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r4     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.List r0 = r0.getSupportItems()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r0 != 0) goto L_0x03e5
            com.sumsub.sns.internal.core.data.source.common.a r0 = r10.a()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r2.f34108a = r10     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r2.f34109b = r9     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r2.f34110c = r8     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r2.f34111d = r4     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r5 = 6
            r2.f34114g = r5     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r0 = r0.a((kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>) r2)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r0 != r3) goto L_0x02d5
            return r3
        L_0x02d5:
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r0 == 0) goto L_0x0385
            java.lang.String r11 = "supportEmail"
            r5 = 47
            r6 = 1
            char[] r12 = new char[r6]     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            char r5 = (char) r5     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r6 = 0
            r12[r6] = r5     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r5 = kotlin.text.StringsKt__StringsKt.K0(r11, r12, r13, r14, r15, r16)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r6.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r6.element = r0     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            int r0 = r5.size()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r11 = 1
            int r0 = r0 - r11
            r11 = 0
            kotlin.ranges.h r0 = kotlin.ranges.RangesKt___RangesKt.o(r11, r0)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x0303:
            boolean r12 = r0.hasNext()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r12 == 0) goto L_0x0370
            r12 = r0
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            int r12 = r12.a()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            T r13 = r6.element     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r12 = r5.get(r12)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r12 = r13.get(r12)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            boolean r13 = r12 instanceof java.util.Map     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r13 == 0) goto L_0x0323
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            goto L_0x0324
        L_0x0323:
            r12 = r7
        L_0x0324:
            if (r12 == 0) goto L_0x0385
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r13.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Set r12 = r12.entrySet()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x0333:
            boolean r14 = r12.hasNext()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r14 == 0) goto L_0x0365
            java.lang.Object r14 = r12.next()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r15 = r14.getKey()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            boolean r11 = r15 instanceof java.lang.String     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r11 != 0) goto L_0x0348
            r15 = r7
        L_0x0348:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r15 != 0) goto L_0x034d
            goto L_0x0358
        L_0x034d:
            java.lang.Object r11 = r14.getValue()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            boolean r14 = r11 instanceof java.lang.Object     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r14 != 0) goto L_0x0356
            r11 = r7
        L_0x0356:
            if (r11 != 0) goto L_0x035a
        L_0x0358:
            r11 = r7
            goto L_0x035e
        L_0x035a:
            kotlin.Pair r11 = kotlin.l.a(r15, r11)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x035e:
            if (r11 == 0) goto L_0x0363
            r13.add(r11)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x0363:
            r11 = 0
            goto L_0x0333
        L_0x0365:
            java.util.Map r11 = kotlin.collections.MapsKt__MapsKt.s(r13)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r11 != 0) goto L_0x036c
            goto L_0x0385
        L_0x036c:
            r6.element = r11     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r11 = 0
            goto L_0x0303
        L_0x0370:
            T r0 = r6.element     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            boolean r5 = r0 instanceof java.lang.String     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r5 != 0) goto L_0x0381
            r0 = r7
        L_0x0381:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r15 = r0
            goto L_0x0386
        L_0x0385:
            r15 = r7
        L_0x0386:
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r15 == 0) goto L_0x0393
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.z(r15)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            if (r5 == 0) goto L_0x0391
            goto L_0x0393
        L_0x0391:
            r5 = 0
            goto L_0x0394
        L_0x0393:
            r5 = 1
        L_0x0394:
            if (r5 == 0) goto L_0x03bc
            com.sumsub.sns.core.data.model.SNSSupportItem r5 = new com.sumsub.sns.core.data.model.SNSSupportItem     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r6 = "sns_support_URL_title"
            java.lang.String r17 = r4.a((java.lang.String) r6)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r6 = "sns_support_URL_description"
            java.lang.String r18 = r4.a((java.lang.String) r6)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.data.model.SNSSupportItem$Type r19 = com.sumsub.sns.core.data.model.SNSSupportItem.Type.Url     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r20 = "https://support.sumsub.com/hc/"
            r21 = 0
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r6 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.MAIL     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r22 = r6.getImageName()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r23 = 0
            r24 = 80
            r25 = 0
            r16 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            goto L_0x03de
        L_0x03bc:
            com.sumsub.sns.core.data.model.SNSSupportItem r5 = new com.sumsub.sns.core.data.model.SNSSupportItem     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r6 = "sns_support_EMAIL_title"
            java.lang.String r12 = r4.a((java.lang.String) r6)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r6 = "sns_support_EMAIL_description"
            java.lang.String r13 = r4.a((java.lang.String) r6)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.data.model.SNSSupportItem$Type r14 = com.sumsub.sns.core.data.model.SNSSupportItem.Type.Email     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r16 = 0
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSCommonIcons r6 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSCommonIcons.MAIL     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r17 = r6.getImageName()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r18 = 0
            r19 = 80
            r20 = 0
            r11 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x03de:
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.setSupportItems(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
        L_0x03e5:
            com.sumsub.sns.internal.core.data.source.common.a r0 = r10.a()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.data.model.SNSSDKState$Ready r5 = com.sumsub.sns.core.data.model.SNSSDKState.Ready.INSTANCE     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.a((com.sumsub.sns.core.data.model.SNSSDKState) r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r12 = "PrepareSDKUseCase"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r5 = "SDK got the following data: Config is "
            r0.append(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.append(r9)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r5 = ", Flow type is "
            r0.append(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.data.model.FlowType r5 = r9.y()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.append(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r13 = r0.toString()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r14 = 0
            r15 = 4
            r16 = 0
            com.sumsub.log.logger.a.d(r11, r12, r13, r14, r15, r16)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.c r17 = com.sumsub.sns.core.c.f30748a     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r18 = "PrepareSDKUseCase"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.<init>()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r5 = "SDK got the config for flow type "
            r0.append(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.core.data.model.FlowType r5 = r9.y()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.append(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            java.lang.String r19 = r0.toString()     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r20 = 0
            r21 = 4
            r22 = 0
            com.sumsub.sns.core.c.b(r17, r18, r19, r20, r21, r22)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.internal.core.domain.model.a$b r0 = new com.sumsub.sns.internal.core.domain.model.a$b     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            com.sumsub.sns.internal.domain.g$b r5 = new com.sumsub.sns.internal.domain.g$b     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r5.<init>(r9, r8, r4)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            r0.<init>(r5)     // Catch:{ SNSApplicantNotFoundException -> 0x004e, Exception -> 0x004b }
            goto L_0x0489
        L_0x0443:
            com.sumsub.sns.core.data.model.SNSApplicantNotFoundException r0 = new com.sumsub.sns.core.data.model.SNSApplicantNotFoundException     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            r4 = 1
            r0.<init>(r7, r4, r7)     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
            throw r0     // Catch:{ SNSApplicantNotFoundException -> 0x007a, Exception -> 0x0076 }
        L_0x044a:
            r0 = move-exception
            r10 = r1
        L_0x044c:
            boolean r2 = r0 instanceof com.sumsub.sns.core.data.model.SNSInvalidParametersException
            if (r2 == 0) goto L_0x045d
            com.sumsub.sns.core.data.model.SNSSDKState$Failed$InvalidParameters r2 = new com.sumsub.sns.core.data.model.SNSSDKState$Failed$InvalidParameters
            r3 = r0
            com.sumsub.sns.core.data.model.SNSInvalidParametersException r3 = (com.sumsub.sns.core.data.model.SNSInvalidParametersException) r3
            java.util.List r3 = r3.getMessages()
            r2.<init>(r3)
            goto L_0x0462
        L_0x045d:
            com.sumsub.sns.core.data.model.SNSSDKState$Failed$InitialLoadingFailed r2 = new com.sumsub.sns.core.data.model.SNSSDKState$Failed$InitialLoadingFailed
            r2.<init>(r0)
        L_0x0462:
            com.sumsub.sns.internal.core.data.source.common.a r3 = r10.a()
            r3.a((com.sumsub.sns.core.data.model.SNSSDKState) r2)
            com.sumsub.sns.internal.core.domain.model.a$a r2 = new com.sumsub.sns.internal.core.domain.model.a$a
            r2.<init>(r0)
            goto L_0x0488
        L_0x046f:
            r0 = move-exception
            r10 = r1
        L_0x0471:
            r2.f34108a = r7
            r2.f34109b = r7
            r2.f34110c = r7
            r2.f34111d = r7
            r4 = 7
            r2.f34114g = r4
            java.lang.Object r0 = r10.a((java.lang.Exception) r0, (kotlin.coroutines.c<? super java.lang.Exception>) r2)
            if (r0 != r3) goto L_0x0483
            return r3
        L_0x0483:
            com.sumsub.sns.internal.core.domain.model.a$a r2 = new com.sumsub.sns.internal.core.domain.model.a$a
            r2.<init>(r0)
        L_0x0488:
            r0 = r2
        L_0x0489:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.g.b(com.sumsub.sns.internal.domain.g$a, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean b() {
        return ((Boolean) this.f34101g.getValue()).booleanValue();
    }

    public g(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.j(), aVar.n(), aVar.F(), aVar.u(), aVar.c(), aVar.p());
    }
}
