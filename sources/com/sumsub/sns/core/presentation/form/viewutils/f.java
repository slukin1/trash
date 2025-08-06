package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class f {

    public static final class a extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.i f31070b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, FormItem.i iVar) {
            super(0);
            this.f31069a = cVar;
            this.f31070b = iVar;
        }

        public final void a() {
            c cVar = this.f31069a;
            if (cVar != null) {
                cVar.a(this.f31070b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31071a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.i f31072b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, FormItem.i iVar) {
            super(1);
            this.f31071a = cVar;
            this.f31072b = iVar;
        }

        public final void a(String str) {
            c cVar = this.f31071a;
            if (cVar != null) {
                cVar.a((FormItem) this.f31072b, str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.i iVar, Context context, c cVar) {
        SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView = new SNSApplicantDataFileFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSApplicantDataFileFieldView.setPickFileClickListener(new a(cVar, iVar));
        sNSApplicantDataFileFieldView.setDeleteFileClickListener(new b(cVar, iVar));
        String v11 = iVar.v();
        if (v11 == null) {
            v11 = "";
        }
        sNSApplicantDataFileFieldView.setPickFileLabel(v11);
        return sNSApplicantDataFileFieldView;
    }

    public static final void a(SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView, FormItem.i iVar, List<String> list) {
        int i11;
        if (sNSApplicantDataFileFieldView != null) {
            boolean z11 = true;
            if (list != null) {
                List<String> list2 = list.isEmpty() ^ true ? list : null;
                if (list2 != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list2, 10));
                    for (String str : list2) {
                        Map<String, String> w11 = iVar.w();
                        arrayList.add(new SNSApplicantDataFileFieldView.Attachment(str, str, w11 != null ? w11.get(str) : null));
                    }
                    sNSApplicantDataFileFieldView.setFiles(arrayList);
                }
            }
            if (list == null) {
                sNSApplicantDataFileFieldView.setFiles(CollectionsKt__CollectionsKt.k());
            }
            p a11 = g.a(iVar.d());
            if (a11 instanceof p.h) {
                i11 = MathKt__MathJVMKt.a(((p.h) a11).a() - ((double) sNSApplicantDataFileFieldView.getFiles().size()));
            } else {
                i11 = a11 instanceof p.d ? MathKt__MathJVMKt.a(((p.d) a11).a().c() - ((double) sNSApplicantDataFileFieldView.getFiles().size())) : Integer.MAX_VALUE;
            }
            if (i11 <= 0) {
                z11 = false;
            }
            sNSApplicantDataFileFieldView.setShowPickFile(z11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView r8, com.sumsub.sns.internal.core.presentation.form.model.FormItem.i r9) {
        /*
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView r8 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView) r8
            java.util.List r8 = r8.getFiles()
            boolean r8 = r8.isEmpty()
            r0 = 1
            r8 = r8 ^ r0
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r1 = r9.d()
            com.sumsub.sns.internal.core.data.model.p r1 = com.sumsub.sns.internal.core.presentation.form.model.g.a(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0045
            boolean r3 = r1 instanceof com.sumsub.sns.internal.core.data.model.p.d
            if (r3 == 0) goto L_0x002b
            r3 = r1
            com.sumsub.sns.internal.core.data.model.p$d r3 = (com.sumsub.sns.internal.core.data.model.p.d) r3
            com.sumsub.sns.internal.core.data.source.applicant.remote.h r3 = r3.a()
            double r3 = r3.d()
            int r3 = (int) r3
            if (r3 <= 0) goto L_0x002b
            r3 = r0
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            boolean r4 = r1 instanceof com.sumsub.sns.internal.core.data.model.p.j
            if (r4 == 0) goto L_0x003e
            com.sumsub.sns.internal.core.data.model.p$j r1 = (com.sumsub.sns.internal.core.data.model.p.j) r1
            double r4 = r1.a()
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x003e
            r1 = r0
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r3 != 0) goto L_0x0043
            if (r1 == 0) goto L_0x0045
        L_0x0043:
            r1 = r0
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            boolean r9 = r9.j()
            if (r9 != 0) goto L_0x0052
            if (r8 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.viewutils.f.a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView, com.sumsub.sns.internal.core.presentation.form.model.FormItem$i):boolean");
    }
}
