package com.sumsub.sns.internal.videoident.presentation;

import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import d10.l;
import java.util.Arrays;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f36681a = new c();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f36682a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f36683b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f36684c;

        public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f36682a = charSequence;
            this.f36683b = charSequence2;
            this.f36684c = charSequence3;
        }

        public final CharSequence a() {
            return this.f36682a;
        }

        public final CharSequence b() {
            return this.f36683b;
        }

        public final CharSequence c() {
            return this.f36684c;
        }

        public final CharSequence d() {
            return this.f36683b;
        }

        public final CharSequence e() {
            return this.f36682a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f36682a, aVar.f36682a) && x.b(this.f36683b, aVar.f36683b) && x.b(this.f36684c, aVar.f36684c);
        }

        public final CharSequence f() {
            return this.f36684c;
        }

        public int hashCode() {
            int hashCode = ((this.f36682a.hashCode() * 31) + this.f36683b.hashCode()) * 31;
            CharSequence charSequence = this.f36684c;
            return hashCode + (charSequence == null ? 0 : charSequence.hashCode());
        }

        public String toString() {
            return "State(title=" + this.f36682a + ", text=" + this.f36683b + ", uploadText=" + this.f36684c + ')';
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new a(charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = aVar.f36682a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = aVar.f36683b;
            }
            if ((i11 & 4) != 0) {
                charSequence3 = aVar.f36684c;
            }
            return aVar.a(charSequence, charSequence2, charSequence3);
        }
    }

    public static final class b extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f36685a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b.c cVar) {
            super(1);
            this.f36685a = cVar;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return this.f36685a.a(str);
        }
    }

    /* renamed from: com.sumsub.sns.internal.videoident.presentation.c$c  reason: collision with other inner class name */
    public static final class C0501c extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f36686a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0501c(b.c cVar) {
            super(1);
            this.f36686a = cVar;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return this.f36686a.a(str);
        }
    }

    public static final class d extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f36687a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b.c cVar) {
            super(1);
            this.f36687a = cVar;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return this.f36687a.a(str);
        }
    }

    public static final class e extends Lambda implements l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f36688a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b.c cVar) {
            super(1);
            this.f36688a = cVar;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return this.f36688a.a(str);
        }
    }

    public final a a(b.c cVar, String str, IdentitySide identitySide, String str2) {
        String str3;
        b.c cVar2 = cVar;
        String str4 = str;
        IdentitySide identitySide2 = identitySide;
        String str5 = str2;
        String str6 = "";
        if (new DocumentType(str4).k()) {
            d0 d0Var = d0.f56774a;
            String a11 = cVar2.a(String.format(n0.j.a.f32236q, Arrays.copyOf(new Object[]{str4, n0.j.a.f32228i, "title"}, 3)));
            String a12 = cVar2.a(String.format(n0.j.a.f32236q, Arrays.copyOf(new Object[]{str4, n0.j.a.f32228i, "text"}, 3)));
            if (a11 == null) {
                a11 = str6;
            }
            if (a12 != null) {
                str6 = a12;
            }
            return new a(a11, str6, cVar2.a("sns_videoident_action_upload"));
        }
        String a13 = cVar2.a("sns_videoident_action_pickUp");
        if (a13 == null) {
            str3 = str5 == null ? str4 : str5;
        } else if (str5 != null) {
            str3 = StringsKt__StringsJVMKt.G(a13, "{doctype}", q.a(q.f32683c.a(str5), cVar2, (CharSequence) null, 2, (Object) null).toString(), false, 4, (Object) null);
        } else {
            str3 = StringsKt__StringsJVMKt.G(a13, "{doctype}", new DocumentType(str4).a(cVar2).toString(), false, 4, (Object) null);
        }
        if (identitySide2 != null) {
            String str7 = identitySide2 == IdentitySide.Back ? n0.j.a.f32230k : n0.j.a.f32229j;
            String str8 = (String) SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.t(CollectionsKt___CollectionsKt.P(d.b(str4, n0.j.a.f32228i, str7, "title", str5)), new d(cVar2)));
            if (str8 == null) {
                str8 = str6;
            }
            String str9 = (String) SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.t(CollectionsKt___CollectionsKt.P(d.b(str4, n0.j.a.f32228i, str7, "text", str5)), new b(cVar2)));
            if (str9 != null) {
                str6 = str9;
            }
            return new a(str8, str6, str3);
        }
        String str10 = (String) SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.t(CollectionsKt___CollectionsKt.P(d.b(str4, n0.j.a.f32228i, "title")), new e(cVar2)));
        if (str10 == null) {
            str10 = str6;
        }
        String str11 = (String) SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.t(CollectionsKt___CollectionsKt.P(d.b(str4, n0.j.a.f32228i, "text")), new C0501c(cVar2)));
        if (str11 != null) {
            str6 = str11;
        }
        return new a(str10, str6, str3);
    }
}
