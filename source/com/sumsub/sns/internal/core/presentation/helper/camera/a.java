package com.sumsub.sns.internal.core.presentation.helper.camera;

import com.sumsub.sns.internal.core.analytics.GlobalStatePayload;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.helper.camera.b;
import com.sumsub.sns.internal.core.presentation.intro.f;
import d10.l;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33847a = new a();

    /* renamed from: com.sumsub.sns.internal.core.presentation.helper.camera.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0379a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33848a;

        static {
            int[] iArr = new int[IdentitySide.values().length];
            iArr[IdentitySide.Front.ordinal()] = 1;
            iArr[IdentitySide.Back.ordinal()] = 2;
            f33848a = iArr;
        }
    }

    public static final class b extends Lambda implements l<q, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f33849a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b.c cVar) {
            super(1);
            this.f33849a = cVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(q qVar) {
            return q.a(qVar, this.f33849a, (CharSequence) null, 2, (Object) null);
        }
    }

    public static final class c extends Lambda implements l<q, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f33850a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b.c cVar) {
            super(1);
            this.f33850a = cVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(q qVar) {
            return q.a(qVar, this.f33850a, (CharSequence) null, 2, (Object) null);
        }
    }

    public static /* synthetic */ b a(a aVar, b.c cVar, DocumentType documentType, g.c.a aVar2, f fVar, String str, List list, IdentitySide identitySide, int i11, Object obj) {
        return aVar.a(cVar, documentType, aVar2, fVar, str, (i11 & 32) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i11 & 64) != 0 ? null : identitySide);
    }

    public final b a(b.c cVar, DocumentType documentType, g.c.a aVar, f fVar, String str, List<? extends q> list, IdentitySide identitySide) {
        int i11;
        String str2;
        String str3;
        String value;
        String str4;
        String str5;
        b.c cVar2 = cVar;
        boolean z11 = false;
        if (documentType.k()) {
            if (aVar != null && aVar.v()) {
                z11 = true;
            }
            String str6 = z11 ? "portrait" : "photo";
            String a11 = cVar2.a("sns_step_" + documentType.c() + '_' + str6 + "_title");
            if (a11 == null) {
                str4 = "";
            } else {
                str4 = a11;
            }
            String a12 = cVar2.a("sns_step_" + documentType.c() + '_' + str6 + "_brief");
            if (a12 == null) {
                str5 = "";
            } else {
                str5 = a12;
            }
            String a13 = cVar2.a("sns_step_" + documentType.c() + '_' + str6 + "_details");
            if (a13 == null) {
                a13 = "";
            }
            return new b.a(str4, str5, a13, fVar, str);
        }
        q qVar = list.size() == 1 ? (q) CollectionsKt___CollectionsKt.a0(list) : null;
        if (!(identitySide == null || (value = identitySide.getValue()) == null)) {
            com.sumsub.sns.internal.core.analytics.b.f31873a.a(GlobalStatePayload.IdDocSubType, value);
            Unit unit = Unit.f56620a;
        }
        if (identitySide == null) {
            i11 = -1;
        } else {
            i11 = C0379a.f33848a[identitySide.ordinal()];
        }
        if (i11 == 1) {
            String a14 = cVar2.a("sns_iddoc_listing_join");
            if (a14 == null) {
                str2 = "";
            } else {
                str2 = a14;
            }
            String k02 = CollectionsKt___CollectionsKt.k0(list, str2, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new b(cVar2), 30, (Object) null);
            String a15 = cVar2.a("sns_iddoc_listing_join_details");
            if (a15 == null) {
                str3 = "";
            } else {
                str3 = a15;
            }
            String k03 = CollectionsKt___CollectionsKt.k0(list, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new c(cVar2), 30, (Object) null);
            d0 d0Var = d0.f56774a;
            Object[] objArr = new Object[5];
            objArr[0] = documentType.c();
            objArr[1] = n0.j.a.f32227h;
            objArr[2] = n0.j.a.f32229j;
            objArr[3] = "title";
            objArr[4] = qVar != null ? qVar.b() : null;
            String str7 = k03;
            String a16 = cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32229j, "title"}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32229j, "title"}, 4)));
            Object[] objArr2 = new Object[5];
            objArr2[0] = documentType.c();
            objArr2[1] = n0.j.a.f32227h;
            objArr2[2] = n0.j.a.f32229j;
            objArr2[3] = n0.j.a.f32233n;
            objArr2[4] = qVar != null ? qVar.b() : null;
            String format = String.format(StringsKt__StringsJVMKt.G(cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr2, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32229j, n0.j.a.f32233n}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32229j, n0.j.a.f32233n}, 4))), "{doctypes}", "%s", false, 4, (Object) null), Arrays.copyOf(new Object[]{k02}, 1));
            Object[] objArr3 = new Object[5];
            objArr3[0] = documentType.c();
            objArr3[1] = n0.j.a.f32227h;
            objArr3[2] = n0.j.a.f32229j;
            objArr3[3] = "details";
            objArr3[4] = qVar != null ? qVar.b() : null;
            return new b.a(a16, format, String.format(StringsKt__StringsJVMKt.G(cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr3, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32229j, "details"}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32229j, "details"}, 4))), "{doctypes}", "%s", false, 4, (Object) null), Arrays.copyOf(new Object[]{str7}, 1)), fVar, str);
        } else if (i11 != 2) {
            return b.c.f33859a;
        } else {
            d0 d0Var2 = d0.f56774a;
            Object[] objArr4 = new Object[5];
            objArr4[0] = documentType.c();
            objArr4[1] = n0.j.a.f32227h;
            objArr4[2] = n0.j.a.f32230k;
            objArr4[3] = "title";
            objArr4[4] = qVar != null ? qVar.b() : null;
            String a17 = cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr4, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32230k, "title"}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32230k, "title"}, 4)));
            Object[] objArr5 = new Object[5];
            objArr5[0] = documentType.c();
            objArr5[1] = n0.j.a.f32227h;
            objArr5[2] = n0.j.a.f32230k;
            objArr5[3] = n0.j.a.f32233n;
            objArr5[4] = qVar != null ? qVar.b() : null;
            String a18 = cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr5, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32230k, n0.j.a.f32233n}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32230k, n0.j.a.f32233n}, 4)));
            Object[] objArr6 = new Object[5];
            objArr6[0] = documentType.c();
            objArr6[1] = n0.j.a.f32227h;
            objArr6[2] = n0.j.a.f32230k;
            objArr6[3] = "details";
            objArr6[4] = qVar != null ? qVar.b() : null;
            return new b.a(a17, a18, cVar2.a(String.format(n0.j.a.f32239t, Arrays.copyOf(objArr6, 5)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{documentType.c(), n0.j.a.f32227h, n0.j.a.f32230k, "details"}, 4)), String.format(n0.j.a.f32237r, Arrays.copyOf(new Object[]{n0.j.a.f32226g, n0.j.a.f32227h, n0.j.a.f32230k, "details"}, 4))), fVar, str);
        }
    }
}
