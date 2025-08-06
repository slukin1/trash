package com.sumsub.sns.internal.core.presentation.helper;

import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.ApplicantStatus;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.ReviewAnswerType;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo;
import com.sumsub.sns.internal.core.presentation.base.adapter.c;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: com.sumsub.sns.internal.core.presentation.helper.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0378a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33842a;

        static {
            int[] iArr = new int[ApplicantStatus.values().length];
            iArr[ApplicantStatus.Reviewing.ordinal()] = 1;
            iArr[ApplicantStatus.Submitting.ordinal()] = 2;
            iArr[ApplicantStatus.Reviewed.ordinal()] = 3;
            f33842a = iArr;
        }
    }

    public static final class b extends Lambda implements l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f33843a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b.c cVar) {
            super(1);
            this.f33843a = cVar;
        }

        /* renamed from: a */
        public final CharSequence invoke(String str) {
            return q.a(q.f32683c.a(str), this.f33843a, (CharSequence) null, 2, (Object) null);
        }
    }

    public static /* synthetic */ c a(b.c cVar, Document document, ApplicantStatus applicantStatus, boolean z11, b bVar, String str, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        boolean z12 = z11;
        if ((i11 & 32) != 0) {
            str = null;
        }
        return a(cVar, document, applicantStatus, z12, bVar, str);
    }

    public static final c a(b.c cVar, Document document, ApplicantStatus applicantStatus, boolean z11, b bVar, String str) {
        SNSStepState sNSStepState;
        CharSequence charSequence;
        CharSequence a11;
        b.c cVar2 = cVar;
        Document document2 = document;
        String str2 = str;
        int i11 = C0378a.f33842a[applicantStatus.ordinal()];
        boolean z12 = true;
        if (i11 == 1) {
            sNSStepState = SNSStepState.PENDING;
        } else if (i11 != 2) {
            sNSStepState = i11 != 3 ? a(document) : (document.isSubmitted() || !z11) ? a(document) : SNSStepState.REJECTED;
        } else {
            sNSStepState = !document.isSubmitted() ? SNSStepState.INIT : SNSStepState.PENDING;
        }
        CharSequence a12 = document.getType().a(cVar2);
        if (sNSStepState == SNSStepState.PENDING) {
            charSequence = cVar2.a("sns_iddoc_status_reviewing");
        } else if (sNSStepState == SNSStepState.REJECTED && !document.isSubmitted()) {
            charSequence = cVar2.a("sns_iddoc_status_notSubmitted");
        } else if (document.isRejected()) {
            Document.b.C0329b review = document.getReview();
            if (review == null || (a11 = a(review)) == null) {
                charSequence = cVar2.a("sns_iddoc_status_declined");
                if (charSequence == null) {
                    charSequence = "Rejected";
                }
            } else {
                charSequence = a11;
            }
        } else if (document.isApproved()) {
            charSequence = cVar2.a("sns_iddoc_status_approved");
        } else if (document.isReviewing() || document.isSubmitted()) {
            charSequence = cVar2.a("sns_iddoc_status_submitted");
        } else if (document.getType().h()) {
            charSequence = a(cVar2, document2, bVar.d());
        } else {
            List<g.c.a> g11 = bVar.d().I().g();
            ArrayList<g.c.a> arrayList = new ArrayList<>();
            for (T next : g11) {
                if (x.b(((g.c.a) next).m(), document.getType())) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (g.c.a q11 : arrayList) {
                boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList2, q11.q());
            }
            String k02 = CollectionsKt___CollectionsKt.k0(arrayList2, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new b(cVar2), 30, (Object) null);
            charSequence = (!x.b(str2, n0.j.a.f32228i) || !(StringsKt__StringsJVMKt.z(k02) ^ true)) ? document.getType().a(cVar2, (String) null).toString() : StringsKt__StringsJVMKt.G(document.getType().a(cVar2, str2).toString(), "{doctypes}", k02, false, 4, (Object) null);
        }
        if (sNSStepState != SNSStepState.REJECTED) {
            z12 = false;
        }
        return new c(sNSStepState, a12, charSequence, z12, new SNSDocumentViewTypeInfo(SNSDocumentViewTypeInfo.Type.DOCUMENT, document2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r6 = r6.a(r5.getType());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.CharSequence a(com.sumsub.sns.internal.core.data.source.dynamic.b.c r4, com.sumsub.sns.internal.core.data.model.Document r5, com.sumsub.sns.internal.core.data.model.g r6) {
        /*
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x0016
            com.sumsub.sns.internal.core.data.model.DocumentType r2 = r5.getType()
            com.sumsub.sns.internal.core.data.model.g$c$a r6 = r6.a((com.sumsub.sns.internal.core.data.model.DocumentType) r2)
            if (r6 == 0) goto L_0x0016
            boolean r6 = r6.t()
            if (r6 != r1) goto L_0x0016
            r6 = r1
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            com.sumsub.sns.internal.core.data.model.DocumentType r5 = r5.getType()
            java.lang.String r5 = r5.c()
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r5
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r3 = "sns_step_%s_prompt"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            if (r6 == 0) goto L_0x0040
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r1)
            java.lang.String r6 = "sns_step_%s_geolocation_prompt"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            goto L_0x0041
        L_0x0040:
            r5 = r2
        L_0x0041:
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]
            r6[r0] = r5
            r6[r1] = r2
            r5 = 2
            java.lang.String r0 = "sns_step_defaults_prompt"
            r6[r5] = r0
            java.lang.String r4 = r4.a((java.lang.String[]) r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.helper.a.a(com.sumsub.sns.internal.core.data.source.dynamic.b$c, com.sumsub.sns.internal.core.data.model.Document, com.sumsub.sns.internal.core.data.model.g):java.lang.CharSequence");
    }

    public static final CharSequence a(Document.b.C0329b bVar) {
        String str;
        String g11 = bVar.g();
        if (g11 != null) {
            int a02 = StringsKt__StringsKt.a0(g11);
            while (true) {
                if (-1 >= a02) {
                    str = "";
                    break;
                }
                if (!(g11.charAt(a02) == 10)) {
                    str = g11.substring(0, a02 + 1);
                    break;
                }
                a02--;
            }
            if (str != null) {
                return StringsKt__StringsKt.i1(str).toString();
            }
        }
        return null;
    }

    public static final SNSStepState a(Document document) {
        if (!document.isSubmitted()) {
            return SNSStepState.INIT;
        }
        Document.b.C0329b review = document.getReview();
        ReviewAnswerType reviewAnswerType = null;
        if ((review != null ? review.e() : null) == ReviewAnswerType.Red) {
            return SNSStepState.REJECTED;
        }
        Document.b.C0329b review2 = document.getReview();
        if (review2 != null) {
            reviewAnswerType = review2.e();
        }
        if (reviewAnswerType == ReviewAnswerType.Green) {
            return SNSStepState.APPROVED;
        }
        if (document.isRejected()) {
            return SNSStepState.REJECTED;
        }
        if (document.isApproved()) {
            return SNSStepState.APPROVED;
        }
        if (document.isSubmitted()) {
            return SNSStepState.PENDING;
        }
        if (document.isReviewing()) {
            return SNSStepState.PENDING;
        }
        return SNSStepState.INIT;
    }
}
